import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class brgq
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private brgn jdField_a_of_type_Brgn;
  private GaussianBlurFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
  private GaussianBlurFilterCompose jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  private RenderBuffer jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int jdField_d_of_type_Int;
  private float[] jdField_d_of_type_ArrayOfFloat;
  private int e;
  private int f = -1;
  
  public brgq(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 0);
  }
  
  public brgq(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private float[] a()
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (-this.jdField_b_of_type_Int * 0.734F * 0.5F);
    arrayOfFloat[1] = (-this.jdField_c_of_type_Int * 0.734F * 0.5F);
    float f1 = this.jdField_b_of_type_Int / this.jdField_c_of_type_Int;
    float f2 = this.jdField_d_of_type_Int / this.e;
    float f3;
    if (f1 > f2)
    {
      f3 = arrayOfFloat[0];
      arrayOfFloat[0] = (f2 / f1 * f3);
    }
    for (;;)
    {
      arrayOfFloat[1] += -0.091F * this.jdField_c_of_type_Int / 2.0F;
      return arrayOfFloat;
      if (f1 < f2)
      {
        f3 = arrayOfFloat[1];
        arrayOfFloat[1] = (f1 / f2 * f3);
      }
    }
  }
  
  private static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.734F;
    float f1 = paramInt3 / paramInt4;
    float f3 = paramInt1 / paramInt2;
    if (f1 > f3) {
      f1 = f3 / f1 * 0.734F;
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.translateM(arrayOfFloat, 0, 0.0F, -0.091F, 0.0F);
      Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
      return arrayOfFloat;
      if (f1 < f3)
      {
        f2 = f1 / f3;
        f1 = 0.734F;
        f2 *= 0.734F;
      }
      else
      {
        f1 = 0.734F;
      }
    }
  }
  
  @NonNull
  private void b()
  {
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setAntiAlias(true);
    ((TextPaint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
    ((TextPaint)localObject).setTextSize(22.0F);
    ((TextPaint)localObject).setColor(-1);
    ((TextPaint)localObject).setFakeBoldText(true);
    ((TextPaint)localObject).setStrokeWidth(0.5F);
    ((TextPaint)localObject).setShadowLayer(4.0F, 0.0F, 0.0F, 1073741824);
    Paint.FontMetrics localFontMetrics = ((TextPaint)localObject).getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    float f3 = ((TextPaint)localObject).measureText(this.jdField_a_of_type_JavaLangString) + 2.0F;
    yuk.b("StoryVideoForwardFilter", "createWaterMarkTextureAndCalculateMvpMatrix textHeight=" + f1);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130846840);
    Bitmap localBitmap1 = Bitmap.createBitmap((int)f3 + 6 + (int)f2, (int)f1 + 1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.drawBitmap(localBitmap2, null, new Rect((int)f3 + 5, (int)(f1 - f2) / 2 + 1, (int)f3 + 5 + (int)f2, (int)(f2 + f1) / 2), (Paint)localObject);
    localBitmap2.recycle();
    localCanvas.drawText(this.jdField_a_of_type_JavaLangString, 2.0F, f1 - localFontMetrics.bottom, (Paint)localObject);
    this.f = GlUtil.createTexture(3553, localBitmap1);
    GLES20.glBindTexture(3553, 0);
    this.jdField_d_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_d_of_type_ArrayOfFloat, 0);
    localObject = a();
    f3 = this.jdField_b_of_type_Int / 750.0F;
    f2 = localBitmap1.getWidth() * f3;
    f1 = localBitmap1.getHeight() * f3;
    float f6 = localObject[0];
    float f7 = f2 / 2.0F;
    float f4 = localObject[1];
    float f5 = f1 / 2.0F;
    f6 = (f6 + f7 + 20.0F * f3) / (this.jdField_b_of_type_Int / 2);
    f3 = (f4 + f5 + f3 * 18.0F) / (this.jdField_c_of_type_Int / 2);
    Matrix.translateM(this.jdField_d_of_type_ArrayOfFloat, 0, f6, f3, 0.0F);
    f2 /= this.jdField_b_of_type_Int;
    f1 /= this.jdField_c_of_type_Int;
    Matrix.scaleM(this.jdField_d_of_type_ArrayOfFloat, 0, f2, f1, 1.0F);
    if (localBitmap1 != null) {
      localBitmap1.recycle();
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.init(paramInt1 / 4, paramInt2 / 4);
    this.jdField_a_of_type_Brgn = new brgn();
    this.jdField_a_of_type_Brgn.a(paramInt1, paramInt2, (int)(20.0F * paramInt1 / 550.0F));
    this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    brgk localbrgk = new brgk();
    localbrgk.init();
    localbrgk.a(0.0F, 0.0F, 0.0F, 0.25F);
    localbrgk.a(0.05454546F, 0.03061225F);
    this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    localbrgk.a(null, null);
    this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getFilter();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt3, paramInt4, 33984);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    b();
    this.jdField_a_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_ArrayOfFloat = a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_c_of_type_ArrayOfFloat = new float[16];
    System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0, 16);
    Matrix.translateM(this.jdField_c_of_type_ArrayOfFloat, 0, 0.02181818F, 0.0122449F, 0.0F);
    Matrix.scaleM(this.jdField_c_of_type_ArrayOfFloat, 0, 1.109091F, 1.061225F, 1.0F);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.rotateM(arrayOfFloat, 0, this.jdField_a_of_type_Int, 0.0F, 0.0F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, arrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      i = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.isInitSucc())) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.drawTexture(i);
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.isInitSucc()))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getTextureId(), null, this.jdField_a_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
    }
    for (;;)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, this.jdField_c_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
      this.jdField_a_of_type_Brgn.drawTexture(i, null, this.jdField_b_of_type_ArrayOfFloat);
      if (this.f != -1)
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.f, null, this.jdField_d_of_type_ArrayOfFloat);
        GLES20.glDisable(3042);
      }
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      return this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.1F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i, null, this.jdField_a_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.f != -1) {
      GlUtil.deleteTexture(this.f);
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_Brgn != null) {
      this.jdField_a_of_type_Brgn.destroy();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_Int != paramInt1) || (this.jdField_c_of_type_Int != paramInt2))
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
      b(this.jdField_d_of_type_Int, this.e, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_Int = paramInt4;
    if (this.jdField_a_of_type_Int % 180 != 0) {
      this.jdField_d_of_type_Int = paramInt2;
    }
    for (this.e = paramInt1;; this.e = paramInt2)
    {
      b(this.jdField_d_of_type_Int, this.e, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      return;
      this.jdField_d_of_type_Int = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brgq
 * JD-Core Version:    0.7.0.1
 */