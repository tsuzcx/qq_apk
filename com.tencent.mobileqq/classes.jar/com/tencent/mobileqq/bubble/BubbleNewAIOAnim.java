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
  public long a;
  AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new BubbleNewAIOAnim.3(this);
  public AnimatorSet a;
  private final Resources jdField_a_of_type_AndroidContentResResources;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public View a;
  public BaseBubbleBuilder.ViewHolder a;
  public QQAppInterface a;
  public AnimationConfig a;
  public BubbleConfig a;
  public BubbleManager a;
  private BubbleNewAIOAnim.AnimPicData jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData;
  public String a;
  public ArrayList<BubbleNewAnimConf> a;
  public ConcurrentHashMap<String, Bitmap> a;
  public boolean a;
  public int b;
  public View b;
  public String b;
  private boolean b;
  public int c;
  public View c;
  public int d;
  public View d;
  public int e;
  public View e;
  public int f;
  public int g;
  public int h;
  private int i;
  private int j;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n = -1;
  
  public BubbleNewAIOAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentResResources = paramListView.getResources();
    this.jdField_h_of_type_Int = AIOUtils.b(12.0F, paramListView.getContext().getResources());
    this.k = AIOUtils.b(50.0F, paramListView.getContext().getResources());
    this.l = AIOUtils.b(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
    if (paramFloat == 0.1F)
    {
      if (this.jdField_a_of_type_Boolean) {
        i1 = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int;
      } else {
        i1 = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int;
      }
    }
    else
    {
      if (paramFloat == 0.9F)
      {
        if (this.jdField_a_of_type_Boolean) {
          i1 = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int;
        } else {
          i1 = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int;
        }
        paramFloat = i1;
      }
      else
      {
        paramFloat = i1 * paramFloat;
        if (this.jdField_a_of_type_Boolean) {
          paramFloat = this.jdField_e_of_type_Int - paramFloat;
        } else {
          paramFloat = this.jdField_d_of_type_Int + paramFloat;
        }
      }
      i1 = (int)paramFloat;
    }
    return i1 - this.i / 2;
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    label53:
    int i2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          break label53;
        }
        i1 += 1;
      }
      i1 = -1;
      i2 = i1;
      if (i1 != -1)
      {
        BubbleNewAnimConf localBubbleNewAnimConf = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        paramString = null;
        if ((localBubbleNewAnimConf instanceof BubbleNewAnimConf.PathAnimConf)) {
          paramString = f((BubbleNewAnimConf.PathAnimConf)localBubbleNewAnimConf);
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
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramPathAnimConf.jdField_b_of_type_Int)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramPathAnimConf.jdField_b_of_type_JavaLangString);
      i1 += 1;
      ((StringBuilder)localObject).append(String.format("%04d.png", new Object[] { Integer.valueOf(i1) }));
      localObject = ((StringBuilder)localObject).toString();
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.jdField_b_of_type_JavaLangString = ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathAnimConf.jdField_a_of_type_JavaLangString);
      localStringBuilder.append((String)localObject);
      localAnimPicData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = paramPathAnimConf.jdField_b_of_type_Boolean;
      } else if (!paramPathAnimConf.jdField_b_of_type_Boolean) {
        bool = true;
      } else {
        bool = false;
      }
      localAnimPicData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      localArrayList.add(localAnimPicData);
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramPendantAnimConf.jdField_b_of_type_Int)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramPendantAnimConf.jdField_b_of_type_JavaLangString);
      i1 += 1;
      ((StringBuilder)localObject).append(String.format("%04d.png", new Object[] { Integer.valueOf(i1) }));
      localObject = ((StringBuilder)localObject).toString();
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.jdField_b_of_type_JavaLangString = ((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPendantAnimConf.jdField_a_of_type_JavaLangString);
      localStringBuilder.append((String)localObject);
      localAnimPicData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      localAnimPicData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_Boolean ^ true);
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
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData);
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
  
  private Interpolator a(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i1 = paramPathAnimConf.jdField_e_of_type_Int;
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
  
  private void a(List<Animator> paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() == 0)
    {
      Object localObject2 = null;
      int i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject1 = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
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
  
  private boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
    return (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null) || (this.jdField_a_of_type_Long == 0L);
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)paramObject);
      return false;
    }
    return true;
  }
  
  private int b(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_f_of_type_Int - this.jdField_g_of_type_Int);
    if (paramFloat == 0.1F) {
      i1 = this.jdField_f_of_type_Int + this.jdField_h_of_type_Int;
    } else if (paramFloat == 0.9F) {
      i1 = this.jdField_g_of_type_Int - this.jdField_h_of_type_Int;
    } else {
      i1 = (int)(this.jdField_f_of_type_Int + i1 * paramFloat);
    }
    return i1 - this.j / 2;
  }
  
  private ObjectAnimator b(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i3 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i4 = a(paramPathAnimConf.jdField_c_of_type_Float);
    int i5 = b(paramPathAnimConf.d);
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    Object localObject = new ArrayList();
    PathPoint localPathPoint = PathPoint.b(i2, i3);
    localPathPoint.jdField_c_of_type_Float = (paramPathAnimConf.jdField_h_of_type_Int * i1);
    localPathPoint.d = (paramPathAnimConf.jdField_f_of_type_Int / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localPathPoint = PathPoint.a(i4, i5);
    localPathPoint.jdField_c_of_type_Float = (paramPathAnimConf.i * i1);
    localPathPoint.d = (paramPathAnimConf.jdField_g_of_type_Int / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
    ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
    float f1 = (Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k;
    ((ObjectAnimator)localObject).setDuration(((float)paramPathAnimConf.jdField_a_of_type_Long * f1));
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
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData);
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
  
  private boolean b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList == null) || (localArrayList.size() == 0);
  }
  
  private ObjectAnimator c(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i3 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i4 = a(paramPathAnimConf.jdField_c_of_type_Float);
    int i5 = b(paramPathAnimConf.d);
    int i6 = a(paramPathAnimConf.jdField_e_of_type_Float);
    int i7 = b(paramPathAnimConf.jdField_f_of_type_Float);
    int i8 = a(paramPathAnimConf.jdField_g_of_type_Float);
    int i9 = b(paramPathAnimConf.jdField_h_of_type_Float);
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    Object localObject = new ArrayList();
    PathPoint localPathPoint = PathPoint.b(i2, i3);
    localPathPoint.d = paramPathAnimConf.jdField_f_of_type_Int;
    localPathPoint.jdField_c_of_type_Float = (paramPathAnimConf.jdField_h_of_type_Int * i1);
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
    localPathPoint.jdField_c_of_type_Float = (paramPathAnimConf.i * i1);
    localPathPoint.d = (paramPathAnimConf.jdField_g_of_type_Int / 100.0F);
    ((ArrayList)localObject).add(localPathPoint);
    localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
    ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
    f1 = (Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k;
    double d1 = (float)paramPathAnimConf.jdField_a_of_type_Long * f1;
    Double.isNaN(d1);
    ((ObjectAnimator)localObject).setDuration((d1 * 3.141592653589793D * 0.4000000059604645D));
    return localObject;
  }
  
  private ObjectAnimator d(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i4 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i7 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i2 = a(paramPathAnimConf.jdField_c_of_type_Float);
    if (i7 != b(paramPathAnimConf.d)) {
      return null;
    }
    int i1;
    if (i2 > i4) {
      i1 = 1;
    } else {
      i1 = -1;
    }
    int i5 = this.k * paramPathAnimConf.j;
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
    float f1 = paramPathAnimConf.jdField_e_of_type_Float;
    float f4 = i1;
    i6 = (int)(f1 * f3 * f4 + f2);
    f1 = i7;
    int i8 = (int)(paramPathAnimConf.jdField_f_of_type_Float * f3 + f1);
    i7 = (int)(paramPathAnimConf.jdField_g_of_type_Float * f3 * f4 + f2);
    int i9 = (int)(f3 * paramPathAnimConf.jdField_h_of_type_Float + f1);
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
    ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("duration: ");
    long l1 = paramPathAnimConf.jdField_a_of_type_Long;
    long l2 = i2;
    double d1 = l1 * l2;
    Double.isNaN(d1);
    localStringBuilder.append(d1 * 3.141592653589793D * 0.4000000059604645D);
    a(localStringBuilder.toString());
    d1 = paramPathAnimConf.jdField_a_of_type_Long * l2;
    Double.isNaN(d1);
    ((ObjectAnimator)localObject).setDuration((d1 * 3.141592653589793D * 0.4000000059604645D));
    return localObject;
  }
  
  private ObjectAnimator e(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i1 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i2 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i3 = a(paramPathAnimConf.jdField_c_of_type_Float);
    int i4 = b(paramPathAnimConf.d);
    if ((i1 != i3) && (i2 != i4)) {
      return null;
    }
    if (i2 == i4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return d(paramPathAnimConf);
    }
    return null;
  }
  
  private void e()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      localObject = (ViewGroup)localObject;
      int i1 = 0;
      while (i1 < ((ViewGroup)localObject).getChildCount())
      {
        View localView = ((ViewGroup)localObject).getChildAt(i1);
        if ((localView.getId() == 2131364541) && (localView.getVisibility() == 0))
        {
          this.jdField_e_of_type_AndroidViewView = localView;
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          this.jdField_d_of_type_AndroidViewView.layout(0, 0, AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.b(59.0F, this.jdField_a_of_type_AndroidContentResResources));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_d_of_type_AndroidViewView);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private ObjectAnimator f(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    ObjectAnimator localObjectAnimator1 = g(paramPathAnimConf);
    ObjectAnimator localObjectAnimator2 = a(paramPathAnimConf);
    if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null))
    {
      if ((paramPathAnimConf.jdField_a_of_type_Float == paramPathAnimConf.jdField_c_of_type_Float) && (paramPathAnimConf.jdField_b_of_type_Float == paramPathAnimConf.d))
      {
        localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
        int i1;
        if (paramPathAnimConf.jdField_a_of_type_Int - 1 >= 0) {
          i1 = paramPathAnimConf.jdField_a_of_type_Int - 1;
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
  
  private void f()
  {
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.j);
    this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.j);
    this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_h_of_type_Int);
    this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.i);
    this.jdField_f_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_h_of_type_Int / 2;
    this.jdField_g_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.i / 2;
    this.jdField_d_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_f_of_type_Int / 2;
    this.jdField_e_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_g_of_type_Int / 2;
    if (this.jdField_g_of_type_Int <= this.jdField_f_of_type_Int)
    {
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_h_of_type_Int);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.i);
    }
    if (this.jdField_e_of_type_Int <= this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.j);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.j);
    }
    if (this.jdField_b_of_type_Int == 160)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.j - this.i / 3);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.j + this.i / 3);
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_h_of_type_Int - this.j / 3);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.i + this.j / 3);
    }
  }
  
  private ObjectAnimator g(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    if ((paramPathAnimConf.jdField_e_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_f_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_g_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_h_of_type_Float == 0.0F)) {
      return b(paramPathAnimConf);
    }
    if (paramPathAnimConf.jdField_c_of_type_Boolean) {
      return e(paramPathAnimConf);
    }
    return c(paramPathAnimConf);
  }
  
  private void g()
  {
    boolean bool = false;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
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
    Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject2).getAbsolutePath());
    ((StringBuilder)localObject3).append(File.separatorChar);
    ((StringBuilder)localObject3).append(((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(String.format("%04d.png", new Object[] { Integer.valueOf(1) }));
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
    BubbleManager.a((String)localObject2, (BitmapFactory.Options)localObject3);
    this.i = Utils.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
    this.j = Utils.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
    if (this.i > BaseChatItemLayout.j * 2)
    {
      i1 = BaseChatItemLayout.j * 2;
      this.j = ((int)(this.j * i1 * 1.0F / this.i));
      this.i = i1;
    }
    localObject3 = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
    ((View)localObject3).layout(0, 0, this.i, this.j);
    ((View)localObject3).setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData = new BubbleNewAIOAnim.AnimPicData();
    BubbleNewAIOAnim.AnimPicData localAnimPicData = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData;
    localAnimPicData.jdField_b_of_type_JavaLangString = ((String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_JavaLangString);
    localStringBuilder.append((String)localObject2);
    localAnimPicData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData;
    if (this.jdField_a_of_type_Boolean) {
      bool = ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_Boolean;
    } else if (!((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_Boolean) {
      bool = true;
    }
    ((BubbleNewAIOAnim.AnimPicData)localObject2).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    int i3 = 0;
    int i1 = -1;
    while (i3 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (i3 != i1)
      {
        Object localObject2 = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
        Object localObject1 = null;
        int i2;
        if ((localObject2 instanceof BubbleNewAnimConf.PathAnimConf))
        {
          localObject1 = f((BubbleNewAnimConf.PathAnimConf)localObject2);
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
              if (localPendantAnimConf.jdField_a_of_type_Int - 1 >= 0) {
                i2 = localPendantAnimConf.jdField_a_of_type_Int - 1;
              } else {
                i2 = 0;
              }
              ((ObjectAnimator)localObject2).setRepeatCount(i2);
            }
            i2 = i1;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localPendantAnimConf.e))
            {
              i2 = a((Animator)localObject2, localPendantAnimConf.e);
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
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.2(this));
  }
  
  private void i()
  {
    ThreadManager.post(new BubbleNewAIOAnim.7(this), 5, null, true);
  }
  
  protected void a(int paramInt)
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setTranslationY(localView.getTranslationY() + paramInt);
    }
    localView = this.jdField_d_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      paramInt = (int)(localView.getTranslationY() + paramInt);
      this.jdField_d_of_type_AndroidViewView.setTranslationY(paramInt);
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
    if (this.jdField_b_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
    if (localObject != null)
    {
      if (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a;
      } else {
        localObject = null;
      }
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
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
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      localObject2 = this.jdField_b_of_type_AndroidViewView;
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
        if (localView.getId() == 2131364541)
        {
          this.jdField_e_of_type_AndroidViewView = localView;
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
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
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
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      return false;
    }
    if (!VersionUtils.e()) {
      return false;
    }
    this.n = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[2]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramVarArgs[3]);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("start msg id ");
    paramVarArgs.append(this.jdField_a_of_type_Long);
    a(paramVarArgs.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if (a()) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, this.n);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig == null) {
      return false;
    }
    if (b()) {
      return false;
    }
    this.jdField_c_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    if (a(AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int)))) {
      return false;
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    i();
    g();
    f();
    e();
    h();
    return true;
  }
  
  protected void c()
  {
    a("now stop new bubble animation conf!");
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.1(this));
  }
  
  public void setBitmapData(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramAnimPicData.jdField_a_of_type_JavaLangString)) {
        return;
      }
      Object localObject;
      if (paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new AnimatorPathDrawable(paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap);
        ((AnimatorPathDrawable)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set bitmap path:");
        ((StringBuilder)localObject).append(paramAnimPicData.jdField_a_of_type_JavaLangString);
        a(((StringBuilder)localObject).toString());
        this.jdField_c_of_type_AndroidViewView.invalidate();
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAnimPicData.jdField_a_of_type_JavaLangString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get cache bitmap path:");
        ((StringBuilder)localObject).append(paramAnimPicData.jdField_a_of_type_JavaLangString);
        a(((StringBuilder)localObject).toString());
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAnimPicData.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          localObject = new AnimatorPathDrawable((Bitmap)localObject);
          ((AnimatorPathDrawable)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_a_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_AndroidViewView.invalidate();
        }
      }
      return;
    }
    c();
  }
  
  public void setPathLocation(PathPoint paramPathPoint)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView = ((View)localView.getParent());
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      float f1;
      if (this.jdField_a_of_type_Boolean) {
        f1 = paramPathPoint.jdField_a_of_type_Float + (i1 - this.m);
      } else {
        f1 = paramPathPoint.jdField_a_of_type_Float;
      }
      float f2 = paramPathPoint.jdField_b_of_type_Float + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      if (f2 < this.jdField_a_of_type_ComTencentWidgetListView.getTop() - this.jdField_c_of_type_AndroidViewView.getHeight())
      {
        a("setPathLocation: now scroll over sreen, stop bubble animatorset!");
        paramPathPoint = new StringBuilder();
        paramPathPoint.append("now listview firstVisible postion: ");
        paramPathPoint.append(this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition());
        paramPathPoint.append(", last postion: ");
        paramPathPoint.append(this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition());
        paramPathPoint.append(", now msg pos: ");
        paramPathPoint.append(this.jdField_c_of_type_Int);
        a(paramPathPoint.toString());
        c();
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setTranslationX(f1);
      this.jdField_c_of_type_AndroidViewView.setTranslationY(f2);
      this.jdField_c_of_type_AndroidViewView.setAlpha(paramPathPoint.d);
      this.jdField_c_of_type_AndroidViewView.setRotation(paramPathPoint.jdField_c_of_type_Float);
      return;
    }
    c();
  }
  
  public void setPendantBitmap(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {
      return;
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_e_of_type_AndroidViewView;
      if (localObject != null)
      {
        int i1 = ((View)localObject).getLeft();
        this.jdField_d_of_type_AndroidViewView.setTranslationX(i1);
        i1 = this.jdField_e_of_type_AndroidViewView.getTop();
        int i2 = this.jdField_b_of_type_AndroidViewView.getTop();
        int i3 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
        this.jdField_d_of_type_AndroidViewView.setTranslationY(i1 + i2 - i3);
        if ((this.jdField_c_of_type_Int <= this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()) && (this.jdField_c_of_type_Int >= this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()))
        {
          if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramAnimPicData.jdField_a_of_type_JavaLangString)) {
            return;
          }
          if (paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            localObject = new AnimatorPathDrawable(paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap);
            this.jdField_b_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
            ((AnimatorPathDrawable)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
            this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
            this.jdField_d_of_type_AndroidViewView.invalidate();
            return;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAnimPicData.jdField_a_of_type_JavaLangString))
          {
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAnimPicData.jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              localObject = new AnimatorPathDrawable((Bitmap)localObject);
              this.jdField_b_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
              ((AnimatorPathDrawable)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
              this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
              this.jdField_d_of_type_AndroidViewView.invalidate();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim
 * JD-Core Version:    0.7.0.1
 */