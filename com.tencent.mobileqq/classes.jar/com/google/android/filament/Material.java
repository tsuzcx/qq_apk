package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Material
{
  private final MaterialInstance mDefaultInstance;
  private long mNativeObject;
  private Set<VertexBuffer.VertexAttribute> mRequiredAttributes;
  
  Material(long paramLong)
  {
    this.mNativeObject = paramLong;
    this.mDefaultInstance = new MaterialInstance(this, nGetDefaultInstance(paramLong));
  }
  
  private static native long nBuilderBuild(long paramLong, @NonNull Buffer paramBuffer, int paramInt);
  
  private static native long nCreateInstance(long paramLong);
  
  private static native int nGetBlendingMode(long paramLong);
  
  private static native int nGetCullingMode(long paramLong);
  
  private static native long nGetDefaultInstance(long paramLong);
  
  private static native int nGetInterpolation(long paramLong);
  
  private static native float nGetMaskThreshold(long paramLong);
  
  private static native String nGetName(long paramLong);
  
  private static native int nGetParameterCount(long paramLong);
  
  private static native void nGetParameters(long paramLong, @NonNull List<Material.Parameter> paramList, @IntRange(from=1L) int paramInt);
  
  private static native int nGetRefractionMode(long paramLong);
  
  private static native int nGetRefractionType(long paramLong);
  
  private static native int nGetRequiredAttributes(long paramLong);
  
  private static native int nGetShading(long paramLong);
  
  private static native float nGetSpecularAntiAliasingThreshold(long paramLong);
  
  private static native float nGetSpecularAntiAliasingVariance(long paramLong);
  
  private static native int nGetVertexDomain(long paramLong);
  
  private static native boolean nHasParameter(long paramLong, @NonNull String paramString);
  
  private static native boolean nIsColorWriteEnabled(long paramLong);
  
  private static native boolean nIsDepthCullingEnabled(long paramLong);
  
  private static native boolean nIsDepthWriteEnabled(long paramLong);
  
  private static native boolean nIsDoubleSided(long paramLong);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  public MaterialInstance createInstance()
  {
    long l = nCreateInstance(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create MaterialInstance");
    }
    return new MaterialInstance(this, l);
  }
  
  public Material.BlendingMode getBlendingMode()
  {
    return Material.BlendingMode.values()[nGetBlendingMode(getNativeObject())];
  }
  
  public Material.CullingMode getCullingMode()
  {
    return Material.CullingMode.values()[nGetCullingMode(getNativeObject())];
  }
  
  @NonNull
  public MaterialInstance getDefaultInstance()
  {
    return this.mDefaultInstance;
  }
  
  public Material.Interpolation getInterpolation()
  {
    return Material.Interpolation.values()[nGetInterpolation(getNativeObject())];
  }
  
  public float getMaskThreshold()
  {
    return nGetMaskThreshold(getNativeObject());
  }
  
  public String getName()
  {
    return nGetName(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Material");
    }
    return this.mNativeObject;
  }
  
  public int getParameterCount()
  {
    return nGetParameterCount(getNativeObject());
  }
  
  public List<Material.Parameter> getParameters()
  {
    int i = getParameterCount();
    ArrayList localArrayList = new ArrayList(i);
    if (i > 0) {
      nGetParameters(getNativeObject(), localArrayList, i);
    }
    return localArrayList;
  }
  
  public Material.RefractionMode getRefractionMode()
  {
    return Material.RefractionMode.values()[nGetRefractionMode(getNativeObject())];
  }
  
  public Material.RefractionType getRefractionType()
  {
    return Material.RefractionType.values()[nGetRefractionType(getNativeObject())];
  }
  
  public Set<VertexBuffer.VertexAttribute> getRequiredAttributes()
  {
    if (this.mRequiredAttributes == null)
    {
      int j = nGetRequiredAttributes(getNativeObject());
      this.mRequiredAttributes = EnumSet.noneOf(VertexBuffer.VertexAttribute.class);
      VertexBuffer.VertexAttribute[] arrayOfVertexAttribute = VertexBuffer.VertexAttribute.values();
      int i = 0;
      while (i < arrayOfVertexAttribute.length)
      {
        if ((1 << i & j) != 0) {
          this.mRequiredAttributes.add(arrayOfVertexAttribute[i]);
        }
        i += 1;
      }
      this.mRequiredAttributes = Collections.unmodifiableSet(this.mRequiredAttributes);
    }
    return this.mRequiredAttributes;
  }
  
  int getRequiredAttributesAsInt()
  {
    return nGetRequiredAttributes(getNativeObject());
  }
  
  public Material.Shading getShading()
  {
    return Material.Shading.values()[nGetShading(getNativeObject())];
  }
  
  public float getSpecularAntiAliasingThreshold()
  {
    return nGetSpecularAntiAliasingThreshold(getNativeObject());
  }
  
  public float getSpecularAntiAliasingVariance()
  {
    return nGetSpecularAntiAliasingVariance(getNativeObject());
  }
  
  public Material.VertexDomain getVertexDomain()
  {
    return Material.VertexDomain.values()[nGetVertexDomain(getNativeObject())];
  }
  
  public boolean hasParameter(@NonNull String paramString)
  {
    return nHasParameter(getNativeObject(), paramString);
  }
  
  public boolean isColorWriteEnabled()
  {
    return nIsColorWriteEnabled(getNativeObject());
  }
  
  public boolean isDepthCullingEnabled()
  {
    return nIsDepthCullingEnabled(getNativeObject());
  }
  
  public boolean isDepthWriteEnabled()
  {
    return nIsDepthWriteEnabled(getNativeObject());
  }
  
  public boolean isDoubleSided()
  {
    return nIsDoubleSided(getNativeObject());
  }
  
  public void setDefaultParameter(@NonNull String paramString, float paramFloat)
  {
    this.mDefaultInstance.setParameter(paramString, paramFloat);
  }
  
  public void setDefaultParameter(@NonNull String paramString, float paramFloat1, float paramFloat2)
  {
    this.mDefaultInstance.setParameter(paramString, paramFloat1, paramFloat2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mDefaultInstance.setParameter(paramString, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setDefaultParameter(@NonNull String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mDefaultInstance.setParameter(paramString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void setDefaultParameter(@NonNull String paramString, int paramInt)
  {
    this.mDefaultInstance.setParameter(paramString, paramInt);
  }
  
  public void setDefaultParameter(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    this.mDefaultInstance.setParameter(paramString, paramInt1, paramInt2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mDefaultInstance.setParameter(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void setDefaultParameter(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDefaultInstance.setParameter(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull Colors.RgbType paramRgbType, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mDefaultInstance.setParameter(paramString, paramRgbType, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull Colors.RgbaType paramRgbaType, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mDefaultInstance.setParameter(paramString, paramRgbaType, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull MaterialInstance.BooleanElement paramBooleanElement, @NonNull @Size(min=1L) boolean[] paramArrayOfBoolean, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    this.mDefaultInstance.setParameter(paramString, paramBooleanElement, paramArrayOfBoolean, paramInt1, paramInt2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull MaterialInstance.FloatElement paramFloatElement, @NonNull @Size(min=1L) float[] paramArrayOfFloat, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    this.mDefaultInstance.setParameter(paramString, paramFloatElement, paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull MaterialInstance.IntElement paramIntElement, @NonNull @Size(min=1L) int[] paramArrayOfInt, @IntRange(from=0L) int paramInt1, @IntRange(from=1L) int paramInt2)
  {
    this.mDefaultInstance.setParameter(paramString, paramIntElement, paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, @NonNull Texture paramTexture, @NonNull TextureSampler paramTextureSampler)
  {
    this.mDefaultInstance.setParameter(paramString, paramTexture, paramTextureSampler);
  }
  
  public void setDefaultParameter(@NonNull String paramString, boolean paramBoolean)
  {
    this.mDefaultInstance.setParameter(paramString, paramBoolean);
  }
  
  public void setDefaultParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mDefaultInstance.setParameter(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void setDefaultParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mDefaultInstance.setParameter(paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void setDefaultParameter(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.mDefaultInstance.setParameter(paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Material
 * JD-Core Version:    0.7.0.1
 */