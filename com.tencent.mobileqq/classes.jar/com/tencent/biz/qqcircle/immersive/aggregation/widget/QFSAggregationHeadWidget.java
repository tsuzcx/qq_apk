package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StImage;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StMusicPageData;

public class QFSAggregationHeadWidget
  extends QCircleBaseWidgetView<QQCircleFeedBase.StMusicPageData>
  implements View.OnClickListener, LifecycleOwner
{
  private LifecycleRegistry a;
  private QFSMusicAggregationFragment b;
  private SquareImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private QQCircleFeedBase.StMusicPageData h;
  private QFSMusicAggregationViewModel i;
  private QFSAudioView j;
  private boolean k = true;
  private boolean l;
  private int m;
  private double n;
  private float o;
  private float p;
  private float q;
  private boolean r;
  
  public QFSAggregationHeadWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSAggregationHeadWidget(@NonNull Context paramContext, QFSMusicAggregationFragment paramQFSMusicAggregationFragment)
  {
    super(paramContext);
    this.a = new LifecycleRegistry(this);
    this.a.setCurrentState(Lifecycle.State.CREATED);
    this.b = paramQFSMusicAggregationFragment;
    this.m = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.o = ImmersiveUtils.getScreenWidth();
    this.n = Math.tan(0.5235987755982988D);
    d();
  }
  
  private void a(UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    int i1 = paramUIStateData.c();
    if ((i1 != 2) && (i1 != 3)) {
      return;
    }
    a((QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e());
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    this.h = ((QQCircleFeedBase.StMusicPageData)paramStFeedListBusiRspData.musicPageData.get());
    e();
    f();
  }
  
  private void b(UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if ((paramUIStateData.c() == 3) && (!paramUIStateData.i()) && (this.r))
    {
      QLog.i("QFSAggregationHeadWidget", 1, "playErrorRetry");
      this.k = true;
      this.r = false;
      g();
    }
  }
  
  private void d()
  {
    this.i = ((QFSMusicAggregationViewModel)getViewModel(this.b, QFSMusicAggregationViewModel.class));
    this.i.d().observe(this, new QFSAggregationHeadWidget.1(this));
  }
  
  private void e()
  {
    Option localOption = new Option().setUrl(this.h.music.cover.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(2130845783)).setLoadingDrawable(getContext().getResources().getDrawable(2130845783)).setTargetView(this.c);
    QCircleFeedPicLoader.setViewWidthHeight(localOption, this.c);
    QCircleFeedPicLoader.g().loadImage(localOption, null);
  }
  
  private void f()
  {
    this.e.setText(this.h.music.musicName.get());
    this.f.setText(this.h.music.singerName.get());
    this.g.setText(this.h.desc.get());
  }
  
  private void g()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    if (this.k)
    {
      if ((!TextUtils.isEmpty(((QQCircleFeedBase.StMusicPageData)localObject).music.MID.get())) && (!TextUtils.isEmpty(this.h.music.playUrl.get())))
      {
        this.j.setVideoPath(this.h.music.MID.get(), this.h.music.playUrl.get(), 0);
        h();
        this.d.setImageResource(2130845798);
        this.k = false;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("musicPlayControl  isFirstClick  setVideoPath | mid = ");
        ((StringBuilder)localObject).append(this.h.music.MID.get());
        ((StringBuilder)localObject).append(" | path = ");
        ((StringBuilder)localObject).append(this.h.music.playUrl.get());
        QLog.i("QFSAggregationHeadWidget", 1, ((StringBuilder)localObject).toString());
        return;
      }
      QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131896230), 0);
      QLog.e("QFSAggregationHeadWidget", 1, "mid or url == null");
      return;
    }
    if (this.j.getSuperPlayer().isPlaying())
    {
      this.j.b();
      this.d.setImageResource(2130845799);
      QLog.i("QFSAggregationHeadWidget", 1, "musicPlayControl  pause");
      return;
    }
    this.j.h();
    this.d.setImageResource(2130845798);
    QLog.i("QFSAggregationHeadWidget", 1, "musicPlayControl  start");
  }
  
  private void h()
  {
    this.j.getSuperPlayer().setOnErrorListener(new QFSAggregationHeadWidget.2(this));
  }
  
  public void a()
  {
    QFSAudioView localQFSAudioView = this.j;
    if ((localQFSAudioView != null) && (localQFSAudioView.getSuperPlayer().isPlaying()))
    {
      this.j.b();
      this.l = true;
      QLog.i("QFSAggregationHeadWidget", 1, "onActivityPause  audio pause");
    }
  }
  
  protected void a(QQCircleFeedBase.StMusicPageData paramStMusicPageData, int paramInt) {}
  
  public void b()
  {
    QFSAudioView localQFSAudioView = this.j;
    if ((localQFSAudioView != null) && (localQFSAudioView.getSuperPlayer().isPausing()) && (this.l))
    {
      this.j.h();
      this.l = false;
      QLog.i("QFSAggregationHeadWidget", 1, "onActivityResume  audio start");
    }
  }
  
  public void c()
  {
    QFSAudioView localQFSAudioView = this.j;
    if (localQFSAudioView != null) {
      localQFSAudioView.release();
    }
    this.k = true;
    QLog.i("QFSAggregationHeadWidget", 1, "onActivityDestroyed  release");
  }
  
  public int getLayoutId()
  {
    return 2131627113;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.a;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.setCurrentState(Lifecycle.State.STARTED);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436496) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((SquareImageView)paramView.findViewById(2131436334));
    this.d = ((ImageView)paramView.findViewById(2131436496));
    this.e = ((TextView)paramView.findViewById(2131448814));
    this.f = ((TextView)paramView.findViewById(2131448277));
    this.g = ((TextView)paramView.findViewById(2131448374));
    this.d.setOnClickListener(this);
    this.j = new QFSAudioView(getContext());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        float f2 = Math.abs(this.p - f1);
        f3 = Math.abs(this.q - f3);
        if (f1 - this.p > this.m)
        {
          double d1 = f2;
          double d2 = this.n;
          Double.isNaN(d1);
          if (d1 * d2 > f3) {
            return true;
          }
        }
      }
    }
    else
    {
      this.p = paramMotionEvent.getX();
      this.q = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = this.p;
      if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.o / 4.0F) && ((getContext() instanceof Activity))) {
        ((Activity)getContext()).onBackPressed();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidget
 * JD-Core Version:    0.7.0.1
 */