package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$8
  implements Runnable
{
  AEPhotoListLogicBase$8(AEPhotoListLogicBase paramAEPhotoListLogicBase, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      QQToast.makeText(((AEAbstractPhotoListFragment)this.this$0.b.get()).getActivity(), "暂无媒体文件", 1000).show();
    }
    ((AEAbstractPhotoListFragment)this.this$0.b.get()).d.notifyDataSetChanged();
    ((AEAbstractPhotoListFragment)this.this$0.b.get()).a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.8
 * JD-Core Version:    0.7.0.1
 */