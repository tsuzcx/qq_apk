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
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
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
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
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

public class amik
  extends blgi
  implements View.OnClickListener, blfg, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691448 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839570 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370896 };
  private final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  antq jdField_a_of_type_Antq = new amis(this);
  private anvi jdField_a_of_type_Anvi = new amiq(this);
  private anvk jdField_a_of_type_Anvk;
  private anyz jdField_a_of_type_Anyz = new amir(this);
  private aoay jdField_a_of_type_Aoay;
  private bisl jdField_a_of_type_Bisl;
  private blfk jdField_a_of_type_Blfk;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public QQAppInterface a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<ajbn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<ajbn> jdField_a_of_type_JavaUtilComparator = new amil(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public amik(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anvk = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    f();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antq, true);
    this.jdField_a_of_type_Blfk = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_Aoay = ((aoay)paramQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
    a(true);
    paramView2.setOnClickListener(new amin(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSuspiciousFriendsUnreadNum();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080);
  }
  
  private View a(Context paramContext, int paramInt, amit paramamit)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramamit, -1);
  }
  
  private blfk a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298795);
    int j = paramContext.getResources().getDimensionPixelSize(2131298796);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new amim(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(amit paramamit)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramamit.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ajbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramamit.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
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
        Object localObject2 = paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramamit.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramamit.jdField_b_of_type_Long);
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
      ajas.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    ajas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(amit paramamit, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    String str = null;
    paramamit.jdField_a_of_type_Long = paramInt;
    paramamit.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramamit.jdField_b_of_type_Long = paramLong;
    paramamit.jdField_a_of_type_Int = 0;
    Object localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2;
    if (paramStructMsg.msg != null)
    {
      localObject2 = paramStructMsg.msg.req_uin_nick.get();
      Object localObject3 = ((anvk)localObject1).a(String.valueOf(paramStructMsg.req_uin.get()));
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
        break label607;
      }
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label174:
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!bhbx.b((String)localObject3))) {
        break label619;
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841803);
      ((Drawable)localObject1).setBounds(0, 0, AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      label278:
      c(paramamit);
      paramamit.jdField_a_of_type_AndroidWidgetImageView.setTag(paramamit);
      paramamit.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
        break label633;
      }
      paramamit.d.setText(String.format(Locale.getDefault(), anvx.a(2131706965), new Object[] { localObject1 }));
      paramamit.d.setVisibility(0);
      label480:
      if (paramStructMsg.msg != null)
      {
        paramamit.c.setText(ajbi.a(this.jdField_a_of_type_AndroidAppActivity, paramStructMsg));
        switch (paramStructMsg.msg.sub_type.get())
        {
        }
      }
    }
    for (;;)
    {
      paramamit.jdField_a_of_type_AndroidWidgetButton.setTag(paramamit);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      localObject2 = null;
      break;
      label607:
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label174;
      label619:
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label278;
      label633:
      paramamit.d.setVisibility(8);
      break label480;
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramamit.e.setVisibility(8);
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramamit.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramamit);
        break;
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
        {
          paramamit.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramamit.e.setText(paramStructMsg);
          paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      paramamit.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramamit.e.setText(paramStructMsg);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramamit);
      continue;
      paramamit.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramamit.e.setText(paramStructMsg);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramamit);
      continue;
      paramamit.e.setVisibility(8);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      paramamit.e.setVisibility(8);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
      {
        paramamit.d.setText(paramStructMsg.msg.msg_additional.get());
        paramamit.c.setText(paramStructMsg.msg.msg_describe.get());
      }
      for (;;)
      {
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramamit.e.setVisibility(8);
        break;
        paramamit.d.setVisibility(8);
      }
      paramamit.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramamit.e.setText(paramStructMsg);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramamit);
      continue;
      paramamit.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramamit.e.setText(paramStructMsg);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramamit.e.setVisibility(8);
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramamit.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramamit);
        break;
        paramamit.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramamit.e.setText(paramStructMsg);
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramamit.e.setVisibility(8);
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramamit.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramamit);
        break;
        paramamit.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramamit.e.setText(paramStructMsg);
        paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramStructMsg.msg.reqsubtype.has()) {
        if (paramStructMsg.msg.reqsubtype.get() == 1)
        {
          paramamit.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramamit.e.setText(paramStructMsg);
          paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else if (paramStructMsg.msg.reqsubtype.get() == 2)
        {
          paramamit.e.setVisibility(8);
          paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramamit.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramamit.e.setText(paramStructMsg);
          paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramamit.d.setVisibility(8);
        }
      }
    }
  }
  
  private void a(amit paramamit, PhoneContactAdd paramPhoneContactAdd)
  {
    paramamit.jdField_a_of_type_Int = 1;
    paramamit.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramamit.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramamit.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramamit.c.setVisibility(0);
      paramamit.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramamit.e.setVisibility(0);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramamit.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131718061));
      paramamit.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramamit.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramamit.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramamit.c.setVisibility(8);
    }
  }
  
  private void a(amit paramamit, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramamit.jdField_a_of_type_Int = 2;
    paramamit.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramamit.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    aiyz.a(paramamit.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((aoay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramamit.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), anvx.a(2131706979), new Object[] { localObject });
      paramamit.d.setText((CharSequence)localObject);
      paramamit.d.setVisibility(0);
      paramamit.e.setVisibility(8);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131706967));
      paramamit.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setTag(paramamit);
      paramamit.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramamit.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramamit.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramamit.c.setVisibility(0);
      paramamit.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blfk != null) {}
    for (int i = this.jdField_a_of_type_Blfk.a(paramContext, paramView, paramInt, paramObject, paramblfl, paramOnClickListener);; i = 0)
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
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzx.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdzx.a().b(l);
      bdzx.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return arhz.a().a();
  }
  
  private void b()
  {
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131698932), null, 2131690697, 2131698931, new amio(this), new amip(this)).show();
  }
  
  private void b(amit paramamit)
  {
    if (paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845859);
        j = 0;
        i = 0;
        m = i;
        if (paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramamit.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845858;
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845859);
        i = 1;
        break;
        j = 2130845856;
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845857);
        i = 1;
        break;
        label205:
        paramamit.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramamit.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692125), 0).b(a());
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
            if (bhbx.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof ajbn));
      paramView = (ajbn)paramView;
      if ((paramView instanceof ajbi))
      {
        paramView = (ajbi)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof ajbw))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof ajby));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(amit paramamit)
  {
    if ((paramamit == null) || (paramamit.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject1 != null) && (((anvk)localObject1).b(String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bheg.a();
        }
        paramamit.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(String.valueOf(paramamit.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bisl.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131718527));
    this.jdField_a_of_type_Bisl.show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    this.jdField_a_of_type_Bisl = null;
  }
  
  private void f()
  {
    Object localObject;
    if (a())
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561545, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131378315);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label204;
      }
      ((View)localObject).setBackgroundResource(2130839458);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378316));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, ViewUtils.dip2px(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label204:
      ((View)localObject).setBackgroundResource(2130839455);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561542, null);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      List localList;
      do
      {
        return;
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692125), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      } while ((localList == null) || (localList.size() < 20) || (bdzx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().g();
    } while (!QLog.isColorLevel());
    QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
  }
  
  private void j()
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return bheg.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antq);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
  }
  
  public void a_(View paramView)
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
  
  public void g() {}
  
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
    amit localamit;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      localamit = new amit();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561541, localamit);
      localamit.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localamit.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371981));
      localamit.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362310));
      localamit.c = ((TextView)paramView.findViewById(2131376609));
      localamit.d = ((TextView)paramView.findViewById(2131377905));
      localamit.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376596));
      localamit.e = ((TextView)paramView.findViewById(2131376606));
      if ((localamit.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localamit.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      paramView.setTag(localamit);
      localamit.g.setTag(localamit);
      localamit.g.setOnClickListener(this);
      localObject = (ajbn)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, localamit, this);
      View localView = localamit.g;
      if (((ajbn)localObject).a()) {
        break label296;
      }
      bool = true;
      label223:
      aiyz.a(localView, bool);
      if (!(localObject instanceof ajbi)) {
        break label302;
      }
      localObject = ((ajbi)getItem(paramInt)).a;
      a(localamit, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamit = (amit)paramView.getTag();
      break;
      label296:
      bool = false;
      break label223;
      label302:
      if ((localObject instanceof ajbw))
      {
        a(localamit, ((ajbw)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
      }
      else if ((localObject instanceof ajby))
      {
        localObject = ((ajby)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
        localamit.g.setClickable(false);
        a(localamit, (QIMNotifyAddFriend)localObject);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      b(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof amit)))
      {
        localObject1 = (amit)localObject1;
        if (((amit)localObject1).jdField_a_of_type_Int == 0)
        {
          if (((amit)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
          {
            a((amit)localObject1);
            switch (((amit)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
            {
            default: 
              break;
            case 1: 
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              break;
            case 2: 
            case 3: 
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              break;
            case 13: 
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              break;
            case 6: 
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
              break;
            }
          }
        }
        else if (((amit)localObject1).jdField_a_of_type_Int == 1)
        {
          Object localObject2 = ((amit)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
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
            if ((localObject1 != null) && ((localObject1 instanceof amit))) {
              if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692125), 0).b(a());
              }
              else
              {
                localObject1 = (amit)localObject1;
                if (((amit)localObject1).jdField_a_of_type_Int != 2)
                {
                  a((structmsg.StructMsg)((amit)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((amit)localObject1).jdField_b_of_type_Long);
                  long l1 = bdzx.a().b();
                  localObject1 = bdzx.a().a(Long.valueOf(l1));
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
                      if (bhbx.b(String.valueOf(l2))) {
                        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                      }
                    }
                  }
                  for (int j = i;; j = 0)
                  {
                    if (j != 0) {
                      d();
                    }
                    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
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
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(0);
                PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, NewFriendMoreSysMsgSuspiciousFragment.class);
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
        if ((paramString != null) && ((paramString instanceof amit)))
        {
          paramString = (amit)paramString;
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
      i();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof amit))
      {
        paramAbsListView = (amit)paramAbsListView;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amik
 * JD-Core Version:    0.7.0.1
 */