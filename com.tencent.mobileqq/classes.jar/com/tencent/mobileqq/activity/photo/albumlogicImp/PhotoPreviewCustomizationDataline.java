package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;

public class PhotoPreviewCustomizationDataline
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationDataline";
  
  protected PhotoPreviewCustomizationDataline(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
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
      return;
    }
    if (this.d.g) {
      s().g.setVisibility(0);
    } else {
      s().g.setVisibility(8);
    }
    if (this.d.f)
    {
      s().j.setVisibility(0);
      s().k.setVisibility(0);
    }
    else
    {
      s().j.setVisibility(8);
      s().k.setVisibility(8);
    }
    if ((this.d.l) || (this.f.isSingleMode))
    {
      s().j.setVisibility(8);
      s().k.setVisibility(8);
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationDataline
 * JD-Core Version:    0.7.0.1
 */