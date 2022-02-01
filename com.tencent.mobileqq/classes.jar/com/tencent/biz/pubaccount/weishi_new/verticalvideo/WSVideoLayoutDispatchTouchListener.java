package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class WSVideoLayoutDispatchTouchListener
  implements WSVerticalVideoRelativeLayout.DispatchTouchEventListener
{
  private WeakReference<WSVerticalVideoRelativeLayout> a;
  private WeakReference<WSPlayerControlBar> b;
  private Runnable c;
  private boolean d;
  
  public WSVideoLayoutDispatchTouchListener(WSVerticalVideoRelativeLayout paramWSVerticalVideoRelativeLayout)
  {
    this.a = new WeakReference(paramWSVerticalVideoRelativeLayout);
  }
  
  public void a()
  {
    this.a.clear();
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.c = null;
  }
  
  public void a(WSPlayerControlBar paramWSPlayerControlBar)
  {
    this.b = new WeakReference(paramWSPlayerControlBar);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = (WSPlayerControlBar)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        Object localObject2 = new Rect();
        ((WSPlayerControlBar)localObject1).a((Rect)localObject2);
        if ((this.d) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject2).left) && (paramMotionEvent.getX() < ((Rect)localObject2).right)))
        {
          if (!this.d)
          {
            this.d = true;
            ((WSPlayerControlBar)localObject1).a(c());
            ((WSPlayerControlBar)localObject1).setSeekBarActivated(true);
            ((WSPlayerControlBar)localObject1).setThumb(BaseApplicationImpl.getContext().getResources().getDrawable(2130842804));
            WSVerticalVideoRelativeLayout localWSVerticalVideoRelativeLayout = (WSVerticalVideoRelativeLayout)this.a.get();
            if (localWSVerticalVideoRelativeLayout != null) {
              localWSVerticalVideoRelativeLayout.requestDisallowInterceptTouchEvent(true);
            }
          }
          float f2 = ((Rect)localObject2).top;
          float f3 = ((Rect)localObject2).height() / 2.0F;
          float f1 = paramMotionEvent.getX() - ((Rect)localObject2).left;
          if (f1 < 0.0F) {
            f1 = 0.0F;
          } else if (f1 > ((Rect)localObject2).width()) {
            f1 = ((Rect)localObject2).width();
          }
          localObject2 = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f2 + f3, paramMotionEvent.getMetaState());
          if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
          {
            ((WSPlayerControlBar)localObject1).postDelayed(this.c, 400L);
            this.d = false;
            paramMotionEvent = (WSVerticalVideoRelativeLayout)this.a.get();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(false);
            }
          }
          ((WSPlayerControlBar)localObject1).a((MotionEvent)localObject2);
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public Runnable c()
  {
    if (this.c == null) {
      this.c = new WSVideoLayoutDispatchTouchListener.1(this);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVideoLayoutDispatchTouchListener
 * JD-Core Version:    0.7.0.1
 */