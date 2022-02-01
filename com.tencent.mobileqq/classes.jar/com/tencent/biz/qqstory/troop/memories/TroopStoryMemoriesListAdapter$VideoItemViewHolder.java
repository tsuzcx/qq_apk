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
  public View b;
  public URLImageView c;
  public TextView d;
  public TextView e;
  public URLImageView f;
  
  public TroopStoryMemoriesListAdapter$VideoItemViewHolder(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.b = paramView;
    this.c = ((URLImageView)paramView.findViewById(2131428988));
    this.d = ((TextView)paramView.findViewById(2131439121));
    this.e = ((TextView)paramView.findViewById(2131447345));
    this.f = ((URLImageView)paramView.findViewById(2131449726));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.g, paramTroopStoryItemInfo, this.c, this.d);
    this.e.setText(DateUtils.e(paramTroopStoryItemInfo.publishTime));
    Drawable localDrawable = this.g.b.getResources().getDrawable(2130848669);
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
      paramTroopStoryItemInfo = URLDrawable.getDrawable(paramTroopStoryItemInfo.videoThumbUrl, localURLDrawableOptions);
      paramTroopStoryItemInfo.setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.g.b, 50.0F), UIUtils.a(this.g.b, 70.0F), UIUtils.a(this.g.b, 3.0F)));
      paramTroopStoryItemInfo.setDecodeHandler(URLDrawableDecodeHandler.j);
      this.f.setImageDrawable(paramTroopStoryItemInfo);
    }
    catch (Exception paramTroopStoryItemInfo)
    {
      label141:
      break label141;
    }
    this.f.setImageDrawable(localDrawable);
    this.b.setOnClickListener(new TroopStoryMemoriesListAdapter.VideoItemViewHolder.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.VideoItemViewHolder
 * JD-Core Version:    0.7.0.1
 */