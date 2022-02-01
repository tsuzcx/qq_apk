package com.tencent.mobileqq.apollo.api.uitls;

import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class ApolloConstant
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
  public static String K;
  public static String L;
  public static final String M;
  public static final String N;
  public static final String O;
  public static String P;
  public static String Q;
  public static String R;
  public static String S;
  public static String T;
  public static String U;
  public static final int a;
  public static long a;
  public static final String a;
  public static final String[] a;
  public static int b;
  public static long b;
  public static String b;
  public static final String[] b;
  public static final int c;
  public static String c;
  public static int d;
  public static String d;
  public static int e;
  public static String e;
  public static int f;
  public static String f;
  public static int g;
  public static String g;
  public static int h;
  public static String h;
  public static int i;
  public static String i;
  public static final String j;
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
    jdField_a_of_type_Int = ApolloUtilImpl.dp2px(100.0F, DeviceInfoUtil.a());
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + "/apollo";
    jdField_b_of_type_JavaLangString = "blendshape";
    jdField_c_of_type_JavaLangString = "deltaHSV";
    jdField_d_of_type_JavaLangString = "skeleton";
    jdField_e_of_type_JavaLangString = "faceUrl";
    jdField_b_of_type_Int = 300000;
    jdField_c_of_type_Int = Color.parseColor("#EBEDF4");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "FaceOrnament", "BackSuit", "HeadDress", "FaceSuit", "HairType", "TopSuit", "BottomSuit" };
    jdField_d_of_type_Int = 31104;
    jdField_e_of_type_Int = 31105;
    jdField_f_of_type_Int = 31102;
    jdField_g_of_type_Int = 31106;
    jdField_a_of_type_Long = 35001L;
    jdField_b_of_type_Long = 35019L;
    jdField_f_of_type_JavaLangString = "https://cmshow.qq.com/apollo/html/direct_pay.html?_wv=1027";
    jdField_g_of_type_JavaLangString = "https://cmshow.qq.com/apollo/html/actlist.html?_wv=1027";
    jdField_h_of_type_JavaLangString = "https://cmshow.qq.com/apollo/html/not_support.html?_wv=1027";
    jdField_i_of_type_JavaLangString = "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326&actionId=";
    StringBuilder localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/index_v2.html");
    localStringBuilder.append("?client=androidQQ").append("&version=").append("8.5.5.5105").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE);
    j = localStringBuilder.toString();
    k = "https://cmshow.qq.com/apollo/html/game-platform/index.html?_wv=16777219&_bid=2695&adtag=aio";
    l = "https://cmshow.qq.com/apollo/html/game-platform/my-coins.html?_wv=1027&_bid=2695&adtag=aio";
    m = "https://cmshow.qq.com/apollo/html/system/mycoins.html?_bid=2536&_wv=1027";
    n = "https://cmshow.qq.com/apollo/html/task_658.html?_bid=2345&_wv=1027";
    o = "https://cmshow.qq.com/apollo/html/system/task_detail.html?_bid=2536&_wwv=4&_wv=16778243";
    p = "https://cmshow.qq.com/apollo/html/island/crystal.html?_wv=1027";
    q = "https://cmshow.qq.com/apollo/html/production/machine.html?_wv=3&_bid=2630";
    r = "https://cmshow.qq.com/apollo/html/game-platform/my-game.html?_wv=1027&_bid=2695";
    s = "https://sqimg.qq.com/qq_product_operations/tmg_sdk/QAVOPENSDK_1.9.6.16.zip";
    t = "dd3d6659ce42a5face3777902679834b";
    E = "https://cmshow.gtimg.cn/client/zip/apollo_drawer_game_box_lottie.zip";
    F = "https://cmshow.qq.com/apollo/html/game-platform/game-feeds-gc.html?_wv=3&tab=hotplay&from=gamecenter&_bid=3143";
    I = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/" + H + "/";
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "103100.103200.103201", "103100.103200.103210.103211", "103100.103200.103201.103202", "103100.103200.103220" };
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(103100).append(".").append(103200).append(".").append(103240).append(".").append(103244);
    O = localStringBuilder.toString();
    localStringBuilder.append(".").append(103245);
    N = localStringBuilder.toString();
    localStringBuilder.append(".").append(103246);
    M = localStringBuilder.toString();
    P = HardCodeUtil.a(2131700397);
    Q = HardCodeUtil.a(2131700396);
    R = "https://cmshow.gtimg.cn/client/img/apollo_aio_game_guide2.png";
    S = "#FFE746";
    T = "https://cmshow.qq.com/apollo/html/game-platform/game-center.html?_wv=16777219&_wwv=4&_bid=2695";
    U = HardCodeUtil.a(2131700395);
    jdField_h_of_type_Int = 1;
    jdField_i_of_type_Int = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.ApolloConstant
 * JD-Core Version:    0.7.0.1
 */