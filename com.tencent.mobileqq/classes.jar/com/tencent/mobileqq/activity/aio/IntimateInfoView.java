package com.tencent.mobileqq.activity.aio;

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
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView.Callback;
import com.tencent.mobileqq.activity.aio.intimate.MemoryDayView;
import com.tencent.mobileqq.activity.aio.intimate.OnDragTouchListener;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView;
import com.tencent.mobileqq.activity.aio.intimate.view.LoveTreeView;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.multicard.CardContent;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.vip.manager.LoverDisbandRequestManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class IntimateInfoView
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, BaseIntimateView, IntimateScoreCardView.Callback, FeedListView.LoadFeedCallback
{
  private ArrayList<IntimateContentItemBaseView> A = new ArrayList();
  @Nullable
  private FeedListView B;
  private View C;
  private boolean D;
  private ActionSheet E;
  private IntimateInfoShareHelper F;
  private QQCustomDialog G;
  private IntimateInfo H;
  private IntimateInfoHandler I;
  private int J;
  private int K = 1;
  private Handler L;
  private IFaceDecoder M;
  private boolean N = false;
  private boolean O = false;
  private String P;
  private URLDrawable Q;
  private Long R;
  private MemoryDayView S;
  private RelativeLayout T;
  @Nullable
  private BounceScrollView U;
  private boolean V = false;
  private int W;
  private final boolean X;
  private boolean Y = false;
  private boolean Z = false;
  public QQAppInterface a;
  public BaseActivity b;
  public Context c;
  public String d;
  public String e;
  public boolean f = false;
  public boolean g = false;
  MultiCardCustomViewDelegate h;
  DecodeTaskCompletionListener i = new IntimateInfoView.9(this);
  AvatarObserver j = new IntimateInfoView.10(this);
  IntimateInfoObserver k = new IntimateInfoView.13(this);
  private View l;
  private View m;
  private TextView n;
  private ImageView o;
  private TextView p;
  private QQProgressDialog q;
  private IntimateContentItemFriendInfoView r;
  private IntimateContentItemMutualMarkView s;
  private IntimateContentItemOldDnaView t;
  private IntimateContentItemClueView u;
  private IntimateContentItemLoverEntranceView v;
  private LoveTreeView w;
  private IntimateContentItemGiftView x;
  private IntimateContentItemNewDnaView y;
  private IntimateContentItemLoverAchievementView z;
  
  public IntimateInfoView()
  {
    this.X = false;
  }
  
  public IntimateInfoView(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramBaseActivity;
    this.c = paramContext;
    this.d = paramString;
    try
    {
      l1 = Long.parseLong(this.d);
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label124:
      StringBuilder localStringBuilder;
      boolean bool;
      Object localObject;
      Iterator localIterator;
      break label124;
    }
    l1 = 0L;
    if ((l1 > 0L) && (QZoneApiProxy.needLoadQZoneEnv()))
    {
      paramString = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IntimateInfoView: start to load qzone plugin ");
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("IntimateInfoView", 1, localStringBuilder.toString());
      if (paramString == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new IntimateInfoView.1(this, paramBaseActivity, paramQQAppInterface));
      }
      else
      {
        bool = QZoneApiProxy.needShowAioFeedList(paramBaseActivity, this.a);
        break label237;
      }
    }
    bool = false;
    label237:
    if (bool) {
      try
      {
        paramString = LayoutInflater.from(paramContext).inflate(2131625185, null);
        try
        {
          this.B = ((FeedListView)paramString.findViewById(2131435873));
        }
        catch (Throwable localThrowable1) {}
        QLog.w("IntimateInfoView", 1, "IntimateInfoView: failed to load qzone feed", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        paramString = null;
      }
    } else {
      paramString = null;
    }
    if ((paramString != null) && (this.B != null))
    {
      this.X = true;
    }
    else
    {
      paramString = LayoutInflater.from(paramContext).inflate(2131625171, null);
      this.X = false;
    }
    this.l = paramString.findViewById(2131445159);
    this.m = paramString.findViewById(2131447587);
    this.n = ((TextView)paramString.findViewById(2131429218));
    this.p = ((TextView)paramString.findViewById(2131447546));
    this.o = ((ImageView)paramString.findViewById(2131438103));
    if (this.X) {
      localObject = LayoutInflater.from(paramContext).inflate(2131625172, null);
    } else {
      localObject = paramString;
    }
    this.r = ((IntimateContentItemFriendInfoView)((View)localObject).findViewById(2131433787));
    this.s = ((IntimateContentItemMutualMarkView)((View)localObject).findViewById(2131433800));
    this.t = ((IntimateContentItemOldDnaView)((View)localObject).findViewById(2131433767));
    this.x = ((IntimateContentItemGiftView)((View)localObject).findViewById(2131433776));
    this.u = ((IntimateContentItemClueView)((View)localObject).findViewById(2131433754));
    this.v = ((IntimateContentItemLoverEntranceView)((View)localObject).findViewById(2131437763));
    a(paramString);
    this.y = ((IntimateContentItemNewDnaView)((View)localObject).findViewById(2131433759));
    this.z = ((IntimateContentItemLoverAchievementView)((View)localObject).findViewById(2131431457));
    this.A.add(this.r);
    this.A.add(this.x);
    this.A.add(this.s);
    this.A.add(this.t);
    this.A.add(this.u);
    this.A.add(this.v);
    this.A.add(this.y);
    this.A.add(this.z);
    localIterator = this.A.iterator();
    while (localIterator.hasNext()) {
      ((IntimateContentItemBaseView)localIterator.next()).setIntimateInterface(this);
    }
    this.r.h();
    this.T = ((RelativeLayout)((View)localObject).findViewById(2131438088));
    this.C = ((View)localObject).findViewById(2131433770);
    if (this.X)
    {
      this.B.setOverScrollMode(0);
      this.B.setEdgeEffectEnabled(false);
      this.B.setVerticalScrollBarEnabled(false);
      this.B.addHeaderView((View)localObject);
      this.B.attach(paramQQAppInterface, paramBaseActivity, l1);
      this.D = false;
    }
    else
    {
      this.U = ((BounceScrollView)paramString.findViewById(2131445370));
      this.U.setOverScrollMode(0);
      this.U.setEdgeEffectEnabled(false);
      this.U.setVerticalScrollBarEnabled(false);
    }
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.n.setOnTouchListener(this);
    this.o.setOnTouchListener(this);
    if (AppSetting.e)
    {
      this.n.setContentDescription(HardCodeUtil.a(2131901576));
      this.o.setContentDescription(HardCodeUtil.a(2131903777));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      paramQQAppInterface.setMargins(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      this.m.setLayoutParams(paramQQAppInterface);
    }
  }
  
  private void A()
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      if (((IntimateInfo)localObject).memoryDayInfoList != null)
      {
        localObject = this.H.memoryDayInfoList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(localMemoryDayInfo.linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A207 ", "0X800A207 ", localMemoryDayInfo.dateType, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A207");
          }
        }
      }
      if (this.H.dnaInfoList != null)
      {
        localObject = this.H.dnaInfoList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!TextUtils.isEmpty(((IntimateInfo.DNAInfo)((Iterator)localObject).next()).linkWording))
          {
            ReportController.b(null, "dc00898", "", "", "0X800A209 ", "0X800A209 ", 0, 0, "", "", "", "");
            QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A209");
          }
        }
      }
    }
    else
    {
      QLog.d("intimate_relationship", 2, "DnaLinkReport info null");
    }
  }
  
  private void B()
  {
    if (this.X)
    {
      FeedListView localFeedListView = this.B;
      if (localFeedListView != null)
      {
        int i1 = this.W;
        if ((i1 != 3) && (i1 != 4))
        {
          localFeedListView.loadMore(this);
          return;
        }
        this.Z = true;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str;
    if (ThemeUtil.isNowThemeIsNight(this.a, true, null)) {
      str = FriendIntimateRelationshipHelper.b(paramInt1, paramInt2);
    } else {
      str = FriendIntimateRelationshipHelper.a(paramInt1, paramInt2);
    }
    if ((!TextUtils.isEmpty(this.P)) && (str.equals(this.P))) {
      return;
    }
    Object localObject;
    if (paramInt1 == 3) {
      localObject = this.c.getResources().getDrawable(2130841289);
    } else if (paramInt1 == 2) {
      localObject = this.c.getResources().getDrawable(2130841287);
    } else if (paramInt1 == 1) {
      localObject = this.c.getResources().getDrawable(2130841291);
    } else if (paramInt1 == 26) {
      localObject = this.c.getResources().getDrawable(2130841304);
    } else {
      localObject = this.c.getResources().getDrawable(2130841295);
    }
    QLog.i("intimate_relationship", 1, String.format("setBackgroundDrawable, intimateType: %s, level: %s, bgUrl: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
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
      this.P = str;
      return;
    }
    this.l.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void a(View paramView)
  {
    this.w = ((LoveTreeView)paramView.findViewById(2131437767));
    int i1 = ImmersiveUtils.getStatusBarHeight(this.c);
    int i2 = this.m.getHeight();
    this.w.setOnTouchListener(new OnDragTouchListener(i1 + i2));
    this.w.setVisibility(8);
    this.w.setContentDescription(this.c.getResources().getString(2131890948));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    IntimateInfoShareHelper localIntimateInfoShareHelper = this.F;
    if (localIntimateInfoShareHelper == null)
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.8(this, paramURLDrawable));
      return;
    }
    localIntimateInfoShareHelper.a();
  }
  
  @RequiresApi(api=17)
  private void a(IntimateInfo paramIntimateInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateIntimateInfo: ");
    ((StringBuilder)localObject).append(paramIntimateInfo);
    QLog.i("intimate_relationship", 1, ((StringBuilder)localObject).toString());
    if (paramIntimateInfo == null) {
      return;
    }
    this.H = paramIntimateInfo;
    this.J = paramIntimateInfo.maskType;
    if (paramIntimateInfo.beFriendDays >= -1)
    {
      int i1 = this.J;
      if (i1 == 3)
      {
        this.K = 4;
        this.o.setVisibility(0);
        a(this.J, paramIntimateInfo.maskLevel);
        this.O = true;
      }
      else if (i1 == 2)
      {
        this.K = 3;
        this.o.setVisibility(0);
        a(this.J, paramIntimateInfo.maskLevel);
        this.O = true;
      }
      else if (i1 == 1)
      {
        c(paramIntimateInfo);
        this.w.a(paramIntimateInfo.loveTreeInfo);
      }
      else if (i1 == 26)
      {
        this.K = 5;
        this.v.setVisibility(8);
        this.o.setVisibility(0);
        a(this.J, paramIntimateInfo.maskLevel);
        this.O = true;
      }
      else
      {
        this.K = 1;
        this.o.setVisibility(0);
        a(0, paramIntimateInfo.maskLevel);
        this.O = false;
      }
    }
    else
    {
      this.J = 0;
      a(0, paramIntimateInfo.maskLevel);
    }
    localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).b(paramIntimateInfo, this.J);
    }
    this.s.setReportType(this.K);
    this.x.setReportType(this.K);
    if (this.f) {
      this.v.n();
    }
    b(paramIntimateInfo);
    if (this.g) {
      A();
    }
    if (this.p != null)
    {
      paramIntimateInfo = this.h;
      if (paramIntimateInfo != null)
      {
        String str = paramIntimateInfo.m();
        TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
        paramIntimateInfo = this.h.l();
        if (paramIntimateInfo != null) {
          paramIntimateInfo = paramIntimateInfo.d();
        } else {
          paramIntimateInfo = "";
        }
        localObject = paramIntimateInfo;
        if (TextUtils.isEmpty(paramIntimateInfo)) {
          localObject = localTroopManager.e(str, this.d);
        }
        this.p.setText((CharSequence)localObject);
      }
    }
    IntimatePlayTogetherMiniGameCardView.a(this.l, this.H);
    if (this.g)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", this.K, 0, "", "", "", "");
      if (this.K == 2) {
        ReportController.b(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
      }
    }
    QLog.d("Intimatetest", 2, "ui ok");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (NetworkUtil.isNetworkAvailable(this.b))
      {
        if (this.I == null) {
          this.I = ((IntimateInfoHandler)this.a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        this.I.a(paramString, this.H.maskType);
      }
      else
      {
        Message localMessage = this.L.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = this.c.getResources().getString(2131916775);
        this.L.sendMessage(localMessage);
        QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", new Object[] { paramString }));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, type: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
  
  private void b(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo.memoryDayInfoList != null)
    {
      AbstractGifImage.resumeAll();
      if (this.S == null)
      {
        this.S = new MemoryDayView(this.c, this.d);
        this.S.a(new IntimateInfoView.3(this));
      }
      paramIntimateInfo = new ArrayList(paramIntimateInfo.memoryDayInfoList);
      this.S.a(this.c, paramIntimateInfo);
      if (this.S.a() != null)
      {
        paramIntimateInfo = this.T;
        if (paramIntimateInfo != null)
        {
          paramIntimateInfo.removeAllViews();
          this.T.addView(this.S.a());
          this.T.setVisibility(0);
        }
      }
    }
    else
    {
      paramIntimateInfo = this.T;
      if (paramIntimateInfo != null) {
        paramIntimateInfo.setVisibility(8);
      }
    }
  }
  
  private void c(IntimateInfo paramIntimateInfo)
  {
    this.K = 2;
    this.o.setVisibility(0);
    LoverZoneUtils.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(this.a));
    a(this.J, paramIntimateInfo.maskLevel);
    if ((!this.N) && (this.f))
    {
      this.N = true;
      x();
    }
    this.O = true;
  }
  
  private void c(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.K, 0, "", "", "", "");
    if (this.Q == null)
    {
      e(this.b.getResources().getString(2131891516));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 750;
      localURLDrawableOptions.mRequestHeight = 1272;
      this.Q = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    }
    if ((this.Q.getStatus() != 1) && (this.Q.getStatus() != 4))
    {
      this.Q.setURLDrawableListener(new IntimateInfoView.6(this));
      ThreadManager.getFileThreadHandler().post(new IntimateInfoView.7(this));
      return;
    }
    y();
    a(this.Q);
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
    }
    LoverDisbandRequestManager localLoverDisbandRequestManager = new LoverDisbandRequestManager();
    try
    {
      localLoverDisbandRequestManager.a(Long.parseLong(this.a.getCurrentUin()), Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      label43:
      break label43;
    }
    paramString = this.L.obtainMessage();
    paramString.what = 5;
    this.L.sendMessage(paramString);
  }
  
  private void e(String paramString)
  {
    if (this.q == null)
    {
      BaseActivity localBaseActivity = this.b;
      this.q = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
      this.q.c(true);
    }
    this.q.a(paramString);
    paramString = this.q;
    if ((paramString != null) && (!paramString.isShowing()) && (!this.b.isFinishing())) {
      this.q.show();
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isIntimate");
      ((StringBuilder)localObject).append(this.O);
      QLog.d("intimate_relationship", 2, String.format(((StringBuilder)localObject).toString(), new Object[0]));
    }
    ReportController.b(null, "dc00898", "", "", "0X800A119", "0X800A119", this.K, 0, "", "", "", "");
    this.E = ActionSheet.createMenuSheet(this.c);
    Object localObject = FriendIntimateRelationshipHelper.c(this.H.maskType, this.H.maskLevel);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.E.addButton(2131891001, 0);
    }
    if (this.O) {
      this.E.addButton(2131890970, 3);
    } else {
      this.E.addButton(2131890983, 0);
    }
    this.E.setOnButtonClickListener(new IntimateInfoView.5(this, (String)localObject));
    this.E.addCancelButton(2131887648);
    this.E.show();
  }
  
  private void v()
  {
    ReportController.b(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
    String str = FriendIntimateRelationshipHelper.b(this.d);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click menu_bind_intimate url:");
      ((StringBuilder)localObject).append(str);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new Intent(this.b, QQBrowserActivity.class);
      this.b.startActivity(((Intent)localObject).putExtra("url", str));
    }
  }
  
  private void w()
  {
    BaseActivity localBaseActivity = this.b;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (this.G == null) {
        this.G = DialogUtil.a(this.b, 230).setMessage(2131890973).setPositiveButton(2131890972, new IntimateInfoView.12(this)).setNegativeButton(2131890971, new IntimateInfoView.11(this));
      }
      this.G.show();
      return;
    }
    QLog.d("intimate_relationship", 1, "showDisbandDialog, mActivity == null or is finishing!");
  }
  
  private void x()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((BaseActivity)localObject).app != null))
    {
      localObject = (IWebProcessManagerService)this.b.app.getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject == null) {
        return;
      }
      if (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess())
      {
        ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
        if (QLog.isColorLevel()) {
          QLog.d("intimate_relationship", 2, "start preloadWebProcess");
        }
      }
    }
  }
  
  private void y()
  {
    QQProgressDialog localQQProgressDialog = this.q;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.q.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void z()
  {
    String str = FriendIntimateRelationshipHelper.c(this.H.maskType, this.H.maskLevel);
    if (!TextUtils.isEmpty(str))
    {
      c(str);
      return;
    }
    QQToast.makeText(this.b, 1, HardCodeUtil.a(2131903768), 1).show();
  }
  
  public View a()
  {
    return this.l;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCurrentShowType: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("IntimateInfoView", 4, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentShowType showType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  old:");
      ((StringBuilder)localObject).append(this.W);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    this.W = paramInt;
    localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).setCurrentShowType(paramInt);
    }
    boolean bool2 = this.Y;
    boolean bool1 = true;
    if (!bool2)
    {
      B();
      this.Y = true;
    }
    localObject = this.B;
    if (localObject != null)
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        bool1 = false;
      }
      ((FeedListView)localObject).setLongClickValid(bool1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.X)
    {
      FeedListView localFeedListView = this.B;
      if (localFeedListView != null) {
        localFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
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
      if (this.L == null) {
        this.L = new Handler(this);
      }
      paramString = this.a;
      if (paramString != null)
      {
        paramString.addObserver(this.k);
        this.a.addObserver(this.j);
      }
      this.H = paramCardContent.b;
      paramString = this.L.obtainMessage();
      paramString.what = 0;
      paramString.obj = paramCardContent.b;
      this.L.sendMessage(paramString);
      if (this.X)
      {
        paramCardContent = this.B;
        if (paramCardContent != null) {
          paramCardContent.scrollTo(0, 0);
        }
      }
      else
      {
        paramCardContent = this.U;
        if (paramCardContent != null) {
          paramCardContent.scrollTo(0, 0);
        }
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
      localObject = this.L;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacksAndMessages(null);
      }
    }
    a(3);
    this.h = paramMultiCardCustomViewDelegate;
    this.V = true;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScoreCardActionClick strUrl:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("IntimateInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"))))
    {
      localObject = new Intent(this.c, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
      this.c.startActivity((Intent)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList)
  {
    if (paramBoolean)
    {
      paramArrayList = this.L.obtainMessage();
      paramArrayList.what = 9;
      paramArrayList.obj = null;
      this.L.removeMessages(9);
      this.L.sendMessage(paramArrayList);
      return;
    }
    paramArrayList = this.L.obtainMessage();
    paramArrayList.what = 10;
    paramArrayList.obj = null;
    this.L.sendMessage(paramArrayList);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.d)) && (paramBoolean))
    {
      d();
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    Object localObject = this.h;
    if ((localObject != null) && (((MultiCardCustomViewDelegate)localObject).p() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
      return;
    }
    if (this.h == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetIntimateInfo, mViewDelegate == null:");
        ((StringBuilder)localObject).append(this.V);
        QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.V) {}
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetIntimateInfo, mode: ");
      ((StringBuilder)localObject).append(this.h.p());
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.d)))
    {
      if (paramBoolean)
      {
        paramString = this.L.obtainMessage();
        paramString.what = 0;
        paramString.obj = paramIntimateInfo;
        this.L.removeMessages(0);
        this.L.sendMessage(paramString);
        return;
      }
      paramString = this.L.obtainMessage();
      paramString.what = 1;
      paramString.obj = this.c.getResources().getString(2131890981);
      this.L.sendMessage(paramString);
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.d)))
    {
      Message localMessage = this.L.obtainMessage();
      if (!paramBoolean1)
      {
        localMessage.what = 5;
        this.L.sendMessage(localMessage);
        return;
      }
      if (paramBoolean2)
      {
        d();
        return;
      }
      localMessage.what = 6;
      localMessage.obj = paramString;
      this.L.sendMessage(localMessage);
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    paramObject = this.h;
    if ((paramObject != null) && (paramObject.p() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
      return;
    }
    if (this.h == null)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onGetGroupIntimateInfos, mViewDelegate == null : ");
        paramObject.append(this.V);
        QLog.d("intimate_relationship", 2, paramObject.toString());
      }
      if (!this.V) {}
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetGroupIntimateInfos, mode: ");
      paramObject.append(this.h.p());
      QLog.d("intimate_relationship", 2, paramObject.toString());
    }
    paramObject = null;
    long l1;
    if ((paramBoolean) && (paramHashMap != null)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(this.d).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramObject)
    {
      label184:
      break label184;
    }
    QLog.e("intimate_relationship", 2, "valueOf string err ");
    paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));
    break label222;
    QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    paramHashMap = paramObject;
    label222:
    if (paramHashMap != null)
    {
      paramObject = this.L.obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      this.L.removeMessages(0);
      this.L.sendMessage(paramObject);
      return;
    }
    paramHashMap = this.L.obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.c.getResources().getString(2131890981);
    this.L.sendMessage(paramHashMap);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHandleGetLoverIntimateInfo isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" data = ");
      ((StringBuilder)localObject).append(paramArrayOfObject);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.L.obtainMessage();
      ((Message)localObject).what = 7;
      ((Message)localObject).obj = paramArrayOfObject;
      this.L.removeMessages(7);
      this.L.sendMessage((Message)localObject);
      return;
    }
    paramArrayOfObject = this.L.obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    this.L.sendMessage(paramArrayOfObject);
  }
  
  public Bitmap b(String paramString)
  {
    if (this.M == null)
    {
      this.M = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
      this.M.setDecodeTaskCompletionListener(this.i);
    }
    Bitmap localBitmap = this.M.getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.M.isPausing()) {
      this.M.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public void b()
  {
    if (this.L == null) {
      this.L = new Handler(this);
    }
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.k);
      this.a.addObserver(this.j);
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoView.2(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.s.setNeedReportPage(paramBoolean);
    this.x.setNeedReportPage(paramBoolean);
  }
  
  public void c()
  {
    this.r.n();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.m != null)
    {
      if (paramBoolean)
      {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        return;
      }
      this.n.setVisibility(4);
      this.o.setVisibility(4);
    }
  }
  
  public void d()
  {
    long l2;
    if (!TextUtils.isEmpty(this.d)) {
      if (NetworkUtil.isNetworkAvailable(this.b))
      {
        if (this.I == null) {
          this.I = ((IntimateInfoHandler)this.a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER));
        }
        if (this.h == null)
        {
          boolean bool = FriendIntimateRelationshipConfProcessor.a().Z;
          this.I.a(this.d, bool);
          break label219;
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
      label115:
      label117:
      break label115;
    }
    try
    {
      l3 = Long.valueOf(this.e).longValue();
      l2 = l3;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label117;
    }
    l1 = 0L;
    QLog.e("intimate_relationship", 1, "valueOf string err");
    ((ArrayList)localObject).add(Long.valueOf(l1));
    this.I.a(l2, (ArrayList)localObject, null);
    break label219;
    Object localObject = this.L.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = this.c.getResources().getString(2131916775);
    this.L.sendMessage((Message)localObject);
    QLog.d("intimate_relationship", 1, String.format("requestIntimateInfo network is not available, uin: %s", new Object[] { this.d }));
    label219:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestIntimateInfo, friendUin: %s", new Object[] { this.d }));
    }
  }
  
  public void e()
  {
    long l2;
    if (!TextUtils.isEmpty(this.d)) {
      if (NetworkUtil.isNetworkAvailable(this.b)) {
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.parseLong(this.d);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label33:
      Message localMessage;
      break label33;
    }
    l1 = l2;
    if (QLog.isColorLevel())
    {
      QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.d }));
      l1 = l2;
    }
    TroopWithCommonFriendsHelper.a(l1, 1, this.a);
    break label147;
    localMessage = this.L.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.c.getResources().getString(2131916775);
    this.L.sendMessage(localMessage);
    QLog.d("intimate_relationship", 1, String.format("requestTroopListWithCommonFriends network is not available, uin: %s", new Object[] { this.d }));
    label147:
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("requestTroopListWithCommonFriends, friendUin: %s", new Object[] { this.d }));
    }
  }
  
  public void f()
  {
    Object localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).j();
    }
    localObject = this.B;
    if (localObject != null) {
      ((FeedListView)localObject).onPause();
    }
  }
  
  public void g()
  {
    Object localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).i();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((FeedListView)localObject).onStart();
      this.B.onResume();
    }
  }
  
  public void h()
  {
    Object localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).l();
    }
    localObject = this.B;
    if (localObject != null) {
      ((FeedListView)localObject).onStop();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 9: 
    case 10: 
      a(this.H);
      return true;
    case 8: 
      this.v.getLoverValueFailed();
      return true;
    case 7: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
      {
        paramMessage = (Object[])paramMessage.obj;
        this.v.a((String)paramMessage[0], (String)paramMessage[1], (String)paramMessage[2]);
        return true;
      }
      this.v.getLoverValueFailed();
      return true;
    case 6: 
      d();
      QQToast.makeText(this.b, 2, 2131890975, 1).show();
      return true;
    case 5: 
      y();
      QQToast.makeText(this.b, 2, 2131890974, 1).show();
      return true;
    case 4: 
      y();
      return true;
    case 3: 
      e((String)paramMessage.obj);
      return true;
    case 2: 
      paramMessage = (String)paramMessage.obj;
      QQToast.makeText(this.b, 2, paramMessage, 1).show();
      return true;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      QQToast.makeText(this.b, 1, paramMessage, 1).show();
      return true;
    }
    a((IntimateInfo)paramMessage.obj);
    return true;
  }
  
  public void i()
  {
    Object localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).k();
    }
    localObject = this.B;
    if (localObject != null) {
      ((FeedListView)localObject).onStart();
    }
  }
  
  public void j()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.k);
      this.a.removeObserver(this.j);
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.M = null;
    }
    localObject = this.F;
    if (localObject != null) {
      ((IntimateInfoShareHelper)localObject).c();
    }
    localObject = this.S;
    if (localObject != null)
    {
      ((MemoryDayView)localObject).b();
      this.S = null;
    }
    localObject = this.A.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IntimateContentItemBaseView)((Iterator)localObject).next()).m();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((FeedListView)localObject).onDestroy();
      this.D = true;
    }
    localObject = this.C;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
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
  
  public void o()
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
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    Long localLong = this.R;
    if ((localLong == null) || (l1 - localLong.longValue() >= 500L))
    {
      this.R = Long.valueOf(l1);
      int i1 = paramView.getId();
      if (i1 != 2131429218)
      {
        if (i1 == 2131438103) {
          u();
        }
      }
      else {
        o();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadOver: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("IntimateInfoView", 4, ((StringBuilder)localObject).toString());
    if (this.C != null)
    {
      localObject = this.B;
      if (localObject == null) {
        return;
      }
      if (((FeedListView)localObject).getFeedCnt() > 0)
      {
        this.C.setVisibility(0);
        return;
      }
      this.C.setVisibility(8);
    }
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
  
  public void p()
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      ((IntimateInfo)localObject).lastAnimAfterScore = ((IntimateInfo)localObject).currentScore;
      ThreadManager.postImmediately(new IntimateInfoView.4(this), null, true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScoreUpdated: ");
      ((StringBuilder)localObject).append(this.H);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void q()
  {
    r();
  }
  
  public void r()
  {
    this.v.getLoverIntimateValue();
  }
  
  public void s()
  {
    QLog.i("IntimateInfoView", 4, "onZoomIn: ");
    FeedListView localFeedListView = this.B;
    if (localFeedListView == null) {
      return;
    }
    if (this.D)
    {
      localFeedListView.attach(this.a, this.b, Long.parseLong(this.d));
      this.B.loadMore(this);
      this.D = false;
      return;
    }
    if (this.Z)
    {
      localFeedListView.loadMore(this);
      this.Z = false;
    }
  }
  
  public void t()
  {
    QLog.i("IntimateInfoView", 4, "onZoomOut: ");
    FeedListView localFeedListView = this.B;
    if (localFeedListView != null) {
      localFeedListView.scrollToHeadView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView
 * JD-Core Version:    0.7.0.1
 */