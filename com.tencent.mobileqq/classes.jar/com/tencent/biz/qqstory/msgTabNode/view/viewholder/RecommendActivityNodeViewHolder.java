package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

public class RecommendActivityNodeViewHolder
  extends MsgNodeViewHolder
{
  public RecommendActivityNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561714);
  }
  
  public void a()
  {
    this.a.setTag(2131374589, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setDisplayState(2);
    c(paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
        str = HardCodeUtil.a(2131713188);
      } else {
        str = paramMsgTabNodeInfo.c;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, paramMsgTabNodeInfo.j);
    }
    else
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
        str = HardCodeUtil.a(2131713195);
      } else {
        str = paramMsgTabNodeInfo.c;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, false);
    }
    if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList == null) || (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.a.a(1, 1 - paramMsgTabNodeInfo.jdField_b_of_type_Int);
    }
    String str = (String)this.a.getTag(2131374589);
    if (!TextUtils.equals(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, str))
    {
      int i = paramMsgTabNodeInfo.jdField_a_of_type_Int;
      if (i != 10)
      {
        if (i != 11) {
          str = "unknown";
        } else {
          str = "3";
        }
      }
      else {
        str = "2";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131374589, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendActivityNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */