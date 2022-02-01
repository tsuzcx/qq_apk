package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements AEFilterProviderAdapter.OnItemClickListener, CaptureComboManager.CaptureComboListener
{
  public int a = 0;
  public int b = 0;
  public VideoFilterTools.DataSet c;
  public ArrayList<FilterCategory> d;
  private AEProviderContainerView e;
  private RecyclerView f;
  private AEFilterProviderAdapter g;
  private CaptureComboManager h;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(String paramString)
  {
    AECameraPrefsUtil.a().a("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFilterPref(ae_filter_id, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(AEFilterProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      if (VideoFilterTools.a().d[this.D] != null) {
        VideoFilterTools.a().d[this.D].o = 1;
      }
      paramBundle = (QIMFilterCategoryItem)paramBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restore ");
          localStringBuilder.append(paramBundle.a);
          QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
        }
        paramBundle.o = 1;
      }
    }
  }
  
  public static String getFilterId()
  {
    String str = AECameraPrefsUtil.a().b("ae_filter_id", "", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFilterId(ae_filter_id, ");
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public void a()
  {
    super.a();
    CaptureComboManager localCaptureComboManager = this.h;
    if (localCaptureComboManager != null)
    {
      localCaptureComboManager.o[this.D].b();
      this.h.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("category= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" categoryName= ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",itemId=");
      localStringBuilder.append(paramString2);
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    FilterCategory localFilterCategory = (FilterCategory)this.d.get(this.b);
    StringBuilder localStringBuilder = null;
    int j = 0;
    paramInt = 0;
    int i;
    for (;;)
    {
      i = j;
      paramString1 = localStringBuilder;
      if (paramInt >= localFilterCategory.c.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.c.get(paramInt);
      if (paramString1.a.equals(paramString2))
      {
        i = paramInt;
        break;
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("itemInfo= ");
      paramString2.append(paramString1);
      paramString2.append(",index=");
      paramString2.append(this.b);
      paramString2.append(",pos=");
      paramString2.append(i);
      QLog.d("AEFilterProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new AEFilterProviderView.1(this, i), 200L);
      if (this.h != null)
      {
        paramString2 = new Bundle();
        paramString2.putInt("apply_source", 1);
        paramString2.putInt("capture_scene", this.D);
        this.h.a(paramString1, (Activity)getContext(), paramString2);
      }
      if (!this.e.j()) {
        a(paramString1.a);
      }
      this.g.notifyDataSetChanged();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = ((AEProviderContainerView)((Activity)getContext()).findViewById(2063990904));
    if (this.w == null) {
      this.w = LayoutInflater.from(getContext()).inflate(2064056350, this, true);
    }
    this.f = ((RecyclerView)this.w.findViewById(2063991073));
    paramBundle = new LinearLayoutManager(this.r, 0, false);
    this.f.setLayoutManager(paramBundle);
    this.g = new AEFilterProviderAdapter(this.r, this.D);
    this.f.setAdapter(this.g);
    this.g.a(this);
    if (QIMManager.a().c(5))
    {
      this.h = ((CaptureComboManager)QIMManager.a(5));
      paramBundle = this.h;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.h.l;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
    }
    else {
      a(paramBundle.a(this.D));
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView != null) {
      localObject1 = paramView.getTag();
    } else {
      localObject1 = null;
    }
    paramView = (View)localObject2;
    if (localObject1 != null) {
      paramView = (QIMFilterCategoryItem)localObject1;
    }
    if (paramView == null) {
      return;
    }
    if (paramView != null)
    {
      localObject2 = new HashMap();
      localObject1 = "none";
      if (paramInt == 0)
      {
        AEBaseReportParam.a().z("none");
        ((HashMap)localObject2).put("ext15", "none");
      }
      else
      {
        AEBaseReportParam.a().z(paramView.a);
        ((HashMap)localObject2).put("ext15", paramView.a);
      }
      AEReportUtils.b(11, (HashMap)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report filter click(");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", ");
        if (paramInt != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(paramView.a);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(")");
        QLog.d("AEFilterProviderView", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (this.F != null) {
      this.F.a(-1, paramView);
    }
    if (this.h != null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("apply_source", 1);
      ((Bundle)localObject1).putInt("capture_scene", this.D);
      if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
        ((Bundle)localObject1).putBoolean("capture_force_enable", true);
      }
      this.h.a(paramView, (Activity)getContext(), (Bundle)localObject1);
    }
    if (!this.e.j()) {
      a(paramView.a);
    }
    paramView = this.h;
    if (paramView != null) {
      paramView.a(this.D, (Activity)this.r);
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onComboFilterDataUpdated data:");
      boolean bool;
      if (paramComboFilterData == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null) {
      a(paramComboFilterData.a(this.D));
    }
  }
  
  public void a(VideoFilterTools.DataSet paramDataSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.c = paramDataSet;
    this.d = paramDataSet.b;
    paramDataSet = this.d;
    if (paramDataSet != null)
    {
      int i = paramDataSet.size();
      int j = this.b;
      if (i > j) {
        this.g.a(((FilterCategory)this.d.get(j)).c);
      }
    }
    this.g.notifyDataSetChanged();
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("fp onComboApply combo ");
      paramBundle.append(paramComboSet.e);
      paramBundle.append(" filter ");
      QLog.i("QCombo", 2, paramBundle.toString());
    }
    this.g.notifyDataSetChanged();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.g.notifyDataSetChanged();
    if (paramBoolean)
    {
      paramFilterSet = (QimMusicPlayer)QIMManager.a().d(8);
      if (this.D == 0) {
        paramInt = QQFilterRenderManagerHolder.b;
      } else {
        paramInt = QQFilterRenderManagerHolder.c;
      }
      paramFilterSet.c(paramInt);
      paramFilterSet.k();
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c == null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        localObject = ((CaptureComboManager)localObject).l;
        if (localObject != null) {
          this.c = ((VideoFilterTools.ComboFilterData)localObject).a(this.D);
        }
      }
    }
    Object localObject = this.c;
    if ((localObject != null) && (((VideoFilterTools.DataSet)localObject).f != null))
    {
      localObject = (Activity)getContext();
      this.h.b(this.c.f).a((Activity)localObject, this.D);
      VideoFilterTools.a().b(this.c.f, (Activity)getContext(), this.D);
      VideoFilterTools.a().a(this.c.f, this.D);
      this.g.notifyDataSetChanged();
      a(null, 0);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.F != null) {
      this.F.c();
    }
    this.g.notifyDataSetChanged();
  }
  
  public void d()
  {
    super.d();
    if (this.F != null) {
      this.F.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    CaptureComboManager localCaptureComboManager = this.h;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    CaptureComboManager localCaptureComboManager = this.h;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.b(this);
    }
  }
  
  protected int getInflateLayout()
  {
    return 2131627201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */