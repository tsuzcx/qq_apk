package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.imcore.message.MsgProxyUtils;
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
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
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
  public boolean N = false;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new MultiForwardChatPie.10(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MultiForwardChatPie.12(this);
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new MultiForwardChatPie.13(this);
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new MultiForwardChatPie.11(this);
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  long jdField_b_of_type_Long;
  private ChatAdapter1 jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
  private AIOAnimationConatiner jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  public Runnable b;
  private List<ChatMessage> jdField_b_of_type_JavaUtilList;
  public MqqHandler b;
  private long jdField_c_of_type_Long;
  private Runnable jdField_c_of_type_JavaLangRunnable = new MultiForwardChatPie.4(this);
  private RelativeLayout e;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  String jdField_f_of_type_JavaLangString;
  String g;
  private final int k;
  private int jdField_l_of_type_Int;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private int jdField_m_of_type_Int;
  View jdField_m_of_type_AndroidViewView;
  private View n;
  
  public MultiForwardChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_k_of_type_Int = 300;
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
    if (str.equals(paramView.getResources().getString(2131693302)))
    {
      MultiMsgUtil.a("0X8009AB5");
      c(this.jdField_b_of_type_Long);
    }
    paramActionSheet.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (MultiMsgManager.a().jdField_a_of_type_Int == 6))
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        MultiMsgManager.a().b.clear();
        MultiMsgManager.a().b.putAll((Map)paramObject);
        ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void bi()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    AIOMessageRecordExposeDataReportHelper localAIOMessageRecordExposeDataReportHelper = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (localAIOMessageRecordExposeDataReportHelper != null) {
      localAIOMessageRecordExposeDataReportHelper.onMoveToState(8);
    }
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void e(View paramView)
  {
    paramView = ActionSheet.createMenuSheet(paramView.getContext());
    paramView.addButton(2131693302);
    paramView.addCancelButton(2131690800);
    paramView.setOnButtonClickListener(new MultiForwardChatPie.8(this, paramView));
    paramView.show();
  }
  
  private void v(int paramInt)
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    if (localChatPieSelectableHelper != null) {
      localChatPieSelectableHelper.onMoveToState(paramInt);
    }
  }
  
  protected boolean E()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839549);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_m_of_type_Int = this.jdField_e_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected boolean F()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_m_of_type_Int);
      this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void J()
  {
    this.jdField_d_of_type_Int = 9;
    v(13);
    this.i = null;
    this.j = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    am();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    AIOMessageRecordExposeDataReportHelper localAIOMessageRecordExposeDataReportHelper = (AIOMessageRecordExposeDataReportHelper)a(49);
    if (localAIOMessageRecordExposeDataReportHelper != null) {
      localAIOMessageRecordExposeDataReportHelper.onMoveToState(14);
    }
  }
  
  public void K()
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
  
  public void M()
  {
    this.jdField_d_of_type_Int = 3;
  }
  
  public void N()
  {
    this.jdField_d_of_type_Int = 6;
    v(11);
  }
  
  public void O()
  {
    QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    AbstractGifImage.pauseAll();
    this.jdField_d_of_type_Int = 5;
    v(10);
  }
  
  public void R()
  {
    if (this.v) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 800L);
    }
    if (this.v)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.v = false;
    }
    for (;;)
    {
      QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      AbstractGifImage.resumeAll();
      this.jdField_d_of_type_Int = 4;
      v(6);
      return;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public AIOContext a()
  {
    return new MultiForwardContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public DownCallBack a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.jdField_b_of_type_Long);
    case 1: 
      return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.jdField_b_of_type_Long);
    }
    return new MultiForwardChatPie.LongTextDownloadCallback(this);
  }
  
  public ListView a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a()
  {
    Object localObject2 = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      b((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.jdField_c_of_type_Long));
      }
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.7(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719718));
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardChatPie", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    paramMessageRecord = this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((MsgProxyUtils.b(paramMessageRecord)) || (MsgProxyUtils.a(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramMessageRecord != null)
        {
          bool = true;
          QLog.d("MultiForwardChatPie", 2, new Object[] { "refreshHeadMessage==>", "isFind:", Boolean.valueOf(bool) });
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt3);
        if ((paramMessageRecord == null) || (UniteGrayTipUtil.a(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageRecord.uniseq);
        if (paramInt2 == -1) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
      }
      label231:
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, HardCodeUtil.a(2131707016), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131697693, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      } while (!QLog.isColorLevel());
      label302:
      if (paramMessageRecord != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("MultiForwardChatPie", 2, new Object[] { "foundMsgRecord:", Boolean.valueOf(bool) });
        return;
      }
      paramMessageRecord = null;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.v = true;
    this.N = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.D = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_d_of_type_Int = 2;
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362327);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377356));
    Object localObject2 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558664, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_url");
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      this.jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131707015);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_f_of_type_JavaLangString + "  msg.uniseq = " + this.jdField_b_of_type_Long + " downCallBackType" + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377159));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377160));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369487));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369501));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369496));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369878));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131380148));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379487));
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    int i;
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707013));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379432));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379523));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690778));
    b(false);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371986));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371984));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371994));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371983));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131371991));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362743));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).getString("uin");
      String str = ((Bundle)localObject1).getString("troop_code");
      i = ((Bundle)localObject1).getInt("uintype");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = str;
    }
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_b_of_type_Long);
    if (localObject1 != null) {
      MultiMsgManager.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.n = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.n.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.jdField_m_of_type_AndroidViewView == null)
      {
        this.jdField_m_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
        this.jdField_m_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.jdField_m_of_type_AndroidViewView.setId(2131362466);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_m_of_type_AndroidViewView, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131559007, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
      if (this.D) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850507);
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167030);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      i = 2130840478;
      if (this.D) {
        i = 2130843941;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131707012));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new MultiForwardChatPie.3(this));
      al();
      localObject1 = (AIOMessageRecordExposeDataReportHelper)a(49);
      if (localObject1 != null) {
        ((AIOMessageRecordExposeDataReportHelper)localObject1).onMoveToState(4);
      }
      return true;
      MultiMsgManager.a().a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850508);
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void al()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void am()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void b(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen , view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("MultiForwardActivity", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label56;
      }
    }
    label56:
    do
    {
      do
      {
        return;
        str = paramView.toString();
        break;
        paramView = AIOUtils.a(paramView);
      } while (!(paramView instanceof TextItemBuilder.Holder));
      paramView = (TextItemBuilder.Holder)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  public void b(List<ChatMessage> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b(int paramInt)
  {
    this.jdField_d_of_type_Int = 8;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "MultiForwardChatPie";
  }
  
  public boolean g()
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    if ((localChatPieSelectableHelper != null) && (localChatPieSelectableHelper.a())) {
      return true;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.N;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      K();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_f_of_type_Int < paramInt1) {
      b(this.i);
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_g_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.i = paramAbsListView.getChildAt(0);
      this.j = paramAbsListView.getChildAt(paramInt2 - 1);
      paramAbsListView = (AIOMessageRecordExposeDataReportHelper)a(49);
      if (paramAbsListView != null) {
        paramAbsListView.onMoveToState(20);
      }
      return;
      if ((paramInt1 + paramInt2 - 1 < this.jdField_g_of_type_Int) && (paramInt1 + paramInt2 - 1 > 0)) {
        b(this.j);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      v(17);
      return;
    }
    v(15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie
 * JD-Core Version:    0.7.0.1
 */