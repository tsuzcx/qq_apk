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
  private int b;
  
  private PhotoCropActivity$LoadBitmapTask(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      if (this.a.w) {
        paramVarArgs = Bitmap.Config.ARGB_8888;
      } else {
        paramVarArgs = Bitmap.Config.RGB_565;
      }
      ((BitmapFactory.Options)localObject).inPreferredConfig = paramVarArgs;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ImageUtil.a(this.a.o, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).calculateInSampleSize((BitmapFactory.Options)localObject, this.a.u, this.a.u);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramVarArgs = ImageUtil.a(this.a.o, (BitmapFactory.Options)localObject);
      paramVarArgs = ((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(this.a.o, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      this.b = 2;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LoadBitmapTask err ");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("PhotoCropActivity", 1, ((StringBuilder)localObject).toString());
      return null;
      this.b = 1;
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
      this.a.c.setRestrict(this.a.q, this.a.r);
      this.a.c.setImageBitmap(paramBitmap);
      paramBitmap = new ViewGroup.LayoutParams(-1, -1);
      localPhotoCropActivity = this.a;
      localPhotoCropActivity.d = new RegionView(localPhotoCropActivity, localPhotoCropActivity.c, this.a.s, this.a.t, this.a.v, this.a.w);
      this.a.b.removeAllViews();
      this.a.b.addView(this.a.c, paramBitmap);
      this.a.b.addView(this.a.d, paramBitmap);
      if (this.a.D != null) {
        this.a.D.sendEmptyMessageDelayed(1000, 250L);
      }
    }
    else
    {
      if (this.a.getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        this.a.c.setRestrict(this.a.q, this.a.r);
        paramBitmap = new ViewGroup.LayoutParams(-1, -1);
        localPhotoCropActivity = this.a;
        localPhotoCropActivity.d = new RegionView(localPhotoCropActivity, localPhotoCropActivity.c, this.a.s, this.a.t, this.a.v, this.a.w);
        this.a.b.removeAllViews();
        this.a.b.addView(this.a.c, paramBitmap);
        this.a.b.addView(this.a.d, paramBitmap);
        this.a.e.setEnabled(false);
        return;
      }
      int i = this.b;
      if (i == 1) {
        QQToast.makeText(this.a, HardCodeUtil.a(2131905866), 0).show();
      } else if (i == 2) {
        QQToast.makeText(this.a, HardCodeUtil.a(2131905867), 0).show();
      } else {
        QQToast.makeText(this.a, HardCodeUtil.a(2131905865), 0).show();
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.LoadBitmapTask
 * JD-Core Version:    0.7.0.1
 */