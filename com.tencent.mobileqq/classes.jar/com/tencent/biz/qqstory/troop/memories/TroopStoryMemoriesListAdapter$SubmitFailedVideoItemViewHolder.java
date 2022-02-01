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
    TroopStoryMemoriesListAdapter.a(this.a, paramTroopStoryItemInfo, this.c, this.d);
    Drawable localDrawable = this.a.b.getResources().getDrawable(2130848669);
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "troop_story_message";
      localObject = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.a.b, 50.0F), UIUtils.a(this.a.b, 70.0F), UIUtils.a(this.a.b, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.j);
      this.f.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      label138:
      break label138;
    }
    this.f.setImageDrawable(localDrawable);
    localDrawable = this.a.b.getResources().getDrawable(2130848666);
    localDrawable.setBounds(0, 0, 26, 26);
    this.e.setCompoundDrawablePadding(10);
    this.e.setCompoundDrawables(localDrawable, null, null, null);
    this.e.setText(HardCodeUtil.a(2131913043));
    this.e.setTextColor(-65536);
    this.b.setOnClickListener(new TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder.1(this, paramTroopStoryItemInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.SubmitFailedVideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */