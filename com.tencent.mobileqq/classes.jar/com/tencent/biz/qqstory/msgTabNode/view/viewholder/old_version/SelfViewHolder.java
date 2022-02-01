package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SelfViewHolder
  extends BaseViewHolder
{
  protected static int a;
  protected static String a;
  protected static int b;
  protected static int c = 2;
  protected boolean a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.msgTab.");
    localStringBuilder.append(SelfViewHolder.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.itemView.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
      Object localObject2 = String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = localQQAppInterface.getCurrentAccountUin();
      }
      Object localObject3 = (UserManager)SuperManager.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((UserManager)localObject3).b((String)localObject2);
      if (localObject3 == null) {
        if ("0_1000".equals(localObject2))
        {
          localObject2 = new QQUserUIItem.UserID(String.valueOf(localObject1), "");
          new GetUserInfoHandler().a(0, (QQUserUIItem.UserID)localObject2, String.valueOf(localObject1));
        }
        else
        {
          QQUserUIItem.UserID localUserID = new QQUserUIItem.UserID("", (String)localObject2);
          new GetUserInfoHandler().a(1, localUserID, (String)localObject2);
        }
      }
      boolean bool;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip())) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, ((QQUserUIItem)localObject3).headUrl, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
      }
      else
      {
        localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, (String)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713688));
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramMsgTabNodeInfo.d) });
      }
      if (paramMsgTabNodeInfo.jdField_b_of_type_Boolean)
      {
        a(paramMsgTabNodeInfo, jdField_b_of_type_Int);
        return;
      }
      if (paramMsgTabNodeInfo.d > 0)
      {
        a(paramMsgTabNodeInfo, c);
        return;
      }
      a(paramMsgTabNodeInfo, jdField_a_of_type_Int);
    }
  }
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "setViewStatus: status=", Integer.valueOf(paramInt) });
    }
    if (paramInt == jdField_a_of_type_Int)
    {
      a(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size(), paramMsgTabNodeInfo.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846865);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (paramInt == jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.ROTATE);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (paramInt == c)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderColors(new int[] { -65536 });
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846871);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.SelfViewHolder
 * JD-Core Version:    0.7.0.1
 */