package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$BindTroopMemberClient
  extends AsyncStep
{
  public TroopMemberApiClient a;
  
  protected int doStep()
  {
    this.a = TroopMemberApiClient.a();
    this.a.a();
    this.a.e(new CaptureAsyncStep.BindTroopMemberClient.1(this));
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.BindTroopMemberClient
 * JD-Core Version:    0.7.0.1
 */