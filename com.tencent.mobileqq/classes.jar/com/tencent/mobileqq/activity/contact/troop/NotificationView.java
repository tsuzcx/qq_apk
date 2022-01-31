package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import wpt;
import wpu;
import wpv;
import wpw;
import wpx;
import wpy;
import wpz;
import wqa;
import wqb;

public class NotificationView
  extends BaseTroopView
  implements View.OnClickListener, BaseSystemMsgInterface, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener
{
  protected static int b;
  protected static long c;
  public final long a;
  public Context a;
  protected View.OnClickListener a;
  protected View.OnTouchListener a;
  public NotificationAdapter a;
  public TroopNotificationUtils.TroopPrivilegeCallback a;
  MessageObserver a;
  protected FaceDecoder a;
  public QQProgressDialog a;
  protected SlideDetectListView a;
  public List a;
  public MqqHandler a;
  public final long b;
  protected View.OnClickListener b;
  protected int c;
  protected boolean c;
  protected int d;
  public boolean d;
  public View e;
  protected View f;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public NotificationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new wpt(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wpu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wpv(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new wpw(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new wpz(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new wqb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    TroopBindPubAccountProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new wqa(this), localBundle);
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramViewHolder == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramViewHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((DiscussionManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    NotificationAdapter.ViewHolder localViewHolder;
    String str;
    if (this.jdField_c_of_type_Int == 0)
    {
      int j = paramXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localViewHolder = (NotificationAdapter.ViewHolder)paramXListView.getChildAt(i).getTag();
        if (localViewHolder == null) {
          i += 1;
        } else {
          switch (TroopNotificationUtils.a(localViewHolder.jdField_a_of_type_Int))
          {
          default: 
            str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localViewHolder != null) && (paramString.equals(str)))
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      str = localViewHolder.jdField_a_of_type_JavaLangString;
      continue;
      str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(l);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(0, paramBoolean);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int k;
    int m;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      k = paramStructMsg.msg.src_id.get();
      m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label220;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label220:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private boolean a(List paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((Stranger)paramList.next()).uin, paramString));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder)
  {
    int i = 1;
    if (paramViewHolder == null) {
      return;
    }
    Object localObject;
    String str;
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131430145);
    }
    for (;;)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, (String)localObject, i);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramViewHolder.jdField_a_of_type_JavaLangString;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131430146);
      continue;
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131430147);
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + paramViewHolder.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramViewHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramViewHolder.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void k()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void l()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void m()
  {
    a(2130969461);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131366601));
    this.e = findViewById(2131366602);
    o();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void n()
  {
    int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = new NotificationAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.L, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDividerHeight(1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(this.jdField_a_of_type_JavaUtilList);
    i();
  }
  
  private void o()
  {
    if (this.f == null) {
      this.f = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970651, null);
    }
    if (this.f.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addFooterView(this.f);
    }
    this.f.setVisibility(8);
  }
  
  private void p()
  {
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433023), 0).b(a());
          return;
        }
      } while (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.jdField_d_of_type_Boolean = true;
      this.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().f();
    } while (!QLog.isColorLevel());
    QLog.i("NotificationView", 2, "loadNextPage.get next page.");
  }
  
  private void q()
  {
    if (this.f != null) {
      this.f.setVisibility(8);
    }
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "stopLoadMore().");
    }
  }
  
  private void r()
  {
    ThreadManager.post(new wpx(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "sendReadConfirm is end!");
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131558448);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
      r();
    }
    a(false);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    k();
    m();
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    b(paramViewHolder, 998);
    String str6 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = "";
    String str5 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str3 = "";
    String str2 = "";
    String str1;
    int i;
    label156:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int)
    {
      str1 = "1";
      i = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label328;
      }
      i = 0;
      localObject1 = str4;
      localObject2 = str3;
      localObject3 = str2;
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      default: 
        localObject3 = str2;
        localObject2 = str3;
        localObject1 = str4;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", (String)localObject1, 0, 0, str5, str1, (String)localObject2, (String)localObject3);
      return;
      str1 = "0";
      break;
      label328:
      i = 1;
      break label156;
      localObject3 = "enter_askjoin";
      if ((str6 == null) || ("".equals(str6))) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label402;
        }
        paramViewHolder = "0";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      label402:
      long l = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l != 0L) && (!(l + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramViewHolder = "2";; paramViewHolder = "1")
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      localObject1 = "refuseask_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "enter_invite";
        localObject2 = str3;
        localObject3 = paramViewHolder;
        break;
      }
      if (i != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseinvite_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      if (i != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseagree_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "quit_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "1";
      localObject3 = str2;
      continue;
      if ((paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "set_admin_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "un_admin_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "un_admin_page";
      localObject2 = "1";
      localObject3 = str2;
    }
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    paramViewHolder.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramViewHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    label245:
    Object localObject2;
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramViewHolder, localStructMsg);
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      localObject1 = "";
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624000);
      if ((TextUtils.isEmpty(str)) || ((paramViewHolder.jdField_a_of_type_Int != 1) && (paramViewHolder.jdField_a_of_type_Int != 22))) {
        break label806;
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624001);
      localObject1 = str;
      if (paramViewHolder.jdField_a_of_type_Int == 11)
      {
        localObject2 = localStructMsg.msg.msg_additional.get();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 15) {
          localObject1 = ((String)localObject2).subSequence(0, 15) + "...";
        }
      }
      localObject2 = localObject1;
      if (localStructMsg.msg.pic_url.has())
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1004;
        }
        localObject2 = "[图片]" + (String)localObject1;
      }
      label354:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1012;
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label387:
      if (paramViewHolder.jdField_a_of_type_Int != 22) {
        break label1024;
      }
      localObject1 = localStructMsg.msg;
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433185, new Object[] { ((structmsg.SystemMsg)localObject1).action_uin_nick.get() }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, ((structmsg.SystemMsg)localObject1).action_uin_nick.get().length() + 6, 33);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new wpy(this, (structmsg.SystemMsg)localObject1));
    }
    for (;;)
    {
      localObject1 = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (localObject1 == null) {
        break label1274;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      label535:
      if (paramViewHolder.jdField_a_of_type_Int != 80) {
        break label1331;
      }
      localObject1 = localStructMsg.msg.actions.get();
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624413);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838526);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      label663:
      if (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1643;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label685:
      if ((paramInt == 2) && (paramViewHolder.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      b(paramViewHolder);
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      label806:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        localObject1 = localStructMsg.msg.msg_qna.get();
        break label245;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        localObject1 = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label245;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional_list.get();
        break label245;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional.get();
        break label245;
      }
      if ((!TextUtils.isEmpty(localStructMsg.msg.msg_detail.get())) && (paramViewHolder.jdField_a_of_type_Int == 12))
      {
        localObject1 = localStructMsg.msg.msg_detail.get();
        break label245;
      }
      if (paramViewHolder.jdField_a_of_type_Int != 83) {
        break label245;
      }
      localObject1 = localStructMsg.msg.msg_detail.get();
      break label245;
      label1004:
      localObject2 = "[图片]";
      break label354;
      label1012:
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label387;
      label1024:
      if ((paramViewHolder.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject2 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; localObject1 = "")
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("来自群 " + (String)localObject1);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject3 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((DiscussionManager)localObject3).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((DiscussionInfo)localObject3).discussionName;
        }
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("来自群 " + (String)localObject1);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1274:
      localObject1 = localStructMsg.msg.msg_additional.get();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429828));
        break label535;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break label535;
      label1331:
      if (paramInt == 1)
      {
        localObject1 = localStructMsg.msg.actions.get();
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (((List)localObject1).size() > 1)
            {
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).name.get());
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624413);
              paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838526);
            }
          }
          for (;;)
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624434);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838525);
          }
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label663;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624002);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      localObject1 = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label663;
      label1643:
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label685;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && ((localViewHolder instanceof NotificationAdapter.ViewHolder)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131366599);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131366600);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.a();
    localButton.setTag(localViewHolder);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount())) {
      p();
    }
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeaderViewsCount() > 0)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i) {
        return true;
      }
    }
    return false;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131366599);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131366600);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected void c()
  {
    super.c();
    a(false);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
  }
  
  protected void g()
  {
    super.g();
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = null;
    }
    TroopNotificationUtils.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0)) {
      r();
    }
    if (this.jdField_c_of_type_Boolean) {
      GroupSystemMsgController.a().b();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
  
  public void j()
  {
    r();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 800L)) {}
    Object localObject1;
    Object localObject2;
    int i;
    label243:
    do
    {
      do
      {
        do
        {
          return;
          jdField_c_of_type_Long = l;
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while (!(paramView.getTag() instanceof NotificationAdapter.ViewHolder));
        localObject1 = (NotificationAdapter.ViewHolder)paramView.getTag();
      } while (localObject1 == null);
      localObject2 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      i = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int;
      if (TroopNotificationUtils.a(i) == 0)
      {
        paramView = TroopInfoActivity.a(String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        paramView.putInt("t_s_f", 1001);
        ChatSettingForTroop.a(a(), paramView, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (i == 0) {
            break label243;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject1, paramView, "", "");
          return;
          i = 0;
          break;
        }
      }
    } while ((((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int == 2) && (TroopInfo.isQidianPrivateTroop(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())));
    if (((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int == 82)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
      paramView.putExtra("uin", ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      paramView.putExtra("source", 112);
      a(paramView);
      return;
    }
    l = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (TroopNotificationUtils.a(i))
    {
    default: 
      paramView = String.valueOf(l);
      label401:
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject2).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(a(), paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      return;
      paramView = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString;
      break label401;
      paramView = String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label401;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.jdField_d_of_type_Int = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 24);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView
 * JD-Core Version:    0.7.0.1
 */