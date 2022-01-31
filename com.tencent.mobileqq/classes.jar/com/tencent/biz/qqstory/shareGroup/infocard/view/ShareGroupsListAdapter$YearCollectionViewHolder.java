package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import nsp;

public class ShareGroupsListAdapter$YearCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
{
  public Context a;
  public View a;
  public TextView a;
  public final ShareGroupsListAdapter a;
  public TextView b;
  public TextView c;
  
  public ShareGroupsListAdapter$YearCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369116));
    this.b = ((TextView)paramView.findViewById(2131369117));
    this.c = ((TextView)paramView.findViewById(2131371900));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371862);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      if (this.b != null) {
        this.b.setTextColor(Color.parseColor("#44608a"));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.c.setTextColor(Color.parseColor("#6991b8"));
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
      }
    }
    this.c.setOnClickListener(new nsp(this));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("热门排行");
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F), 0, 0, 0);
      this.b.setText("");
      if (paramInt != 1) {
        break label171;
      }
      this.c.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a);
    }
    for (;;)
    {
      paramVideoCollectionItem = this.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1) {
        i = 4;
      }
      paramVideoCollectionItem.setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.b(paramVideoCollectionItem.collectionTime));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      if (paramVideoCollectionItem.collectionCount <= 0)
      {
        this.b.setText("");
        break;
      }
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438711, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      break;
      label171:
      this.c.setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 17.0F);
    if (paramBoolean)
    {
      this.c.setText("按时间");
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843796);
      localDrawable.setBounds(0, 0, i, i);
      this.c.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    this.c.setText("按热度");
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843795);
    localDrawable.setBounds(0, 0, i, i);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.YearCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */