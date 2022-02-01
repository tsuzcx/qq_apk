package com.tencent.aelight.camera.aioeditor.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(14)
public class ProviderContainerView
  extends FrameLayout
{
  private LinearLayout a;
  private FrameLayout b;
  private ProviderViewBuilder c;
  private HashMap<Integer, ProviderView> d = new HashMap();
  private ProviderContainerView.ProviderContainViewListener e;
  private ProviderView f;
  private View g;
  private int h;
  private View.OnClickListener i = new ProviderContainerView.1(this);
  
  public ProviderContainerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    paramInt = this.c.c(paramInt);
    if (paramInt == 100)
    {
      paramImageView.setContentDescription(HardCodeUtil.a(2131907493));
      return;
    }
    if (paramInt == 101) {
      paramImageView.setContentDescription(HardCodeUtil.a(2131907497));
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131627193, null);
    addView(localView);
    this.a = ((LinearLayout)localView.findViewById(2131435234));
    this.a.setGravity(0);
    this.b = ((FrameLayout)localView.findViewById(2131440787));
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.f.setAlpha(1.0F);
      this.f.setVisibility(8);
      this.f = null;
    }
    if (this.d.containsKey(Integer.valueOf(this.c.c(paramInt))))
    {
      localObject = (ProviderView)this.d.get(Integer.valueOf(this.c.c(paramInt)));
    }
    else
    {
      int j = this.c.c(paramInt);
      localObject = this.c.a(getContext(), j);
      if (localObject != null)
      {
        this.d.put(Integer.valueOf(this.c.c(paramInt)), localObject);
        this.b.addView((View)localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("build provider view failed ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (localObject != null)
    {
      if (!((ProviderView)localObject).B) {
        ((ProviderView)localObject).a(null);
      }
      this.f = ((ProviderView)localObject);
      this.f.setAlpha(1.0F);
      this.f.setVisibility(0);
      this.f.c();
    }
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.d.isEmpty())
    {
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.a.getChildCount()))
    {
      localObject = this.g;
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      this.g = this.a.getChildAt(paramInt);
      this.g.setSelected(true);
      c(paramInt);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOpenProviderView failed out bounds");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" size:");
      ((StringBuilder)localObject).append(this.a.getChildCount());
      QLog.e("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, List<Integer> paramList)
  {
    this.c = new ProviderViewBuilder(paramInt, paramList);
    this.a.removeAllViews();
    paramInt = 0;
    while (paramInt < this.c.a())
    {
      paramList = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      paramList.setTag(Integer.valueOf(paramInt));
      paramList.setId(this.c.b(paramInt));
      paramList.setImageResource(this.c.a(paramInt));
      paramList.setScaleType(ImageView.ScaleType.CENTER);
      paramList.setOnClickListener(this.i);
      a(paramList, paramInt);
      this.a.addView(paramList, localLayoutParams);
      paramInt += 1;
    }
    paramList = this.b.getLayoutParams();
    paramList.height = UIUtils.a(getContext(), 272.0F);
    this.b.setLayoutParams(paramList);
  }
  
  public void b(int paramInt)
  {
    String str;
    if (paramInt == 102) {
      str = "0X800B3D1";
    } else if (paramInt == 101) {
      str = "0X800B3CD";
    } else if (paramInt == 100) {
      str = "0X800B3CF";
    } else {
      str = null;
    }
    if (str != null) {
      EditActivityEntranceUtil.a(str, this.h);
    }
  }
  
  public void setEditActivityEntrance(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setProviderContainViewListener(ProviderContainerView.ProviderContainViewListener paramProviderContainViewListener)
  {
    this.e = paramProviderContainViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */