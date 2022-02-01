package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.ConfessMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessListUI;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask;
import com.tencent.mobileqq.activity.aio.rebuild.tips.ConfessTipsController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.confess.ConfessProgressView;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class ConfessChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  protected boolean D;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  protected MessageObserver a;
  ConfessHandler jdField_a_of_type_ComTencentMobileqqConfessConfessHandler;
  protected ConfessInfo a;
  ConfessObserver jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new ConfessChatPie.1(this);
  private ConfessProgressView jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  MqqHandler b;
  private String d;
  private int jdField_g_of_type_Int = -1;
  private View jdField_g_of_type_AndroidViewView;
  private View h;
  private ImageView l;
  
  public ConfessChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ConfessChatPie.4(this);
  }
  
  private int a(int paramInt)
  {
    int i = 2130844985;
    switch (paramInt)
    {
    default: 
      return 2130844985;
    case 10: 
      return 2130844981;
    case 9: 
      return 2130844989;
    case 8: 
      return 2130844988;
    case 7: 
      return 2130844987;
    case 6: 
      return 2130844986;
    case 4: 
      return 2130844984;
    case 3: 
      return 2130844983;
    case 2: 
      return 2130844982;
    case 1: 
      return 2130844980;
    case 0: 
      i = 2130844979;
    }
    return i;
  }
  
  private void ao()
  {
    long l1;
    if (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      m(false);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessHandler.a(l1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
  }
  
  private void ap()
  {
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
    {
      String str = UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      if (ConfessConfig.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))
      {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void aq()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843798);
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843798);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646).setVisibility(8);
      try
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843804);
      }
      catch (Throwable localThrowable)
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleConfessUI error: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843817);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
      }
      this.e.setTextColor(AnonymousChatHelper.c);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843824);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
      }
      else if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851067);
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837943);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-16777216);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this, new UpdateParams.Builder().a(true).a());
      }
      localObject1 = (AIOEmoticonUIHelper)a(105);
      if (localObject1 != null) {
        ((AIOEmoticonUIHelper)localObject1).b(true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_Boolean = false;
      a(true);
      localObject1 = this.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702572));
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.f.setTextColor(-855638017);
      this.e.setTextColor(-855638017);
      localObject1 = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((View)localObject1).setBackgroundColor(-2013265920);
      localObject2 = new RelativeLayout.LayoutParams(-1, 2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    else
    {
      this.e.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845755);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
    }
    Object localObject1 = HardCodeUtil.a(2131702573);
    if (this.D) {
      localObject1 = HardCodeUtil.a(2131702574);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369985).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription((String)localObject1);
    localObject1 = new ConfessNewsBgView(this.jdField_a_of_type_AndroidContentContext);
    ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, 0);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
      i = 858006566;
    } else {
      i = 268234225;
    }
    ((ConfessNewsBgView)localObject1).setBgColor(i);
    ((ConfessNewsBgView)localObject1).setSize(2);
    if (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561019, null);
      this.jdField_d_of_type_AndroidViewViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
      localObject2 = ((View)localObject1).findViewById(2131381026);
      this.l = ((ImageView)((View)localObject1).findViewById(2131368212));
      this.l.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView = ((ConfessProgressView)((View)localObject1).findViewById(2131365068));
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.setSize(24.0F * f, 27.0F * f, -0.15F * f, -0.5F * f);
      this.jdField_g_of_type_AndroidViewView = ((View)localObject1).findViewById(2131368204);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.h = ((View)localObject1).findViewById(2131368202);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
      {
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(f * 9.0F));
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.h.setVisibility(4);
      ar();
      if (!ConfessConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide"))
      {
        ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide", true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
          localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561018, null);
        } else {
          localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561017, null);
        }
        ((View)localObject1).findViewById(2131368207).setOnClickListener(this);
        ((View)localObject1).setOnClickListener(this);
        this.jdField_d_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ConfessChatPie.2(this, (View)localObject1, (View)localObject2));
      }
      if (this.z)
      {
        localObject1 = this.l;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(4);
        }
      }
    }
  }
  
  private void ar()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void as()
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.a((Context)localObject, null);
      ((ActionSheet)localObject).addButton(2131689944, 5);
      ((ActionSheet)localObject).addButton(2131690749, 5);
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new ConfessChatPie.5(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView != null)
    {
      if (this.l == null) {
        return;
      }
      ConfessConvInfo localConfessConvInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      if (localConfessConvInfo != null)
      {
        int i;
        if ((localConfessConvInfo.holmesTolCount != 0) && (localConfessConvInfo.holmesCurCount == localConfessConvInfo.holmesTolCount))
        {
          this.l.setImageResource(2130844993);
          i = 0;
        }
        else
        {
          this.l.setImageResource(2130844992);
          i = 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.a(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
        this.l.setContentDescription(String.format(HardCodeUtil.a(2131702582), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
        if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.jdField_g_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
        {
          if (i != 0)
          {
            localObject = this.l;
            if (localObject != null) {
              ((ImageView)localObject).setVisibility(4);
            }
          }
          Object localObject = this.h;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
        }
        this.jdField_g_of_type_Int = localConfessConvInfo.holmesCurCount;
      }
      ap();
    }
  }
  
  public void F()
  {
    Object localObject = a().getSupportFragmentManager();
    ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).a != null) {
        ((ChatFragment)localObject).a.setStatusBarColor(1226741);
      }
    }
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new ConfessMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ConfessListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new ConfessMsgLoader()).a(new ConfessUnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this)).a(new ConfessMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new ConfessTipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  protected void a()
  {
    QQProgressNotifier localQQProgressNotifier = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localQQProgressNotifier != null)
    {
      localQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessHandler = ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER));
    ao();
    return paramBoolean;
  }
  
  public void ai() {}
  
  protected void aj()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) {
        return;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033)
        {
          Object localObject = a().getSupportFragmentManager();
          ((FragmentManager)localObject).beginTransaction();
          localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
          if (localObject != null)
          {
            localObject = (ChatFragment)localObject;
            if (((ChatFragment)localObject).a != null) {
              ((ChatFragment)localObject).a.setStatusBarDrawable(a().getResources().getDrawable(2130846361));
            }
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
          this.e.setTextColor(-1);
          this.f.setTextColor(-1);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850447));
          this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369985).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setIsDefaultTheme(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850433));
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
          AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, SkinEngine.getInstances().getDefaultThemeDrawable(2130850177));
          AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, SkinEngine.getInstances().getDefaultThemeDrawable(2130850178));
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
          }
          localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850326);
          Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850323);
          Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850327);
          StateListDrawable localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
          localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
          localStateListDrawable.addState(new int[0], (Drawable)localObject);
          if (this.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
          {
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(localStateListDrawable);
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(-1);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850227));
          return;
        }
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843817);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
      }
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "ConfessChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l1 = paramIntent.getLongExtra("key_confess_time", 0L);
    this.D = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.jdField_d_of_type_JavaLangString = str1;
    paramIntent = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("friend uin is null ,uintype = ");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      QLog.d("ConfessChatPie", 1, paramIntent.toString());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h = this.jdField_d_of_type_JavaLangString;
    if (!this.z)
    {
      ConfessCache localConfessCache = paramIntent.a();
      String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      } else {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localConfessCache.a(str3, j, k, paramIntent, str1, i, str2, l1);
    }
    else
    {
      paramIntent = new ConfessInfo();
      paramIntent.reset();
      paramIntent.topicId = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
      paramIntent.confessorNick = str1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e), str1, Integer.valueOf(i) }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843798);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void k() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131369216) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
    {
      as();
    }
    else
    {
      Object localObject1;
      if (i == 2131368207)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetPopupWindow;
        if (localObject1 != null)
        {
          ((PopupWindow)localObject1).dismiss();
          this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        }
      }
      else if (i != 2131368209)
      {
        if (i == 2131368212)
        {
          localObject1 = this.jdField_g_of_type_AndroidViewView;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
          {
            this.jdField_g_of_type_AndroidViewView.setVisibility(8);
            localObject1 = UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
            ConfessConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, false);
            i = 1;
          }
          else
          {
            i = 2;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
          {
            str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          else
          {
            str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          }
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
          boolean bool;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
            bool = true;
          } else {
            bool = false;
          }
          ConfessConfig.a(localQQAppInterface, (Context)localObject2, str, (String)localObject1, j, bool);
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("");
          String str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("");
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, (String)localObject2, "", str, localStringBuilder.toString());
        }
        else
        {
          super.onClick(paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    super.p();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    a();
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  protected void w()
  {
    super.w();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
      a(-16777216, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie
 * JD-Core Version:    0.7.0.1
 */