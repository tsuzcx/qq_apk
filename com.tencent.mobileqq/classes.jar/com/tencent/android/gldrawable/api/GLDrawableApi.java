package com.tencent.android.gldrawable.api;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.base.AsyncDrawable;
import com.tencent.android.gldrawable.api.base.InternalApiImpl;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/GLDrawableApi;", "Lcom/tencent/android/gldrawable/api/base/InternalApiImpl;", "()V", "state", "Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "getState", "()Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "state$delegate", "Lkotlin/Lazy;", "asyncFactory", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "failedBlock", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "sucessBlock", "Lkotlin/Function1;", "Lcom/tencent/android/gldrawable/api/IFactoryStub;", "config", "Lcom/tencent/android/gldrawable/api/IConfigStub;", "factory", "State", "api_release"}, k=1, mv={1, 1, 16})
public final class GLDrawableApi
  extends InternalApiImpl
{
  public static final GLDrawableApi INSTANCE = new GLDrawableApi();
  @NotNull
  private static final Lazy state$delegate = LazyKt.lazy((Function0)GLDrawableApi.state.2.INSTANCE);
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final AsyncDrawable asyncFactory(@NotNull Function0<? extends Drawable> paramFunction0, @NotNull Function1<? super IFactoryStub, ? extends Drawable> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "failedBlock");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "sucessBlock");
    AsyncDrawable localAsyncDrawable = new AsyncDrawable();
    localAsyncDrawable.setFailedDrawableBuild(paramFunction0);
    localAsyncDrawable.setTargetDrawableBuild((Function0)new GLDrawableApi.asyncFactory.2(paramFunction1));
    localAsyncDrawable.build();
    return localAsyncDrawable;
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final AsyncDrawable asyncFactory(@NotNull Function1<? super IFactoryStub, ? extends Drawable> paramFunction1)
  {
    return asyncFactory$default(null, paramFunction1, 1, null);
  }
  
  @JvmStatic
  @NotNull
  public static final IConfigStub config()
  {
    INSTANCE.loadDynamicSync$api_release();
    IConfigStub localIConfigStub1 = (IConfigStub)null;
    if (INSTANCE.isDynamicReady()) {
      localIConfigStub1 = INSTANCE.createDynamicConfig();
    }
    IConfigStub localIConfigStub2 = localIConfigStub1;
    if (localIConfigStub1 == null) {
      localIConfigStub2 = INSTANCE.createStaticConfig();
    }
    return localIConfigStub2;
  }
  
  @JvmStatic
  @NotNull
  public static final IFactoryStub factory()
  {
    INSTANCE.loadDynamicSync$api_release();
    IFactoryStub localIFactoryStub1 = (IFactoryStub)null;
    if (INSTANCE.isDynamicReady()) {
      localIFactoryStub1 = INSTANCE.createDynamicFactory();
    }
    IFactoryStub localIFactoryStub2 = localIFactoryStub1;
    if (localIFactoryStub1 == null) {
      localIFactoryStub2 = INSTANCE.createStaticFactory();
    }
    return localIFactoryStub2;
  }
  
  @NotNull
  public final GLDrawableApi.State getState()
  {
    return (GLDrawableApi.State)state$delegate.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.GLDrawableApi
 * JD-Core Version:    0.7.0.1
 */