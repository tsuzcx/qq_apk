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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
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
    jdField_a_of_type_JavaLangString = "Q.qqstory.msgTab." + SelfViewHolder.class.getSimpleName();
    jdField_b_of_type_Int = 1;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.itemView.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject1 instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long);
      if (!"0".equals(localObject1)) {
        break label332;
      }
      localObject1 = localQQAppInterface.getCurrentAccountUin();
    }
    label142:
    label283:
    label288:
    label307:
    label332:
    for (;;)
    {
      Object localObject3 = (UserManager)SuperManager.a(2);
      Object localObject2 = QQStoryContext.a().b();
      localObject3 = ((UserManager)localObject3).b((String)localObject2);
      boolean bool;
      if (localObject3 == null)
      {
        if ("0_1000".equals(localObject2))
        {
          localObject2 = new QQUserUIItem.UserID(String.valueOf(localObject1), "");
          new GetUserInfoHandler().a(0, (QQUserUIItem.UserID)localObject2, String.valueOf(localObject1));
        }
      }
      else
      {
        if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
          break label283;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if (!this.jdField_a_of_type_Boolean) {
          break label288;
        }
        PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, ((QQUserUIItem)localObject3).headUrl, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("我");
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramMsgTabNodeInfo.c) });
        }
        if (!paramMsgTabNodeInfo.jdField_b_of_type_Boolean) {
          break label307;
        }
        a(paramMsgTabNodeInfo, jdField_b_of_type_Int);
        return;
        QQUserUIItem.UserID localUserID = new QQUserUIItem.UserID("", (String)localObject2);
        new GetUserInfoHandler().a(1, localUserID, (String)localObject2);
        break;
        bool = false;
        break label142;
        localObject1 = FaceDrawable.a(localQQAppInterface, 1, (String)localObject1);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      if (paramMsgTabNodeInfo.c > 0)
      {
        a(paramMsgTabNodeInfo, c);
        return;
      }
      a(paramMsgTabNodeInfo, jdField_a_of_type_Int);
      return;
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843606);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      if (paramInt == jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.ROTATE);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
    } while (paramInt != c);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderColors(new int[] { -65536 });
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843611);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.SelfViewHolder
 * JD-Core Version:    0.7.0.1
 */