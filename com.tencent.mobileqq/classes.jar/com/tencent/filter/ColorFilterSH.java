package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import java.util.Map;

public class ColorFilterSH
  extends BaseFilter
{
  private int effectindex = 0;
  
  public ColorFilterSH()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(62));
    int i = this.effectindex;
    Object localObject = "sh/";
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sh/");
              ((StringBuilder)localObject).append("yellow_sh_blend.jpg");
              localObject = ((StringBuilder)localObject).toString();
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("sh/");
            ((StringBuilder)localObject).append("red_sh_blend.jpg");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sh/");
          ((StringBuilder)localObject).append("purple_sh_blend.jpg");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sh/");
        ((StringBuilder)localObject).append("green_sh_blend.jpg");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sh/");
      ((StringBuilder)localObject).append("blue_sh_blend.jpg");
      localObject = ((StringBuilder)localObject).toString();
    }
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", (String)localObject, 33986));
    setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(3));
    if (this.effectindex == 2) {
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("filterAdjustParam", 0.6F));
    } else {
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("filterAdjustParam", 0.5F));
    }
    localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.effectindex = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ColorFilterSH
 * JD-Core Version:    0.7.0.1
 */