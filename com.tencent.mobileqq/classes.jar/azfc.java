import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qassistant.core.LoadManager.1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class azfc
{
  private static String jdField_a_of_type_JavaLangString = "";
  public static final List<String> a;
  public static volatile AtomicBoolean a;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static String b;
  public static volatile AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "network_tip.mp3", "quit_voice_panel_tip.mp3", "voice_not_support_tip.mp3", "voice_not_understant_tip.mp3", "wake_default_tip.mp3" }));
    jdField_b_of_type_JavaLangString = "";
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static String a()
  {
    if ("".equals(jdField_b_of_type_JavaLangString)) {
      jdField_b_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("resAnimation", "animation1");
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    return a("voice", b()) + "/" + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "/data/data/com.tencent.mobileqq/voiceAssistant/" + paramString1 + "/" + paramString2;
  }
  
  public static void a(List<String> paramList, String paramString, azfe paramazfe)
  {
    if ((paramString == null) || (paramString == "")) {
      paramString = "HelloQQWake";
    }
    for (;;)
    {
      if (!a(paramList)) {
        a("voice", b(), paramList, jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, paramString, paramazfe);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    if ((!azgv.a()) || (azgv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return false;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    if ((!a(a(), null)) || (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return false;
    }
    jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public static boolean a(azfe paramazfe)
  {
    boolean bool = a();
    if (!bool)
    {
      a("wake", azgv.a(), azgv.jdField_a_of_type_JavaUtilList, azgv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, "HelloQQWake", paramazfe);
      a(jdField_a_of_type_JavaUtilList, "HelloQQWake", paramazfe);
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, List<String> paramList, AtomicBoolean paramAtomicBoolean, String paramString3, azfe paramazfe)
  {
    String str = a(paramString1, paramString2);
    boolean bool = a(str, paramList);
    if (!bool)
    {
      azeu.a(paramString3, "loadRes hasRes no res");
      paramList = new File(str + ".zip");
      if ((!paramList.getParentFile().exists()) && (!paramList.getParentFile().mkdirs()))
      {
        azeu.a(paramString3, "DownLoadZipFile  mkdirs failure：" + paramList.getPath());
        return bool;
      }
      if (paramAtomicBoolean.compareAndSet(false, true)) {
        ThreadManagerV2.excute(new LoadManager.1(paramString3, paramList, paramString1, paramAtomicBoolean, paramazfe, "https://down.qq.com/helloqq/" + paramString2 + ".zip"), 128, null, true);
      }
    }
    for (;;)
    {
      return bool;
      azeu.a("HelloQQWake", "loadRes hasRes no res");
    }
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    if (paramList == null) {
      return true;
    }
    paramString = paramString + "/";
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!new File(paramString + str).exists())
        {
          azeu.a("HelloQQWake", "hasModel() not file :" + paramString + str);
          return false;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return true;
  }
  
  public static boolean a(List<String> paramList)
  {
    return a(a("voice", b()), paramList);
  }
  
  public static String b()
  {
    if ("".equals(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getString("resVoice", "voice1");
    }
    return jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfc
 * JD-Core Version:    0.7.0.1
 */