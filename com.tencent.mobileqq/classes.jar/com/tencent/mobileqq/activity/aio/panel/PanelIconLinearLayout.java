package com.tencent.mobileqq.activity.aio.panel;

import actn;
import acxv;
import adwl;
import aefv;
import aefz;
import aega;
import aegb;
import aekr;
import aeks;
import aenv;
import ahiy;
import amfw;
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
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anrs;
import aqzc;
import aupe;
import auqe;
import avpq;
import axjq;
import axmt;
import axqw;
import ayls;
import bawz;
import bbbd;
import bdto;
import biwd;
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
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mye;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static Boolean a;
  public static boolean a;
  public static int b;
  public static Boolean b;
  public int a;
  private aega jdField_a_of_type_Aega;
  private aegb jdField_a_of_type_Aegb;
  public Context a;
  public SharedPreferences a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOLongCaptureCtrl jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl;
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
    setBackgroundResource(2130848820);
    jdField_b_of_type_Int = actn.a(40.0F, paramContext.getResources());
    c();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if ((!axmt.b()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)))) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void a(aupe paramaupe, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramaupe.jdField_d_of_type_Int) && (paramSessionInfo != null) && (bbbd.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramaupe.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aefv.T[2]);
      paramaupe.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramaupe.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramaupe.jdField_d_of_type_Int = aefv.T[0];
      paramaupe.e = aefv.T[3];
      paramaupe.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(aefv.T[1]);
    }
  }
  
  private void a(aupe paramaupe, ArrayList<aeks> paramArrayList, int paramInt)
  {
    int i = paramaupe.jdField_d_of_type_Int;
    Object localObject = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
    ((RedDotImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((RedDotImageView)localObject).setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bawz.a(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    ((RedDotImageView)localObject).setTag(Integer.valueOf(i));
    if ((paramaupe.jdField_a_of_type_ArrayOfInt != null) && (paramaupe.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (((paramaupe.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramaupe.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramaupe.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))))
      {
        aeks localaeks = new aeks();
        localaeks.jdField_a_of_type_Int = paramInt;
        localaeks.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)localObject);
        paramArrayList.add(localaeks);
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label593;
      }
      paramArrayList = paramaupe.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label268:
      ((RedDotImageView)localObject).setImageDrawable(paramArrayList);
      if (AppSetting.d) {
        ((RedDotImageView)localObject).setContentDescription(paramaupe.jdField_d_of_type_JavaLangString);
      }
      if (paramaupe.e > 0) {
        ((RedDotImageView)localObject).setId(paramaupe.e);
      }
      ((RedDotImageView)localObject).setOnClickListener(this);
      ((RedDotImageView)localObject).setSelected(false);
      a((View)localObject, i);
      if (this.jdField_c_of_type_Boolean) {
        break label1028;
      }
      if (i == 23)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label601;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
        ((RedDotImageView)localObject).a(true);
      }
      label388:
      if (i == 26)
      {
        if (!b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label610;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
        ((RedDotImageView)localObject).a(true);
      }
      label444:
      if (i == 3)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label619;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
        ((RedDotImageView)localObject).a(true);
      }
      label495:
      if (i != 2) {
        break label637;
      }
      paramaupe = ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103300");
      if ((paramaupe == null) || (paramaupe.iNewFlag.get() != 1)) {
        break label628;
      }
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setReddotYOffsetDp(11);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
      ((RedDotImageView)localObject).a(true);
    }
    for (;;)
    {
      addView((View)localObject, localLayoutParams);
      return;
      ((RedDotImageView)localObject).setImageResource(paramaupe.jdField_a_of_type_ArrayOfInt[2]);
      break;
      label593:
      paramArrayList = paramaupe.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label268;
      label601:
      ((RedDotImageView)localObject).a(false);
      break label388;
      label610:
      ((RedDotImageView)localObject).a(false);
      break label444;
      label619:
      ((RedDotImageView)localObject).a(false);
      break label495;
      label628:
      ((RedDotImageView)localObject).a(false);
      continue;
      label637:
      if (i == 6)
      {
        if (!ShortVideoUtils.e)
        {
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          ShortVideoUtils.e = true;
        }
        jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(axjq.a(axjq.jdField_d_of_type_JavaLangString));
        if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(11);
          ((RedDotImageView)localObject).setReddotYOffsetDp(8);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130848687));
          ((RedDotImageView)localObject).a(true);
        }
        else if (jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(15);
          ((RedDotImageView)localObject).setReddotYOffsetDp(11);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
          ((RedDotImageView)localObject).a(true);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
        }
        else
        {
          ((RedDotImageView)localObject).a(false);
        }
      }
      else if (i == 10)
      {
        ahiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RedDotImageView)localObject, this.jdField_c_of_type_Int);
      }
      else if (i == 8)
      {
        if (a(this.jdField_c_of_type_Int))
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(15);
          ((RedDotImageView)localObject).setReddotYOffsetDp(11);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
          ((RedDotImageView)localObject).a(true);
        }
        else
        {
          ((RedDotImageView)localObject).a(false);
        }
      }
      else if (i == 24)
      {
        if (!ShortVideoUtils.f)
        {
          jdField_a_of_type_Boolean = ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ShortVideoUtils.f = true;
        }
        if (jdField_a_of_type_Boolean)
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(15);
          ((RedDotImageView)localObject).setReddotYOffsetDp(11);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
          ((RedDotImageView)localObject).a(true);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
        }
        else
        {
          ((RedDotImageView)localObject).a(false);
        }
      }
    }
    label1028:
    paramArrayList = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject).a(53).c(15).d(3).a(true).a();
    paramArrayList.setTag(Integer.valueOf(i));
    localObject = (avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (i == 8)
    {
      paramaupe = ((avpq)localObject).a(10);
      if (paramaupe != null) {
        paramArrayList.a(paramaupe);
      }
    }
    for (;;)
    {
      addView(paramArrayList, localLayoutParams);
      return;
      paramaupe = ((avpq)localObject).a(4, String.valueOf(paramaupe.jdField_b_of_type_Int));
      if (paramaupe != null)
      {
        paramArrayList.a(paramaupe);
        ((avpq)localObject).b(paramaupe, "");
      }
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
  
  private void a(List<aupe> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (aupe)paramList.get(i);
      if (!a(((aupe)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((aupe)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((aupe)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      aekr.a().a((ArrayList)localObject, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!bbbd.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((anrs)paramQQAppInterface.getManager(334)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = adwl.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = adwl.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(adwl.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
      g();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label1185;
      }
      setCustomHeight(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      a();
      return;
      if (i == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramQQAppInterface = localHotChatManager.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.W);
          if (!paramQQAppInterface.isRobotHotChat) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.G);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.I);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
          if (paramQQAppInterface.isRobotHotChat) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
          break;
        }
        boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        a(mye.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie, true);
        break;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        if ((i == 1024) && (((bdto)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.A);
        if ((i != 1024) || (!((bdto)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(aefv.z);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        break;
      }
      if ((i == 1033) || (i == 1034))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        break;
      }
      if (i == 1036)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.X);
        break;
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_Boolean = true;
        this.d = false;
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        g();
        e();
        if (aefv.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.C);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        if (bbbd.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.U);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        break;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        break;
      }
      if ((i == 1000) || (i == 1004) || (i == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.A);
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.A);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.A);
        d();
        break;
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        break;
      }
      if ((i == 1001) || (i == 10002))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
      break;
      label1185:
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramString, 2053, null);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = adwl.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = adwl.a(paramSharedPreferences);; bool1 = false)
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
        QLog.d(adwl.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaUtilMap.put(aefv.e, aefv.i);
    this.jdField_b_of_type_JavaUtilMap.put(aefv.f, aefv.j);
    this.jdField_b_of_type_JavaUtilMap.put(aefv.g, aefv.k);
    this.jdField_b_of_type_JavaUtilMap.put(aefv.l, aefv.p);
    this.jdField_b_of_type_JavaUtilMap.put(aefv.m, aefv.q);
    this.jdField_b_of_type_JavaUtilMap.put(aefv.n, aefv.r);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.i, aefv.e);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.j, aefv.f);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.k, aefv.g);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.p, aefv.l);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.q, aefv.m);
    this.jdField_a_of_type_JavaUtilMap.put(aefv.r, aefv.n);
  }
  
  private void d()
  {
    if (aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.O);
    }
  }
  
  private void e()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aefv.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aefv.s[2] = 2130844003;
        aefv.s[5] = 0;
        aefv.s[6] = 0;
      }
      return;
    }
  }
  
  private void f()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aefv.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.s);
      }
      return;
    }
  }
  
  private void g()
  {
    if (ShortVideoUtils.f()) {
      aefv.v[2] = 2130844014;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.v);
      return;
      aefv.v[2] = 2130844003;
    }
  }
  
  private void h()
  {
    if (ShortVideoUtils.f())
    {
      aefv.v[2] = 2130838031;
      aefv.v[5] = 2130848886;
      aefv.v[6] = 2130848887;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.v);
      return;
      aefv.v[2] = 2130837954;
      aefv.v[5] = 2130848788;
      aefv.v[6] = 2130848789;
    }
  }
  
  public ArrayList<int[]> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    int j = 0;
    removeAllViews();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject2 = auqe.a(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext);
      if ((localObject2 == null) && (QLog.isColorLevel()))
      {
        localObject3 = new StringBuilder().append("session: ");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label239;
        }
      }
    }
    int i;
    label239:
    for (localObject1 = "";; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      QLog.e("PanelIconLinearLayout", 2, localObject1 + " did not use config");
      localObject1 = localObject2;
      if ((!this.d) && (this.jdField_c_of_type_Boolean) && (localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label433;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject3 = new aupe();
        ((aupe)localObject3).jdField_d_of_type_Int = localObject2[0];
        ((aupe)localObject3).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(localObject2[1]);
        ((aupe)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject2[2]);
        ((aupe)localObject3).e = localObject2[3];
        ((aupe)localObject3).jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
    }
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        localObject2 = (aupe)((List)localObject1).get(i);
        if ((!this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((aupe)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = auqe.b(((aupe)localObject2).jdField_a_of_type_Int);
          if (localObject3 != null) {
            ((aupe)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((aupe)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = auqe.b(((aupe)localObject2).jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label390;
          }
          ((aupe)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
        }
        for (;;)
        {
          i += 1;
          break;
          label390:
          if (((aupe)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            ((aupe)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((aupe)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
      }
      a((List)localObject1);
      ayls.a().b(this.jdField_a_of_type_AndroidContentContext, this);
      return;
      i = j;
      continue;
      label433:
      i = j;
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
    paramView.setOnLongClickListener(new aefz(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(aefv.b);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aefv.q;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.t);
      if (aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.R);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aefv.j;; paramQQAppInterface = aefv.f)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      paramQQAppInterface = aefv.m;
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
      setBackgroundResource(2130848820);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130844008);
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
      a();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label76;
      }
      arrayOfInt = aefv.p;
      localArrayList.add(arrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = aefv.i;; arrayOfInt = aefv.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      arrayOfInt = aefv.l;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aefv.q;
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.t);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = aefv.j;; paramQQAppInterface = aefv.f)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.x);
        return;
        paramQQAppInterface = aefv.m;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.o);
      g();
      e();
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.A);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.y);
        return;
        if (aefv.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.C);
        }
      }
    }
    this.d = true;
    this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aefv.p;
      paramBaseChatPie.add(paramQQAppInterface);
      h();
      f();
      if (!paramBoolean2) {
        break label304;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.z);
      label261:
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
      return;
      paramQQAppInterface = aefv.l;
      break;
      if (!aefv.jdField_a_of_type_Boolean) {
        break label261;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.B);
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
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10);
          ((RedTouch)localView).a(localRedTypeInfo);
        }
      }
      return;
      label90:
      i -= 1;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(aefv.c);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aefv.r;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.u);
      if (aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aefv.k;; paramQQAppInterface = aefv.g)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      paramQQAppInterface = aefv.n;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aefv.p;
        paramSessionInfo.add(paramQQAppInterface);
        h();
        f();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label219;
        }
        paramQQAppInterface = aefv.i;
        label161:
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
        label178:
        a(i, paramBoolean);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label2053;
        }
        setCustomHeight(0);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      a();
      return;
      paramQQAppInterface = aefv.l;
      break;
      label219:
      paramQQAppInterface = aefv.e;
      break label161;
      Object localObject;
      if (i == 1)
      {
        localObject = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramSessionInfo = ((HotChatManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.V);
          if (!paramSessionInfo.isRobotHotChat) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.F);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.H);
          paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
          if (this.jdField_b_of_type_Boolean) {}
          for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
          {
            paramBaseChatPie.add(paramQQAppInterface);
            if (paramSessionInfo.isRobotHotChat) {
              break;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
            break;
          }
        }
        boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        a(mye.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie);
        break label178;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        if ((i == 1024) && (((bdto)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        }
        localObject = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramBaseChatPie = aefv.p;
          label490:
          ((ArrayList)localObject).add(paramBaseChatPie);
          f();
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label596;
          }
        }
        label596:
        for (paramBaseChatPie = aefv.i;; paramBaseChatPie = aefv.e)
        {
          ((ArrayList)localObject).add(paramBaseChatPie);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.z);
          if ((i != 1024) || (!((bdto)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(aefv.z);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
          break;
          paramBaseChatPie = aefv.l;
          break label490;
        }
      }
      if ((i == 1033) || (i == 1034))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aefv.p;
          label646:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (aqzc.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label709;
          }
        }
        label709:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aefv.l;
          break label646;
        }
      }
      if (i == 1036)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label740:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label793;
          }
        }
        label793:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.X);
          break;
          paramQQAppInterface = aefv.l;
          break label740;
        }
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_Boolean = true;
        this.d = false;
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label853:
          paramBaseChatPie.add(paramQQAppInterface);
          h();
          f();
          if (aefv.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.B);
          }
          paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label937;
          }
        }
        label937:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramBaseChatPie.add(paramQQAppInterface);
          if (!bbbd.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label944;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.T);
          break;
          paramQQAppInterface = aefv.l;
          break label853;
        }
        label944:
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
        break label178;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aefv.p;
          label993:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (aqzc.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1067;
          }
        }
        label1067:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
          break;
          paramSessionInfo = aefv.l;
          break label993;
        }
      }
      if ((i == 1000) || (i == 1004) || (i == 1006))
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aefv.p;
          label1114:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (aqzc.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1177;
          }
        }
        label1177:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aefv.l;
          break label1114;
        }
      }
      if (i == 1020)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label1208:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1261;
          }
        }
        label1261:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.z);
          break;
          paramQQAppInterface = aefv.l;
          break label1208;
        }
      }
      if (i == 1008) {
        break label178;
      }
      if (i == 1005)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label1300:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1353;
          }
        }
        label1353:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.z);
          break;
          paramQQAppInterface = aefv.l;
          break label1300;
        }
      }
      if (i == 1003)
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramSessionInfo = aefv.p;; paramSessionInfo = aefv.l)
        {
          paramBaseChatPie.add(paramSessionInfo);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.z);
          if (!aqzc.a(paramQQAppInterface).b()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
          break;
        }
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label1471:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1524;
          }
        }
        label1524:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
          break;
          paramQQAppInterface = aefv.l;
          break label1471;
        }
      }
      if ((i == 1001) || (i == 10002))
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aefv.p;
          label1563:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (aqzc.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1626;
          }
        }
        label1626:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aefv.l;
          break label1563;
        }
      }
      if (i == 6000)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = aefv.p;; paramQQAppInterface = aefv.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.J);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.K);
          break;
        }
      }
      if (i == 6003)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = aefv.p;; paramQQAppInterface = aefv.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.J);
          break;
        }
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aefv.p;
          label1789:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1842;
          }
        }
        label1842:
        for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.w);
          break;
          paramQQAppInterface = aefv.l;
          break label1789;
        }
      }
      if (i == 9501)
      {
        if ((paramBaseChatPie == null) || (!(paramBaseChatPie instanceof aenv))) {
          break label178;
        }
        if (((aenv)paramBaseChatPie).H()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.jdField_a_of_type_ArrayOfInt);
        }
        if (((aenv)paramBaseChatPie).G())
        {
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1981;
          }
        }
        label1981:
        for (paramQQAppInterface = aefv.p;; paramQQAppInterface = aefv.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          if (((aenv)paramBaseChatPie).D())
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.E);
            this.jdField_a_of_type_JavaUtilArrayList.add(aefv.D);
          }
          if (!((aenv)paramBaseChatPie).F()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aefv.J);
          break;
        }
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aefv.p;
        label2004:
        paramSessionInfo.add(paramQQAppInterface);
        f();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label2046;
        }
      }
      label2046:
      for (paramQQAppInterface = aefv.i;; paramQQAppInterface = aefv.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        break;
        paramQQAppInterface = aefv.l;
        break label2004;
      }
      label2053:
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
        a();
      }
      do
      {
        return;
      } while (j == 0);
      a();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      return;
    }
    if (((Integer)localObject).intValue() == 6)
    {
      biwd.a().b();
      biwd.a().a("userClick");
    }
    aupe localaupe = auqe.a(((Integer)localObject).intValue());
    if (localaupe != null) {
      aefv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(localaupe.jdField_b_of_type_Int), localaupe.jdField_a_of_type_Int);
    }
    int i;
    do
    {
      do
      {
        if (this.jdField_a_of_type_Aegb != null) {
          this.jdField_a_of_type_Aegb.a(paramView.getTag());
        }
        try
        {
          i = ((Integer)paramView.getTag()).intValue();
          if (i != 2) {
            break;
          }
          ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("103100.103300");
          if ((paramView instanceof RedDotImageView)) {
            ((RedDotImageView)paramView).a(false);
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramView)
        {
          QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
          return;
        }
        localObject = auqe.a(((Integer)localObject).intValue(), true);
      } while (localObject == null);
      if ("web".equals(((aupe)localObject).jdField_a_of_type_JavaLangString))
      {
        a(((aupe)localObject).jdField_b_of_type_JavaLangString);
        return;
      }
    } while (!"miniapp".equals(((aupe)localObject).jdField_a_of_type_JavaLangString));
    b(((aupe)localObject).jdField_b_of_type_JavaLangString);
    return;
    if (i == 10)
    {
      acxv.a(1);
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000)) {
        break label680;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) {
        break label680;
      }
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject, 0, 0, "", "", "", "");
      ahiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_c_of_type_Int);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        localObject = "entrance.click.group.quick";
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localObject = "entrance.click.chatgroup.quick";
        continue;
        if (i == 6)
        {
          if ((ShortVideoUtils.e()) && (amfw.a())) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            setShowRed(6, false);
            axjq.a(axjq.jdField_d_of_type_JavaLangString);
            return;
          }
          if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break;
          }
          setShowRed(6, false);
          ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
          return;
        }
        if (i == 24)
        {
          if (!jdField_a_of_type_Boolean) {
            break;
          }
          setShowRed(24, false);
          ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
          jdField_a_of_type_Boolean = false;
          return;
        }
        if ((i != 8) || (!a(this.jdField_c_of_type_Int))) {
          break;
        }
        ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        setShowRed(8, false);
        return;
        label680:
        localObject = "entrance.click.c2c.quick";
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aega != null) {
      return this.jdField_a_of_type_Aega.a(paramMotionEvent);
    }
    return false;
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
    if (this.jdField_a_of_type_Aega != null) {
      return this.jdField_a_of_type_Aega.b(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAIOLongCaptureCtrlListener(AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = paramAIOLongCaptureCtrl;
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
    if ((localView != null) && (AppSetting.d)) {
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
  
  public void setInterceptListener(aega paramaega)
  {
    this.jdField_a_of_type_Aega = paramaega;
  }
  
  public void setPanelIconListener(aegb paramaegb)
  {
    this.jdField_a_of_type_Aegb = paramaegb;
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
          break label120;
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label82;
        }
        localObject = auqe.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          aefv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(((aupe)localObject).jdField_b_of_type_Int), ((aupe)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849289));
      ((RedDotImageView)localObject).a(paramBoolean);
      return;
      label120:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */