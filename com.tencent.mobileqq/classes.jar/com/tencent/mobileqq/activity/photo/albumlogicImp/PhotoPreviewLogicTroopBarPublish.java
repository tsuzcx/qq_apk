package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class PhotoPreviewLogicTroopBarPublish
  extends PhotoPreviewLogicDefault
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  PhotoPreviewLogicTroopBarPublish(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      SlideShowUtils.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setClickable(true);
      return;
    }
    super.d();
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("from_tribe_slideshow", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("from_tribe_class_name");
    ((PhotoOtherData)this.mOtherCommonData).a(this.jdField_a_of_type_Boolean, this.mPhotoCommonData);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10012)
    {
      if ((paramInt2 == -1) && (this.jdField_a_of_type_Boolean))
      {
        ((NewPhotoPreviewActivity)this.mActivity).setResult(paramInt2, paramIntent);
        ((NewPhotoPreviewActivity)this.mActivity).finish();
      }
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Boolean);
        paramIntent = paramIntent.getStringExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      } while (TextUtils.isEmpty(paramIntent));
      FileUtils.a(new File(paramIntent).getParent());
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    super.onMagicStickClick(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (!TroopBarPublishActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
        break label60;
      }
      TribeUtils.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
    }
    label60:
    while (!TroopBarReplyActivity.class.getSimpleName().equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    TribeUtils.a("reply", "clk_photo_edit", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicTroopBarPublish
 * JD-Core Version:    0.7.0.1
 */