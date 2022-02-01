package com.tencent.mobileqq.activity;

import Override;
import acqm;
import acqn;
import acqo;
import acqp;
import acqq;
import acqr;
import acqs;
import acqt;
import acqu;
import acqv;
import acqw;
import acqx;
import acqy;
import acqz;
import acra;
import acrb;
import amov;
import amrc;
import amsu;
import amsw;
import amwl;
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
import anmf;
import bcef;
import bcsy;
import bddg;
import bftf;
import bfur;
import bjnw;
import bjon;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
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
  public int a;
  public long a;
  public amov a;
  amrc jdField_a_of_type_Amrc = new acqp(this);
  private amsu jdField_a_of_type_Amsu = new acqz(this);
  private amwl jdField_a_of_type_Amwl = new acqn(this);
  public Dialog a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acqw(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new acqo(this);
  public QQCustomDialog a;
  private Serializable jdField_a_of_type_JavaIoSerializable;
  public String a;
  public structmsg.StructMsg a;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  protected float b;
  private int jdField_b_of_type_Int;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new acqx(this);
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 3999;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new acqy(this);
  Button jdField_c_of_type_AndroidWidgetButton;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = null;
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
  
  public AddRequestActivity()
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void a(boolean paramBoolean)
  {
    a();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364033));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364031));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364032));
    TextView localTextView = (TextView)findViewById(2131371458);
    Object localObject2 = (LinearLayout)findViewById(2131380373);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131371459);
    ImageView localImageView = (ImageView)findViewById(2131366241);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371791));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371775));
    Object localObject3 = (TextView)findViewById(2131380381);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362319));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376220));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376298));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377334));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    TextPaint localTextPaint = ((TextView)localObject3).getPaint();
    Object localObject1 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.jdField_e_of_type_JavaLangString);
    if (this.jdField_b_of_type_Float - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.jdField_e_of_type_JavaLangString);
      paramBoolean = true;
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_e_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString.equals(""))) {
        break label619;
      }
      if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.equals(""))) {
        break label595;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130839490);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      a(localTextView);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      localLinearLayout.setBackgroundResource(2130839490);
      label415:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1821;
      }
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label778;
      }
      i = 0;
      label480:
      if (i >= ((List)localObject2).size()) {
        break label796;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get();
      if (i != 0) {
        break label738;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
    }
    for (;;)
    {
      i += 1;
      break label480;
      localObject2 = (LinearLayout)findViewById(2131380372);
      localObject1 = (TextView)findViewById(2131380371);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131376282));
      paramBoolean = false;
      break;
      label595:
      ((LinearLayout)localObject2).setBackgroundResource(2130839437);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label415;
      label619:
      if ((this.jdField_e_of_type_JavaLangString != null) && (!this.jdField_e_of_type_JavaLangString.equals(""))) {
        break label415;
      }
      if ((this.jdField_f_of_type_JavaLangString != null) && (!this.jdField_f_of_type_JavaLangString.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        a(localTextView);
        if (localLinearLayout.getVisibility() != 0) {
          localLinearLayout.setVisibility(0);
        }
        localLinearLayout.setBackgroundResource(2130839437);
        break label415;
      }
      localObject3 = (ViewGroup)findViewById(2131364034);
      ((View)localObject3).setBackgroundResource(2130839475);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label415;
      label738:
      if (i == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
      }
    }
    label778:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    label796:
    localObject2 = (TextView)findViewById(2131378667);
    if ((this.jdField_c_of_type_Int == 3014) || (this.jdField_c_of_type_Int == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label834:
      localObject2 = (TextView)findViewById(2131371435);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has())) {
        break label1852;
      }
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();
      label893:
      if ((i & 0x20) == 32)
      {
        ((TextView)localObject2).setText(2131689510);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setOnClickListener(this);
        bcef.b(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, new Object[] { "uint32_source_flag=", Integer.valueOf(i) });
      ((TextView)findViewById(2131361929)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject2 = (TextView)findViewById(2131361928);
      if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.get() == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() <= 1) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get().length() <= 0) || (((amsw)this.app.getManager(51)).b(this.jdField_a_of_type_JavaLangString)))) {
        break label1957;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get());
      bcef.b(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
    }
    label1821:
    label1957:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        label1361:
        this.g = ((TextView)findViewById(2131364935));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.g.setVisibility(0);
          label1459:
          localObject2 = ((amsw)this.app.getManager(51)).e(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((Friends)localObject2).alias == null) || (((Friends)localObject2).alias.length() == 0)) {
            ((FriendListHandler)this.app.getBusinessHandler(1)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
          }
          e();
          i = 0;
          if ((this.jdField_c_of_type_Int == 3007) || (this.jdField_c_of_type_Int == 3019) || (this.jdField_c_of_type_Int == 2007) || (this.jdField_c_of_type_Int == 4007) || (this.jdField_c_of_type_Int == 2019))
          {
            localObject2 = (amsw)this.app.getManager(51);
            if ((localObject2 == null) || (!((amsw)localObject2).b(this.jdField_a_of_type_JavaLangString))) {
              break label1906;
            }
            i = 0;
          }
          label1611:
          if (i == 0) {
            break label1911;
          }
          localObject2 = FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.jdField_a_of_type_JavaLangString, true);
          label1632:
          localImageView.setBackgroundDrawable((Drawable)localObject2);
          ((ViewGroup)findViewById(2131364034)).setOnClickListener(new acqt(this));
          ((TextView)localObject1).setText(StringUtil.trimUnreadableInFriendRequest(this.jdField_e_of_type_JavaLangString));
          if (this.jdField_b_of_type_Int != 2) {
            break label1928;
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
          bcef.b(this.app, "CliOper", "", "", "0X800AA40", "0X800AA40", 0, 0, "", "", "", "");
        }
        if (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0) {
          bcef.b(this.app, "CliOper", "", "", "0X800AD03", "0X800AD03", 0, 0, "", "", "", "");
        }
        bcef.b(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        break;
        ((TextView)localObject2).setVisibility(8);
        break label834;
        label1852:
        i = 0;
        break label893;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        break label1361;
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        break label1361;
        this.g.setVisibility(8);
        ThreadManager.post(new AddRequestActivity.1(this), 5, null, true);
        break label1459;
        label1906:
        i = 1;
        break label1611;
        label1911:
        localObject2 = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString);
        break label1632;
        if ((this.jdField_e_of_type_JavaLangString == null) || ("".equals(this.jdField_e_of_type_JavaLangString))) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    long l1 = bcsy.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bcsy.a().a(Long.valueOf(l1));
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
    for (TextView localTextView = (TextView)findViewById(2131380382);; localTextView = (TextView)findViewById(2131380374))
    {
      localTextView.setText(2131693111);
      return;
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc_w 541
    //   5: invokevirtual 122	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   8: putfield 543	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   11: aload_0
    //   12: aload_0
    //   13: ldc_w 544
    //   16: invokevirtual 122	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   19: checkcast 546	com/tencent/image/URLImageView
    //   22: putfield 548	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   25: aload_0
    //   26: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   29: ifnull +321 -> 350
    //   32: aload_0
    //   33: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   36: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   39: getfield 552	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   42: invokevirtual 555	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   45: ifeq +305 -> 350
    //   48: aload_0
    //   49: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   52: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   55: getfield 558	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   61: ifeq +289 -> 350
    //   64: aload_0
    //   65: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   68: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   71: ifnull +284 -> 355
    //   74: aload_0
    //   75: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   78: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   81: getfield 243	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: ifnull +268 -> 355
    //   90: aload_0
    //   91: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   94: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   97: getfield 243	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   100: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +250 -> 355
    //   108: aload_3
    //   109: invokeinterface 253 1 0
    //   114: ifle +241 -> 355
    //   117: iconst_1
    //   118: istore_1
    //   119: aload_0
    //   120: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   123: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   126: getfield 558	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 290	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: iconst_1
    //   133: if_icmpne +217 -> 350
    //   136: iload_1
    //   137: ifeq +213 -> 350
    //   140: new 560	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   143: dup
    //   144: invokespecial 561	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: aload_0
    //   152: getfield 51	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   155: getfield 171	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   158: getfield 552	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: invokevirtual 564	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   164: invokevirtual 570	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   167: invokevirtual 574	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: pop
    //   171: new 576	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   174: dup
    //   175: invokespecial 577	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   178: astore_3
    //   179: aload_3
    //   180: aload 4
    //   182: invokestatic 582	apgk:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   185: aload_0
    //   186: ldc 137
    //   188: invokevirtual 122	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   191: checkcast 136	android/widget/LinearLayout
    //   194: astore 4
    //   196: aload_3
    //   197: ifnull +140 -> 337
    //   200: aload_3
    //   201: getfield 585	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   204: invokestatic 189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +130 -> 337
    //   210: aload 4
    //   212: ldc 229
    //   214: invokevirtual 232	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   217: aload_0
    //   218: getfield 543	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   221: iconst_0
    //   222: invokevirtual 275	android/view/View:setVisibility	(I)V
    //   225: aload_0
    //   226: getfield 548	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   229: iconst_0
    //   230: invokevirtual 586	com/tencent/image/URLImageView:setVisibility	(I)V
    //   233: aload_0
    //   234: invokevirtual 590	com/tencent/mobileqq/activity/AddRequestActivity:getResources	()Landroid/content/res/Resources;
    //   237: invokevirtual 596	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   240: getfield 601	android/util/DisplayMetrics:widthPixels	I
    //   243: aload_0
    //   244: ldc_w 602
    //   247: invokestatic 608	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   250: iconst_2
    //   251: imul
    //   252: isub
    //   253: istore_1
    //   254: iload_1
    //   255: sipush 600
    //   258: imul
    //   259: sipush 1000
    //   262: idiv
    //   263: istore_2
    //   264: aload_0
    //   265: getfield 548	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   268: invokevirtual 612	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   271: checkcast 614	android/widget/LinearLayout$LayoutParams
    //   274: astore 4
    //   276: aload 4
    //   278: iload_1
    //   279: putfield 617	android/widget/LinearLayout$LayoutParams:width	I
    //   282: aload 4
    //   284: iload_2
    //   285: putfield 620	android/widget/LinearLayout$LayoutParams:height	I
    //   288: aload_0
    //   289: getfield 548	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   292: aload 4
    //   294: invokevirtual 624	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   297: aload_3
    //   298: getfield 585	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 548	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   305: sipush 1000
    //   308: sipush 600
    //   311: invokestatic 629	aphs:a	(Ljava/lang/String;Lcom/tencent/image/URLImageView;II)V
    //   314: return
    //   315: astore_3
    //   316: aconst_null
    //   317: astore_3
    //   318: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +13 -> 334
    //   324: ldc_w 308
    //   327: iconst_2
    //   328: ldc_w 631
    //   331: invokestatic 531	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: goto -149 -> 185
    //   337: aload 4
    //   339: ldc 229
    //   341: invokevirtual 232	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   344: return
    //   345: astore 4
    //   347: goto -29 -> 318
    //   350: aconst_null
    //   351: astore_3
    //   352: goto -167 -> 185
    //   355: iconst_0
    //   356: istore_1
    //   357: goto -238 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	AddRequestActivity
    //   118	239	1	i	int
    //   263	22	2	j	int
    //   103	195	3	localObject1	Object
    //   315	1	3	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   317	35	3	localObject2	Object
    //   147	191	4	localObject3	Object
    //   345	1	4	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   149	179	315	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   179	185	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
      str = "(" + bddg.a(18, str) + ")";
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      i = (int)Layout.getDesiredWidth(this.jdField_c_of_type_AndroidWidgetTextView.getText(), this.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      j = (int)Layout.getDesiredWidth(this.jdField_b_of_type_AndroidWidgetTextView.getText(), this.jdField_b_of_type_AndroidWidgetTextView.getPaint());
      k = ViewUtils.getScreenWidth() - ViewUtils.dip2px(130.0F);
    } while (j + i <= k);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(k - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setMinWidth(i);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 0, getString(2131689589), null, getString(2131689588), false, getString(2131690620), getString(2131694201), new acqq(this), new acqr(this), new acqs(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      bcef.b(this.app, "dc00898", "", "", "0X800B083", "0X800B083", 0, 0, "", "", "", "");
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
    int i = getResources().getDimensionPixelSize(2131297218);
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
        this.jdField_c_of_type_JavaLangString = ContactUtils.getDiscussionNameCanNull(this.app, String.valueOf(this.jdField_b_of_type_Long));
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            localObject2 = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.jdField_f_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
          }
        }
      }
    } while (bftf.a(localObject2, paramTextView.getText().toString()));
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
            break label936;
          }
          localObject1 = Long.toString(l);
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        i = ((String)localObject2).indexOf((String)localObject3);
        j = ((String)localObject3).length();
        localSpannableString.setSpan(new acrb(this, 1, "Q.systemmsg.AddRequestActivity", TroopInfoActivity.a((String)localObject1, 101)), i, j + i, 33);
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
          localSpannableString.setSpan(new acrb(this, 2, "Q.systemmsg.AddRequestActivity", localBundle), i, j + i, 33);
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
              break label948;
            }
            localObject1 = Long.toString(l);
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
        {
          j = ((String)localObject2).indexOf((String)localObject3);
          k = ((String)localObject3).length();
          if (!((amsw)this.app.getManager(51)).b((String)localObject1)) {
            break label963;
          }
        }
      }
    }
    label936:
    label948:
    label963:
    for (int i = 1;; i = 25)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_profile_uin", (String)localObject1);
      ((Bundle)localObject2).putInt("key_profile_pa", i);
      ((Bundle)localObject2).putInt("key_profile_chatability", 1);
      localSpannableString.setSpan(new acrb(this, 3, "Q.systemmsg.AddRequestActivity", (Bundle)localObject2), j, j + k, 33);
      paramTextView.setClickable(true);
      paramTextView.setFocusable(true);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      paramTextView.setLinkTextColor(localResources.getColorStateList(2131167064));
      for (;;)
      {
        localObject1 = paramTextView.getText().toString();
        localObject2 = this.app;
        paramTextView = (TextView)localObject1;
        if (localObject1 == null) {
          paramTextView = "null";
        }
        bcef.b((QQAppInterface)localObject2, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", paramTextView, "");
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
        localObject1 = getString(2131693568);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        i = paramCard.age;
        localObject1 = "";
        if (i <= 0) {
          break label383;
        }
        localObject1 = i + getString(2131718743);
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
          localObject1 = getString(2131692108);
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
    ((FriendListHandler)this.app.getBusinessHandler(1)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    bjnw localbjnw = (bjnw)bjon.a(this, null);
    localbjnw.a(getString(2131690640), 3);
    localbjnw.a(new acqu(this, localbjnw));
    localbjnw.c(2131690620);
    localbjnw.show();
  }
  
  public void c()
  {
    bjnw localbjnw = (bjnw)bjon.a(this, null);
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getTag() instanceof String)) {}
    for (String str = (String)this.jdField_a_of_type_AndroidWidgetTextView.getTag();; str = getString(2131718192))
    {
      localbjnw.a(str);
      localbjnw.a(getString(2131718431), 3);
      localbjnw.a(new acqv(this, localbjnw));
      localbjnw.c(2131690620);
      localbjnw.show();
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
    long l = bcsy.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bcsy.a().a(Long.valueOf(l));
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
    super.setContentView(2131561475);
    Object localObject = findViewById(2131363691);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130838892);
    }
    localObject = (TextView)findViewById(2131371428);
    if ((paramBundle != null) && (!paramBundle.equals("")))
    {
      ((TextView)localObject).setText(paramBundle);
      ((TextView)localObject).setVisibility(0);
    }
    setTitle(str);
    a(true);
    d();
    this.jdField_a_of_type_Amov = ((amov)this.app.getBusinessHandler(2));
    if (this.jdField_b_of_type_Long != 0L) {
      addObserver(this.jdField_a_of_type_Amrc, true);
    }
    addObserver(this.jdField_a_of_type_Amwl);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Amsu);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_Amwl != null) {
      removeObserver(this.jdField_a_of_type_Amwl);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_Amsu != null) {
      removeObserver(this.jdField_a_of_type_Amsu);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      removeObserver(this.jdField_a_of_type_Amrc);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this)) {
      QQToast.a(this, getString(2131694062), 0).b(getTitleBarHeight());
    }
    label735:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = 0;
      int i = 0;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Int == -1011)
        {
          ((FriendListHandler)this.app.getBusinessHandler(1)).confirmContactFriend(0, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
          i = 1;
          label102:
          bcef.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
          if (this.jdField_a_of_type_JavaIoSerializable != null) {
            bcef.b(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
          }
          bcef.b(this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label735;
        }
        a(2131718142, 1000L, false);
        break;
        long l1 = bcsy.a().b();
        Object localObject1 = bcsy.a().a(Long.valueOf(l1));
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
            break label102;
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
        break label102;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          f();
          bcef.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
          if (this.jdField_a_of_type_JavaIoSerializable != null) {
            bcef.b(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
          }
          bcef.b(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
          i = j;
        }
        else
        {
          i = j;
          if (paramView.getId() == 2131371435)
          {
            i = j;
            if (QQBrowserActivity.a(1500L))
            {
              localObject1 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
              startActivity((Intent)localObject1);
              bcef.b(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230).setTitle(getString(2131690635)).setMessage(2131690633).setPositiveButton(2131690634, new acqm(this)).setNegativeButton(2131690600, new acra(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755826);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558434);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365552)).setText(2131690642);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */