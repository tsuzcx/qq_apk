package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import vtr;
import vxr;

public class QCircleFeedCleanPlayView
  extends QCircleBaseVideoView
{
  private int jdField_a_of_type_Int;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private boolean d;
  
  public QCircleFeedCleanPlayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 0;
  }
  
  public SeekBar a()
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
      return this.jdField_a_of_type_AndroidWidgetSeekBar;
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleFeedCleanPlayView";
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null)
    {
      String str = "";
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        str = paramInt2 + ":" + paramInt1;
      }
      vtr.a(2, 7, 1, this.jdField_a_of_type_Int, paramLong1, paramLong2, this.d, str, localStFeed, vtr.a(localStFeed), b());
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Context paramContext, View paramView) {}
  
  public void a(Object paramObject) {}
  
  public void b(long paramLong1, long paramLong2) {}
  
  public boolean b()
  {
    if (a() != null) {
      return a().isPlaying();
    }
    return false;
  }
  
  public boolean c()
  {
    if (a() != null) {
      return a().isPausing();
    }
    return false;
  }
  
  public void f()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null) {
      vtr.a(2, 4, 1, this.jdField_a_of_type_Int, 0L, 0L, true, "", localStFeed, vtr.a(localStFeed), b());
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Vxr != null) {
      this.jdField_a_of_type_Vxr.a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Vxr != null) {
        this.jdField_a_of_type_Vxr.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    paramISuperPlayer.setXYaxis(2);
    if (this.jdField_a_of_type_Vxr != null) {
      this.jdField_a_of_type_Vxr.a(paramISuperPlayer);
    }
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setProgressBar(SeekBar paramSeekBar)
  {
    if (paramSeekBar != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar = paramSeekBar;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */