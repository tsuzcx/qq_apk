import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qqreader.QRBridgeUtil;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bfma
  extends QIPCModule
{
  private static bfma a;
  
  public bfma(String paramString)
  {
    super(paramString);
  }
  
  public static bfma a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfma("ReaderIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bfne.d("ReaderIPCModule", "action = " + paramString);
    if (paramBundle == null)
    {
      bfne.d("ReaderIPCModule", "Err params = null, action = " + paramString);
      return null;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      bfne.d("ReaderIPCModule", "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getRedTouchInfo".equals(paramString))
    {
      paramString = (auqh)((QQAppInterface)localObject).getManager(36);
      localObject = paramBundle.getStringArrayList("pathList");
      if ((paramString != null) && (localObject != null))
      {
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.a((String)((Iterator)localObject).next());
          if (localAppInfo != null) {
            paramBundle.add(auqk.a(localAppInfo));
          }
        }
        paramString = new Bundle();
        paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
        return EIPCResult.createResult(0, paramString);
      }
    }
    else if ("getSingleRedTouchInfo".equals(paramString))
    {
      paramString = (auqh)((QQAppInterface)localObject).getManager(36);
      if (paramString != null)
      {
        paramString = paramString.a(paramBundle.getString("path"));
        if (paramString != null)
        {
          paramString = auqk.a(paramString);
          paramBundle = new Bundle();
          paramBundle.putParcelable("redTouchInfo", paramString);
          if ((paramString != null) && (paramString.b() == 1)) {
            bfne.d("ReaderIPCModule", "path=" + paramString.b());
          }
          return EIPCResult.createResult(0, paramBundle);
        }
      }
    }
    else
    {
      if (!"reportRedTouchClick".equals(paramString)) {
        break label396;
      }
      paramString = (auqh)((QQAppInterface)localObject).getManager(36);
      if (paramString != null)
      {
        paramBundle = paramBundle.getString("path");
        paramString.b(paramBundle);
      }
    }
    label396:
    do
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
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      if ("download_reader_plugin".equals(paramString))
      {
        paramInt = bflp.a((QQAppInterface)localObject);
        if (4 == paramInt) {
          QRBridgeUtil.loadReaderPluginModule(((QQAppInterface)localObject).getApp());
        }
        for (;;)
        {
          bfne.d("ReaderIPCModule", "installPlugin，installState= " + paramInt);
          break;
          if ((2 != paramInt) && (3 != paramInt)) {
            bflp.a((QQAppInterface)localObject);
          }
        }
      }
    } while (!"get_skey".equals(paramString));
    paramString = new Bundle();
    paramString.putString("get_skey_value", QRBridgeUtil.getSKey((QQAppInterface)localObject));
    return EIPCResult.createResult(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfma
 * JD-Core Version:    0.7.0.1
 */