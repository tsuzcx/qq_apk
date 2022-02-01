package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import java.lang.reflect.Constructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbsApi
{
  private static final String CLASS_NAME_CONFIG_STUB = "com.tencent.android.gldrawable.ConfigStubImpl";
  private static final String CLASS_NAME_FACTORY_STUB = "com.tencent.android.gldrawable.FactoryStubImpl";
  private static final String CLASS_NAME_LOADER_IMPL = "com.tencent.android.gldrawable.api.impl.GLDLoaderImpl";
  private static final IGLDrawableLoader EMPTY_LOADER = new EmptyLoader();
  private ClassLoader dynamicClassLoader = null;
  private final IGLDrawableLoader loader;
  
  protected AbsApi()
  {
    IGLDrawableLoader localIGLDrawableLoader;
    try
    {
      localIGLDrawableLoader = (IGLDrawableLoader)AbsApi.class.getClassLoader().loadClass("com.tencent.android.gldrawable.api.impl.GLDLoaderImpl").newInstance();
    }
    catch (Exception localException)
    {
      localIGLDrawableLoader = EMPTY_LOADER;
      localIGLDrawableLoader.getLoaderUtils().getReport().logE("find no loader", localException);
    }
    this.loader = localIGLDrawableLoader;
  }
  
  @Nullable
  protected IConfigStub createDynamicConfig()
  {
    Object localObject2;
    try
    {
      Object localObject1 = this.dynamicClassLoader.loadClass("com.tencent.android.gldrawable.ConfigStubImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    return (IConfigStub)localObject2;
  }
  
  @Nullable
  protected IFactoryStub createDynamicFactory()
  {
    Object localObject2;
    try
    {
      Object localObject1 = this.dynamicClassLoader.loadClass("com.tencent.android.gldrawable.FactoryStubImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    return (IFactoryStub)localObject2;
  }
  
  @NotNull
  protected IConfigStub createStaticConfig()
  {
    try
    {
      IConfigStub localIConfigStub = (IConfigStub)Class.forName("com.tencent.android.gldrawable.ConfigStubImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
      return localIConfigStub;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  @NotNull
  protected IFactoryStub createStaticFactory()
  {
    try
    {
      IFactoryStub localIFactoryStub = (IFactoryStub)Class.forName("com.tencent.android.gldrawable.FactoryStubImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
      return localIFactoryStub;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public IGLDrawableLoader getLoader()
  {
    return this.loader;
  }
  
  protected boolean isDynamicReady()
  {
    return this.dynamicClassLoader != null;
  }
  
  protected void setDynamicReady(ClassLoader paramClassLoader)
  {
    this.dynamicClassLoader = paramClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AbsApi
 * JD-Core Version:    0.7.0.1
 */