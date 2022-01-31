package com.tencent.mobileqq.activity.aio;

import aabm;
import acex;
import aeox;
import aeoy;
import aeoz;
import aepa;
import aepb;
import aepc;
import aepf;
import aepw;
import afsw;
import agbu;
import agci;
import agcq;
import agiy;
import agkk;
import agkt;
import agld;
import agoj;
import agot;
import agqn;
import agqq;
import akji;
import alpo;
import alqx;
import alrh;
import alsy;
import aluw;
import alzf;
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
import anhp;
import aofk;
import aogj;
import aokc;
import aokd;
import aono;
import aooh;
import apds;
import arng;
import arnh;
import arni;
import arum;
import asps;
import atii;
import atmd;
import auso;
import awhs;
import axhe;
import axho;
import ayca;
import aywz;
import azib;
import azmj;
import azwu;
import badh;
import badt;
import bajq;
import baky;
import ball;
import batw;
import bbib;
import bbig;
import bcgx;
import bchl;
import bcjl;
import bcjs;
import bcju;
import bclo;
import bcsl;
import bdaj;
import bdcd;
import bdee;
import bdfc;
import bdfq;
import bdiv;
import bfua;
import bhpy;
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
import lnz;
import mqq.app.MobileQQ;
import mww;
import myl;
import nav;
import nax;
import nbp;
import ndv;
import org.json.JSONException;
import org.json.JSONObject;
import wta;
import xlh;
import xmv;
import ylr;
import yqv;
import zpa;
import zqh;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnLongClickListener
{
  public static final int[] A;
  public static final int[] B;
  public static int[] C;
  public static final int[] D;
  public static final int[] E;
  public static final int[] F;
  public static final int[] G = { 2131698789, 2130838055, 204 };
  private static final int[] X;
  private static final int[] Z;
  public static final int[] a;
  private static final int[] ab;
  private static final int[] ac;
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
  private static final int[] ar;
  private static final int[] as;
  private static final int[] at;
  private static final int[] au;
  private static final int[] av;
  private static final int[] aw;
  private static final int[] ax;
  private static final int[] ay = { 2131698789, 2130838055, 1107930043 };
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
  private final int[] H = { 2131698802, 2130838989 };
  private final int[] I = { 2131690810, 2130838967 };
  private final int[] J = { 2131720918, 2130838996 };
  private final int[] K = { 2131720918, 2130838996, 1104788673 };
  private final int[] L = { 2131691653, 2130839001 };
  private final int[] M = { 2131720912, 2130838960 };
  private final int[] N = { 2131720908, 2130838961, 100719166 };
  private final int[] O = { 2131720909, 2130838962, 101847385 };
  private final int[] P = { 2131720905, 2130838960, 1104651886 };
  private final int[] Q = { 2131690819, 2130838991, 1104864066 };
  private final int[] R = { 2131690821, 2130838997 };
  private final int[] S = { 2131690818, 2130838990 };
  private final int[] T = { 2131690813, 2130838976, 100729587 };
  private final int[] U = { 2131690812, 2130838975, 1106184014 };
  private final int[] V = { 2131690822, 2130838984 };
  private final int[] W = { 2131690820, 2130838993 };
  private final int[] Y = { 2131717706, 2130838958 };
  public int a;
  long jdField_a_of_type_Long;
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
  ylr jdField_a_of_type_Ylr = null;
  private boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_hongbao", "chat_tool_qwallettransfer" };
  protected final int[][] a;
  private final int[] aa = { 2131690823, 2130843348, 1104445552 };
  private final int[] aq = { 2131699007, 2130843283, 1106865772 };
  private final int[] az = { 2131690817, 2130843776, 1108961705 };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private final int[][] jdField_b_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, this.I, this.P, f, ay, s, this.N, ae, ab, this.Q, g, X, x, af, ak, ag, ar };
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private final int[][] jdField_c_of_type_Array2dOfInt = { jdField_a_of_type_ArrayOfInt, this.K, this.P, f, z, this.N, s, this.aq, ae, ab, this.Q, g, X, Z, x, af, ak, v, ah, this.aa, an, ao, at, E, aw, ax, ay, this.az, j, o, l, m, this.O };
  private boolean jdField_d_of_type_Boolean;
  private final int[][] jdField_d_of_type_Array2dOfInt = { e, jdField_d_of_type_ArrayOfInt, C, G, h, i, k, w, D, A, q, y, u, r, B, F, jdField_b_of_type_ArrayOfInt, jdField_c_of_type_ArrayOfInt, t, n, p };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131720913, 2130838988, 1104864054 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131720913, 2130838988, 217 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131690810, 2130838967, 218 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131698957, 2130839000, 202 };
    e = new int[] { 2131720898, 2130838960, 201 };
    f = new int[] { 2131720907, 2130839000, 1106658188 };
    g = new int[] { 2131720910, 2130838979, 1104864068 };
    h = new int[] { 2131720910, 2130838979, 205 };
    i = new int[] { 2131690816, 2130838991, 206 };
    X = new int[] { 2131694631, 2130838982, 1104864070 };
    j = new int[] { 2131693936, 2130838978, 101761547 };
    k = new int[] { 2131693936, 2130838978, 207 };
    l = new int[] { 2131698884, 2130839003, 101793773 };
    m = new int[] { 2131698858, 2130838998, 101817424 };
    n = new int[] { 2131698858, 2130838998, 220 };
    o = new int[] { 2131698856, 2130838995, 101850591 };
    p = new int[] { 2131698856, 2130838995, 221 };
    Z = new int[] { 2131691515, 2130842015 };
    ab = new int[] { 2131690095, 2130843233, 1101487426 };
    ac = new int[] { 2131692278, 2130843233 };
    ad = new int[] { 2131696534, 2130843240 };
    ae = new int[] { 2131689526, 2130842089, 1104864064 };
    af = new int[] { 2131689528, 2130842090, 1101678813 };
    q = new int[] { 2131717709, 2130838999, 211 };
    ag = new int[] { 2131698807, 2130838992 };
    r = new int[] { 2131698807, 2130838992, 214 };
    s = new int[] { 2131719746, 2130838977, 1104864062 };
    t = new int[] { 2131719746, 2130838977, 219 };
    u = new int[] { 2131697743, 2130850018, 213 };
    ah = new int[] { 2131697743, 2130850018, 1104874204 };
    ai = new int[] { 2131697671, 2130850009 };
    v = new int[] { 2131698785, 2130843736, 1104639410 };
    w = new int[] { 2131698785, 2130843736, 208 };
    aj = new int[] { 2131697745, 2130842098 };
    ak = new int[] { 2131698201, 2130842139, 1104536706 };
    al = new int[] { 2131698957, 2130839000 };
    am = new int[] { 2131693453, 2130842183 };
    an = new int[] { 2131691805, 2130838970, 1104823592 };
    ao = new int[] { 2131691742, 2130838959, 1105298834 };
    x = new int[] { 2131693830, 2130838955, 1104788679 };
    y = new int[] { 2131693830, 2130838955, 212 };
    ap = new int[] { 2131699403, 2130844980 };
    z = new int[] { 2131698805, 2130838088, 1106114157 };
    A = new int[] { 2131698805, 2130838088, 210 };
    ar = new int[] { 2131690379, 2130838325 };
    B = new int[] { 2131690379, 2130838325, 215 };
    C = new int[] { 2131698799, 2130838986, 203 };
    D = new int[] { 2131698794, 2130838981, 209 };
    as = new int[] { 2131698803, 2130838987 };
    E = new int[] { 2131698804, 2130838142, 1106189400 };
    F = new int[] { 2131698804, 2130838142, 216 };
    at = new int[] { 2131698134, 2130850019, 1106194086 };
    au = new int[] { 2131690797, 2130842243 };
    av = new int[] { 2131690239, 2130838543 };
    aw = new int[] { 2131698193, 2130842133, 1105981808 };
    ax = new int[] { 2131697710, 2130843263, 1106729451 };
  }
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.Q };
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.Q };
  }
  
  private Drawable a(String paramString, int paramInt, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = awhs.a(paramInt);
      if ((paramString != null) && (paramString.length >= 2)) {
        return BaseApplicationImpl.getContext().getResources().getDrawable(paramString[1]);
      }
    }
    else
    {
      return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130843243);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2130838960: 
      return "0";
    case 2130839000: 
      return "1";
    case 2130838991: 
      return "3";
    case 2130843736: 
      return "4";
    case 2130838979: 
      return "5";
    case 2130838977: 
      return "6";
    }
    return "7";
  }
  
  private String a(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    String str = paramTroopAIOAppInfo.name;
    switch (alrh.a())
    {
    default: 
      return str;
    case 2052: 
      return paramTroopAIOAppInfo.name;
    }
    return paramTroopAIOAppInfo.enName;
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = awhs.a(paramInt);
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
      }
      if ((paramBoolean) && (paramInt2 != 0)) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramInt2), "", "");
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
  
  private void a(aepc paramaepc, axho paramaxho)
  {
    int i4 = 0;
    if (!TextUtils.isEmpty(paramaepc.c))
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = paramaxho.a(10, paramaepc.c);
      if (localAppInfo != null) {
        paramaxho.b(localAppInfo, "");
      }
    }
    int i1;
    int i2;
    label127:
    int i3;
    label141:
    boolean bool;
    if ((paramaepc.jdField_b_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramaepc.jdField_b_of_type_Int))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramaepc.jdField_b_of_type_Int));
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
      paramaxho = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i3 = paramaepc.jdField_b_of_type_Int;
      i2 = i4;
      if (paramaepc.jdField_a_of_type_Boolean) {
        i2 = 1;
      }
      azmj.b(paramaxho, "dc00898", "", "", "0X800A46B", "0X800A46B", i3, i2, String.valueOf(i1), "", "", "");
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
                if ((!akji.a(getContext(), Boolean.valueOf(false))) || (akji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) <= 0)) {
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
  
  private void a(zpa paramzpa)
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (paramzpa != null) && (paramzpa.c(l1)))
        {
          aepf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramzpa = new arnh();
          paramzpa.jdField_b_of_type_JavaLangString = "send_file";
          paramzpa.jdField_a_of_type_Int = 1;
          arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramzpa);
          aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      return;
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
  
  private boolean a(aeox paramaeox)
  {
    if ((paramaeox != null) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(paramaeox.jdField_b_of_type_Int) >= 0)) {
      return aepw.a((TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramaeox.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramaeox);
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
    if (((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://"))) || (paramString.startsWith("https://")))
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
      int i1 = mww.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1);
      Object localObject = (bcjl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      boolean bool1 = ((bcjl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      boolean bool2 = ((bcjl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      boolean bool3 = ((bcjl)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = ((bcjl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((l1 == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((bcjs)localObject).jdField_a_of_type_Long > 0L))))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, alpo.a(2131708694), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
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
        azmj.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "1", "");
      }
      agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB5", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1021) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1022) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008);
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, paramString, 2053, null);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (((HotChatManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ap);
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
      while (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        b();
        this.jdField_a_of_type_JavaUtilArrayList.add(ac);
        if (!azwu.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(ai);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(ad);
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
        localObject1 = (bchl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
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
          localObject2 = bbib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bbig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
          localObject1 = localObject2;
          if (AudioHelper.d())
          {
            localObject1 = localObject2;
            if (AudioHelper.a(4) == 1)
            {
              AudioHelper.a(alpo.a(2131708681));
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
                  if ((arrayOfInt1 != z) || (ScribbleResMgr.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
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
      if (localObject2 != Z) {
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
      if ((localObject2 != z) || (ScribbleResMgr.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_Ylr == null)
    {
      this.jdField_a_of_type_Ylr = ylr.a();
      this.jdField_a_of_type_Ylr.b();
    }
    if (this.jdField_a_of_type_Ylr.a(paramString))
    {
      if (!"200002".equals(paramString)) {
        break label54;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Z);
    }
    label54:
    do
    {
      return;
      if ("0".equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aj);
        return;
      }
    } while (!"1".equals(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(ak);
  }
  
  private void j()
  {
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    localbhpy.b(2131697727);
    localbhpy.b(2131697728);
    localbhpy.c(2131690648);
    localbhpy.a(new aepa(this, localbhpy));
    localbhpy.show();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
  }
  
  private void k()
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
    if (nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(e);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      if (asps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(G);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i);
      this.jdField_a_of_type_JavaUtilArrayList.add(w);
      this.jdField_a_of_type_JavaUtilArrayList.add(h);
      this.jdField_a_of_type_JavaUtilArrayList.add(X);
      this.jdField_a_of_type_JavaUtilArrayList.add(y);
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
      return;
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(e);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(C);
        if (asps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(G);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(t);
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
        this.jdField_a_of_type_JavaUtilArrayList.add(i);
        this.jdField_a_of_type_JavaUtilArrayList.add(w);
        this.jdField_a_of_type_JavaUtilArrayList.add(X);
      }
      else
      {
        List localList = awhs.a(false);
        if ((localList != null) && (!localList.isEmpty()))
        {
          this.jdField_b_of_type_Boolean = true;
          a(localList);
          return;
        }
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(e);
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(C);
        if (asps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(G);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(t);
        if ((agcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (azib.b())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(D);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(h);
        this.jdField_a_of_type_JavaUtilArrayList.add(i);
        this.jdField_a_of_type_JavaUtilArrayList.add(k);
        if ((agcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (!azib.b())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(D);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(w);
        if (ScribbleResMgr.c(super.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          this.jdField_a_of_type_JavaUtilArrayList.add(A);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(X);
        this.jdField_a_of_type_JavaUtilArrayList.add(q);
        this.jdField_a_of_type_JavaUtilArrayList.add(y);
        this.jdField_a_of_type_JavaUtilArrayList.add(u);
        if (axhe.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(F);
        }
        if (((badh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(283)).a().booleanValue())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(r);
          agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        if ((akji.a(getContext(), Boolean.valueOf(false))) && (akji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) > 0)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(B);
        }
        if (!anhp.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(av);
        }
        d("200002");
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(q);
          this.jdField_a_of_type_JavaUtilArrayList.remove(Z);
          this.jdField_a_of_type_JavaUtilArrayList.remove(C);
        }
      }
    }
  }
  
  public DeviceInfo a(long paramLong)
  {
    zpa localzpa = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localzpa != null) {
      return localzpa.a(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
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
        break label1176;
      }
      b();
      this.jdField_a_of_type_JavaUtilArrayList.add(this.M);
      this.jdField_a_of_type_JavaUtilArrayList.add(al);
      if (asps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ay);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(s);
      this.jdField_a_of_type_JavaUtilArrayList.add(g);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.Q);
      this.jdField_a_of_type_JavaUtilArrayList.add(v);
      if (ScribbleResMgr.c(super.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_JavaUtilArrayList.add(z);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.Y);
      this.jdField_a_of_type_JavaUtilArrayList.add(X);
      this.jdField_a_of_type_JavaUtilArrayList.add(x);
      this.jdField_a_of_type_JavaUtilArrayList.add(ah);
      if (axhe.a()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(E);
      }
      if ((akji.a(super.getContext())) && (akji.c("discuss") == 1)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ar);
      }
      if (((badh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(283)).a().booleanValue())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ag);
        agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      if (!anhp.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(av);
      }
      label434:
      if ((!lnz.c()) || (!lnz.d()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.remove(e);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.M);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.N);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.O);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.P);
        this.jdField_a_of_type_JavaUtilArrayList.remove(f);
      }
      if ((i1 != 0) && (i1 != 1025) && (i1 != 1024) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(jdField_d_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.remove(e);
      }
      if ((!this.jdField_b_of_type_Boolean) && (i1 == 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(X);
        if (!azib.a()) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(t);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(D) >= 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(D);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 10) {
            break label2279;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(D);
        }
      }
      label670:
      if ((i1 != 1) || (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label3181;
      }
    }
    label713:
    label2279:
    label3181:
    for (i1 = 1;; i1 = 0)
    {
      ArrayList localArrayList = new ArrayList();
      int i2 = 0;
      Object localObject3;
      if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        aepc localaepc = new aepc();
        Resources localResources;
        String str2;
        if ((i1 != 0) || (this.jdField_b_of_type_Boolean))
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
                    if (!azib.b()) {
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
                    if (this.jdField_b_of_type_Boolean)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("PlusPanel", 2, "plusPanel reload useManageConfig = " + this.jdField_b_of_type_Boolean);
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
                    Object localObject4 = localResources.getDrawable(2130843243);
                    String str1 = str2;
                    continue;
                  }
                  localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject4);
                  localaepc.jdField_a_of_type_Int = arrayOfInt[1];
                  localaepc.jdField_b_of_type_Int = localTroopAIOAppInfo.appid;
                  localaepc.c = localTroopAIOAppInfo.redDotID;
                  localaepc.e = localTroopAIOAppInfo.actionType;
                  localaepc.d = localTroopAIOAppInfo.action;
                  localaepc.jdField_a_of_type_JavaLangString = a(str1, localTroopAIOAppInfo.appid);
                  if ((arrayOfInt == D) || (arrayOfInt == s) || (arrayOfInt == j) || (arrayOfInt == l) || (arrayOfInt == m)) {
                    localaepc.jdField_a_of_type_Boolean = localTroopAIOAppInfo.redPoint;
                  }
                  localaepc.jdField_b_of_type_JavaLangString = (localaepc.jdField_a_of_type_JavaLangString + alpo.a(2131708683));
                  localArrayList.add(localaepc);
                  if (localaepc.jdField_b_of_type_Int == 1104874204) {
                    this.jdField_a_of_type_Int = (i2 / 8);
                  }
                  i2 += 1;
                  break label713;
                  this.jdField_a_of_type_JavaUtilArrayList.clear();
                  break;
                  if (i1 == 1)
                  {
                    c(bool);
                    break label434;
                  }
                  if ((i1 == 1000) || (i1 == 1004))
                  {
                    if (!nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(t);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    if (!nbp.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(q);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    this.jdField_a_of_type_JavaUtilArrayList.add(u);
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
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    this.jdField_a_of_type_JavaUtilArrayList.add(y);
                    break label434;
                  }
                  if (i1 == 1020) {
                    break label434;
                  }
                  if (i1 == 1025)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(e);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if ((i1 == 1008) || (i1 == 1024))
                  {
                    localObject1 = (bfua)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
                    if (((bfua)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                    {
                      if (((bfua)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_JavaUtilArrayList.add(e);
                        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                      }
                      this.jdField_a_of_type_JavaUtilArrayList.add(i);
                      this.jdField_a_of_type_JavaUtilArrayList.add(h);
                      break label434;
                    }
                    if (ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(e);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                    if (i1 == 1008)
                    {
                      localObject1 = ((aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x20000000) != 0) && (ShortVideoUtils.jdField_a_of_type_Boolean) && (VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                      {
                        this.jdField_c_of_type_Boolean = true;
                        this.jdField_a_of_type_JavaUtilArrayList.add(this.K);
                      }
                      if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x10000000) != 0)) {
                        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.H);
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
                    this.jdField_a_of_type_JavaUtilArrayList.add(e);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    this.jdField_a_of_type_JavaUtilArrayList.add(u);
                    break label434;
                  }
                  if (i1 == 10002)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    this.jdField_a_of_type_JavaUtilArrayList.add(u);
                    break label434;
                  }
                  if (i1 == 1010)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(e);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(u);
                    this.jdField_a_of_type_JavaUtilArrayList.add(h);
                    break label434;
                  }
                  if (i1 == 1021)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(e);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if ((i1 == 1022) || (i1 == 1009) || (i1 == 1024) || (i1 == 1023)) {
                    break label434;
                  }
                  if (i1 == 6000)
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(i);
                    this.jdField_a_of_type_JavaUtilArrayList.add(w);
                    break label434;
                  }
                  if (i1 == 9501) {
                    try
                    {
                      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      localObject1 = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                      if ((localObject1 == null) || (!((zpa)localObject1).c(l1))) {
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
                  if (bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                    break label434;
                  }
                  k();
                  break label434;
                }
                if (bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
                  this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
                  break label434;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(h);
                break label434;
                this.jdField_a_of_type_JavaUtilArrayList.add(10, D);
                break label670;
                i3 = 2130843243;
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
        else if (arrayOfInt == u) {
          this.jdField_a_of_type_Int = (i2 / 8);
        }
        if (arrayOfInt[1] != 2130838981)
        {
          localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
          if (arrayOfInt.length >= 3) {
            localaepc.jdField_b_of_type_Int = arrayOfInt[2];
          }
          localaepc.jdField_a_of_type_Int = arrayOfInt[1];
          localaepc.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
          if ((i1 == 0) && (arrayOfInt == D)) {
            localaepc.jdField_a_of_type_JavaLangString = aokd.a().g();
          }
          localObject3 = (aywz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          if (localObject3 != null)
          {
            if (((aywz)localObject3).a("999999.100004") == -1) {
              break label2705;
            }
            bool = true;
          }
          if (this.jdField_b_of_type_Int != 7) {
            break label2711;
          }
          localObject3 = "chat_tool_gift_stranger_clicked";
          if ((arrayOfInt != aj) || (!a("chat_tool_dingyue"))) {
            break label2719;
          }
          localaepc.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + alpo.a(2131708691));
          if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (arrayOfInt != jdField_a_of_type_ArrayOfInt) {
              break label3002;
            }
            localaepc.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131690100);
          }
        }
        for (;;)
        {
          localArrayList.add(localaepc);
          break;
          localaepc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = agcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
          break label2463;
          bool = false;
          break label2563;
          localObject3 = "chat_tool_gift_clicked";
          break label2577;
          if (((arrayOfInt == q) && (a("chat_tool_qwallettransfer"))) || ((arrayOfInt == ag) && (a("chat_tool_tencentdoc"))) || ((arrayOfInt == v) && (a("chat_tool_qfav"))) || ((arrayOfInt == ar) && (a("chat_tool_apollo"))) || ((arrayOfInt == C) && (a("chat_tool_poke"))) || ((arrayOfInt == u) && (a((String)localObject3))) || ((arrayOfInt == z) && (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
            break label2595;
          }
          if (arrayOfInt == G)
          {
            if (ShortVideoUtils.f) {
              break label2595;
            }
            bool = ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ShortVideoUtils.f = true;
            if (!bool) {
              break label2595;
            }
            break label2595;
          }
          if (arrayOfInt == D)
          {
            localaepc.jdField_a_of_type_Boolean = agcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
            break label2595;
          }
          if (arrayOfInt == j)
          {
            if (i1 != 0) {
              break label2595;
            }
            localaepc.jdField_a_of_type_Boolean = atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false);
            break label2595;
          }
          if (arrayOfInt == l)
          {
            if (i1 == 0) {
              break label2595;
            }
            localaepc.jdField_a_of_type_Boolean = ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false);
            break label2595;
          }
          if (arrayOfInt == m) {
            break label2595;
          }
          localaepc.jdField_a_of_type_Boolean = false;
          break label2595;
          if (arrayOfInt == this.I) {
            localaepc.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131690096);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(null);
      if (i1 != 0)
      {
        localObject3 = (bchl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(((bchl)localObject3).a());
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
      QLog.d("PlusPanel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", xmv.a(5) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(paramInt);
    axho localaxho = (axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      aepc localaepc = (aepc)localIterator.next();
      a(localaepc, localaxho);
      switch (localaepc.jdField_b_of_type_Int)
      {
      default: 
      case 1106717414: 
      case 1106729451: 
      case 101458937: 
        for (;;)
        {
          label156:
          if (localaepc.jdField_a_of_type_Int == 2130838981)
          {
            azmj.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            bdaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "Grp_chain", "ChainEntry_Show");
            continue;
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            bdaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "MassMessage", "grpapp_Show");
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
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
      bdfc.b(paramBoolean);
    }
    agbu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131367851));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131367829));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    a(this);
    paramBaseChatPie = getResources().getDrawable(2130849607);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agld)) {
        this.jdField_b_of_type_Int = 2;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agkt)) {
        this.jdField_b_of_type_Int = 6;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agqq)) {
        this.jdField_b_of_type_Int = 7;
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agoj)) {
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
      if (this.jdField_a_of_type_Boolean) {
        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bF();
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label35;
      }
      if (!QLog.isColorLevel()) {}
    }
    label35:
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
      for (int i1 = 1; i1 == 0; i1 = 0)
      {
        QQToast.a(getContext(), aofk.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
    } while ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || ((TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(1106865772) == null) || (TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")));
    String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", auso.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getIntent();
    localIntent.putExtra("url", str);
    localIntent.putExtra("confess_half_screen_web", true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      this.jdField_d_of_type_Boolean = aofk.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    b(1106865772);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i1 = afsw.b(paramQQAppInterface, 0);
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
        QLog.d(afsw.jdField_a_of_type_JavaLangString, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + " getPokeMsgFoldSwitch=" + i1 + " hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public void b()
  {
    if (azib.b())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.I);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1106717414)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      bdaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    bdaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "MassMessage", "grpapp_Clk");
  }
  
  public void c()
  {
    if (azib.b())
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
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
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
      try
      {
        BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
        Resources localResources = localBaseActivity.getResources();
        bdcd.a(localBaseActivity, 230, localResources.getString(2131691727), localResources.getString(2131696316), 0, 2131696088, new aepb(this), null).show();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("PlusPanel", 1, "clickToolShareScreen", localThrowable);
        return;
      }
      i1 = 0;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        a(10, false, "AIOShareScreen");
        mww.a("0x800AD8E", 2);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
        d();
        aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, "AIOShareScreen", null);
        mww.a("0x800AD8E", 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PlusPanel", 2, "clickToolShareScreen, not support chat, [" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "]");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      a(10, true, null);
    }
    long l1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break;
      }
      a("chat_tool_gaudio");
      a(1, true, null);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
      if (!alqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131694710));
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
        for (String str = "0";; str = "1")
        {
          azmj.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "1", "", "");
          return;
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!apds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131694710));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
    aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004086", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      a(10, false, null);
    }
    long l1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break;
      }
      a("chat_tool_gaudio");
      a(1, false, null);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
      if (!alqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131694709));
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
        for (String str = "0";; str = "1")
        {
          azmj.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "0", "", "");
          return;
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!apds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(BaseApplicationImpl.getContext().getString(2131694709));
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
      return;
    }
    a("chat_tool_audio");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ar();
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)
    {
      if (((bfua)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
        return;
      }
      if (ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        ndv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOBottomButtonEngineFalse");
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407B", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131696170, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "Don't support ivr");
        continue;
        aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
      }
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    aeox localaeox = (aeox)paramView.getTag();
    int i4 = localaeox.jdField_a_of_type_Int;
    int i5 = localaeox.jdField_b_of_type_Int;
    int i1 = 0;
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      int i3;
      try
      {
        paramView = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramView != null) {
          i1 = paramView.productId;
        }
        i2 = i1;
      }
      catch (Exception paramView)
      {
        i2 = 0;
        continue;
        i1 = 0;
        continue;
        i3 = 0;
        continue;
        if (i3 == 0) {
          continue;
        }
        i1 = 2;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          continue;
        }
        i1 = 3;
        continue;
        if (!bool) {
          continue;
        }
        i1 = 4;
        continue;
        i1 = 5;
        continue;
        i3 = 0;
        continue;
        if (!"miniapp".equals(localaeox.jdField_b_of_type_JavaLangString)) {
          continue;
        }
        c(localaeox.jdField_a_of_type_JavaLangString);
        return;
        paramView = (zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        switch (i4)
        {
        default: 
          if (!a(localaeox)) {
            break label7627;
          }
        }
      }
      if (!TextUtils.isEmpty(localaeox.c))
      {
        paramView = (axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        paramView.a(paramView.a(10, localaeox.c), "");
      }
      boolean bool;
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
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!localaeox.jdField_a_of_type_Boolean) {
            continue;
          }
          i3 = 1;
          azmj.b(paramView, "dc00898", "", "", "0X800A46C", "0X800A46C", i5, i3, String.valueOf(i1), "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bl();
        if (!"web".equals(localaeox.jdField_b_of_type_JavaLangString)) {
          continue;
        }
        b(localaeox.jdField_a_of_type_JavaLangString);
        return;
      }
      label821:
      label866:
      Object localObject1;
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
          {
            paramView = null;
            localObject1 = (bchl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
            if ((paramView != null) && (paramView.redPoint))
            {
              bbib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.appid);
              ThreadManager.post(new PlusPanel.4(this, (bchl)localObject1, paramView), 8, null, false);
            }
            if ((paramView == null) || (!paramView.canRemove)) {
              break label7655;
            }
            bool = true;
            label937:
            a(i4, localaeox.jdField_b_of_type_Int, bool);
            if (localObject1 == null) {
              break;
            }
            ((bchl)localObject1).a(localaeox.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u(24);
            continue;
            if ((azib.b()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agqn)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(6));
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanel", 2, "pluspanel onclick called with plus from simple!");
              }
              if (azib.b()) {
                azmj.b(null, "dc00898", "", "", "0X800A114", "0X800A114", 0, 0, "", "", "", "");
              }
              if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agqn)) {
                continue;
              }
              azmj.b(null, "dc00898", "", "", "0X800A488", "0X800A488", 0, 0, "", "", "", "");
              continue;
            }
            aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i2, 0);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
            if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            continue;
            if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
            {
              bdcd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 230).setMessage(alpo.a(2131708684)).setPositiveButton(2131694951, new aeoy(this)).show();
              continue;
            }
            if (!BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x(2);
            continue;
            if ((azib.b()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agqn)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(4));
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanel", 2, "report() called with plus from simple!");
              }
              if (azib.b()) {
                azmj.b(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
              }
              if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agqn)) {
                continue;
              }
              azmj.b(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
            {
              paramView = new Intent();
              if (paramView != null) {
                if (agkk.X) {
                  break label1725;
                }
              }
              label1546:
              label1725:
              for (bool = true;; bool = false)
              {
                paramView.putExtra("isdevicesupportmultiupload", bool);
                aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramView);
                aabm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i2);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                {
                  paramView = (alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                  if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
                    paramView.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
                }
                agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
                  aabm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i2);
                }
                if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                break;
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break label7794;
            }
            paramView = new Intent();
            paramView.putExtra("filter_photolist_troopalbum_toolbar", true);
          }
        }
      }
      for (;;)
      {
        aepf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        break label1546;
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
                paramView = QzoneConfig.getInstance().getConfig("H5Url", "C2CPlusGiftJumpUrl", "https://h5.qzone.qq.com/giftv2/sendDialog?_wv=16781315&_wwv=13&_proxy=1&themeMode={themeMode}&uin={uin}");
                if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                  continue;
                }
                i1 = 1;
                paramView = paramView.replace("{uin}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).replace("{themeMode}", i1 + "");
                localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQTranslucentBrowserActivity.class);
                ((Intent)localObject1).putExtra("url", paramView);
                ((Intent)localObject1).setData(Uri.parse(paramView));
                ((Intent)localObject1).putExtra("flag_show_loading_dialog", true);
                ((Intent)localObject1).putExtra("hide_left_button", true);
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
                bool = false;
              }
              catch (Exception paramView)
              {
                QLog.e("PlusPanel", 2, paramView, new Object[0]);
                bool = false;
                continue;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agoj))
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
                {
                  paramView = "3";
                  alsy.a("gift_aio", "clk_icon", (String)localObject1, paramView, "", "");
                  azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "qq_gift", "plus_entry_clk", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
                  if (QLog.isColorLevel()) {
                    QLog.d("PlusPanel", 2, "PlusPanel onGiftClick, aioType=" + this.jdField_b_of_type_Int);
                  }
                  if (this.jdField_b_of_type_Int != 7) {
                    break label2567;
                  }
                  paramView = "chat_tool_gift_stranger_clicked";
                  a(paramView);
                  d();
                  break;
                  i1 = 0;
                  continue;
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n(true);
                  l1 = System.currentTimeMillis();
                  paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                  if (paramView == null) {
                    break label7788;
                  }
                  long l2 = paramView.jdField_a_of_type_Long;
                  if ((!paramView.jdField_a_of_type_Boolean) || (l1 < paramView.jdField_a_of_type_Long) || (l1 > l2 + 2592000000L) || (((bcju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a())) {
                    break label7788;
                  }
                  bool = true;
                  continue;
                }
                paramView = "0";
                continue;
              }
              if (this.jdField_b_of_type_Int == 2) {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 6) {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 7) {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_clk", 0, 0, "", "", "", "");
              } else if (this.jdField_b_of_type_Int == 1) {
                if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                {
                  azmj.b(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                }
                else
                {
                  azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + bool, "", "");
                  continue;
                  label2567:
                  paramView = "chat_tool_gift_clicked";
                  continue;
                  if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()))
                  {
                    CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), null);
                    return;
                  }
                  new atmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();
                  break;
                  h();
                  break;
                  if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agot)) {
                    break;
                  }
                  ((agot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).r.performClick();
                  break;
                  i();
                  break;
                  try
                  {
                    j();
                  }
                  catch (Exception paramView)
                  {
                    QLog.d("PlusPanel", 1, "showTroopCourseActionSheet() func call Exception", paramView);
                  }
                }
              }
            }
            break;
            try
            {
              b(false);
            }
            catch (Exception paramView)
            {
              QLog.d("PlusPanel", 1, "handleTroopLiveOrTroopCourseClick Exception", paramView);
            }
          }
          break label821;
          a("chat_tool_tencentdoc");
          d();
          badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
          {
            agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break label821;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break label821;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label821;
          }
          agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80093F8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break label821;
          a("chat_tool_tencentdoc");
          d();
          badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label821;
          }
          paramView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (paramView != null) {}
          for (paramView = paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramView = null)
          {
            if (paramView != null) {}
            for (paramView = "" + paramView.dwGroupClassExt;; paramView = "")
            {
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009E25", "0X8009E25", 0, 0, "", "", "" + paramView, "");
              break label821;
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()))
              {
                CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), new aeoz(this, paramView));
                return;
              }
              a(paramView);
              break label821;
              a("chat_tool_qlink_file");
              d();
              arni.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
              break label821;
              i1 = 1;
              if (this.jdField_c_of_type_Long == -1L)
              {
                label3157:
                if (i1 == 0) {
                  break label3226;
                }
                acex.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                this.jdField_c_of_type_Long = System.currentTimeMillis();
              }
              for (;;)
              {
                agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004081", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                break;
                if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 10000L) {
                  break label3157;
                }
                i1 = 0;
                break label3157;
                label3226:
                QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131708689), 0).a();
              }
              paramView = new Bundle();
              paramView.putInt("forward_type", 23);
              paramView.putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              paramView.putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
              paramView.putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramView.putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
              paramView.putBoolean("only_single_selection", true);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtras(paramView);
              arum.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (Intent)localObject1, 21);
              agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80056B3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8007010", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break label821;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
                break;
              }
              paramView = myl.a().a("aio_qqMusicShare", "");
              aepf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004083", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break label821;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
              {
                i3 = 2;
                i2 = 0;
              }
              for (;;)
              {
                label3506:
                if (i3 == 0) {
                  break label7774;
                }
                if (i2 != 0)
                {
                  paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  if (paramView.isTroopOwner((String)localObject1)) {
                    i1 = 0;
                  }
                }
                for (;;)
                {
                  label3558:
                  atii.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), i3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                  if ((i2 == 0) && (atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false)))
                  {
                    atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", false, false);
                    d();
                  }
                  if (i2 == 0) {}
                  for (paramView = "c2c_AIO";; paramView = "Grp_AIO")
                  {
                    azmj.b(null, "dc00899", paramView, "", "music_tab", "clk_panelmusic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1 + "", i1 + "", "");
                    break;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                      break label7768;
                    }
                    i3 = 1;
                    i2 = 1;
                    break label3506;
                    if (paramView.isTroopAdmin((String)localObject1))
                    {
                      i1 = 1;
                      break label3558;
                    }
                    i1 = 2;
                    break label3558;
                  }
                  paramView = null;
                  i1 = -1;
                  i2 = -1;
                  localObject1 = new Bundle();
                  Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  Object localObject2 = (baky)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
                  bool = ((baky)localObject2).a(4, -1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    i2 = 0;
                    paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    if (paramView == null) {
                      break;
                    }
                    localObject1 = ball.a(bool, paramView.isTroopOwner((String)localObject3), paramView.isAdmin(), paramView.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                    ((baky)localObject2).a("sing_tab", "clk_panelsing", 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    i1 = 1;
                    paramView = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
                  }
                  for (;;)
                  {
                    if (TextUtils.isEmpty(paramView)) {
                      break label3997;
                    }
                    if (!bool) {
                      break label3999;
                    }
                    ((baky)localObject2).b(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1, 4, i2, (Bundle)localObject1);
                    break;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                    {
                      localObject1 = ball.a(bool, 3);
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                      i2 = 3;
                      i1 = 2;
                      paramView = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                    }
                  }
                  label3997:
                  break;
                  label3999:
                  ((baky)localObject2).a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i1, 4, i2, (Bundle)localObject1);
                  break label821;
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
                    break;
                  }
                  paramView = (aono)aogj.a().a(535);
                  if ((paramView == null) || (paramView.a == null))
                  {
                    QQToast.a(getContext(), 0, 2131693336, 0).a();
                    return;
                  }
                  localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if (localObject1 == null) {
                    break;
                  }
                  localObject2 = (baky)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339);
                  bool = ((baky)localObject2).a(2, 1, ((TroopInfo)localObject1).uin);
                  localObject3 = ball.a(bool, ((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), ((TroopInfo)localObject1).isAdmin(), ((TroopInfo)localObject1).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
                  switch (paramView.a.a())
                  {
                  default: 
                    if (((baky)localObject2).a(getContext(), 2, ((TroopInfo)localObject1).troopuin, 0)) {
                      if (QLog.isColorLevel()) {
                        QLog.d("PlusPanel", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
                      }
                    }
                    break;
                  }
                  while (ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
                  {
                    ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
                    d();
                    break;
                    QQToast.a(getContext(), 0, 2131693336, 0).a();
                    continue;
                    if (!((TroopInfo)localObject1).isAdmin())
                    {
                      if (bool) {
                        ((baky)localObject2).b(getContext(), ((TroopInfo)localObject1).troopuin, 1, 2, 0, (Bundle)localObject3);
                      } else {
                        ((baky)localObject2).a(getContext(), ((TroopInfo)localObject1).troopuin, 1, 2, 0, (Bundle)localObject3);
                      }
                    }
                    else if (bool)
                    {
                      ((baky)localObject2).b(getContext(), ((TroopInfo)localObject1).troopuin, 1, 2, 0, (Bundle)localObject3);
                    }
                    else
                    {
                      ((baky)localObject2).a(getContext(), ((TroopInfo)localObject1).troopuin, 1, 2, 0, (Bundle)localObject3);
                      continue;
                      ((baky)localObject2).a("video_tab", "clk_panelvideo", 0, ((TroopInfo)localObject1).troopuin);
                      ball.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.a.b(), paramView.a.a(), paramView.a.b(), (Bundle)localObject3, 1);
                    }
                  }
                  ylr.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "200002", "http://m.dianping.com/qq/aiodwonload", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  ylr.a("200002", "click_app", "", "", "");
                  agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB2", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label821;
                  bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0");
                  agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label821;
                  paramView = new Bundle();
                  paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  paramView.putBoolean("hide_operation_bar", true);
                  paramView.putBoolean("hide_more_button", true);
                  paramView.putBoolean("isScreenOrientationPortrait", true);
                  bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
                  agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  break label821;
                  if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    bajq.a().b(true);
                    a("chat_tool_anonymous");
                    d();
                    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
                      break;
                    }
                    ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(2, "");
                    ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    azmj.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
                    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label821;
                  }
                  if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
                    break;
                  }
                  ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).u(false);
                  bajq.a().b(false);
                  azmj.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
                  break label821;
                  if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label821;
                  }
                  paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if ((localObject1 != null) && (!TextUtils.isEmpty(paramView))) {
                    if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains(paramView))) {
                      i1 = 3;
                    }
                  }
                  for (;;)
                  {
                    label4975:
                    paramView = nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    localObject2 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&avatar=").append(nav.a(paramView.jdField_a_of_type_Int)).append("&nick=");
                    if (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) {}
                    for (paramView = "";; paramView = URLEncoder.encode(paramView.jdField_a_of_type_JavaLangString))
                    {
                      ((Intent)localObject1).putExtra("url", paramView + "&role=" + String.valueOf(i1) + "&self=1");
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(i1), "", "");
                      break;
                      if (paramView.equals(((TroopInfo)localObject1).troopowneruin))
                      {
                        i1 = 2;
                        break label4975;
                      }
                      i1 = 1;
                      break label4975;
                    }
                    a("chat_tool_qwallettransfer");
                    d();
                    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TransactionActivity.class);
                    ((Intent)localObject1).putExtra("come_from", 2);
                    i2 = 0;
                    i1 = 0;
                    paramView = null;
                    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
                    {
                    }
                    for (;;)
                    {
                      localObject2 = new JSONObject();
                      try
                      {
                        ((JSONObject)localObject2).put("targetUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        ((JSONObject)localObject2).put("targetNickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
                        ((JSONObject)localObject2).put("sign", "");
                        if (i2 != 0) {
                          ((JSONObject)localObject2).put("source", i2);
                        }
                        ((JSONObject)localObject2).put("group_type", i1);
                        if (!TextUtils.isEmpty(paramView)) {
                          ((JSONObject)localObject2).put("group_uin", paramView);
                        }
                      }
                      catch (JSONException paramView)
                      {
                        for (;;)
                        {
                          paramView.printStackTrace();
                        }
                      }
                      ((Intent)localObject1).putExtra("extra_data", ((JSONObject)localObject2).toString());
                      ((Intent)localObject1).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
                      ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 0, null));
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
                      agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB0", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                      break;
                      i2 = 5;
                      i1 = 3;
                      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
                      continue;
                      i2 = 5;
                      i1 = 4;
                      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
                    }
                    zqh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
                      break label821;
                    }
                    aabm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 4, 0, i2);
                    break label821;
                    l1 = System.currentTimeMillis();
                    if (Math.abs(l1 - this.jdField_a_of_type_Long) < 1000L) {
                      break;
                    }
                    this.jdField_a_of_type_Long = l1;
                    d();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u(10);
                      aepf.a(0);
                    }
                    paramView = "";
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008)) {
                      paramView = "entrance.click.c2c.plus";
                    }
                    for (;;)
                    {
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramView, 0, 0, "", "", "", "");
                      break;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                        paramView = "entrance.click.group.plus";
                      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                        paramView = "entrance.click.chatgroup.plus";
                      }
                    }
                    a("chat_tool_qfav");
                    d();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
                      break label821;
                    }
                    aepf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
                    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label821;
                    a("chat_tool_dingyue");
                    d();
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    paramView.putExtra("url", "https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
                    break label821;
                    a("chat_tool_toupiao");
                    d();
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    paramView.putExtra("selfSet_leftViewText", alpo.a(2131708682));
                    paramView.putExtra("url", "https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&src=3");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
                    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB9", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label821;
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    paramView.putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793&f=6&uintype=3000&touin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    paramView.putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
                    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBB", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label821;
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    paramView.putExtra("url", "https://mqq.tenpay.com/mqq/groupreceipts/index.shtml?type=4&_wv=1027&_wvx=4");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                    break label821;
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    paramView.putExtra("url", "https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&state=1");
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                    break label821;
                    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localaeox.jdField_b_of_type_Int) < 0)) {
                      break label821;
                    }
                    paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localaeox.jdField_b_of_type_Int);
                    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
                    if ((paramView == null) || (paramView.url == null)) {
                      break label821;
                    }
                    ((Intent)localObject1).putExtra("url", paramView.url.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
                    agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBA", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    break label821;
                    if (paramView == null) {
                      break label821;
                    }
                    localObject1 = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
                    if (localObject1 == null) {
                      break label821;
                    }
                    paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (DeviceInfo)localObject1, false);
                    break label821;
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
                      paramView = (akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                      i2 = paramView.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                      i3 = ApolloUtil.h(akji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                      localObject3 = "" + i1;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
                      for (paramView = "0";; paramView = "2")
                      {
                        VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "panel_enter_clk", (String)localObject2, i2, i3, new String[] { localObject3, paramView, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                        break;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
                      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
                      {
                        ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        d();
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bg();
                      break label821;
                      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView))
                      {
                        a("chat_tool_poke");
                        if (Build.VERSION.SDK_INT <= 8) {
                          break label7031;
                        }
                        paramView.edit().putBoolean("chat_tool_poke_clicked", true).apply();
                      }
                      for (;;)
                      {
                        d();
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aG();
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8007F21");
                        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agiy)) {
                          break;
                        }
                        agci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                        break;
                        label7031:
                        paramView.edit().putBoolean("chat_tool_poke_clicked", true).commit();
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aQ();
                      break label821;
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aH();
                      break label821;
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.be();
                      break label821;
                      if (bdiv.r(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                        TroopPicEffectsEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                      }
                      for (;;)
                      {
                        bcsl.a("app_entry", "page_clk");
                        break;
                        bdiv.z(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TroopPicEffectGuidePicActivity.class);
                        paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                      }
                      paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localaeox.jdField_b_of_type_Int);
                      if (paramView == null) {
                        break label821;
                      }
                      paramView = xlh.a(null, paramView.url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), JumpActivity.class);
                      ((Intent)localObject1).setData(Uri.parse(paramView));
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject1);
                      wta.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
                      break label821;
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
                      if (!bdee.e(BaseApplicationImpl.getContext()))
                      {
                        QQToast.a(BaseApplicationImpl.getContext(), 2131692397, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
                        break label821;
                      }
                      if (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long < 5000L) {
                        a(false);
                      }
                      for (;;)
                      {
                        this.jdField_a_of_type_Boolean = true;
                        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
                        break;
                        ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).f(alpo.a(2131708687));
                        ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
                      }
                      if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(localaeox.jdField_b_of_type_Int) < 0)) {
                        break label821;
                      }
                      paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localaeox.jdField_b_of_type_Int);
                      aepw.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView.url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 1);
                      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009FCD", "0X8009FCD", 0, 0, "", "", "", "");
                      break label821;
                      agcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
                      d();
                      break label821;
                      g();
                      break label821;
                      label7627:
                      aepw.a(this, localaeox);
                      break label821;
                      paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localaeox.jdField_b_of_type_Int);
                      break label866;
                      label7655:
                      bool = false;
                      break label937;
                      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002)) {
                        break;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
                      for (paramView = "0";; paramView = "1")
                      {
                        azmj.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramView, a(i4), "", "");
                        return;
                      }
                    }
                    i1 = 0;
                  }
                  i1 = -1;
                }
                label7768:
                i3 = 0;
                i2 = 0;
              }
              label7774:
              break label821;
            }
          }
          label7788:
          bool = false;
        }
        label7794:
        paramView = null;
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
    switch (((aeox)paramView.getTag()).jdField_a_of_type_Int)
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      } else if (this.jdField_b_of_type_Int == 7) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void setAIOLongCaptureCtrlListener(AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = paramAIOLongCaptureCtrl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */