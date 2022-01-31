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
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "ShareGroupViewHolder groupItem = " + localShareGroupItem + ", unionId = " + paramMsgTabNodeInfo.a);
    }
  }
  
  protected void a(ShareGroupItem paramShareGroupItem)
  {
    String str;
    Object localObject;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((paramShareGroupItem == null) || (TextUtils.isEmpty(paramShareGroupItem.getName())))
    {
      str = "圈子";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      localObject = (ShareGroupIconManager)SuperManager.a(24);
      i = this.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDimensionPixelSize(2131560145);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localLayoutParams != null) {
        break label113;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      label88:
      if (paramShareGroupItem != null) {
        break label128;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((ShareGroupIconManager)localObject).a());
    }
    label113:
    do
    {
      return;
      str = paramShareGroupItem.getName();
      break;
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      break label88;
      localObject = ((ShareGroupIconManager)localObject).a(paramShareGroupItem.headerUnionIdList, str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    label128:
    paramShareGroupItem = new StringBuilder("nickname = ").append(str).append(", headerUnionIdList = ").append(paramShareGroupItem.headerUnionIdList);
    QLog.e("zivonxxx", 2, "ShareGroupViewHolder: " + paramShareGroupItem.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.ShareGroupViewHolder
 * JD-Core Version:    0.7.0.1
 */