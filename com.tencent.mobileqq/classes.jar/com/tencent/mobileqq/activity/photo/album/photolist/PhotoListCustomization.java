package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class PhotoListCustomization<O extends OtherCommonData>
  implements MediaScanner.OnMediaScannerListener, ISceneCallBack
{
  public PeakFragmentActivity d;
  public PhotoCommonBaseData<O> e;
  public O f;
  public PhotoListBaseData g;
  public PhotoListSceneBase h;
  
  protected PhotoListCustomization(PeakFragmentActivity paramPeakFragmentActivity)
  {
    this.d = paramPeakFragmentActivity;
    this.e = PhotoCommonBaseData.getInstance(paramPeakFragmentActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.f = this.e.bindCommonData(l());
    paramPeakFragmentActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.e.addHoldNember();
    this.g = new PhotoListBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListCustomization new，activity = ");
      localStringBuilder.append(paramPeakFragmentActivity);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.e);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.h = t();
  }
  
  public abstract Holder a(@NonNull Holder paramHolder, int paramInt);
  
  public abstract List<LocalMediaInfo> a(Object... paramVarArgs);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, int paramInt);
  
  public abstract void a(View paramView, int paramInt, CheckBox paramCheckBox);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public abstract void a(List<LocalMediaInfo> paramList, int paramInt);
  
  public void a(boolean paramBoolean) {}
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  
  public abstract boolean a(List<LocalMediaInfo> paramList);
  
  public abstract Intent b(View paramView, int paramInt);
  
  public abstract Holder b(@NonNull Holder paramHolder, int paramInt);
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract Holder c(@NonNull Holder paramHolder, int paramInt);
  
  public abstract void c(Intent paramIntent);
  
  public abstract void c(View paramView);
  
  public abstract void c(View paramView, int paramInt);
  
  public abstract void d(View paramView, int paramInt);
  
  public abstract void e();
  
  public abstract void e(Intent paramIntent);
  
  public abstract void f(Intent paramIntent);
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract AbstractAlbumListFragment j();
  
  public abstract void k();
  
  protected OtherCommonData l()
  {
    return new PhotoListCustomization.1(this);
  }
  
  public PhotoListSceneBase t()
  {
    return new PhotoListSceneBase(this);
  }
  
  public void u()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListCustomization close，activity = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.e);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.e.releaseCommonData();
  }
  
  public abstract void v();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization
 * JD-Core Version:    0.7.0.1
 */