package com.tencent.aelight.camera.ae.album.logic;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$12
  implements VideoPlayerCallback
{
  AEPhotoListLogicBase$12(AEPhotoListLogicBase paramAEPhotoListLogicBase, VideoPlayParam paramVideoPlayParam, String paramString) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayError---errorType=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", errorCode=");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(", exInfo=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("\nvideoPath=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    AEQLog.d("AEPhotoListLogicBase", ((StringBuilder)localObject).toString());
    paramString = this.jdField_a_of_type_JavaLangString;
    if ((paramString != null) && (paramString.equals(AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase))) && (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      paramInt1 = AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_JavaLangString);
      if (paramInt1 != -1)
      {
        paramString = (AEAbstractPhotoListFragment.PhotoVH)((AEAbstractPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt1);
        localObject = ((AEAbstractPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt1);
        AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase, paramInt1, (LocalMediaInfo)localObject, paramString);
      }
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStateChange---state=");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEPhotoListLogicBase", localStringBuilder.toString());
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        if (paramInt != 9) {
          return;
        }
        AEPhotoListLogicBase.c(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase);
        return;
      }
      AEPhotoListLogicBase.c(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase);
      ((AEAbstractPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).a(true);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
      AEPhotoListLogicBase.b(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase);
    }
    ((AEAbstractPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.12
 * JD-Core Version:    0.7.0.1
 */