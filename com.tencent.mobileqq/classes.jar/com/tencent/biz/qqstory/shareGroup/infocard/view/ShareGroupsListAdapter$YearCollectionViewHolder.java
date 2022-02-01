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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class ShareGroupsListAdapter$YearCollectionViewHolder
  extends BaseStoryTimeLineAdapter.BaseViewHolder
{
  public Context a;
  public View a;
  public TextView a;
  protected final ShareGroupsListAdapter a;
  public TextView b;
  public TextView c;
  
  public ShareGroupsListAdapter$YearCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = paramShareGroupsListAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381306));
    this.b = ((TextView)paramView.findViewById(2131380562));
    this.c = ((TextView)paramView.findViewById(2131380752));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370049);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      paramView = this.b;
      if (paramView != null) {
        paramView.setTextColor(Color.parseColor("#44608a"));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.c.setTextColor(Color.parseColor("#6991b8"));
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (paramView != null) {
        paramView.setBackgroundColor(Color.parseColor("#0c284e"));
      }
    }
    this.c.setOnClickListener(new ShareGroupsListAdapter.YearCollectionViewHolder.1(this));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a;
    int i = 0;
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713815));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F), 0, 0, 0);
      this.b.setText("");
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.c(paramVideoCollectionItem.collectionTime));
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
      if (paramVideoCollectionItem.collectionCount <= 0) {
        this.b.setText("");
      } else {
        this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699376, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      }
    }
    if (paramInt == 1)
    {
      this.c.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a);
    }
    else
    {
      this.c.setVisibility(8);
    }
    paramVideoCollectionItem = this.jdField_a_of_type_AndroidViewView;
    if (paramInt == 1) {
      i = 4;
    }
    paramVideoCollectionItem.setVisibility(i);
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 17.0F);
    if (paramBoolean)
    {
      this.c.setText(HardCodeUtil.a(2131713794));
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847116);
      localDrawable.setBounds(0, 0, i, i);
      this.c.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    this.c.setText(HardCodeUtil.a(2131713805));
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847115);
    localDrawable.setBounds(0, 0, i, i);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.YearCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */