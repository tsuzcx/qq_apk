import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class bdax
{
  public static String A;
  public static String B;
  public static String C;
  public static String D;
  public static String E;
  public static String F;
  public static String G;
  public static String H;
  public static String I;
  public static String J;
  static String K;
  static String L;
  static String M;
  static String N;
  static String O;
  static String P;
  static String Q;
  static String R;
  static String S;
  static String T;
  static String U;
  static String V;
  static String W;
  static String X;
  static String Y;
  static String Z;
  public static String a;
  private static Hashtable<String, String> jdField_a_of_type_JavaUtilHashtable;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  static String aa;
  static String ab;
  static String ac;
  static String ad;
  static String ae;
  static String af;
  static String ag;
  static String ah;
  static String ai;
  static String aj;
  static String ak;
  static String al;
  static String am;
  static String an;
  static String ao;
  static String ap;
  static String aq;
  static String ar;
  static String as;
  static String at;
  static String au;
  static String av;
  static String aw;
  static String ax;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    jdField_a_of_type_JavaLangString = "NOT_FOCUS_MODEL";
    b = "NOT_CALLBACK_WHEN_SCREENOFF_MODEL";
    c = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL";
    d = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2";
    e = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL";
    f = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2";
    g = "PREVIEW_ORIENTATION_270_OF_BACK_MODEL";
    h = "NOT_TAKE_PICTURE_MODEL";
    i = "PREVIEW_DATA_LENGTH_ERR_MODEL";
    j = "NEED_ROTATION_INFO_90_MODEL";
    k = "NEED_ROTATION_INFO_MODEL";
    l = "PREVIEW_DATA_LENGTH_MIN_640X480_MODLE";
    m = "GL_CHOOSER_CONFIG_MODEL";
    n = "ENCODE_ERROR_NOT_SUPPORT_PTV";
    o = "HW_PRE_SEND_NOT_SUPPORT_MODEL";
    p = "HARDWARE_PRIVILEGE_ERROR_MODEL";
    q = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL";
    r = "HW_HARDENCODE_NOT_SUPPORT_MODEL";
    s = "PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE";
    t = "IO_RW_VERY_SLOW_MODLE";
    u = "NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE";
    v = "BLACK_EGL_MAKECURRENT_ERR_3009";
    w = "BLACK_NOT_SUPPORT_FILTER_PHONE";
    x = "CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA";
    y = "CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL";
    z = "BLACK_OPENGL_ES20_NEED_FLUSH";
    A = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK";
    B = "WHITE_LIST_FILTER_HIGH_FPS_PHONE";
    C = "DO_NOT_DESTORY_GLSURFACE_VIEW";
    D = "BLACK_3D_RENDER_ES20_NEED_SYNC";
    E = "BLACK_NOT_SUPPORT_3D_TK";
    F = "DISABLE_FLASH";
    G = "DISABLE_BACK_CAMERA_MODE";
    H = "NOT_SUPPORT_MUTIL_TOUCH";
    I = "DUAL_DIFF_SCREEN_PHONE";
    J = "DOT_NOT_CHANGE_PREVIEW_SIZE";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    K = "GT-I8262D|SCH-I879|SCH-I829";
    L = "M040|GT-N7102|GT-N7108|HTC_7060|OPPO_R1S|SM-G9250|HUAWEI NXT-TL00|DOOV L5|Lenovo A5860|Nexus 6P|R827T|VIE-AL10|OPPO A59m|OPPO A37m|OPPO R9m|OPPO R9tm|MI 4LTE|HUAWEI GRA-CL00|vivo X6A|SM-N9100|MX4 Pro|HUAWEI TAG-TL00|H60-L12|SM-G9200|vivo X6Plus D|vivo X6D|OPPO R7|vivo X5Pro D";
    M = "M351";
    N = "Meizu;M351;17";
    O = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H|M823";
    P = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1|redbird;redbird H1;23;MMB29M";
    Q = "Nexus 5X";
    R = "HTC T329t";
    S = "ZTE-T U880|Coolpad 5219|K-Touch S2";
    T = "M040|MX4 Pro";
    U = "Mi-4c|MI NOTE Pro";
    V = "samsung;SM-G5108Q;19;KTU84P";
    W = "OPPO;R7c;19|OPPO;A51kc;22|OPPO;OPPO A51kc;22|OPPO;3007;19|OPPO;OPPO 3007;19|OPPO;A31;19|OPPO;OPPO A31;19|OPPO;R7Plusm;22|OPPO;OPPO R7Plusm;22|OPPO;A51;22|OPPO;OPPO A51;22|OPPO;R7sm;22|OPPO;OPPO R7sm;22|OPPO;A53;22|OPPO;OPPO A53;22|OPPO;A53m;22|OPPO;OPPO A53m;22|OPPO;A33;22|OPPO;OPPO A33;22|OPPO;R7sPlus;22|OPPO;OPPO R7sPlus;22|OPPO;A35;22|OPPO;OPPO A35;22|OPPO;A11;19|OPPO;OPPO A11;19|OPPO;R7;19|OPPO;OPPO R7;19|OPPO;R8107;19|OPPO;OPPO R8107;19|OPPO;1107;19|OPPO;OPPO 1107;19|OPPO;R8007;18|OPPO;OPPO R8007;18|OPPO;R8207;19|OPPO;OPPO R8207;19|OPPO;R7007;18|OPPO;OPPO R7007;18|OPPO;N5110;18|OPPO;OPPO N5110;18|OPPO;A33m;22|OPPO;OPPO A33m;22|OPPO;A33t;22|OPPO;OPPO A33t;22|OPPO;N5117;18|OPPO;OPPO N5117;18|ONEPLUS;A0001;22|OnePlus;ONE E1001;22|OnePlus;ONE E1003;22";
    X = "Coolpad 8675|Coolpad 8675-HD|SM-G900|H30-U10|MB855|HUAWEI G730-T00|lPHONE 6";
    Y = "GiONEE;E3T;17";
    Z = "Xiaomi;MI 2A;16|meizu;M356;18|meizu;MX4;19|Meizu;m1 note;19";
    aa = "BBK;vivo X5L;19|HTC;HTC ONE X;15";
    ab = "LGE;Nexus 5";
    ac = "Xiaomi;MI 2S|nubia;NX513J|OPPO;1107|OPPO;OPPO R7sm|vivo;vivo Y27|HUAWEI;HUAWEI RIO-AL00|Xiaomi;Redmi Note 3|Xiaomi;MI 3|Meizu;m1 metal|Meizu;M3s|Xiaomi;MI 4LTE|Xiaomi;MI 5|Xiaomi;MI NOTE LTE";
    ad = "asus;ASUS_T00F;21";
    ae = "Meizu;MX4 Pro;21";
    af = "htc;HTC T329t;16|htc;HTC T528t;15";
    ag = "Xiaomi;MI 2S";
    ah = "HUAWEI;HUAWEI GRA-CL10";
    ai = "samsung;GT-I8558|samsung;SM-G3818|Lenovo;Lenovo A828t|XiaoMi;HM 2A|OPPO;OPPO R823T|OPPO;R823T|Meizu;M355|samsung;SM-G3812|Meizu;m1 note|OPPO;U707T|OPPO;OPPO U707T|samsung;GT-I9502|HUAWEI;HUAWEI P6-T00|Meizu;M351|nubia;NX513J|meizu;M356|samsung;GT-I9500|OPPO;R815T|YuLong;Coolpad8750|BBK;vivo X3t|Xiaomi;2013022|Xiaomi;2013023|OPPO;N1T";
    aj = "";
    ak = "samsung;17;JDQ39";
    al = "LGE;Nexus 5";
    am = "Xiaomi;MI 3|samsung;GT-I9500|OPPO;X907";
    an = "samsung;SM-A7100;22;LMY47X|OPPO;OPPO A37m;22;LMY47I|HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|samsung;SM-G9208;23;MMB29K|HUAWEI;HUAWEI NXT-AL10;23;HUAWEINXT-AL10|OPPO;OPPO R7;19;KTU84P|lephone;lephone W9;22;LMY47D";
    ao = "HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|HUAWEI;H30-T00;17;HuaweiH30-T00|BBK;vivo X5L;19;KOT49H";
    ap = "HTC D820u";
    aq = "samsung;SM-N9009;18;JSS15J|OPPO;X907;15;IML74K";
    ar = "vivo;vivo X7Plus;22|OPPO;N1T;17|samsung;SM-A7000;19";
    as = "Xiaomi;MI 3;19";
    at = "OPPO;OPPO R9 Plustm A;22";
    au = "Xiaomi;MI 6;25|samsung;SM-G5500;22|samsung;SM-J3110;22|samsung;SM-G6000;22|ZTE;BV0701;23|GiONEE;GN8001;22";
    av = "VIVO;V1821A|VIVO;V1821T";
    aw = "";
    ax = "VIVO;V1732T|VIVO;V1732A";
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    }
    jdField_a_of_type_JavaUtilHashtable.put(jdField_a_of_type_JavaLangString, K);
    jdField_a_of_type_JavaUtilHashtable.put(b, L);
    jdField_a_of_type_JavaUtilHashtable.put(c, M);
    jdField_a_of_type_JavaUtilHashtable.put(d, N);
    jdField_a_of_type_JavaUtilHashtable.put(e, O);
    jdField_a_of_type_JavaUtilHashtable.put(f, P);
    jdField_a_of_type_JavaUtilHashtable.put(g, Q);
    jdField_a_of_type_JavaUtilHashtable.put(h, R);
    jdField_a_of_type_JavaUtilHashtable.put(i, S);
    jdField_a_of_type_JavaUtilHashtable.put(j, T);
    jdField_a_of_type_JavaUtilHashtable.put(k, U);
    jdField_a_of_type_JavaUtilHashtable.put(l, W);
    jdField_a_of_type_JavaUtilHashtable.put(m, X);
    jdField_a_of_type_JavaUtilHashtable.put(n, Y);
    jdField_a_of_type_JavaUtilHashtable.put(o, ac);
    jdField_a_of_type_JavaUtilHashtable.put(p, Z);
    jdField_a_of_type_JavaUtilHashtable.put(q, aa);
    jdField_a_of_type_JavaUtilHashtable.put(r, ad);
    jdField_a_of_type_JavaUtilHashtable.put(y, ae);
    jdField_a_of_type_JavaUtilHashtable.put(s, af);
    jdField_a_of_type_JavaUtilHashtable.put(t, ag);
    jdField_a_of_type_JavaUtilHashtable.put(u, ah);
    jdField_a_of_type_JavaUtilHashtable.put(v, aj);
    jdField_a_of_type_JavaUtilHashtable.put(w, ai);
    jdField_a_of_type_JavaUtilHashtable.put(x, V);
    jdField_a_of_type_JavaUtilHashtable.put(z, ak);
    jdField_a_of_type_JavaUtilHashtable.put(A, ab);
    jdField_a_of_type_JavaUtilHashtable.put(B, al);
    jdField_a_of_type_JavaUtilHashtable.put(C, am);
    jdField_a_of_type_JavaUtilHashtable.put(D, an);
    jdField_a_of_type_JavaUtilHashtable.put(E, ao);
    jdField_a_of_type_JavaUtilHashtable.put(F, ap);
    jdField_a_of_type_JavaUtilHashtable.put(G, aq);
    jdField_a_of_type_JavaUtilHashtable.put(H, ar);
    jdField_a_of_type_JavaUtilHashtable.put(I, av);
    jdField_a_of_type_JavaUtilHashtable.put(J, aw);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "local config has been inited");
    }
  }
  
  private static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true) {
      return;
    }
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("camera_compatible_list", "");
    if (!TextUtils.isEmpty(str)) {
      a(str, false);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    }
    Object localObject;
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        localObject = new JSONObject(paramString);
        Iterator localIterator = ((JSONObject)localObject).keys();
        if (!localIterator.hasNext()) {
          break label188;
        }
        str1 = (String)localIterator.next();
        str2 = (String)((JSONObject)localObject).get(str1);
        String str3 = (String)jdField_a_of_type_JavaUtilHashtable.get(str1);
        if ((!jdField_a_of_type_JavaUtilHashtable.containsKey(str1)) || (str3 == null)) {
          break label174;
        }
        jdField_a_of_type_JavaUtilHashtable.put(str1, str3 + "|" + str2);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("CameraCompatibleList", 2, "updateCompatibleList json ERROR, msg=" + paramString.getMessage());
      return;
      label174:
      jdField_a_of_type_JavaUtilHashtable.put(str1, str2);
    }
    label188:
    if (paramBoolean)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
      ((SharedPreferences.Editor)localObject).putString("camera_compatible_list", paramString);
      ((SharedPreferences.Editor)localObject).commit();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static boolean a()
  {
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19");
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeature key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString2 == null) {}
    do
    {
      return bool2;
      paramString2 = paramString2.split("\\|");
    } while (paramString2 == null);
    int i2 = paramString2.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool3;
      if (i1 < i2)
      {
        if (paramString2[i1].equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("CameraCompatibleList", 2, "isFoundProduct buildType:" + paramString1 + ", result:" + bool1);
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean b()
  {
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, as);
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeatureRom key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean c()
  {
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, at);
  }
  
  public static boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductFeatureRom key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    return a(Build.MANUFACTURER + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean d()
  {
    return a(Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT, au);
  }
  
  public static boolean d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProduct key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    paramString = (String)jdField_a_of_type_JavaUtilHashtable.get(paramString);
    return a(Build.MODEL, paramString);
  }
  
  public static boolean e()
  {
    return f(I);
  }
  
  public static boolean e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProduct key=" + paramString);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_JavaUtilHashtable == null) {
      return false;
    }
    String str = Build.MANUFACTURER + ";" + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isFoundProductManufacturer =" + str);
    }
    return a(str, (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean f()
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    String str = (String)jdField_a_of_type_JavaUtilHashtable.get(J);
    return !a(Build.MANUFACTURER + ";" + Build.MODEL, str);
  }
  
  private static boolean f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "isDualScreenPhone key=" + paramString);
    }
    return a(Build.MANUFACTURER.toUpperCase() + ";" + Build.MODEL.toUpperCase(), (String)jdField_a_of_type_JavaUtilHashtable.get(paramString));
  }
  
  public static boolean g()
  {
    return a(Build.MANUFACTURER.toUpperCase() + ";" + Build.MODEL.toUpperCase(), ax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdax
 * JD-Core Version:    0.7.0.1
 */