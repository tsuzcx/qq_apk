package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class NewPublicAccountObserver
  extends AppletsObserver
{
  protected QQAppInterface a;
  private NewPublicAccountObserver.ResponseResultListener b;
  
  public NewPublicAccountObserver(NewPublicAccountObserver.ResponseResultListener paramResponseResultListener)
  {
    this.b = paramResponseResultListener;
  }
  
  public NewPublicAccountObserver(NewPublicAccountObserver.ResponseResultListener paramResponseResultListener, QQAppInterface paramQQAppInterface)
  {
    this.b = paramResponseResultListener;
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeObserver  ");
        localStringBuilder.append(this);
        QLog.d("AppletsObserver", 2, localStringBuilder.toString());
      }
      this.a.removeObserver(this);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
      return;
    }
    if (4 != ((NewPublicAccountObserver.ResponseResultListener)localObject).a()) {
      return;
    }
    this.b.a(paramBoolean, paramObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("      Follow isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AppletsObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new oidb_cmd0xc96.RspBody();
      if ((paramObject instanceof byte[])) {
        try
        {
          ((oidb_cmd0xc96.RspBody)localObject).mergeFrom((byte[])paramObject);
          this.b.a(localObject);
        }
        catch (Exception localException)
        {
          QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
          this.b.b(paramObject);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
          this.b.b(paramObject);
        }
      } else {
        this.b.b(paramObject);
      }
    }
    else
    {
      this.b.b(paramObject);
    }
    this.b.b(paramBoolean, paramObject);
    a();
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
      return;
    }
    if (5 != ((NewPublicAccountObserver.ResponseResultListener)localObject).a()) {
      return;
    }
    this.b.a(paramBoolean, paramObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("      unFollow isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AppletsObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new oidb_cmd0xc96.RspBody();
      if ((paramObject instanceof byte[])) {
        try
        {
          ((oidb_cmd0xc96.RspBody)localObject).mergeFrom((byte[])paramObject);
          this.b.a(localObject);
        }
        catch (Exception localException)
        {
          QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
          this.b.b(paramObject);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
          this.b.b(paramObject);
        }
      } else {
        this.b.b(paramObject);
      }
    }
    else
    {
      this.b.b(paramObject);
    }
    this.b.b(paramBoolean, paramObject);
    a();
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
      return;
    }
    if (7 != ((NewPublicAccountObserver.ResponseResultListener)localObject).a()) {
      return;
    }
    this.b.a(paramBoolean, paramObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PublicAccountNotifySetting isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AppletsObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {
      this.b.a(paramObject);
    } else {
      this.b.b(paramObject);
    }
    this.b.b(paramBoolean, paramObject);
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            super.onUpdate(paramInt, paramBoolean, paramObject);
            return;
          }
          c(paramBoolean, paramObject);
        }
      }
      else {
        b(paramBoolean, paramObject);
      }
    }
    else {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.NewPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */