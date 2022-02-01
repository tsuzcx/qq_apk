package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SelfNodeViewHolder
  extends MsgNodeViewHolder
{
  private boolean a;
  
  public SelfNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131628093);
  }
  
  private void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          super.b(paramMsgTabNodeInfo);
          this.c.b();
        }
      }
      else
      {
        super.b(paramMsgTabNodeInfo);
        this.c.a();
      }
    }
    else
    {
      super.b(paramMsgTabNodeInfo);
      this.c.b();
    }
    c(paramMsgTabNodeInfo);
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((!paramMsgTabNodeInfo.s) && (paramMsgTabNodeInfo.r <= 0))
    {
      b(ThumbnailUrlHelper.b(paramMsgTabNodeInfo.p));
      SLog.b("VASH", "bindCoverImage: %s", paramMsgTabNodeInfo.p);
      return;
    }
    b(paramMsgTabNodeInfo.t);
    if ((!paramMsgTabNodeInfo.s) && (paramMsgTabNodeInfo.r > 0)) {
      this.c.setDisplayState(1);
    } else {
      this.c.setDisplayState(0);
    }
    SLog.b("VASH", "bindCoverImage: %s", paramMsgTabNodeInfo.t);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject3 = (QQAppInterface)localObject1;
      Object localObject2 = String.valueOf(paramMsgTabNodeInfo.c);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (UserManager)SuperManager.a(2);
      localObject2 = QQStoryContext.a().i();
      localObject3 = ((UserManager)localObject3).b((String)localObject2);
      if (localObject3 == null) {
        if ("0_1000".equals(localObject2))
        {
          localObject2 = new QQUserUIItem.UserID(String.valueOf(localObject1), "");
          new GetUserInfoHandler().a(0, (QQUserUIItem.UserID)localObject2, String.valueOf(localObject1));
        }
        else
        {
          localObject1 = new QQUserUIItem.UserID("", (String)localObject2);
          new GetUserInfoHandler().a(1, (QQUserUIItem.UserID)localObject1, (String)localObject2);
        }
      }
      boolean bool;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip())) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
      if (this.a) {
        localObject1 = ((QQUserUIItem)localObject3).nickName;
      } else {
        localObject1 = HardCodeUtil.a(2131911232);
      }
      this.c.setNodeName((String)localObject1, this.a);
      c(paramMsgTabNodeInfo);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramMsgTabNodeInfo.s), ", unUploadVideoCount: ", Integer.valueOf(paramMsgTabNodeInfo.r) });
      }
    }
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    SLog.b("VASH", "My bindImage of data: %s", String.valueOf(paramMsgTabNodeInfo));
    if (paramMsgTabNodeInfo.s) {
      a(paramMsgTabNodeInfo, 1);
    } else if (paramMsgTabNodeInfo.r > 0) {
      a(paramMsgTabNodeInfo, 2);
    } else {
      a(paramMsgTabNodeInfo, 0);
    }
    this.c.a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.SelfNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */