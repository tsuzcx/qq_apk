package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask.Status;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import azri;
import bayu;
import bdhj;
import bhtd;
import bjua;
import bjvw;
import bkas;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.FastAnimationDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import wxe;
import wxk;
import wxs;
import wxu;
import wyz;
import xal;
import xan;
import xby;
import xlb;

public class EditGifImage
  extends xal
  implements Handler.Callback, View.OnTouchListener, bkas, Runnable
{
  public static final int a;
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public bhtd a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public FastAnimationDrawable a;
  wxu jdField_a_of_type_Wxu;
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  FastAnimationDrawable jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable;
  public boolean b;
  boolean c = false;
  public boolean d = false;
  public boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h;
  boolean i;
  boolean j;
  
  static
  {
    jdField_a_of_type_Int = bjvw.e;
  }
  
  public EditGifImage(@NonNull xan paramxan)
  {
    super(paramxan);
    this.jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int n = paramOptions.outHeight;
    int i1 = paramOptions.outWidth;
    int m = 1;
    if ((n > paramInt2) || (i1 > paramInt1))
    {
      int k = 2;
      for (;;)
      {
        if (n / k <= paramInt2)
        {
          m = k;
          if (i1 / k <= paramInt1) {
            break;
          }
        }
        k *= 2;
      }
    }
    return m;
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("module_name", paramString1);
      localHashMap.put("module_status", paramString2);
      if (paramString2.equals("exposeAntishake")) {
        localHashMap.put("module_exposeTime", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      }
      if ((this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) && (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a != null)) {
        localHashMap.put("module_frameNum", this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a.size() + "");
      }
      localHashMap.put("module_exposeStatus", this.j + "");
      localHashMap.put("module_showStatus", this.h + "");
      localHashMap.put("module_resetStatus", this.i + "");
      azri.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifAntishakeModule", true, 0L, 0L, localHashMap, null);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + paramString1.getMessage());
    }
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b = paramArrayList;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if (this.f)
        {
          String str1 = "0";
          localHashMap.put("module_clickToPublish", str1);
          if (this.f)
          {
            str1 = "module_clickToPublishPhotoFrameNum";
            localHashMap.put(str1, this.jdField_b_of_type_Int + "");
            azri.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "GifChooser", true, 0L, 0L, localHashMap, null);
            return;
          }
          str1 = "module_clickToPublishVideoFrameNum";
          continue;
        }
        String str2 = "1";
      }
      catch (Exception localException)
      {
        QLog.e("EditPicActivity.EditGifImage", 1, "reportToBeacon failed " + localException.getMessage());
        return;
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.d))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
        localURLDrawableOptions.mLoadingDrawable = bayu.a;
        localURLDrawableOptions.mFailedDrawable = bayu.a;
        localURLDrawableOptions.mPlayGifImage = true;
        this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Xby.getActivity().getApplicationContext(), localEditLocalGifSource.b, localEditLocalGifSource.jdField_a_of_type_Long, this);
        localEditLocalGifSource.jdField_a_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_Bhtd.post(new EditGifImage.2(this));
    }
  }
  
  private void i()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.d))
    {
      if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable == null)
      {
        EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
        localURLDrawableOptions.mLoadingDrawable = bayu.a;
        localURLDrawableOptions.mFailedDrawable = bayu.a;
        localURLDrawableOptions.mPlayGifImage = true;
        this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Xby.getActivity().getApplicationContext(), localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList, localEditLocalGifSource.jdField_a_of_type_Long, this);
        localEditLocalGifSource.jdField_a_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_Bhtd.post(new EditGifImage.3(this));
    }
  }
  
  public RectF a(Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject).getValues(arrayOfFloat);
    float f4 = arrayOfFloat[0];
    localObject = this.jdField_a_of_type_Xby.getActivity().getResources().getDisplayMetrics();
    int k = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    float f1 = m / k;
    float f2;
    float f3;
    if (i1 / n > f1)
    {
      f2 = m;
      f1 = m / i1;
      f3 = n * f1 + 0.5F;
    }
    for (;;)
    {
      paramBitmap = new RectF(0.0F, 0.0F, f3, f2);
      wxe.c("EditPicActivity.EditGifImage", "getDisplayBounds " + paramBitmap + " scale " + f1 + " old scale " + f4);
      return paramBitmap;
      f3 = k;
      f1 = k / n;
      f2 = i1 * f1 + 0.5F;
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)a(2131367198));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ThreadManager.post(this, 8, null, false);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 11)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public void a(LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    if (!this.g)
    {
      this.g = true;
      if (this.c) {
        break label36;
      }
      ThreadManager.post(new EditGifImage.1(this, paramLruCache), 8, null, false);
    }
    label36:
    do
    {
      return;
      localArrayList = ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList;
    } while ((paramLruCache == null) || (paramLruCache.size() != localArrayList.size()));
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < paramLruCache.size())
    {
      if (paramLruCache.get(Integer.valueOf(k)) != null) {
        localArrayList.add(((BitmapDrawable)paramLruCache.get(Integer.valueOf(k))).getBitmap());
      }
      k += 1;
    }
    this.jdField_a_of_type_Wxu = new wxu(this);
    this.jdField_a_of_type_Wxu.execute(new ArrayList[] { localArrayList });
  }
  
  public void a(@NonNull xlb paramxlb)
  {
    paramxlb.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    a("PublishBtn", this.d + "");
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
    }
  }
  
  public void ac_()
  {
    super.ac_();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditGifImage", 2, "EditGifImage onDestroy");
    }
    this.jdField_a_of_type_Bhtd.removeMessages(999);
    if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
    if (this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
    {
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = null;
    }
    if ((this.jdField_a_of_type_Wxu != null) && (this.jdField_a_of_type_Wxu.getStatus() == AsyncTask.Status.RUNNING))
    {
      this.jdField_a_of_type_Wxu.cancel(false);
      this.jdField_a_of_type_Wxu = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Xby.getActivity().isFinishing()) {
      QLog.e("EditPicActivity.EditGifImage", 1, "handleMessage isFinishing" + paramMessage.what);
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            return false;
            if (paramMessage.what == 998)
            {
              QQToast.a(this.jdField_a_of_type_Xby.getActivity().getApplicationContext(), this.jdField_a_of_type_Xby.getActivity().getResources().getString(2131720898), 0).a();
              this.jdField_a_of_type_Xby.a(0, null, 2130772028, 0);
              return false;
            }
            if (paramMessage.what != 999) {
              break;
            }
            AbstractGifImage.resumeAll();
            paramMessage = a((Bitmap)paramMessage.obj);
            localObject = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject).height = ((int)paramMessage.bottom);
            ((ViewGroup.LayoutParams)localObject).width = ((int)paramMessage.right);
            this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            if (this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null)
            {
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height);
              this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
            }
            localObject = (wxs)a(wxs.class);
          } while (localObject == null);
          ((wxs)localObject).a((int)paramMessage.width(), (int)paramMessage.height());
          return false;
          if (paramMessage.what != 995) {
            break;
          }
          this.e = false;
          i();
        } while (this.i);
        a("AutoOptimizationBtn", "resetAntishake");
        this.i = true;
        return false;
        if (paramMessage.what != 994) {
          break;
        }
        this.e = true;
        g();
      } while (this.h);
      a("AutoOptimizationBtn", "showAntishake");
      this.h = true;
      return false;
      if (paramMessage.what == 997)
      {
        this.jdField_a_of_type_Xan.jdField_a_of_type_Wyz.a(false, false);
        return false;
      }
    } while (paramMessage.what != 996);
    this.jdField_a_of_type_Xan.jdField_a_of_type_Wyz.a(true, false);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a("AutoOptimizationBtn", "exposeAntishake");
    this.j = true;
    return false;
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
      if ((Math.abs(f1 - this.jdField_a_of_type_Float) < 10.0F) && (Math.abs(f2 - this.jdField_b_of_type_Float) < 10.0F)) {
        if (this.jdField_a_of_type_Xan.jdField_b_of_type_Int != 21)
        {
          if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 2)
          {
            this.jdField_a_of_type_Xan.a(5);
            wxk.b("0X80075D7");
          }
          else if (this.jdField_a_of_type_Xan.jdField_b_of_type_Int == 0)
          {
            this.jdField_a_of_type_Xan.a(27);
          }
          else if (this.jdField_a_of_type_Xan.jdField_b_of_type_Int == 27)
          {
            this.jdField_a_of_type_Xan.a(0);
          }
        }
        else {
          this.jdField_a_of_type_Xan.a(0);
        }
      }
    }
  }
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((((BitmapFactory.Options)localObject2).outWidth < jdField_a_of_type_Int) || (((BitmapFactory.Options)localObject2).outHeight < jdField_a_of_type_Int))
      {
        QLog.e("EditPicActivity.EditGifImage", 1, "bitmapPath:" + (String)localObject1 + " too small width:" + ((BitmapFactory.Options)localObject2).outWidth + " height:" + ((BitmapFactory.Options)localObject2).outHeight);
        this.jdField_a_of_type_Bhtd.sendEmptyMessage(998);
        return;
        if (((this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) && (((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList != null) && (((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          this.jdField_a_of_type_Boolean = true;
          localObject1 = ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList;
          this.f = bjua.a().a((ArrayList)localObject1);
          this.jdField_b_of_type_Int = ((ArrayList)localObject1).size();
          if ((((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Boolean) && (((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b != null) && (((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b.size() > 1))
          {
            this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Xby.getActivity().getApplicationContext(), ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b, ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long, this);
            this.jdField_b_of_type_Boolean = true;
            this.d = true;
            label472:
            switch (((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int)
            {
            }
          }
          for (;;)
          {
            localObject1 = (String)((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList.get(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
            break;
            this.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = new FastAnimationDrawable(this.jdField_a_of_type_Xby.getActivity().getApplicationContext(), ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_JavaUtilArrayList, ((EditLocalGifSource)this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long, this);
            this.jdField_b_of_type_Boolean = false;
            this.d = false;
            break label472;
            this.c = true;
            this.jdField_a_of_type_Bhtd.obtainMessage(996).sendToTarget();
            continue;
            this.g = true;
            this.c = false;
            this.jdField_a_of_type_Bhtd.sendEmptyMessage(997);
            if (QLog.isColorLevel()) {
              QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
            }
          }
        }
      }
      else
      {
        Object localObject3 = this.jdField_a_of_type_Xby.getActivity().getResources().getDisplayMetrics();
        int k = a((BitmapFactory.Options)localObject2, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = k;
        try
        {
          localObject2 = bdhj.a((String)localObject1, (BitmapFactory.Options)localObject2);
          if (localObject2 == null)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decode" + null);
            this.jdField_a_of_type_Xby.a(0, null, 2130772028, 0);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Bitmap localBitmap;
          for (;;)
          {
            QLog.e("EditPicActivity.EditGifImage", 1, "decodeoom");
            localBitmap = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditGifImage", 2, "sampleSize" + k + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
          }
          localObject3 = localBitmap;
          if (localObject1 != null)
          {
            k = bdhj.b((String)localObject1);
            localObject3 = localBitmap;
            if (k != 0)
            {
              localObject3 = localBitmap;
              if (k % 90 == 0)
              {
                if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
                  this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_Int = k;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("EditPicActivity.EditGifImage", 2, "has exif rotate" + k);
                }
                int m = localBitmap.getWidth();
                int n = localBitmap.getHeight();
                localObject1 = new Matrix();
                ((Matrix)localObject1).postRotate(k, m / 2.0F, n / 2.0F);
                localObject3 = Bitmap.createBitmap(localBitmap, 0, 0, m, n, (Matrix)localObject1, true);
              }
            }
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject3);
          this.jdField_a_of_type_Bhtd.obtainMessage(999, localObject3).sendToTarget();
          return;
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage
 * JD-Core Version:    0.7.0.1
 */