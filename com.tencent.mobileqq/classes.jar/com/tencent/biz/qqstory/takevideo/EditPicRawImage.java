package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bhmq;
import blhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import yuk;
import yuq;
import yuy;
import yxr;
import yxt;
import yze;
import zih;

public class EditPicRawImage
  extends yxr
  implements Handler.Callback, View.OnLayoutChangeListener, View.OnTouchListener, Runnable
{
  public static final String[] a;
  public static boolean b;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  float b;
  
  static
  {
    int i = 0;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MIX 2S", "Redmi Note 5" };
    String str1 = Build.MODEL;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (str1.equalsIgnoreCase(str2))
      {
        jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditVideoRawImage", 2, "IS_HEIGHT_PIXEL_CHANGE:" + str2);
        }
      }
      i += 1;
    }
  }
  
  public EditPicRawImage(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (i > paramInt1))
    {
      k /= 2;
      int m = i / 2;
      i = 2;
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    super.a();
    ThreadManager.post(this, 8, null, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376088));
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.addOnLayoutChangeListener(this);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    paramzih.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == this.jdField_a_of_type_AndroidGraphicsBitmap) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidWidgetImageView.refreshDrawableState();
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
      }
    } while (paramBoolean);
    f();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Blhq.removeMessages(999);
    this.jdField_a_of_type_AndroidWidgetImageView.removeOnLayoutChangeListener(this);
  }
  
  void f()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject2 = this.jdField_a_of_type_Yze.getActivity().getResources().getDisplayMetrics();
    int k = ((DisplayMetrics)localObject2).widthPixels;
    int j = ((DisplayMetrics)localObject2).heightPixels;
    int i = j;
    if (jdField_b_of_type_Boolean)
    {
      i = j;
      if (this.jdField_a_of_type_Int != 0) {
        i = this.jdField_a_of_type_Int;
      }
    }
    j = ((Bitmap)localObject1).getWidth();
    int m = ((Bitmap)localObject1).getHeight();
    float f1 = i / k;
    float f2;
    float f3;
    if (m / j > f1)
    {
      f2 = i;
      f1 = i / m;
      f3 = j * f1 + 0.5F;
    }
    for (;;)
    {
      localObject1 = new RectF(0.0F, 0.0F, f3, f2);
      yuk.c("EditPicActivity.EditVideoRawImage", "getDisplayBounds " + localObject1 + " scale " + f1 + " old scale " + f4);
      localObject2 = (yuy)a(yuy.class);
      if (localObject2 != null) {}
      try
      {
        ((yuy)localObject2).a((int)((RectF)localObject1).width(), (int)((RectF)localObject1).height());
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity.EditVideoRawImage", 2, "resizeDoodleView width:" + ((RectF)localObject1).width() + " height:" + ((RectF)localObject1).height());
        }
        return;
      }
      catch (Exception localException) {}
      f3 = k;
      f1 = k / j;
      f2 = m * f1 + 0.5F;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Yze.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 998)
        {
          QQToast.a(this.jdField_a_of_type_Yze.getActivity().getApplicationContext(), this.jdField_a_of_type_Yze.getActivity().getResources().getString(2131718772), 0).a();
          this.jdField_a_of_type_Yze.a(0, null, 2130772029, 0);
          return false;
        }
      } while (paramMessage.what != 999);
      paramMessage = (Bitmap)paramMessage.obj;
      if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
        a(paramMessage, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Yxt.u();
        if ((!(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 103) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 11)) {
          break;
        }
        this.jdField_a_of_type_Yxt.a(Message.obtain(null, 2, 1, 0));
        return false;
        a(paramMessage, false);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Yxt.a(Message.obtain(null, 2, 2, 0));
    return false;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditPicActivity.EditVideoRawImage", 1, "onLayoutChange, height pixel change" + paramInt1 + " " + paramInt2 + " " + paramInt3 + " " + paramInt4 + " " + paramInt5 + " " + paramInt6 + " " + paramInt7 + " " + paramInt8 + " ");
      }
      if (paramInt8 != paramInt4) {
        this.jdField_a_of_type_Int = (paramInt4 - paramInt2);
      }
    }
    try
    {
      f();
      return;
    }
    catch (Throwable paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditPicActivity.EditVideoRawImage", 1, "onLayoutChange, resizeDoodleView Throwable" + paramView.getMessage());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.jdField_b_of_type_Float) < 10.0F) && (this.jdField_a_of_type_Yxt.b != 12)) {
        if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2)
        {
          this.jdField_a_of_type_Yxt.a(5);
          yuq.b("0X80075D7");
        }
        else if (this.jdField_a_of_type_Yxt.b == 0)
        {
          this.jdField_a_of_type_Yxt.a(27);
        }
        else if (this.jdField_a_of_type_Yxt.b == 27)
        {
          this.jdField_a_of_type_Yxt.a(0);
        }
      }
    }
  }
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1);
    if ((((BitmapFactory.Options)localObject1).outWidth < 64) || (((BitmapFactory.Options)localObject1).outHeight < 64))
    {
      QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
      this.jdField_a_of_type_Blhq.sendEmptyMessage(998);
      return;
    }
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Yze.getActivity().getResources().getDisplayMetrics();
    int i = a((BitmapFactory.Options)localObject1, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = i;
    try
    {
      localObject1 = bhmq.a((String)localObject2, (BitmapFactory.Options)localObject1);
      if (localObject1 == null)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + null);
        this.jdField_a_of_type_Yze.a(0, null, 2130772029, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decodeoom");
        localBitmap = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      }
      i = bhmq.b((String)localObject2);
      localObject2 = localBitmap;
      if (i != 0)
      {
        localObject2 = localBitmap;
        if (i % 90 == 0)
        {
          if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
            this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b = i;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + i);
          }
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          localObject2 = new Matrix();
          ((Matrix)localObject2).postRotate(i, j / 2.0F, k / 2.0F);
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, j, k, (Matrix)localObject2, true);
        }
      }
      this.jdField_a_of_type_Blhq.obtainMessage(999, localObject2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */