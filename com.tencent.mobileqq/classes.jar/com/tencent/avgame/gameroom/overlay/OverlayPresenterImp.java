package com.tencent.avgame.gameroom.overlay;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import com.tencent.avgame.gameroom.IGameRoomPresenter;

public class OverlayPresenterImp
  implements IOverlayPresenter
{
  protected IOverlayView a;
  protected IGameRoomPresenter b;
  
  public OverlayPresenterImp(IOverlayView paramIOverlayView)
  {
    this.a = paramIOverlayView;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(RectF paramRectF)
  {
    this.a.a(paramRectF);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.b = paramIGameRoomPresenter;
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString1, Bitmap paramBitmap1, String paramString2, long paramLong1, long paramLong2, long paramLong3, Bitmap paramBitmap2, long paramLong4, boolean paramBoolean)
  {
    this.a.a(paramString1, paramBitmap1, paramString2, paramLong1, paramLong2, paramLong3, paramBitmap2, paramLong4, paramBoolean);
  }
  
  public void a(String paramString, RectF paramRectF, int paramInt)
  {
    this.a.a(paramString, paramRectF, paramInt);
  }
  
  public View b()
  {
    return this.a.getAnswerCardWrapperView();
  }
  
  public void b(RectF paramRectF)
  {
    this.a.b(paramRectF);
  }
  
  public void b(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void b(String paramString, RectF paramRectF, int paramInt)
  {
    this.a.b(paramString, paramRectF, paramInt);
  }
  
  public int c()
  {
    return this.a.getAnswerCoverColor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayPresenterImp
 * JD-Core Version:    0.7.0.1
 */