package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.mobileqq.widget.QQToast;

class WSEpisodeChoicePanel$8
  implements IFetchDataListener<Integer>
{
  WSEpisodeChoicePanel$8(WSEpisodeChoicePanel paramWSEpisodeChoicePanel, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!this.a)
    {
      paramString = WSEpisodeChoicePanel.g(this.b).getResources().getString(1929838607);
      QQToast.makeText(WSEpisodeChoicePanel.g(this.b), 1, paramString, 0).show();
    }
  }
  
  public void a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    WSEpisodeChoicePanel.b(this.b, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.8
 * JD-Core Version:    0.7.0.1
 */