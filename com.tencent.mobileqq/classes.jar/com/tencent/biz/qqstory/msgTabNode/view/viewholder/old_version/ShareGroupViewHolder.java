package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class ShareGroupViewHolder
  extends BaseViewHolder
{
  public ShareGroupViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.a);
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(paramMsgTabNodeInfo.a);
    a(localShareGroupItem);
    if (localShareGroupItem == null) {
      new GetShareGroupInfoHandler(paramMsgTabNodeInfo.a, String.valueOf(System.currentTimeMillis())).a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShareGroupViewHolder groupItem = ");
      localStringBuilder.append(localShareGroupItem);
      localStringBuilder.append(", unionId = ");
      localStringBuilder.append(paramMsgTabNodeInfo.a);
      QLog.e("zivonchen", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(ShareGroupItem paramShareGroupItem)
  {
    String str;
    if ((paramShareGroupItem != null) && (!TextUtils.isEmpty(paramShareGroupItem.getName()))) {
      str = paramShareGroupItem.getName();
    } else {
      str = HardCodeUtil.a(2131713807);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    Object localObject = (ShareGroupIconManager)SuperManager.a(24);
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDimensionPixelSize(2131298600);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    else
    {
      localLayoutParams.width = i;
      localLayoutParams.height = i;
    }
    if (paramShareGroupItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((ShareGroupIconManager)localObject).a());
      return;
    }
    localObject = ((ShareGroupIconManager)localObject).a(paramShareGroupItem.headerUnionIdList, str);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("nickname = ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", headerUnionIdList = ");
      ((StringBuilder)localObject).append(paramShareGroupItem.headerUnionIdList);
      paramShareGroupItem = new StringBuilder();
      paramShareGroupItem.append("ShareGroupViewHolder: ");
      paramShareGroupItem.append(((StringBuilder)localObject).toString());
      QLog.e("zivonxxx", 2, paramShareGroupItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.ShareGroupViewHolder
 * JD-Core Version:    0.7.0.1
 */