import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAiDictMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictMgr.3;
import com.tencent.mobileqq.ark.ArkAiDictMgr.4;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.ark.ArkRecommendLogic.ArkWordSegmentThread;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.wordsegment.WordSegment;
import java.io.File;

public class anmj
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean;
  private java.lang.ref.WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public anmj(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new mqq.util.WeakReference(paramAppInterface);
  }
  
  public static anml a(AppInterface paramAppInterface, String paramString)
  {
    anml localanml = new anml();
    localanml.jdField_a_of_type_JavaLangString = paramString;
    ArkRecommendLogic.a().a(new ArkAiDictMgr.3(paramAppInterface, localanml, paramString));
    return localanml;
  }
  
  static String a()
  {
    return ArkAppCenter.b() + "/WordData/";
  }
  
  public static String a(String paramString)
  {
    return a() + paramString;
  }
  
  public static void a()
  {
    Object localObject = new File(a());
    if (((File)localObject).isFile()) {
      ((File)localObject).delete();
    }
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (a())
    {
      ArkAppCenter.c("ArkApp.Dict", "initWordData, already inited.");
      return;
    }
    new File(a()).mkdirs();
    if (!jdField_a_of_type_Boolean) {
      ArkRecommendLogic.a().a(new ArkAiDictMgr.1());
    }
    b(paramAppInterface);
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString));
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      ArkAppCenter.c("ArkApp.Dict", "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.a().post(new ArkAiDictMgr.4(paramAppInterface));
  }
  
  private static boolean b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    do
    {
      return true;
      paramAppInterface = aolx.b(170).a();
      if ((paramAppInterface == null) || (paramAppInterface.a() == null))
      {
        ArkAppCenter.c("ArkApp.Dict", "getWordInitState, confBean is empty");
        return true;
      }
      paramAppInterface = paramAppInterface.a().d;
      if (paramAppInterface == null) {
        break;
      }
      ArkAppCenter.c("ArkApp.Dict", String.format("getWordInitState, wordInitState=%s", new Object[] { paramAppInterface }));
    } while (!paramAppInterface.equals("false"));
    return false;
    ArkAppCenter.c("ArkApp.Dict", "getWordInitState, ark_dict_init is empty");
    return true;
  }
  
  private static void d()
  {
    try
    {
      if ((anly.b) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = UpdateArkSo.b(BaseApplicationImpl.getContext(), "WordSegment");
        ArkAppCenter.c("ArkApp.Dict", String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(jdField_a_of_type_Boolean) }));
        if (jdField_a_of_type_Boolean) {
          WordSegment.setLogCallback(new anmk());
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    ArkAppCenter.c("ArkApp.Dict", "clearDict");
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    bdne.i(localAppInterface.getApp(), localAppInterface.getCurrentAccountUin());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmj
 * JD-Core Version:    0.7.0.1
 */