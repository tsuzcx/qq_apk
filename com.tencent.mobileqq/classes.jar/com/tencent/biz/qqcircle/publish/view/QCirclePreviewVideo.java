package com.tencent.biz.qqcircle.publish.view;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;

public class QCirclePreviewVideo
  extends BaseVideoView
{
  public QCirclePreviewVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePreviewVideo(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePreviewVideo(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void bindData(Object paramObject, int paramInt)
  {
    setVideoPath(null, (String)paramObject, paramInt);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public SeekBar getProgressBar()
  {
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  protected void j() {}
  
  protected void l()
  {
    super.l();
  }
  
  protected boolean m()
  {
    return true;
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.QCirclePreviewVideo
 * JD-Core Version:    0.7.0.1
 */