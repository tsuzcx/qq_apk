package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.AddtionInfo;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AddRequestActivity
  extends DialogBaseActivity
  implements View.OnClickListener, AppConstants
{
  protected float a;
  int jdField_a_of_type_Int;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AddRequestActivity.6(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AddRequestActivity.13(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new AddRequestActivity.14(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddRequestActivity.9(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AddRequestActivity.12(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Serializable jdField_a_of_type_JavaIoSerializable;
  String jdField_a_of_type_JavaLangString;
  structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  protected float b;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new AddRequestActivity.7(this);
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 3999;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new AddRequestActivity.8(this);
  Button jdField_c_of_type_AndroidWidgetButton;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = null;
  private long jdField_e_of_type_Long;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = "";
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = "";
  private TextView g;
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, LinearLayout paramLinearLayout, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, "setEntityInfo null");
      }
    }
    TextView localTextView;
    ImageView localImageView;
    do
    {
      do
      {
        return;
      } while (paramLinearLayout == null);
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, "setEntityInfo category:" + paramString2 + ",name:" + paramString3 + ",url:" + paramString4);
      }
      localTextView = (TextView)paramLinearLayout.findViewById(2131374476);
      localImageView = (ImageView)paramLinearLayout.findViewById(2131374475);
    } while (TextUtils.isEmpty(paramString2));
    paramLinearLayout.setVisibility(0);
    if (TextUtils.isEmpty(paramString3)) {}
    for (paramString2 = "";; paramString2 = paramString3)
    {
      localTextView.setText(paramString2);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B756", "0X800B756", 0, 0, paramString5, paramString6, "", "");
      if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4))) {
        break;
      }
      localImageView.setVisibility(0);
      paramLinearLayout.setOnClickListener(new AddRequestActivity.3(paramString4, paramActivity, paramQQAppInterface, paramString5, paramString6, paramString1));
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364211));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364209));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364210));
    TextView localTextView = (TextView)findViewById(2131371957);
    Object localObject2 = (LinearLayout)findViewById(2131381157);
    Object localObject6 = (LinearLayout)findViewById(2131371958);
    ImageView localImageView = (ImageView)findViewById(2131366520);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372288));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372271));
    Object localObject4 = (TextView)findViewById(2131381165);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362352));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376861));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376946));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378018));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    Object localObject5 = ((TextView)localObject4).getPaint();
    Object localObject1 = localObject5;
    if (localObject5 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.jdField_e_of_type_JavaLangString);
    if (this.jdField_b_of_type_Float - f1 > 30.0F)
    {
      ((TextView)localObject4).setText(this.jdField_e_of_type_JavaLangString);
      paramBoolean = true;
      localObject1 = localObject4;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_e_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString.equals(""))) {
        break label787;
      }
      if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.equals(""))) {
        break label763;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130839590);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      a(localTextView);
      if (((LinearLayout)localObject6).getVisibility() != 0) {
        ((LinearLayout)localObject6).setVisibility(0);
      }
      ((LinearLayout)localObject6).setBackgroundResource(2130839590);
    }
    label418:
    for (localObject2 = new FrdSysMsg.AddtionInfo();; localObject2 = "2")
    {
      try
      {
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion.has()))
        {
          ((FrdSysMsg.AddtionInfo)localObject2).mergeFrom(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion.get().toByteArray());
          localObject4 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_category.get();
          localObject5 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_name.get();
          localObject6 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_url.get();
          if (this.jdField_b_of_type_Boolean != true) {
            continue;
          }
          localObject2 = "1";
          a(this.app, this, (LinearLayout)findViewById(2131371952), "Q.systemmsg.AddRequestActivity", (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject2, "1");
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          label763:
          if (QLog.isColorLevel())
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 2, "decode FrdSysMsg.AddtionInfo failed!");
            continue;
            if (i == 1)
            {
              this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)localInvalidProtocolBufferMicroException.get(i)).detail_name.get());
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label2029;
      }
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label975;
      }
      i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label993;
        }
        ((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get();
        if (i != 0) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
        i += 1;
      }
      localObject2 = (LinearLayout)findViewById(2131381156);
      localObject1 = (TextView)findViewById(2131381155);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376930));
      paramBoolean = false;
      break;
      ((LinearLayout)localObject2).setBackgroundResource(2130839537);
      ((LinearLayout)localObject2).setVisibility(0);
      ((LinearLayout)localObject6).setVisibility(8);
      break label418;
      if ((this.jdField_e_of_type_JavaLangString != null) && (!this.jdField_e_of_type_JavaLangString.equals(""))) {
        break label418;
      }
      if ((this.jdField_f_of_type_JavaLangString != null) && (!this.jdField_f_of_type_JavaLangString.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        a(localTextView);
        if (((LinearLayout)localObject6).getVisibility() != 0) {
          ((LinearLayout)localObject6).setVisibility(0);
        }
        ((LinearLayout)localObject6).setBackgroundResource(2130839537);
        break label418;
      }
      localObject4 = (ViewGroup)findViewById(2131364212);
      ((View)localObject4).setBackgroundResource(2130839575);
      ((View)localObject4).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      ((LinearLayout)localObject6).setVisibility(8);
      break label418;
    }
    label787:
    label975:
    label993:
    Object localObject3 = (TextView)findViewById(2131379392);
    if ((this.jdField_c_of_type_Int == 3014) || (this.jdField_c_of_type_Int == 2014))
    {
      ((TextView)localObject3).setVisibility(0);
      label1031:
      localObject3 = (TextView)findViewById(2131371934);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has())) {
        break label2060;
      }
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();
      label1090:
      if ((i & 0x20) == 32)
      {
        this.jdField_b_of_type_Boolean = true;
        ((TextView)localObject3).setText(2131689511);
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setOnClickListener(this);
        ReportController.b(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, new Object[] { "uint32_source_flag=", Integer.valueOf(i) });
      ((TextView)findViewById(2131361931)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject3 = (TextView)findViewById(2131361930);
      if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.get() == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() <= 1) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get().length() <= 0) || (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_JavaLangString)))) {
        break label2165;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ((TextView)localObject3).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get());
      ReportController.b(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
    }
    label1565:
    label1840:
    label2029:
    label2165:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((TextView)localObject3).setVisibility(8);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.g = ((TextView)findViewById(2131365158));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.g.setVisibility(0);
          label1663:
          localObject3 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_JavaLangString);
          if ((localObject3 == null) || (((Friends)localObject3).alias == null) || (((Friends)localObject3).alias.length() == 0)) {
            ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
          }
          e();
          i = 0;
          if ((this.jdField_c_of_type_Int == 3007) || (this.jdField_c_of_type_Int == 3019) || (this.jdField_c_of_type_Int == 2007) || (this.jdField_c_of_type_Int == 4007) || (this.jdField_c_of_type_Int == 2019))
          {
            localObject3 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if ((localObject3 == null) || (!((FriendsManager)localObject3).b(this.jdField_a_of_type_JavaLangString))) {
              break label2114;
            }
            i = 0;
          }
          if (i == 0) {
            break label2119;
          }
          localObject3 = FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true);
          localImageView.setBackgroundDrawable((Drawable)localObject3);
          ((ViewGroup)findViewById(2131364212)).setOnClickListener(new AddRequestActivity.2(this));
          ((TextView)localObject1).setText(StringUtil.a(this.jdField_e_of_type_JavaLangString));
          if (this.jdField_b_of_type_Int != 2) {
            break label2136;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        b(paramBoolean);
        if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X800AA40", "0X800AA40", 0, 0, "", "", "", "");
        }
        if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X800AD03", "0X800AD03", 0, 0, "", "", "", "");
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        break;
        ((TextView)localObject3).setVisibility(8);
        break label1031;
        i = 0;
        break label1090;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        break label1565;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        break label1565;
        this.g.setVisibility(8);
        ThreadManager.post(new AddRequestActivity.1(this), 5, null, true);
        break label1663;
        i = 1;
        break label1819;
        localObject3 = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString);
        break label1840;
        if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString))) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() >= 1)
        {
          localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(1)).action_info.get();
          if (paramBoolean) {
            ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(true);
          }
          this.app.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 1, null, false);
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, String.format("sendRefuseRequest withShield=%s hasSendRequest=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (TextView localTextView = (TextView)findViewById(2131381166);; localTextView = (TextView)findViewById(2131381158))
    {
      localTextView.setText(2131693430);
      return;
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc_w 626
    //   5: invokevirtual 199	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   8: putfield 628	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   11: aload_0
    //   12: aload_0
    //   13: ldc_w 629
    //   16: invokevirtual 199	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   19: checkcast 631	com/tencent/image/URLImageView
    //   22: putfield 633	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   25: aload_0
    //   26: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   29: ifnull +323 -> 352
    //   32: aload_0
    //   33: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   36: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   39: getfield 636	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   42: invokevirtual 305	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   45: ifeq +307 -> 352
    //   48: aload_0
    //   49: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   52: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   55: getfield 639	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   61: ifeq +291 -> 352
    //   64: aload_0
    //   65: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   68: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   71: ifnull +286 -> 357
    //   74: aload_0
    //   75: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   78: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   81: getfield 342	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 347	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: ifnull +270 -> 357
    //   90: aload_0
    //   91: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   94: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   97: getfield 342	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   100: invokevirtual 347	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +252 -> 357
    //   108: aload_3
    //   109: invokeinterface 352 1 0
    //   114: ifle +243 -> 357
    //   117: iconst_1
    //   118: istore_1
    //   119: aload_0
    //   120: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   123: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   126: getfield 639	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 390	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: iconst_1
    //   133: if_icmpne +219 -> 352
    //   136: iload_1
    //   137: ifeq +215 -> 352
    //   140: new 641	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   143: dup
    //   144: invokespecial 642	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: aload_0
    //   152: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   155: getfield 239	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   158: getfield 636	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: invokevirtual 308	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   164: invokevirtual 314	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   167: invokevirtual 643	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: pop
    //   171: new 645	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   174: dup
    //   175: invokespecial 646	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   178: astore_3
    //   179: aload_3
    //   180: aload 4
    //   182: invokestatic 651	com/tencent/mobileqq/businessCard/BusinessCardServlet:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   185: aload_0
    //   186: ldc 210
    //   188: invokevirtual 199	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   191: checkcast 150	android/widget/LinearLayout
    //   194: astore 4
    //   196: aload_3
    //   197: ifnull +141 -> 338
    //   200: aload_3
    //   201: getfield 654	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   204: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +131 -> 338
    //   210: aload 4
    //   212: ldc_w 282
    //   215: invokevirtual 285	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   218: aload_0
    //   219: getfield 628	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   222: iconst_0
    //   223: invokevirtual 374	android/view/View:setVisibility	(I)V
    //   226: aload_0
    //   227: getfield 633	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   230: iconst_0
    //   231: invokevirtual 655	com/tencent/image/URLImageView:setVisibility	(I)V
    //   234: aload_0
    //   235: invokevirtual 659	com/tencent/mobileqq/activity/AddRequestActivity:getResources	()Landroid/content/res/Resources;
    //   238: invokevirtual 665	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   241: getfield 670	android/util/DisplayMetrics:widthPixels	I
    //   244: aload_0
    //   245: ldc_w 671
    //   248: invokestatic 676	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   251: iconst_2
    //   252: imul
    //   253: isub
    //   254: istore_1
    //   255: iload_1
    //   256: sipush 600
    //   259: imul
    //   260: sipush 1000
    //   263: idiv
    //   264: istore_2
    //   265: aload_0
    //   266: getfield 633	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   269: invokevirtual 680	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   272: checkcast 682	android/widget/LinearLayout$LayoutParams
    //   275: astore 4
    //   277: aload 4
    //   279: iload_1
    //   280: putfield 685	android/widget/LinearLayout$LayoutParams:width	I
    //   283: aload 4
    //   285: iload_2
    //   286: putfield 688	android/widget/LinearLayout$LayoutParams:height	I
    //   289: aload_0
    //   290: getfield 633	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   293: aload 4
    //   295: invokevirtual 692	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   298: aload_3
    //   299: getfield 654	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 633	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   306: sipush 1000
    //   309: sipush 600
    //   312: invokestatic 697	com/tencent/mobileqq/businessCard/utilities/BusinessCardUtils:a	(Ljava/lang/String;Lcom/tencent/image/URLImageView;II)V
    //   315: return
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_3
    //   319: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +13 -> 335
    //   325: ldc_w 336
    //   328: iconst_2
    //   329: ldc_w 699
    //   332: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto -150 -> 185
    //   338: aload 4
    //   340: ldc_w 282
    //   343: invokevirtual 285	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   346: return
    //   347: astore 4
    //   349: goto -30 -> 319
    //   352: aconst_null
    //   353: astore_3
    //   354: goto -169 -> 185
    //   357: iconst_0
    //   358: istore_1
    //   359: goto -240 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	AddRequestActivity
    //   118	241	1	i	int
    //   264	22	2	j	int
    //   103	196	3	localObject1	Object
    //   316	1	3	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   318	36	3	localObject2	Object
    //   147	192	4	localObject3	Object
    //   347	1	4	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   149	179	316	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   179	185	347	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void e()
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label80;
      }
      str = this.jdField_d_of_type_JavaLangString;
      label37:
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, "0"))) {
        break label89;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label80:
    label89:
    int i;
    int j;
    int k;
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      break;
      str = this.jdField_a_of_type_JavaLangString;
      break label37;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      str = "(" + TogetherUtils.a(18, str) + ")";
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      i = (int)Layout.getDesiredWidth(this.jdField_c_of_type_AndroidWidgetTextView.getText(), this.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      j = (int)Layout.getDesiredWidth(this.jdField_b_of_type_AndroidWidgetTextView.getText(), this.jdField_b_of_type_AndroidWidgetTextView.getPaint());
      k = ViewUtils.a() - ViewUtils.a(130.0F);
    } while (j + i <= k);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(k - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setMinWidth(i);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, getString(2131689596), null, getString(2131689595), false, getString(2131690800), getString(2131694615), new AddRequestActivity.15(this), new AddRequestActivity.16(this), new AddRequestActivity.17(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      ReportController.b(this.app, "dc00898", "", "", "0X800B083", "0X800B083", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.systemmsg.AddRequestActivity", 1, "handleRefuseClicked show dialog fail.", localException);
    }
  }
  
  public void a()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131297244);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i * 1 - 175.0F * this.mDensity);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  protected void a(TextView paramTextView)
  {
    if (paramTextView == null) {}
    Resources localResources;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      paramTextView.setSingleLine(false);
      localResources = paramTextView.getContext().getResources();
      localObject1 = this.jdField_f_of_type_JavaLangString;
      localObject2 = localObject1;
      if (this.jdField_b_of_type_Long != 0L)
      {
        this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.app, String.valueOf(this.jdField_b_of_type_Long));
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            localObject2 = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.jdField_f_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
          }
        }
      }
    } while (Utils.a(localObject2, paramTextView.getText().toString()));
    SpannableString localSpannableString;
    int j;
    label427:
    label718:
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localSpannableString = new SpannableString((CharSequence)localObject2);
      Bundle localBundle = null;
      Object localObject4 = null;
      Object localObject3 = localObject4;
      localObject1 = localBundle;
      long l;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
      {
        localObject3 = localObject4;
        localObject1 = localBundle;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
        {
          localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
          l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
          if (l == 0L) {
            break label937;
          }
          localObject1 = Long.toString(l);
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        i = ((String)localObject2).indexOf((String)localObject3);
        j = ((String)localObject3).length();
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 1, "Q.systemmsg.AddRequestActivity", TroopInfoActivity.a((String)localObject1, 101)), i, j + i, 33);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(1), localObject3, localObject1, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject3 = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_b_of_type_Long != 0L)
      {
        localObject1 = Long.toString(this.jdField_b_of_type_Long);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
        {
          i = ((String)localObject2).indexOf((String)localObject3);
          j = ((String)localObject3).length();
          localBundle = new Bundle();
          localBundle.putString("uin", (String)localObject1);
          localBundle.putString("uinname", this.jdField_c_of_type_JavaLangString);
          localBundle.putInt("uintype", 3000);
          localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 2, "Q.systemmsg.AddRequestActivity", localBundle), i, j + i, 33);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (QLog.isColorLevel())) {
            QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(2), localObject3, localObject1, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
          }
        }
        localBundle = null;
        localObject4 = null;
        localObject3 = localBundle;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
        {
          localObject3 = localBundle;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
          {
            localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
            l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get();
            if (l == 0L) {
              break label949;
            }
            localObject1 = Long.toString(l);
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
        {
          j = ((String)localObject2).indexOf((String)localObject3);
          k = ((String)localObject3).length();
          if (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
            break label964;
          }
        }
      }
    }
    label937:
    label949:
    label964:
    for (int i = 1;; i = 25)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_profile_uin", (String)localObject1);
      ((Bundle)localObject2).putInt("key_profile_pa", i);
      ((Bundle)localObject2).putInt("key_profile_chatability", 1);
      localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 3, "Q.systemmsg.AddRequestActivity", (Bundle)localObject2), j, j + k, 33);
      paramTextView.setClickable(true);
      paramTextView.setFocusable(true);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      paramTextView.setLinkTextColor(localResources.getColorStateList(2131167085));
      for (;;)
      {
        localObject1 = paramTextView.getText().toString();
        localObject2 = this.app;
        paramTextView = (TextView)localObject1;
        if (localObject1 == null) {
          paramTextView = "null";
        }
        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", paramTextView, "");
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label427;
        localObject1 = null;
        break label718;
        paramTextView.setText((CharSequence)localObject2);
      }
    }
  }
  
  void a(Card paramCard)
  {
    if (paramCard != null)
    {
      int j = -1;
      Object localObject1 = "";
      int i = j;
      if (paramCard != null) {
        if (paramCard.shGender != 0)
        {
          i = j;
          if (paramCard.shGender != 1) {}
        }
        else
        {
          i = paramCard.shGender;
        }
      }
      if (i == 0)
      {
        localObject1 = getString(2131693923);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        i = paramCard.age;
        localObject1 = "";
        if (i <= 0) {
          break label383;
        }
        localObject1 = i + getString(2131719672);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        label115:
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        Object localObject2 = "";
        localObject1 = localObject2;
        if (paramCard.strProvince != null)
        {
          localObject1 = localObject2;
          if (paramCard.strProvince.length() > 0) {
            localObject1 = "" + paramCard.strProvince;
          }
        }
        localObject2 = localObject1;
        if (paramCard.strCity != null)
        {
          localObject2 = localObject1;
          if (paramCard.strCity.length() > 0) {
            localObject2 = (String)localObject1 + "" + paramCard.strCity;
          }
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (this.jdField_a_of_type_JavaIoSerializable != null)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          if ("age:" + paramCard.age + "gender:" + paramCard.shGender + ",isFromWzry=" + this.jdField_a_of_type_JavaIoSerializable == null) {
            break label395;
          }
        }
      }
      label395:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, new Object[] { Boolean.valueOf(bool) });
        return;
        if (i == 1)
        {
          localObject1 = getString(2131692330);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label383:
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break label115;
      }
    }
    ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(getString(2131690821), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestActivity.4(this, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getTag() instanceof String)) {}
    for (String str = (String)this.jdField_a_of_type_AndroidWidgetTextView.getTag();; str = getString(2131719101))
    {
      localActionSheet.setMainTitle(str);
      localActionSheet.addButton(getString(2131719342), 3);
      localActionSheet.setOnButtonClickListener(new AddRequestActivity.5(this, localActionSheet));
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.show();
      return;
    }
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
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l));
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("infouin");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("verify_msg");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("msg_source");
    this.jdField_c_of_type_Int = getIntent().getIntExtra("msg_source_id", 3041);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get() == 8)) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
    }
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has())) {
      this.jdField_d_of_type_JavaLangString = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("msg_type", -1006);
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("sig");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("lToMobile", 0L);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("strNickName");
    paramBundle = getIntent().getStringExtra("info_dealwith_msg");
    this.jdField_e_of_type_Long = getIntent().getLongExtra("msg_troopuin", 0L);
    String str = getIntent().getStringExtra("msg_title");
    if (getIntent().hasExtra("param_wzry_data")) {
      this.jdField_a_of_type_JavaIoSerializable = getIntent().getSerializableExtra("param_wzry_data");
    }
    super.setContentView(2131561654);
    Object localObject = findViewById(2131363858);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130838980);
    }
    localObject = (TextView)findViewById(2131371924);
    if ((paramBundle != null) && (!paramBundle.equals("")))
    {
      ((TextView)localObject).setText(paramBundle);
      ((TextView)localObject).setVisibility(0);
    }
    setTitle(str);
    a(true);
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    if (this.jdField_b_of_type_Long != 0L) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, getString(2131694457), 0).b(getTitleBarHeight());
    }
    label737:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = 0;
      int i = 0;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Int == -1011)
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).confirmContactFriend(0, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
          i = 1;
          label104:
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
          if (this.jdField_a_of_type_JavaIoSerializable != null) {
            ReportController.b(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
          }
          ReportController.b(this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label737;
        }
        a(2131719050, 1000L, false);
        break;
        long l1 = FriendSystemMsgController.a().b();
        Object localObject1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
        if (localObject1 != null)
        {
          i = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
          Object localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
            this.app.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            i = 1;
            break label104;
          }
          localObject1 = new StringBuilder().append("agree, ");
          if (localObject2 != null) {}
          for (i = ((List)localObject2).size();; i = -1)
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
        break label104;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          f();
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
          if (this.jdField_a_of_type_JavaIoSerializable != null) {
            ReportController.b(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
          }
          ReportController.b(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
          i = j;
        }
        else
        {
          i = j;
          if (paramView.getId() == 2131371934)
          {
            i = j;
            if (QQBrowserActivity.checkNotFrequentlyThenEnter(1500L))
            {
              localObject1 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
              startActivity((Intent)localObject1);
              ReportController.b(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
              i = j;
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131690816)).setMessage(2131690814).setPositiveButton(2131690815, new AddRequestActivity.11(this)).setNegativeButton(2131690779, new AddRequestActivity.10(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755842);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807)).setText(2131690823);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */