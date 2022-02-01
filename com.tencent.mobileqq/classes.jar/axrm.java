import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class axrm
  implements ImageAssetDelegate
{
  axrm(axrl paramaxrl) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.a.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable).get();
    int i;
    int j;
    if (localObject != null)
    {
      paramLottieImageAsset = paramLottieImageAsset.getFileName();
      i = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      j = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      localObject = this.a.jdField_a_of_type_JavaLangString + "entry_images" + File.separator + paramLottieImageAsset;
    }
    for (;;)
    {
      try
      {
        paramLottieImageAsset = mqa.a((String)localObject, i, j);
        localObject = paramLottieImageAsset;
        if (paramLottieImageAsset == null) {
          localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        }
        return localObject;
      }
      catch (Exception paramLottieImageAsset)
      {
        if (AudioHelper.f()) {
          QLog.w(PromotionEntry.jdField_a_of_type_JavaLangString, 1, "UpdateOperateBtnStatusRunnable Exception, imagePath[" + (String)localObject + "]", paramLottieImageAsset);
        }
      }
      paramLottieImageAsset = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrm
 * JD-Core Version:    0.7.0.1
 */