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
  private TextView a;
  private TextView b;
  private TextView c;
  private AEEditorTextMaterialContentAdapter d;
  private AEEditorColorSelectorView e;
  private final int f = getResources().getColor(2131167030);
  private final int g = getResources().getColor(2131167032);
  private final Drawable h;
  private AEEditorTextViewModel i;
  private Observer<Integer> j;
  private Observer<String> k;
  private Observer<List<MetaMaterial>> l;
  private Observer<Integer> m;
  private boolean n;
  private AEEditorTextControlPanel.TextControlListener o;
  
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
    this.h = ContextCompat.getDrawable(paramContext, 2063925537);
    a(paramContext);
    a();
  }
  
  private void a()
  {
    this.j = new AEEditorTextControlPanel.3(this);
    this.k = new AEEditorTextControlPanel.4(this);
    this.l = new AEEditorTextControlPanel.5(this);
    this.m = new AEEditorTextControlPanel.6(this);
  }
  
  private void a(@NonNull Context paramContext)
  {
    Object localObject = View.inflate(paramContext, 2064056456, this);
    this.a = ((TextView)((View)localObject).findViewById(2063991540));
    this.b = ((TextView)((View)localObject).findViewById(2063991538));
    this.c = ((TextView)((View)localObject).findViewById(2063991539));
    RecyclerView localRecyclerView = (RecyclerView)((View)localObject).findViewById(2063991403);
    this.e = ((AEEditorColorSelectorView)((View)localObject).findViewById(2063990973));
    this.e.setColorSelectedListener(new AEEditorTextControlPanel.1(this));
    localObject = new AEEditorTextControlPanel.2(this);
    this.a.setOnClickListener((View.OnClickListener)localObject);
    this.b.setOnClickListener((View.OnClickListener)localObject);
    this.c.setOnClickListener((View.OnClickListener)localObject);
    localRecyclerView.setOverScrollMode(2);
    localObject = new LinearLayoutManager(getContext(), 0, false);
    ((LinearLayoutManager)localObject).setAutoMeasureEnabled(false);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.d = new AEEditorTextMaterialContentAdapter(paramContext);
    this.d.a(c());
    localRecyclerView.setAdapter(this.d);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setTextColor(this.f);
      paramTextView.setTypeface(Typeface.defaultFromStyle(1));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, this.h);
      return;
    }
    paramTextView.setTextColor(this.g);
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void b()
  {
    AEEditorTextControlPanel.7 local7 = new AEEditorTextControlPanel.7(this);
    ThreadManager.getUIHandler().post(local7);
  }
  
  private ApplyMaterialTask c()
  {
    return new AEEditorTextControlPanel.8(this);
  }
  
  private void setColorSelectorViewVisibility(boolean paramBoolean)
  {
    Object localObject = this.e;
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
      this.e.setVisibility(8);
      localObject = this.o;
      if (localObject != null) {
        ((AEEditorTextControlPanel.TextControlListener)localObject).c(false);
      }
    }
  }
  
  public void a(int paramInt)
  {
    AEEditorColorSelectorView localAEEditorColorSelectorView = this.e;
    if (localAEEditorColorSelectorView != null) {
      localAEEditorColorSelectorView.a(Integer.valueOf(paramInt));
    }
  }
  
  public boolean a(String paramString)
  {
    int i1 = this.i.b(paramString);
    paramString = this.i.a(paramString);
    if ((i1 != -1) && (paramString != null))
    {
      AEEditorTextMaterialContentAdapter localAEEditorTextMaterialContentAdapter = this.d;
      if (localAEEditorTextMaterialContentAdapter != null)
      {
        localAEEditorTextMaterialContentAdapter.a(i1, paramString);
        return true;
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorTextViewModel localAEEditorTextViewModel = this.i;
    if (localAEEditorTextViewModel != null)
    {
      if (this.j != null) {
        localAEEditorTextViewModel.e().removeObserver(this.j);
      }
      if (this.k != null) {
        this.i.g().removeObserver(this.k);
      }
      if (this.l != null) {
        this.i.h().removeObserver(this.l);
      }
      if (this.m != null) {
        this.i.i().removeObserver(this.m);
      }
    }
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.d.b(paramBoolean);
  }
  
  public void setTextControlPanelListener(AEEditorTextControlPanel.TextControlListener paramTextControlListener)
  {
    this.o = paramTextControlListener;
  }
  
  public void setTextViewModel(AEEditorTextViewModel paramAEEditorTextViewModel)
  {
    this.i = paramAEEditorTextViewModel;
    this.i.e().observeForever(this.j);
    this.i.g().observeForever(this.k);
    this.i.h().observeForever(this.l);
    this.i.i().observeForever(this.m);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEEditorTextMaterialContentAdapter localAEEditorTextMaterialContentAdapter = this.d;
    if (localAEEditorTextMaterialContentAdapter != null) {
      localAEEditorTextMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel
 * JD-Core Version:    0.7.0.1
 */