package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo.DnaDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

class IntimateContentItemNewDnaView$FriendDnaRvAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<NewDnaInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private IntimateContentItemNewDnaView$FriendDnaRvAdapter(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView) {}
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      SpannableString localSpannableString = new SpannableString(paramString);
      Object localObject = paramString.getBytes();
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(localObject, paramInt1, arrayOfByte, 0, paramInt2);
      localObject = new String(arrayOfByte);
      paramInt1 = paramString.indexOf((String)localObject);
      paramInt2 = ((String)localObject).length();
      if ((TextUtils.equals(paramString, (CharSequence)localObject)) && (paramString.length() == ((String)localObject).length()))
      {
        localSpannableString = new SpannableString(paramString);
        localSpannableString.setSpan(new StyleSpan(0), 0, paramString.length(), 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.a(17.0F)), 0, paramString.length(), 33);
        return localSpannableString;
      }
      paramInt2 += paramInt1;
      int i = paramString.length() - paramInt2;
      localSpannableString.setSpan(new StyleSpan(0), 0, 0 + paramInt1, 33);
      localSpannableString.setSpan(new TopAlignSuperscriptSpan(0.3F), 0, 0 + paramInt1, 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.a(10.0F)), 0, paramInt1 + 0, 33);
      localSpannableString.setSpan(new StyleSpan(0), paramInt2, paramInt2 + i, 33);
      localSpannableString.setSpan(new TopAlignSuperscriptSpan(0.3F), paramInt2, paramInt2 + i, 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.a(10.0F)), paramInt2, paramInt2 + i, 33);
      return localSpannableString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntimateContentItemNewDnaView", 2, "getSpecialContent fail:" + paramString.toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt, IntimateContentItemNewDnaView.FriendDnaViewHolder paramFriendDnaViewHolder)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) || (this.jdField_a_of_type_JavaUtilList.size() == 2))
    {
      a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -15.0F);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() % 2 == 0)
    {
      if ((paramInt == 0) || (paramInt == 1))
      {
        a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -22.0F);
        return;
      }
      if (((paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1) || (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 2)) && (this.jdField_a_of_type_JavaUtilList.size() >= 5))
      {
        a(paramFriendDnaViewHolder, -7.0F, -4.3F, -7.0F, -22.0F);
        return;
      }
      if ((paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1) || (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 2))
      {
        a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -15.0F);
        return;
      }
      a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -22.0F);
      return;
    }
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1) && (this.jdField_a_of_type_JavaUtilList.size() >= 5))
    {
      a(paramFriendDnaViewHolder, -7.0F, -4.3F, -7.0F, -22.0F);
      return;
    }
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -15.0F);
      return;
    }
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
      return;
    }
    a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
  }
  
  private void a(LinearLayout paramLinearLayout, ArrayList<NewDnaInfo.DnaDetail> paramArrayList)
  {
    if ((paramLinearLayout != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramLinearLayout.removeAllViews();
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 2))
      {
        Object localObject = (NewDnaInfo.DnaDetail)paramArrayList.get(i);
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a);
        localTextView.setTextSize(1, 22.0F);
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setTextColor(ContextCompat.getColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a, 2131166811));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, ViewUtils.b(2.0F), 0, 0);
        localTextView.setLayoutParams(localLayoutParams);
        localObject = a(((NewDnaInfo.DnaDetail)localObject).jdField_a_of_type_JavaLangString, ((NewDnaInfo.DnaDetail)localObject).jdField_a_of_type_Int, ((NewDnaInfo.DnaDetail)localObject).b);
        if (localObject != null) {
          localTextView.setText((CharSequence)localObject);
        }
        paramLinearLayout.addView(localTextView);
        i += 1;
      }
    }
  }
  
  private void a(IntimateContentItemNewDnaView.FriendDnaViewHolder paramFriendDnaViewHolder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramFriendDnaViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(ViewUtils.b(paramFloat1), ViewUtils.b(paramFloat2), ViewUtils.b(paramFloat3), ViewUtils.b(paramFloat4));
    paramFriendDnaViewHolder.itemView.setLayoutParams(localLayoutParams);
  }
  
  public void a(List<NewDnaInfo> paramList)
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
    paramViewHolder = (IntimateContentItemNewDnaView.FriendDnaViewHolder)paramViewHolder;
    Object localObject = (NewDnaInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X800B568", "0X800B568", ((NewDnaInfo)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((NewDnaInfo)localObject).jdField_a_of_type_JavaLangString)) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((NewDnaInfo)localObject).jdField_a_of_type_JavaLangString);
    }
    if ((((NewDnaInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((NewDnaInfo)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      a(paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, ((NewDnaInfo)localObject).jdField_a_of_type_JavaUtilArrayList);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(ViewUtils.b(15.0F), 1);
      if (!IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView)) {
        break label163;
      }
      paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(8);
    }
    for (;;)
    {
      a(paramInt, paramViewHolder);
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      break;
      label163:
      if (!TextUtils.isEmpty(((NewDnaInfo)localObject).c))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getWidth();
        localURLDrawableOptions.mRequestHeight = paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getHeight();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        localObject = URLDrawable.getDrawable(((NewDnaInfo)localObject).c, localURLDrawableOptions);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable((Drawable)localObject);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(0);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(8);
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new IntimateContentItemNewDnaView.FriendDnaViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a).inflate(2131559387, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.FriendDnaRvAdapter
 * JD-Core Version:    0.7.0.1
 */