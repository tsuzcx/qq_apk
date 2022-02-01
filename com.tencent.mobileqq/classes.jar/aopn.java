import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aopn
  extends aoot
{
  aopi jdField_a_of_type_Aopi = null;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  public aopn(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aoou paramaoou, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, 100, paramBoolean1, paramDrawable1, paramDrawable2, paramaoou, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
  
  protected Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) {
      return null;
    }
    String str = FaceInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.b, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c);
    return ((aope)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216)).a(str);
  }
  
  protected Bitmap a(boolean paramBoolean)
  {
    return a();
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    Bitmap localBitmap = a();
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",bitmap is already in cache...");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, localBitmap);
      return;
    }
    if (this.jdField_a_of_type_Aopi == null)
    {
      this.jdField_a_of_type_Aopi = new aopo(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Aopi);
    }
    ((aopc)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(4)).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "requestDecode.faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) {
      return false;
    }
    FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, this));
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aopi != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Aopi);
      this.jdField_a_of_type_Aopi = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */