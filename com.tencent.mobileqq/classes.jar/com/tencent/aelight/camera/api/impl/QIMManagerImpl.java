package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.api.IQIMManager;

public class QIMManagerImpl
  implements IQIMManager
{
  public void destory()
  {
    AEQIMManager.a().a();
    QIMManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.QIMManagerImpl
 * JD-Core Version:    0.7.0.1
 */