package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.MobileQQ;

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
  public static String M;
  public static String N;
  public static String O;
  public static String P;
  public static String Q;
  public static final String R;
  public static final String S;
  public static final String T;
  public static String U;
  public static int a;
  public static long a;
  public static final String a;
  public static final String[] a;
  public static final int b;
  public static long b;
  public static String b;
  public static final String[] b;
  public static int c;
  public static String c;
  public static int d;
  public static String d;
  public static int e;
  public static String e;
  public static int f;
  public static final String f;
  public static int g;
  public static final String g;
  public static int h;
  public static final String h;
  public static final String i;
  public static final String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static final String o;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir());
    localStringBuilder.append("/apollo");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_JavaLangString = "blendshape";
    jdField_c_of_type_JavaLangString = "deltaHSV";
    jdField_d_of_type_JavaLangString = "skeleton";
    jdField_e_of_type_JavaLangString = "faceUrl";
    jdField_a_of_type_Int = 3000000;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getExternalCacheDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cmshow");
    jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_f_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cmshowGifDatas");
    localStringBuilder.append(File.separator);
    jdField_g_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir());
    localStringBuilder.append("/crossengine");
    jdField_h_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_h_of_type_JavaLangString);
    localStringBuilder.append("/libs/");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_h_of_type_JavaLangString);
    localStringBuilder.append("/CrossEngine_Assets/");
    j = localStringBuilder.toString();
    jdField_b_of_type_Int = Color.parseColor("#EBEDF4");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "FaceOrnament", "BackSuit", "HeadDress", "FaceSuit", "HairType", "TopSuit", "BottomSuit" };
    jdField_c_of_type_Int = 31104;
    jdField_d_of_type_Int = 31105;
    jdField_e_of_type_Int = 31102;
    jdField_f_of_type_Int = 31106;
    jdField_a_of_type_Long = 35001L;
    jdField_b_of_type_Long = 35019L;
    k = "https://cmshow.qq.com/apollo/html/direct_pay.html?_wv=1027";
    l = "https://cmshow.qq.com/apollo/html/actlist.html?_wv=1027";
    m = "https://cmshow.qq.com/apollo/html/not_support.html?_wv=1027";
    n = "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326&actionId=";
    localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/index_v2.html");
    localStringBuilder.append("?client=androidQQ");
    localStringBuilder.append("&version=");
    localStringBuilder.append("8.7.0.5295");
    localStringBuilder.append("&system=");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("&device=");
    localStringBuilder.append(Build.DEVICE);
    o = localStringBuilder.toString();
    p = "https://cmshow.qq.com/apollo/html/game-platform/index.html?_wv=16777219&_bid=2695&adtag=aio";
    q = "https://cmshow.qq.com/apollo/html/game-platform/my-coins.html?_wv=1027&_bid=2695&adtag=aio";
    r = "https://cmshow.qq.com/apollo/html/system/mycoins.html?_bid=2536&_wv=1027";
    s = "https://cmshow.qq.com/apollo/html/task_658.html?_bid=2345&_wv=1027";
    t = "https://cmshow.qq.com/apollo/html/system/task_detail.html?_bid=2536&_wwv=4&_wv=16778243";
    u = "https://cmshow.qq.com/apollo/html/island/crystal.html?_wv=1027";
    v = "https://cmshow.qq.com/apollo/html/production/machine.html?_wv=3&_bid=2630";
    w = "https://cmshow.qq.com/apollo/html/game-platform/my-game.html?_wv=1027&_bid=2695";
    x = "https://sqimg.qq.com/qq_product_operations/tmg_sdk/QAVOPENSDK_1.9.6.16.zip";
    y = "dd3d6659ce42a5face3777902679834b";
    J = "https://cmshow.gtimg.cn/client/zip/apollo_drawer_game_box_lottie.zip";
    K = "https://cmshow.qq.com/apollo/html/game-platform/game-feeds-gc.html?_wv=3&tab=hotplay&from=gamecenter&_bid=3143";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
    localStringBuilder.append(M);
    localStringBuilder.append("/");
    N = localStringBuilder.toString();
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "103100.103200.103201", "103100.103200.103210.103211", "103100.103200.103201.103202", "103100.103200.103220" };
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(103100);
    localStringBuilder.append(".");
    localStringBuilder.append(103200);
    localStringBuilder.append(".");
    localStringBuilder.append(103240);
    localStringBuilder.append(".");
    localStringBuilder.append(103244);
    T = localStringBuilder.toString();
    localStringBuilder.append(".");
    localStringBuilder.append(103245);
    S = localStringBuilder.toString();
    localStringBuilder.append(".");
    localStringBuilder.append(103246);
    R = localStringBuilder.toString();
    U = "https://cmshow.qq.com/apollo/html/game-platform/game-center.html?_wv=16777219&_wwv=4&_bid=2695";
    jdField_g_of_type_Int = 1;
    jdField_h_of_type_Int = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConstant
 * JD-Core Version:    0.7.0.1
 */