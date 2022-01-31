package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.WeakReferenceHandler;

public class ReadInJoyWebRenderStateMachineScheduler
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ReadInJoyWebRenderStateMachineScheduler.StateMachine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderStateMachineScheduler$StateMachine;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public ReadInJoyWebRenderStateMachineScheduler(ReadInJoyWebRenderStateMachineScheduler.StateMachine paramStateMachine)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderStateMachineScheduler$StateMachine = paramStateMachine;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderStateMachineScheduler$StateMachine.a(paramBundle))
        {
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.b) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderStateMachineScheduler
 * JD-Core Version:    0.7.0.1
 */