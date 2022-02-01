package com.tencent.mobileqq.activity.activateFriend;

import Override;
import Wallet.AcsMsg;
import afse;
import afsf;
import afsg;
import afsh;
import afsi;
import afsj;
import afsk;
import afst;
import afsx;
import afts;
import aftt;
import aftu;
import aftv;
import afur;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import anhk;
import aniz;
import anni;
import anyq;
import anyr;
import anyu;
import bcst;
import bgsp;
import bgtn;
import bkho;
import bkif;
import blyl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import zlx;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
{
  private static final int jdField_a_of_type_Int = bgtn.b(16.0F);
  private long jdField_a_of_type_Long;
  private afts jdField_a_of_type_Afts;
  private aftv jdField_a_of_type_Aftv;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new afsh(this));
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aniz jdField_a_of_type_Aniz = new afsj(this);
  private anyr jdField_a_of_type_Anyr;
  private anyu jdField_a_of_type_Anyu = new afsk(this);
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  private BirthdayActivatePageArkView jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
  MemorialActivatePage jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage;
  private ReminderViewPager jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
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
  
  private void a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.show");
      }
      bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.show", 0, 0, "", "", paramAcsMsg.busi_id, paramAcsMsg.msg_id);
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
      bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.none", 0, 0, "", "", "", "");
    }
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
  
  private boolean b()
  {
    Object localObject1;
    int i;
    label62:
    Object localObject2;
    Object localObject3;
    label168:
    Object localObject4;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Anyr.e();
      localObject1 = null;
      if (getIntent().getExtras() != null) {
        localObject1 = getIntent().getExtras().getString("leftViewText");
      }
      if ((localObject1 == null) || (!((String)localObject1).contains(getString(2131718387)))) {
        break label215;
      }
      i = 1;
      if (i != 0) {
        this.app.a().addObserver(this);
      }
      localObject1 = this.app.a().b(anhk.ad, 9002);
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "current message count = " + ((List)localObject1).size());
      }
      localObject2 = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label1918;
      }
      localObject3 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label251;
      }
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      if (!(localObject4 instanceof MessageForActivateFriends)) {
        break label220;
      }
      i += 1;
    }
    for (;;)
    {
      break label168;
      this.jdField_a_of_type_Afts.a();
      break;
      label215:
      i = 0;
      break label62;
      label220:
      if ((localObject4 instanceof MessageForText))
      {
        ((List)localObject2).add((MessageForText)localObject4);
        ((Iterator)localObject3).remove();
      }
    }
    label251:
    label1918:
    for (int k = i;; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + k);
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
        anyq.a(this.app, (ArrayList)localObject2);
      }
      this.app.a().c(anhk.ad, 9002);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.c();
      }
      Collections.sort((List)localObject1, new afsf(this));
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
      }
      if (k > 0)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForActivateFriends))
          {
            localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
            i = -1;
            if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != 1) {
              break label716;
            }
            i = 2;
          }
        }
      }
      for (;;)
      {
        bcst.b(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
        localObject2 = new ArrayList();
        if (k <= 0) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject3 instanceof MessageForActivateFriends))
          {
            localObject4 = new aftt();
            ((aftt)localObject4).jdField_a_of_type_Long = ((MessageRecord)localObject3).time;
            ((aftt)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject3);
            ((aftt)localObject4).jdField_a_of_type_WalletAcsMsg = null;
            ((ArrayList)localObject2).add(localObject4);
          }
        }
        if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2) {
          i = 1;
        } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 3) {
          i = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_Aftv.a();
        if ((QLog.isColorLevel()) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          QLog.i("ActivateFriends.MainActivity", 2, "get today's list size: " + ((List)localObject1).size());
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (AcsMsg)((Iterator)localObject3).next();
            QLog.i("ActivateFriends.MainActivity", 2, "acsMsg notice time: " + afsx.a(((AcsMsg)localObject4).notice_time * 1000L, "yyyy-MM-dd HH:mm:ss"));
          }
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (AcsMsg)((Iterator)localObject1).next();
            localObject4 = new aftt();
            ((aftt)localObject4).jdField_a_of_type_Long = ((AcsMsg)localObject3).notice_time;
            ((aftt)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
            ((aftt)localObject4).jdField_a_of_type_WalletAcsMsg = ((AcsMsg)localObject3);
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "after order list : " + localObject2);
      }
      Collections.sort((List)localObject2, new afsg(this));
      localObject1 = new SparseBooleanArray(3);
      int j;
      int m;
      long l1;
      if (!((ArrayList)localObject2).isEmpty())
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        i = 0;
        j = 1;
        m = i;
        if (!((Iterator)localObject2).hasNext()) {
          break label1655;
        }
        localObject3 = (aftt)((Iterator)localObject2).next();
        if (((aftt)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject3 = ((aftt)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          localObject4 = ((MessageForActivateFriends)localObject3).getMsgBody();
          l1 = ((MessageRecord)localObject3).time * 1000L;
          m = ((SubMsgType0x76.MsgBody)localObject4).uint32_msg_type.get();
          if ((m == 1) && (!((SparseBooleanArray)localObject1).get(1, false)))
          {
            QLog.w("ActivateFriends.MainActivity", 1, "MSG_TYPE_GEO is no longer support!");
            m = 0;
            j = i;
            i = m;
          }
        }
      }
      for (;;)
      {
        m = j;
        j = i;
        i = m;
        break;
        if ((m == 2) && (!((SparseBooleanArray)localObject1).get(2, false)))
        {
          localObject3 = afst.a(((SubMsgType0x76.MsgBody)localObject4).msg_birthday_notify, this.app);
          a(this.app, l1, (String)localObject3);
          ((SparseBooleanArray)localObject1).put(2, true);
          if (j == 0) {
            break label1185;
          }
          LpReportInfo_pf00064.allReport(220, 2, 1);
          break label1185;
        }
        if ((m != 3) || (((SparseBooleanArray)localObject1).get(3, false))) {
          break label1185;
        }
        Object localObject5 = (SubMsgType0x76.OneMemorialDayInfo)((SubMsgType0x76.MsgBody)localObject4).msg_memorialday_notify.rpt_anniversary_info.get(0);
        long l2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint64_uin.get();
        m = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_type.get();
        int n = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_memorial_time.get();
        localObject3 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_main_wording_nick.get().toStringUtf8();
        localObject4 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_main_wording_event.get().toStringUtf8();
        String str1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_sub_wording.get().toStringUtf8();
        String str2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_greetings.get().toStringUtf8();
        int i1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_friend_gender.get();
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("memorial_type:").append(m);
          ((StringBuilder)localObject5).append(" pushTime:").append(l1);
          ((StringBuilder)localObject5).append(" uin:").append(l2);
          ((StringBuilder)localObject5).append(" timeStamp:").append(n);
          ((StringBuilder)localObject5).append(" titleNick:").append((String)localObject3);
          ((StringBuilder)localObject5).append(" titleEvent:").append((String)localObject4);
          ((StringBuilder)localObject5).append(" subTitle:").append(str1);
          ((StringBuilder)localObject5).append(" greetings:").append(str2);
          ((StringBuilder)localObject5).append(" gender:").append(i1);
          QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject5).toString());
        }
        a(m, l1, l2, n, (String)localObject3, (String)localObject4, str1, str2, i1);
        ((SparseBooleanArray)localObject1).put(3, true);
        if (j == 0) {
          break label1185;
        }
        LpReportInfo_pf00064.allReport(220, 2, 2);
        break label1185;
        if ((((aftt)localObject3).jdField_a_of_type_WalletAcsMsg != null) && (afsx.a(((aftt)localObject3).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L)) && (this.jdField_a_of_type_Long > ((aftt)localObject3).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L))
        {
          a(((aftt)localObject3).jdField_a_of_type_WalletAcsMsg);
          i = j;
          j = 1;
          continue;
          m = 0;
          if (k == 0) {
            d();
          }
          if (m == 0) {
            a(null);
          }
          e();
          if ((k > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.e();
          }
          if ((!this.jdField_c_of_type_Boolean) && (a()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
            }
            bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
            blyl.a().a("qqremind", "3", "1", 100, ((ReminderCardItemPage)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a().get(0)).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
            if (getIntent() != null)
            {
              i = getIntent().getIntExtra("af_key_from", 0);
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "from : " + i);
              }
              if (i != 4) {
                break label1856;
              }
            }
          }
          for (;;)
          {
            this.jdField_c_of_type_Boolean = true;
            return true;
            if (i == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
              }
              bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
            }
          }
        }
        else
        {
          m = i;
          i = j;
          j = m;
        }
      }
    }
  }
  
  private void c()
  {
    super.setContentView(2131560996);
    super.setTitle(2131689531);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368961));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840281);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368947));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373383));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager = ((ReminderViewPager)findViewById(2131362000));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setPageMargin(jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("af_key_from", 1);
    this.jdField_a_of_type_Anyr = ((anyr)this.app.getManager(85));
    this.jdField_a_of_type_Afts = ((afts)this.app.getManager(321));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Anyr.a(true);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131717832));
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends.MainActivity", 2, "mViewPager height: " + localLayoutParams1.height);
      QLog.d("ActivateFriends.MainActivity", 2, "mPageIndicator topMargin: " + localLayoutParams2.topMargin);
      QLog.d("ActivateFriends.MainActivity", 2, "screen height: " + zlx.c(this));
    }
    int i;
    if (localLayoutParams1 != null)
    {
      this.e = ((int)(0.785D * zlx.c(this)));
      i = bgtn.b(550.0F);
      if (this.e >= i) {
        break label416;
      }
    }
    for (;;)
    {
      this.e = i;
      localLayoutParams1.height = this.e;
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setLayoutParams(localLayoutParams1);
      if (localLayoutParams2 != null)
      {
        localLayoutParams2.topMargin = ((int)(0.8050000000000001D * zlx.c(this)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams2);
      }
      return;
      label416:
      i = this.e;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.app, System.currentTimeMillis(), afst.a(null, this.app));
      this.jdField_a_of_type_Anyr.c();
      a();
      return;
    }
    a(this.app, System.currentTimeMillis(), null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a(false);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.a.findViewById(2131365994);
    SpannableString localSpannableString = new SpannableString(anni.a(2131698578));
    localSpannableString.setSpan(new afse(this), 0, 2, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void e()
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
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bgtn.b(7.0F), bgtn.b(7.0F));
      i = 0;
      while (i < this.d)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageDrawable(getResources().getDrawable(2130838003));
        if (i != 0) {
          localLayoutParams.leftMargin = afur.a(5.0F, getResources());
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
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130838004);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130838003);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(paramInt);
    }
  }
  
  public void b()
  {
    bkho localbkho = (bkho)bkif.a(this, null);
    localbkho.a(getString(2131689529), this.jdField_a_of_type_Boolean);
    localbkho.a(new afsi(this, localbkho));
    localbkho.c(2131690582);
    localbkho.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
          this.jdField_a_of_type_Anyr.a(arrayOfLong, i);
          if ((i == 2) && (localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (((String)localObject2).length() != 0) && (paramInt2 != -1))
          {
            this.jdField_a_of_type_Anyr.a(i, arrayOfLong, (long[])localObject1, (String)localObject2, paramInt2);
            bcst.b(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", arrayOfLong.length, 0, "", "", "", "");
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
            break label376;
          }
          paramInt1 = -1;
          label317:
          paramIntent.append(paramInt1).append(" | message = ").append((String)localObject2);
          localStringBuilder.append(" | giftId id = ").append(paramInt2);
        }
      }
      else
      {
        super.finish();
        label350:
        break label641;
        break label478;
        break label478;
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
      label376:
      paramInt1 = localObject1.length;
      break label317;
      if ((paramInt1 == 2000) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("msg_id");
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "从全部列表中返回-----" + paramIntent);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null) || (bgsp.a(paramIntent))) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        label478:
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (ActivateBasePage)((Iterator)localObject1).next();
        if (!(localObject2 instanceof ReminderCardItemPage)) {
          break label350;
        }
        localObject2 = (ReminderCardItemPage)localObject2;
        if ((((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg == null) || (!paramIntent.equals(((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.msg_id)) || (this.jdField_a_of_type_Long < ((ReminderCardItemPage)localObject2).jdField_a_of_type_WalletAcsMsg.notice_time * 1000L)) {
          break label350;
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
          label641:
          if (paramIntent.hasNext())
          {
            localObject1 = (ActivateBasePage)paramIntent.next();
            if ((!(localObject1 instanceof ReminderCardItemPage)) || (((ReminderCardItemPage)localObject1).jdField_a_of_type_WalletAcsMsg == null)) {
              break label350;
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
    this.jdField_a_of_type_Aftv = new aftv(this.app);
    aftu.a(this.app);
    c();
    addObserver(this.jdField_a_of_type_Aniz);
    this.app.registObserver(this.jdField_a_of_type_Anyu);
    this.jdField_c_of_type_Boolean = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Aniz);
    this.app.unRegistObserver(this.jdField_a_of_type_Anyu);
    this.app.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    aftu.a();
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
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.b();
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
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.set");
      }
      bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.set", 0, 0, "", "", "", "");
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
    bcst.b(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
    LpReportInfo_pf00064.allReport(220, 3);
    a(paramInt);
    Object localObject = a();
    if (localObject != null)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label185;
      }
      ((TopGestureLayout)localObject).setInterceptTouchFlag(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
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
            bcst.b(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
            blyl.a().a("qqremind", "3", "1", 100, ((ReminderCardItemPage)localObject).jdField_a_of_type_WalletAcsMsg.msg_id, "15", 1);
          }
        }
      }
      return;
      label185:
      ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
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
        runOnUiThread(new ActivateFriendActivity.8(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */