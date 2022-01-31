package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MainService;
import ukq;

@TargetApi(11)
public class FloorJumperSet
  extends AIOAnimationConatiner.AIOAnimator
{
  @SuppressLint({"NewApi"})
  static final long jdField_a_of_type_Long;
  public static final int b;
  public ArrayList a;
  ukq jdField_a_of_type_Ukq;
  private long b;
  
  static
  {
    long l;
    if (VersionUtils.e())
    {
      l = ValueAnimator.getFrameDelay();
      jdField_a_of_type_Long = l;
      if (!VersionUtils.e()) {
        break label35;
      }
    }
    label35:
    for (int i = 16;; i = 1)
    {
      jdField_b_of_type_Int = i;
      return;
      l = 16L;
      break;
    }
  }
  
  public FloorJumperSet(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_b_of_type_Int);
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      FloorJumper localFloorJumper = (FloorJumper)localIterator.next();
      localFloorJumper.j += paramInt;
      localFloorJumper.h += paramInt;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (((FloorJumper)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) {
        bool = true;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if (!bool)
    {
      c();
      d();
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
    return bool;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloorJumperSet", 2, "[start], args.len:" + paramVarArgs.length);
    }
    if ((paramVarArgs != null) && (paramVarArgs.length >= 3) && (((Integer)paramVarArgs[2]).intValue() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.a();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_b_of_type_Int)
    {
      int i;
      if (MainService.sPwdPacketTime != 0L)
      {
        long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if ((l < 60000L) && (l > 0L)) {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= jdField_b_of_type_Int / 3) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          FloorJumper localFloorJumper = new FloorJumper(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
          if ((paramVarArgs != null) && (paramVarArgs.length >= 3)) {
            localFloorJumper.c = ((Integer)paramVarArgs[2]).intValue();
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localFloorJumper);
          if (paramVarArgs != null) {
            localFloorJumper.a(paramVarArgs);
          }
        }
        if (this.jdField_a_of_type_Ukq == null)
        {
          this.jdField_a_of_type_Ukq = new ukq(this, null);
          if (this.jdField_b_of_type_Long == 0L) {
            this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_Ukq, jdField_a_of_type_Long);
          }
        }
        return true;
        i = 0;
        continue;
        MainService.sPwdPacketTime = 0L;
        i = 1;
      }
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Long = 0L;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((FloorJumper)localIterator.next()).a(false)) {
        i = 1;
      }
      for (;;)
      {
        break;
        localIterator.remove();
      }
    }
    if ((i != 0) && (this.jdField_a_of_type_Ukq != null))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.post(this.jdField_a_of_type_Ukq);
      return;
    }
    d();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ukq != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_Ukq);
      this.jdField_a_of_type_Ukq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet
 * JD-Core Version:    0.7.0.1
 */