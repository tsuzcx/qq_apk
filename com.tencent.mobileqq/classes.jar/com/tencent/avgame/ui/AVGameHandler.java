package com.tencent.avgame.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class AVGameHandler
{
  private static String b = "AVGameHandler";
  private static final AVGameHandler c = new AVGameHandler();
  HandlerThread a = new HandlerThread("avgame_chat_thread");
  private Handler d;
  private Handler e;
  
  private AVGameHandler()
  {
    this.a.start();
    this.d = new Handler(this.a.getLooper());
    this.e = new Handler(Looper.getMainLooper());
  }
  
  public static AVGameHandler a()
  {
    return c;
  }
  
  public Handler b()
  {
    return this.d;
  }
  
  public Handler c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameHandler
 * JD-Core Version:    0.7.0.1
 */