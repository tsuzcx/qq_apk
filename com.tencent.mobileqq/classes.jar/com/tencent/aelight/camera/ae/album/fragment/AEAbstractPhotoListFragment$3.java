package com.tencent.aelight.camera.ae.album.fragment;

import com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEAbstractPhotoListFragment$3
  implements AEAlbumLinearLayout.ScrollListener
{
  AEAbstractPhotoListFragment$3(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void a(float paramFloat)
  {
    this.a.a.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.a.a.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a.a(paramInt, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!AEAbstractPhotoListFragment.a(this.a)) && (!paramBoolean))
    {
      if (this.a.a.e.initialHasPickedNum > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      AEReportUtils.a(paramBoolean);
      AEAbstractPhotoListFragment.a(this.a, true);
    }
  }
  
  public void b(float paramFloat)
  {
    this.a.a.b(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.3
 * JD-Core Version:    0.7.0.1
 */