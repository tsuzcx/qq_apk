package com.tencent.mobileqq.activity.aio.panel;

import aepi;
import aetu;
import afev;
import affo;
import afxl;
import aggx;
import aghb;
import aghc;
import aghd;
import aghe;
import aglv;
import aglw;
import agoz;
import ajeu;
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
import aobe;
import apno;
import asub;
import awkx;
import awmb;
import axlx;
import azjh;
import azmk;
import azqs;
import banz;
import bdaq;
import bdeu;
import bfyh;
import blfv;
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
import nav;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static Boolean a;
  public static boolean a;
  public static int b;
  public static Boolean b;
  public int a;
  protected afev a;
  private aghc jdField_a_of_type_Aghc;
  private aghd jdField_a_of_type_Aghd;
  private aghe jdField_a_of_type_Aghe;
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
    setBackgroundResource(2130849330);
    jdField_b_of_type_Int = aepi.a(40.0F, paramContext.getResources());
    c();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if ((!azmk.b()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)))) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void a(awkx paramawkx, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramawkx.jdField_d_of_type_Int) && (paramSessionInfo != null) && (bdeu.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aggx.T[2]);
      paramawkx.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramawkx.jdField_d_of_type_Int = aggx.T[0];
      paramawkx.e = aggx.T[3];
      paramawkx.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(aggx.T[1]);
    }
  }
  
  private void a(awkx paramawkx, ArrayList<aglw> paramArrayList, int paramInt)
  {
    int i = paramawkx.jdField_d_of_type_Int;
    Object localObject = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
    ((RedDotImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((RedDotImageView)localObject).setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, bdaq.a(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    ((RedDotImageView)localObject).setTag(Integer.valueOf(i));
    if ((paramawkx.jdField_a_of_type_ArrayOfInt != null) && (paramawkx.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (((paramawkx.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramawkx.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) || ((paramawkx.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))))
      {
        aglw localaglw = new aglw();
        localaglw.jdField_a_of_type_Int = paramInt;
        localaglw.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)localObject);
        paramArrayList.add(localaglw);
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label605;
      }
      paramArrayList = paramawkx.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label268:
      ((RedDotImageView)localObject).setImageDrawable(paramArrayList);
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((RedDotImageView)localObject).setContentDescription(paramawkx.jdField_d_of_type_JavaLangString);
      }
      if (paramawkx.e > 0) {
        ((RedDotImageView)localObject).setId(paramawkx.e);
      }
      ((RedDotImageView)localObject).setLongClickable(true);
      ((RedDotImageView)localObject).setOnLongClickListener(this);
      ((RedDotImageView)localObject).setOnClickListener(this);
      ((RedDotImageView)localObject).setSelected(false);
      a((View)localObject, i);
      if (this.jdField_c_of_type_Boolean) {
        break label1040;
      }
      if (i == 23)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label613;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
        ((RedDotImageView)localObject).a(true);
      }
      label400:
      if (i == 26)
      {
        if (!b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label622;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
        ((RedDotImageView)localObject).a(true);
      }
      label456:
      if (i == 3)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label631;
        }
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setReddotYOffsetDp(11);
        ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
        ((RedDotImageView)localObject).a(true);
      }
      label507:
      if (i != 2) {
        break label649;
      }
      paramawkx = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103300");
      if ((paramawkx == null) || (paramawkx.iNewFlag.get() != 1)) {
        break label640;
      }
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setReddotYOffsetDp(11);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
      ((RedDotImageView)localObject).a(true);
    }
    for (;;)
    {
      addView((View)localObject, localLayoutParams);
      return;
      ((RedDotImageView)localObject).setImageResource(paramawkx.jdField_a_of_type_ArrayOfInt[2]);
      break;
      label605:
      paramArrayList = paramawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label268;
      label613:
      ((RedDotImageView)localObject).a(false);
      break label400;
      label622:
      ((RedDotImageView)localObject).a(false);
      break label456;
      label631:
      ((RedDotImageView)localObject).a(false);
      break label507;
      label640:
      ((RedDotImageView)localObject).a(false);
      continue;
      label649:
      if (i == 6)
      {
        if (!ShortVideoUtils.e)
        {
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          ShortVideoUtils.e = true;
        }
        jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(azjh.a(azjh.jdField_d_of_type_JavaLangString));
        if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(11);
          ((RedDotImageView)localObject).setReddotYOffsetDp(8);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849198));
          ((RedDotImageView)localObject).a(true);
        }
        else if (jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(15);
          ((RedDotImageView)localObject).setReddotYOffsetDp(11);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
          ((RedDotImageView)localObject).a(true);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
        }
        else
        {
          ((RedDotImageView)localObject).a(false);
        }
      }
      else if (i == 10)
      {
        ajeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RedDotImageView)localObject, this.jdField_c_of_type_Int);
      }
      else if (i == 8)
      {
        if (a(this.jdField_c_of_type_Int))
        {
          ((RedDotImageView)localObject).setReddotXOffsetDp(15);
          ((RedDotImageView)localObject).setReddotYOffsetDp(11);
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
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
          ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
          ((RedDotImageView)localObject).a(true);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
        }
        else
        {
          ((RedDotImageView)localObject).a(false);
        }
      }
    }
    label1040:
    paramArrayList = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject).a(53).c(15).d(3).a(true).a();
    paramArrayList.setTag(Integer.valueOf(i));
    localObject = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (i == 8)
    {
      paramawkx = ((axlx)localObject).a(10);
      if (paramawkx != null) {
        paramArrayList.a(paramawkx);
      }
    }
    for (;;)
    {
      addView(paramArrayList, localLayoutParams);
      return;
      paramawkx = ((axlx)localObject).a(4, String.valueOf(paramawkx.jdField_b_of_type_Int));
      if (paramawkx != null)
      {
        paramArrayList.a(paramawkx);
        ((axlx)localObject).b(paramawkx, "");
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
  
  private void a(List<awkx> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (awkx)paramList.get(i);
      if (!a(((awkx)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((awkx)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((awkx)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      aglv.a().a((ArrayList)localObject, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!bdeu.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((apno)paramQQAppInterface.getManager(334)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = afxl.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = afxl.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(afxl.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
      g();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label1198;
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
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.W);
          if (!paramQQAppInterface.isRobotHotChat) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.G);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.I);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
          if (paramQQAppInterface.isRobotHotChat) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
          break;
        }
        boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        a(nav.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie, true);
        break;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        if ((i == 1024) && (((bfyh)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.A);
        if ((i != 1024) || (!((bfyh)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(aggx.z);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        break;
      }
      if ((i == 1033) || (i == 1034))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        break;
      }
      if (i == 1036)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.X);
        break;
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_Boolean = true;
        this.d = false;
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        g();
        e();
        if (aggx.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.C);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        if (bdeu.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.U);
          this.jdField_c_of_type_Boolean = false;
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        break;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        break;
      }
      if ((i == 1000) || (i == 1004) || (i == 1006) || (i == 10008))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.A);
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.A);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.A);
        d();
        break;
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        break;
      }
      if ((i == 1001) || (i == 10002))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        d();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
        e();
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
      break;
      label1198:
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
    int i = afxl.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = afxl.a(paramSharedPreferences);; bool1 = false)
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
        QLog.d(afxl.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaUtilMap.put(aggx.e, aggx.i);
    this.jdField_b_of_type_JavaUtilMap.put(aggx.f, aggx.j);
    this.jdField_b_of_type_JavaUtilMap.put(aggx.g, aggx.k);
    this.jdField_b_of_type_JavaUtilMap.put(aggx.l, aggx.p);
    this.jdField_b_of_type_JavaUtilMap.put(aggx.m, aggx.q);
    this.jdField_b_of_type_JavaUtilMap.put(aggx.n, aggx.r);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.i, aggx.e);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.j, aggx.f);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.k, aggx.g);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.p, aggx.l);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.q, aggx.m);
    this.jdField_a_of_type_JavaUtilMap.put(aggx.r, aggx.n);
  }
  
  private void d()
  {
    if (asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.O);
    }
  }
  
  private void e()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aggx.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aggx.s[2] = 2130844419;
        aggx.s[5] = 0;
        aggx.s[6] = 0;
      }
      return;
    }
  }
  
  private void f()
  {
    if ((ShortVideoUtils.f()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(aggx.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.s);
      }
      return;
    }
  }
  
  private void g()
  {
    if (ShortVideoUtils.f()) {
      aggx.v[2] = 2130844430;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.v);
      return;
      aggx.v[2] = 2130844419;
    }
  }
  
  private void h()
  {
    if (ShortVideoUtils.f())
    {
      aggx.v[2] = 2130838088;
      aggx.v[5] = 2130849396;
      aggx.v[6] = 2130849397;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.v);
      return;
      aggx.v[2] = 2130838011;
      aggx.v[5] = 2130849298;
      aggx.v[6] = 2130849299;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (!a())
      {
        localObject2 = awmb.a(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 == null) && (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder().append("session: ");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            break label253;
          }
        }
      }
    }
    int i;
    label253:
    for (localObject1 = "";; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      QLog.e("PanelIconLinearLayout", 2, localObject1 + " did not use config");
      localObject1 = localObject2;
      if ((!this.d) && (this.jdField_c_of_type_Boolean) && (localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label447;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject3 = new awkx();
        ((awkx)localObject3).jdField_d_of_type_Int = localObject2[0];
        ((awkx)localObject3).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(localObject2[1]);
        ((awkx)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject2[2]);
        ((awkx)localObject3).e = localObject2[3];
        ((awkx)localObject3).jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
    }
    for (;;)
    {
      if (i < ((List)localObject1).size())
      {
        localObject2 = (awkx)((List)localObject1).get(i);
        if ((!this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((awkx)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = awmb.b(((awkx)localObject2).jdField_a_of_type_Int);
          if (localObject3 != null) {
            ((awkx)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (localObject2 != null) && (((awkx)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localObject3 = awmb.b(((awkx)localObject2).jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label404;
          }
          ((awkx)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject3[2]);
        }
        for (;;)
        {
          i += 1;
          break;
          label404:
          if (((awkx)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            ((awkx)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((awkx)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
      }
      a((List)localObject1);
      banz.a().b(this.jdField_a_of_type_AndroidContentContext, this);
      return;
      i = j;
      continue;
      label447:
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
    paramView.setOnLongClickListener(new aghb(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(aggx.b);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aggx.q;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.t);
      if (asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.R);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aggx.j;; paramQQAppInterface = aggx.f)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      paramQQAppInterface = aggx.m;
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
      setBackgroundResource(2130849330);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130844424);
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label76;
      }
      arrayOfInt = aggx.p;
      localArrayList.add(arrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = aggx.i;; arrayOfInt = aggx.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      arrayOfInt = aggx.l;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aggx.q;
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.t);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = aggx.j;; paramQQAppInterface = aggx.f)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.x);
        return;
        paramQQAppInterface = aggx.m;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.o);
      g();
      e();
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.A);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.y);
        return;
        if (aggx.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.C);
        }
      }
    }
    this.d = true;
    this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aggx.p;
      paramBaseChatPie.add(paramQQAppInterface);
      h();
      f();
      if (!paramBoolean2) {
        break label304;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.z);
      label261:
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
      return;
      paramQQAppInterface = aggx.l;
      break;
      if (!aggx.jdField_a_of_type_Boolean) {
        break label261;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.B);
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
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(10);
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
    this.jdField_a_of_type_JavaUtilArrayList.add(aggx.c);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = aggx.r;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.u);
      if (asub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = aggx.k;; paramQQAppInterface = aggx.g)
    {
      localArrayList.add(paramQQAppInterface);
      this.jdField_c_of_type_Boolean = false;
      a();
      return;
      paramQQAppInterface = aggx.n;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aggx.p;
        paramSessionInfo.add(paramQQAppInterface);
        h();
        f();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label219;
        }
        paramQQAppInterface = aggx.i;
        label161:
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
        label178:
        a(i, paramBoolean);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label2066;
        }
        setCustomHeight(0);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      a();
      return;
      paramQQAppInterface = aggx.l;
      break;
      label219:
      paramQQAppInterface = aggx.e;
      break label161;
      Object localObject;
      if (i == 1)
      {
        localObject = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramSessionInfo = ((HotChatManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.V);
          if (!paramSessionInfo.isRobotHotChat) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.F);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.H);
          paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
          if (this.jdField_b_of_type_Boolean) {}
          for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
          {
            paramBaseChatPie.add(paramQQAppInterface);
            if (paramSessionInfo.isRobotHotChat) {
              break;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
            break;
          }
        }
        boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        a(nav.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool, paramQQAppInterface, paramBaseChatPie);
        break label178;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        if ((i == 1024) && (((bfyh)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        }
        localObject = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramBaseChatPie = aggx.p;
          label490:
          ((ArrayList)localObject).add(paramBaseChatPie);
          f();
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label596;
          }
        }
        label596:
        for (paramBaseChatPie = aggx.i;; paramBaseChatPie = aggx.e)
        {
          ((ArrayList)localObject).add(paramBaseChatPie);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.z);
          if ((i != 1024) || (!((bfyh)paramQQAppInterface.getManager(165)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(aggx.z);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
          break;
          paramBaseChatPie = aggx.l;
          break label490;
        }
      }
      if ((i == 1033) || (i == 1034))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aggx.p;
          label646:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (asub.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label709;
          }
        }
        label709:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aggx.l;
          break label646;
        }
      }
      if (i == 1036)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aggx.p;
          label740:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label793;
          }
        }
        label793:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.X);
          break;
          paramQQAppInterface = aggx.l;
          break label740;
        }
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_Boolean = true;
        this.d = false;
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aggx.p;
          label853:
          paramBaseChatPie.add(paramQQAppInterface);
          h();
          f();
          if (aggx.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.B);
          }
          paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label942;
          }
        }
        label942:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramBaseChatPie.add(paramQQAppInterface);
          if (!bdeu.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label949;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.T);
          this.jdField_c_of_type_Boolean = false;
          break;
          paramQQAppInterface = aggx.l;
          break label853;
        }
        label949:
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
        break label178;
      }
      if (i == 10004)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aggx.p;
          label998:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (asub.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1072;
          }
        }
        label1072:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
          break;
          paramSessionInfo = aggx.l;
          break label998;
        }
      }
      if ((i == 1000) || (i == 1004) || (i == 1006) || (i == 10008))
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aggx.p;
          label1127:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (asub.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1190;
          }
        }
        label1190:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aggx.l;
          break label1127;
        }
      }
      if (i == 1020)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aggx.p;
          label1221:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1274;
          }
        }
        label1274:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.z);
          break;
          paramQQAppInterface = aggx.l;
          break label1221;
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
          paramQQAppInterface = aggx.p;
          label1313:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1366;
          }
        }
        label1366:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.z);
          break;
          paramQQAppInterface = aggx.l;
          break label1313;
        }
      }
      if (i == 1003)
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramSessionInfo = aggx.p;; paramSessionInfo = aggx.l)
        {
          paramBaseChatPie.add(paramSessionInfo);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.z);
          if (!asub.a(paramQQAppInterface).b()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
          break;
        }
      }
      if (i == 1010)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aggx.p;
          label1484:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1537;
          }
        }
        label1537:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
          break;
          paramQQAppInterface = aggx.l;
          break label1484;
        }
      }
      if ((i == 1001) || (i == 10002))
      {
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSessionInfo = aggx.p;
          label1576:
          paramBaseChatPie.add(paramSessionInfo);
          f();
          if (asub.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.N);
          }
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1639;
          }
        }
        label1639:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          break;
          paramSessionInfo = aggx.l;
          break label1576;
        }
      }
      if (i == 6000)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = aggx.p;; paramQQAppInterface = aggx.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.J);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.K);
          break;
        }
      }
      if (i == 6003)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean) {}
        for (paramQQAppInterface = aggx.p;; paramQQAppInterface = aggx.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.J);
          break;
        }
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = aggx.p;
          label1802:
          paramSessionInfo.add(paramQQAppInterface);
          f();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1855;
          }
        }
        label1855:
        for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.w);
          break;
          paramQQAppInterface = aggx.l;
          break label1802;
        }
      }
      if (i == 9501)
      {
        if ((paramBaseChatPie == null) || (!(paramBaseChatPie instanceof agoz))) {
          break label178;
        }
        if (((agoz)paramBaseChatPie).I()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.jdField_a_of_type_ArrayOfInt);
        }
        if (((agoz)paramBaseChatPie).H())
        {
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label1994;
          }
        }
        label1994:
        for (paramQQAppInterface = aggx.p;; paramQQAppInterface = aggx.l)
        {
          paramSessionInfo.add(paramQQAppInterface);
          f();
          if (((agoz)paramBaseChatPie).E())
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.E);
            this.jdField_a_of_type_JavaUtilArrayList.add(aggx.D);
          }
          if (!((agoz)paramBaseChatPie).G()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(aggx.J);
          break;
        }
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = aggx.p;
        label2017:
        paramSessionInfo.add(paramQQAppInterface);
        f();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label2059;
        }
      }
      label2059:
      for (paramQQAppInterface = aggx.i;; paramQQAppInterface = aggx.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        break;
        paramQQAppInterface = aggx.l;
        break label2017;
      }
      label2066:
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
      blfv.a().b();
      blfv.a().a("userClick");
    }
    awkx localawkx = awmb.a(((Integer)localObject).intValue());
    if (localawkx != null) {
      aggx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(localawkx.jdField_b_of_type_Int), localawkx.jdField_a_of_type_Int);
    }
    int i;
    do
    {
      do
      {
        if (this.jdField_a_of_type_Aghd != null) {
          this.jdField_a_of_type_Aghd.a(paramView.getTag());
        }
        try
        {
          i = ((Integer)paramView.getTag()).intValue();
          if (i != 2) {
            break;
          }
          ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("103100.103300");
          if ((paramView instanceof RedDotImageView)) {
            ((RedDotImageView)paramView).a(false);
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramView)
        {
          QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
          return;
        }
        localObject = awmb.a(((Integer)localObject).intValue(), true);
      } while (localObject == null);
      if ("web".equals(((awkx)localObject).jdField_a_of_type_JavaLangString))
      {
        a(((awkx)localObject).jdField_b_of_type_JavaLangString);
        return;
      }
    } while (!"miniapp".equals(((awkx)localObject).jdField_a_of_type_JavaLangString));
    b(((awkx)localObject).jdField_b_of_type_JavaLangString);
    return;
    if (i == 10)
    {
      aetu.a(1);
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
        break label693;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10008) {
        break label693;
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject, 0, 0, "", "", "", "");
      ajeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_c_of_type_Int);
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
          if ((ShortVideoUtils.e()) && (aobe.a())) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            setShowRed(6, false);
            azjh.a(azjh.jdField_d_of_type_JavaLangString);
            return;
          }
          if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break;
          }
          setShowRed(6, false);
          ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
          jdField_a_of_type_Boolean = false;
          return;
        }
        if ((i != 8) || (!a(this.jdField_c_of_type_Int))) {
          break;
        }
        ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        setShowRed(8, false);
        return;
        label693:
        localObject = "entrance.click.c2c.quick";
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aghc != null) {
      return this.jdField_a_of_type_Aghc.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      return false;
    }
    if (this.jdField_a_of_type_Aghe != null) {
      return this.jdField_a_of_type_Aghe.a(paramView.getTag());
    }
    switch (((Integer)localObject).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Afev == null);
      paramView = (affo)this.jdField_a_of_type_Afev.a(7);
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
    if (this.jdField_a_of_type_Aghc != null) {
      return this.jdField_a_of_type_Aghc.b(paramMotionEvent);
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
  
  public void setHelperProvider(afev paramafev)
  {
    this.jdField_a_of_type_Afev = paramafev;
  }
  
  public void setInterceptListener(aghc paramaghc)
  {
    this.jdField_a_of_type_Aghc = paramaghc;
  }
  
  public void setPanelIconListener(aghd paramaghd)
  {
    this.jdField_a_of_type_Aghd = paramaghd;
  }
  
  public void setPanelIconLongListener(aghe paramaghe)
  {
    this.jdField_a_of_type_Aghe = paramaghe;
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
        localObject = awmb.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          aggx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(((awkx)localObject).jdField_b_of_type_Int), ((awkx)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130849802));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */