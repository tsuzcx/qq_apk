package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;

public class CustomFrameAnimationDrawable
  extends Drawable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  CustomFrameAnimationDrawable.AnimationEndListener jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener = null;
  CustomFrameAnimationDrawable.DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable = null;
  public CustomFrameAnimationDrawable.FrameAnimationState a;
  private CustomFrameAnimationDrawable.FrameListener jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener = null;
  private CustomFrameAnimationDrawable.KeyGenerator jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$KeyGenerator;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  private Vector<Bitmap> jdField_a_of_type_JavaUtilVector;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 160;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = new CustomFrameAnimationDrawable.FrameAnimationState();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    int j;
    if (paramResources != null)
    {
      j = paramResources.getDisplayMetrics().densityDpi;
      if (j != 0) {}
    }
    for (this.jdField_b_of_type_Int = i;; this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (paramBitmap == null) {
        break label210;
      }
      this.jdField_c_of_type_Int = paramBitmap.getScaledWidth(this.jdField_b_of_type_Int);
      this.jdField_d_of_type_Int = paramBitmap.getScaledHeight(this.jdField_b_of_type_Int);
      return;
      i = j;
      break;
    }
    label210:
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler, CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, String paramString, boolean paramBoolean)
  {
    this(paramResources, paramBitmap, paramMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = paramFrameAnimationState;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      ThreadManager.postImmediately(new CustomFrameAnimationDrawable.1(this), null, true);
    }
  }
  
  private CustomFrameAnimationDrawable(CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = paramFrameAnimationState;
    a(paramResources);
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject;
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (paramInt - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int < 2)
      {
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable = new CustomFrameAnimationDrawable.DecodeRunnable(this, paramInt, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_a_of_type_JavaLangString, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable.a(this.jdField_a_of_type_AndroidContentResResources);
          if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
            this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
          ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Int += 1;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
            ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
          }
        }
      }
      localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
      if (paramLong != 0L) {
        break label319;
      }
    }
    label319:
    for (paramLong = SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int;; paramLong = SystemClock.uptimeMillis() + paramLong)
    {
      scheduleSelf(this, paramLong);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean))
      {
        IHapticManagerApi localIHapticManagerApi = (IHapticManagerApi)QRoute.api(IHapticManagerApi.class);
        paramInt = this.jdField_a_of_type_Int;
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
        localIHapticManagerApi.update(paramInt, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int * i);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        j();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void a(Resources paramResources)
  {
    int i;
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      i = j;
      if (j == 0) {
        i = 160;
      }
    }
    for (this.jdField_b_of_type_Int = i;; this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int)
    {
      m();
      return;
    }
  }
  
  public static boolean a()
  {
    return (!Build.VERSION.RELEASE.equals("5.0.2")) || ((!Build.MODEL.equals("SM-A5009")) && (!Build.MODEL.equals("SM-A7000")) && (!Build.MODEL.equals("Redmi Note 2")));
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label48;
      }
    }
    label48:
    for (Bitmap localBitmap = null; localBitmap != null; localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(0))
    {
      this.jdField_c_of_type_Int = localBitmap.getScaledWidth(this.jdField_b_of_type_Int);
      this.jdField_d_of_type_Int = localBitmap.getScaledHeight(this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  private void n()
  {
    Object localObject = a();
    if (localObject != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilVector.size() <= 2)) {
        this.jdField_a_of_type_JavaUtilVector.add(localBitmap);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int += 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
      }
      invalidateSelf();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int + 1;
    long l1 = 0L;
    long l2 = l1;
    int i = j;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
    {
      if (j >= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size()) {
        l1 = this.jdField_e_of_type_Int;
      }
      i = j % this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
      l2 = l1;
    }
    a(i, l2);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
      {
        invalidateSelf();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        }
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        l = SystemClock.uptimeMillis();
        scheduleSelf(this, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int + l);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int += 1;
      }
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
      } while (this.jdField_a_of_type_JavaLangString == null);
      if (this.jdField_a_of_type_Boolean) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
    invalidateSelf();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
    }
    Object localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
    long l = SystemClock.uptimeMillis();
    scheduleSelf(this, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int + l);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int += 1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    return localObject1;
  }
  
  public CustomFrameAnimationDrawable.OneFrame a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = localObject2;
          if (paramInt >= 0)
          {
            localObject1 = localObject2;
            if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size()) {
              localObject1 = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    CustomFrameAnimationDrawable.OneFrame localOneFrame = new CustomFrameAnimationDrawable.OneFrame();
    localOneFrame.jdField_a_of_type_Int = paramInt1;
    localOneFrame.jdField_b_of_type_Int = paramInt2;
    localOneFrame.jdField_c_of_type_Int = paramInt3;
    localOneFrame.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.add(localOneFrame);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    CustomFrameAnimationDrawable.OneFrame localOneFrame = new CustomFrameAnimationDrawable.OneFrame();
    localOneFrame.jdField_a_of_type_Int = paramInt1;
    localOneFrame.jdField_b_of_type_Int = paramInt2;
    localOneFrame.jdField_a_of_type_JavaLangString = paramString;
    localOneFrame.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.add(localOneFrame);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(CustomFrameAnimationDrawable.AnimationEndListener paramAnimationEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener = paramAnimationEndListener;
  }
  
  public void a(CustomFrameAnimationDrawable.FrameListener paramFrameListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener = paramFrameListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() - 1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    unscheduleSelf(this);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = 0;
      invalidateSelf();
      scheduleSelf(this, 0L);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Int = ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.jdField_a_of_type_JavaLangString, 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = false;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = -1;; this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = 0)
    {
      scheduleSelf(this, 0L);
      break;
    }
  }
  
  public void d()
  {
    this.jdField_e_of_type_Boolean = false;
    unscheduleSelf(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = true;
    scheduleSelf(this, 0L);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    label488:
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.jdField_c_of_type_Int / 2, this.jdField_d_of_type_Int / 2);
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      int i = paramCanvas.getWidth();
      float f = paramCanvas.getHeight() * 1.0F / this.jdField_d_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 1) {
        paramCanvas.translate((i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, localPaint);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
          break;
        }
        paramCanvas.restore();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 2) {
          paramCanvas.translate(Math.abs(i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int < 0) {
          localObject = null;
        }
        for (;;)
        {
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            break label488;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
          {
            paramCanvas.save();
            paramCanvas.scale(-1.0F, 1.0F, ((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
            break;
          }
          paramCanvas.restore();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Int);
          }
          else
          {
            localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  public void e()
  {
    this.jdField_e_of_type_Boolean = true;
    f();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean) {
      unscheduleSelf(this);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_d_of_type_Boolean))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.size())
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean) {
      unscheduleSelf(this);
    }
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean = true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject2).next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    ((ArrayList)localObject1).clear();
    if (this.jdField_a_of_type_JavaUtilVector != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bitmap)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
          ((Bitmap)localObject2).recycle();
        }
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void k()
  {
    unscheduleSelf(this);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).pauseEffect(this.jdField_a_of_type_Int);
    }
  }
  
  public void l()
  {
    scheduleSelf(this, SystemClock.uptimeMillis() + 50L);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).resumeEffect(this.jdField_a_of_type_Int);
    }
  }
  
  public void run()
  {
    if (this.jdField_e_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("CustomFrameAnimationDrawable", 2, "paused");
      }
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
          break;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int + 1;
        int i = j;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean) {
          i = j % this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
        {
          n();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
        }
        if (this.jdField_b_of_type_Boolean)
        {
          j();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
      } while (this.jdField_a_of_type_JavaLangString == null);
      if (this.jdField_a_of_type_Boolean) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = 0;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        break;
      }
      invalidateSelf();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
    return;
    o();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */