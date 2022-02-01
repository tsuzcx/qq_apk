package com.tencent.aelight.camera.ae.album.logic;

import android.support.v7.widget.GridLayoutManager;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$1
  implements Runnable
{
  AEPhotoListLogicBase$1(AEPhotoListLogicBase paramAEPhotoListLogicBase, int paramInt) {}
  
  public void run()
  {
    ((AEAbstractPhotoListFragment)this.this$0.b.get()).k.scrollToPositionWithOffset(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.1
 * JD-Core Version:    0.7.0.1
 */