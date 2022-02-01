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
  public static String R;
  public static String S;
  public static String T;
  public static String U;
  public static String V;
  public static String W;
  public static String X;
  public static String Y;
  public static final String[] Z;
  public static final String a;
  public static final String aa;
  public static final String ab;
  public static final String ac;
  public static int ad = 1;
  public static int ae = 2;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static int f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static long q;
  public static long r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static final String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir());
    localStringBuilder.append("/apollo");
    a = localStringBuilder.toString();
    b = "blendshape";
    c = "deltaHSV";
    d = "skeleton";
    e = "faceUrl";
    f = 3000000;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getExternalCacheDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cmshow");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cmshowGifDatas");
    localStringBuilder.append(File.separator);
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir());
    localStringBuilder.append("/crossengine");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("/libs/");
    j = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("/CrossEngine_Assets/");
    k = localStringBuilder.toString();
    l = Color.parseColor("#EBEDF4");
    m = 31104;
    n = 31105;
    o = 31102;
    p = 31106;
    q = 35001L;
    r = 35019L;
    s = "https://cmshow.qq.com/apollo/html/direct_pay.html?_wv=1027";
    t = "https://cmshow.qq.com/apollo/html/actlist.html?_wv=1027";
    u = "https://cmshow.qq.com/apollo/html/not_support.html?_wv=1027";
    v = "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326&actionId=";
    localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/index_v2.html");
    localStringBuilder.append("?client=androidQQ");
    localStringBuilder.append("&version=");
    localStringBuilder.append("8.8.17.5770");
    localStringBuilder.append("&system=");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("&device=");
    localStringBuilder.append(Build.DEVICE);
    w = localStringBuilder.toString();
    x = "https://cmshow.qq.com/apollo/html/game-platform/index.html?_wv=16777219&_bid=2695&adtag=aio";
    y = "https://cmshow.qq.com/apollo/html/game-platform/my-coins.html?_wv=1027&_bid=2695&adtag=aio";
    z = "https://cmshow.qq.com/apollo/html/system/mycoins.html?_bid=2536&_wv=1027";
    A = "https://cmshow.qq.com/apollo/html/task_658.html?_bid=2345&_wv=1027";
    B = "https://cmshow.qq.com/apollo/html/system/task_detail.html?_bid=2536&_wwv=4&_wv=16778243";
    C = "https://cmshow.qq.com/apollo/html/island/crystal.html?_wv=1027";
    D = "https://cmshow.qq.com/apollo/html/production/machine.html?_wv=3&_bid=2630";
    E = "https://cmshow.qq.com/apollo/html/game-platform/my-game.html?_wv=1027&_bid=2695";
    F = "https://sqimg.qq.com/qq_product_operations/tmg_sdk/QAVOPENSDK_1.9.6.16.zip";
    G = "dd3d6659ce42a5face3777902679834b";
    R = "https://cmshow.gtimg.cn/client/zip/apollo_drawer_game_box_lottie.zip";
    S = "https://cmshow.qq.com/apollo/html/game-platform/game-feeds-gc.html?_wv=3&tab=hotplay&from=gamecenter&_bid=3143";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
    localStringBuilder.append(U);
    localStringBuilder.append("/");
    V = localStringBuilder.toString();
    Z = new String[] { "103100.103200.103201", "103100.103200.103210.103211", "103100.103200.103201.103202", "103100.103200.103220" };
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(103100);
    localStringBuilder.append(".");
    localStringBuilder.append(103200);
    localStringBuilder.append(".");
    localStringBuilder.append(103240);
    localStringBuilder.append(".");
    localStringBuilder.append(103244);
    ac = localStringBuilder.toString();
    localStringBuilder.append(".");
    localStringBuilder.append(103245);
    ab = localStringBuilder.toString();
    localStringBuilder.append(".");
    localStringBuilder.append(103246);
    aa = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConstant
 * JD-Core Version:    0.7.0.1
 */