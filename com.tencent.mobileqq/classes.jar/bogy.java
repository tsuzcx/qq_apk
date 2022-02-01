import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class bogy<K extends bogi>
{
  public static volatile bogy a;
  public bogz a;
  public AlbumListBaseData a;
  protected PhotoCommonBaseData a;
  public WeakReference<K> a;
  
  protected bogy(K paramK)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = PhotoCommonBaseData.getInstance();
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
    jdField_a_of_type_Bogy = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogy
 * JD-Core Version:    0.7.0.1
 */