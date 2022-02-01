package com.tencent.luggage.wxa.fy;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

class q$b
{
  @NonNull
  public final SurfaceTexture.OnFrameAvailableListener a;
  @Nullable
  public final Handler b;
  
  public q$b(@NonNull SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, @Nullable Handler paramHandler)
  {
    this.a = paramOnFrameAvailableListener;
    this.b = paramHandler;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (b)paramObject;
      return this.a.equals(paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.q.b
 * JD-Core Version:    0.7.0.1
 */