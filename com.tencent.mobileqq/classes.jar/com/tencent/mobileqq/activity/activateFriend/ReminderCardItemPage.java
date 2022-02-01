package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import afsx;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import bcst;
import bgsp;
import blyl;
import bqja;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.FakeUrl;
import zlx;

public class ReminderCardItemPage
  extends ActivateBasePage
  implements View.OnClickListener
{
  public AcsMsg a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ActivateFriendActivity jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  public ReminderCardItemPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReminderCardItemPage(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity = ((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mUseMemoryCache = false;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString != null) {
      paramImageView.setImageDrawable(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    String str = paramString;
    if (bgsp.a(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    paramString = Uri.parse(str);
    if (paramString != null)
    {
      paramString = paramString.getScheme();
      if (!bgsp.a(paramString)) {
        if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
        {
          if (paramInt != 0) {
            break label83;
          }
          FakeUrl.gotoH5(getContext(), str, true, true);
        }
      }
    }
    for (;;)
    {
      if (paramString.startsWith("mqqapi")) {
        FakeUrl.gotoMqq(getContext(), str);
      }
      return;
      label83:
      FakeUrl.gotoResultH5(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, str, true, paramInt);
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bgsp.a(paramString))
    {
      bool1 = bool2;
      if (MiniAppLauncher.isMiniAppUrl(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(View paramView)
  {
    String str = (String)paramView.getTag(2131364179);
    if (a(str))
    {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, str, 2102, null);
      return;
    }
    a((String)paramView.getTag(), 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561004, this, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364185));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364186));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364184));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364181));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364182));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(zlx.a(getContext(), 5.0F), true);
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364187));
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364180));
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364178));
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364179));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364183));
    int k = bqja.a(getContext()) * 542 / 1334;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
    localLayoutParams.height = k;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_WalletAcsMsg = paramAcsMsg;
        if (paramAcsMsg == null)
        {
          this.f.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          a(this.jdField_a_of_type_AndroidWidgetImageView, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png");
          return;
        }
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.f.setText(afsx.a(paramAcsMsg.notice_time * 1000L, "HH:mm"));
        RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
        if (TextUtils.isEmpty(paramAcsMsg.banner_url))
        {
          str = "https://sola.gtimg.cn/aoi/sola/20200520104458_ifeJLiwYMW.png";
          a(localRoundImageView, str);
          this.j.setText(afsx.a(paramAcsMsg.sub_time * 1000L, "yyyy.MM.dd") + anni.a(2131716129) + paramAcsMsg.busi_name + anni.a(2131716130));
          this.g.setText(paramAcsMsg.title);
          this.h.setText(paramAcsMsg.content);
          this.jdField_b_of_type_AndroidWidgetButton.setText(paramAcsMsg.btn_text);
          this.jdField_b_of_type_AndroidWidgetButton.setTag(paramAcsMsg.jump_url);
          this.jdField_b_of_type_AndroidWidgetButton.setTag(2131364179, paramAcsMsg.applet_jump_url);
          return;
        }
      }
      catch (Throwable paramAcsMsg)
      {
        QLog.e("ReminderCardItemPage", 1, "initData throw an exception: " + paramAcsMsg);
        return;
      }
      String str = paramAcsMsg.banner_url;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
      }
      if (1 == QzoneConfig.getInstance().getConfig("QZoneSetting", "QQRemindAllRemindUseH5", 1))
      {
        a(QzoneConfig.getInstance().getConfig("H5Url", "QQRemindAllRemind", "https://h5.qianbao.qq.com/notice?_wv=1027&_wvx=10&_wwv=4"), 2001);
      }
      else
      {
        ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
        continue;
        if (this.jdField_a_of_type_WalletAcsMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
          blyl.a().a("qqremind", "3", "2", 102, this.jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
        }
        b(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */