package com.tencent.aelight.camera.ae.album.logic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class AEPhotoListLogic<K extends AEAbstractPhotoListFragment>
  implements MediaScanner.OnMediaScannerListener
{
  protected static volatile AEPhotoListLogic a;
  protected long a;
  public final AEAlbumLogicData a;
  public AEPhotoListLogic.IadapterCallback a;
  public AEPhotoListLogic.IcheckBoxCallback a;
  public AEPhotoListLogic.IitemClickCallback a;
  AEPhotoListLogic.IonSelectionChangeListener a;
  public PhotoCommonBaseData<OtherCommonData> a;
  public PhotoListBaseData a;
  public WeakReference<K> a;
  
  protected AEPhotoListLogic(K paramK)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData = new AEAlbumLogicData();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IonSelectionChangeListener = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IitemClickCallback = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IadapterCallback = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic$IcheckBoxCallback = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic new，fragment = ");
      localStringBuilder.append(paramK);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected int a(LocalMediaInfo paramLocalMediaInfo)
  {
    return 0;
  }
  
  abstract String a(LocalMediaInfo paramLocalMediaInfo);
  
  public abstract List<LocalMediaInfo> a(boolean paramBoolean);
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic close，fragment = ");
      localStringBuilder.append(this.jdField_a_of_type_MqqUtilWeakReference.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
    jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic = null;
  }
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  protected abstract void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener);
  
  public abstract void a(ArrayList<LocalMediaInfo> paramArrayList, boolean paramBoolean);
  
  public abstract void a(List<LocalMediaInfo> paramList);
  
  protected abstract void a(boolean paramBoolean);
  
  abstract void a(boolean paramBoolean, Intent paramIntent);
  
  public abstract boolean a();
  
  public abstract boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(float paramFloat);
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public void b(boolean paramBoolean) {}
  
  public abstract void c();
  
  public abstract void c(View paramView);
  
  abstract void d();
  
  public abstract void d(View paramView);
  
  public abstract void e();
  
  public abstract void e(View paramView);
  
  public abstract void f();
  
  public abstract void g();
  
  protected abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic
 * JD-Core Version:    0.7.0.1
 */