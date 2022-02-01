package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingRelativeLayout;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class UpComingMsgChatPie
  extends BaseChatPie
{
  private boolean D;
  private boolean E;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new UpComingMsgChatPie.7(this);
  Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new UpComingMsgChatPie.4(this);
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private Long[] jdField_a_of_type_ArrayOfJavaLangLong;
  private ChatAdapter1 jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  Comparator<MessageRecord> jdField_b_of_type_JavaUtilComparator = new UpComingMsgChatPie.5(this);
  private RelativeLayout c;
  private View g;
  private TextView h;
  
  public UpComingMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    ((AIOUpComingMsgHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(59)).a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void a(View paramView, int paramInt, ActionSheet paramActionSheet)
  {
    if (paramView == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    String str = paramActionSheet.getContent(paramInt);
    if (str == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramActionSheet.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131689963)))
    {
      a();
      ReportController.b(null, "dc00898", "", "", "0X800AE92", "0X800AE92", 0, 0, "", "", "", "");
    }
    else if (str.equals(paramView.getResources().getString(2131689964)))
    {
      ao();
      ReportController.b(null, "dc00898", "", "", "0X800AE93", "0X800AE93", 0, 0, "", "", "", "");
    }
    paramActionSheet.dismiss();
  }
  
  private void ao()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      ((UpComingMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER)).a(a(), (ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
  
  private void ap()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfJavaLangLong;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangLong;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        MessageRecord localMessageRecord = localObject2[i];
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.longValue());
        if (((localMessageRecord instanceof ChatMessage)) && (UpComingMsgUtil.a(localMessageRecord))) {
          ((List)localObject1).add((ChatMessage)localMessageRecord);
        } else {
          this.D = true;
        }
        i += 1;
      }
      b((List)localObject1);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 96;
      ((Message)localObject2).obj = localObject1;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject2);
    }
  }
  
  private void aq()
  {
    Object localObject1 = a().getIntent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])((Intent)localObject1).getSerializableExtra("key_uniseq"));
    }
    else
    {
      localObject2 = (Object[])((Intent)localObject1).getSerializableExtra("key_uniseq");
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])Arrays.copyOf((Object[])localObject2, localObject2.length, [Ljava.lang.Long.class));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangLong;
    if ((localObject2 == null) || (localObject2.length == 0)) {
      a().finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("uintype", -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((Intent)localObject1).getStringExtra("uinname");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n = true;
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Q.aio.BaseChatPie parseIntent...sessionInfo.curFriendUin = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", sessionInfo.curType = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (((ChatMessage)paramList.get(0)).istroop == 1)
      {
        Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
        return;
      }
      Collections.sort(paramList, this.jdField_b_of_type_JavaUtilComparator);
    }
  }
  
  private void e(View paramView)
  {
    paramView = ActionSheet.createMenuSheet(paramView.getContext());
    paramView.addButton(2131689963);
    paramView.addButton(2131689964);
    paramView.addCancelButton(2131690728);
    paramView.setOnButtonClickListener(new UpComingMsgChatPie.3(this, paramView));
    paramView.show();
  }
  
  private void l(int paramInt)
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    if (localChatPieSelectableHelper != null) {
      localChatPieSelectableHelper.onMoveToState(paramInt);
    }
  }
  
  protected void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void P()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnCreate...");
    }
    this.D = false;
    this.q = true;
    aq();
    this.x = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362288);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376809));
    Object localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362546);
    if (localObject2 != null) {
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new UpComingRelativeLayout(a());
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setId(2131362546);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)localObject1).addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = new ChatXListView(a());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.g = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.g.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics())));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.g);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVerticalScrollBarEnabled(false);
    this.h = new TextView(a());
    this.h.setText(a().getResources().getString(2131689966));
    this.h.setTextSize(2, 16.0F);
    this.h.setTextColor(-7829368);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.h, (ViewGroup.LayoutParams)localObject1);
    this.h.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376636));
    this.k = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376637));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369216));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369211));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369563));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378784));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378872));
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(this.jdField_a_of_type_Float * 50.0F + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379476));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378837));
    localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      i = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707035));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = new AIOAnimationConatiner(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    if (this.jdField_f_of_type_AndroidViewView == null)
    {
      this.jdField_f_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      this.jdField_f_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.jdField_f_of_type_AndroidViewView.setId(2131362422);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_f_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690706));
    a(false);
    this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine(false);
    this.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(2);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(a().getResources().getString(2131689961));
    if (!this.x)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850433);
      this.k.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167053);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850434);
      this.k.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167054);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    ThreadManager.post(new UpComingMsgChatPie.1(this), 8, null, true);
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    int i = 2130840347;
    if (this.x) {
      i = 2130843861;
    }
    ((ImageView)localObject1).setImageResource(i);
    ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131707034));
    ((ImageView)localObject1).setOnClickListener(new UpComingMsgChatPie.2(this));
    O();
    return true;
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleScrollOutScreen , view = ");
      String str;
      if (paramView == null) {
        str = "null";
      } else {
        str = paramView.toString();
      }
      localStringBuilder.append(str);
      QLog.i("Q.aio.BaseChatPie", 2, localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.a(paramView);
    if ((paramView instanceof TextItemBuilder.Holder))
    {
      paramView = (TextItemBuilder.Holder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    this.jdField_c_of_type_Int = 8;
    return false;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "UpComingMsgLogic.UpComingMsgChatPie";
  }
  
  public boolean d()
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    return (localChatPieSelectableHelper != null) && (localChatPieSelectableHelper.a());
  }
  
  public void g(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE91", "0X800AE91", 0, 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 96) && ((paramMessage.obj instanceof List)))
    {
      Object localObject = (List)paramMessage.obj;
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
        this.h.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ReportController.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 1, 0, "", "", "", "");
      }
      else
      {
        if (this.D)
        {
          QQToast.a(a(), 0, 2131689967, 3000).a();
          ReportController.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 2, 0, "", "", "", "");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((List)localObject, null);
      }
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Q.aio.BaseChatPie upComing. dataList.size = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131369202) || (i == 2131369563) || (i == 2131379476)) {
      q();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_d_of_type_Int < paramInt1)
    {
      b(this.jdField_c_of_type_AndroidViewView);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 < this.jdField_e_of_type_Int) && (paramInt3 > 0)) {
        b(this.jdField_d_of_type_AndroidViewView);
      }
    }
    this.jdField_d_of_type_Int = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.jdField_e_of_type_Int = paramInt1;
    }
    this.jdField_c_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
    this.jdField_d_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      l(18);
      return;
    }
    l(16);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnDestroy...");
    }
    this.jdField_c_of_type_Int = 9;
    l(14);
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    P();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnStart...");
    }
    this.jdField_c_of_type_Int = 3;
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnStop...");
    }
    this.jdField_c_of_type_Int = 6;
    l(12);
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnPause...");
    }
    BaseChatItemLayout.a = this.E;
    QQLiveImage.pauseAll(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AbstractGifImage.pauseAll();
    this.jdField_c_of_type_Int = 5;
    l(11);
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Q.aio.BaseChatPie doOnResume...");
    }
    this.E = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    if (this.q)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new UpComingMsgChatPie.6(this), 600L);
      this.q = false;
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AbstractGifImage.resumeAll();
    this.jdField_c_of_type_Int = 4;
    l(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie
 * JD-Core Version:    0.7.0.1
 */