package com.tencent.aelight.camera.ae.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.log.AEQLog;

public class AEAlbumPreviewMaskLayout
  extends FrameLayout
{
  private AEAlbumPreviewMaskLayout.OnTouchCallback a;
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = this.a;
      if (paramMotionEvent != null) {
        paramMotionEvent.a();
      }
      AEQLog.a("AEAlbumPreviewMaskLayout", "[onTouchEvent], action=ACTION_DOWN");
    }
    return true;
  }
  
  public void setOnTouchCallback(@Nullable AEAlbumPreviewMaskLayout.OnTouchCallback paramOnTouchCallback)
  {
    this.a = paramOnTouchCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout
 * JD-Core Version:    0.7.0.1
 */