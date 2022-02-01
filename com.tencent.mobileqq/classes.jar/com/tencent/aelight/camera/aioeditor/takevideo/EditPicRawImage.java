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
  public static int a;
  private float jdField_a_of_type_Float;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_b_of_type_Boolean = false;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g = 1.0F;
  private float h = 3.0F;
  
  public EditPicRawImage(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private float a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix().getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = paramInt2;
    if (k > j * 6) {
      i = paramInt2 * 3;
    }
    paramInt2 = paramInt1;
    if (j > k * 6) {
      paramInt2 = paramInt1 * 3;
    }
    if ((k <= i * 1.2F) && (j <= paramInt2 * 1.2F)) {
      return 1;
    }
    paramInt1 = 2;
    k /= 2;
    j /= 2;
    for (;;)
    {
      if ((k / paramInt1 <= i) && (j / paramInt1 <= paramInt2)) {
        return paramInt1;
      }
      paramInt1 *= 2;
    }
  }
  
  private void a(Matrix paramMatrix, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      float f1 = this.c;
      float f2 = this.d;
      float f3 = 0.0F;
      localRectF.set(0.0F, 0.0F, f1, f2);
      paramMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
      if (this.jdField_b_of_type_AndroidGraphicsRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) {
        f2 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      }
      for (f1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;; f1 = this.jdField_b_of_type_AndroidGraphicsRectF.right)
      {
        f1 = f2 - f1;
        break label126;
        if (this.jdField_b_of_type_AndroidGraphicsRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
          break;
        }
        f2 = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      }
      f1 = 0.0F;
      label126:
      if (this.jdField_b_of_type_AndroidGraphicsRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) {
        f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
      }
      for (f3 = this.jdField_b_of_type_AndroidGraphicsRectF.top;; f3 = this.jdField_b_of_type_AndroidGraphicsRectF.bottom)
      {
        f2 -= f3;
        break;
        f2 = f3;
        if (this.jdField_b_of_type_AndroidGraphicsRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
          break;
        }
        f2 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      }
      paramMatrix.postTranslate(f1, f2);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(paramMatrix);
    this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix());
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a(this.jdField_b_of_type_AndroidGraphicsMatrix);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() <= 0) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if (localObject == null)
      {
        AEQLog.a("EditPicActivity.EditVideoRawImage", "image view with no drawable");
        return;
      }
      this.c = ((Drawable)localObject).getIntrinsicWidth();
      this.d = ((Drawable)localObject).getIntrinsicHeight();
      if ((this.c > 0.0F) && (this.d > 0.0F))
      {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
        float f1 = this.jdField_a_of_type_Float;
        float f2 = this.c;
        float f3 = f1 / f2;
        float f4 = this.jdField_b_of_type_Float;
        float f5 = this.d;
        if (f3 >= f4 / f5)
        {
          this.g = (f4 / f5);
          f1 = (f1 - f2 * this.g) / 2.0F;
          f2 = 0.0F;
        }
        else
        {
          this.g = (f1 / f2);
          f2 = (f4 - f5 * this.g) / 2.0F;
          f1 = 0.0F;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bitmap width = ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("bitmap height = ");
        ((StringBuilder)localObject).append(this.d);
        AEQLog.b("EditPicActivity.EditVideoRawImage", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scale = ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(", tx = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", ty = ");
        ((StringBuilder)localObject).append(f2);
        AEQLog.b("EditPicActivity.EditVideoRawImage", ((StringBuilder)localObject).toString());
        this.h = Math.max(this.g, this.h);
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
        f3 = this.g;
        ((Matrix)localObject).setScale(f3, f3);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1, f2);
        a(this.jdField_a_of_type_AndroidGraphicsMatrix, false);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.c, this.d);
        this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix().mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null)
        {
          if (this.c / this.jdField_a_of_type_Float != this.d / this.jdField_b_of_type_Float)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a(new RectF(this.jdField_a_of_type_AndroidGraphicsRectF));
            return;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a(null);
        }
        return;
      }
      AEQLog.a("EditPicActivity.EditVideoRawImage", "image view drawable size is not ready");
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    super.a();
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setVideoDuration(-1L);
    ThreadManager.post(this, 8, null, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2064122534));
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new EditPicRawImage.1(this));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = a();
    paramFloat1 = Math.min(this.h / f1, Math.max(this.g / f1, paramFloat1));
    if (Math.abs(paramFloat1 - 1.0F) < 1.0E-006D) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidWidgetImageView.getImageMatrix());
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat2 - this.e, paramFloat3 - this.f);
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(this.jdField_b_of_type_AndroidGraphicsMatrix, true);
    this.e = paramFloat2;
    this.f = paramFloat3;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)a(EditDoodleExport.class);
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
    paramGenerateContext.a.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
    paramGenerateContext.a.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 7)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    if ((!this.jdField_b_of_type_Boolean) && (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 8192)) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 0))
    {
      this.jdField_b_of_type_Boolean = true;
      if (VideoUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j))
      {
        localObject = ImageUtil.a(a(), this.jdField_a_of_type_AndroidGraphicsBitmap, 0.25F, 20.0F);
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
          paramBitmap = VideoUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j);
          this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.a(BitmapUtils.a((Bitmap)localObject, ((Integer)paramBitmap.first).intValue(), ((Integer)paramBitmap.second).intValue(), true), this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    g();
    if (Build.MANUFACTURER.equalsIgnoreCase("Letv"))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.destroyDrawingCache();
      this.jdField_a_of_type_AndroidWidgetImageView.refreshDrawableState();
      this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      j = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      if ((i > 0) && (j > 0))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("resizeDoodleView image width: ");
        paramBitmap.append(i);
        paramBitmap.append(" height: ");
        paramBitmap.append(j);
        AEQLog.b("EditPicActivity.EditVideoRawImage", paramBitmap.toString());
        a(i, j);
      }
    }
    else
    {
      paramBitmap = (EditDoodleExport)a(EditDoodleExport.class);
      if (paramBitmap != null)
      {
        localObject = (MosaicOperator)paramBitmap.a().a().a(104);
        if (localObject != null)
        {
          ((MosaicOperator)localObject).e();
          ((MosaicOperator)localObject).b();
          paramBitmap.a().s();
        }
      }
    }
  }
  
  public void b()
  {
    this.f = 0.0F;
    this.e = 0.0F;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(999);
    jdField_a_of_type_Int = 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().isFinishing()))
    {
      if (paramMessage.what == 998)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getResources().getString(2131719721), 0).a();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, null, 2130772056, 0);
        return false;
      }
      if (paramMessage.what == 999)
      {
        a((Bitmap)paramMessage.obj, false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.y();
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 4, 0));
          return false;
        }
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() != 106) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() != 109) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() != 103)) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 2, 1024, 0));
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
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == null) {
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
    if ((paramInt8 != paramInt4) && (jdField_a_of_type_Int == 0) && (paramInt4 > 0)) {
      jdField_a_of_type_Int = paramInt4 - paramInt2;
    }
    boolean bool;
    if ((paramInt7 - paramInt5 == paramInt3 - paramInt1) && (paramInt8 - paramInt6 == paramInt4 - paramInt2)) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.post(new EditPicRawImage.2(this, bool));
  }
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a.a();
    Object localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
    ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
    if ((((BitmapFactory.Options)localObject3).outWidth >= 64) && (((BitmapFactory.Options)localObject3).outHeight >= 64))
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
      i = a((BitmapFactory.Options)localObject3, ((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject3).inSampleSize = i;
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
      ((BitmapFactory.Options)localObject3).inSampleSize = (i * 2);
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
      ((BitmapFactory.Options)localObject3).inSampleSize = (i * 4);
      try
      {
        localObject1 = ImageUtil.a((String)localObject2, (BitmapFactory.Options)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        int j;
        int k;
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
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, null, 2130772056, 0);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sampleSize");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(" w ");
      ((StringBuilder)localObject3).append(((Bitmap)localObject1).getWidth());
      ((StringBuilder)localObject3).append(" h ");
      ((StringBuilder)localObject3).append(((Bitmap)localObject1).getHeight());
      QLog.d("EditPicActivity.EditVideoRawImage", 2, ((StringBuilder)localObject3).toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d = ((Bitmap)localObject1).getWidth();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e = ((Bitmap)localObject1).getHeight();
    int i = ImageUtil.c((String)localObject2);
    localObject2 = localObject1;
    if (i != 0)
    {
      localObject2 = localObject1;
      if (i % 90 == 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g = i;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("has exif rotate");
          ((StringBuilder)localObject2).append(i);
          QLog.d("EditPicActivity.EditVideoRawImage", 2, ((StringBuilder)localObject2).toString());
        }
        j = ((Bitmap)localObject1).getWidth();
        k = ((Bitmap)localObject1).getHeight();
        localObject2 = new Matrix();
        ((Matrix)localObject2).postRotate(i, j / 2.0F, k / 2.0F);
        localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, j, k, (Matrix)localObject2, true);
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(999, localObject2).sendToTarget();
    return;
    QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage
 * JD-Core Version:    0.7.0.1
 */