import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class apxv
  extends QIPCModule
{
  private static volatile apxv jdField_a_of_type_Apxv;
  private final HashMap<String, Class<? extends Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private apxv(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static int a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apxy(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static apxv a()
  {
    if (jdField_a_of_type_Apxv == null) {}
    try
    {
      if (jdField_a_of_type_Apxv == null) {
        jdField_a_of_type_Apxv = new apxv("ArkQQAPIIPCModule");
      }
      return jdField_a_of_type_Apxv;
    }
    finally {}
  }
  
  private Object a(String paramString)
  {
    Class localClass = (Class)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localClass == null)
    {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "createHandler fail, action=" + paramString);
      return null;
    }
    try
    {
      paramString = localClass.newInstance();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apyc(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apyd(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apye(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUin", apyr.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNickname", apyk.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNicknameByView", apyj.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetSKey", apyq.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKey", apyp.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.Login", apyx.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUserInformation", apys.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetAudioOutputModeHandler", apyi.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKeyAsync", apyl.class);
  }
  
  public static void a(long paramLong1, long paramLong2, apza paramapza)
  {
    a().a(new apyh(paramLong1, paramLong2, paramapza, paramLong2));
  }
  
  public static void a(String paramString, apyo paramapyo)
  {
    a().a(new apxz(paramString, paramapyo));
  }
  
  private static QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String b()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apyf(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apyg(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apxx(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public void a(apyu paramapyu)
  {
    boolean bool = true;
    if (paramapyu == null) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
    }
    Object localObject;
    do
    {
      return;
      localObject = a(paramapyu.a());
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramapyu.a());
        return;
      }
      if (b() == null) {
        break;
      }
      if ((localObject instanceof apyw))
      {
        localObject = ((apyw)localObject).a(paramapyu.a());
        if (((EIPCResult)localObject).code == 0) {}
        for (bool = true;; bool = false)
        {
          paramapyu.a(bool, ((EIPCResult)localObject).data);
          return;
        }
      }
    } while (!(localObject instanceof apyt));
    ((apyt)localObject).a(paramapyu.a(), new apya(this, paramapyu));
    return;
    if ((localObject instanceof apyw))
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramapyu.a(), paramapyu.a());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramapyu.a() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramapyu.a(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    if ((localObject instanceof apyt))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramapyu.a(), paramapyu.a(), new apyb(this, paramapyu));
      return;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, invalid handler class, " + localObject.getClass().toString());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof apyw)) {
      return ((apyw)localObject).a(paramBundle);
    }
    if ((localObject instanceof apyt))
    {
      ((apyt)localObject).a(paramBundle, new apxw(this, paramInt));
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxv
 * JD-Core Version:    0.7.0.1
 */