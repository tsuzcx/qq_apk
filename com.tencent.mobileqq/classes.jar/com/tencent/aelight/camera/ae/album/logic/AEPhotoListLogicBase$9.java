package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$9
  implements Runnable
{
  AEPhotoListLogicBase$9(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void run()
  {
    ((AEAbstractPhotoListFragment)this.this$0.b.get()).d.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.9
 * JD-Core Version:    0.7.0.1
 */