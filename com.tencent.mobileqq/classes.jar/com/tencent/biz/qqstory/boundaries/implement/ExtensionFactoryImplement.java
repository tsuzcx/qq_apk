package com.tencent.biz.qqstory.boundaries.implement;

import android.os.Bundle;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.boundaries.extension.QQStoryFriendSettingDelegateExtension;
import com.tencent.biz.qqstory.boundaries.extension.QimMemoryPlayMode;
import com.tencent.biz.qqstory.boundaries.extension.config.QQStoryConfigServletHandlerExt;
import com.tencent.biz.qqstory.model.QQStoryConfigServletHandler;
import com.tencent.biz.qqstory.playmode.child.QimMemoryPlayModeDelegate;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionFactoryImplement
{
  public static ConcurrentHashMap a = new ConcurrentHashMap();
  public static ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    a.put(QQStoryFriendSettingDelegate.class, QQStoryFriendSettingDelegateExtension.class);
    a.put(QimMemoryPlayModeDelegate.class, QimMemoryPlayMode.class);
    b.put(QQStoryConfigServletHandler.class, QQStoryConfigServletHandlerExt.class);
  }
  
  public static Object a(Class paramClass1, Class paramClass2, Object... paramVarArgs)
  {
    try
    {
      if (paramClass1.equals(QQStoryFriendSettingDelegate.class)) {
        return paramClass2.cast(new QQStoryFriendSettingDelegateExtension());
      }
      if (paramClass1.equals(QimMemoryPlayModeDelegate.class))
      {
        Object localObject = paramClass2.cast(new QimMemoryPlayMode(Integer.parseInt((String)paramVarArgs[0]), (StoryVideoPlayer)paramVarArgs[1], (VideoPlayerPagerAdapter)paramVarArgs[2], (Bundle)paramVarArgs[3]));
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      SLog.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass1 = (Class)a.get(paramClass1);
        if (paramClass1 != null)
        {
          if (KeepConstructor.class.isAssignableFrom(paramClass1)) {
            break label158;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass1.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass1)
      {
        SLog.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return NullableObjectFactoryImplement.a(paramClass2);
    }
    label158:
    paramClass1 = NullableObjectFactoryImplement.a(paramClass1, paramVarArgs);
    return paramClass1;
  }
  
  public static Object a(Class paramClass, Object... paramVarArgs)
  {
    if (!KeepConstructor.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (KeepConstructor.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      SLog.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return NullableObjectFactoryImplement.a(paramClass, paramVarArgs);
    label124:
    Object localObject = NullableObjectFactoryImplement.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.ExtensionFactoryImplement
 * JD-Core Version:    0.7.0.1
 */