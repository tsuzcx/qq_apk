package com.tencent.imcore.message;

public class InitMsgModule
{
  public static void a()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.app.QQMessageFacadeConfig");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.InitMsgModule
 * JD-Core Version:    0.7.0.1
 */