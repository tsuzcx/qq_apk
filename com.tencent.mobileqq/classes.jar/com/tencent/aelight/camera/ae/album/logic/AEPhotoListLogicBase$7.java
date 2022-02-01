package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$7
  implements Runnable
{
  AEPhotoListLogicBase$7(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void run()
  {
    ((AEAbstractPhotoListFragment)this.this$0.a.get()).a.notifyDataSetChanged();
    this.this$0.d();
    QQToast.a(((AEAbstractPhotoListFragment)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.7
 * JD-Core Version:    0.7.0.1
 */