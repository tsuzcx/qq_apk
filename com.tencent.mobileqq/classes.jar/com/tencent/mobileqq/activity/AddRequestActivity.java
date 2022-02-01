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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
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
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
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
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
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
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddRequestActivity.9(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AddRequestActivity.12(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new AddRequestActivity.14(this);
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
    if ((paramQQAppInterface != null) && (paramActivity != null))
    {
      if (paramLinearLayout != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setEntityInfo category:");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(",name:");
          ((StringBuilder)localObject).append(paramString3);
          ((StringBuilder)localObject).append(",url:");
          ((StringBuilder)localObject).append(paramString4);
          QLog.d(paramString1, 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (TextView)paramLinearLayout.findViewById(2131374014);
        ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131374013);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramLinearLayout.setVisibility(0);
          if (TextUtils.isEmpty(paramString3)) {
            paramString2 = "";
          } else {
            paramString2 = paramString3;
          }
          ((TextView)localObject).setText(paramString2);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B756", "0X800B756", 0, 0, paramString5, paramString6, "", "");
          if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
          {
            localImageView.setVisibility(0);
            paramLinearLayout.setOnClickListener(new AddRequestActivity.3(paramString4, paramActivity, paramQQAppInterface, paramString5, paramString6, paramString1));
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "setEntityInfo null");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364128));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364126));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364127));
    Object localObject6 = (TextView)findViewById(2131371565);
    Object localObject2 = (LinearLayout)findViewById(2131380414);
    Object localObject5 = (LinearLayout)findViewById(2131371566);
    ImageView localImageView = (ImageView)findViewById(2131366401);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371877));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371860));
    Object localObject3 = (TextView)findViewById(2131380422);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362313));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376352));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376436));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377442));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    Object localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    Object localObject4 = ((TextView)localObject3).getPaint();
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.jdField_e_of_type_JavaLangString);
    float f2 = this.jdField_b_of_type_Float;
    int j = 0;
    if (f2 - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.jdField_e_of_type_JavaLangString);
      localObject1 = localObject3;
      paramBoolean = true;
    }
    else
    {
      localObject2 = (LinearLayout)findViewById(2131380413);
      localObject1 = (TextView)findViewById(2131380412);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376420));
      paramBoolean = false;
    }
    ((LinearLayout)localObject2).setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    localObject3 = this.jdField_e_of_type_JavaLangString;
    if ((localObject3 != null) && (!((String)localObject3).equals("")))
    {
      localObject3 = this.jdField_f_of_type_JavaLangString;
      if ((localObject3 != null) && (!((String)localObject3).equals("")))
      {
        ((LinearLayout)localObject2).setBackgroundResource(2130839448);
        if (((LinearLayout)localObject2).getVisibility() != 0) {
          ((LinearLayout)localObject2).setVisibility(0);
        }
        a((TextView)localObject6);
        if (((LinearLayout)localObject5).getVisibility() != 0) {
          ((LinearLayout)localObject5).setVisibility(0);
        }
        ((LinearLayout)localObject5).setBackgroundResource(2130839448);
      }
      else
      {
        ((LinearLayout)localObject2).setBackgroundResource(2130839393);
        ((LinearLayout)localObject2).setVisibility(0);
        ((LinearLayout)localObject5).setVisibility(8);
      }
    }
    else
    {
      localObject3 = this.jdField_e_of_type_JavaLangString;
      if ((localObject3 == null) || (((String)localObject3).equals("")))
      {
        localObject3 = this.jdField_f_of_type_JavaLangString;
        if ((localObject3 != null) && (!((String)localObject3).equals("")))
        {
          ((LinearLayout)localObject2).setVisibility(8);
          a((TextView)localObject6);
          if (((LinearLayout)localObject5).getVisibility() != 0) {
            ((LinearLayout)localObject5).setVisibility(0);
          }
          ((LinearLayout)localObject5).setBackgroundResource(2130839393);
        }
        else
        {
          localObject3 = (ViewGroup)findViewById(2131364129);
          ((View)localObject3).setBackgroundResource(2130839433);
          ((View)localObject3).setVisibility(0);
          ((LinearLayout)localObject2).setVisibility(8);
          ((LinearLayout)localObject5).setVisibility(8);
        }
      }
    }
    localObject2 = new FrdSysMsg.AddtionInfo();
    try
    {
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion.has())) {
        break label801;
      }
      ((FrdSysMsg.AddtionInfo)localObject2).mergeFrom(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_addtion.get().toByteArray());
      localObject3 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_category.get();
      localObject4 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_name.get();
      localObject5 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_url.get();
      if (this.jdField_b_of_type_Boolean != true) {
        break label2237;
      }
      localObject2 = "1";
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      for (;;)
      {
        LinearLayout localLinearLayout;
        continue;
        String str = "2";
      }
    }
    localObject6 = this.app;
    localLinearLayout = (LinearLayout)findViewById(2131371560);
    try
    {
      a((QQAppInterface)localObject6, this, localLinearLayout, "Q.systemmsg.AddRequestActivity", (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject2, "1");
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      label798:
      int i;
      int k;
      break label798;
    }
    break label804;
    label801:
    break label820;
    label804:
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, "decode FrdSysMsg.AddtionInfo failed!");
    }
    label820:
    localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null))
    {
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          ((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get();
          if (i == 0)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
          }
          else if (i == 1)
          {
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
          }
          i += 1;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    localObject2 = (TextView)findViewById(2131378743);
    i = this.jdField_c_of_type_Int;
    if ((i != 3014) && (i != 2014)) {
      ((TextView)localObject2).setVisibility(8);
    } else {
      ((TextView)localObject2).setVisibility(0);
    }
    localObject2 = (TextView)findViewById(2131371545);
    localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has())) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();
    } else {
      i = 0;
    }
    if ((i & 0x20) == 32)
    {
      this.jdField_b_of_type_Boolean = true;
      ((TextView)localObject2).setText(2131689538);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setOnClickListener(this);
      ReportController.b(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
    }
    QLog.d("Q.systemmsg.AddRequestActivity", 1, new Object[] { "uint32_source_flag=", Integer.valueOf(i) });
    ((TextView)findViewById(2131361937)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = (TextView)findViewById(2131361936);
    QLog.isColorLevel();
    localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 1) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get().length() > 0) && (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get());
      ReportController.b(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg.has())) {
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 6: 
      case 7: 
      case 8: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 9: 
      case 10: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    this.g = ((TextView)findViewById(2131365038));
    localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
    {
      this.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
      this.g.setVisibility(0);
    }
    else
    {
      this.g.setVisibility(8);
      ThreadManager.post(new AddRequestActivity.1(this), 5, null, true);
    }
    localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_JavaLangString);
    if ((localObject2 == null) || (((Friends)localObject2).alias == null) || (((Friends)localObject2).alias.length() == 0)) {
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
    e();
    k = this.jdField_c_of_type_Int;
    if ((k != 3007) && (k != 3019) && (k != 2007) && (k != 4007))
    {
      i = j;
      if (k != 2019) {}
    }
    else
    {
      localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject2 != null) && (((FriendsManager)localObject2).b(this.jdField_a_of_type_JavaLangString))) {
        i = j;
      } else {
        i = 1;
      }
    }
    if (i != 0) {
      localObject2 = FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true);
    } else {
      localObject2 = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString);
    }
    localImageView.setBackgroundDrawable((Drawable)localObject2);
    ((ViewGroup)findViewById(2131364129)).setOnClickListener(new AddRequestActivity.2(this));
    ((TextView)localObject1).setText(StringUtil.a(this.jdField_e_of_type_JavaLangString));
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      localObject2 = this.jdField_e_of_type_JavaLangString;
      if ((localObject2 == null) || ("".equals(localObject2))) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
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
  }
  
  private boolean a(boolean paramBoolean)
  {
    long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject != null) && (((List)localObject).size() >= 1))
      {
        localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(1)).action_info.get();
        if (paramBoolean) {
          ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(true);
        }
        this.app.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 1, null, false);
        bool = true;
        break label247;
      }
    }
    boolean bool = false;
    label247:
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, String.format("sendRefuseRequest withShield=%s hasSendRequest=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((localObject != null) && (((structmsg.StructMsg)localObject).msg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())))
    {
      if (paramBoolean) {
        localObject = (TextView)findViewById(2131380423);
      } else {
        localObject = (TextView)findViewById(2131380415);
      }
      ((TextView)localObject).setText(2131693385);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377492);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131364134));
    structmsg.StructMsg localStructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    Oidb_0x43c.CardInfo localCardInfo = null;
    Object localObject2 = null;
    Object localObject1 = localCardInfo;
    int i;
    if (localStructMsg != null)
    {
      localObject1 = localCardInfo;
      if (localStructMsg.msg.req_uin_business_card.has())
      {
        localObject1 = localCardInfo;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.card_switch.has())
        {
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null))
          {
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              i = 1;
              break label141;
            }
          }
          i = 0;
          label141:
          localObject1 = localCardInfo;
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.card_switch.get() == 1)
          {
            localObject1 = localCardInfo;
            if (i != 0) {
              localCardInfo = new Oidb_0x43c.CardInfo();
            }
          }
        }
      }
    }
    try
    {
      localCardInfo.mergeFrom(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_business_card.get().toByteArray());
      localObject1 = new BusinessCard();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      label216:
      label222:
      int j;
      break label222;
    }
    try
    {
      BusinessCardServlet.a((BusinessCard)localObject1, localCardInfo);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      break label216;
    }
    localObject2 = localObject1;
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, "decode CardInfo failed!");
      localObject1 = localObject2;
    }
    localObject2 = (LinearLayout)findViewById(2131371566);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((BusinessCard)localObject1).picUrl)))
    {
      ((LinearLayout)localObject2).setBackgroundResource(2130839448);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      i = getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(this, 15.0F) * 2;
      j = i * 600 / 1000;
      localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = i;
      ((LinearLayout.LayoutParams)localObject2).height = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      BusinessCardUtils.a(((BusinessCard)localObject1).picUrl, this.jdField_a_of_type_ComTencentImageURLImageView, 1000, 600);
      return;
    }
    ((LinearLayout)localObject2).setBackgroundResource(2130839448);
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    String str;
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      str = this.jdField_d_of_type_JavaLangString;
    } else {
      str = this.jdField_a_of_type_JavaLangString;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, "0")))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(TogetherUtils.a(18, str));
      localStringBuilder.append(")");
      str = localStringBuilder.toString();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      int i = (int)Layout.getDesiredWidth(this.jdField_c_of_type_AndroidWidgetTextView.getText(), this.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      int j = (int)Layout.getDesiredWidth(this.jdField_b_of_type_AndroidWidgetTextView.getText(), this.jdField_b_of_type_AndroidWidgetTextView.getPaint());
      int k = ViewUtils.a() - ViewUtils.a(130.0F);
      if (j + i > k)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(k - i);
        this.jdField_c_of_type_AndroidWidgetTextView.setMinWidth(i);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, getString(2131689628), null, getString(2131689627), false, getString(2131690728), getString(2131694583), new AddRequestActivity.15(this), new AddRequestActivity.16(this), new AddRequestActivity.17(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
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
  }
  
  public void a()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131297233);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i * 1 - this.mDensity * 175.0F);
  }
  
  protected void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setSingleLine(false);
    Resources localResources = paramTextView.getContext().getResources();
    Object localObject1 = this.jdField_f_of_type_JavaLangString;
    Object localObject2 = localObject1;
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_c_of_type_JavaLangString = ContactUtils.b(this.app, String.valueOf(this.jdField_b_of_type_Long));
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          localObject2 = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.jdField_f_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
        }
      }
    }
    if (Utils.a(localObject2, paramTextView.getText().toString())) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      Object localObject4;
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null))
      {
        localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
        localObject1 = localObject3;
        if (l != 0L)
        {
          localObject4 = Long.toString(l);
          localObject1 = localObject3;
          localObject3 = localObject4;
          break label234;
        }
      }
      else
      {
        localObject1 = null;
      }
      Object localObject3 = null;
      label234:
      int i;
      int j;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject2).contains((CharSequence)localObject1)))
      {
        i = ((String)localObject2).indexOf((String)localObject1);
        j = ((String)localObject1).length();
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 1, "Q.systemmsg.AddRequestActivity", TroopInfoUIUtil.a((String)localObject3, 101)), i, i + j, 33);
        localObject4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
        if ((localObject4 != null) && (((structmsg.StructMsg)localObject4).msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(1), localObject1, localObject3, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject3 = this.jdField_c_of_type_JavaLangString;
      long l = this.jdField_b_of_type_Long;
      if (l != 0L) {
        localObject1 = Long.toString(l);
      } else {
        localObject1 = null;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        i = ((String)localObject2).indexOf((String)localObject3);
        j = ((String)localObject3).length();
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("uin", (String)localObject1);
        ((Bundle)localObject4).putString("uinname", this.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject4).putInt("uintype", 3000);
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 2, "Q.systemmsg.AddRequestActivity", (Bundle)localObject4), i, j + i, 33);
        localObject4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
        if ((localObject4 != null) && (((structmsg.StructMsg)localObject4).msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(2), localObject3, localObject1, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null))
      {
        localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get();
        if (l != 0L) {
          localObject1 = Long.toString(l);
        } else {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = null;
        localObject3 = null;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        j = ((String)localObject2).indexOf((String)localObject3);
        int k = ((String)localObject3).length();
        i = 25;
        if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
          i = 1;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_profile_uin", (String)localObject1);
        ((Bundle)localObject2).putInt("key_profile_pa", i);
        ((Bundle)localObject2).putInt("key_profile_chatability", 1);
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 3, "Q.systemmsg.AddRequestActivity", (Bundle)localObject2), j, k + j, 33);
      }
      paramTextView.setClickable(true);
      paramTextView.setFocusable(true);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      paramTextView.setLinkTextColor(localResources.getColorStateList(2131167108));
    }
    else
    {
      paramTextView.setText((CharSequence)localObject2);
    }
    localObject1 = paramTextView.getText().toString();
    localObject2 = this.app;
    paramTextView = (TextView)localObject1;
    if (localObject1 == null) {
      paramTextView = "null";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", paramTextView, "");
  }
  
  void a(Card paramCard)
  {
    if (paramCard != null)
    {
      int j = -1;
      boolean bool = true;
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
      Object localObject1;
      if (i == 0)
      {
        localObject1 = getString(2131693879);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (i == 1)
      {
        localObject1 = getString(2131692259);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject1 = "";
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      i = paramCard.age;
      if (i > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(getString(2131719391));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject1 = "";
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if ((paramCard.strProvince != null) && (paramCard.strProvince.length() > 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramCard.strProvince);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localObject1;
      if (paramCard.strCity != null)
      {
        localObject2 = localObject1;
        if (paramCard.strCity.length() > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramCard.strCity);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_JavaIoSerializable != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("age:");
        ((StringBuilder)localObject1).append(paramCard.age);
        ((StringBuilder)localObject1).append("gender:");
        ((StringBuilder)localObject1).append(paramCard.shGender);
        ((StringBuilder)localObject1).append(",isFromWzry=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaIoSerializable);
        if (((StringBuilder)localObject1).toString() == null) {
          bool = false;
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 2, new Object[] { Boolean.valueOf(bool) });
      }
    }
    else
    {
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(getString(2131690749), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestActivity.4(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String str;
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getTag() instanceof String)) {
      str = (String)this.jdField_a_of_type_AndroidWidgetTextView.getTag();
    } else {
      str = getString(2131718819);
    }
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131719060), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestActivity.5(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
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
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l));
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("infouin");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("verify_msg");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("msg_source");
    this.jdField_c_of_type_Int = getIntent().getIntExtra("msg_source_id", 3041);
    paramBundle = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((paramBundle != null) && (paramBundle.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get() == 8)) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
    }
    paramBundle = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if ((paramBundle != null) && (paramBundle.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has())) {
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
    super.setContentView(2131561505);
    Object localObject = findViewById(2131363786);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130838740);
    }
    localObject = (TextView)findViewById(2131371541);
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
      addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver, true);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppCardObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, getString(2131694422), 0).b(getTitleBarHeight());
    }
    else
    {
      int i;
      Object localObject1;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        int j = this.jdField_a_of_type_Int;
        i = 1;
        if (j == -1011)
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).confirmContactFriend(0, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
          i = 1;
        }
        else
        {
          long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
          localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
          if (localObject1 != null)
          {
            j = ((structmsg.StructMsg)localObject1).msg_type.get();
            l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
            long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
            int k = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
            int m = ((structmsg.StructMsg)localObject1).msg.src_id.get();
            int n = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
            int i1 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
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
              this.app.getMsgHandler().a().a(j, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("agree, ");
              if (localObject2 != null) {
                i = ((List)localObject2).size();
              } else {
                i = -1;
              }
              ((StringBuilder)localObject1).append(i);
              QLog.d("Q.systemmsg.AddRequestActivity", 1, ((StringBuilder)localObject1).toString());
              i = 0;
            }
          }
          else
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
            i = 0;
          }
        }
        ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
        if (this.jdField_a_of_type_JavaIoSerializable != null) {
          ReportController.b(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
      }
      else
      {
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          f();
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
          if (this.jdField_a_of_type_JavaIoSerializable != null) {
            ReportController.b(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
          }
          ReportController.b(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
        }
        else if ((paramView.getId() == 2131371545) && (WebViewComUtils.a(1500L)))
        {
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
          startActivity((Intent)localObject1);
          ReportController.b(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
        }
        i = 0;
      }
      if (i != 0) {
        showProgressDialog(2131718766, 1000L, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return super.onCreateDialog(paramInt);
      }
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558463);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(2131690751);
      return this.jdField_a_of_type_AndroidAppDialog;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131690744)).setMessage(2131690742).setPositiveButton(2131690743, new AddRequestActivity.11(this)).setNegativeButton(2131690707, new AddRequestActivity.10(this));
    return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  }
  
  protected void showToast(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */