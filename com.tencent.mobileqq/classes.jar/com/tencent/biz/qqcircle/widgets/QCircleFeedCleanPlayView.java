package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import feedcloud.FeedCloudMeta.StFeed;
import tyk;
import udu;
import vrr;
import vrw;
import vsv;
import yjd;

public class QCircleFeedCleanPlayView
  extends BaseVideoView
{
  private int jdField_a_of_type_Int;
  udu jdField_a_of_type_Udu;
  private vrw jdField_a_of_type_Vrw;
  private yjd jdField_a_of_type_Yjd;
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
      tyk.a(2, 4, 1, this.jdField_a_of_type_Int + 1, paramLong1, paramLong2, this.d, str, localStFeed, tyk.a(localStFeed));
    }
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(Context paramContext, View paramView) {}
  
  public void a(Object paramObject) {}
  
  public void a(vrr paramvrr)
  {
    super.a(paramvrr);
    a().setXYaxis(2);
    if (this.jdField_a_of_type_Vrw != null) {
      this.jdField_a_of_type_Vrw.a(paramvrr);
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Yjd != null) {
        this.jdField_a_of_type_Yjd.a("", paramMessage.arg2, paramMessage.arg1);
      }
    }
  }
  
  public void setFeedPresenter(udu paramudu)
  {
    this.jdField_a_of_type_Udu = paramudu;
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnPreparedListener(vrw paramvrw)
  {
    this.jdField_a_of_type_Vrw = paramvrw;
  }
  
  public void setOnProgressListener(yjd paramyjd)
  {
    this.jdField_a_of_type_Yjd = paramyjd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */