import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class bdeq
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "N1T", "ZTE A2015" };
  private static String jdField_b_of_type_JavaLangString;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = new String[0];
  private static String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoGuideUtil";
  }
  
  public static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(c))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
      localIntent.putExtra("shareto_web_mode", jdField_a_of_type_Int);
      localIntent.putExtra("edit_video_call_back", jdField_b_of_type_JavaLangString);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", c);
      localIntent.setFlags(536870912);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt)
  {
    paramAppInterface = new Intent(paramActivity, StoryTransitionActivity.class);
    paramAppInterface.putExtra("jump_action", 6);
    paramAppInterface.putExtra("web_target_type", paramInt);
    paramActivity.startActivity(paramAppInterface);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (!b(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= true");
    }
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, bodz parambodz)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startPTVActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameramode:" + paramString3 + ", beauty:" + paramString4 + ", unfoldDDStr:" + paramString6 + ", dDCategoryName:" + paramString7 + ", dDItemID:" + paramString8 + ", unfoldFilter:" + paramString10 + ", filterCategoryName:" + paramString11 + ", filterItemID:" + paramString12 + ", dealtype:" + paramString14 + ", activityType:" + paramString15 + ", activityId:" + paramString16 + ", callback:" + paramString17 + " subtitle:" + paramString13 + ", callerType:" + paramString18 + ", topicId:" + paramString19 + ", topicName:" + paramString20 + ", adTag=" + paramString21);
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if ("1".equals(paramString3))
    {
      i = 2;
      bool3 = "1".equals(paramString4);
      bool4 = "1".equals(paramString5);
      bool5 = "1".equals(paramString9);
      bool6 = "1".equals(paramString6);
      bool7 = "1".equals(paramString10);
      "1".equals(paramString13);
      if (!"1".equals(paramString14)) {
        break label400;
      }
    }
    label400:
    for (int j = 1;; j = 0)
    {
      if (parambodz != null)
      {
        parambodz.jdField_a_of_type_Boolean = "1".equals(parambodz.jdField_a_of_type_JavaLangString);
        parambodz.jdField_b_of_type_Boolean = "1".equals(parambodz.jdField_b_of_type_JavaLangString);
        parambodz.c = "1".equals(parambodz.e);
        parambodz.d = "1".equals(parambodz.f);
      }
      if (bbgg.a()) {
        break label406;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "supportMediaCodec = false");
      }
      return false;
      i = 1;
      break;
    }
    label406:
    paramAppInterface = boea.a(bool1, bool2, i, bool3, bool4, bool6, paramString7, paramString8, bool5, bool7, paramString11, paramString12, j, paramString15, paramString16, paramString17, paramString18, paramString19, paramString20, paramString21, parambodz);
    paramString1 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString1.putExtras(paramAppInterface);
    paramString1.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString1);
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool2 = bdek.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (VideoEnvironment.b(paramAppInterface)) {
        break;
      }
      bool1 = false;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVersion fasle");
    return false;
    return true;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (paramAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isAccLoginSucdess false.");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (a(paramAppInterface)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isGuideReaded false.");
        return false;
        if (bork.a(borf.b) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
      return false;
    } while (!bbgg.a());
    if (ShortVideoUtils.a()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        bool = false;
      }
    }
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    if (!ShortVideoUtils.a())
    {
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.b(paramAppInterface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isMobileSupportPTV fasle");
    }
    return bool;
  }
  
  public static boolean f(AppInterface paramAppInterface)
  {
    boolean bool = bdek.a();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "issupportFilterSo false");
    }
    return bool;
  }
  
  public static boolean g(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (Build.VERSION.SDK_INT < 21) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (e(paramAppInterface))
      {
        bool1 = bool2;
        if (f(paramAppInterface)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!bool1);
    return bczv.c();
  }
  
  public static boolean h(AppInterface paramAppInterface)
  {
    if ((e(paramAppInterface)) && (f(paramAppInterface))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (bddo.b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportDanceGame false");
        }
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeq
 * JD-Core Version:    0.7.0.1
 */