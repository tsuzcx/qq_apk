package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import afmn;
import afmw;
import afmx;
import afnn;
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
import bdla;
import bhid;
import bptp;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;

public class ReminderCardItemPage
  extends ActivateBasePage
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int;
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
  private TextView k;
  
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
  
  private void a(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mUseMemoryCache = false;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString == null) {
      return;
    }
    paramString.setURLDrawableListener(new afmw(this, paramBoolean, paramImageView));
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    String str = paramString;
    if (StringUtil.isEmpty(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    paramString = Uri.parse(str);
    if (paramString != null)
    {
      paramString = paramString.getScheme();
      if (!StringUtil.isEmpty(paramString)) {
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
    if (!StringUtil.isEmpty(paramString))
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
    String str = (String)paramView.getTag(2131364319);
    if (a(str))
    {
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, str, 2102, null);
      return;
    }
    a((String)paramView.getTag(), 0);
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(84.0F);
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560969, this, false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364326));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364327));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364325));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364322));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364323));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(UIUtils.dip2px(getContext(), 4.0F), true);
      this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364328));
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364321));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364318)).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364319));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.k = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364324));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364320));
      this.g.setOnClickListener(this);
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364350));
      int m = bptp.a(getContext()) * 452 / 1334;
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
      localLayoutParams.height = m;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setLayoutParams(localLayoutParams);
      addView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ReminderCardItemPage", 1, "initUI getWidth with a error: ", localThrowable);
      }
    }
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
          a(this.jdField_a_of_type_AndroidWidgetImageView, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", false);
          return;
        }
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        localObject = bhid.a(getContext(), 3, paramAcsMsg.notice_time * 1000L);
        this.f.setText((CharSequence)localObject);
        if (paramAcsMsg.banner_type == 1)
        {
          bool = true;
          RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
          if (!TextUtils.isEmpty(paramAcsMsg.banner_url)) {
            break label268;
          }
          localObject = "https://sola.gtimg.cn/aoi/sola/20200520104458_ifeJLiwYMW.png";
          a(localRoundImageView, (String)localObject, bool);
          this.i.setText(paramAcsMsg.title);
          this.j.setText(paramAcsMsg.content);
          this.jdField_b_of_type_AndroidWidgetButton.setText(paramAcsMsg.btn_text);
          this.jdField_b_of_type_AndroidWidgetButton.setTag(paramAcsMsg.jump_url);
          this.jdField_b_of_type_AndroidWidgetButton.setTag(2131364319, paramAcsMsg.applet_jump_url);
          if (paramAcsMsg.type != 1) {
            break;
          }
          this.h.setVisibility(0);
          this.g.setVisibility(0);
          return;
        }
      }
      catch (Throwable paramAcsMsg)
      {
        QLog.e("ReminderCardItemPage", 1, "initData throw an exception: " + paramAcsMsg);
        return;
      }
      boolean bool = false;
      continue;
      label268:
      Object localObject = paramAcsMsg.banner_url;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0;
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
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
        afmn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_allclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, null, String.valueOf(this.jdField_a_of_type_WalletAcsMsg.mn_reserved));
      }
      a("https://ti.qq.com/remind/index", 2001);
      continue;
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
        }
        if (this.jdField_a_of_type_WalletAcsMsg.type != 0) {
          break label308;
        }
      }
      label308:
      for (int m = 1;; m = 2)
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "2", 102, this.jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
        afmn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_contentclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, String.valueOf(m), String.valueOf(this.jdField_a_of_type_WalletAcsMsg.mn_reserved));
        b(paramView);
        break;
      }
      afmn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_rejectclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, null, this.jdField_a_of_type_WalletAcsMsg.mn_reserved);
      afnn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_WalletAcsMsg.msg_id, this.jdField_a_of_type_WalletAcsMsg.mn_appid, 1, new afmx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */