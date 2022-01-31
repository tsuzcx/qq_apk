package com.tencent.mobileqq.activity.history;

import aciy;
import ackc;
import acke;
import ackg;
import adey;
import adik;
import adja;
import adkd;
import ados;
import adot;
import adpi;
import adrh;
import afkm;
import afkn;
import afkp;
import afkq;
import afkr;
import afks;
import afkt;
import afku;
import afkv;
import afkw;
import afkx;
import afky;
import afkz;
import afla;
import afmm;
import afry;
import ahox;
import ahpa;
import ahpg;
import ajed;
import ajmp;
import ajmr;
import aket;
import akhq;
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
import anoc;
import aodp;
import aoii;
import awqx;
import axfi;
import babh;
import badq;
import bajr;
import bant;
import bbms;
import bbmy;
import beez;
import begh;
import begr;
import behe;
import belq;
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
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.activity.history.widget.ChatHistoryTimeLineContainer;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
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
  implements ackg, ajmr, View.OnClickListener, begh, belq
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public acke a;
  public afry a;
  public ajmp a;
  private aket jdField_a_of_type_Aket = new afkp(this);
  public BroadcastReceiver a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  IntentFilter jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afkm(this);
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private aodp jdField_a_of_type_Aodp = new afks(this);
  axfi jdField_a_of_type_Axfi = new afkr(this);
  public bbms a;
  AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  TimeLineView jdField_a_of_type_ComTencentMobileqqActivityTimeLineView;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  public ChatHistoryTimeLineContainer a;
  public ChatXListView a;
  public TipsBar a;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  public List<MessageRecord> a;
  public MqqHandler a;
  private int jdField_b_of_type_Int;
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bbms jdField_b_of_type_Bbms;
  TipsBar jdField_b_of_type_ComTencentMobileqqWidgetTipsBar;
  public String b;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  String jdField_c_of_type_JavaLangString = "";
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private View d;
  public boolean d;
  private View e;
  public boolean e;
  private View f;
  public boolean f;
  private View jdField_g_of_type_AndroidViewView;
  boolean jdField_g_of_type_Boolean = false;
  boolean h = false;
  private boolean i;
  
  public ChatHistoryC2CAllFragment()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler = new afku(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void A()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    boolean bool1 = badq.d(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_Ajmp.h();
    if ((!bool1) || (!bool2))
    {
      if (!bool1) {
        a(null);
      }
      t();
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CAllFragment.5(this, bool2));
      return;
      if (!this.jdField_a_of_type_Ajmp.f())
      {
        akhq localakhq = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(59);
        label92:
        StringBuilder localStringBuilder;
        if (localakhq != null)
        {
          localakhq.a();
          if (!QLog.isColorLevel()) {
            break label141;
          }
          localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (localakhq != null) {
            break label143;
          }
        }
        label141:
        label143:
        for (bool1 = true;; bool1 = false)
        {
          QLog.d("Q.history.C2CAllFragment", 2, bool1);
          break;
          t();
          break label92;
          break;
        }
      }
      c(false);
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(ajed.G))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131654085);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, babh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "uin type illegal: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131495943, null));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305052));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new afkw(this));
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_d_of_type_Boolean = true;
    u();
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303605));
    View localView = LayoutInflater.from(getActivity()).inflate(2131493267, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131300078);
    s();
    C();
    y();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_e_of_type_AndroidViewView = getActivity().getLayoutInflater().inflate(2131495880, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131309309));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131304762));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131297884).setOnClickListener(this);
    this.jdField_a_of_type_Acke = new acke(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null, this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Acke);
  }
  
  private void E()
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
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen in history, view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("Q.history.C2CAllFragment", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label55;
      }
    }
    label55:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramView.toString();
            break;
            paramView = aciy.a(paramView);
            if (ados.class.isInstance(paramView))
            {
              ((ados)paramView).a();
              return;
            }
            if (adpi.class.isInstance(paramView))
            {
              ((adpi)paramView).a();
              return;
            }
            if (adik.class.isInstance(paramView))
            {
              ((adik)paramView).a();
              return;
            }
            if (!(paramView instanceof adrh)) {
              break label141;
            }
            paramView = (adrh)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof adkd)) {
            break label168;
          }
          paramView = (adkd)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof adja));
      paramView = (adja)paramView;
    } while (paramView.a == null);
    label141:
    label168:
    paramView.a.d();
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
        x();
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
    return (this.jdField_a_of_type_Afkk instanceof afmm);
  }
  
  private void h(Message paramMessage)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      paramMessage = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if (paramMessage != null) {
        paramMessage.d();
      }
    }
  }
  
  private void i(Message paramMessage)
  {
    boolean bool3 = true;
    int j = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    boolean bool1;
    boolean bool2;
    if (paramMessage.arg2 == 1)
    {
      bool1 = true;
      q();
      if ((j != 0) || (localDevlockInfo == null)) {
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
    if (1 == this.jdField_a_of_type_Ajmp.b())
    {
      t();
      return;
    }
    if (!this.jdField_a_of_type_Ajmp.g())
    {
      p();
      return;
    }
    d(bool1);
  }
  
  private void j(Message paramMessage)
  {
    boolean bool = true;
    int j;
    if (paramMessage.arg1 == 1)
    {
      j = 1;
      if (paramMessage.arg2 != 1) {
        break label39;
      }
    }
    for (;;)
    {
      q();
      if (j == 0) {
        break label44;
      }
      d(bool);
      return;
      j = 0;
      break;
      label39:
      bool = false;
    }
    label44:
    t();
  }
  
  private void k(Message paramMessage)
  {
    int j;
    int k;
    if (paramMessage.arg1 == 1)
    {
      j = 1;
      k = paramMessage.arg2;
      paramMessage = (byte[])paramMessage.obj;
      if (j == 0) {
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
      j = 0;
      break;
      paramMessage = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (paramMessage != null)
      {
        z();
        paramMessage.refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afkt(this));
        return;
      }
      t();
      return;
      if ((2 != k) && (3 != k)) {
        break label140;
      }
      d(false);
    } while (2 != k);
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    return;
    label140:
    t();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131495943, null));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311503));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  private void z()
  {
    if (getActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "showDialogLoadingTips activity is null");
      return;
    }
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new afla(this);
    }
    a(getString(2131653912), this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
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
    int j;
    int k;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      j = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(j))
      {
        localCalendar.add(5, j);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label247;
      }
      j += 1;
      k = j;
      if (j < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int)
      {
        if (!paramObject.get(j)) {
          break label238;
        }
        k = j;
      }
      j = k * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
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
      QLog.d("Q.history.C2CAllFragment", 2, paramObject + ",idnex=" + k + ",old crollX=" + paramInt1 + ",expect crollX=" + j);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(j, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, k);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      label238:
      j += 1;
      break;
      label247:
      j -= 1;
      for (;;)
      {
        k = j;
        if (j < 0) {
          break;
        }
        k = j;
        if (paramObject.get(j)) {
          break;
        }
        j -= 1;
      }
    }
  }
  
  public void a()
  {
    QLog.d("Q.history.C2CAllFragment", 1, "gotoCheckPasswordUrl ! ");
    this.jdField_a_of_type_Ajmp.c(1);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
    startActivityForResult(localIntent, 30);
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
            do
            {
              return;
            } while (paramInt2 != 3000);
            t();
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
            QLog.d("Q.history.C2CAllFragment", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_a_of_type_Ajmp.b());
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
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(paramInt1);
      localMessage.obj = paramObject;
      localMessage.arg1 = paramInt2;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  void a(int paramInt, String paramString)
  {
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt, paramString, 0).b(getActivity().getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int j = 1;
    switch (paramMessage.what)
    {
    default: 
      if (j != 0) {
        u();
      }
      break;
    }
    label456:
    int k;
    do
    {
      return;
      paramMessage = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130839293, super.getString(2131627385));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        j = 1;
      }
      for (;;)
      {
        q();
        break;
        if (paramMessage.a() == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
          this.jdField_a_of_type_Acke.b(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_Acke.notifyDataSetChanged();
          j = 1;
        }
        else if (this.i)
        {
          paramMessage.f();
          j = 1;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
          ((Message)localObject).obj = paramMessage.a();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          j = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
        {
          a(2130839293, super.getString(2131627385));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        if (paramMessage.a() == 4) {
          break label456;
        }
        if (this.i)
        {
          paramMessage.f();
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
        ((Message)localObject).obj = paramMessage.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        j = 0;
        break;
      }
      if (paramMessage.a != null) {
        b(paramMessage.a());
      }
      if (paramMessage.a() == 4) {
        this.jdField_a_of_type_Acke.b(this.jdField_a_of_type_JavaUtilList);
      }
      this.i = false;
      q();
      if ((this.jdField_a_of_type_Acke == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label575;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      k = this.jdField_a_of_type_Acke.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.d, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.a);
    } while (paramMessage.a() == 4);
    if (this.jdField_a_of_type_Acke.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Acke.jdField_a_of_type_Int);
    }
    for (;;)
    {
      label575:
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131652967));
      }
      paramMessage.g();
      break;
      if (k >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(k - 1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(k);
      }
    }
  }
  
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
      begr localbegr = (begr)behe.a(getActivity(), null);
      localbegr.a(super.getString(2131630692));
      localbegr.a(2131625147, 3);
      localbegr.c(2131625035);
      localbegr.a(new afkn(this, paramMessageRecord, localbegr));
      localbegr.show();
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
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramCalendar == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131652967));
      this.jdField_d_of_type_Boolean = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      Calendar localCalendar = ((ajmp)localObject).b();
      localObject = ((ajmp)localObject).c();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131628753));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131627389, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131627390, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    u();
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = this.jdField_a_of_type_Ajmp.b();
    boolean bool = this.jdField_a_of_type_Ajmp.g();
    Object localObject1;
    int j;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_Ajmp.b();
      localObject2 = new StringBuilder().append("mode: ").append(k).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        j = 0;
        QLog.d("Q.history.C2CAllFragment", 2, j);
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
      j = localObject1.length;
      break;
      if (k != 0) {
        break label326;
      }
      if ((!paramBoolean1) && (!this.jdField_a_of_type_Ajmp.i()))
      {
        a(super.getString(2131630947), super.getString(2131630950), 2130844190, super.getString(2131630945), super.getString(2131630946), "", true);
        this.jdField_a_of_type_Ajmp.d(true);
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((!paramBoolean1) || (this.jdField_a_of_type_Ajmp.i())) {
        break label310;
      }
      if (!this.h) {
        break label274;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
    return;
    label274:
    this.jdField_a_of_type_Ajmp.d(true);
    ChatHistoryAuthDevForRoamMsgFragment.a(getActivity(), 32);
    getActivity().overridePendingTransition(2130771979, 2130771977);
    this.h = true;
    return;
    label310:
    if (!bool)
    {
      p();
      return;
    }
    d(paramBoolean3);
    return;
    label326:
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Ajmp.b() != null)
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
        z();
        ((AccountManager)localObject1).refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afkz(this, paramBoolean3));
        return;
      }
      t();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131630949);
    }
    for (Object localObject2 = super.getString(2131630944);; localObject2 = super.getString(2131630943))
    {
      a(super.getString(2131630947), (String)localObject1, 2130844190, (String)localObject2, "", "", false);
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131630948);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.i = true;
    paramView = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    paramListView = this.jdField_a_of_type_Acke.jdField_b_of_type_JavaUtilCalendar;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.b();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5))) {
        a(2130839293, super.getString(2131628753));
      }
    }
    else
    {
      return false;
    }
    if (paramView.e()) {
      paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
    }
    for (;;)
    {
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
      paramView.a(2, null, false);
      return false;
      paramView.b(paramListView);
    }
  }
  
  protected void b() {}
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
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
    ((ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(1, null, false);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ajmp localajmp = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    if (paramMessageRecord != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramMessageRecord.time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = localajmp.c();
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2))) {
        break label97;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
    return;
    label97:
    localajmp.a(paramMessageRecord);
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
    int j;
    int k;
    StringBuilder localStringBuilder1;
    int m;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      j = 0;
      k = j;
      if (j > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
        k = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay scrollx: " + k + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(k, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      j = paramCalendar.get(1);
      k = paramCalendar.get(2) + 1;
      m = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(j).append("-");
      if (k <= 9) {
        break label355;
      }
      paramCalendar = Integer.valueOf(k);
      label240:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (m <= 9) {
        break label379;
      }
    }
    label355:
    label379:
    for (paramCalendar = Integer.valueOf(m);; paramCalendar = "0" + m)
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
      j = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      break;
      paramCalendar = "0" + k;
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
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 14: 
      q();
      paramMessage = (Bundle)paramMessage.obj;
      String str = paramMessage.getString("showText");
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTag(paramMessage);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajmp.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    z();
    anoc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afky(this, l, paramBoolean));
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
        u();
        paramMessage = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
    this.jdField_a_of_type_Ajmp.c(true);
    this.jdField_a_of_type_Ajmp.a(paramBoolean);
  }
  
  public void e()
  {
    super.e();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Acke, null);
    if (this.jdField_a_of_type_Acke != null) {
      this.jdField_a_of_type_Acke.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(getActivity());
    QQLiveImage.onForeground(getActivity());
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnResume");
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 1, 0, "", "", "", "");
    this.jdField_a_of_type_Ajmp.b(hashCode());
    this.jdField_a_of_type_Ajmp.a(this);
    A();
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
      j = paramMessage.get(1);
      k = paramMessage.get(2) + 1;
      m = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(j).append("-");
      if (k > 9)
      {
        paramMessage = Integer.valueOf(k);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (m <= 9) {
          break label210;
        }
      }
      for (paramMessage = Integer.valueOf(m);; paramMessage = "0" + m)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        if (a()) {
          break;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
        paramMessage = "0" + k;
        break label124;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    label210:
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = ((Calendar)localObject2).get(1);
    int k = ((Calendar)localObject2).get(2) + 1;
    int m = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(j).append("-");
    if (k > 9)
    {
      localObject1 = Integer.valueOf(k);
      label317:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (m <= 9) {
        break label493;
      }
    }
    label493:
    for (Object localObject1 = Integer.valueOf(m);; localObject1 = "0" + m)
    {
      localStringBuilder2.append(localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Ajmp.a();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.jdField_a_of_type_JavaUtilCalendar))) {
        break label519;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131652967));
      return;
      localObject1 = "0" + k;
      break label317;
    }
    label519:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      bajr.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_a_of_type_Ajmp.a(5, (Calendar)localObject2, true);
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
    if (this.jdField_a_of_type_Ajmp != null) {
      this.jdField_a_of_type_Ajmp.b(this);
    }
    ahox localahox = ahox.a();
    if ((localahox.c()) && (localahox.a())) {
      localahox.d();
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
        t();
        break;
        a(2130839293, super.getString(2131627384));
      }
      t();
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
        localObject = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
        ((ajmp)localObject).a(0, null, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ajmp)localObject).b(), ((ajmp)localObject).c(), false);
        b(((ajmp)localObject).a());
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
          localObject = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
          if (((ajmp)localObject).b())
          {
            ((ajmp)localObject).a(1, null, false);
            ((ajmp)localObject).a();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ajmp)localObject).b(), ((ajmp)localObject).c(), true);
            b(((ajmp)localObject).a());
            break;
            ((ajmp)localObject).a(0, null, false);
          }
          if (this.jdField_a_of_type_Ajmp.h()) {
            a(2130839293, super.getString(2131627385));
          }
          q();
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
          localObject = Calendar.getInstance();
          StringBuilder localStringBuilder1 = new StringBuilder();
          int j = ((Calendar)localObject).get(1);
          int k = ((Calendar)localObject).get(2) + 1;
          int m = ((Calendar)localObject).get(5);
          StringBuilder localStringBuilder2 = localStringBuilder1.append(j).append("-");
          if (k > 9)
          {
            localObject = Integer.valueOf(k);
            label427:
            localStringBuilder2 = localStringBuilder2.append(localObject).append("-");
            if (m <= 9) {
              break label561;
            }
          }
          label561:
          for (localObject = Integer.valueOf(m);; localObject = "0" + m)
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
            localObject = "0" + k;
            break label427;
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
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(j);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof adey)))
        {
          localObject = (adey)((View)localObject).getTag();
          if (((adey)localObject).a != null) {
            ((URLDrawable)((adey)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        j += 1;
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
      if (this.jdField_a_of_type_Ajmp != null)
      {
        this.jdField_a_of_type_Ajmp.p();
        this.jdField_a_of_type_Ajmp.a(hashCode());
        this.jdField_a_of_type_Ajmp.b(this);
      }
      E();
      v();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aket);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axfi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_a_of_type_Acke.c();
      QQLiveImage.releaseAll(getActivity());
    }
  }
  
  public void g(Message paramMessage)
  {
    ajmp localajmp = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
    for (int j = 1;; j = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (j == 0) {
        localajmp.c(localCalendar);
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
    localajmp.e();
    return;
    if (paramMessage.arg1 == -1) {}
    for (;;)
    {
      localajmp.e();
      return;
      paramMessage = localajmp.a();
      if (paramMessage != null) {
        a(2130839293, super.getString(2131627386, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localajmp.e();
    return;
    q();
    a();
    return;
    q();
    return;
    v();
    a(2130839278, super.getString(2131625933));
    getActivity().setResult(-1);
    getActivity().finish();
    return;
    v();
    ((ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).j();
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  void j()
  {
    super.j();
    ChatHistoryC2CSettingFragment.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 41);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "onClick event unknow id: " + paramView.getId());
      }
    case 2131311503: 
    case 2131300167: 
      long l;
      do
      {
        do
        {
          return;
          paramView = bant.a("vipRoamChatBanner");
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(getActivity(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            startActivity((Intent)localObject);
            bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.history.C2CAllFragment", 2, "onClick blue tipe goUrl is null");
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l;
      r();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
      return;
    }
    paramView = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    Object localObject = this.jdField_a_of_type_Acke.jdField_a_of_type_JavaUtilCalendar;
    if (localObject != null)
    {
      if (paramView.e()) {
        paramView.a(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
      }
      for (;;)
      {
        Calendar localCalendar = paramView.c();
        if ((localCalendar == null) || (((Calendar)localObject).get(1) != localCalendar.get(1)) || (((Calendar)localObject).get(2) != localCalendar.get(2)) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
          break;
        }
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
        paramView.b((Calendar)localObject);
      }
    }
    this.i = true;
    paramView.a(3, null, false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131493217, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramViewGroup = getActivity().getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramViewGroup.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramViewGroup.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc = new ackc();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131309736);
    paramViewGroup.setOnDispatchListener(new afkv(this));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getActivity().finish();
      return null;
    }
    if (ackc.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc)) {
      paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a);
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24));
    this.jdField_a_of_type_Ajmp = ((ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
    this.jdField_a_of_type_Ajmp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(0L);
    B();
    D();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aket);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axfi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
    this.jdField_a_of_type_Ajmp.o();
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    adot.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    QQLiveImage.onBackground(getActivity());
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
        break label405;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
        localObject1 = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
        localObject2 = ((ajmp)localObject1).c();
        if ((localObject2 != null) && (this.jdField_c_of_type_JavaUtilCalendar.get(1) <= ((Calendar)localObject2).get(1)) && (this.jdField_c_of_type_JavaUtilCalendar.get(2) <= ((Calendar)localObject2).get(2)) && (this.jdField_c_of_type_JavaUtilCalendar.get(5) < ((Calendar)localObject2).get(5)))
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (((ajmp)localObject1).d())
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
      label219:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramAbsListView.getChildAt(3);
        if (localObject1 != null) {
          break label437;
        }
        localObject2 = null;
      }
      label243:
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
        break label453;
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
      label405:
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131298565);
      break;
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131298565);
      break label219;
      label437:
      localObject2 = (ChatMessage)((View)localObject1).getTag(2131298565);
      break label243;
      label453:
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
      this.jdField_a_of_type_Ahpg.a(14);
    }
    int j;
    int k;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ahpg.a(12);
        AbstractGifImage.pauseAll();
        QQLiveImage.pauseAll(getActivity());
      } while ((paramAbsListView == null) || (this.jdField_a_of_type_Acke == null));
      paramInt = paramAbsListView.getLastVisiblePosition();
      j = paramAbsListView.getCount();
      k = paramAbsListView.getFirstVisiblePosition();
    } while ((paramInt != j - 1) || (j == 0) || (k == 0) || (this.i));
    QLog.d("Q.history.C2CAllFragment", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    Calendar localCalendar1 = this.jdField_a_of_type_Acke.jdField_a_of_type_JavaUtilCalendar;
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
        break label314;
      }
      paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.i = true;
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label314:
      paramAbsListView.b(localCalendar1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.jdField_b_of_type_AndroidViewView.findViewById(2131309736);
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ackc.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc))) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a);
    }
  }
  
  public void p()
  {
    if (getActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl activity is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl ! ");
    }
    this.jdField_a_of_type_Ajmp.c(0);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    startActivityForResult(localIntent, 30);
  }
  
  public void q()
  {
    o();
  }
  
  void r()
  {
    ajmp localajmp = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_Afry = new afry(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localajmp.k());
    this.jdField_a_of_type_Afry.setOnDismissListener(new afkx(this));
    this.jdField_a_of_type_Afry.show();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131309915));
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297934).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300167);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  public void t()
  {
    z();
    ajmp localajmp = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    localajmp.c(false);
    localajmp.k();
  }
  
  public void u()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  void v()
  {
    try
    {
      if (this.jdField_b_of_type_Bbms != null)
      {
        this.jdField_b_of_type_Bbms.dismiss();
        this.jdField_b_of_type_Bbms.cancel();
        this.jdField_b_of_type_Bbms = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer = ((ChatHistoryTimeLineContainer)this.jdField_b_of_type_AndroidViewView.findViewById(2131312757));
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131309900));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311480));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131312756);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131312755));
    if (a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void x()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new afkq(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */