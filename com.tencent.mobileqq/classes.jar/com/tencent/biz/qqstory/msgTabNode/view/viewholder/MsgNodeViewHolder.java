package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;

public class MsgNodeViewHolder
  extends BaseViewHolder<MsgTabNodeInfo>
{
  private Drawable a;
  public StoryMsgNodeFrameLayout c = (StoryMsgNodeFrameLayout)this.itemView;
  
  public MsgNodeViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  @CallSuper
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.c.setTag(paramMsgTabNodeInfo.d);
    b(paramMsgTabNodeInfo);
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.c.setDisplayState(0);
    if ((paramMsgTabNodeInfo.e != null) && (!paramMsgTabNodeInfo.e.isEmpty())) {
      this.c.a(paramMsgTabNodeInfo.e.size(), paramMsgTabNodeInfo.e.size() - paramMsgTabNodeInfo.i);
    }
    this.c.a(paramMsgTabNodeInfo);
  }
  
  protected void b(String paramString)
  {
    if (this.a == null) {
      this.a = a().getResources().getDrawable(2130848395);
    }
    RoundBorderImageView localRoundBorderImageView = this.c.a;
    Drawable localDrawable = this.a;
    UIUtils.a(localRoundBorderImageView, paramString, localDrawable, localDrawable, this.c.c, this.c.b, "msg_tab_thumb");
  }
  
  protected void c(String paramString)
  {
    Drawable localDrawable = a().getResources().getDrawable(2130848395);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mMemoryCacheKeySuffix = "msg_tab_thumb";
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mGifRoundCorner = UIUtils.a(a(), 3.0F);
    localURLDrawableOptions.mRequestHeight = this.c.b;
    localURLDrawableOptions.mRequestWidth = this.c.c;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setURLDrawableListener(new MsgNodeViewHolder.1(this));
    if ((paramString.getStatus() != 1) || (paramString.getCurrDrawable() == null)) {
      if ((paramString.getStatus() != 3) && (paramString.getStatus() != 2)) {
        paramString.startDownload();
      } else {
        paramString.restartDownload();
      }
    }
    this.c.a.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */