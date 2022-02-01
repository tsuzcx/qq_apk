package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Iterator;
import java.util.List;

public class RecommendPersonViewHolder
  extends FollowPersonViewHolder
{
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    String str = super.a(paramQQUserUIItem);
    paramQQUserUIItem = str;
    if (str == null) {
      paramQQUserUIItem = HardCodeUtil.a(2131713222);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.itemView.setTag(2131375066, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(0);
    String str1;
    if (!TextUtils.equals((String)this.itemView.getTag(2131375066), paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))
    {
      if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList == null) || (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label237;
      }
      String str2 = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      Iterator localIterator = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
      do
      {
        str1 = str2;
        if (!localIterator.hasNext()) {
          break;
        }
        localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
      } while (localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean);
      str2 = localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString;
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break label234;
      }
      str1 = "i" + String.valueOf(localMsgTabNodeVideoInfo.jdField_a_of_type_Long);
    }
    for (;;)
    {
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "1", "", str1 });
      this.itemView.setTag(2131375066, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      return;
      label234:
      continue;
      label237:
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendPersonViewHolder
 * JD-Core Version:    0.7.0.1
 */