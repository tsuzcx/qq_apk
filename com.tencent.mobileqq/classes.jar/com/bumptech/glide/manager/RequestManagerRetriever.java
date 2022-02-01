package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever
  implements Handler.Callback
{
  private static final RequestManagerRetriever.RequestManagerFactory i = new RequestManagerRetriever.1();
  @VisibleForTesting
  final Map<android.app.FragmentManager, RequestManagerFragment> a = new HashMap();
  @VisibleForTesting
  final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> b = new HashMap();
  private volatile RequestManager c;
  private final Handler d;
  private final RequestManagerRetriever.RequestManagerFactory e;
  private final ArrayMap<View, android.support.v4.app.Fragment> f = new ArrayMap();
  private final ArrayMap<View, android.app.Fragment> g = new ArrayMap();
  private final Bundle h = new Bundle();
  
  public RequestManagerRetriever(@Nullable RequestManagerRetriever.RequestManagerFactory paramRequestManagerFactory)
  {
    if (paramRequestManagerFactory == null) {
      paramRequestManagerFactory = i;
    }
    this.e = paramRequestManagerFactory;
    this.d = new Handler(Looper.getMainLooper(), this);
  }
  
  @Deprecated
  @NonNull
  private RequestManager a(@NonNull Context paramContext, @NonNull android.app.FragmentManager paramFragmentManager, @Nullable android.app.Fragment paramFragment, boolean paramBoolean)
  {
    RequestManagerFragment localRequestManagerFragment = a(paramFragmentManager, paramFragment, paramBoolean);
    paramFragment = localRequestManagerFragment.b();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = Glide.a(paramContext);
      paramFragmentManager = this.e.a(paramFragmentManager, localRequestManagerFragment.a(), localRequestManagerFragment.c(), paramContext);
      localRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  @NonNull
  private RequestManager a(@NonNull Context paramContext, @NonNull android.support.v4.app.FragmentManager paramFragmentManager, @Nullable android.support.v4.app.Fragment paramFragment, boolean paramBoolean)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = a(paramFragmentManager, paramFragment, paramBoolean);
    paramFragment = localSupportRequestManagerFragment.b();
    paramFragmentManager = paramFragment;
    if (paramFragment == null)
    {
      paramFragmentManager = Glide.a(paramContext);
      paramFragmentManager = this.e.a(paramFragmentManager, localSupportRequestManagerFragment.a(), localSupportRequestManagerFragment.c(), paramContext);
      localSupportRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  @NonNull
  private RequestManagerFragment a(@NonNull android.app.FragmentManager paramFragmentManager, @Nullable android.app.Fragment paramFragment, boolean paramBoolean)
  {
    RequestManagerFragment localRequestManagerFragment2 = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    RequestManagerFragment localRequestManagerFragment1 = localRequestManagerFragment2;
    if (localRequestManagerFragment2 == null)
    {
      localRequestManagerFragment2 = (RequestManagerFragment)this.a.get(paramFragmentManager);
      localRequestManagerFragment1 = localRequestManagerFragment2;
      if (localRequestManagerFragment2 == null)
      {
        localRequestManagerFragment1 = new RequestManagerFragment();
        localRequestManagerFragment1.a(paramFragment);
        if (paramBoolean) {
          localRequestManagerFragment1.a().a();
        }
        this.a.put(paramFragmentManager, localRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localRequestManagerFragment1;
  }
  
  @NonNull
  private SupportRequestManagerFragment a(@NonNull android.support.v4.app.FragmentManager paramFragmentManager, @Nullable android.support.v4.app.Fragment paramFragment, boolean paramBoolean)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
    if (localSupportRequestManagerFragment2 == null)
    {
      localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)this.b.get(paramFragmentManager);
      localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
      if (localSupportRequestManagerFragment2 == null)
      {
        localSupportRequestManagerFragment1 = new SupportRequestManagerFragment();
        localSupportRequestManagerFragment1.a(paramFragment);
        if (paramBoolean) {
          localSupportRequestManagerFragment1.a().a();
        }
        this.b.put(paramFragmentManager, localSupportRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localSupportRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return localSupportRequestManagerFragment1;
  }
  
  @NonNull
  private RequestManager b(@NonNull Context paramContext)
  {
    if (this.c == null) {
      try
      {
        if (this.c == null)
        {
          Glide localGlide = Glide.a(paramContext.getApplicationContext());
          this.c = this.e.a(localGlide, new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return this.c;
  }
  
  @TargetApi(17)
  private static void c(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!paramActivity.isDestroyed()) {
        return;
      }
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
  }
  
  private static boolean d(Activity paramActivity)
  {
    return paramActivity.isFinishing() ^ true;
  }
  
  @NonNull
  public RequestManager a(@NonNull Activity paramActivity)
  {
    if (Util.d()) {
      return a(paramActivity.getApplicationContext());
    }
    c(paramActivity);
    return a(paramActivity, paramActivity.getFragmentManager(), null, d(paramActivity));
  }
  
  @NonNull
  public RequestManager a(@NonNull Context paramContext)
  {
    if (paramContext != null)
    {
      if ((Util.c()) && (!(paramContext instanceof Application)))
      {
        if ((paramContext instanceof FragmentActivity)) {
          return a((FragmentActivity)paramContext);
        }
        if ((paramContext instanceof Activity)) {
          return a((Activity)paramContext);
        }
        if ((paramContext instanceof ContextWrapper)) {
          return a(((ContextWrapper)paramContext).getBaseContext());
        }
      }
      return b(paramContext);
    }
    throw new IllegalArgumentException("You cannot start a load on a null Context");
  }
  
  @NonNull
  public RequestManager a(@NonNull FragmentActivity paramFragmentActivity)
  {
    if (Util.d()) {
      return a(paramFragmentActivity.getApplicationContext());
    }
    c(paramFragmentActivity);
    return a(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), null, d(paramFragmentActivity));
  }
  
  @Deprecated
  @NonNull
  RequestManagerFragment b(Activity paramActivity)
  {
    return a(paramActivity.getFragmentManager(), null, d(paramActivity));
  }
  
  @NonNull
  SupportRequestManagerFragment b(FragmentActivity paramFragmentActivity)
  {
    return a(paramFragmentActivity.getSupportFragmentManager(), null, d(paramFragmentActivity));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    Object localObject1 = null;
    boolean bool = true;
    if (j != 1)
    {
      if (j != 2)
      {
        bool = false;
        Object localObject2 = null;
        paramMessage = (Message)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        paramMessage = (android.support.v4.app.FragmentManager)paramMessage.obj;
        localObject1 = this.b.remove(paramMessage);
      }
    }
    else
    {
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      localObject1 = this.a.remove(paramMessage);
    }
    if ((bool) && (localObject1 == null) && (Log.isLoggable("RMRetriever", 5)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to remove expected request manager fragment, manager: ");
      ((StringBuilder)localObject1).append(paramMessage);
      Log.w("RMRetriever", ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.RequestManagerRetriever
 * JD-Core Version:    0.7.0.1
 */