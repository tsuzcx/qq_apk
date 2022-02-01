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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
  
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
  
  public MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846881);
    }
    RoundBorderImageView localRoundBorderImageView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    UIUtils.a(localRoundBorderImageView, paramString, localDrawable, localDrawable, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, "msg_tab_thumb");
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    Object localObject1 = ((MsgTabStoryNodeConfigManager)QQStoryContext.a().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a();
    if ((localObject1 != null) && (((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = new MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.a((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bindData config=");
      ((StringBuilder)localObject2).append(((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).b);
      ((StringBuilder)localObject2).append(" id=");
      ((StringBuilder)localObject2).append(((MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig)localObject1).d);
      SLog.c("Q.qqstory.config.takevideo", ((StringBuilder)localObject2).toString());
      setNodeName(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.b, false);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130846881);
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.a.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "msg_tab_thumb";
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = UIUtils.a(getContext(), 3.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_b_of_type_Int;
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.a, (URLDrawable.URLDrawableOptions)localObject1);
        if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null)) {
          SLog.a("Q.qqstory.msgTab.MsgNodeShotView", "setImageByURLDrawable() %s, %s, not start download!", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.a, localObject1);
        } else if ((((URLDrawable)localObject1).getStatus() != 3) && (((URLDrawable)localObject1).getStatus() != 2)) {
          ((URLDrawable)localObject1).startDownload();
        } else {
          ((URLDrawable)localObject1).restartDownload();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.a);
      }
    }
    else
    {
      SLog.b("Q.qqstory.msgTab.MsgNodeShotView", "normal info");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130846881);
      setNodeName(HardCodeUtil.a(2131706982), false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = null;
    }
    a(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView
 * JD-Core Version:    0.7.0.1
 */