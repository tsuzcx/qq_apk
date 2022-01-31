package com.tencent.mobileqq.activity.history;

import actn;
import acuv;
import acux;
import acuz;
import adqa;
import adtl;
import aduc;
import adve;
import adzh;
import adzr;
import adzs;
import aeah;
import aecg;
import afwj;
import afwk;
import afwm;
import afwn;
import afwo;
import afwp;
import afwq;
import afwr;
import afws;
import afwt;
import afwu;
import afwv;
import afww;
import afwx;
import afyj;
import agdx;
import aibp;
import aibs;
import aiby;
import ajsf;
import akay;
import akba;
import aktf;
import akwc;
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
import aoen;
import aouj;
import aozc;
import axqw;
import ayfl;
import bbcl;
import bbev;
import bbpp;
import bcpq;
import bcpw;
import bfmt;
import bfob;
import bfol;
import bfoy;
import bftk;
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
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.history.widget.ChatHistoryTimeLineContainer;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
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
  implements acuz, akba, View.OnClickListener, bfob, bftk
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public acux a;
  public agdx a;
  public akay a;
  private aktf jdField_a_of_type_Aktf = new afwm(this);
  public BroadcastReceiver a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  IntentFilter jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afwj(this);
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private aouj jdField_a_of_type_Aouj = new afwp(this);
  ayfl jdField_a_of_type_Ayfl = new afwo(this);
  public bcpq a;
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
  private bcpq jdField_b_of_type_Bcpq;
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
  boolean i = false;
  private boolean j;
  
  public ChatHistoryC2CAllFragment()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler = new afwr(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void A()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    boolean bool1 = bbev.d(BaseApplication.getContext());
    boolean bool2 = this.jdField_a_of_type_Akay.h();
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
      if (!this.jdField_a_of_type_Akay.f())
      {
        akwc localakwc = (akwc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(59);
        label92:
        StringBuilder localStringBuilder;
        if (localakwc != null)
        {
          localakwc.a();
          if (!QLog.isColorLevel()) {
            break label141;
          }
          localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (localakwc != null) {
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(ajsf.G))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = super.getString(2131719974);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, bbcl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "uin type illegal: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void C()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131561535, null));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131370719));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new afwt(this));
    this.jdField_b_of_type_AndroidWidgetTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a();
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.b();
    this.jdField_d_of_type_Boolean = true;
    u();
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369275));
    View localView = LayoutInflater.from(getActivity()).inflate(2131558825, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365675);
    s();
    C();
    y();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.jdField_e_of_type_AndroidViewView = getActivity().getLayoutInflater().inflate(2131561471, null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131375054));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131370422));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131363430).setOnClickListener(this);
    this.jdField_a_of_type_Acux = new acux(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null, this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Acux);
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
            paramView = actn.a(paramView);
            if (adzr.class.isInstance(paramView))
            {
              ((adzr)paramView).a();
              return;
            }
            if (aeah.class.isInstance(paramView))
            {
              ((aeah)paramView).a();
              return;
            }
            if (adtl.class.isInstance(paramView))
            {
              ((adtl)paramView).a();
              return;
            }
            if (!(paramView instanceof aecg)) {
              break label141;
            }
            paramView = (aecg)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof adve)) {
            break label168;
          }
          paramView = (adve)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof aduc));
      paramView = (aduc)paramView;
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
    return (this.jdField_a_of_type_Afwh instanceof afyj);
  }
  
  private void h(Message paramMessage)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      paramMessage = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if (paramMessage != null) {
        paramMessage.d();
      }
    }
  }
  
  private void i(Message paramMessage)
  {
    boolean bool3 = true;
    int k = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    boolean bool1;
    boolean bool2;
    if (paramMessage.arg2 == 1)
    {
      bool1 = true;
      q();
      if ((k != 0) || (localDevlockInfo == null)) {
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
    if (1 == this.jdField_a_of_type_Akay.b())
    {
      t();
      return;
    }
    if (!this.jdField_a_of_type_Akay.g())
    {
      p();
      return;
    }
    d(bool1);
  }
  
  private void j(Message paramMessage)
  {
    boolean bool = true;
    int k;
    if (paramMessage.arg1 == 1)
    {
      k = 1;
      if (paramMessage.arg2 != 1) {
        break label39;
      }
    }
    for (;;)
    {
      q();
      if (k == 0) {
        break label44;
      }
      d(bool);
      return;
      k = 0;
      break;
      label39:
      bool = false;
    }
    label44:
    t();
  }
  
  private void k(Message paramMessage)
  {
    int k;
    int m;
    if (paramMessage.arg1 == 1)
    {
      k = 1;
      m = paramMessage.arg2;
      paramMessage = (byte[])paramMessage.obj;
      if (k == 0) {
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
      k = 0;
      break;
      paramMessage = (AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0);
      if (paramMessage != null)
      {
        z();
        paramMessage.refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afwq(this));
        return;
      }
      t();
      return;
      if ((2 != m) && (3 != m)) {
        break label140;
      }
      d(false);
    } while (2 != m);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    return;
    label140:
    t();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2131561535, null));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377316));
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
      this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new afwx(this);
    }
    a(getString(2131719796), this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
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
    int k;
    int m;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      k = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(k))
      {
        localCalendar.add(5, k);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label247;
      }
      k += 1;
      m = k;
      if (k < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.jdField_a_of_type_Int)
      {
        if (!paramObject.get(k)) {
          break label238;
        }
        m = k;
      }
      k = m * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
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
      QLog.d("Q.history.C2CAllFragment", 2, paramObject + ",idnex=" + m + ",old crollX=" + paramInt1 + ",expect crollX=" + k);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(k, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, m);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      label238:
      k += 1;
      break;
      label247:
      k -= 1;
      for (;;)
      {
        m = k;
        if (k < 0) {
          break;
        }
        m = k;
        if (paramObject.get(k)) {
          break;
        }
        k -= 1;
      }
    }
  }
  
  public void a()
  {
    QLog.d("Q.history.C2CAllFragment", 1, "gotoCheckPasswordUrl ! ");
    this.jdField_a_of_type_Akay.c(1);
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
            this.jdField_a_of_type_Akay.b();
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
            QLog.d("Q.history.C2CAllFragment", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_a_of_type_Akay.b());
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
    bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt, paramString, 0).b(getActivity().getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int k = 1;
    switch (paramMessage.what)
    {
    default: 
      if (k != 0) {
        u();
      }
      break;
    }
    label456:
    int m;
    do
    {
      return;
      paramMessage = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
      {
        a(2130839317, super.getString(2131693025));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        k = 1;
      }
      for (;;)
      {
        q();
        break;
        if (paramMessage.a() == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
          this.jdField_a_of_type_Acux.b(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_Acux.notifyDataSetChanged();
          k = 1;
        }
        else if (this.j)
        {
          paramMessage.g();
          k = 1;
        }
        else
        {
          localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
          ((Message)localObject).obj = paramMessage.a();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          k = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.d()) && (paramMessage.a() == 3)) || ((paramMessage.c()) && (paramMessage.a() == 2)) || ((paramMessage.c()) && ((paramMessage.a() == 0) || (paramMessage.a() == 1))))
        {
          a(2130839317, super.getString(2131693025));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        if (paramMessage.a() == 4) {
          break label456;
        }
        if (this.j)
        {
          paramMessage.g();
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33);
        ((Message)localObject).obj = paramMessage.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        k = 0;
        break;
      }
      if (paramMessage.a != null) {
        b(paramMessage.a());
      }
      if (paramMessage.a() == 4) {
        this.jdField_a_of_type_Acux.b(this.jdField_a_of_type_JavaUtilList);
      }
      this.j = false;
      q();
      if ((this.jdField_a_of_type_Acux == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label575;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      m = this.jdField_a_of_type_Acux.a((List)localObject, paramMessage.a(), paramMessage.a(), paramMessage.d, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.a);
    } while (paramMessage.a() == 4);
    if (this.jdField_a_of_type_Acux.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Acux.jdField_a_of_type_Int);
    }
    for (;;)
    {
      label575:
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718792));
      }
      paramMessage.h();
      break;
      if (m >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(m - 1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(m);
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
      bfol localbfol = (bfol)bfoy.a(getActivity(), null);
      localbfol.a(super.getString(2131696395));
      localbfol.a(2131690708, 3);
      localbfol.c(2131690596);
      localbfol.a(new afwk(this, paramMessageRecord, localbfol));
      localbfol.show();
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131718792));
      this.jdField_d_of_type_Boolean = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      Calendar localCalendar = ((akay)localObject).b();
      localObject = ((akay)localObject).c();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131694406));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131693029, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(super.getString(2131693030, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    u();
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = this.jdField_a_of_type_Akay.b();
    boolean bool = this.jdField_a_of_type_Akay.g();
    Object localObject1;
    int k;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_Akay.b();
      localObject2 = new StringBuilder().append("mode: ").append(m).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        k = 0;
        QLog.d("Q.history.C2CAllFragment", 2, k);
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
      k = localObject1.length;
      break;
      if (m != 0) {
        break label326;
      }
      if ((!paramBoolean1) && (!this.jdField_a_of_type_Akay.i()))
      {
        a(super.getString(2131696659), super.getString(2131696662), 2130844267, super.getString(2131696657), super.getString(2131696658), "", true);
        this.jdField_a_of_type_Akay.d(true);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((!paramBoolean1) || (this.jdField_a_of_type_Akay.i())) {
        break label310;
      }
      if (!this.h) {
        break label274;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
    return;
    label274:
    this.jdField_a_of_type_Akay.d(true);
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
      if (this.jdField_a_of_type_Akay.b() != null)
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
        ((AccountManager)localObject1).refreshDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afww(this, paramBoolean3));
        return;
      }
      t();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131696661);
    }
    for (Object localObject2 = super.getString(2131696656);; localObject2 = super.getString(2131696655))
    {
      a(super.getString(2131696659), (String)localObject1, 2130844267, (String)localObject2, "", "", false);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131696660);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.j = true;
    paramView = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    paramListView = this.jdField_a_of_type_Acux.jdField_b_of_type_JavaUtilCalendar;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.b();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5))) {
        a(2130839317, super.getString(2131694406));
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
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
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
    ((akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(1, null, false);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    akay localakay = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    if (paramMessageRecord != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramMessageRecord.time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = localakay.c();
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2))) {
        break label97;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
    return;
    label97:
    localakay.a(paramMessageRecord);
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
    int k;
    int m;
    StringBuilder localStringBuilder1;
    int n;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      k = 0;
      m = k;
      if (k > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int) {
        m = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay scrollx: " + m + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a(m, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      k = paramCalendar.get(1);
      m = paramCalendar.get(2) + 1;
      n = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(k).append("-");
      if (m <= 9) {
        break label355;
      }
      paramCalendar = Integer.valueOf(m);
      label240:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (n <= 9) {
        break label379;
      }
    }
    label355:
    label379:
    for (paramCalendar = Integer.valueOf(n);; paramCalendar = "0" + n)
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
      k = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      break;
      paramCalendar = "0" + m;
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
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akay.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    z();
    aoen.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new afwv(this, l, paramBoolean));
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
        paramMessage = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
    this.jdField_a_of_type_Akay.c(true);
    this.jdField_a_of_type_Akay.a(paramBoolean);
    this.jdField_a_of_type_Akay.f();
  }
  
  public void e()
  {
    super.e();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Acux, null);
    if (this.jdField_a_of_type_Acux != null) {
      this.jdField_a_of_type_Acux.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(getActivity());
    QQLiveImage.onForeground(getActivity());
    adzh.f();
    ShortVideoRealItemBuilder.f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnResume");
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 1, 0, "", "", "", "");
    this.jdField_a_of_type_Akay.b(hashCode());
    this.jdField_a_of_type_Akay.a(this);
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
      k = paramMessage.get(1);
      m = paramMessage.get(2) + 1;
      n = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(k).append("-");
      if (m > 9)
      {
        paramMessage = Integer.valueOf(m);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (n <= 9) {
          break label210;
        }
      }
      for (paramMessage = Integer.valueOf(n);; paramMessage = "0" + n)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
        if (a()) {
          break;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
        paramMessage = "0" + m;
        break label124;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    label210:
    StringBuilder localStringBuilder1 = new StringBuilder();
    int k = ((Calendar)localObject2).get(1);
    int m = ((Calendar)localObject2).get(2) + 1;
    int n = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append("-");
    if (m > 9)
    {
      localObject1 = Integer.valueOf(m);
      label317:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (n <= 9) {
        break label493;
      }
    }
    label493:
    for (Object localObject1 = Integer.valueOf(n);; localObject1 = "0" + n)
    {
      localStringBuilder2.append(localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder1.toString());
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Akay.a();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.jdField_a_of_type_JavaUtilCalendar))) {
        break label519;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718792));
      return;
      localObject1 = "0" + m;
      break label317;
    }
    label519:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      VipUtils.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_a_of_type_Akay.a(5, (Calendar)localObject2, true);
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
    if (this.jdField_a_of_type_Akay != null) {
      this.jdField_a_of_type_Akay.b(this);
    }
    aibp localaibp = aibp.a();
    if ((localaibp.c()) && (localaibp.a())) {
      localaibp.d();
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
        a(2130839317, super.getString(2131693024));
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
        localObject = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
        ((akay)localObject).a(0, null, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((akay)localObject).b(), ((akay)localObject).c(), false);
        b(((akay)localObject).a());
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
          localObject = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
          if (((akay)localObject).b())
          {
            ((akay)localObject).a(1, null, false);
            ((akay)localObject).a();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((akay)localObject).b(), ((akay)localObject).c(), true);
            b(((akay)localObject).a());
            break;
            ((akay)localObject).a(0, null, false);
          }
          if (this.jdField_a_of_type_Akay.h()) {
            a(2130839317, super.getString(2131693025));
          }
          q();
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.a();
          localObject = Calendar.getInstance();
          StringBuilder localStringBuilder1 = new StringBuilder();
          int k = ((Calendar)localObject).get(1);
          int m = ((Calendar)localObject).get(2) + 1;
          int n = ((Calendar)localObject).get(5);
          StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append("-");
          if (m > 9)
          {
            localObject = Integer.valueOf(m);
            label427:
            localStringBuilder2 = localStringBuilder2.append(localObject).append("-");
            if (n <= 9) {
              break label561;
            }
          }
          label561:
          for (localObject = Integer.valueOf(n);; localObject = "0" + n)
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
            localObject = "0" + m;
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
      int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int k = 0;
      while (k < m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(k);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof adqa)))
        {
          localObject = (adqa)((View)localObject).getTag();
          if (((adqa)localObject).a != null) {
            ((URLDrawable)((adqa)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        k += 1;
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
      if (this.jdField_a_of_type_Akay != null)
      {
        this.jdField_a_of_type_Akay.q();
        this.jdField_a_of_type_Akay.a(hashCode());
        this.jdField_a_of_type_Akay.b(this);
      }
      E();
      v();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aktf);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayfl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aouj);
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_a_of_type_Acux.c();
      QQLiveImage.releaseAll(getActivity());
    }
  }
  
  public void g(Message paramMessage)
  {
    akay localakay = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
    for (int k = 1;; k = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (k == 0) {
        localakay.c(localCalendar);
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
    localakay.e();
    return;
    if (paramMessage.arg1 == -1) {}
    for (;;)
    {
      localakay.e();
      return;
      paramMessage = localakay.a();
      if (paramMessage != null) {
        a(2130839317, super.getString(2131693026, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localakay.e();
    return;
    q();
    a();
    return;
    q();
    return;
    v();
    a(2130839302, super.getString(2131691509));
    getActivity().setResult(-1);
    getActivity().finish();
    return;
    v();
    ((akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).k();
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
    case 2131377316: 
    case 2131365764: 
      long l;
      do
      {
        do
        {
          return;
          paramView = bbpp.a("vipRoamChatBanner");
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(getActivity(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            startActivity((Intent)localObject);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString });
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.history.C2CAllFragment", 2, "onClick blue tipe goUrl is null");
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l;
      r();
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
      return;
    }
    paramView = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    Object localObject = this.jdField_a_of_type_Acux.jdField_a_of_type_JavaUtilCalendar;
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
    this.j = true;
    paramView.a(3, null, false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558773, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramViewGroup = getActivity().getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramViewGroup.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramViewGroup.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv = new acuv();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375491);
    paramViewGroup.setOnDispatchListener(new afws(this));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getActivity().finish();
      return null;
    }
    if (acuv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv)) {
      paramViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.a);
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24));
    this.jdField_a_of_type_Akay = ((akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
    this.jdField_a_of_type_Akay.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(0L);
    B();
    D();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aktf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayfl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aouj);
    this.jdField_a_of_type_Akay.p();
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    adzs.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    QQLiveImage.onBackground(getActivity());
    adzh.e();
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
        break label405;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
        localObject1 = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
        localObject2 = ((akay)localObject1).c();
        if ((localObject2 != null) && (this.jdField_c_of_type_JavaUtilCalendar.get(1) <= ((Calendar)localObject2).get(1)) && (this.jdField_c_of_type_JavaUtilCalendar.get(2) <= ((Calendar)localObject2).get(2)) && (this.jdField_c_of_type_JavaUtilCalendar.get(5) < ((Calendar)localObject2).get(5)))
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (((akay)localObject1).d())
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
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364123);
      break;
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364123);
      break label219;
      label437:
      localObject2 = (ChatMessage)((View)localObject1).getTag(2131364123);
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
      adzh.f();
      ShortVideoRealItemBuilder.f();
      this.jdField_a_of_type_Aiby.a(14);
    }
    int k;
    int m;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Aiby.a(12);
        AbstractGifImage.pauseAll();
        QQLiveImage.pauseAll(getActivity());
        adzh.e();
        ShortVideoRealItemBuilder.e();
      } while ((paramAbsListView == null) || (this.jdField_a_of_type_Acux == null));
      paramInt = paramAbsListView.getLastVisiblePosition();
      k = paramAbsListView.getCount();
      m = paramAbsListView.getFirstVisiblePosition();
    } while ((paramInt != k - 1) || (k == 0) || (m == 0) || (this.j));
    QLog.d("Q.history.C2CAllFragment", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    Calendar localCalendar1 = this.jdField_a_of_type_Acux.jdField_a_of_type_JavaUtilCalendar;
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
        break label326;
      }
      paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.j = true;
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label326:
      paramAbsListView.b(localCalendar1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.jdField_b_of_type_AndroidViewView.findViewById(2131375491);
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (acuv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv))) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.a);
    }
  }
  
  public void p()
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
    this.jdField_a_of_type_Akay.c(0);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "http://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    startActivityForResult(localIntent, 30);
    this.i = true;
  }
  
  public void q()
  {
    o();
  }
  
  void r()
  {
    akay localakay = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_Agdx = new agdx(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakay.k());
    this.jdField_a_of_type_Agdx.setOnDismissListener(new afwu(this));
    this.jdField_a_of_type_Agdx.show();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375676));
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363480).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365764);
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
    akay localakay = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    localakay.c(false);
    localakay.l();
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
      if (this.jdField_b_of_type_Bcpq != null)
      {
        this.jdField_b_of_type_Bcpq.dismiss();
        this.jdField_b_of_type_Bcpq.cancel();
        this.jdField_b_of_type_Bcpq = null;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer = ((ChatHistoryTimeLineContainer)this.jdField_b_of_type_AndroidViewView.findViewById(2131378581));
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375660));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377293));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378580);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378579));
    if (a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void x()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new afwn(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */