package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import lnn;

public class ReadInJoyWebProcessManager
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new lnn(paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager
 * JD-Core Version:    0.7.0.1
 */