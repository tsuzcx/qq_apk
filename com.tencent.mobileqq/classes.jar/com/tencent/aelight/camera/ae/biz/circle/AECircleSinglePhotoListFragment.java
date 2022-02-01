package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class AECircleSinglePhotoListFragment
  extends Fragment
{
  private int jdField_a_of_type_Int;
  public RecyclerView a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private AECirclePhotoListLogic jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
  public PhotoGridAdapter a;
  public AEEditorQcircleBubbleView a;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AECircleSinglePhotoListFragment.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  public AECircleSinglePhotoListFragment()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2064122211));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2064122484));
    ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter = new PhotoGridAdapter(getActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AECircleSinglePhotoListFragment.2(this));
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(getActivity().getApplicationContext());
    }
  }
  
  private void f()
  {
    AECirclePhotoListLogic localAECirclePhotoListLogic = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
    if (localAECirclePhotoListLogic != null)
    {
      if (localAECirclePhotoListLogic.a == null) {
        return;
      }
      if ((getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.b) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.jdField_a_of_type_Boolean)) {
        ThreadManager.getUIHandler().post(new AECircleSinglePhotoListFragment.3(this));
      }
    }
  }
  
  public AECircleSinglePhotoListFragment a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public AECircleSinglePhotoListFragment a(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    return this;
  }
  
  public void a()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.c();
    }
  }
  
  public void a(int paramInt)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.b(paramInt);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    PhotoGridAdapter localPhotoGridAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    if (localPhotoGridAdapter != null)
    {
      AECirclePhotoListLogic localAECirclePhotoListLogic = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
      if (localAECirclePhotoListLogic != null) {
        localPhotoGridAdapter.a(localAECirclePhotoListLogic.a());
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter.a(paramList);
      f();
    }
  }
  
  public void b()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.a();
    }
  }
  
  public void c()
  {
    PhotoGridAdapter localPhotoGridAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    if (localPhotoGridAdapter != null) {
      localPhotoGridAdapter.b();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.inflate(2064318495, paramViewGroup, false));
    d();
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */