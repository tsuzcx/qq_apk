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

public class apkf
  extends QIPCModule
{
  private static volatile apkf jdField_a_of_type_Apkf;
  private final HashMap<String, Class<? extends Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private apkf(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static int a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apki(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static apkf a()
  {
    if (jdField_a_of_type_Apkf == null) {}
    try
    {
      if (jdField_a_of_type_Apkf == null) {
        jdField_a_of_type_Apkf = new apkf("ArkQQAPIIPCModule");
      }
      return jdField_a_of_type_Apkf;
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
    a().a(new apkm(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apkn(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apko(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUin", aplb.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNickname", apku.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNicknameByView", apkt.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetSKey", apla.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKey", apkz.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.Login", aplh.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUserInformation", aplc.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetAudioOutputModeHandler", apks.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKeyAsync", apkv.class);
  }
  
  public static void a(long paramLong1, long paramLong2, aplk paramaplk)
  {
    a().a(new apkr(paramLong1, paramLong2, paramaplk, paramLong2));
  }
  
  public static void a(String paramString, apky paramapky)
  {
    a().a(new apkj(paramString, paramapky));
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
    a().a(new apkp(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apkq(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new apkh(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public void a(aple paramaple)
  {
    boolean bool = true;
    if (paramaple == null) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
    }
    Object localObject;
    do
    {
      return;
      localObject = a(paramaple.a());
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramaple.a());
        return;
      }
      if (b() == null) {
        break;
      }
      if ((localObject instanceof aplg))
      {
        localObject = ((aplg)localObject).a(paramaple.a());
        if (((EIPCResult)localObject).code == 0) {}
        for (bool = true;; bool = false)
        {
          paramaple.a(bool, ((EIPCResult)localObject).data);
          return;
        }
      }
    } while (!(localObject instanceof apld));
    ((apld)localObject).a(paramaple.a(), new apkk(this, paramaple));
    return;
    if ((localObject instanceof aplg))
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramaple.a(), paramaple.a());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramaple.a() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramaple.a(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    if ((localObject instanceof apld))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramaple.a(), paramaple.a(), new apkl(this, paramaple));
      return;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, invalid handler class, " + localObject.getClass().toString());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof aplg)) {
      return ((aplg)localObject).a(paramBundle);
    }
    if ((localObject instanceof apld))
    {
      ((apld)localObject).a(paramBundle, new apkg(this, paramInt));
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkf
 * JD-Core Version:    0.7.0.1
 */