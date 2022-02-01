package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StFeed;
import vrg;
import vuq;
import waj;

public class QCircleFeedCleanPlayView
  extends QCircleBaseVideoView
{
  private int jdField_a_of_type_Int;
  waj jdField_a_of_type_Waj;
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
    return null;
  }
  
  protected String a()
  {
    return "QCircleFeedCleanPlayView";
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Vuq != null) {
      this.jdField_a_of_type_Vuq.a();
    }
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
      vrg.a(2, 7, 1, this.jdField_a_of_type_Int, paramLong1, paramLong2, this.d, str, localStFeed, vrg.a(localStFeed), b());
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
      vrg.a(2, 4, 1, this.jdField_a_of_type_Int, 0L, 0L, true, "", localStFeed, vrg.a(localStFeed), b());
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
      if (this.jdField_a_of_type_Vuq != null) {
        this.jdField_a_of_type_Vuq.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    paramISuperPlayer.setXYaxis(2);
    if (this.jdField_a_of_type_Vuq != null) {
      this.jdField_a_of_type_Vuq.a(paramISuperPlayer);
    }
  }
  
  public void setFeedPresenter(waj paramwaj)
  {
    this.jdField_a_of_type_Waj = paramwaj;
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */