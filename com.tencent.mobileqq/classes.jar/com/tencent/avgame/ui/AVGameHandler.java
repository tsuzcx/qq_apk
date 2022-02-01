package com.tencent.avgame.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class AVGameHandler
{
  private static final AVGameHandler jdField_a_of_type_ComTencentAvgameUiAVGameHandler = new AVGameHandler();
  private static String jdField_a_of_type_JavaLangString = "AVGameHandler";
  private Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("avgame_chat_thread");
  private Handler b;
  
  private AVGameHandler()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameHandler
 * JD-Core Version:    0.7.0.1
 */