package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SelfNodeViewHolder
  extends MsgNodeViewHolder
{
  private boolean a;
  
  public SelfNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2130970798);
  }
  
  private void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramMsgTabNodeInfo);
      return;
      super.b(paramMsgTabNodeInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramMsgTabNodeInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramMsgTabNodeInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo.jdField_b_of_type_Boolean) || (paramMsgTabNodeInfo.c > 0))
    {
      UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a, paramMsgTabNodeInfo.g, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.getHeight(), 2);
      if ((!paramMsgTabNodeInfo.jdField_b_of_type_Boolean) && (paramMsgTabNodeInfo.c > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        SLog.b("VASH", "bindCoverImage: %s", paramMsgTabNodeInfo.g);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    String str = ThumbnailUrlHelper.b(paramMsgTabNodeInfo.f);
    UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a, str, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.getHeight(), 2);
    SLog.b("VASH", "bindCoverImage: %s", paramMsgTabNodeInfo.f);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (UserManager)SuperManager.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((UserManager)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new QQUserUIItem.UserID(String.valueOf(localObject1), "");
        new GetUserInfoHandler().a(0, (QQUserUIItem.UserID)localObject2, String.valueOf(localObject1));
      }
      if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
        break label252;
      }
      bool = true;
      label141:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = "我")
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramMsgTabNodeInfo);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramMsgTabNodeInfo.c) });
      }
      return;
      label223:
      localObject1 = new QQUserUIItem.UserID("", (String)localObject2);
      new GetUserInfoHandler().a(1, (QQUserUIItem.UserID)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    SLog.b("VASH", "My bindImage of data: %s", String.valueOf(paramMsgTabNodeInfo));
    if (paramMsgTabNodeInfo.jdField_b_of_type_Boolean)
    {
      a(paramMsgTabNodeInfo, 1);
      return;
    }
    if (paramMsgTabNodeInfo.c > 0)
    {
      a(paramMsgTabNodeInfo, 2);
      return;
    }
    a(paramMsgTabNodeInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.SelfNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */