package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhotoPreviewCustomizationScanEntry
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationScanEntry";
  
  protected PhotoPreviewCustomizationScanEntry(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    if (this.d.y.size() > 1)
    {
      TextView localTextView = s().p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.G + 1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(this.d.y.size());
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    s().p.setText(this.c.getResources().getString(2131892721));
  }
  
  public void a(Intent paramIntent)
  {
    int i = this.c.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 != null) {
      localArrayList2.addAll(localArrayList1);
    }
    super.a(paramIntent);
    this.d.y.clear();
    this.d.y = localArrayList2;
    this.d.D = this.d.y.size();
    this.d.G = i;
    if (this.d.G >= this.d.D) {
      this.d.G = -1;
    }
    this.f.selectedIndex.clear();
    this.f.selectedIndex.add(Integer.valueOf(this.d.G));
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.f.selectedPhotoList == null) {
      this.f.selectedPhotoList = new ArrayList();
    } else {
      this.f.selectedPhotoList.clear();
    }
    if ((paramIntent != null) && (!paramIntent.equals(""))) {
      this.f.selectedPhotoList.add(paramIntent);
    }
    QLog.d("PhotoPreviewCustomizationScanEntry", 1, new Object[] { "count=", Integer.valueOf(this.d.D), " pos=", Integer.valueOf(this.d.G) });
    paramIntent = this.i.a();
    this.i.notifyImageListChanged(paramIntent, this.d.G);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationScanEntry
 * JD-Core Version:    0.7.0.1
 */