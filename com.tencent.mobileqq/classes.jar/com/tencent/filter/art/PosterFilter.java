package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import java.util.Map;

public class PosterFilter
  extends BaseFilter
{
  private float edgeFactor = 1.0F;
  private int type = 0;
  
  public PosterFilter(int paramInt)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.type = paramInt;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    clearGLSL();
    if (paramBoolean)
    {
      this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
      setNextFilter(null, null);
    }
    else
    {
      this.glslProgramShader = BaseFilter.getFragmentShader(78);
      BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(77));
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(79));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(72));
      localBaseFilter2.addParam(new UniformParam.FloatParam("threshold", 0.0F));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(83));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      BaseFilter localBaseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(84));
      localBaseFilter3.addParam(new UniformParam.FloatParam("inv_2sigma2", 127.00195F));
      localBaseFilter3.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.0008F));
      localBaseFilter3.addParam(new UniformParam.FloatParam("edge_factor", this.edgeFactor));
      localBaseFilter1.setNextFilter(localBaseFilter3, new int[] { 2 });
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(85));
      localBaseFilter2.addParam(new UniformParam.FloatParam("par", 0.35F));
      localBaseFilter2.addParam(new UniformParam.FloatParam("par_b", 0.2F));
      if (this.type == 0)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 1.0F, 1.0F, 1.0F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 0.8666667F, 0.8470588F, 0.6666667F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.8705882F, 0.3098039F, 0.1647059F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.2039216F, 0.4078431F, 0.4078431F, 1.0F }));
      }
      if (this.type == 1)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 0.8117647F, 0.9647059F, 0.9607843F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 0.8627451F, 0.882353F, 0.7921569F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.827451F, 0.690196F, 0.2352941F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.4470588F, 0.4078431F, 0.3176471F, 1.0F }));
      }
      if (this.type == 2)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 0.7411765F, 0.8627451F, 0.827451F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 0.882353F, 0.682353F, 0.7333334F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.6313726F, 0.5215687F, 0.690196F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.3960784F, 0.3294118F, 0.4980392F, 1.0F }));
      }
      if (this.type == 3)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 0.9882353F, 0.9960784F, 0.882353F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 0.9882353F, 0.9960784F, 0.882353F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.854902F, 0.7372549F, 0.4392157F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.654902F, 0.4588235F, 0.4784314F, 1.0F }));
      }
      if (this.type == 4)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 1.0F, 0.9529412F, 0.7843137F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 1.0F, 0.9529412F, 0.7843137F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.8F, 0.8431373F, 0.5372549F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.0F, 0.3254902F, 0.3529412F, 1.0F }));
      }
      if (this.type == 5)
      {
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorA", new float[] { 1.0F, 0.913726F, 0.6862745F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorB", new float[] { 1.0F, 0.913726F, 0.6862745F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorC", new float[] { 0.4352941F, 0.854902F, 0.8901961F, 1.0F }));
        localBaseFilter2.addParam(new UniformParam.FloatsParam("colorD", new float[] { 0.9647059F, 0.3607843F, 0.5333334F, 1.0F }));
      }
      localBaseFilter3.setNextFilter(localBaseFilter2, new int[] { 4 });
      if (GLES20.glGetString(7937).indexOf("NVIDIA Tegra") != -1)
      {
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(87));
      }
      else
      {
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(86));
        localBaseFilter1.addParam(new UniformParam.IntParam("radius", 2));
      }
      localBaseFilter1.addParam(new UniformParam.FloatParam("inv_2sigma", 4.4F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
    }
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("detail")) {
      this.edgeFactor = ((Float)paramMap.get("detail")).floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.art.PosterFilter
 * JD-Core Version:    0.7.0.1
 */