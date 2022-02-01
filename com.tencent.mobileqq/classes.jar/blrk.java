import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.ipc.QQComicIPCModule.1;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class blrk
  extends QIPCModule
{
  private static blrk jdField_a_of_type_Blrk;
  blrl jdField_a_of_type_Blrl;
  
  public blrk(String paramString)
  {
    super(paramString);
  }
  
  public static blrk a()
  {
    if (jdField_a_of_type_Blrk == null) {}
    try
    {
      if (jdField_a_of_type_Blrk == null) {
        jdField_a_of_type_Blrk = new blrk("QQComicIPCModule");
      }
      return jdField_a_of_type_Blrk;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicIPCModule", 2, "action = " + paramString);
    }
    if (paramBundle == null)
    {
      QLog.d("QQComicIPCModule", 2, "QQComicIPCModule Err params = null, action = " + paramString);
      paramString = null;
      return paramString;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getIpExpressionConfig".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, " ACTION_GET_IP_EXPRESSION_CONFIGgetIpExpressionConfig");
      }
      ThreadManagerV2.excute(new QQComicIPCModule.1(this, paramInt), 64, null, false);
      label142:
      return null;
    }
    if ("isLebaItemOpen".equals(paramString))
    {
      paramInt = paramBundle.getInt("appId", -1);
      paramString = ((bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH)).a().iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        paramBundle = (BusinessInfoCheckUpdate.AppSetting)paramString.next();
      } while (paramBundle.appid.get() != paramInt);
    }
    for (boolean bool = paramBundle.setting.get();; bool = false)
    {
      for (;;)
      {
        paramString = new Bundle();
        paramString.putBoolean("isLebaItemOpen", bool);
        return EIPCResult.createResult(0, paramString);
        if ("getRedTouchInfo".equals(paramString))
        {
          paramString = (bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
          localObject = paramBundle.getStringArrayList("pathList");
          if ((paramString == null) || (localObject == null)) {
            break;
          }
          paramBundle = new ArrayList();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.a((String)((Iterator)localObject).next());
            if (localAppInfo != null) {
              paramBundle.add(bbbt.a(localAppInfo));
            }
          }
          paramString = new Bundle();
          paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
          return EIPCResult.createResult(0, paramString);
        }
        if (!"reportRedTouchClick".equals(paramString)) {
          break label455;
        }
        paramString = (bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
        paramBundle = paramBundle.getString("path");
        if ((paramString == null) || (paramBundle == null)) {
          break;
        }
        paramString.b(paramBundle);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("service_type", 2);
          ((JSONObject)localObject).put("act_id", 1002);
          paramString.c(paramString.a(paramBundle), ((JSONObject)localObject).toString());
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      break label142;
      label455:
      if ("initPluginBeforeEnter".equals(paramString))
      {
        VipComicJumpActivity.a((AppInterface)localObject, paramBundle.getBoolean("doLoadModule"));
        break label142;
      }
      if ("getComicConfig".equals(paramString))
      {
        paramString = (VasQuickUpdateManager)((QQAppInterface)localObject).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
        if ((paramInt > 0) && (paramString != null))
        {
          if (this.jdField_a_of_type_Blrl == null) {
            this.jdField_a_of_type_Blrl = new blrl(this, paramInt);
          }
          paramString.addCallBacker(this.jdField_a_of_type_Blrl);
        }
        paramString = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject, "vipComic_config_v2.json", true, null);
        if (paramString == null) {
          break label142;
        }
        paramBundle = new Bundle();
        paramBundle.putString("config_json", paramString.toString());
        paramBundle = EIPCResult.createResult(0, paramBundle);
        paramString = paramBundle;
        if (paramInt <= 0) {
          break;
        }
        callbackResult(paramInt, paramBundle);
        break label142;
      }
      if (!"getPlayerSo".equals(paramString)) {
        break label142;
      }
      blrf.a((QQAppInterface)localObject);
      break label142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrk
 * JD-Core Version:    0.7.0.1
 */