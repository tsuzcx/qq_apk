package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class MsgNodeShotView
  extends StoryMsgNodeFrameLayout
{
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig n;
  private Drawable o;
  
  public MsgNodeShotView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MsgNodeShotView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDisplayState(4);
    d();
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    Object localObject1 = ((MsgTabStoryNodeConfigManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).b();
    if ((localObject1 != null) && (((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).a()))
    {
      this.n = new MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig();
      this.n.a((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bindData config=");
      ((StringBuilder)localObject2).append(((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).d);
      ((StringBuilder)localObject2).append(" id=");
      ((StringBuilder)localObject2).append(((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).f);
      SLog.c("Q.qqstory.config.takevideo", ((StringBuilder)localObject2).toString());
      setNodeName(this.n.d, false);
      if (this.o == null) {
        this.o = getContext().getResources().getDrawable(2130848433);
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      if (this.n.c.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "msg_tab_thumb";
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = UIUtils.a(getContext(), 3.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.b;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.c;
        localObject2 = this.o;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(this.n.c, (URLDrawable.URLDrawableOptions)localObject1);
        if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null)) {
          SLog.a("Q.qqstory.msgTab.MsgNodeShotView", "setImageByURLDrawable() %s, %s, not start download!", this.n.c, localObject1);
        } else if ((((URLDrawable)localObject1).getStatus() != 3) && (((URLDrawable)localObject1).getStatus() != 2)) {
          ((URLDrawable)localObject1).startDownload();
        } else {
          ((URLDrawable)localObject1).restartDownload();
        }
        this.a.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        setRoundImageViewCoverUrl(this.n.c);
      }
    }
    else
    {
      SLog.b("Q.qqstory.msgTab.MsgNodeShotView", "normal info");
      this.a.setImageResource(2130848433);
      setNodeName(HardCodeUtil.a(2131904824), false);
      this.n = null;
    }
    setCornerMarkVisible(8);
    this.i.setVisibility(8);
  }
  
  public String getShotViewName()
  {
    return this.l.getText().toString();
  }
  
  public MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig getUsingConfigInfo()
  {
    return this.n;
  }
  
  protected void setRoundImageViewCoverUrl(String paramString)
  {
    if (this.o == null) {
      this.o = getContext().getResources().getDrawable(2130848433);
    }
    RoundBorderImageView localRoundBorderImageView = this.a;
    Drawable localDrawable = this.o;
    UIUtils.a(localRoundBorderImageView, paramString, localDrawable, localDrawable, this.c, this.b, "msg_tab_thumb");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView
 * JD-Core Version:    0.7.0.1
 */