package com.tencent.biz.qrcode.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.wealthgod.ARMapThreadStubReceiver;
import com.tencent.qphone.base.util.QLog;
import otb;

public class PreCallUpToolProc
  implements Handler.Callback
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PreCallUpToolProc.Callback jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc$Callback;
  private String jdField_a_of_type_JavaLangString;
  
  public PreCallUpToolProc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new otb(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc$Callback = null;
  }
  
  public void a(String paramString, long paramLong, PreCallUpToolProc.Callback paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc$Callback = paramCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramCallback = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapThreadStubReceiver.class);
    paramCallback.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    paramCallback.putExtra("from", paramString);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramCallback);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(108);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(108, paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc$Callback != null) {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc$Callback.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.PreCallUpToolProc
 * JD-Core Version:    0.7.0.1
 */