package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.NewMessageViewHolder;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.ShareGroupViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;

public class ViewHolderFactory
{
  private static String a = "ViewHolderFactory";
  
  public static BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    SLog.a(a, "create type=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("发现一个野生的类型: ");
        localStringBuilder.append(paramInt);
        QLog.e(str, 2, localStringBuilder.toString());
      }
      break;
    case 13: 
      return new MsgNodeNewGuideViewHolder(paramViewGroup);
    case 12: 
      return new WeiShiRecommendNodeViewHolder(paramViewGroup);
    case 10: 
    case 11: 
      return new RecommendActivityNodeViewHolder(paramViewGroup);
    case 9: 
      return new RecommendFollowNodeViewHolder(paramViewGroup);
    case 8: 
      return new ShareGroupViewHolder(paramViewGroup, 2131561715);
    case 7: 
      return new FollowNodeViewHolder(paramViewGroup);
    case 6: 
      return new FriendNodeViewHolder(paramViewGroup);
    case 5: 
      return new SelfNodeViewHolder(paramViewGroup);
    case 4: 
      return new NormalNodeView(paramViewGroup, 4);
    case 3: 
      return new MsgNodeGuideViewHolder(paramViewGroup);
    case 2: 
      return new NewMessageViewHolder(paramViewGroup, 2131561717);
    }
    return new BaseViewHolder(paramViewGroup, 2131561715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.ViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */