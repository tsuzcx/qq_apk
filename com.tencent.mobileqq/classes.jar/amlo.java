import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloResManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;

public class amlo
  extends QIPCModule
{
  private amlo(String paramString)
  {
    super(paramString);
  }
  
  public static amlo a()
  {
    return amlx.a();
  }
  
  public static void a(int paramInt, amoe paramamoe)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putInt("apolloRoleId", paramInt);
    localBundle.putLong("startTime", l);
    anis.a(132, String.valueOf(l));
    anis.a(132, String.valueOf(l), 3);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_role_dir", localBundle, new amlv(paramamoe));
  }
  
  private void a(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetDressInfo ");
    ApolloResManager localApolloResManager = (ApolloResManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_RES_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManager == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManager.a(paramQQAppInterface, paramBundle.getInt("apolloRoleId"), new amlp(this, localBundle, paramInt));
  }
  
  public static void a(String paramString, amof paramamof)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putLong("startTime", l);
    anis.a(132, null, String.valueOf(l));
    anis.a(132, String.valueOf(l), 1);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_user_res_info", localBundle, new amlt(paramamof));
  }
  
  public static void a(String paramString, anfj paramanfj)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putLong("startTime", l);
    anis.a(132, String.valueOf(l));
    anis.a(132, String.valueOf(l), 4);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_check_face_data_download", localBundle, new amlw(paramanfj));
  }
  
  public static void a(ArrayList<Integer> paramArrayList, amod paramamod)
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("apolloDressIdList", paramArrayList);
    localBundle.putLong("startTime", l);
    anis.a(132, null, String.valueOf(l));
    anis.a(132, String.valueOf(l), 2);
    QIPCClientHelper.getInstance().callServer("apollo_client_module", "action_get_dress_info", localBundle, new amlu(paramamod));
  }
  
  private void b(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetDressInfo ");
    ApolloResManager localApolloResManager = (ApolloResManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_RES_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (localApolloResManager == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    localApolloResManager.a(paramQQAppInterface, paramBundle.getIntegerArrayList("apolloDressIdList"), new amlq(this, localBundle, paramInt));
  }
  
  private void c(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleGetUserRes ");
    String str = paramBundle.getString("uin");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "uin isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle = (ApolloResManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_RES_MANAGER);
    if (paramBundle == null)
    {
      localBundle.putString("apolloErrMsg", "apolloResManager is null");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    paramBundle.a(paramQQAppInterface, str, new amlr(this, localBundle, paramInt));
  }
  
  private void d(Bundle paramBundle, int paramInt, QQAppInterface paramQQAppInterface)
  {
    QLog.d("cm_res", 1, " handleCheckFaceDataDownload ");
    String str = paramBundle.getString("url");
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramBundle.getLong("startTime"));
    if (TextUtils.isEmpty(str))
    {
      localBundle.putString("apolloErrMsg", "url isEmpty");
      callbackResult(paramInt, EIPCResult.createResult(-1, localBundle));
      return;
    }
    anex.a(paramQQAppInterface, str, new amls(this, localBundle, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("cm_res", 2, "onCall, action : " + paramString);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      QLog.i("cm_res", 2, "onRemoteInvoke cannot get QQAppInterface");
    }
    do
    {
      return null;
      localObject = (QQAppInterface)localObject;
      if ("action_get_user_res_info".equals(paramString))
      {
        c(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_get_dress_info".equals(paramString))
      {
        b(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
      if ("action_get_role_dir".equals(paramString))
      {
        a(paramBundle, paramInt, (QQAppInterface)localObject);
        return null;
      }
    } while (!"action_check_face_data_download".equals(paramString));
    d(paramBundle, paramInt, (QQAppInterface)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlo
 * JD-Core Version:    0.7.0.1
 */