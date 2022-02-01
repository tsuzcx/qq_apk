package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;

public class AIOBusinessRecordHelper
  implements ILifeCycleHelper
{
  private void a()
  {
    com.etrump.mixlayout.FontManager.c = false;
    com.tencent.mobileqq.vas.AvatarPendantManager.b = false;
    com.tencent.mobileqq.bubble.BubbleManager.a = false;
    BubbleDiyFetcher.a().d();
    ThreadManager.executeOnSubThread(new AIOBusinessRecordHelper.1(this));
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOBusinessRecordHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 21 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOBusinessRecordHelper
 * JD-Core Version:    0.7.0.1
 */