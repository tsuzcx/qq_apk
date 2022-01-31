import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class bkmp<K extends bklz>
{
  public static volatile bkmp a;
  protected aimj a;
  public bkmq a;
  public AlbumListBaseData a;
  public WeakReference<K> a;
  
  protected bkmp(K paramK)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true);
    this.jdField_a_of_type_Aimj = aimj.getInstance();
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Aimj.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListBaseData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_Aimj);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Aimj);
    }
    this.jdField_a_of_type_Aimj.releaseCommonData();
    jdField_a_of_type_Bkmp = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmp
 * JD-Core Version:    0.7.0.1
 */