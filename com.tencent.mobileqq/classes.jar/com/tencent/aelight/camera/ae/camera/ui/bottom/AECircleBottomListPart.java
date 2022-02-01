package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import java.util.HashMap;

public class AECircleBottomListPart
  extends AEBottomListPart
  implements AEBottomListScrollView.AEEditMaterialSelectedListener
{
  private View jdField_a_of_type_AndroidViewView;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  public AECircleBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private boolean a(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramViewHolder != null)
    {
      bool1 = bool2;
      if (paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData != null)
      {
        bool1 = bool2;
        if (paramInt == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean)) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)this.mRootView.findViewById(2064122583));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setAEEditMaterialSelectedListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new AECircleScaleTransformer.Builder().a(1.0F).b(1.3839F).a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter = new AEBottomListAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(new AECircleBottomListPart.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter);
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2064122281);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a().b(1));
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 113);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 112);
    a();
    c();
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.mPartManager != null)
    {
      if (paramBoolean)
      {
        this.mPartManager.a(327696, new Object[0]);
        return;
      }
      this.mPartManager.a(327689, new Object[0]);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AECircleBottomListPart.2(this));
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if (a(paramViewHolder, paramInt))
    {
      this.jdField_a_of_type_Boolean = false;
      b(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    b(true);
    super.c(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
      if ((paramViewHolder != null) && (!"call_material_id".equals(paramViewHolder.k)))
      {
        this.jdField_b_of_type_Int = paramInt;
        if (a())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ext2", paramViewHolder.k);
          AEReportUtils.b(2, localHashMap);
        }
      }
      if ((paramViewHolder != null) && (!"0".equals(paramViewHolder.k)) && (paramViewHolder.jdField_a_of_type_Boolean)) {
        a(true);
      }
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter != null)
      {
        if (a(paramViewHolder))
        {
          WeishiGuideUtils.a(this.mActivity, paramViewHolder, 1);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.b(paramViewHolder);
      }
    }
  }
  
  protected void d()
  {
    h();
  }
  
  protected void e()
  {
    b(327683);
  }
  
  protected void f()
  {
    b(327697);
  }
  
  protected void g()
  {
    b(327684);
  }
  
  public void initView()
  {
    if (this.mRootView != null) {
      j();
    }
    b();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    super.send(paramInt, paramVarArgs);
    if (paramInt == 786433)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(0);
      return;
    }
    if (paramInt == 786434)
    {
      b(false);
      return;
    }
    if (paramInt == 786435)
    {
      b(true);
      return;
    }
    if (paramInt == 131075)
    {
      paramVarArgs = AEMaterialManager.a();
      if ((paramVarArgs == null) || (paramVarArgs.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))) {
        b(false);
      }
    }
    else if (paramInt == 786436)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(this.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomListPart
 * JD-Core Version:    0.7.0.1
 */