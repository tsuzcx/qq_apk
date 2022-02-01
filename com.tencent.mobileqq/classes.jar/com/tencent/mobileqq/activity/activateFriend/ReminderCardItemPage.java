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
  private static int n;
  public AcsMsg k;
  private ActivateFriendActivity l;
  private QQAppInterface m;
  private ImageView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private RelativeLayout s;
  private RelativeLayout t;
  private RoundImageView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private Button y;
  
  public ReminderCardItemPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReminderCardItemPage(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.l = ((ActivateFriendActivity)paramContext);
    this.m = paramQQAppInterface;
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
    if (StringUtil.isEmpty(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    Object localObject = Uri.parse(str);
    if (localObject != null)
    {
      paramString = new FakeUrl();
      paramString.init(this.l);
      localObject = ((Uri)localObject).getScheme();
      if (!StringUtil.isEmpty((String)localObject))
      {
        if ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https"))) {
          if (paramInt == 0) {
            paramString.gotoH5(getContext(), str, true, true);
          } else {
            paramString.gotoResultH5(this.l, str, true, paramInt);
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
    return (!StringUtil.isEmpty(paramString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString));
  }
  
  private void b(View paramView)
  {
    String str = (String)paramView.getTag(2131430344);
    if (QQReminderAMSHelper.b(this.k))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderCardItemPage", 1, new Object[] { "is AMS reminder: ", Boolean.valueOf(true) });
      }
      QQReminderAMSHelper.a(new WeakReference(this.l), this.k, "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc");
      return;
    }
    if (a(str))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.l, str, 2102, null);
      return;
    }
    a((String)paramView.getTag(), 0);
  }
  
  public void a()
  {
    try
    {
      if (n == 0) {
        n = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(84.0F);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReminderCardItemPage", 1, "initUI getWidth with a error: ", localThrowable);
    }
    this.b = this.a.inflate(2131627260, this, false);
    this.o = ((ImageView)this.b.findViewById(2131430351));
    this.p = ((TextView)this.b.findViewById(2131430352));
    this.s = ((RelativeLayout)this.b.findViewById(2131430350));
    this.t = ((RelativeLayout)this.b.findViewById(2131430347));
    this.u = ((RoundImageView)this.b.findViewById(2131430348));
    this.u.setmRadius(UIUtils.a(getContext(), 4.0F), true);
    this.v = ((TextView)this.b.findViewById(2131430353));
    this.w = ((TextView)this.b.findViewById(2131430346));
    ((TextView)this.b.findViewById(2131430343)).setOnClickListener(this);
    this.y = ((Button)this.b.findViewById(2131430344));
    this.y.setOnClickListener(this);
    this.x = ((TextView)this.b.findViewById(2131430349));
    this.q = ((TextView)this.b.findViewById(2131430345));
    this.q.setOnClickListener(this);
    this.r = ((TextView)this.b.findViewById(2131430375));
    int i = ScreenUtil.getInstantScreenHeight(getContext()) * 452 / 1334;
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    localLayoutParams.height = i;
    this.u.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    for (;;)
    {
      try
      {
        this.k = paramAcsMsg;
        if (paramAcsMsg == null)
        {
          this.p.setVisibility(4);
          this.s.setVisibility(0);
          this.t.setVisibility(8);
          this.y.setVisibility(8);
          a(this.o, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", false);
          return;
        }
        this.p.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        this.y.setVisibility(0);
        localObject = TimeFormatterUtils.a(getContext(), 3, paramAcsMsg.notice_time * 1000L);
        this.p.setText((CharSequence)localObject);
        if (paramAcsMsg.banner_type != 1) {
          break label279;
        }
        bool = true;
        RoundImageView localRoundImageView = this.u;
        if (TextUtils.isEmpty(paramAcsMsg.banner_url)) {
          localObject = "https://sola.gtimg.cn/aoi/sola/20200520104458_ifeJLiwYMW.png";
        } else {
          localObject = paramAcsMsg.banner_url;
        }
        a(localRoundImageView, (String)localObject, bool);
        this.v.setText(paramAcsMsg.title);
        this.w.setText(paramAcsMsg.content);
        this.y.setText(paramAcsMsg.btn_text);
        this.y.setTag(paramAcsMsg.jump_url);
        this.y.setTag(2131430344, paramAcsMsg.applet_jump_url);
        if (paramAcsMsg.type == 1)
        {
          this.r.setVisibility(0);
          this.q.setVisibility(0);
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
  
  public boolean e()
  {
    return this.s.getVisibility() == 0;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 2;
    switch (j)
    {
    default: 
      break;
    case 2131430345: 
      QQNotifyHelper.a(this.m, "remindcontentpage_rejectclick", this.k.busi_id, this.k.msg_id, null, this.k.mn_reserved);
      Object localObject = (IQQReminderService)this.m.getRuntimeService(IQQReminderService.class, "");
      if (localObject != null) {
        ((IQQReminderService)localObject).sendDelReminderListById(this.k.msg_id, this.k.mn_appid, 1, new ReminderCardItemPage.2(this));
      }
      localObject = (IQQReminderCalendarService)this.m.getRuntimeService(IQQReminderCalendarService.class, "");
      CalendarEntity localCalendarEntity = new CalendarEntity();
      localCalendarEntity.msg_id = this.k.msg_id;
      ((IQQReminderCalendarService)localObject).deleteCalendarAlarm(this.l, localCalendarEntity);
      break;
    case 2131430344: 
      if (this.k != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
        }
        if (this.k.type == 0) {
          i = 1;
        }
        ReportController.b(this.m, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.k.busi_id, this.k.msg_id);
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "2", 102, this.k.msg_id, "15", 1);
        QQNotifyHelper.a(this.m, "remindcontentpage_contentclick", this.k.busi_id, this.k.msg_id, String.valueOf(i), String.valueOf(this.k.mn_reserved));
      }
      b(paramView);
      break;
    case 2131430343: 
      if (this.k != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
        }
        ReportController.b(this.m, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.k.busi_id, this.k.msg_id);
        QQNotifyHelper.a(this.m, "remindcontentpage_allclick", this.k.busi_id, this.k.msg_id, null, String.valueOf(this.k.mn_reserved));
      }
      a("https://ti.qq.com/remind/index", 2001);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */