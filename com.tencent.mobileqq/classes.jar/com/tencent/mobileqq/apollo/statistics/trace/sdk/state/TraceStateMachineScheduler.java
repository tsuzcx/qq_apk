package com.tencent.mobileqq.apollo.statistics.trace.sdk.state;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.WeakReferenceHandler;

public class TraceStateMachineScheduler
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final TraceStateMachineScheduler.StateMachine jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$StateMachine;
  private TraceStateMachineScheduler.TimeOutState jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState = null;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public TraceStateMachineScheduler(TraceStateMachineScheduler.StateMachine paramStateMachine)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$StateMachine = paramStateMachine;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, TraceStateMachineScheduler.TimeOutState paramTimeOutState)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState = paramTimeOutState;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$StateMachine.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState != null) && (this.jdField_a_of_type_Int > 0))
          {
            paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, this.jdField_a_of_type_Int);
          }
          break;
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState = null;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.b) {
        a(paramMessage.getData());
      }
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState.b();
        this.jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceSdkStateTraceStateMachineScheduler$TimeOutState = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateMachineScheduler
 * JD-Core Version:    0.7.0.1
 */