package com.tencent.mobileqq.activity.aio.anim;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class FriendProfileCardBgDrawable$DecodeNextFrameTask
  extends AsyncTask
{
  private Object jdField_a_of_type_JavaLangObject;
  
  public FriendProfileCardBgDrawable$DecodeNextFrameTask(FriendProfileCardBgDrawable paramFriendProfileCardBgDrawable, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        l1 = paramVarArgs[0].longValue();
        long l2 = paramVarArgs[1].longValue();
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.a(this.jdField_a_of_type_JavaLangObject, (int)l2);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.d)
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_AndroidOsHandler;
          FriendProfileCardBgDrawable localFriendProfileCardBgDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable;
          if (FriendProfileCardBgDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable) != null) {
            break label203;
          }
          l1 = 1000L;
          paramVarArgs.postDelayed(localFriendProfileCardBgDrawable, l1);
          return null;
        }
        if ((paramVarArgs != null) && (!isCancelled()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.b = paramVarArgs;
          l2 = SystemClock.uptimeMillis();
          if (l2 < l1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable, l1 - l2);
            return null;
          }
        }
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.e("FriendProfileCardBgDrawable", 4, "", paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.b = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_Boolean = true;
        return null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable);
        return null;
      }
      catch (Throwable paramVarArgs)
      {
        QLog.e("FriendProfileCardBgDrawable", 1, "", paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.b = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_Boolean = true;
      }
      return null;
      label203:
      long l1 = 0L;
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */