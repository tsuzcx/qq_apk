package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class FriendNodeViewHolder
  extends MsgNodeViewHolder
{
  public FriendNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561714);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    SLog.a("FriendNodeViewHolder", "bindData %s", paramMsgTabNodeInfo);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
      Object localObject2 = String.valueOf(paramMsgTabNodeInfo.b);
      b(ThumbnailUrlHelper.b(paramMsgTabNodeInfo.g));
      if (MsgTabStoryNodeListManager.h) {
        localObject1 = ContactUtils.f(localQQAppInterface, (String)localObject2);
      } else {
        localObject1 = localObject2;
      }
      this.a.setNodeName((String)localObject1, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, (String)localObject2), 8, null, true);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("userItem = ");
        ((StringBuilder)localObject2).append(paramMsgTabNodeInfo.b);
        ((StringBuilder)localObject2).append(", name = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("FriendNodeViewHolder", 2, new Object[] { ((StringBuilder)localObject2).toString(), " list: ", String.valueOf(paramMsgTabNodeInfo.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramMsgTabNodeInfo) });
      }
    }
    super.a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */