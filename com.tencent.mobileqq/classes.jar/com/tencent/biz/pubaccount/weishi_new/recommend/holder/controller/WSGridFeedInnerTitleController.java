package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSGridFeedInnerTitleController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private TextView g;
  private stSimpleMetaFeed h;
  
  public WSGridFeedInnerTitleController(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    this.h = ((stSimpleMetaFeed)c());
  }
  
  protected void b()
  {
    String str = this.h.feed_desc;
    if (!TextUtils.isEmpty(str))
    {
      this.g.setVisibility(0);
      this.g.setTextColor(l());
      this.g.setTextSize(2, m());
      this.g.setText(str);
      return;
    }
    this.g.setVisibility(8);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626476;
  }
  
  protected void j()
  {
    this.g = ((TextView)c(2131436091));
  }
  
  @ColorInt
  protected int l()
  {
    return -1;
  }
  
  protected int m()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTitleController
 * JD-Core Version:    0.7.0.1
 */