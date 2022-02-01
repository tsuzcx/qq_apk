package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;

public class MaterialClassifierView
  extends LinearLayout
{
  private LinearLayout a;
  private RecyclerView b;
  private RecyclerView c;
  private ImageView d;
  private LinearLayoutManager e;
  private MaterialCategoryAdapter f;
  private MaterialContentAdapter g;
  private MaterialClassifierView.CategoryItemListener h;
  private List<MetaCategory> i;
  private List<MetaMaterial> j;
  private boolean k;
  
  public MaterialClassifierView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialClassifierView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialClassifierView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    this.a = new LinearLayout(getContext());
    this.a.setOrientation(0);
    this.a.setGravity(16);
    this.d = new ImageView(getContext());
    this.d.setImageResource(2063925432);
    int m = DisplayUtil.a(getContext(), 11.0F);
    int n = DisplayUtil.a(getContext(), 6.0F);
    this.d.setPadding(m, n, m, n);
    Object localObject = new LinearLayout.LayoutParams(DisplayUtil.a(getContext(), 42.0F), DisplayUtil.a(getContext(), 32.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(getContext(), 14.0F), 0, 0, 0);
    this.a.addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.b = new RecyclerView(getContext());
    this.b.setOverScrollMode(2);
    this.b.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    localObject = (SimpleItemAnimator)this.b.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    localObject = new LinearLayout.LayoutParams(-1, -2);
    this.a.addView(this.b, (ViewGroup.LayoutParams)localObject);
    addView(this.a, new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 32.0F)));
    this.c = new RecyclerView(getContext());
    this.c.setOverScrollMode(2);
    this.e = new LinearLayoutManager(getContext(), 0, false);
    this.e.setAutoMeasureEnabled(false);
    this.c.setLayoutManager(this.e);
    localObject = (SimpleItemAnimator)this.c.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    addView(this.c, new LinearLayout.LayoutParams(-1, -2));
    this.c.addOnScrollListener(new MaterialClassifierView.1(this));
  }
  
  public void a()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((MaterialCategoryAdapter)localObject).notifyDataSetChanged();
    }
    localObject = this.g;
    if (localObject != null) {
      ((MaterialContentAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  public void setCategoryItemListener(MaterialClassifierView.CategoryItemListener paramCategoryItemListener)
  {
    this.h = paramCategoryItemListener;
  }
  
  public void setCategoryLayoutVisibility(boolean paramBoolean)
  {
    Object localObject = this.a;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    ((LinearLayout)localObject).setVisibility(m);
    localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
    if (localObject != null)
    {
      if (paramBoolean) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 0.0F);
      } else {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 18.0F);
      }
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setClearButtonEnable(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
    ImageView localImageView = this.d;
    int m;
    if (paramBoolean) {
      m = 2063925431;
    } else {
      m = 2063925432;
    }
    localImageView.setImageResource(m);
  }
  
  public void setOnClearButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setup(MaterialContentAdapter paramMaterialContentAdapter, @NonNull List<MetaCategory> paramList, @NonNull List<MetaMaterial> paramList1)
  {
    this.g = paramMaterialContentAdapter;
    this.i = paramList;
    this.j = paramList1;
    this.f = new MaterialCategoryAdapter(paramList, new MaterialClassifierView.2(this));
    this.b.setAdapter(this.f);
    this.g.a(this.j);
    this.c.setAdapter(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView
 * JD-Core Version:    0.7.0.1
 */