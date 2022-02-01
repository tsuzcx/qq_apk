package com.tencent.av.core;

import android.content.Context;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.so.ResMgr;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVSoProxy;
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
  
  public String getAVMediaEngineSoDir()
  {
    return ResMgr.d();
  }
  
  public String getAVTraeSoDir()
  {
    return ResMgr.c();
  }
  
  public String getAndroidCodecInfo()
  {
    Object localObject2 = AndroidCodec.checkSupportHWCodecAbility("AVSoProxyImpl", this.a);
    Object localObject1 = "";
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (HWCodecAbility)localIterator.next();
        StringBuilder localStringBuilder;
        if ((((HWCodecAbility)localObject2).codecType == 1) && (((HWCodecAbility)localObject2).isHWCodec))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCDEC=1;");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCDEC_MAXW=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxW);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCDEC_MAXH=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxH);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
        }
        else if ((((HWCodecAbility)localObject2).codecType == 2) && (((HWCodecAbility)localObject2).isHWCodec))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCENC=1;");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCENC_MAXW=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxW);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWAVCENC_MAXH=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxH);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
        }
        else if ((((HWCodecAbility)localObject2).codecType == 4) && (((HWCodecAbility)localObject2).isHWCodec))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCDEC=1;");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCDEC_MAXW=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxW);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCDEC_MAXH=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxH);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
        }
        else if ((((HWCodecAbility)localObject2).codecType == 8) && (((HWCodecAbility)localObject2).isHWCodec))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCENC=1;");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCENC_MAXW=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxW);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("HWHEVCENC_MAXH=");
          localStringBuilder.append(((HWCodecAbility)localObject2).maxH);
          localStringBuilder.append(";");
          localObject1 = localStringBuilder.toString();
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("HWAVCENC=0;");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("HWAVCDEC=0;");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("HWHEVCENC=0;");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("HWHEVCDEC=0;");
    localObject2 = ((StringBuilder)localObject2).toString();
    return localObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.AVSoProxyImpl
 * JD-Core Version:    0.7.0.1
 */