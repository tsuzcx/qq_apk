package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;

public class QFSAudioView
  extends BaseVideoView
{
  private int f;
  private int g;
  
  public QFSAudioView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
    int i = this.g;
    if (i > 0) {
      setLoopBack(true, this.f, i);
    } else {
      setLoopBack(true);
    }
    paramISuperPlayer.start();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public void c()
  {
    super.c();
  }
  
  public void f()
  {
    super.f();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public SeekBar getProgressBar()
  {
    return null;
  }
  
  protected void j() {}
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSAudioView
 * JD-Core Version:    0.7.0.1
 */