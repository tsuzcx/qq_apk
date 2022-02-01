import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anhx
  extends FaceDrawable
{
  anhs jdField_a_of_type_Anhs = null;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  public anhx(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, 100, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
  
  public void cancel()
  {
    if ((this.jdField_a_of_type_Anhs != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Anhs);
      this.jdField_a_of_type_Anhs = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    super.cancel();
  }
  
  public Bitmap getBitmapFromCache()
  {
    if (this.mFaceInfo == null) {
      return null;
    }
    String str = FaceInfo.a(this.mFaceInfo.jdField_a_of_type_Int, this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.b, this.mFaceInfo.c, this.mFaceInfo.d);
    return ((anho)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216)).a(str);
  }
  
  public Bitmap getBitmapFromCache(boolean paramBoolean)
  {
    return getBitmapFromCache();
  }
  
  public void onNeedDownload()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.mFaceInfo);
    }
    Bitmap localBitmap = getBitmapFromCache();
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.mFaceInfo + ",bitmap is already in cache...");
      }
      onDecodeTaskCompleted(this.mFaceInfo, localBitmap);
      return;
    }
    if (this.jdField_a_of_type_Anhs == null)
    {
      this.jdField_a_of_type_Anhs = new anhy(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Anhs);
    }
    ((anhm)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(this.mFaceInfo);
  }
  
  public boolean requestDecode()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "requestDecode.faceInfo=" + this.mFaceInfo);
    }
    if (this.mFaceInfo == null) {
      return false;
    }
    FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.mFaceInfo, this));
    return true;
  }
  
  public void setApp(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhx
 * JD-Core Version:    0.7.0.1
 */