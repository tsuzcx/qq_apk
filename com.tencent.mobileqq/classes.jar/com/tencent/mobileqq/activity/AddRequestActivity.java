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
  DiscussionObserver A = new AddRequestActivity.14(this);
  private long B;
  private long C;
  private String D = "";
  private String E = "";
  private int F;
  private int G = 3999;
  private long H;
  private Serializable I;
  private final int J = 0;
  private TextView K;
  private TextView L;
  private TextView M;
  private TextView N;
  private QQCustomDialog O;
  private boolean P;
  private boolean Q = false;
  private FriendListObserver R = new AddRequestActivity.9(this);
  private MessageObserver S = new AddRequestActivity.12(this);
  private boolean T = false;
  String a;
  Button b;
  Button c;
  Button d;
  TextView e;
  QQCustomDialog f;
  Dialog g;
  CardHandler h;
  int i;
  byte[] j;
  public long k;
  public String l;
  TextView m;
  TextView n;
  View o;
  URLImageView p;
  structmsg.StructMsg q = null;
  long r = 0L;
  String s = null;
  String t = null;
  protected float u;
  protected float v;
  View.OnClickListener w = new AddRequestActivity.6(this);
  View.OnClickListener x = new AddRequestActivity.7(this);
  View.OnClickListener y = new AddRequestActivity.8(this);
  CardObserver z = new AddRequestActivity.13(this);
  
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
        Object localObject = (TextView)paramLinearLayout.findViewById(2131442080);
        ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131442079);
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
    this.K = ((TextView)findViewById(2131430095));
    this.L = ((TextView)findViewById(2131430093));
    this.M = ((TextView)findViewById(2131430094));
    Object localObject6 = (TextView)findViewById(2131438946);
    Object localObject2 = (LinearLayout)findViewById(2131449365);
    Object localObject5 = (LinearLayout)findViewById(2131438947);
    ImageView localImageView = (ImageView)findViewById(2131432714);
    this.m = ((TextView)findViewById(2131439320));
    this.n = ((TextView)findViewById(2131439301));
    Object localObject3 = (TextView)findViewById(2131449373);
    this.b = ((Button)findViewById(2131427912));
    this.c = ((Button)findViewById(2131444568));
    this.d = ((Button)findViewById(2131444657));
    this.e = ((TextView)findViewById(2131445841));
    this.e.setOnClickListener(this.x);
    Object localObject1 = this.q;
    if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null) && (TextUtils.isEmpty(this.q.msg.msg_additional.get()))) {
      this.D = this.q.msg.msg_describe.get();
    }
    Object localObject4 = ((TextView)localObject3).getPaint();
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.D);
    float f2 = this.v;
    int i2 = 0;
    if (f2 - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.D);
      localObject1 = localObject3;
      paramBoolean = true;
    }
    else
    {
      localObject2 = (LinearLayout)findViewById(2131449364);
      localObject1 = (TextView)findViewById(2131449363);
      this.d = ((Button)findViewById(2131444637));
      paramBoolean = false;
    }
    ((LinearLayout)localObject2).setVisibility(0);
    this.d.setOnClickListener(this.y);
    localObject3 = this.D;
    if ((localObject3 != null) && (!((String)localObject3).equals("")))
    {
      localObject3 = this.E;
      if ((localObject3 != null) && (!((String)localObject3).equals("")))
      {
        ((LinearLayout)localObject2).setBackgroundResource(2130839637);
        if (((LinearLayout)localObject2).getVisibility() != 0) {
          ((LinearLayout)localObject2).setVisibility(0);
        }
        a((TextView)localObject6);
        if (((LinearLayout)localObject5).getVisibility() != 0) {
          ((LinearLayout)localObject5).setVisibility(0);
        }
        ((LinearLayout)localObject5).setBackgroundResource(2130839637);
      }
      else
      {
        ((LinearLayout)localObject2).setBackgroundResource(2130839577);
        ((LinearLayout)localObject2).setVisibility(0);
        ((LinearLayout)localObject5).setVisibility(8);
      }
    }
    else
    {
      localObject3 = this.D;
      if ((localObject3 == null) || (((String)localObject3).equals("")))
      {
        localObject3 = this.E;
        if ((localObject3 != null) && (!((String)localObject3).equals("")))
        {
          ((LinearLayout)localObject2).setVisibility(8);
          a((TextView)localObject6);
          if (((LinearLayout)localObject5).getVisibility() != 0) {
            ((LinearLayout)localObject5).setVisibility(0);
          }
          ((LinearLayout)localObject5).setBackgroundResource(2130839577);
        }
        else
        {
          localObject3 = (ViewGroup)findViewById(2131430096);
          ((View)localObject3).setBackgroundResource(2130839622);
          ((View)localObject3).setVisibility(0);
          ((LinearLayout)localObject2).setVisibility(8);
          ((LinearLayout)localObject5).setVisibility(8);
        }
      }
    }
    localObject2 = new FrdSysMsg.AddtionInfo();
    try
    {
      if ((this.q == null) || (this.q.msg == null) || (!this.q.msg.has()) || (this.q.msg.bytes_addtion == null) || (!this.q.msg.bytes_addtion.has())) {
        break label802;
      }
      ((FrdSysMsg.AddtionInfo)localObject2).mergeFrom(this.q.msg.bytes_addtion.get().toByteArray());
      localObject3 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_category.get();
      localObject4 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_name.get();
      localObject5 = ((FrdSysMsg.AddtionInfo)localObject2).str_entity_url.get();
      if (this.Q != true) {
        break label2241;
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
    localLinearLayout = (LinearLayout)findViewById(2131438941);
    try
    {
      a((QQAppInterface)localObject6, this, localLinearLayout, "Q.systemmsg.AddRequestActivity", (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject2, "1");
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      label799:
      int i1;
      int i3;
      break label799;
    }
    break label805;
    label802:
    break label821;
    label805:
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.AddRequestActivity", 2, "decode FrdSysMsg.AddtionInfo failed!");
    }
    label821:
    localObject2 = this.q;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg != null) && (this.q.msg.actions.get() != null))
    {
      localObject2 = this.q.msg.actions.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
          if (i1 == 0)
          {
            this.b.setVisibility(0);
            this.b.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
          }
          else if (i1 == 1)
          {
            this.c.setVisibility(0);
            this.c.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
          }
          i1 += 1;
        }
      }
      else
      {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
      }
    }
    else
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    localObject2 = (TextView)findViewById(2131447416);
    i1 = this.G;
    if ((i1 != 3014) && (i1 != 2014)) {
      ((TextView)localObject2).setVisibility(8);
    } else {
      ((TextView)localObject2).setVisibility(0);
    }
    localObject2 = (TextView)findViewById(2131438924);
    localObject3 = this.q;
    if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg != null) && (this.q.msg.uint32_source_flag.has())) {
      i1 = this.q.msg.uint32_source_flag.get();
    } else {
      i1 = 0;
    }
    if ((i1 & 0x20) == 32)
    {
      this.Q = true;
      ((TextView)localObject2).setText(2131886146);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setOnClickListener(this);
      ReportController.b(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
    }
    QLog.d("Q.systemmsg.AddRequestActivity", 1, new Object[] { "uint32_source_flag=", Integer.valueOf(i1) });
    ((TextView)findViewById(2131427491)).setOnClickListener(this.w);
    localObject2 = (TextView)findViewById(2131427490);
    QLog.isColorLevel();
    localObject3 = this.q;
    if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg.has()) && (this.q.msg.get() != null) && (this.q.msg.actions.has()) && (this.q.msg.actions.get() != null) && (this.q.msg.actions.get().size() > 1) && (this.q.msg.friend_info.has()) && (this.q.msg.friend_info.msg_blacklist.has()) && (this.q.msg.friend_info.msg_blacklist.get().length() > 0) && (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.a)))
    {
      this.e.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      this.e.setTag(this.q.msg.friend_info.msg_blacklist.get());
      ReportController.b(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0)
    {
      this.e.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject2 = this.q;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg.has())) {
      switch (this.q.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.d.setVisibility(8);
        break;
      case 6: 
      case 7: 
      case 8: 
        this.d.setVisibility(8);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 9: 
      case 10: 
        this.d.setVisibility(0);
      }
    }
    this.N = ((TextView)findViewById(2131431171));
    localObject2 = this.q;
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg != null) && (this.q.msg.friend_info.has()) && (this.q.msg.friend_info.msg_joint_friend.has() == true))
    {
      this.N.setText(this.q.msg.friend_info.msg_joint_friend.get());
      this.N.setVisibility(0);
    }
    else
    {
      this.N.setVisibility(8);
      ThreadManager.post(new AddRequestActivity.1(this), 5, null, true);
    }
    localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.a);
    if ((localObject2 == null) || (((Friends)localObject2).alias == null) || (((Friends)localObject2).alias.length() == 0)) {
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.a);
    }
    e();
    i3 = this.G;
    if ((i3 != 3007) && (i3 != 3019) && (i3 != 2007) && (i3 != 4007))
    {
      i1 = i2;
      if (i3 != 2019) {}
    }
    else
    {
      localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject2 != null) && (((FriendsManager)localObject2).n(this.a))) {
        i1 = i2;
      } else {
        i1 = 1;
      }
    }
    if (i1 != 0) {
      localObject2 = FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.a, true);
    } else {
      localObject2 = FaceDrawable.getFaceDrawable(this.app, 1, this.a);
    }
    localImageView.setBackgroundDrawable((Drawable)localObject2);
    ((ViewGroup)findViewById(2131430096)).setOnClickListener(new AddRequestActivity.2(this));
    ((TextView)localObject1).setText(StringUtil.trimUnreadableInFriendRequest(this.D));
    if (this.F == 2)
    {
      this.c.setVisibility(8);
    }
    else
    {
      localObject2 = this.D;
      if ((localObject2 == null) || ("".equals(localObject2))) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    b(paramBoolean);
    if (this.b.getVisibility() == 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X800AA40", "0X800AA40", 0, 0, "", "", "", "");
    }
    if (this.c.getVisibility() == 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X800AD03", "0X800AD03", 0, 0, "", "", "", "");
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.q;
    if ((localObject != null) && (((structmsg.StructMsg)localObject).msg != null) && (!TextUtils.isEmpty(this.q.msg.msg_additional.get())))
    {
      if (paramBoolean) {
        localObject = (TextView)findViewById(2131449374);
      } else {
        localObject = (TextView)findViewById(2131449366);
      }
      ((TextView)localObject).setText(2131890934);
    }
  }
  
  private boolean c(boolean paramBoolean)
  {
    long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    this.q = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    Object localObject = this.q;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      l1 = this.q.msg_seq.get();
      long l2 = this.q.req_uin.get();
      int i2 = this.q.msg.sub_type.get();
      int i3 = this.q.msg.src_id.get();
      int i4 = this.q.msg.sub_src_id.get();
      int i5 = this.q.msg.group_msg_type.get();
      localObject = this.q.msg.actions.get();
      if ((localObject != null) && (((List)localObject).size() >= 1))
      {
        localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(1)).action_info.get();
        if (paramBoolean) {
          ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(true);
        }
        this.app.getMsgHandler().B().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject, 1, null, false);
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
  
  private void d()
  {
    this.o = findViewById(2131445893);
    this.p = ((URLImageView)findViewById(2131430101));
    structmsg.StructMsg localStructMsg = this.q;
    Oidb_0x43c.CardInfo localCardInfo = null;
    Object localObject2 = null;
    Object localObject1 = localCardInfo;
    int i1;
    if (localStructMsg != null)
    {
      localObject1 = localCardInfo;
      if (localStructMsg.msg.req_uin_business_card.has())
      {
        localObject1 = localCardInfo;
        if (this.q.msg.card_switch.has())
        {
          if ((this.q.msg != null) && (this.q.msg.actions.get() != null))
          {
            localObject1 = this.q.msg.actions.get();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              i1 = 1;
              break label141;
            }
          }
          i1 = 0;
          label141:
          localObject1 = localCardInfo;
          if (this.q.msg.card_switch.get() == 1)
          {
            localObject1 = localCardInfo;
            if (i1 != 0) {
              localCardInfo = new Oidb_0x43c.CardInfo();
            }
          }
        }
      }
    }
    try
    {
      localCardInfo.mergeFrom(this.q.msg.req_uin_business_card.get().toByteArray());
      localObject1 = new BusinessCard();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      label216:
      label222:
      int i2;
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
    localObject2 = (LinearLayout)findViewById(2131438947);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((BusinessCard)localObject1).picUrl)))
    {
      ((LinearLayout)localObject2).setBackgroundResource(2130839637);
      this.o.setVisibility(0);
      this.p.setVisibility(0);
      i1 = getResources().getDisplayMetrics().widthPixels - DisplayUtil.a(this, 15.0F) * 2;
      i2 = i1 * 600 / 1000;
      localObject2 = (LinearLayout.LayoutParams)this.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = i1;
      ((LinearLayout.LayoutParams)localObject2).height = i2;
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      BusinessCardUtils.a(((BusinessCard)localObject1).picUrl, this.p, 1000, 600);
      return;
    }
    ((LinearLayout)localObject2).setBackgroundResource(2130839637);
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.l)) {
      this.m.setText(this.l);
    } else {
      this.m.setText(this.a);
    }
    String str;
    if (!TextUtils.isEmpty(this.t)) {
      str = this.t;
    } else {
      str = this.a;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, "0")))
    {
      this.n.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(TogetherUtils.a(18, str));
      localStringBuilder.append(")");
      str = localStringBuilder.toString();
      this.n.setText(str);
      int i1 = (int)Layout.getDesiredWidth(this.n.getText(), this.n.getPaint());
      int i2 = (int)Layout.getDesiredWidth(this.m.getText(), this.m.getPaint());
      int i3 = ViewUtils.getScreenWidth() - ViewUtils.dip2px(130.0F);
      if (i2 + i1 > i3)
      {
        this.m.setMaxWidth(i3 - i1);
        this.n.setMinWidth(i1);
      }
    }
    else
    {
      this.n.setVisibility(8);
    }
  }
  
  private void f()
  {
    if (this.O == null) {
      this.O = DialogUtil.a(this, 0, getString(2131886239), null, getString(2131886238), false, getString(2131887648), getString(2131892267), new AddRequestActivity.15(this), new AddRequestActivity.16(this), new AddRequestActivity.17(this));
    }
    if (!this.O.isShowing()) {
      try
      {
        this.O.show();
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
    this.u = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = getResources().getDimensionPixelSize(2131297664);
    this.v = (this.u - i1 * 1 - this.mDensity * 175.0F);
  }
  
  protected void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setSingleLine(false);
    Resources localResources = paramTextView.getContext().getResources();
    Object localObject1 = this.E;
    Object localObject2 = localObject1;
    if (this.r != 0L)
    {
      this.s = ContactUtils.b(this.app, String.valueOf(this.r));
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.s))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.E)) {
          localObject2 = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.E, this.s });
        }
      }
    }
    if (Utils.a(localObject2, paramTextView.getText().toString())) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
      localObject1 = this.q;
      Object localObject4;
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null))
      {
        localObject3 = this.q.msg.group_name.get();
        l1 = this.q.msg.group_code.get();
        localObject1 = localObject3;
        if (l1 != 0L)
        {
          localObject4 = Long.toString(l1);
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
      int i1;
      int i2;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject2).contains((CharSequence)localObject1)))
      {
        i1 = ((String)localObject2).indexOf((String)localObject1);
        i2 = ((String)localObject1).length();
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 1, "Q.systemmsg.AddRequestActivity", TroopInfoUIUtil.a((String)localObject3, 101)), i1, i1 + i2, 33);
        localObject4 = this.q;
        if ((localObject4 != null) && (((structmsg.StructMsg)localObject4).msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(1), localObject1, localObject3, Integer.valueOf(this.q.msg.src_id.get()), Integer.valueOf(this.q.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject3 = this.s;
      long l1 = this.r;
      if (l1 != 0L) {
        localObject1 = Long.toString(l1);
      } else {
        localObject1 = null;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        i1 = ((String)localObject2).indexOf((String)localObject3);
        i2 = ((String)localObject3).length();
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("uin", (String)localObject1);
        ((Bundle)localObject4).putString("uinname", this.s);
        ((Bundle)localObject4).putInt("uintype", 3000);
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 2, "Q.systemmsg.AddRequestActivity", (Bundle)localObject4), i1, i2 + i1, 33);
        localObject4 = this.q;
        if ((localObject4 != null) && (((structmsg.StructMsg)localObject4).msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(2), localObject3, localObject1, Integer.valueOf(this.q.msg.src_id.get()), Integer.valueOf(this.q.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject1 = this.q;
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg != null))
      {
        localObject3 = this.q.msg.action_uin_nick.get();
        l1 = this.q.msg.action_uin.get();
        if (l1 != 0L) {
          localObject1 = Long.toString(l1);
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
        i2 = ((String)localObject2).indexOf((String)localObject3);
        int i3 = ((String)localObject3).length();
        i1 = 25;
        if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n((String)localObject1)) {
          i1 = 1;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_profile_uin", (String)localObject1);
        ((Bundle)localObject2).putInt("key_profile_pa", i1);
        ((Bundle)localObject2).putInt("key_profile_chatability", 1);
        localSpannableString.setSpan(new AddRequestActivity.ClickJumpSpan(this, 3, "Q.systemmsg.AddRequestActivity", (Bundle)localObject2), i2, i3 + i2, 33);
      }
      paramTextView.setClickable(true);
      paramTextView.setFocusable(true);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      paramTextView.setLinkTextColor(localResources.getColorStateList(2131168078));
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
      int i2 = -1;
      boolean bool = true;
      int i1 = i2;
      if (paramCard != null) {
        if (paramCard.shGender != 0)
        {
          i1 = i2;
          if (paramCard.shGender != 1) {}
        }
        else
        {
          i1 = paramCard.shGender;
        }
      }
      Object localObject1;
      if (i1 == 0)
      {
        localObject1 = getString(2131891484);
        this.K.setVisibility(0);
      }
      else if (i1 == 1)
      {
        localObject1 = getString(2131889246);
        this.K.setVisibility(0);
      }
      else
      {
        this.K.setVisibility(8);
        localObject1 = "";
      }
      this.K.setText((CharSequence)localObject1);
      i1 = paramCard.age;
      if (i1 > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(getString(2131916946));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.L.setVisibility(0);
      }
      else
      {
        this.L.setVisibility(8);
        localObject1 = "";
      }
      this.L.setText((CharSequence)localObject1);
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
      this.M.setText((CharSequence)localObject2);
      if (this.I != null)
      {
        this.L.setVisibility(8);
        this.M.setVisibility(8);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("age:");
        ((StringBuilder)localObject1).append(paramCard.age);
        ((StringBuilder)localObject1).append("gender:");
        ((StringBuilder)localObject1).append(paramCard.shGender);
        ((StringBuilder)localObject1).append(",isFromWzry=");
        ((StringBuilder)localObject1).append(this.I);
        if (((StringBuilder)localObject1).toString() == null) {
          bool = false;
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 2, new Object[] { Boolean.valueOf(bool) });
      }
    }
    else
    {
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.a);
    }
  }
  
  void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addButton(getString(2131887669), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestActivity.4(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    String str;
    if ((this.e.getTag() instanceof String)) {
      str = (String)this.e.getTag();
    } else {
      str = getString(2131916327);
    }
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131916596), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestActivity.5(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
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
    long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    this.q = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    this.B = getIntent().getLongExtra("infoid", 0L);
    this.a = getIntent().getStringExtra("infouin");
    this.C = getIntent().getLongExtra("infotime", 0L);
    this.D = getIntent().getStringExtra("verify_msg");
    this.F = getIntent().getIntExtra("verify_type", 1);
    this.E = getIntent().getStringExtra("msg_source");
    this.G = getIntent().getIntExtra("msg_source_id", 3041);
    paramBundle = this.q;
    if ((paramBundle != null) && (paramBundle.msg != null) && (this.q.msg.uint32_source_flag.get() == 8)) {
      this.r = this.q.msg.uint64_discuss_uin.get();
    }
    paramBundle = this.q;
    if ((paramBundle != null) && (paramBundle.msg != null) && (this.q.msg.bytes_name_more.has())) {
      this.t = new String(this.q.msg.bytes_name_more.get().toByteArray());
    }
    this.i = getIntent().getIntExtra("msg_type", -1006);
    this.j = getIntent().getByteArrayExtra("sig");
    this.k = getIntent().getLongExtra("lToMobile", 0L);
    this.l = getIntent().getStringExtra("strNickName");
    paramBundle = getIntent().getStringExtra("info_dealwith_msg");
    this.H = getIntent().getLongExtra("msg_troopuin", 0L);
    String str = getIntent().getStringExtra("msg_title");
    if (getIntent().hasExtra("param_wzry_data")) {
      this.I = getIntent().getSerializableExtra("param_wzry_data");
    }
    super.setContentView(2131627866);
    Object localObject = findViewById(2131429719);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130838959);
    }
    localObject = (TextView)findViewById(2131438920);
    if ((paramBundle != null) && (!paramBundle.equals("")))
    {
      ((TextView)localObject).setText(paramBundle);
      ((TextView)localObject).setVisibility(0);
    }
    setTitle(str);
    a(true);
    d();
    this.h = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    if (this.r != 0L) {
      addObserver(this.A, true);
    }
    addObserver(this.S);
    addObserver(this.z);
    addObserver(this.R);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    Object localObject = this.S;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.z;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.R;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.r != 0L) {
      removeObserver(this.A);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, getString(2131892102), 0).show(getTitleBarHeight());
    }
    else
    {
      int i1;
      Object localObject1;
      if (paramView == this.b)
      {
        int i2 = this.i;
        i1 = 1;
        if (i2 == -1011)
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).confirmContactFriend(0, Long.parseLong(this.a), this.k, this.j, (byte)0, this.l, this.C, this.B);
          i1 = 1;
        }
        else
        {
          long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
          localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
          if (localObject1 != null)
          {
            i2 = ((structmsg.StructMsg)localObject1).msg_type.get();
            l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
            long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
            int i3 = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
            int i4 = ((structmsg.StructMsg)localObject1).msg.src_id.get();
            int i5 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
            int i6 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
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
              this.app.getMsgHandler().B().a(i2, l1, l2, i3, i4, i5, i6, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("agree, ");
              if (localObject2 != null) {
                i1 = ((List)localObject2).size();
              } else {
                i1 = -1;
              }
              ((StringBuilder)localObject1).append(i1);
              QLog.d("Q.systemmsg.AddRequestActivity", 1, ((StringBuilder)localObject1).toString());
              i1 = 0;
            }
          }
          else
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
            i1 = 0;
          }
        }
        ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
        if (this.I != null) {
          ReportController.b(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
      }
      else
      {
        if (paramView == this.c)
        {
          f();
          ReportController.b(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
          if (this.I != null) {
            ReportController.b(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
          }
          ReportController.b(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
        }
        else if ((paramView.getId() == 2131438924) && (WebViewComUtils.a(1500L)))
        {
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
          startActivity((Intent)localObject1);
          ReportController.b(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
        }
        i1 = 0;
      }
      if (i1 != 0) {
        showProgressDialog(2131916272, 1000L, false);
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
      this.g = new ReportDialog(this, 2131953338);
      this.g.setContentView(2131623999);
      ((TextView)this.g.findViewById(2131431876)).setText(2131887671);
      return this.g;
    }
    this.f = DialogUtil.a(this, 230).setTitle(getString(2131887664)).setMessage(2131887662).setPositiveButton(2131887663, new AddRequestActivity.11(this)).setNegativeButton(2131887626, new AddRequestActivity.10(this));
    return this.f;
  }
  
  protected void showToast(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.makeText(this, paramString, 0).show(getTitleBarHeight());
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */