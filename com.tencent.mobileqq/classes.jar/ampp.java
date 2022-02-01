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
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
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

public class ampp
  extends blqv
  implements View.OnClickListener, aoog, blih, blpr
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691323 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839514 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370743 };
  private final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anwt jdField_a_of_type_Anwt = new ampx(this);
  private anyu jdField_a_of_type_Anyu = new ampv(this);
  private anyw jdField_a_of_type_Anyw;
  private aocj jdField_a_of_type_Aocj = new ampw(this);
  private aoej jdField_a_of_type_Aoej;
  private aoof jdField_a_of_type_Aoof;
  private bjbs jdField_a_of_type_Bjbs;
  private blpv jdField_a_of_type_Blpv;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public QQAppInterface a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<ajmf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<ajmf> jdField_a_of_type_JavaUtilComparator = new ampq(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public ampp(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anyw = ((anyw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aoof = new aoof(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anwt, true);
    this.jdField_a_of_type_Blpv = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Aoej = ((aoej)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new amps(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.a(1)).j();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011);
  }
  
  private View a(Context paramContext, int paramInt, ampy paramampy)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Blpv.a(paramContext, localView, paramampy, -1);
  }
  
  private blpv a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298726);
    int j = paramContext.getResources().getDimensionPixelSize(2131298727);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new ampr(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(ampy paramampy)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramampy.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ajma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramampy.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
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
        Object localObject2 = paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramampy.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramampy.jdField_b_of_type_Long);
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
      ajlk.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    ajlk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(ampy paramampy, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramampy.jdField_a_of_type_Long = paramInt;
    paramampy.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramampy.jdField_b_of_type_Long = paramLong;
    paramampy.jdField_a_of_type_Int = 0;
    Object localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((anyw)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
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
        paramampy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramampy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!bhjx.b(str))) {
          break label605;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841751);
        ((Drawable)localObject1).setBounds(0, 0, agej.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), agej.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        paramampy.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramampy.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(paramampy);
        paramampy.jdField_a_of_type_AndroidWidgetImageView.setTag(paramampy);
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (paramStructMsg.msg == null) {
          break label1630;
        }
        localObject1 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((paramInt & 0x8) != 8)) {
          break label1627;
        }
        paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
        if (paramLong == 0L) {
          break label1627;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1627;
        }
        localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject1, localObject2 });
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramampy.d.setText(String.format(Locale.getDefault(), anzj.a(2131706383), new Object[] { localObject1 }));
          paramampy.d.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            paramampy.c.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramampy.jdField_a_of_type_AndroidWidgetButton.setTag(paramampy);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          return;
          paramampy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label605:
          paramampy.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label259;
          paramampy.d.setVisibility(8);
          break label441;
          label631:
          paramampy.c.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          paramampy.c.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramampy.e.setVisibility(8);
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramampy.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramampy);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramampy.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramampy.e.setText(paramStructMsg);
              paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramampy.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramampy.e.setText(paramStructMsg);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramampy);
          continue;
          paramampy.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramampy.e.setText(paramStructMsg);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramampy);
          continue;
          paramampy.e.setVisibility(8);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramampy.e.setVisibility(8);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramampy.d.setText(paramStructMsg.msg.msg_additional.get());
            paramampy.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramampy.e.setVisibility(8);
            break;
            paramampy.d.setVisibility(8);
          }
          paramampy.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramampy.e.setText(paramStructMsg);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramampy);
          continue;
          paramampy.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramampy.e.setText(paramStructMsg);
          paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramampy.e.setVisibility(8);
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramampy.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramampy);
            break;
            paramampy.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramampy.e.setText(paramStructMsg);
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramampy.e.setVisibility(8);
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramampy.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramampy);
            break;
            paramampy.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramampy.e.setText(paramStructMsg);
            paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramampy.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramampy.e.setText(paramStructMsg);
              paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramampy.e.setVisibility(8);
              paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramampy.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramampy.e.setText(paramStructMsg);
              paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramampy.d.setVisibility(8);
            }
          }
        }
        label1627:
        continue;
        label1630:
        localObject1 = null;
      }
    }
  }
  
  private void a(ampy paramampy, PhoneContactAdd paramPhoneContactAdd)
  {
    paramampy.jdField_a_of_type_Int = 1;
    paramampy.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramampy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramampy.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramampy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramampy.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramampy.c.setVisibility(0);
      paramampy.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramampy.e.setVisibility(0);
      paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramampy.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131717458));
      paramampy.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramampy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramampy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramampy.c.setVisibility(8);
    }
  }
  
  private void a(ampy paramampy, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramampy.jdField_a_of_type_Int = 2;
    paramampy.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramampy.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    ajjr.a(paramampy.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((aoej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramampy.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), anzj.a(2131706397), new Object[] { localObject });
      paramampy.d.setText((CharSequence)localObject);
      paramampy.d.setVisibility(0);
      paramampy.e.setVisibility(8);
      paramampy.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131706385));
      paramampy.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramampy.jdField_a_of_type_AndroidWidgetButton.setTag(paramampy);
      paramampy.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramampy.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramampy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramampy.c.setVisibility(0);
      paramampy.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blpv != null) {}
    for (int i = this.jdField_a_of_type_Blpv.a(paramContext, paramView, paramInt, paramObject, paramblpw, paramOnClickListener);; i = 0)
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
      bdzh.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdzh.a().b(l);
      bdzh.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return arkv.a().a();
  }
  
  private void b()
  {
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131698466), null, 2131690580, 2131698465, new ampt(this), new ampu(this)).show();
  }
  
  private void b(ampy paramampy)
  {
    if (paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845871);
        j = 0;
        i = 0;
        m = i;
        if (paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramampy.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845870;
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845871);
        i = 1;
        break;
        j = 2130845868;
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845869);
        i = 1;
        break;
        label205:
        paramampy.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramampy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691989), 0).b(a());
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
            if (bhjx.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof ajmf));
      paramView = (ajmf)paramView;
      if ((paramView instanceof ajma))
      {
        paramView = (ajma)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof ajmo))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof ajmq));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(ampy paramampy)
  {
    if ((paramampy == null) || (paramampy.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((anyw)localObject1).b(String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Aoof.a(32, String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aoof.a())
          {
            this.jdField_a_of_type_Aoof.a(String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bhmq.a();
        }
        paramampy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Aoof.a(1, String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aoof.a())
          {
            this.jdField_a_of_type_Aoof.a(String.valueOf(paramampy.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bjbs.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131717902));
    this.jdField_a_of_type_Bjbs.show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    this.jdField_a_of_type_Bjbs = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561605, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131378257);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839402);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378258));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, bhtq.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839399);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561602, null);
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
        if (!bhnv.g(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691989), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.M, 0);
      } while ((localList == null) || (localList.size() < 20) || (bdzh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().g();
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
    Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aoof.a()) {
      this.jdField_a_of_type_Aoof.a(paramString, paramInt, true, (byte)0);
    }
    return bhmq.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anwt);
    this.jdField_a_of_type_Aoof.a(null);
    this.jdField_a_of_type_Aoof.d();
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
  
  public void f() {}
  
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
    ampy localampy;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      localampy = new ampy();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561601, localampy);
      localampy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localampy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371827));
      localampy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362302));
      localampy.c = ((TextView)paramView.findViewById(2131376588));
      localampy.d = ((TextView)paramView.findViewById(2131377861));
      localampy.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376575));
      localampy.e = ((TextView)paramView.findViewById(2131376585));
      if ((localampy.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localampy.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      paramView.setTag(localampy);
      localampy.g.setTag(localampy);
      localampy.g.setOnClickListener(this);
      localObject = (ajmf)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, localampy, this);
      View localView = localampy.g;
      if (((ajmf)localObject).a()) {
        break label296;
      }
      bool = true;
      label223:
      ajjr.a(localView, bool);
      if (!(localObject instanceof ajma)) {
        break label302;
      }
      localObject = ((ajma)getItem(paramInt)).a;
      a(localampy, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localampy = (ampy)paramView.getTag();
      break;
      label296:
      bool = false;
      break label223;
      label302:
      if ((localObject instanceof ajmo))
      {
        a(localampy, ((ajmo)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
      }
      else if ((localObject instanceof ajmq))
      {
        localObject = ((ajmq)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
        localampy.g.setClickable(false);
        a(localampy, (QIMNotifyAddFriend)localObject);
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
      if ((localObject1 != null) && ((localObject1 instanceof ampy)))
      {
        localObject1 = (ampy)localObject1;
        if (((ampy)localObject1).jdField_a_of_type_Int == 0)
        {
          if (((ampy)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
          {
            a((ampy)localObject1);
            switch (((ampy)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
            {
            default: 
              break;
            case 1: 
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              break;
            case 2: 
            case 3: 
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              break;
            case 13: 
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              break;
            case 6: 
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
              break;
            }
          }
        }
        else if (((ampy)localObject1).jdField_a_of_type_Int == 1)
        {
          Object localObject2 = ((ampy)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
          if (localObject2 != null)
          {
            if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i()) {}
            for (localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29))
            {
              ((ProfileActivity.AllInOne)localObject1).h = ((PhoneContactAdd)localObject2).name;
              ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject1);
              break;
            }
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof ampy))) {
              if (!bhnv.g(this.jdField_a_of_type_AndroidAppActivity))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691989), 0).b(a());
              }
              else
              {
                localObject1 = (ampy)localObject1;
                if (((ampy)localObject1).jdField_a_of_type_Int != 2)
                {
                  a((structmsg.StructMsg)((ampy)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((ampy)localObject1).jdField_b_of_type_Long);
                  long l1 = bdzh.a().b();
                  localObject1 = bdzh.a().a(Long.valueOf(l1));
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
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                      i = 1;
                      j = i;
                      if (bhjx.b(String.valueOf(l2))) {
                        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                      }
                    }
                  }
                  for (int j = i;; j = 0)
                  {
                    if (j != 0) {
                      d();
                    }
                    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
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
                ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidAppActivity, null);
                continue;
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText("");
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
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
        if ((paramString != null) && ((paramString instanceof ampy)))
        {
          paramString = (ampy)paramString;
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
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
      return;
    }
    if (this.jdField_a_of_type_Aoof.a()) {
      this.jdField_a_of_type_Aoof.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof ampy))
      {
        paramAbsListView = (ampy)paramAbsListView;
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
 * Qualified Name:     ampp
 * JD-Core Version:    0.7.0.1
 */