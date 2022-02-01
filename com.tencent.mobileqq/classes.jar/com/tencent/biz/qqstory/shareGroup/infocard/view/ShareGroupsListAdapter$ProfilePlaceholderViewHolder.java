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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  List<QQUserUIItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  final ImageView jdField_b_of_type_AndroidWidgetImageView;
  final TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ShareGroupsListAdapter$ProfilePlaceholderViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378563));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378589));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373071));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131378070));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370757));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368504));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      Object localObject1 = (UserManager)SuperManager.a(2);
      Object localObject2 = new ArrayList();
      int j = Math.min(paramList.size(), 6);
      int i = 0;
      while (i < j)
      {
        String str = (String)paramList.get(i);
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject1).b(str);
        if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl))) {
          this.jdField_a_of_type_JavaUtilList.add(localQQUserUIItem);
        } else {
          ((List)localObject2).add(new QQUserUIItem.UserID("", str));
        }
        i += 1;
      }
      if (!((List)localObject2).isEmpty()) {
        new GetUserInfoHandler(1, (List)localObject2).a();
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int k = this.jdField_a_of_type_JavaUtilList.size();
      j = 0;
      while (j < k)
      {
        if (j == 0) {
          i = -1;
        } else if (j == k - 1) {
          i = 1;
        } else {
          i = 0;
        }
        paramList = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_AndroidContentContext;
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        localObject2 = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(j);
        int m = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.memberCount > 6) {
          bool = true;
        } else {
          bool = false;
        }
        ShareGroupUtil.a(paramList, (LinearLayout)localObject1, 34, (QQUserUIItem)localObject2, i, m, bool);
        j += 1;
      }
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
      paramVideoCollectionItem = HardCodeUtil.a(2131713800);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847038);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      paramVideoCollectionItem = null;
    }
    if (!TextUtils.isEmpty(paramView.backgroundUrl)) {
      UIUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramView.backgroundUrl, 0, 0, null);
    }
    if (paramView.headerUnionIdList != null) {
      paramView.memberCount = Math.max(paramView.headerUnionIdList.size(), paramView.memberCount);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoCollectionItem);
    localStringBuilder.append(" · ");
    localStringBuilder.append(paramView.memberCount);
    localStringBuilder.append(HardCodeUtil.a(2131713802));
    paramVideoCollectionItem = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVideoCollectionItem);
    a(paramView.headerUnionIdList);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131370757)
    {
      if (i != 2131378070)
      {
        if (i == 2131378563) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.a(this.jdField_a_of_type_AndroidWidgetButton);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ProfilePlaceholderViewHolder
 * JD-Core Version:    0.7.0.1
 */