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
      if (!paramClass.equals(QQStoryFriendSettingDelegate.class)) {
        break label30;
      }
      Object localObject = paramClass1.cast(new QQStoryFriendSettingDelegateExtension());
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label23:
      label30:
      label103:
      label117:
      break label23;
    }
    SLog.e("ExtensionFactoryImplement", "parse int exception");
    try
    {
      paramClass = (Class)a.get(paramClass);
      if (paramClass == null) {
        break label117;
      }
      if (KeepConstructor.class.isAssignableFrom(paramClass)) {
        return NullableObjectFactoryImplement.a(paramClass, paramVarArgs);
      }
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("createExtendableObject class ");
      paramVarArgs.append(paramClass.getName());
      paramVarArgs.append(" should have a KeepConstructor interface");
      throw new IllegalArgumentException(paramVarArgs.toString());
    }
    catch (Exception paramClass)
    {
      break label103;
    }
    SLog.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    return NullableObjectFactoryImplement.a(paramClass1);
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (KeepConstructor.class.isAssignableFrom(paramClass)) {}
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass == null) {
        break label96;
      }
      if (KeepConstructor.class.isAssignableFrom(localClass)) {
        return NullableObjectFactoryImplement.a(localClass, paramVarArgs);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createExtendableObject class ");
      localStringBuilder.append(localClass.getName());
      localStringBuilder.append(" should have a KeepConstructor interface");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      label82:
      label96:
      break label82;
    }
    SLog.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    return NullableObjectFactoryImplement.a(paramClass, paramVarArgs);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("createExtendableObject class ");
    paramVarArgs.append(paramClass.getName());
    paramVarArgs.append(" should have a KeepConstructor interface");
    throw new IllegalArgumentException(paramVarArgs.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.ExtensionFactoryImplement
 * JD-Core Version:    0.7.0.1
 */