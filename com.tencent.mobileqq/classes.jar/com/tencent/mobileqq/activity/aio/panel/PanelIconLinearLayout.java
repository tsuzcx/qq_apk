package com.tencent.mobileqq.activity.aio.panel;

import agej;
import agju;
import aguw;
import agvq;
import ahnt;
import aiaf;
import aial;
import aiam;
import aian;
import aiao;
import aifn;
import aifo;
import aiit;
import alil;
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
import aqql;
import asfy;
import avtm;
import azrz;
import azte;
import bbav;
import bdcy;
import bdgb;
import bdll;
import behz;
import bhgr;
import bhjx;
import bkgt;
import bowp;
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
import nlj;
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
  public aguw a;
  private aiam jdField_a_of_type_Aiam;
  private aian jdField_a_of_type_Aian;
  private aiao jdField_a_of_type_Aiao;
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
    setBackgroundResource(2130849892);
    jdField_b_of_type_Int = agej.a(40.0F, paramContext.getResources());
    d();
  }
  
  @NotNull
  private RedTouch a(azrz paramazrz, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramRedDotImageView).a(53).c(15).d(3).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (paramInt == 8)
    {
      paramazrz = localbbav.a(10);
      if (paramazrz != null) {
        paramRedDotImageView.a(paramazrz);
      }
    }
    do
    {
      return paramRedDotImageView;
      paramazrz = localbbav.a(4, String.valueOf(paramazrz.jdField_b_of_type_Int));
    } while (paramazrz == null);
    paramRedDotImageView.a(paramazrz);
    localbbav.b(paramazrz, "");
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
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
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
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
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
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
        paramRedDotImageView.a(true);
      }
      label145:
      if (paramInt != 2) {
        break label244;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103300");
      if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
        break label238;
      }
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
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
        jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(bdcy.a(bdcy.jdField_d_of_type_JavaLangString));
        if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(11);
          paramRedDotImageView.setReddotYOffsetDp(8);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130849758));
          paramRedDotImageView.a(true);
          return;
        }
        if (jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
          paramRedDotImageView.a(true);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
          return;
        }
        paramRedDotImageView.a(false);
        return;
      }
      if (paramInt == 10)
      {
        alil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedDotImageView, this.jdField_c_of_type_Int);
        return;
      }
      if (paramInt == 8)
      {
        if (a(this.jdField_c_of_type_Int))
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
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
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850401));
      paramRedDotImageView.a(true);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if ((!bdgb.b()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)))) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void a(azrz paramazrz, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramazrz.jdField_d_of_type_Int) && (paramSessionInfo != null) && (bhjx.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aiaf.T[2]);
      paramazrz.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramazrz.jdField_d_of_type_Int = aiaf.T[0];
      paramazrz.e = aiaf.T[3];
      paramazrz.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(aiaf.T[1]);
    }
  }
  
  private void a(azrz paramazrz, ArrayList<aifo> paramArrayList, int paramInt)
  {
    int i = paramazrz.jdField_d_of_type_Int;
    RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bhgr.a(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramazrz.jdField_a_of_type_ArrayOfInt != null) && (paramazrz.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (((paramazrz.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramazrz.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramazrz.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))))
      {
        aifo localaifo = new aifo();
        localaifo.jdField_a_of_type_Int = paramInt;
        localaifo.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        paramArrayList.add(localaifo);
      }
    }
    else {
      if (!this.jdField_b_of_type_Boolean) {
        break label364;
      }
    }
    label364:
    for (paramArrayList = paramazrz.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; paramArrayList = paramazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      localRedDotImageView.setImageDrawable(paramArrayList);
      if (AppSetting.jdField_c_of_type_Boolean) {
        localRedDotImageView.setContentDescription(paramazrz.jdField_d_of_type_JavaLangString);
      }
      if (paramazrz.e > 0) {
        localRedDotImageView.setId(paramazrz.e);
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
      localRedDotImageView.setImageResource(paramazrz.jdField_a_of_type_ArrayOfInt[2]);
      break;
    }
    label372:
    addView(a(paramazrz, i, localRedDotImageView), localLayoutParams);
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList;
    if ((paramBaseChatPie != null) && ((paramBaseChatPie instanceof aiit)))
    {
      if (((aiit)paramBaseChatPie).I()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
      }
      if (((aiit)paramBaseChatPie).H())
      {
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label122;
        }
      }
    }
    label122:
    for (int[] arrayOfInt = aiaf.p;; arrayOfInt = aiaf.l)
    {
      localArrayList.add(arrayOfInt);
      g();
      if (((aiit)paramBaseChatPie).E())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.E);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.D);
      }
      if (((aiit)paramBaseChatPie).G()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.J);
      }
      return;
    }
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
    h();
    f();
    if (aiaf.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.C);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
    if (bhjx.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.U);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramInt == 1024) && (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = aiaf.p;
      localArrayList.add(arrayOfInt);
      g();
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label163;
      }
    }
    label163:
    for (int[] arrayOfInt = aiaf.i;; arrayOfInt = aiaf.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.z);
      if ((paramInt == 1024) && (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(aiaf.z);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
      }
      return;
      arrayOfInt = aiaf.l;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<int[]> paramArrayList)
  {
    if ((paramInt == 1024) && (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramArrayList.add(aiaf.d);
    }
    paramArrayList.add(aiaf.o);
    f();
    paramArrayList.add(aiaf.h);
    paramArrayList.add(aiaf.A);
    if ((paramInt == 1024) && (((bkgt)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramArrayList.remove(aiaf.z);
      paramArrayList.add(aiaf.y);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, ArrayList<int[]> paramArrayList)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = localHotChatManager.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramArrayList.add(aiaf.d);
      paramArrayList.add(aiaf.W);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(aiaf.G);
      }
      paramArrayList.add(aiaf.I);
      paramArrayList.add(aiaf.h);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(aiaf.y);
      }
      return;
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    a(nlj.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = aiaf.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (avtm.a(paramQQAppInterface).b()) {
        paramArrayList.add(aiaf.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label64;
      }
    }
    label64:
    for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = aiaf.l;
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
  
  private void a(List<azrz> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (azrz)paramList.get(i);
      if (!a(((azrz)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((azrz)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((azrz)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      aifn.a().a((ArrayList)localObject, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!bhjx.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((asfy)paramQQAppInterface.getManager(334)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = ahnt.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = ahnt.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ahnt.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
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
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = aiaf.p;
      localArrayList.add(arrayOfInt);
      i();
      g();
      if (aiaf.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.B);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label124;
      }
    }
    label124:
    for (int[] arrayOfInt = aiaf.i;; arrayOfInt = aiaf.e)
    {
      localArrayList.add(arrayOfInt);
      if (!bhjx.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label131;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.T);
      this.jdField_c_of_type_Boolean = false;
      return;
      arrayOfInt = aiaf.l;
      break;
    }
    label131:
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
      h();
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        break;
      }
      if (i == 1036)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.X);
        break;
      }
      if (a(paramQQAppInterface, paramSessionInfo, i))
      {
        a(paramSessionInfo);
        break;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
        break;
      }
      if (e(i))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.A);
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.A);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.A);
        e();
        break;
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
        break;
      }
      if (b(i))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
        f();
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
      break;
      label778:
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    paramArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = aiaf.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (avtm.a(paramQQAppInterface).b()) {
        paramArrayList.add(aiaf.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = aiaf.l;
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
    int i = ahnt.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = ahnt.a(paramSharedPreferences);; bool1 = false)
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
        QLog.d(ahnt.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.V);
      if (!paramSessionInfo.isRobotHotChat) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.F);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.H);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        if (!paramSessionInfo.isRobotHotChat) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
        }
        return;
      }
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    a(nlj.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie);
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1033) || (paramInt == 1034);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.e, aiaf.i);
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.f, aiaf.j);
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.g, aiaf.k);
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.l, aiaf.p);
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.m, aiaf.q);
    this.jdField_b_of_type_JavaUtilMap.put(aiaf.n, aiaf.r);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.i, aiaf.e);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.j, aiaf.f);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.k, aiaf.g);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.p, aiaf.l);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.q, aiaf.m);
    this.jdField_a_of_type_JavaUtilMap.put(aiaf.r, aiaf.n);
  }
  
  private boolean d(int paramInt)
  {
    return (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1009) || (paramInt == 1024);
  }
  
  private void e()
  {
    if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.O);
    }
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008) || (paramInt == 10010);
  }
  
  private void f()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aiaf.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aiaf.s[2] = 2130844827;
        aiaf.s[5] = 0;
        aiaf.s[6] = 0;
      }
      return;
    }
  }
  
  private void g()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aiaf.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.s);
      }
      return;
    }
  }
  
  private void h()
  {
    if (ShortVideoUtils.f()) {
      aiaf.v[2] = 2130844838;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.v);
      return;
      aiaf.v[2] = 2130844827;
    }
  }
  
  private void i()
  {
    if (ShortVideoUtils.f())
    {
      aiaf.v[2] = 2130838192;
      aiaf.v[5] = 2130849958;
      aiaf.v[6] = 2130849959;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.v);
      return;
      aiaf.v[2] = 2130838115;
      aiaf.v[5] = 2130849860;
      aiaf.v[6] = 2130849861;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label78;
      }
      arrayOfInt = aiaf.p;
      localArrayList.add(arrayOfInt);
      g();
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.N);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label85;
      }
    }
    label78:
    label85:
    for (int[] arrayOfInt = aiaf.i;; arrayOfInt = aiaf.e)
    {
      localArrayList.add(arrayOfInt);
      return;
      arrayOfInt = aiaf.l;
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
    paramView.setOnLongClickListener(new aial(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.b);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aiaf.q;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.t);
      if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.R);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aiaf.j;; paramQQAppInterface = aiaf.f)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      paramQQAppInterface = aiaf.m;
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
      setBackgroundResource(2130849892);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130844832);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label76;
      }
      arrayOfInt = aiaf.p;
      localArrayList.add(arrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = aiaf.i;; arrayOfInt = aiaf.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      arrayOfInt = aiaf.l;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aiaf.q;
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.t);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = aiaf.j;; paramQQAppInterface = aiaf.f)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.x);
        return;
        paramQQAppInterface = aiaf.m;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.o);
      h();
      f();
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.A);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.y);
        return;
        if (aiaf.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.C);
        }
      }
    }
    this.d = true;
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aiaf.p;
      paramBaseChatPie.add(paramQQAppInterface);
      i();
      g();
      if (!paramBoolean2) {
        break label304;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.z);
      label261:
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
      return;
      paramQQAppInterface = aiaf.l;
      break;
      if (!aiaf.jdField_a_of_type_Boolean) {
        break label261;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.B);
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
        localObject2 = azte.a(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext);
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
        localObject3 = new azrz();
        ((azrz)localObject3).jdField_d_of_type_Int = localObject2[0];
        ((azrz)localObject3).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(localObject2[1]);
        ((azrz)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject2[2]);
        ((azrz)localObject3).e = localObject2[3];
        ((azrz)localObject3).jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
    }
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        localObject2 = (azrz)((List)localObject1).get(i);
        if ((!this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((azrz)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = azte.b(((azrz)localObject2).jdField_a_of_type_Int);
          if (localObject3 != null) {
            ((azrz)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((azrz)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = azte.b(((azrz)localObject2).jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label403;
          }
          ((azrz)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
        }
        for (;;)
        {
          i += 1;
          break;
          label403:
          if (((azrz)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            ((azrz)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((azrz)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
      }
      a((List)localObject1);
      behz.a().b(this.jdField_a_of_type_AndroidContentContext, this);
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
    this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.c);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aiaf.r;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.u);
      if (avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.N);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aiaf.k;; paramQQAppInterface = aiaf.g)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
      paramQQAppInterface = aiaf.n;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aiaf.p;
        paramSessionInfo.add(paramQQAppInterface);
        i();
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label220;
        }
        paramQQAppInterface = aiaf.i;
        label162:
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
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
      paramQQAppInterface = aiaf.l;
      break;
      label220:
      paramQQAppInterface = aiaf.e;
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
          paramQQAppInterface = aiaf.p;
          label308:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label361;
          }
        }
        label361:
        for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.X);
          break;
          paramQQAppInterface = aiaf.l;
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
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
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
          paramQQAppInterface = aiaf.p;
          label463:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label516;
          }
        }
        label516:
        for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.z);
          break;
          paramQQAppInterface = aiaf.l;
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
          paramQQAppInterface = aiaf.p;
          label555:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label608;
          }
        }
        label608:
        for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.z);
          break;
          paramQQAppInterface = aiaf.l;
          break label555;
        }
      }
      if (i == 1003)
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramSessionInfo = aiaf.p;; paramSessionInfo = aiaf.l)
        {
          paramBaseChatPie.add(paramSessionInfo);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.z);
          if (!avtm.a(paramQQAppInterface).b()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.N);
          break;
        }
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aiaf.p;
          label726:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label779;
          }
        }
        label779:
        for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
          break;
          paramQQAppInterface = aiaf.l;
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
        for (paramQQAppInterface = aiaf.p;; paramQQAppInterface = aiaf.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.J);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.K);
          break;
        }
      }
      if (i == 6003)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = aiaf.p;; paramQQAppInterface = aiaf.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          g();
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.J);
          break;
        }
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aiaf.p;
          label963:
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1016;
          }
        }
        label1016:
        for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aiaf.w);
          break;
          paramQQAppInterface = aiaf.l;
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
        paramQQAppInterface = aiaf.p;
        label1070:
        paramSessionInfo.add(paramQQAppInterface);
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label1112;
        }
      }
      label1112:
      for (paramQQAppInterface = aiaf.i;; paramQQAppInterface = aiaf.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        break;
        paramQQAppInterface = aiaf.l;
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
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10);
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
        bowp.a().d();
        bowp.a().a("userClick");
      }
      azrz localazrz = azte.a(((Integer)localObject1).intValue());
      if (localazrz != null) {
        aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(localazrz.jdField_b_of_type_Int), localazrz.jdField_a_of_type_Int);
      }
      do
      {
        do
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Aian != null) {
              this.jdField_a_of_type_Aian.a(paramView.getTag());
            }
            try
            {
              i = ((Integer)paramView.getTag()).intValue();
              if (i != 2) {
                break label292;
              }
              ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("103100.103300");
              if ((paramView instanceof RedDotImageView)) {
                ((RedDotImageView)paramView).a(false);
              }
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
            }
            catch (Exception localException)
            {
              QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + localException.getMessage());
            }
          }
          break;
          localObject2 = azte.a(((Integer)localException).intValue(), true);
        } while (localObject2 == null);
        if ("web".equals(((azrz)localObject2).jdField_a_of_type_JavaLangString))
        {
          a(((azrz)localObject2).jdField_b_of_type_JavaLangString);
          break;
        }
      } while (!"miniapp".equals(((azrz)localObject2).jdField_a_of_type_JavaLangString));
      b(((azrz)localObject2).jdField_b_of_type_JavaLangString);
    }
    label292:
    if (i == 10)
    {
      agju.a(1);
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject2, 0, 0, "", "", "", "");
      alil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_c_of_type_Int);
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
          if ((ShortVideoUtils.e()) && (aqql.a())) {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            setShowRed(6, false);
            bdcy.a(bdcy.jdField_d_of_type_JavaLangString);
            break;
          }
          if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break;
          }
          setShowRed(6, false);
          ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Aiam != null) {
      return this.jdField_a_of_type_Aiam.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      return false;
    }
    if (this.jdField_a_of_type_Aiao != null) {
      return this.jdField_a_of_type_Aiao.a(paramView.getTag());
    }
    switch (((Integer)localObject).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Aguw == null);
      paramView = (agvq)this.jdField_a_of_type_Aguw.a(7);
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
    if (this.jdField_a_of_type_Aiam != null) {
      return this.jdField_a_of_type_Aiam.b(paramMotionEvent);
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
  
  public void setHelperProvider(aguw paramaguw)
  {
    this.jdField_a_of_type_Aguw = paramaguw;
  }
  
  public void setInterceptListener(aiam paramaiam)
  {
    this.jdField_a_of_type_Aiam = paramaiam;
  }
  
  public void setPanelIconListener(aian paramaian)
  {
    this.jdField_a_of_type_Aian = paramaian;
  }
  
  public void setPanelIconLongListener(aiao paramaiao)
  {
    this.jdField_a_of_type_Aiao = paramaiao;
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
        localObject = azte.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          aiaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(((azrz)localObject).jdField_b_of_type_Int), ((azrz)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130850401));
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