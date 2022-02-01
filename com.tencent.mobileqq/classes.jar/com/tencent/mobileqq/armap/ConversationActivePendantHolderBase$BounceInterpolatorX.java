package com.tencent.mobileqq.armap;

import android.view.animation.Interpolator;

class ConversationActivePendantHolderBase$BounceInterpolatorX
  implements Interpolator
{
  ConversationActivePendantHolderBase$BounceInterpolatorX(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase) {}
  
  public float getInterpolation(float paramFloat)
  {
    double d = paramFloat;
    if (d < 0.2094D)
    {
      Double.isNaN(d);
      d -= 0.18D;
      return (float)(-34.0D * d * d + 1.08D);
    }
    if (d < 0.404D)
    {
      Double.isNaN(d);
      d -= 0.34D;
      return (float)(5.9D * d * d + 0.95D);
    }
    if (d < 0.6045D)
    {
      Double.isNaN(d);
      d -= 0.53D;
      return (float)(-3.0D * d * d + 1.02D);
    }
    if (d < 0.8064D)
    {
      Double.isNaN(d);
      d -= 0.72D;
      return (float)(d * d + 0.99D);
    }
    Double.isNaN(d);
    d -= 0.915D;
    return (float)(-0.3D * d * d + 1.001D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase.BounceInterpolatorX
 * JD-Core Version:    0.7.0.1
 */