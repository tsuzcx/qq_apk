package com.tencent.mobileqq.app.readinjoy;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyRemoteCommand;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadInJoyHandler
  extends BusinessHandler
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  ReadInJoyRemoteCommand jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand = null;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  public ReadInJoyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return ReadInJoyObserver.class;
  }
  
  public void a()
  {
    b();
    super.a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyHandler", 2, "readInJoyFeedsMsgNotify, isSuccess=" + paramBoolean1 + ",isNewMsgCome=" + paramBoolean2 + ",reason=" + paramInt);
    }
    a(1, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHandler", 2, "handleOnlinePushReadInJoyFeedsMsg");
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null) {
      this.b = new HashSet();
    }
    return !this.b.contains(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand != null)
    {
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand.a();
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyRemoteCommand = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyHandler
 * JD-Core Version:    0.7.0.1
 */