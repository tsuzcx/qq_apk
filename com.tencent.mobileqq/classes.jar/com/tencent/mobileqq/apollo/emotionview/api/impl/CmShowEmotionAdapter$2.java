package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.OnTagUpdateListener;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;

class CmShowEmotionAdapter$2
  implements ApolloTagActionViewBinder.OnTagUpdateListener
{
  CmShowEmotionAdapter$2(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void a(List<ApolloInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      ThreadManagerV2.getUIHandlerV2().post(new CmShowEmotionAdapter.2.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */