package com.tencent.mobileqq.activity.qwallet.goldmsg;

import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog;
import com.tencent.mobileqq.activity.qwallet.QWalletFullWindowActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormEditItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;
import xaz;
import xba;
import xbb;
import xbc;
import xbd;
import xbe;

public class GoldMsgAioState
{
  public long a;
  public View a;
  public TextView a;
  public GoldMsgEntryDialog a;
  public QQCustomDialog a;
  public boolean a;
  public View b;
  public TextView b;
  public TextView c;
  
  private TextView a(int paramInt1, int paramInt2, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = new TextView(paramContext);
    paramContext.setBackgroundResource(paramInt2);
    paramContext.setText(paramInt1);
    paramContext.setTextSize(2, 16.0F);
    paramContext.setTextColor(-1);
    paramContext.setClickable(false);
    return paramContext;
  }
  
  public static void a(Window paramWindow, Context paramContext, View paramView)
  {
    if (paramWindow != null)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = paramWindow.getDecorView();
      }
      if (localView != null) {
        ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
  }
  
  public static void b(BaseChatPie paramBaseChatPie)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GoldMsgAioState", 2, " restoreUi");
        }
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          paramBaseChatPie.a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130843245));
          paramBaseChatPie.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845743);
          paramBaseChatPie.m.setVisibility(0);
          paramBaseChatPie.b.findViewById(2131363477).setVisibility(0);
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845508);
          paramBaseChatPie.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
          paramBaseChatPie.d().setTextColor(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
          paramBaseChatPie.c().setTextColor(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
          if (paramBaseChatPie.a().getVisibility() == 0)
          {
            paramBaseChatPie.a().setBackgroundResource(2130846136);
            paramBaseChatPie.a().setTextColor(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494203));
            if (paramBaseChatPie.c().getVisibility() == 0) {
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130846138, 2130846139);
            }
            if (paramBaseChatPie.a().getVisibility() == 0)
            {
              paramBaseChatPie.a().setBackgroundResource(2130846141);
              if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
                break label456;
              }
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845772);
            }
            paramBaseChatPie.b.setBackgroundResource(2130845507);
            if (paramBaseChatPie.b.getBackground() != null) {
              paramBaseChatPie.l();
            }
            if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundResource(2130845549);
            }
            Object localObject = paramBaseChatPie.c.findViewById(2131363486);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            localLayoutParams.addRule(2, 2131363476);
            ((View)localObject).setLayoutParams(localLayoutParams);
            localObject = paramBaseChatPie.a();
            localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            localLayoutParams.addRule(2, 2131363476);
            ((View)localObject).setLayoutParams(localLayoutParams);
            paramBaseChatPie = paramBaseChatPie.b();
            localObject = (RelativeLayout.LayoutParams)paramBaseChatPie.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363476);
            paramBaseChatPie.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          paramBaseChatPie.a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494247), true);
          continue;
        }
        if (paramBaseChatPie.b().getVisibility() != 0) {
          continue;
        }
      }
      catch (Exception paramBaseChatPie)
      {
        paramBaseChatPie.printStackTrace();
        return;
      }
      paramBaseChatPie.b().setBackgroundResource(2130846137);
      paramBaseChatPie.b().setPadding(0, 0, 0, 0);
      paramBaseChatPie.b().setTextColor(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494205));
      paramBaseChatPie.b().setBackgroundResource(2130837562);
      continue;
      label456:
      if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845766);
      }
    }
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GoldMsgAioState", 2, " updateGoldMsgUi");
        }
        Object localObject = (RelativeLayout.LayoutParams)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams;
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2130970947, paramBaseChatPie.a(), false);
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.addRule(2, 2131363476);
          paramBaseChatPie.a().addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372335));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365532);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131372334).setOnClickListener(paramBaseChatPie);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131372333);
        if (ThemeUtil.isNowThemeIsDefault(null, false, null))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramBaseChatPie.a(-5693, false);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(-5693);
          if (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130843951);
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(-16777216);
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493128));
            paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
          }
          paramBaseChatPie.m.setVisibility(8);
          paramBaseChatPie.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-13421773);
          paramBaseChatPie.d().setTextColor(-13421773);
          paramBaseChatPie.c().setTextColor(-13421773);
          if (paramBaseChatPie.a().getVisibility() == 0)
          {
            paramBaseChatPie.a().setBackgroundResource(2130843973);
            paramBaseChatPie.a().setTextColor(-13421773);
            if (paramBaseChatPie.c().getVisibility() == 0) {
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130843992, 2130843992);
            }
            if (paramBaseChatPie.a().getVisibility() == 0)
            {
              paramBaseChatPie.a().setBackgroundDrawable(null);
              if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
                break label608;
              }
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130843998);
            }
            paramBaseChatPie.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(-1298);
            if (paramBaseChatPie.b != null)
            {
              paramBaseChatPie.b.findViewById(2131363477).setVisibility(8);
              paramBaseChatPie.b.getBackground().setVisible(true, false);
              paramBaseChatPie.b.setBackgroundResource(2130843979);
            }
            if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
              paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setBackgroundColor(-5693);
            }
            localObject = paramBaseChatPie.a();
            if (localObject != null) {
              ((TipsManager)localObject).a();
            }
            localObject = paramBaseChatPie.c.findViewById(2131363486);
            localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            localLayoutParams.addRule(2, 2131372333);
            ((View)localObject).setLayoutParams(localLayoutParams);
            localObject = paramBaseChatPie.a();
            localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            localLayoutParams.addRule(2, 2131372333);
            ((View)localObject).setLayoutParams(localLayoutParams);
            paramBaseChatPie = paramBaseChatPie.b();
            localObject = (RelativeLayout.LayoutParams)paramBaseChatPie.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131372333);
            paramBaseChatPie.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          continue;
        }
        if (paramBaseChatPie.b().getVisibility() != 0) {
          continue;
        }
      }
      catch (Exception paramBaseChatPie)
      {
        paramBaseChatPie.printStackTrace();
        return;
      }
      paramBaseChatPie.b().setBackgroundResource(2130843968);
      paramBaseChatPie.b().setTextColor(-13421773);
      paramBaseChatPie.b().setBackgroundResource(2130843981);
      continue;
      label608:
      if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130843995);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, PlusPanel paramPlusPanel)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.c == null)
    {
      this.c = a(2131432268, 2130842423, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
      if (this.c == null) {
        return;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      paramBaseChatPie.jdField_d_of_type_AndroidViewViewGroup.addView(this.c);
      if ((localLayoutParams != null) && (paramPlusPanel != null))
      {
        localLayoutParams.addRule(10, -1);
        localLayoutParams.addRule(9, -1);
        i = paramPlusPanel.getTop();
        localLayoutParams.leftMargin = DisplayUtil.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 95.0F);
        localLayoutParams.topMargin = i;
        if (XPanelContainer.d <= 0) {
          break label170;
        }
      }
    }
    label170:
    for (localLayoutParams.topMargin = (i - XPanelContainer.d / 3 - DisplayUtil.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 5.0F));; localLayoutParams.topMargin = (i - DisplayUtil.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 40.0F)))
    {
      this.c.setLayoutParams(localLayoutParams);
      this.c.setVisibility(0);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      break;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt, RelativeLayout paramRelativeLayout)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = a(paramInt, 2130842424, paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        return;
      }
      paramBaseChatPie = new RelativeLayout.LayoutParams(-2, -2);
      paramBaseChatPie.addRule(2, 2131372333);
      paramBaseChatPie.addRule(14, -1);
      paramRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramBaseChatPie);
    }
    if (paramString != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131432269);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp)
  {
    int i;
    if (paramBoolean)
    {
      paramGoldMsgSetRsp = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramGoldMsgSetRsp != null) {
        paramGoldMsgSetRsp.obtainMessage(51).sendToTarget();
      }
      if (paramGoldMsgSetReq.goldMsgSwitch == 1) {
        i = 2131432298;
      }
    }
    for (;;)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, j, i, 0).a();
        return;
        i = 2131432299;
        break;
      }
      i = 2131432272;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgAioState", 2, " switchGoldMsgModel,isInGoldMsgModel:" + paramBoolean1 + ",fromUpdateSession:" + paramBoolean2);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {}
    try
    {
      c(paramBaseChatPie, paramBoolean1, paramBoolean2, paramString);
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      paramBaseChatPie.printStackTrace();
    }
    b(paramBaseChatPie, paramBoolean1, paramBoolean2, paramString);
    return;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject;
    if ((paramBoolean2) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && ((paramBaseChatPie instanceof FriendChatPie)))
    {
      localObject = GoldMsgChatHelper.GoldMsgFriendSet.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((FriendChatPie)paramBaseChatPie).a((GoldMsgChatHelper.GoldMsgFriendSet)localObject);
    }
    int i;
    if (paramBoolean1)
    {
      if (!this.jdField_a_of_type_Boolean) {
        a(paramBaseChatPie);
      }
      c(paramBaseChatPie);
      if (!paramBoolean2)
      {
        localObject = GoldMsgChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        int j = 0;
        i = j;
        if (QWalletSetting.b(paramString))
        {
          i = j;
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
          {
            String str = QWalletSetting.a(paramString);
            i = j;
            if (!TextUtils.isEmpty(str))
            {
              Intent localIntent = new Intent(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, QWalletFullWindowActivity.class);
              localIntent.putExtra("url", str);
              localIntent.putExtra("webStyle", "noBottomBar");
              localIntent.putExtra("hide_more_button", true);
              localIntent.putExtra("isFullScreen", true);
              localIntent.putExtra("isTransparentTitle", true);
              paramBaseChatPie.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
              QWalletSetting.a(paramString, false);
              i = 1;
            }
          }
        }
        if (i == 0)
        {
          if ((localObject == null) || (((GoldMsgChatHelper.GoldMsgChatState)localObject).b >= ((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)) {
            break label437;
          }
          ((GoldMsgChatHelper.GoldMsgChatState)localObject).a(paramString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long, 0);
          a(paramBaseChatPie, String.format(paramBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131432288), new Object[] { NumAnim.formatNumber(((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long / 100.0D, false) }), 2131432288, paramBaseChatPie.a());
        }
      }
      for (;;)
      {
        if (!paramBoolean2)
        {
          boolean bool = SpriteCommFunc.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          QWalletSetting.a(paramString, "goldmsg_apllo_is_show", bool);
          if (!bool) {
            SpriteCommFunc.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GoldMsg", true);
          }
        }
        this.jdField_a_of_type_Boolean = true;
        if (!paramBoolean2)
        {
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatPie);
          }
          if (paramBaseChatPie.a() != null) {
            paramBaseChatPie.a().g();
          }
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean1) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)) {
            GoldMsgChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, null);
          }
        }
        return;
        label437:
        if (GoldMsgChatHelper.a().c(paramString))
        {
          i = 2131432270;
          if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
            i = 2131432269;
          }
          a(paramBaseChatPie, null, i, paramBaseChatPie.a());
        }
        else if (GoldMsgChatHelper.a().b(paramString))
        {
          a(paramBaseChatPie, paramBaseChatPie.a());
        }
      }
    }
    a();
    b();
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      i = 1;
      label544:
      if ((!this.jdField_a_of_type_Boolean) || (i != 0)) {
        break label654;
      }
      i = 1;
      b(paramBaseChatPie);
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (RelativeLayout.LayoutParams)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363476);
          paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if ((!paramBoolean2) && (!QWalletSetting.a(paramString, "goldmsg_apllo_is_show", true))) {
        SpriteCommFunc.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GoldMsg", false);
      }
      this.jdField_a_of_type_Boolean = false;
      break;
      i = 0;
      break label544;
      label654:
      if (i != 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState = GoldMsgChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Resources localResources;
    String str;
    if (localGoldMsgChatState != null)
    {
      localResources = paramBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources();
      str = NumAnim.formatNumber(localGoldMsgChatState.b / 100.0D, false);
      switch (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        paramBaseChatPie = "";
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatPie);
      return;
      if (localGoldMsgChatState.b < localGoldMsgChatState.jdField_a_of_type_Long)
      {
        localGoldMsgChatState.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localGoldMsgChatState.jdField_a_of_type_Long, 0);
        str = NumAnim.formatNumber(localGoldMsgChatState.jdField_a_of_type_Long / 100.0D, false);
      }
      paramBaseChatPie = localResources.getString(2131432317, new Object[] { str });
      continue;
      paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131432318, new Object[] { str, String.valueOf(localGoldMsgChatState.c) });
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgEntryDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgEntryDialog = new GoldMsgEntryDialog(paramBaseChatPie.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgEntryDialog.show();
    GoldMsgEntryDialog localGoldMsgEntryDialog = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgEntryDialog;
    paramBaseChatPie.a().postDelayed(new xaz(this, localGoldMsgEntryDialog, paramBaseChatPie, paramBoolean1, paramBoolean2, paramString), 500L);
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    Object localObject = GoldMsgChatHelper.a().a(0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long > ((GoldMsgChatHelper.GoldMsgChatState)localObject).b) && (System.currentTimeMillis() - 1000L <= this.jdField_a_of_type_Long))
    {
      ((GoldMsgChatHelper.GoldMsgChatState)localObject).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long, 0);
      localObject = NumAnim.formatNumber(((GoldMsgChatHelper.GoldMsgChatState)localObject).jdField_a_of_type_Long / 100.0D, false) + "元";
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 230);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("好友设置仅接收不少于" + (String)localObject + "的句有料消息，开启后默认单条消息包含金额为" + (String)localObject + "。").setPositiveButton("我知道了", new xba(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      label201:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void e(BaseChatPie paramBaseChatPie)
  {
    Context localContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    switch (localSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramBaseChatPie = GoldMsgChatHelper.a().a(localSessionInfo);
      localObject1 = new Intent();
      long l = 1L;
      if (paramBaseChatPie != null) {
        l = paramBaseChatPie.jdField_a_of_type_Long;
      }
      ((Intent)localObject1).putExtra("goldmsg_min_value_", l);
      PriceSettingDialog.a(localContext, (Intent)localObject1, new xbb(this, localSessionInfo, localQQAppInterface));
      ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.changeamount", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.changeamount", 0, 0, "", "", "", "");
    Resources localResources = localContext.getResources();
    Object localObject1 = null;
    TextWatcher localTextWatcher = null;
    String str1 = localResources.getString(2131432305);
    paramBaseChatPie = "0.03";
    String str2 = localResources.getString(2131432307);
    String str3 = localResources.getString(2131432306);
    Object localObject2 = "3";
    GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState = GoldMsgChatHelper.a().a(localSessionInfo);
    if (localGoldMsgChatState != null)
    {
      paramBaseChatPie = NumAnim.formatNumber(localGoldMsgChatState.b / 100.0D, false);
      localObject2 = "" + localGoldMsgChatState.c;
      localObject1 = localGoldMsgChatState.a(localContext, localSessionInfo.jdField_a_of_type_Int);
      localTextWatcher = localGoldMsgChatState.a(localContext, localSessionInfo.jdField_a_of_type_Int);
    }
    localObject1 = DialogUtil.a(localContext, 2131432319, 2131432304, str1, paramBaseChatPie, str2, (TextWatcher)localObject1, str3, (String)localObject2, localResources.getString(2131432308), localTextWatcher, new xbc(this, localContext), new xbd(this, localContext, localSessionInfo, localQQAppInterface));
    paramBaseChatPie = new xbe(this, (QQCustomDialog)localObject1, localContext);
    localObject2 = (FormEditItem)((QQCustomDialog)localObject1).findViewById(2131364059);
    localObject1 = (FormEditItem)((QQCustomDialog)localObject1).findViewById(2131364061);
    localObject2 = ((FormEditItem)localObject2).a();
    localObject1 = ((FormEditItem)localObject1).a();
    ((EditText)localObject2).setOnFocusChangeListener(paramBaseChatPie);
    ((EditText)localObject1).setOnFocusChangeListener(paramBaseChatPie);
    ((EditText)localObject2).setInputType(8194);
    ((EditText)localObject1).setInputType(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState
 * JD-Core Version:    0.7.0.1
 */