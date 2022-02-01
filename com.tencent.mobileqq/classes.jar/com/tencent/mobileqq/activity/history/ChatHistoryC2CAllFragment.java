package com.tencent.mobileqq.activity.history;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.AutoFitScrollView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TimeLineView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C.ActionListener;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicHolder;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.history.widget.ChatHistoryTimeLineContainer;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.CommonSelectableHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.MessageRoamManager.MessageRoamListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHistoryC2CAllFragment
  extends ChatHistoryBaseFragment
  implements View.OnClickListener, ChatHistoryAdapterForC2C.ActionListener, MessageRoamManager.MessageRoamListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  IntentFilter jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ChatHistoryC2CAllFragment.1(this);
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  TimeLineView jdField_a_of_type_ComTencentMobileqqActivityTimeLineView;
  public ChatHistoryAdapterForC2C a;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  public ChatHistoryTimeLineContainer a;
  public C2CMessageSearchDialog a;
  MessageRoamManager jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new ChatHistoryC2CAllFragment.11(this);
  public TipsBar a;
  public ChatXListView a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryC2CAllFragment.14(this);
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new ChatHistoryC2CAllFragment.13(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  public List<MessageRecord> a;
  public MqqHandler a;
  private int jdField_b_of_type_Int;
  Handler jdField_b_of_type_AndroidOsHandler = new ChatHistoryC2CAllFragment.3(this);
  View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  TipsBar jdField_b_of_type_ComTencentMobileqqBannerTipsBar;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  String jdField_c_of_type_JavaLangString = "";
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = true;
  private View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView;
  boolean jdField_g_of_type_Boolean = false;
  boolean h = false;
  boolean i = false;
  boolean j = false;
  private boolean k = false;
  
  public ChatHistoryC2CAllFragment()
  {
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private void A()
  {
    if (getActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "showDialogLoadingTips activity is null");
      return;
    }
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new ChatHistoryC2CAllFragment.CancelDialogListener(this);
    }
    a(getString(2131719537), this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
  }
  
  private void B()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    boolean bool1 = NetworkUtil.d(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h();
    if ((!bool1) || (!bool2))
    {
      if (!bool1) {
        a(null);
      }
      u();
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CAllFragment.5(this, bool2));
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f())
      {
        MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
        label93:
        StringBuilder localStringBuilder;
        if (localMessageRoamHandler != null)
        {
          localMessageRoamHandler.a();
          if (!QLog.isColorLevel()) {
            break label142;
          }
          localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (localMessageRoamHandler != null) {
            break label144;
          }
        }
        label142:
        label144:
        for (bool1 = true;; bool1 = false)
        {
          QLog.d("Q.history.C2CAllFragment", 2, bool1);
          break;
          u();
          break label93;
          break;
        }
      }
      c(false);
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131719683);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "uin type illegal: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131562104, null));
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372180));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.setOnClickListener(new ChatHistoryC2CAllFragment.6(this));
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.a();
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.b();
    this.jdField_d_of_type_Boolean = true;
    v();
  }
  
  private void E()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370461));
    View localView = LayoutInflater.from(getActivity()).inflate(2131559007, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366349);
    t();
    D();
    z();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_e_of_type_AndroidViewView = getActivity().getLayoutInflater().inflate(2131562033, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131376854));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131371874));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131363891).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C = new ChatHistoryAdapterForC2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null, this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  public static MessageRecord a(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.getBooleanExtra("need_jump_to_msg", false))) {}
    long l1;
    long l2;
    do
    {
      return null;
      l1 = paramIntent.getLongExtra("searched_time", -1L);
      l2 = paramIntent.getLongExtra("target_shmsgseq", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "jumpSearchRecord, time = " + l1 + " , shmsgseq = " + l2);
      }
    } while ((l1 == -1L) || (l2 == -1L));
    paramIntent = new MessageRecord();
    paramIntent.time = l1;
    paramIntent.shmsgseq = l2;
    return paramIntent;
  }
  
  private void a(View paramView)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleScrollOutScreen in history, view = ");
      if (paramView != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject = "null";; localObject = paramView.toString())
    {
      QLog.i("Q.history.C2CAllFragment", 2, (String)localObject);
      if (paramView != null) {
        break;
      }
      return;
    }
    paramView = AIOUtils.a(paramView);
    if (ShortVideoItemBuilder.Holder.class.isInstance(paramView))
    {
      ((ShortVideoItemBuilder.Holder)paramView).a();
      label77:
      if (!QLog.isColorLevel()) {
        break label223;
      }
      if (paramView != null) {
        break label225;
      }
    }
    label223:
    label225:
    for (paramView = "null";; paramView = paramView.getClass())
    {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleScrollOutScreen in history", " obj=", paramView });
      return;
      if (ShortVideoRealItemBuilder.Holder.class.isInstance(paramView))
      {
        ((ShortVideoRealItemBuilder.Holder)paramView).a();
        break label77;
      }
      if ((paramView instanceof TextItemBuilder.Holder))
      {
        localObject = (TextItemBuilder.Holder)paramView;
        if (((TextItemBuilder.Holder)localObject).a == null) {
          break label77;
        }
        ((TextItemBuilder.Holder)localObject).a.d();
        break label77;
      }
      if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
      {
        localObject = (MixedMsgItemBuilder.MixedHolder)paramView;
        if (((MixedMsgItemBuilder.MixedHolder)localObject).a == null) {
          break label77;
        }
        ((MixedMsgItemBuilder.MixedHolder)localObject).a.d();
        break label77;
      }
      if (!(paramView instanceof LongMsgItemBuilder.Holder)) {
        break label77;
      }
      localObject = (LongMsgItemBuilder.Holder)paramView;
      if (((LongMsgItemBuilder.Holder)localObject).a == null) {
        break label77;
      }
      ((LongMsgItemBuilder.Holder)localObject).a.d();
      break label77;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (this.h)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
      }
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramString1);
      localJSONObject.put("wording", paramString2);
      localJSONObject.put("image_res_id", paramInt);
      localJSONObject.put("btn_text", paramString3);
      localJSONObject.put("jump_text", paramString4);
      localJSONObject.put("jump_url", paramString5);
      label95:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        y();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this.jdField_a_of_type_AndroidContentIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      }
      paramString1 = new Intent();
      paramString1.setFlags(268435456);
      paramString1.setAction("android.intent.action.VIEW");
      paramString1.putExtra("devlock_guide_config", localJSONObject.toString());
      paramString1.putExtra("devlock_open_source", "RoamMsg");
      paramString1.putExtra("open_devlock_verify_passwd", paramBoolean);
      paramString1.putExtra("open_devlock_from_roam", true);
      paramString1.putExtra("devlock_show_auth_dev_list", false);
      paramString1.setData(Uri.parse("mqqdevlock://devlock/open?"));
      startActivity(paramString1);
      this.h = true;
      return;
    }
    catch (JSONException paramString1)
    {
      break label95;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController instanceof ChatHistoryReadOnlyViewController);
  }
  
  private void h(Message paramMessage)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (paramMessage != null) {
        paramMessage.d();
      }
    }
  }
  
  private void i(Message paramMessage)
  {
    boolean bool3 = true;
    int m = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    boolean bool1;
    boolean bool2;
    if (paramMessage.arg2 == 1)
    {
      bool1 = true;
      r();
      if ((m != 0) || (localDevlockInfo == null)) {
        break label88;
      }
      if (localDevlockInfo.DevSetup != 1) {
        break label76;
      }
      bool2 = true;
      label52:
      if (localDevlockInfo.AllowSet != 1) {
        break label82;
      }
    }
    for (;;)
    {
      a(bool2, bool3, bool1);
      return;
      bool1 = false;
      break;
      label76:
      bool2 = false;
      break label52;
      label82:
      bool3 = false;
    }
    label88:
    if (1 == this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b())
    {
      u();
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g())
    {
      q();
      return;
    }
    d(bool1);
  }
  
  private void j(Message paramMessage)
  {
    boolean bool = true;
    int m;
    if (paramMessage.arg1 == 1)
    {
      m = 1;
      if (paramMessage.arg2 != 1) {
        break label39;
      }
    }
    for (;;)
    {
      r();
      if (m == 0) {
        break label44;
      }
      d(bool);
      return;
      m = 0;
      break;
      label39:
      bool = false;
    }
    label44:
    u();
  }
  
  private void k(Message paramMessage)
  {
    int m;
    int n;
    if (paramMessage.arg1 == 1)
    {
      m = 1;
      n = paramMessage.arg2;
      paramMessage = (byte[])paramMessage.obj;
      if (m == 0) {
        break label97;
      }
      if ((paramMessage == null) || (paramMessage.length <= 0)) {
        break label50;
      }
      d(false);
    }
    label50:
    label97:
    do
    {
      return;
      m = 0;
      break;
      paramMessage = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (paramMessage != null)
      {
        A();
        paramMessage.refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.2(this));
        return;
      }
      u();
      return;
      if ((2 != n) && (3 != n)) {
        break label140;
      }
      d(false);
    } while (2 != n);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    return;
    label140:
    u();
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131562104, null));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379395));
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
  }
  
  Calendar a(int paramInt)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    if (paramInt > 0) {
      localCalendar.add(5, paramInt / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    }
    return localCalendar;
  }
  
  Calendar a(int paramInt1, int paramInt2, Object paramObject)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    int m;
    int n;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      m = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(m))
      {
        localCalendar.add(5, m);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label247;
      }
      m += 1;
      n = m;
      if (m < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int)
      {
        if (!paramObject.get(m)) {
          break label238;
        }
        n = m;
      }
      m = n * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("orientation=");
        if (paramInt2 <= 0) {
          break label284;
        }
      }
    }
    label284:
    for (paramObject = "left";; paramObject = "right")
    {
      QLog.d("Q.history.C2CAllFragment", 2, paramObject + ",idnex=" + n + ",old crollX=" + paramInt1 + ",expect crollX=" + m);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(m, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, n);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      label238:
      m += 1;
      break;
      label247:
      m -= 1;
      for (;;)
      {
        n = m;
        if (m < 0) {
          break;
        }
        n = m;
        if (paramObject.get(m)) {
          break;
        }
        m -= 1;
      }
    }
  }
  
  public void a()
  {
    QLog.d("Q.history.C2CAllFragment", 1, "gotoCheckPasswordUrl ! ");
    if (!this.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(1);
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
      getActivity().startActivityForResult(localIntent, 30);
      this.j = true;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, "ChatHistoryC2CAllFragment, doOnActivityResult, resultCode = " + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt2 == 3000)
            {
              u();
              this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
            }
            this.j = false;
            this.i = false;
            r();
            return;
            paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
          } while (paramInt1 == this.jdField_a_of_type_Int);
          if (paramInt1 > this.jdField_a_of_type_Int) {
            c(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_Int = paramInt1;
            return;
            if (paramInt1 < this.jdField_a_of_type_Int) {
              c(true);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b());
          }
          c(false);
          return;
        } while (-1 != paramInt2);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, getActivity());
        return;
        paramIntent = a(paramIntent);
      } while (paramIntent == null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, " ChatHistoryC2CAllFragment doOnActivityResult, startSearchMessage");
      }
      b(paramIntent);
      return;
    } while ((paramInt2 != -1) || (getActivity() == null) || (getActivity().isFinishing()));
    getActivity().finish();
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt, paramString, 0).b(getActivity().getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int m = 1;
    switch (paramMessage.what)
    {
    default: 
      if (m != 0) {
        v();
      }
      break;
    }
    label494:
    int n;
    do
    {
      return;
      paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130839732, super.getString(2131692962));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        m = 1;
      }
      for (;;)
      {
        r();
        break;
        if (paramMessage.a() == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
          m = 1;
        }
        else if (this.k)
        {
          paramMessage.g();
          QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp getRoamHistoryForSomeDay");
          m = 1;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
          ((Message)localObject).obj = paramMessage.a();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp message not exist");
          m = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
        {
          a(2130839732, super.getString(2131692962));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        if (paramMessage.a() == 4) {
          break label494;
        }
        if (this.k)
        {
          paramMessage.g();
          QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ getRoamHistoryForSomeDay");
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
        ((Message)localObject).obj = paramMessage.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ message not exist");
        m = 0;
        break;
      }
      if (paramMessage.a != null) {
        b(paramMessage.a());
      }
      if (paramMessage.a() == 4) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
      }
      this.k = false;
      r();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label661;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      n = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.d, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.a);
    } while (paramMessage.a() == 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "setSelection ", Integer.valueOf(n), " indexOfClieckedItem", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int);
    }
    for (;;)
    {
      label661:
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718636));
      }
      paramMessage.h();
      break;
      if (n >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(n - 1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(n);
      }
    }
  }
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      localActionSheet.setMainTitle(super.getString(2131696078));
      localActionSheet.addButton(2131690860, 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ChatHistoryC2CAllFragment.10(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast == null) {
      this.jdField_a_of_type_AndroidWidgetToast = Toast.makeText(getActivity(), paramString, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetToast.show();
      return;
      this.jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  public void a(Calendar paramCalendar)
  {
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramCalendar == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131718636));
      this.jdField_d_of_type_Boolean = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      Calendar localCalendar = ((MessageRoamManager)localObject).b();
      localObject = ((MessageRoamManager)localObject).c();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131694341));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131692966, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131692967, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    v();
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g();
    Object localObject1;
    int m;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
      localObject2 = new StringBuilder().append("mode: ").append(n).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        m = 0;
        QLog.d("Q.history.C2CAllFragment", 2, m);
      }
    }
    else
    {
      if (getActivity() != null) {
        break label149;
      }
      QLog.e("Q.history.C2CAllFragment", 2, "checkAuthMode activity is null");
    }
    label149:
    do
    {
      return;
      m = localObject1.length;
      break;
      if (n != 0) {
        break label326;
      }
      if ((!paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.j()))
      {
        a(super.getString(2131696343), super.getString(2131696346), 2130845208, super.getString(2131696341), super.getString(2131696342), "", true);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.d(true);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((!paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.j())) {
        break label310;
      }
      if (!this.h) {
        break label274;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
    return;
    label274:
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.d(true);
    ChatHistoryAuthDevForRoamMsgFragment.a(getActivity(), 32);
    getActivity().overridePendingTransition(2130771981, 2130771979);
    this.h = true;
    return;
    label310:
    if (!bool)
    {
      q();
      return;
    }
    d(paramBoolean3);
    return;
    label326:
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
      {
        d(paramBoolean3);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "devlock is open but no da2 ticket， refresh da2...");
      }
      localObject1 = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (localObject1 != null)
      {
        A();
        ((AccountManager)localObject1).refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.9(this, paramBoolean3));
        return;
      }
      u();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131696345);
    }
    for (Object localObject2 = super.getString(2131696340);; localObject2 = super.getString(2131696339))
    {
      a(super.getString(2131696343), (String)localObject1, 2130845208, (String)localObject2, "", "", false);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131696344);
    }
  }
  
  protected void b() {}
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(paramInt1);
      localMessage.obj = paramObject;
      localMessage.arg1 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 24: 
      d(false);
      return;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    paramMessage.putLong("vip_message_roam_last_request_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    paramMessage.commit();
    ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(1, null, false);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (paramMessageRecord != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramMessageRecord.time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = localMessageRoamManager.c();
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2))) {
        break label98;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
    return;
    label98:
    localMessageRoamManager.a(paramMessageRecord);
  }
  
  void b(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay rencent is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a().getTimeInMillis();
      l2 = paramCalendar.getTimeInMillis();
      if (l2 >= l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay rencent < begin, begin=" + l1 + ",recent=" + l2);
    return;
    int m;
    int n;
    StringBuilder localStringBuilder1;
    int i1;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      m = 0;
      n = m;
      if (m > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
        n = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay scrollx: " + n + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(n, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      m = paramCalendar.get(1);
      n = paramCalendar.get(2) + 1;
      i1 = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(m).append("-");
      if (n <= 9) {
        break label355;
      }
      paramCalendar = Integer.valueOf(n);
      label240:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (i1 <= 9) {
        break label379;
      }
    }
    label355:
    label379:
    for (paramCalendar = Integer.valueOf(i1);; paramCalendar = "0" + i1)
    {
      localStringBuilder2.append(paramCalendar);
      if (!a())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
        this.jdField_c_of_type_AndroidViewView.invalidate();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      m = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      break;
      paramCalendar = "0" + n;
      break label240;
    }
  }
  
  protected int c()
  {
    if (a()) {
      return 1600;
    }
    return 1601;
  }
  
  protected void c() {}
  
  public void c(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 14: 
      r();
      paramMessage = (Bundle)paramMessage.obj;
      String str = paramMessage.getString("showText");
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(str);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTag(paramMessage);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    A();
    EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.8(this, l, paramBoolean));
  }
  
  public void d(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_Boolean = true;
        v();
        paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      } while (paramMessage.e() != true);
      paramMessage.a(1, null, false);
      return;
      a(null);
      return;
    } while (paramMessage.obj == null);
    a((Calendar)paramMessage.obj);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f();
  }
  
  public void e()
  {
    super.e();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(getActivity());
    QQLiveImage.onForeground(getActivity());
    ShortVideoItemBuilder.f();
    ShortVideoRealItemBuilder.f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnResume");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 1, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(hashCode());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this);
    B();
  }
  
  public void e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject2;
    label124:
    do
    {
      do
      {
        return;
        b(this.jdField_a_of_type_JavaUtilCalendar);
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        paramMessage = a(paramMessage.arg1);
      } while (paramMessage == null);
      localObject1 = new StringBuilder();
      m = paramMessage.get(1);
      n = paramMessage.get(2) + 1;
      i1 = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(m).append("-");
      if (n > 9)
      {
        paramMessage = Integer.valueOf(n);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (i1 <= 9) {
          break label210;
        }
      }
      for (paramMessage = Integer.valueOf(i1);; paramMessage = "0" + i1)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        if (a()) {
          break;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
        paramMessage = "0" + n;
        break label124;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    label210:
    StringBuilder localStringBuilder1 = new StringBuilder();
    int m = ((Calendar)localObject2).get(1);
    int n = ((Calendar)localObject2).get(2) + 1;
    int i1 = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(m).append("-");
    if (n > 9)
    {
      localObject1 = Integer.valueOf(n);
      label317:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (i1 <= 9) {
        break label493;
      }
    }
    label493:
    for (Object localObject1 = Integer.valueOf(i1);; localObject1 = "0" + i1)
    {
      localStringBuilder2.append(localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.jdField_a_of_type_JavaUtilCalendar))) {
        break label519;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718636));
      return;
      localObject1 = "0" + n;
      break label317;
    }
    label519:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      VipUtils.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(5, (Calendar)localObject2, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate someday=" + localStringBuilder1.toString());
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnPause");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(this);
    }
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (localAIOSelectableDelegateImpl.a())) {
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public void f(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramMessage.what) });
      }
      return;
      if (paramMessage.arg1 == -1) {
        a(null);
      }
      for (;;)
      {
        u();
        break;
        a(2130839732, super.getString(2131692961));
      }
      u();
      continue;
      Object localObject;
      if (a())
      {
        localObject = a(getActivity().getIntent());
        if (localObject != null) {
          b((MessageRecord)localObject);
        }
      }
      else
      {
        localObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        ((MessageRoamManager)localObject).a(0, null, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRoamManager)localObject).b(), ((MessageRoamManager)localObject).c(), false);
        b(((MessageRoamManager)localObject).a());
        continue;
        if (a())
        {
          localObject = a(getActivity().getIntent());
          if (localObject != null) {
            b((MessageRecord)localObject);
          }
        }
        else
        {
          localObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
          if (((MessageRoamManager)localObject).b())
          {
            ((MessageRoamManager)localObject).a(1, null, false);
            ((MessageRoamManager)localObject).a();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRoamManager)localObject).b(), ((MessageRoamManager)localObject).c(), true);
            b(((MessageRoamManager)localObject).a());
            break;
            ((MessageRoamManager)localObject).a(0, null, false);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h()) {
            a(2130839732, super.getString(2131692962));
          }
          r();
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
          localObject = Calendar.getInstance();
          StringBuilder localStringBuilder1 = new StringBuilder();
          int m = ((Calendar)localObject).get(1);
          int n = ((Calendar)localObject).get(2) + 1;
          int i1 = ((Calendar)localObject).get(5);
          StringBuilder localStringBuilder2 = localStringBuilder1.append(m).append("-");
          if (n > 9)
          {
            localObject = Integer.valueOf(n);
            label429:
            localStringBuilder2 = localStringBuilder2.append(localObject).append("-");
            if (i1 <= 9) {
              break label563;
            }
          }
          label563:
          for (localObject = Integer.valueOf(i1);; localObject = "0" + i1)
          {
            localStringBuilder2.append(localObject);
            if (!a())
            {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
              this.jdField_c_of_type_AndroidViewView.invalidate();
            }
            this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
            break;
            localObject = "0" + n;
            break label429;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
        }
      }
    }
  }
  
  public void g()
  {
    try
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int m = 0;
      while (m < n)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof FlashPicItemBuilder.FlashPicHolder)))
        {
          localObject = (FlashPicItemBuilder.FlashPicHolder)((View)localObject).getTag();
          if (((FlashPicItemBuilder.FlashPicHolder)localObject).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.FlashPicHolder)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        m += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.history.C2CAllFragment", 2, "", localException);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.q();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(hashCode());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(this);
      }
      F();
      w();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().saveNotify();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.c();
      QQLiveImage.releaseAll(getActivity());
    }
  }
  
  public void g(Message paramMessage)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Calendar localCalendar;
    long l;
    if (paramMessage.obj != null)
    {
      localCalendar = Calendar.getInstance();
      l = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 != 1) {
        break label133;
      }
    }
    label133:
    for (int m = 1;; m = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (m == 0) {
        localMessageRoamManager.c(localCalendar);
      }
      switch (paramMessage.what)
      {
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      }
    }
    localMessageRoamManager.e();
    return;
    if (paramMessage.arg1 == -1) {}
    for (;;)
    {
      localMessageRoamManager.e();
      return;
      paramMessage = localMessageRoamManager.a();
      if (paramMessage != null) {
        a(2130839732, super.getString(2131692963, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localMessageRoamManager.e();
    return;
    a();
    return;
    r();
    return;
    w();
    a(2130839715, super.getString(2131691560));
    getActivity().setResult(-1);
    getActivity().finish();
    return;
    w();
    ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).k();
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  void j()
  {
    super.j();
    ChatHistoryC2CSettingFragment.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 42);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "onClick event unknow id: " + paramView.getId());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = IndividuationUrlHelper.a("vipRoamChatBanner");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.history.C2CAllFragment", 2, "onClick blue tipe goUrl is null");
        continue;
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long > 1000L)
        {
          this.jdField_a_of_type_Long = l;
          s();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
          continue;
          localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
          if (localObject2 != null)
          {
            if (((MessageRoamManager)localObject1).e()) {
              ((MessageRoamManager)localObject1).a(((Calendar)localObject2).get(1), ((Calendar)localObject2).get(2), ((Calendar)localObject2).get(5));
            }
            for (;;)
            {
              Calendar localCalendar = ((MessageRoamManager)localObject1).c();
              if ((localCalendar == null) || (((Calendar)localObject2).get(1) != localCalendar.get(1)) || (((Calendar)localObject2).get(2) != localCalendar.get(2)) || (((Calendar)localObject2).get(5) != localCalendar.get(5))) {
                break label398;
              }
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              break;
              ((MessageRoamManager)localObject1).b((Calendar)localObject2);
            }
          }
          label398:
          this.k = true;
          ((MessageRoamManager)localObject1).a(3, null, false);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558955, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramViewGroup = getActivity().getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramViewGroup.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramViewGroup.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377356);
    paramViewGroup.setOnDispatchListener(new ChatHistoryC2CAllFragment.4(this));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getActivity().finish();
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      }
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
      this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
      this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
      this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(0L);
      C();
      E();
      x();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().saveNotify();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.p();
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    super.onPause();
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    QQLiveImage.onBackground(getActivity());
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject2;
    if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0))
    {
      localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - 1);
      if (localObject1 != null) {
        break label406;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
        localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        localObject2 = ((MessageRoamManager)localObject1).c();
        if ((localObject2 != null) && (this.jdField_c_of_type_JavaUtilCalendar.get(1) <= ((Calendar)localObject2).get(1)) && (this.jdField_c_of_type_JavaUtilCalendar.get(2) <= ((Calendar)localObject2).get(2)) && (this.jdField_c_of_type_JavaUtilCalendar.get(5) < ((Calendar)localObject2).get(5)))
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (((MessageRoamManager)localObject1).d())
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
    }
    Object localObject1 = paramAbsListView.getChildAt(0);
    if (localObject1 == null)
    {
      localObject1 = null;
      label220:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramAbsListView.getChildAt(3);
        if (localObject1 != null) {
          break label438;
        }
        localObject2 = null;
      }
      label244:
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject2).time * 1000L);
        this.jdField_a_of_type_JavaUtilCalendar.set(11, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
        if (!this.jdField_a_of_type_JavaUtilCalendar.equals(this.jdField_b_of_type_JavaUtilCalendar))
        {
          this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis());
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65537, 100L);
        }
      }
      if (this.jdField_b_of_type_Int >= paramInt1) {
        break label454;
      }
      a(this.jdField_f_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.jdField_f_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_g_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      label406:
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364647);
      break;
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364647);
      break label220;
      label438:
      localObject2 = (ChatMessage)((View)localObject1).getTag(2131364647);
      break label244;
      label454:
      if ((paramInt1 + paramInt2 - 1 > 0) && (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int)) {
        a(this.jdField_g_of_type_AndroidViewView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      QQLiveImage.resumeAll(getActivity());
      ShortVideoItemBuilder.f();
      ShortVideoRealItemBuilder.f();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(17);
    }
    int m;
    int n;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(15);
        AbstractGifImage.pauseAll();
        QQLiveImage.pauseAll(getActivity());
        ShortVideoItemBuilder.e();
        ShortVideoRealItemBuilder.e();
      } while ((paramAbsListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null));
      paramInt = paramAbsListView.getLastVisiblePosition();
      m = paramAbsListView.getCount();
      n = paramAbsListView.getFirstVisiblePosition();
    } while ((paramInt != m - 1) || (m == 0) || (n == 0) || (this.k));
    QLog.d("Q.history.C2CAllFragment", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Calendar localCalendar1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
    if (localCalendar1 != null)
    {
      Calendar localCalendar2 = paramAbsListView.c();
      if ((localCalendar2 != null) && (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (!paramAbsListView.e()) {
        break label327;
      }
      paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.k = true;
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label327:
      paramAbsListView.b(localCalendar1);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.k = true;
    paramView = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_b_of_type_JavaUtilCalendar;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.b();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5)))
      {
        a(2130839732, super.getString(2131694341));
        return false;
      }
      if (paramView.e()) {
        paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
      }
      for (;;)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
        paramView.a(2, null, false);
        return false;
        paramView.b(paramListView);
      }
    }
    QLog.d("Q.history.C2CAllFragment", 1, "firstDay is null");
    paramView.a(2, null, false);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377356);
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground))) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void q()
  {
    if (getActivity() == null) {
      QLog.e("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl activity is null");
    }
    while (this.i) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl ! ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(0);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    getActivity().startActivityForResult(localIntent, 30);
    this.i = true;
  }
  
  public void r()
  {
    p();
  }
  
  void s()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = new C2CMessageSearchDialog(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRoamManager.l());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.setOnDismissListener(new ChatHistoryC2CAllFragment.7(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377580));
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363942).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366452);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  public void u()
  {
    A();
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localMessageRoamManager.c(false);
    localMessageRoamManager.l();
  }
  
  public void v()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
    }
  }
  
  void w()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer = ((ChatHistoryTimeLineContainer)this.jdField_b_of_type_AndroidViewView.findViewById(2131380875));
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377562));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379373));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131380874);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380873));
    if (a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void y()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ChatHistoryC2CAllFragment.12(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */