package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsWithColumnViewHolder;

class RIJVideoHandleClick$6
  implements ClickHandler
{
  RIJVideoHandleClick$6(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof VideoFeedsWithColumnViewHolder)) {
      ((VideoFeedsWithColumnViewHolder)localObject).onClick(paramView);
    }
    do
    {
      return;
      localObject = (VideoFeedsViewHolder)paramView.getTag();
      localObject = RIJVideoHandleClick.a(this.a).a(((VideoFeedsViewHolder)localObject).a);
    } while (localObject == null);
    RIJUserLevelModule.a().a(RIJVideoHandleClick.a(this.a), 2, new RIJVideoHandleClick.6.1(this, (BaseArticleInfo)localObject, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.6
 * JD-Core Version:    0.7.0.1
 */