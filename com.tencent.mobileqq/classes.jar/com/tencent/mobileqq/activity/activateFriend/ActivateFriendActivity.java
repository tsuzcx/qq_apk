package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import cooperation.qwallet.plugin.IFakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
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
      QLog.e("ActivateFriends.MainActivity", 1, "erro " + paramQQAppInterface.toString());
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    String str = paramString;
    if (StringUtil.a(paramString)) {
      str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
    }
    paramString = Uri.parse(str);
    IFakeUrl localIFakeUrl;
    if (paramString != null)
    {
      paramString = paramString.getScheme();
      if (!StringUtil.a(paramString))
      {
        localIFakeUrl = (IFakeUrl)QRoute.api(IFakeUrl.class);
        localIFakeUrl.init(this);
        if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
        {
          if (paramInt != 0) {
            break label103;
          }
          localIFakeUrl.gotoH5(this, str, true, true);
        }
      }
    }
    for (;;)
    {
      if (paramString.startsWith("mqqapi")) {
        localIFakeUrl.gotoMqq(this, str);
      }
      return;
      label103:
      localIFakeUrl.gotoResultH5(this, str, true, paramInt);
    }
  }
  
  private void a(ArrayList<QQReminderOrderModel> paramArrayList, List<AcsMsg> paramList, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivateBasePage)((Iterator)localObject1).next();
      if ((localObject2 instanceof BirthdayActivatePage)) {
        ((BirthdayActivatePage)localObject2).e();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((QLog.isColorLevel()) && (paramList != null) && (!paramList.isEmpty()))
      {
        QLog.i("ActivateFriends.MainActivity", 2, "get today's list size: " + paramList.size());
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AcsMsg)((Iterator)localObject1).next();
          QLog.i("ActivateFriends.MainActivity", 2, "acsMsg notice time: " + DateUtil.a(((AcsMsg)localObject2).notice_time * 1000L, "yyyy-MM-dd HH:mm:ss"));
        }
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (AcsMsg)paramList.next();
          localObject2 = new QQReminderOrderModel();
          ((QQReminderOrderModel)localObject2).jdField_a_of_type_Long = ((AcsMsg)localObject1).notice_time;
          ((QQReminderOrderModel)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
          ((QQReminderOrderModel)localObject2).jdField_a_of_type_WalletAcsMsg = ((AcsMsg)localObject1);
          paramArrayList.add(localObject2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "after order list : " + paramArrayList);
    }
    Collections.sort(paramArrayList, new ActivateFriendActivity.4(this));
    paramList = new SparseBooleanArray(3);
    int j;
    int i;
    int k;
    long l1;
    if (!paramArrayList.isEmpty())
    {
      paramArrayList = paramArrayList.iterator();
      j = 1;
      i = 0;
      k = i;
      if (!paramArrayList.hasNext()) {
        break label947;
      }
      localObject1 = (QQReminderOrderModel)paramArrayList.next();
      if (((QQReminderOrderModel)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = ((QQReminderOrderModel)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localObject2 = ((MessageForActivateFriends)localObject1).getMsgBody();
        l1 = ((MessageRecord)localObject1).time * 1000L;
        k = ((SubMsgType0x76.MsgBody)localObject2).uint32_msg_type.get();
        if ((k == 1) && (!paramList.get(1, false)))
        {
          QLog.w("ActivateFriends.MainActivity", 1, "MSG_TYPE_GEO is no longer support!");
          label437:
          k = 0;
          j = i;
          i = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if ((k == 2) && (!paramList.get(2, false)))
      {
        localObject1 = BirthdayActivateData.a(((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify, this.app);
        a(this.app, l1, (String)localObject1);
        paramList.put(2, true);
        if (j == 0) {
          break label437;
        }
        LpReportInfo_pf00064.allReport(220, 2, 1);
        break label437;
      }
      if ((k != 3) || (paramList.get(3, false))) {
        break label437;
      }
      Object localObject3 = (SubMsgType0x76.OneMemorialDayInfo)((SubMsgType0x76.MsgBody)localObject2).msg_memorialday_notify.rpt_anniversary_info.get(0);
      long l2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).uint64_uin.get();
      k = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject3).uint32_type.get();
      int m = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).uint32_memorial_time.get();
      localObject1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).bytes_main_wording_nick.get().toStringUtf8();
      localObject2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).bytes_main_wording_event.get().toStringUtf8();
      String str1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).bytes_sub_wording.get().toStringUtf8();
      String str2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).bytes_greetings.get().toStringUtf8();
      int n = ((SubMsgType0x76.OneMemorialDayInfo)localObject3).uint32_friend_gender.get();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("memorial_type:").append(k);
        ((StringBuilder)localObject3).append(" pushTime:").append(l1);
        ((StringBuilder)localObject3).append(" uin:").append(l2);
        ((StringBuilder)localObject3).append(" timeStamp:").append(m);
        ((StringBuilder)localObject3).append(" titleNick:").append((String)localObject1);
        ((StringBuilder)localObject3).append(" titleEvent:").append((String)localObject2);
        ((StringBuilder)localObject3).append(" subTitle:").append(str1);
        ((StringBuilder)localObject3).append(" greetings:").append(str2);
        ((StringBuilder)localObject3).append(" gender:").append(n);
        QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject3).toString());
      }
      a(k, l1, l2, m, (String)localObject1, (String)localObject2, str1, str2, n);
      paramList.put(3, true);
      if (j == 0) {
        break label437;
      }
      LpReportInfo_pf00064.allReport(220, 2, 2);
      break label437;
      if (((QQReminderOrderModel)localObject1).jdField_a_of_type_WalletAcsMsg != null)
      {
        l1 = ((QQReminderOrderModel)localObject1).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L;
        localObject2 = ((QQReminderOrderModel)localObject1).jdField_a_of_type_WalletAcsMsg;
        if (((((AcsMsg)localObject2).type == 0) && (DateUtil.a(l1)) && (this.jdField_a_of_type_Long > l1)) || ((((AcsMsg)localObject2).type == 1) && (this.jdField_a_of_type_Long - l1 < 86400000L)))
        {
          b(((QQReminderOrderModel)localObject1).jdField_a_of_type_WalletAcsMsg);
          i = j;
          j = 1;
          continue;
          k = 0;
          label947:
          if (paramInt == 0) {
            d();
          }
          if (k == 0) {
            b(null);
          }
          if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.e();
          }
          f();
          e();
          return;
        }
      }
      k = i;
      i = j;
      j = k;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
    } while ((localArrayList == null) || (localArrayList.isEmpty()));
    return (ActivateBasePage)localArrayList.get(0) instanceof ReminderCardItemPage;
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
    for (;;)
    {
      ReminderCardItemPage localReminderCardItemPage = new ReminderCardItemPage(this, this.app);
      localReminderCardItemPage.a(paramAcsMsg);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localReminderCardItemPage);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.none");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.none", 0, 0, "", "", "", "");
    }
  }
  
  private boolean b()
  {
    Object localObject1;
    int i;
    label62:
    Object localObject2;
    Object localObject3;
    label163:
    Object localObject4;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.checkTodayReminder();
      localObject1 = null;
      if (getIntent().getExtras() != null) {
        localObject1 = getIntent().getExtras().getString("leftViewText");
      }
      if ((localObject1 == null) || (!((String)localObject1).contains(getString(2131719718)))) {
        break label224;
      }
      i = 1;
      if (i != 0) {
        this.app.getMessageFacade().addObserver(this);
      }
      localObject1 = this.app.getMessageFacade().b(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "current message count = " + ((List)localObject1).size());
      }
      localObject2 = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label819;
      }
      localObject3 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label260;
      }
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      if (!(localObject4 instanceof MessageForActivateFriends)) {
        break label229;
      }
      i += 1;
    }
    for (;;)
    {
      break label163;
      ((IQQReminderAlarmService)this.app.getRuntimeService(IQQReminderAlarmService.class, "")).clearAllAlarm();
      break;
      label224:
      i = 0;
      break label62;
      label229:
      if ((localObject4 instanceof MessageForText))
      {
        ((List)localObject2).add((MessageForText)localObject4);
        ((Iterator)localObject3).remove();
      }
    }
    label260:
    label819:
    for (int j = i;; j = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + j);
      }
      localObject2 = new ArrayList(((List)localObject1).size());
      localObject3 = ((List)localObject1).iterator();
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
      this.app.getMessageFacade().c(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
      }
      Collections.sort((List)localObject1, new ActivateFriendActivity.2(this));
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
      }
      if (j > 0)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForActivateFriends))
          {
            localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
            i = -1;
            if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != 1) {
              break label722;
            }
            i = 2;
          }
        }
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
        localObject2 = new ArrayList();
        if (j <= 0) {
          break;
        }
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
        label722:
        if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2) {
          i = 1;
        } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 3) {
          i = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
        }
      }
      if (j == 0) {
        d();
      }
      this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getTodayReminderMsgAsync(new ActivateFriendActivity.3(this, (ArrayList)localObject2, j), false);
      return true;
    }
  }
  
  private void c()
  {
    super.setContentView(2131561044);
    super.setTitle(2131689538);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840478);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373950));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager = ((ReminderViewPager)findViewById(2131362004));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setPageMargin(jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("af_key_from", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131719114));
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends.MainActivity", 2, "mViewPager height: " + localLayoutParams1.height);
      QLog.d("ActivateFriends.MainActivity", 2, "mPageIndicator topMargin: " + localLayoutParams2.topMargin);
      QLog.d("ActivateFriends.MainActivity", 2, "screen height: " + UIUtils.c(this));
    }
    int i;
    if (localLayoutParams1 != null)
    {
      this.e = ((int)(0.785D * UIUtils.c(this)));
      i = ViewUtils.b(550.0F);
      if (this.e >= i) {
        break label400;
      }
    }
    for (;;)
    {
      this.e = i;
      localLayoutParams1.height = this.e;
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setLayoutParams(localLayoutParams1);
      if (localLayoutParams2 != null)
      {
        localLayoutParams2.topMargin = ((int)(0.8050000000000001D * UIUtils.c(this)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams2);
      }
      return;
      label400:
      i = this.e;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a(false);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a.findViewById(2131366342);
    SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131699849));
    localSpannableString.setSpan(new ActivateFriendActivity.1(this), 0, 2, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void e()
  {
    int i;
    if ((!this.jdField_c_of_type_Boolean) && (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
      MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().get(0)).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
      if (getIntent() != null)
      {
        i = getIntent().getIntExtra("af_key_from", 0);
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "from : " + i);
        }
        if (i != 4) {
          break label407;
        }
        localObject = this.app.getMessageFacade().a();
        if (localObject != null)
        {
          long l = ((Message)localObject).uniseq;
          localObject = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getCacheKeyList().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (l == str.hashCode())
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.getEntityByKey(str);
              if (localObject == null) {
                break;
              }
            }
          }
        }
      }
    }
    for (Object localObject = ((IReminderEntity)localObject).getAcsMsg();; localObject = null)
    {
      if (localObject != null)
      {
        QQNotifyHelper.a(this.app, "push_click", ((AcsMsg)localObject).busi_id, ((AcsMsg)localObject).msg_id, null, null);
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
        {
          localObject = (ActivateBasePage)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().get(0);
          if (((localObject instanceof ReminderCardItemPage)) && (!((ReminderCardItemPage)localObject).a()))
          {
            localObject = ((ReminderCardItemPage)localObject).jdField_a_of_type_WalletAcsMsg;
            if (((AcsMsg)localObject).type != 0) {
              break label480;
            }
          }
        }
      }
      label407:
      label480:
      for (i = 1;; i = 2)
      {
        QQNotifyHelper.a(this.app, "remindcontentpage_exp", ((AcsMsg)localObject).busi_id, ((AcsMsg)localObject).msg_id, String.valueOf(i), ((AcsMsg)localObject).mn_reserved);
        QQReminderAMSHelper.a((AcsMsg)localObject);
        return;
        QQNotifyHelper.a(this.app, "push_click", null, null, null, null);
        break;
        if (i != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
        }
        QQNotifyHelper.a(this.app, "newslisting_click", null, null, null, null);
        ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
        break;
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.getCount();; i = 0)
    {
      this.d = i;
      if (this.d <= 1) {
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.b(7.0F), ViewUtils.b(7.0F));
      i = 0;
      while (i < this.d)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageDrawable(getResources().getDrawable(2130838123));
        if (i != 0) {
          localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
        }
        localImageView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
        i += 1;
      }
    }
    this.jdField_c_of_type_Int = 0;
    a(this.jdField_c_of_type_Int);
    label160:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.f();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void a(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.d <= 1)
    {
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
    }
    i = 0;
    while (i < this.d)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(0);
      i += 1;
    }
    i = 0;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (i == paramInt) {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130838124);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130838123);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(paramInt);
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
      this.app.getMessageFacade().c(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
      return;
    }
    finally {}
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addRadioButton(getString(2131689536), this.jdField_a_of_type_Boolean);
    localActionSheet.setOnButtonClickListener(new ActivateFriendActivity.6(this, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult").append(" | rs code = ").append(paramInt2);
    long[] arrayOfLong;
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      if (paramIntent != null)
      {
        arrayOfLong = paramIntent.getLongArrayExtra("key_friend_list");
        int i = paramIntent.getIntExtra("key_msg_type", -1);
        localObject1 = paramIntent.getLongArrayExtra("key_time_list");
        localObject2 = paramIntent.getStringExtra("key_msg_content");
        paramInt2 = paramIntent.getIntExtra("key_gift_id", -1);
        if ((arrayOfLong != null) && (arrayOfLong.length > 0) && (i != -1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(arrayOfLong, i);
          if ((i == 2) && (localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (((String)localObject2).length() != 0) && (paramInt2 != -1))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(i, arrayOfLong, (long[])localObject1, (String)localObject2, paramInt2);
            ReportController.b(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", arrayOfLong.length, 0, "", "", "", "");
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("uinArray_stampList:");
              paramInt1 = 0;
              while (paramInt1 < arrayOfLong.length)
              {
                localStringBuilder.append(arrayOfLong[paramInt1] + "_" + localObject1[paramInt1] + "|");
                paramInt1 += 1;
              }
            }
          }
        }
        paramIntent = localStringBuilder.append(" | uinArray len = ");
        if (arrayOfLong == null)
        {
          paramInt1 = -1;
          paramIntent.append(paramInt1).append(" | type = ").append(i);
          paramIntent = localStringBuilder.append(" | stampList len = ");
          if (localObject1 != null) {
            break label382;
          }
          paramInt1 = -1;
          label323:
          paramIntent.append(paramInt1).append(" | message = ").append((String)localObject2);
          localStringBuilder.append(" | giftId id = ").append(paramInt2);
        }
      }
      else
      {
        super.finish();
        label356:
        break label647;
        break label484;
        break label484;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
      return;
      paramInt1 = arrayOfLong.length;
      break;
      label382:
      paramInt1 = localObject1.length;
      break label323;
      if ((paramInt1 == 2000) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("msg_id");
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "从全部列表中返回-----" + paramIntent);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null) || (StringUtil.a(paramIntent))) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        label484:
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (ActivateBasePage)((Iterator)localObject1).next();
        if (!(localObject2 instanceof ReminderCardItemPage)) {
          break label356;
        }
        localObject2 = (ReminderCardItemPage)localObject2;
        if ((((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg == null) || (!paramIntent.equals(((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.msg_id)) || (this.jdField_a_of_type_Long < ((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L)) {
          break label356;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
        b();
        continue;
      }
      if ((paramInt1 == 2001) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------ qqbrowser");
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
        if ((paramIntent != null) && (!paramIntent.isEmpty()))
        {
          paramIntent = paramIntent.iterator();
          label647:
          if (paramIntent.hasNext())
          {
            localObject1 = (ActivateBasePage)paramIntent.next();
            if ((!(localObject1 instanceof ReminderCardItemPage)) || (((ReminderCardItemPage)localObject1).jdField_a_of_type_WalletAcsMsg == null)) {
              break label356;
            }
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
  
  public boolean doOnCreate(Bundle paramBundle)
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
  
  public void doOnDestroy()
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
  
  public void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
      b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.b();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.setQQNotifyListener(new ActivateFriendActivity.11(this));
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService.setQQNotifyListener(null);
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
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.set");
      }
      ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.set", 0, 0, "", "", "", "");
      b();
    }
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
    Object localObject = a();
    if (localObject != null)
    {
      if (this.jdField_c_of_type_Int == 0) {
        ((TopGestureLayout)localObject).setInterceptTouchFlag(true);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = (ActivateBasePage)((ArrayList)localObject).get(paramInt);
        if ((localObject instanceof ReminderCardItemPage))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
          }
          ReportController.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
          MobileReportManager.getInstance().reportActionOfNotice("qqremind", "3", "1", 100, ((ReminderCardItemPage)localObject).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
          if (!((ReminderCardItemPage)localObject).a())
          {
            localObject = ((ReminderCardItemPage)localObject).jdField_a_of_type_WalletAcsMsg;
            if (((AcsMsg)localObject).type != 0) {
              break label264;
            }
          }
        }
      }
    }
    label264:
    for (paramInt = 1;; paramInt = 2)
    {
      QQNotifyHelper.a(this.app, "remindcontentpage_exp", ((AcsMsg)localObject).busi_id, ((AcsMsg)localObject).msg_id, String.valueOf(paramInt), ((AcsMsg)localObject).mn_reserved);
      QQReminderAMSHelper.a((AcsMsg)localObject);
      return;
      ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */