package com.tencent.av.opengl.multiplevideos;

import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class CompositeFilter2
  extends Filter
{
  private static String jdField_b_of_type_JavaLangString = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private static String c = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform vec4 offset;\nuniform vec4 offset1;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture1;\nvoid main() {\n    vec2 newCoordinate;\n    if (textureCoordinate.x <= 0.5) {\n        newCoordinate.x = offset.x + textureCoordinate.x * 2.0 * (1.0 - offset.y - offset.x);\n        newCoordinate.y = offset.y + textureCoordinate.y * (1.0 - offset.w - offset.z);\n        gl_FragColor = texture2D(inputImageTexture, newCoordinate);\n    } else {\n        newCoordinate.x = offset1.x + (textureCoordinate.x - 0.5) * 2.0 * (1.0 - offset1.y - offset1.x);\n        newCoordinate.y = offset1.z + textureCoordinate.y * (1.0 - offset1.w - offset1.z);\n        gl_FragColor = texture2D(inputImageTexture1, newCoordinate);\n    }\n}";
  private int jdField_a_of_type_Int = 0;
  private CompositeFilter2.Filter2 jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2;
  private String jdField_a_of_type_JavaLangString = "CompositeFilter2-" + Integer.toHexString(hashCode());
  private float[] jdField_a_of_type_ArrayOfFloat = new float[4];
  private int jdField_b_of_type_Int = 0;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[4];
  
  public CompositeFilter2(int paramInt1, int paramInt2)
  {
    super(2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "CompositeFilter2: width=" + paramInt1 + ", height=" + paramInt2);
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = this.jdField_b_of_type_Int / this.jdField_a_of_type_Int * 2.0F;
    if (paramInt2 / paramInt1 > f)
    {
      paramArrayOfFloat[1] = 0.0F;
      paramArrayOfFloat[0] = 0.0F;
      paramArrayOfFloat[2] = ((paramInt2 - f * paramInt1) / paramInt2 / 2.0F);
      paramArrayOfFloat[3] = paramArrayOfFloat[2];
      return;
    }
    paramArrayOfFloat[0] = ((paramInt1 - paramInt2 / f) / paramInt1 / 2.0F);
    paramArrayOfFloat[1] = paramArrayOfFloat[0];
    paramArrayOfFloat[3] = 0.0F;
    paramArrayOfFloat[2] = 0.0F;
  }
  
  @NotNull
  public Frame a(List<RefFrame> paramList, long paramLong)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0))
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "onRender: invalidate composite size");
      return null;
    }
    if (paramList.size() > 2) {
      Log.w(this.jdField_a_of_type_JavaLangString, "onRender: expect 2 inputs, but got " + paramList.size());
    }
    Frame localFrame = ((RefFrame)paramList.get(0)).a;
    a(this.jdField_a_of_type_ArrayOfFloat, localFrame.width, localFrame.height);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.addParam(new UniformParam.Float4fParam("offset", this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]));
    if (paramList.size() > 1)
    {
      paramList = ((RefFrame)paramList.get(1)).a;
      a(this.jdField_b_of_type_ArrayOfFloat, paramList.width, paramList.height);
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.addParam(new UniformParam.TextureParam("inputImageTexture1", paramList.getTextureId(), 33985));
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.addParam(new UniformParam.Float4fParam("offset1", this.jdField_b_of_type_ArrayOfFloat[0], this.jdField_b_of_type_ArrayOfFloat[1], this.jdField_b_of_type_ArrayOfFloat[2], this.jdField_b_of_type_ArrayOfFloat[3]));
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.RenderProcess(localFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.addParam(new UniformParam.TextureParam("inputImageTexture1", -1, 33985));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2 = new CompositeFilter2.Filter2(this);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.hashCode()));
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.setPositions(AEOpenRenderConfig.ORIGIN_POSITION_COORDS, true);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS, true);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.ApplyGLSLFilter();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2 != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.clearGLSLSelf();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2.hashCode()));
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2$Filter2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.CompositeFilter2
 * JD-Core Version:    0.7.0.1
 */