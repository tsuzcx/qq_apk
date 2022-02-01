package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LayoutPreLoader
{
  private static volatile LayoutPreLoader a;
  private static final Map<Integer, RFPreloadContextHelper> b = new ConcurrentHashMap();
  private static final int d = QCirclePluginConfig.a().L();
  private WeakReference<Activity> c;
  
  private LayoutPreLoader()
  {
    QCircleApplication.APP.registerActivityLifecycleCallbacks(new LayoutPreLoader.1(this));
  }
  
  public static LayoutPreLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new LayoutPreLoader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private RFPreloadContextHelper a(int paramInt)
  {
    RFPreloadContextHelper localRFPreloadContextHelper2 = (RFPreloadContextHelper)b.get(Integer.valueOf(paramInt));
    RFPreloadContextHelper localRFPreloadContextHelper1 = localRFPreloadContextHelper2;
    if (localRFPreloadContextHelper2 == null)
    {
      WeakReference localWeakReference = this.c;
      localRFPreloadContextHelper1 = localRFPreloadContextHelper2;
      if (localWeakReference != null)
      {
        localRFPreloadContextHelper1 = localRFPreloadContextHelper2;
        if (localWeakReference.get() != null)
        {
          localRFPreloadContextHelper1 = new RFPreloadContextHelper();
          localRFPreloadContextHelper1.a(new RFAsyncLayoutInflater((Context)this.c.get()));
          localRFPreloadContextHelper1.a(new LruCache(50));
          localRFPreloadContextHelper1.a(new ConcurrentHashMap());
          b.put(Integer.valueOf(paramInt), localRFPreloadContextHelper1);
        }
      }
    }
    return localRFPreloadContextHelper1;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView)
  {
    RFPreloadContextHelper localRFPreloadContextHelper = a(paramInt1);
    Object localObject2 = localRFPreloadContextHelper.b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new LruCache(50);
    }
    if (((LruCache)localObject1).get(Integer.valueOf(paramInt2)) == null) {
      localObject2 = new CopyOnWriteArrayList();
    } else {
      localObject2 = (CopyOnWriteArrayList)((LruCache)localObject1).get(Integer.valueOf(paramInt2));
    }
    ((CopyOnWriteArrayList)localObject2).add(paramView);
    ((LruCache)localObject1).put(Integer.valueOf(paramInt2), localObject2);
    localRFPreloadContextHelper.a((LruCache)localObject1);
    paramView = new StringBuilder();
    paramView.append("preInflate success layoutId:");
    paramView.append(paramInt2);
    paramView.append(", cacheSize:");
    paramView.append(((CopyOnWriteArrayList)localObject2).size());
    QLog.d("LayoutPreLoader", 1, paramView.toString());
  }
  
  private void a(int paramInt1, int paramInt2, LayoutPreLoader.RequestPreloadViewListener paramRequestPreloadViewListener)
  {
    if (paramRequestPreloadViewListener == null) {
      return;
    }
    RFPreloadContextHelper localRFPreloadContextHelper = a(paramInt1);
    if ((localRFPreloadContextHelper != null) && (localRFPreloadContextHelper.c() != null))
    {
      Object localObject2 = (CopyOnWriteArrayList)localRFPreloadContextHelper.c().get(Integer.valueOf(paramInt2));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new CopyOnWriteArrayList();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("register: hashCode:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" layoutId:");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d("LayoutPreLoader", 1, ((StringBuilder)localObject2).toString());
      ((CopyOnWriteArrayList)localObject1).add(new WeakReference(paramRequestPreloadViewListener));
      localRFPreloadContextHelper.c().put(Integer.valueOf(paramInt2), localObject1);
      return;
    }
    QLog.e("LayoutPreLoader", 1, "init contextHelper error");
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = (RFPreloadContextHelper)((Map)localObject).get(Integer.valueOf(paramActivity.hashCode()));
      if (localObject != null)
      {
        localObject = ((RFPreloadContextHelper)localObject).b();
        if (localObject != null) {
          ((LruCache)localObject).evictAll();
        }
        b.remove(Integer.valueOf(paramActivity.hashCode()));
      }
    }
  }
  
  private void a(View paramView, ViewGroup paramViewGroup, ViewStub paramViewStub)
  {
    int i = paramViewGroup.indexOfChild(paramViewStub);
    paramViewGroup.removeViewInLayout(paramViewStub);
    paramViewStub = paramViewStub.getLayoutParams();
    if (paramViewStub != null)
    {
      paramViewGroup.addView(paramView, i, paramViewStub);
      return;
    }
    paramViewGroup.addView(paramView, i);
  }
  
  private void a(ViewStub paramViewStub, View paramView, LayoutPreLoader.RequestPreloadViewListener paramRequestPreloadViewListener)
  {
    if ((paramView != null) && ((paramViewStub.getParent() instanceof ViewGroup)))
    {
      if (paramViewStub.getInflatedId() != -1) {
        paramView.setId(paramViewStub.getInflatedId());
      }
      a(paramView, (ViewGroup)paramViewStub.getParent(), paramViewStub);
      if (paramRequestPreloadViewListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestPreloadViewSuccess: viewStub.getLayoutResource:");
        localStringBuilder.append(paramViewStub.getLayoutResource());
        QLog.d("LayoutPreLoader", 1, localStringBuilder.toString());
        paramRequestPreloadViewListener.onPreloadResult(paramView);
      }
    }
  }
  
  private LayoutPreLoader.RequestPreloadViewListener b(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1);
    if (localObject1 != null)
    {
      if (((RFPreloadContextHelper)localObject1).c() == null) {
        return null;
      }
      localObject1 = (CopyOnWriteArrayList)((RFPreloadContextHelper)localObject1).c().get(Integer.valueOf(paramInt2));
      if (localObject1 != null)
      {
        if (((CopyOnWriteArrayList)localObject1).size() == 0) {
          return null;
        }
        do
        {
          Object localObject2 = (WeakReference)((CopyOnWriteArrayList)localObject1).remove(0);
          if (localObject2 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("headListener is null, layoutId");
            ((StringBuilder)localObject1).append(paramInt2);
            QLog.e("LayoutPreLoader", 1, ((StringBuilder)localObject1).toString());
            return null;
          }
          localObject2 = (LayoutPreLoader.RequestPreloadViewListener)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            return localObject2;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("headListener is release, layoutId:");
          ((StringBuilder)localObject2).append(paramInt2);
          QLog.e("LayoutPreLoader", 1, ((StringBuilder)localObject2).toString());
        } while (((CopyOnWriteArrayList)localObject1).size() > 0);
      }
    }
    return null;
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = a(paramContext.hashCode());
    if ((paramContext != null) && (paramContext.b() != null) && (paramContext.b().get(Integer.valueOf(paramInt)) != null) && (((CopyOnWriteArrayList)paramContext.b().get(Integer.valueOf(paramInt))).size() > 0)) {
      return (View)((CopyOnWriteArrayList)paramContext.b().get(Integer.valueOf(paramInt))).remove(0);
    }
    return null;
  }
  
  @Deprecated
  public View a(ViewStub paramViewStub)
  {
    View localView = a(paramViewStub.getContext(), paramViewStub.getLayoutResource());
    if ((localView != null) && ((paramViewStub.getParent() instanceof ViewGroup)))
    {
      if (paramViewStub.getInflatedId() != -1) {
        localView.setId(paramViewStub.getInflatedId());
      }
      a(localView, (ViewGroup)paramViewStub.getParent(), paramViewStub);
      return localView;
    }
    return paramViewStub.inflate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!QCirclePluginConfig.a().k()) {
      return;
    }
    RFPreloadContextHelper localRFPreloadContextHelper = a(paramInt1);
    if (localRFPreloadContextHelper != null)
    {
      if (localRFPreloadContextHelper.a() == null) {
        return;
      }
      localRFPreloadContextHelper.a().a(paramInt2, null, new LayoutPreLoader.2(this, paramInt1, paramInt2));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = Math.min(paramInt3, 10);
    int i;
    do
    {
      a(paramInt1, paramInt2);
      i = paramInt3 - 1;
      paramInt3 = i;
    } while (i > 0);
  }
  
  public void a(int paramInt1, Class<? extends BaseWidgetView> paramClass, int paramInt2)
  {
    try
    {
      int i = ((BaseWidgetView)paramClass.getConstructor(new Class[] { Context.class, Integer.class }).newInstance(new Object[] { QCircleApplication.APP, Integer.valueOf(-1) })).getLayoutId();
      if (i == 0) {
        return;
      }
      a(paramInt1, i, paramInt2);
      return;
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      if (!QCircleApplication.isRDMVersion())
      {
        paramClass.printStackTrace();
        return;
      }
      throw new RuntimeException("if you want to preload class extends BaseWidgetView, please override constructor BaseWidgetView(@NonNull Context context, Integer viewType)");
    }
  }
  
  public void a(ViewStub paramViewStub, LayoutPreLoader.RequestPreloadViewListener paramRequestPreloadViewListener)
  {
    if (paramViewStub == null) {
      return;
    }
    Object localObject = a(paramViewStub.getContext(), paramViewStub.getLayoutResource());
    if ((localObject != null) && ((paramViewStub.getParent() instanceof ViewGroup)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadSuccess: layoutId:");
      localStringBuilder.append(paramViewStub.getLayoutResource());
      QLog.d("LayoutPreLoader", 1, localStringBuilder.toString());
      a(paramViewStub, (View)localObject, paramRequestPreloadViewListener);
      return;
    }
    if ((d == 2) && (QCirclePluginConfig.a().k()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not preload start subTread load: layoutId:");
      ((StringBuilder)localObject).append(paramViewStub.getLayoutResource());
      QLog.d("LayoutPreLoader", 1, ((StringBuilder)localObject).toString());
      a(paramViewStub.getContext().hashCode(), paramViewStub.getLayoutResource(), new LayoutPreLoader.ViewStubPreloadViewListener(this, paramViewStub, paramRequestPreloadViewListener));
      a(paramViewStub.getContext().hashCode(), paramViewStub.getLayoutResource());
      return;
    }
    if (paramRequestPreloadViewListener != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not preload: ui thread load: layoutId:");
      ((StringBuilder)localObject).append(paramViewStub.getLayoutResource());
      QLog.d("LayoutPreLoader", 1, ((StringBuilder)localObject).toString());
      paramRequestPreloadViewListener.onPreloadResult(paramViewStub.inflate());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader
 * JD-Core Version:    0.7.0.1
 */