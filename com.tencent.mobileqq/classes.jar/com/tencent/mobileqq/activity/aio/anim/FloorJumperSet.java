package com.tencent.mobileqq.activity.aio.anim;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MainService;

@TargetApi(11)
public class FloorJumperSet
  extends AIOAnimationConatiner.AIOAnimator
{
  @SuppressLint({"NewApi"})
  static final long jdField_a_of_type_Long;
  public static final int b;
  FloorJumperSet.Animator jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator;
  ArrayList<FloorJumper> jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_b_of_type_Int);
  private long b;
  
  static
  {
    long l;
    if (VersionUtils.e()) {
      l = ValueAnimator.getFrameDelay();
    } else {
      l = 16L;
    }
    jdField_a_of_type_Long = l;
    int i;
    if (VersionUtils.e()) {
      i = 16;
    } else {
      i = 1;
    }
    jdField_b_of_type_Int = i;
  }
  
  public FloorJumperSet(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_b_of_type_Long = 0L;
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
    QQViewCompatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, paramInt);
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      if (((FloorJumper)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4)) {
        bool = true;
      } else {
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[start], args.len:");
      ((StringBuilder)localObject).append(paramVarArgs.length);
      QLog.d("FloorJumperSet", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramVarArgs != null) && (paramVarArgs.length >= 3) && (((Integer)paramVarArgs[2]).intValue() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.a();
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int k = jdField_b_of_type_Int;
    int i = 0;
    if (j < k)
    {
      if (MainService.sPwdPacketTime != 0L)
      {
        long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if ((l < 60000L) && (l > 0L)) {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > jdField_b_of_type_Int / 3) {
            break label165;
          }
        } else {
          MainService.sPwdPacketTime = 0L;
        }
      }
      i = 1;
      label165:
      if (i != 0)
      {
        localObject = new FloorJumper(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
        if ((paramVarArgs != null) && (paramVarArgs.length >= 3)) {
          ((FloorJumper)localObject).c = ((Integer)paramVarArgs[2]).intValue();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (paramVarArgs != null) {
          ((FloorJumper)localObject).a(paramVarArgs);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator = new FloorJumperSet.Animator(this, null);
        if (this.jdField_b_of_type_Long == 0L) {
          this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator, jdField_a_of_type_Long);
        }
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Long = 0L;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((FloorJumper)localIterator.next()).a(false)) {
        i = 1;
      } else {
        localIterator.remove();
      }
    }
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator != null))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator);
      return;
    }
    d();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFloorJumperSet$Animator = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet
 * JD-Core Version:    0.7.0.1
 */