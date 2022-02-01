package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class BubbleNewAIOAnim
  extends AIOAnimationConatiner.AIOAnimator
{
  public String A = "";
  public String B = "";
  private final Resources C;
  private int D;
  private int E;
  private int F = 0;
  private int G = 0;
  private int H;
  private BubbleNewAIOAnim.AnimPicData I;
  private final Handler J = new Handler(Looper.getMainLooper());
  private int K = -1;
  private boolean L = true;
  public boolean d = true;
  public long e = -1L;
  public int f;
  public BubbleConfig g;
  public AnimationConfig h;
  public BubbleManager i;
  public ArrayList<BubbleNewAnimConf> j = new ArrayList();
  public int k;
  public BaseBubbleBuilder.ViewHolder l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public View r;
  public View s;
  public View t;
  public View u;
  public View v;
  public AnimatorSet w;
  public ConcurrentHashMap<String, Bitmap> x = new ConcurrentHashMap();
  public QQAppInterface y;
  AnimatorListenerAdapter z = new BubbleNewAIOAnim.3(this);
  
  public BubbleNewAIOAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.C = paramListView.getResources();
    this.q = AIOUtils.b(12.0F, paramListView.getContext().getResources());
    this.F = AIOUtils.b(50.0F, paramListView.getContext().getResources());
    this.G = AIOUtils.b(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(float paramFloat)
  {
    int i1 = Math.abs(this.n - this.m);
    if (paramFloat == 0.1F)
    {
      if (this.d) {
        i1 = this.n - this.q;
      } else {
        i1 = this.m + this.q;
      }
    }
    else
    {
      if (paramFloat == 0.9F)
      {
        if (this.d) {
          i1 = this.m + this.q;
        } else {
          i1 = this.n - this.q;
        }
        paramFloat = i1;
      }
      else
      {
        paramFloat = i1 * paramFloat;
        if (this.d) {
          paramFloat = this.n - paramFloat;
        } else {
          paramFloat = this.m + paramFloat;
        }
      }
      i1 = (int)paramFloat;
    }
    return i1 - this.D / 2;
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    label53:
    int i2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      while (i1 < this.j.size())
      {
        if (((BubbleNewAnimConf)this.j.get(i1)).a.equals(paramString)) {
          break label53;
        }
        i1 += 1;
      }
      i1 = -1;
      i2 = i1;
      if (i1 != -1)
      {
        BubbleNewAnimConf localBubbleNewAnimConf = (BubbleNewAnimConf)this.j.get(i1);
        paramString = null;
        if ((localBubbleNewAnimConf instanceof BubbleNewAnimConf.PathAnimConf)) {
          paramString = g((BubbleNewAnimConf.PathAnimConf)localBubbleNewAnimConf);
        }
        i2 = i1;
        if (paramAnimator != null)
        {
          i2 = i1;
          if (paramString != null)
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new BubbleNewAIOAnim.4(this, paramString));
            return i1;
          }
        }
      }
    }
    else
    {
      i2 = -1;
    }
    return i2;
  }
  
  private ObjectAnimator a(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    if (paramPathAnimConf == null) {
      return null;
    }
    File localFile = new File(this.i.d(this.f, false), this.h.a);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramPathAnimConf.d)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramPathAnimConf.e);
      i1 += 1;
      ((StringBuilder)localObject).append(String.format("%04d.png", new Object[] { Integer.valueOf(i1) }));
      localObject = ((StringBuilder)localObject).toString();
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.b = ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathAnimConf.a);
      localStringBuilder.append((String)localObject);
      localAnimPicData.a = localStringBuilder.toString();
      boolean bool;
      if (this.d) {
        bool = paramPathAnimConf.v;
      } else if (!paramPathAnimConf.v) {
        bool = true;
      } else {
        bool = false;
      }
      localAnimPicData.c = Boolean.valueOf(bool);
      localArrayList.add(localAnimPicData);
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf)
  {
    File localFile = new File(this.i.d(this.f, false), this.h.a);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramPendantAnimConf.d)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramPendantAnimConf.e);
      i1 += 1;
      ((StringBuilder)localObject).append(String.format("%04d.png", new Object[] { Integer.valueOf(i1) }));
      localObject = ((StringBuilder)localObject).toString();
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.b = ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPendantAnimConf.a);
      localStringBuilder.append((String)localObject);
      localAnimPicData.a = localStringBuilder.toString();
      localAnimPicData.c = Boolean.valueOf(this.d ^ true);
      localArrayList.add(localAnimPicData);
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List<BubbleNewAIOAnim.AnimPicData> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.I);
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1)
      {
        int i2 = i1 + 1;
        localObject[i2] = Keyframe.ofObject(i2 * f1, paramList.get(i1));
      }
      else
      {
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
      i1 += 1;
    }
    localObject = PropertyValuesHolder.ofKeyframe("bitmapData", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new BubbleNewAIOAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Bitmap a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      paramString = BubbleManager.a(paramString, null);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("BubbleNewAIOAnim", 4, "decode error!", paramString);
        return paramBitmap;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BubbleNewAIOAnim", 4, "decode error!", paramString);
      }
    }
    return paramBitmap;
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.l = ((BaseBubbleBuilder.ViewHolder)paramObject);
      return false;
    }
    return true;
  }
  
  private int b(float paramFloat)
  {
    int i1 = Math.abs(this.o - this.p);
    if (paramFloat == 0.1F) {
      i1 = this.o + this.q;
    } else if (paramFloat == 0.9F) {
      i1 = this.p - this.q;
    } else {
      i1 = (int)(this.o + i1 * paramFloat);
    }
    return i1 - this.E / 2;
  }
  
  private ObjectAnimator b(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.m);
    int i3 = b(paramPathAnimConf.n);
    int i4 = a(paramPathAnimConf.o);
    int i5 = b(paramPathAnimConf.p);
    int i1;
    if (this.d) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    Object localObject = new ArrayList();
    PathPoint localPathPoint = PathPoint.b(i2, i3);
    localPathPoint.c = (paramPathAnimConf.y * i1);
    localPathPoint.d = (paramPathAnimConf.w / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localPathPoint = PathPoint.a(i4, i5);
    localPathPoint.c = (paramPathAnimConf.z * i1);
    localPathPoint.d = (paramPathAnimConf.x / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
    ((ObjectAnimator)localObject).setInterpolator(c(paramPathAnimConf));
    float f1 = (Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.F;
    ((ObjectAnimator)localObject).setDuration(((float)paramPathAnimConf.b * f1));
    return localObject;
  }
  
  private ObjectAnimator b(BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf)
  {
    ObjectAnimator localObjectAnimator = a(paramPendantAnimConf);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new BubbleNewAIOAnim.6(this, paramPendantAnimConf));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List<BubbleNewAIOAnim.AnimPicData> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.I);
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1)
      {
        int i2 = i1 + 1;
        localObject[i2] = Keyframe.ofObject(i2 * f1, paramList.get(i1));
      }
      else
      {
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
      i1 += 1;
    }
    localObject = PropertyValuesHolder.ofKeyframe("pendantBitmap", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new BubbleNewAIOAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator c(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i1 = paramPathAnimConf.u;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return null;
        }
        return new DecelerateInterpolator();
      }
      return new AccelerateInterpolator();
    }
    return null;
  }
  
  private void c(List<Animator> paramList)
  {
    if (this.b.getFirstVisiblePosition() == 0)
    {
      Object localObject2 = null;
      int i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= this.j.size()) {
          break;
        }
        localObject1 = (BubbleNewAnimConf)this.j.get(i1);
        if ((localObject1 instanceof BubbleNewAnimConf.PathAnimConf))
        {
          localObject1 = (BubbleNewAnimConf.PathAnimConf)localObject1;
          break;
        }
        i1 += 1;
      }
      Object localObject1 = a((BubbleNewAnimConf.PathAnimConf)localObject1);
      if (localObject1 != null)
      {
        ((ObjectAnimator)localObject1).setDuration(200L);
        paramList.add(localObject1);
      }
    }
  }
  
  private ObjectAnimator d(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.m);
    int i3 = b(paramPathAnimConf.n);
    int i4 = a(paramPathAnimConf.o);
    int i5 = b(paramPathAnimConf.p);
    int i6 = a(paramPathAnimConf.q);
    int i7 = b(paramPathAnimConf.r);
    int i8 = a(paramPathAnimConf.s);
    int i9 = b(paramPathAnimConf.t);
    int i1;
    if (this.d) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    Object localObject = new ArrayList();
    PathPoint localPathPoint = PathPoint.b(i2, i3);
    localPathPoint.d = paramPathAnimConf.w;
    localPathPoint.c = (paramPathAnimConf.y * i1);
    ((ArrayList)localObject).add(localPathPoint);
    float f1 = i6;
    float f2 = i7;
    float f3 = i8;
    float f4 = i9;
    float f5 = i4;
    float f6 = i5;
    localPathPoint = PathPoint.a(f1, f2, f3, f4, f5, f6);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play circle points: ");
    localStringBuilder.append(PathPoint.a(f1, f2, f3, f4, f5, f6).toString());
    a(localStringBuilder.toString());
    localPathPoint.c = (paramPathAnimConf.z * i1);
    localPathPoint.d = (paramPathAnimConf.x / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
    ((ObjectAnimator)localObject).setInterpolator(c(paramPathAnimConf));
    f1 = (Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.F;
    double d1 = (float)paramPathAnimConf.b * f1;
    Double.isNaN(d1);
    ((ObjectAnimator)localObject).setDuration((d1 * 3.141592653589793D * 0.4000000059604645D));
    return localObject;
  }
  
  private ObjectAnimator e(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i4 = a(paramPathAnimConf.m);
    int i7 = b(paramPathAnimConf.n);
    int i2 = a(paramPathAnimConf.o);
    if (i7 != b(paramPathAnimConf.p)) {
      return null;
    }
    int i1;
    if (i2 > i4) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    int i5 = this.F * paramPathAnimConf.B;
    i2 = i4 - i2;
    int i6 = Math.abs(i2);
    int i3 = (int)(Math.abs(i2) * 1.0F / i5 + 0.5F);
    i2 = i3;
    if (i3 == 0) {
      i2 = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playPeriodicalCircleAnim, periodLen: ");
    ((StringBuilder)localObject).append(i5);
    ((StringBuilder)localObject).append(", period: ");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(", resize periodLen: ");
    i5 = i6 / i2;
    ((StringBuilder)localObject).append(i5);
    a(((StringBuilder)localObject).toString());
    float f2 = i4;
    float f3 = i5;
    float f1 = paramPathAnimConf.q;
    float f4 = i1;
    i6 = (int)(f1 * f3 * f4 + f2);
    f1 = i7;
    int i8 = (int)(paramPathAnimConf.r * f3 + f1);
    i7 = (int)(paramPathAnimConf.s * f3 * f4 + f2);
    int i9 = (int)(f3 * paramPathAnimConf.t + f1);
    i3 = i4 + i5 * i1;
    localObject = new ArrayList();
    ((ArrayList)localObject).add(PathPoint.b(f2, f1));
    f4 = i6;
    f2 = i8;
    float f5 = i7;
    f3 = i9;
    float f6 = i3;
    ((ArrayList)localObject).add(PathPoint.a(f4, f2, f5, f3, f6, f1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("next points: ");
    localStringBuilder.append(PathPoint.a(f4, f2, f5, f3, f6, f1).toString());
    a(localStringBuilder.toString());
    i4 = 1;
    while (i4 < i2)
    {
      i8 = i1 * i4 * i5;
      f4 = i8 + i6;
      f5 = i8 + i7;
      f6 = i8 + i3;
      ((ArrayList)localObject).add(PathPoint.a(f4, f2, f5, f3, f6, f1));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("next points: ");
      localStringBuilder.append(PathPoint.a(f4, f2, f5, f3, f6, f1).toString());
      a(localStringBuilder.toString());
      i4 += 1;
    }
    localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
    ((ObjectAnimator)localObject).setInterpolator(c(paramPathAnimConf));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration: ");
    long l1 = paramPathAnimConf.b;
    long l2 = i2;
    double d1 = l1 * l2;
    Double.isNaN(d1);
    localStringBuilder.append(d1 * 3.141592653589793D * 0.4000000059604645D);
    a(localStringBuilder.toString());
    d1 = paramPathAnimConf.b * l2;
    Double.isNaN(d1);
    ((ObjectAnimator)localObject).setDuration((d1 * 3.141592653589793D * 0.4000000059604645D));
    return localObject;
  }
  
  private boolean e()
  {
    this.i = ((BubbleManager)this.y.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
    return (this.i == null) || (this.e == 0L);
  }
  
  private ObjectAnimator f(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i1 = a(paramPathAnimConf.m);
    int i2 = b(paramPathAnimConf.n);
    int i3 = a(paramPathAnimConf.o);
    int i4 = b(paramPathAnimConf.p);
    if ((i1 != i3) && (i2 != i4)) {
      return null;
    }
    if (i2 == i4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return e(paramPathAnimConf);
    }
    return null;
  }
  
  private boolean f()
  {
    this.j = this.h.w;
    ArrayList localArrayList = this.j;
    return (localArrayList == null) || (localArrayList.size() == 0);
  }
  
  private ObjectAnimator g(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    ObjectAnimator localObjectAnimator1 = h(paramPathAnimConf);
    ObjectAnimator localObjectAnimator2 = a(paramPathAnimConf);
    if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null))
    {
      if ((paramPathAnimConf.m == paramPathAnimConf.o) && (paramPathAnimConf.n == paramPathAnimConf.p))
      {
        localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
        int i1;
        if (paramPathAnimConf.c - 1 >= 0) {
          i1 = paramPathAnimConf.c - 1;
        } else {
          i1 = 0;
        }
        localObjectAnimator1.setRepeatCount(i1);
      }
      else
      {
        localObjectAnimator2.setRepeatCount(-1);
      }
      localObjectAnimator1.addListener(new BubbleNewAIOAnim.5(this, localObjectAnimator2));
      return localObjectAnimator1;
    }
    return null;
  }
  
  private void g()
  {
    Object localObject = this.s;
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      localObject = (ViewGroup)localObject;
      int i1 = 0;
      while (i1 < ((ViewGroup)localObject).getChildCount())
      {
        View localView = ((ViewGroup)localObject).getChildAt(i1);
        if ((localView.getId() == 2131430599) && (localView.getVisibility() == 0))
        {
          this.v = localView;
          this.u = new View(this.b.getContext());
          this.u.layout(0, 0, AIOUtils.b(50.0F, this.C), AIOUtils.b(59.0F, this.C));
          this.a.addView(this.u);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private ObjectAnimator h(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    if ((paramPathAnimConf.q == 0.0F) && (paramPathAnimConf.r == 0.0F) && (paramPathAnimConf.s == 0.0F) && (paramPathAnimConf.t == 0.0F)) {
      return b(paramPathAnimConf);
    }
    if (paramPathAnimConf.A) {
      return f(paramPathAnimConf);
    }
    return d(paramPathAnimConf);
  }
  
  private void h()
  {
    this.m = (this.r.getLeft() + BaseChatItemLayout.getBubblePaddingAlignHead());
    this.n = (this.r.getRight() - BaseChatItemLayout.getBubblePaddingAlignHead());
    this.o = (this.r.getTop() + BaseChatItemLayout.k);
    this.p = (this.r.getBottom() - BaseChatItemLayout.l);
    this.o += this.h.q / 2;
    this.p -= this.h.r / 2;
    this.m += this.h.o / 2;
    this.n -= this.h.p / 2;
    if (this.p <= this.o)
    {
      this.o = (this.r.getTop() + BaseChatItemLayout.k);
      this.p = (this.r.getBottom() - BaseChatItemLayout.l);
    }
    if (this.n <= this.m)
    {
      this.m = (this.r.getLeft() + BaseChatItemLayout.getBubblePaddingAlignHead());
      this.n = (this.r.getRight() - BaseChatItemLayout.getBubblePaddingAlignHead());
    }
    if (this.f == 160)
    {
      this.m = (this.r.getLeft() + BaseChatItemLayout.getBubblePaddingAlignHead() - this.D / 3);
      this.n = (this.r.getRight() - BaseChatItemLayout.getBubblePaddingAlignHead() + this.D / 3);
      this.o = (this.r.getTop() + BaseChatItemLayout.k - this.E / 3);
      this.p = (this.r.getBottom() - BaseChatItemLayout.l + this.E / 3);
    }
  }
  
  private void i()
  {
    boolean bool = false;
    int i1 = 0;
    while (i1 < this.j.size())
    {
      localObject1 = (BubbleNewAnimConf)this.j.get(i1);
      if ((localObject1 instanceof BubbleNewAnimConf.PathAnimConf))
      {
        localObject1 = (BubbleNewAnimConf.PathAnimConf)localObject1;
        break label51;
      }
      i1 += 1;
    }
    Object localObject1 = null;
    label51:
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new File(this.i.d(this.f, false), this.h.a);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject2).getAbsolutePath());
    ((StringBuilder)localObject3).append(File.separatorChar);
    ((StringBuilder)localObject3).append(((BubbleNewAnimConf.PathAnimConf)localObject1).e);
    ((StringBuilder)localObject3).append(String.format("%04d.png", new Object[] { Integer.valueOf(1) }));
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
    BubbleManager.a((String)localObject2, (BitmapFactory.Options)localObject3);
    this.D = Utils.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.C.getDisplayMetrics().densityDpi);
    this.E = Utils.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.C.getDisplayMetrics().densityDpi);
    if (this.D > BaseChatItemLayout.getBubblePaddingAlignHead() * 2)
    {
      i1 = BaseChatItemLayout.getBubblePaddingAlignHead() * 2;
      this.E = ((int)(this.E * i1 * 1.0F / this.D));
      this.D = i1;
    }
    localObject3 = new View(this.b.getContext());
    ((View)localObject3).layout(0, 0, this.D, this.E);
    ((View)localObject3).setVisibility(4);
    this.I = new BubbleNewAIOAnim.AnimPicData();
    BubbleNewAIOAnim.AnimPicData localAnimPicData = this.I;
    localAnimPicData.b = ((String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BubbleNewAnimConf.PathAnimConf)localObject1).a);
    localStringBuilder.append((String)localObject2);
    localAnimPicData.a = localStringBuilder.toString();
    localObject2 = this.I;
    if (this.d) {
      bool = ((BubbleNewAnimConf.PathAnimConf)localObject1).v;
    } else if (!((BubbleNewAnimConf.PathAnimConf)localObject1).v) {
      bool = true;
    }
    ((BubbleNewAIOAnim.AnimPicData)localObject2).c = Boolean.valueOf(bool);
    this.a.addView((View)localObject3);
    this.t = ((View)localObject3);
  }
  
  private void j()
  {
    this.w = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    c(localArrayList);
    int i3 = 0;
    int i1 = -1;
    while (i3 < this.j.size())
    {
      if (i3 != i1)
      {
        Object localObject2 = (BubbleNewAnimConf)this.j.get(i3);
        Object localObject1 = null;
        int i2;
        if ((localObject2 instanceof BubbleNewAnimConf.PathAnimConf))
        {
          localObject1 = g((BubbleNewAnimConf.PathAnimConf)localObject2);
          i2 = i1;
        }
        else
        {
          i2 = i1;
          if ((localObject2 instanceof BubbleNewAnimConf.PendantAnimConf))
          {
            BubbleNewAnimConf.PendantAnimConf localPendantAnimConf = (BubbleNewAnimConf.PendantAnimConf)localObject2;
            localObject2 = b(localPendantAnimConf);
            if (localObject2 != null)
            {
              if (localPendantAnimConf.c - 1 >= 0) {
                i2 = localPendantAnimConf.c - 1;
              } else {
                i2 = 0;
              }
              ((ObjectAnimator)localObject2).setRepeatCount(i2);
            }
            i2 = i1;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localPendantAnimConf.m))
            {
              i2 = a((Animator)localObject2, localPendantAnimConf.m);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null)
        {
          i1 = i2;
        }
        else
        {
          localArrayList.add(localObject1);
          i1 = i2;
        }
      }
      i3 += 1;
    }
    this.w.playSequentially(localArrayList);
    this.w.addListener(this.z);
    this.J.post(new BubbleNewAIOAnim.2(this));
  }
  
  private void k()
  {
    ThreadManager.post(new BubbleNewAIOAnim.7(this), 5, null, true);
  }
  
  protected void a(int paramInt)
  {
    View localView = this.t;
    if (localView != null) {
      localView.setTranslationY(localView.getTranslationY() + paramInt);
    }
    localView = this.u;
    if ((localView != null) && (this.v != null))
    {
      paramInt = (int)(localView.getTranslationY() + paramInt);
      this.u.setTranslationY(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleNewAIOAnim", 4, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.L == paramBoolean) {
      return;
    }
    this.L = paramBoolean;
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((BaseBubbleBuilder.ViewHolder)localObject).i != null) {
        localObject = this.l.i.j;
      } else {
        localObject = null;
      }
      if ((localObject != null) && (this.h.s))
      {
        localObject = this.l.h.getBackground();
        if ((localObject instanceof VipBubbleDrawable))
        {
          if (paramBoolean)
          {
            ((VipBubbleDrawable)localObject).c(true);
            return;
          }
          ((VipBubbleDrawable)localObject).c(false);
        }
      }
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = AIOUtils.a(this.e, this.b.getAdapter());
    Object localObject1 = AIOUtils.b(AIOUtils.a(this.b, this.k));
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.l = ((BaseBubbleBuilder.ViewHolder)localObject1);
      this.r = this.l.h;
      this.s = ((View)this.r.getParent());
      localObject2 = this.s;
      if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)localObject2;
        paramInt1 = 0;
      }
    }
    else
    {
      while (paramInt1 < ((ViewGroup)localObject2).getChildCount())
      {
        View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
        if (localView.getId() == 2131430599)
        {
          this.v = localView;
        }
        else
        {
          paramInt1 += 1;
          continue;
          c();
        }
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("relayout children,  p : ");
    ((StringBuilder)localObject2).append(this.k);
    ((StringBuilder)localObject2).append(", get object: ");
    if (localObject1 != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((StringBuilder)localObject2).append(paramBoolean);
    a(((StringBuilder)localObject2).toString());
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    AnimatorSet localAnimatorSet = this.w;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      return false;
    }
    if (!VersionUtils.e()) {
      return false;
    }
    this.K = ((Integer)paramVarArgs[0]).intValue();
    this.e = ((Long)paramVarArgs[1]).longValue();
    this.f = ((Integer)paramVarArgs[2]).intValue();
    this.y = ((QQAppInterface)paramVarArgs[3]);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("start msg id ");
    paramVarArgs.append(this.e);
    a(paramVarArgs.toString());
    if (this.y == null) {
      return false;
    }
    if (e()) {
      return false;
    }
    this.g = this.i.a(this.f, false);
    if (this.g == null) {
      return false;
    }
    this.h = this.i.b(this.f, this.K);
    if (this.h == null) {
      return false;
    }
    if (f()) {
      return false;
    }
    this.k = AIOUtils.a(this.e, this.b.getAdapter());
    if (a(AIOUtils.b(AIOUtils.a(this.b, this.k)))) {
      return false;
    }
    this.d = this.l.q.isSend();
    this.r = this.l.h;
    this.s = ((View)this.r.getParent());
    this.H = this.a.getWidth();
    k();
    i();
    h();
    g();
    j();
    return true;
  }
  
  protected boolean b(int paramInt)
  {
    return true;
  }
  
  protected void c()
  {
    a("now stop new bubble animation conf!");
    this.J.post(new BubbleNewAIOAnim.1(this));
  }
  
  public void setBitmapData(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {
      return;
    }
    if ((this.r != null) && (this.t != null))
    {
      if (this.A.equalsIgnoreCase(paramAnimPicData.a)) {
        return;
      }
      Object localObject;
      if (paramAnimPicData.d != null)
      {
        localObject = new AnimatorPathDrawable(paramAnimPicData.d);
        ((AnimatorPathDrawable)localObject).b = paramAnimPicData.c.booleanValue();
        this.t.setBackgroundDrawable((Drawable)localObject);
        this.A = paramAnimPicData.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set bitmap path:");
        ((StringBuilder)localObject).append(paramAnimPicData.a);
        a(((StringBuilder)localObject).toString());
        this.t.invalidate();
        return;
      }
      if (this.x.containsKey(paramAnimPicData.a))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get cache bitmap path:");
        ((StringBuilder)localObject).append(paramAnimPicData.a);
        a(((StringBuilder)localObject).toString());
        localObject = (Bitmap)this.x.get(paramAnimPicData.a);
        if (localObject != null)
        {
          localObject = new AnimatorPathDrawable((Bitmap)localObject);
          ((AnimatorPathDrawable)localObject).b = paramAnimPicData.c.booleanValue();
          this.t.setBackgroundDrawable((Drawable)localObject);
          this.A = paramAnimPicData.a;
          this.t.invalidate();
        }
      }
      return;
    }
    c();
  }
  
  public void setPathLocation(PathPoint paramPathPoint)
  {
    View localView = this.r;
    if ((localView != null) && (this.t != null))
    {
      this.s = ((View)localView.getParent());
      int i1 = this.a.getWidth();
      float f1;
      if (this.d) {
        f1 = paramPathPoint.a + (i1 - this.H);
      } else {
        f1 = paramPathPoint.a;
      }
      float f2 = paramPathPoint.b + this.s.getTop() - this.b.getScrollY();
      if (f2 < this.b.getTop() - this.t.getHeight())
      {
        a("setPathLocation: now scroll over sreen, stop bubble animatorset!");
        paramPathPoint = new StringBuilder();
        paramPathPoint.append("now listview firstVisible postion: ");
        paramPathPoint.append(this.b.getFirstVisiblePosition());
        paramPathPoint.append(", last postion: ");
        paramPathPoint.append(this.b.getLastVisiblePosition());
        paramPathPoint.append(", now msg pos: ");
        paramPathPoint.append(this.k);
        a(paramPathPoint.toString());
        c();
        return;
      }
      this.t.setTranslationX(f1);
      this.t.setTranslationY(f2);
      this.t.setAlpha(paramPathPoint.d);
      this.t.setRotation(paramPathPoint.c);
      return;
    }
    c();
  }
  
  public void setPendantBitmap(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {
      return;
    }
    if (this.u != null)
    {
      Object localObject = this.v;
      if (localObject != null)
      {
        int i1 = ((View)localObject).getLeft();
        this.u.setTranslationX(i1);
        i1 = this.v.getTop();
        int i2 = this.s.getTop();
        int i3 = this.b.getScrollY();
        this.u.setTranslationY(i1 + i2 - i3);
        if ((this.k <= this.b.getLastVisiblePosition()) && (this.k >= this.b.getFirstVisiblePosition()))
        {
          if (this.B.equalsIgnoreCase(paramAnimPicData.a)) {
            return;
          }
          if (paramAnimPicData.d != null)
          {
            localObject = new AnimatorPathDrawable(paramAnimPicData.d);
            this.B = paramAnimPicData.a;
            ((AnimatorPathDrawable)localObject).b = paramAnimPicData.c.booleanValue();
            this.u.setBackgroundDrawable((Drawable)localObject);
            this.u.invalidate();
            return;
          }
          if (this.x.containsKey(paramAnimPicData.a))
          {
            localObject = (Bitmap)this.x.get(paramAnimPicData.a);
            if (localObject != null)
            {
              localObject = new AnimatorPathDrawable((Bitmap)localObject);
              this.B = paramAnimPicData.a;
              ((AnimatorPathDrawable)localObject).b = paramAnimPicData.c.booleanValue();
              this.u.setBackgroundDrawable((Drawable)localObject);
              this.u.invalidate();
            }
          }
          return;
        }
        a("setPendantBitmap: now scroll over sreen, stop pendant animatorset!");
        c();
        return;
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim
 * JD-Core Version:    0.7.0.1
 */