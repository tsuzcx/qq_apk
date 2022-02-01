package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardScroller;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class MultiForwardChatPie
  extends BaseChatPie
{
  public boolean D = false;
  long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new MultiForwardChatPie.10(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MultiForwardChatPie.12(this);
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new MultiForwardChatPie.11(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new MultiForwardChatPie.13(this);
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public Runnable a;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private long jdField_b_of_type_Long;
  private ChatAdapter1 jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
  private AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new MultiForwardChatPie.4(this);
  public MqqHandler b;
  private RelativeLayout c;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  String jdField_d_of_type_JavaLangString;
  String e;
  private final int jdField_g_of_type_Int = 300;
  View jdField_g_of_type_AndroidViewView;
  private int jdField_h_of_type_Int;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int i;
  private ImageView l;
  
  public MultiForwardChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_b_of_type_MqqOsMqqHandler = new MultiForwardChatPie.1(this);
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
    if (str.equals(paramView.getResources().getString(2131693256)))
    {
      MultiMsgUtil.a("0X8009AB5");
      c(this.jdField_a_of_type_Long);
    }
    paramActionSheet.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (!this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        return;
      }
      Object localObject;
      if ((paramBoolean) && (paramObject != null) && (MultiMsgManager.a().jdField_a_of_type_Int == 6))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        MultiMsgManager.a().b.clear();
        localObject = MultiMsgManager.a().b;
        Map localMap = (Map)paramObject;
        ((HashMap)localObject).putAll(localMap);
        ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11)).a(localMap, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMultiFavorite = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void ao()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AIOMessageRecordExposeDataReportHelper localAIOMessageRecordExposeDataReportHelper = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (localAIOMessageRecordExposeDataReportHelper != null) {
      localAIOMessageRecordExposeDataReportHelper.onMoveToState(9);
    }
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void e(View paramView)
  {
    paramView = ActionSheet.createMenuSheet(paramView.getContext());
    paramView.addButton(2131693256);
    paramView.addCancelButton(2131690728);
    paramView.setOnButtonClickListener(new MultiForwardChatPie.8(this, paramView));
    paramView.show();
  }
  
  private void l(int paramInt)
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    if (localChatPieSelectableHelper != null) {
      localChatPieSelectableHelper.onMoveToState(paramInt);
    }
  }
  
  public void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public ChatAdapter1 a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  }
  
  protected AIOContext a()
  {
    return new MultiForwardContext();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new MultiForwardMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new MultiForwardScroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public DownCallBack a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.jdField_a_of_type_Long);
      }
      return new MultiForwardChatPie.LongTextDownloadCallback(this);
    }
    return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.jdField_a_of_type_Long);
  }
  
  public ListView a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a()
  {
    Object localObject2 = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      b((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MultiForwardActivity.onDownload, requestReceiveMultiMsg uses ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
      }
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, true);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.7(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719442));
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.q = true;
    this.D = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.x = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_c_of_type_Int = 2;
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362288);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376809));
    Object localObject2 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558562, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("multi_url");
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131707037);
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MultiForwardActivity.doOnCreate ResID = ");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  msg.uniseq = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" downCallBackType");
      ((StringBuilder)localObject1).append(this.jdField_h_of_type_Int);
      QLog.d("MultiMsg_TAG.Nest", 4, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376636));
    this.k = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376637));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369202));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369216));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369211));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369563));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(this.jdField_a_of_type_Float * 50.0F + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379476));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378837));
    localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      j = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = j;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = j;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707035));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378784));
    this.f = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378872));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690706));
    a(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371593));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371591));
    this.l = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371601));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371590));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371598));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362698));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).getString("uin");
      String str = ((Bundle)localObject1).getString("troop_code");
      j = ((Bundle)localObject1).getInt("uintype");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = str;
    }
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (localObject1 != null) {
      MultiMsgManager.a().a(((MessageRecord)localObject1).issend);
    } else {
      MultiMsgManager.a().a(0);
    }
    this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_h_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics())));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_h_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    if (this.jdField_g_of_type_AndroidViewView == null)
    {
      this.jdField_g_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      this.jdField_g_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, j));
      this.jdField_g_of_type_AndroidViewView.setId(2131362422);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_g_of_type_AndroidViewView, null, false);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(j);
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131558901, null);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
    ((MultiForwardScroller)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a((MultiForwardContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
    this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine(false);
    this.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(2);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
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
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    int j = 2130840347;
    if (this.x) {
      j = 2130843861;
    }
    ((ImageView)localObject1).setImageResource(j);
    ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131707034));
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setOnClickListener(new MultiForwardChatPie.3(this));
    O();
    localObject1 = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (localObject1 != null) {
      ((AIOMessageRecordExposeDataReportHelper)localObject1).onMoveToState(4);
    }
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
      QLog.i("MultiForwardActivity", 2, localStringBuilder.toString());
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
  
  public void b(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean b(int paramInt)
  {
    this.jdField_c_of_type_Int = 8;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(localRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "MultiForwardChatPie";
  }
  
  public boolean d()
  {
    Object localObject = (ChatPieSelectableHelper)a(4);
    if ((localObject != null) && (((ChatPieSelectableHelper)localObject).a())) {
      return true;
    }
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.D;
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if ((j == 2131369202) || (j == 2131369563) || (j == 2131379476)) {
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
    paramAbsListView = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (paramAbsListView != null) {
      paramAbsListView.onMoveToState(20);
    }
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
    this.jdField_c_of_type_Int = 9;
    l(14);
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    P();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    localObject = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (localObject != null) {
      ((AIOMessageRecordExposeDataReportHelper)localObject).onMoveToState(15);
    }
  }
  
  public void q()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(localRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
  
  public void t()
  {
    this.jdField_c_of_type_Int = 3;
  }
  
  protected boolean t()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839406);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.i = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public void u()
  {
    this.jdField_c_of_type_Int = 6;
    l(12);
  }
  
  protected boolean u()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.i);
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void v()
  {
    QQLiveImage.pauseAll(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AbstractGifImage.pauseAll();
    this.jdField_c_of_type_Int = 5;
    l(11);
  }
  
  public void y()
  {
    if (this.q) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
    }
    if (this.q)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.5(this), 600L);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie
 * JD-Core Version:    0.7.0.1
 */