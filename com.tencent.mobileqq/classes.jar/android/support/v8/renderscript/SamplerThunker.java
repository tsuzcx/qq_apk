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
    case 7: 
      return android.renderscript.Sampler.Value.MIRRORED_REPEAT;
    case 6: 
      return android.renderscript.Sampler.Value.CLAMP;
    case 5: 
      return android.renderscript.Sampler.Value.WRAP;
    case 4: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_NEAREST;
    case 3: 
      return android.renderscript.Sampler.Value.LINEAR_MIP_LINEAR;
    case 2: 
      return android.renderscript.Sampler.Value.LINEAR;
    }
    return android.renderscript.Sampler.Value.NEAREST;
  }
  
  BaseObj getNObj()
  {
    return this.mN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.SamplerThunker
 * JD-Core Version:    0.7.0.1
 */