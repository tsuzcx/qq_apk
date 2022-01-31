package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShareGroupsListAdapter$DayCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
  implements View.OnClickListener
{
  public Context a;
  public View a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ShareGroupInnerListView a;
  public final ShareGroupsListAdapter a;
  public VideoCollectionItem a;
  public View b;
  public ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public ShareGroupsListAdapter$DayCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramShareGroupsListAdapter.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366837));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371694));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371695));
    this.c = ((TextView)paramView.findViewById(2131371698));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371699));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView = ((ShareGroupInnerListView)paramView.findViewById(2131371701));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView, false);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setLoadMoreDataListener(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener);
    paramShareGroupsListAdapter = (MemoriesInnerListAdapter)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.a();
    paramShareGroupsListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId);
    paramShareGroupsListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371692);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371693);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371696));
    this.d = ((TextView)paramView.findViewById(2131371700));
    a();
  }
  
  protected void a()
  {
    QQStoryContext.a();
    if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843441);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843437);
    this.c.setTextColor(Color.parseColor("#44608a"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem = paramVideoCollectionItem;
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_empty_item"))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramView.height = Integer.valueOf(paramVideoCollectionItem.collectionId).intValue();
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_desc_item"))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
    paramView = DateUtils.a(paramVideoCollectionItem.collectionTime);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView[1]);
    Object localObject;
    if (!TextUtils.isEmpty(paramView[0]))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramView[0]);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 32.0F);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -8.0F), 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setData(paramVideoCollectionItem);
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 80.0F);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((paramVideoCollectionItem.collectionCount > 0) || (paramInt != 2)) {
        break label649;
      }
      this.c.setText("点击拍摄，和圈子成员分享你的一天");
      label379:
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
      if ((((ShareGroupItem)localObject).type != 2) || (!((ShareGroupItem)localObject).isPublic()) || (paramVideoCollectionItem.collectionCount <= 0)) {
        break label683;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label436:
      if (!TextUtils.isEmpty(paramVideoCollectionItem.address)) {
        break label695;
      }
      this.d.setVisibility(4);
      label454:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoCollectionItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (paramInt != 2) {
        break label734;
      }
      paramVideoCollectionItem.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramVideoCollectionItem);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if ((paramInt == 3) && (TextUtils.equals(paramView[1], "昨天"))) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      label649:
      this.c.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438691, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      break label379;
      label683:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label436;
      label695:
      paramVideoCollectionItem.address = paramVideoCollectionItem.address.replace(65292, '‧');
      this.d.setText(paramVideoCollectionItem.address);
      this.d.setVisibility(0);
      break label454;
      label734:
      if (TextUtils.equals(paramView[1], "昨天")) {
        paramVideoCollectionItem.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 172.0F);
      } else {
        paramVideoCollectionItem.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 176.0F);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.size() == 0)
    {
      SLog.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "no data to share");
      return;
    }
    DateUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionCount;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramView = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
    } while ((paramView == null) || (MemoriesInnerListAdapter.PublishVideoItem.a(paramView)) || (0 != 0));
    for (;;)
    {
      if (paramView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$UIEventListener.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime, paramView.a, i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.feedId, null);
        return;
      }
      SLog.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "cannot found first data to share to qq");
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.DayCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */