import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class blly<K extends bllh>
  implements MediaScanner.OnMediaScannerListener
{
  protected static volatile blly a;
  protected long a;
  public bllz a;
  public blma a;
  public blmb a;
  blmc a;
  public PhotoCommonBaseData<OtherCommonData> a;
  public PhotoListBaseData a;
  public final AEAlbumLogicData a;
  public WeakReference<K> a;
  
  protected blly(K paramK)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData = new AEAlbumLogicData();
    this.jdField_a_of_type_Blmc = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = blla.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，fragment = " + paramK + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected int a(LocalMediaInfo paramLocalMediaInfo)
  {
    return 0;
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
  
  protected abstract void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener);
  
  public abstract void a(ArrayList<LocalMediaInfo> paramArrayList);
  
  public abstract void a(List<LocalMediaInfo> paramList);
  
  protected abstract void a(boolean paramBoolean);
  
  abstract void a(boolean paramBoolean, Intent paramIntent);
  
  public abstract boolean a();
  
  public abstract boolean a(List<LocalMediaInfo> paramList);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
    jdField_a_of_type_Blly = null;
  }
  
  public abstract void b(float paramFloat);
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public void b(boolean paramBoolean) {}
  
  public abstract void c();
  
  public abstract void c(View paramView);
  
  public abstract void d();
  
  public abstract void d(View paramView);
  
  public abstract void e();
  
  public abstract void e(View paramView);
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  protected abstract void i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blly
 * JD-Core Version:    0.7.0.1
 */