package android.support.v8.renderscript;

public class Sampler
  extends BaseObj
{
  float mAniso;
  Sampler.Value mMag;
  Sampler.Value mMin;
  Sampler.Value mWrapR;
  Sampler.Value mWrapS;
  Sampler.Value mWrapT;
  
  Sampler(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static Sampler CLAMP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_LINEAR == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.LINEAR);
      localBuilder.setMagnification(Sampler.Value.LINEAR);
      localBuilder.setWrapS(Sampler.Value.CLAMP);
      localBuilder.setWrapT(Sampler.Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_LINEAR;
  }
  
  public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.LINEAR_MIP_LINEAR);
      localBuilder.setMagnification(Sampler.Value.LINEAR);
      localBuilder.setWrapS(Sampler.Value.CLAMP);
      localBuilder.setWrapT(Sampler.Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR;
  }
  
  public static Sampler CLAMP_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_CLAMP_NEAREST == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.NEAREST);
      localBuilder.setMagnification(Sampler.Value.NEAREST);
      localBuilder.setWrapS(Sampler.Value.CLAMP);
      localBuilder.setWrapT(Sampler.Value.CLAMP);
      paramRenderScript.mSampler_CLAMP_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_CLAMP_NEAREST;
  }
  
  public static Sampler MIRRORED_REPEAT_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.LINEAR);
      localBuilder.setMagnification(Sampler.Value.LINEAR);
      localBuilder.setWrapS(Sampler.Value.MIRRORED_REPEAT);
      localBuilder.setWrapT(Sampler.Value.MIRRORED_REPEAT);
      paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_MIRRORED_REPEAT_LINEAR;
  }
  
  public static Sampler MIRRORED_REPEAT_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.NEAREST);
      localBuilder.setMagnification(Sampler.Value.NEAREST);
      localBuilder.setWrapS(Sampler.Value.MIRRORED_REPEAT);
      localBuilder.setWrapT(Sampler.Value.MIRRORED_REPEAT);
      paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_MIRRORED_REPEAT_NEAREST;
  }
  
  public static Sampler WRAP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_LINEAR == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.LINEAR);
      localBuilder.setMagnification(Sampler.Value.LINEAR);
      localBuilder.setWrapS(Sampler.Value.WRAP);
      localBuilder.setWrapT(Sampler.Value.WRAP);
      paramRenderScript.mSampler_WRAP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_LINEAR;
  }
  
  public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.LINEAR_MIP_LINEAR);
      localBuilder.setMagnification(Sampler.Value.LINEAR);
      localBuilder.setWrapS(Sampler.Value.WRAP);
      localBuilder.setWrapT(Sampler.Value.WRAP);
      paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_LINEAR_MIP_LINEAR;
  }
  
  public static Sampler WRAP_NEAREST(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mSampler_WRAP_NEAREST == null)
    {
      Sampler.Builder localBuilder = new Sampler.Builder(paramRenderScript);
      localBuilder.setMinification(Sampler.Value.NEAREST);
      localBuilder.setMagnification(Sampler.Value.NEAREST);
      localBuilder.setWrapS(Sampler.Value.WRAP);
      localBuilder.setWrapT(Sampler.Value.WRAP);
      paramRenderScript.mSampler_WRAP_NEAREST = localBuilder.create();
    }
    return paramRenderScript.mSampler_WRAP_NEAREST;
  }
  
  public float getAnisotropy()
  {
    return this.mAniso;
  }
  
  public Sampler.Value getMagnification()
  {
    return this.mMag;
  }
  
  public Sampler.Value getMinification()
  {
    return this.mMin;
  }
  
  public Sampler.Value getWrapS()
  {
    return this.mWrapS;
  }
  
  public Sampler.Value getWrapT()
  {
    return this.mWrapT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Sampler
 * JD-Core Version:    0.7.0.1
 */