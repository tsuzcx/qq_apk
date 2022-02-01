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
  static final long d;
  public static final int e;
  ArrayList<FloorJumper> f = new ArrayList(e);
  FloorJumperSet.Animator g;
  private long h = 0L;
  
  static
  {
    long l;
    if (VersionUtils.e()) {
      l = ValueAnimator.getFrameDelay();
    } else {
      l = 16L;
    }
    d = l;
    int i;
    if (VersionUtils.e()) {
      i = 16;
    } else {
      i = 1;
    }
    e = i;
  }
  
  public FloorJumperSet(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FloorJumper localFloorJumper = (FloorJumper)localIterator.next();
      localFloorJumper.v += paramInt;
      localFloorJumper.t += paramInt;
    }
    QQViewCompatUtil.a(this.a, paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.f.iterator();
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
    this.a.invalidate();
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
    int j = this.f.size();
    int k = e;
    int i = 0;
    if (j < k)
    {
      if (MainService.sPwdPacketTime != 0L)
      {
        long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if ((l < 60000L) && (l > 0L)) {
          if (this.f.size() > e / 3) {
            break label120;
          }
        } else {
          MainService.sPwdPacketTime = 0L;
        }
      }
      i = 1;
      label120:
      if (i != 0)
      {
        localObject = new FloorJumper(this.c, this.a, this.b);
        if ((paramVarArgs != null) && (paramVarArgs.length >= 3)) {
          ((FloorJumper)localObject).h = ((Integer)paramVarArgs[2]).intValue();
        }
        this.f.add(localObject);
        if (paramVarArgs != null) {
          ((FloorJumper)localObject).a(paramVarArgs);
        }
      }
      if (this.g == null)
      {
        this.g = new FloorJumperSet.Animator(this, null);
        if (this.h == 0L) {
          this.b.postDelayed(this.g, d);
        }
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    this.h = 0L;
    Iterator localIterator = this.f.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((FloorJumper)localIterator.next()).a(false)) {
        i = 1;
      } else {
        localIterator.remove();
      }
    }
    if ((i != 0) && (this.g != null))
    {
      this.b.post(this.g);
      return;
    }
    d();
  }
  
  protected boolean b(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected void c()
  {
    if (this.g != null)
    {
      this.b.removeCallbacks(this.g);
      this.g = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet
 * JD-Core Version:    0.7.0.1
 */