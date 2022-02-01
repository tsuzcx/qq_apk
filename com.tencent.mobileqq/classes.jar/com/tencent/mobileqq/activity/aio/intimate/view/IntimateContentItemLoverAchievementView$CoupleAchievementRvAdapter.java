package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.intimate.info.LoveAchievementInfo.LoveAchievementItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

class IntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<LoveAchievementInfo.LoveAchievementItem> b = new ArrayList();
  
  private IntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter(IntimateContentItemLoverAchievementView paramIntimateContentItemLoverAchievementView) {}
  
  public void a(List<LoveAchievementInfo.LoveAchievementItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.b.clear();
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (IntimateContentItemLoverAchievementView.CoupleAchievementViewHolder)paramViewHolder;
    Object localObject = (LoveAchievementInfo.LoveAchievementItem)this.b.get(paramInt);
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((LoveAchievementInfo.LoveAchievementItem)localObject).b))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramViewHolder.a.getHeight();
      localURLDrawableOptions.mRequestWidth = paramViewHolder.a.getWidth();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(((LoveAchievementInfo.LoveAchievementItem)localObject).b, localURLDrawableOptions);
      paramViewHolder.a.setImageDrawable((Drawable)localObject);
      paramViewHolder.a.setCornerRadiusAndMode(ViewUtils.dpToPx(7.0F), 1);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a;
    return new IntimateContentItemLoverAchievementView.CoupleAchievementViewHolder(paramViewGroup, LayoutInflater.from(paramViewGroup.a).inflate(2131625182, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter
 * JD-Core Version:    0.7.0.1
 */