package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class RecommendActivityViewHolder
  extends BaseViewHolder
{
  public static final void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(paramMsgTabNodeInfo), 8, null, true);
  }
  
  public void a()
  {
    this.itemView.setTag(2131374589, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    PlayModeUtils.b(this.jdField_a_of_type_AndroidWidgetImageView, paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString, true, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 50.0F));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
      localObject = HardCodeUtil.a(2131713189);
    } else {
      localObject = paramMsgTabNodeInfo.c;
    }
    localTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(0);
    int i;
    if (paramMsgTabNodeInfo.jdField_b_of_type_Int > 0) {
      i = 1;
    } else {
      i = 0;
    }
    a(1, i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FollowPersonViewHolder userItem = ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.c);
      ((StringBuilder)localObject).append(", faceDrawable = ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString);
      QLog.e("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (String)this.itemView.getTag(2131374589);
    if (!TextUtils.equals(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
    {
      i = paramMsgTabNodeInfo.jdField_a_of_type_Int;
      if (i != 10)
      {
        if (i != 11) {
          localObject = "unknown";
        } else {
          localObject = "3";
        }
      }
      else {
        localObject = "2";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, localObject });
      this.itemView.setTag(2131374589, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */