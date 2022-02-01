package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class QIMProviderContainerView
  extends AbsBottomPanal
{
  LinearLayout b;
  FrameLayout c;
  View d;
  View e;
  View f;
  public int g;
  boolean h = false;
  public boolean i = false;
  public boolean j = false;
  View.OnClickListener k = new QIMProviderContainerView.1(this);
  private QIMProviderViewBuilder l;
  private HashMap<Integer, ProviderView> m = new HashMap();
  private ProviderView n;
  private View o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private AbsQIMCaptureController s;
  private boolean t = true;
  private ArrayList<View> u = new ArrayList();
  private float v = 0.0F;
  private boolean w = false;
  private List<QIMProviderContainerView.ContainerViewListener2> x = new ArrayList();
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131627199, null);
    addView(localView);
    this.b = ((LinearLayout)localView.findViewById(2131435234));
    this.b.setGravity(0);
    this.c = ((FrameLayout)localView.findViewById(2131440787));
    this.d = localView.findViewById(2131432784);
    this.e = localView.findViewById(2131432783);
    this.f = localView.findViewById(2131449314);
    this.l = new QIMProviderViewBuilder(0);
    this.u.add(this.b);
    this.u.add(this.d);
    this.u.add(this.e);
    this.u.add(this.f);
  }
  
  private void a(int paramInt)
  {
    this.q = true;
    a(paramInt, true);
    paramInt = UIUtils.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    float f1 = paramInt;
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { f1, 0.0F }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F }));
    ((List)localObject1).add(QIMAnimationUtils.a(this.d, getResources().getColor(2131165794), 0, 153));
    ((List)localObject1).add(QIMAnimationUtils.a(this.e, getResources().getColor(2131165794), 0, 153));
    Object localObject2 = this.s.b.findViewById(2131449539);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { f1, 0.0F }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new QIMProviderContainerView.2(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = QIMAnimationUtils.a(this.n, 0.0F, 1.0F);
    ((Animation)localObject1).setStartOffset(200L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new QIMProviderContainerView.3(this));
    startAnimation((Animation)localObject1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.n.setAlpha(1.0F);
      this.n.setVisibility(8);
      this.n = null;
    }
    if (this.m.containsKey(Integer.valueOf(this.l.e(paramInt))))
    {
      localObject = (ProviderView)this.m.get(Integer.valueOf(this.l.e(paramInt)));
    }
    else
    {
      int i1 = this.l.e(paramInt);
      localObject = this.l.a(getContext(), i1);
      if (localObject != null)
      {
        this.m.put(Integer.valueOf(this.l.e(paramInt)), localObject);
        this.c.addView((View)localObject);
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
      if (!((ProviderView)localObject).B)
      {
        ((ProviderView)localObject).setProviderViewListener(this.s);
        ((ProviderView)localObject).setDoodleEventListener(this.s);
        ((ProviderView)localObject).a(null);
      }
      this.n = ((ProviderView)localObject);
      if (!paramBoolean)
      {
        this.n.setAlpha(1.0F);
        this.n.setVisibility(0);
      }
      else
      {
        this.n.setAlpha(1.0F);
        this.n.setVisibility(8);
      }
      if (this.n.getId() != 2131430308) {
        this.s.b(false);
      }
      localObject = this.x.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMProviderContainerView.ContainerViewListener2 localContainerViewListener2 = (QIMProviderContainerView.ContainerViewListener2)((Iterator)localObject).next();
        if (localContainerViewListener2 != null) {
          localContainerViewListener2.a(false);
        }
      }
      this.n.c();
      this.n.E = this.s.a;
    }
  }
  
  private void b()
  {
    ThreadManager.excute(new QIMProviderContainerView.7(this), 64, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!this.r)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("doOpenProviderView failed isInflated");
        paramString1.append(this.r);
        QLog.e("ProviderContainerView", 2, paramString1.toString());
      }
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.b.getChildCount()))
    {
      Object localObject = this.o;
      if (localObject != null)
      {
        ((View)localObject).setSelected(false);
        this.p = true;
      }
      this.o = this.b.getChildAt(paramInt1);
      this.o.setSelected(true);
      this.g = paramInt1;
      ((ImageView)this.o).setImageResource(this.l.a(paramInt1));
      if (!this.p) {
        a(paramInt1);
      } else {
        a(paramInt1, false);
      }
      localObject = this.s;
      if (localObject != null) {
        ((AbsQIMCaptureController)localObject).a(paramInt1, paramBoolean);
      }
      this.l.d(paramInt1);
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openSpecificTabByWeb tab_index= ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(",categoryId=");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(",categoryName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("itemId=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
        }
        this.n.a(paramInt2, paramString1, paramString2);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("doOpenProviderView failed out bounds");
      paramString1.append(paramInt1);
      paramString1.append(" size:");
      paramString1.append(this.b.getChildCount());
      QLog.e("ProviderContainerView", 2, paramString1.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, null, paramString, paramBoolean);
  }
  
  public int getCount()
  {
    return this.l.b();
  }
  
  public ProviderView getCurrentProviderView()
  {
    return this.n;
  }
  
  public ProviderView getCurrentProviderViewIndex()
  {
    return this.n;
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.a(paramBoolean);
    }
  }
  
  public void setCaptureControllerAndPreloadView(AbsQIMCaptureController paramAbsQIMCaptureController)
  {
    this.s = paramAbsQIMCaptureController;
    this.r = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.d(paramBoolean);
    }
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.f(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.c(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.b(paramBoolean);
    }
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.m.get(Integer.valueOf(104));
    if (localMusicProviderView != null) {
      localMusicProviderView.setIsGuideMode(paramBoolean);
    }
  }
  
  public void setMusicEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.l;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.e(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */