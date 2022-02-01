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

public class aori
  extends QIPCModule
{
  private static volatile aori jdField_a_of_type_Aori;
  private final HashMap<String, Class<? extends Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private aori(String paramString)
  {
    super(paramString);
    a();
  }
  
  public static int a()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aorl(localArrayList));
    return ((Integer)localArrayList.get(0)).intValue();
  }
  
  public static aori a()
  {
    if (jdField_a_of_type_Aori == null) {}
    try
    {
      if (jdField_a_of_type_Aori == null) {
        jdField_a_of_type_Aori = new aori("ArkQQAPIIPCModule");
      }
      return jdField_a_of_type_Aori;
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
    a().a(new aorp(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aorq(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aorr(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUin", aose.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNickname", aorx.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetNicknameByView", aorw.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetSKey", aosd.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKey", aosc.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.Login", aosk.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetUserInformation", aosf.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetAudioOutputModeHandler", aorv.class);
    this.jdField_a_of_type_JavaUtilHashMap.put("QQ.GetPSKeyAsync", aory.class);
  }
  
  public static void a(long paramLong1, long paramLong2, aosn paramaosn)
  {
    a().a(new aoru(paramLong1, paramLong2, paramaosn, paramLong2));
  }
  
  public static void a(String paramString, aosb paramaosb)
  {
    a().a(new aorm(paramString, paramaosb));
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
    a().a(new aors(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aort(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new aork(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public void a(aosh paramaosh)
  {
    boolean bool = true;
    if (paramaosh == null) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
    }
    Object localObject;
    do
    {
      return;
      localObject = a(paramaosh.a());
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramaosh.a());
        return;
      }
      if (b() == null) {
        break;
      }
      if ((localObject instanceof aosj))
      {
        localObject = ((aosj)localObject).a(paramaosh.a());
        if (((EIPCResult)localObject).code == 0) {}
        for (bool = true;; bool = false)
        {
          paramaosh.a(bool, ((EIPCResult)localObject).data);
          return;
        }
      }
    } while (!(localObject instanceof aosg));
    ((aosg)localObject).a(paramaosh.a(), new aorn(this, paramaosh));
    return;
    if ((localObject instanceof aosj))
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramaosh.a(), paramaosh.a());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramaosh.a() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramaosh.a(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    if ((localObject instanceof aosg))
    {
      QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramaosh.a(), paramaosh.a(), new aoro(this, paramaosh));
      return;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, invalid handler class, " + localObject.getClass().toString());
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof aosj)) {
      return ((aosj)localObject).a(paramBundle);
    }
    if ((localObject instanceof aosg))
    {
      ((aosg)localObject).a(paramBundle, new aorj(this, paramInt));
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */