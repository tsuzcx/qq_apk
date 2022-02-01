package com.tencent.aelight.camera.ae.biz.circle.part;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class AECirclePreviewPart$1
  implements RecyclerView.OnItemTouchListener
{
  AECirclePreviewPart$1(AECirclePreviewPart paramAECirclePreviewPart) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      AECirclePreviewPart.a(this.a, paramMotionEvent.getY());
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      float f = paramMotionEvent.getY();
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append(AECirclePreviewPart.a(this.a));
      paramRecyclerView.append(" ");
      paramRecyclerView.append(f);
      QLog.d("AECirclePreviewPart", 4, paramRecyclerView.toString());
      if (Math.abs(f - AECirclePreviewPart.a(this.a)) > 600.0F)
      {
        AECirclePreviewPart.a(this.a);
        return true;
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart.1
 * JD-Core Version:    0.7.0.1
 */