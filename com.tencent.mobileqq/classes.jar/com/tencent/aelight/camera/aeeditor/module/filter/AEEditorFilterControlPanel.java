package com.tencent.aelight.camera.aeeditor.module.filter;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTaskHelper;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorFilterControlPanel
  extends FrameLayout
  implements View.OnClickListener, ApplyMaterialTask
{
  public static int a = 0;
  private static final String b = "AEEditorFilterControlPanel";
  private final List<MetaCategory> c = new ArrayList();
  private final List<MetaMaterial> d = new ArrayList();
  private MetaMaterial e = null;
  private boolean f;
  private View g;
  private SeekBar h;
  private TextView i;
  private ImageView j;
  private MaterialClassifierView k;
  private FiltersAdapterMaterial l;
  private AEEditorFilterControlPanel.FilterControlListener m;
  private FilterChangedComparator n;
  private int o = -1;
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorFilterControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2064056439, this);
    this.g = localView.findViewById(2063991390);
    this.g.setVisibility(4);
    this.h = ((SeekBar)localView.findViewById(2063991077));
    this.h.setOnSeekBarChangeListener(new AEEditorFilterControlPanel.1(this));
    this.j = ((ImageView)localView.findViewById(2063990888));
    this.j.setOnClickListener(this);
    this.k = ((MaterialClassifierView)localView.findViewById(2063990967));
    this.k.setOnClearButtonClickListener(new AEEditorFilterControlPanel.2(this));
    this.l = new FiltersAdapterMaterial(paramContext);
    this.l.a(this);
    this.l.a(new AEEditorFilterControlPanel.3(this));
    this.k.setup(this.l, this.c, this.d);
    this.k.setCategoryItemListener(new AEEditorFilterControlPanel.4(this));
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    String str = FilterMetaMaterialKt.m(paramMetaMaterial);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lutId = ");
    ((StringBuilder)localObject).append(str);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(str))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    localObject = AEEditorResourceManager.a().c(paramMetaMaterial);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lutPath = ");
    localStringBuilder.append((String)localObject);
    ApplyMaterialTaskHelper.a("downloadLutResource", paramMetaMaterial, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    AEEditorResourceManager.a().a(str, new AEEditorFilterControlPanel.7(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  private boolean a(MetaMaterial paramMetaMaterial, String paramString)
  {
    try
    {
      paramString = (AEFilterExtendBean)new Gson().fromJson(paramString, new AEEditorFilterControlPanel.6(this).getType());
      if (paramString != null)
      {
        FilterMetaMaterialKt.b(paramMetaMaterial, true);
        FilterMetaMaterialKt.a(paramMetaMaterial, paramString.getDefaultEffectAlpha());
        if (!TextUtils.isEmpty(paramString.getLutID())) {
          FilterMetaMaterialKt.a(paramMetaMaterial, paramString.getLutID());
        }
        FilterMetaMaterialKt.b(paramMetaMaterial, paramString.getGlowStrength());
        if (!TextUtils.isEmpty(paramString.getMotionID())) {
          FilterMetaMaterialKt.b(paramMetaMaterial, paramString.getMotionID());
        }
        FilterMetaMaterialKt.a(paramMetaMaterial, paramString.getAdjustParams());
        return true;
      }
    }
    catch (JsonSyntaxException paramMetaMaterial)
    {
      paramString = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse effect json exception: ");
      localStringBuilder.append(paramMetaMaterial.toString());
      AEQLog.d(paramString, localStringBuilder.toString());
    }
    return false;
  }
  
  public int a(String paramString)
  {
    List localList = this.l.b();
    int i1 = 0;
    while (i1 < localList.size())
    {
      if (paramString.equals(((MetaMaterial)localList.get(i1)).id))
      {
        setSelectedIndex(i1);
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void a()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((AEEditorFilterControlPanel.FilterControlListener)localObject).Q();
      setSelectedIndex(-1);
      AEBaseDataReporter.a().b(EffectType.NON.name());
    }
    boolean bool = this.f;
    if (bool) {
      localObject = "image_clear_button";
    } else {
      localObject = "video_clear_button";
    }
    AEReportUtils.b(bool, (String)localObject);
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    int i1 = AEEditorFilterControlPanel.8.a[FilterMetaMaterialKt.c(paramMetaMaterial).ordinal()];
    boolean bool2 = true;
    AEEditorFilterControlPanel.FilterControlListener localFilterControlListener;
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        AEQLog.b(b, "select comics filter");
        localFilterControlListener = this.m;
        if (localFilterControlListener != null)
        {
          bool1 = localFilterControlListener.b(paramInt, paramMetaMaterial);
          AEBaseDataReporter.a().b(paramMetaMaterial.id);
          break label118;
        }
      }
    }
    else
    {
      AEQLog.b(b, "select ai filter");
      localFilterControlListener = this.m;
      if (localFilterControlListener != null)
      {
        bool1 = localFilterControlListener.c(paramInt);
        AEBaseDataReporter.a().b(paramMetaMaterial.id);
        break label118;
      }
    }
    boolean bool1 = true;
    label118:
    if (bool1)
    {
      paramMetaMaterial = this.n;
      bool1 = bool2;
      if (paramMetaMaterial != null) {
        bool1 = paramMetaMaterial.a(this.o, paramInt);
      }
      if (bool1)
      {
        paramMetaMaterial = this.m;
        if (paramMetaMaterial != null) {
          paramMetaMaterial.T();
        }
      }
      this.o = paramInt;
    }
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
    this.o = paramInt;
    AEReportUtils.d(this.f, paramMetaMaterial.id);
  }
  
  public void a(TextView paramTextView)
  {
    this.i = paramTextView;
  }
  
  public void a(ApplyMaterialTask.Status paramStatus, int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    if (FilterMetaMaterialKt.a(paramMetaMaterial))
    {
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    if (FilterMetaMaterialKt.b(paramMetaMaterial))
    {
      a(paramMetaMaterial, paramMaterialStatusCallback);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AEEditorFilterControlPanel.5(this, paramMetaMaterial, paramMaterialStatusCallback));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.g.getVisibility() == 4))
    {
      this.g.setVisibility(0);
      return;
    }
    if ((!paramBoolean) && (this.g.getVisibility() == 0)) {
      this.g.setVisibility(4);
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.l != null)
    {
      paramString = FilterMetaMaterialKt.a(paramString, paramBoolean);
      return this.l.a(paramString);
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView = this.j;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public boolean b()
  {
    return this.j.getVisibility() == 0;
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.h;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    ((SeekBar)localObject).setVisibility(i1);
    localObject = this.i;
    if ((localObject != null) && (!paramBoolean)) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public boolean c()
  {
    return this.h.getVisibility() == 0;
  }
  
  public boolean c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorResourceManager.a().d(paramMetaMaterial);
    return (ApplyMaterialTaskHelper.b(paramMetaMaterial)) && (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  public void d(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public boolean d()
  {
    return FilterMetaMaterialKt.c(this.e) == EffectType.AI;
  }
  
  public void e(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    this.k.setClearButtonEnable(true);
    this.e = paramMetaMaterial;
    AEEditorFilterControlPanel.FilterControlListener localFilterControlListener = this.m;
    if (localFilterControlListener != null)
    {
      localFilterControlListener.c(paramInt, paramMetaMaterial);
      AEBaseDataReporter.a().b(paramMetaMaterial.id);
    }
  }
  
  public boolean e()
  {
    return FilterMetaMaterialKt.c(this.e) == EffectType.NON;
  }
  
  public MetaMaterial getCurrentFilterInstance()
  {
    return this.e;
  }
  
  public List<MetaMaterial> getFilterMaterials()
  {
    return this.d;
  }
  
  public int getSelectedIndex()
  {
    return this.l.c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2063990888) {
      return;
    }
    if (this.j.isEnabled())
    {
      paramView = this.m;
      if ((paramView != null) && ((paramView instanceof AEEditorFilterControlPanel.ImageFilterControlListener))) {
        ((AEEditorFilterControlPanel.ImageFilterControlListener)paramView).P();
      }
    }
  }
  
  public void setFilterChangedComparator(FilterChangedComparator paramFilterChangedComparator)
  {
    this.n = paramFilterChangedComparator;
  }
  
  public void setFilterControlListener(AEEditorFilterControlPanel.FilterControlListener paramFilterControlListener)
  {
    this.m = paramFilterControlListener;
  }
  
  public void setFiltersMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.c.clear();
    this.c.addAll(paramList);
    this.d.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)paramList.next();
      if (localMetaCategory.materials != null)
      {
        Iterator localIterator = localMetaCategory.materials.iterator();
        while (localIterator.hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
          MetaMaterialKt.a(localMetaMaterial, localMetaCategory.id);
          if (paramBoolean)
          {
            if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.h(localMetaMaterial))) {
              localIterator.remove();
            }
          }
          else if ((FilterMetaMaterialKt.g(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.i(localMetaMaterial))) {
            localIterator.remove();
          }
        }
        int i1 = 0;
        while (i1 < localMetaCategory.materials.size())
        {
          if (localMetaCategory.materials.get(i1) != null)
          {
            int i2 = AEEditorFilterControlPanel.8.a[FilterMetaMaterialKt.c((MetaMaterial)localMetaCategory.materials.get(i1)).ordinal()];
            if (i2 != 1)
            {
              if (i2 != 2)
              {
                if (i2 == 3)
                {
                  MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i1), true);
                  MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i1), true);
                }
              }
              else
              {
                MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i1), false);
                MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i1), false);
              }
            }
            else
            {
              a = i1;
              MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i1), false);
              MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i1), false);
            }
            if (FilterMetaMaterialKt.e((MetaMaterial)localMetaCategory.materials.get(i1))) {
              MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i1), 2063925421);
            }
          }
          i1 += 1;
        }
        this.d.addAll(localMetaCategory.materials);
      }
    }
    this.k.a();
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.l.b(this.f);
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.h.setProgress((int)(paramFloat * 100.0F));
  }
  
  public void setSelectedIndex(int paramInt)
  {
    setSelectedIndex(paramInt, false);
  }
  
  public void setSelectedIndex(int paramInt, boolean paramBoolean)
  {
    this.l.a(paramInt, paramBoolean);
    MaterialClassifierView localMaterialClassifierView = this.k;
    if (paramInt != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localMaterialClassifierView.setClearButtonEnable(paramBoolean);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    FiltersAdapterMaterial localFiltersAdapterMaterial = this.l;
    if (localFiltersAdapterMaterial != null) {
      localFiltersAdapterMaterial.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */