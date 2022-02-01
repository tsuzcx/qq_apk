package com.tencent.av.config.api;

import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ICodecConfigParser
  extends QRouteApi
{
  public static final int VERSION_1 = 1;
  public static final int VERSION_2 = 2;
  
  public abstract HWCodecAbility getAVCDecoderAbility();
  
  public abstract HWCodecAbility getAVCEncoderAbility();
  
  public abstract HWCodecAbility getHevcDecoderAbility();
  
  public abstract HWCodecAbility getHevcEncoderAbility();
  
  public abstract void init(IConfigParser paramIConfigParser);
  
  public abstract boolean isEnableAsyncApi(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.ICodecConfigParser
 * JD-Core Version:    0.7.0.1
 */