package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PhotoCropActivity$LoadBitmapTask
  extends AsyncTask<Void, Void, Bitmap>
{
  private int jdField_a_of_type_Int;
  
  private PhotoCropActivity$LoadBitmapTask(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean) {
        paramVarArgs = Bitmap.Config.ARGB_8888;
      } else {
        paramVarArgs = Bitmap.Config.RGB_565;
      }
      ((BitmapFactory.Options)localObject).inPreferredConfig = paramVarArgs;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).calculateInSampleSize((BitmapFactory.Options)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.g, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.g);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramVarArgs = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramVarArgs = ((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      this.jdField_a_of_type_Int = 2;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LoadBitmapTask err ");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("PhotoCropActivity", 1, ((StringBuilder)localObject).toString());
      return null;
      this.jdField_a_of_type_Int = 1;
      return null;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label163:
      break label163;
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    PhotoCropActivity localPhotoCropActivity;
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.d);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageBitmap(paramBitmap);
      paramBitmap = new ViewGroup.LayoutParams(-1, -1);
      localPhotoCropActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity;
      localPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(localPhotoCropActivity, localPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 250L);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.d);
        paramBitmap = new ViewGroup.LayoutParams(-1, -1);
        localPhotoCropActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity;
        localPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(localPhotoCropActivity, localPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 1) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, HardCodeUtil.a(2131708067), 0).a();
      } else if (i == 2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, HardCodeUtil.a(2131708068), 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, HardCodeUtil.a(2131708066), 0).a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.LoadBitmapTask
 * JD-Core Version:    0.7.0.1
 */