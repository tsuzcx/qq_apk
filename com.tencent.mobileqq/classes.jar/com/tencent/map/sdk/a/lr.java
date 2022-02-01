package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.MaskLayer;
import com.tencent.tencentmap.mapsdk.maps.model.MaskLayerOptions;

public final class lr
  implements kz
{
  public pn a;
  public kr b;
  private MaskLayerOptions c;
  private mt d;
  private ko e;
  
  private void e()
  {
    if (this.b.a()) {
      this.b.a(true);
    }
    this.b.b(true);
  }
  
  public final MaskLayerOptions a()
  {
    return this.c;
  }
  
  public final void a(long paramLong)
  {
    mt localmt = this.d;
    if (localmt != null)
    {
      localmt.a(paramLong);
      e();
    }
  }
  
  public final void a(MaskLayerOptions paramMaskLayerOptions)
  {
    this.c = paramMaskLayerOptions;
    b();
    ko localko = this.e;
    Object localObject = this.d;
    if (localObject != null) {
      ((mt)localObject).a(0L);
    }
    localObject = this.a;
    if ((localObject != null) && (paramMaskLayerOptions != null))
    {
      this.c = paramMaskLayerOptions;
      this.e = localko;
      this.d = new mt((pn)localObject, paramMaskLayerOptions);
      if (!this.d.a())
      {
        this.d.b();
        this.d = null;
        return;
      }
      if ((paramMaskLayerOptions != null) && (this.b != null)) {
        if ((paramMaskLayerOptions.getColor() >> 24 & 0xFF) >= 51)
        {
          if (this.b.a()) {
            this.b.a(false);
          }
          this.b.b(false);
        }
        else
        {
          if (this.b.a()) {
            this.b.a(true);
          }
          this.b.b(true);
        }
      }
      new MaskLayer(paramMaskLayerOptions, localko);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    mt localmt = this.d;
    if (localmt != null)
    {
      localmt.a = paramBoolean;
      if (paramBoolean)
      {
        localmt.a();
        return;
      }
      localmt.c();
    }
  }
  
  public final void b()
  {
    mt localmt = this.d;
    if (localmt != null)
    {
      localmt.a(0L);
      e();
    }
  }
  
  public final int c()
  {
    MaskLayerOptions localMaskLayerOptions = this.c;
    if (localMaskLayerOptions == null) {
      return 0;
    }
    return localMaskLayerOptions.getZIndex();
  }
  
  public final boolean d()
  {
    mt localmt = this.d;
    if (localmt == null) {
      return false;
    }
    return localmt.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lr
 * JD-Core Version:    0.7.0.1
 */