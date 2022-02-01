package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorTextControlPanel
  extends FrameLayout
{
  private final int jdField_a_of_type_Int = getResources().getColor(2131166293);
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Observer<Integer> jdField_a_of_type_AndroidxLifecycleObserver;
  private AEEditorColorSelectorView jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView;
  private AEEditorTextControlPanel.TextControlListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel$TextControlListener;
  private AEEditorTextMaterialContentAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter;
  private AEEditorTextViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = getResources().getColor(2131166295);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Observer<String> jdField_b_of_type_AndroidxLifecycleObserver;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Observer<List<MetaMaterial>> jdField_c_of_type_AndroidxLifecycleObserver;
  private Observer<Integer> d;
  
  public AEEditorTextControlPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ContextCompat.getDrawable(paramContext, 2064056578);
    a(paramContext);
    a();
  }
  
  private ApplyMaterialTask a()
  {
    return new AEEditorTextControlPanel.8(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidxLifecycleObserver = new AEEditorTextControlPanel.3(this);
    this.jdField_b_of_type_AndroidxLifecycleObserver = new AEEditorTextControlPanel.4(this);
    this.jdField_c_of_type_AndroidxLifecycleObserver = new AEEditorTextControlPanel.5(this);
    this.d = new AEEditorTextControlPanel.6(this);
  }
  
  private void a(@NonNull Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2064318584, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2064122765));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2064122763));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2064122764));
    RecyclerView localRecyclerView = (RecyclerView)((View)localObject).findViewById(2064122586);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView = ((AEEditorColorSelectorView)((View)localObject).findViewById(2064122053));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView.setColorSelectedListener(new AEEditorTextControlPanel.1(this));
    localObject = new AEEditorTextControlPanel.2(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
    localRecyclerView.setOverScrollMode(2);
    localObject = new LinearLayoutManager(getContext(), 0, false);
    ((LinearLayoutManager)localObject).setAutoMeasureEnabled(false);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter = new AEEditorTextMaterialContentAdapter(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter.a(a());
    localRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setTextColor(this.jdField_a_of_type_Int);
      paramTextView.setTypeface(Typeface.defaultFromStyle(1));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramTextView.setTextColor(this.jdField_b_of_type_Int);
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      if (((AEEditorColorSelectorView)localObject).getVisibility() != 0) {
        b();
      }
    }
    else if (((AEEditorColorSelectorView)localObject).getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel$TextControlListener;
      if (localObject != null) {
        ((AEEditorTextControlPanel.TextControlListener)localObject).c(false);
      }
    }
  }
  
  private void b()
  {
    AEEditorTextControlPanel.7 local7 = new AEEditorTextControlPanel.7(this);
    ThreadManager.getUIHandler().post(local7);
  }
  
  public void a(int paramInt)
  {
    AEEditorColorSelectorView localAEEditorColorSelectorView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorColorSelectorView;
    if (localAEEditorColorSelectorView != null) {
      localAEEditorColorSelectorView.a(Integer.valueOf(paramInt));
    }
  }
  
  public boolean a(String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramString);
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(paramString);
    if ((i != -1) && (paramString != null))
    {
      AEEditorTextMaterialContentAdapter localAEEditorTextMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter;
      if (localAEEditorTextMaterialContentAdapter != null)
      {
        localAEEditorTextMaterialContentAdapter.a(i, paramString);
        return true;
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorTextViewModel localAEEditorTextViewModel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel;
    if (localAEEditorTextViewModel != null)
    {
      if (this.jdField_a_of_type_AndroidxLifecycleObserver != null) {
        localAEEditorTextViewModel.c().removeObserver(this.jdField_a_of_type_AndroidxLifecycleObserver);
      }
      if (this.jdField_b_of_type_AndroidxLifecycleObserver != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.d().removeObserver(this.jdField_b_of_type_AndroidxLifecycleObserver);
      }
      if (this.jdField_c_of_type_AndroidxLifecycleObserver != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.e().removeObserver(this.jdField_c_of_type_AndroidxLifecycleObserver);
      }
      if (this.d != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.f().removeObserver(this.d);
      }
    }
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter.b(paramBoolean);
  }
  
  public void setTextControlPanelListener(AEEditorTextControlPanel.TextControlListener paramTextControlListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel$TextControlListener = paramTextControlListener;
  }
  
  public void setTextViewModel(AEEditorTextViewModel paramAEEditorTextViewModel)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel = paramAEEditorTextViewModel;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.c().observeForever(this.jdField_a_of_type_AndroidxLifecycleObserver);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.d().observeForever(this.jdField_b_of_type_AndroidxLifecycleObserver);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.e().observeForever(this.jdField_c_of_type_AndroidxLifecycleObserver);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.f().observeForever(this.d);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEEditorTextMaterialContentAdapter localAEEditorTextMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextMaterialContentAdapter;
    if (localAEEditorTextMaterialContentAdapter != null) {
      localAEEditorTextMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel
 * JD-Core Version:    0.7.0.1
 */