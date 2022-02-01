package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.io.File;

class TroopStoryMemoriesListAdapter$SubmitFailedVideoItemViewHolder
  extends TroopStoryMemoriesListAdapter.VideoItemViewHolder
{
  public TroopStoryMemoriesListAdapter$SubmitFailedVideoItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    super(paramTroopStoryMemoriesListAdapter, paramView);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130847117);
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "troop_story_message";
      localObject = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.i);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      label138:
      break label138;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130847114);
    localDrawable.setBounds(0, 0, 26, 26);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715571));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder.1(this, paramTroopStoryItemInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */