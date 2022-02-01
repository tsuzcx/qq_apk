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
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a(2131699904);
  }
  
  public FollowNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561714);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = null;
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
    this.itemView.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).a(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, false);
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    Object localObject1;
    if (MsgTabStoryNodeListManager.h)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      if ((localObject1 == null) || (!((QQUserUIItem)localObject1).isVipButNoFriend())) {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
    }
    Object localObject2 = a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = HardCodeUtil.a(2131704772);
      }
    }
    else
    {
      QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
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
      localObject1 = jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
        localObject1 = paramMsgTabNodeInfo.c;
      }
      SLog.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      StoryDispatcher.a().dispatch(new RequireUserItemEvent(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString));
      localObject2 = localObject1;
    }
    a((String)localObject2, this.jdField_a_of_type_Boolean, paramMsgTabNodeInfo);
    a(paramMsgTabNodeInfo.g);
  }
  
  protected void a(String paramString)
  {
    b(ThumbnailUrlHelper.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FollowNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */