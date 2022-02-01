package com.tencent.aelight.camera.aebase;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.aelight.camera.util.api.IAEEditorJumpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewLogicAECircle
  extends PhotoPreviewCustomizationBase
{
  public static final String a = "com.tencent.aelight.camera.aebase.PhotoPreviewLogicAECircle";
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, 2131756189);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(this.jdField_b_of_type_JavaLangString)))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, HardCodeUtil.a(2131689733), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(this.jdField_b_of_type_JavaLangString);
    }
    ((IAEEditorJumpUtil)QRoute.api(IAEEditorJumpUtil.class)).picChooseJump(this.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
    b(false);
  }
  
  public void a()
  {
    super.a();
    a().c.setVisibility(8);
    a().a.setOnClickListener(new PhotoPreviewLogicAECircle.1(this));
  }
  
  public void a(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a().getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
    {
      if (localRichMediaBrowserInfo.baseData.getType() == 100)
      {
        str = ((PreviewPictureData)localRichMediaBrowserInfo.baseData).filePath;
        break label81;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 101)
      {
        str = ((PreviewVideoData)localRichMediaBrowserInfo.baseData).filePath;
        break label81;
      }
    }
    String str = null;
    label81:
    this.jdField_b_of_type_JavaLangString = str;
    int i;
    if (localRichMediaBrowserInfo.baseData.getType() == 100) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      a().c.setVisibility(8);
    } else {
      a().c.setVisibility(0);
    }
    super.a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("choosed_num", 0);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", 0);
  }
  
  public void a(View paramView)
  {
    int i = a().a();
    String str;
    if (i != -1) {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.get(i);
    } else {
      str = "";
    }
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(str);
    int j = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(i)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int == 9)
      {
        paramView = BaseApplicationImpl.sApplication.getResources().getString(2131689734, new Object[] { Integer.valueOf(9 - this.jdField_b_of_type_Int) });
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, paramView, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if (a(localLocalMediaInfo))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, HardCodeUtil.a(2131689733), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if ((j == 1) && (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int != 0)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, HardCodeUtil.a(2131689735), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimensionPixelSize(2131299168));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.remove(str);
    }
    super.a(paramView);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
  }
  
  public void b()
  {
    a().a.setClickable(true);
    a().a.setBackgroundResource(2130837911);
    super.b();
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PhotoPreviewLogicAECircle
 * JD-Core Version:    0.7.0.1
 */