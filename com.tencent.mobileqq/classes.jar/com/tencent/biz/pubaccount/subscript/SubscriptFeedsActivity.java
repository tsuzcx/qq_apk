package com.tencent.biz.pubaccount.subscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class SubscriptFeedsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, SwipListView.RightIconMenuListener, Observer
{
  private boolean A = false;
  private boolean B = false;
  private XListView.DrawFinishedListener C = new SubscriptFeedsActivity.1(this);
  private float D = 0.0F;
  private float E = 0.0F;
  private int F = 0;
  private boolean G = false;
  private boolean H = false;
  private SubscriptObserver I = new SubscriptFeedsActivity.15(this);
  public SubscriptRecommendController a;
  public View b;
  protected DragFrameLayout c;
  protected int d = 0;
  protected boolean e = false;
  public boolean f = false;
  public long g = 0L;
  public long h = 0L;
  public boolean i;
  public boolean j;
  MessageObserver k = new SubscriptFeedsActivity.12(this);
  MqqHandler l = new SubscriptFeedsActivity.14(this, ThreadManager.getSubThreadLooper());
  private SubscriptFeedsAdapter m;
  private SwipListView n;
  private int o = -1;
  private SubscriptPicManager p;
  private List<SubscriptionFeed> q = null;
  private ArrayList<ReadInJoyArticle> r = null;
  private boolean s = false;
  private PopupWindow t;
  private CustomGuideView u;
  private View v;
  private EditText w;
  private long x;
  private TopGestureLayout y;
  private long z = 0L;
  
  private void a(List<SubscriptionFeed> paramList)
  {
    DragFrameLayout localDragFrameLayout = this.c;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.getMode() != -1)) {
      return;
    }
    if (this.m != null)
    {
      if (this.b == null) {
        return;
      }
      if (paramList != null) {
        this.q = paramList;
      }
      this.m.a(this.q);
      if (((this.m.h == -1) || (this.m.f == -1)) && (((!this.B) && (SubscriptRecommendController.d(this.app))) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.app))))
      {
        paramList = this.m;
        paramList.h = 0;
        paramList.f = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "subscript inner recommend need show !");
        }
      }
      a(true, false, false);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.y == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.y = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.y;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      this.j = true;
      this.m.b();
      this.m.notifyDataSetChanged();
      g();
    }
    SubscriptRecommendController localSubscriptRecommendController = this.a;
    if ((localSubscriptRecommendController != null) && (this.m != null) && (!this.H) && (localSubscriptRecommendController.i) && (this.m.h == 0) && (this.m.i) && (this.m.f == 0))
    {
      this.H = true;
      this.a.a();
    }
  }
  
  private boolean a(ArrayList<ReadInJoyArticle> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySharedPreferences(1);
      try
      {
        paramArrayList = SubscriptFeedsUtils.a(paramArrayList);
        if (!TextUtils.isEmpty(paramArrayList))
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString("subscript_feeds_readinjoy_articles", paramArrayList);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences((SharedPreferences.Editor)localObject, true);
          return true;
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    return false;
  }
  
  private void d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("8.8.17");
    ((StringBuilder)localObject1).append(this.app.getCurrentUin());
    ((StringBuilder)localObject1).append("subscript_guid");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.app.getPreferences();
    int i1 = 1;
    if ((!((SharedPreferences)localObject2).getBoolean((String)localObject1, true)) || (!SubscriptRecommendController.k(this.app))) {
      i1 = 0;
    }
    if (i1 == 0) {
      return;
    }
    this.app.getPreferences().edit().putBoolean((String)localObject1, false).commit();
    try
    {
      localObject1 = getResources();
      this.t = new PopupWindow();
      this.u = new CustomGuideView(this);
      this.u.i = ((Resources)localObject1).getColor(2131168247);
      this.u.h = ((Resources)localObject1).getColor(2131168248);
      this.u.g = AIOUtils.a(2, 14, (Resources)localObject1);
      this.u.f = AIOUtils.b(12.0F, (Resources)localObject1);
      this.u.b = AIOUtils.b(30.0F, (Resources)localObject1);
      this.u.c = AIOUtils.b(7.0F, (Resources)localObject1);
      this.u.j = AIOUtils.b(12.0F, (Resources)localObject1);
      this.u.d = AIOUtils.b(3.0F, (Resources)localObject1);
      this.u.a = HardCodeUtil.a(2131911980);
      this.u.setOnClickListener(this);
      this.u.setId(2131446596);
      this.t.setContentView(this.u);
      this.t.setFocusable(false);
      this.t.setOutsideTouchable(false);
      this.t.setWidth(this.u.c());
      this.t.setHeight(-2);
      i1 = this.u.c();
      int i2 = getResources().getDisplayMetrics().widthPixels;
      this.rightViewText.post(new SubscriptFeedsActivity.6(this, i2, i1));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showSubscriptCenterGuideWindow, ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("SubscriptFeedsActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void e()
  {
    PopupWindow localPopupWindow = this.t;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      this.u.setOnClickListener(null);
      try
      {
        this.t.dismiss();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeSubscriptCenterGuideWindow, ");
          localStringBuilder.append(localException);
          QLog.e("SubscriptFeedsActivity", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void f()
  {
    ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.7(this));
    if (TroopBarAssistantManager.a().g(this.app)) {
      TroopBarAssistantManager.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.k);
    addObserver(this.I);
    this.app.getMessageFacade().addObserver(this);
    HtmlOffline.b("2278", this.app, true, new SubscriptFeedsActivity.8(this));
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (this.m.getCount() == 0)
    {
      ((TextView)this.b.findViewById(2131447914)).setText(2131895595);
      this.b.setVisibility(0);
      if (!bool) {
        this.b.setBackgroundResource(2131166842);
      } else {
        this.b.setBackgroundResource(2131166843);
      }
      this.n.setBackgroundResource(2130853309);
      this.n.setEnabled(false);
      SubscriptRecommendController localSubscriptRecommendController = this.a;
      if (localSubscriptRecommendController != null) {
        localSubscriptRecommendController.e();
      }
    }
    else
    {
      this.b.setVisibility(8);
      if (!bool) {
        this.n.setBackgroundResource(2131166842);
      } else {
        this.n.setBackgroundResource(2131166843);
      }
      this.n.setEnabled(true);
    }
  }
  
  public void a()
  {
    if (this.e)
    {
      this.a.h();
      this.e = false;
    }
    else
    {
      this.a.i();
    }
    this.m.a(this.a);
  }
  
  void b()
  {
    try
    {
      if (this.l != null)
      {
        this.l.removeMessages(1002);
        this.l.sendEmptyMessage(1002);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscriptFeedsActivity", 2, "refreshTroopBarAccountList, error: ", localException);
      }
    }
  }
  
  void c()
  {
    if (this.leftView != null) {
      ThreadManager.post(new SubscriptFeedsActivity.9(this), 5, null, true);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject = this.n;
    label447:
    boolean bool;
    if ((localObject != null) && (this.m != null))
    {
      int[] arrayOfInt;
      if (this.F == 0)
      {
        arrayOfInt = new int[2];
        ((SwipListView)localObject).getLocationOnScreen(arrayOfInt);
        this.F = arrayOfInt[1];
      }
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2)
          {
            if (i1 != 3) {
              break label447;
            }
          }
          else
          {
            if (Math.abs(f1 - this.D) > Math.abs(f2 - this.E))
            {
              f2 = this.D;
              if (f1 - f2 > 20.0F)
              {
                if (!this.G) {
                  break label447;
                }
                ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
                break label447;
              }
              if (f1 - f2 >= -20.0F) {
                break label447;
              }
              ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
              break label447;
            }
            Math.abs(f2 - this.E);
            break label447;
          }
        }
        ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(false);
        this.G = false;
      }
      else
      {
        this.D = f1;
        this.E = f2;
        this.G = false;
        i1 = this.n.getHeight();
        if (f2 >= this.F)
        {
          localObject = this.a;
          if ((localObject != null) && (((SubscriptRecommendController)localObject).j == 1) && (this.a.b != null))
          {
            localObject = this.a.b.findViewById(2131445351);
            arrayOfInt = new int[2];
            ((View)localObject).getLocationOnScreen(arrayOfInt);
            if ((f2 >= arrayOfInt[1]) && (f2 < arrayOfInt[1] + ((View)localObject).getHeight())) {
              this.G = true;
            }
          }
          else
          {
            int i2 = this.F;
            if (f2 < i1 + i2)
            {
              i1 = this.n.pointToPosition((int)f1, (int)f2 - i2);
              if (i1 != -1)
              {
                i1 -= this.n.getHeaderViewsCount();
                if ((i1 >= 0) && (i1 < this.m.getCount()))
                {
                  if (i1 == this.o) {
                    this.G = true;
                  }
                  if (this.m.getItem(i1).equals("SubscriptRecommendController")) {
                    this.G = true;
                  }
                }
              }
            }
          }
        }
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.g = SystemClock.uptimeMillis();
    PublicTracker.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      new MqqHandler().postDelayed(new SubscriptFeedsActivity.2(this), 1000L);
    }
    setContentView(2131626441);
    getWindow().setBackgroundDrawable(null);
    this.c = DragFrameLayout.a(this);
    this.c.a(this, false);
    this.e = true;
    this.d = super.getIntent().getIntExtra("come_from", 0);
    this.z = super.getIntent().getLongExtra("start_time", 0L);
    this.A = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.p = new SubscriptPicManager();
    setTitle(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
    c();
    boolean bool = SubscriptRecommendController.k(this.app);
    this.rightViewText.setText(2131888819);
    if (bool) {
      this.rightViewText.setVisibility(0);
    } else {
      this.rightViewText.setVisibility(8);
    }
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setOnClickListener(this);
    this.b = findViewById(2131432530);
    this.n = ((SwipListView)findViewById(2131433082));
    SwipListView localSwipListView = this.n;
    if (ThemeUtil.isInNightMode(this.app)) {
      paramBundle = getResources().getDrawable(2131168246);
    } else {
      paramBundle = getResources().getDrawable(2131167227);
    }
    localSwipListView.setDivider(paramBundle);
    this.n.setDividerHeight(getResources().getDimensionPixelSize(2131297287));
    this.n.setOnScrollListener(new SubscriptFeedsActivity.3(this));
    this.n.setDrawFinishedListener(this.C);
    this.v = LayoutInflater.from(this).inflate(2131629216, null);
    this.v.setBackgroundDrawable(null);
    ((Button)this.v.findViewById(2131429816)).setVisibility(8);
    ((TextView)this.v.findViewById(2131448724)).setText(String.format(getResources().getString(2131894280), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
    this.w = ((EditText)this.v.findViewById(2131432634));
    this.w.setCursorVisible(false);
    this.w.setOnFocusChangeListener(new SubscriptFeedsActivity.4(this));
    this.n.addHeaderView(this.v);
    d();
    this.m = new SubscriptFeedsAdapter(this, this.app, this.n, getLayoutInflater());
    this.m.a(this);
    this.n.setAdapter(this.m);
    this.m.a(this.c);
    this.m.a(this.p);
    if (!ThemeUtil.isInNightMode(this.app)) {
      this.n.setBackgroundResource(2131166842);
    } else {
      this.n.setBackgroundResource(2131166843);
    }
    this.n.setDragEnable(true);
    this.n.setRightIconMenuListener(this);
    ThreadManager.executeOnSubThread(new SubscriptFeedsActivity.5(this));
    f();
    if (this.a == null) {
      this.a = new SubscriptRecommendController(this, this.app, this.p);
    }
    this.app.setHandler(getClass(), this.l);
    return true;
  }
  
  protected void doOnDestroy()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.c;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    boolean bool = SubscriptRecommendController.g(this.app);
    Object localObject = super.findViewById(2131436213);
    int i1;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
    if (this.f) {
      this.f = false;
    }
    if (this.B)
    {
      String str = SubscriptRecommendController.f(this.app);
      Intent localIntent = new Intent(this, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
      }
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", this.app.getCurrentUin());
      localIntent.putExtra("fromLocalUrl", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("assignBackText", HardCodeUtil.a(2131911969));
      localIntent.putExtra("hideRightButton", true);
      localIntent.putExtra("assignBackText", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this));
      localIntent.putExtra("call_from", 1001);
      startActivity(localIntent);
      overridePendingTransition(2130772308, 2130771997);
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
      }
      this.B = false;
      ReportController.b(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
    }
    a();
    b();
  }
  
  public void finish()
  {
    super.finish();
    TroopBarAssistantManager.a().e(this.app);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.c.getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131449123))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.getDragView().getTag(2131446598);
      if (paramDragFrameLayout != null)
      {
        String str = paramDragFrameLayout.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramDragFrameLayout.b);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", str, "0X80064D1", "0X80064D1", 0, 0, localStringBuilder.toString(), "", "", "");
        paramDragFrameLayout.a();
        c();
        this.l.removeMessages(1002);
        this.l.sendEmptyMessage(1002);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i6 = paramView.getId();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i1 = 0;
    Object localObject1 = "";
    Object localObject3;
    Object localObject2;
    switch (i6)
    {
    default: 
      break;
    case 2131446596: 
      ReportController.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
      PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
      SubscriptRecommendController.b(this.app, false);
      e();
      break;
    case 2131446595: 
      if (((Integer)paramView.getTag(2131446599)).intValue() == SubscriptFeedsAdapter.d)
      {
        localObject3 = paramView.getTag(2131446598);
        Object localObject4 = paramView.getTag(2131446607);
        if (localObject4 != null) {
          localObject2 = (String)localObject4;
        } else {
          localObject2 = "";
        }
        if (localObject4 != null) {
          i1 = ((Integer)localObject3).intValue();
        }
        localObject3 = Integer.valueOf(i1);
        if (((Integer)localObject3).intValue() > 0) {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject2)))
        {
          localObject4 = (IPublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject4 != null) {
            ((IPublicAccountHandler)localObject4).getUserFollowList();
          }
        }
        localObject4 = paramView.getTag(2131446600);
        if (localObject4 != null) {
          localObject1 = (String)localObject4;
        }
        localObject4 = new Intent(this, ChatActivity.class);
        ((Intent)localObject4).putExtra("uintype", 1008);
        ((Intent)localObject4).putExtra("uin", (String)localObject2);
        ((Intent)localObject4).putExtra("uinname", (String)localObject1);
        ((Intent)localObject4).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject4).putExtra("red_hot_count", (Serializable)localObject3);
        startActivity((Intent)localObject4);
        e();
      }
      break;
    case 2131438143: 
      localObject2 = paramView.getTag(2131446607);
      if (localObject2 != null) {
        localObject2 = (String)localObject2;
      } else {
        localObject2 = "";
      }
      localObject3 = paramView.getTag(2131446600);
      if (localObject3 != null) {
        localObject1 = (String)localObject3;
      }
      localObject3 = (ActionSheet)ActionSheetHelper.b(this, null);
      ((ActionSheet)localObject3).setMainTitle(String.format(getResources().getString(2131894284), new Object[] { localObject1 }));
      ((ActionSheet)localObject3).addButton(2131894218, 3);
      ((ActionSheet)localObject3).addCancelButton(2131887648);
      ((ActionSheet)localObject3).setOnButtonClickListener(new SubscriptFeedsActivity.11(this, (String)localObject2, (ActionSheet)localObject3));
      ((ActionSheet)localObject3).show();
      break;
    case 2131438138: 
    case 2131438144: 
      localObject1 = paramView.getTag(2131446607);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      if (!TroopBarAssistantManager.a().b((String)localObject1, this.app))
      {
        TroopBarAssistantManager.a().c((String)localObject1, this.app);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
        i3 = TroopBarAssistantManager.a().d();
        localObject2 = this.q.iterator();
        do
        {
          i1 = i2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
        } while ((((SubscriptionFeed)localObject3).c == null) || (!((SubscriptionFeed)localObject3).c.equals(localObject1)));
        i1 = ((SubscriptionFeed)localObject3).b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i3);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CD", "0X80064CD", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      }
      else
      {
        TroopBarAssistantManager.a().d((String)localObject1, this.app);
        i2 = TroopBarAssistantManager.a().d();
        localObject2 = this.q.iterator();
        do
        {
          i1 = i3;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
        } while ((((SubscriptionFeed)localObject3).c == null) || (!((SubscriptionFeed)localObject3).c.equals(localObject1)));
        i1 = ((SubscriptionFeed)localObject3).b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i2);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064CE", "0X80064CE", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      }
      b();
      break;
    case 2131438112: 
      localObject1 = paramView.getTag(2131446607);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005730", "0X8005730", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8006241", "0X8006241", 0, 0, "", "", "", "");
      TroopBarAssistantManager.a().a((String)localObject1, this.app);
      b();
      i1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, (String)localObject1);
      RecentUtil.b(this.app, (String)localObject1, i1);
      this.app.getMessageFacade().a((String)localObject1, 1008);
      localObject2 = this.app.getHandler(Conversation.class);
      if (localObject2 != null) {
        ((MqqHandler)localObject2).sendEmptyMessage(1014);
      }
      localObject2 = this.q.iterator();
      do
      {
        i1 = i4;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SubscriptionFeed)((Iterator)localObject2).next();
      } while ((((SubscriptionFeed)localObject3).c == null) || (!((SubscriptionFeed)localObject3).c.equals(localObject1)));
      i1 = ((SubscriptionFeed)localObject3).b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i1);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject1, "0X80064D0", "0X80064D0", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      break;
    case 2131436716: 
    case 2131436717: 
    case 2131436718: 
    case 2131436719: 
    case 2131436730: 
      ReportController.b(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("channel_id", 0);
      ((Intent)localObject1).putExtra("readinjoy_launch_source", 9);
      localObject2 = new ArrayList();
      localObject3 = this.r;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() == 4))
      {
        i1 = i5;
        while (i1 < 4)
        {
          ((ArrayList)localObject2).add(Long.valueOf(((ReadInJoyArticle)this.r.get(i1)).mArticleID));
          i1 += 1;
        }
        ((Intent)localObject1).putExtra("subscription_all_article_id", (Serializable)localObject2);
        if ((paramView.getId() != 2131436716) && (paramView.getId() != 2131436717) && (paramView.getId() != 2131436718) && (paramView.getId() != 2131436719))
        {
          ((Intent)localObject1).putExtra("subscription_click_article_id", 0L);
        }
        else
        {
          i1 = ((Integer)paramView.getTag()).intValue();
          localObject2 = (ReadInJoyArticle)this.r.get(i1);
          long l1;
          if (localObject2 != null) {
            l1 = ((ReadInJoyArticle)localObject2).mArticleID;
          } else {
            l1 = -1L;
          }
          ((Intent)localObject1).putExtra("subscription_click_article_id", Long.valueOf(l1));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
      }
      this.f = true;
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).launchReadInJoyPlugin(this, (Intent)localObject1);
      e();
      break;
    case 2131436211: 
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
      PublicAccountSearchActivity.a(this, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
      SubscriptRecommendController.b(this.app, false);
      e();
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
    this.o = -1;
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.o = ((Integer)paramView.getTag(2131446601)).intValue();
    a(false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new SubscriptFeedsActivity.13(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity
 * JD-Core Version:    0.7.0.1
 */