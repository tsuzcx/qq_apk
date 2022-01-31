import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.filter.AEGifSticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.view.RendererUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class blbx
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int;
  private blbu jdField_a_of_type_Blbu = new blbu();
  private blby jdField_a_of_type_Blby;
  private AEGifSticker jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private boolean jdField_b_of_type_Boolean;
  
  private Frame a(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    Object localObject = paramFrame;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker != null)
    {
      localObject = new HashSet();
      ((Set)localObject).add(Integer.valueOf(1));
      ((Set)localObject).add(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.updateFaceParams(paramList, paramList1, (Set)localObject);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.updateVideoSize(paramFrame.width, paramFrame.height, this.jdField_a_of_type_Double * 2.0D);
      localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.render(paramFrame);
    }
    return localObject;
  }
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Blbu.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      paramFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Blby != null))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        float f1 = -1.0F + this.jdField_a_of_type_Blby.jdField_a_of_type_Float * 2.0F;
        float f2 = -1.0F + this.jdField_a_of_type_Blby.b * 2.0F;
        float f3 = this.jdField_a_of_type_Blby.c * 2.0F + f1;
        float f4 = this.jdField_a_of_type_Blby.d * 2.0F + f2;
        this.jdField_a_of_type_ComTencentFilterBaseFilter.setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
        this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_Blby.jdField_a_of_type_Int, paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
        GLES20.glDisable(3042);
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(paramFrame.getTextureId(), 320, 320, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      return a(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame, paramList, paramList1);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blbu.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.apply();
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.clear();
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker = new AEGifSticker(paramString);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.apply();
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Blby = new blby(this);
    blce localblce = new blce((int)(320.0F * paramFloat3), (int)(320.0F * paramFloat4));
    localblce.a(paramString1);
    localblce.a(paramInt1);
    localblce.b(paramString2);
    localblce.c(paramString3);
    localblce.a(paramInt2);
    localblce.b();
    paramString1 = localblce.a();
    this.jdField_a_of_type_Blby.jdField_a_of_type_Int = RendererUtils.createTexture(paramString1);
    localblce.c();
    this.jdField_a_of_type_Blby.jdField_a_of_type_Float = paramFloat1;
    this.jdField_a_of_type_Blby.b = paramFloat2;
    this.jdField_a_of_type_Blby.c = paramFloat3;
    this.jdField_a_of_type_Blby.d = paramFloat4;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blbu.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Blby != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Blby.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbx
 * JD-Core Version:    0.7.0.1
 */