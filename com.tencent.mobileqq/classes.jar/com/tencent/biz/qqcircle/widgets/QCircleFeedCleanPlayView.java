package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import feedcloud.FeedCloudMeta.StFeed;
import tzw;
import ugu;
import vwa;
import vwf;
import vxe;
import ynq;

public class QCircleFeedCleanPlayView
  extends BaseVideoView
{
  private int jdField_a_of_type_Int;
  ugu jdField_a_of_type_Ugu;
  private vwf jdField_a_of_type_Vwf;
  private ynq jdField_a_of_type_Ynq;
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
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null)
    {
      String str = "";
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        str = paramInt2 + ":" + paramInt1;
      }
      tzw.a(2, 7, 1, this.jdField_a_of_type_Int, paramLong1, paramLong2, this.d, str, localStFeed, tzw.a(localStFeed));
    }
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(Context paramContext, View paramView) {}
  
  public void a(Object paramObject) {}
  
  public void a(vwa paramvwa)
  {
    super.a(paramvwa);
    a().setXYaxis(2);
    if (this.jdField_a_of_type_Vwf != null) {
      this.jdField_a_of_type_Vwf.a(paramvwa);
    }
  }
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void d() {}
  
  public boolean d()
  {
    if (a() != null) {
      return a().a();
    }
    return false;
  }
  
  protected void f()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
    if (localStFeed != null) {
      tzw.a(2, 4, 1, this.jdField_a_of_type_Int, 0L, 0L, true, "", localStFeed, tzw.a(localStFeed));
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
      if (this.jdField_a_of_type_Ynq != null) {
        this.jdField_a_of_type_Ynq.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
  }
  
  public void setFeedPresenter(ugu paramugu)
  {
    this.jdField_a_of_type_Ugu = paramugu;
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnPreparedListener(vwf paramvwf)
  {
    this.jdField_a_of_type_Vwf = paramvwf;
  }
  
  public void setOnProgressListener(ynq paramynq)
  {
    this.jdField_a_of_type_Ynq = paramynq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */