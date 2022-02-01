package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class StackAdapter
  extends RecyclerView.Adapter
{
  public List<String> a = new ArrayList();
  
  public StackAdapter(List<String> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ImageView localImageView = ((StackAdapter.MyViewHolder)paramViewHolder).a;
    if (!TextUtils.isEmpty((String)this.a.get(paramInt))) {
      if (paramInt == 0)
      {
        String str = (String)this.a.get(paramInt);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
        localURLDrawableOptions.mPlayGifImage = BaseImageUtil.c(str);
        localURLDrawableOptions.mUseAutoScaleParams = true;
        localImageView.setImageDrawable(URLDrawable.getFileDrawable(str, localURLDrawableOptions));
      }
      else if (paramInt == 1)
      {
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setImageDrawable(null);
        localImageView.setBackgroundColor(Color.parseColor("#9A989EB4"));
      }
      else if (paramInt == 2)
      {
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setImageDrawable(null);
        localImageView.setBackgroundColor(Color.parseColor("#48989EB4"));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new StackAdapter.MyViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624748, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.StackAdapter
 * JD-Core Version:    0.7.0.1
 */