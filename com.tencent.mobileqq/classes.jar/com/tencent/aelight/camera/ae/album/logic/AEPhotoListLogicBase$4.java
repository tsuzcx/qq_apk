package com.tencent.aelight.camera.ae.album.logic;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$4
  implements View.OnTouchListener
{
  AEPhotoListLogicBase$4(AEPhotoListLogicBase paramAEPhotoListLogicBase, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.e.isChecked())
    {
      paramView = (LocalMediaInfo)AEPhotoListLogicBase.a(this.c).get(this.b);
      AEPhotoListLogicBase.a(this.c, this.b, paramView, this.a);
      AEPhotoListLogicBase.a(this.c, this.a);
      AEPhotoListLogicBase.b(this.c);
      if (AEPhotoListLogicBase.c(this.c).isEmpty()) {
        ((AEAbstractPhotoListFragment)this.c.b.get()).d.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.4
 * JD-Core Version:    0.7.0.1
 */