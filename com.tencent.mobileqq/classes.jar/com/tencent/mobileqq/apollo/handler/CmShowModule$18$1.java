package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.listener.Save3DFaceListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$18$1
  implements Save3DFaceListener
{
  CmShowModule$18$1(CmShowModule.18 param18) {}
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    this.a.b.putBundle("response", localBundle);
    this.a.a.a(this.a.b);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    localBundle.putString("faceUrl", paramString);
    this.a.b.putBundle("response", localBundle);
    this.a.a.a(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.18.1
 * JD-Core Version:    0.7.0.1
 */