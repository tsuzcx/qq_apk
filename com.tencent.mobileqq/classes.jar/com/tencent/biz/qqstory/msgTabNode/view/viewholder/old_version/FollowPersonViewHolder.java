package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class FollowPersonViewHolder
  extends BaseViewHolder
{
  protected boolean a;
  
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
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    Object localObject2 = a(paramQQUserUIItem);
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846865);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = HardCodeUtil.a(2131704773);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = localObject2;
      if (paramQQUserUIItem != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramQQUserUIItem.qq;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = PlayModeUtils.b;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    boolean bool = true;
    if ((paramQQUserUIItem != null) && (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl))) {
      PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramQQUserUIItem.headUrl, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.e());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FollowPersonViewHolder nickname = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(", userItem = ");
      ((StringBuilder)localObject1).append(paramQQUserUIItem);
      ((StringBuilder)localObject1).append(", isVip = ");
      if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isVipButNoFriend())) {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", faceDrawable = ");
      if (paramQQUserUIItem == null) {
        paramQQUserUIItem = "null";
      } else {
        paramQQUserUIItem = paramQQUserUIItem.headUrl;
      }
      ((StringBuilder)localObject1).append(paramQQUserUIItem);
      QLog.e("zivonchen", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.a);
    paramMsgTabNodeInfo = ((UserManager)SuperManager.a(2)).c(paramMsgTabNodeInfo.a);
    boolean bool;
    if ((paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.isVipButNoFriend())) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FollowPersonViewHolder
 * JD-Core Version:    0.7.0.1
 */