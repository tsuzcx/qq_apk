package com.tencent.mobileqq.activity.aio.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.QIMUserIcon;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static Boolean a;
  public static boolean a;
  public static int b;
  public static Boolean b;
  public int a;
  public Context a;
  public SharedPreferences a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private PanelIconLinearLayout.InterceptListener jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener;
  private PanelIconLinearLayout.PanelIconCallback jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  private int c = -1;
  
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
    setBackgroundResource(2130845758);
    jdField_b_of_type_Int = AIOUtils.a(40.0F, paramContext.getResources());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    paramInt1 = 0;
    switch (paramInt2)
    {
    default: 
      if (!paramBoolean1) {
        if ((paramBoolean2) && (paramInt1 != 0)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.z);
        }
      }
      break;
    }
    label77:
    do
    {
      do
      {
        return;
        paramInt1 = 1;
        break;
        if (!paramBoolean2) {
          break label77;
        }
      } while (paramInt1 == 0);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.z);
      return;
    } while (!paramBoolean2);
    b();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, SessionInfo paramSessionInfo)
  {
    if (paramBoolean1) {
      if (paramBoolean2) {
        if (paramBoolean3) {
          b();
        }
      }
    }
    while ((!AIOPanelUtiles.jdField_a_of_type_Boolean) || (Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
      return;
      b();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = PokeItemHelper.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = PokeItemHelper.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = PokeItemHelper.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = PokeItemHelper.a(paramSharedPreferences);; bool1 = false)
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
        QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  private void c()
  {
    if ((ShortVideoUtils.f()) || ((!this.jdField_a_of_type_JavaUtilArrayList.contains(AIOPanelUtiles.m)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(AIOPanelUtiles.n)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "addCameraIcon" + bool);
      }
      if (bool)
      {
        if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
  }
  
  private void d()
  {
    if (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      if (ShortVideoUtils.f())
      {
        AIOPanelUtiles.n[2] = 2130844154;
        AIOPanelUtiles.m[5] = 2130844153;
        AIOPanelUtiles.m[6] = 2130845815;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.n);
        return;
        AIOPanelUtiles.n[2] = 2130844143;
        AIOPanelUtiles.m[5] = 2130844142;
        AIOPanelUtiles.m[6] = 2130845734;
      }
    }
    if (ShortVideoUtils.f())
    {
      AIOPanelUtiles.m[2] = 2130837695;
      AIOPanelUtiles.m[5] = 2130845814;
      AIOPanelUtiles.m[6] = 2130845815;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.m);
      return;
      AIOPanelUtiles.m[2] = 2130837640;
      AIOPanelUtiles.m[5] = 2130845733;
      AIOPanelUtiles.m[6] = 2130845734;
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    removeAllViews();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      localRedDotImageView.setTag(Integer.valueOf(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]));
      if (((((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i)).length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)) || ((((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i)).length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)) || ((((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i)).length >= 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))))
      {
        Object localObject = new QIMUserManager.QIMUserIcon();
        ((QIMUserManager.QIMUserIcon)localObject).jdField_a_of_type_Int = i;
        ((QIMUserManager.QIMUserIcon)localObject).jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        localArrayList.add(localObject);
        label269:
        if (AppSetting.b) {
          localRedDotImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[1]));
        }
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i)).length >= 4) {
          localRedDotImageView.setId(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[3]);
        }
        localRedDotImageView.setOnClickListener(this);
        localRedDotImageView.setSelected(false);
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 23)
        {
          if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
            break label594;
          }
          localRedDotImageView.setReddotXOffsetDp(15);
          localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
          localRedDotImageView.a(true);
        }
        label402:
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 26)
        {
          if (!b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences)) {
            break label602;
          }
          localRedDotImageView.setReddotXOffsetDp(15);
          localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
          localRedDotImageView.a(true);
        }
        label459:
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 3) {
          localRedDotImageView.a(false);
        }
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] != 2) {
          break label618;
        }
        localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("103100.103300");
        if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 1)) {
          break label610;
        }
        localRedDotImageView.setReddotXOffsetDp(15);
        localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
        localRedDotImageView.a(true);
      }
      for (;;)
      {
        addView(localRedDotImageView, localLayoutParams);
        i += 1;
        break;
        localRedDotImageView.setImageResource(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[2]);
        break label269;
        label594:
        localRedDotImageView.a(false);
        break label402;
        label602:
        localRedDotImageView.a(false);
        break label459;
        label610:
        localRedDotImageView.a(false);
        continue;
        label618:
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 6)
        {
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(RedBagVideoManager.a(RedBagVideoManager.d));
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            localRedDotImageView.setReddotXOffsetDp(11);
            localRedDotImageView.setReddotYOffsetDp(8);
            localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130845660));
            localRedDotImageView.a(true);
          }
          else if (jdField_a_of_type_JavaLangBoolean.booleanValue())
          {
            localRedDotImageView.setReddotXOffsetDp(15);
            localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
            localRedDotImageView.a(true);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
          }
          else
          {
            localRedDotImageView.a(false);
          }
        }
        else if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 27)
        {
          localRedDotImageView.setVisibility(8);
        }
        else if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 10)
        {
          QWalletTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotImageView, this.c);
        }
        else if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 8)
        {
          if (a(this.c))
          {
            localRedDotImageView.setReddotXOffsetDp(15);
            localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
            localRedDotImageView.a(true);
          }
          else
          {
            localRedDotImageView.a(false);
          }
        }
        else if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 24)
        {
          jdField_a_of_type_Boolean = ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          if (jdField_a_of_type_Boolean)
          {
            localRedDotImageView.setReddotXOffsetDp(15);
            localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130846134));
            localRedDotImageView.a(true);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
          }
          else
          {
            localRedDotImageView.a(false);
          }
        }
      }
    }
    QIMUserManager.a().a(localArrayList, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(View paramView)
  {
    boolean bool1 = paramView instanceof RedDotImageView;
    boolean bool2 = paramView.isSelected();
    boolean bool3 = ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    if ((!bool1) || (bool2) || (!bool3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanelIconLinearLayout", 2, "doAioIconAnimation return," + bool1 + "," + bool2 + "," + bool3);
      }
      return;
    }
    RedDotImageView localRedDotImageView = (RedDotImageView)paramView;
    Object localObject = localRedDotImageView.getDrawable();
    if ((localObject instanceof PanelIconLinearLayout.AioIconAnimationDrawabale)) {}
    for (localObject = (PanelIconLinearLayout.AioIconAnimationDrawabale)localObject;; localObject = null)
    {
      if ((localObject != null) && (((PanelIconLinearLayout.AioIconAnimationDrawabale)localObject).isRunning()))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PanelIconLinearLayout", 2, "doAioIconAnimation return, animation is running");
        return;
      }
      int j = ((Integer)paramView.getTag()).intValue();
      int i = 0;
      label164:
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (j != ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]) {}
      }
      for (paramView = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);; paramView = null)
      {
        if ((paramView == null) || (paramView.length < 5)) {
          break label282;
        }
        i = paramView[4];
        if (i == 0) {
          break;
        }
        try
        {
          paramView = new PanelIconLinearLayout.AioIconAnimationDrawabale(this, (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i), localRedDotImageView, paramView);
          localRedDotImageView.setImageDrawable(paramView);
          paramView.start();
          return;
        }
        catch (Exception paramView)
        {
          QLog.e("PanelIconLinearLayout", 1, paramView, new Object[0]);
          return;
        }
        i += 1;
        break label164;
      }
      label282:
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.k);
    if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.E);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool4 = true;
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
    boolean bool1 = GoldMsgChatHelper.a(paramSessionInfo);
    if (i == 3000) {
      if (bool1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
        d();
        c();
        if (HotPicManager.a(paramQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.F);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.q);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label2047;
        }
        setCustomHeight(0);
      }
    }
    for (;;)
    {
      this.c = i;
      a();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      d();
      c();
      if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
      }
      if (HotPicManager.a(paramQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
      break;
      if (i == 1)
      {
        paramBaseChatPie = (HotChatManager)paramQQAppInterface.getManager(59);
        if ((paramBaseChatPie != null) && (paramBaseChatPie.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramQQAppInterface = paramBaseChatPie.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.K);
          if (!paramQQAppInterface.isRobotHotChat) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.v);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.w);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.G);
          if (paramQQAppInterface.isRobotHotChat) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
          break;
        }
        if (bool1)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
          d();
          c();
          if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.F);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.q);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.I);
          break;
        }
        bool1 = TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        a(AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString), bool1, paramQQAppInterface, paramSessionInfo);
        break;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(164)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
        if ((i != 1024) || (!((QidianManager)paramQQAppInterface.getManager(164)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(AIOPanelUtiles.r);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if ((i == 1033) || (i == 1034))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        if (HotPicManager.a(paramQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        break;
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (BmqqSegmentUtil.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          d();
          c();
          if (HotPicManager.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
          break;
        }
        if (bool1)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
          d();
          c();
          if (HotPicManager.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.F);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.q);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        int j = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4);
        int k = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        if (QLog.isColorLevel()) {
          QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "loadData getPokeMsgBarFoldSwitch=" + k);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        d();
        c();
        label1079:
        boolean bool2;
        label1095:
        boolean bool3;
        if (PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
        {
          bool1 = true;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(AIOPanelUtiles.j)) {
            break label1313;
          }
          bool2 = true;
          bool3 = bool4;
          if (k != 1)
          {
            if (k != 2) {
              break label1319;
            }
            bool3 = bool4;
          }
          label1115:
          a(bool1, bool2, j, k);
          a(bool1, bool2, bool3, paramSessionInfo);
          if (HotPicManager.a(paramQQAppInterface).b()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
          if (!Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label1325;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.J);
        }
        for (;;)
        {
          if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {
            break label1337;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PanelIcon", 2, "loadData curType=" + i + "isSingleWayFriend");
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          c();
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
          if (!Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label1339;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.J);
          break;
          bool1 = false;
          break label1079;
          label1313:
          bool2 = false;
          break label1095;
          label1319:
          bool3 = false;
          break label1115;
          label1325:
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        }
        label1337:
        break;
        label1339:
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if ((i == 1000) || (i == 1004) || (i == 10004) || (i == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        if (HotPicManager.a(paramQQAppInterface).b()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
        break;
      }
      if (i == 1008) {
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
        if (!HotPicManager.a(paramQQAppInterface).b()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
        break;
      }
      if ((i == 1001) || (i == 10002) || (i == 1010))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if (i == 1029)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if (i == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.x);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.y);
        break;
      }
      if (i == 6003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.x);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        c();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
        break;
      }
      if (i == 9501)
      {
        if ((paramBaseChatPie == null) || (!(paramBaseChatPie instanceof DeviceMsgChatPie))) {
          break;
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).B()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).A())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          c();
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).x())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.u);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.t);
        }
        if (!((DeviceMsgChatPie)paramBaseChatPie).z()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.x);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      c();
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      break;
      label2047:
      setCustomHeight(jdField_b_of_type_Int);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramBoolean, false, paramQQAppInterface, paramSessionInfo);
    if (paramSessionInfo != null) {}
    for (this.c = paramSessionInfo.jdField_a_of_type_Int;; this.c = 1)
    {
      a();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
    }
    a();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.k);
      if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.E);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.p);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.H);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
    d();
    c();
    paramBoolean1 = TroopInfo.isHomeworkTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    boolean bool = TroopInfo.isAdmin(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramBoolean2)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
      if ((!paramBoolean1) || (!bool)) {
        break label258;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.C);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.G);
      return;
      if ((paramBoolean1) && (bool))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.D);
        break;
      }
      if (!AIOPanelUtiles.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
      break;
      label258:
      if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.B);
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int i = a().indexOf(paramArrayOfInt);
    if (i < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "updateIconNumbers error index =  " + i);
      }
    }
    do
    {
      return;
      paramArrayOfInt = getChildAt(i);
    } while (!(paramArrayOfInt instanceof RedDotImageView));
    ((RedDotImageView)paramArrayOfInt).setUnreadNumber(paramInt);
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
    switch (PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
    default: 
      AIOPanelUtiles.A[2] = 2130837690;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.A);
      return;
      AIOPanelUtiles.A[2] = 2130837690;
      continue;
      AIOPanelUtiles.A[2] = 2130837690;
      continue;
      AIOPanelUtiles.A[2] = 2130837639;
      continue;
      AIOPanelUtiles.A[2] = 2130837703;
      continue;
      AIOPanelUtiles.A[2] = 2130837701;
      continue;
      AIOPanelUtiles.A[2] = 2130837643;
      continue;
      AIOPanelUtiles.A[2] = 2130837702;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          a(paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback.a(paramView.getTag());
          try
          {
            i = ((Integer)paramView.getTag()).intValue();
            if (i == 2)
            {
              ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("103100.103300");
              if ((paramView instanceof RedDotImageView)) {
                ((RedDotImageView)paramView).a(false);
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
              return;
            }
          }
          catch (Exception paramView)
          {
            QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
            return;
          }
          if (i == 10)
          {
            QWalletTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.c);
            return;
          }
          if (i != 6) {
            break;
          }
          if ((ShortVideoUtils.e()) && (CameraUtils.a())) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
          }
          if (!jdField_b_of_type_JavaLangBoolean.booleanValue())
          {
            setShowRed(6, false);
            RedBagVideoManager.a(RedBagVideoManager.d);
            return;
          }
        } while (!jdField_a_of_type_JavaLangBoolean.booleanValue());
        setShowRed(6, false);
        ShortVideoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        return;
        if (i != 24) {
          break;
        }
      } while (!jdField_a_of_type_Boolean);
      setShowRed(24, false);
      ShortVideoUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009367", "0X8009367", 2, 0, "", "", "", "");
      jdField_a_of_type_Boolean = false;
      return;
    } while ((i != 8) || (!a(this.c)));
    ScribbleResMgr.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    setShowRed(8, false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener.a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener.b(paramMotionEvent);
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
    if ((localView != null) && (AppSetting.b)) {
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
  
  public void setInterceptListener(PanelIconLinearLayout.InterceptListener paramInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener = paramInterceptListener;
  }
  
  public void setPanelIconListener(PanelIconLinearLayout.PanelIconCallback paramPanelIconCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback = paramPanelIconCallback;
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
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt)))
        {
          ((RedDotImageView)localView).setReddotXOffsetDp(15);
          ((RedDotImageView)localView).setRedDotDrawable(getResources().getDrawable(2130846134));
          ((RedDotImageView)localView).a(paramBoolean);
        }
      }
      else
      {
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */