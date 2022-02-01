package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.boundaries.extension.QQStoryFriendSettingDelegateExtension;
import com.tencent.biz.qqstory.boundaries.extension.config.QQStoryConfigServletHandlerExt;
import com.tencent.biz.qqstory.model.QQStoryConfigServletHandler;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionFactoryImplement
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(QQStoryFriendSettingDelegate.class, QQStoryFriendSettingDelegateExtension.class);
    b.put(QQStoryConfigServletHandler.class, QQStoryConfigServletHandlerExt.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(QQStoryFriendSettingDelegate.class))
      {
        Object localObject = paramClass1.cast(new QQStoryFriendSettingDelegateExtension());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      SLog.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (KeepConstructor.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        SLog.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return NullableObjectFactoryImplement.a(paramClass1);
    }
    label110:
    paramClass = NullableObjectFactoryImplement.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.ExtensionFactoryImplement
 * JD-Core Version:    0.7.0.1
 */