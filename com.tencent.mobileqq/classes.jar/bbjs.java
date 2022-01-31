import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bbjs
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845408, 2130845409, 2130845370, 2130845371, 2130845376, 2130845377, 2130845364, 2130845365, 2130845361, 2130845362, 2130845414, 2130845415, 2130845399, 2130845400, 2130845406, 2130845407, 2130845380, 2130845381, 2130845382, 2130845383, 2130845433, 2130845434, 2130845389, 2130845390, 2130845374, 2130845375, 2130849656, 2130843058, 2130843060, 2130843063, 2130843062, 2130843595, 2130843596, 2130842132, 2130845435, 2130845436, 2130838751, 2130839046, 2130839079, 2130845384, 2130845385, 2130842133, 2130842143, 2130849666, 2130842128, 2130842134, 2130842130, 2130845410, 2130845411, 2130845767, 2130846011, 2130838756, 2130842116, 2130842585, 2130845395, 2130845396, 2130845378, 2130845379, 2130845372, 2130845373, 2130845449, 2130845450, 2130845357, 2130845420, 2130845421, 2130845424, 2130845358, 2130845359, 2130845425, 2130845426, 2130845404, 2130845405, 2130843486, 2130849427, 2130845393, 2130845394, 2130845402, 2130845403, 2130845422, 2130845423, 2130839736, 2130848646, 2130848647, 2130839643, 2130840874, 2130840875, 2130840884, 2130845398, 2130840885, 2130840886, 2130840887, 2130840888, 2130845454, 2130845434, 2130840876, 2130840877, 2130840878, 2130840879, 2130840882, 2130840883, 2130842125 };
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
    jdField_b_of_type_ArrayOfInt = new int[] { 2131719462, 2131719468, 2131719469, 2131719437, 2131719438, 2131719439, 2131719459, 2131719472, 2131719484, 2131719460, 2131719481, 2131719482, 2131719483, 2131719478, 2131719436, 2131719465, 2131719467, 2131719461, 2131719463, 2131719480, 2131719444, 2131719464, 2131719476, 2131719474, 2131719475, 2131719445, 2131719470, 2131719453, 2131719450, 2131719448, 2131719451, 2131719449, 2131719452, 2131719458, 2131719455, 2131719456, 2131719435, 2131719447, 2131719466, 2131719473, 2131719446, 2131719477, 2131719457, 2131719440, 2131719443, 2131719442, 2131719441, 2131719479, 2131719471, 2131719454, 2131697497, 2131697500, 2131697503, 2131697502, 2131696701, 2131695607 };
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
  
  public bbjs()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    if (!new java.lang.Throwable().getStackTrace()[1].getClassName().equals(bbjs.class.getName()))
    {
      this.jdField_a_of_type_JavaLangIllegalStateException = new IllegalStateException("Must use method com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem.build(int) to create me !");
      QLog.e("ShareActionSheetBuilder", 1, "ActionSheetItem: ", this.jdField_a_of_type_JavaLangIllegalStateException);
    }
  }
  
  private static bbjs A()
  {
    if (bfwr.a()) {}
    return a(2130842133, 2131695546, "open_aio");
  }
  
  private static bbjs B()
  {
    if (bfwr.a()) {}
    return a(2130842134, 2131719444, "add_friend");
  }
  
  private static bbjs C()
  {
    if (bfwr.a()) {}
    return a(2130842133, 2131719464, "open_aio");
  }
  
  private static bbjs D()
  {
    int i = 2130845384;
    if (bfwr.a()) {
      i = 2130845385;
    }
    return a(i, 2131719484, "weiyun");
  }
  
  private static bbjs E()
  {
    int i = 2130845368;
    if (bfwr.a()) {
      i = 2130845369;
    }
    return a(i, 2131719477, "sent_pc");
  }
  
  private static bbjs F()
  {
    int i = 2130845435;
    if (bfwr.a()) {
      i = 2130845436;
    }
    return a(i, 2131719435, "QRcode");
  }
  
  private static bbjs G()
  {
    if (bfwr.a()) {}
    return a(2130842132, 2131719440, "Screenshot_share");
  }
  
  private static bbjs H()
  {
    if (bfwr.a()) {}
    return a(2130843596, 2131719469, "qiyeqq");
  }
  
  private static bbjs I()
  {
    if (bfwr.a()) {}
    return a(2130843595, 2131719468, "qidian");
  }
  
  private static bbjs J()
  {
    int i = 2130840884;
    if (bfwr.a()) {
      i = 2130845398;
    }
    return a(i, 2131719442, "add_desktop");
  }
  
  private static bbjs K()
  {
    int i = 2130845374;
    if (bfwr.a()) {
      i = 2130845375;
    }
    return a(i, 2131719460, "kandian");
  }
  
  private static bbjs L()
  {
    int i = 2130845389;
    if (bfwr.a()) {
      i = 2130845390;
    }
    return a(i, 2131719483, "weibo");
  }
  
  private static bbjs M()
  {
    int i = 2130845433;
    if (bfwr.a()) {
      i = 2130845434;
    }
    return a(i, 2131719471, "report");
  }
  
  private static bbjs N()
  {
    int i = 2130845382;
    if (bfwr.a()) {
      i = 2130845383;
    }
    return a(i, 2131719482, "wechat_");
  }
  
  private static bbjs O()
  {
    int i = 2130845380;
    if (bfwr.a()) {
      i = 2130845381;
    }
    return a(i, 2131719481, "wechat");
  }
  
  private static bbjs P()
  {
    int i = 2130845399;
    if (bfwr.a()) {
      i = 2130845400;
    }
    return a(i, 2131719446, "adjust_font");
  }
  
  private static bbjs Q()
  {
    int i = 2130845414;
    if (bfwr.a()) {
      i = 2130845415;
    }
    return a(i, 2131719454, "collect");
  }
  
  private static bbjs R()
  {
    int i = 2130845361;
    if (bfwr.a()) {
      i = 2130845362;
    }
    return a(i, 2131719436, "Qbrowser");
  }
  
  private static bbjs S()
  {
    int i = 2130845364;
    if (bfwr.a()) {
      i = 2130845365;
    }
    return a(i, 2131719478, "browser");
  }
  
  private static bbjs T()
  {
    int i = 2130845376;
    if (bfwr.a()) {
      i = 2130845377;
    }
    return a(i, 2131719438, "Qzone");
  }
  
  private static bbjs U()
  {
    int i = 2130845370;
    if (bfwr.a()) {
      i = 2130845371;
    }
    return a(i, 2131719437, "Qfriend");
  }
  
  private static bbjs V()
  {
    int i = 2130845408;
    if (bfwr.a()) {
      i = 2130845409;
    }
    return a(i, 2131719457, "copy_link");
  }
  
  private static bbjs a()
  {
    int i = 2130845406;
    if (bfwr.a()) {
      i = 2130845407;
    }
    return a(i, 2131696721, "check_profile");
  }
  
  public static bbjs a(int paramInt)
  {
    bbjs localbbjs1;
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
      localbbjs1 = new bbjs();
      QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
    }
    for (;;)
    {
      bbjs localbbjs2 = localbbjs1;
      if (localbbjs1 == null)
      {
        localbbjs2 = new bbjs();
        QLog.e("ShareActionSheetBuilder", 1, "build: notSupportAction = [" + paramInt + "]", new IllegalArgumentException());
      }
      localbbjs2.jdField_c_of_type_Int = paramInt;
      return localbbjs2;
      localbbjs1 = V();
      continue;
      localbbjs1 = U();
      continue;
      localbbjs1 = T();
      continue;
      localbbjs1 = S();
      continue;
      localbbjs1 = R();
      continue;
      localbbjs1 = Q();
      continue;
      localbbjs1 = P();
      continue;
      localbbjs1 = a();
      continue;
      localbbjs1 = O();
      continue;
      localbbjs1 = N();
      continue;
      localbbjs1 = M();
      continue;
      localbbjs1 = L();
      continue;
      localbbjs1 = K();
      continue;
      localbbjs1 = J();
      continue;
      localbbjs1 = I();
      continue;
      localbbjs1 = H();
      continue;
      localbbjs1 = G();
      continue;
      localbbjs1 = F();
      continue;
      localbbjs1 = E();
      continue;
      localbbjs1 = D();
      continue;
      localbbjs1 = C();
      continue;
      localbbjs1 = B();
      continue;
      localbbjs1 = A();
      continue;
      localbbjs1 = z();
      continue;
      localbbjs1 = y();
      continue;
      localbbjs1 = x();
      continue;
      localbbjs1 = w();
      continue;
      localbbjs1 = v();
      continue;
      localbbjs1 = u();
      continue;
      localbbjs1 = t();
      continue;
      localbbjs1 = s();
      continue;
      localbbjs1 = r();
      continue;
      localbbjs1 = q();
      continue;
      localbbjs1 = p();
      continue;
      localbbjs1 = o();
      continue;
      localbbjs1 = n();
      continue;
      localbbjs1 = M();
      continue;
      localbbjs1 = m();
      continue;
      localbbjs1 = l();
      continue;
      localbbjs1 = k();
      continue;
      localbbjs1 = a(2130839736, 2131719437, "");
      continue;
      localbbjs1 = a(2130848646, 2131719462, "");
      continue;
      localbbjs1 = j();
      continue;
      localbbjs1 = i();
      continue;
      localbbjs1 = h();
      continue;
      localbbjs1 = g();
      continue;
      localbbjs1 = f();
      continue;
      localbbjs1 = e();
      continue;
      localbbjs1 = d();
      continue;
      localbbjs1 = c();
      continue;
      localbbjs1 = b();
      continue;
      localbbjs1 = a(2130843058, 2131697497, "add_troop_app");
      continue;
      localbbjs1 = a(2130843060, 2131697500, "open_app_detail");
      continue;
      localbbjs1 = a(2130843063, 2131697503, "share_troop_app");
      continue;
      localbbjs1 = a(2130843062, 2131697502, "refresh_troop_app_view");
      continue;
      localbbjs1 = a(2130842128, 2131696701, "share_diandian");
      continue;
      localbbjs1 = a(2130842125, 2131695607, "share_more");
    }
  }
  
  private static bbjs a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramInt1, paramInt2, paramString, BaseApplicationImpl.getApplication().getResources());
  }
  
  private static bbjs a(int paramInt1, int paramInt2, String paramString, Resources paramResources)
  {
    bbjs localbbjs = new bbjs();
    localbbjs.jdField_b_of_type_Int = paramInt1;
    localbbjs.jdField_a_of_type_JavaLangString = paramResources.getString(paramInt2);
    localbbjs.jdField_d_of_type_JavaLangString = paramString;
    return localbbjs;
  }
  
  private static bbjs b()
  {
    int i = 2130845402;
    if (bfwr.a()) {
      i = 2130845403;
    }
    return a(i, 2131719456, "colornote_cancel");
  }
  
  private static bbjs c()
  {
    int i = 2130840876;
    if (bfwr.a()) {
      i = 2130840877;
    }
    return a(i, 2131719453, "backtohome");
  }
  
  private static bbjs d()
  {
    int i = 2130840887;
    if (bfwr.a()) {
      i = 2130840888;
    }
    return a(i, 2131719470, "remove_my");
  }
  
  private static bbjs e()
  {
    int i = 2130840885;
    if (bfwr.a()) {
      i = 2130840886;
    }
    return a(i, 2131719445, "add_my");
  }
  
  private static bbjs f()
  {
    int i = 2130840874;
    if (bfwr.a()) {
      i = 2130840875;
    }
    return a(i, 2131719441, "about");
  }
  
  private static bbjs g()
  {
    int i = 2130840878;
    if (bfwr.a()) {
      i = 2130840879;
    }
    return a(i, 2131719449, "applet_closeperformance");
  }
  
  private static bbjs h()
  {
    int i = 2130840878;
    if (bfwr.a()) {
      i = 2130840879;
    }
    return a(i, 2131719451, "applet_openperformance");
  }
  
  private static bbjs i()
  {
    int i = 2130840878;
    if (bfwr.a()) {
      i = 2130840879;
    }
    return a(i, 2131719448, "applet_closedebug");
  }
  
  private static bbjs j()
  {
    int i = 2130840878;
    if (bfwr.a()) {
      i = 2130840879;
    }
    return a(i, 2131719450, "applet_opendebug");
  }
  
  private static bbjs k()
  {
    int i = 2130845422;
    if (bfwr.a()) {
      i = 2130845423;
    }
    return a(i, 2131719461, "long_screenshot");
  }
  
  private static bbjs l()
  {
    int i = 2130845393;
    if (bfwr.a()) {
      i = 2130845394;
    }
    return a(i, 2131719455, "colornote");
  }
  
  private static bbjs m()
  {
    if (bfwr.a()) {}
    return a(2130849427, 2131719480, "url_to_txdoc");
  }
  
  private static bbjs n()
  {
    int i = 2130845404;
    if (bfwr.a()) {
      i = 2130845405;
    }
    return a(i, 2131719476, "search_emotion");
  }
  
  private static bbjs o()
  {
    int i = 2130845425;
    if (bfwr.a()) {
      i = 2130845426;
    }
    return a(i, 2131719465, "other_app");
  }
  
  private static bbjs p()
  {
    if (bfwr.a()) {}
    return a(2130845424, 2131719474, "scan_appletcode");
  }
  
  private static bbjs q()
  {
    int i = 2130845435;
    if (bfwr.a()) {
      i = 2130845436;
    }
    return a(i, 2131719475, "scan_qrcode");
  }
  
  private static bbjs r()
  {
    int i = 2130845420;
    if (bfwr.a()) {
      i = 2130845421;
    }
    return a(i, 2131719447, "aio_position");
  }
  
  private static bbjs s()
  {
    int i = 2130845449;
    if (bfwr.a()) {
      i = 2130845450;
    }
    return a(i, 2131719466, "pick_words");
  }
  
  private static bbjs t()
  {
    int i = 2130845372;
    if (bfwr.a()) {
      i = 2130845373;
    }
    return a(i, 2131719459, "group_album");
  }
  
  private static bbjs u()
  {
    int i = 2130845378;
    if (bfwr.a()) {
      i = 2130845379;
    }
    return a(i, 2131719439, "Qzone_album");
  }
  
  private static bbjs v()
  {
    int i = 2130845395;
    if (bfwr.a()) {
      i = 2130845396;
    }
    return a(i, 2131719443, "add_emotion");
  }
  
  private static bbjs w()
  {
    int i = 2130840882;
    if (bfwr.a()) {
      i = 2130840883;
    }
    return a(i, 2131719467, "push_setup");
  }
  
  private static bbjs x()
  {
    int i = 2130842116;
    if (bfwr.a()) {
      i = 2130845452;
    }
    return a(i, 2131719479, "uninterested");
  }
  
  private static bbjs y()
  {
    int i = 2130845410;
    if (bfwr.a()) {
      i = 2130845411;
    }
    return a(i, 2131719473, "save");
  }
  
  private static bbjs z()
  {
    if (bfwr.a()) {}
    return a(2130842130, 2131719463, "not_care");
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
 * Qualified Name:     bbjs
 * JD-Core Version:    0.7.0.1
 */