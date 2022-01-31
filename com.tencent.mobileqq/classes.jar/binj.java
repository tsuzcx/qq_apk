import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class binj
  extends QIPCModule
{
  private static binj jdField_a_of_type_Binj;
  bink jdField_a_of_type_Bink;
  
  public binj(String paramString)
  {
    super(paramString);
  }
  
  public static binj a()
  {
    if (jdField_a_of_type_Binj == null) {}
    try
    {
      if (jdField_a_of_type_Binj == null) {
        jdField_a_of_type_Binj = new binj("QQComicIPCModule");
      }
      return jdField_a_of_type_Binj;
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
    if ("isLebaItemOpen".equals(paramString))
    {
      paramInt = paramBundle.getInt("appId", -1);
      paramString = ((axlx)((QQAppInterface)localObject).getManager(36)).a().iterator();
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
      paramString = new Bundle();
      paramString.putBoolean("isLebaItemOpen", bool);
      return EIPCResult.createResult(0, paramString);
      if ("getRedTouchInfo".equals(paramString))
      {
        paramString = (axlx)((QQAppInterface)localObject).getManager(36);
        localObject = paramBundle.getStringArrayList("pathList");
        if ((paramString != null) && (localObject != null))
        {
          paramBundle = new ArrayList();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.a((String)((Iterator)localObject).next());
            if (localAppInfo != null) {
              paramBundle.add(axmc.a(localAppInfo));
            }
          }
          paramString = new Bundle();
          paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
          return EIPCResult.createResult(0, paramString);
        }
      }
      else
      {
        if (!"reportRedTouchClick".equals(paramString)) {
          break label410;
        }
        paramString = (axlx)((QQAppInterface)localObject).getManager(36);
        paramBundle = paramBundle.getString("path");
        if ((paramString != null) && (paramBundle != null)) {
          paramString.b(paramBundle);
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("service_type", 2);
          ((JSONObject)localObject).put("act_id", 1002);
          paramString.c(paramString.a(paramBundle), ((JSONObject)localObject).toString());
          return null;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          continue;
        }
        label410:
        if ("initPluginBeforeEnter".equals(paramString))
        {
          VipComicJumpActivity.a((AppInterface)localObject, paramBundle.getBoolean("doLoadModule"));
        }
        else
        {
          if ("getComicConfig".equals(paramString))
          {
            paramString = (VasQuickUpdateManager)((QQAppInterface)localObject).getManager(184);
            if ((paramInt > 0) && (paramString != null))
            {
              if (this.jdField_a_of_type_Bink == null) {
                this.jdField_a_of_type_Bink = new bink(this, paramInt);
              }
              paramString.addCallBacker(this.jdField_a_of_type_Bink);
            }
            paramString = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject, "vipComic_config_v2.json", true, null);
            if (paramString == null) {
              continue;
            }
            paramBundle = new Bundle();
            paramBundle.putString("config_json", paramString.toString());
            paramBundle = EIPCResult.createResult(0, paramBundle);
            paramString = paramBundle;
            if (paramInt <= 0) {
              break;
            }
            callbackResult(paramInt, paramBundle);
            continue;
          }
          if ("getPlayerSo".equals(paramString)) {
            bine.a((QQAppInterface)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     binj
 * JD-Core Version:    0.7.0.1
 */