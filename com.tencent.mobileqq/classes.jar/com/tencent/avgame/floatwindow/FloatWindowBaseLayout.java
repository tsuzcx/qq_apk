package com.tencent.avgame.floatwindow;

import afur;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mxa;

public class FloatWindowBaseLayout
  extends FrameLayout
{
  float jdField_a_of_type_Float;
  public int a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  mxa jdField_a_of_type_Mxa;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  public int b;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  boolean jdField_c_of_type_Boolean = false;
  float d;
  float e = 6.0F;
  
  public FloatWindowBaseLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.e = afur.a(3.0F, getResources());
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.systemUiVisibility = 5892;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 85;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.setTitle("FloatWindowBaseLayout");
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0;
      b();
      return;
    }
  }
  
  private void b()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width / 2;
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x) || (paramInt2 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y))
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramInt1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramInt2;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 86
    //   10: iconst_2
    //   11: new 149	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   18: ldc 152
    //   20: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 21	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 21	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_Boolean	Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +60 -> 104
    //   47: aload_0
    //   48: getfield 58	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 64	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   56: invokeinterface 170 3 0
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield 21	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_Boolean	Z
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_1
    //   69: ireturn
    //   70: astore_3
    //   71: ldc 86
    //   73: iconst_1
    //   74: new 149	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   81: ldc 172
    //   83: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_3
    //   87: invokevirtual 175	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: istore_1
    //   101: goto -35 -> 66
    //   104: aload_0
    //   105: getfield 58	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 64	com/tencent/avgame/floatwindow/FloatWindowBaseLayout:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   113: invokeinterface 180 3 0
    //   118: goto -52 -> 66
    //   121: astore_3
    //   122: ldc 86
    //   124: iconst_1
    //   125: new 149	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   132: ldc 182
    //   134: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 175	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iconst_0
    //   151: istore_1
    //   152: goto -86 -> 66
    //   155: astore_3
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	FloatWindowBaseLayout
    //   1	151	1	bool1	boolean
    //   42	2	2	bool2	boolean
    //   70	17	3	localThrowable1	Throwable
    //   121	17	3	localThrowable2	Throwable
    //   155	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	66	70	java/lang/Throwable
    //   104	118	121	java/lang/Throwable
    //   38	43	155	finally
    //   47	66	155	finally
    //   66	68	155	finally
    //   71	99	155	finally
    //   104	118	155	finally
    //   122	150	155	finally
    //   156	158	155	finally
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowBaseLayout", 2, "hide: " + this.jdField_a_of_type_Boolean);
    }
    boolean bool1;
    try
    {
      boolean bool3 = this.jdField_a_of_type_Boolean;
      bool1 = bool2;
      if (bool3) {}
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
        this.jdField_a_of_type_Boolean = false;
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("FloatWindowBaseLayout", 1, "hide removeView error: " + localThrowable.getMessage());
          bool1 = false;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowBaseLayout", 2, "applyChanges: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FloatWindowBaseLayout", 1, "applyChanges updateViewLayout error: " + localThrowable.getMessage());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        return bool1;
        this.jdField_c_of_type_Float = f1;
        this.d = f2;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = true;
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        continue;
        if ((Math.abs(f1 - this.jdField_c_of_type_Float) > this.e) && (Math.abs(f2 - this.d) > this.e) && (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_b_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_Mxa != null) && (this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_Mxa.a((int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
        }
        if (!this.jdField_b_of_type_Boolean) {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((this.jdField_a_of_type_Mxa != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Mxa.b();
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = super.dispatchTouchEvent(paramMotionEvent))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  public int e()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Mxa = null;
  }
  
  public void setFloatPositionChangeCallback(mxa parammxa)
  {
    this.jdField_a_of_type_Mxa = parammxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowBaseLayout
 * JD-Core Version:    0.7.0.1
 */