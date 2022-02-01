package com.tencent.av.ui;

import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import java.lang.ref.WeakReference;

public class VideoLayerUI$WeakTouchListener
  implements GLView.OnTouchListener
{
  private WeakReference<VideoLayerUI.TouchListener> a;
  
  public VideoLayerUI$WeakTouchListener(VideoLayerUI.TouchListener paramTouchListener)
  {
    this.a = new WeakReference(paramTouchListener);
  }
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    VideoLayerUI.TouchListener localTouchListener = (VideoLayerUI.TouchListener)this.a.get();
    if (localTouchListener != null) {
      return localTouchListener.a(paramGLView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.WeakTouchListener
 * JD-Core Version:    0.7.0.1
 */