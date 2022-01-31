package com.tencent.intervideo.nowproxy;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.intervideo.nowproxy.common.ThreadManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

class NowRoomEntry$3
  implements EnterCallback
{
  NowRoomEntry$3(NowRoomEntry paramNowRoomEntry, Bundle paramBundle) {}
  
  public void onCloseLoadingView()
  {
    ThreadManager.getUIThreadHandler().post(new NowRoomEntry.3.2(this));
  }
  
  public void onEnterComplete()
  {
    ThreadManager.getUIThreadHandler().post(new NowRoomEntry.3.3(this));
  }
  
  public void onShowLoadingView(View paramView)
  {
    ThreadManager.getUIThreadHandler().post(new NowRoomEntry.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry.3
 * JD-Core Version:    0.7.0.1
 */