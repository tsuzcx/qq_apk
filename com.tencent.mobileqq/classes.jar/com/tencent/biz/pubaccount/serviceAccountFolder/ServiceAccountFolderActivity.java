package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ServiceAccountFolderActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, SwipListView.RightIconMenuListener
{
  private ExtraTypeInfo a;
  private List<ServiceAccountFolderFeed> b;
  private ServiceAccountFolderFeedAdapter c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private TopRecommendListView j;
  private TopPanelView k;
  private TopPanelPresenter l;
  private boolean m;
  private QQProgressDialog n;
  private DragFrameLayout o;
  private TopGestureLayout p;
  private View q;
  private final MqqHandler r = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private ArrayList<String> s = new ArrayList();
  private long t = 0L;
  private boolean u;
  
  private void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    try
    {
      Field localField = localInputMethodManager.getClass().getDeclaredField("mLastSrvView");
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      localField.set(localInputMethodManager, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ServiceAccountFolderActivity", "[onDestroy]", localThrowable);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableFlingRight->enable:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d()
  {
    this.d = super.findViewById(2131445655);
    this.e = ((TextView)super.findViewById(2131436227));
    this.f = ((TextView)super.findViewById(2131436180));
    this.h = ((TextView)findViewById(2131436218));
    this.g = ((TextView)super.findViewById(2131448219));
    this.j = ((TopRecommendListView)super.findViewById(2131445662));
    this.k = new TopPanelView(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l = new TopPanelPresenter(this.k);
    this.j.addHeaderView(this.k);
    this.i = ((ImageView)findViewById(2131436666));
    this.n = new QQProgressDialog(this, super.getTitleBarHeight());
    this.n.setCanceledOnTouchOutside(true);
    this.n.c(2131893007);
    this.o = DragFrameLayout.a(this);
    this.o.a(this, false);
    this.q = super.findViewById(2131445657);
    localObject = (TextView)findViewById(2131445656);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("暂无");
    localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle());
    localStringBuilder.append("消息");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  private void e()
  {
    this.e.setText(ServiceAccountFolderManager.h(this.app));
    if (this.leftView != null) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131911254));
    }
    Object localObject;
    if (this.u)
    {
      localObject = this.g;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        localObject = this.g.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(32.0F, getResources());
          this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = this.h;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.h;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getBackground();
        if ((localObject != null) && ((localObject instanceof GradientDrawable)))
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)((Drawable)localObject).mutate();
          localGradientDrawable.setColor(getResources().getColorStateList(2131167990).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.h.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.h.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(40.0F, getResources());
            this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.h.setTextColor(getResources().getColor(2131167990));
        this.h.setVisibility(8);
      }
      localObject = this.g;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    if (this.rightViewText != null) {
      if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isSwitchToCertifiedAccount())
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(HardCodeUtil.a(2131916913));
        this.rightViewText.setOnClickListener(this);
      }
      else
      {
        this.rightViewText.setVisibility(8);
      }
    }
    h();
  }
  
  private void f()
  {
    this.j.setDragEnable(true);
    this.j.setRightIconMenuListener(this);
    this.j.setContentBackground(getResources().getDrawable(2130838959), false);
    this.j.setBackgroundResource(2130838959);
    this.c = new ServiceAccountFolderFeedAdapter(this.app, this, this.j);
    this.c.a(this.o);
    this.b = ServiceAccountFolderManager.a().b();
    this.c.a(this.b);
    this.j.setAdapter(this.c);
  }
  
  private void g()
  {
    View localView = super.findViewById(2131444897);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131447484);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131436180);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void h()
  {
    TextView localTextView;
    if (this.u) {
      localTextView = this.g;
    } else {
      localTextView = this.h;
    }
    if (localTextView != null)
    {
      ExtraTypeInfo localExtraTypeInfo = this.a;
      if ((localExtraTypeInfo != null) && (localExtraTypeInfo.sourceType == 9004)) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.3(this, localTextView));
      }
    }
  }
  
  private void i()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        if (!this.s.contains(localServiceAccountFolderFeed.b))
        {
          this.s.add(localServiceAccountFolderFeed.b);
          if ((localServiceAccountFolderFeed.j != null) && (localServiceAccountFolderFeed.j.mExJsonObject != null)) {
            localObject1 = localServiceAccountFolderFeed.j.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
          } else {
            localObject1 = "";
          }
          Object localObject2 = localServiceAccountFolderFeed.j;
          if (localObject2 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localServiceAccountFolderFeed.d);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((MessageRecord)localObject2).msgseq);
            ((StringBuilder)localObject4).append("");
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((MessageRecord)localObject2).msgBackupMsgRandom);
            ((StringBuilder)localObject5).append("");
            localObject2 = PublicAccountEventReport.a((String)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString());
          }
          else
          {
            localObject2 = "";
          }
          Object localObject3 = this.app;
          Object localObject4 = localServiceAccountFolderFeed.j;
          Object localObject5 = localServiceAccountFolderFeed.b;
          int i1 = localServiceAccountFolderFeed.c;
          int i2 = localServiceAccountFolderFeed.d;
          String str = localServiceAccountFolderFeed.i.toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.b.indexOf(localServiceAccountFolderFeed));
          localStringBuilder.append("");
          PublicAccountEventReport.a((QQAppInterface)localObject3, (MessageRecord)localObject4, (String)localObject5, i1, i2, str, (String)localObject1, (String)localObject2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void j()
  {
    ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onReportNumRedPoint(104000, "104000.104001");
    QLog.d("ServiceAccountFolderActivity", 2, "exposurePublicAccountMessagePopRedDot");
  }
  
  protected TopGestureLayout a()
  {
    if (this.p == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.p = ((TopGestureLayout)localObject);
      }
    }
    return this.p;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      if (ThemeUtil.isInNightMode(this.app)) {
        this.d.setBackgroundResource(2130838959);
      } else {
        this.d.setBackgroundColor(Color.parseColor("#f5f5f5"));
      }
      if (this.q != null)
      {
        localObject = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        int i1 = ((Rect)localObject).height();
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.q.measure(i2, i3);
        i1 = (i1 - this.q.getMeasuredHeight()) / 2;
        i2 = (int)getResources().getDimension(2131299920);
        ((ViewGroup.MarginLayoutParams)this.q.getLayoutParams()).topMargin = (i1 - i2);
        this.q.setVisibility(0);
      }
    }
    else
    {
      this.j.setVisibility(0);
      localObject = this.q;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmptyView->show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void b()
  {
    if (this.m) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      this.m = true;
      localTopGestureLayout.setInterceptTouchEventListener(new ServiceAccountFolderActivity.5(this));
      return;
    }
    QLog.e("ServiceAccountFolderActivity", 2, "processTopPanelTouchEvent failed! topGestureLayout return null!");
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.n;
    if (localObject != null) {
      if ((paramBoolean) && (!((QQProgressDialog)localObject).isShowing()))
      {
        this.n.show();
        this.r.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
      }
      else if ((!paramBoolean) && (this.n.isShowing()))
      {
        this.n.dismiss();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgressBar->show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) > 0) && (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isSwitchToCertifiedAccount()))
    {
      Intent localIntent = new Intent();
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localIntent.setClass(this, ServiceAccountFolderActivityNew.class);
      startActivity(localIntent);
      finish();
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131625663);
    this.a = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    this.app.setHandler(getClass(), this.r);
    this.u = ThemeUtil.isDefaultOrDIYTheme(false);
    d();
    e();
    f();
    g();
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    paramBundle = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
    if (paramBundle != null) {
      paramBundle.startWebProcess(-1, null);
    }
    j();
    return true;
  }
  
  protected void doOnDestroy()
  {
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.t) });
    Object localObject = this.r;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    localObject = this.j;
    if (localObject != null)
    {
      ((TopRecommendListView)localObject).removeHeaderView(this.k);
      this.j.setAdapter(null);
    }
    localObject = this.l;
    if (localObject != null) {
      ((TopPanelPresenter)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ServiceAccountFolderFeedAdapter)localObject).a();
    }
    this.o.a(this);
    localObject = this.n;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    c();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.o;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    PublicAccountEventReport.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.t);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
    ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.2(this, ServiceAccountFolderManager.a()));
    PublicTracker.a("SERVICE_FOLDER_COST", null);
    this.t = System.currentTimeMillis();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.r.removeMessages(100);
      ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.1(this));
      return true;
    }
    if (paramMessage.what == 101)
    {
      this.c.a(this.b);
      boolean bool;
      if (this.c.getCount() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      a(bool);
      h();
      i();
      return true;
    }
    if (paramMessage.what == 102) {
      h();
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.o.getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131449128))
    {
      paramInt = ((Integer)paramDragFrameLayout.getDragView().getTag()).intValue();
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.c.getItem(paramInt);
      if (localServiceAccountFolderFeed != null)
      {
        long l1 = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        QQAppInterface localQQAppInterface = this.app;
        if (localServiceAccountFolderFeed.a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.d);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramInt + 1);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l1);
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject1, (String)localObject2, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.app, localServiceAccountFolderFeed, true);
        VSReporter.a(localServiceAccountFolderFeed.b, "auth_page", "ignore", 0, 0, new String[0]);
        h();
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = new StringBuilder();
          paramDragFrameLayout.append("onChange->drag red dot:");
          paramDragFrameLayout.append(localServiceAccountFolderFeed.b);
          QLog.d("ServiceAccountFolderActivity", 2, paramDragFrameLayout.toString());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131436211: 
      SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
      break;
    case 2131436194: 
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, str, 2016, null, null);
      QZoneHelper.prepareForQQPublicAccountPublishPage();
      ReportController.b(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      break;
    case 2131436180: 
    case 2131436666: 
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    c(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */