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
  public TextView b;
  public TextView c;
  public TextView d;
  public View e;
  public Context f;
  protected final ShareGroupsListAdapter g;
  
  public ShareGroupsListAdapter$YearCollectionViewHolder(View paramView, ShareGroupsListAdapter paramShareGroupsListAdapter)
  {
    this.g = paramShareGroupsListAdapter;
    this.f = paramView.getContext();
    this.a = 0;
    this.b = ((TextView)paramView.findViewById(2131450358));
    this.c = ((TextView)paramView.findViewById(2131449519));
    this.d = ((TextView)paramView.findViewById(2131449720));
    this.e = paramView.findViewById(2131437206);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null))
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.setTextColor(Color.parseColor("#44608a"));
      }
      this.b.setTextColor(Color.parseColor("#6991b8"));
      this.d.setTextColor(Color.parseColor("#6991b8"));
      paramView = this.e;
      if (paramView != null) {
        paramView.setBackgroundColor(Color.parseColor("#0c284e"));
      }
    }
    this.d.setOnClickListener(new ShareGroupsListAdapter.YearCollectionViewHolder.1(this));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    boolean bool = this.g.j;
    int i = 0;
    if (bool)
    {
      this.b.setText(HardCodeUtil.a(2131911355));
      this.b.setPadding(UIUtils.a(this.f, 3.0F), 0, 0, 0);
      this.c.setText("");
    }
    else
    {
      this.b.setText(DateUtils.d(paramVideoCollectionItem.collectionTime));
      this.b.setPadding(0, 0, 0, 0);
      if (paramVideoCollectionItem.collectionCount <= 0) {
        this.c.setText("");
      } else {
        this.c.setText(this.f.getString(2131897393, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      }
    }
    if (paramInt == 1)
    {
      this.d.setVisibility(0);
      a(this.g.j);
    }
    else
    {
      this.d.setVisibility(8);
    }
    paramVideoCollectionItem = this.e;
    if (paramInt == 1) {
      i = 4;
    }
    paramVideoCollectionItem.setVisibility(i);
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = UIUtils.a(this.f, 17.0F);
    if (paramBoolean)
    {
      this.d.setText(HardCodeUtil.a(2131911334));
      localDrawable = this.f.getResources().getDrawable(2130848668);
      localDrawable.setBounds(0, 0, i, i);
      this.d.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    this.d.setText(HardCodeUtil.a(2131911345));
    Drawable localDrawable = this.f.getResources().getDrawable(2130848667);
    localDrawable.setBounds(0, 0, i, i);
    this.d.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.YearCollectionViewHolder
 * JD-Core Version:    0.7.0.1
 */