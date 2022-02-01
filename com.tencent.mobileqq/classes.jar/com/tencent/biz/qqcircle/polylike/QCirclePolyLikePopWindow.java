package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.AnimationView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikePopWindow
  extends PopupWindow
  implements ReportBean<QCircleReportBean>, SimpleEventReceiver
{
  public static int a = ViewUtils.a(101.0F);
  public static int b = 5;
  private TextView c;
  private HashMap<String, QCirclePolyBaseLikeView> d = new HashMap();
  private WeakReference<View> e;
  private FeedCloudMeta.StFeed f;
  private View g;
  private LinearLayout h;
  private boolean i;
  private List<QQCircleFeedBase.StPolyLike> j;
  private int k;
  private RFWMultiDownloadHelper l;
  private RFWMultiDownloadHelper.MultiDownloadResultListener m;
  private ReportBean<QCircleReportBean> n;
  private QCircleReportBean o;
  private QCircleExtraTypeInfo p;
  private QCirclePolyRequestManager q;
  private Handler r = new Handler(Looper.getMainLooper());
  private QCirclePolyLikeFrameLayout.OnClickHookListener s;
  
  public QCirclePolyLikePopWindow(Context paramContext)
  {
    super(paramContext);
    if (paramContext != null)
    {
      this.g = LayoutInflater.from(paramContext).inflate(2131626915, null);
      this.q = new QCirclePolyRequestManager();
      this.h = ((LinearLayout)this.g.findViewById(2131441778));
      this.c = ((TextView)this.g.findViewById(2131441788));
      setContentView(this.g);
      setOutsideTouchable(true);
      setFocusable(true);
      setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  private void a(QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView)
  {
    if (!TextUtils.isEmpty(paramQCirclePolyBaseLikeView.e.fullScreenURLAND.get()))
    {
      paramQCirclePolyBaseLikeView = new AnimationDrawableCreateOption.Builder(paramQCirclePolyBaseLikeView.e.fullScreenURLAND.get());
      paramQCirclePolyBaseLikeView.b(40).a(true).a(2147483647L).b(false);
      AnimationDrawableFactory.a().a(hashCode(), paramQCirclePolyBaseLikeView.a(), new QCirclePolyLikePopWindow.2(this));
    }
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    QCirclePolyBaseLikeView localQCirclePolyBaseLikeView1 = (QCirclePolyBaseLikeView)this.d.get(paramStPolyLike.polyLikeID.get());
    QCirclePolyBaseLikeView localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
    if (localQCirclePolyBaseLikeView1 == null)
    {
      if ((paramInt == b - 1) && (this.j.size() > b)) {
        localQCirclePolyBaseLikeView1 = QCirclePolyLikeViewFactory.a(getContentView().getContext(), 256, 3);
      } else if (paramStPolyLike.articleType.get() == 0) {
        localQCirclePolyBaseLikeView1 = QCirclePolyLikeViewFactory.a(getContentView().getContext(), 256, 1);
      } else if (paramStPolyLike.articleType.get() == 1) {
        localQCirclePolyBaseLikeView1 = QCirclePolyLikeViewFactory.a(getContentView().getContext(), 256, 2);
      }
      if (localQCirclePolyBaseLikeView1 == null) {
        return;
      }
      localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
      if (localQCirclePolyBaseLikeView1.getViewType() != 3)
      {
        this.d.put(paramStPolyLike.polyLikeID.get(), localQCirclePolyBaseLikeView1);
        localQCirclePolyBaseLikeView2 = localQCirclePolyBaseLikeView1;
      }
    }
    localQCirclePolyBaseLikeView2.setExtraTypeInfo(this.p);
    localQCirclePolyBaseLikeView2.setReportBean(this.o);
    localQCirclePolyBaseLikeView2.setRequestManager(this.q);
    localQCirclePolyBaseLikeView2.setCurrentFeed(this.f);
    localQCirclePolyBaseLikeView2.setHookListener(new QCirclePolyLikePopWindow.4(this, paramStPolyLike, localQCirclePolyBaseLikeView2));
    localQCirclePolyBaseLikeView2.bindData(paramStPolyLike, paramInt);
    paramStPolyLike = new LinearLayout.LayoutParams(-1, -1);
    paramStPolyLike.weight = 1.0F;
    this.h.addView(localQCirclePolyBaseLikeView2.c, paramStPolyLike);
  }
  
  public static void b()
  {
    QCirclePolyLikeInfoManger.a.clear();
  }
  
  private void d()
  {
    List localList = this.j;
    if (localList != null)
    {
      int i2 = localList.size();
      int i1 = b;
      if (i2 <= i1) {
        i1 = this.j.size();
      }
      this.k = i1;
      setWidth(-2);
      setHeight(a);
    }
  }
  
  private void e()
  {
    this.l = new RFWMultiDownloadHelper();
    Iterator localIterator = this.d.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QCirclePolyBaseLikeView)this.d.get(localObject);
      this.l.addTask(new RFWMultiDownloadHelper.DownloadTask(((QCirclePolyBaseLikeView)localObject).e.polySource.get(), QCirclePluginConfig.e()));
      a((QCirclePolyBaseLikeView)localObject);
      if (!QCirclePolyLikeInfoManger.a.containsKey(((QCirclePolyBaseLikeView)localObject).e.polySource.get())) {
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      f();
      QLog.d("QCirclePolymorphicLikePopWindow", 1, "shouldDownload");
      return;
    }
    g();
    QLog.d("QCirclePolymorphicLikePopWindow", 1, "should not Download");
  }
  
  private void f()
  {
    this.m = new QCirclePolyLikePopWindow.1(this);
    this.l.setListener(this.m);
    this.l.start();
  }
  
  private void g()
  {
    this.r.post(new QCirclePolyLikePopWindow.3(this));
  }
  
  public void a()
  {
    try
    {
      if (this.e.get() != null)
      {
        QCirclePolyLikeInfoManger.a().d();
        Object localObject = new int[2];
        int i1 = DisplayUtil.e() / 2;
        ((View)this.e.get()).getLocationInWindow((int[])localObject);
        setAnimationStyle(2131953415);
        if (localObject[1] > a + ViewUtils.a(60.0F) + ImmersiveUtils.a(this.g.getContext()))
        {
          setAnimationStyle(2131953415);
          double d1 = localObject[1];
          i2 = a;
          double d2 = i2;
          Double.isNaN(d2);
          d2 /= 1.5D;
          Double.isNaN(d1);
          double d3 = i1;
          Double.isNaN(d3);
          i2 = (int)(d1 - d2 - d3);
          i1 = i2;
          if (this.i) {
            i1 = i2 - ViewUtils.a(5.0F);
          }
        }
        else
        {
          setAnimationStyle(2131953414);
          i1 = localObject[1] + ((View)this.e.get()).getHeight() + a / 4 - i1;
        }
        localObject = (View)this.e.get();
        int i2 = 0;
        showAtLocation((View)localObject, 1, 0, i1);
        this.h.removeAllViews();
        SimpleEventBus.getInstance().registerReceiver(this);
        i1 = i2;
        if (this.c != null)
        {
          this.c.setText(String.format(this.h.getContext().getResources().getString(2131895839), new Object[] { Float.valueOf(QCirclePolyLikeInfoManger.a().c()) }));
          i1 = i2;
        }
        while (i1 < this.k)
        {
          a((QQCircleFeedBase.StPolyLike)this.j.get(i1), i1);
          i1 += 1;
        }
        e();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(View paramView1, View paramView2, boolean paramBoolean, QCirclePolyLikeAniView paramQCirclePolyLikeAniView, FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.e = new WeakReference(paramView1);
    this.f = paramStFeed;
    this.i = paramBoolean;
    this.j = paramList;
    this.p = paramQCircleExtraTypeInfo;
    this.q.a(paramQCircleExtraTypeInfo, paramView1, paramView2, paramQCirclePolyLikeAniView);
    d();
  }
  
  public void a(QCirclePolyLikeFrameLayout.OnClickHookListener paramOnClickHookListener)
  {
    this.s = paramOnClickHookListener;
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.n = paramReportBean;
    this.q.a(this.n);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.o = QCircleReportBean.setReportBean("QCirclePolymorphicLikePopWindow", paramQCircleReportBean);
    this.q.a(paramQCircleReportBean);
  }
  
  public QCircleReportBean c()
  {
    return QCircleReportBean.getReportBean("QCirclePolymorphicLikePopWindow", this.o);
  }
  
  public void dismiss()
  {
    super.dismiss();
    Object localObject = this.d.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCirclePolyBaseLikeView localQCirclePolyBaseLikeView = (QCirclePolyBaseLikeView)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localQCirclePolyBaseLikeView != null) && (localQCirclePolyBaseLikeView.a != null))
      {
        if (localQCirclePolyBaseLikeView.a.getAnimationFromInfo() == null) {
          return;
        }
        localQCirclePolyBaseLikeView.a.b();
      }
      else
      {
        return;
      }
    }
    localObject = this.r;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePopWindowUpdateBalanceEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePopWindowUpdateBalanceEvent))
    {
      paramSimpleBaseEvent = (QCirclePopWindowUpdateBalanceEvent)paramSimpleBaseEvent;
      if (QCirclePluginUtil.d(paramSimpleBaseEvent.uin))
      {
        Handler localHandler = this.r;
        if (localHandler != null)
        {
          localHandler.post(new QCirclePolyLikePopWindow.5(this, paramSimpleBaseEvent));
          QCirclePolyLikeInfoManger.a().a(paramSimpleBaseEvent.balance);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow
 * JD-Core Version:    0.7.0.1
 */