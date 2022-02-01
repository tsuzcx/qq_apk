package com.tencent.biz.qqstory.troop.memories;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

class TroopStoryMemoriesListAdapter$DayItemViewHolder
{
  public View a;
  public TextView a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  
  public TroopStoryMemoriesListAdapter$DayItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379621));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365584));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371832));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381305));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370394);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370396);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370397);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370395);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    Object localObject = DateUtils.a(paramTroopStoryItemInfo.publishTime);
    if (TextUtils.isEmpty(localObject[0]))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject[1]);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if ((paramInt > 0) && (((TroopStoryItemInfo)this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.get(paramInt - 1)).itemType == 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      while (paramTroopStoryItemInfo.publishCount == 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715646));
        return;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[1]);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localObject[0]);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((paramInt > 0) && (((TroopStoryItemInfo)this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.get(paramInt - 1)).itemType == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTroopStoryItemInfo.publishCount).append("个小视频");
    if (paramTroopStoryItemInfo.dayCommentCount > 0)
    {
      ((StringBuilder)localObject).append(" 评论").append(paramTroopStoryItemInfo.dayCommentCount);
      if (paramTroopStoryItemInfo.dayLikeCount > 0) {
        ((StringBuilder)localObject).append("·");
      }
    }
    if (paramTroopStoryItemInfo.dayLikeCount > 0)
    {
      if (paramTroopStoryItemInfo.dayCommentCount <= 0) {
        ((StringBuilder)localObject).append(" ");
      }
      ((StringBuilder)localObject).append("赞").append(paramTroopStoryItemInfo.dayLikeCount);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.DayItemViewHolder
 * JD-Core Version:    0.7.0.1
 */