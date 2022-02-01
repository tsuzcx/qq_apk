package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class PhotoPreviewCustomizationAEPlay
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay";
  
  PhotoPreviewCustomizationAEPlay(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.d.C >= 700L)
    {
      this.d.C = l;
      QQToast.makeText(this.c, paramString, 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private boolean d()
  {
    return this.f.selectedPhotoList.size() < this.f.maxSelectNum;
  }
  
  public void a()
  {
    super.a();
    s().l.setOnClickListener(new PhotoPreviewCustomizationAEPlay.1(this));
  }
  
  public void a(View paramView)
  {
    if ((!this.f.selectedIndex.contains(Integer.valueOf(s().m()))) && (this.f.selectedPhotoList.size() >= this.f.maxSelectNum))
    {
      a(String.format(this.c.getString(2131886357), new Object[] { Integer.valueOf(this.f.maxSelectNum) }));
      return;
    }
    super.a(paramView);
  }
  
  public void b()
  {
    super.b();
    String str = this.c.getString(2131914046);
    int i = this.f.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.f.maxSelectNum);
    str = localStringBuilder.toString();
    s().l.setText(str);
    s().l.setEnabled(true);
    if (d())
    {
      s().l.setBackgroundResource(2130851880);
      return;
    }
    s().l.setBackgroundResource(2130837935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay
 * JD-Core Version:    0.7.0.1
 */