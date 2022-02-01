package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

class TroopStoryMemoriesListAdapter$VideoItemViewHolder
  extends SwipRightMenuBuilder.SwipItemBaseHolder
{
  public View a;
  public TextView a;
  public URLImageView a;
  public TextView b;
  public URLImageView b;
  
  public TroopStoryMemoriesListAdapter$VideoItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363135));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378688));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131380758));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(DateUtils.d(paramTroopStoryItemInfo.publishTime));
    Drawable localDrawable = this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130847117);
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
      paramTroopStoryItemInfo = URLDrawable.getDrawable(paramTroopStoryItemInfo.videoThumbUrl, localURLDrawableOptions);
      paramTroopStoryItemInfo.setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), UIUtils.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), UIUtils.a(this.jdField_b_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      paramTroopStoryItemInfo.setDecodeHandler(URLDrawableDecodeHandler.i);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramTroopStoryItemInfo);
    }
    catch (Exception paramTroopStoryItemInfo)
    {
      label141:
      break label141;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new TroopStoryMemoriesListAdapter.VideoItemViewHolder.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.VideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */