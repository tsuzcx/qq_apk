package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupsListAdapter$ProfilePlaceholderViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
  implements View.OnClickListener
{
  final Button jdField_a_of_type_AndroidWidgetButton;
  final ImageView jdField_a_of_type_AndroidWidgetImageView;
  final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final ShareGroupsListAdapter jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  final ImageView jdField_b_of_type_AndroidWidgetImageView;
  final TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ShareGroupsListAdapter$ProfilePlaceholderViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371717));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371720));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371823));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371529));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371824));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371714));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject2 = new ArrayList();
    int j = Math.min(paramList.size(), 6);
    int i = 0;
    if (i < j)
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(str);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl))) {
        this.jdField_a_of_type_JavaUtilList.add(localQQUserUIItem);
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject2).add(new QQUserUIItem.UserID("", str));
      }
    }
    if (!((List)localObject2).isEmpty()) {
      new GetUserInfoHandler(1, (List)localObject2).a();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    j = 0;
    label181:
    label193:
    int m;
    if (j < k)
    {
      if (j != 0) {
        break label274;
      }
      i = -1;
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_AndroidContentContext;
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      localObject2 = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(j);
      m = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount <= 6) {
        break label292;
      }
    }
    label274:
    label292:
    for (boolean bool = true;; bool = false)
    {
      ShareGroupUtil.a(paramList, (LinearLayout)localObject1, 34, (QQUserUIItem)localObject2, i, m, bool);
      j += 1;
      break label181;
      break;
      if (j == k - 1)
      {
        i = 1;
        break label193;
      }
      i = 0;
      break label193;
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.name);
    if (paramView.type == 1)
    {
      paramVideoCollectionItem = "仅群成员可查看和添加小视频";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843600);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView.backgroundUrl)) {
        UIUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramView.backgroundUrl, 0, 0, null);
      }
      if (paramView.headerUnionIdList != null) {
        paramView.memberCount = Math.max(paramView.headerUnionIdList.size(), paramView.memberCount);
      }
      paramVideoCollectionItem = paramVideoCollectionItem + " · " + paramView.memberCount + "成员";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVideoCollectionItem);
      a(paramView.headerUnionIdList);
      return;
      paramVideoCollectionItem = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371529: 
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.a(this.jdField_a_of_type_AndroidWidgetButton);
      return;
    case 2131371824: 
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ProfilePlaceholderViewHolder
 * JD-Core Version:    0.7.0.1
 */