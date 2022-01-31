package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGeoGraphicFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;
import uiq;
import uir;
import uis;
import uit;
import uiu;
import uiv;
import uiw;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
{
  private int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new uis(this));
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  public BirthdayActivatePage a;
  MemorialActivatePage jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new uiu(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new uiv(this);
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
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
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, long[] paramArrayOfLong)
  {
    PositionActivatePage localPositionActivatePage = new PositionActivatePage(this);
    localPositionActivatePage.a(paramQQAppInterface, paramLong, paramString, paramArrayOfLong);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localPositionActivatePage);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, long[] paramArrayOfLong1, String[] paramArrayOfString, long[] paramArrayOfLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage = new BirthdayActivatePage(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.a(paramQQAppInterface, paramLong, paramArrayOfLong1, paramArrayOfString, paramArrayOfLong2);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage);
  }
  
  private boolean a()
  {
    Object localObject1 = null;
    if (getIntent().getExtras() != null) {
      localObject1 = getIntent().getExtras().getString("leftViewText");
    }
    if ((localObject1 != null) && (((String)localObject1).contains(getString(2131433297)))) {}
    Object localObject3;
    Object localObject4;
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.app.a().addObserver(this);
      }
      localObject1 = this.app.a().b(AppConstants.Z, 9002);
      i = ((List)localObject1).size();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + i);
      }
      localObject2 = new ArrayList(((List)localObject1).size());
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if ((!((MessageRecord)localObject4).isread) && ((((MessageRecord)localObject4).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject4).extStr))) {
          ((List)localObject2).add(((MessageRecord)localObject4).extStr);
        }
      }
    }
    if (((List)localObject2).size() > 0) {
      ActivateFriendServlet.a(this.app, (ArrayList)localObject2);
    }
    this.app.a().c(AppConstants.Z, 9002);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.b();
    }
    if (i == 0)
    {
      a(this.app, System.currentTimeMillis(), null, null, null);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.c();
        a();
      }
      for (;;)
      {
        return false;
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.d();
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.findViewById(2131366489);
        localObject2 = new SpannableString("启用一声问候，查看好友生日。");
        ((SpannableString)localObject2).setSpan(new uiq(this), 0, 2, 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      }
    }
    Collections.sort((List)localObject1, new uir(this));
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
    }
    Object localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
    i = -1;
    if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 1)
    {
      i = 2;
      ReportController.b(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label1425;
      }
      localObject3 = (MessageRecord)((Iterator)localObject1).next();
      localObject2 = ((MessageForActivateFriends)localObject3).getMsgBody();
      long l1 = 1000L * ((MessageRecord)localObject3).time;
      i = ((SubMsgType0x76.MsgBody)localObject2).uint32_msg_type.get();
      if (i == 1)
      {
        localObject3 = ((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.bytes_local_city.get().toStringUtf8();
        localObject4 = new long[((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.rpt_msg_one_friend.get().size()];
        i = 0;
        for (;;)
        {
          if (i < localObject4.length)
          {
            localObject4[i] = ((SubMsgType0x76.OneGeoGraphicFriend)((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
            i += 1;
            continue;
            if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2)
            {
              i = 1;
              break;
            }
            if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != 3) {
              break;
            }
            i = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
            break;
          }
        }
        a(this.app, l1, (String)localObject3, (long[])localObject4);
      }
      else
      {
        Object localObject5;
        int j;
        int k;
        long l2;
        if (i == 2)
        {
          localObject3 = new long[((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().size()];
          localObject4 = new long[localObject3.length];
          localObject5 = new String[localObject3.length];
          i = 0;
          if (i < localObject3.length)
          {
            localObject3[i] = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
            j = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_month.get();
            k = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_date.get();
            int m = ActivateFriendsManager.a(((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_year.get(), j, k);
            localObject5[i] = ActivateFriendsManager.a(m, j, k);
            if ((m == 0) || (m == 1)) {
              localObject4[i] = MessageCache.a();
            }
            for (;;)
            {
              i += 1;
              break;
              localObject4[i] = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_msg_send_time.get();
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder("Native FriendUinArray :");
            j = localObject3.length;
            i = 0;
            while (i < j)
            {
              l2 = localObject3[i];
              ((StringBuilder)localObject2).append(Long.toString(l2) + "_");
              i += 1;
            }
            ((StringBuilder)localObject2).append("FriendUinArraySize:" + localObject3.length);
            QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject2).toString());
          }
          QZoneCheckSendGiftServlet.a(this.app, Long.parseLong(this.app.getCurrentAccountUin()), (long[])localObject3);
          a(this.app, l1, (long[])localObject3, (String[])localObject5, (long[])localObject4);
        }
        else if (i == 3)
        {
          Object localObject6 = (SubMsgType0x76.OneMemorialDayInfo)((SubMsgType0x76.MsgBody)localObject2).msg_memorialday_notify.rpt_anniversary_info.get(0);
          l2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint64_uin.get();
          i = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_type.get();
          j = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_memorial_time.get();
          localObject2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_main_wording_nick.get().toStringUtf8();
          localObject3 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_main_wording_event.get().toStringUtf8();
          localObject4 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_sub_wording.get().toStringUtf8();
          localObject5 = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).bytes_greetings.get().toStringUtf8();
          k = ((SubMsgType0x76.OneMemorialDayInfo)localObject6).uint32_friend_gender.get();
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("memorial_type:").append(i);
            ((StringBuilder)localObject6).append(" pushTime:").append(l1);
            ((StringBuilder)localObject6).append(" uin:").append(l2);
            ((StringBuilder)localObject6).append(" timeStamp:").append(j);
            ((StringBuilder)localObject6).append(" titleNick:").append((String)localObject2);
            ((StringBuilder)localObject6).append(" titleEvent:").append((String)localObject3);
            ((StringBuilder)localObject6).append(" subTitle:").append((String)localObject4);
            ((StringBuilder)localObject6).append(" greetings:").append((String)localObject5);
            ((StringBuilder)localObject6).append(" gender:").append(k);
            QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject6).toString());
          }
          a(i, l1, l2, j, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, k);
        }
      }
    }
    label1425:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {}
    for (i = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.getCount();; i = 0)
    {
      this.c = i;
      if (this.c <= 1) {
        break label1576;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      i = 0;
      while (i < this.c)
      {
        localObject2 = new ImageView(this);
        ((ImageView)localObject2).setImageDrawable(getResources().getDrawable(2130837574));
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(5.0F, getResources());
        }
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        i += 1;
      }
    }
    this.b = 0;
    a(this.b);
    label1576:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.d();
    }
    return true;
  }
  
  private void c()
  {
    super.setContentView(2130970176);
    super.setTitle(2131437234);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363474));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839147);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131369417));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131369416));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(84));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("af_key_from", 1);
    if (AppSetting.b) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131436790));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void a(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.c <= 1)
    {
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
    }
    i = 0;
    while (i < this.c)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(0);
      i += 1;
    }
    i = 0;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (i == paramInt) {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130837575);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i)).setImageResource(2130837574);
      }
    }
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131437249), this.jdField_a_of_type_Boolean);
    localActionSheet.a(new uit(this, localActionSheet));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult").append(" | rs code = ").append(paramInt2);
    long[] arrayOfLong2;
    long[] arrayOfLong1;
    String str;
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      if (paramIntent != null)
      {
        arrayOfLong2 = paramIntent.getLongArrayExtra("key_friend_list");
        int i = paramIntent.getIntExtra("key_msg_type", -1);
        arrayOfLong1 = paramIntent.getLongArrayExtra("key_time_list");
        str = paramIntent.getStringExtra("key_msg_content");
        paramInt2 = paramIntent.getIntExtra("key_gift_id", -1);
        if ((arrayOfLong2 != null) && (arrayOfLong2.length > 0) && (i != -1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(arrayOfLong2, i);
          if ((i == 2) && (arrayOfLong1 != null) && (arrayOfLong1.length > 0) && (str != null) && (str.length() != 0) && (paramInt2 != -1))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(i, arrayOfLong2, arrayOfLong1, str, paramInt2);
            ReportController.b(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", arrayOfLong2.length, 0, "", "", "", "");
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("uinArray_stampList:");
              paramInt1 = 0;
              while (paramInt1 < arrayOfLong2.length)
              {
                localStringBuilder.append(arrayOfLong2[paramInt1] + "_" + arrayOfLong1[paramInt1] + "|");
                paramInt1 += 1;
              }
            }
          }
        }
        paramIntent = localStringBuilder.append(" | uinArray len = ");
        if (arrayOfLong2 != null) {
          break label375;
        }
        paramInt1 = -1;
        paramIntent.append(paramInt1).append(" | type = ").append(i);
        paramIntent = localStringBuilder.append(" | stampList len = ");
        if (arrayOfLong1 != null) {
          break label382;
        }
      }
    }
    label375:
    label382:
    for (paramInt1 = -1;; paramInt1 = arrayOfLong1.length)
    {
      paramIntent.append(paramInt1).append(" | message = ").append(str);
      localStringBuilder.append(" | giftId id = ").append(paramInt2);
      super.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
      return;
      paramInt1 = arrayOfLong2.length;
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.app.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.b();
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.b = paramInt;
    ReportController.b(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
    a(paramInt);
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      if (this.b == 0) {
        localTopGestureLayout.setInterceptTouchFlag(true);
      }
    }
    else {
      return;
    }
    localTopGestureLayout.setInterceptTouchFlag(false);
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
        runOnUiThread(new uiw(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */