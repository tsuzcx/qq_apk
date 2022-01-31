package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import nso;

public class ShareGroupsListAdapter$HotSortCardHolder
  extends RecyclerView.ViewHolder
{
  public Context a;
  public ImageView a;
  public TextView a;
  public MyMemoriesListView.OnUIClickListener a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public TextView e;
  
  public ShareGroupsListAdapter$HotSortCardHolder(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371807));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371808));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371809));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371811));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371812));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371813));
    this.e = ((TextView)paramView.findViewById(2131371814));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371815));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371682));
  }
  
  public void a()
  {
    this.itemView.setVisibility(8);
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    if (paramHotSortVideoEntry == null)
    {
      this.itemView.setVisibility(8);
      return;
    }
    this.itemView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    int i = (DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 25.0F)) / 2;
    int j = (int)(i * 1.61D);
    this.itemView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
    Object localObject;
    if (paramHotSortVideoEntry.coverURL == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843554));
      localObject = paramHotSortVideoEntry.storyId;
      this.itemView.setOnClickListener(new nso(this, (String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = ((UserManager)SuperManager.a(2)).c(paramHotSortVideoEntry.unionId);
      if (localObject != null) {
        break label333;
      }
      if (!"NullImage".equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag("NullImage");
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(StoryApi.a(2131432087));
      label217:
      if ((paramHotSortVideoEntry.likeCount != 0) || (paramHotSortVideoEntry.viewCount != 0)) {
        break label516;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      StoryReportor.a("share_story", "exp_video_card", 0, 0, new String[] { paramHotSortVideoEntry.groupId, paramHotSortVideoEntry.storyId });
      return;
      localObject = ThumbnailUrlHelper.c(paramHotSortVideoEntry.coverURL);
      if (((String)localObject).equals(this.jdField_a_of_type_AndroidWidgetImageView.getTag())) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
      UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, i, j, i / 30, UIUtils.b, "QQStoryMemory");
      break;
      label333:
      if (!((QQUserUIItem)localObject).headUrl.equals(this.jdField_b_of_type_AndroidWidgetImageView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(((QQUserUIItem)localObject).headUrl);
        ShareGroupsListAdapter.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, ((QQUserUIItem)localObject).headUrl);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject).getDisplayName());
      if (((QQUserUIItem)localObject).isVipButNoFriend())
      {
        if (StoryDepends.QimUtil.a())
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(i - j);
          break label217;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        PlayModeUtils.a(this.jdField_d_of_type_AndroidWidgetImageView, (QQUserUIItem)localObject);
        localObject = PlayModeUtils.b((QQUserUIItem)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label217;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setTag(localObject);
        break label217;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break label217;
      label516:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843787);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(UIUtils.a(paramHotSortVideoEntry.viewCount));
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843443);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.e.setText(UIUtils.a(paramHotSortVideoEntry.likeCount));
      this.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.e.setVisibility(0);
    }
  }
  
  public void a(MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener = paramOnUIClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.HotSortCardHolder
 * JD-Core Version:    0.7.0.1
 */