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

class blmf
  implements MovieExporter.VideoCompressListener
{
  blmf(blmd paramblmd, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onCompressCanceled()
  {
    blmd.a(this.jdField_a_of_type_Blmd, false);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    blmd.a(this.jdField_a_of_type_Blmd, false);
    QQToast.a(((bllr)this.jdField_a_of_type_Blmd.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131719465, 0).b(((bllr)this.jdField_a_of_type_Blmd.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  public void onCompressFinish(String paramString)
  {
    blmd.a(this.jdField_a_of_type_Blmd, false);
    if (!blmd.a(this.jdField_a_of_type_Blmd, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      bmbx.d("PhotoListLogicAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      FileUtils.deleteFile(paramString);
      return;
    }
    blmd.a(this.jdField_a_of_type_Blmd, 1);
    this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramString == null)
    {
      paramString = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    for (;;)
    {
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bllr)this.jdField_a_of_type_Blmd.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
      paramString = AlbumUtil.sSelectItemAlbum;
      if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localPair);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bllr)this.jdField_a_of_type_Blmd.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bmbx.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bltp.a().a();
        }
        blmd.a(this.jdField_a_of_type_Blmd);
        this.jdField_a_of_type_Blmd.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
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
    if ((blmd.a(this.jdField_a_of_type_Blmd) != null) && (blmd.a(this.jdField_a_of_type_Blmd).isShowing()) && (blmd.a(this.jdField_a_of_type_Blmd) != null))
    {
      int i = (int)(100.0F * paramFloat);
      blmd.a(this.jdField_a_of_type_Blmd).c(i);
      blmd.a(this.jdField_a_of_type_Blmd).a(i + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmf
 * JD-Core Version:    0.7.0.1
 */