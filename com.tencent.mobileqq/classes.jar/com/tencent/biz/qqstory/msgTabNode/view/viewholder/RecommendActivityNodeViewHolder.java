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
    super(paramViewGroup, 2131561863);
  }
  
  public void a()
  {
    this.a.setTag(2131375066, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setDisplayState(2);
    c(paramMsgTabNodeInfo.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c))
      {
        str = HardCodeUtil.a(2131713220);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramMsgTabNodeInfo.j);
        if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList == null) || (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramMsgTabNodeInfo.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131375066);
        if (!TextUtils.equals(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, str)) {
          switch (paramMsgTabNodeInfo.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131375066, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      return;
      str = paramMsgTabNodeInfo.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {}
      for (str = HardCodeUtil.a(2131713227);; str = paramMsgTabNodeInfo.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, false);
        break;
      }
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendActivityNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */