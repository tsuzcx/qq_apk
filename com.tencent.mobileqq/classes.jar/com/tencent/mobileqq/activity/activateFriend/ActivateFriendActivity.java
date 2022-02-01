package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderOrderModel;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.biz.entity.IReminderEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ViewPager.OnPageChangeListener, Observer
{
  private static final int c = ViewUtils.dpToPx(16.0F);
  Handler a = new Handler(Looper.getMainLooper(), new ActivateFriendActivity.5(this));
  MemorialActivatePage b;
  private int d = 0;
  private ImageView e;
  private TextView f;
  private ReminderViewPager g;
  private ActivatePageAdapter h;
  private LinearLayout i = null;
  private int j;
  private int k;
  private ActivateFriendsManager l;
  private IQQReminderDataService m;
  private boolean n = false;
  private long o;
  private boolean p = false;
  private boolean q = false;
  private long r = -1L;
  private int s;
  private BirthdayActivatePageArkView t;
  private MemorialActivatePageArk u;
  private CardObserver v = new ActivateFriendActivity.8(this);
  private ActivateFriendsObserver w = new ActivateFriendActivity.9(this);
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    if (this.b == null) {
      this.b = new MemorialActivatePage(this, this.app, paramInt1, String.valueOf(paramLong2), paramInt2, paramString1, paramString2, paramString3, paramString4, paramInt3);
    }
    this.b.a(paramLong1);
    this.h.a(this.b);
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
  {
    try
    {
      if (this.u == null)
      {
        this.u = new MemorialActivatePageArk(this);
        if (this.u.a(paramLong, paramJSONObject, this.s)) {
          this.h.a(this.u);
        }
      }
      else if (this.u.a(paramLong, paramJSONObject, this.s))
      {
        this.h.a(this.u);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("erro ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.e("ActivateFriends.MainActivity", 1, localStringBuilder.toString());
    }
  }
  
  private void a(SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    SubMsgType0x76.MsgBody localMsgBody = ((MessageForActivateFriends)paramMessageRecord).getMsgBody();
    long l1 = paramMessageRecord.time * 1000L;
    int i1 = localMsgBody.uint32_msg_type.get();
    if ((i1 == 1) && (!paramSparseBooleanArray.get(1, false)))
    {
      QLog.w("ActivateFriends.MainActivity", 1, "MSG_TYPE_GEO is no longer support!");
      return;
    }
    if ((i1 == 2) && (!paramSparseBooleanArray.get(2, false)))
    {
      paramMessageRecord = BirthdayActivateData.a(localMsgBody.msg_birthday_notify, this.app);
      a(this.app, l1, paramMessageRecord);
      paramSparseBooleanArray.put(2, true);
      if (paramBoolean) {
        LpReportInfo_pf00064.allReport(220, 2, 1);
      }
    }
    else if ((i1 == 3) && (!paramSparseBooleanArray.get(3, false)))
    {
      a(paramSparseBooleanArray, paramBoolean, localMsgBody, l1);
    }
  }
  
  private void a(SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean, SubMsgType0x76.MsgBody paramMsgBody, long paramLong)
  {
    Object localObject = (SubMsgType0x76.OneMemorialDayInfo)paramMsgBody.msg_memorialday_notify.rpt_anniversary_info.get(0);
    long l1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).uint64_uin.get();
    int i1 = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject).uint32_type.get();
    int i2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).uint32_memorial_time.get();
    paramMsgBody = ((SubMsgType0x76.OneMemorialDayInfo)localObject).bytes_main_wording_nick.get().toStringUtf8();
    String str1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).bytes_main_wording_event.get().toStringUtf8();
    String str2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).bytes_sub_wording.get().toStringUtf8();
    String str3 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).bytes_greetings.get().toStringUtf8();
    int i3 = ((SubMsgType0x76.OneMemorialDayInfo)localObject).uint32_friend_gender.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("memorial_type:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" pushTime:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" timeStamp:");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" titleNick:");
      ((StringBuilder)localObject).append(paramMsgBody);
      ((StringBuilder)localObject).append(" titleEvent:");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" subTitle:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(" greetings:");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(" gender:");
      ((StringBuilder)localObject).append(i3);
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject).toString());
    }
    a(i1, paramLong, l1, i2, paramMsgBody, str1, str2, str3, i3);
    paramSparseBooleanArray.put(3, true);
    if (paramBoolean) {
      LpReportInfo_pf00064.allReport(220, 2, 2);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    try
    {
      if (this.t == null)
      {
        this.t = new BirthdayActivatePageArkView(this);
        this.t.a(paramLong, paramString, this.s);
        this.h.a(this.t);
        return;
      }
      this.t.a(paramLong, paramString, this.s);
      this.h.a(this.t);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("erro ");
      paramString.append(paramQQAppInterface.toString());
      QLog.e("ActivateFriends.MainActivity", 1, paramString.toString());
    }
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
      if (!StringUtil.isEmpty(paramString))
      {
        FakeUrl localFakeUrl = new FakeUrl();
        localFakeUrl.init(this);
        if ((paramString.startsWith("http")) || (paramString.startsWith("https"))) {
          if (paramInt == 0) {
            localFakeUrl.gotoH5(this, str, true, true);
          } else {
            localFakeUrl.gotoResultH5(this, str, true, paramInt);
          }
        }
        if (paramString.startsWith("mqqapi")) {
          localFakeUrl.gotoMqq(this, str);
        }
      }
    }
  }
  
  private void a(ArrayList<QQReminderOrderModel> paramArrayList)
  {
    boolean bool = this.q;
    int i1 = 1;
    if (!bool)
    {
      int i2;
      StringBuilder localStringBuilder;
      if (c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
        }
        ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
        MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)this.h.a().get(0)).k.msg_id, "15", 1);
        if (getIntent() != null)
        {
          i2 = getIntent().getIntExtra("af_key_from", 0);
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("from : ");
            paramArrayList.append(i2);
            QLog.d("ActivateFriends.MainActivity", 2, paramArrayList.toString());
          }
          if (i2 == 4)
          {
            paramArrayList = this.app.getMessageFacade().B();
            if (paramArrayList != null)
            {
              long l1 = paramArrayList.uniseq;
              localStringBuilder = null;
              Object localObject = this.m.getCacheKeyList().iterator();
              do
              {
                paramArrayList = localStringBuilder;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                paramArrayList = (String)((Iterator)localObject).next();
              } while (l1 != paramArrayList.hashCode());
              localObject = this.m.getEntityByKey(paramArrayList);
              paramArrayList = localStringBuilder;
              if (localObject != null) {
                paramArrayList = ((IReminderEntity)localObject).getAcsMsg();
              }
              if (paramArrayList != null) {
                QQNotifyHelper.a(this.app, "push_click", paramArrayList.busi_id, paramArrayList.msg_id, null, null);
              } else {
                QQNotifyHelper.a(this.app, "push_click", null, null, null, null);
              }
            }
          }
          else if (i2 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
            }
            QQNotifyHelper.a(this.app, "newslisting_click", null, null, null, null);
            ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
          }
        }
      }
      else if ((d()) && (getIntent() != null))
      {
        i2 = getIntent().getIntExtra("af_key_from", 0);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("from : ");
          localStringBuilder.append(i2);
          QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
        }
        paramArrayList = (MessageForReminder)((QQReminderOrderModel)paramArrayList.get(0)).a;
        if (paramArrayList != null)
        {
          int i3 = QQNotifyHelper.a(paramArrayList.getMsgBody().toByteArray());
          if (i2 == 4)
          {
            paramArrayList = this.app;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(i3);
            QQNotifyHelper.a(paramArrayList, "push_click", null, null, null, localStringBuilder.toString());
          }
          else if (i2 == 1)
          {
            paramArrayList = this.app;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(i3);
            QQNotifyHelper.a(paramArrayList, "newslisting_click", null, null, null, localStringBuilder.toString());
          }
        }
      }
      this.q = true;
    }
    paramArrayList = this.h;
    if (paramArrayList != null)
    {
      paramArrayList = (ActivateBasePage)paramArrayList.a().get(0);
      if ((paramArrayList instanceof ReminderCardItemPage))
      {
        paramArrayList = (ReminderCardItemPage)paramArrayList;
        if (!paramArrayList.e())
        {
          paramArrayList = paramArrayList.k;
          if (paramArrayList.type != 0) {
            i1 = 2;
          }
          QQNotifyHelper.a(this.app, "remindcontentpage_exp", paramArrayList.busi_id, paramArrayList.msg_id, String.valueOf(i1), paramArrayList.mn_reserved);
          QQReminderAMSHelper.a(paramArrayList);
        }
      }
    }
  }
  
  private void a(ArrayList<QQReminderOrderModel> paramArrayList, List<AcsMsg> paramList)
  {
    Object localObject1;
    Object localObject2;
    if ((QLog.isColorLevel()) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get today's list size: ");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.i("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject1).toString());
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AcsMsg)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("acsMsg notice time: ");
        localStringBuilder.append(DateUtil.a(((AcsMsg)localObject2).notice_time * 1000L, "yyyy-MM-dd HH:mm:ss"));
        QLog.i("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (AcsMsg)paramList.next();
        localObject2 = new QQReminderOrderModel();
        ((QQReminderOrderModel)localObject2).c = ((AcsMsg)localObject1).notice_time;
        ((QQReminderOrderModel)localObject2).a = null;
        ((QQReminderOrderModel)localObject2).b = ((AcsMsg)localObject1);
        paramArrayList.add(localObject2);
      }
    }
  }
  
  private void a(ArrayList<QQReminderOrderModel> paramArrayList, List<AcsMsg> paramList, int paramInt)
  {
    Iterator localIterator = this.h.a().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (ActivateBasePage)localIterator.next();
      if ((localObject instanceof BirthdayActivatePage)) {
        ((BirthdayActivatePage)localObject).e();
      }
    }
    this.h.d();
    if (this.n) {
      a(paramArrayList, paramList);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("after order list : ");
      paramList.append(paramArrayList);
      QLog.d("ActivateFriends.MainActivity", 2, paramList.toString());
    }
    Collections.sort(paramArrayList, new ActivateFriendActivity.4(this));
    paramList = new SparseBooleanArray(4);
    boolean bool = paramArrayList.isEmpty();
    int i1 = 0;
    if (!bool)
    {
      localIterator = paramArrayList.iterator();
      i1 = 0;
      bool = true;
      while (localIterator.hasNext())
      {
        localObject = (QQReminderOrderModel)localIterator.next();
        if (((QQReminderOrderModel)localObject).a != null)
        {
          localObject = ((QQReminderOrderModel)localObject).a;
          if ((localObject instanceof MessageForActivateFriends))
          {
            a(paramList, bool, (MessageRecord)localObject);
          }
          else if (((localObject instanceof MessageForReminder)) && (MemorialActivatePageArk.h()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "showReminderPage");
            }
            a((MessageRecord)localObject, paramList);
          }
          bool = false;
        }
        else if (((QQReminderOrderModel)localObject).b != null)
        {
          long l1 = ((QQReminderOrderModel)localObject).b.notice_time * 1000L;
          AcsMsg localAcsMsg = ((QQReminderOrderModel)localObject).b;
          if (((localAcsMsg.type == 0) && (DateUtil.a(l1)) && (this.o > l1)) || ((localAcsMsg.type == 1) && (this.o - l1 < 86400000L)))
          {
            b(((QQReminderOrderModel)localObject).b);
            i1 = 1;
          }
        }
      }
    }
    if (paramInt == 0) {
      g();
    }
    if (i1 == 0) {
      b(null);
    }
    if (paramInt > 0)
    {
      paramList = this.t;
      if (paramList != null) {
        paramList.e();
      }
    }
    i();
    a(paramArrayList);
  }
  
  private boolean a(String paramString)
  {
    return (!StringUtil.isEmpty(paramString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString));
  }
  
  private void b(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.show");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.show", 0, 0, "", "", paramAcsMsg.busi_id, paramAcsMsg.msg_id);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.none");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.none", 0, 0, "", "", "", "");
    }
    ReminderCardItemPage localReminderCardItemPage = new ReminderCardItemPage(this, this.app);
    localReminderCardItemPage.a(paramAcsMsg);
    this.h.a(localReminderCardItemPage);
  }
  
  private void c(AcsMsg paramAcsMsg)
  {
    if (a(paramAcsMsg.applet_jump_url))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, paramAcsMsg.applet_jump_url, 2102, null);
      return;
    }
    a(paramAcsMsg.jump_url, 0);
  }
  
  private boolean c()
  {
    Object localObject = this.h;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivatePageAdapter)localObject).a();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return false;
      }
      localObject = (ActivateBasePage)((ArrayList)localObject).get(0);
      bool1 = bool2;
      if ((localObject instanceof ReminderCardItemPage))
      {
        bool1 = bool2;
        if (((ReminderCardItemPage)localObject).k != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean d()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivatePageAdapter)localObject).a();
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return false;
      }
      return (ActivateBasePage)((ArrayList)localObject).get(0) instanceof MemorialActivatePageArk;
    }
    return false;
  }
  
  private TopGestureLayout e()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  private void f()
  {
    super.setContentView(2131627249);
    super.setTitle(2131886175);
    this.e = ((ImageView)super.findViewById(2131436194));
    this.e.setVisibility(0);
    this.e.setImageResource(2130841087);
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131436180));
    this.i = ((LinearLayout)super.findViewById(2131441195));
    this.g = ((ReminderViewPager)findViewById(2131427597));
    this.h = new ActivatePageAdapter(this.g);
    this.g.setAdapter(this.h);
    this.g.setOnPageChangeListener(this);
    this.g.setPageMargin(c);
    this.d = getIntent().getIntExtra("af_key_from", 1);
    this.l = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.n = this.l.a(true);
    if (AppSetting.e) {
      this.e.setContentDescription(getString(2131916361));
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mViewPager height: ");
      localStringBuilder.append(localLayoutParams1.height);
      QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPageIndicator topMargin: ");
      localStringBuilder.append(localLayoutParams2.topMargin);
      QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("screen height: ");
      localStringBuilder.append(UIUtils.d(this));
      QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
    }
    double d1;
    if (localLayoutParams1 != null)
    {
      d1 = UIUtils.d(this);
      Double.isNaN(d1);
      this.s = ((int)(d1 * 0.785D));
      int i1 = ViewUtils.dpToPx(550.0F);
      int i2 = this.s;
      if (i2 >= i1) {
        i1 = i2;
      }
      this.s = i1;
      localLayoutParams1.height = this.s;
      this.g.setLayoutParams(localLayoutParams1);
    }
    if (localLayoutParams2 != null)
    {
      d1 = UIUtils.d(this);
      Double.isNaN(d1);
      localLayoutParams2.topMargin = ((int)(d1 * 0.8050000000000001D));
      this.i.setLayoutParams(localLayoutParams2);
    }
  }
  
  private void g()
  {
    if (this.n)
    {
      a(this.app, System.currentTimeMillis(), BirthdayActivateData.a(null, this.app));
      this.l.c();
      a();
      return;
    }
    a(this.app, System.currentTimeMillis(), null);
    Object localObject = this.t;
    if (localObject != null) {
      ((BirthdayActivatePageArkView)localObject).a(false);
    }
    localObject = (TextView)this.t.b.findViewById(2131432518);
    SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131898036));
    localSpannableString.setSpan(new ActivateFriendActivity.1(this), 0, 2, 33);
    ((TextView)localObject).setText(localSpannableString);
    ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private boolean h()
  {
    if (this.n) {
      this.m.checkTodayReminder();
    } else {
      ((IQQReminderAlarmService)this.app.getRuntimeService(IQQReminderAlarmService.class, "")).clearAllAlarm();
    }
    if (getIntent().getExtras() != null) {
      localObject1 = getIntent().getExtras().getString("leftViewText");
    } else {
      localObject1 = null;
    }
    int i1;
    if ((localObject1 != null) && (((String)localObject1).contains(getString(2131917002)))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.app.getMessageFacade().addObserver(this);
    }
    Object localObject1 = this.app.getMessageFacade().h(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current message count = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ArrayList();
    Object localObject4;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject3 = ((List)localObject1).iterator();
      boolean bool1 = false;
      i1 = 0;
      for (;;)
      {
        bool2 = bool1;
        i2 = i1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if ((localObject4 instanceof MessageForActivateFriends))
        {
          i1 += 1;
        }
        else if ((localObject4 instanceof MessageForText))
        {
          ((List)localObject2).add((MessageForText)localObject4);
          ((Iterator)localObject3).remove();
        }
        else if ((localObject4 instanceof MessageForReminder))
        {
          bool1 = true;
        }
      }
    }
    boolean bool2 = false;
    int i2 = 0;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initData | message count = ");
      ((StringBuilder)localObject2).append(i2);
      QLog.d("ActivateFriends.MainActivity", 2, new Object[] { ((StringBuilder)localObject2).toString(), " has memorial Msg: ", Boolean.valueOf(bool2) });
    }
    localObject2 = new ArrayList(((List)localObject1).size());
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      if (((localObject4 instanceof MessageForActivateFriends)) && (!((MessageRecord)localObject4).isread) && ((((MessageRecord)localObject4).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject4).extStr))) {
        ((List)localObject2).add(((MessageRecord)localObject4).extStr);
      }
    }
    if (((List)localObject2).size() > 0) {
      ActivateFriendServlet.a(this.app, (ArrayList)localObject2);
    }
    this.app.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
    localObject2 = this.h;
    if (localObject2 != null) {
      ((ActivatePageAdapter)localObject2).d();
    }
    Collections.sort((List)localObject1, new ActivateFriendActivity.2(this));
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("entrance type : ");
      ((StringBuilder)localObject2).append(getIntent().getIntExtra("af_key_from", 0));
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i2 > 0) && (((List)localObject1).size() > 0) && ((((List)localObject1).get(0) instanceof MessageForActivateFriends)))
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForActivateFriends))
        {
          localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
          if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 1) {
            i1 = 2;
          } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2) {
            i1 = 1;
          } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 3) {
            i1 = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
          } else {
            i1 = -1;
          }
          localObject2 = this.app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(getIntent().getIntExtra("af_key_from", 1));
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004E05", "0X8004E05", i1, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
      }
    }
    localObject2 = new ArrayList();
    if ((i2 > 0) || (bool2))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        if (((localObject3 instanceof MessageForActivateFriends)) || ((localObject3 instanceof MessageForReminder)))
        {
          localObject4 = new QQReminderOrderModel();
          ((QQReminderOrderModel)localObject4).c = ((MessageRecord)localObject3).time;
          ((QQReminderOrderModel)localObject4).a = ((MessageRecord)localObject3);
          ((QQReminderOrderModel)localObject4).b = null;
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    if (i2 == 0) {
      g();
    }
    this.m.getTodayReminderMsgAsync(new ActivateFriendActivity.3(this, (ArrayList)localObject2, i2), false);
    return true;
  }
  
  private void i()
  {
    Object localObject = this.h;
    int i1;
    if (localObject != null) {
      i1 = ((ActivatePageAdapter)localObject).getCount();
    } else {
      i1 = 0;
    }
    this.k = i1;
    if (this.k > 1)
    {
      this.i.removeAllViews();
      this.i.setVisibility(0);
      localObject = new LinearLayout.LayoutParams(ViewUtils.dpToPx(7.0F), ViewUtils.dpToPx(7.0F));
      i1 = 0;
      while (i1 < this.k)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageDrawable(getResources().getDrawable(2130837996));
        if (i1 != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.i.addView(localImageView);
        i1 += 1;
      }
      this.j = 0;
      a(this.j);
      return;
    }
    this.i.setVisibility(8);
    localObject = this.h;
    if (localObject != null) {
      ((ActivatePageAdapter)localObject).a(0);
    }
  }
  
  private boolean j()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return false;
    }
    int i1 = ((Intent)localObject).getIntExtra("af_key_from", 0);
    if ((i1 != 4) && (i1 != 3)) {
      return false;
    }
    long l1 = ((Intent)localObject).getLongExtra("msg_hash", -1L);
    if (l1 == this.r) {
      return false;
    }
    localObject = this.m.getCacheKeyList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (l1 == str.hashCode())
      {
        localObject = this.m.getEntityByKey(str);
        this.r = l1;
        localObject = ((IReminderEntity)localObject).getAcsMsg();
        if (QQReminderAMSHelper.b((AcsMsg)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "ActivateFriends inter isAms");
          }
          return false;
        }
        c((AcsMsg)localObject);
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((BirthdayActivatePageArkView)localObject).f();
    }
    localObject = this.u;
    if (localObject != null) {
      ((MemorialActivatePageArk)localObject).e();
    }
    this.a.sendEmptyMessageDelayed(1, 5000L);
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIndicatorSelected-->index = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i2 = this.k;
    int i3 = 0;
    int i1 = 0;
    if (i2 <= 1)
    {
      paramInt = i1;
      while (paramInt < this.i.getChildCount())
      {
        this.i.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
      return;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.k) {
        break;
      }
      this.i.getChildAt(i1).setVisibility(0);
      i1 += 1;
    }
    while (i2 < this.i.getChildCount())
    {
      if (i2 == paramInt) {
        ((ImageView)this.i.getChildAt(i2)).setImageResource(2130837997);
      } else {
        ((ImageView)this.i.getChildAt(i2)).setImageResource(2130837996);
      }
      i2 += 1;
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((ActivatePageAdapter)localObject).a(paramInt);
    }
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    try
    {
      ReminderCardItemPage localReminderCardItemPage = new ReminderCardItemPage(this, this.app);
      localReminderCardItemPage.a(paramAcsMsg);
      paramAcsMsg = this.h.a().iterator();
      while (paramAcsMsg.hasNext())
      {
        ActivateBasePage localActivateBasePage = (ActivateBasePage)paramAcsMsg.next();
        if (((localActivateBasePage instanceof ReminderCardItemPage)) && (((ReminderCardItemPage)localActivateBasePage).e())) {
          paramAcsMsg.remove();
        }
      }
      this.h.a(localReminderCardItemPage, 0);
      i();
      this.app.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAcsMsg;
    }
  }
  
  void a(MessageRecord paramMessageRecord, SparseBooleanArray paramSparseBooleanArray)
  {
    Object localObject = ((MessageForReminder)paramMessageRecord).getMsgBody();
    long l1 = paramMessageRecord.time;
    try
    {
      paramMessageRecord = new JSONObject(((submsgtype0x13a.MsgBody)localObject).bytes_push_data.get().toStringUtf8());
      if ((TextUtils.equals("97f2e3f9e7a46a25a4e986296e5ab4b1", paramMessageRecord.optString("msg_id", ""))) && (!paramSparseBooleanArray.get(4, false)))
      {
        localObject = paramMessageRecord.optJSONObject("ark_data");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showReminderPage arkData:");
          if (localObject == null) {
            paramMessageRecord = "null";
          } else {
            paramMessageRecord = ((JSONObject)localObject).toString();
          }
          localStringBuilder.append(paramMessageRecord);
          QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
        }
        a(l1 * 1000L, (JSONObject)localObject);
        paramSparseBooleanArray.put(4, true);
        return;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addRadioButton(getString(2131886173), this.n);
    localActionSheet.setOnButtonClickListener(new ActivateFriendActivity.6(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnBottomCancelListener(new ActivateFriendActivity.7(this, localActionSheet));
    localActionSheet.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult");
    localStringBuilder.append(" | rs code = ");
    localStringBuilder.append(paramInt2);
    int i1 = -1;
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getLongArrayExtra("key_friend_list");
        int i2 = paramIntent.getIntExtra("key_msg_type", -1);
        localObject2 = paramIntent.getLongArrayExtra("key_time_list");
        String str = paramIntent.getStringExtra("key_msg_content");
        paramInt2 = paramIntent.getIntExtra("key_gift_id", -1);
        if ((localObject1 != null) && (localObject1.length > 0) && (i2 != -1))
        {
          this.l.a((long[])localObject1, i2);
          if ((i2 == 2) && (localObject2 != null) && (localObject2.length > 0) && (str != null) && (str.length() != 0) && (paramInt2 != -1))
          {
            this.l.a(i2, (long[])localObject1, (long[])localObject2, str, paramInt2);
            ReportController.b(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", localObject1.length, 0, "", "", "", "");
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("uinArray_stampList:");
              paramInt1 = 0;
              while (paramInt1 < localObject1.length)
              {
                paramIntent = new StringBuilder();
                paramIntent.append(localObject1[paramInt1]);
                paramIntent.append("_");
                paramIntent.append(localObject2[paramInt1]);
                paramIntent.append("|");
                localStringBuilder.append(paramIntent.toString());
                paramInt1 += 1;
              }
            }
          }
        }
        localStringBuilder.append(" | uinArray len = ");
        if (localObject1 == null) {
          paramInt1 = -1;
        } else {
          paramInt1 = localObject1.length;
        }
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" | type = ");
        localStringBuilder.append(i2);
        localStringBuilder.append(" | stampList len = ");
        if (localObject2 == null) {
          paramInt1 = i1;
        } else {
          paramInt1 = localObject2.length;
        }
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" | message = ");
        localStringBuilder.append(str);
        localStringBuilder.append(" | giftId id = ");
        localStringBuilder.append(paramInt2);
      }
      super.finish();
    }
    else if ((paramInt1 == 2000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("msg_id");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("从全部列表中返回-----");
        ((StringBuilder)localObject1).append(paramIntent);
        QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.h != null) && (!StringUtil.isEmpty(paramIntent)))
      {
        localObject1 = this.h.a();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          localObject1 = ((ArrayList)localObject1).iterator();
        }
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivateBasePage)((Iterator)localObject1).next();
        if ((localObject2 instanceof ReminderCardItemPage))
        {
          localObject2 = (ReminderCardItemPage)localObject2;
          if ((((ReminderCardItemPage)localObject2).k != null) && (paramIntent.equals(((ReminderCardItemPage)localObject2).k.msg_id)) && (this.o >= ((ReminderCardItemPage)localObject2).k.notice_time * 1000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
            }
            this.h.d();
            h();
            break;
            if ((paramInt1 == 2001) && (this.h != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------ qqbrowser");
              }
              paramIntent = this.h.a();
              if ((paramIntent != null) && (!paramIntent.isEmpty()))
              {
                paramIntent = paramIntent.iterator();
                while (paramIntent.hasNext())
                {
                  localObject1 = (ActivateBasePage)paramIntent.next();
                  if (((localObject1 instanceof ReminderCardItemPage)) && (((ReminderCardItemPage)localObject1).k != null))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
                    }
                    this.h.d();
                    h();
                  }
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.o = NetConnInfoCenter.getServerTimeMillis();
    this.m = ((IQQReminderDataService)this.app.getRuntimeService(IQQReminderDataService.class, ""));
    f();
    addObserver(this.v);
    this.app.registObserver(this.w);
    this.q = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.v);
    this.app.unRegistObserver(this.w);
    this.app.getMessageFacade().deleteObserver(this);
    this.h.b();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    this.q = false;
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    paramIntent = this.h;
    if (paramIntent != null)
    {
      paramIntent.d();
      h();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    j();
    if (!this.p)
    {
      this.p = true;
      h();
    }
    ActivatePageAdapter localActivatePageAdapter = this.h;
    if (localActivatePageAdapter != null) {
      localActivatePageAdapter.c();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.m.setQQNotifyListener(new ActivateFriendActivity.11(this));
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.m.setQQNotifyListener(null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436194)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.set");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.set", 0, 0, "", "", "", "");
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.j = paramInt;
    ReportController.b(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
    LpReportInfo_pf00064.allReport(220, 3);
    a(paramInt);
    Object localObject1 = e();
    int i1 = 1;
    if (localObject1 != null) {
      if (this.j == 0) {
        ((TopGestureLayout)localObject1).setInterceptTouchFlag(true);
      } else {
        ((TopGestureLayout)localObject1).setInterceptTouchFlag(false);
      }
    }
    localObject1 = this.h;
    if (localObject1 != null)
    {
      localObject1 = ((ActivatePageAdapter)localObject1).a();
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        Object localObject2 = (ActivateBasePage)((ArrayList)localObject1).get(paramInt);
        if ((localObject2 instanceof ReminderCardItemPage))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
          }
          ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
          localObject1 = MobileReportManager.getInstance();
          localObject2 = (ReminderCardItemPage)localObject2;
          ((MobileReportManager)localObject1).reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)localObject2).k.msg_id, "15", 1);
          if (!((ReminderCardItemPage)localObject2).e())
          {
            localObject1 = ((ReminderCardItemPage)localObject2).k;
            if (((AcsMsg)localObject1).type == 0) {
              paramInt = i1;
            } else {
              paramInt = 2;
            }
            QQNotifyHelper.a(this.app, "remindcontentpage_exp", ((AcsMsg)localObject1).busi_id, ((AcsMsg)localObject1).msg_id, String.valueOf(paramInt), ((AcsMsg)localObject1).mn_reserved);
            QQReminderAMSHelper.a((AcsMsg)localObject1);
          }
        }
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      int i2 = 1;
      int i1 = i2;
      if ((paramObject instanceof ChatMessage))
      {
        i1 = i2;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          i1 = 0;
        }
      }
      if (i1 != 0) {
        runOnUiThread(new ActivateFriendActivity.10(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */