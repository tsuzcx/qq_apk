package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.biz.common.util.HttpUtil;
import java.util.List;

class AEBottomListAdapter$1$1
  implements Runnable
{
  AEBottomListAdapter$1$1(AEBottomListAdapter.1 param1) {}
  
  public void run()
  {
    int i = HttpUtil.getNetWorkType();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (AEBottomListAdapter.a(this.a.a).size() > 1)) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */