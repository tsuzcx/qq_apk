package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
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
      paramQQUserUIItem = HardCodeUtil.a(2131713179);
    }
    return paramQQUserUIItem;
  }
  
  public void a()
  {
    this.a.setTag(2131374589, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setDisplayState(2);
    if (!TextUtils.equals((String)this.a.getTag(2131374589), paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))
    {
      Object localObject;
      if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList != null) && (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        String str = ((MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
        Iterator localIterator = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          localObject = str;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (MsgTabNodeVideoInfo)localIterator.next();
        } while (((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean);
        localObject = ((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_JavaLangString;
      }
      else
      {
        localObject = "";
      }
      StoryReportor.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "1", "", localObject });
      this.a.setTag(2131374589, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(String paramString)
  {
    c(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((!TextUtils.isEmpty(paramMsgTabNodeInfo.j)) && (!paramBoolean))
    {
      this.a.setNodeName(paramString, paramMsgTabNodeInfo.j);
      return;
    }
    super.a(paramString, paramBoolean, paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendFollowNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */