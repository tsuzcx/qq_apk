package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConfessNewsItemBuilder$1
  implements View.OnClickListener
{
  ConfessNewsItemBuilder$1(ConfessNewsItemBuilder paramConfessNewsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ConfessNewsBgView))
    {
      Object localObject = paramView.getTag();
      if ((localObject instanceof MessageForConfessNews))
      {
        localObject = (MessageForConfessNews)localObject;
        int j = ((MessageForConfessNews)localObject).istroop;
        int i = 1;
        if (j != 1) {
          i = 0;
        }
        if (i != 0) {
          TroopConfessUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, 2, ((MessageForConfessNews)localObject).strGroupUin, ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).strRecUin);
        } else {
          ConfessMsgUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).nConfessorSex, ((MessageForConfessNews)localObject).strRecUin);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */