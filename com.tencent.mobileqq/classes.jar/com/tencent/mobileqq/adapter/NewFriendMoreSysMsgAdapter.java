package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMessageHelper;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeObserver;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfBean;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
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

public class NewFriendMoreSysMsgAdapter
  extends XBaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener, SwipListView.SwipListListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691558 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839649 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131371177 };
  private final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  NewFriendNotifyPokeObserver jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver = new NewFriendMoreSysMsgAdapter.10(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new NewFriendMoreSysMsgAdapter.9(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NewFriendMoreSysMsgAdapter.7(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new NewFriendMoreSysMsgAdapter.8(this);
  private QIMNewFriendManager jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new NewFriendMoreSysMsgAdapter.6(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private ArrayList<NewFriendMessage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<NewFriendMessage> jdField_a_of_type_JavaUtilComparator = new NewFriendMoreSysMsgAdapter.1(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  final ConcurrentHashMap<Long, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public NewFriendMoreSysMsgAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    g();
    f();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
    a(true);
    paramView2.setOnClickListener(new NewFriendMoreSysMsgAdapter.2(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSuspiciousFriendsUnreadNum();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166);
  }
  
  private View a(Context paramContext, int paramInt, NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, localView, paramMoreSysMsgHolder, -1);
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298882);
    int j = paramContext.getResources().getDimensionPixelSize(2131298883);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new NewFriendMoreSysMsgAdapter.13(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
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
  
  private void a(View paramView)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692257), 0).b(a());
    }
    do
    {
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
        paramView = getItem(i);
      } while (!(paramView instanceof NewFriendMessage));
      paramView = (NewFriendMessage)paramView;
      if ((paramView instanceof FriendSystemMessage))
      {
        paramView = (FriendSystemMessage)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof PhoneContactAddMessage))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.11(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof QIMNotifyAddFriendMsg));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.12(this, paramView), null, true);
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
    case 2: 
    case 3: 
      SystemMessageHelper.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    SystemMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    String str = null;
    paramMoreSysMsgHolder.jdField_a_of_type_Long = paramInt;
    paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramMoreSysMsgHolder.jdField_b_of_type_Long = paramLong;
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 0;
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2;
    if (paramStructMsg.msg != null)
    {
      localObject2 = paramStructMsg.msg.req_uin_nick.get();
      Object localObject3 = ((FriendsManager)localObject1).a(String.valueOf(paramStructMsg.req_uin.get()));
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
          localObject1 = ((Friends)localObject3).remark;
        }
      }
      localObject3 = String.valueOf(paramStructMsg.req_uin.get());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label623;
      }
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label174:
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!Utils.b((String)localObject3))) {
        break label635;
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841947);
      ((Drawable)localObject1).setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      label278:
      d(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = str;
      if (paramStructMsg.msg != null)
      {
        localObject2 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if ((paramInt & 0x8) == 8)
          {
            paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
            localObject1 = localObject2;
            if (paramLong != 0L)
            {
              str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(str)) {
                localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject2, str });
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label649;
      }
      paramMoreSysMsgHolder.d.setText(String.format(Locale.getDefault(), HardCodeUtil.a(2131707495), new Object[] { localObject1 }));
      paramMoreSysMsgHolder.d.setVisibility(0);
      label480:
      if (paramStructMsg.msg != null)
      {
        paramMoreSysMsgHolder.c.setText(FriendSystemMessage.a(this.jdField_a_of_type_AndroidAppActivity, paramStructMsg));
        switch (paramStructMsg.msg.sub_type.get())
        {
        }
      }
    }
    for (;;)
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      localObject2 = null;
      break;
      label623:
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label174;
      label635:
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label278;
      label649:
      paramMoreSysMsgHolder.d.setVisibility(8);
      break label480;
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramMoreSysMsgHolder.e.setVisibility(8);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        c(paramMoreSysMsgHolder);
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
      c(paramMoreSysMsgHolder);
      NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      paramMoreSysMsgHolder.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramMoreSysMsgHolder.e.setText(paramStructMsg);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      c(paramMoreSysMsgHolder);
      NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      c(paramMoreSysMsgHolder);
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
        c(paramMoreSysMsgHolder);
        break;
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        c(paramMoreSysMsgHolder);
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
      paramMoreSysMsgHolder.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131718554));
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
    NewFriendBaseBuilder.a(paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramMoreSysMsgHolder.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131707504), new Object[] { localObject });
      paramMoreSysMsgHolder.d.setText((CharSequence)localObject);
      paramMoreSysMsgHolder.d.setVisibility(0);
      paramMoreSysMsgHolder.e.setVisibility(8);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707496));
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
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
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return SysSuspiciousConfProcessor.a().a();
  }
  
  private void b()
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131699274), null, 2131690800, 2131699273, new NewFriendMoreSysMsgAdapter.3(this), new NewFriendMoreSysMsgAdapter.4(this)).show();
  }
  
  private void b(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramMoreSysMsgHolder.c.setVisibility(0);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramMoreSysMsgHolder.d.setVisibility(0);
    paramMoreSysMsgHolder.e.setVisibility(8);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846180);
        j = 0;
        i = 0;
        m = i;
        if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label220;
        }
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130846179;
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846180);
        i = 1;
        break;
        j = 2130846177;
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846178);
        i = 1;
        break;
        label205:
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label220:
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131719050));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void d(NewFriendMoreSysMsgAdapter.MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    if ((paramMoreSysMsgHolder == null) || (paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ImageUtil.c();
        }
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
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
    Object localObject;
    if (a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561662, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131378741);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label197;
      }
      ((View)localObject).setBackgroundResource(2130839537);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378742));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, ViewUtils.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label197:
      ((View)localObject).setBackgroundResource(2130839534);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561659, null);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void h()
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
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692257), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      } while ((localList == null) || (localList.size() < 20) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().g();
    } while (!QLog.isColorLevel());
    QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
  }
  
  private void i()
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.c();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    NewFriendNotifyPokeMsgHelper.b();
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
    NewFriendMoreSysMsgAdapter.MoreSysMsgHolder localMoreSysMsgHolder;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      localMoreSysMsgHolder = new NewFriendMoreSysMsgAdapter.MoreSysMsgHolder();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561658, localMoreSysMsgHolder);
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372288));
      localMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362338));
      localMoreSysMsgHolder.c = ((TextView)paramView.findViewById(2131377005));
      localMoreSysMsgHolder.d = ((TextView)paramView.findViewById(2131378318));
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376990));
      localMoreSysMsgHolder.e = ((TextView)paramView.findViewById(2131377001));
      localMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376994));
      if ((localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      paramView.setTag(localMoreSysMsgHolder);
      localMoreSysMsgHolder.g.setTag(localMoreSysMsgHolder);
      localMoreSysMsgHolder.g.setOnClickListener(this);
      localObject = (NewFriendMessage)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, localMoreSysMsgHolder, this);
      View localView = localMoreSysMsgHolder.g;
      if (((NewFriendMessage)localObject).a()) {
        break label317;
      }
      bool = true;
      label238:
      NewFriendBaseBuilder.a(localView, bool);
      if (!(localObject instanceof FriendSystemMessage)) {
        break label323;
      }
      localObject = ((FriendSystemMessage)getItem(paramInt)).a;
      a(localMoreSysMsgHolder, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localMoreSysMsgHolder = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramView.getTag();
      b(localMoreSysMsgHolder);
      break;
      label317:
      bool = false;
      break label238;
      label323:
      if ((localObject instanceof PhoneContactAddMessage))
      {
        a(localMoreSysMsgHolder, ((PhoneContactAddMessage)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
      }
      else if ((localObject instanceof QIMNotifyAddFriendMsg))
      {
        localObject = ((QIMNotifyAddFriendMsg)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
        localMoreSysMsgHolder.g.setClickable(false);
        a(localMoreSysMsgHolder, (QIMNotifyAddFriend)localObject);
      }
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)))
      {
        localObject1 = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1;
        if (((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_Int == 0)
        {
          if (((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
          {
            a((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1);
            switch (((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
            {
            default: 
              break;
            case 1: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              break;
            case 2: 
            case 3: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              break;
            case 13: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              break;
            case 6: 
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
              break;
            }
          }
        }
        else if (((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_Int == 1)
        {
          Object localObject2 = ((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
          if (localObject2 != null)
          {
            if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i()) {}
            for (localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29))
            {
              ((ProfileActivity.AllInOne)localObject1).h = ((PhoneContactAdd)localObject2).name;
              ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject1);
              break;
            }
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder))) {
              if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692257), 0).b(a());
              }
              else
              {
                localObject1 = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1;
                if (((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_Int != 2)
                {
                  a((structmsg.StructMsg)((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_b_of_type_Long);
                  long l1 = FriendSystemMsgController.a().b();
                  localObject1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
                  int i;
                  if (localObject1 != null)
                  {
                    i = ((structmsg.StructMsg)localObject1).msg_type.get();
                    l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                    long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                    j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                    int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                    int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                    int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                    localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                    if ((localObject2 != null) && (((List)localObject2).size() > 0))
                    {
                      localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                      ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                      ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                      structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                      localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                      localAddFrdSNInfo.uint32_set_sn.set(0);
                      ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
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
                      d();
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
                    break;
                    localObject1 = new StringBuilder().append("agree, ");
                    if (localObject2 != null) {}
                    for (i = ((List)localObject2).size();; i = -1)
                    {
                      QLog.d("NewFriendMoreSysMsgAdapter", 1, i);
                      i = 0;
                      break;
                    }
                    QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                  }
                }
                ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(this.jdField_a_of_type_AndroidAppActivity, null);
                continue;
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText("");
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(0);
                PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, NewFriendMoreSysMsgSuspiciousFragment.class);
                continue;
                if ((paramView.getTag() != null) && ((paramView.getTag() instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)))
                {
                  localObject1 = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramView.getTag();
                  if ((!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) && (NewFriendNotifyPokeMsgHelper.a((structmsg.StructMsg)((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get())))
                  {
                    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692257), 0).b(a());
                  }
                  else
                  {
                    a((structmsg.StructMsg)((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)localObject1).jdField_b_of_type_Long);
                    NewFriendNotifyPokeMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1);
                  }
                }
              }
            }
          }
        }
      }
    }
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
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_Int == getCount())) {
      h();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label78:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof NewFriendMoreSysMsgAdapter.MoreSysMsgHolder))
      {
        paramAbsListView = (NewFriendMoreSysMsgAdapter.MoreSysMsgHolder)paramAbsListView;
        if (paramAbsListView.jdField_a_of_type_Int != 0) {
          break label126;
        }
        d(paramAbsListView);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label78;
      break;
      label126:
      if (paramAbsListView.jdField_a_of_type_Int == 1) {
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramAbsListView.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void updateCurShowRightView(View paramView)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter
 * JD-Core Version:    0.7.0.1
 */