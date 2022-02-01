package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
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
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessListUI;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
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
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
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
  protected boolean N;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  protected MessageObserver a;
  ConfessHandler jdField_a_of_type_ComTencentMobileqqConfessConfessHandler;
  protected ConfessInfo a;
  ConfessObserver jdField_a_of_type_ComTencentMobileqqConfessConfessObserver = new ConfessChatPie.1(this);
  private ConfessProgressView jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  MqqHandler b;
  private String f;
  private int k = -1;
  private ImageView l;
  private View m;
  private View n;
  
  public ConfessChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ConfessChatPie.4(this);
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 2130845108;
    case 0: 
      return 2130845102;
    case 1: 
      return 2130845103;
    case 2: 
      return 2130845105;
    case 3: 
      return 2130845106;
    case 4: 
      return 2130845107;
    case 6: 
      return 2130845109;
    case 7: 
      return 2130845110;
    case 8: 
      return 2130845111;
    case 9: 
      return 2130845112;
    }
    return 2130845104;
  }
  
  private void bi()
  {
    long l1;
    if (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      t(false);
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
  
  private void bj()
  {
    if ((this.m != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
    {
      String str = UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
      if (ConfessConfig.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
        this.m.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.m.setVisibility(8);
  }
  
  private void bk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843878);
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843878);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232).setVisibility(8);
    }
    for (;;)
    {
      try
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843884);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843897);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
        this.e.setTextColor(AnonymousChatHelper.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843904);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
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
          Object localObject1 = (AIOEmoticonUIHelper)a(105);
          if (localObject1 != null) {
            ((AIOEmoticonUIHelper)localObject1).b(true);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_b_of_type_Boolean = false;
          b(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702440) + this.jdField_f_of_type_JavaLangString);
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-855638017);
          this.e.setTextColor(-855638017);
          localObject1 = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          ((View)localObject1).setBackgroundColor(-2013265920);
          Object localObject2 = new RelativeLayout.LayoutParams(-1, 2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = HardCodeUtil.a(2131702441);
          if (this.N) {
            localObject1 = HardCodeUtil.a(2131702442);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131370317).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription((String)localObject1);
          localObject1 = new ConfessNewsBgView(this.jdField_a_of_type_AndroidContentContext);
          ((ConfessNewsBgView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
            break label955;
          }
          i = 858006566;
          ((ConfessNewsBgView)localObject1).setBgColor(i);
          ((ConfessNewsBgView)localObject1).setSize(2);
          if (ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561156, null);
            this.jdField_d_of_type_AndroidViewViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
            localObject2 = ((View)localObject1).findViewById(2131381804);
            this.l = ((ImageView)((View)localObject1).findViewById(2131368466));
            this.l.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView = ((ConfessProgressView)((View)localObject1).findViewById(2131365189));
            float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
            this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.setSize(24.0F * f1, 27.0F * f1, -0.15F * f1, -0.5F * f1);
            this.m = ((View)localObject1).findViewById(2131368458);
            this.m.setVisibility(8);
            this.n = ((View)localObject1).findViewById(2131368456);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
            {
              localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
              ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = ((int)(9.0F * f1));
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            this.n.setVisibility(4);
            bl();
            if (!ConfessConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide"))
            {
              ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "holmes_guide", true);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
                break label962;
              }
              localObject1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561155, null);
              ((View)localObject1).findViewById(2131368461).setOnClickListener(this);
              ((View)localObject1).setOnClickListener(this);
              this.jdField_d_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ConfessChatPie.2(this, (View)localObject1, (View)localObject2));
            }
            if ((this.G) && (this.l != null)) {
              this.l.setVisibility(4);
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "handleConfessUI error: " + localThrowable.getMessage());
        continue;
        if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          continue;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130851151);
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(AnonymousChatHelper.c);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130838093);
        continue;
      }
      this.e.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845882);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      continue;
      label955:
      int i = 268234225;
      continue;
      label962:
      View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561154, null);
    }
  }
  
  private void bl()
  {
    ThreadManager.excute(new ConfessChatPie.3(this), 16, null, true);
  }
  
  private void bm()
  {
    Object localObject = a();
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.a((Context)localObject, null);
    ((ActionSheet)localObject).addButton(2131690029, 5);
    ((ActionSheet)localObject).addButton(2131690821, 5);
    ((ActionSheet)localObject).addCancelButton(2131690800);
    ((ActionSheet)localObject).setOnButtonClickListener(new ConfessChatPie.5(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  private void t(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView == null) || (this.l == null)) {
      return;
    }
    ConfessConvInfo localConfessConvInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    if (localConfessConvInfo != null)
    {
      if ((localConfessConvInfo.holmesTolCount == 0) || (localConfessConvInfo.holmesCurCount != localConfessConvInfo.holmesTolCount)) {
        break label215;
      }
      this.l.setImageResource(2130845116);
    }
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessProgressView.a(localConfessConvInfo.holmesCurCount, localConfessConvInfo.holmesTolCount);
      this.l.setContentDescription(String.format(HardCodeUtil.a(2131702450), new Object[] { Integer.valueOf(localConfessConvInfo.holmesTolCount), Integer.valueOf(localConfessConvInfo.holmesCurCount) }));
      if ((paramBoolean) && (localConfessConvInfo.holmesCurCount > this.k) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
      {
        if ((i != 0) && (this.l != null)) {
          this.l.setVisibility(4);
        }
        if (this.n != null) {
          this.n.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
      this.k = localConfessConvInfo.holmesCurCount;
      bj();
      return;
      label215:
      this.l.setImageResource(2130845115);
    }
  }
  
  public void J()
  {
    super.J();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    a();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  public void P()
  {
    super.P();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
      a(-16777216, false);
    }
  }
  
  public void Y()
  {
    Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
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
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ConfessListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new ConfessMsgLoader()).a(new ConfessUnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this)).a();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(com.tencent.imcore.message.Message paramMessage) {}
  
  public void a(DraftTextInfo paramDraftTextInfo) {}
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bk();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqConfessConfessObserver);
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessHandler = ((ConfessHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER));
    bi();
    return paramBoolean;
  }
  
  public void aO() {}
  
  public void aP()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    do
    {
      do
      {
        return;
      } while (ThemeUtil.isDefaultOrDIYTheme(false));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033)
      {
        Object localObject = ((FragmentActivity)a()).getSupportFragmentManager();
        ((FragmentManager)localObject).beginTransaction();
        localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
        if (localObject != null)
        {
          localObject = (ChatFragment)localObject;
          if (((ChatFragment)localObject).a != null) {
            ((ChatFragment)localObject).a.setStatusBarDrawable(a().getResources().getDrawable(2130846481));
          }
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.e.setTextColor(-1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850521));
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370317).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setIsDefaultTheme(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850507));
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, SkinEngine.getInstances().getDefaultThemeDrawable(2130850250));
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, SkinEngine.getInstances().getDefaultThemeDrawable(2130850251));
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
        }
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850399);
        Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850396);
        Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850400);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842910 }, localDrawable1);
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
        localStateListDrawable.addState(new int[0], (Drawable)localObject);
        if (this.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
        {
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable(localStateListDrawable);
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(-1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850300));
        return;
      }
      AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130843897);
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void ap()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > j))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131719043, 1);
      return;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    a(localSendMsgParams);
    localSendMsgParams.i = this.E;
    this.E = false;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null, localSendMsgParams);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
    }
    aQ();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { str });
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "ConfessChatPie";
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    String str1 = paramIntent.getStringExtra("key_confessor_nick");
    int i = paramIntent.getIntExtra("key_confessor_sex", 0);
    String str2 = paramIntent.getStringExtra("key_confess_desc");
    long l1 = paramIntent.getLongExtra("key_confess_time", 0L);
    this.N = paramIntent.getBooleanExtra("open_chat_from_rec_confess", false);
    this.jdField_f_of_type_JavaLangString = str1;
    paramIntent = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ConfessChatPie", 1, "friend uin is null ,uintype = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    label345:
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h = this.jdField_f_of_type_JavaLangString;
      if (!this.G)
      {
        ConfessCache localConfessCache = paramIntent.a();
        String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = localConfessCache.a(str3, j, i1, paramIntent, str1, i, str2, l1);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, String.format("updateSession saveConfessItem frdUin:%s type:%s topicId:%d confessorNick:%s confessorSex:%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e), str1, Integer.valueOf(i) }));
        return;
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break;
        paramIntent = new ConfessInfo();
        paramIntent.reset();
        paramIntent.topicId = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        paramIntent.confessorNick = str1;
      }
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int e()
  {
    int i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000 - 200;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if ((paramMessage.what == 60) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843878);
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void k() {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if ((i == 2131369501) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034)) {
      bm();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131368461)
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
          this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        }
      }
      else if (i != 2131368463)
      {
        if (i == 2131368466)
        {
          int j = 2;
          i = j;
          String str1;
          if (this.m != null)
          {
            i = j;
            if (this.m.getVisibility() == 0)
            {
              this.m.setVisibility(8);
              str1 = UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
              ConfessConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false);
              i = 1;
            }
          }
          String str2;
          label192:
          QQAppInterface localQQAppInterface;
          Context localContext;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033)
          {
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localContext = this.jdField_a_of_type_AndroidContentContext;
            j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
              break label358;
            }
          }
          for (;;)
          {
            ConfessConfig.a(localQQAppInterface, localContext, str1, str2, j, bool);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009573", "0X8009573", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e + "", "", str1 + "", str2 + "");
            break;
            str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            break label192;
            label358:
            bool = false;
          }
        }
        super.onClick(paramView);
      }
    }
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie
 * JD-Core Version:    0.7.0.1
 */