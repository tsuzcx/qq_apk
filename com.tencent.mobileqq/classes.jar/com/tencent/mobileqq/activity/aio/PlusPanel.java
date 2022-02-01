package com.tencent.mobileqq.activity.aio;

import aarg;
import aawm;
import abur;
import abvy;
import achd;
import aean;
import agjm;
import agjn;
import agjo;
import agjp;
import agjq;
import agjr;
import agju;
import agkp;
import ahnt;
import ahxi;
import aiaf;
import aiay;
import aihh;
import aiit;
import aijc;
import aijm;
import aimx;
import ainh;
import aipj;
import aipm;
import amsx;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anzj;
import aoat;
import aobf;
import aocz;
import aody;
import aoip;
import apzu;
import aqzo;
import aran;
import arfc;
import arfd;
import arjl;
import arkh;
import asam;
import aunh;
import auni;
import aunj;
import auxu;
import avtm;
import awml;
import awqg;
import axwz;
import azte;
import bbal;
import bbav;
import bbxk;
import bcuy;
import bdgb;
import bdll;
import bduy;
import bebp;
import becb;
import behz;
import bejx;
import bekk;
import bflw;
import bfmb;
import bgpy;
import bgqm;
import bgsl;
import bgss;
import bgsu;
import bguq;
import bhbg;
import bhju;
import bhlq;
import bhnv;
import bhoo;
import bhpc;
import bhsi;
import bkgt;
import blir;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import common.config.service.QzoneConfig;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import llk;
import mqq.app.MobileQQ;
import mvd;
import mxc;
import nhv;
import niz;
import nlj;
import nll;
import nmd;
import nok;
import org.json.JSONException;
import org.json.JSONObject;
import yup;
import zmw;
import zok;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnLongClickListener
{
  public static final int[] A;
  public static final int[] B;
  public static final int[] C;
  public static final int[] D;
  public static int[] E;
  public static final int[] F;
  public static final int[] G;
  public static final int[] H;
  public static final int[] I = { 2131697767, 2130838160, 204 };
  private static final int[] Z;
  public static final int[] a;
  private static final int[] aA = { 2131697767, 2130838160, 1107930043 };
  private static final int[] ab;
  private static final int[] ad;
  private static final int[] ae;
  private static final int[] af;
  private static final int[] ag;
  private static final int[] ah;
  private static final int[] ai;
  private static final int[] aj;
  private static final int[] ak;
  private static final int[] al;
  private static final int[] am;
  private static final int[] an;
  private static final int[] ao;
  private static final int[] ap;
  private static final int[] aq;
  private static final int[] ar;
  private static final int[] at;
  private static final int[] au;
  private static final int[] av;
  private static final int[] aw;
  private static final int[] ax;
  private static final int[] ay;
  private static final int[] az;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  public static final int[] j;
  public static final int[] k;
  public static final int[] l;
  public static final int[] m;
  public static final int[] n;
  public static final int[] o;
  public static final int[] p;
  public static final int[] q;
  public static final int[] r;
  public static final int[] s;
  public static final int[] t;
  public static final int[] u;
  public static final int[] v;
  public static final int[] w;
  public static final int[] x;
  public static final int[] y;
  public static final int[] z;
  private final int[] J = { 2131697779, 2130839164 };
  private final int[] K = { 2131690675, 2130839142 };
  private final int[] L = { 2131718795, 2130839171 };
  private final int[] M = { 2131718795, 2130839171, 1104788673 };
  private final int[] N = { 2131691406, 2130839176 };
  private final int[] O = { 2131718792, 2130839135 };
  private final int[] P = { 2131718788, 2130839136, 100719166 };
  private final int[] Q = { 2131718789, 2130839137, 101847385 };
  private final int[] R = { 2131718785, 2130839135, 1104651886 };
  private final int[] S = { 2131690682, 2130839166, 1104864066 };
  private final int[] T = { 2131690684, 2130839172 };
  private final int[] U = { 2131690681, 2130839165 };
  private final int[] V = { 2131690677, 2130839151, 100729587 };
  private final int[] W = { 2131690676, 2130839150, 1106184014 };
  private final int[] X = { 2131690685, 2130839159 };
  private final int[] Y = { 2131690683, 2130839168 };
  public int a;
  long jdField_a_of_type_Long;
  aarg jdField_a_of_type_Aarg = null;
  public ViewPager.OnPageChangeListener a;
  public SparseArray<TroopAIOAppInfo> a;
  public BaseChatPie a;
  public PanelAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AIOLongCaptureCtrl jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl;
  ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_hongbao", "chat_tool_qwallettransfer" };
  protected final int[][] a;
  private final int[] aB = { 2131690680, 2130844250, 1108961705 };
  private final int[] aa = { 2131716041, 2130839133 };
  private final int[] ac = { 2131690686, 2130843740, 1104445552 };
  private final int[] as = { 2131697920, 2130843675, 1106865772 };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private final int[][] jdField_b_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, this.K, this.R, f, aA, u, this.P, ag, ad, this.S, g, Z, z, ah, am, ai, at };
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private final int[][] jdField_c_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, this.M, this.R, f, B, this.P, u, this.as, ag, ad, this.S, g, Z, ab, z, ah, am, x, aj, this.ac, ap, aq, av, G, ay, az, aA, this.aB, j, o, l, m, this.Q, r };
  private boolean jdField_d_of_type_Boolean;
  private final int[][] jdField_d_of_type_Array2dOfInt = { jdField_e_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt, E, I, h, i, k, y, F, C, s, A, w, t, D, H, jdField_b_of_type_ArrayOfInt, jdField_c_of_type_ArrayOfInt, v, n, p, q };
  private boolean e;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131718793, 2130839163, 1104864054 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131718793, 2130839163, 217 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131690675, 2130839142, 218 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131697896, 2130839175, 202 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131718782, 2130839135, 201 };
    f = new int[] { 2131718787, 2130839175, 1106658188 };
    g = new int[] { 2131718790, 2130839154, 1104864068 };
    h = new int[] { 2131718790, 2130839154, 205 };
    i = new int[] { 2131690679, 2130839166, 206 };
    Z = new int[] { 2131693903, 2130839157, 1104864070 };
    j = new int[] { 2131693262, 2130839153, 101761547 };
    k = new int[] { 2131693262, 2130839153, 207 };
    l = new int[] { 2131697848, 2130839178, 101793773 };
    m = new int[] { 2131697824, 2130839173, 101817424 };
    n = new int[] { 2131697824, 2130839173, 220 };
    o = new int[] { 2131697823, 2130839170, 101850591 };
    p = new int[] { 2131697823, 2130839170, 221 };
    q = new int[] { 2131689917, 2130838696, 222 };
    r = new int[] { 2131689917, 2130838696, 101872203 };
    ab = new int[] { 2131691296, 2130842349 };
    ad = new int[] { 2131689994, 2130843625, 1101487426 };
    ae = new int[] { 2131691896, 2130843625 };
    af = new int[] { 2131695405, 2130843632 };
    ag = new int[] { 2131689488, 2130842423, 1104864064 };
    ah = new int[] { 2131689489, 2130842424, 1101678813 };
    s = new int[] { 2131716044, 2130839174, 211 };
    ai = new int[] { 2131697783, 2130839167 };
    t = new int[] { 2131697783, 2130839167, 214 };
    u = new int[] { 2131717879, 2130839152, 1104864062 };
    v = new int[] { 2131717879, 2130839152, 219 };
    w = new int[] { 2131696636, 2130850701, 213 };
    aj = new int[] { 2131696636, 2130850701, 1104874204 };
    ak = new int[] { 2131696558, 2130850690 };
    x = new int[] { 2131697763, 2130844197, 1104639410 };
    y = new int[] { 2131697763, 2130844197, 208 };
    al = new int[] { 2131696638, 2130842433 };
    am = new int[] { 2131697103, 2130842475, 1104536706 };
    an = new int[] { 2131697896, 2130839175 };
    ao = new int[] { 2131692934, 2130842519 };
    ap = new int[] { 2131691544, 2130839145, 1104823592 };
    aq = new int[] { 2131691481, 2130839134, 1105298834 };
    z = new int[] { 2131693184, 2130839130, 1104788679 };
    A = new int[] { 2131693184, 2130839130, 212 };
    ar = new int[] { 2131698126, 2130845465 };
    B = new int[] { 2131697782, 2130838193, 1106114157 };
    C = new int[] { 2131697782, 2130838193, 210 };
    at = new int[] { 2131690376, 2130838438 };
    D = new int[] { 2131690376, 2130838438, 215 };
    E = new int[] { 2131697776, 2130839161, 203 };
    F = new int[] { 2131697771, 2130839156, 209 };
    au = new int[] { 2131697780, 2130839162 };
    G = new int[] { 2131697781, 2130838255, 1106189400 };
    H = new int[] { 2131697781, 2130838255, 216 };
    av = new int[] { 2131697035, 2130850702, 1106194086 };
    aw = new int[] { 2131690669, 2130842579 };
    ax = new int[] { 2131690095, 2130838658 };
    ay = new int[] { 2131697095, 2130842469, 1105981808 };
    az = new int[] { 2131696597, 2130843655, 1106729451 };
  }
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.S };
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.S };
  }
  
  private Drawable a(String paramString, int paramInt, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = azte.a(paramInt);
      if ((paramString != null) && (paramString.length >= 2)) {
        return BaseApplicationImpl.getContext().getResources().getDrawable(paramString[1]);
      }
    }
    else
    {
      return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130843635);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2130839135: 
      return "0";
    case 2130839175: 
      return "1";
    case 2130839166: 
      return "3";
    case 2130844197: 
      return "4";
    case 2130839154: 
      return "5";
    case 2130839152: 
      return "6";
    }
    return "7";
  }
  
  private String a(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    String str = paramTroopAIOAppInfo.name;
    switch (aobf.a())
    {
    default: 
      return str;
    case 2052: 
      return paramTroopAIOAppInfo.name;
    }
    return paramTroopAIOAppInfo.enName;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.contains("$TOUIN$"))
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          str = paramString;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            str = paramString.replace("$TOUIN$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    return str;
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = azte.a(paramInt);
      if ((paramString != null) && (paramString.length >= 1)) {
        str = BaseApplicationImpl.getContext().getString(paramString[0]);
      }
    }
    else
    {
      return str;
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (!str.equals("")) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
      }
      if ((paramBoolean) && (paramInt2 != 0)) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramInt2), "", "");
      }
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
      continue;
      str = "23";
      continue;
      str = "4";
      continue;
      str = "5";
      continue;
      str = "6";
      continue;
      str = "8";
      continue;
      str = "24";
      continue;
      str = "9";
      continue;
      str = "11";
      continue;
      str = "22";
      continue;
      str = "12";
      continue;
      str = "13";
      continue;
      str = "14";
      continue;
      str = "15";
      continue;
      str = "16";
      continue;
      str = "17";
      continue;
      str = "18";
      continue;
      str = "21";
    }
  }
  
  private void a(abur paramabur)
  {
    Environment.getExternalStorageState();
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (paramabur != null) && (paramabur.c(l1)))
        {
          agju.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramabur = new auni();
          paramabur.jdField_b_of_type_JavaLangString = "send_file";
          paramabur.jdField_a_of_type_Int = 1;
          aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramabur);
          agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      return;
    }
  }
  
  private void a(agjr paramagjr, bbav parambbav)
  {
    int i4 = 0;
    if (!TextUtils.isEmpty(paramagjr.c))
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = parambbav.a(10, paramagjr.c);
      if (localAppInfo != null) {
        parambbav.b(localAppInfo, "");
      }
    }
    int i1;
    int i2;
    label127:
    int i3;
    label141:
    boolean bool;
    if ((paramagjr.jdField_b_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramagjr.jdField_b_of_type_Int))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramagjr.jdField_b_of_type_Int));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label215;
      }
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label220;
      }
      i2 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label226;
      }
      i3 = 1;
      bool = b();
      if (i1 == 0) {
        break label232;
      }
      i1 = 1;
    }
    for (;;)
    {
      parambbav = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i3 = paramagjr.jdField_b_of_type_Int;
      i2 = i4;
      if (paramagjr.jdField_a_of_type_Boolean) {
        i2 = 1;
      }
      bdll.b(parambbav, "dc00898", "", "", "0X800A46B", "0X800A46B", i3, i2, String.valueOf(i1), "", "", "");
      return;
      label215:
      i1 = 0;
      break;
      label220:
      i2 = 0;
      break label127;
      label226:
      i3 = 0;
      break label141;
      label232:
      if (i2 != 0) {
        i1 = 2;
      } else if (i3 != 0) {
        i1 = 3;
      } else if (bool) {
        i1 = 4;
      } else {
        i1 = 5;
      }
    }
  }
  
  private void a(List<TroopAIOAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        paramList = paramList.iterator();
      }
      label34:
      label215:
      for (;;)
      {
        if (!paramList.hasNext()) {
          return;
        }
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)paramList.next();
        if ((TextUtils.isEmpty(localTroopAIOAppInfo.minVersion)) || (AppSetting.a(localTroopAIOAppInfo.minVersion) >= 0))
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localTroopAIOAppInfo.appid, localTroopAIOAppInfo);
          int[][] arrayOfInt = this.jdField_d_of_type_Array2dOfInt;
          int i2 = arrayOfInt.length;
          int i1 = 0;
          for (;;)
          {
            if (i1 >= i2) {
              break label215;
            }
            int[] arrayOfInt1 = arrayOfInt[i1];
            if ((arrayOfInt1.length >= 3) && (localTroopAIOAppInfo.appid == arrayOfInt1[2]))
            {
              if (arrayOfInt1[2] == 215)
              {
                if ((!amsx.a(getContext(), Boolean.valueOf(false))) || (amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) <= 0)) {
                  break label34;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfInt1);
                break label34;
                this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
                break;
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfInt1);
              break label34;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))
    {
      localTroopManager.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      return true;
    }
    return false;
  }
  
  private boolean a(agjm paramagjm)
  {
    if ((paramagjm != null) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(paramagjm.jdField_b_of_type_Int) >= 0)) {
      return agkp.a((TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramagjm.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramagjm);
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio_new")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_poke")) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_poke_emo")) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_gift_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gift_stranger_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_tencentdoc")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    long l1;
    HashMap localHashMap;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int i1 = mvd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1);
      Object localObject = (bgsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      boolean bool1 = ((bgsl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      boolean bool2 = ((bgsl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      boolean bool3 = ((bgsl)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = ((bgsl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((l1 == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((bgss)localObject).jdField_a_of_type_Long > 0L))))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, anzj.a(2131707191), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = 0L;
      }
      a("chat_tool_gaudio");
      localHashMap = new HashMap();
      localHashMap.put("MultiAVType", String.valueOf(2));
      localHashMap.put("from", "Panel");
      if (!paramBoolean) {}
    }
    for (String str = "true";; str = "false")
    {
      localHashMap.put("publicClass", str);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localHashMap);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1, l1)) {
        bdll.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "1", "");
      }
      aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB5", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1021) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1022) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10009) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10010);
  }
  
  private void c(String paramString)
  {
    QLog.i("PlusPanel", 2, "onMiniAppJump jumpUrl:" + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString)))
    {
      paramString = a(paramString);
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, paramString, 2053, null);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (((HotChatManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ar);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(g);
    }
    Object localObject2;
    label296:
    label560:
    label693:
    label736:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
      while (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        b();
        this.jdField_a_of_type_JavaUtilArrayList.add(ae);
        if (!bduy.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(ak);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(af);
        return;
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject1 = this.jdField_a_of_type_Array2dOfInt;
        i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject2 = localObject1[i1];
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          i1 += 1;
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject1 = (bgqm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l1;
        if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
        {
          i1 = 1;
          if (!((TroopInfo)localObject1).isAdmin()) {
            break label560;
          }
          i2 = 1;
          l1 = (i1 & 0x1) << 2 | (i2 & 0x1) << 1 | 0x1;
          if (((TroopInfo)localObject1).isHomeworkTroop()) {}
          localObject2 = bflw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bfmb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          localObject1 = localObject2;
          if (AudioHelper.e())
          {
            localObject1 = localObject2;
            if (AudioHelper.a(4) == 1)
            {
              AudioHelper.a(anzj.a(2131707178));
              localObject1 = null;
            }
          }
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.w("PlusPanel", 1, "reloadTroop, server, troopAppInfos[" + ((List)localObject1).size() + "]");
          }
          b();
          localObject1 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label736;
          }
          localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
          if ((TextUtils.isEmpty(((TroopAIOAppInfo)localObject2).minVersion)) || (AppSetting.a(((TroopAIOAppInfo)localObject2).minVersion) >= 0))
          {
            if ((((TroopAIOAppInfo)localObject2).identifyMask & l1) == 0L)
            {
              if (!QLog.isDevelopLevel()) {
                continue;
              }
              QLog.d(".troop.troop_appPlusPanel", 1, new Object[] { "reloadTroop, appInfo is filtered: info: ", String.valueOf(localObject2), " userIdentify: ", Long.toBinaryString(l1) });
              continue;
              i1 = 0;
              break;
              i2 = 0;
              break label296;
            }
            this.jdField_a_of_type_AndroidUtilSparseArray.put(((TroopAIOAppInfo)localObject2).appid, localObject2);
            int[][] arrayOfInt = this.jdField_c_of_type_Array2dOfInt;
            int i4 = arrayOfInt.length;
            i1 = 0;
            i2 = 0;
            int[] arrayOfInt1;
            for (;;)
            {
              i3 = i1;
              if (i2 >= i4) {
                break label693;
              }
              arrayOfInt1 = arrayOfInt[i2];
              i3 = i1;
              if (arrayOfInt1.length >= 3)
              {
                i3 = i1;
                if (((TroopAIOAppInfo)localObject2).appid == arrayOfInt1[2])
                {
                  i1 = 1;
                  i3 = 1;
                  if ((arrayOfInt1 != B) || (ScribbleResMgr.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                    break;
                  }
                }
              }
              i2 += 1;
              i1 = i3;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfInt1);
            int i3 = i1;
            if (i3 == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.add(new int[] { -((TroopAIOAppInfo)localObject2).appid, -((TroopAIOAppInfo)localObject2).appid, ((TroopAIOAppInfo)localObject2).appid });
            }
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("PlusPanel", 1, "reloadTroop, local, troopAppInfos[" + this.jdField_b_of_type_Array2dOfInt.length + "]");
    }
    localObject1 = this.jdField_b_of_type_Array2dOfInt;
    int i2 = localObject1.length;
    int i1 = 0;
    label793:
    if (i1 < i2)
    {
      localObject2 = localObject1[i1];
      if (localObject2 != ab) {
        break label826;
      }
      d("200002");
    }
    for (;;)
    {
      i1 += 1;
      break label793;
      break;
      label826:
      if ((localObject2 != B) || (ScribbleResMgr.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_Aarg == null)
    {
      this.jdField_a_of_type_Aarg = aarg.a();
      this.jdField_a_of_type_Aarg.b();
    }
    if (this.jdField_a_of_type_Aarg.a(paramString))
    {
      if (!"200002".equals(paramString)) {
        break label54;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ab);
    }
    label54:
    do
    {
      return;
      if ("0".equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(al);
        return;
      }
    } while (!"1".equals(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(am);
  }
  
  private void k()
  {
    blir localblir = blir.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    localblir.b(2131696620);
    localblir.b(2131696621);
    localblir.c(2131690580);
    localblir.a(new agjp(this, localblir));
    localblir.show();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    if (nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(I);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i);
      this.jdField_a_of_type_JavaUtilArrayList.add(y);
      this.jdField_a_of_type_JavaUtilArrayList.add(h);
      this.jdField_a_of_type_JavaUtilArrayList.add(Z);
      this.jdField_a_of_type_JavaUtilArrayList.add(A);
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(E);
        if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(I);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(v);
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
        this.jdField_a_of_type_JavaUtilArrayList.add(i);
        this.jdField_a_of_type_JavaUtilArrayList.add(y);
        this.jdField_a_of_type_JavaUtilArrayList.add(Z);
      }
      else
      {
        List localList = azte.a(false);
        if ((localList != null) && (!localList.isEmpty()))
        {
          this.jdField_c_of_type_Boolean = true;
          a(localList);
          return;
        }
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(E);
        if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(I);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(v);
        if ((aiay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (bdgb.b())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(F);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
        this.jdField_a_of_type_JavaUtilArrayList.add(i);
        this.jdField_a_of_type_JavaUtilArrayList.add(k);
        if ((aiay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (!bdgb.b())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(F);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(y);
        if (ScribbleResMgr.c(super.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(C);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(Z);
        this.jdField_a_of_type_JavaUtilArrayList.add(s);
        this.jdField_a_of_type_JavaUtilArrayList.add(A);
        this.jdField_a_of_type_JavaUtilArrayList.add(w);
        if (bbal.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(H);
        }
        if (((bebp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(283)).a().booleanValue())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(t);
          aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        if ((amsx.a(getContext(), Boolean.valueOf(false))) && (amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) > 0)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(D);
        }
        if (!apzu.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(ax);
        }
        d("200002");
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(s);
          this.jdField_a_of_type_JavaUtilArrayList.remove(ab);
          this.jdField_a_of_type_JavaUtilArrayList.remove(E);
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_hotchat_hongbao.name(), "1"));
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "reload(): showHongBao=" + bool + " type=" + i1);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reload(): iconList size[" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if (i1 != 3000) {
        break label1170;
      }
      b();
      this.jdField_a_of_type_JavaUtilArrayList.add(this.O);
      this.jdField_a_of_type_JavaUtilArrayList.add(an);
      if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aA);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(u);
      this.jdField_a_of_type_JavaUtilArrayList.add(g);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.S);
      this.jdField_a_of_type_JavaUtilArrayList.add(x);
      if (ScribbleResMgr.c(super.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_JavaUtilArrayList.add(B);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.aa);
      this.jdField_a_of_type_JavaUtilArrayList.add(Z);
      this.jdField_a_of_type_JavaUtilArrayList.add(z);
      this.jdField_a_of_type_JavaUtilArrayList.add(aj);
      if (bbal.a()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(G);
      }
      if ((amsx.a(super.getContext())) && (amsx.c("discuss") == 1)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(at);
      }
      if (((bebp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(283)).a().booleanValue())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ai);
        aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      if (!apzu.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ax);
      }
      label434:
      if (!llk.c())
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_e_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.O);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.P);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.Q);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.R);
        this.jdField_a_of_type_JavaUtilArrayList.remove(f);
      }
      if ((i1 != 0) && (i1 != 1025) && (i1 != 1024) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_e_of_type_ArrayOfInt);
      }
      if ((!this.jdField_c_of_type_Boolean) && (i1 == 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(Z);
        if (!bdgb.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(v);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(F) >= 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(F);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 10) {
            break label2273;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(F);
        }
      }
      label664:
      if ((i1 != 1) || (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label3175;
      }
    }
    label707:
    label2273:
    label3175:
    for (i1 = 1;; i1 = 0)
    {
      ArrayList localArrayList = new ArrayList();
      int i2 = 0;
      Object localObject3;
      if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        agjr localagjr = new agjr();
        Resources localResources;
        String str2;
        if ((i1 != 0) || (this.jdField_c_of_type_Boolean))
        {
          if ((arrayOfInt.length >= 3) && (this.jdField_a_of_type_AndroidUtilSparseArray != null))
          {
            TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(arrayOfInt[2]);
            if (localTroopAIOAppInfo != null)
            {
              localResources = BaseApplicationImpl.getContext().getResources();
              str2 = localTroopAIOAppInfo.name;
              for (;;)
              {
                for (;;)
                {
                  try
                  {
                    localObject1 = URLDrawable.URLDrawableOptions.obtain();
                    if ((arrayOfInt.length < 2) || (arrayOfInt[1] <= 0)) {
                      continue;
                    }
                    i3 = arrayOfInt[1];
                    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(i3);
                    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(i3);
                    if (!bdgb.b()) {
                      continue;
                    }
                    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
                      continue;
                    }
                    if (!TextUtils.isEmpty(localTroopAIOAppInfo.simpleNightUrl)) {
                      continue;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("PlusPanel", 2, "plusPanel reload simpleNightUrl is null!");
                    }
                    localObject1 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject1);
                    str1 = str2;
                    localObject4 = localObject1;
                    if (this.jdField_c_of_type_Boolean)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("PlusPanel", 2, "plusPanel reload useManageConfig = " + this.jdField_c_of_type_Boolean);
                      }
                      str1 = a(localTroopAIOAppInfo);
                      localObject4 = localObject1;
                    }
                  }
                  catch (Exception localException2)
                  {
                    Object localObject1;
                    int i3;
                    Object localObject2;
                    Object localObject4 = localResources.getDrawable(2130843635);
                    String str1 = str2;
                    continue;
                  }
                  localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject4);
                  localagjr.jdField_a_of_type_Int = arrayOfInt[1];
                  localagjr.jdField_b_of_type_Int = localTroopAIOAppInfo.appid;
                  localagjr.c = localTroopAIOAppInfo.redDotID;
                  localagjr.e = localTroopAIOAppInfo.actionType;
                  localagjr.d = localTroopAIOAppInfo.action;
                  localagjr.jdField_a_of_type_JavaLangString = a(str1, localTroopAIOAppInfo.appid);
                  if ((arrayOfInt == F) || (arrayOfInt == u) || (arrayOfInt == j) || (arrayOfInt == l) || (arrayOfInt == m)) {
                    localagjr.jdField_a_of_type_Boolean = localTroopAIOAppInfo.redPoint;
                  }
                  localagjr.jdField_b_of_type_JavaLangString = (localagjr.jdField_a_of_type_JavaLangString + anzj.a(2131707180));
                  localArrayList.add(localagjr);
                  if (localagjr.jdField_b_of_type_Int == 1104874204) {
                    this.jdField_a_of_type_Int = (i2 / 8);
                  }
                  i2 += 1;
                  break label707;
                  this.jdField_a_of_type_JavaUtilArrayList.clear();
                  break;
                  if (i1 == 1)
                  {
                    c(bool);
                    break label434;
                  }
                  if ((i1 == 1000) || (i1 == 1004))
                  {
                    if (!nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(v);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    if (!nmd.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(s);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(A);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if (i1 == 10004)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    break label434;
                  }
                  if (i1 == 1006)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    this.jdField_a_of_type_JavaUtilArrayList.add(A);
                    break label434;
                  }
                  if (i1 == 1020) {
                    break label434;
                  }
                  if (i1 == 1025)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    break label434;
                  }
                  if ((i1 == 1008) || (i1 == 1024))
                  {
                    localObject1 = (bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
                    if (((bkgt)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                    {
                      if (((bkgt)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                      }
                      this.jdField_a_of_type_JavaUtilArrayList.add(i);
                      this.jdField_a_of_type_JavaUtilArrayList.add(h);
                      break label434;
                    }
                    if (nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                    if (i1 == 1008)
                    {
                      localObject1 = ((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x20000000) != 0) && (ShortVideoUtils.jdField_a_of_type_Boolean) && (VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                      {
                        this.jdField_d_of_type_Boolean = true;
                        this.jdField_a_of_type_JavaUtilArrayList.add(this.M);
                      }
                      if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x10000000) != 0)) {
                        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.J);
                      }
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    break label434;
                  }
                  if ((i1 == 1005) || (i1 == 1003)) {
                    break label434;
                  }
                  if (i1 == 1001)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if (i1 == 10002)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if (i1 == 1010)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    break label434;
                  }
                  if (i1 == 1021)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_e_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    break label434;
                  }
                  if ((i1 == 1022) || (i1 == 1009) || (i1 == 1024) || (i1 == 1023)) {
                    break label434;
                  }
                  if (i1 == 6000)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    break label434;
                  }
                  if (i1 == 9501) {
                    try
                    {
                      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      localObject1 = (abur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                      if ((localObject1 == null) || (!((abur)localObject1).c(l1))) {
                        break label434;
                      }
                      this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    }
                    catch (Exception localException1)
                    {
                      localException1.printStackTrace();
                      long l1 = 0L;
                    }
                  }
                }
                if ((i1 == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
                {
                  if (bgpy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                    break label434;
                  }
                  l();
                  break label434;
                }
                if (bgpy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                  this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                  break label434;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(h);
                break label434;
                this.jdField_a_of_type_JavaUtilArrayList.add(10, F);
                break label664;
                i3 = 2130843635;
                continue;
                localObject2 = URLDrawable.getDrawable(localTroopAIOAppInfo.simpleNightUrl, localException1);
                continue;
                if (TextUtils.isEmpty(localTroopAIOAppInfo.simpleDayUrl))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PlusPanel", 2, "plusPanel reload simpleDayUrl is null!");
                  }
                  localObject2 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject2);
                }
                else
                {
                  localObject2 = URLDrawable.getDrawable(localTroopAIOAppInfo.simpleDayUrl, (URLDrawable.URLDrawableOptions)localObject2);
                  continue;
                  localObject2 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject2);
                }
              }
            }
          }
        }
        else if (arrayOfInt == w) {
          this.jdField_a_of_type_Int = (i2 / 8);
        }
        if (arrayOfInt[1] != 2130839156)
        {
          localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
          if (arrayOfInt.length >= 3) {
            localagjr.jdField_b_of_type_Int = arrayOfInt[2];
          }
          localagjr.jdField_a_of_type_Int = arrayOfInt[1];
          localagjr.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
          if ((i1 == 0) && (arrayOfInt == F)) {
            localagjr.jdField_a_of_type_JavaLangString = arfd.a().g();
          }
          localObject3 = (bcuy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          if (localObject3 != null)
          {
            if (((bcuy)localObject3).a("999999.100004") == -1) {
              break label2699;
            }
            bool = true;
          }
          label2557:
          if (this.jdField_b_of_type_Int != 7) {
            break label2705;
          }
          localObject3 = "chat_tool_gift_stranger_clicked";
          if ((arrayOfInt != al) || (!a("chat_tool_dingyue"))) {
            break label2713;
          }
          localagjr.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + anzj.a(2131707188));
          if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (arrayOfInt != jdField_a_of_type_ArrayOfInt) {
              break label2996;
            }
            localagjr.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131689998);
          }
        }
        for (;;)
        {
          localArrayList.add(localagjr);
          break;
          localagjr.jdField_a_of_type_AndroidGraphicsDrawableDrawable = aiay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
          break label2457;
          bool = false;
          break label2557;
          localObject3 = "chat_tool_gift_clicked";
          break label2571;
          if (((arrayOfInt == s) && (a("chat_tool_qwallettransfer"))) || ((arrayOfInt == ai) && (a("chat_tool_tencentdoc"))) || ((arrayOfInt == x) && (a("chat_tool_qfav"))) || ((arrayOfInt == at) && (a("chat_tool_apollo"))) || ((arrayOfInt == E) && (a("chat_tool_poke"))) || ((arrayOfInt == w) && (a((String)localObject3))) || ((arrayOfInt == B) && (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
            break label2589;
          }
          if (arrayOfInt == I)
          {
            if (ShortVideoUtils.f) {
              break label2589;
            }
            bool = ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ShortVideoUtils.f = true;
            if (!bool) {
              break label2589;
            }
            break label2589;
          }
          if (arrayOfInt == F)
          {
            localagjr.jdField_a_of_type_Boolean = aiay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
            break label2589;
          }
          if (arrayOfInt == j)
          {
            if (i1 != 0) {
              break label2589;
            }
            localagjr.jdField_a_of_type_Boolean = awml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false);
            break label2589;
          }
          if (arrayOfInt == l)
          {
            if (i1 == 0) {
              break label2589;
            }
            localagjr.jdField_a_of_type_Boolean = bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false);
            break label2589;
          }
          if (arrayOfInt == m) {
            break label2589;
          }
          localagjr.jdField_a_of_type_Boolean = false;
          break label2589;
          if (arrayOfInt == this.K) {
            localagjr.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131689995);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(null);
      if (i1 != 0)
      {
        localObject3 = (bgqm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(((bgqm)localObject3).a());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount());
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
          post(new PlusPanel.1(this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.d("PlusPanel", 2, "e=" + localException3);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", zok.a(5) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(paramInt);
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      agjr localagjr = (agjr)localIterator.next();
      a(localagjr, localbbav);
      switch (localagjr.jdField_b_of_type_Int)
      {
      default: 
      case 1106717414: 
      case 1106729451: 
      case 101458937: 
        for (;;)
        {
          label156:
          if (localagjr.jdField_a_of_type_Int == 2130839156)
          {
            bdll.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            bhju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "Grp_chain", "ChainEntry_Show");
            continue;
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            bhju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "MassMessage", "grpapp_Show");
            continue;
            localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            if (localObject == null) {
              break label434;
            }
          }
        }
      }
    }
    label434:
    for (localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = "" + ((TroopInfo)localObject).dwGroupClassExt;; localObject = "")
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
        break label156;
        break;
        if (paramInt == this.jdField_a_of_type_Int) {
          TroopGiftPanel.a(paramInt, this.jdField_b_of_type_Int);
        }
        return;
      }
    }
  }
  
  void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt == 10) {
      bhoo.b(paramBoolean);
    }
    ahxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
  }
  
  protected void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368258));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368235));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    a(this);
    paramBaseChatPie = getResources().getDrawable(2130850268);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      ((BitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
        break label207;
      }
      this.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      a();
      return;
      if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
        break;
      }
      ((SkinnableBitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((SkinnableBitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
      break;
      label207:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijm)) {
        this.jdField_b_of_type_Int = 2;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aijc)) {
        this.jdField_b_of_type_Int = 6;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aipm)) {
        this.jdField_b_of_type_Int = 7;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aimx)) {
        this.jdField_b_of_type_Int = 3;
      }
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gaudio_new")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_poke")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gift_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gift_stranger_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_tencentdoc")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bC();
      }
    }
    else
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label35;
      }
      if (!QLog.isColorLevel()) {}
    }
    label35:
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
      for (int i1 = 1; i1 == 0; i1 = 0)
      {
        QQToast.a(getContext(), aqzo.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
    } while ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || ((TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(1106865772) == null) || (TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")));
    String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", axwz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent();
    localIntent.putExtra("url", str);
    localIntent.putExtra("confess_half_screen_web", true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      this.jdField_e_of_type_Boolean = aqzo.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    b(1106865772);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i1 = ahnt.b(paramQQAppInterface, 0);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i1 == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(ahnt.jdField_a_of_type_JavaLangString, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + " getPokeMsgFoldSwitch=" + i1 + " hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public void b()
  {
    if (bdgb.b())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.K);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1106717414)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      bhju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    bhju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "MassMessage", "grpapp_Clk");
  }
  
  public void c()
  {
    if (bdgb.b())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
    }
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void f()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void g()
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      i1 = 1;
      if (i1 != 0) {
        break label83;
      }
    }
    label83:
    do
    {
      do
      {
        try
        {
          BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
          Resources localResources = localBaseActivity.getResources();
          bhlq.a(localBaseActivity, 230, localResources.getString(2131691467), localResources.getString(2131695243), 0, 2131695013, new agjq(this), null).show();
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.i("PlusPanel", 1, "clickToolShareScreen", localThrowable);
          return;
        }
        i1 = 0;
        break;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        a(10, false, "AIOShareScreen");
        mvd.a("0X800AD8E", 2);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
        d();
        agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, "AIOShareScreen", null);
        mvd.a("0X800AD8E", 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PlusPanel", 2, "clickToolShareScreen, not support chat, [" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "]");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    long l1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        a(10, true, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break;
      }
      a("chat_tool_gaudio");
      a(1, true, null);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
      if (!aoat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131693944));
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
        for (String str = "0";; str = "1")
        {
          bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "1", "", "");
          return;
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!asam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131693944));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.au();
    agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004086", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    long l1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        a(10, false, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break;
      }
      a("chat_tool_gaudio");
      a(1, false, null);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
      if (!aoat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131693943));
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
        for (String str = "0";; str = "1")
        {
          bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "0", "", "");
          return;
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!asam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131693943));
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
      return;
    }
    a("chat_tool_audio");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)
    {
      if (((bkgt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
        return;
      }
      if (nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        nok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOBottomButtonEngineFalse");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407B", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131695095, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011));
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "Don't support ivr");
        continue;
        agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
      }
    }
  }
  
  public void j()
  {
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmxc == null)
    {
      QLog.e("PlusPanel", 2, "AV_GAME_MANAGER NULL");
      return;
    }
    if (localmxc.a()) {}
    for (int i1 = 1;; i1 = 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        if (nhv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localmxc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B015", "0X800B015", i1, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        localmxc.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
        d();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B014", "0X800B014", i1, 0, "", "", "", "");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PlusPanel", 2, "click gotoAvGame, not support chat, [" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "]");
      return;
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    agjm localagjm = (agjm)paramView.getTag();
    int i4 = localagjm.jdField_a_of_type_Int;
    int i5 = localagjm.jdField_b_of_type_Int;
    int i1 = 0;
    if (a())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      int i3;
      boolean bool;
      Object localObject2;
      try
      {
        Object localObject1 = abur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if (localObject1 != null) {
          i1 = ((DeviceInfo)localObject1).productId;
        }
        i2 = i1;
        if (!TextUtils.isEmpty(localagjm.c))
        {
          localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          ((bbav)localObject1).a(((bbav)localObject1).a(10, localagjm.c), "");
        }
        if (i5 > 0)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            i1 = 1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
              continue;
            }
            i3 = 1;
            bool = b();
            if (i1 == 0) {
              continue;
            }
            i1 = 1;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!localagjm.jdField_a_of_type_Boolean) {
              continue;
            }
            i3 = 1;
            bdll.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A46C", "0X800A46C", i5, i3, String.valueOf(i1), "", "", "");
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bh();
          if (!"web".equals(localagjm.jdField_b_of_type_JavaLangString)) {
            continue;
          }
          b(localagjm.jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception localException1)
      {
        i2 = 0;
        continue;
        i1 = 0;
        continue;
        i3 = 0;
        continue;
        if (i3 != 0)
        {
          i1 = 2;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          i1 = 3;
          continue;
        }
        if (bool)
        {
          i1 = 4;
          continue;
        }
        i1 = 5;
        continue;
        i3 = 0;
        continue;
        if ("miniapp".equals(localagjm.jdField_b_of_type_JavaLangString))
        {
          c(localagjm.jdField_a_of_type_JavaLangString);
          break;
        }
        localObject2 = (abur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        switch (i4)
        {
        default: 
          if (!a(localagjm)) {
            break label7843;
          }
        }
      }
      label853:
      Object localObject6;
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
          {
            localObject2 = null;
            label899:
            localObject6 = (bgqm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
            if ((localObject2 != null) && (((TroopAIOAppInfo)localObject2).redPoint))
            {
              bflw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((TroopAIOAppInfo)localObject2).appid);
              ThreadManager.post(new PlusPanel.4(this, (bgqm)localObject6, (TroopAIOAppInfo)localObject2), 8, null, false);
            }
            if ((localObject2 == null) || (!((TroopAIOAppInfo)localObject2).canRemove)) {
              break label7872;
            }
            bool = true;
            label976:
            a(i4, localagjm.jdField_b_of_type_Int, bool);
            if (localObject6 == null) {
              break;
            }
            ((bgqm)localObject6).a(localagjm.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u(24);
            continue;
            if ((bdgb.b()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aipj)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(6));
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanel", 2, "pluspanel onclick called with plus from simple!");
              }
              if (bdgb.b()) {
                bdll.b(null, "dc00898", "", "", "0X800A114", "0X800A114", 0, 0, "", "", "", "");
              }
              if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aipj)) {
                continue;
              }
              bdll.b(null, "dc00898", "", "", "0X800A488", "0X800A488", 0, 0, "", "", "", "");
              continue;
            }
            agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i2, 0);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
            if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
            {
              bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 230).setMessage(anzj.a(2131707181)).setPositiveButton(2131694098, new agjn(this)).show();
              continue;
            }
            if (!BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x(2);
            continue;
            if ((bdgb.b()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aipj)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(4));
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanel", 2, "report() called with plus from simple!");
              }
              if (bdgb.b()) {
                bdll.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
              }
              if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aipj)) {
                continue;
              }
              bdll.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.au();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
            {
              localObject2 = new Intent();
              if (localObject2 != null) {
                if (aiit.W) {
                  break label1762;
                }
              }
              label1581:
              label1762:
              for (bool = true;; bool = false)
              {
                ((Intent)localObject2).putExtra("isdevicesupportmultiupload", bool);
                agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, (Intent)localObject2);
                achd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i2);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                {
                  localObject2 = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                  if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
                    ((aoip)localObject2).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
                }
                aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
                  achd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i2);
                }
                if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                break;
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break label8018;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("filter_photolist_troopalbum_toolbar", true);
          }
        }
      }
      for (;;)
      {
        agju.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject2);
        break label1581;
        if (QLog.isColorLevel()) {
          QLog.i("testing", 2, "deliver flowers!");
        }
        if (i5 == 213) {}
        for (;;)
        {
          long l1;
          for (;;)
          {
            for (;;)
            {
              try
              {
                localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "C2CPlusGiftJumpUrl", "https://h5.qzone.qq.com/giftv2/sendDialog?_wv=16781315&_wwv=13&_proxy=1&themeMode={themeMode}&uin={uin}");
                if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                  continue;
                }
                i1 = 1;
                localObject2 = ((String)localObject2).replace("{uin}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).replace("{themeMode}", i1 + "");
                localObject6 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQTranslucentBrowserActivity.class);
                ((Intent)localObject6).putExtra("url", (String)localObject2);
                ((Intent)localObject6).setData(Uri.parse((String)localObject2));
                ((Intent)localObject6).putExtra("flag_show_loading_dialog", true);
                ((Intent)localObject6).putExtra("hide_left_button", true);
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject6);
                bool = false;
              }
              catch (Exception localException2)
              {
                QLog.e("PlusPanel", 2, localException2, new Object[0]);
                bool = false;
                continue;
              }
              Object localObject3;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aimx))
              {
                localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
                {
                  localObject2 = "3";
                  aocz.a("gift_aio", "clk_icon", (String)localObject6, (String)localObject2, "", "");
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "qq_gift", "plus_entry_clk", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
                  if (QLog.isColorLevel()) {
                    QLog.d("PlusPanel", 2, "PlusPanel onGiftClick, aioType=" + this.jdField_b_of_type_Int);
                  }
                  if (this.jdField_b_of_type_Int != 7) {
                    break label2624;
                  }
                  localObject2 = "chat_tool_gift_stranger_clicked";
                  a((String)localObject2);
                  d();
                  break label853;
                  i1 = 0;
                  continue;
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.o(true);
                  l1 = System.currentTimeMillis();
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                  if (localObject3 == null) {
                    break label8012;
                  }
                  long l2 = ((aawm)localObject3).jdField_a_of_type_Long;
                  if ((!((aawm)localObject3).jdField_a_of_type_Boolean) || (l1 < ((aawm)localObject3).jdField_a_of_type_Long) || (l1 > l2 + 2592000000L) || (((bgsu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a())) {
                    break label8012;
                  }
                  bool = true;
                  continue;
                }
                localObject3 = "0";
                continue;
              }
              if (this.jdField_b_of_type_Int == 2) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 6) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 7) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 1) {
                if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                {
                  bdll.b(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                }
                else
                {
                  bdll.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + bool, "", "");
                  continue;
                  label2624:
                  localObject3 = "chat_tool_gift_clicked";
                  continue;
                  if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()))
                  {
                    CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), null);
                    break;
                  }
                  new awqg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();
                  break label853;
                  h();
                  break label853;
                  if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ainh)) {
                    break label853;
                  }
                  ((ainh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).n.performClick();
                  break label853;
                  i();
                  break label853;
                  try
                  {
                    k();
                  }
                  catch (Exception localException3)
                  {
                    QLog.d("PlusPanel", 1, "showTroopCourseActionSheet() func call Exception", localException3);
                  }
                }
              }
            }
            break label853;
            try
            {
              b(false);
            }
            catch (Exception localException4)
            {
              QLog.d("PlusPanel", 1, "handleTroopLiveOrTroopCourseClick Exception", localException4);
            }
          }
          break label853;
          a("chat_tool_tencentdoc");
          d();
          becb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
          {
            aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break label853;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break label853;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label853;
          }
          aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break label853;
          a("chat_tool_tencentdoc");
          d();
          becb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label853;
          }
          Object localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (localObject4 != null) {}
          for (localObject4 = ((TroopManager)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject5 = null)
          {
            if (localObject4 != null) {}
            for (localObject4 = "" + ((TroopInfo)localObject4).dwGroupClassExt;; localObject5 = "")
            {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009E25", "0X8009E25", 0, 0, "", "", "" + (String)localObject4, "");
              break label853;
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()))
              {
                CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), new agjo(this, (abur)localObject4));
                break;
              }
              a((abur)localObject4);
              break label853;
              a("chat_tool_qlink_file");
              d();
              aunj.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
              break label853;
              i1 = 1;
              if (this.jdField_c_of_type_Long == -1L)
              {
                label3233:
                if (i1 == 0) {
                  break label3302;
                }
                aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                this.jdField_c_of_type_Long = System.currentTimeMillis();
              }
              for (;;)
              {
                aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004081", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                break;
                if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 10000L) {
                  break label3233;
                }
                i1 = 0;
                break label3233;
                label3302:
                QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131707186), 0).a();
              }
              localObject4 = new Bundle();
              ((Bundle)localObject4).putInt("forward_type", 23);
              ((Bundle)localObject4).putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              ((Bundle)localObject4).putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              ((Bundle)localObject4).putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              ((Bundle)localObject4).putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
              ((Bundle)localObject4).putBoolean("only_single_selection", true);
              localObject6 = new Intent();
              ((Intent)localObject6).putExtras((Bundle)localObject4);
              auxu.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (Intent)localObject6, 21);
              aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80056B3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8007010", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break label853;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
                break;
              }
              localObject4 = niz.a().a("aio_qqMusicShare", "");
              agju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject4);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004083", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break label853;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
              {
                i3 = 2;
                i2 = 0;
              }
              for (;;)
              {
                label3598:
                if (i3 == 0) {
                  break label7996;
                }
                if (i2 != 0)
                {
                  localObject4 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  if (((TroopInfo)localObject4).isTroopOwner((String)localObject6)) {
                    i1 = 0;
                  }
                }
                for (;;)
                {
                  label3652:
                  awml.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), i3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                  if ((i2 == 0) && (awml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false)))
                  {
                    awml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", false, false);
                    d();
                  }
                  if (i2 == 0) {}
                  for (localObject4 = "c2c_AIO";; localObject4 = "Grp_AIO")
                  {
                    bdll.b(null, "dc00899", (String)localObject4, "", "music_tab", "clk_panelmusic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1 + "", i1 + "", "");
                    break;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                      break label7990;
                    }
                    i3 = 1;
                    i2 = 1;
                    break label3598;
                    if (((TroopInfo)localObject4).isTroopAdmin((String)localObject6))
                    {
                      i1 = 1;
                      break label3652;
                    }
                    i1 = 2;
                    break label3652;
                  }
                  localObject4 = null;
                  i1 = -1;
                  i2 = -1;
                  localObject6 = new Bundle();
                  Object localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  Object localObject7 = (bejx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
                  bool = ((bejx)localObject7).a(4, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    i2 = 0;
                    localObject4 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    if (localObject4 == null) {
                      break;
                    }
                    localObject6 = bekk.a(bool, ((TroopInfo)localObject4).isTroopOwner((String)localObject8), ((TroopInfo)localObject4).isAdmin(), ((TroopInfo)localObject4).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                    ((bejx)localObject7).a("sing_tab", "clk_panelsing", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    i1 = 1;
                    localObject4 = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
                  }
                  for (;;)
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      break label4083;
                    }
                    break;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                    {
                      localObject6 = bekk.a(bool, 3);
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                      i2 = 3;
                      i1 = 2;
                      localObject4 = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                    }
                  }
                  label4083:
                  if (bool)
                  {
                    ((bejx)localObject7).b(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1, 4, i2, (Bundle)localObject6);
                    break label853;
                  }
                  ((bejx)localObject7).a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1, 4, i2, (Bundle)localObject6);
                  break label853;
                  if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
                    break;
                  }
                  localObject4 = (arjl)aran.a().a(535);
                  if ((localObject4 == null) || (((arjl)localObject4).a == null))
                  {
                    QQToast.a(getContext(), 0, 2131692838, 0).a();
                    break;
                  }
                  localObject6 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if (localObject6 == null) {
                    break;
                  }
                  localObject7 = (bejx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
                  bool = ((bejx)localObject7).a(2, 1, ((TroopInfo)localObject6).uin);
                  localObject8 = bekk.a(bool, ((TroopInfo)localObject6).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject6).isAdmin(), ((TroopInfo)localObject6).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                  switch (((arjl)localObject4).a.a())
                  {
                  default: 
                    if (((bejx)localObject7).a(getContext(), 2, ((TroopInfo)localObject6).troopuin, 0)) {
                      if (QLog.isColorLevel()) {
                        QLog.d("PlusPanel", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
                      }
                    }
                    break;
                  }
                  while (bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
                  {
                    bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
                    d();
                    break;
                    QQToast.a(getContext(), 0, 2131692838, 0).a();
                    continue;
                    if (!((TroopInfo)localObject6).isAdmin())
                    {
                      if (bool) {
                        ((bejx)localObject7).b(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                      } else {
                        ((bejx)localObject7).a(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                      }
                    }
                    else if (bool)
                    {
                      ((bejx)localObject7).b(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                    }
                    else
                    {
                      ((bejx)localObject7).a(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                      continue;
                      ((bejx)localObject7).a("video_tab", "clk_panelvideo", 0, ((TroopInfo)localObject6).troopuin);
                      bekk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((arjl)localObject4).a.b(), ((arjl)localObject4).a.a(), ((arjl)localObject4).a.b(), (Bundle)localObject8, 1);
                    }
                  }
                  aarg.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "200002", "https://m.dianping.com/qq/aiodwonload", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  aarg.a("200002", "click_app", "", "", "");
                  aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB2", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label853;
                  bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0");
                  aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label853;
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  ((Bundle)localObject4).putBoolean("hide_operation_bar", true);
                  ((Bundle)localObject4).putBoolean("hide_more_button", true);
                  ((Bundle)localObject4).putBoolean("isScreenOrientationPortrait", true);
                  bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (Bundle)localObject4);
                  aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label853;
                  if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    behz.a().b(true);
                    a("chat_tool_anonymous");
                    d();
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))
                    {
                      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(2, "");
                      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      bdll.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
                      aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                      break label853;
                    }
                    break;
                  }
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))
                  {
                    ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).w(false);
                    behz.a().b(false);
                    bdll.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
                    break label853;
                  }
                  break;
                  if (!nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label853;
                  }
                  localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  localObject6 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if ((localObject6 != null) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
                    if ((((TroopInfo)localObject6).Administrator != null) && (((TroopInfo)localObject6).Administrator.contains((CharSequence)localObject4))) {
                      i1 = 3;
                    }
                  }
                  for (;;)
                  {
                    label5121:
                    localObject4 = nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    localObject6 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    localObject7 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&avatar=").append(nlj.a(((nll)localObject4).jdField_a_of_type_Int)).append("&nick=");
                    if (TextUtils.isEmpty(((nll)localObject4).jdField_a_of_type_JavaLangString)) {}
                    for (localObject4 = "";; localObject4 = URLEncoder.encode(((nll)localObject4).jdField_a_of_type_JavaLangString))
                    {
                      ((Intent)localObject6).putExtra("url", (String)localObject4 + "&role=" + String.valueOf(i1) + "&self=1");
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject6);
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(i1), "", "");
                      break;
                      if (((String)localObject4).equals(((TroopInfo)localObject6).troopowneruin))
                      {
                        i1 = 2;
                        break label5121;
                      }
                      i1 = 1;
                      break label5121;
                    }
                    a("chat_tool_qwallettransfer");
                    d();
                    localObject6 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TransactionActivity.class);
                    ((Intent)localObject6).putExtra("come_from", 2);
                    i2 = 0;
                    i1 = 0;
                    localObject4 = null;
                    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
                    {
                    }
                    for (;;)
                    {
                      localObject7 = new JSONObject();
                      try
                      {
                        ((JSONObject)localObject7).put("targetUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        ((JSONObject)localObject7).put("targetNickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
                        ((JSONObject)localObject7).put("sign", "");
                        if (i2 != 0) {
                          ((JSONObject)localObject7).put("source", i2);
                        }
                        ((JSONObject)localObject7).put("group_type", i1);
                        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                          ((JSONObject)localObject7).put("group_uin", localObject4);
                        }
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          localJSONException.printStackTrace();
                        }
                      }
                      ((Intent)localObject6).putExtra("extra_data", ((JSONObject)localObject7).toString());
                      ((Intent)localObject6).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
                      ((Intent)localObject6).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 0, null));
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject6);
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
                      aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB0", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                      break;
                      i2 = 5;
                      i1 = 3;
                      localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
                      continue;
                      i2 = 5;
                      i1 = 4;
                      localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
                    }
                    abvy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
                      break label853;
                    }
                    achd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 4, 0, i2);
                    break label853;
                    l1 = System.currentTimeMillis();
                    if (Math.abs(l1 - this.jdField_a_of_type_Long) < 1000L) {
                      break;
                    }
                    this.jdField_a_of_type_Long = l1;
                    d();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u(10);
                      agju.a(0);
                    }
                    localObject5 = "";
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008)) {
                      localObject5 = "entrance.click.c2c.plus";
                    }
                    for (;;)
                    {
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject5, 0, 0, "", "", "", "");
                      break;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                        localObject5 = "entrance.click.group.plus";
                      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        localObject5 = "entrance.click.chatgroup.plus";
                      }
                    }
                    a("chat_tool_qfav");
                    d();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
                      break label853;
                    }
                    agju.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
                    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label853;
                    a("chat_tool_dingyue");
                    d();
                    localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    ((Intent)localObject5).putExtra("url", "https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
                    break label853;
                    a("chat_tool_toupiao");
                    d();
                    localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    ((Intent)localObject5).putExtra("selfSet_leftViewText", anzj.a(2131707179));
                    ((Intent)localObject5).putExtra("url", "https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&src=3");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
                    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB9", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label853;
                    localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    ((Intent)localObject5).putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793&f=6&uintype=3000&touin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    ((Intent)localObject5).putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
                    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBB", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label853;
                    localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    ((Intent)localObject5).putExtra("url", "https://mqq.tenpay.com/mqq/groupreceipts/index.shtml?type=4&_wv=1027&_wvx=4");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                    break label853;
                    localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    ((Intent)localObject5).putExtra("url", "https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&state=1");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                    break label853;
                    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localagjm.jdField_b_of_type_Int) < 0)) {
                      break label853;
                    }
                    localObject5 = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localagjm.jdField_b_of_type_Int);
                    localObject6 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    if ((localObject5 == null) || (((TroopAIOAppInfo)localObject5).url == null)) {
                      break label853;
                    }
                    ((Intent)localObject6).putExtra("url", ((TroopAIOAppInfo)localObject5).url.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject6);
                    aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBA", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label853;
                    if (localObject5 == null) {
                      break label853;
                    }
                    localObject6 = abur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
                    if (localObject6 == null) {
                      break label853;
                    }
                    ((abur)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (DeviceInfo)localObject6, false);
                    break label853;
                    bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
                    a("chat_tool_apollo");
                    if (bool) {
                      d();
                    }
                    for (i1 = 1;; i1 = 0)
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.s(0);
                      }
                      localObject5 = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
                      localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                      i2 = ((amsx)localObject5).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                      i3 = ApolloUtil.h(amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                      localObject8 = "" + i1;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
                      for (localObject5 = "0";; localObject5 = "2")
                      {
                        VipUtils.a((AppInterface)localObject6, "cmshow", "Apollo", "panel_enter_clk", (String)localObject7, i2, i3, new String[] { localObject8, localObject5, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                        break;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
                      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
                      {
                        ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        d();
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bc();
                      break label853;
                      localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SharedPreferences)localObject5))
                      {
                        a("chat_tool_poke");
                        if (Build.VERSION.SDK_INT <= 8) {
                          break label7228;
                        }
                        ((SharedPreferences)localObject5).edit().putBoolean("chat_tool_poke_clicked", true).apply();
                      }
                      for (;;)
                      {
                        d();
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aD();
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8007F21");
                        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aihh)) {
                          break;
                        }
                        aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                        break;
                        label7228:
                        ((SharedPreferences)localObject5).edit().putBoolean("chat_tool_poke_clicked", true).commit();
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aN();
                      break label853;
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aE();
                      break label853;
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ba();
                      break label853;
                      if (bhsi.q(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                        TroopPicEffectsEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                      }
                      for (;;)
                      {
                        bhbg.a("app_entry", "page_clk");
                        break;
                        bhsi.z(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        localObject5 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TroopPicEffectGuidePicActivity.class);
                        ((Intent)localObject5).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        ((Intent)localObject5).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject5);
                      }
                      localObject5 = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localagjm.jdField_b_of_type_Int);
                      if (localObject5 == null) {
                        break label853;
                      }
                      localObject5 = zmw.a(null, ((TroopAIOAppInfo)localObject5).url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      localObject6 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), JumpActivity.class);
                      ((Intent)localObject6).setData(Uri.parse((String)localObject5));
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject6);
                      yup.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
                      break label853;
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
                      if (!bhnv.e(BaseApplicationImpl.getContext()))
                      {
                        QQToast.a(BaseApplicationImpl.getContext(), 2131691989, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011));
                        break label853;
                      }
                      if (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long < 5000L) {
                        a(false);
                      }
                      for (;;)
                      {
                        this.jdField_b_of_type_Boolean = true;
                        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
                        break;
                        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).g(anzj.a(2131707184));
                        ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
                      }
                      if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localagjm.jdField_b_of_type_Int) < 0)) {
                        break label853;
                      }
                      localObject5 = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localagjm.jdField_b_of_type_Int);
                      agkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((TroopAIOAppInfo)localObject5).url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 1);
                      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009FCD", "0X8009FCD", 0, 0, "", "", "", "");
                      break label853;
                      aiay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
                      d();
                      break label853;
                      g();
                      break label853;
                      j();
                      break label853;
                      label7843:
                      agkp.a(this, localagjm);
                      break label853;
                      localObject5 = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localagjm.jdField_b_of_type_Int);
                      break label899;
                      label7872:
                      bool = false;
                      break label976;
                      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002)) {
                        break;
                      }
                      localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
                      for (localObject5 = "0";; localObject5 = "1")
                      {
                        bdll.b((QQAppInterface)localObject6, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, (String)localObject5, a(i4), "", "");
                        break;
                      }
                    }
                    i1 = 0;
                  }
                  i1 = -1;
                }
                label7990:
                i3 = 0;
                i2 = 0;
              }
              label7996:
              break label853;
            }
          }
          label8012:
          bool = false;
        }
        label8018:
        Object localObject5 = null;
      }
      int i2 = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (((agjm)paramView.getTag()).jdField_a_of_type_Int)
    {
    }
    do
    {
      return false;
    } while ((!LightVideoConfigMgr.a().b()) || (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl == null));
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl.a(1);
    return true;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() - 1)
    {
      if (this.jdField_b_of_type_Int != 2) {
        break label80;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(paramInt);
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
      }
      return;
      label80:
      if (this.jdField_b_of_type_Int == 6) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      } else if (this.jdField_b_of_type_Int == 7) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void setAIOLongCaptureCtrlListener(AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = paramAIOLongCaptureCtrl;
  }
  
  public void setOneWayFriend(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      d();
    }
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != super.getVisibility()) {}
    for (int i1 = 1;; i1 = 0)
    {
      super.setVisibility(paramInt);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        if (i1 != 0) {
          a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */