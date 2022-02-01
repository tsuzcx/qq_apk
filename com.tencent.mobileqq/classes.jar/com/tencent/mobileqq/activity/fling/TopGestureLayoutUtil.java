package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;

public class TopGestureLayoutUtil
  implements FlingHelperUtils.IFlingHelperUtils
{
  public boolean isDragFrameLayoutClass(View paramView)
  {
    return paramView instanceof DragFrameLayout;
  }
  
  public boolean isInTwoFingerMode(@Nullable GestureDetector paramGestureDetector)
  {
    if ((paramGestureDetector instanceof StickerGestureDetector)) {
      return ((StickerGestureDetector)paramGestureDetector).isInTowFingerMode;
    }
    if ((paramGestureDetector instanceof StickerDismissGestureDetector)) {
      return ((StickerDismissGestureDetector)paramGestureDetector).isInTowFingerMode;
    }
    return false;
  }
  
  public GestureDetector newStickerDismissGestureDetectorInstance(TopGestureLayout paramTopGestureLayout, Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    return new StickerDismissGestureDetector(paramTopGestureLayout, paramContext, paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayoutUtil
 * JD-Core Version:    0.7.0.1
 */