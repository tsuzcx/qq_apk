package com.tencent.aelight.camera.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.tencent.aelight.camera.ae.album.fragment.AENewPhotoListFragment;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

class AEPhotoListLogicAECircle$3
  implements MovieExporter.VideoCompressListener
{
  AEPhotoListLogicAECircle$3(AEPhotoListLogicAECircle paramAEPhotoListLogicAECircle, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onCompressCanceled()
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle, false);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle, false);
    QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2064515418, 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  public void onCompressFinish(String paramString)
  {
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle, false);
    if (!AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      AEQLog.d("PhotoListCustomizationAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      FileUtils.deleteFile(paramString);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle;
    int j = 1;
    AEPhotoListLogicAECircle.a((AEPhotoListLogicAECircle)localObject, 1);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
    paramString = AlbumUtil.sSelectItemAlbum;
    if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
    {
      localObject = new Pair(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localObject);
    }
    int i = j;
    if (Build.VERSION.SDK_INT >= 23) {
      if (((AENewPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0)
    {
      AEQLog.b("PhotoListCustomizationAECircle", "updateWMProps onGetLocation");
      WatermarkDataManager.a().a(new AEPhotoListLogicAECircle.3.1(this));
    }
    AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    if ((AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle) != null) && (AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle).isShowing()) && (AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle) != null))
    {
      int i = (int)(paramFloat * 100.0F);
      AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle).c(i);
      ProgressPieDrawable localProgressPieDrawable = AEPhotoListLogicAECircle.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicAECircle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      localProgressPieDrawable.a(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle.3
 * JD-Core Version:    0.7.0.1
 */