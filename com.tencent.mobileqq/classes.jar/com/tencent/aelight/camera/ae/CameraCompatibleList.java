package com.tencent.aelight.camera.ae;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class CameraCompatibleList
{
  static String A;
  static String B;
  static String C;
  static String D;
  static String E;
  static String F;
  static String G;
  static String H;
  static String I;
  static String J;
  static String K;
  static String L;
  static String M;
  static String N;
  static String O;
  private static AtomicBoolean P = new AtomicBoolean(false);
  private static Hashtable<String, String> Q = null;
  static String a = "GT-I8262D|SCH-I879|SCH-I829";
  static String b = "M040|GT-N7102|GT-N7108|HTC_7060|OPPO_R1S|SM-G9250|HUAWEI NXT-TL00|DOOV L5|Lenovo A5860|Nexus 6P|R827T|VIE-AL10|OPPO A59m|OPPO A37m|OPPO R9m|OPPO R9tm|MI 4LTE|HUAWEI GRA-CL00|vivo X6A|SM-N9100|MX4 Pro|HUAWEI TAG-TL00|H60-L12|SM-G9200|vivo X6Plus D|vivo X6D|OPPO R7|vivo X5Pro D";
  static String c = "M351";
  static String d = "Meizu;M351;17";
  static String e = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H|M823";
  static String f = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1|redbird;redbird H1;23;MMB29M";
  static String g = "Nexus 5X";
  static String h = "HTC T329t";
  static String i = "ZTE-T U880|Coolpad 5219|K-Touch S2";
  static String j = "M040|MX4 Pro";
  static String k = "Mi-4c|MI NOTE Pro";
  static String l = "samsung;SM-G5108Q;19;KTU84P";
  static String m = "OPPO;R7c;19|OPPO;A51kc;22|OPPO;OPPO A51kc;22|OPPO;3007;19|OPPO;OPPO 3007;19|OPPO;A31;19|OPPO;OPPO A31;19|OPPO;R7Plusm;22|OPPO;OPPO R7Plusm;22|OPPO;A51;22|OPPO;OPPO A51;22|OPPO;R7sm;22|OPPO;OPPO R7sm;22|OPPO;A53;22|OPPO;OPPO A53;22|OPPO;A53m;22|OPPO;OPPO A53m;22|OPPO;A33;22|OPPO;OPPO A33;22|OPPO;R7sPlus;22|OPPO;OPPO R7sPlus;22|OPPO;A35;22|OPPO;OPPO A35;22|OPPO;A11;19|OPPO;OPPO A11;19|OPPO;R7;19|OPPO;OPPO R7;19|OPPO;R8107;19|OPPO;OPPO R8107;19|OPPO;1107;19|OPPO;OPPO 1107;19|OPPO;R8007;18|OPPO;OPPO R8007;18|OPPO;R8207;19|OPPO;OPPO R8207;19|OPPO;R7007;18|OPPO;OPPO R7007;18|OPPO;N5110;18|OPPO;OPPO N5110;18|OPPO;A33m;22|OPPO;OPPO A33m;22|OPPO;A33t;22|OPPO;OPPO A33t;22|OPPO;N5117;18|OPPO;OPPO N5117;18|ONEPLUS;A0001;22|OnePlus;ONE E1001;22|OnePlus;ONE E1003;22";
  static String n = "Coolpad 8675|Coolpad 8675-HD|SM-G900|H30-U10|MB855|HUAWEI G730-T00|lPHONE 6";
  static String o = "GiONEE;E3T;17";
  static String p = "Xiaomi;MI 2A;16|meizu;M356;18|meizu;MX4;19|Meizu;m1 note;19";
  static String q = "BBK;vivo X5L;19|HTC;HTC ONE X;15";
  static String r = "LGE;Nexus 5";
  static String s = "Xiaomi;MI 2S|nubia;NX513J|OPPO;1107|OPPO;OPPO R7sm|vivo;vivo Y27|HUAWEI;HUAWEI RIO-AL00|Xiaomi;Redmi Note 3|Xiaomi;MI 3|Meizu;m1 metal|Meizu;M3s|Xiaomi;MI 4LTE|Xiaomi;MI 5|Xiaomi;MI NOTE LTE";
  static String t = "asus;ASUS_T00F;21";
  static String u = "Meizu;MX4 Pro;21";
  static String v = "htc;HTC T329t;16|htc;HTC T528t;15";
  static String w = "Xiaomi;MI 2S";
  static String x = "HUAWEI;HUAWEI GRA-CL10";
  static String y = "samsung;GT-I8558|samsung;SM-G3818|Lenovo;Lenovo A828t|XiaoMi;HM 2A|OPPO;OPPO R823T|OPPO;R823T|Meizu;M355|samsung;SM-G3812|Meizu;m1 note|OPPO;U707T|OPPO;OPPO U707T|samsung;GT-I9502|HUAWEI;HUAWEI P6-T00|Meizu;M351|nubia;NX513J|meizu;M356|samsung;GT-I9500|OPPO;R815T|YuLong;Coolpad8750|BBK;vivo X3t|Xiaomi;2013022|Xiaomi;2013023|OPPO;N1T";
  static String z = "HUAWEI;NTS-AL00";
  
  static
  {
    A = "";
    B = "samsung;17;JDQ39";
    C = "LGE;Nexus 5";
    D = "Xiaomi;MI 3|samsung;GT-I9500|OPPO;X907";
    E = "samsung;SM-A7100;22;LMY47X|OPPO;OPPO A37m;22;LMY47I|HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|samsung;SM-G9208;23;MMB29K|HUAWEI;HUAWEI NXT-AL10;23;HUAWEINXT-AL10|OPPO;OPPO R7;19;KTU84P|lephone;lephone W9;22;LMY47D";
    F = "HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|HUAWEI;H30-T00;17;HuaweiH30-T00|BBK;vivo X5L;19;KOT49H";
    G = "HTC D820u";
    H = "samsung;SM-N9009;18;JSS15J|OPPO;X907;15;IML74K";
    I = "vivo;vivo X7Plus;22|OPPO;N1T;17|samsung;SM-A7000;19";
    J = "Xiaomi;MI 3;19";
    K = "OPPO;OPPO R9 Plustm A;22";
    L = "Xiaomi;MI 6;25|samsung;SM-G5500;22|samsung;SM-J3110;22|samsung;SM-G6000;22|ZTE;BV0701;23|GiONEE;GN8001;22";
    M = "VIVO;V1821A|VIVO;V1821T";
    N = "";
    O = "VIVO;V1732T|VIVO;V1732A";
    if (Q == null) {
      Q = new Hashtable();
    }
    Q.put(CameraCompatibleConstants.a, a);
    Q.put(CameraCompatibleConstants.b, b);
    Q.put(CameraCompatibleConstants.c, c);
    Q.put(CameraCompatibleConstants.d, d);
    Q.put(CameraCompatibleConstants.e, e);
    Q.put(CameraCompatibleConstants.f, f);
    Q.put(CameraCompatibleConstants.g, g);
    Q.put(CameraCompatibleConstants.h, h);
    Q.put(CameraCompatibleConstants.i, i);
    Q.put(CameraCompatibleConstants.j, j);
    Q.put(CameraCompatibleConstants.k, k);
    Q.put(CameraCompatibleConstants.l, m);
    Q.put(CameraCompatibleConstants.m, n);
    Q.put(CameraCompatibleConstants.n, o);
    Q.put(CameraCompatibleConstants.o, s);
    Q.put(CameraCompatibleConstants.p, p);
    Q.put(CameraCompatibleConstants.q, q);
    Q.put(CameraCompatibleConstants.r, t);
    Q.put(CameraCompatibleConstants.z, u);
    Q.put(CameraCompatibleConstants.s, v);
    Q.put(CameraCompatibleConstants.t, w);
    Q.put(CameraCompatibleConstants.u, x);
    Q.put(CameraCompatibleConstants.v, A);
    Q.put(CameraCompatibleConstants.w, y);
    Q.put(CameraCompatibleConstants.x, z);
    Q.put(CameraCompatibleConstants.y, l);
    Q.put(CameraCompatibleConstants.A, B);
    Q.put(CameraCompatibleConstants.B, r);
    Q.put(CameraCompatibleConstants.C, C);
    Q.put(CameraCompatibleConstants.D, D);
    Q.put(CameraCompatibleConstants.E, E);
    Q.put(CameraCompatibleConstants.F, F);
    Q.put(CameraCompatibleConstants.G, G);
    Q.put(CameraCompatibleConstants.H, H);
    Q.put(CameraCompatibleConstants.I, I);
    Q.put(CameraCompatibleConstants.J, M);
    Q.put(CameraCompatibleConstants.K, N);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCompatibleList", 2, "local config has been inited");
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (Q == null) {
      Q = new Hashtable();
    }
    try
    {
      localObject = new JSONObject(paramString);
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)((JSONObject)localObject).get(str1);
        String str3 = (String)Q.get(str1);
        if ((Q.containsKey(str1)) && (str3 != null))
        {
          Hashtable localHashtable = Q;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str3);
          localStringBuilder.append("|");
          localStringBuilder.append(str2);
          localHashtable.put(str1, localStringBuilder.toString());
        }
        else
        {
          Q.put(str1, str2);
        }
      }
      if (paramBoolean)
      {
        localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        ((SharedPreferences.Editor)localObject).putString("camera_compatible_list", paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
      P.set(true);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateCompatibleList json ERROR, msg=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("CameraCompatibleList", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return a(localStringBuilder.toString(), "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19");
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFoundProductFeature key=");
      localStringBuilder.append(paramString);
      QLog.d("CameraCompatibleList", 2, localStringBuilder.toString());
    }
    if (!P.get()) {
      h();
    }
    if (Q == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return a(localStringBuilder.toString(), (String)Q.get(paramString));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramString2 == null) {
      return false;
    }
    paramString2 = paramString2.split("\\|");
    if (paramString2 == null) {
      return false;
    }
    int i2 = paramString2.length;
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      if (paramString2[i1].equalsIgnoreCase(paramString1))
      {
        bool1 = true;
        break;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("isFoundProduct buildType:");
      paramString2.append(paramString1);
      paramString2.append(", result:");
      paramString2.append(bool1);
      QLog.d("CameraCompatibleList", 2, paramString2.toString());
    }
    return bool1;
  }
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return a(localStringBuilder.toString(), J);
  }
  
  public static boolean b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFoundProductFeatureRom key=");
      localStringBuilder.append(paramString);
      QLog.d("CameraCompatibleList", 2, localStringBuilder.toString());
    }
    if (!P.get()) {
      h();
    }
    if (Q == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.ID);
    return a(localStringBuilder.toString(), (String)Q.get(paramString));
  }
  
  public static boolean c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return a(localStringBuilder.toString(), K);
  }
  
  public static boolean c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFoundProduct key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CameraCompatibleList", 2, ((StringBuilder)localObject).toString());
    }
    if (!P.get()) {
      h();
    }
    Object localObject = Q;
    if (localObject == null) {
      return false;
    }
    paramString = (String)((Hashtable)localObject).get(paramString);
    return a(Build.MODEL, paramString);
  }
  
  public static boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return a(localStringBuilder.toString(), L);
  }
  
  public static boolean d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFoundProduct key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CameraCompatibleList", 2, ((StringBuilder)localObject).toString());
    }
    if (!P.get()) {
      h();
    }
    if (Q == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFoundProductManufacturer =");
      localStringBuilder.append((String)localObject);
      QLog.d("CameraCompatibleList", 2, localStringBuilder.toString());
    }
    return a((String)localObject, (String)Q.get(paramString));
  }
  
  public static boolean e()
  {
    return e(CameraCompatibleConstants.J);
  }
  
  private static boolean e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDualScreenPhone key=");
      localStringBuilder.append(paramString);
      QLog.d("CameraCompatibleList", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER.toUpperCase());
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL.toUpperCase());
    return a(localStringBuilder.toString(), (String)Q.get(paramString));
  }
  
  public static boolean f()
  {
    if (!P.get()) {
      h();
    }
    String str = (String)Q.get(CameraCompatibleConstants.K);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL);
    return a(localStringBuilder.toString(), str) ^ true;
  }
  
  public static boolean g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER.toUpperCase());
    localStringBuilder.append(";");
    localStringBuilder.append(Build.MODEL.toUpperCase());
    return a(localStringBuilder.toString(), O);
  }
  
  private static void h()
  {
    if (P.get() == true) {
      return;
    }
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("camera_compatible_list", "");
    if (!TextUtils.isEmpty(str)) {
      a(str, false);
    }
    P.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.CameraCompatibleList
 * JD-Core Version:    0.7.0.1
 */