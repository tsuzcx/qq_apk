package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.qphone.base.util.QLog;

public class ViewHolderFactory
{
  private static String a = ViewHolderFactory.class.getSimpleName();
  
  public static BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e(a, 2, "发现一个野生的类型: " + paramInt);
      }
      return new BaseViewHolder(paramViewGroup, 2130970782);
    case 6: 
      return new FriendViewHolder(paramViewGroup, 2130970782);
    case 5: 
      return new SelfViewHolder(paramViewGroup, 2130970782);
    case 7: 
      return new FollowPersonViewHolder(paramViewGroup, 2130970782);
    case 8: 
      return new ShareGroupViewHolder(paramViewGroup, 2130970782);
    case 9: 
      return new RecommendPersonViewHolder(paramViewGroup, 2130970782);
    case 3: 
      return new GuideViewHolder(paramViewGroup, 2130970783);
    case 4: 
      return new AllStoryViewHolder(paramViewGroup, 2130970783);
    case 2: 
      return new NewMessageViewHolder(paramViewGroup, 2130970784);
    }
    return new RecommendActivityViewHolder(paramViewGroup, 2130970782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.ViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */