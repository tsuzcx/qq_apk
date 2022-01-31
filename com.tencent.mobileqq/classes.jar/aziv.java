import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aziv
{
  public static HashMap<String, WeakReference<Drawable>> a;
  private static boolean a;
  public static String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject2 = (Drawable)((WeakReference)jdField_a_of_type_JavaUtilHashMap.get(paramString)).get();
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    if (paramString.equals("fivea")) {
      paramContext = paramContext.getResources().getDrawable(2130841791);
    }
    for (;;)
    {
      localObject2 = paramContext;
      if (paramContext == null) {
        break;
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString, new WeakReference(paramContext));
      return paramContext;
      if (paramString.equals("palmup"))
      {
        paramContext = paramContext.getResources().getDrawable(2130841792);
      }
      else if (paramString.equals("qheart"))
      {
        paramContext = paramContext.getResources().getDrawable(2130841793);
      }
      else
      {
        paramContext = localObject1;
        if (!paramString.equals("")) {
          paramContext = new BitmapDrawable(arso.a(azgn.a() + paramString + ".png"));
        }
      }
    }
  }
  
  public static axoy a(axoy paramaxoy)
  {
    if ((!c()) || (!b())) {}
    for (int i = 1; i == 0; i = 0) {
      return paramaxoy;
    }
    axoy localaxoy = new axoy();
    localaxoy.jdField_a_of_type_Int = paramaxoy.jdField_a_of_type_Int;
    localaxoy.jdField_a_of_type_JavaLangString = paramaxoy.jdField_a_of_type_JavaLangString;
    localaxoy.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramaxoy = paramaxoy.jdField_a_of_type_JavaUtilList.iterator();
    if (i != 0) {
      while (paramaxoy.hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxoy.next();
        if (!localPtvTemplateInfo.hasGesture()) {
          localaxoy.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        }
      }
    }
    return localaxoy;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    jdField_a_of_type_Boolean = paramBoolean;
    bdne.a(BaseApplicationImpl.getApplication().getSharedPreferences("GestureRecognitionUtils", 4).edit().putBoolean("shared_gesture_recognize_result", paramBoolean));
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("GestureRecognitionUtils", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b()
  {
    boolean bool = azgg.a().a();
    if (!bool) {
      azgg.a().b();
    }
    QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check gestureResource ready " + bool);
    return bool;
  }
  
  public static boolean c()
  {
    boolean bool1;
    if ((lsa.a(8, 1400000L)) || (lsa.a(4, 2150000L)))
    {
      bool1 = true;
      QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check condition 2 +cpuNumber is" + bool1);
      lrg locallrg = lrg.a();
      if ((locallrg == null) || (locallrg.b())) {
        break label196;
      }
    }
    label196:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (Build.VERSION.SDK_INT > 17) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        boolean bool4 = azki.d();
        boolean bool5 = a();
        QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils isSupportGestureFilter faceFilterCheck: " + true + ";checkDeviceSupport:" + bool1 + ":inBlackLists:" + bool2 + ":isSDKEnable:" + bool3 + ":isNotInShortVideoBlackWhiteList:" + bool4 + ":isHardCodePhoneInBlackList" + bool5);
        if ((bool1) && (!bool2) && (bool3) && (bool4) && (!bool5))
        {
          return true;
          bool1 = false;
          break;
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziv
 * JD-Core Version:    0.7.0.1
 */