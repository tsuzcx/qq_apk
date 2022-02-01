package com.tencent.mobileqq.activity.aio.anim;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class FriendProfileCardBgDrawable$DecodeNextFrameTask
  extends AsyncTask<Long, Void, Void>
{
  private Object b;
  
  public FriendProfileCardBgDrawable$DecodeNextFrameTask(FriendProfileCardBgDrawable paramFriendProfileCardBgDrawable, Object paramObject)
  {
    this.b = paramObject;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        l1 = paramVarArgs[0].longValue();
        long l2 = paramVarArgs[1].longValue();
        paramVarArgs = this.a.a(this.b, (int)l2);
        if (!this.a.m)
        {
          paramVarArgs = this.a.f;
          FriendProfileCardBgDrawable localFriendProfileCardBgDrawable = this.a;
          if (FriendProfileCardBgDrawable.a(this.a) != null) {
            break label204;
          }
          l1 = 1000L;
          paramVarArgs.postDelayed(localFriendProfileCardBgDrawable, l1);
          return null;
        }
        if ((paramVarArgs != null) && (!isCancelled()))
        {
          this.a.c = paramVarArgs;
          l2 = SystemClock.uptimeMillis();
          if (l2 < l1)
          {
            this.a.f.postDelayed(this.a, l1 - l2);
            return null;
          }
          this.a.f.post(this.a);
          return null;
        }
      }
      catch (Throwable paramVarArgs)
      {
        QLog.e("FriendProfileCardBgDrawable", 1, "", paramVarArgs);
        paramVarArgs = this.a;
        paramVarArgs.c = null;
        paramVarArgs.g = true;
        return null;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.e("FriendProfileCardBgDrawable", 4, "", paramVarArgs);
        paramVarArgs = this.a;
        paramVarArgs.c = null;
        paramVarArgs.g = true;
      }
      return null;
      label204:
      long l1 = 0L;
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */