import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bbje
{
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] b;
  public int a;
  public Drawable a;
  public View.OnClickListener a;
  private IllegalStateException jdField_a_of_type_JavaLangIllegalStateException;
  public String a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  static
  {
    int j = 0;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845402, 2130845403, 2130845364, 2130845365, 2130845370, 2130845371, 2130845358, 2130845359, 2130845355, 2130845356, 2130845408, 2130845409, 2130845393, 2130845394, 2130845400, 2130845401, 2130845374, 2130845375, 2130845376, 2130845377, 2130845427, 2130845428, 2130845383, 2130845384, 2130845368, 2130845369, 2130849647, 2130843057, 2130843059, 2130843062, 2130843061, 2130843594, 2130843595, 2130842131, 2130845429, 2130845430, 2130838751, 2130839046, 2130839079, 2130845378, 2130845379, 2130842132, 2130842142, 2130849657, 2130842127, 2130842133, 2130842129, 2130845404, 2130845405, 2130845761, 2130846005, 2130838756, 2130842115, 2130842584, 2130845389, 2130845390, 2130845372, 2130845373, 2130845366, 2130845367, 2130845443, 2130845444, 2130845351, 2130845414, 2130845415, 2130845418, 2130845352, 2130845353, 2130845419, 2130845420, 2130845398, 2130845399, 2130843485, 2130849418, 2130845387, 2130845388, 2130845396, 2130845397, 2130845416, 2130845417, 2130839736, 2130848640, 2130848641, 2130839643, 2130840877, 2130840878, 2130840887, 2130845392, 2130840888, 2130840889, 2130840890, 2130840891, 2130845448, 2130845428, 2130840879, 2130840880, 2130840881, 2130840882, 2130840885, 2130840886, 2130842124 };
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length)
    {
      if (localHashSet.contains(Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated icon " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(jdField_a_of_type_ArrayOfInt[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(jdField_a_of_type_ArrayOfInt[i]));
      }
    }
    Arrays.sort(jdField_a_of_type_ArrayOfInt);
    jdField_b_of_type_ArrayOfInt = new int[] { 2131719451, 2131719457, 2131719458, 2131719426, 2131719427, 2131719428, 2131719448, 2131719461, 2131719473, 2131719449, 2131719470, 2131719471, 2131719472, 2131719467, 2131719425, 2131719454, 2131719456, 2131719450, 2131719452, 2131719469, 2131719433, 2131719453, 2131719465, 2131719463, 2131719464, 2131719434, 2131719459, 2131719442, 2131719439, 2131719437, 2131719440, 2131719438, 2131719441, 2131719447, 2131719444, 2131719445, 2131719424, 2131719436, 2131719455, 2131719462, 2131719435, 2131719466, 2131719446, 2131719429, 2131719432, 2131719431, 2131719430, 2131719468, 2131719460, 2131719443, 2131697496, 2131697499, 2131697502, 2131697501, 2131696700, 2131695606 };
    localHashSet = new HashSet();
    i = j;
    if (i < jdField_b_of_type_ArrayOfInt.length)
    {
      if (localHashSet.contains(Integer.valueOf(jdField_b_of_type_ArrayOfInt[i]))) {
        QLog.e("ShareActionSheetBuilder", 1, "static initializer() called duplicated label " + i + ", " + BaseApplicationImpl.getApplication().getResources().getResourceEntryName(jdField_b_of_type_ArrayOfInt[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashSet.add(Integer.valueOf(jdField_b_of_type_ArrayOfInt[i]));
      }
    }
    Arrays.sort(jdField_b_of_type_ArrayOfInt);
  }
  
  public bbje()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(bbje.class.getName()))
    {
      this.jdField_a_of_type_JavaLangIllegalStateException = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
      QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.jdField_a_of_type_JavaLangIllegalStateException);
    }
  }
  
  private static bbje A()
  {
    if (bfwa.a()) {}
    return a(2130842132, 2131695545, "open_aio");
  }
  
  private static bbje B()
  {
    if (bfwa.a()) {}
    return a(2130842133, 2131719433, "add_friend");
  }
  
  private static bbje C()
  {
    if (bfwa.a()) {}
    return a(2130842132, 2131719453, "open_aio");
  }
  
  private static bbje D()
  {
    int i = 2130845378;
    if (bfwa.a()) {
      i = 2130845379;
    }
    return a(i, 2131719473, "weiyun");
  }
  
  private static bbje E()
  {
    int i = 2130845362;
    if (bfwa.a()) {
      i = 2130845363;
    }
    return a(i, 2131719466, "sent_pc");
  }
  
  private static bbje F()
  {
    int i = 2130845429;
    if (bfwa.a()) {
      i = 2130845430;
    }
    return a(i, 2131719424, "QRcode");
  }
  
  private static bbje G()
  {
    if (bfwa.a()) {}
    return a(2130842131, 2131719429, "Screenshot_share");
  }
  
  private static bbje H()
  {
    if (bfwa.a()) {}
    return a(2130843595, 2131719458, "qiyeqq");
  }
  
  private static bbje I()
  {
    if (bfwa.a()) {}
    return a(2130843594, 2131719457, "qidian");
  }
  
  private static bbje J()
  {
    int i = 2130840887;
    if (bfwa.a()) {
      i = 2130845392;
    }
    return a(i, 2131719431, "add_desktop");
  }
  
  private static bbje K()
  {
    int i = 2130845368;
    if (bfwa.a()) {
      i = 2130845369;
    }
    return a(i, 2131719449, "kandian");
  }
  
  private static bbje L()
  {
    int i = 2130845383;
    if (bfwa.a()) {
      i = 2130845384;
    }
    return a(i, 2131719472, "weibo");
  }
  
  private static bbje M()
  {
    int i = 2130845427;
    if (bfwa.a()) {
      i = 2130845428;
    }
    return a(i, 2131719460, "report");
  }
  
  private static bbje N()
  {
    int i = 2130845376;
    if (bfwa.a()) {
      i = 2130845377;
    }
    return a(i, 2131719471, "wechat_");
  }
  
  private static bbje O()
  {
    int i = 2130845374;
    if (bfwa.a()) {
      i = 2130845375;
    }
    return a(i, 2131719470, "wechat");
  }
  
  private static bbje P()
  {
    int i = 2130845393;
    if (bfwa.a()) {
      i = 2130845394;
    }
    return a(i, 2131719435, "adjust_font");
  }
  
  private static bbje Q()
  {
    int i = 2130845408;
    if (bfwa.a()) {
      i = 2130845409;
    }
    return a(i, 2131719443, "collect");
  }
  
  private static bbje R()
  {
    int i = 2130845355;
    if (bfwa.a()) {
      i = 2130845356;
    }
    return a(i, 2131719425, "Qbrowser");
  }
  
  private static bbje S()
  {
    int i = 2130845358;
    if (bfwa.a()) {
      i = 2130845359;
    }
    return a(i, 2131719467, "browser");
  }
  
  private static bbje T()
  {
    int i = 2130845370;
    if (bfwa.a()) {
      i = 2130845371;
    }
    return a(i, 2131719427, "Qzone");
  }
  
  private static bbje U()
  {
    int i = 2130845364;
    if (bfwa.a()) {
      i = 2130845365;
    }
    return a(i, 2131719426, "Qfriend");
  }
  
  private static bbje V()
  {
    int i = 2130845402;
    if (bfwa.a()) {
      i = 2130845403;
    }
    return a(i, 2131719446, "copy_link");
  }
  
  private static bbje a()
  {
    int i = 2130845400;
    if (bfwa.a()) {
      i = 2130845401;
    }
    return a(i, 2131696720, "check_profile");
  }
  
  public static bbje a(int paramInt)
  {
    bbje localbbje1;
    switch (paramInt)
    {
    case 22: 
    case 24: 
    case 25: 
    case 28: 
    case 29: 
    case 32: 
    case 33: 
    case 36: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 46: 
    case 47: 
    case 49: 
    case 53: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 67: 
    case 69: 
    default: 
      localbbje1 = new bbje();
      QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
    }
    for (;;)
    {
      bbje localbbje2 = localbbje1;
      if (localbbje1 == null)
      {
        localbbje2 = new bbje();
        QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
      }
      localbbje2.jdField_c_of_type_Int = paramInt;
      return localbbje2;
      localbbje1 = V();
      continue;
      localbbje1 = U();
      continue;
      localbbje1 = T();
      continue;
      localbbje1 = S();
      continue;
      localbbje1 = R();
      continue;
      localbbje1 = Q();
      continue;
      localbbje1 = P();
      continue;
      localbbje1 = a();
      continue;
      localbbje1 = O();
      continue;
      localbbje1 = N();
      continue;
      localbbje1 = M();
      continue;
      localbbje1 = L();
      continue;
      localbbje1 = K();
      continue;
      localbbje1 = J();
      continue;
      localbbje1 = I();
      continue;
      localbbje1 = H();
      continue;
      localbbje1 = G();
      continue;
      localbbje1 = F();
      continue;
      localbbje1 = E();
      continue;
      localbbje1 = D();
      continue;
      localbbje1 = C();
      continue;
      localbbje1 = B();
      continue;
      localbbje1 = A();
      continue;
      localbbje1 = z();
      continue;
      localbbje1 = y();
      continue;
      localbbje1 = x();
      continue;
      localbbje1 = w();
      continue;
      localbbje1 = v();
      continue;
      localbbje1 = u();
      continue;
      localbbje1 = t();
      continue;
      localbbje1 = s();
      continue;
      localbbje1 = r();
      continue;
      localbbje1 = q();
      continue;
      localbbje1 = p();
      continue;
      localbbje1 = o();
      continue;
      localbbje1 = n();
      continue;
      localbbje1 = M();
      continue;
      localbbje1 = m();
      continue;
      localbbje1 = l();
      continue;
      localbbje1 = k();
      continue;
      localbbje1 = a(2130839736, 2131719426, "");
      continue;
      localbbje1 = a(2130848640, 2131719451, "");
      continue;
      localbbje1 = j();
      continue;
      localbbje1 = i();
      continue;
      localbbje1 = h();
      continue;
      localbbje1 = g();
      continue;
      localbbje1 = f();
      continue;
      localbbje1 = e();
      continue;
      localbbje1 = d();
      continue;
      localbbje1 = c();
      continue;
      localbbje1 = b();
      continue;
      localbbje1 = a(2130843057, 2131697496, "add_troop_app");
      continue;
      localbbje1 = a(2130843059, 2131697499, "open_app_detail");
      continue;
      localbbje1 = a(2130843062, 2131697502, "share_troop_app");
      continue;
      localbbje1 = a(2130843061, 2131697501, "refresh_troop_app_view");
      continue;
      localbbje1 = a(2130842127, 2131696700, "share_diandian");
      continue;
      localbbje1 = a(2130842124, 2131695606, "share_more");
    }
  }
  
  private static bbje a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramInt1, paramInt2, paramString, BaseApplicationImpl.getApplication().getResources());
  }
  
  private static bbje a(int paramInt1, int paramInt2, String paramString, Resources paramResources)
  {
    bbje localbbje = new bbje();
    localbbje.jdField_b_of_type_Int = paramInt1;
    localbbje.jdField_a_of_type_JavaLangString = paramResources.getString(paramInt2);
    localbbje.jdField_d_of_type_JavaLangString = paramString;
    return localbbje;
  }
  
  private static bbje b()
  {
    int i = 2130845396;
    if (bfwa.a()) {
      i = 2130845397;
    }
    return a(i, 2131719445, "colornote_cancel");
  }
  
  private static bbje c()
  {
    int i = 2130840879;
    if (bfwa.a()) {
      i = 2130840880;
    }
    return a(i, 2131719442, "backtohome");
  }
  
  private static bbje d()
  {
    int i = 2130840890;
    if (bfwa.a()) {
      i = 2130840891;
    }
    return a(i, 2131719459, "remove_my");
  }
  
  private static bbje e()
  {
    int i = 2130840888;
    if (bfwa.a()) {
      i = 2130840889;
    }
    return a(i, 2131719434, "add_my");
  }
  
  private static bbje f()
  {
    int i = 2130840877;
    if (bfwa.a()) {
      i = 2130840878;
    }
    return a(i, 2131719430, "about");
  }
  
  private static bbje g()
  {
    int i = 2130840881;
    if (bfwa.a()) {
      i = 2130840882;
    }
    return a(i, 2131719438, "applet_closeperformance");
  }
  
  private static bbje h()
  {
    int i = 2130840881;
    if (bfwa.a()) {
      i = 2130840882;
    }
    return a(i, 2131719440, "applet_openperformance");
  }
  
  private static bbje i()
  {
    int i = 2130840881;
    if (bfwa.a()) {
      i = 2130840882;
    }
    return a(i, 2131719437, "applet_closedebug");
  }
  
  private static bbje j()
  {
    int i = 2130840881;
    if (bfwa.a()) {
      i = 2130840882;
    }
    return a(i, 2131719439, "applet_opendebug");
  }
  
  private static bbje k()
  {
    int i = 2130845416;
    if (bfwa.a()) {
      i = 2130845417;
    }
    return a(i, 2131719450, "long_screenshot");
  }
  
  private static bbje l()
  {
    int i = 2130845387;
    if (bfwa.a()) {
      i = 2130845388;
    }
    return a(i, 2131719444, "colornote");
  }
  
  private static bbje m()
  {
    if (bfwa.a()) {}
    return a(2130849418, 2131719469, "url_to_txdoc");
  }
  
  private static bbje n()
  {
    int i = 2130845398;
    if (bfwa.a()) {
      i = 2130845399;
    }
    return a(i, 2131719465, "search_emotion");
  }
  
  private static bbje o()
  {
    int i = 2130845419;
    if (bfwa.a()) {
      i = 2130845420;
    }
    return a(i, 2131719454, "other_app");
  }
  
  private static bbje p()
  {
    if (bfwa.a()) {}
    return a(2130845418, 2131719463, "scan_appletcode");
  }
  
  private static bbje q()
  {
    int i = 2130845429;
    if (bfwa.a()) {
      i = 2130845430;
    }
    return a(i, 2131719464, "scan_qrcode");
  }
  
  private static bbje r()
  {
    int i = 2130845414;
    if (bfwa.a()) {
      i = 2130845415;
    }
    return a(i, 2131719436, "aio_position");
  }
  
  private static bbje s()
  {
    int i = 2130845443;
    if (bfwa.a()) {
      i = 2130845444;
    }
    return a(i, 2131719455, "pick_words");
  }
  
  private static bbje t()
  {
    int i = 2130845366;
    if (bfwa.a()) {
      i = 2130845367;
    }
    return a(i, 2131719448, "group_album");
  }
  
  private static bbje u()
  {
    int i = 2130845372;
    if (bfwa.a()) {
      i = 2130845373;
    }
    return a(i, 2131719428, "Qzone_album");
  }
  
  private static bbje v()
  {
    int i = 2130845389;
    if (bfwa.a()) {
      i = 2130845390;
    }
    return a(i, 2131719432, "add_emotion");
  }
  
  private static bbje w()
  {
    int i = 2130840885;
    if (bfwa.a()) {
      i = 2130840886;
    }
    return a(i, 2131719456, "push_setup");
  }
  
  private static bbje x()
  {
    int i = 2130842115;
    if (bfwa.a()) {
      i = 2130845446;
    }
    return a(i, 2131719468, "uninterested");
  }
  
  private static bbje y()
  {
    int i = 2130845404;
    if (bfwa.a()) {
      i = 2130845405;
    }
    return a(i, 2131719462, "save");
  }
  
  private static bbje z()
  {
    if (bfwa.a()) {}
    return a(2130842129, 2131719452, "not_care");
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Boolean)
    {
      if (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_Int) < 0) {
        break label28;
      }
      bool1 = true;
    }
    label28:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, this.jdField_a_of_type_JavaLangString + " is in invalid icon " + this);
    return false;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_b_of_type_ArrayOfInt.length)
      {
        if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, localResources.getString(jdField_b_of_type_ArrayOfInt[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaLangIllegalStateException == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbje
 * JD-Core Version:    0.7.0.1
 */