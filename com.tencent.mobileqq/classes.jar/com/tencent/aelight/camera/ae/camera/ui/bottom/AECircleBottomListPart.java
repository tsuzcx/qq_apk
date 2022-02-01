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
  private View g;
  private boolean h = false;
  private int i = 0;
  private AEVideoStoryTopBarViewModel j;
  private boolean k = false;
  
  public AECircleBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.g;
    if (localView == null) {
      return;
    }
    int m;
    if ((this.h) && (paramBoolean)) {
      m = 0;
    } else {
      m = 8;
    }
    localView.setVisibility(m);
  }
  
  private boolean d(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramViewHolder != null)
    {
      bool1 = bool2;
      if (paramViewHolder.a != null)
      {
        bool1 = bool2;
        if (paramInt == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void m()
  {
    this.b = ((AEBottomListScrollView)this.mRootView.findViewById(2063991400));
    this.b.setSlideOnFling(true);
    this.b.setItemTransitionTimeMillis(100);
    this.b.setSlideOnFlingThreshold(1000);
    this.b.setOffscreenItems(10);
    this.b.setOnItemChangedListener(this);
    this.b.setScrollStateChangeListener(this);
    this.b.setAEEditMaterialSelectedListener(this);
    this.b.setItemTransformer(new AECircleScaleTransformer.Builder().a(1.0F).b(1.3839F).a());
    this.c = new AEBottomListAdapter(this.a, this.b, this.d);
    this.c.a(new AECircleBottomListPart.1(this));
    this.b.setAdapter(this.c);
    this.g = this.mRootView.findViewById(2063991157);
    this.e = ((AEMaterialManager)AEQIMManager.a().b(1));
    this.e.a(this, 113);
    this.e.a(this, 112);
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
        this.mPartManager.b(327696, new Object[0]);
        return;
      }
      this.mPartManager.b(327689, new Object[0]);
    }
  }
  
  protected void b()
  {
    super.b();
    this.j = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.a).get(AEVideoStoryTopBarViewModel.class));
    this.j.a.observe(this.a, new AECircleBottomListPart.2(this));
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if (d(paramViewHolder, paramInt))
    {
      this.h = false;
      b(false);
      return;
    }
    this.h = true;
    b(true);
  }
  
  protected void c(int paramInt)
  {
    if (this.k) {
      return;
    }
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    b(true);
    super.c(paramInt);
    this.i = paramInt;
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.a;
      if ((paramViewHolder != null) && (!"call_material_id".equals(paramViewHolder.m)))
      {
        this.i = paramInt;
        if (k())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ext2", paramViewHolder.m);
          AEReportUtils.b(2, localHashMap);
        }
      }
      if ((paramViewHolder != null) && (!"0".equals(paramViewHolder.m)) && (paramViewHolder.u)) {
        a(true);
      }
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.c != null)
      {
        if (a(paramViewHolder))
        {
          WeishiGuideUtils.a(this.mActivity, paramViewHolder, 1);
          return;
        }
        this.c.b(paramViewHolder);
      }
    }
  }
  
  protected void d()
  {
    i();
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
      m();
    }
    b();
  }
  
  public boolean k()
  {
    return true;
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.k = true;
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    this.k = false;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    super.send(paramInt, paramVarArgs);
    if (paramInt == 786433)
    {
      this.b.smoothScrollToPosition(0);
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
      paramVarArgs = AEMaterialManager.n();
      if ((paramVarArgs == null) || (paramVarArgs.equals(AEMaterialMetaData.l))) {
        b(false);
      }
    }
    else if (paramInt == 786436)
    {
      this.b.smoothScrollToPosition(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomListPart
 * JD-Core Version:    0.7.0.1
 */