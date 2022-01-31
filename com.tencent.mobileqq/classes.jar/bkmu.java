import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class bkmu<K extends bkme>
  implements MediaScanner.OnMediaScannerListener
{
  protected static volatile bkmu a;
  public aimj a;
  public bkmv a;
  public bkmw a;
  public bkmx a;
  bkmy a;
  public PhotoListBaseData a;
  public WeakReference<K> a;
  
  protected bkmu(K paramK)
  {
    this.jdField_a_of_type_Bkmy = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true);
    this.jdField_a_of_type_Aimj = aimj.getInstance();
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Aimj.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，fragment = " + paramK + ",PhotoCommonData = " + this.jdField_a_of_type_Aimj);
    }
  }
  
  abstract String a(LocalMediaInfo paramLocalMediaInfo);
  
  public abstract List<LocalMediaInfo> a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public abstract void a(ArrayList<LocalMediaInfo> paramArrayList);
  
  public abstract void a(List<LocalMediaInfo> paramList);
  
  public void a(boolean paramBoolean) {}
  
  abstract void a(boolean paramBoolean, Intent paramIntent);
  
  public abstract boolean a();
  
  public abstract boolean a(List<LocalMediaInfo> paramList);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Aimj);
    }
    this.jdField_a_of_type_Aimj.releaseCommonData();
    jdField_a_of_type_Bkmu = null;
  }
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract void c();
  
  public abstract void c(Intent paramIntent);
  
  public abstract void c(View paramView);
  
  public abstract void d();
  
  public abstract void d(View paramView);
  
  public abstract void e();
  
  public abstract void e(View paramView);
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmu
 * JD-Core Version:    0.7.0.1
 */