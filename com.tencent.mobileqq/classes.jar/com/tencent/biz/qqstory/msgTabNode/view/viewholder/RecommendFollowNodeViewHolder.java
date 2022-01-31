package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.Iterator;
import java.util.List;

public class RecommendFollowNodeViewHolder
  extends FollowNodeViewHolder
{
  public RecommendFollowNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = "热门达人";
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131362464, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setDisplayState(2);
    String str;
    if (!TextUtils.equals((String)this.a.getTag(2131362464), paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))
    {
      if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList == null) || (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label168;
      }
      str = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
        if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
          str = localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "1", "", str });
      this.a.setTag(2131362464, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      return;
      continue;
      label168:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendFollowNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */