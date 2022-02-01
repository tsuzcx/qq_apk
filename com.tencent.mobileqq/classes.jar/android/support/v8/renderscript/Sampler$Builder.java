package android.support.v8.renderscript;

public class Sampler$Builder
{
  float mAniso;
  Sampler.Value mMag;
  Sampler.Value mMin;
  RenderScript mRS;
  Sampler.Value mWrapR;
  Sampler.Value mWrapS;
  Sampler.Value mWrapT;
  
  public Sampler$Builder(RenderScript paramRenderScript)
  {
    this.mRS = paramRenderScript;
    this.mMin = Sampler.Value.NEAREST;
    this.mMag = Sampler.Value.NEAREST;
    this.mWrapS = Sampler.Value.WRAP;
    this.mWrapT = Sampler.Value.WRAP;
    this.mWrapR = Sampler.Value.WRAP;
    this.mAniso = 1.0F;
  }
  
  public Sampler create()
  {
    Object localObject = this.mRS;
    if (RenderScript.isNative)
    {
      localObject = new SamplerThunker.Builder((RenderScriptThunker)this.mRS);
      ((SamplerThunker.Builder)localObject).setMinification(this.mMin);
      ((SamplerThunker.Builder)localObject).setMagnification(this.mMag);
      ((SamplerThunker.Builder)localObject).setWrapS(this.mWrapS);
      ((SamplerThunker.Builder)localObject).setWrapT(this.mWrapT);
      ((SamplerThunker.Builder)localObject).setAnisotropy(this.mAniso);
      return ((SamplerThunker.Builder)localObject).create();
    }
    this.mRS.validate();
    localObject = new Sampler(this.mRS.nSamplerCreate(this.mMag.mID, this.mMin.mID, this.mWrapS.mID, this.mWrapT.mID, this.mWrapR.mID, this.mAniso), this.mRS);
    ((Sampler)localObject).mMin = this.mMin;
    ((Sampler)localObject).mMag = this.mMag;
    ((Sampler)localObject).mWrapS = this.mWrapS;
    ((Sampler)localObject).mWrapT = this.mWrapT;
    ((Sampler)localObject).mWrapR = this.mWrapR;
    ((Sampler)localObject).mAniso = this.mAniso;
    return localObject;
  }
  
  public void setAnisotropy(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.mAniso = paramFloat;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
  
  public void setMagnification(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR))
    {
      this.mMag = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
  
  public void setMinification(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_NEAREST))
    {
      this.mMin = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
  
  public void setWrapS(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
    {
      this.mWrapS = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
  
  public void setWrapT(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
    {
      this.mWrapT = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.Sampler.Builder
 * JD-Core Version:    0.7.0.1
 */