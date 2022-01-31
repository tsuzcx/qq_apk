package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class FollowPersonViewHolder
  extends BaseViewHolder
{
  protected boolean a;
  
  public FollowPersonViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return null;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    Object localObject2 = a(paramQQUserUIItem);
    Object localObject1;
    label87:
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843570);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "热门达人";
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = PlayModeUtils.b;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      if ((paramQQUserUIItem != null) && (HttpUtil.a(paramQQUserUIItem.headUrl))) {
        break label212;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.b());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("FollowPersonViewHolder nickname = ").append((String)localObject2).append(", userItem = ").append(paramQQUserUIItem).append(", isVip = ");
        if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isVipButNoFriend())) {
          break label240;
        }
        bool = true;
        label147:
        localObject1 = ((StringBuilder)localObject1).append(bool).append(", faceDrawable = ");
        if (paramQQUserUIItem != null) {
          break label245;
        }
      }
    }
    label212:
    label240:
    label245:
    for (paramQQUserUIItem = "null";; paramQQUserUIItem = paramQQUserUIItem.headUrl)
    {
      QLog.e("zivonchen", 2, paramQQUserUIItem);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = localObject2;
      if (paramQQUserUIItem == null) {
        break;
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = paramQQUserUIItem.qq;
      break;
      PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
      break label87;
      bool = false;
      break label147;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.a);
    paramMsgTabNodeInfo = ((UserManager)SuperManager.a(2)).c(paramMsgTabNodeInfo.a);
    if ((paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.isVipButNoFriend())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(paramMsgTabNodeInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FollowPersonViewHolder
 * JD-Core Version:    0.7.0.1
 */