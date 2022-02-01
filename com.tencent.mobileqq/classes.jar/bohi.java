import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

class bohi
  implements MovieExporter.VideoCompressListener
{
  bohi(bohh parambohh, long paramLong, EncoderWriter.OutputConfig paramOutputConfig, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString) {}
  
  public void onCompressCanceled()
  {
    bohh.a(this.jdField_a_of_type_Bohh, false);
    bhmi.d(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    bohh.a(this.jdField_a_of_type_Bohh, false);
    QQToast.a(((bogv)this.jdField_a_of_type_Bohh.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131719179, 0).b(((bogv)this.jdField_a_of_type_Bohh.jdField_a_of_type_MqqUtilWeakReference.get()).d);
    bhmi.d(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onCompressFinish(String paramString)
  {
    bohh.a(this.jdField_a_of_type_Bohh, false);
    if (!bohh.a(this.jdField_a_of_type_Bohh, this.jdField_a_of_type_ComTencentTavDecoderEncoderWriter$OutputConfig, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      bpam.d("PhotoListLogicAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      return;
    }
    bohh.a(this.jdField_a_of_type_Bohh, 1);
    this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = (LinkedHashMap)bhkd.sSelectItemPosMap.get(this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramString == null)
    {
      paramString = new LinkedHashMap();
      bhkd.sSelectItemPosMap.put(this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    for (;;)
    {
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bogv)this.jdField_a_of_type_Bohh.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
      paramString = bhkd.sSelectItemAlbum;
      if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localPair);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bogv)this.jdField_a_of_type_Bohh.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bpam.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bopi.a().a();
        }
        bohh.a(this.jdField_a_of_type_Bohh);
        this.jdField_a_of_type_Bohh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
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
    if ((bohh.a(this.jdField_a_of_type_Bohh) != null) && (bohh.a(this.jdField_a_of_type_Bohh).isShowing()) && (bohh.a(this.jdField_a_of_type_Bohh) != null))
    {
      int i = (int)(100.0F * paramFloat);
      bohh.a(this.jdField_a_of_type_Bohh).c(i);
      bohh.a(this.jdField_a_of_type_Bohh).a(i + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohi
 * JD-Core Version:    0.7.0.1
 */