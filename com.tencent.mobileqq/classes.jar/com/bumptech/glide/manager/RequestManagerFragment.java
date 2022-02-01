package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment
  extends Fragment
{
  private final ActivityFragmentLifecycle a;
  private final RequestManagerTreeNode b = new RequestManagerFragment.FragmentRequestManagerTreeNode(this);
  private final Set<RequestManagerFragment> c = new HashSet();
  @Nullable
  private RequestManager d;
  @Nullable
  private RequestManagerFragment e;
  @Nullable
  private Fragment f;
  
  public RequestManagerFragment()
  {
    this(new ActivityFragmentLifecycle());
  }
  
  @SuppressLint({"ValidFragment"})
  @VisibleForTesting
  RequestManagerFragment(@NonNull ActivityFragmentLifecycle paramActivityFragmentLifecycle)
  {
    this.a = paramActivityFragmentLifecycle;
  }
  
  private void a(@NonNull Activity paramActivity)
  {
    e();
    this.e = Glide.a(paramActivity).g().b(paramActivity);
    if (!equals(this.e)) {
      this.e.a(this);
    }
  }
  
  private void a(RequestManagerFragment paramRequestManagerFragment)
  {
    this.c.add(paramRequestManagerFragment);
  }
  
  private void b(RequestManagerFragment paramRequestManagerFragment)
  {
    this.c.remove(paramRequestManagerFragment);
  }
  
  @TargetApi(17)
  @Nullable
  private Fragment d()
  {
    Fragment localFragment;
    if (Build.VERSION.SDK_INT >= 17) {
      localFragment = getParentFragment();
    } else {
      localFragment = null;
    }
    if (localFragment != null) {
      return localFragment;
    }
    return this.f;
  }
  
  private void e()
  {
    RequestManagerFragment localRequestManagerFragment = this.e;
    if (localRequestManagerFragment != null)
    {
      localRequestManagerFragment.b(this);
      this.e = null;
    }
  }
  
  @NonNull
  ActivityFragmentLifecycle a()
  {
    return this.a;
  }
  
  void a(@Nullable Fragment paramFragment)
  {
    this.f = paramFragment;
    if ((paramFragment != null) && (paramFragment.getActivity() != null)) {
      a(paramFragment.getActivity());
    }
  }
  
  public void a(@Nullable RequestManager paramRequestManager)
  {
    this.d = paramRequestManager;
  }
  
  @Nullable
  public RequestManager b()
  {
    return this.d;
  }
  
  @NonNull
  public RequestManagerTreeNode c()
  {
    return this.b;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      a(paramActivity);
      return;
    }
    catch (IllegalStateException paramActivity)
    {
      if (Log.isLoggable("RMFragment", 5)) {
        Log.w("RMFragment", "Unable to register fragment with root", paramActivity);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
    e();
  }
  
  public void onDetach()
  {
    super.onDetach();
    e();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{parent=");
    localStringBuilder.append(d());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.RequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */