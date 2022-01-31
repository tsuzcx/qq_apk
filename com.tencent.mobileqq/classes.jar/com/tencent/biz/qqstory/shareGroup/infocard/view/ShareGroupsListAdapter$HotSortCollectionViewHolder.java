package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class ShareGroupsListAdapter$HotSortCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
{
  public TextView a;
  public ShareGroupsListAdapter.HotSortCardHolder a;
  public TextView b;
  public ShareGroupsListAdapter.HotSortCardHolder b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public ShareGroupsListAdapter$HotSortCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    View localView = paramView.findViewById(2131371997);
    paramView = paramView.findViewById(2131371998);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder = new ShareGroupsListAdapter.HotSortCardHolder(localView, paramShareGroupsListAdapter.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder = new ShareGroupsListAdapter.HotSortCardHolder(paramView, paramShareGroupsListAdapter.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371811));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371811));
    this.c = ((TextView)localView.findViewById(2131371812));
    this.d = ((TextView)paramView.findViewById(2131371812));
    this.e = ((TextView)localView.findViewById(2131371813));
    this.f = ((TextView)paramView.findViewById(2131371813));
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.c.setTextColor(Color.parseColor("#6991b8"));
      this.d.setTextColor(Color.parseColor("#6991b8"));
      this.e.setTextColor(Color.parseColor("#6991b8"));
      this.f.setTextColor(Color.parseColor("#6991b8"));
    }
    if (paramShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.a(paramShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener);
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.a(paramShareGroupsListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      SLog.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.a();
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter$HotSortCardHolder.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */