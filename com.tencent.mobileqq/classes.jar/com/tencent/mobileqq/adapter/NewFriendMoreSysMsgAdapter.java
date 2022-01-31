package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMessageHelper;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import yhs;
import yht;
import yhv;
import yhw;
import yhx;
import yhy;
import yia;
import yic;

public class NewFriendMoreSysMsgAdapter
  extends XBaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, SwipListView.SwipListListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131434041 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130838682 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370002 };
  private final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new yhx(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yhv(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new yhw(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QIMNewFriendManager jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager;
  public QQAppInterface a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator jdField_a_of_type_JavaUtilComparator = new yhs(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private int d;
  
  public NewFriendMoreSysMsgAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    f();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)paramQQAppInterface.getManager(256));
    a(true);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448);
  }
  
  private View a(Context paramContext, int paramInt, NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramMoreSysMsgHolder, -1);
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131558956);
    int j = paramContext.getResources().getDimensionPixelSize(2131558957);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new yic(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      if (this.jdField_b_of_type_Int != -1)
      {
        if (paramInt != this.jdField_b_of_type_Int) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  private void a(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramMoreSysMsgHolder.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramMoreSysMsgHolder.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramMoreSysMsgHolder.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    SystemMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Long = paramInt;
    paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramMoreSysMsgHolder.jdField_b_of_type_Long = paramLong;
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 0;
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((FriendsManager)localObject2).c(String.valueOf(paramStructMsg.req_uin.get()));
    if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark))) {
      localObject1 = ((Friends)localObject2).remark;
    }
    for (;;)
    {
      String str = String.valueOf(paramStructMsg.req_uin.get());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!Utils.b(str))) {
          break label633;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839751);
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label251:
        c(paramMoreSysMsgHolder);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (paramStructMsg.msg == null) {
          break label1658;
        }
        localObject1 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((paramInt & 0x8) != 8)) {
          break label1655;
        }
        paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
        if (paramLong == 0L) {
          break label1655;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1655;
        }
        localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject1, localObject2 });
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramMoreSysMsgHolder.d.setText(String.format(Locale.getDefault(), "来源：%s", new Object[] { localObject1 }));
          paramMoreSysMsgHolder.d.setVisibility(0);
          label430:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label679;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label659;
            }
            paramMoreSysMsgHolder.c.setText(paramStructMsg.msg.msg_qna.get());
            label486:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          paramStructMsg = this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131494237);
          if (paramStructMsg != null) {
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramStructMsg);
          }
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838509);
          return;
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label633:
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label251;
          paramMoreSysMsgHolder.d.setVisibility(8);
          break label430;
          label659:
          paramMoreSysMsgHolder.c.setText(paramStructMsg.msg.msg_additional.get());
          break label486;
          label679:
          paramMoreSysMsgHolder.c.setText(paramStructMsg.msg.msg_describe.get());
          break label486;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramMoreSysMsgHolder.e.setVisibility(8);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramMoreSysMsgHolder);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramMoreSysMsgHolder.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramMoreSysMsgHolder.e.setText(paramStructMsg);
              paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramMoreSysMsgHolder);
          continue;
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramMoreSysMsgHolder);
          continue;
          paramMoreSysMsgHolder.e.setVisibility(8);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramMoreSysMsgHolder.e.setVisibility(8);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramMoreSysMsgHolder.d.setText(paramStructMsg.msg.msg_additional.get());
            paramMoreSysMsgHolder.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramMoreSysMsgHolder.e.setVisibility(8);
            break;
            paramMoreSysMsgHolder.d.setVisibility(8);
          }
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramMoreSysMsgHolder);
          continue;
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramMoreSysMsgHolder.e.setVisibility(8);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramMoreSysMsgHolder);
            break;
            paramMoreSysMsgHolder.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramMoreSysMsgHolder.e.setText(paramStructMsg);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramMoreSysMsgHolder.e.setVisibility(8);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramMoreSysMsgHolder);
            break;
            paramMoreSysMsgHolder.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramMoreSysMsgHolder.e.setText(paramStructMsg);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramMoreSysMsgHolder.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramMoreSysMsgHolder.e.setText(paramStructMsg);
              paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramMoreSysMsgHolder.e.setVisibility(8);
              paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramMoreSysMsgHolder.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramMoreSysMsgHolder.e.setText(paramStructMsg);
              paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramMoreSysMsgHolder.d.setVisibility(8);
            }
          }
        }
        label1655:
        continue;
        label1658:
        localObject1 = null;
      }
    }
  }
  
  private void a(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder, PhoneContactAdd paramPhoneContactAdd)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 1;
    paramMoreSysMsgHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramMoreSysMsgHolder.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramMoreSysMsgHolder.c.setVisibility(0);
      paramMoreSysMsgHolder.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramMoreSysMsgHolder.e.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramMoreSysMsgHolder.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131433048));
      paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramMoreSysMsgHolder.c.setVisibility(8);
    }
  }
  
  private void a(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 2;
    paramMoreSysMsgHolder.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    int j;
    int i;
    label86:
    label123:
    Object localObject;
    switch (paramQIMNotifyAddFriend.gender)
    {
    default: 
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843120);
      j = 0;
      i = 0;
      if (paramQIMNotifyAddFriend.age > 0)
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramQIMNotifyAddFriend.age));
        i = 1;
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (i == 0) {
          break label404;
        }
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(8, 4, 8, 4);
        localObject = ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(256)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label416;
        }
        paramMoreSysMsgHolder.c.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).d();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), "来源：%s", new Object[] { localObject });
      paramMoreSysMsgHolder.d.setText((CharSequence)localObject);
      paramMoreSysMsgHolder.d.setVisibility(0);
      paramMoreSysMsgHolder.e.setVisibility(8);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText("查看");
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131494237);
      if (localObject != null) {
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor((ColorStateList)localObject);
      }
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838509);
      paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      j = 2130843119;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843120);
      i = 1;
      break;
      j = 2130843117;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843118);
      i = 1;
      break;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break label86;
      label404:
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label123;
      label416:
      paramMoreSysMsgHolder.c.setVisibility(0);
      paramMoreSysMsgHolder.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new yht(this, paramBoolean), null, true);
  }
  
  private void b()
  {
    a(false);
  }
  
  private void b(View paramView)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433009), 0).b(a());
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick tag is not int");
        return;
        localObject = paramView.getTag(-1);
        paramView = paramView.getTag(-2);
        if (((localObject instanceof Integer)) && ((paramView instanceof Integer))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
      return;
      int i = ((Integer)localObject).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick position = " + i);
      }
      paramView = (NewFriendMessage)getItem(i);
      if ((paramView instanceof FriendSystemMessage))
      {
        paramView = (FriendSystemMessage)paramView;
        c();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof PhoneContactAddMessage))
      {
        ThreadManager.postImmediately(new yhy(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof QIMNotifyAddFriendMsg));
    ThreadManager.postImmediately(new yia(this, paramView), null, true);
  }
  
  private void b(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    int i = -1;
    if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    int j;
    switch (i)
    {
    default: 
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843120);
      j = 0;
      i = 0;
      k = i;
      if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
      {
        if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) {
          break label207;
        }
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
      }
      break;
    }
    for (int k = 1;; k = i)
    {
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
      if (k == 0) {
        break label223;
      }
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(8, 4, 8, 4);
      return;
      j = 2130843119;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843120);
      i = 1;
      break;
      j = 2130843117;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843118);
      i = 1;
      break;
      label207:
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    label223:
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131434453));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void c(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    if ((paramMoreSysMsgHolder == null) || (paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ImageUtil.a();
        }
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970638, null);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      List localList;
      do
      {
        return;
        if (!NetworkUtil.g(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433009), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0);
      } while ((localList == null) || (localList.size() < 20) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().e();
    } while (!QLog.isColorLevel());
    QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
    }
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_Int == getCount())) {
      g();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder))
      {
        paramAbsListView = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramAbsListView;
        if (paramAbsListView.jdField_a_of_type_Int != 0) {
          break label118;
        }
        c(paramAbsListView);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label70;
      break;
      label118:
      if (paramAbsListView.jdField_a_of_type_Int == 1) {
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramAbsListView.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void d() {}
  
  public void e(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return new Object();
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new NewFriendMoreSysMsgAdapter.MoreSysMsgHolder();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2130970637, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366545));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362894));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371532));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369982));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131369984));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368973));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131368974));
      paramView.setTag(paramViewGroup);
      paramViewGroup.f.setTag(paramViewGroup);
      paramViewGroup.f.setOnClickListener(this);
      localObject = (NewFriendMessage)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, paramViewGroup, this);
      if (((NewFriendMessage)localObject).a()) {
        break label236;
      }
      paramViewGroup.f.setBackgroundResource(2130838589);
      label186:
      if (!(localObject instanceof FriendSystemMessage)) {
        break label249;
      }
      localObject = ((FriendSystemMessage)getItem(paramInt)).a;
      a(paramViewGroup, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    label236:
    label249:
    do
    {
      return paramView;
      paramViewGroup = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramView.getTag();
      break;
      paramViewGroup.f.setBackgroundResource(2130838585);
      break label186;
      if ((localObject instanceof PhoneContactAddMessage))
      {
        a(paramViewGroup, ((PhoneContactAddMessage)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
        return paramView;
      }
    } while (!(localObject instanceof QIMNotifyAddFriendMsg));
    Object localObject = ((QIMNotifyAddFriendMsg)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
    paramViewGroup.f.setClickable(false);
    a(paramViewGroup, (QIMNotifyAddFriend)localObject);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      b(paramView);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramView = paramView.getTag();
            } while ((paramView == null) || (!(paramView instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)));
            paramView = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramView;
            if (paramView.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
          a(paramView);
          switch (paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
          {
          default: 
            return;
          case 1: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
            return;
          case 2: 
          case 3: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
            return;
          case 13: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
          return;
        } while (paramView.jdField_a_of_type_Int != 1);
        localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).g()) {}
      for (paramView = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject).unifiedCode, 29))
      {
        paramView.h = ((PhoneContactAdd)localObject).name;
        ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramView);
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)));
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433009), 0).b(a());
      return;
    }
    paramView = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramView;
    if (paramView.jdField_a_of_type_Int != 2)
    {
      a((structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.jdField_b_of_type_Long);
      long l1 = FriendSystemMsgController.a().b();
      paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
      int i;
      if (paramView != null)
      {
        i = paramView.msg_type.get();
        l1 = paramView.msg_seq.get();
        long l2 = paramView.req_uin.get();
        j = paramView.msg.sub_type.get();
        int k = paramView.msg.src_id.get();
        int m = paramView.msg.sub_src_id.get();
        int n = paramView.msg.group_msg_type.get();
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
          i = 1;
          j = i;
          if (Utils.b(String.valueOf(l2))) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
          }
        }
      }
      for (int j = i;; j = 0)
      {
        if (j != 0) {
          c();
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
        return;
        paramView = new StringBuilder().append("agree, ");
        if (localObject != null) {}
        for (i = ((List)localObject).size();; i = -1)
        {
          QLog.d("NewFriendMoreSysMsgAdapter", 1, i);
          i = 0;
          break;
        }
        QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
      }
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(this.jdField_a_of_type_AndroidAppActivity, null);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)))
        {
          paramString = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter
 * JD-Core Version:    0.7.0.1
 */