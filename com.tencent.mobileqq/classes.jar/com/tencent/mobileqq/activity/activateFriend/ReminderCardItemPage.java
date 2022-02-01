package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.lang.ref.WeakReference;

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
    paramString.setURLDrawableListener(new ReminderCardItemPage.1(this, paramBoolean, paramImageView));
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    String str = paramString;
    if (StringUtil.a(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    Object localObject = Uri.parse(str);
    if (localObject != null)
    {
      paramString = new FakeUrl();
      paramString.init(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
      localObject = ((Uri)localObject).getScheme();
      if (!StringUtil.a((String)localObject))
      {
        if ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https"))) {
          if (paramInt == 0) {
            paramString.gotoH5(getContext(), str, true, true);
          } else {
            paramString.gotoResultH5(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, str, true, paramInt);
          }
        }
        if (((String)localObject).startsWith("mqqapi")) {
          paramString.gotoMqq(getContext(), str);
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return (!StringUtil.a(paramString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString));
  }
  
  private void b(View paramView)
  {
    String str = (String)paramView.getTag(2131364316);
    if (QQReminderAMSHelper.a(this.jdField_a_of_type_WalletAcsMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderCardItemPage", 1, new Object[] { "is AMS reminder: ", Boolean.valueOf(true) });
      }
      QQReminderAMSHelper.a(new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity), this.jdField_a_of_type_WalletAcsMsg, "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc");
      return;
    }
    if (a(str))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, str, 2102, null);
      return;
    }
    a((String)paramView.getTag(), 0);
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ViewUtils.a() - ViewUtils.b(84.0F);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReminderCardItemPage", 1, "initUI getWidth with a error: ", localThrowable);
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560919, this, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364323));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364324));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364322));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364319));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364320));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(UIUtils.a(getContext(), 4.0F), true);
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364325));
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364318));
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364315)).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364316));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.k = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364321));
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364317));
    this.g.setOnClickListener(this);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364347));
    int m = ScreenUtil.getInstantScreenHeight(getContext()) * 452 / 1334;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
    localLayoutParams.height = m;
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
          a(this.jdField_a_of_type_AndroidWidgetImageView, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", false);
          return;
        }
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        localObject = TimeFormatterUtils.a(getContext(), 3, paramAcsMsg.notice_time * 1000L);
        this.f.setText((CharSequence)localObject);
        if (paramAcsMsg.banner_type != 1) {
          break label279;
        }
        bool = true;
        RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
        if (TextUtils.isEmpty(paramAcsMsg.banner_url)) {
          localObject = "https://sola.gtimg.cn/aoi/sola/20200520104458_ifeJLiwYMW.png";
        } else {
          localObject = paramAcsMsg.banner_url;
        }
        a(localRoundImageView, (String)localObject, bool);
        this.i.setText(paramAcsMsg.title);
        this.j.setText(paramAcsMsg.content);
        this.jdField_b_of_type_AndroidWidgetButton.setText(paramAcsMsg.btn_text);
        this.jdField_b_of_type_AndroidWidgetButton.setTag(paramAcsMsg.jump_url);
        this.jdField_b_of_type_AndroidWidgetButton.setTag(2131364316, paramAcsMsg.applet_jump_url);
        if (paramAcsMsg.type == 1)
        {
          this.h.setVisibility(0);
          this.g.setVisibility(0);
          return;
        }
      }
      catch (Throwable paramAcsMsg)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initData throw an exception: ");
        ((StringBuilder)localObject).append(paramAcsMsg);
        QLog.e("ReminderCardItemPage", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label279:
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    int m = 2;
    switch (n)
    {
    default: 
      break;
    case 2131364317: 
      QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_rejectclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, null, this.jdField_a_of_type_WalletAcsMsg.mn_reserved);
      Object localObject = (IQQReminderService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderService.class, "");
      if (localObject != null) {
        ((IQQReminderService)localObject).sendDelReminderListById(this.jdField_a_of_type_WalletAcsMsg.msg_id, this.jdField_a_of_type_WalletAcsMsg.mn_appid, 1, new ReminderCardItemPage.2(this));
      }
      localObject = (IQQReminderCalendarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQReminderCalendarService.class, "");
      CalendarEntity localCalendarEntity = new CalendarEntity();
      localCalendarEntity.msg_id = this.jdField_a_of_type_WalletAcsMsg.msg_id;
      ((IQQReminderCalendarService)localObject).deleteCalendarAlarm(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, localCalendarEntity);
      break;
    case 2131364316: 
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
        }
        if (this.jdField_a_of_type_WalletAcsMsg.type == 0) {
          m = 1;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "2", 102, this.jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
        QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_contentclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, String.valueOf(m), String.valueOf(this.jdField_a_of_type_WalletAcsMsg.mn_reserved));
      }
      b(paramView);
      break;
    case 2131364315: 
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
        QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "remindcontentpage_allclick", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id, null, String.valueOf(this.jdField_a_of_type_WalletAcsMsg.mn_reserved));
      }
      a("https://ti.qq.com/remind/index", 2001);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */