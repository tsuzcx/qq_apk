package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class PhotoListCustomizationArk
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk";
  private String i;
  private boolean j;
  private String k;
  
  public PhotoListCustomizationArk(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.i = paramIntent.getStringExtra("key_ark_app_res_path");
    this.j = paramIntent.getBooleanExtra("key_should_compress", false);
    this.k = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void a(View paramView)
  {
    this.h.o.setClickable(false);
    if (!this.e.selectedPhotoList.isEmpty()) {
      this.h.a((String)this.e.selectedPhotoList.get(this.e.selectedPhotoList.size() - 1));
    }
    AlbumUtil.a();
    if (this.e.selectedPhotoList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoList", 2, "size == 0");
      }
      return;
    }
    this.c.getIntent();
    if (this.e.selectedPhotoList.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder(this.e.selectedPhotoList.size() * 128);
        int m = 0;
        while (m < this.e.selectedPhotoList.size())
        {
          paramView.append(String.format(Locale.CHINA, "choose image[%d],path=%s \r\n", new Object[] { Integer.valueOf(m), this.e.selectedPhotoList.get(m) }));
          m += 1;
        }
        QLog.d("PhotoListCustomizationArk", 2, paramView.toString());
      }
      this.b.u.a();
      ThreadManagerV2.executeOnSubThread(new PhotoListCustomizationArk.1(this));
    }
    else
    {
      ChooseImageIPCModule.a().a("callbackArk", null, null);
    }
    this.c.finish();
  }
  
  public Intent b(View paramView, int paramInt)
  {
    Intent localIntent = this.c.getIntent();
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", this.i);
    localIntent.putExtra("key_should_compress", this.j);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.k);
    return super.b(paramView, paramInt);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    ChooseImageIPCModule.a().a("callbackArk", null, null);
    this.c.finish();
    super.b(paramView);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    super.c(paramIntent);
  }
  
  public void e()
  {
    ChooseImageIPCModule.a().a("callbackArk", null, null);
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
  
  public void k()
  {
    super.k();
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkApp ark app res:");
      localStringBuilder.append(this.i);
      QLog.d("PhotoListCustomizationArk", 2, localStringBuilder.toString());
    }
    localNewPhotoListActivity.findViewById(2131440614).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk
 * JD-Core Version:    0.7.0.1
 */