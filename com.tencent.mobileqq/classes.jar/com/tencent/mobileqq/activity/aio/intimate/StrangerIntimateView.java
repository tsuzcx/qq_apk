package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.multicard.CardContent;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class StrangerIntimateView
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, BaseIntimateView
{
  private QQProgressDialog A;
  private View B;
  private IntimateInfo C;
  private IntimateInfoHandler D;
  private int E = 1;
  private Handler F;
  private IFaceDecoder G;
  private Long H;
  private Button I;
  private TextView J;
  private BounceScrollView K;
  private String L;
  private boolean M = false;
  public QQAppInterface a;
  public BaseActivity b;
  public Context c;
  public String d;
  public String e;
  public boolean f = false;
  public boolean g = false;
  MultiCardCustomViewDelegate h;
  AvatarObserver i = new StrangerIntimateView.3(this);
  DecodeTaskCompletionListener j = new StrangerIntimateView.4(this);
  IntimateInfoObserver k = new StrangerIntimateView.5(this);
  private View l;
  private View m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private ImageView q;
  private View r;
  private View s;
  private TextView t;
  private View u;
  private ImageView v;
  private TextView w;
  private TextView x;
  private View y;
  private LinearLayout z;
  
  public StrangerIntimateView(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramBaseActivity;
    this.c = paramContext;
    this.d = paramString;
    paramQQAppInterface = LayoutInflater.from(paramContext).inflate(2131625197, null);
    this.l = paramQQAppInterface.findViewById(2131445159);
    this.m = paramQQAppInterface.findViewById(2131447587);
    this.n = ((TextView)paramQQAppInterface.findViewById(2131429218));
    this.o = ((TextView)paramQQAppInterface.findViewById(2131447546));
    this.p = ((ImageView)paramQQAppInterface.findViewById(2131445565));
    this.q = ((ImageView)paramQQAppInterface.findViewById(2131433781));
    this.r = paramQQAppInterface.findViewById(2131431161);
    this.s = paramQQAppInterface.findViewById(2131431165);
    this.t = ((TextView)paramQQAppInterface.findViewById(2131431164));
    this.u = paramQQAppInterface.findViewById(2131444397);
    this.v = ((ImageView)paramQQAppInterface.findViewById(2131444395));
    this.w = ((TextView)paramQQAppInterface.findViewById(2131444396));
    this.x = ((TextView)paramQQAppInterface.findViewById(2131444398));
    this.B = paramQQAppInterface.findViewById(2131432346);
    this.y = paramQQAppInterface.findViewById(2131433767);
    this.z = ((LinearLayout)paramQQAppInterface.findViewById(2131433761));
    this.I = ((Button)paramQQAppInterface.findViewById(2131427796));
    this.J = ((TextView)paramQQAppInterface.findViewById(2131450022));
    this.K = ((BounceScrollView)paramQQAppInterface.findViewById(2131445370));
    this.K.setOverScrollMode(0);
    this.K.setEdgeEffectEnabled(false);
    this.K.setVerticalScrollBarEnabled(false);
    this.n.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.n.setOnTouchListener(this);
    this.s.setOnTouchListener(this);
    this.u.setOnTouchListener(this);
    this.p.setOnTouchListener(this);
    this.q.setOnTouchListener(this);
    this.B.setOnTouchListener(this);
    if (AppSetting.e)
    {
      this.n.setContentDescription(HardCodeUtil.a(2131901576));
      this.q.setContentDescription(HardCodeUtil.a(2131911879));
      this.p.setContentDescription(HardCodeUtil.a(2131911881));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.m.setLayoutParams(paramQQAppInterface);
    }
    g();
  }
  
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateIntimateInfo: ");
      ((StringBuilder)localObject1).append(paramIntimateInfo);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramIntimateInfo == null) {
      return;
    }
    this.C = paramIntimateInfo;
    this.E = 5;
    h();
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if (this.o != null)
    {
      localObject1 = this.h;
      if (localObject1 != null)
      {
        localObject3 = ((MultiCardCustomViewDelegate)localObject1).m();
        localObject4 = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject1 = this.h.l();
        if (localObject1 != null) {
          localObject1 = ((CardContent)localObject1).d();
        } else {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ((TroopManager)localObject4).e((String)localObject3, this.d);
        }
        this.o.setText((CharSequence)localObject2);
      }
    }
    int i1;
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      i1 = paramIntimateInfo.commonTroopInfoList.size();
      this.r.setVisibility(0);
      this.t.setText(String.valueOf(i1));
      localObject1 = paramIntimateInfo.recentChatTroopInfo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((IntimateInfo.CommonTroopInfo)localObject1).troopUin)))
      {
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        this.w.setText(((IntimateInfo.CommonTroopInfo)localObject1).troopName);
        this.x.setText(paramIntimateInfo.commonTroopTips);
        localObject1 = FaceDrawable.getFaceDrawable(this.a, 4, ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
        this.v.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
      }
      if (this.g)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A21B ", "0X800A21B ", 0, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21B");
      }
    }
    else
    {
      this.r.setVisibility(8);
    }
    if (this.g) {
      o();
    }
    int i2;
    if ((paramIntimateInfo.dnaInfoList != null) && (paramIntimateInfo.dnaInfoList.size() > 0))
    {
      this.y.setVisibility(0);
      if (this.h == null)
      {
        this.z.removeAllViews();
      }
      else
      {
        i2 = this.z.getChildCount();
        if (i2 > 0)
        {
          i1 = 0;
          while (i1 < i2)
          {
            localObject1 = this.z.getChildAt(0);
            this.h.a(this.z, (View)localObject1);
            i1 += 1;
          }
        }
      }
      localObject2 = paramIntimateInfo.dnaInfoList.iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (IntimateInfo.DNAInfo)((Iterator)localObject2).next();
      paramIntimateInfo = null;
      localObject1 = this.h;
      if (localObject1 != null) {
        paramIntimateInfo = ((MultiCardCustomViewDelegate)localObject1).r();
      }
      localObject1 = paramIntimateInfo;
      if (paramIntimateInfo == null) {
        localObject1 = IntimateUtil.a(this.c);
      }
      paramIntimateInfo = (TextView)((View)localObject1).findViewById(2131447585);
      localObject4 = (TextView)((View)localObject1).findViewById(2131447443);
      paramIntimateInfo.setText(((IntimateInfo.DNAInfo)localObject3).wording);
      if (((IntimateInfo.DNAInfo)localObject3).viceTitle != null)
      {
        paramIntimateInfo = new SpannableString(((IntimateInfo.DNAInfo)localObject3).viceTitle);
        if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)localObject3).linkWording))
        {
          int i3 = ((IntimateInfo.DNAInfo)localObject3).viceTitle.indexOf(((IntimateInfo.DNAInfo)localObject3).linkWording);
          i2 = ((IntimateInfo.DNAInfo)localObject3).linkWording.length() + i3;
          i1 = i3;
          if (i3 < 0)
          {
            paramIntimateInfo = new StringBuilder();
            paramIntimateInfo.append(((IntimateInfo.DNAInfo)localObject3).viceTitle);
            paramIntimateInfo.append(((IntimateInfo.DNAInfo)localObject3).linkWording);
            String str = paramIntimateInfo.toString();
            paramIntimateInfo = new SpannableString(str);
            i1 = ((IntimateInfo.DNAInfo)localObject3).viceTitle.length();
            i2 = str.length();
          }
          paramIntimateInfo.setSpan(new StrangerIntimateView.2(this, (IntimateInfo.DNAInfo)localObject3), i1, i2, 33);
          ((TextView)localObject4).setText(paramIntimateInfo);
          ((TextView)localObject4).setMovementMethod(LinkMovementMethod.getInstance());
        }
        else
        {
          ((TextView)localObject4).setText(paramIntimateInfo);
        }
      }
      else
      {
        ((TextView)localObject4).setVisibility(8);
      }
      paramIntimateInfo = new LinearLayout.LayoutParams(-1, -1);
      paramIntimateInfo.topMargin = ViewUtils.dip2px(16.0F);
      this.z.addView((View)localObject1, paramIntimateInfo);
      continue;
      this.y.setVisibility(8);
    }
    QLog.d("Intimatetest2", 2, "ui ok");
  }
  
  private void a(String paramString)
  {
    if (this.A == null)
    {
      BaseActivity localBaseActivity = this.b;
      this.A = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
      this.A.c(true);
    }
    this.A.a(paramString);
    paramString = this.A;
    if ((paramString != null) && (!paramString.isShowing()) && (!this.b.isFinishing())) {
      this.A.show();
    }
  }
  
  private void g()
  {
    String str;
    if (ThemeUtil.isNowThemeIsNight(this.a, true, null)) {
      str = "";
    } else {
      str = FriendIntimateRelationshipConfProcessor.a().d;
    }
    if ((!TextUtils.isEmpty(this.L)) && (str.equals(this.L))) {
      return;
    }
    Object localObject = this.c.getResources().getDrawable(2130841295);
    if (!TextUtils.isEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ViewUtils.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = ViewUtils.getScreenHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(str, localURLDrawableOptions);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.y);
      this.l.setBackgroundDrawable((Drawable)localObject);
      this.L = str;
      return;
    }
    this.l.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void h()
  {
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn begin");
    if ((this.I != null) && (this.J != null))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager.n(this.d))
      {
        this.I.setVisibility(8);
        this.J.setVisibility(8);
      }
      else if (!localFriendsManager.v(this.d))
      {
        this.I.setVisibility(0);
        this.J.setVisibility(8);
        if (this.g)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A218 ", "0X800A218 ", 0, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A218");
        }
      }
      else
      {
        this.I.setVisibility(8);
        this.J.setVisibility(0);
        if (ThemeUtil.isNowThemeIsNight(this.a, false, null)) {
          this.J.setBackgroundResource(2130841280);
        } else {
          this.J.setBackgroundResource(2130841281);
        }
      }
    }
    QLog.d("Intimatetest2", 2, "updateAddFrdBtn end");
  }
  
  private void i()
  {
    QQProgressDialog localQQProgressDialog = this.A;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.A.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void o()
  {
    Object localObject = this.C;
    if (localObject != null)
    {
      if (((IntimateInfo)localObject).dnaInfoList != null)
      {
        localObject = this.C.dnaInfoList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)((Iterator)localObject).next()).linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  public View a()
  {
    return this.l;
  }
  
  public void a(CardContent paramCardContent, String paramString)
  {
    if (paramCardContent == null) {
      return;
    }
    this.d = paramCardContent.c();
    this.e = paramString;
    if (paramCardContent.b != null)
    {
      if (this.F == null) {
        this.F = new Handler(this);
      }
      paramString = this.a;
      if (paramString != null)
      {
        paramString.addObserver(this.k);
        this.a.addObserver(this.i);
      }
      this.C = paramCardContent.b;
      paramString = this.F.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramCardContent.b;
      this.F.sendMessage(paramString);
      paramCardContent = this.K;
      if (paramCardContent != null) {
        paramCardContent.scrollTo(0, 0);
      }
    }
  }
  
  public void a(MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).o();
      this.h = null;
      localObject = this.F;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacksAndMessages(null);
      }
    }
    if (paramMultiCardCustomViewDelegate == null) {
      return;
    }
    this.h = paramMultiCardCustomViewDelegate;
    paramMultiCardCustomViewDelegate = this.h;
    if (paramMultiCardCustomViewDelegate != null) {
      paramMultiCardCustomViewDelegate.c(this.I);
    }
    this.M = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public Bitmap b(String paramString)
  {
    if (this.G == null)
    {
      this.G = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
      this.G.setDecodeTaskCompletionListener(this.j);
    }
    Bitmap localBitmap = this.G.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.G.isPausing()) {
      this.G.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public void b()
  {
    this.F = new Handler(this);
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.k);
      this.a.addObserver(this.i);
    }
    ThreadManager.getSubThreadHandler().post(new StrangerIntimateView.1(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c()
  {
    Bitmap localBitmap = b(this.a.getCurrentAccountUin());
    if (localBitmap != null) {
      this.p.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.d))
    {
      localBitmap = b(this.d);
      if (localBitmap != null) {
        this.q.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.n;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setVisibility(0);
        return;
      }
      localTextView.setVisibility(4);
    }
  }
  
  public void d()
  {
    long l2;
    if (!TextUtils.isEmpty(this.d)) {
      if (NetworkUtil.isNetworkAvailable(this.b))
      {
        if (this.D == null) {
          this.D = ((IntimateInfoHandler)this.a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        localObject = new ArrayList();
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.valueOf(this.d).longValue();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l1;
      long l3;
      label84:
      label86:
      break label84;
    }
    try
    {
      l3 = Long.valueOf(this.e).longValue();
      l2 = l3;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label86;
    }
    l1 = 0L;
    QLog.e("intimate_relationship", 2, "valueOf string err");
    ((ArrayList)localObject).add(Long.valueOf(l1));
    this.D.a(l2, (ArrayList)localObject, null);
    break label187;
    Object localObject = this.F.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = this.c.getResources().getString(2131916775);
    this.F.sendMessage((Message)localObject);
    QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.d }));
    label187:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.d }));
    }
  }
  
  public void e()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      ((MultiCardCustomViewDelegate)localObject).q();
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((BaseActivity)localObject).finish();
    }
  }
  
  public void f()
  {
    h();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return true;
            }
            i();
            return true;
          }
          a((String)paramMessage.obj);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.makeText(this.b, 2, paramMessage, 1).show();
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      QQToast.makeText(this.b, 1, paramMessage, 1).show();
      return true;
    }
    a((IntimateInfo)paramMessage.obj);
    return true;
  }
  
  public void j()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.k);
      this.a.removeObserver(this.i);
    }
    localObject = this.G;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.G = null;
    }
  }
  
  public String k()
  {
    return this.d;
  }
  
  public BaseActivity l()
  {
    return this.b;
  }
  
  public MultiCardCustomViewDelegate m()
  {
    return this.h;
  }
  
  public QQAppInterface n()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject1 = this.H;
    if ((localObject1 == null) || (l1 - ((Long)localObject1).longValue() >= 500L))
    {
      this.H = Long.valueOf(l1);
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131445565: 
        localObject1 = this.h;
        if (localObject1 == null)
        {
          localObject1 = new AllInOne(this.a.getCurrentAccountUin(), 0);
          ProfileUtils.openProfileCard(this.b, (AllInOne)localObject1);
        }
        else
        {
          localObject1 = ((MultiCardCustomViewDelegate)localObject1).m();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.a;
            TroopMemberCardUtils.a((QQAppInterface)localObject2, this.c, (String)localObject1, ((QQAppInterface)localObject2).getCurrentAccountUin(), 0, -1);
          }
          else
          {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131444397: 
        localObject1 = this.C;
        if ((localObject1 != null) && (((IntimateInfo)localObject1).recentChatTroopInfo != null))
        {
          localObject1 = this.C.recentChatTroopInfo;
          localObject2 = AIOUtils.a(new Intent(this.b, SplashActivity.class), null);
          ((Intent)localObject2).putExtra("uin", ((IntimateInfo.CommonTroopInfo)localObject1).troopCode);
          ((Intent)localObject2).putExtra("uintype", 1);
          ((Intent)localObject2).putExtra("uinname", ((IntimateInfo.CommonTroopInfo)localObject1).troopName);
          this.b.startActivity((Intent)localObject2);
        }
        break;
      case 2131433781: 
        localObject1 = this.h;
        if (localObject1 == null)
        {
          localObject1 = new AllInOne(this.d, 19);
          ProfileUtils.openProfileCard(this.b, (AllInOne)localObject1);
        }
        else
        {
          localObject1 = ((MultiCardCustomViewDelegate)localObject1).m();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            TroopMemberCardUtils.a(this.a, this.c, (String)localObject1, this.d, 0, -1);
          } else {
            QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
          }
        }
        break;
      case 2131432346: 
        localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject1 = new Intent((Context)localObject1, FriendProfileMoreInfoActivity.class);
          this.b.startActivity((Intent)localObject1);
        }
        break;
      case 2131431165: 
        localObject1 = this.C;
        if ((localObject1 != null) && (((IntimateInfo)localObject1).commonTroopInfoList != null))
        {
          CommonTroopListActivity.a(this.b, (ArrayList)this.C.commonTroopInfoList, this.E);
          ReportController.b(null, "dc00898", "", "", "0X800A21A ", "0X800A21A ", this.E, 0, "", "", "", "");
          QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A21A");
        }
        break;
      case 2131429218: 
        e();
        break;
      case 2131427796: 
        localObject1 = this.h;
        if ((localObject1 != null) && (((MultiCardCustomViewDelegate)localObject1).p() == 1)) {
          ReportController.b(null, "dc00898", "", "", "0X800A214", "0X800A214", 2, 0, "", "", "", "");
        }
        ReportController.b(null, "dc00898", "", "", "0X800A219 ", "0X800A219 ", 0, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A219");
        localObject1 = this.h;
        if (localObject1 != null)
        {
          String str = ((MultiCardCustomViewDelegate)localObject1).m();
          localObject1 = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
          localObject2 = this.h.l();
          if (localObject2 != null) {
            localObject1 = ((CardContent)localObject2).d();
          } else {
            localObject1 = ((TroopManager)localObject1).f(str, this.d);
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals(this.d)) {
              localObject2 = "";
            }
          }
          localObject1 = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
          Context localContext = this.c;
          localObject1 = ((IAddFriendApi)localObject1).startAddFriend(localContext, 1, this.d, str, 3004, 17, (String)localObject2, null, null, localContext.getString(2131886199), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.c, (Intent)localObject1);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (((i1 == 1) || (i1 == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
  
  public void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView
 * JD-Core Version:    0.7.0.1
 */