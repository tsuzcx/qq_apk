package com.tencent.biz.expand.flutter.router;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/router/RouterManager;", "", "()V", "mIsInitial", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNativeRouters", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/expand/flutter/router/BaseRouter;", "Lkotlin/collections/HashMap;", "addNativeRouter", "", "addRouter", "router", "getIsRouterInitial", "", "getRouter", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RouterManager
{
  public static final RouterManager.Companion a;
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RouterManager.Companion.instance.2.INSTANCE);
  private HashMap<String, BaseRouter> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandFlutterRouterRouterManager$Companion = new RouterManager.Companion(null);
  }
  
  @JvmStatic
  @NotNull
  public static final RouterManager a()
  {
    return jdField_a_of_type_ComTencentBizExpandFlutterRouterRouterManager$Companion.a();
  }
  
  private final void a(BaseRouter paramBaseRouter)
  {
    if (TextUtils.isEmpty((CharSequence)paramBaseRouter.a())) {
      QLog.d("RouterManager", 1, "add router name is empty");
    }
    while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramBaseRouter.a())) {
      return;
    }
    ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(paramBaseRouter.a(), paramBaseRouter);
  }
  
  @Nullable
  public final BaseRouter a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Map localMap = (Map)this.jdField_a_of_type_JavaUtilHashMap;
      if (localMap == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      }
      if (localMap.containsKey(paramString)) {}
    }
    else
    {
      return null;
    }
    return (BaseRouter)((Map)this.jdField_a_of_type_JavaUtilHashMap).get(paramString);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a((BaseRouter)new ExpandRouter());
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.router.RouterManager
 * JD-Core Version:    0.7.0.1
 */