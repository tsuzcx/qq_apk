import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

class bmzo
  implements MovieExporter.VideoCompressListener
{
  bmzo(bmzm parambmzm, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onCompressCanceled()
  {
    bmzm.a(this.jdField_a_of_type_Bmzm, false);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    bmzm.a(this.jdField_a_of_type_Bmzm, false);
    QQToast.a(((bmza)this.jdField_a_of_type_Bmzm.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131719917, 0).b(((bmza)this.jdField_a_of_type_Bmzm.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  public void onCompressFinish(String paramString)
  {
    bmzm.a(this.jdField_a_of_type_Bmzm, false);
    if (!bmzm.a(this.jdField_a_of_type_Bmzm, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      bnrh.d("PhotoListLogicAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      FileUtils.deleteFile(paramString);
      return;
    }
    bmzm.a(this.jdField_a_of_type_Bmzm, 1);
    this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramString == null)
    {
      paramString = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    for (;;)
    {
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bmza)this.jdField_a_of_type_Bmzm.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
      paramString = AlbumUtil.sSelectItemAlbum;
      if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localPair);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bmza)this.jdField_a_of_type_Bmzm.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bnrh.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bnhs.a().a();
        }
        bmzm.a(this.jdField_a_of_type_Bmzm);
        this.jdField_a_of_type_Bmzm.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        return;
        i = 0;
        continue;
        i = 1;
      }
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    if ((bmzm.a(this.jdField_a_of_type_Bmzm) != null) && (bmzm.a(this.jdField_a_of_type_Bmzm).isShowing()) && (bmzm.a(this.jdField_a_of_type_Bmzm) != null))
    {
      int i = (int)(100.0F * paramFloat);
      bmzm.a(this.jdField_a_of_type_Bmzm).c(i);
      bmzm.a(this.jdField_a_of_type_Bmzm).a(i + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzo
 * JD-Core Version:    0.7.0.1
 */