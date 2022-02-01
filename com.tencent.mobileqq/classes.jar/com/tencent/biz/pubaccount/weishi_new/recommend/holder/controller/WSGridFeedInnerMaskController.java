package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSGridFeedInnerMaskController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  protected stSimpleMetaFeed g;
  private KandianUrlImageView h;
  
  public WSGridFeedInnerMaskController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void l()
  {
    if (m())
    {
      this.h.setVisibility(0);
      WSPicLoader.a().a(this.h, this.g.h5_op_info.maskImgUrl);
      return;
    }
    this.h.setVisibility(8);
  }
  
  private boolean m()
  {
    return (this.g.video_type == 1) && (WSGlobalConfig.a().b(1) == 2) && (this.g.h5_op_info != null) && (!TextUtils.isEmpty(this.g.h5_op_info.maskImgUrl));
  }
  
  protected void a()
  {
    this.g = ((stSimpleMetaFeed)c());
  }
  
  protected void b()
  {
    l();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626471;
  }
  
  protected void j()
  {
    this.h = ((KandianUrlImageView)c(2131436092));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerMaskController
 * JD-Core Version:    0.7.0.1
 */