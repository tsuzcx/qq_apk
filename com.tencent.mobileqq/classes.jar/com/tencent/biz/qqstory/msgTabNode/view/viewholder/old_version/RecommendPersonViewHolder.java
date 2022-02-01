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
      paramQQUserUIItem = HardCodeUtil.a(2131713190);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.itemView.setTag(2131374589, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.itemView.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(0);
    if (!TextUtils.equals((String)this.itemView.getTag(2131374589), paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))
    {
      Object localObject;
      if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList != null) && (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        String str = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
        Iterator localIterator = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
        do
        {
          localObject = str;
          if (!localIterator.hasNext()) {
            break;
          }
          localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
        } while (localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean);
        str = localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("i");
          ((StringBuilder)localObject).append(String.valueOf(localMsgTabNodeVideoInfo.jdField_a_of_type_Long));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = "";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "1", "", localObject });
      this.itemView.setTag(2131374589, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendPersonViewHolder
 * JD-Core Version:    0.7.0.1
 */