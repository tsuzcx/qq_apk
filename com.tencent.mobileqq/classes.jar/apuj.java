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

public class apuj
  extends QIPCModule
{
  private static volatile apuj jdField_a_of_type_Apuj;
  private final HashMap<String, Class<? extends Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private apuj(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static int a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apum(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static apuj a()
  {
    if (jdField_a_of_type_Apuj == null) {}
    try
    {
      if (jdField_a_of_type_Apuj == null) {
        jdField_a_of_type_Apuj = new apuj("ArkQQAPIIPCModule");
      }
      return jdField_a_of_type_Apuj;
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
    a().a(new apur(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apus(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aput(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUin", apvg.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNickname", apuz.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNicknameByView", apuy.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetSKey", apvf.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKey", apve.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.Login", apvn.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUserInformation", apvh.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetAudioOutputModeHandler", apux.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKeyAsync", apva.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.LaunchMiniappHandler", apvm.class);
  }
  
  public static void a(long paramLong1, long paramLong2, apvq paramapvq)
  {
    a().a(new apuw(paramLong1, paramLong2, paramapvq, paramLong2));
  }
  
  public static void a(String paramString, apvd paramapvd)
  {
    a().a(new apun(paramString, paramapvd));
  }
  
  public static boolean a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apuo(paramString, localArrayList));
    return ((Boolean)localArrayList.get(0)).booleanValue();
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
    a().a(new apuu(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apuv(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apul(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public void a(apvj paramapvj)
  {
    boolean bool = true;
    if (paramapvj == null) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
    }
    Object localObject;
    do
    {
      return;
      localObject = a(paramapvj.a());
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramapvj.a());
        return;
      }
      if (b() == null) {
        break;
      }
      if ((localObject instanceof apvl))
      {
        localObject = ((apvl)localObject).a(paramapvj.a());
        if (((EIPCResult)localObject).code == 0) {}
        for (bool = true;; bool = false)
        {
          paramapvj.a(bool, ((EIPCResult)localObject).data);
          return;
        }
      }
    } while (!(localObject instanceof apvi));
    ((apvi)localObject).a(paramapvj.a(), new apup(this, paramapvj));
    return;
    if ((localObject instanceof apvl))
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramapvj.a(), paramapvj.a());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramapvj.a() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramapvj.a(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    if ((localObject instanceof apvi))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramapvj.a(), paramapvj.a(), new apuq(this, paramapvj));
      return;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, invalid handler class, " + localObject.getClass().toString());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof apvl)) {
      return ((apvl)localObject).a(paramBundle);
    }
    if ((localObject instanceof apvi))
    {
      ((apvi)localObject).a(paramBundle, new apuk(this, paramInt));
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuj
 * JD-Core Version:    0.7.0.1
 */