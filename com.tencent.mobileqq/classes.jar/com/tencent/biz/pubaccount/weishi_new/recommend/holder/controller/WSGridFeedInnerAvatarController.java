package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;

public class WSGridFeedInnerAvatarController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private WSRoundedImageView g;
  private TextView h;
  private TextView i;
  private stSimpleMetaFeed j;
  
  public WSGridFeedInnerAvatarController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void m()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.j.poster;
    WSPicLoader.a().a(this.a, this.g, localstSimpleMetaPerson.avatar);
    this.h.setTextColor(l());
    this.h.setText(WSFeedUtils.a(localstSimpleMetaPerson.nick));
    WSFeedUtils.a(this.i, localstSimpleMetaPerson.medal, false);
  }
  
  protected void a()
  {
    this.j = ((stSimpleMetaFeed)c());
  }
  
  protected void b()
  {
    m();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626465;
  }
  
  protected void j()
  {
    this.g = ((WSRoundedImageView)c(2131436087));
    this.h = ((TextView)c(2131436094));
    this.i = ((TextView)c(2131436093));
  }
  
  @ColorInt
  protected int l()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerAvatarController
 * JD-Core Version:    0.7.0.1
 */