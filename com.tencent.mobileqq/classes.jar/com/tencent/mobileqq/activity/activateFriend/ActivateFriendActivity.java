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
import java.util.ArrayList<Lcom.tencent.mobileqq.activity.activateFriend.biz.QQReminderOrderModel;>;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ViewPager.OnPageChangeListener, Observer
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(16.0F);
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ActivateFriendActivity.5(this));
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  private BirthdayActivatePageArkView jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
  MemorialActivatePage jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage;
  private ReminderViewPager jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ActivateFriendActivity.8(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new ActivateFriendActivity.9(this);
  private IQQReminderDataService jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  private int e;
  
  private TopGestureLayout a()
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
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage = new MemorialActivatePage(this, this.app, paramInt1, String.valueOf(paramLong2), paramInt2, paramString1, paramString2, paramString3, paramString4, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage.a(paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView = new BirthdayActivatePageArkView(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a(paramLong, paramString, this.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a(paramLong, paramString, this.e);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView);
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
    if (StringUtil.a(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    paramString = Uri.parse(str);
    if (paramString != null)
    {
      paramString = paramString.getScheme();
      if (!StringUtil.a(paramString))
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
  
  private void a(ArrayList<QQReminderOrderModel> paramArrayList, List<AcsMsg> paramList, int paramInt)
  {
    Object localObject1 = this;
    Object localObject2 = ((ActivateFriendActivity)localObject1).jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ActivateBasePage)((Iterator)localObject2).next();
      if ((localObject3 instanceof BirthdayActivatePage)) {
        ((BirthdayActivatePage)localObject3).e();
      }
    }
    ((ActivateFriendActivity)localObject1).jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
    boolean bool = ((ActivateFriendActivity)localObject1).jdField_a_of_type_Boolean;
    long l1 = 1000L;
    localObject2 = "ActivateFriends.MainActivity";
    Object localObject4;
    Object localObject5;
    if (bool)
    {
      if ((QLog.isColorLevel()) && (paramList != null) && (!paramList.isEmpty()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("get today's list size: ");
        ((StringBuilder)localObject3).append(paramList.size());
        QLog.i("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject3).toString());
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (AcsMsg)((Iterator)localObject3).next();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("acsMsg notice time: ");
          ((StringBuilder)localObject5).append(DateUtil.a(((AcsMsg)localObject4).notice_time * 1000L, "yyyy-MM-dd HH:mm:ss"));
          QLog.i("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject5).toString());
        }
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject3 = (AcsMsg)paramList.next();
          localObject4 = new QQReminderOrderModel();
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_Long = ((AcsMsg)localObject3).notice_time;
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_WalletAcsMsg = ((AcsMsg)localObject3);
          paramArrayList.add(localObject4);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("after order list : ");
      paramList.append(paramArrayList);
      QLog.d("ActivateFriends.MainActivity", 2, paramList.toString());
    }
    Collections.sort(paramArrayList, new ActivateFriendActivity.4((ActivateFriendActivity)localObject1));
    paramList = new SparseBooleanArray(3);
    int i;
    if (!paramArrayList.isEmpty())
    {
      localObject3 = paramArrayList.iterator();
      i = 0;
      int j = 1;
      paramArrayList = (ArrayList<QQReminderOrderModel>)localObject2;
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (QQReminderOrderModel)((Iterator)localObject3).next();
        int k;
        int m;
        if (((QQReminderOrderModel)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject2 = ((QQReminderOrderModel)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          localObject4 = ((MessageForActivateFriends)localObject2).getMsgBody();
          l1 = ((MessageRecord)localObject2).time * l1;
          k = ((SubMsgType0x76.MsgBody)localObject4).uint32_msg_type.get();
          if ((k == 1) && (!paramList.get(1, false)))
          {
            QLog.w(paramArrayList, 1, "MSG_TYPE_GEO is no longer support!");
          }
          else if ((k == 2) && (!paramList.get(2, false)))
          {
            localObject2 = BirthdayActivateData.a(((SubMsgType0x76.MsgBody)localObject4).msg_birthday_notify, ((ActivateFriendActivity)localObject1).app);
            ((ActivateFriendActivity)localObject1).a(((ActivateFriendActivity)localObject1).app, l1, (String)localObject2);
            paramList.put(2, true);
            if (j != 0) {
              LpReportInfo_pf00064.allReport(220, 2, 1);
            }
          }
          else if ((k == 3) && (!paramList.get(3, false)))
          {
            Object localObject6 = (SubMsgType0x76.OneMemorialDayInfo)((SubMsgType0x76.MsgBody)localObject4).msg_memorialday_notify.rpt_anniversary_info.get(0);
            long l2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint64_uin.get();
            k = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_type.get();
            m = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_memorial_time.get();
            localObject1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_main_wording_nick.get().toStringUtf8();
            localObject2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_main_wording_event.get().toStringUtf8();
            localObject4 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_sub_wording.get().toStringUtf8();
            localObject5 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_greetings.get().toStringUtf8();
            int n = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_friend_gender.get();
            if (QLog.isColorLevel())
            {
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("memorial_type:");
              ((StringBuilder)localObject6).append(k);
              ((StringBuilder)localObject6).append(" pushTime:");
              ((StringBuilder)localObject6).append(l1);
              ((StringBuilder)localObject6).append(" uin:");
              ((StringBuilder)localObject6).append(l2);
              ((StringBuilder)localObject6).append(" timeStamp:");
              ((StringBuilder)localObject6).append(m);
              ((StringBuilder)localObject6).append(" titleNick:");
              ((StringBuilder)localObject6).append((String)localObject1);
              ((StringBuilder)localObject6).append(" titleEvent:");
              ((StringBuilder)localObject6).append((String)localObject2);
              ((StringBuilder)localObject6).append(" subTitle:");
              ((StringBuilder)localObject6).append((String)localObject4);
              ((StringBuilder)localObject6).append(" greetings:");
              ((StringBuilder)localObject6).append((String)localObject5);
              ((StringBuilder)localObject6).append(" gender:");
              ((StringBuilder)localObject6).append(n);
              QLog.d(paramArrayList, 2, ((StringBuilder)localObject6).toString());
            }
            a(k, l1, l2, m, (String)localObject1, (String)localObject2, (String)localObject4, (String)localObject5, n);
            paramList.put(3, true);
            if (j != 0) {
              LpReportInfo_pf00064.allReport(220, 2, 2);
            }
          }
          j = 0;
        }
        for (;;)
        {
          k = i;
          m = j;
          break;
          if (((QQReminderOrderModel)localObject2).jdField_a_of_type_WalletAcsMsg != null)
          {
            l1 = ((QQReminderOrderModel)localObject2).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L;
            localObject1 = ((QQReminderOrderModel)localObject2).jdField_a_of_type_WalletAcsMsg;
            if ((((AcsMsg)localObject1).type == 0) && (DateUtil.a(l1)) && (this.jdField_a_of_type_Long > l1)) {
              break label1013;
            }
            k = i;
            m = j;
            if (((AcsMsg)localObject1).type != 1) {
              break;
            }
            k = i;
            m = j;
            if (this.jdField_a_of_type_Long - l1 >= 86400000L) {
              break;
            }
            label1013:
            b(((QQReminderOrderModel)localObject2).jdField_a_of_type_WalletAcsMsg);
            k = 1;
            m = j;
            break;
          }
        }
        l1 = 1000L;
        localObject1 = this;
        i = k;
        j = m;
      }
    }
    else
    {
      i = 0;
    }
    if (paramInt == 0) {
      d();
    }
    if (i == 0) {
      ((ActivateFriendActivity)localObject1).b(null);
    }
    if (paramInt > 0)
    {
      paramArrayList = ((ActivateFriendActivity)localObject1).jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
      if (paramArrayList != null) {
        paramArrayList.e();
      }
    }
    f();
    e();
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivatePageAdapter)localObject).a();
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return false;
      }
      return (ActivateBasePage)((ArrayList)localObject).get(0) instanceof ReminderCardItemPage;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return (!StringUtil.a(paramString)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localReminderCardItemPage);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.checkTodayReminder();
    } else {
      ((IQQReminderAlarmService)this.app.getRuntimeService(IQQReminderAlarmService.class, "")).clearAllAlarm();
    }
    if (getIntent().getExtras() != null) {
      localObject1 = getIntent().getExtras().getString("leftViewText");
    } else {
      localObject1 = null;
    }
    int i;
    if ((localObject1 != null) && (((String)localObject1).contains(getString(2131719442)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.app.getMessageFacade().addObserver(this);
    }
    Object localObject1 = this.app.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
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
      i = 0;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if ((localObject4 instanceof MessageForActivateFriends))
        {
          i += 1;
        }
        else if ((localObject4 instanceof MessageForText))
        {
          ((List)localObject2).add((MessageForText)localObject4);
          ((Iterator)localObject3).remove();
        }
      }
    }
    int j = 0;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initData | message count = ");
      ((StringBuilder)localObject2).append(j);
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject2).toString());
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
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (localObject2 != null) {
      ((ActivatePageAdapter)localObject2).c();
    }
    Collections.sort((List)localObject1, new ActivateFriendActivity.2(this));
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("entrance type : ");
      ((StringBuilder)localObject2).append(getIntent().getIntExtra("af_key_from", 0));
      QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (j > 0)
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForActivateFriends))
        {
          localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
          if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 1) {
            i = 2;
          } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2) {
            i = 1;
          } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 3) {
            i = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
          } else {
            i = -1;
          }
          localObject2 = this.app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(getIntent().getIntExtra("af_key_from", 1));
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004E05", "0X8004E05", i, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
      }
    }
    localObject2 = new ArrayList();
    if (j > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject3 instanceof MessageForActivateFriends))
        {
          localObject4 = new QQReminderOrderModel();
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_Long = ((MessageRecord)localObject3).time;
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject3);
          ((QQReminderOrderModel)localObject4).jdField_a_of_type_WalletAcsMsg = null;
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    if (j == 0) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getTodayReminderMsgAsync(new ActivateFriendActivity.3(this, (ArrayList)localObject2, j), false);
    return true;
  }
  
  private void c()
  {
    super.setContentView(2131560908);
    super.setTitle(2131689565);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369216));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373522));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager = ((ReminderViewPager)findViewById(2131362019));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setPageMargin(jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("af_key_from", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131718832));
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
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
      localStringBuilder.append(UIUtils.c(this));
      QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
    }
    double d1;
    if (localLayoutParams1 != null)
    {
      d1 = UIUtils.c(this);
      Double.isNaN(d1);
      this.e = ((int)(d1 * 0.785D));
      int i = ViewUtils.b(550.0F);
      int j = this.e;
      if (j >= i) {
        i = j;
      }
      this.e = i;
      localLayoutParams1.height = this.e;
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setLayoutParams(localLayoutParams1);
    }
    if (localLayoutParams2 != null)
    {
      d1 = UIUtils.c(this);
      Double.isNaN(d1);
      localLayoutParams2.topMargin = ((int)(d1 * 0.8050000000000001D));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams2);
    }
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
    Object localObject = getIntent();
    if (localObject == null) {
      return false;
    }
    int i = ((Intent)localObject).getIntExtra("af_key_from", 0);
    if ((i != 4) && (i != 3)) {
      return false;
    }
    long l = ((Intent)localObject).getLongExtra("msg_hash", -1L);
    if (l == this.jdField_b_of_type_Long) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getCacheKeyList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (l == str.hashCode())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getEntityByKey(str);
        this.jdField_b_of_type_Long = l;
        localObject = ((IReminderEntity)localObject).getAcsMsg();
        if (QQReminderAMSHelper.a((AcsMsg)localObject))
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
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.app, System.currentTimeMillis(), BirthdayActivateData.a(null, this.app));
      this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.c();
      a();
      return;
    }
    a(this.app, System.currentTimeMillis(), null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
    if (localObject != null) {
      ((BirthdayActivatePageArkView)localObject).a(false);
    }
    localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a.findViewById(2131366230);
    SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131699990));
    localSpannableString.setSpan(new ActivateFriendActivity.1(this), 0, 2, 33);
    ((TextView)localObject).setText(localSpannableString);
    ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void e()
  {
    boolean bool = this.jdField_c_of_type_Boolean;
    int i = 1;
    if ((!bool) && (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
      MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().get(0)).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
      if (getIntent() != null)
      {
        int j = getIntent().getIntExtra("af_key_from", 0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("from : ");
          ((StringBuilder)localObject1).append(j);
          QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject1).toString());
        }
        if (j == 4)
        {
          localObject1 = this.app.getMessageFacade().a();
          if (localObject1 != null)
          {
            long l = ((Message)localObject1).uniseq;
            Object localObject2 = null;
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getCacheKeyList().iterator();
            do
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject1 = (String)((Iterator)localObject3).next();
            } while (l != ((String)localObject1).hashCode());
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getEntityByKey((String)localObject1);
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((IReminderEntity)localObject3).getAcsMsg();
            }
            if (localObject1 != null) {
              QQNotifyHelper.a(this.app, "push_click", ((AcsMsg)localObject1).busi_id, ((AcsMsg)localObject1).msg_id, null, null);
            } else {
              QQNotifyHelper.a(this.app, "push_click", null, null, null, null);
            }
          }
        }
        else if (j == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
          }
          QQNotifyHelper.a(this.app, "newslisting_click", null, null, null, null);
          ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
        }
      }
      this.jdField_c_of_type_Boolean = true;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (localObject1 != null)
    {
      localObject1 = (ActivateBasePage)((ActivatePageAdapter)localObject1).a().get(0);
      if ((localObject1 instanceof ReminderCardItemPage))
      {
        localObject1 = (ReminderCardItemPage)localObject1;
        if (!((ReminderCardItemPage)localObject1).a())
        {
          localObject1 = ((ReminderCardItemPage)localObject1).jdField_a_of_type_WalletAcsMsg;
          if (((AcsMsg)localObject1).type != 0) {
            i = 2;
          }
          QQNotifyHelper.a(this.app, "remindcontentpage_exp", ((AcsMsg)localObject1).busi_id, ((AcsMsg)localObject1).msg_id, String.valueOf(i), ((AcsMsg)localObject1).mn_reserved);
          QQReminderAMSHelper.a((AcsMsg)localObject1);
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    int i;
    if (localObject != null) {
      i = ((ActivatePageAdapter)localObject).getCount();
    } else {
      i = 0;
    }
    this.d = i;
    if (this.d > 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject = new LinearLayout.LayoutParams(ViewUtils.b(7.0F), ViewUtils.b(7.0F));
      i = 0;
      while (i < this.d)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageDrawable(getResources().getDrawable(2130837972));
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
        i += 1;
      }
      this.jdField_c_of_type_Int = 0;
      a(this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (localObject != null) {
      ((ActivatePageAdapter)localObject).a(0);
    }
  }
  
  public void a()
  {
    BirthdayActivatePageArkView localBirthdayActivatePageArkView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
    if (localBirthdayActivatePageArkView != null)
    {
      localBirthdayActivatePageArkView.f();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
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
    int j = this.d;
    int k = 0;
    int i = 0;
    if (j <= 1)
    {
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
      return;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.d) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(0);
      i += 1;
    }
    while (j < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (j == paramInt) {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j)).setImageResource(2130837973);
      } else {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j)).setImageResource(2130837972);
      }
      j += 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
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
      paramAcsMsg = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().iterator();
      while (paramAcsMsg.hasNext())
      {
        ActivateBasePage localActivateBasePage = (ActivateBasePage)paramAcsMsg.next();
        if (((localActivateBasePage instanceof ReminderCardItemPage)) && (((ReminderCardItemPage)localActivateBasePage).a())) {
          paramAcsMsg.remove();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localReminderCardItemPage, 0);
      f();
      this.app.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramAcsMsg;
    }
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addRadioButton(getString(2131689563), this.jdField_a_of_type_Boolean);
    localActionSheet.setOnButtonClickListener(new ActivateFriendActivity.6(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
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
    int i = -1;
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getLongArrayExtra("key_friend_list");
        int j = paramIntent.getIntExtra("key_msg_type", -1);
        localObject2 = paramIntent.getLongArrayExtra("key_time_list");
        String str = paramIntent.getStringExtra("key_msg_content");
        paramInt2 = paramIntent.getIntExtra("key_gift_id", -1);
        if ((localObject1 != null) && (localObject1.length > 0) && (j != -1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a((long[])localObject1, j);
          if ((j == 2) && (localObject2 != null) && (localObject2.length > 0) && (str != null) && (str.length() != 0) && (paramInt2 != -1))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(j, (long[])localObject1, (long[])localObject2, str, paramInt2);
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
        localStringBuilder.append(j);
        localStringBuilder.append(" | stampList len = ");
        if (localObject2 == null) {
          paramInt1 = i;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) && (!StringUtil.a(paramIntent)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
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
          if ((((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg != null) && (paramIntent.equals(((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.msg_id)) && (this.jdField_a_of_type_Long >= ((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
            b();
            break;
            if ((paramInt1 == 2001) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------ qqbrowser");
              }
              paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
              if ((paramIntent != null) && (!paramIntent.isEmpty()))
              {
                paramIntent = paramIntent.iterator();
                while (paramIntent.hasNext())
                {
                  localObject1 = (ActivateBasePage)paramIntent.next();
                  if (((localObject1 instanceof ReminderCardItemPage)) && (((ReminderCardItemPage)localObject1).jdField_a_of_type_WalletAcsMsg != null))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
                    }
                    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
                    b();
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
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService = ((IQQReminderDataService)this.app.getRuntimeService(IQQReminderDataService.class, ""));
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.jdField_c_of_type_Boolean = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.app.getMessageFacade().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    this.jdField_c_of_type_Boolean = false;
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (paramIntent != null)
    {
      paramIntent.c();
      b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
    }
    ActivatePageAdapter localActivatePageAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
    if (localActivatePageAdapter != null) {
      localActivatePageAdapter.b();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.setQQNotifyListener(new ActivateFriendActivity.11(this));
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.setQQNotifyListener(null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369216)
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
    this.jdField_c_of_type_Int = paramInt;
    ReportController.b(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
    LpReportInfo_pf00064.allReport(220, 3);
    a(paramInt);
    Object localObject1 = a();
    int i = 1;
    if (localObject1 != null) {
      if (this.jdField_c_of_type_Int == 0) {
        ((TopGestureLayout)localObject1).setInterceptTouchFlag(true);
      } else {
        ((TopGestureLayout)localObject1).setInterceptTouchFlag(false);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
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
          ((MobileReportManager)localObject1).reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
          if (!((ReminderCardItemPage)localObject2).a())
          {
            localObject1 = ((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg;
            if (((AcsMsg)localObject1).type == 0) {
              paramInt = i;
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
      int j = 1;
      int i = j;
      if ((paramObject instanceof ChatMessage))
      {
        i = j;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          i = 0;
        }
      }
      if (i != 0) {
        runOnUiThread(new ActivateFriendActivity.10(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */