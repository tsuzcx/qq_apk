package android.support.v8.renderscript;

import android.renderscript.BaseObj;

class SamplerThunker
  extends Sampler
{
  android.renderscript.Sampler mN;
  
  protected SamplerThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  static android.renderscript.Sampler.Value convertValue(Sampler.Value paramValue)
  {
    switch (SamplerThunker.1.$SwitchMap$android$support$v8$renderscript$Sampler$Value[paramValue.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return android.renderscript.Sampler.Value.NEAREST;
    case 2: 
      return android.renderscript.Sampler.Value.LINEAR;
    case 3: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_LINEAR;
    case 4: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_NEAREST;
    case 5: 
      return android.renderscript.Sampler.Value.WRAP;
    case 6: 
      return android.renderscript.Sampler.Value.CLAMP;
    }
    return android.renderscript.Sampler.Value.MIRRORED_REPEAT;
  }
  
  BaseObj getNObj()
  {
    return this.mN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.SamplerThunker
 * JD-Core Version:    0.7.0.1
 */