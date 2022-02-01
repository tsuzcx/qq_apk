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
  private List<LoveAchievementInfo.LoveAchievementItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private IntimateContentItemLoverAchievementView$CoupleAchievementRvAdapter(IntimateContentItemLoverAchievementView paramIntimateContentItemLoverAchievementView) {}
  
  public void a(List<LoveAchievementInfo.LoveAchievementItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (IntimateContentItemLoverAchievementView.CoupleAchievementViewHolder)paramViewHolder;
    Object localObject = (LoveAchievementInfo.LoveAchievementItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((LoveAchievementInfo.LoveAchievementItem)localObject).a))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramViewHolder.a.getHeight();
      localURLDrawableOptions.mRequestWidth = paramViewHolder.a.getWidth();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(((LoveAchievementInfo.LoveAchievementItem)localObject).a, localURLDrawableOptions);
      paramViewHolder.a.setImageDrawable((Drawable)localObject);
      paramViewHolder.a.setCornerRadiusAndMode(ViewUtils.b(7.0F), 1);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new IntimateContentItemLoverAchievementView.CoupleAchievementViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemLoverAchievementView.a).inflate(2131559386, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView.CoupleAchievementRvAdapter
 * JD-Core Version:    0.7.0.1
 */