package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.emoticonview.EmotionPreviewFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhotoListCustomizationEmotion
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationEmotion";
  
  protected PhotoListCustomizationEmotion(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.e.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NewPhotoListActivity] [onActivityResult] selectedPhotoList = ");
      localStringBuilder.append(localArrayList.size());
      QLog.d("QQAlbum", 4, localStringBuilder.toString());
    }
    if ((paramInt2 == -1) && (paramInt1 == 10015))
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.e.customSendBtnText = this.c.getString(2131892590);
  }
  
  public void b(Intent paramIntent)
  {
    ReportController.b(null, "CliOper", "", "", "0X800A6D9", "0X800A6D9", 0, 0, "", "", "", "");
    this.c.startActivityForResult(paramIntent, 10015);
  }
  
  public void b(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A6E0", "0X800A6E0", 0, 0, "", "", "", "");
    super.b(paramView);
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.e.maxSelectNum;
    return this.c.getString(2131892552, new Object[] { Integer.valueOf(i) });
  }
  
  protected void c()
  {
    int i;
    if (this.e.selectedPhotoList != null) {
      i = this.e.selectedPhotoList.size();
    } else {
      i = 0;
    }
    ReportController.b(null, "CliOper", "", "", "0X800A6D8", "0X800A6D8", 0, 0, String.valueOf(i), "", "", "");
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    this.c.setResult(-1, localIntent);
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
  
  public void c(Intent paramIntent)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A6DF", "0X800A6DF", 0, 0, "", "", "", "");
    super.c(paramIntent);
  }
  
  public void c(View paramView)
  {
    EmotionPreviewFragment.enterEmotionPreview(this.c, this.c.getIntent(), this.e.selectedPhotoList);
    ReportController.b(null, "dc00898", "", "", "0X800A6DC", "0X800A6DC", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationEmotion
 * JD-Core Version:    0.7.0.1
 */