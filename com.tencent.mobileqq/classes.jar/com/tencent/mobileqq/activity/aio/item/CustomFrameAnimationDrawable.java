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
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      i = j;
      if (j == 0) {
        i = 160;
      }
      this.jdField_b_of_type_Int = i;
    }
    else
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int;
    }
    paramResources = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    int i = this.jdField_b_of_type_Int;
    paramResources.jdField_b_of_type_Int = i;
    if (paramBitmap != null)
    {
      this.jdField_c_of_type_Int = paramBitmap.getScaledWidth(i);
      this.jdField_d_of_type_Int = paramBitmap.getScaledHeight(this.jdField_b_of_type_Int);
      return;
    }
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
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (paramInt - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int < 2)
      {
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable = new CustomFrameAnimationDrawable.DecodeRunnable(this, paramInt, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_a_of_type_JavaLangString, ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable.a(this.jdField_a_of_type_AndroidContentResResources);
          localObject = this.jdField_a_of_type_MqqOsMqqHandler;
          if (localObject != null) {
            ((MqqHandler)localObject).post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$DecodeRunnable);
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
      if (paramLong == 0L) {
        paramLong = SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int;
      } else {
        paramLong += SystemClock.uptimeMillis();
      }
      scheduleSelf(this, paramLong);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).update(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int * ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener;
    if (localObject != null) {
      ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      j();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Boolean = false;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Boolean = true;
  }
  
  private void a(Resources paramResources)
  {
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      int i = j;
      if (j == 0) {
        i = 160;
      }
      this.jdField_b_of_type_Int = i;
    }
    else
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int;
    }
    m();
  }
  
  public static boolean a()
  {
    return (!Build.VERSION.RELEASE.equals("5.0.2")) || ((!Build.MODEL.equals("SM-A5009")) && (!Build.MODEL.equals("SM-A7000")) && (!Build.MODEL.equals("Redmi Note 2")));
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        localObject = null;
      } else {
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      if (localObject != null)
      {
        this.jdField_c_of_type_Int = ((Bitmap)localObject).getScaledWidth(this.jdField_b_of_type_Int);
        this.jdField_d_of_type_Int = ((Bitmap)localObject).getScaledHeight(this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_d_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
    }
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
      }
      invalidateSelf();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int + 1;
    long l1 = 0L;
    int i = j;
    long l2 = l1;
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
      {
        invalidateSelf();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        }
        localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        scheduleSelf(this, SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int += 1;
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Boolean = false;
        ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Int = 0;
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
      invalidateSelf();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
      }
      localObject = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
      scheduleSelf(this, SystemClock.uptimeMillis() + ((CustomFrameAnimationDrawable.OneFrame)localObject).jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
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
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    if ((localFrameAnimationState != null) && (localFrameAnimationState.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
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
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    localFrameAnimationState.jdField_a_of_type_Int = paramInt;
    localFrameAnimationState.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    unscheduleSelf(this);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      localFrameAnimationState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      localFrameAnimationState.jdField_a_of_type_Int = 0;
      localFrameAnimationState.jdField_c_of_type_Int = 0;
      invalidateSelf();
      scheduleSelf(this, 0L);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() != 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = 0;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = -1;
      }
      scheduleSelf(this, 0L);
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Int = ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.jdField_a_of_type_JavaLangString, 2);
    }
    CustomFrameAnimationDrawable.FrameAnimationState localFrameAnimationState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    localFrameAnimationState.jdField_a_of_type_Boolean = true;
    localFrameAnimationState.jdField_c_of_type_Boolean = false;
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
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null)
      {
        if (((Bitmap)localObject2).isRecycled())
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          return;
        }
        localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
        {
          paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, this.jdField_c_of_type_Int / 2, this.jdField_d_of_type_Int / 2);
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        int i = paramCanvas.getWidth();
        float f = paramCanvas.getHeight() * 1.0F / this.jdField_d_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 1) {
          paramCanvas.translate((i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 2) {
          paramCanvas.translate(Math.abs(i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
        }
        paramCanvas.drawBitmap((Bitmap)localObject1, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, localPaint);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
          return;
        }
        paramCanvas.restore();
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int >= 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Int);
        }
        else
        {
          localObject1 = (CustomFrameAnimationDrawable.OneFrame)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
          localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((CustomFrameAnimationDrawable.OneFrame)localObject1).jdField_a_of_type_Int);
        }
      }
      if (localObject1 != null)
      {
        if (((Bitmap)localObject1).isRecycled()) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
        {
          paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, ((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, localPaint);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
          paramCanvas.restore();
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
        localObject = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localObject != null) {
          ((Bitmap)localObject).recycle();
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.clear();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Int = ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Int;
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
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject1 != null)
    {
      ((Bitmap)localObject1).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject2).next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    ((ArrayList)localObject1).clear();
    localObject1 = this.jdField_a_of_type_JavaUtilVector;
    if (localObject1 != null)
    {
      localObject1 = ((Vector)localObject1).iterator();
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
    if (this.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CustomFrameAnimationDrawable", 2, "paused");
      }
      return;
    }
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener;
      if (localObject != null) {
        ((CustomFrameAnimationDrawable.AnimationEndListener)localObject).a();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        j();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_a_of_type_Boolean = false;
      ((CustomFrameAnimationDrawable.FrameAnimationState)localObject).jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).stopEffect(this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        invalidateSelf();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener;
        if (localObject != null) {
          ((CustomFrameAnimationDrawable.FrameListener)localObject).onUpdate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        }
        return;
      }
      o();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */