package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public class DYAEFilterProviderView
  extends ProviderView
  implements DYAEEffectListHolder.ItemClickListener, CaptureComboManager.CaptureComboListener
{
  public int a = 0;
  public VideoFilterTools.DataSet b;
  public ArrayList<FilterCategory> c;
  private DYAEProviderContainerView d;
  private DYAEEffectListHolder e;
  private String f;
  private CaptureComboManager g;
  private AEPituCameraUnit h;
  private AEFilterProviderViewModel i;
  private DYAEFilterProviderView.PendingApplyAction j;
  
  public DYAEFilterProviderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DYAEFilterProviderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DYAEFilterProviderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.r = paramContext;
  }
  
  private void a(@NonNull QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    AEBaseDataReporter.a().d(paramQIMFilterCategoryItem.a, AEProviderViewModel.a(paramQIMFilterCategoryItem));
    Object localObject2 = new HashMap();
    Object localObject1 = "none";
    if (paramInt == 0)
    {
      AEBaseReportParam.a().z("none");
      ((HashMap)localObject2).put("ext15", "none");
    }
    else
    {
      AEBaseReportParam.a().z(paramQIMFilterCategoryItem.a);
      ((HashMap)localObject2).put("ext15", paramQIMFilterCategoryItem.a);
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
        ((StringBuilder)localObject1).append(paramQIMFilterCategoryItem.a);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      QLog.d("AEFilterProviderView", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.F != null) {
      this.F.a(paramInt, paramQIMFilterCategoryItem);
    }
    if (this.g != null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("apply_source", 1);
      ((Bundle)localObject1).putInt("capture_scene", this.D);
      if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
        ((Bundle)localObject1).putBoolean("capture_force_enable", true);
      }
      this.g.a(paramQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject1);
    }
    if (!this.d.i()) {
      a(paramQIMFilterCategoryItem.a);
    }
    paramQIMFilterCategoryItem = this.g;
    if (paramQIMFilterCategoryItem != null) {
      paramQIMFilterCategoryItem.a(this.D, (Activity)this.r);
    }
  }
  
  public static void a(String paramString)
  {
    AECameraPrefsUtil.a().a("dy_filter_id", paramString, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFilterPref(dy_filter_id, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
  }
  
  private void b(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    paramComboFilterData = paramComboFilterData.a(this.D);
    this.b = paramComboFilterData;
    this.c = paramComboFilterData.b;
    paramComboFilterData = new ArrayList();
    Object localObject = this.c;
    if (localObject != null)
    {
      int k = ((ArrayList)localObject).size();
      int m = this.a;
      if (k > m)
      {
        localObject = ((FilterCategory)this.c.get(m)).c;
        if (localObject != null)
        {
          if (((List)localObject).size() > 0)
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((List)localObject).get(0);
            if (localQIMFilterCategoryItem.d())
            {
              localQIMFilterCategoryItem.d = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";
              this.f = localQIMFilterCategoryItem.a;
            }
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramComboFilterData.add(new DYAEFilterItem((QIMFilterCategoryItem)((Iterator)localObject).next()));
          }
        }
      }
    }
    this.e.a(paramComboFilterData);
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(DYAEFilterProviderView.class.getSimpleName());
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
  
  private void g()
  {
    this.i = ((AEFilterProviderViewModel)AEViewModelProviders.a(this.h).get(AEFilterProviderViewModel.class));
    this.i.a().observe(this.h, new DYAEFilterProviderView.1(this));
  }
  
  public static String getFilterId()
  {
    String str = AECameraPrefsUtil.a().b("dy_filter_id", "", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFilterId(dy_filter_id, ");
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      QLog.d("AEFilterProviderView", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  private void h()
  {
    if (this.i != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterTools.a().c(this.D);
      this.i.a(localQIMFilterCategoryItem);
    }
  }
  
  public void a()
  {
    super.a();
    CaptureComboManager localCaptureComboManager = this.g;
    if (localCaptureComboManager != null)
    {
      localCaptureComboManager.o[this.D].b();
      this.g.b(this);
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
    FilterCategory localFilterCategory = (FilterCategory)this.c.get(this.a);
    StringBuilder localStringBuilder = null;
    int m = 0;
    paramInt = 0;
    int k;
    for (;;)
    {
      k = m;
      paramString1 = localStringBuilder;
      if (paramInt >= localFilterCategory.c.size()) {
        break;
      }
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.c.get(paramInt);
      if (paramString1.a.equals(paramString2))
      {
        k = paramInt;
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
      paramString2.append(this.a);
      paramString2.append(",pos=");
      paramString2.append(k);
      QLog.d("AEFilterProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new DYAEFilterProviderView.2(this, paramString1.a), 200L);
      if (this.g != null)
      {
        paramString2 = new Bundle();
        paramString2.putInt("apply_source", 1);
        paramString2.putInt("capture_scene", this.D);
        this.g.a(paramString1, (Activity)getContext(), paramString2);
      }
      if (!this.d.i()) {
        a(paramString1.a);
      }
      this.e.a(true);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = ((DYAEProviderContainerView)((Activity)getContext()).findViewById(2063990904));
    this.e = new DYAEEffectListHolder(this.r, this.y, this);
    if (QIMManager.a().c(5))
    {
      this.g = ((CaptureComboManager)QIMManager.a(5));
      paramBundle = this.g;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.g.l;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
    }
    else {
      b(paramBundle);
    }
    h();
  }
  
  public void a(@NotNull DYAEEffectItem paramDYAEEffectItem, int paramInt)
  {
    if (!(paramDYAEEffectItem instanceof DYAEFilterItem)) {
      return;
    }
    paramDYAEEffectItem = ((DYAEFilterItem)paramDYAEEffectItem).g();
    this.j = new DYAEFilterProviderView.PendingApplyAction(null);
    Object localObject = this.j;
    ((DYAEFilterProviderView.PendingApplyAction)localObject).a = paramInt;
    ((DYAEFilterProviderView.PendingApplyAction)localObject).b = paramDYAEEffectItem;
    localObject = this.i;
    if (localObject != null) {
      ((AEFilterProviderViewModel)localObject).a(paramDYAEEffectItem);
    }
  }
  
  public void a(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.h = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    if (this.h != null) {
      g();
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
      b(paramComboFilterData);
    }
    h();
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
    h();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
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
    h();
  }
  
  public void b()
  {
    super.b();
    if (this.b == null)
    {
      localObject = this.g;
      if (localObject != null)
      {
        localObject = ((CaptureComboManager)localObject).l;
        if (localObject != null) {
          this.b = ((VideoFilterTools.ComboFilterData)localObject).a(this.D);
        }
      }
    }
    Object localObject = this.b;
    if ((localObject != null) && (((VideoFilterTools.DataSet)localObject).f != null))
    {
      localObject = (Activity)getContext();
      this.g.b(this.b.f).a((Activity)localObject, this.D);
      VideoFilterTools.a().b(this.b.f, (Activity)getContext(), this.D);
      VideoFilterTools.a().a(this.b.f, this.D);
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
    this.e.a(true);
    this.e.b();
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
    CaptureComboManager localCaptureComboManager = this.g;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    CaptureComboManager localCaptureComboManager = this.g;
    if (localCaptureComboManager != null) {
      localCaptureComboManager.b(this);
    }
  }
  
  protected int getInflateLayout()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */