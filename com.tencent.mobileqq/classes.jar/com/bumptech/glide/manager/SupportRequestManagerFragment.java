package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment
  extends Fragment
{
  private final ActivityFragmentLifecycle a;
  private final RequestManagerTreeNode b = new SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode(this);
  private final Set<SupportRequestManagerFragment> c = new HashSet();
  @Nullable
  private SupportRequestManagerFragment d;
  @Nullable
  private RequestManager e;
  @Nullable
  private Fragment f;
  
  public SupportRequestManagerFragment()
  {
    this(new ActivityFragmentLifecycle());
  }
  
  @SuppressLint({"ValidFragment"})
  @VisibleForTesting
  public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle paramActivityFragmentLifecycle)
  {
    this.a = paramActivityFragmentLifecycle;
  }
  
  private void a(@NonNull FragmentActivity paramFragmentActivity)
  {
    d();
    this.d = Glide.a(paramFragmentActivity).g().b(paramFragmentActivity);
    if (!equals(this.d)) {
      this.d.a(this);
    }
  }
  
  private void a(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.c.add(paramSupportRequestManagerFragment);
  }
  
  private void b(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.c.remove(paramSupportRequestManagerFragment);
  }
  
  private void d()
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = this.d;
    if (localSupportRequestManagerFragment != null)
    {
      localSupportRequestManagerFragment.b(this);
      this.d = null;
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
    this.e = paramRequestManager;
  }
  
  @Nullable
  public RequestManager b()
  {
    return this.e;
  }
  
  @NonNull
  public RequestManagerTreeNode c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.SupportRequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */