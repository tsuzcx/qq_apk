package com.tencent.biz.qqstory.troop.memories;

import android.os.Handler;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopStoryMemoriesListAdapter$GetFeedFeatureHelper
  implements Runnable
{
  List<String> a = new ArrayList();
  Handler b = new Handler(ThreadManager.getSubThreadLooper());
  final int c = 500;
  
  public void run()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start to send GetFeedFeature request: ");
      localStringBuilder.append(this.a);
      QLog.d("TroopStoryMemoriesListAdapter", 2, localStringBuilder.toString());
    }
    GetFeedFeatureHandler.a(this.a);
    this.a = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.GetFeedFeatureHelper
 * JD-Core Version:    0.7.0.1
 */