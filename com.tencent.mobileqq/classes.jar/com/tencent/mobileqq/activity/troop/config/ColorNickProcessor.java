package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.api.config.AbsTroopHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.IColorNickObserver;
import com.tencent.mobileqq.vas.ColorNickManager;

public class ColorNickProcessor
  extends AbsTroopHandlerProcessor
  implements IColorNickObserver
{
  public int a(byte[] paramArrayOfByte)
  {
    return ColorNickManager.a(paramArrayOfByte);
  }
  
  @NonNull
  public String a()
  {
    return "ColorNickProcessor";
  }
  
  public String a(ByteStringMicro paramByteStringMicro)
  {
    return ColorNickManager.a(paramByteStringMicro);
  }
  
  public String a(String paramString)
  {
    return ColorNickManager.b(paramString);
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return ColorNickManager.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.ColorNickProcessor
 * JD-Core Version:    0.7.0.1
 */