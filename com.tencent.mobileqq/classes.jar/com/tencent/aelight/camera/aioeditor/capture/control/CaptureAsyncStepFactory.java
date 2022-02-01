package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CaptureAsyncStepFactory
{
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (!TextUtils.isEmpty(str))
    {
      int i = -1;
      if (str.startsWith("{"))
      {
        paramString = new CaptureAsyncStepFactory.CaptureLinearGroup();
        paramString.a = str;
      }
      else if (str.startsWith("["))
      {
        paramString = new CaptureAsyncStepFactory.CaptureParallGroup();
        paramString.a = str;
      }
      else
      {
        i = Integer.parseInt(str);
        switch (i)
        {
        default: 
          paramString = new AsyncStep();
          break;
        case 1010: 
          paramString = new CaptureAsyncStep.InitLoadSegmentSo();
          break;
        case 1009: 
          paramString = new UpdateAllFullMusicInfoTask();
          break;
        case 1008: 
          paramString = new GetAllFullMusicInfoTask();
          break;
        case 1007: 
          paramString = new CaptureAsyncStep.OnShowOther();
          break;
        case 1006: 
          paramString = new CaptureAsyncStep.InitMusic();
          break;
        case 1005: 
          paramString = new CaptureAsyncStep.InitPaster();
          break;
        case 1004: 
          paramString = new CaptureAsyncStep.InitCombo();
          break;
        case 1003: 
          paramString = new CaptureAsyncStep.InitTemplate();
          break;
        case 1002: 
          paramString = new CaptureAsyncStep.LoadQzoneConfig();
          break;
        case 1001: 
          paramString = new CaptureAsyncStep.BindTroopMemberClient();
          break;
        case 1000: 
          paramString = new CaptureAsyncStep.BindRichMediaClient();
        }
      }
      paramString.mAutomator = paramAutomator;
      paramString.mStepId = i;
      if (i >= 0)
      {
        paramString.mName = paramString.getClass().getSimpleName();
        return paramString;
      }
      paramString.mName = str;
      return paramString;
    }
    paramAutomator = new StringBuilder();
    paramAutomator.append("createStepGroup: ");
    paramAutomator.append(str);
    throw new RuntimeException(paramAutomator.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStepFactory
 * JD-Core Version:    0.7.0.1
 */