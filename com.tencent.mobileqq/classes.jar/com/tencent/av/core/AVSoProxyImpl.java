package com.tencent.av.core;

import android.content.Context;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVSoProxy;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AVSoProxyImpl
  implements AVSoProxy
{
  private final Context a;
  
  public AVSoProxyImpl(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public String getAndroidCodecInfo()
  {
    String str = "";
    Object localObject = AndroidCodec.checkSupportHWCodecAbility("AVSoProxyImpl", this.a);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      localObject = str;
      if (!localIterator.hasNext()) {
        break label540;
      }
      localObject = (HWCodecAbility)localIterator.next();
      if ((((HWCodecAbility)localObject).codecType == 1) && (((HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWAVCDEC=1;";
        str = str + "HWAVCDEC_MAXW=" + ((HWCodecAbility)localObject).maxW + ";";
        str = str + "HWAVCDEC_MAXH=" + ((HWCodecAbility)localObject).maxH + ";";
      }
    }
    for (;;)
    {
      break;
      if ((((HWCodecAbility)localObject).codecType == 2) && (((HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWAVCENC=1;";
        str = str + "HWAVCENC_MAXW=" + ((HWCodecAbility)localObject).maxW + ";";
        str = str + "HWAVCENC_MAXH=" + ((HWCodecAbility)localObject).maxH + ";";
      }
      else if ((((HWCodecAbility)localObject).codecType == 4) && (((HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWHEVCDEC=1;";
        str = str + "HWHEVCDEC_MAXW=" + ((HWCodecAbility)localObject).maxW + ";";
        str = str + "HWHEVCDEC_MAXH=" + ((HWCodecAbility)localObject).maxH + ";";
      }
      else if ((((HWCodecAbility)localObject).codecType == 8) && (((HWCodecAbility)localObject).isHWCodec))
      {
        str = str + "HWHEVCENC=1;";
        str = str + "HWHEVCENC_MAXW=" + ((HWCodecAbility)localObject).maxW + ";";
        str = str + "HWHEVCENC_MAXH=" + ((HWCodecAbility)localObject).maxH + ";";
        continue;
        str = "" + "HWAVCENC=0;";
        str = str + "HWAVCDEC=0;";
        str = str + "HWHEVCENC=0;";
        localObject = str + "HWHEVCDEC=0;";
        label540:
        return localObject;
      }
    }
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public String getHardwareDetectSoDir()
  {
    return AVSoUtils.g();
  }
  
  public String getHevcDecSoDir()
  {
    return AVSoUtils.f();
  }
  
  public String getHevcEncSoDir()
  {
    return AVSoUtils.e();
  }
  
  public void updateHevcCodecSoDir() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.core.AVSoProxyImpl
 * JD-Core Version:    0.7.0.1
 */