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
    super(paramViewGroup, 2131561863);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    SLog.a("FriendNodeViewHolder", "bindData %s", paramMsgTabNodeInfo);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramMsgTabNodeInfo.b);
      b(ThumbnailUrlHelper.b(paramMsgTabNodeInfo.g));
      if (!MsgTabStoryNodeListManager.h) {
        break label180;
      }
    }
    label180:
    for (localObject = ContactUtils.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramMsgTabNodeInfo.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramMsgTabNodeInfo.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramMsgTabNodeInfo) });
      }
      super.a(paramMsgTabNodeInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */