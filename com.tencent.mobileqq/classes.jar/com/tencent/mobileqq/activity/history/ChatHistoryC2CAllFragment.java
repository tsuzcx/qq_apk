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
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "showDialogLoadingTips activity is null");
      return;
    }
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new ChatHistoryC2CAllFragment.CancelDialogListener(this);
    }
    a(getString(2131719255), this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
  }
  
  private void B()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h();
    if ((bool1) && (bool2))
    {
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f();
      bool1 = false;
      if (!bool3)
      {
        MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
        if (localMessageRoamHandler != null) {
          localMessageRoamHandler.a();
        } else {
          u();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hasGetAuthMode false hanlder is null: ");
          if (localMessageRoamHandler == null) {
            bool1 = true;
          }
          localStringBuilder.append(bool1);
          QLog.d("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
        }
      }
      else
      {
        c(false);
      }
    }
    else
    {
      if (!bool1) {
        a(null);
      }
      u();
    }
    ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CAllFragment.5(this, bool2));
  }
  
  private void C()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131719404);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin type illegal: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      QLog.e("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      ((SessionInfo)localObject).d = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getBaseActivity(), 2131561940, null));
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371762));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.setOnClickListener(new ChatHistoryC2CAllFragment.6(this));
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.a();
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.b();
    this.jdField_d_of_type_Boolean = true;
    v();
  }
  
  private void E()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370120));
    View localView = LayoutInflater.from(getBaseActivity()).inflate(2131558901, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366237);
    t();
    D();
    z();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_e_of_type_AndroidViewView = getBaseActivity().getLayoutInflater().inflate(2131561866, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131376345));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131371496));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131363819).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C = new ChatHistoryAdapterForC2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null, this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
  }
  
  private void F()
  {
    Toast localToast = this.jdField_a_of_type_AndroidWidgetToast;
    if (localToast != null)
    {
      localToast.cancel();
      this.jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  public static MessageRecord a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("need_jump_to_msg", false)) {
        return null;
      }
      long l1 = paramIntent.getLongExtra("searched_time", -1L);
      long l2 = paramIntent.getLongExtra("target_shmsgseq", -1L);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("jumpSearchRecord, time = ");
        paramIntent.append(l1);
        paramIntent.append(" , shmsgseq = ");
        paramIntent.append(l2);
        QLog.d("Q.history.C2CAllFragment", 2, paramIntent.toString());
      }
      if ((l1 != -1L) && (l2 != -1L))
      {
        paramIntent = new MessageRecord();
        paramIntent.time = l1;
        paramIntent.shmsgseq = l2;
        return paramIntent;
      }
    }
    return null;
  }
  
  private void a(View paramView)
  {
    boolean bool = QLog.isColorLevel();
    String str = "null";
    Object localObject;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleScrollOutScreen in history, view = ");
      if (paramView == null) {
        localObject = "null";
      } else {
        localObject = paramView.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.i("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.a(paramView);
    if (ShortVideoItemBuilder.Holder.class.isInstance(paramView))
    {
      ((ShortVideoItemBuilder.Holder)paramView).a();
    }
    else if (ShortVideoRealItemBuilder.Holder.class.isInstance(paramView))
    {
      ((ShortVideoRealItemBuilder.Holder)paramView).a();
    }
    else if ((paramView instanceof TextItemBuilder.Holder))
    {
      localObject = (TextItemBuilder.Holder)paramView;
      if (((TextItemBuilder.Holder)localObject).a != null) {
        ((TextItemBuilder.Holder)localObject).a.d();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      localObject = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (((MixedMsgItemBuilder.MixedHolder)localObject).a != null) {
        ((MixedMsgItemBuilder.MixedHolder)localObject).a.d();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      localObject = (LongMsgItemBuilder.Holder)paramView;
      if (((LongMsgItemBuilder.Holder)localObject).a != null) {
        ((LongMsgItemBuilder.Holder)localObject).a.d();
      }
    }
    if (QLog.isColorLevel())
    {
      if (paramView == null) {
        paramView = str;
      } else {
        paramView = paramView.getClass();
      }
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleScrollOutScreen in history", " obj=", paramView });
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
    int m = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    int n = paramMessage.arg2;
    boolean bool3 = false;
    boolean bool1;
    if (n == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    r();
    if ((m == 0) && (localDevlockInfo != null))
    {
      boolean bool2;
      if (localDevlockInfo.DevSetup == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (localDevlockInfo.AllowSet == 1) {
        bool3 = true;
      }
      a(bool2, bool3, bool1);
      return;
    }
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
    int m = paramMessage.arg1;
    boolean bool = false;
    if (m == 1) {
      m = 1;
    } else {
      m = 0;
    }
    if (paramMessage.arg2 == 1) {
      bool = true;
    }
    r();
    if (m != 0)
    {
      d(bool);
      return;
    }
    u();
  }
  
  private void k(Message paramMessage)
  {
    int n = paramMessage.arg1;
    int m = 1;
    if (n != 1) {
      m = 0;
    }
    n = paramMessage.arg2;
    paramMessage = (byte[])paramMessage.obj;
    if (m != 0)
    {
      if ((paramMessage != null) && (paramMessage.length > 0))
      {
        d(false);
        return;
      }
      paramMessage = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (paramMessage != null)
      {
        A();
        paramMessage.refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.2(this));
        return;
      }
      u();
      return;
    }
    if ((2 != n) && (3 != n))
    {
      u();
      return;
    }
    d(false);
    if (2 == n) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getBaseActivity(), 2131561940, null));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378746));
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
    if (paramInt1 > 0)
    {
      int m = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(m))
      {
        localCalendar.add(5, m);
        return localCalendar;
      }
      int n;
      if (paramInt2 > 0) {
        for (;;)
        {
          m += 1;
          n = m;
          if (m >= this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int) {
            break;
          }
          if (paramObject.get(m))
          {
            n = m;
            break;
          }
        }
      }
      m -= 1;
      for (;;)
      {
        n = m;
        if (m < 0) {
          break;
        }
        if (paramObject.get(m))
        {
          n = m;
          break;
        }
        m -= 1;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a() * n;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("orientation=");
        if (paramInt2 > 0) {
          paramObject = "left";
        } else {
          paramObject = "right";
        }
        localStringBuilder.append(paramObject);
        localStringBuilder.append(",idnex=");
        localStringBuilder.append(n);
        localStringBuilder.append(",old crollX=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",expect crollX=");
        localStringBuilder.append(m);
        QLog.d("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
      paramObject.a(m, paramObject.getScrollY());
      localCalendar.add(5, n);
    }
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar;
  }
  
  public void a()
  {
    QLog.d("Q.history.C2CAllFragment", 1, "gotoCheckPasswordUrl ! ");
    if (!this.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(1);
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
      getBaseActivity().startActivityForResult(localIntent, 30);
      this.j = true;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChatHistoryC2CAllFragment, doOnActivityResult, resultCode = ");
      localStringBuilder.append(paramInt1);
      QLog.d("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 21)
    {
      if (paramInt1 != 36) {
        if (paramInt1 != 38)
        {
          if (paramInt1 != 42)
          {
            switch (paramInt1)
            {
            default: 
              return;
            case 32: 
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("switch auth mode result: ");
                paramIntent.append(paramInt2);
                paramIntent.append(", cur mode: ");
                paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b());
                QLog.d("Q.history.C2CAllFragment", 2, paramIntent.toString());
              }
              c(false);
              return;
            case 31: 
              paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("message_roam_flag");
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              paramInt1 = paramIntent.getInt(localStringBuilder.toString(), -1);
              paramInt2 = this.jdField_a_of_type_Int;
              if (paramInt1 == paramInt2) {
                return;
              }
              if (paramInt1 > paramInt2) {
                c(true);
              } else if (paramInt1 < paramInt2) {
                c(true);
              }
              this.jdField_a_of_type_Int = paramInt1;
              return;
            }
            if (paramInt2 == 3000)
            {
              u();
              this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
            }
            this.j = false;
            this.i = false;
            r();
            return;
          }
          if ((paramInt2 == -1) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing())) {
            getBaseActivity().finish();
          }
        }
        else
        {
          paramIntent = a(paramIntent);
          if (paramIntent != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.history.C2CAllFragment", 2, " ChatHistoryC2CAllFragment doOnActivityResult, startSearchMessage");
            }
            b(paramIntent);
          }
        }
      }
    }
    else if (-1 == paramInt2) {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, getBaseActivity());
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt, paramString, 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    int n = 0;
    int m = 0;
    Object localObject;
    if (i1 != 22)
    {
      if (i1 == 23)
      {
        localObject = (List)paramMessage.obj;
        paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          if (paramMessage.a != null) {
            b(paramMessage.a());
          }
          if (paramMessage.a() == 4) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
          }
          this.k = false;
        }
        else
        {
          if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
          {
            a(2130839590, super.getString(2131692922));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            break label505;
          }
          if (paramMessage.a() != 4)
          {
            if (this.k)
            {
              paramMessage.g();
              QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ getRoamHistoryForSomeDay");
              break label505;
            }
            localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
            ((Message)localObject).obj = paramMessage.a();
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
            QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ message not exist");
            m = n;
            break label719;
          }
        }
        r();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C != null) && (localObject != null) && (((List)localObject).size() > 0))
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.d, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.a);
          if (paramMessage.a() == 4) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "setSelection ", Integer.valueOf(m), " indexOfClieckedItem", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int) });
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int != -1) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int);
          } else if (m >= 1) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(m - 1);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(m);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718354));
        }
        paramMessage.h();
      }
      label505:
      m = 1;
    }
    else
    {
      paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130839590, super.getString(2131692922));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      else if (paramMessage.a() == 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
      }
      else
      {
        if (!this.k) {
          break label676;
        }
        paramMessage.g();
        QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp getRoamHistoryForSomeDay");
      }
      m = 1;
      break label715;
      label676:
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
      ((Message)localObject).obj = paramMessage.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp message not exist");
      label715:
      r();
    }
    label719:
    if (m != 0) {
      v();
    }
  }
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      if (paramMessageRecord != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDelMsg is called,mr uniseq is:");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject).append(",id is:");
        ((StringBuilder)localObject).append(paramMessageRecord.getId());
        QLog.d("Q.msg.delmsg", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
      }
    }
    Object localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(super.getString(2131696093));
    ((ActionSheet)localObject).addButton(2131690788, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryC2CAllFragment.10(this, paramMessageRecord, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void a(Calendar paramCalendar)
  {
    this.jdField_b_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramCalendar == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131718354));
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    Object localObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Calendar localCalendar = ((MessageRoamManager)localObject).b();
    localObject = ((MessageRoamManager)localObject).c();
    if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131694306));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131692926, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131692927, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
      return;
    }
    if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) > 0)) {
      v();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mode: ");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(", isSetPasswd: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", refreshTimeLine: ");
      ((StringBuilder)localObject2).append(paramBoolean3);
      ((StringBuilder)localObject2).append(", devSetup: ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", allowSet: ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append(", da2 length: ");
      int m;
      if (localObject1 == null) {
        m = 0;
      } else {
        m = localObject1.length;
      }
      ((StringBuilder)localObject2).append(m);
      QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "checkAuthMode activity is null");
      return;
    }
    if (n == 0)
    {
      if ((!paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.j()))
      {
        a(super.getString(2131696362), super.getString(2131696365), 2130845085, super.getString(2131696360), super.getString(2131696361), "", true);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.d(true);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.j()))
      {
        if (this.h)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.d(true);
          ChatHistoryAuthDevForRoamMsgFragment.a(getBaseActivity(), 32);
          getBaseActivity().overridePendingTransition(2130771993, 2130771991);
          this.h = true;
        }
      }
      else
      {
        if (!bool)
        {
          q();
          return;
        }
        d(paramBoolean3);
      }
    }
    else
    {
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
      if (paramBoolean2)
      {
        localObject1 = super.getString(2131696364);
        localObject2 = super.getString(2131696359);
      }
      else
      {
        localObject1 = super.getString(2131696363);
        localObject2 = super.getString(2131696358);
      }
      a(super.getString(2131696362), (String)localObject1, 2130845085, (String)localObject2, "", "", false);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
    }
  }
  
  protected void b() {}
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      localObject = ((MqqHandler)localObject).obtainMessage(paramInt1);
      ((Message)localObject).obj = paramObject;
      ((Message)localObject).arg1 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    }
  }
  
  public void b(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 24)
    {
      if (m != 25) {
        return;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip_message_roam_last_request_timestamp");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramMessage.putLong(localStringBuilder.toString(), System.currentTimeMillis());
      paramMessage.commit();
      ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(1, null, false);
      return;
    }
    d(false);
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
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2)))
      {
        localMessageRoamManager.a(paramMessageRecord);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
  }
  
  void b(Calendar paramCalendar)
  {
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay rencent is null");
      }
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a().getTimeInMillis();
    long l2 = paramCalendar.getTimeInMillis();
    if (l2 < l1)
    {
      if (QLog.isColorLevel())
      {
        paramCalendar = new StringBuilder();
        paramCalendar.append("scrollToRecentDay rencent < begin, begin=");
        paramCalendar.append(l1);
        paramCalendar.append(",recent=");
        paramCalendar.append(l2);
        QLog.d("Q.history.C2CAllFragment", 2, paramCalendar.toString());
      }
      return;
    }
    if (l2 == l1) {
      m = 0;
    } else {
      m = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    }
    int n = m;
    if (m > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
      n = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollToRecentDay scrollx: ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", maxWidth: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
    ((AutoFitScrollView)localObject).a(n, ((AutoFitScrollView)localObject).getScrollY());
    localObject = new StringBuilder();
    int m = paramCalendar.get(1);
    n = paramCalendar.get(2) + 1;
    int i1 = paramCalendar.get(5);
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("-");
    if (n > 9)
    {
      paramCalendar = Integer.valueOf(n);
    }
    else
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append("0");
      paramCalendar.append(n);
      paramCalendar = paramCalendar.toString();
    }
    ((StringBuilder)localObject).append(paramCalendar);
    ((StringBuilder)localObject).append("-");
    if (i1 > 9)
    {
      paramCalendar = Integer.valueOf(i1);
    }
    else
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append("0");
      paramCalendar.append(i1);
      paramCalendar = paramCalendar.toString();
    }
    ((StringBuilder)localObject).append(paramCalendar);
    if (!a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
      this.jdField_c_of_type_AndroidViewView.invalidate();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
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
    int m = paramMessage.what;
    if (m != 14)
    {
      if (m != 15) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
      return;
    }
    r();
    paramMessage = (Bundle)paramMessage.obj;
    String str = paramMessage.getString("showText");
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(str);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTag(paramMessage);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
  }
  
  public void c(String paramString)
  {
    Toast localToast = this.jdField_a_of_type_AndroidWidgetToast;
    if (localToast == null) {
      this.jdField_a_of_type_AndroidWidgetToast = Toast.makeText(getBaseActivity(), paramString, 0);
    } else {
      localToast.setText(paramString);
    }
    this.jdField_a_of_type_AndroidWidgetToast.show();
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
    int m = paramMessage.what;
    if (m != 27)
    {
      if (m != 28)
      {
        if (m != 33) {
          return;
        }
        if (paramMessage.obj != null) {
          a((Calendar)paramMessage.obj);
        }
      }
      else
      {
        a(null);
      }
    }
    else
    {
      this.jdField_d_of_type_Boolean = true;
      v();
      paramMessage = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (paramMessage.e() == true) {
        paramMessage.a(1, null, false);
      }
    }
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
    ChatHistoryAdapterForC2C localChatHistoryAdapterForC2C = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C;
    if (localChatHistoryAdapterForC2C != null) {
      localChatHistoryAdapterForC2C.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(getBaseActivity());
    QQLiveImage.onForeground(getBaseActivity());
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
    int m;
    int n;
    int i1;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 65540: 
      Calendar localCalendar = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      if (localCalendar != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        m = localCalendar.get(1);
        n = localCalendar.get(2) + 1;
        i1 = localCalendar.get(5);
        localStringBuilder.append(m);
        localStringBuilder.append("-");
        if (n > 9)
        {
          localObject = Integer.valueOf(n);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(n);
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append("-");
        if (i1 > 9)
        {
          localObject = Integer.valueOf(i1);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(i1);
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append(localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
        if (((localObject != null) && (localCalendar.equals(localObject))) || (localCalendar.equals(this.jdField_a_of_type_JavaUtilCalendar)))
        {
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("getForwardRoamHistoryByDate same day: ");
            paramMessage.append(localStringBuilder.toString());
            QLog.d("Q.history.C2CAllFragment", 2, paramMessage.toString());
          }
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718354));
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessage.arg2 > 0) {
            paramMessage = "Slip_timelineleft";
          } else {
            paramMessage = "Slip_timelineright";
          }
          VipUtils.a((AppInterface)localObject, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(5, localCalendar, true);
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("getForwardRoamHistoryByDate someday=");
            paramMessage.append(localStringBuilder.toString());
            QLog.d("Q.history.C2CAllFragment", 2, paramMessage.toString());
            return;
          }
        }
      }
      break;
    case 65539: 
      paramMessage = a(paramMessage.arg1);
      if (paramMessage != null)
      {
        localObject = new StringBuilder();
        m = paramMessage.get(1);
        n = paramMessage.get(2) + 1;
        i1 = paramMessage.get(5);
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append("-");
        if (n > 9)
        {
          paramMessage = Integer.valueOf(n);
        }
        else
        {
          paramMessage = new StringBuilder();
          paramMessage.append("0");
          paramMessage.append(n);
          paramMessage = paramMessage.toString();
        }
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append("-");
        if (i1 > 9)
        {
          paramMessage = Integer.valueOf(i1);
        }
        else
        {
          paramMessage = new StringBuilder();
          paramMessage.append("0");
          paramMessage.append(i1);
          paramMessage = paramMessage.toString();
        }
        ((StringBuilder)localObject).append(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        if (!a())
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          return;
        }
      }
      break;
    case 65538: 
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    case 65537: 
      b(this.jdField_a_of_type_JavaUtilCalendar);
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnPause");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
    if (localObject != null) {
      ((MessageRoamManager)localObject).b(this);
    }
    localObject = AIOSelectableDelegateImpl.a();
    if ((((AIOSelectableDelegateImpl)localObject).c()) && (((AIOSelectableDelegateImpl)localObject).a())) {
      ((AIOSelectableDelegateImpl)localObject).d();
    }
  }
  
  public void f(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      break;
    case 21: 
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      break;
    case 20: 
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h()) {
        a(2130839590, super.getString(2131692922));
      }
      r();
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
      localObject = Calendar.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      int m = ((Calendar)localObject).get(1);
      int n = ((Calendar)localObject).get(2) + 1;
      int i1 = ((Calendar)localObject).get(5);
      localStringBuilder.append(m);
      localStringBuilder.append("-");
      if (n > 9)
      {
        localObject = Integer.valueOf(n);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(n);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("-");
      if (i1 > 9)
      {
        localObject = Integer.valueOf(i1);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(i1);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append(localObject);
      if (!a())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
        this.jdField_c_of_type_AndroidViewView.invalidate();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      break;
    case 19: 
      if (a())
      {
        localObject = a(getBaseActivity().getIntent());
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
        else
        {
          ((MessageRoamManager)localObject).a(0, null, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRoamManager)localObject).b(), ((MessageRoamManager)localObject).c(), true);
        b(((MessageRoamManager)localObject).a());
      }
      break;
    case 18: 
      if (a())
      {
        localObject = a(getBaseActivity().getIntent());
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
      }
      break;
    case 17: 
      u();
      break;
    case 16: 
      if (paramMessage.arg1 == -1) {
        a(null);
      } else {
        a(2130839590, super.getString(2131692921));
      }
      u();
    }
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramMessage.what) });
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
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m);
        if ((((View)localObject1).getTag() != null) && ((((View)localObject1).getTag() instanceof FlashPicItemBuilder.FlashPicHolder)))
        {
          localObject1 = (FlashPicItemBuilder.FlashPicHolder)((View)localObject1).getTag();
          if (((FlashPicItemBuilder.FlashPicHolder)localObject1).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.FlashPicHolder)localObject1).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        m += 1;
      }
      Object localObject2;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.history.C2CAllFragment", 2, "", localException);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
      if (localObject2 != null)
      {
        ((MessageRoamManager)localObject2).q();
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
      if (localObject2 != null) {
        ((MediaPlayerManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.c();
      QQLiveImage.releaseAll(getBaseActivity());
    }
  }
  
  public void g(Message paramMessage)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (paramMessage.obj != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      long l = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 == 1) {
        m = 1;
      } else {
        m = 0;
      }
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (m == 0) {
        localMessageRoamManager.c(localCalendar);
      }
    }
    int m = paramMessage.what;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              if (m != 8)
              {
                if (m != 9) {
                  return;
                }
                w();
                ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).k();
                getBaseActivity().setResult(-1);
                getBaseActivity().finish();
                return;
              }
              w();
              a(2130839573, super.getString(2131691481));
              getBaseActivity().setResult(-1);
              getBaseActivity().finish();
              return;
            }
            r();
            return;
          }
          a();
          return;
        }
        localMessageRoamManager.e();
        return;
      }
      if (paramMessage.arg1 != -1)
      {
        paramMessage = localMessageRoamManager.a();
        if (paramMessage != null) {
          a(2130839590, super.getString(2131692923, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
        }
      }
      localMessageRoamManager.e();
      return;
    }
    localMessageRoamManager.e();
  }
  
  void j()
  {
    super.j();
    ChatHistoryC2CSettingFragment.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 42);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (m != 2131363819)
    {
      if (m != 2131366333)
      {
        if (m != 2131378746)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onClick event unknow id: ");
            ((StringBuilder)localObject1).append(paramView.getId());
            QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = IndividuationUrlHelper.a("vipRoamChatBanner");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(getBaseActivity(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject2);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("Q.history.C2CAllFragment", 2, "onClick blue tipe goUrl is null");
          }
        }
      }
      else
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long > 1000L)
        {
          this.jdField_a_of_type_Long = l;
          s();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
      if (localObject2 != null)
      {
        if (((MessageRoamManager)localObject1).e()) {
          ((MessageRoamManager)localObject1).a(((Calendar)localObject2).get(1), ((Calendar)localObject2).get(2), ((Calendar)localObject2).get(5));
        } else {
          ((MessageRoamManager)localObject1).b((Calendar)localObject2);
        }
        Calendar localCalendar = ((MessageRoamManager)localObject1).c();
        if ((localCalendar != null) && (((Calendar)localObject2).get(1) == localCalendar.get(1)) && (((Calendar)localObject2).get(2) == localCalendar.get(2)) && (((Calendar)localObject2).get(5) == localCalendar.get(5)))
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          break label402;
        }
      }
      this.k = true;
      ((MessageRoamManager)localObject1).a(3, null, false);
    }
    label402:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558853, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramViewGroup = getBaseActivity().getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramViewGroup.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramViewGroup.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getBaseActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376809);
    paramViewGroup.setOnDispatchListener(new ChatHistoryC2CAllFragment.4(this));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getBaseActivity().finish();
      paramLayoutInflater = null;
    }
    else
    {
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
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    super.onPause();
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    QQLiveImage.onBackground(getBaseActivity());
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject3 = null;
    if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0))
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      if ((localObject1 != null) && (((LinearLayout)localObject1).getVisibility() != 0))
      {
        localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - 1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = (ChatMessage)((View)localObject1).getTag(2131364534);
        }
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
    }
    Object localObject1 = paramAbsListView.getChildAt(0);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364534);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = paramAbsListView.getChildAt(3);
      if (localObject1 == null) {
        localObject1 = localObject3;
      } else {
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131364534);
      }
      localObject2 = localObject1;
    }
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
    if (this.jdField_b_of_type_Int < paramInt1)
    {
      a(this.jdField_f_of_type_AndroidViewView);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 > 0) && (paramInt3 < this.jdField_c_of_type_Int)) {
        a(this.jdField_g_of_type_AndroidViewView);
      }
    }
    this.jdField_b_of_type_Int = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.jdField_c_of_type_Int = paramInt1;
    }
    this.jdField_f_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
    this.jdField_g_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      QQLiveImage.resumeAll(getBaseActivity());
      ShortVideoItemBuilder.f();
      ShortVideoRealItemBuilder.f();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(18);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(16);
    AbstractGifImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
    if (paramAbsListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null) {
        return;
      }
      paramInt = paramAbsListView.getLastVisiblePosition();
      int m = paramAbsListView.getCount();
      int n = paramAbsListView.getFirstVisiblePosition();
      if ((paramInt == m - 1) && (m != 0) && (n != 0) && (!this.k))
      {
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
          if (paramAbsListView.e()) {
            paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
          } else {
            paramAbsListView.b(localCalendar1);
          }
        }
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.k = true;
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
        paramAbsListView.a(3, null, false);
      }
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
        a(2130839590, super.getString(2131694306));
        return false;
      }
      if (paramView.e()) {
        paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
      } else {
        paramView.b(paramListView);
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
      paramView.a(2, null, false);
      return false;
    }
    QLog.d("Q.history.C2CAllFragment", 1, "firstDay is null");
    paramView.a(2, null, false);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.jdField_b_of_type_AndroidViewView.findViewById(2131376809);
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground))) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void q()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl activity is null");
      return;
    }
    if (!this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl ! ");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(0);
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
      getBaseActivity().startActivityForResult(localIntent, 30);
      this.i = true;
    }
  }
  
  public void r()
  {
    p();
  }
  
  void s()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = new C2CMessageSearchDialog(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRoamManager.l());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.setOnDismissListener(new ChatHistoryC2CAllFragment.7(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377024));
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333);
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
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer = ((ChatHistoryTimeLineContainer)this.jdField_b_of_type_AndroidViewView.findViewById(2131380139));
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377006));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378724));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131380138);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380137));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */