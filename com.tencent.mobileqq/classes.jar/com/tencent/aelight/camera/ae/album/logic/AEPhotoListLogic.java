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
import com.tencent.qcircle.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class AEPhotoListLogic<K extends AEAbstractPhotoListFragment>
  implements MediaScanner.OnMediaScannerListener
{
  protected static volatile AEPhotoListLogic f;
  protected long a;
  public WeakReference<K> b;
  public PhotoCommonBaseData<OtherCommonData> c;
  public PhotoListBaseData d;
  public final AEAlbumLogicData e = new AEAlbumLogicData();
  AEPhotoListLogic.IonSelectionChangeListener g = null;
  public AEPhotoListLogic.IitemClickCallback h = null;
  public AEPhotoListLogic.IadapterCallback i = null;
  public AEPhotoListLogic.IcheckBoxCallback j = null;
  
  protected AEPhotoListLogic(K paramK)
  {
    this.b = new WeakReference(paramK);
    this.c = AEPhotoCommonDataCreator.a();
    this.c.addHoldNember();
    this.d = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic new，fragment = ");
      localStringBuilder.append(paramK);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.c);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.a = System.currentTimeMillis();
  }
  
  abstract String a(LocalMediaInfo paramLocalMediaInfo);
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListLogic close，fragment = ");
      localStringBuilder.append(this.b.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.c);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.c.releaseCommonData();
    f = null;
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
  
  public abstract boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean);
  
  protected int b(LocalMediaInfo paramLocalMediaInfo)
  {
    return 0;
  }
  
  public abstract List<LocalMediaInfo> b(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(float paramFloat);
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract void c();
  
  public abstract void c(View paramView);
  
  public void c(boolean paramBoolean) {}
  
  abstract void d();
  
  public abstract void d(View paramView);
  
  public abstract void e(View paramView);
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  protected abstract void i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic
 * JD-Core Version:    0.7.0.1
 */