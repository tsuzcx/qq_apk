package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

public class PhotoPreviewCustomizationFileAssistant
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant";
  
  public PhotoPreviewCustomizationFileAssistant(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (s().getItem(paramInt).baseData.getType() == 101)
    {
      s().g.setVisibility(8);
      s().j.setVisibility(8);
      s().k.setVisibility(8);
      s().h.setVisibility(8);
      s().i.setVisibility(8);
      return;
    }
    if (this.d.g) {
      s().g.setVisibility(0);
    } else {
      s().g.setVisibility(8);
    }
    s().j.setVisibility(8);
    s().k.setVisibility(8);
    s().h.setVisibility(8);
    s().i.setVisibility(8);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null)
    {
      paramBundle.putBoolean("key_multi_edit_pic", true);
      paramBundle.putBoolean("key_enable_edit_title_bar", true);
    }
    super.a(paramView, 10000, paramBundle, paramInt2, paramIntent);
  }
  
  public boolean g()
  {
    return (this.f.selectedPhotoList != null) && (!this.f.selectedPhotoList.isEmpty());
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "sendPicAndVideoToFileAssistant...");
    }
    if (this.c != null)
    {
      if (this.c.isFinishing()) {
        return;
      }
      Intent localIntent;
      if (this.c.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {
        localIntent = (Intent)this.c.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
      } else {
        localIntent = this.c.getIntent();
      }
      localIntent.setExtrasClassLoader(PeakConstants.class.getClassLoader());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", s().l());
      this.c.setResult(-1, localIntent);
      this.c.finish();
      AlbumUtil.anim(this.c, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant
 * JD-Core Version:    0.7.0.1
 */