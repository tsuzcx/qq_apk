package com.tencent.luggage.wxa.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

@TargetApi(23)
class d
  extends c
{
  d(i.a parama, o paramo, Context paramContext)
  {
    super(parama, paramo, paramContext);
  }
  
  protected void a(r paramr, StreamConfigurationMap paramStreamConfigurationMap)
  {
    if (paramStreamConfigurationMap.getHighResolutionOutputSizes(256) != null)
    {
      Size[] arrayOfSize = paramStreamConfigurationMap.getHighResolutionOutputSizes(256);
      int j = arrayOfSize.length;
      int i = 0;
      while (i < j)
      {
        Size localSize = arrayOfSize[i];
        paramr.a(new q(localSize.getWidth(), localSize.getHeight()));
        i += 1;
      }
    }
    if ((paramr.c()) || (paramr.b(i()) == null)) {
      super.a(paramr, paramStreamConfigurationMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.d
 * JD-Core Version:    0.7.0.1
 */