package com.tencent.TMG.channel;

import com.tencent.TMG.logger.AVLoggerChooser;

public class AVChannelManager
{
  public static final int IMChannelTypeIMSDK = 0;
  public static final int IMChannelTypeImplementExternal = 2;
  public static final int IMChannelTypeImplementInternal = 1;
  private static int channelType;
  private static AVAppChannel sAppChannel;
  
  public static AVAppChannel getAppChannel()
  {
    try
    {
      Object localObject1;
      if (sAppChannel != null)
      {
        localObject1 = sAppChannel;
        return localObject1;
      }
      Object localObject5 = null;
      AVAppChannel localAVAppChannel;
      try
      {
        localObject1 = Class.forName("com.tencent.TMG.channel.IMAppChannel");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        localAVAppChannel = null;
      }
      if (localAVAppChannel == null) {
        return null;
      }
      try
      {
        localAVAppChannel = (AVAppChannel)localAVAppChannel.newInstance();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        Object localObject2 = localObject5;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        localObject3 = localObject5;
      }
      sAppChannel = (AVAppChannel)localObject3;
      Object localObject3 = sAppChannel;
      return localObject3;
    }
    finally {}
  }
  
  public static int getIMChannelType()
  {
    try
    {
      int i = channelType;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setAppChannel(AVAppChannel paramAVAppChannel)
  {
    try
    {
      sAppChannel = paramAVAppChannel;
      return;
    }
    finally
    {
      paramAVAppChannel = finally;
      throw paramAVAppChannel;
    }
  }
  
  public static void setIMChannelType(int paramInt)
  {
    for (;;)
    {
      try
      {
        channelType = paramInt;
        if (channelType == 0)
        {
          bool = true;
          AVLoggerChooser.setUseImsdk(bool);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public static void setSsoHost(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.AVChannelManager
 * JD-Core Version:    0.7.0.1
 */