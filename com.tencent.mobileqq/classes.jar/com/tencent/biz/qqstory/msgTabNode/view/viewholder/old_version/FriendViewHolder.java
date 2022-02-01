package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class FriendViewHolder
  extends BaseViewHolder
{
  private FaceDrawable a;
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.a);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str1 = String.valueOf(paramMsgTabNodeInfo.b);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, str1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
      String str2 = ContactUtils.m((QQAppInterface)localObject, str1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      ThreadManager.post(new FriendViewHolder.1(this, (QQAppInterface)localObject, str1), 8, null, true);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FriendViewHolder userItem = " + paramMsgTabNodeInfo.b + ", name = " + str2 + ", faceDrawable = " + this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder
 * JD-Core Version:    0.7.0.1
 */