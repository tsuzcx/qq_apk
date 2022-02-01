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
  private static final String jdField_a_of_type_JavaLangString = "AEEditorFilterControlPanel";
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MetaMaterial jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
  private AEEditorFilterControlPanel.FilterControlListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
  private FilterChangedComparator jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFilterChangedComparator;
  private FiltersAdapterMaterial jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial;
  private MaterialClassifierView jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private final List<MetaMaterial> jdField_b_of_type_JavaUtilList = new ArrayList();
  
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
    View localView = View.inflate(paramContext, 2064318567, this);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2064122572);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView.findViewById(2064122196));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorFilterControlPanel.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2064121957));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView = ((MaterialClassifierView)localView.findViewById(2064122044));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setOnClearButtonClickListener(new AEEditorFilterControlPanel.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial = new FiltersAdapterMaterial(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a(new AEEditorFilterControlPanel.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setup(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setCategoryItemListener(new AEEditorFilterControlPanel.4(this));
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    String str1 = FilterMetaMaterialKt.a(paramMetaMaterial);
    if (TextUtils.isEmpty(str1))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    String str2 = AEEditorResourceManager.a().b(paramMetaMaterial);
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      FilterMetaMaterialKt.a(paramMetaMaterial, true);
      paramMaterialStatusCallback.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
      return;
    }
    AEEditorResourceManager.a().a(str1, new AEEditorFilterControlPanel.7(this, paramMetaMaterial, paramMaterialStatusCallback));
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
      paramString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse effect json exception: ");
      localStringBuilder.append(paramMetaMaterial.toString());
      AEQLog.d(paramString, localStringBuilder.toString());
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a();
  }
  
  public int a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a();
    int i = 0;
    while (i < localList.size())
    {
      if (paramString.equals(((MetaMaterial)localList.get(i)).id))
      {
        setSelectedIndex(i);
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public MetaMaterial a()
  {
    return this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
  }
  
  public List<MetaMaterial> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
    if (localObject != null)
    {
      ((AEEditorFilterControlPanel.FilterControlListener)localObject).A();
      setSelectedIndex(-1);
      AEBaseDataReporter.a().b(EffectType.NON.name());
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    if (bool) {
      localObject = "image_clear_button";
    } else {
      localObject = "video_clear_button";
    }
    AEReportUtils.a(bool, (String)localObject);
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    int i = AEEditorFilterControlPanel.8.a[FilterMetaMaterialKt.a(paramMetaMaterial).ordinal()];
    boolean bool2 = true;
    AEEditorFilterControlPanel.FilterControlListener localFilterControlListener;
    if (i != 1)
    {
      if (i == 2)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "select comics filter");
        localFilterControlListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
        if (localFilterControlListener != null)
        {
          bool1 = localFilterControlListener.a(paramInt, paramMetaMaterial);
          AEBaseDataReporter.a().b(paramMetaMaterial.id);
          break label118;
        }
      }
    }
    else
    {
      AEQLog.b(jdField_a_of_type_JavaLangString, "select ai filter");
      localFilterControlListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
      if (localFilterControlListener != null)
      {
        bool1 = localFilterControlListener.b(paramInt);
        AEBaseDataReporter.a().b(paramMetaMaterial.id);
        break label118;
      }
    }
    boolean bool1 = true;
    label118:
    if (bool1)
    {
      paramMetaMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFilterChangedComparator;
      bool1 = bool2;
      if (paramMetaMaterial != null) {
        bool1 = paramMetaMaterial.a(this.jdField_b_of_type_Int, paramInt);
      }
      if (bool1)
      {
        paramMetaMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
        if (paramMetaMaterial != null) {
          paramMetaMaterial.D();
        }
      }
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void a(int paramInt, @NonNull MetaMaterial paramMetaMaterial, @NonNull ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback)
  {
    ApplyMaterialTaskHelper.a(paramMaterialStatusCallback);
    this.jdField_b_of_type_Int = paramInt;
    AEReportUtils.c(this.jdField_a_of_type_Boolean, paramMetaMaterial.id);
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
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
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  public boolean a(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    return ApplyMaterialTaskHelper.a(paramMetaMaterial);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial != null)
    {
      paramString = FilterMetaMaterialKt.a(paramString, paramBoolean);
      return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a(paramString);
    }
    return false;
  }
  
  public void b(int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public void b(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0;
  }
  
  public boolean b(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    String str = AEEditorResourceManager.a().c(paramMetaMaterial);
    return (ApplyMaterialTaskHelper.b(paramMetaMaterial)) && (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  public void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setClearButtonEnable(true);
    this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = paramMetaMaterial;
    AEEditorFilterControlPanel.FilterControlListener localFilterControlListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
    if (localFilterControlListener != null)
    {
      localFilterControlListener.b(paramInt, paramMetaMaterial);
      AEBaseDataReporter.a().b(paramMetaMaterial.id);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    ((SeekBar)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (!paramBoolean)) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public boolean c()
  {
    return FilterMetaMaterialKt.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial) == EffectType.AI;
  }
  
  public boolean d()
  {
    return FilterMetaMaterialKt.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial) == EffectType.NON;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2064121957) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.isEnabled())
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener;
      if ((paramView != null) && ((paramView instanceof AEEditorFilterControlPanel.ImageFilterControlListener))) {
        ((AEEditorFilterControlPanel.ImageFilterControlListener)paramView).z();
      }
    }
  }
  
  public void setFilterChangedComparator(FilterChangedComparator paramFilterChangedComparator)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFilterChangedComparator = paramFilterChangedComparator;
  }
  
  public void setFilterControlListener(AEEditorFilterControlPanel.FilterControlListener paramFilterControlListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel$FilterControlListener = paramFilterControlListener;
  }
  
  public void setFiltersMaterials(List<MetaCategory> paramList, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_b_of_type_JavaUtilList.clear();
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
            if ((FilterMetaMaterialKt.e(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.a(localMetaMaterial))) {
              localIterator.remove();
            }
          }
          else if ((FilterMetaMaterialKt.f(localMetaMaterial)) || (paramInt < FilterMetaMaterialKt.b(localMetaMaterial))) {
            localIterator.remove();
          }
        }
        int i = 0;
        while (i < localMetaCategory.materials.size())
        {
          if (localMetaCategory.materials.get(i) != null)
          {
            int j = AEEditorFilterControlPanel.8.a[FilterMetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i)).ordinal()];
            if (j != 1)
            {
              if (j != 2)
              {
                if (j == 3)
                {
                  MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i), true);
                  MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i), true);
                }
              }
              else
              {
                MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i), false);
                MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i), false);
              }
            }
            else
            {
              jdField_a_of_type_Int = i;
              MetaMaterialKt.a((MetaMaterial)localMetaCategory.materials.get(i), false);
              MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i), false);
            }
            if (FilterMetaMaterialKt.d((MetaMaterial)localMetaCategory.materials.get(i))) {
              MetaMaterialKt.b((MetaMaterial)localMetaCategory.materials.get(i), 2064056453);
            }
          }
          i += 1;
        }
        this.jdField_b_of_type_JavaUtilList.addAll(localMetaCategory.materials);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.a();
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.b(this.jdField_a_of_type_Boolean);
  }
  
  public void setSeekBarValue(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(paramFloat * 100.0F));
  }
  
  public void setSelectedIndex(int paramInt)
  {
    setSelectedIndex(paramInt, false);
  }
  
  public void setSelectedIndex(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial.a(paramInt, paramBoolean);
    MaterialClassifierView localMaterialClassifierView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
    if (paramInt != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localMaterialClassifierView.setClearButtonEnable(paramBoolean);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    FiltersAdapterMaterial localFiltersAdapterMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterFiltersAdapterMaterial;
    if (localFiltersAdapterMaterial != null) {
      localFiltersAdapterMaterial.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel
 * JD-Core Version:    0.7.0.1
 */