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
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tav.core.AssetExportSession;
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
    AEPhotoListLogicAECircle.a(this.d, false);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    AEPhotoListLogicAECircle.a(this.d, false);
    QQToast.makeText(((AENewPhotoListFragment)this.d.b.get()).getActivity(), 2064187705, 0).show(((AENewPhotoListFragment)this.d.b.get()).i);
  }
  
  public void onCompressFinish(String paramString)
  {
    AEPhotoListLogicAECircle.a(this.d, false);
    if (!AEPhotoListLogicAECircle.a(this.d, paramString, this.b.mDuration))
    {
      AEQLog.d("PhotoListCustomizationAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      FileUtils.deleteFile(paramString);
      return;
    }
    Object localObject = this.d;
    int j = 1;
    AEPhotoListLogicAECircle.a((AEPhotoListLogicAECircle)localObject, 1);
    this.d.c.selectedPhotoList.add(paramString);
    this.d.c.selectedIndex.add(Integer.valueOf(this.c));
    this.d.c.selectedMediaInfoHashMap.put(paramString, this.b);
    localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.d.c.albumId);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.d.c.albumId, paramString);
    }
    paramString.put(this.b.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.d.b.get()).r.getLayoutManager()).findFirstVisibleItemPosition()));
    paramString = AlbumUtil.sSelectItemAlbum;
    if (!paramString.containsKey(this.b.path))
    {
      localObject = new Pair(this.d.c.albumId, this.d.c.albumName);
      paramString.put(this.b.path, localObject);
    }
    int i = j;
    if (Build.VERSION.SDK_INT >= 23) {
      if (((AENewPhotoListFragment)this.d.b.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
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
    AEPhotoListLogicAECircle.c(this.d);
    this.d.c.selectedPhotoList.clear();
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    if ((AEPhotoListLogicAECircle.a(this.d) != null) && (AEPhotoListLogicAECircle.a(this.d).isShowing()) && (AEPhotoListLogicAECircle.b(this.d) != null))
    {
      int i = (int)(paramFloat * 100.0F);
      AEPhotoListLogicAECircle.b(this.d).d(i);
      ProgressPieDrawable localProgressPieDrawable = AEPhotoListLogicAECircle.b(this.d);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      localProgressPieDrawable.a(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle.3
 * JD-Core Version:    0.7.0.1
 */