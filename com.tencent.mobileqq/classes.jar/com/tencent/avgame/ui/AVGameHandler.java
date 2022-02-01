package com.tencent.avgame.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class AVGameHandler
{
  private static final AVGameHandler jdField_a_of_type_ComTencentAvgameUiAVGameHandler = new AVGameHandler();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Handler b;
  
  private AVGameHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("avgame_chat_thread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static AVGameHandler a()
  {
    return jdField_a_of_type_ComTencentAvgameUiAVGameHandler;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Handler b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameHandler
 * JD-Core Version:    0.7.0.1
 */