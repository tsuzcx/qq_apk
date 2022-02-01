import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import java.util.ArrayList;
import mqq.util.WeakReference;

class bmzs
  implements VideoPlayerCallback
{
  bmzs(bmzr parambmzr, VideoPlayParam paramVideoPlayParam, String paramString) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    bnrh.d("AEPhotoListLogicBase", "onPlayError---errorType=" + paramInt2 + ", errorCode=" + paramInt3 + ", exInfo=" + paramString + "\nvideoPath=" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(bmzr.a(this.jdField_a_of_type_Bmzr))) && (this.jdField_a_of_type_Bmzr.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      paramInt1 = bmzr.a(this.jdField_a_of_type_Bmzr, this.jdField_a_of_type_JavaLangString);
      if (paramInt1 != -1)
      {
        paramString = (bmyx)((bmyq)this.jdField_a_of_type_Bmzr.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt1);
        LocalMediaInfo localLocalMediaInfo = ((bmyq)this.jdField_a_of_type_Bmzr.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Bmyv.a(paramInt1);
        bmzr.a(this.jdField_a_of_type_Bmzr, localLocalMediaInfo, paramString);
      }
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    bnrh.b("AEPhotoListLogicBase", "onStateChange---state=" + paramInt);
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 4: 
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
        bmzr.b(this.jdField_a_of_type_Bmzr);
      }
      ((bmyq)this.jdField_a_of_type_Bmzr.jdField_a_of_type_MqqUtilWeakReference.get()).a(false);
      return;
    case 6: 
      bmzr.c(this.jdField_a_of_type_Bmzr);
      ((bmyq)this.jdField_a_of_type_Bmzr.jdField_a_of_type_MqqUtilWeakReference.get()).a(true);
      return;
    }
    bmzr.c(this.jdField_a_of_type_Bmzr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzs
 * JD-Core Version:    0.7.0.1
 */