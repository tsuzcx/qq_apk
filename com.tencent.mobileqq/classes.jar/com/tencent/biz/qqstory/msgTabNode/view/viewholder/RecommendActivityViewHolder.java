package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import nea;

public class RecommendActivityViewHolder
  extends BaseViewHolder
{
  public RecommendActivityViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public static final void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    ThreadManager.post(new nea(paramMsgTabNodeInfo), 8, null, true);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.c))
    {
      str = "热门活动";
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      if (paramMsgTabNodeInfo.jdField_b_of_type_Int <= 0) {
        break label150;
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      a(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + paramMsgTabNodeInfo.c + ", faceDrawable = " + paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString);
      }
      return;
      str = paramMsgTabNodeInfo.c;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */