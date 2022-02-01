package com.tencent.biz.qqcircle.immersive;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalInfoBlock;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QFSPersonalDetailsFragment$1
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QFSPersonalDetailsFragment$1(QFSPersonalDetailsFragment paramQFSPersonalDetailsFragment) {}
  
  public void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    if (paramUIStateData.c() != 1)
    {
      if (paramUIStateData.c() == 2) {
        return;
      }
      QFSPersonalDetailsFragment.a(this.a).notifyLoadingComplete(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment.1
 * JD-Core Version:    0.7.0.1
 */