package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.mobileqq.widget.QQToast;

class WSEpisodeChoicePanel$8
  implements IFetchDataListener<Integer>
{
  WSEpisodeChoicePanel$8(WSEpisodeChoicePanel paramWSEpisodeChoicePanel, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramString = WSEpisodeChoicePanel.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel).getResources().getString(1929707525);
      QQToast.a(WSEpisodeChoicePanel.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel), 1, paramString, 0).a();
    }
  }
  
  public void a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    WSEpisodeChoicePanel.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel.8
 * JD-Core Version:    0.7.0.1
 */