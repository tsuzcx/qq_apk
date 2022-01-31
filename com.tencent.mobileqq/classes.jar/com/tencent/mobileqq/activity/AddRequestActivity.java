package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import rju;
import rjw;
import rjx;
import rjy;
import rjz;
import rka;
import rkb;
import rkf;
import rkg;
import rkh;
import rki;
import rkj;
import rkk;
import rkl;
import rkm;
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
  public Dialog a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rkj(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public TextView a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rjz(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new rkb(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rkm(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new rjy(this);
  public QQCustomDialog a;
  private Serializable jdField_a_of_type_JavaIoSerializable;
  public String a;
  public structmsg.StructMsg a;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  protected float b;
  private int jdField_b_of_type_Int;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new rkk(this);
  Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private int jdField_c_of_type_Int = 3999;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new rkl(this);
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = null;
  private final int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private long jdField_e_of_type_Long;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = "";
  
  public AddRequestActivity()
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void b(boolean paramBoolean)
  {
    int j = 0;
    a();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371515));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371516));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371517));
    TextView localTextView = (TextView)findViewById(2131371526);
    Object localObject2 = (LinearLayout)findViewById(2131371519);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131371525);
    ImageView localImageView = (ImageView)findViewById(2131362739);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362894));
    Object localObject3 = (TextView)findViewById(2131371520);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371528));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131368570));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131371521));
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    Object localObject4 = ((TextView)localObject3).getPaint();
    Object localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f = ((TextPaint)localObject1).measureText(this.jdField_d_of_type_JavaLangString);
    label382:
    int i;
    if (this.jdField_b_of_type_Float - f > 30.0F)
    {
      ((TextView)localObject3).setText(this.jdField_d_of_type_JavaLangString);
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.equals(""))) {
        break label583;
      }
      if ((this.jdField_e_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString.equals(""))) {
        break label560;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130838633);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      localTextView.setText(this.jdField_e_of_type_JavaLangString);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      localLinearLayout.setBackgroundResource(2130838630);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1458;
      }
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label744;
      }
      i = 0;
      label447:
      if (i >= ((List)localObject2).size()) {
        break label762;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get();
      if (i != 0) {
        break label704;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
    }
    for (;;)
    {
      i += 1;
      break label447;
      localObject2 = (LinearLayout)findViewById(2131371522);
      localObject1 = (TextView)findViewById(2131371523);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131371524));
      break;
      label560:
      ((LinearLayout)localObject2).setBackgroundResource(2130838630);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label382;
      label583:
      if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(""))) {
        break label382;
      }
      if ((this.jdField_e_of_type_JavaLangString != null) && (!this.jdField_e_of_type_JavaLangString.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        localTextView.setText(this.jdField_e_of_type_JavaLangString);
        if (localLinearLayout.getVisibility() != 0) {
          localLinearLayout.setVisibility(0);
        }
        localLinearLayout.setBackgroundResource(2130838630);
        break label382;
      }
      localObject3 = (ViewGroup)findViewById(2131371513);
      ((View)localObject3).setBackgroundResource(2130838623);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label382;
      label704:
      if (i == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
      }
    }
    label744:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    label762:
    localObject2 = (TextView)findViewById(2131370273);
    if ((this.jdField_c_of_type_Int == 3014) || (this.jdField_c_of_type_Int == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label800:
      ((TextView)findViewById(2131368576)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject2 = (TextView)findViewById(2131368575);
      localObject3 = (TextView)findViewById(2131368574);
      ((TextView)localObject3).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null))
      {
        if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) && (!"".equals(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get()))) {
          break label1489;
        }
        ((TextView)localObject3).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
      label940:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        label1037:
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371514));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          label1135:
          localObject2 = (FriendsManager)this.app.getManager(50);
          localObject3 = ((FriendsManager)localObject2).c(this.jdField_a_of_type_JavaLangString);
          if ((localObject3 == null) || (((Friends)localObject3).alias == null) || (((Friends)localObject3).alias.length() == 0))
          {
            localObject3 = this.app;
            localObject4 = this.app;
            ((FriendListHandler)((QQAppInterface)localObject3).a(1)).b(this.jdField_a_of_type_JavaLangString);
          }
          if (ProfileActivity.e(this.jdField_c_of_type_Int))
          {
            localObject2 = ((FriendsManager)localObject2).b(this.jdField_a_of_type_JavaLangString);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1593;
            }
            ThreadManager.post(new rkf(this), 5, null, true);
          }
          label1255:
          if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            break label1602;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
          label1276:
          if ((this.jdField_c_of_type_Int != 3007) && (this.jdField_c_of_type_Int != 3019) && (this.jdField_c_of_type_Int != 2007) && (this.jdField_c_of_type_Int != 4007))
          {
            i = j;
            if (this.jdField_c_of_type_Int != 2019) {}
          }
          else
          {
            localObject2 = (FriendsManager)this.app.getManager(50);
            if ((localObject2 == null) || (!((FriendsManager)localObject2).b(this.jdField_a_of_type_JavaLangString))) {
              break label1616;
            }
            i = j;
          }
          label1363:
          if (i == 0) {
            break label1621;
          }
          localObject2 = FaceDrawable.a(this.app, 200, this.jdField_a_of_type_JavaLangString, true);
          label1384:
          localImageView.setBackgroundDrawable((Drawable)localObject2);
          ((ViewGroup)findViewById(2131371513)).setOnClickListener(new rkg(this));
          ((TextView)localObject1).setText(StringUtil.a(this.jdField_d_of_type_JavaLangString));
          if (this.jdField_b_of_type_Int != 2) {
            break label1638;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      label1458:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      ((TextView)localObject2).setVisibility(8);
      break label800;
      label1489:
      if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() != 1)) {
        break label940;
      }
      ((TextView)localObject3).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      break label940;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      break label1037;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      break label1037;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      ThreadManager.post(new rju(this), 5, null, true);
      break label1135;
      label1593:
      this.jdField_b_of_type_JavaLangString = ((String)localObject2);
      break label1255;
      label1602:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      break label1276;
      label1616:
      i = 1;
      break label1363;
      label1621:
      localObject2 = FaceDrawable.a(this.app, 1, this.jdField_a_of_type_JavaLangString);
      break label1384;
      label1638:
      if ((this.jdField_d_of_type_JavaLangString == null) || ("".equals(this.jdField_d_of_type_JavaLangString))) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc_w 381
    //   5: invokevirtual 124	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   8: putfield 383	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   11: aload_0
    //   12: aload_0
    //   13: ldc_w 384
    //   16: invokevirtual 124	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   19: checkcast 386	com/tencent/image/URLImageView
    //   22: putfield 388	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   25: aload_0
    //   26: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   29: ifnull +321 -> 350
    //   32: aload_0
    //   33: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   36: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   39: getfield 392	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   42: invokevirtual 395	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   45: ifeq +305 -> 350
    //   48: aload_0
    //   49: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   52: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   55: getfield 398	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 399	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   61: ifeq +289 -> 350
    //   64: aload_0
    //   65: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   68: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   71: ifnull +284 -> 355
    //   74: aload_0
    //   75: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   78: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   81: getfield 236	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: ifnull +268 -> 355
    //   90: aload_0
    //   91: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   94: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   97: getfield 236	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   100: invokevirtual 241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +250 -> 355
    //   108: aload_3
    //   109: invokeinterface 246 1 0
    //   114: ifle +241 -> 355
    //   117: iconst_1
    //   118: istore_1
    //   119: aload_0
    //   120: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   123: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   126: getfield 398	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: iconst_1
    //   133: if_icmpne +217 -> 350
    //   136: iload_1
    //   137: ifeq +213 -> 350
    //   140: new 401	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   143: dup
    //   144: invokespecial 402	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: aload_0
    //   152: getfield 49	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   155: getfield 163	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   158: getfield 392	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: invokevirtual 405	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   164: invokevirtual 411	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   167: invokevirtual 415	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: pop
    //   171: new 417	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   174: dup
    //   175: invokespecial 418	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   178: astore_3
    //   179: aload_3
    //   180: aload 4
    //   182: invokestatic 423	com/tencent/mobileqq/businessCard/BusinessCardServlet:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   185: aload_0
    //   186: ldc 139
    //   188: invokevirtual 124	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   191: checkcast 138	android/widget/LinearLayout
    //   194: astore 4
    //   196: aload_3
    //   197: ifnull +140 -> 337
    //   200: aload_3
    //   201: getfield 426	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   204: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +130 -> 337
    //   210: aload 4
    //   212: ldc 224
    //   214: invokevirtual 227	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   217: aload_0
    //   218: getfield 383	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   221: iconst_0
    //   222: invokevirtual 267	android/view/View:setVisibility	(I)V
    //   225: aload_0
    //   226: getfield 388	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   229: iconst_0
    //   230: invokevirtual 427	com/tencent/image/URLImageView:setVisibility	(I)V
    //   233: aload_0
    //   234: invokevirtual 431	com/tencent/mobileqq/activity/AddRequestActivity:getResources	()Landroid/content/res/Resources;
    //   237: invokevirtual 437	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   240: getfield 442	android/util/DisplayMetrics:widthPixels	I
    //   243: aload_0
    //   244: ldc_w 443
    //   247: invokestatic 448	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
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
    //   265: getfield 388	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   268: invokevirtual 452	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   271: checkcast 454	android/widget/LinearLayout$LayoutParams
    //   274: astore 4
    //   276: aload 4
    //   278: iload_1
    //   279: putfield 457	android/widget/LinearLayout$LayoutParams:width	I
    //   282: aload 4
    //   284: iload_2
    //   285: putfield 460	android/widget/LinearLayout$LayoutParams:height	I
    //   288: aload_0
    //   289: getfield 388	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   292: aload 4
    //   294: invokevirtual 464	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   297: aload_3
    //   298: getfield 426	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 388	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   305: sipush 1000
    //   308: sipush 600
    //   311: invokestatic 469	com/tencent/mobileqq/businessCard/utilities/BusinessCardUtils:a	(Ljava/lang/String;Lcom/tencent/image/URLImageView;II)V
    //   314: return
    //   315: astore_3
    //   316: aconst_null
    //   317: astore_3
    //   318: invokestatic 474	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +13 -> 334
    //   324: ldc_w 476
    //   327: iconst_2
    //   328: ldc_w 478
    //   331: invokestatic 481	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: goto -149 -> 185
    //   337: aload 4
    //   339: ldc 232
    //   341: invokevirtual 227	android/widget/LinearLayout:setBackgroundResource	(I)V
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
  
  public void a()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131558575);
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
  
  public void a(Card paramCard)
  {
    if (paramCard != null)
    {
      int j = -1;
      localObject1 = "";
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
        localObject1 = getString(2131433941);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        i = paramCard.age;
        localObject1 = "";
        if (i <= 0) {
          break label383;
        }
        localObject1 = i + getString(2131433943);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label115:
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
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
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (this.jdField_a_of_type_JavaIoSerializable != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
          localObject1 = getString(2131433942);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label383:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label115;
      }
    }
    paramCard = this.app;
    Object localObject1 = this.app;
    ((FriendListHandler)paramCard.a(1)).b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    runOnUiThread(new rka(this));
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131433452), 3);
    localActionSheet.a(new rkh(this, localActionSheet));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  public void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131434716));
    localActionSheet.a(getString(2131434714), 3);
    localActionSheet.a(new rki(this, localActionSheet));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Long != 0L) {
      this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.app, String.valueOf(this.jdField_b_of_type_Long));
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
      this.jdField_e_of_type_JavaLangString = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
    }
    TextView localTextView = (TextView)findViewById(2131371526);
    if ((localTextView != null) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_e_of_type_JavaLangString.equals(localTextView.getText()))) {
      localTextView.setText(this.jdField_e_of_type_JavaLangString);
    }
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
    long l = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l));
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("infouin");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("verify_msg");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("msg_source");
    this.jdField_c_of_type_Int = getIntent().getIntExtra("msg_source_id", 3041);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get() == 8))
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
      if (this.jdField_b_of_type_Long != 0L) {
        this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.app, String.valueOf(this.jdField_b_of_type_Long));
      }
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      }
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
    super.setContentView(2130970634);
    setContentBackgroundResource(2130838214);
    TextView localTextView = (TextView)findViewById(2131371529);
    if ((paramBundle != null) && (!paramBundle.equals("")))
    {
      localTextView.setText(paramBundle);
      localTextView.setVisibility(0);
    }
    setTitle(str);
    b(true);
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    if (this.jdField_b_of_type_Long != 0L) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
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
      QQToast.a(this, getString(2131433213), 0).b(getTitleBarHeight());
    }
    label841:
    for (;;)
    {
      return;
      int j = 0;
      int i;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Int == -1011)
        {
          ((FriendListHandler)this.app.a(1)).a(0, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
          i = 1;
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
          j = i;
          if (this.jdField_a_of_type_JavaIoSerializable != null)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
            j = i;
          }
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label841;
        }
        a(2131434453, 1000L, false);
        return;
        long l1 = FriendSystemMsgController.a().b();
        paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
        long l2;
        int k;
        int m;
        int n;
        Object localObject;
        if (paramView != null)
        {
          i = paramView.msg_type.get();
          l1 = paramView.msg_seq.get();
          l2 = paramView.req_uin.get();
          j = paramView.msg.sub_type.get();
          k = paramView.msg.src_id.get();
          m = paramView.msg.sub_src_id.get();
          n = paramView.msg.group_msg_type.get();
          localObject = paramView.msg.actions.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
            this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
            i = 1;
            break;
          }
          paramView = new StringBuilder().append("agree, ");
          if (localObject != null) {}
          for (i = ((List)localObject).size();; i = -1)
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
        i = 0;
        break;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          l1 = FriendSystemMsgController.a().b();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            paramView = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((paramView != null) && (1 < paramView.size()))
            {
              this.app.a().a().a(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
              i = 1;
            }
          }
          for (;;)
          {
            ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
            j = i;
            if (this.jdField_a_of_type_JavaIoSerializable == null) {
              break;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
            j = i;
            break;
            localObject = new StringBuilder().append("refuse, ");
            if (paramView != null) {}
            for (i = paramView.size();; i = -1)
            {
              QLog.d("Q.systemmsg.AddRequestActivity", 1, i);
              i = j;
              break;
            }
            QLog.d("Q.systemmsg.AddRequestActivity", 1, "refuse");
            i = 0;
          }
        }
        j = 0;
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131433454)).setMessage(2131433455).setPositiveButton(2131433456, new rjx(this)).setNegativeButton(2131433699, new rjw(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968595);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362776)).setText(2131433471);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */