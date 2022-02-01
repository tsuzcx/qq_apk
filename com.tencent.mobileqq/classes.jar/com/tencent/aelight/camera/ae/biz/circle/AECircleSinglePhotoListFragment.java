package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class AECircleSinglePhotoListFragment
  extends Fragment
{
  public RecyclerView a;
  public PhotoGridAdapter b = null;
  public AEEditorQcircleBubbleView c = null;
  private FrameLayout d;
  private AECirclePhotoListLogic e;
  private int f;
  private boolean g = false;
  private int h = 0;
  private final Runnable i = new AECircleSinglePhotoListFragment.1(this);
  
  private void d()
  {
    this.d = ((FrameLayout)this.d.findViewById(2063991092));
    this.a = ((RecyclerView)this.d.findViewById(2063991298));
    ((DefaultItemAnimator)this.a.getItemAnimator()).setSupportsChangeAnimations(false);
    this.a.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    this.b = new PhotoGridAdapter(getActivity(), this.a, this.e);
    this.b.a(this.f);
    this.a.setAdapter(this.b);
    this.a.addOnScrollListener(new AECircleSinglePhotoListFragment.2(this));
    e();
  }
  
  private void e()
  {
    if (this.c == null) {
      this.c = new AEEditorQcircleBubbleView(getActivity().getApplicationContext());
    }
  }
  
  private void f()
  {
    AECirclePhotoListLogic localAECirclePhotoListLogic = this.e;
    if (localAECirclePhotoListLogic != null)
    {
      if (localAECirclePhotoListLogic.e == null) {
        return;
      }
      if ((getUserVisibleHint()) && (this.c != null) && (this.f == this.e.e.b) && (!this.e.e.e)) {
        ThreadManager.getUIHandler().post(new AECircleSinglePhotoListFragment.3(this));
      }
    }
  }
  
  public AECircleSinglePhotoListFragment a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public AECircleSinglePhotoListFragment a(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.e = paramAECirclePhotoListLogic;
    return this;
  }
  
  public void a()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.h();
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null)
    {
      AECirclePhotoListLogic localAECirclePhotoListLogic = this.e;
      if (localAECirclePhotoListLogic != null) {
        localPhotoGridAdapter.a(localAECirclePhotoListLogic.d());
      }
      this.b.a(paramList);
      f();
    }
  }
  
  public void b()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.b();
    }
  }
  
  public void b(int paramInt)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.c(paramInt);
    }
  }
  
  public void c()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.b;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.c();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = ((FrameLayout)paramLayoutInflater.inflate(2064056362, paramViewGroup, false));
    d();
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */