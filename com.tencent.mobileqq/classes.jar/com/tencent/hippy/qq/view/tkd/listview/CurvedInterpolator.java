package com.tencent.hippy.qq.view.tkd.listview;

import android.view.animation.Interpolator;

public class CurvedInterpolator
  implements Interpolator
{
  public static final int ease_in = 0;
  public static final int ease_in_android = 3;
  public static final int ease_out = 1;
  public static final int ease_out_android = 2;
  private static final float[] mX_easein = { 0.0F, 0.09829712F, 0.1875488F, 0.2686707F, 0.3425781F, 0.4101868F, 0.4724121F, 0.5301697F, 0.584375F, 0.6359437F, 0.685791F, 0.7348328F, 0.7839844F, 0.834161F, 0.8862793F, 0.9412537F, 1.0F };
  private static final float[] mX_easein_android;
  private static final float[] mX_easeout = { 0.0F, 0.0395752F, 0.0782422F, 0.1168506F, 0.15625F, 0.19729F, 0.2408203F, 0.2876904F, 0.33875F, 0.3948486F, 0.4568359F, 0.5255615F, 0.601875F, 0.686626F, 0.7806641F, 0.8848389F, 1.0F };
  private static final float[] mX_easeout_android;
  private static final float[] mY_easein = { 0.0F, 0.01139526F, 0.02553711F, 0.04329712F, 0.06554688F, 0.09315796F, 0.127002F, 0.1679504F, 0.216875F, 0.2746472F, 0.3421387F, 0.4202209F, 0.5097656F, 0.6116443F, 0.726729F, 0.8558899F, 1.0F };
  private static final float[] mY_easein_android;
  private static final float[] mY_easeout = { 0.0F, 0.1117554F, 0.2181055F, 0.3188013F, 0.4135938F, 0.5022339F, 0.5844727F, 0.660061F, 0.72875F, 0.7902905F, 0.8444336F, 0.8909302F, 0.9295313F, 0.9599878F, 0.9820508F, 0.9954712F, 1.0F };
  private static final float[] mY_easeout_android;
  private float[] mX;
  private float[] mY;
  
  static
  {
    mX_easeout_android = new float[] { 0.0F, 0.03320313F, 0.059375F, 0.08085938F, 0.1F, 0.1191406F, 0.140625F, 0.1667969F, 0.2F, 0.2425781F, 0.296875F, 0.3291504F, 0.3652344F, 0.4054199F, 0.45F, 0.4992676F, 0.5535156F, 0.6130371F, 0.678125F, 0.7490723F, 0.8261719F, 0.9097168F, 1.0F };
    mY_easeout_android = new float[] { 0.0F, 0.1265869F, 0.2439453F, 0.3522217F, 0.4515625F, 0.5421143F, 0.6240234F, 0.6974365F, 0.7625F, 0.8193604F, 0.8681641F, 0.8895904F, 0.9090576F, 0.9265839F, 0.9421875F, 0.9558868F, 0.9677002F, 0.9776459F, 0.9857422F, 0.9920074F, 0.99646F, 0.999118F, 1.0F };
    mX_easein_android = new float[] { 0.0F, 0.090283F, 0.1738281F, 0.2509278F, 0.321875F, 0.3869629F, 0.4464844F, 0.5007324F, 0.55F, 0.5945801F, 0.6347656F, 0.6708496F, 0.703125F, 0.7574219F, 0.8F, 0.8332031F, 0.859375F, 0.8808594F, 0.9F, 0.9191406F, 0.940625F, 0.9667969F, 1.0F };
    mY_easein_android = new float[] { 0.0F, 0.0008819581F, 0.003540039F, 0.007992555F, 0.01425781F, 0.02235413F, 0.03229981F, 0.04411316F, 0.0578125F, 0.07341614F, 0.09094238F, 0.1104096F, 0.1318359F, 0.1806397F, 0.2375F, 0.3025635F, 0.3759766F, 0.4578857F, 0.5484375F, 0.6477783F, 0.756055F, 0.8734131F, 1.0F };
  }
  
  public CurvedInterpolator(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mX = mX_easein;
      this.mY = mY_easein;
      return;
    case 1: 
      this.mX = mX_easeout;
      this.mY = mY_easeout;
      return;
    case 3: 
      this.mX = mX_easein_android;
      this.mY = mY_easein_android;
      return;
    }
    this.mX = mX_easeout_android;
    this.mY = mY_easeout_android;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = 1.0F;
    if (paramFloat <= 0.0F) {
      f = 0.0F;
    }
    while (paramFloat >= 1.0F) {
      return f;
    }
    int j = 0;
    int i = this.mX.length - 1;
    if (i - j > 1)
    {
      int k = (j + i) / 2;
      if (paramFloat < this.mX[k]) {
        i = k;
      }
      for (;;)
      {
        break;
        j = k;
      }
    }
    f = this.mX[i] - this.mX[j];
    if (f == 0.0F) {
      return this.mY[j];
    }
    paramFloat = (paramFloat - this.mX[j]) / f;
    f = this.mY[j];
    return paramFloat * (this.mY[i] - f) + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.CurvedInterpolator
 * JD-Core Version:    0.7.0.1
 */