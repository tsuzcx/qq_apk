package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a = new ViewGroup.LayoutParams(-2, -2);
  public static ClassLoader b = AIOAnimationConatiner.class.getClassLoader();
  private AIOAnimationConatiner.AIOAnimator c;
  private List<AIOAnimationConatiner.AIOAnimator> d;
  private int e;
  private ListView f;
  
  public AIOAnimationConatiner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AIOAnimationConatiner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private AIOAnimationConatiner.AIOAnimator d(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 7)
              {
                if (paramInt != 8)
                {
                  if (paramInt != 9) {
                    return null;
                  }
                  return new DigitLottieAnimation(paramInt, this, this.f);
                }
                return new BusinessEggsAnimation(paramInt, this, this.f);
              }
              return new LottieAnimation(paramInt, this, this.f);
            }
            return new BubbleInterActiveAnim(paramInt, this, this.f);
          }
          return new PathAnimation(paramInt, this, this.f);
        }
        return new FloorJumperSet(paramInt, this, this.f);
      }
      return new ComboAnimation3(paramInt, this, this.f);
    }
    return new BubbleAnimation(paramInt, this, this.f);
  }
  
  private void g()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).c);
      }
      this.d.clear();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.c = null;
    List localList = this.d;
    if ((localList == null) || (localList.size() == 0))
    {
      removeAllViewsInLayout();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationConatiner", 2, "[end] removeAllViews");
      }
    }
    invalidate();
  }
  
  public void a()
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.c;
    if (localAIOAnimator != null) {
      localAIOAnimator.c();
    }
    h();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = this.d;
      if ((localObject == null) || (i >= ((List)localObject).size())) {
        break;
      }
      localObject = (AIOAnimationConatiner.AIOAnimator)this.d.get(i);
      if ((localObject != null) && (paramInt == ((AIOAnimationConatiner.AIOAnimator)localObject).c)) {
        break label61;
      }
      i += 1;
    }
    Object localObject = null;
    i = -1;
    label61:
    if (i != -1)
    {
      ((AIOAnimationConatiner.AIOAnimator)localObject).c();
      this.d.remove(i);
    }
    localObject = this.d;
    if (((localObject == null) || (((List)localObject).size() == 0)) && (this.c == null))
    {
      removeAllViewsInLayout();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationConatiner", 2, "[stopConcurrentAnimation] removeAllViews");
      }
    }
    invalidate();
  }
  
  public void a(ListView paramListView)
  {
    AssertUtils.checkNotNull(paramListView);
    ListView localListView = this.f;
    if (localListView == paramListView)
    {
      SLog.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (localListView != null)
    {
      SLog.e("AIOAnimationConatiner", "attach and override listView!");
      f();
    }
    this.f = paramListView;
    this.f.addOnLayoutChangeListener(this);
  }
  
  public boolean a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.c;
    boolean bool1 = false;
    if ((localAIOAnimator != null) && (paramInt2 < localAIOAnimator.c)) {
      return false;
    }
    localAIOAnimator = this.c;
    if ((localAIOAnimator != null) && (paramInt2 == localAIOAnimator.c) && (this.c.b(paramInt1))) {
      return this.c.a(paramVarArgs);
    }
    if (this.c != null) {
      a();
    }
    this.e = paramInt1;
    this.c = d(paramInt1);
    localAIOAnimator = this.c;
    if (localAIOAnimator != null)
    {
      localAIOAnimator.c = paramInt2;
      boolean bool2 = localAIOAnimator.a(paramVarArgs);
      bool1 = bool2;
      if (!bool2)
      {
        this.c = null;
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    g();
    a();
  }
  
  public void b(int paramInt)
  {
    if ((this.c != null) && (paramInt == this.e)) {
      a();
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIOAnimationConatiner.AIOAnimator localAIOAnimator = (AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next();
      if ((paramInt1 == localAIOAnimator.c) && (localAIOAnimator.b(paramInt1)))
      {
        localAIOAnimator.a(paramVarArgs);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[concurrentStartAnimation] reuse animator, type: ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("AIOAnimationConatiner", 2, ((StringBuilder)localObject).toString());
        }
        paramInt2 = 1;
        break label124;
      }
    }
    paramInt2 = 0;
    label124:
    if (paramInt2 == 0)
    {
      localObject = d(paramInt1);
      if (localObject == null) {
        return false;
      }
      this.d.add(localObject);
      ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramVarArgs);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("[concurrentStartAnimation] create new animator, type: ");
        paramVarArgs.append(paramInt1);
        QLog.d("AIOAnimationConatiner", 2, paramVarArgs.toString());
      }
    }
    return true;
  }
  
  public void c(int paramInt)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.c;
    if (localAIOAnimator != null) {
      localAIOAnimator.a(paramInt);
    }
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).a();
    }
    localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).a();
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).b();
    }
    localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void f()
  {
    ListView localListView = this.f;
    if (localListView == null) {
      return;
    }
    localListView.removeOnLayoutChangeListener(this);
    this.f = null;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    Object localObject = paramView.getTag();
    if ((VersionUtils.e()) && ((localObject instanceof AnimationPath.Values)))
    {
      localObject = (AnimationPath.Values)localObject;
      if (((AnimationPath.Values)localObject).k)
      {
        Matrix localMatrix = paramTransformation.getMatrix();
        localMatrix.reset();
        int i = paramView.getWidth() / 2;
        int j = paramView.getHeight() / 2;
        float f1 = ((AnimationPath.Values)localObject).c;
        float f2 = i;
        float f3 = j;
        localMatrix.preRotate(f1, f2, f3);
        localMatrix.preScale(((AnimationPath.Values)localObject).f, ((AnimationPath.Values)localObject).g, f3, f3);
        paramTransformation.setAlpha(((AnimationPath.Values)localObject).i);
        return true;
      }
    }
    return false;
  }
  
  public ListView getListView()
  {
    return this.f;
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ListView localListView = this.f;
    if (localListView != null) {
      localListView.removeOnLayoutChangeListener(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.c;
    if (localAIOAnimator != null) {
      localAIOAnimator.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.c != null)
    {
      boolean bool;
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        bool = false;
      } else {
        bool = true;
      }
      this.c.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */