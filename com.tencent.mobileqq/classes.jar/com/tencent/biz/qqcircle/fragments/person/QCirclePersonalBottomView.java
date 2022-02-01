package com.tencent.biz.qqcircle.fragments.person;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleBroadcastEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleTimeLineCreateTimeEvent;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel;
import com.tencent.biz.qqcircle.widgets.FrameAnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockMerger.ShareData;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.List;

public class QCirclePersonalBottomView
  extends QCircleBaseWidgetView<BlockMerger.ShareData>
  implements View.OnClickListener, SimpleEventReceiver
{
  private RadioGroup a;
  private MultiTabViewPager b;
  private RadioButton c;
  private RadioButton d;
  private RadioButton e;
  private ImageView f;
  private TextView g;
  private QCirclePersonalBottomView.RelativePersonalBottomAdapter h;
  private MultiViewBlock i;
  private List<QCirclePersonalBaseBottomFragment> j;
  private QCirclePersonalWorksFragment k;
  private QCirclePersonalDynamicFragment l;
  private QCirclePersonalPushFragment m;
  private int n;
  private FrameAnimationView o;
  private int p;
  private String q;
  private FeedCloudMeta.StUser r;
  private FeedCloudMeta.StFeed s;
  private String t;
  private byte[] u = null;
  
  public QCirclePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomView(Context paramContext, MultiViewBlock paramMultiViewBlock)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (paramMultiViewBlock == null) {
      return;
    }
    this.i = paramMultiViewBlock;
    setInteractor(paramMultiViewBlock.getInteractor());
    b();
    this.b.setOffscreenPageLimit(2);
    this.h = new QCirclePersonalBottomView.RelativePersonalBottomAdapter(this, this.i.getParentFragment().getChildFragmentManager());
    this.b.setAdapter(this.h);
    c();
    a(this);
    ((QCirclePersonalDetailPushViewModel)paramMultiViewBlock.getViewModel(QCirclePersonalDetailPushViewModel.class)).a.observe(paramMultiViewBlock.getParentFragment(), new QCirclePersonalBottomView.1(this));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(this.r.id.get()).setActionType(11).setSubActionType(paramInt1).setThrActionType(paramInt2);
    String str;
    if (QCirclePluginUtil.d(this.q)) {
      str = "1";
    } else {
      str = "2";
    }
    QCircleLpReportDc05504.report(localDataBuilder.setExt1(str).setExt9(this.t).setFeedReportInfo(this.u).setPageId(getPageId()));
  }
  
  private void a(@Nullable ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.o = new FrameAnimationView(getContext());
      this.o.setDownloadZipFilePath("https://downv6.qq.com/video_story/personal_page_loading.zip", 1000, FrameAnimationView.a, false);
      paramViewGroup.addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QCircleSkinHelper localQCircleSkinHelper = QCircleSkinHelper.getInstance();
    if (paramBoolean) {
      localObject = "profilepage_timeline_to_grid";
    } else {
      localObject = "profilepage_grid_to_timeline";
    }
    Object localObject = new AnimationDrawableCreateOption.Builder(localQCircleSkinHelper.getUrl((String)localObject));
    ((AnimationDrawableCreateOption.Builder)localObject).a(500);
    ((AnimationDrawableCreateOption.Builder)localObject).a(500L);
    ((AnimationDrawableCreateOption.Builder)localObject).a(true);
    ((AnimationDrawableCreateOption.Builder)localObject).b(true);
    AnimationDrawableFactory.a().a(hashCode(), ((AnimationDrawableCreateOption.Builder)localObject).a(), new QCirclePersonalBottomView.2(this, paramBoolean));
  }
  
  private void b()
  {
    this.q = QCirclePluginUtil.b(getContext());
    this.r = QCirclePluginUtil.c(getContext());
    this.s = QCirclePluginUtil.d(getContext());
    FeedCloudMeta.StFeed localStFeed = this.s;
    if (localStFeed != null)
    {
      this.t = localStFeed.id.get();
      if (this.s.busiReport.has()) {
        this.u = this.s.busiReport.get().toByteArray();
      }
    }
    this.j = new ArrayList();
    this.k = new QCirclePersonalWorksFragment();
    this.l = new QCirclePersonalDynamicFragment();
    this.m = new QCirclePersonalPushFragment();
    this.j.add(this.k);
    this.j.add(this.l);
    this.j.add(this.m);
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.j.size())
    {
      if (i1 == paramInt) {
        ((QCirclePersonalBaseBottomFragment)this.j.get(i1)).a(paramInt);
      } else {
        ((QCirclePersonalBaseBottomFragment)this.j.get(i1)).A();
      }
      i1 += 1;
    }
  }
  
  private void c()
  {
    this.a.setOnCheckedChangeListener(new QCirclePersonalBottomView.3(this));
    this.b.addOnPageChangeListener(new QCirclePersonalBottomView.4(this));
  }
  
  private void c(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    String str = getResources().getString(2131895825);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(QCirclePluginUtil.d(paramInt));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(ViewUtils.a(10.0F)), str.length(), str.length() + 1, 34);
    this.e.setText((CharSequence)localObject);
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 2)
    {
      this.f.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845365));
      return;
    }
    if (paramInt == 1)
    {
      this.f.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845361));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unSupport layoutMode:");
    localStringBuilder.append(paramInt);
    QLog.i("QCirclePersonalBottomView", 1, localStringBuilder.toString());
    this.f.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845365));
  }
  
  public void a()
  {
    if (this.f != null)
    {
      int i1 = this.b.getCurrentItem();
      int i2 = 0;
      if ((i1 == 0) && (this.p > 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      Object localObject = this.f;
      if (i1 == 0) {
        i2 = 8;
      }
      ((ImageView)localObject).setVisibility(i2);
      if (i1 != 0)
      {
        QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(18).setThrActionType(1);
        if (QCirclePluginUtil.e(getContext())) {
          localObject = String.valueOf(1);
        } else {
          localObject = String.valueOf(2);
        }
        QCircleLpReportDc05504.report(localDataBuilder.setvid((String)localObject).setPageId(getPageId()));
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c != null)
    {
      String str = getResources().getString(2131895823);
      Object localObject = this.r;
      if ((localObject != null) && (((FeedCloudMeta.StUser)localObject).blackState.get() != 0))
      {
        this.c.setText(str);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(QCirclePluginUtil.d(paramInt));
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(ViewUtils.a(10.0F)), str.length(), str.length() + 1, 34);
      this.c.setText((CharSequence)localObject);
    }
  }
  
  public void a(BlockMerger.ShareData paramShareData, int paramInt) {}
  
  public void a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramStGetMainPageRsp == null) {
      return;
    }
    this.p = paramStGetMainPageRsp.feedCount.get();
    a(this.p);
    c(paramStGetMainPageRsp.pushRocketCount.get());
    a();
  }
  
  public int getCurrentIndex()
  {
    MultiTabViewPager localMultiTabViewPager = this.b;
    if (localMultiTabViewPager != null) {
      return localMultiTabViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTimeLineCreateTimeEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleBroadcastEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626893;
  }
  
  protected String getLogTag()
  {
    return "QCirclePersonalBottomView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    if ((!FastClickUtils.a(String.valueOf(paramView.getId()), 500L)) && (paramView.getId() == 2131436433))
    {
      QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(18).setThrActionType(2);
      String str;
      if (QCirclePluginUtil.e(getContext())) {
        str = String.valueOf(1);
      } else {
        str = String.valueOf(2);
      }
      QCircleLpReportDc05504.report(localDataBuilder.setvid(str).setPageId(getPageId()));
      if (this.n == 2)
      {
        setLayoutMode(1);
        a(true);
      }
      else
      {
        setLayoutMode(2);
        a(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((RadioGroup)paramView.findViewById(2131444765));
    this.c = ((RadioButton)paramView.findViewById(2131444186));
    this.d = ((RadioButton)paramView.findViewById(2131444184));
    this.e = ((RadioButton)paramView.findViewById(2131444185));
    this.b = ((MultiTabViewPager)paramView.findViewById(2131439999));
    this.f = ((ImageView)paramView.findViewById(2131436433));
    this.g = ((TextView)paramView.findViewById(2131448463));
    this.f.setOnClickListener(this);
    this.n = 2;
    d(2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NestScrollRecyclerView QCirclePersonalBottomView onInterceptTouchEvent hashCode");
    localStringBuilder.append(hashCode());
    QLog.d("QCirclePersonalBottomView", 4, localStringBuilder.toString());
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("NestScrollRecyclerView QCirclePersonalBottomView onInterceptTouchEvent handle");
    paramMotionEvent.append(bool);
    QLog.d("QCirclePersonalBottomView", 4, paramMotionEvent.toString());
    return bool;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    RFThreadManager.getUIHandler().post(new QCirclePersonalBottomView.PersonBottomEventTask(paramSimpleBaseEvent, this));
  }
  
  public void setLayoutMode(int paramInt)
  {
    a();
    d(paramInt);
    if (paramInt == this.n)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("same layoutMode not change");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCirclePersonalBottomView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.n = paramInt;
    Object localObject = this.k;
    if ((localObject != null) && (((QCirclePersonalWorksFragment)localObject).e != null)) {
      this.k.b(paramInt);
    }
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    this.r = paramStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */