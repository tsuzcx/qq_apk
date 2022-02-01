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

class bnga
  implements MovieExporter.VideoCompressListener
{
  bnga(bnfz parambnfz, long paramLong, EncoderWriter.OutputConfig paramOutputConfig, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString) {}
  
  public void onCompressCanceled()
  {
    bnfz.a(this.jdField_a_of_type_Bnfz, false);
    bgmg.d(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    bnfz.a(this.jdField_a_of_type_Bnfz, false);
    QQToast.a(((bnfn)this.jdField_a_of_type_Bnfz.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131719010, 0).b(((bnfn)this.jdField_a_of_type_Bnfz.jdField_a_of_type_MqqUtilWeakReference.get()).d);
    bgmg.d(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onCompressFinish(String paramString)
  {
    bnfz.a(this.jdField_a_of_type_Bnfz, false);
    if (!bnfz.a(this.jdField_a_of_type_Bnfz, this.jdField_a_of_type_ComTencentTavDecoderEncoderWriter$OutputConfig, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration))
    {
      bnzb.d("PhotoListLogicAECircle", "[compressVideoToEdit] compress error");
      onCompressError(null);
      return;
    }
    bnfz.a(this.jdField_a_of_type_Bnfz, 1);
    this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramString);
    this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    paramString = (LinkedHashMap)bgkc.sSelectItemPosMap.get(this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    if (paramString == null)
    {
      paramString = new LinkedHashMap();
      bgkc.sSelectItemPosMap.put(this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramString);
    }
    for (;;)
    {
      paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((bnfn)this.jdField_a_of_type_Bnfz.jdField_a_of_type_MqqUtilWeakReference.get()).a.getLayoutManager()).findFirstVisibleItemPosition()));
      paramString = bgkc.sSelectItemAlbum;
      if (!paramString.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramString.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, localPair);
      }
      int i;
      if (Build.VERSION.SDK_INT >= 23) {
        if (((bnfn)this.jdField_a_of_type_Bnfz.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          bnzb.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          bnnx.a().a();
        }
        bnfz.a(this.jdField_a_of_type_Bnfz);
        this.jdField_a_of_type_Bnfz.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
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
    if ((bnfz.a(this.jdField_a_of_type_Bnfz) != null) && (bnfz.a(this.jdField_a_of_type_Bnfz).isShowing()) && (bnfz.a(this.jdField_a_of_type_Bnfz) != null))
    {
      int i = (int)(100.0F * paramFloat);
      bnfz.a(this.jdField_a_of_type_Bnfz).c(i);
      bnfz.a(this.jdField_a_of_type_Bnfz).a(i + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnga
 * JD-Core Version:    0.7.0.1
 */