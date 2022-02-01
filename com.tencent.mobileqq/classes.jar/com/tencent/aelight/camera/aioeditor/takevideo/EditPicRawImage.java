package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.MosaicOperator;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class EditPicRawImage
  extends EditVideoPart
  implements Handler.Callback, View.OnLayoutChangeListener, Runnable
{
  public static int f;
  ImageView a;
  Bitmap b;
  WeakReferenceHandler c = new WeakReferenceHandler(Looper.getMainLooper(), this);
  boolean d = false;
  boolean e = false;
  private int g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n = 1.0F;
  private float o = 3.0F;
  private final RectF p = new RectF();
  private final Matrix q = new Matrix();
  private final Matrix r = new Matrix();
  private final float[] s = new float[9];
  private final RectF x = new RectF();
  
  public EditPicRawImage(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.g = paramInt;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = paramOptions.outHeight;
    int i2 = paramOptions.outWidth;
    int i1 = paramInt2;
    if (i3 > i2 * 6) {
      i1 = paramInt2 * 3;
    }
    paramInt2 = paramInt1;
    if (i2 > i3 * 6) {
      paramInt2 = paramInt1 * 3;
    }
    if ((i3 <= i1 * 1.2F) && (i2 <= paramInt2 * 1.2F)) {
      return 1;
    }
    paramInt1 = 2;
    i3 /= 2;
    i2 /= 2;
    for (;;)
    {
      if ((i3 / paramInt1 <= i1) && (i2 / paramInt1 <= paramInt2)) {
        return paramInt1;
      }
      paramInt1 *= 2;
    }
  }
  
  private void a(Matrix paramMatrix, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RectF localRectF = this.x;
      float f1 = this.j;
      float f2 = this.k;
      float f3 = 0.0F;
      localRectF.set(0.0F, 0.0F, f1, f2);
      paramMatrix.mapRect(this.x);
      if (this.x.left > this.p.left) {
        f2 = this.p.left;
      }
      for (f1 = this.x.left;; f1 = this.x.right)
      {
        f1 = f2 - f1;
        break label126;
        if (this.x.right >= this.p.right) {
          break;
        }
        f2 = this.p.right;
      }
      f1 = 0.0F;
      label126:
      if (this.x.top > this.p.top) {
        f2 = this.p.top;
      }
      for (f3 = this.x.top;; f3 = this.x.bottom)
      {
        f2 -= f3;
        break;
        f2 = f3;
        if (this.x.bottom >= this.p.bottom) {
          break;
        }
        f2 = this.p.bottom;
      }
      paramMatrix.postTranslate(f1, f2);
    }
    this.a.setImageMatrix(paramMatrix);
    this.a.invalidate();
    this.q.invert(this.r);
    this.r.postConcat(this.a.getImageMatrix());
    if (this.t.O != null) {
      this.t.O.a(this.r);
    }
  }
  
  private void i()
  {
    if (this.a.getWidth() > 0)
    {
      if (this.a.getHeight() <= 0) {
        return;
      }
      Object localObject = this.a.getDrawable();
      if (localObject == null)
      {
        AEQLog.a("EditPicActivity.EditVideoRawImage", "image view with no drawable");
        return;
      }
      this.j = ((Drawable)localObject).getIntrinsicWidth();
      this.k = ((Drawable)localObject).getIntrinsicHeight();
      if ((this.j > 0.0F) && (this.k > 0.0F))
      {
        this.h = this.a.getWidth();
        this.i = this.a.getHeight();
        float f1 = this.h;
        float f2 = this.j;
        float f3 = f1 / f2;
        float f4 = this.i;
        float f5 = this.k;
        if (f3 >= f4 / f5)
        {
          this.n = (f4 / f5);
          f1 = (f1 - f2 * this.n) / 2.0F;
          f2 = 0.0F;
        }
        else
        {
          this.n = (f1 / f2);
          f2 = (f4 - f5 * this.n) / 2.0F;
          f1 = 0.0F;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bitmap width = ");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append("bitmap height = ");
        ((StringBuilder)localObject).append(this.k);
        AEQLog.b("EditPicActivity.EditVideoRawImage", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scale = ");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(", tx = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", ty = ");
        ((StringBuilder)localObject).append(f2);
        AEQLog.b("EditPicActivity.EditVideoRawImage", ((StringBuilder)localObject).toString());
        this.o = Math.max(this.n, this.o);
        this.q.reset();
        localObject = this.q;
        f3 = this.n;
        ((Matrix)localObject).setScale(f3, f3);
        this.q.postTranslate(f1, f2);
        a(this.q, false);
        this.p.set(0.0F, 0.0F, this.j, this.k);
        this.a.getImageMatrix().mapRect(this.p);
        if (this.t.O != null)
        {
          if (this.j / this.h != this.k / this.i)
          {
            this.t.O.a(new RectF(this.p));
            return;
          }
          this.t.O.a(null);
        }
        return;
      }
      AEQLog.a("EditPicActivity.EditVideoRawImage", "image view drawable size is not ready");
    }
  }
  
  private float k()
  {
    this.a.getImageMatrix().getValues(this.s);
    return this.s[0];
  }
  
  public void a()
  {
    super.a();
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setVideoDuration(-1L);
    ThreadManager.post(this, 8, null, false);
    this.a = ((ImageView)d(2063991353));
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new EditPicRawImage.1(this));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.l = paramFloat1;
    this.m = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = k();
    paramFloat1 = Math.min(this.o / f1, Math.max(this.n / f1, paramFloat1));
    if (Math.abs(paramFloat1 - 1.0F) < 1.0E-006D) {
      return;
    }
    this.r.set(this.a.getImageMatrix());
    this.r.postTranslate(paramFloat2 - this.l, paramFloat3 - this.m);
    this.r.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(this.r, true);
    this.l = paramFloat2;
    this.m = paramFloat3;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)b(EditDoodleExport.class);
    if (localEditDoodleExport != null) {}
    try
    {
      localEditDoodleExport.a(paramInt1, paramInt2, false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    paramGenerateContext.l.e = this.e;
    paramGenerateContext.l.c = this.b;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 7)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.b.recycle();
    }
    int i1 = this.a.getWidth();
    int i2 = this.a.getHeight();
    this.b = paramBitmap;
    if ((!this.e) && (!EditVideoPartManager.a(this.g, 8192)) && (this.b != null) && (this.t.C == 0))
    {
      this.e = true;
      if (VideoUtils.a(this.b.getWidth(), this.b.getHeight(), i1, i2))
      {
        localObject = ImageUtil.a(u(), this.b, 0.25F, 20.0F);
        if (localObject != null)
        {
          Canvas localCanvas = new Canvas();
          if (((Bitmap)localObject).isMutable()) {
            paramBitmap = (Bitmap)localObject;
          } else {
            paramBitmap = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
          }
          localCanvas.setBitmap(paramBitmap);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramBitmap = VideoUtils.b(this.b.getWidth(), this.b.getHeight(), i1, i2);
          this.b = BitmapUtils.a(BitmapUtils.a((Bitmap)localObject, ((Integer)paramBitmap.first).intValue(), ((Integer)paramBitmap.second).intValue(), true), this.b);
        }
      }
    }
    this.a.setImageBitmap(this.b);
    this.a.setScaleType(ImageView.ScaleType.MATRIX);
    i();
    if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
    {
      this.a.destroyDrawingCache();
      this.a.refreshDrawableState();
      this.a.invalidate();
    }
    if ((!paramBoolean) && (this.b != null))
    {
      i1 = this.a.getWidth();
      i2 = this.a.getHeight();
      if ((i1 > 0) && (i2 > 0))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("resizeDoodleView image width: ");
        paramBitmap.append(i1);
        paramBitmap.append(" height: ");
        paramBitmap.append(i2);
        AEQLog.b("EditPicActivity.EditVideoRawImage", paramBitmap.toString());
        a(i1, i2);
      }
    }
    else
    {
      paramBitmap = (EditDoodleExport)b(EditDoodleExport.class);
      if (paramBitmap != null)
      {
        localObject = (MosaicOperator)paramBitmap.b().getLineLayer().b(104);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).e();
          ((MosaicOperator)localObject).b();
          paramBitmap.b().w();
        }
      }
    }
  }
  
  public void c()
  {
    this.m = 0.0F;
    this.l = 0.0F;
  }
  
  public Bitmap d()
  {
    return this.b;
  }
  
  public void g()
  {
    super.g();
    this.c.removeMessages(999);
    f = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.u != null) && (this.u.getActivity() != null) && (!this.u.getActivity().isFinishing()))
    {
      if (paramMessage.what == 998)
      {
        QQToast.makeText(this.u.getActivity().getApplicationContext(), this.u.getActivity().getResources().getString(2131917324), 0).show();
        this.u.finish(0, null, 2130772081, 0);
        return false;
      }
      if (paramMessage.what == 999)
      {
        a((Bitmap)paramMessage.obj, false);
        this.t.K();
        if (this.d)
        {
          this.t.a(Message.obtain(null, 2, 4, 0));
          return false;
        }
        if ((this.t.I.h() != 106) && (this.t.I.h() != 109) && (this.t.I.h() != 103)) {
          this.t.a(Message.obtain(null, 2, 1024, 0));
        }
      }
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage isFinishing");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(" mUi is null, ");
    paramMessage = localStringBuilder.toString();
    boolean bool;
    if (this.u == null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.e("EditPicActivity.EditVideoRawImage", 1, new Object[] { paramMessage, Boolean.valueOf(bool) });
    return false;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLayoutChange, height pixel change,bottom:");
      paramView.append(paramInt4);
      paramView.append(" oldBottom:");
      paramView.append(paramInt8);
      paramView.append(" top:");
      paramView.append(paramInt2);
      paramView.append(" oldTop:");
      paramView.append(paramInt6);
      QLog.i("EditPicActivity.EditVideoRawImage", 2, paramView.toString());
    }
    if ((paramInt8 != paramInt4) && (f == 0) && (paramInt4 > 0)) {
      f = paramInt4 - paramInt2;
    }
    boolean bool;
    if ((paramInt7 - paramInt5 == paramInt3 - paramInt1) && (paramInt8 - paramInt6 == paramInt4 - paramInt2)) {
      bool = false;
    } else {
      bool = true;
    }
    this.a.post(new EditPicRawImage.2(this, bool));
  }
  
  public void run()
  {
    Object localObject2 = this.t.I.e.a();
    Object localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
    ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
    if ((((BitmapFactory.Options)localObject3).outWidth >= 64) && (((BitmapFactory.Options)localObject3).outHeight >= 64))
    {
      localObject1 = this.u.getActivity().getResources().getDisplayMetrics();
      i1 = a((BitmapFactory.Options)localObject3, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject3).inSampleSize = i1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode oom");
      ((StringBuilder)localObject1).append(((BitmapFactory.Options)localObject3).inSampleSize);
      QLog.e("EditPicActivity.EditVideoRawImage", 1, ((StringBuilder)localObject1).toString());
      ((BitmapFactory.Options)localObject3).inSampleSize = (i1 * 2);
      try
      {
        localObject1 = ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode oom");
      ((StringBuilder)localObject1).append(((BitmapFactory.Options)localObject3).inSampleSize);
      QLog.e("EditPicActivity.EditVideoRawImage", 1, ((StringBuilder)localObject1).toString());
      ((BitmapFactory.Options)localObject3).inSampleSize = (i1 * 4);
      try
      {
        localObject1 = ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        int i2;
        int i3;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("decode oom again");
    ((StringBuilder)localObject1).append(((BitmapFactory.Options)localObject3).inSampleSize);
    QLog.e("EditPicActivity.EditVideoRawImage", 1, ((StringBuilder)localObject1).toString());
    localObject1 = null;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode");
      ((StringBuilder)localObject1).append(null);
      QLog.e("EditPicActivity.EditVideoRawImage", 1, ((StringBuilder)localObject1).toString());
      this.u.finish(0, null, 2130772081, 0);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sampleSize");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(" w ");
      ((StringBuilder)localObject3).append(((Bitmap)localObject1).getWidth());
      ((StringBuilder)localObject3).append(" h ");
      ((StringBuilder)localObject3).append(((Bitmap)localObject1).getHeight());
      QLog.d("EditPicActivity.EditVideoRawImage", 2, ((StringBuilder)localObject3).toString());
    }
    this.t.I.f = ((Bitmap)localObject1).getWidth();
    this.t.I.g = ((Bitmap)localObject1).getHeight();
    int i1 = ImageUtil.h((String)localObject2);
    localObject2 = localObject1;
    if (i1 != 0)
    {
      localObject2 = localObject1;
      if (i1 % 90 == 0)
      {
        this.t.af = i1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("has exif rotate");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("EditPicActivity.EditVideoRawImage", 2, ((StringBuilder)localObject2).toString());
        }
        i2 = ((Bitmap)localObject1).getWidth();
        i3 = ((Bitmap)localObject1).getHeight();
        localObject2 = new Matrix();
        ((Matrix)localObject2).postRotate(i1, i2 / 2.0F, i3 / 2.0F);
        localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, i2, i3, (Matrix)localObject2, true);
      }
    }
    this.c.obtainMessage(999, localObject2).sendToTarget();
    return;
    QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
    this.c.sendEmptyMessage(998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */