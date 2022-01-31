package com.tencent.mobileqq.activity.contacts.view.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import java.lang.reflect.Method;

public class TargetDrawable
{
  static Method jdField_a_of_type_JavaLangReflectMethod;
  public static final int[] a;
  static Method jdField_b_of_type_JavaLangReflectMethod;
  public static final int[] b;
  static Method jdField_c_of_type_JavaLangReflectMethod;
  public static final int[] c;
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.0F;
  private float jdField_c_of_type_Float = 0.0F;
  private float d = 0.0F;
  private float e = 1.0F;
  private float f = 1.0F;
  private float g = 1.0F;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 16842910, 16842914 };
    jdField_b_of_type_ArrayOfInt = new int[] { 16842910, -16842914 };
    jdField_c_of_type_ArrayOfInt = new int[] { 16842910, -16842914, 16842908 };
    try
    {
      jdField_b_of_type_JavaLangReflectMethod = StateListDrawable.class.getDeclaredMethod("getStateCount", new Class[0]);
      jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          jdField_c_of_type_JavaLangReflectMethod = StateListDrawable.class.getDeclaredMethod("getStateDrawable", new Class[] { Integer.TYPE });
          jdField_c_of_type_JavaLangReflectMethod.setAccessible(true);
          try
          {
            jdField_a_of_type_JavaLangReflectMethod = StateListDrawable.class.getDeclaredMethod("getStateDrawableIndex", new Class[] { [I.class });
            jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            Log.e("TargetDrawable", "Couldn't access the StateListDrawable#mGetStateDrawableIndex(int[]) method. Some stuff might break!", localNoSuchMethodException3);
          }
          localNoSuchMethodException1 = localNoSuchMethodException1;
          Log.e("TargetDrawable", "Couldn't access the StateListDrawable#getStateCount() method. Some stuff might break!", localNoSuchMethodException1);
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          Log.e("TargetDrawable", "Couldn't access the StateListDrawable#getStateDrawable(int) method. Some stuff might break!", localNoSuchMethodException2);
        }
      }
    }
  }
  
  public TargetDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = null;
    }
    paramDrawable = localObject;
    if (localDrawable != null) {
      paramDrawable = localDrawable.mutate();
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
    a(jdField_b_of_type_ArrayOfInt);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof StateListDrawable))
    {
      StateListDrawable localStateListDrawable = (StateListDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject1 = Integer.valueOf(0);
      try
      {
        localObject2 = (Integer)jdField_b_of_type_JavaLangReflectMethod.invoke(localStateListDrawable, new Object[0]);
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject2;
          Log.w("TargetDrawable", "StateListDrawable#getStateCount() call failed!", localException1);
        }
        localStateListDrawable.setBounds(0, 0, j, i);
        k = 0;
      }
      int k = 0;
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (k >= ((Integer)localObject1).intValue()) {
          break label142;
        }
        try
        {
          localObject2 = (Drawable)jdField_c_of_type_JavaLangReflectMethod.invoke(localStateListDrawable, new Object[] { Integer.valueOf(k) });
          j = Math.max(j, ((Drawable)localObject2).getIntrinsicWidth());
          i = Math.max(i, ((Drawable)localObject2).getIntrinsicHeight());
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.w("TargetDrawable", "StateListDrawable#getStateDrawable(int) call failed!", localException2);
          }
        }
        k += 1;
      }
      for (;;)
      {
        label142:
        if (k >= ((Integer)localObject1).intValue()) {
          return;
        }
        try
        {
          Drawable localDrawable = (Drawable)jdField_c_of_type_JavaLangReflectMethod.invoke(localStateListDrawable, new Object[] { Integer.valueOf(k) });
          localDrawable.setBounds(0, 0, j, i);
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Log.w("TargetDrawable", "StateListDrawable#getStateDrawable(int) call failed!", localException3);
          }
        }
        k += 1;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    return 0;
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof StateListDrawable)) {
      ((StateListDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setState(paramArrayOfInt);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public void b(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void c(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void d(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void e(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.card.TargetDrawable
 * JD-Core Version:    0.7.0.1
 */