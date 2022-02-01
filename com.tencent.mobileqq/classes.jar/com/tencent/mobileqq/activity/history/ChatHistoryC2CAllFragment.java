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
  public List<MessageRecord> A;
  public int B;
  public String C = "";
  String D = "";
  public SessionInfo E;
  public MqqHandler F;
  MessageRoamManager G;
  MediaPlayerManager H;
  DialogInterface.OnCancelListener I;
  boolean J = false;
  boolean K = false;
  boolean L = false;
  boolean M = false;
  boolean N = false;
  View O;
  Handler.Callback P = new ChatHistoryC2CAllFragment.1(this);
  QQProgressDialog Q;
  Handler R = new ChatHistoryC2CAllFragment.3(this);
  TipsBar S;
  RelativeLayout T;
  View U;
  TextView V;
  AutoFitScrollView W;
  public ChatHistoryTimeLineContainer X;
  TimeLineView Y;
  DisplayMetrics Z;
  IntentFilter aa = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  BroadcastReceiver ab = null;
  TeamWorkObserver ac = new ChatHistoryC2CAllFragment.13(this);
  private View ad;
  private View ae;
  private LinearLayout af;
  private LinearLayout ag;
  private Toast ah;
  private TextView ai;
  private ImageView aj;
  private boolean ak = false;
  private Calendar al;
  private Calendar am;
  private Calendar an;
  private View ao;
  private View ap;
  private int aq;
  private int ar;
  private QQProgressDialog as;
  private ProxyObserver at = new ChatHistoryC2CAllFragment.11(this);
  private FMObserver au = new ChatHistoryC2CAllFragment.14(this);
  public ChatXListView s;
  public ChatHistoryAdapterForC2C t;
  boolean u = true;
  public C2CMessageSearchDialog v;
  long w = 0L;
  public LinearLayout x;
  public TipsBar y;
  boolean z = false;
  
  private void D()
  {
    if (this.x == null)
    {
      this.x = ((LinearLayout)View.inflate(getBaseActivity(), 2131628364, null));
      this.s.addHeaderView(this.x);
    }
    this.y = ((TipsBar)this.x.findViewById(2131447420));
    this.y.setOnClickListener(this);
    this.x.setVisibility(0);
    this.y.setVisibility(8);
  }
  
  private void E()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "showDialogLoadingTips activity is null");
      return;
    }
    if (this.I == null) {
      this.I = new ChatHistoryC2CAllFragment.CancelDialogListener(this);
    }
    a(getString(2131916807), this.I);
  }
  
  private void F()
  {
    if (this.K) {
      return;
    }
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    boolean bool2 = this.G.C();
    if ((bool1) && (bool2))
    {
      boolean bool3 = this.G.A();
      bool1 = false;
      if (!bool3)
      {
        MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.a.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
        if (localMessageRoamHandler != null) {
          localMessageRoamHandler.a();
        } else {
          y();
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
      y();
    }
    ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CAllFragment.5(this, bool2));
  }
  
  private boolean G()
  {
    return (this.g instanceof ChatHistoryReadOnlyViewController);
  }
  
  private void H()
  {
    Object localObject;
    if (this.E.a == 0)
    {
      if (this.E.b.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
        this.E.e = super.getString(2131916963);
      } else {
        this.E.e = ContactUtils.a(this.a, this.E.b, this.E.c, ContactUtils.c(this.E.a), 3);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin type illegal: ");
      ((StringBuilder)localObject).append(this.E.a);
      QLog.e("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.E.e))
    {
      localObject = this.E;
      ((SessionInfo)localObject).e = ((SessionInfo)localObject).b;
    }
  }
  
  private void I()
  {
    this.x = ((LinearLayout)View.inflate(getBaseActivity(), 2131628364, null));
    this.S = ((TipsBar)this.x.findViewById(2131439194));
    this.s.addHeaderView(this.x);
    this.S.setOnClickListener(new ChatHistoryC2CAllFragment.6(this));
    this.ai = this.S.getTextView();
    this.aj = this.S.getTipsIconView();
    this.u = true;
    z();
  }
  
  private void J()
  {
    this.s = ((ChatXListView)this.O.findViewById(2131437282));
    View localView = LayoutInflater.from(getBaseActivity()).inflate(2131624523, null);
    localView.setPadding(0, 0, 0, 30);
    this.s.setOverScrollHeader(localView);
    this.s.setOverScrollListener(this);
    this.ad = this.O.findViewById(2131432529);
    x();
    I();
    D();
    this.s.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.s.setOverscrollFooter(null);
    }
    this.ae = getBaseActivity().getLayoutInflater().inflate(2131628284, null);
    this.af = ((LinearLayout)this.ae.findViewById(2131444560));
    this.s.addFooterView(this.ae);
    this.ae.setVisibility(8);
    this.ag = ((LinearLayout)this.ae.findViewById(2131438871));
    this.ag.findViewById(2131429754).setOnClickListener(this);
    this.t = new ChatHistoryAdapterForC2C(this.a, getBaseActivity(), this.E, null, null, this);
    this.s.setAdapter(this.t);
  }
  
  private void K()
  {
    Toast localToast = this.ah;
    if (localToast != null)
    {
      localToast.cancel();
      this.ah = null;
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
    paramView = AIOUtils.b(paramView);
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
      if (((TextItemBuilder.Holder)localObject).w != null) {
        ((TextItemBuilder.Holder)localObject).w.n();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      localObject = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (((MixedMsgItemBuilder.MixedHolder)localObject).a != null) {
        ((MixedMsgItemBuilder.MixedHolder)localObject).a.n();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      localObject = (LongMsgItemBuilder.Holder)paramView;
      if (((LongMsgItemBuilder.Holder)localObject).f != null) {
        ((LongMsgItemBuilder.Holder)localObject).f.n();
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
    if (this.L)
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
      if (this.a != null)
      {
        C();
        this.a.getApp().registerReceiver(this.ab, this.aa, "com.tencent.msg.permission.pushnotify", null);
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
      this.L = true;
      return;
    }
    catch (JSONException paramString1)
    {
      break label95;
    }
  }
  
  private void h(Message paramMessage)
  {
    if (this.z)
    {
      this.z = false;
      paramMessage = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (paramMessage != null) {
        paramMessage.m();
      }
    }
  }
  
  private void i(Message paramMessage)
  {
    int i = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    int j = paramMessage.arg2;
    boolean bool3 = false;
    boolean bool1;
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    v();
    if ((i == 0) && (localDevlockInfo != null))
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
    if (1 == this.G.z())
    {
      y();
      return;
    }
    if (!this.G.B())
    {
      b();
      return;
    }
    d(bool1);
  }
  
  private void j(Message paramMessage)
  {
    int i = paramMessage.arg1;
    boolean bool = false;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramMessage.arg2 == 1) {
      bool = true;
    }
    v();
    if (i != 0)
    {
      d(bool);
      return;
    }
    y();
  }
  
  private void k(Message paramMessage)
  {
    int j = paramMessage.arg1;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    j = paramMessage.arg2;
    paramMessage = (byte[])paramMessage.obj;
    if (i != 0)
    {
      if ((paramMessage != null) && (paramMessage.length > 0))
      {
        d(false);
        return;
      }
      paramMessage = (AccountManager)this.a.getManager(0);
      if (paramMessage != null)
      {
        E();
        paramMessage.refreshDA2(this.a.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.2(this));
        return;
      }
      y();
      return;
    }
    if ((2 != j) && (3 != j))
    {
      y();
      return;
    }
    d(false);
    if (2 == j) {
      VipUtils.a(this.a, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    }
  }
  
  void A()
  {
    try
    {
      if (this.as != null)
      {
        this.as.dismiss();
        this.as.cancel();
        this.as = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void B()
  {
    this.X = ((ChatHistoryTimeLineContainer)this.O.findViewById(2131449053));
    if (G()) {
      this.X.setVisibility(8);
    }
    this.W = ((AutoFitScrollView)this.O.findViewById(2131445370));
    this.Y = ((TimeLineView)this.O.findViewById(2131447383));
    this.Y.a(this.W);
    this.Y.setClickable(false);
    this.Y.setPressed(false);
    this.Y.setEnabled(false);
    this.X.setScrollView(this.W);
    this.O.findViewById(2131449050).setBackgroundColor(getResources().getColor(2131168003));
    this.Z = super.getResources().getDisplayMetrics();
    this.W.setFitWidth(this.Z.widthPixels, this.Y.getItemWidth());
    this.W.setCallback(this.F);
    this.U = this.O.findViewById(2131449052);
    this.V = ((TextView)this.O.findViewById(2131449051));
    if (G())
    {
      this.U.setVisibility(8);
      this.V.setVisibility(8);
    }
  }
  
  void C()
  {
    if (this.ab == null) {
      this.ab = new ChatHistoryC2CAllFragment.12(this);
    }
  }
  
  Calendar a(int paramInt1, int paramInt2, Object paramObject)
  {
    Calendar localCalendar = this.Y.getBegintDate();
    if (paramInt1 > 0)
    {
      int i = paramInt1 / this.Y.getItemWidth();
      paramObject = this.Y.getRoamDateBitMap();
      if (paramObject.get(i))
      {
        localCalendar.add(5, i);
        return localCalendar;
      }
      int j;
      if (paramInt2 > 0) {
        for (;;)
        {
          i += 1;
          j = i;
          if (i >= this.Y.a) {
            break;
          }
          if (paramObject.get(i))
          {
            j = i;
            break;
          }
        }
      }
      i -= 1;
      for (;;)
      {
        j = i;
        if (i < 0) {
          break;
        }
        if (paramObject.get(i))
        {
          j = i;
          break;
        }
        i -= 1;
      }
      i = this.Y.getItemWidth() * j;
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
        localStringBuilder.append(j);
        localStringBuilder.append(",old crollX=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",expect crollX=");
        localStringBuilder.append(i);
        QLog.d("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
      }
      paramObject = this.W;
      paramObject.a(i, paramObject.getScrollY());
      localCalendar.add(5, j);
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
    if (!this.N)
    {
      this.G.d(1);
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
      getBaseActivity().startActivityForResult(localIntent, 30);
      this.N = true;
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
                paramIntent.append(this.G.z());
                QLog.d("Q.history.C2CAllFragment", 2, paramIntent.toString());
              }
              c(false);
              return;
            case 31: 
              paramIntent = this.a.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("message_roam_flag");
              localStringBuilder.append(this.a.getCurrentAccountUin());
              paramInt1 = paramIntent.getInt(localStringBuilder.toString(), -1);
              paramInt2 = this.B;
              if (paramInt1 == paramInt2) {
                return;
              }
              if (paramInt1 > paramInt2) {
                c(true);
              } else if (paramInt1 < paramInt2) {
                c(true);
              }
              this.B = paramInt1;
              return;
            }
            if (paramInt2 == 3000)
            {
              y();
              this.G.i();
            }
            this.N = false;
            this.M = false;
            v();
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
      ForwardUtils.a(this.a, paramIntent, getBaseActivity());
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.makeText(this.a.getApp(), paramInt, paramString, 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    int k = paramMessage.what;
    int j = 0;
    int i = 0;
    Object localObject;
    if (k != 22)
    {
      if (k == 23)
      {
        localObject = (List)paramMessage.obj;
        paramMessage = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          if (paramMessage.j != null) {
            b(paramMessage.e());
          }
          if (paramMessage.s() == 4) {
            this.t.b(this.A);
          }
          this.ak = false;
        }
        else
        {
          if (((paramMessage.l()) && (paramMessage.s() == 3)) || ((paramMessage.k()) && (paramMessage.s() == 2)) || ((paramMessage.k()) && ((paramMessage.s() == 0) || (paramMessage.s() == 1))))
          {
            a(2130840055, super.getString(2131890033));
            this.af.setVisibility(8);
            this.ae.setVisibility(8);
            break label505;
          }
          if (paramMessage.s() != 4)
          {
            if (this.ak)
            {
              paramMessage.q();
              QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ getRoamHistoryForSomeDay");
              break label505;
            }
            localObject = this.F.obtainMessage(33);
            ((Message)localObject).obj = paramMessage.e();
            this.F.sendMessage((Message)localObject);
            QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp succ message not exist");
            i = j;
            break label719;
          }
        }
        v();
        if ((this.t != null) && (localObject != null) && (((List)localObject).size() > 0))
        {
          this.af.setVisibility(8);
          this.ae.setVisibility(8);
          this.ag.setVisibility(8);
          i = this.t.a((List)localObject, paramMessage.s(), paramMessage.e(), paramMessage.h, this.s.getSelectedItemPosition(), paramMessage.j);
          if (paramMessage.s() == 4) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "setSelection ", Integer.valueOf(i), " indexOfClieckedItem", Integer.valueOf(this.t.r) });
          }
          if (this.t.r != -1) {
            this.s.setSelection(this.t.r);
          } else if (i >= 1) {
            this.s.setSelection(i - 1);
          } else {
            this.s.setSelection(i);
          }
        }
        this.s.setEmptyView(this.ad);
        if (!this.u) {
          this.ai.setText(getString(2131915846));
        }
        paramMessage.r();
      }
      label505:
      i = 1;
    }
    else
    {
      paramMessage = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (((paramMessage.l()) && (paramMessage.s() == 3)) || ((paramMessage.k()) && (paramMessage.s() == 2)) || ((paramMessage.k()) && ((paramMessage.s() == 0) || (paramMessage.s() == 1))))
      {
        a(2130840055, super.getString(2131890033));
        this.af.setVisibility(8);
        this.ae.setVisibility(8);
      }
      else if (paramMessage.s() == 4)
      {
        this.s.setEmptyView(this.ad);
        this.t.b(this.A);
        this.t.notifyDataSetChanged();
      }
      else
      {
        if (!this.ak) {
          break label676;
        }
        paramMessage.q();
        QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp getRoamHistoryForSomeDay");
      }
      i = 1;
      break label715;
      label676:
      localObject = this.F.obtainMessage(33);
      ((Message)localObject).obj = paramMessage.e();
      this.F.sendMessage((Message)localObject);
      QLog.d("Q.history.C2CAllFragment", 1, "handleQueryMessageFromDBRsp message not exist");
      label715:
      v();
    }
    label719:
    if (i != 0) {
      z();
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
    Object localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(super.getString(2131893858));
    ((ActionSheet)localObject).addButton(2131887718, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryC2CAllFragment.10(this, paramMessageRecord, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void a(Calendar paramCalendar)
  {
    this.S.setVisibility(0);
    this.aj.setVisibility(0);
    if (paramCalendar == null)
    {
      this.ai.setText(super.getString(2131915846));
      this.u = false;
      return;
    }
    Object localObject = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Calendar localCalendar = ((MessageRoamManager)localObject).f();
    localObject = ((MessageRoamManager)localObject).g();
    if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
    {
      this.ai.setText(super.getString(2131891944));
      this.aj.setVisibility(8);
      return;
    }
    if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
    {
      if (this.u)
      {
        this.ai.setText(super.getString(2131890037, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        this.aj.setVisibility(8);
        return;
      }
      this.ai.setText(super.getString(2131890038, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
      return;
    }
    if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) > 0)) {
      z();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.G.z();
    boolean bool = this.G.B();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.G.H();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mode: ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", isSetPasswd: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", refreshTimeLine: ");
      ((StringBuilder)localObject2).append(paramBoolean3);
      ((StringBuilder)localObject2).append(", devSetup: ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", allowSet: ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append(", da2 length: ");
      int i;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = localObject1.length;
      }
      ((StringBuilder)localObject2).append(i);
      QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "checkAuthMode activity is null");
      return;
    }
    if (j == 0)
    {
      if ((!paramBoolean1) && (!this.G.E()))
      {
        a(super.getString(2131894134), super.getString(2131894137), 2130846522, super.getString(2131894132), super.getString(2131894133), "", true);
        this.G.d(true);
        VipUtils.a(this.a, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((paramBoolean1) && (!this.G.E()))
      {
        if (this.L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
          }
        }
        else
        {
          this.G.d(true);
          ChatHistoryAuthDevForRoamMsgFragment.a(getBaseActivity(), 32);
          getBaseActivity().overridePendingTransition(2130771996, 2130771994);
          this.L = true;
        }
      }
      else
      {
        if (!bool)
        {
          b();
          return;
        }
        d(paramBoolean3);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        if (this.G.H() != null)
        {
          d(paramBoolean3);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.history.C2CAllFragment", 2, "devlock is open but no da2 ticket， refresh da2...");
        }
        localObject1 = (AccountManager)this.a.getManager(0);
        if (localObject1 != null)
        {
          E();
          ((AccountManager)localObject1).refreshDA2(this.a.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.9(this, paramBoolean3));
          return;
        }
        y();
        return;
      }
      if (paramBoolean2)
      {
        localObject1 = super.getString(2131894136);
        localObject2 = super.getString(2131894131);
      }
      else
      {
        localObject1 = super.getString(2131894135);
        localObject2 = super.getString(2131894130);
      }
      a(super.getString(2131894134), (String)localObject1, 2130846522, (String)localObject2, "", "", false);
      VipUtils.a(this.a, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
    }
  }
  
  public void b()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl activity is null");
      return;
    }
    if (!this.M)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl ! ");
      }
      this.G.d(0);
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
      getBaseActivity().startActivityForResult(localIntent, 30);
      this.M = true;
    }
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      localObject = ((MqqHandler)localObject).obtainMessage(paramInt1);
      ((Message)localObject).obj = paramObject;
      ((Message)localObject).arg1 = paramInt2;
      this.F.sendMessage((Message)localObject);
    }
  }
  
  public void b(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 24)
    {
      if (i != 25) {
        return;
      }
      paramMessage = this.a.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip_message_roam_last_request_timestamp");
      localStringBuilder.append(this.a.getCurrentAccountUin());
      paramMessage.putLong(localStringBuilder.toString(), System.currentTimeMillis());
      paramMessage.commit();
      ((MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(1, null, false);
      return;
    }
    d(false);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (paramMessageRecord != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramMessageRecord.time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = localMessageRoamManager.g();
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
    long l1 = this.Y.getBegintDate().getTimeInMillis();
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
      i = 0;
    } else {
      i = (int)((l2 - l1) / 86400000L) * this.Y.getItemWidth();
    }
    int j = i;
    if (i > this.W.a) {
      j = this.W.a;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollToRecentDay scrollx: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", maxWidth: ");
      ((StringBuilder)localObject).append(this.W.a);
      QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.W;
    ((AutoFitScrollView)localObject).a(j, ((AutoFitScrollView)localObject).getScrollY());
    localObject = new StringBuilder();
    int i = paramCalendar.get(1);
    j = paramCalendar.get(2) + 1;
    int k = paramCalendar.get(5);
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("-");
    if (j > 9)
    {
      paramCalendar = Integer.valueOf(j);
    }
    else
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append("0");
      paramCalendar.append(j);
      paramCalendar = paramCalendar.toString();
    }
    ((StringBuilder)localObject).append(paramCalendar);
    ((StringBuilder)localObject).append("-");
    if (k > 9)
    {
      paramCalendar = Integer.valueOf(k);
    }
    else
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append("0");
      paramCalendar.append(k);
      paramCalendar = paramCalendar.toString();
    }
    ((StringBuilder)localObject).append(paramCalendar);
    if (!G())
    {
      this.U.setVisibility(0);
      this.V.setText(((StringBuilder)localObject).toString());
      this.U.invalidate();
    }
    this.F.removeMessages(65538);
    this.F.sendEmptyMessageDelayed(65538, 3000L);
  }
  
  Calendar c(int paramInt)
  {
    Calendar localCalendar = this.Y.getBegintDate();
    if (paramInt > 0) {
      localCalendar.add(5, paramInt / this.Y.getItemWidth());
    }
    return localCalendar;
  }
  
  protected void c() {}
  
  public void c(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 14)
    {
      if (i != 15) {
        return;
      }
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      return;
    }
    v();
    paramMessage = (Bundle)paramMessage.obj;
    String str = paramMessage.getString("showText");
    this.y.setTipsText(str);
    this.y.setTag(paramMessage);
    this.x.setVisibility(0);
    this.y.setVisibility(0);
    VipUtils.a(this.a, "vip", "0X8004F9B", "0X8004F9B", 0, 0, new String[] { this.C });
  }
  
  public void c(String paramString)
  {
    Toast localToast = this.ah;
    if (localToast == null) {
      this.ah = Toast.makeText(getBaseActivity(), paramString, 0);
    } else {
      localToast.setText(paramString);
    }
    this.ah.show();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.G.H() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    E();
    EquipmentLockImpl.a().a(this.a, this.a.getCurrentAccountUin(), new ChatHistoryC2CAllFragment.8(this, l, paramBoolean));
  }
  
  protected void d() {}
  
  public void d(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 27)
    {
      if (i != 28)
      {
        if (i != 33) {
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
      this.u = true;
      z();
      paramMessage = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (paramMessage.w() == true) {
        paramMessage.a(1, null, false);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.G.c(true);
    this.G.a(paramBoolean);
    this.G.p();
  }
  
  public void e(Message paramMessage)
  {
    int i;
    int j;
    int k;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 65540: 
      Calendar localCalendar = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
      if (localCalendar != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        i = localCalendar.get(1);
        j = localCalendar.get(2) + 1;
        k = localCalendar.get(5);
        localStringBuilder.append(i);
        localStringBuilder.append("-");
        if (j > 9)
        {
          localObject = Integer.valueOf(j);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(j);
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append("-");
        if (k > 9)
        {
          localObject = Integer.valueOf(k);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0");
          ((StringBuilder)localObject).append(k);
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append(localObject);
        this.V.setText(localStringBuilder.toString());
        this.U.setVisibility(0);
        localObject = this.G.e();
        if (((localObject != null) && (localCalendar.equals(localObject))) || (localCalendar.equals(this.al)))
        {
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("getForwardRoamHistoryByDate same day: ");
            paramMessage.append(localStringBuilder.toString());
            QLog.d("Q.history.C2CAllFragment", 2, paramMessage.toString());
          }
          if (!this.u) {
            this.ai.setText(getString(2131915846));
          }
        }
        else
        {
          localObject = this.a;
          if (paramMessage.arg2 > 0) {
            paramMessage = "Slip_timelineleft";
          } else {
            paramMessage = "Slip_timelineright";
          }
          VipUtils.a((AppInterface)localObject, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
          this.G.a(5, localCalendar, true);
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
      paramMessage = c(paramMessage.arg1);
      if (paramMessage != null)
      {
        localObject = new StringBuilder();
        i = paramMessage.get(1);
        j = paramMessage.get(2) + 1;
        k = paramMessage.get(5);
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("-");
        if (j > 9)
        {
          paramMessage = Integer.valueOf(j);
        }
        else
        {
          paramMessage = new StringBuilder();
          paramMessage.append("0");
          paramMessage.append(j);
          paramMessage = paramMessage.toString();
        }
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append("-");
        if (k > 9)
        {
          paramMessage = Integer.valueOf(k);
        }
        else
        {
          paramMessage = new StringBuilder();
          paramMessage.append("0");
          paramMessage.append(k);
          paramMessage = paramMessage.toString();
        }
        ((StringBuilder)localObject).append(paramMessage);
        this.V.setText(((StringBuilder)localObject).toString());
        if (!G())
        {
          this.U.setVisibility(0);
          return;
        }
      }
      break;
    case 65538: 
      this.U.setVisibility(8);
      return;
    case 65537: 
      b(this.al);
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
      this.s.setEmptyView(this.ad);
      break;
    case 20: 
      if (this.G.C()) {
        a(2130840055, super.getString(2131890033));
      }
      v();
      this.W.a();
      localObject = Calendar.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = ((Calendar)localObject).get(1);
      int j = ((Calendar)localObject).get(2) + 1;
      int k = ((Calendar)localObject).get(5);
      localStringBuilder.append(i);
      localStringBuilder.append("-");
      if (j > 9)
      {
        localObject = Integer.valueOf(j);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(j);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("-");
      if (k > 9)
      {
        localObject = Integer.valueOf(k);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(k);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append(localObject);
      if (!G())
      {
        this.U.setVisibility(0);
        this.V.setText(localStringBuilder.toString());
        this.U.invalidate();
      }
      this.F.removeMessages(65538);
      this.F.sendEmptyMessageDelayed(65538, 3000L);
      this.s.setEmptyView(this.ad);
      break;
    case 19: 
      if (G())
      {
        localObject = a(getBaseActivity().getIntent());
        if (localObject != null) {
          b((MessageRecord)localObject);
        }
      }
      else
      {
        localObject = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        if (((MessageRoamManager)localObject).c())
        {
          ((MessageRoamManager)localObject).a(1, null, false);
          ((MessageRoamManager)localObject).d();
        }
        else
        {
          ((MessageRoamManager)localObject).a(0, null, false);
        }
        this.Y.setDate(this.a, ((MessageRoamManager)localObject).f(), ((MessageRoamManager)localObject).g(), true);
        b(((MessageRoamManager)localObject).e());
      }
      break;
    case 18: 
      if (G())
      {
        localObject = a(getBaseActivity().getIntent());
        if (localObject != null) {
          b((MessageRecord)localObject);
        }
      }
      else
      {
        localObject = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        ((MessageRoamManager)localObject).a(0, null, false);
        this.Y.setDate(this.a, ((MessageRoamManager)localObject).f(), ((MessageRoamManager)localObject).g(), false);
        b(((MessageRoamManager)localObject).e());
      }
      break;
    case 17: 
      y();
      break;
    case 16: 
      if (paramMessage.arg1 == -1) {
        a(null);
      } else {
        a(2130840055, super.getString(2131890032));
      }
      y();
    }
    this.K = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramMessage.what) });
    }
  }
  
  public void g(Message paramMessage)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (paramMessage.obj != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      long l = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 == 1) {
        i = 1;
      } else {
        i = 0;
      }
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (i == 0) {
        localMessageRoamManager.c(localCalendar);
      }
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 8)
              {
                if (i != 9) {
                  return;
                }
                A();
                ((MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).v();
                getBaseActivity().setResult(-1);
                getBaseActivity().finish();
                return;
              }
              A();
              a(2130839791, super.getString(2131888440));
              getBaseActivity().setResult(-1);
              getBaseActivity().finish();
              return;
            }
            v();
            return;
          }
          a();
          return;
        }
        localMessageRoamManager.n();
        return;
      }
      if (paramMessage.arg1 != -1)
      {
        paramMessage = localMessageRoamManager.e();
        if (paramMessage != null) {
          a(2130840055, super.getString(2131890034, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
        }
      }
      localMessageRoamManager.n();
      return;
    }
    localMessageRoamManager.n();
  }
  
  public void i()
  {
    super.i();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.H.a(this.s, this.t, null);
    ChatHistoryAdapterForC2C localChatHistoryAdapterForC2C = this.t;
    if (localChatHistoryAdapterForC2C != null) {
      localChatHistoryAdapterForC2C.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(getBaseActivity());
    QQLiveImage.onForeground(getBaseActivity());
    ShortVideoItemBuilder.i();
    ShortVideoRealItemBuilder.i();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnResume");
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 1, 0, "", "", "", "");
    this.G.b(hashCode());
    this.G.a(this);
    F();
  }
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnPause");
    }
    Object localObject = this.G;
    if (localObject != null) {
      ((MessageRoamManager)localObject).b(this);
    }
    localObject = AIOSelectableDelegateImpl.a();
    if ((((AIOSelectableDelegateImpl)localObject).l()) && (((AIOSelectableDelegateImpl)localObject).i())) {
      ((AIOSelectableDelegateImpl)localObject).n();
    }
  }
  
  public void k()
  {
    try
    {
      int j = this.s.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = this.s.getChildAt(i);
        if ((((View)localObject1).getTag() != null) && ((((View)localObject1).getTag() instanceof FlashPicItemBuilder.FlashPicHolder)))
        {
          localObject1 = (FlashPicItemBuilder.FlashPicHolder)((View)localObject1).getTag();
          if (((FlashPicItemBuilder.FlashPicHolder)localObject1).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.FlashPicHolder)localObject1).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        i += 1;
      }
      Object localObject2;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.history.C2CAllFragment", 2, "", localException);
      }
      this.F.removeCallbacksAndMessages(null);
      this.R.removeCallbacksAndMessages(null);
      localObject2 = this.G;
      if (localObject2 != null)
      {
        ((MessageRoamManager)localObject2).M();
        this.G.c(hashCode());
        this.G.b(this);
      }
      K();
      A();
      if (this.a.getProxyManager() != null)
      {
        this.a.getProxyManager().removeProxyObserver(this.at);
        this.a.getProxyManager().saveNotify();
      }
      this.a.removeObserver(this.ac);
      this.a.getFileManagerNotifyCenter().deleteObserver(this.au);
      if (this.ab != null)
      {
        this.a.getApp().unregisterReceiver(this.ab);
        this.ab = null;
      }
      localObject2 = this.H;
      if (localObject2 != null) {
        ((MediaPlayerManager)localObject2).a(this.s);
      }
      this.t.d();
      QQLiveImage.releaseAll(getBaseActivity());
    }
  }
  
  protected int l()
  {
    if (G()) {
      return 1600;
    }
    return 1601;
  }
  
  void o()
  {
    super.o();
    ChatHistoryC2CSettingFragment.a(getBaseActivity(), this.E.b, this.E.a, 42);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (i != 2131429754)
    {
      if (i != 2131432634)
      {
        if (i != 2131447420)
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
            VipUtils.a(this.a, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.C });
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
        if (l - this.w > 1000L)
        {
          this.w = l;
          w();
          ReportController.b(this.a, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      localObject1 = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      localObject2 = this.t.s;
      if (localObject2 != null)
      {
        if (((MessageRoamManager)localObject1).w()) {
          ((MessageRoamManager)localObject1).a(((Calendar)localObject2).get(1), ((Calendar)localObject2).get(2), ((Calendar)localObject2).get(5));
        } else {
          ((MessageRoamManager)localObject1).b((Calendar)localObject2);
        }
        Calendar localCalendar = ((MessageRoamManager)localObject1).g();
        if ((localCalendar != null) && (((Calendar)localObject2).get(1) == localCalendar.get(1)) && (((Calendar)localObject2).get(2) == localCalendar.get(2)) && (((Calendar)localObject2).get(5) == localCalendar.get(5)))
        {
          this.ae.setVisibility(8);
          this.af.setVisibility(8);
          this.ag.setVisibility(8);
          break label401;
        }
      }
      this.ak = true;
      ((MessageRoamManager)localObject1).a(3, null, false);
    }
    label401:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624473, paramViewGroup, false);
    this.O = paramLayoutInflater;
    this.E = new SessionInfo();
    paramViewGroup = getBaseActivity().getIntent().getExtras();
    this.E.b = paramViewGroup.getString("uin");
    this.E.a = paramViewGroup.getInt("uintype");
    this.E.c = paramViewGroup.getString("troop_uin");
    this.E.H = new ChatBackground();
    this.E.r = ChatTextSizeSettingActivity.a(getBaseActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.O.findViewById(2131445137);
    paramViewGroup.setOnDispatchListener(new ChatHistoryC2CAllFragment.4(this));
    if (this.a == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getBaseActivity().finish();
      paramLayoutInflater = null;
    }
    else
    {
      if (ChatBackground.a(BaseApplicationImpl.getContext(), this.a.getCurrentAccountUin(), this.E.b, true, 0, this.E.H)) {
        paramViewGroup.setBackgroundDrawable(this.E.H.c);
      }
      this.F = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.P);
      this.H = ((MediaPlayerManager)this.a.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
      this.G = ((MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
      this.G.a(this.E.b);
      this.al = Calendar.getInstance();
      this.an = Calendar.getInstance();
      this.am = Calendar.getInstance();
      this.am.setTimeInMillis(0L);
      H();
      J();
      B();
      if (this.a.getProxyManager() != null)
      {
        this.a.getProxyManager().addProxyObserver(this.at);
        this.a.getProxyManager().saveNotify();
      }
      this.a.addObserver(this.ac);
      this.a.getFileManagerNotifyCenter().addObserver(this.au);
      this.G.K();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    super.onPause();
    ShortVideoPTVItemBuilder.a(this.s);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    QQLiveImage.onBackground(getBaseActivity());
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject3 = null;
    if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0))
    {
      localObject1 = this.af;
      if ((localObject1 != null) && (((LinearLayout)localObject1).getVisibility() != 0))
      {
        localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - 1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = (ChatMessage)((View)localObject1).getTag(2131430591);
        }
        if (localObject1 != null)
        {
          this.an.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
          localObject1 = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
          localObject2 = ((MessageRoamManager)localObject1).g();
          if ((localObject2 != null) && (this.an.get(1) <= ((Calendar)localObject2).get(1)) && (this.an.get(2) <= ((Calendar)localObject2).get(2)) && (this.an.get(5) < ((Calendar)localObject2).get(5)))
          {
            this.ae.setVisibility(0);
            this.ag.setVisibility(0);
          }
          if (((MessageRoamManager)localObject1).l())
          {
            this.ae.setVisibility(8);
            this.ag.setVisibility(8);
          }
        }
      }
    }
    Object localObject1 = paramAbsListView.getChildAt(0);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131430591);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = paramAbsListView.getChildAt(3);
      if (localObject1 == null) {
        localObject1 = localObject3;
      } else {
        localObject1 = (ChatMessage)((View)localObject1).getTag(2131430591);
      }
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      this.al.setTimeInMillis(((ChatMessage)localObject2).time * 1000L);
      this.al.set(11, 0);
      this.al.set(12, 0);
      this.al.set(13, 0);
      this.al.set(14, 0);
      if (!this.al.equals(this.am))
      {
        this.am.setTimeInMillis(this.al.getTimeInMillis());
        this.F.sendEmptyMessageDelayed(65537, 100L);
      }
    }
    if (this.aq < paramInt1)
    {
      a(this.ao);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 > 0) && (paramInt3 < this.ar)) {
        a(this.ap);
      }
    }
    this.aq = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.ar = paramInt1;
    }
    this.ao = paramAbsListView.getChildAt(0);
    this.ap = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      QQLiveImage.resumeAll(getBaseActivity());
      ShortVideoItemBuilder.i();
      ShortVideoRealItemBuilder.i();
      this.m.onMoveToState(18);
      return;
    }
    this.m.onMoveToState(16);
    AbstractGifImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
    if (paramAbsListView != null)
    {
      if (this.t == null) {
        return;
      }
      paramInt = paramAbsListView.getLastVisiblePosition();
      int i = paramAbsListView.getCount();
      int j = paramAbsListView.getFirstVisiblePosition();
      if ((paramInt == i - 1) && (i != 0) && (j != 0) && (!this.ak))
      {
        QLog.d("Q.history.C2CAllFragment", 2, "onScrollStateChanged .... querying querying : ");
        paramAbsListView = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        Calendar localCalendar1 = this.t.s;
        if (localCalendar1 != null)
        {
          Calendar localCalendar2 = paramAbsListView.g();
          if ((localCalendar2 != null) && (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
          {
            this.ae.setVisibility(8);
            this.af.setVisibility(8);
            this.ag.setVisibility(8);
            return;
          }
          if (paramAbsListView.w()) {
            paramAbsListView.a(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
          } else {
            paramAbsListView.b(localCalendar1);
          }
        }
        this.ae.setVisibility(0);
        this.af.setVisibility(0);
        this.ag.setVisibility(8);
        this.ak = true;
        VipUtils.a(this.a, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
        paramAbsListView.a(3, null, false);
      }
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.ak = true;
    paramView = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramListView = this.t.t;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.f();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5)))
      {
        a(2130840055, super.getString(2131891944));
        return false;
      }
      if (paramView.w()) {
        paramView.a(paramListView.get(1), paramListView.get(2), paramListView.get(5));
      } else {
        paramView.b(paramListView);
      }
      VipUtils.a(this.a, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
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
    paramView = this.O.findViewById(2131445137);
    if ((paramView != null) && (this.a != null) && (ChatBackground.a(BaseApplicationImpl.getContext(), this.a.getCurrentAccountUin(), this.E.b, true, 0, this.E.H))) {
      paramView.setBackgroundDrawable(this.E.H.c);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void v()
  {
    u();
  }
  
  void w()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.v = new C2CMessageSearchDialog(getBaseActivity(), this.a, this.E, localMessageRoamManager.I());
    this.v.setOnDismissListener(new ChatHistoryC2CAllFragment.7(this));
    this.v.show();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  void x()
  {
    this.T = ((RelativeLayout)this.O.findViewById(2131445390));
    if (G()) {
      this.T.setVisibility(8);
    }
    this.T.findViewById(2131429816).setVisibility(8);
    EditText localEditText = (EditText)this.T.findViewById(2131432634);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.T != null) && (Build.VERSION.SDK_INT > 10)) {
      this.T.setLayerType(0, null);
    }
  }
  
  public void y()
  {
    E();
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localMessageRoamManager.c(false);
    localMessageRoamManager.x();
  }
  
  public void z()
  {
    if (this.u) {
      this.S.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */