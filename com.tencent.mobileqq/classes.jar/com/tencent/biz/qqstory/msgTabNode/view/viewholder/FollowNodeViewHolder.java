package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.events.RequireUserItemEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.dispatch.Dispatcher;

public class FollowNodeViewHolder
  extends MsgNodeViewHolder
{
  public static final String b = StoryApi.b(2131897957);
  public QQUserUIItem a = null;
  private boolean d;
  
  public FollowNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131628093);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isAvailable()))
    {
      if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
        return paramQQUserUIItem.nickName;
      }
      return paramQQUserUIItem.getDisplayName();
    }
    return null;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    SLog.a("FollowNodeViewHolder", "bindData %s", paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.d);
    this.a = ((UserManager)SuperManager.a(2)).c(paramMsgTabNodeInfo.d, false);
    boolean bool = true;
    this.d = true;
    Object localObject1;
    if (MsgTabStoryNodeListManager.B)
    {
      localObject1 = this.a;
      if ((localObject1 == null) || (!((QQUserUIItem)localObject1).isVipButNoFriend())) {
        bool = false;
      }
      this.d = bool;
    }
    Object localObject2 = a(this.a);
    if (this.d)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = HardCodeUtil.a(2131902674);
      }
    }
    else
    {
      QQUserUIItem localQQUserUIItem = this.a;
      localObject1 = localObject2;
      if (localQQUserUIItem != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localQQUserUIItem.qq;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = b;
      if (!TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
        localObject1 = paramMsgTabNodeInfo.l;
      }
      SLog.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramMsgTabNodeInfo.d);
      StoryDispatcher.a().dispatch(new RequireUserItemEvent(paramMsgTabNodeInfo.d));
      localObject2 = localObject1;
    }
    a((String)localObject2, this.d, paramMsgTabNodeInfo);
    a(paramMsgTabNodeInfo.p);
  }
  
  protected void a(String paramString)
  {
    b(ThumbnailUrlHelper.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.c.setNodeName(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FollowNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */