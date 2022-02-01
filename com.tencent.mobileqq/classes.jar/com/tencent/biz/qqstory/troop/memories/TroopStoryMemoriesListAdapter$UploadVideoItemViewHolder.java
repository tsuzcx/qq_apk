package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.io.File;

class TroopStoryMemoriesListAdapter$UploadVideoItemViewHolder
  extends TroopStoryMemoriesListAdapter.VideoItemViewHolder
{
  public TroopStoryMemoriesListAdapter$UploadVideoItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    super(paramTroopStoryMemoriesListAdapter, paramView);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.a, paramTroopStoryItemInfo, this.c, this.d);
    this.e.setText(DateUtils.e(paramTroopStoryItemInfo.publishTime));
    Drawable localDrawable = this.a.b.getResources().getDrawable(2130848669);
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
      paramTroopStoryItemInfo = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), localURLDrawableOptions);
      paramTroopStoryItemInfo.setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.a.b, 50.0F), UIUtils.a(this.a.b, 70.0F), UIUtils.a(this.a.b, 3.0F)));
      paramTroopStoryItemInfo.setDecodeHandler(URLDrawableDecodeHandler.j);
      this.f.setImageDrawable(paramTroopStoryItemInfo);
    }
    catch (Exception paramTroopStoryItemInfo)
    {
      label148:
      break label148;
    }
    this.f.setImageDrawable(localDrawable);
    paramTroopStoryItemInfo = this.a.b.getResources().getDrawable(2130839585);
    paramTroopStoryItemInfo.setBounds(0, 0, 26, 26);
    this.e.setCompoundDrawables(paramTroopStoryItemInfo, null, null, null);
    this.e.setCompoundDrawablePadding(10);
    this.e.setText(HardCodeUtil.a(2131913044));
    ((Animatable)paramTroopStoryItemInfo).start();
    this.b.setOnClickListener(new TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.UploadVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */