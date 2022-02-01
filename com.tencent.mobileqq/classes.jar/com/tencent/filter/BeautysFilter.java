package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import java.util.Map;

public class BeautysFilter
  extends BaseFilter
{
  private final int[] curveStatic = { 0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255 };
  private int flag = 0;
  private final int[] globalWhiten = { 0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255 };
  private int usesmooth = 1;
  
  public BeautysFilter(int paramInt1, int paramInt2)
  {
    super(BaseFilter.getFragmentShader(paramInt1));
    this.usesmooth = paramInt2;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (isValid())
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    Object localObject2;
    Object localObject1;
    if (this.usesmooth == 1)
    {
      localObject2 = new BaseFilter(BaseFilter.getFragmentShader(15));
      ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("radius", 2.0F));
      setNextFilter((BaseFilter)localObject2, null);
      localObject1 = new BaseFilter(BaseFilter.getFragmentShader(16));
      ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("radius", 2.0F));
      ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
      localObject2 = new BaseFilter(BaseFilter.getFragmentShader(17));
      ((BaseFilter)localObject2).addParam(new TextureFloatsParam("inputImageTexture2", this.curveStatic, 33986));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
      ((BaseFilter)localObject2).setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(18)), new int[] { this.srcTextureIndex + 1 });
    }
    else
    {
      localObject2 = this;
    }
    int i = this.flag;
    if (i != 1002)
    {
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          localObject1 = null;
          break;
        case 103: 
          localObject1 = new BaseFilter(BaseFilter.getFragmentShader(40));
          ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "tianmei.png", 33986));
          break;
        case 102: 
          localObject1 = new BaseFilter(BaseFilter.getFragmentShader(42));
          ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "hongrun.png", 33986));
          break;
        case 101: 
          localObject1 = new BaseFilter(BaseFilter.getFragmentShader(41));
          ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "yangguang.png", 33986));
        }
        break;
      case 9: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(43));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
      case 8: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(12));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "gradient.jpg", 33986));
        break;
      case 7: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(26));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "fennen.png", 33986));
        break;
      case 6: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(25));
        ((BaseFilter)localObject1).addParam(new TextureFloatsParam("inputImageTexture2", this.globalWhiten, 33986));
        break;
      case 5: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(24));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
      case 4: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(23));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
      case 3: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(22));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
      case 1: 
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(20));
        ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
      }
    }
    else
    {
      localObject1 = new BaseFilter(BaseFilter.getFragmentShader(21));
      ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "portraitbeauty.png", 33986));
    }
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    i = this.flag;
    if ((i != 1) && (i != 8) && (i >= 1))
    {
      localObject2 = new BaseFilter(BaseFilter.getFragmentShader(19));
      ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "glowcenter.jpg", 33986));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
      localObject1 = localObject2;
    }
    i = this.flag;
    if (i == 9)
    {
      localObject2 = new BaseFilter(BaseFilter.getFragmentShader(4));
      ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("filterAdjustParam", 0.6400001F));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex + 1 });
    }
    else if (i == 1002)
    {
      localObject2 = new BaseFilter(BaseFilter.getFragmentShader(4));
      ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("filterAdjustParam", 0.56F));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex + 1 });
    }
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.flag = paramInt;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.flag = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.BeautysFilter
 * JD-Core Version:    0.7.0.1
 */