package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import sao;
import sap;
import sar;
import sau;
import saw;
import saz;
import sba;
import sbb;
import sbc;
import sbd;
import sbe;
import sbf;
import sbh;
import sbj;

public class ChatHistoryForC2C
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Dialog a;
  public BroadcastReceiver a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  IntentFilter jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new sao(this);
  public Handler a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  TimeLineView jdField_a_of_type_ComTencentMobileqqActivityTimeLineView;
  public ChatHistoryAdapterForC2C a;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  public C2CMessageSearchDialog a;
  public MessageRoamManager a;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new sau(this);
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public QQProgressDialog a;
  public TipsBar a;
  public String a;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  public List a;
  public MqqHandler a;
  public boolean a;
  private final int jdField_b_of_type_Int = 3;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  TipsBar jdField_b_of_type_ComTencentMobileqqWidgetTipsBar;
  public String b;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  public boolean b;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  public boolean c;
  private boolean d;
  
  public ChatHistoryForC2C()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new saz(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new saw(this);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramString1);
      localJSONObject.put("wording", paramString2);
      localJSONObject.put("image_res_id", paramInt);
      localJSONObject.put("btn_text", paramString3);
      localJSONObject.put("jump_text", paramString4);
      localJSONObject.put("jump_url", paramString5);
      label66:
      super.getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, this.jdField_a_of_type_AndroidContentIntentFilter, "com.tencent.msg.permission.pushnotify", null);
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
      return;
    }
    catch (JSONException paramString1)
    {
      break label66;
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this, 2130970964, null));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365457));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130971508);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362776)).setText(super.getString(2131433842));
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new sbj(this);
        }
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      }
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this, 2130970964, null));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369886));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new sbb(this));
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_Boolean = true;
    h();
  }
  
  @SuppressLint({"NewApi"})
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)super.findViewById(2131363754));
    View localView = LayoutInflater.from(this).inflate(2130968796, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    f();
    o();
    m();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130970932, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363049));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366802));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131365810).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C = new ChatHistoryAdapterForC2C(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
  }
  
  private void q()
  {
    String str = super.getString(2131433649);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.F)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131434943);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.F))) {
          break label237;
        }
        str = super.getString(2131434943);
      }
    }
    label237:
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      ((TextView)super.findViewById(2131363381)).setText(str);
      this.leftView = ((TextView)super.findViewById(2131363245));
      super.findViewById(2131363766).setOnClickListener(this);
      super.findViewById(2131363474).setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryForC2C", 2, "uin type illegal: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_AndroidWidgetToast = null;
    }
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
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      i = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(i))
      {
        localCalendar.add(5, i);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label248;
      }
      i += 1;
      j = i;
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int)
      {
        if (!paramObject.get(i)) {
          break label239;
        }
        j = i;
      }
      i = j * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("orientation=");
        if (paramInt2 <= 0) {
          break label285;
        }
      }
    }
    label285:
    for (paramObject = "left";; paramObject = "right")
    {
      QLog.d("ChatHistoryForC2C", 2, paramObject + ",idnex=" + j + ",old crollX=" + paramInt1 + ",expect crollX=" + i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(i, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, j);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      label239:
      i += 1;
      break;
      label248:
      i -= 1;
      for (;;)
      {
        j = i;
        if (i < 0) {
          break;
        }
        j = i;
        if (paramObject.get(i)) {
          break;
        }
        i -= 1;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCheckPasswordUrl ! ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(1);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
    startActivityForResult(localIntent, 29);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this.app.getApp(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
      if (i != 0) {
        h();
      }
      break;
    }
    label445:
    int j;
    do
    {
      return;
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if (((paramMessage.c()) && (paramMessage.a() == 3)) || ((paramMessage.b()) && (paramMessage.a() == 2)) || ((paramMessage.b()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130838752, super.getString(2131433850));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        i = 1;
      }
      for (;;)
      {
        d();
        break;
        if (paramMessage.a() == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
          i = 1;
        }
        else if (this.d)
        {
          paramMessage.f();
          i = 1;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(32);
          ((Message)localObject).obj = paramMessage.a();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          i = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.c()) && (paramMessage.a() == 3)) || ((paramMessage.b()) && (paramMessage.a() == 2)) || ((paramMessage.b()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
        {
          a(2130838752, super.getString(2131433850));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        if (paramMessage.a() == 4) {
          break label445;
        }
        if (this.d)
        {
          paramMessage.f();
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(32);
        ((Message)localObject).obj = paramMessage.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        i = 0;
        break;
      }
      if (paramMessage.a != null) {
        b(paramMessage.a());
      }
      if (paramMessage.a() == 4) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(this.jdField_a_of_type_JavaUtilList);
      }
      this.d = false;
      d();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label564;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.d, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.a);
    } while (paramMessage.a() == 4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Int);
    }
    for (;;)
    {
      label564:
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131433854));
      }
      paramMessage.g();
      break;
      if (j >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(j);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label107;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(super.getString(2131430175));
      localActionSheet.a(2131433638, 3);
      localActionSheet.c(2131433015);
      localActionSheet.a(new sap(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label107:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
        AbstractGifImage.pauseAll();
      } while ((paramAbsListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C == null));
      paramInt = paramAbsListView.getLastVisiblePosition();
      i = paramAbsListView.getCount();
      j = paramAbsListView.getFirstVisiblePosition();
    } while ((paramInt != i - 1) || (i == 0) || (j == 0) || (this.d));
    QLog.d("ChatHistoryForC2C", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (MessageRoamManager)this.app.getManager(91);
    Calendar localCalendar1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
    if (localCalendar1 != null)
    {
      Calendar localCalendar2 = paramAbsListView.c();
      if ((localCalendar2 != null) && (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (!paramAbsListView.d()) {
        break label283;
      }
      paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.d = true;
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label283:
      paramAbsListView.b(localCalendar1);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {}
    label390:
    for (;;)
    {
      return;
      if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0))
      {
        localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - 1);
        if (localObject1 != null) {
          break label345;
        }
        localObject1 = null;
        label64:
        if (localObject1 != null)
        {
          this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
          localObject1 = (MessageRoamManager)this.app.getManager(91);
          localObject2 = ((MessageRoamManager)localObject1).c();
          if ((localObject2 != null) && (this.jdField_c_of_type_JavaUtilCalendar.get(1) <= ((Calendar)localObject2).get(1)) && (this.jdField_c_of_type_JavaUtilCalendar.get(2) <= ((Calendar)localObject2).get(2)) && (this.jdField_c_of_type_JavaUtilCalendar.get(5) < ((Calendar)localObject2).get(5)))
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          }
          if (((MessageRoamManager)localObject1).c())
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
        }
      }
      Object localObject1 = paramAbsListView.getChildAt(0);
      if (localObject1 == null)
      {
        localObject1 = null;
        label219:
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramAbsListView = paramAbsListView.getChildAt(3);
          if (paramAbsListView != null) {
            break label377;
          }
        }
      }
      label345:
      label377:
      for (Object localObject2 = null;; localObject2 = (ChatMessage)paramAbsListView.getTag(2131361859))
      {
        if (localObject2 == null) {
          break label390;
        }
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject2).time * 1000L);
        this.jdField_a_of_type_JavaUtilCalendar.set(11, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
        this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
        if (this.jdField_a_of_type_JavaUtilCalendar.equals(this.jdField_b_of_type_JavaUtilCalendar)) {
          break;
        }
        this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis());
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65537, 100L);
        return;
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131361859);
        break label64;
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131361859);
        break label219;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast == null) {
      this.jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
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
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramCalendar == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(super.getString(2131433854));
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (MessageRoamManager)this.app.getManager(91);
      Calendar localCalendar = ((MessageRoamManager)localObject).b();
      localObject = ((MessageRoamManager)localObject).c();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(super.getString(2131433851));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(super.getString(2131433852, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(super.getString(2131433853, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    n();
    EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), new sbf(this, l, paramBoolean));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
      localObject2 = new StringBuilder().append("mode: ").append(j).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 != null) {
        break label213;
      }
    }
    label213:
    for (int i = 0;; i = localObject1.length)
    {
      QLog.d("ChatHistoryForC2C", 2, i);
      if (j != 0) {
        break label287;
      }
      if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h())) {
        break;
      }
      a(super.getString(2131430668), super.getString(2131430671), 2130842473, super.getString(2131430672), super.getString(2131430675), "", true);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
      VipUtils.a(this.app, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
      return;
    }
    if ((paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
      super.startActivityForResult(new Intent(this, AuthDevForRoamMsgActivity.class), 31);
      overridePendingTransition(2131034123, 2131034121);
      return;
    }
    if (!bool)
    {
      b();
      return;
    }
    b(paramBoolean3);
    return;
    label287:
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
      {
        b(paramBoolean3);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryForC2C", 2, "devlock is open but no da2 ticket， refresh da2...");
      }
      localObject1 = (AccountManager)this.app.getManager(0);
      if (localObject1 != null)
      {
        n();
        ((AccountManager)localObject1).refreshDA2(this.app.getCurrentAccountUin(), new sbh(this, paramBoolean3));
        return;
      }
      g();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131430673);
    }
    for (Object localObject2 = super.getString(2131430674);; localObject2 = super.getString(2131430670))
    {
      a(super.getString(2131430668), (String)localObject1, 2130842473, (String)localObject2, "", "", false);
      VipUtils.a(this.app, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131430669);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.d = true;
    paramView = (MessageRoamManager)this.app.getManager(91);
    paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_b_of_type_JavaUtilCalendar;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.b();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5))) {
        a(2130838752, super.getString(2131433851));
      }
    }
    else
    {
      return false;
    }
    if (paramView.d()) {
      paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
    }
    for (;;)
    {
      VipUtils.a(this.app, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
      paramView.a(2, null, false);
      return false;
      paramView.b(paramListView);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCreatePasswordUrl ! ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(0);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    startActivityForResult(localIntent, 29);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 24: 
      b(false);
      return;
    }
    paramMessage = this.app.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    paramMessage.putLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), System.currentTimeMillis());
    paramMessage.commit();
    ((MessageRoamManager)this.app.getManager(91)).a(1, null, false);
  }
  
  void b(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay rencent is null");
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
    QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay rencent < begin, begin=" + l1 + ",recent=" + l2);
    return;
    int i;
    int j;
    StringBuilder localStringBuilder1;
    int k;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      i = 0;
      j = i;
      if (i > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "scrollToRecentDay scrollx: " + j + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(j, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      i = paramCalendar.get(1);
      j = paramCalendar.get(2) + 1;
      k = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(i).append("-");
      if (j <= 9) {
        break label351;
      }
      paramCalendar = Integer.valueOf(j);
      label243:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (k <= 9) {
        break label375;
      }
    }
    label351:
    label375:
    for (paramCalendar = Integer.valueOf(k);; paramCalendar = "0" + k)
    {
      localStringBuilder2.append(paramCalendar);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_a_of_type_AndroidViewView.invalidate();
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      i = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      break;
      paramCalendar = "0" + j;
      break label243;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoRoamMessageSettingUrl ! ");
    }
    this.jdField_a_of_type_Int = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), -1);
    VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, new String[] { "0", "0", "msgHistory" });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    String str = IndividuationUrlHelper.a("vipRoamChatCell");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("ChatHistoryForC2C", 1, "gotoRoamMessageSettingUrl ! url empty");
      return;
    }
    if (str.contains("?")) {}
    for (str = str + "&ADTAG=msgHistory";; str = str + "?ADTAG=msgHistory")
    {
      localIntent.putExtra("url", str);
      startActivityForResult(localIntent, 30);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 14: 
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetTextView != null);
      d();
      paramMessage = (Bundle)paramMessage.obj;
      String str = paramMessage.getString("showText");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTag(paramMessage);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
      VipUtils.a(this.app, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localIllegalArgumentException.getMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localException.getMessage());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
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
        this.jdField_a_of_type_Boolean = true;
        h();
        paramMessage = (MessageRoamManager)this.app.getManager(91);
      } while (paramMessage.d() != true);
      paramMessage.a(1, null, false);
      return;
      a(null);
      return;
    } while (paramMessage.obj == null);
    a((Calendar)paramMessage.obj);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != 3000);
        g();
        return;
        paramInt1 = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), -1);
      } while (paramInt1 == this.jdField_a_of_type_Int);
      if (paramInt1 > this.jdField_a_of_type_Int) {
        a(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt1;
        return;
        if (paramInt1 < this.jdField_a_of_type_Int) {
          a(true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b());
      }
      a(false);
      return;
    } while (-1 != paramInt2);
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    setContentViewNoTitle(2130968782);
    paramBundle = super.findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      paramBundle.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
    init(getIntent());
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.app.getManager(23));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)this.app.getManager(91));
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(hashCode());
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(0L);
    q();
    p();
    l();
    if (this.app.a() != null)
    {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
      this.app.a().f();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.o();
    boolean bool3 = NetworkUtil.d(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g();
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "isOpenMessageRoam: " + bool2 + ", netState: " + bool3);
    }
    if ((!bool3) || (!bool2))
    {
      if (!bool3) {
        a(null);
      }
      g();
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new sba(this, bool2, paramBundle));
      return true;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.e())
      {
        MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.app.a(59);
        if (localMessageRoamHandler != null) {
          localMessageRoamHandler.b();
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label546;
          }
          StringBuilder localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (localMessageRoamHandler == null) {
            bool1 = true;
          }
          QLog.d("ChatHistoryForC2C", 2, bool1);
          break;
          g();
        }
      }
      else
      {
        label546:
        a(false);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof FlashPicItemBuilder.FlashPicHolder)))
        {
          localObject = (FlashPicItemBuilder.FlashPicHolder)((View)localObject).getTag();
          if (((FlashPicItemBuilder.FlashPicHolder)localObject).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.FlashPicHolder)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        i += 1;
      }
      MessageRoamManager localMessageRoamManager;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistoryForC2C", 2, "", localException);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
      localMessageRoamManager.p();
      if (localMessageRoamManager.a(hashCode())) {
        this.app.removeHandler(getClass());
      }
      r();
      j();
      if (this.app.a() != null)
      {
        this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.app.a().f();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.notifyDataSetChanged();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  void e()
  {
    View localView1 = super.findViewById(2131363244);
    View localView2 = super.findViewById(2131362840);
    int i = localView1.getHeight();
    Object localObject = (MessageRoamManager)this.app.getManager(91);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog = new C2CMessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRoamManager)localObject).j());
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject).setDuration(200L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation.setDuration(200L);
    ((TranslateAnimation)localObject).setAnimationListener(new sbc(this, localView2, localView1));
    localTranslateAnimation.setAnimationListener(new sbd(this, localView2, i));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.setOnDismissListener(new sbe(this, localView2, i, localView1, localTranslateAnimation));
    localView2.startAnimation((Animation)localObject);
  }
  
  public void e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject2;
    label203:
    do
    {
      do
      {
        return;
        b(this.jdField_a_of_type_JavaUtilCalendar);
        return;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        paramMessage = a(paramMessage.arg1);
      } while (paramMessage == null);
      localObject1 = new StringBuilder();
      i = paramMessage.get(1);
      j = paramMessage.get(2) + 1;
      k = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(i).append("-");
      if (j > 9)
      {
        paramMessage = Integer.valueOf(j);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (k <= 9) {
          break label203;
        }
      }
      for (paramMessage = Integer.valueOf(k);; paramMessage = "0" + k)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        paramMessage = "0" + j;
        break;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = ((Calendar)localObject2).get(1);
    int j = ((Calendar)localObject2).get(2) + 1;
    int k = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append("-");
    if (j > 9)
    {
      localObject1 = Integer.valueOf(j);
      label310:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (k <= 9) {
        break label487;
      }
    }
    label487:
    for (Object localObject1 = Integer.valueOf(k);; localObject1 = "0" + k)
    {
      localStringBuilder2.append(localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.jdField_a_of_type_JavaUtilCalendar))) {
        break label513;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131433854));
      return;
      localObject1 = "0" + j;
      break label310;
    }
    label513:
    localObject1 = this.app;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      VipUtils.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(5, (Calendar)localObject2, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryForC2C", 2, "getForwardRoamHistoryByDate someday=" + localStringBuilder1.toString());
      return;
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this, 2130971517, null));
    int i = (int)DisplayUtils.a(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, i, 0, i);
    ((RelativeLayout)localObject).setBackgroundResource(2130845986);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131558583));
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368321).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368322);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(this);
    setLayerType(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void f(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16: 
      if (paramMessage.arg1 == -1) {
        a(null);
      }
      for (;;)
      {
        g();
        return;
        a(2130838752, super.getString(2131433847));
      }
    case 17: 
      g();
      return;
    case 18: 
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      paramMessage.a(0, null, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.app, paramMessage.b(), paramMessage.c(), false);
      b(paramMessage.a());
      return;
    case 19: 
      paramMessage = (MessageRoamManager)this.app.getManager(91);
      if (paramMessage.a())
      {
        paramMessage.a(1, null, false);
        paramMessage.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.app, paramMessage.b(), paramMessage.c(), true);
        b(paramMessage.a());
        return;
        paramMessage.a(0, null, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g()) {
      a(2130838752, super.getString(2131433850));
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
    paramMessage = Calendar.getInstance();
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = paramMessage.get(1);
    int j = paramMessage.get(2) + 1;
    int k = paramMessage.get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append("-");
    if (j > 9)
    {
      paramMessage = Integer.valueOf(j);
      localStringBuilder2 = localStringBuilder2.append(paramMessage).append("-");
      if (k <= 9) {
        break label404;
      }
    }
    label404:
    for (paramMessage = Integer.valueOf(k);; paramMessage = "0" + k)
    {
      localStringBuilder2.append(paramMessage);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_a_of_type_AndroidViewView.invalidate();
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(65538);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      paramMessage = "0" + j;
      break;
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    n();
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    localMessageRoamManager.b(false);
    localMessageRoamManager.k();
  }
  
  public void g(Message paramMessage)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
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
    for (int i = 1;; i = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (i == 0) {
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
        a(2130838752, super.getString(2131433848, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localMessageRoamManager.e();
    return;
    d();
    a();
    return;
    d();
    return;
    j();
    a(2130838739, super.getString(2131434480));
    setResult(-1);
    finish();
    return;
    j();
    ((MessageRoamManager)this.app.getManager(91)).j();
    setResult(-1);
    finish();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  public void i()
  {
    if (!NetworkUtil.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this.app.getApp(), 2131434481, 1).a();
      return;
    }
    b(super.getString(2131434482));
    ((MessageRoamManager)this.app.getManager(91)).h();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void j()
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
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(super.getString(2131430176));
    localActionSheet.a("删除漫游聊天记录", 3);
    localActionSheet.a("删除手机聊天记录", 3);
    localActionSheet.c(2131433015);
    localActionSheet.a(new sar(this, localActionSheet));
    localActionSheet.show();
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)super.findViewById(2131363769));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)super.findViewById(2131363770));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363772);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363773));
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.a(false);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      i = 2131363428;
    }
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "onClick event unknow id: " + paramView.getId());
      }
    case 2131363428: 
    case 2131363474: 
    case 2131363766: 
    case 2131365457: 
    case 2131368322: 
      label164:
      long l;
      label257:
      do
      {
        do
        {
          return;
          if (NetworkUtil.d(BaseApplication.getContext()))
          {
            this.jdField_a_of_type_Boolean = true;
            h();
            VipUtils.a(this.app, "vip", "0X8004FAC", "0X8004FAC", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
            c();
            localObject = this.app;
            if (paramView != this.jdField_a_of_type_AndroidWidgetTextView) {
              break label257;
            }
          }
          for (paramView = "0X8007AC4";; paramView = "0X8007AB5")
          {
            ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "c2c_msg_roam", paramView, 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
            if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            ((RelativeLayout)super.findViewById(2131362840)).removeView(this.jdField_a_of_type_AndroidWidgetTextView);
            this.jdField_a_of_type_AndroidWidgetTextView = null;
            return;
            a(null);
            break label164;
          }
          k();
          VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_deleteAll", 1, 0, new String[0]);
          return;
          paramView = IndividuationUrlHelper.a("vipRoamChatBanner");
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            startActivity((Intent)localObject);
            VipUtils.a(this.app, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ChatHistoryForC2C", 2, "onClick blue tipe goUrl is null");
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l;
      e();
      ReportController.b(this.app, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
      return;
    }
    paramView = (MessageRoamManager)this.app.getManager(91);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_JavaUtilCalendar;
    if (localObject != null)
    {
      if (paramView.d()) {
        paramView.a(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
      }
      for (;;)
      {
        Calendar localCalendar = paramView.c();
        if ((localCalendar == null) || (((Calendar)localObject).get(1) != localCalendar.get(1)) || (((Calendar)localObject).get(2) != localCalendar.get(2)) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
          break;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
        paramView.b((Calendar)localObject);
      }
    }
    this.d = true;
    paramView.a(3, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryForC2C
 * JD-Core Version:    0.7.0.1
 */