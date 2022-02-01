package com.tencent.mobileqq.activity.aio.panel;

import afcm;
import afqw;
import afrt;
import agkg;
import agwt;
import agwz;
import agxa;
import agxb;
import agxc;
import agxd;
import ahcd;
import ahce;
import ahff;
import akgd;
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
import apju;
import aqzw;
import augn;
import ayfh;
import ayft;
import azvi;
import bbwb;
import bbyp;
import bcef;
import bdav;
import bftf;
import bily;
import bmau;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.DisplayUtil;
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
import nmy;
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
  public afqw a;
  private agxa jdField_a_of_type_Agxa;
  private agxb jdField_a_of_type_Agxb;
  private agxc jdField_a_of_type_Agxc;
  private agxd jdField_a_of_type_Agxd;
  public Context a;
  public SharedPreferences a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<int[]> a;
  private Map<int[], int[]> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<int[], int[]> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e;
  
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
    setBackgroundResource(2130849809);
    jdField_b_of_type_Int = AIOUtils.dp2px(40.0F, paramContext.getResources());
    d();
  }
  
  @NotNull
  private RedTouch a(ayfh paramayfh, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramRedDotImageView).a(53).c(15).d(0).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    azvi localazvi = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (paramInt == 8)
    {
      paramayfh = localazvi.a(10);
      if (paramayfh != null) {
        paramRedDotImageView.a(paramayfh);
      }
    }
    do
    {
      return paramRedDotImageView;
      paramayfh = localazvi.a(4, String.valueOf(paramayfh.jdField_b_of_type_Int));
    } while (paramayfh == null);
    paramRedDotImageView.a(paramayfh);
    localazvi.b(paramayfh, "");
    return paramRedDotImageView;
  }
  
  @NotNull
  private String a(SessionInfo paramSessionInfo)
  {
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (paramSessionInfo.curType == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 10008)) {
      paramSessionInfo = "entrance.click.c2c.quick";
    }
    do
    {
      return paramSessionInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
        return "entrance.click.group.quick";
      }
      paramSessionInfo = str;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1);
    return "entrance.click.chatgroup.quick";
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23)
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
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
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
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
        paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
        paramRedDotImageView.a(true);
      }
      label145:
      if (paramInt != 2) {
        break label244;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("103100.103300");
      if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
        break label238;
      }
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
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
        b(paramRedDotImageView);
        return;
      }
      if (paramInt == 10)
      {
        akgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedDotImageView, this.jdField_c_of_type_Int);
        return;
      }
      if (paramInt == 8)
      {
        if (a(this.jdField_c_of_type_Int))
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
          paramRedDotImageView.a(true);
          return;
        }
        paramRedDotImageView.a(false);
        return;
      }
    } while (paramInt != 24);
    a(paramRedDotImageView);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if (a(paramBoolean)) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void a(View paramView)
  {
    int i;
    try
    {
      i = ((Integer)paramView.getTag()).intValue();
      if (i == 2)
      {
        ((azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("103100.103300");
        if ((paramView instanceof RedDotImageView)) {
          ((RedDotImageView)paramView).a(false);
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
        return;
      }
      if (i == 10)
      {
        afcm.a(1);
        String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", str, 0, 0, "", "", "", "");
        akgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_c_of_type_Int);
        return;
      }
    }
    catch (Exception paramView)
    {
      QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
      return;
    }
    if (i == 6)
    {
      if ((ShortVideoUtils.supportShortVideoMergePhoto()) && (apju.a())) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
      }
      if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
      {
        setShowRed(6, false);
        bbwb.a(bbwb.jdField_d_of_type_JavaLangString);
        return;
      }
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        setShowRed(6, false);
        ShortVideoUtils.setPtvRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
    else if (i == 24)
    {
      if (jdField_a_of_type_Boolean)
      {
        setShowRed(24, false);
        ShortVideoUtils.setHotPicRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
        jdField_a_of_type_Boolean = false;
      }
    }
    else if (i == 8)
    {
      if (a(this.jdField_c_of_type_Int))
      {
        ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        setShowRed(8, false);
      }
      c();
    }
  }
  
  private void a(ayfh paramayfh, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramayfh.jdField_d_of_type_Int) && (paramSessionInfo != null) && (bftf.b(paramSessionInfo.curFriendUin)))
    {
      paramayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(agwt.T[2]);
      paramayfh.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramayfh.jdField_d_of_type_Int = agwt.T[0];
      paramayfh.e = agwt.T[3];
      paramayfh.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(agwt.T[1]);
    }
  }
  
  private void a(ayfh paramayfh, ArrayList<ahce> paramArrayList, int paramInt)
  {
    int i = paramayfh.jdField_d_of_type_Int;
    RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramayfh.jdField_a_of_type_ArrayOfInt != null) && (paramayfh.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (a(paramayfh))
      {
        ahce localahce = new ahce();
        localahce.jdField_a_of_type_Int = paramInt;
        localahce.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        paramArrayList.add(localahce);
      }
    }
    else {
      if (!this.jdField_b_of_type_Boolean) {
        break label253;
      }
    }
    label253:
    for (paramArrayList = paramayfh.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; paramArrayList = paramayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      localRedDotImageView.setImageDrawable(paramArrayList);
      if (AppSetting.jdField_c_of_type_Boolean) {
        localRedDotImageView.setContentDescription(paramayfh.jdField_d_of_type_JavaLangString);
      }
      if (paramayfh.e > 0) {
        localRedDotImageView.setId(paramayfh.e);
      }
      localRedDotImageView.setLongClickable(true);
      localRedDotImageView.setOnLongClickListener(this);
      localRedDotImageView.setOnClickListener(this);
      localRedDotImageView.setSelected(false);
      a(localRedDotImageView, i);
      if ((!this.d) && (i != 8)) {
        break label261;
      }
      addView(a(paramayfh, i, localRedDotImageView), localLayoutParams);
      return;
      localRedDotImageView.setImageResource(paramayfh.jdField_a_of_type_ArrayOfInt[2]);
      break;
    }
    label261:
    a(i, localRedDotImageView);
    addView(localRedDotImageView, localLayoutParams);
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    this.d = true;
    this.e = false;
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
    h();
    f();
    if (agwt.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.C);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
    if (bftf.b(paramSessionInfo.curFriendUin))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.U);
      this.d = false;
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList;
    if ((paramBaseChatPie != null) && ((paramBaseChatPie instanceof ahff)))
    {
      if (((ahff)paramBaseChatPie).e()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      }
      if (((ahff)paramBaseChatPie).d())
      {
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label122;
        }
      }
    }
    label122:
    for (int[] arrayOfInt = agwt.p;; arrayOfInt = agwt.l)
    {
      localArrayList.add(arrayOfInt);
      g();
      if (((ahff)paramBaseChatPie).a())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.E);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.D);
      }
      if (((ahff)paramBaseChatPie).c()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.J);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramInt == 1024) && (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = agwt.p;
      localArrayList.add(arrayOfInt);
      g();
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label163;
      }
    }
    label163:
    for (int[] arrayOfInt = agwt.i;; arrayOfInt = agwt.e)
    {
      localArrayList.add(arrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.z);
      if ((paramInt == 1024) && (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(agwt.z);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
      }
      return;
      arrayOfInt = agwt.l;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<int[]> paramArrayList)
  {
    if ((paramInt == 1024) && (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin))) {
      paramArrayList.add(agwt.d);
    }
    paramArrayList.add(agwt.o);
    f();
    paramArrayList.add(agwt.h);
    paramArrayList.add(agwt.A);
    if ((paramInt == 1024) && (((bily)paramQQAppInterface.getManager(165)).f(paramSessionInfo.curFriendUin)))
    {
      paramArrayList.remove(agwt.z);
      paramArrayList.add(agwt.y);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      h();
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
      return;
    }
    if (paramInt == 1)
    {
      a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (d(paramInt))
    {
      a(paramQQAppInterface, paramSessionInfo, paramInt, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (c(paramInt))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      return;
    }
    if (paramInt == 1036)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.X);
      return;
    }
    if (a(paramQQAppInterface, paramSessionInfo, paramInt))
    {
      a(paramSessionInfo);
      return;
    }
    if (paramInt == 10004)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
      return;
    }
    if (e(paramInt))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      return;
    }
    if (paramInt == 1020)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.A);
      return;
    }
    if (paramInt == 1005)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.A);
      return;
    }
    if (paramInt == 1003)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.A);
      e();
      return;
    }
    if (paramInt == 1010)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
      return;
    }
    if (b(paramInt))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      e();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      return;
    }
    if (paramInt == 1025)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      f();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
    f();
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, ArrayList<int[]> paramArrayList)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.curFriendUin)))
    {
      paramQQAppInterface = localHotChatManager.a(paramSessionInfo.curFriendUin);
      paramArrayList.add(agwt.d);
      paramArrayList.add(agwt.W);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(agwt.G);
      }
      paramArrayList.add(agwt.I);
      paramArrayList.add(agwt.h);
      if (!paramQQAppInterface.isRobotHotChat) {
        paramArrayList.add(agwt.y);
      }
      return;
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.curFriendUin);
    a(nmy.a().a(paramSessionInfo.curFriendUin), bool, paramQQAppInterface, paramBaseChatPie, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = agwt.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (augn.a(paramQQAppInterface).b()) {
        paramArrayList.add(agwt.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label64;
      }
    }
    label64:
    for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = agwt.l;
      break;
    }
  }
  
  private void a(RedDotImageView paramRedDotImageView)
  {
    if (!ShortVideoUtils.isHotPicConfiginitied)
    {
      jdField_a_of_type_Boolean = ShortVideoUtils.getHotPicRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ShortVideoUtils.isHotPicConfiginitied = true;
    }
    if (jdField_a_of_type_Boolean)
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
      paramRedDotImageView.a(true);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
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
  
  private void a(List<ayfh> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      ayfh localayfh = (ayfh)paramList.get(i);
      int[] arrayOfInt;
      if ((!this.jdField_b_of_type_Boolean) && (localayfh != null) && (localayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        arrayOfInt = ayft.a(localayfh.jdField_a_of_type_Int);
        if (arrayOfInt != null) {
          localayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(arrayOfInt[2]);
        }
      }
      if ((this.jdField_b_of_type_Boolean) && (localayfh != null) && (localayfh.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        arrayOfInt = ayft.a(localayfh.jdField_a_of_type_Int);
        if (arrayOfInt == null) {
          break label130;
        }
        localayfh.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(arrayOfInt[2]);
      }
      for (;;)
      {
        i += 1;
        break;
        label130:
        if (localayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localayfh.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localayfh.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
      }
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin));
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    return (10 != paramInt) || (paramSessionInfo == null) || (!bftf.b(paramSessionInfo.curFriendUin));
  }
  
  private boolean a(ayfh paramayfh)
  {
    return ((paramayfh.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isNightMode)) || ((paramayfh.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isTimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isTimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isNightMode)) || ((paramayfh.jdField_a_of_type_ArrayOfInt.length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((aqzw)paramQQAppInterface.getManager(334)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = agkg.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = agkg.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(agkg.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    return (paramInt == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.curFriendUin));
  }
  
  private boolean a(List<ayfh> paramList)
  {
    return (this.e) || (!this.d) || (paramList == null) || (paramList.size() == 0);
  }
  
  private boolean a(boolean paramBoolean)
  {
    return (!bbyp.b()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)));
  }
  
  private void b(SessionInfo paramSessionInfo)
  {
    this.d = true;
    this.e = false;
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = agwt.p;
      localArrayList.add(arrayOfInt);
      i();
      g();
      if (agwt.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.B);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label124;
      }
    }
    label124:
    for (int[] arrayOfInt = agwt.i;; arrayOfInt = agwt.e)
    {
      localArrayList.add(arrayOfInt);
      if (!bftf.b(paramSessionInfo.curFriendUin)) {
        break label131;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.T);
      this.d = false;
      return;
      arrayOfInt = agwt.l;
      break;
    }
    label131:
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.curType;
    EmojiStickerManager.a().jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ShortVideoUtils.sSupportShortVideo = ShortVideoUtils.canRecordShortVideo();
    a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, i);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      setCustomHeight(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      b();
      return;
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = agwt.p;
        paramSessionInfo.add(paramQQAppInterface);
        i();
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label90;
        }
        paramQQAppInterface = agwt.i;
        label65:
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
      }
    }
    label90:
    label223:
    label370:
    do
    {
      return;
      paramQQAppInterface = agwt.l;
      break;
      paramQQAppInterface = agwt.e;
      break label65;
      if (paramInt == 1)
      {
        c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        return;
      }
      if (d(paramInt))
      {
        a(paramQQAppInterface, paramSessionInfo, paramInt);
        return;
      }
      if (c(paramInt))
      {
        b(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      if (paramInt == 1036)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = agwt.p;
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label223;
          }
        }
        for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(agwt.X);
          return;
          paramQQAppInterface = agwt.l;
          break;
        }
      }
      if (a(paramQQAppInterface, paramSessionInfo, paramInt))
      {
        b(paramSessionInfo);
        return;
      }
      if (paramInt == 10004)
      {
        b(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
        return;
      }
      if (e(paramInt))
      {
        a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      if (paramInt == 1020)
      {
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (this.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = agwt.p;
          paramSessionInfo.add(paramQQAppInterface);
          g();
          paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
          if (!this.jdField_b_of_type_Boolean) {
            break label370;
          }
        }
        for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
        {
          paramSessionInfo.add(paramQQAppInterface);
          this.jdField_a_of_type_JavaUtilArrayList.add(agwt.z);
          return;
          paramQQAppInterface = agwt.l;
          break;
        }
      }
    } while (paramInt == 1008);
    if (paramInt == 1005)
    {
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = agwt.p;
        paramSessionInfo.add(paramQQAppInterface);
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label460;
        }
      }
      label460:
      for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.z);
        return;
        paramQQAppInterface = agwt.l;
        break;
      }
    }
    if (paramInt == 1003)
    {
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramSessionInfo = agwt.p;; paramSessionInfo = agwt.l)
      {
        paramBaseChatPie.add(paramSessionInfo);
        g();
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.z);
        if (!augn.a(paramQQAppInterface).b()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.N);
        return;
      }
    }
    if (paramInt == 1010)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = agwt.p;
        paramSessionInfo.add(paramQQAppInterface);
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label627;
        }
      }
      label627:
      for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
        return;
        paramQQAppInterface = agwt.l;
        break;
      }
    }
    if (b(paramInt))
    {
      a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (paramInt == 6000)
    {
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramQQAppInterface = agwt.p;; paramQQAppInterface = agwt.l)
      {
        paramSessionInfo.add(paramQQAppInterface);
        g();
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.J);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.K);
        return;
      }
    }
    if (paramInt == 6003)
    {
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramQQAppInterface = agwt.p;; paramQQAppInterface = agwt.l)
      {
        paramSessionInfo.add(paramQQAppInterface);
        g();
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.J);
        return;
      }
    }
    if (paramInt == 1025)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = agwt.p;
        paramSessionInfo.add(paramQQAppInterface);
        g();
        paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label856;
        }
      }
      label856:
      for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
      {
        paramSessionInfo.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
        return;
        paramQQAppInterface = agwt.l;
        break;
      }
    }
    if (paramInt == 9501)
    {
      a(paramBaseChatPie);
      return;
    }
    if (paramInt == 10009)
    {
      a();
      return;
    }
    paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = agwt.p;
      paramSessionInfo.add(paramQQAppInterface);
      g();
      paramSessionInfo = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label946;
      }
    }
    label946:
    for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
    {
      paramSessionInfo.add(paramQQAppInterface);
      return;
      paramQQAppInterface = agwt.l;
      break;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ArrayList<int[]> paramArrayList)
  {
    paramArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = agwt.p;
      paramArrayList.add(arrayOfInt);
      g();
      if (augn.a(paramQQAppInterface).b()) {
        paramArrayList.add(agwt.N);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
    {
      paramArrayList.add(paramQQAppInterface);
      return;
      arrayOfInt = agwt.l;
      break;
    }
  }
  
  private void b(RedDotImageView paramRedDotImageView)
  {
    if (!ShortVideoUtils.isPtvConfiginitied)
    {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ShortVideoUtils.getPtvRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      ShortVideoUtils.isPtvConfiginitied = true;
    }
    jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(bbwb.a(bbwb.jdField_d_of_type_JavaLangString));
    if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
    {
      paramRedDotImageView.setReddotXOffsetDp(11);
      paramRedDotImageView.setReddotYOffsetDp(8);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130849675));
      paramRedDotImageView.a(true);
      return;
    }
    if (jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130850322));
      paramRedDotImageView.a(true);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramString, 2053, null);
    }
  }
  
  private void b(List<ayfh> paramList)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (ayfh)paramList.get(i);
      if (!a(((ayfh)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        a((ayfh)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    Object localObject = new ArrayList();
    if (paramList.size() > 0)
    {
      i = j;
      while (i < paramList.size())
      {
        a((ayfh)paramList.get(i), (ArrayList)localObject, i);
        i += 1;
      }
    }
    if (((ArrayList)localObject).size() > 0) {}
    try
    {
      ahcd.a().a((ArrayList)localObject, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("PanelIconLinearLayout", 1, "load data qim exception = " + paramList);
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = agkg.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = agkg.a(paramSharedPreferences);; bool1 = false)
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
        QLog.d(agkg.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramSessionInfo.curFriendUin)))
    {
      paramSessionInfo = localHotChatManager.a(paramSessionInfo.curFriendUin);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.V);
      if (!paramSessionInfo.isRobotHotChat) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.F);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.H);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean) {}
      for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        if (!paramSessionInfo.isRobotHotChat) {
          this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
        }
        return;
      }
    }
    boolean bool = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.curFriendUin);
    a(nmy.a().a(paramSessionInfo.curFriendUin), bool, paramQQAppInterface, paramBaseChatPie);
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1033) || (paramInt == 1034);
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaUtilMap.put(agwt.e, agwt.i);
    this.jdField_b_of_type_JavaUtilMap.put(agwt.f, agwt.j);
    this.jdField_b_of_type_JavaUtilMap.put(agwt.g, agwt.k);
    this.jdField_b_of_type_JavaUtilMap.put(agwt.l, agwt.p);
    this.jdField_b_of_type_JavaUtilMap.put(agwt.m, agwt.q);
    this.jdField_b_of_type_JavaUtilMap.put(agwt.n, agwt.r);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.i, agwt.e);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.j, agwt.f);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.k, agwt.g);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.p, agwt.l);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.q, agwt.m);
    this.jdField_a_of_type_JavaUtilMap.put(agwt.r, agwt.n);
  }
  
  private boolean d(int paramInt)
  {
    return (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1009) || (paramInt == 1024);
  }
  
  private void e()
  {
    if (augn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.O);
    }
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008) || (paramInt == 10010);
  }
  
  private void f()
  {
    if ((ShortVideoUtils.needTwoEntrance()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(agwt.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        agwt.s[2] = 2130844703;
        agwt.s[5] = 0;
        agwt.s[6] = 0;
      }
      return;
    }
  }
  
  private void g()
  {
    if ((ShortVideoUtils.needTwoEntrance()) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(agwt.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.s);
      }
      return;
    }
  }
  
  private void h()
  {
    if (ShortVideoUtils.needTwoEntrance()) {
      agwt.v[2] = 2130844714;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.v);
      return;
      agwt.v[2] = 2130844703;
    }
  }
  
  private void i()
  {
    if (ShortVideoUtils.needTwoEntrance())
    {
      agwt.v[2] = 2130838217;
      agwt.v[5] = 2130849875;
      agwt.v[6] = 2130849876;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.v);
      return;
      agwt.v[2] = 2130838140;
      agwt.v[5] = 2130849777;
      agwt.v[6] = 2130849778;
    }
  }
  
  private void j()
  {
    try
    {
      azvi localazvi = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (this.e) {}
      for (int i = 11;; i = 10)
      {
        if (localazvi.a(i, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin) != null) {
          localazvi.b(i, 31);
        }
        return;
      }
      return;
    }
    catch (Exception localException) {}
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
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label78;
      }
      arrayOfInt = agwt.p;
      localArrayList.add(arrayOfInt);
      g();
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.N);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label85;
      }
    }
    label78:
    label85:
    for (int[] arrayOfInt = agwt.i;; arrayOfInt = agwt.e)
    {
      localArrayList.add(arrayOfInt);
      return;
      arrayOfInt = agwt.l;
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
    paramView.setOnLongClickListener(new agwz(this));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.b);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = agwt.q;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.t);
      if (augn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.R);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = agwt.j;; paramQQAppInterface = agwt.f)
    {
      localArrayList.add(paramQQAppInterface);
      this.d = false;
      b();
      return;
      paramQQAppInterface = agwt.m;
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
      setBackgroundResource(2130849809);
      b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramBoolean);
      return;
    }
    setBackgroundResource(2130844708);
    b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramBoolean, false, paramQQAppInterface, paramBaseChatPie);
    if (paramBaseChatPie.sessionInfo != null) {}
    for (this.jdField_c_of_type_Int = paramBaseChatPie.sessionInfo.curType;; this.jdField_c_of_type_Int = 1)
    {
      this.d = false;
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
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label76;
      }
      arrayOfInt = agwt.p;
      localArrayList.add(arrayOfInt);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label83;
      }
    }
    label76:
    label83:
    for (int[] arrayOfInt = agwt.i;; arrayOfInt = agwt.e)
    {
      localArrayList.add(arrayOfInt);
      this.d = false;
      b();
      return;
      arrayOfInt = agwt.l;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    a(paramBoolean1, paramBoolean2, paramQQAppInterface, paramBaseChatPie, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, boolean paramBoolean3)
  {
    this.d = false;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = agwt.q;
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.t);
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
        if (!this.jdField_b_of_type_Boolean) {
          break label98;
        }
      }
      label98:
      for (paramQQAppInterface = agwt.j;; paramQQAppInterface = agwt.f)
      {
        paramBaseChatPie.add(paramQQAppInterface);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.x);
        return;
        paramQQAppInterface = agwt.m;
        break;
      }
    }
    if (paramBoolean3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.o);
      h();
      f();
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.A);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.y);
        return;
        if (agwt.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilArrayList.add(agwt.C);
        }
      }
    }
    this.e = true;
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = agwt.p;
      paramBaseChatPie.add(paramQQAppInterface);
      i();
      g();
      if (!paramBoolean2) {
        break label304;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.z);
      label261:
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label324;
      }
    }
    label304:
    label324:
    for (paramQQAppInterface = agwt.i;; paramQQAppInterface = agwt.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.w);
      return;
      paramQQAppInterface = agwt.l;
      break;
      if (!agwt.jdField_a_of_type_Boolean) {
        break label261;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.B);
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
    removeAllViews();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.d)
    {
      localObject1 = localObject2;
      if (!a())
      {
        localObject2 = ayft.a(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 == null) && (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder().append("session: ");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            break label221;
          }
        }
      }
    }
    label221:
    for (localObject1 = "";; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))
    {
      QLog.e("PanelIconLinearLayout", 2, localObject1 + " did not use config");
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (!a((List)localObject1)) {
        break;
      }
      localObject2 = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject3 = new ayfh();
        ((ayfh)localObject3).jdField_d_of_type_Int = localObject1[0];
        ((ayfh)localObject3).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(localObject1[1]);
        ((ayfh)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localObject1[2]);
        ((ayfh)localObject3).e = localObject1[3];
        ((ayfh)localObject3).jdField_a_of_type_ArrayOfInt = ((int[])localObject1);
        ((List)localObject2).add(localObject3);
        i += 1;
      }
    }
    a((List)localObject2);
    b((List)localObject2);
    bdav.a().b(this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(agwt.c);
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (this.jdField_b_of_type_Boolean)
    {
      paramQQAppInterface = agwt.r;
      localArrayList.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilArrayList.add(agwt.u);
      if (augn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(agwt.N);
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!this.jdField_b_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (paramQQAppInterface = agwt.k;; paramQQAppInterface = agwt.g)
    {
      localArrayList.add(paramQQAppInterface);
      this.d = false;
      b();
      return;
      paramQQAppInterface = agwt.n;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramSessionInfo.curType;
    EmojiStickerManager.a().jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ShortVideoUtils.sSupportShortVideo = ShortVideoUtils.canRecordShortVideo();
    b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie, i);
    a(i, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      setCustomHeight(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      b();
      return;
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
      if ((this.d) || (!bool2)) {
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
    if ((getVisibility() == 0) && ((this.d) || (this.e))) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if ((!(localView.getTag() instanceof Integer)) || (((Integer)localView.getTag()).intValue() != 8)) {
          break label162;
        }
        if ((localView instanceof RedTouch))
        {
          azvi localazvi = (azvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          if (!this.e) {
            break label151;
          }
          i = 11;
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = localazvi.a(i, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
          ((RedTouch)localView).a(localRedTypeInfo);
          if ((!this.jdField_c_of_type_Boolean) && (localRedTypeInfo != null)) {
            localazvi.b(i, 30);
          }
          if (localRedTypeInfo == null) {
            break label157;
          }
        }
      }
      label151:
      label157:
      for (boolean bool = true;; bool = false)
      {
        this.jdField_c_of_type_Boolean = bool;
        return;
        i = 10;
        break;
      }
      label162:
      i -= 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Agxa != null) && (this.jdField_a_of_type_Agxa.a(((Integer)localObject).intValue())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "onClick intercepted tag = " + localObject);
        }
      }
      else
      {
        if (((Integer)localObject).intValue() == 6)
        {
          bmau.a().d();
          bmau.a().a("userClick");
        }
        ayfh localayfh = ayft.a(((Integer)localObject).intValue());
        if (localayfh != null) {
          agwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(localayfh.jdField_b_of_type_Int), localayfh.jdField_a_of_type_Int);
        }
        do
        {
          do
          {
            if (((Integer)paramView.getTag()).intValue() == 8) {
              j();
            }
            if (this.jdField_a_of_type_Agxc != null) {
              this.jdField_a_of_type_Agxc.onPanelIconClick(paramView.getTag());
            }
            a(paramView);
            break;
            localObject = ayft.a(((Integer)localObject).intValue(), true);
          } while (localObject == null);
          if ("web".equals(((ayfh)localObject).jdField_a_of_type_JavaLangString))
          {
            a(((ayfh)localObject).jdField_b_of_type_JavaLangString);
            break;
          }
        } while (!"miniapp".equals(((ayfh)localObject).jdField_a_of_type_JavaLangString));
        b(((ayfh)localObject).jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Agxb != null) {
      return this.jdField_a_of_type_Agxb.interceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {
      return false;
    }
    if (this.jdField_a_of_type_Agxd != null) {
      return this.jdField_a_of_type_Agxd.a(paramView.getTag());
    }
    switch (((Integer)localObject).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Afqw == null);
      paramView = (afrt)this.jdField_a_of_type_Afqw.a(7);
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
    if (this.jdField_a_of_type_Agxb != null) {
      return this.jdField_a_of_type_Agxb.handleTouchEvent(paramMotionEvent);
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
  
  public void setHelperProvider(afqw paramafqw)
  {
    this.jdField_a_of_type_Afqw = paramafqw;
  }
  
  public void setInterceptListener(agxb paramagxb)
  {
    this.jdField_a_of_type_Agxb = paramagxb;
  }
  
  public void setPanelIconClickInterceptListener(agxa paramagxa)
  {
    this.jdField_a_of_type_Agxa = paramagxa;
  }
  
  public void setPanelIconListener(agxc paramagxc)
  {
    this.jdField_a_of_type_Agxc = paramagxc;
  }
  
  public void setPanelIconLongListener(agxd paramagxd)
  {
    this.jdField_a_of_type_Agxd = paramagxd;
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
        if (!this.d) {
          break label82;
        }
        localObject = ayft.a(Integer.valueOf(paramInt).intValue());
        if (localObject != null) {
          agwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, String.valueOf(((ayfh)localObject).jdField_b_of_type_Int), ((ayfh)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label82:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(getResources().getDrawable(2130850322));
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