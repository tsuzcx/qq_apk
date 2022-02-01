package com.tencent.biz.qqcircle.fragments.content;

import aadv;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.List;
import uys;
import vrd;
import vtr;
import vtt;
import vwr;

public class QCircleContentVideo
  extends QCircleBaseVideoView
{
  private int jdField_a_of_type_Int;
  private volatile QCircleContentOperationView jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView;
  private int b = 2;
  private boolean d;
  
  public QCircleContentVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void o() {}
  
  public void M_()
  {
    if (a() == null) {
      return;
    }
    if (a().isPlaying())
    {
      c();
      return;
    }
    if (this.d)
    {
      e();
      return;
    }
    d();
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    if (a() != null) {
      return a().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public SeekBar a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetSeekBar;
    }
    return null;
  }
  
  public String a()
  {
    return "QCircleContentVideo";
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    String str1;
    ArrayList localArrayList;
    if (localStFeed != null)
    {
      str1 = "";
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        str1 = paramInt2 + ":" + paramInt1;
      }
      localArrayList = vtr.a(localStFeed);
      if (!QCircleContentImmersiveEvent.isImmersive()) {
        break label112;
      }
    }
    label112:
    for (String str2 = "2";; str2 = "1")
    {
      localArrayList.add(vtt.a("ext4", str2));
      vtr.a(2, 7, this.b, this.jdField_a_of_type_Int, paramLong1, paramLong2, true, str1, localStFeed, localArrayList, d());
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    ArrayList localArrayList;
    if (localStFeed != null)
    {
      localArrayList = vtr.a(localStFeed);
      if (!QCircleContentImmersiveEvent.isImmersive()) {
        break label73;
      }
    }
    label73:
    for (String str = "2";; str = "1")
    {
      localArrayList.add(vtt.a("ext4", str));
      vtr.a(2, 5, this.b, this.jdField_a_of_type_Int, paramLong1, paramLong2, true, "", localStFeed, localArrayList, d());
      return;
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    o();
    setLoopBack(true);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (a() != null)
    {
      paramObject = (FeedCloudMeta.StFeed)paramObject;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = uys.b(a());
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850680);
      paramObject = new vrd().a(paramObject.cover.picUrl.get()).a(a()).c(localURLDrawableOptions.mRequestWidth).b(localURLDrawableOptions.mRequestHeight).a(true).a(localURLDrawableOptions.mLoadingDrawable);
      QCircleFeedPicLoader.a().a(paramObject, null);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if ((localStFeed != null) && (localStFeed.type.get() == 3)) {
      return localStFeed.video.playUrl.get();
    }
    return null;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    ArrayList localArrayList;
    if (localStFeed != null)
    {
      localArrayList = vtr.a(localStFeed);
      if (!QCircleContentImmersiveEvent.isImmersive()) {
        break label71;
      }
    }
    label71:
    for (String str = "2";; str = "1")
    {
      localArrayList.add(vtt.a("ext4", str));
      vtr.a(2, 6, 2, this.jdField_a_of_type_Int, paramLong1, paramLong2, true, "", localStFeed, localArrayList, d());
      return;
    }
  }
  
  public void c()
  {
    super.c();
    a().post(new QCircleContentVideo.1(this));
  }
  
  public void d()
  {
    super.d();
    a().post(new QCircleContentVideo.2(this));
  }
  
  public void e()
  {
    super.e();
    this.d = false;
  }
  
  public void f()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    ArrayList localArrayList;
    if (localStFeed != null)
    {
      localArrayList = vtr.a(localStFeed);
      if (!QCircleContentImmersiveEvent.isImmersive()) {
        break label64;
      }
    }
    label64:
    for (String str = "2";; str = "1")
    {
      localArrayList.add(vtt.a("ext4", str));
      vtr.a(2, 4, this.b, this.jdField_a_of_type_Int, 0L, 0L, true, "", localStFeed, localArrayList, d());
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.d = true;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    super.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    if ((this.c) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.e != null))
    {
      aadv.a(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.e, false);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.e.setText(vwr.a(paramInt) + " | ");
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleExpandableTextView.setVisibility(8);
      }
      paramSeekBar.getLayoutParams().height = ImmersiveUtils.a(4.0F);
      paramSeekBar.requestLayout();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.a(1.0F);
    paramSeekBar.requestLayout();
    a().postDelayed(new QCircleContentVideo.4(this), 500L);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    a().post(new QCircleContentVideo.3(this, paramISuperPlayer));
    d();
  }
  
  public void setOperationView(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView = paramQCircleContentOperationView;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView != null) {
      setLoadingView(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsContentQCircleContentOperationView.jdField_a_of_type_AndroidViewView);
    }
    this.d = false;
    super.setVideoPath(paramStVideo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo
 * JD-Core Version:    0.7.0.1
 */