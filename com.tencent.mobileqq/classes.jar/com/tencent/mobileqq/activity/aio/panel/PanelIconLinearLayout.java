package com.tencent.mobileqq.activity.aio.panel;

import afur;
import agaa;
import aglu;
import agmo;
import aheh;
import ahqr;
import ahqx;
import ahqy;
import ahqz;
import ahra;
import ahvz;
import ahwa;
import ahzf;
import akww;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqbj;
import arqk;
import avbk;
import ayzm;
import azar;
import baif;
import bckg;
import bcnj;
import bcst;
import bdpd;
import bggq;
import bgjw;
import bjft;
import bnvd;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import njo;
import org.jetbrains.annotations.NotNull;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static Boolean a;
  public static boolean a;
  public static int b;
  public static Boolean b;
  public int a;
  public aglu a;
  private ahqy jdField_a_of_type_Ahqy;
  private ahqz jdField_a_of_type_Ahqz;
  private ahra jdField_a_of_type_Ahra;
  public Context a;
  public SharedPreferences a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<int[]> a;
  private Map<int[], int[]> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<int[], int[]> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
  }
  
  public PanelIconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 100;
    setOrientation(0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundResource(2130849881);
    jdField_b_of_type_Int = afur.a(40.0F, paramContext.getResources());
    d();
  }
  
  @NotNull
  private RedTouch a(ayzm paramayzm, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramRedDotImageView).a(53).c(15).d(3).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    baif localbaif = (baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (paramInt == 8)
    {
      paramayzm = localbaif.a(10);
      if (paramayzm != null) {
        paramRedDotImageView.a(paramayzm);
      }
    }
    do
    {
      return paramRedDotImageView;
      paramayzm = localbaif.a(4, String.valueOf(paramayzm.jdField_b_of_type_Int));
    } while (paramayzm == null);
    paramRedDotImageView.a(paramayzm);
    localbaif.b(paramayzm, "");
    return paramRedDotImageView;
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23)
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
        paramRedDotImageView.a(true);
      }
    }
    else
    {
      if (paramInt == 26)
      {
        if (!b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label222;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
        paramRedDotImageView.a(true);
      }
      label100:
      if (paramInt == 3)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label230;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
        paramRedDotImageView.a(true);
      }
      label145:
      if (paramInt != 2) {
        break label244;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103300");
      if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
        break label238;
      }
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
      paramRedDotImageView.a(true);
    }
    label222:
    label230:
    label238:
    label244:
    do
    {
      return;
      paramRedDotImageView.a(false);
      break;
      paramRedDotImageView.a(false);
      break label100;
      paramRedDotImageView.a(false);
      break label145;
      paramRedDotImageView.a(false);
      return;
      if (paramInt == 6)
      {
        if (!ShortVideoUtils.e)
        {
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          ShortVideoUtils.e = true;
        }
        jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(bckg.a(bckg.jdField_d_of_type_JavaLangString));
        if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(11);
          paramRedDotImageView.setReddotYOffsetDp(8);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130849747));
          paramRedDotImageView.a(true);
          return;
        }
        if (jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
          paramRedDotImageView.a(true);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
          return;
        }
        paramRedDotImageView.a(false);
        return;
      }
      if (paramInt == 10)
      {
        akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedDotImageView, this.jdField_c_of_type_Int);
        return;
      }
      if (paramInt == 8)
      {
        if (a(this.jdField_c_of_type_Int))
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
          paramRedDotImageView.a(true);
          return;
        }
        paramRedDotImageView.a(false);
        return;
      }
    } while (paramInt != 24);
    if (!ShortVideoUtils.f)
    {
      jdField_a_of_type_Boolean = ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      ShortVideoUtils.f = true;
    }
    if (jdField_a_of_type_Boolean)
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850389));
      paramRedDotImageView.a(true);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if ((!bcnj.b()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)))) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void a(ayzm paramayzm, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramayzm.jdField_d_of_type_Int) && (paramSessionInfo != null) && (bgjw.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(ahqr.T[2]);
      paramayzm.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramayzm.jdField_d_of_type_Int = ahqr.T[0];
      paramayzm.e = ahqr.T[3];
      paramayzm.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(ahqr.T[1]);
    }
  }
  
  private void a(ayzm paramayzm, ArrayList<ahwa> paramArrayList, int paramInt)
  {
    int i = paramayzm.jdField_d_of_type_Int;
    RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bggq.a(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramayzm.jdField_a_of_type_ArrayOfInt != null) && (paramayzm.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (((paramayzm.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramayzm.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramayzm.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))))
      {
        ahwa localahwa = new ahwa();
        localahwa.jdField_a_of_type_Int = paramInt;
        localahwa.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        paramArrayList.add(localahwa);
      }
    }
    else {
      if (!this.jdField_b_of_type_Boolean) {
        break label364;
      }
    }
    label364:
    for (paramArrayList = paramayzm.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; paramArrayList = paramayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      localRedDotImageView.setImageDrawable(paramArrayList);
      if (AppSetting.jdField_c_of_type_Boolean) {
        localRedDotImageView.setContentDescription(paramayzm.jdField_d_of_type_JavaLangString);
      }
      if (paramayzm.e > 0) {
        localRedDotImageView.setId(paramayzm.e);
      }
      localRedDotImageView.setLongClickable(true);
      localRedDotImageView.setOnLongClickListener(this);
      localRedDotImageView.setOnClickListener(this);
      localRedDotImageView.setSelected(false);
      a(localRedDotImageView, i);
      if (this.jdField_c_of_type_Boolean) {
        break label372;
      }
      a(i, localRedDotImageView);
      addView(localRedDotImageView, localLayoutParams);
      return;
      localRedDotImageView.setImageResource(paramayzm.jdField_a_of_type_ArrayOfInt[2]);
      break;
    }
    label372:
    addView(a(paramayzm, i, localRedDotImageView), localLayoutParams);
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList;
    if ((paramBaseChatPie != null) && ((paramBaseChatPie instanceof ahzf)))
    {
      if (((ahzf)paramBaseChatPie).I()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
      }
      if (((ahzf)paramBaseChatPie).H())
      {
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label122;
        }
      }
    }
    label122:
    for (int[] arrayOfInt = ahqr.p;; arrayOfInt = ahqr.l)
    {
      localArrayList.add(arrayOfInt);
      g();
      if (((ahzf)paramBaseChatPie).E())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.E);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.D);
      }
      if (((ahzf)paramBaseChatPie).G()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.J);
      }
      return;
    }
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
    h();
    f();
    if (ahqr.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.C);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
    if (bgjw.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.U);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramInt == 1024) && (((bjft)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = ahqr.p;
      localArrayList.add(arrayOfInt);
      g();
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label163;
      }
    }
    label163:
    for (int[] arrayOfInt = ahqr.i;; arrayOfInt = ahqr.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.z);
      if ((paramInt == 1024) && (((bjft)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(ahqr.z);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
      }
      return;
      arrayOfInt = ahqr.l;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<int[]> paramArrayList)
  {
    if ((paramInt == 1024) && (((bjft)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramArrayList.add(ahqr.d);
    }
    paramArrayList.add(ahqr.o);
    f();
    paramArrayList.add(ahqr.h);
    paramArrayList.add(ahqr.A);
    if ((paramInt == 1024) && (((bjft)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramArrayList.remove(ahqr.z);
      paramArrayList.add(ahqr.y);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, ArrayList<int[]> paramArrayList)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = localHotChatManager.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramArrayList.add(ahqr.d);
      paramArrayList.add(ahqr.W);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(ahqr.G);
      }
      paramArrayList.add(ahqr.I);
      paramArrayList.add(ahqr.h);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(ahqr.y);
      }
      return;
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    a(njo.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = ahqr.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (avbk.a(paramQQAppInterface).b()) {
        paramArrayList.add(ahqr.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label64;
      }
    }
    label64:
    for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = ahqr.l;
      break;
    }
  }
  
  private void a(String paramString)
  {
    if (((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://"))) || (paramString.startsWith("https://")))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private void a(List<ayzm> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (ayzm)paramList.get(i);
      if (!a(((ayzm)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((ayzm)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((ayzm)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      ahvz.a().a((ArrayList)localObject, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (bgjw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!bgjw.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((arqk)paramQQAppInterface.getManager(334)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = aheh.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = aheh.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(aheh.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    return (paramInt == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private void b(SessionInfo paramSessionInfo)
  {
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = ahqr.p;
      localArrayList.add(arrayOfInt);
      i();
      g();
      if (ahqr.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.B);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label124;
      }
    }
    label124:
    for (int[] arrayOfInt = ahqr.i;; arrayOfInt = ahqr.e)
    {
      localArrayList.add(arrayOfInt);
      if (!bgjw.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label131;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.T);
      this.jdField_c_of_type_Boolean = false;
      return;
      arrayOfInt = ahqr.l;
      break;
    }
    label131:
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.jdField_a_of_type_Int;
    EmojiStickerManager.a().jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    if (i == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
      h();
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label778;
      }
      setCustomHeight(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      b();
      return;
      if (i == 1)
      {
        a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, this.jdField_a_of_type_JavaUtilArrayList);
        break;
      }
      if (d(i))
      {
        a(paramQQAppInterface, paramSessionInfo, i, this.jdField_a_of_type_JavaUtilArrayList);
        break;
      }
      if (c(i))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        break;
      }
      if (i == 1036)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.X);
        break;
      }
      if (a(paramQQAppInterface, paramSessionInfo, i))
      {
        a(paramSessionInfo);
        break;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
        break;
      }
      if (e(i))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.A);
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.A);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.A);
        e();
        break;
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
        break;
      }
      if (b(i))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
      break;
      label778:
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    paramArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = ahqr.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (avbk.a(paramQQAppInterface).b()) {
        paramArrayList.add(ahqr.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = ahqr.l;
      break;
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramString, 2053, null);
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = aheh.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = aheh.a(paramSharedPreferences);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(aheh.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramSessionInfo = localHotChatManager.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.V);
      if (!paramSessionInfo.isRobotHotChat) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.F);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.H);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        if (!paramSessionInfo.isRobotHotChat) {
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
        }
        return;
      }
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    a(njo.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie);
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1033) || (paramInt == 1034);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.e, ahqr.i);
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.f, ahqr.j);
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.g, ahqr.k);
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.l, ahqr.p);
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.m, ahqr.q);
    this.jdField_b_of_type_JavaUtilMap.put(ahqr.n, ahqr.r);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.i, ahqr.e);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.j, ahqr.f);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.k, ahqr.g);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.p, ahqr.l);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.q, ahqr.m);
    this.jdField_a_of_type_JavaUtilMap.put(ahqr.r, ahqr.n);
  }
  
  private boolean d(int paramInt)
  {
    return (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1009) || (paramInt == 1024);
  }
  
  private void e()
  {
    if (avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.O);
    }
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008) || (paramInt == 10010);
  }
  
  private void f()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(ahqr.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ahqr.s[2] = 2130844813;
        ahqr.s[5] = 0;
        ahqr.s[6] = 0;
      }
      return;
    }
  }
  
  private void g()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(ahqr.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.s);
      }
      return;
    }
  }
  
  private void h()
  {
    if (ShortVideoUtils.f()) {
      ahqr.v[2] = 2130844824;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.v);
      return;
      ahqr.v[2] = 2130844813;
    }
  }
  
  private void i()
  {
    if (ShortVideoUtils.f())
    {
      ahqr.v[2] = 2130838182;
      ahqr.v[5] = 2130849947;
      ahqr.v[6] = 2130849948;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.v);
      return;
      ahqr.v[2] = 2130838105;
      ahqr.v[5] = 2130849849;
      ahqr.v[6] = 2130849850;
    }
  }
  
  public ArrayList<int[]> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label78;
      }
      arrayOfInt = ahqr.p;
      localArrayList.add(arrayOfInt);
      g();
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.N);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label85;
      }
    }
    label78:
    label85:
    for (int[] arrayOfInt = ahqr.i;; arrayOfInt = ahqr.e)
    {
      localArrayList.add(arrayOfInt);
      return;
      arrayOfInt = ahqr.l;
      break;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!LightVideoConfigMgr.a().b());
    paramView.setOnLongClickListener(new ahqx(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.b);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = ahqr.q;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.t);
      if (avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.R);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = ahqr.j;; paramQQAppInterface = ahqr.f)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      paramQQAppInterface = ahqr.m;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      setBackgroundResource(2130849881);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130844818);
    b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramBoolean, false, paramQQAppInterface, paramBaseChatPie);
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {}
    for (this.jdField_c_of_type_Int = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;; this.jdField_c_of_type_Int = 1)
    {
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label76;
      }
      arrayOfInt = ahqr.p;
      localArrayList.add(arrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = ahqr.i;; arrayOfInt = ahqr.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      arrayOfInt = ahqr.l;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    a(paramBoolean1, paramBoolean2, paramQQAppInterface, paramBaseChatPie, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, boolean paramBoolean3)
  {
    this.jdField_c_of_type_Boolean = false;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = ahqr.q;
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.t);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = ahqr.j;; paramQQAppInterface = ahqr.f)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.x);
        return;
        paramQQAppInterface = ahqr.m;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.o);
      h();
      f();
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.A);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.y);
        return;
        if (ahqr.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.C);
        }
      }
    }
    this.d = true;
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = ahqr.p;
      paramBaseChatPie.add(paramQQAppInterface);
      i();
      g();
      if (!paramBoolean2) {
        break label304;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.z);
      label261:
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
      return;
      paramQQAppInterface = ahqr.l;
      break;
      if (!ahqr.jdField_a_of_type_Boolean) {
        break label261;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.B);
      break label261;
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int i = a().indexOf(paramArrayOfInt);
    if (i < 0) {
      if (this.jdField_b_of_type_Boolean)
      {
        paramArrayOfInt = (int[])this.jdField_b_of_type_JavaUtilMap.get(paramArrayOfInt);
        if (paramArrayOfInt == null) {
          break label205;
        }
        i = a().indexOf(paramArrayOfInt);
      }
    }
    label205:
    for (;;)
    {
      if (i < 0) {
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "updateIconNumbers error index =  " + i);
        }
      }
      do
      {
        return;
        paramArrayOfInt = (int[])this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfInt);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "updateIconNumbers index =  " + i + ",num = " + paramInt);
        }
        paramArrayOfInt = getChildAt(i);
        if ((paramArrayOfInt instanceof RedDotImageView))
        {
          ((RedDotImageView)paramArrayOfInt).setUnreadNumber(paramInt);
          return;
        }
      } while ((!(paramArrayOfInt instanceof RedTouch)) || (!(((RedTouch)paramArrayOfInt).a() instanceof RedDotImageView)));
      ((RedDotImageView)((RedTouch)paramArrayOfInt).a()).setUnreadNumber(paramInt);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 3000) {}
    }
    else
    {
      bool1 = bool2;
      if (ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    int j = 0;
    removeAllViews();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (!a())
      {
        localObject2 = azar.a(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 == null) && (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder().append("session: ");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            break label252;
          }
        }
      }
    }
    int i;
    label252:
    for (localObject1 = "";; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      QLog.e("PanelIconLinearLayout", 2, localObject1 + " did not use config");
      localObject1 = localObject2;
      if ((!this.d) && (this.jdField_c_of_type_Boolean) && (localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label446;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject3 = new ayzm();
        ((ayzm)localObject3).jdField_d_of_type_Int = localObject2[0];
        ((ayzm)localObject3).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(localObject2[1]);
        ((ayzm)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject2[2]);
        ((ayzm)localObject3).e = localObject2[3];
        ((ayzm)localObject3).jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
    }
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        localObject2 = (ayzm)((List)localObject1).get(i);
        if ((!this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((ayzm)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = azar.b(((ayzm)localObject2).jdField_a_of_type_Int);
          if (localObject3 != null) {
            ((ayzm)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((ayzm)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = azar.b(((ayzm)localObject2).jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label403;
          }
          ((ayzm)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
        }
        for (;;)
        {
          i += 1;
          break;
          label403:
          if (((ayzm)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            ((ayzm)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((ayzm)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
      }
      a((List)localObject1);
      bdpd.a().b(this.jdField_a_of_type_AndroidContentContext, this);
      return;
      i = j;
      continue;
      label446:
      i = j;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.c);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = ahqr.r;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.u);
      if (avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.N);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = ahqr.k;; paramQQAppInterface = ahqr.g)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      paramQQAppInterface = ahqr.n;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.jdField_a_of_type_Int;
    EmojiStickerManager.a().jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    if (i == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = ahqr.p;
        paramSessionInfo.add(paramQQAppInterface);
        i();
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label220;
        }
        paramQQAppInterface = ahqr.i;
        label162:
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
        label179:
        a(i, paramBoolean);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label1119;
        }
        setCustomHeight(0);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      b();
      return;
      paramQQAppInterface = ahqr.l;
      break;
      label220:
      paramQQAppInterface = ahqr.e;
      break label162;
      if (i == 1)
      {
        c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        break label179;
      }
      if (d(i))
      {
        a(paramQQAppInterface, paramSessionInfo, i);
        break label179;
      }
      if (c(i))
      {
        b(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        break label179;
      }
      if (i == 1036)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = ahqr.p;
          label308:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label361;
          }
        }
        label361:
        for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.X);
          break;
          paramQQAppInterface = ahqr.l;
          break label308;
        }
      }
      if (a(paramQQAppInterface, paramSessionInfo, i))
      {
        b(paramSessionInfo);
        break label179;
      }
      if (i == 10004)
      {
        b(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
        break label179;
      }
      if (e(i))
      {
        a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        break label179;
      }
      if (i == 1020)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = ahqr.p;
          label463:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label516;
          }
        }
        label516:
        for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.z);
          break;
          paramQQAppInterface = ahqr.l;
          break label463;
        }
      }
      if (i == 1008) {
        break label179;
      }
      if (i == 1005)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = ahqr.p;
          label555:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label608;
          }
        }
        label608:
        for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.z);
          break;
          paramQQAppInterface = ahqr.l;
          break label555;
        }
      }
      if (i == 1003)
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramSessionInfo = ahqr.p;; paramSessionInfo = ahqr.l)
        {
          paramBaseChatPie.add(paramSessionInfo);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.z);
          if (!avbk.a(paramQQAppInterface).b()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.N);
          break;
        }
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = ahqr.p;
          label726:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label779;
          }
        }
        label779:
        for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
          break;
          paramQQAppInterface = ahqr.l;
          break label726;
        }
      }
      if (b(i))
      {
        a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        break label179;
      }
      if (i == 6000)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = ahqr.p;; paramQQAppInterface = ahqr.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.J);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.K);
          break;
        }
      }
      if (i == 6003)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = ahqr.p;; paramQQAppInterface = ahqr.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.J);
          break;
        }
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = ahqr.p;
          label963:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1016;
          }
        }
        label1016:
        for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(ahqr.w);
          break;
          paramQQAppInterface = ahqr.l;
          break label963;
        }
      }
      if (i == 9501)
      {
        a(paramBaseChatPie);
        break label179;
      }
      if (i == 10009)
      {
        a();
        break label179;
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = ahqr.p;
        label1070:
        paramSessionInfo.add(paramQQAppInterface);
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label1112;
        }
      }
      label1112:
      for (paramQQAppInterface = ahqr.i;; paramQQAppInterface = ahqr.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        break;
        paramQQAppInterface = ahqr.l;
        break label1070;
      }
      label1119:
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    boolean bool2 = ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    boolean bool1;
    int j;
    label47:
    int k;
    label88:
    int[] arrayOfInt;
    if ((paramBoolean) && (bool2))
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
        break label163;
      }
      j = 1;
      if ((this.jdField_c_of_type_Boolean) || (!bool2)) {
        break label200;
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label199;
      }
      int m = this.jdField_a_of_type_JavaUtilArrayList.size();
      k = 0;
      if (k >= m) {
        break label187;
      }
      arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (!paramBoolean) {
        break label168;
      }
      arrayOfInt = (int[])this.jdField_b_of_type_JavaUtilMap.get(arrayOfInt);
      label129:
      if (arrayOfInt == null) {
        break label209;
      }
      this.jdField_a_of_type_JavaUtilArrayList.set(k, arrayOfInt);
      i = 1;
    }
    label163:
    label168:
    label187:
    label199:
    label200:
    label209:
    for (;;)
    {
      k += 1;
      break label88;
      bool1 = false;
      break;
      j = 0;
      break label47;
      arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilMap.get(arrayOfInt);
      break label129;
      if ((i != 0) && (j != 0)) {
        b();
      }
      do
      {
        return;
      } while (j == 0);
      b();
      return;
    }
  }
  
  public void c()
  {
    int i;
    if ((getVisibility() == 0) && (this.jdField_c_of_type_Boolean)) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if ((!(localView.getTag() instanceof Integer)) || (((Integer)localView.getTag()).intValue() != 8)) {
          break label90;
        }
        if ((localView instanceof RedTouch))
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10);
          ((RedTouch)localView).a(localRedTypeInfo);
        }
      }
      return;
      label90:
      i -= 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {}
    int i;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((Integer)localObject1).intValue() == 6)
      {
        bnvd.a().d();
        bnvd.a().a("userClick");
      }
      ayzm localayzm = azar.a(((Integer)localObject1).intValue());
      if (localayzm != null) {
        ahqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(localayzm.jdField_b_of_type_Int), localayzm.jdField_a_of_type_Int);
      }
      do
      {
        do
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Ahqz != null) {
              this.jdField_a_of_type_Ahqz.a(paramView.getTag());
            }
            try
            {
              i = ((Integer)paramView.getTag()).intValue();
              if (i != 2) {
                break label292;
              }
              ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("103100.103300");
              if ((paramView instanceof RedDotImageView)) {
                ((RedDotImageView)paramView).a(false);
              }
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
            }
            catch (Exception localException)
            {
              QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + localException.getMessage());
            }
          }
          break;
          localObject2 = azar.a(((Integer)localException).intValue(), true);
        } while (localObject2 == null);
        if ("web".equals(((ayzm)localObject2).jdField_a_of_type_JavaLangString))
        {
          a(((ayzm)localObject2).jdField_b_of_type_JavaLangString);
          break;
        }
      } while (!"miniapp".equals(((ayzm)localObject2).jdField_a_of_type_JavaLangString));
      b(((ayzm)localObject2).jdField_b_of_type_JavaLangString);
    }
    label292:
    if (i == 10)
    {
      agaa.a(1);
      localObject2 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        break label684;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008) {
        break label684;
      }
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject2, 0, 0, "", "", "", "");
      akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_c_of_type_Int);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        localObject2 = "entrance.click.group.quick";
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localObject2 = "entrance.click.chatgroup.quick";
        continue;
        if (i == 6)
        {
          if ((ShortVideoUtils.e()) && (aqbj.a())) {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            setShowRed(6, false);
            bckg.a(bckg.jdField_d_of_type_JavaLangString);
            break;
          }
          if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break;
          }
          setShowRed(6, false);
          ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
          break;
        }
        if (i == 24)
        {
          if (!jdField_a_of_type_Boolean) {
            break;
          }
          setShowRed(24, false);
          ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
          jdField_a_of_type_Boolean = false;
          break;
        }
        if ((i != 8) || (!a(this.jdField_c_of_type_Int))) {
          break;
        }
        ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        setShowRed(8, false);
        break;
        label684:
        localObject2 = "entrance.click.c2c.quick";
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Ahqy != null) {
      return this.jdField_a_of_type_Ahqy.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      return false;
    }
    if (this.jdField_a_of_type_Ahra != null) {
      return this.jdField_a_of_type_Ahra.a(paramView.getTag());
    }
    switch (((Integer)localObject).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Aglu == null);
      paramView = (agmo)this.jdField_a_of_type_Aglu.a(7);
    } while (paramView == null);
    paramView.a();
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, System.identityHashCode(this) + " onMeasure() called with: w = [" + getMeasuredWidth() + "], h = [" + getMeasuredHeight() + "]");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Ahqy != null) {
      return this.jdField_a_of_type_Ahqy.b(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(11)
  public void setAllAlpha(float paramFloat)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).setAlpha(paramFloat);
      }
      for (;;)
      {
        i += 1;
        break;
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        getChildAt(i).startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public void setAllEnable(boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setAllUnSelected()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  @TargetApi(11)
  public void setChildAlpha(int paramInt, float paramFloat)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localView.setAlpha(paramFloat);
      }
    }
    else {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localView.startAnimation(localAlphaAnimation);
  }
  
  public void setChildContentDescription(int paramInt, String paramString)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if ((localView != null) && (AppSetting.jdField_c_of_type_Boolean)) {
      localView.setContentDescription(paramString);
    }
  }
  
  public void setChildImageSource(int paramInt1, int paramInt2)
  {
    ImageView localImageView = (ImageView)findViewWithTag(Integer.valueOf(paramInt1));
    if (localImageView != null) {
      localImageView.setImageResource(paramInt2);
    }
  }
  
  public void setChildVisible(int paramInt1, int paramInt2)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt1));
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, "setCustomHeight() called with: height = [" + paramInt + "]");
    }
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setEnable(int paramInt, boolean paramBoolean)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setHelperProvider(aglu paramaglu)
  {
    this.jdField_a_of_type_Aglu = paramaglu;
  }
  
  public void setInterceptListener(ahqy paramahqy)
  {
    this.jdField_a_of_type_Ahqy = paramahqy;
  }
  
  public void setPanelIconListener(ahqz paramahqz)
  {
    this.jdField_a_of_type_Ahqz = paramahqz;
  }
  
  public void setPanelIconLongListener(ahra paramahra)
  {
    this.jdField_a_of_type_Ahra = paramahra;
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getTag().equals(Integer.valueOf(paramInt))) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setSelected(false);
      }
    }
  }
  
  public void setShowRed(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < getChildCount())
      {
        localObject = getChildAt(i);
        if (!((View)localObject).getTag().equals(Integer.valueOf(paramInt))) {
          break label119;
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label82;
        }
        localObject = azar.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          ahqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(((ayzm)localObject).jdField_b_of_type_Int), ((ayzm)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130850389));
      ((RedDotImageView)localObject).a(paramBoolean);
      return;
      label119:
      i += 1;
    }
  }
  
  public void setUnSelected(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt))) {
          localView.setSelected(false);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */