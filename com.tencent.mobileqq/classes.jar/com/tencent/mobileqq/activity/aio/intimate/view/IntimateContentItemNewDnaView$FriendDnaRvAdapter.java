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
  private List<NewDnaInfo> b = new ArrayList();
  
  private IntimateContentItemNewDnaView$FriendDnaRvAdapter(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView) {}
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      localObject1 = new SpannableString(paramString);
      Object localObject2 = paramString.getBytes();
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(localObject2, paramInt1, arrayOfByte, 0, paramInt2);
      localObject2 = new String(arrayOfByte);
      paramInt2 = paramString.indexOf((String)localObject2);
      paramInt1 = ((String)localObject2).length();
      if ((TextUtils.equals(paramString, (CharSequence)localObject2)) && (paramString.length() == ((String)localObject2).length()))
      {
        localObject1 = new SpannableString(paramString);
        ((SpannableString)localObject1).setSpan(new StyleSpan(0), 0, paramString.length(), 33);
        ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(17.0F)), 0, paramString.length(), 33);
        return localObject1;
      }
      paramInt1 += paramInt2;
      int i = paramString.length();
      paramString = new StyleSpan(0);
      paramInt2 += 0;
      ((SpannableString)localObject1).setSpan(paramString, 0, paramInt2, 33);
      ((SpannableString)localObject1).setSpan(new TopAlignSuperscriptSpan(0.3F), 0, paramInt2, 33);
      ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0F)), 0, paramInt2, 33);
      paramString = new StyleSpan(0);
      paramInt2 = i - paramInt1 + paramInt1;
      ((SpannableString)localObject1).setSpan(paramString, paramInt1, paramInt2, 33);
      ((SpannableString)localObject1).setSpan(new TopAlignSuperscriptSpan(0.3F), paramInt1, paramInt2, 33);
      ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0F)), paramInt1, paramInt2, 33);
      return localObject1;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSpecialContent fail:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("IntimateContentItemNewDnaView", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt, IntimateContentItemNewDnaView.FriendDnaViewHolder paramFriendDnaViewHolder)
  {
    if ((this.b.size() != 1) && (this.b.size() != 2))
    {
      if (this.b.size() % 2 == 0)
      {
        if ((paramInt != 0) && (paramInt != 1))
        {
          if (((paramInt == this.b.size() - 1) || (paramInt == this.b.size() - 2)) && (this.b.size() >= 5))
          {
            a(paramFriendDnaViewHolder, -7.0F, -4.3F, -7.0F, -22.0F);
            return;
          }
          if ((paramInt != this.b.size() - 1) && (paramInt != this.b.size() - 2))
          {
            a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
            return;
          }
          a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -15.0F);
          return;
        }
        a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -22.0F);
        return;
      }
      if ((paramInt != 0) && (paramInt != 1))
      {
        if ((paramInt == this.b.size() - 1) && (this.b.size() >= 5))
        {
          a(paramFriendDnaViewHolder, -7.0F, -4.3F, -7.0F, -22.0F);
          return;
        }
        if (paramInt == this.b.size() - 1)
        {
          a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -15.0F);
          return;
        }
        if (paramInt == this.b.size() - 2)
        {
          a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
          return;
        }
        a(paramFriendDnaViewHolder, -7.0F, -3.0F, -7.0F, -22.0F);
        return;
      }
      a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -22.0F);
      return;
    }
    a(paramFriendDnaViewHolder, -7.0F, 0.0F, -7.0F, -15.0F);
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
        TextView localTextView = new TextView(this.a.a);
        localTextView.setTextSize(1, 22.0F);
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setTextColor(ContextCompat.getColor(this.a.a, 2131167747));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, ViewUtils.dpToPx(2.0F), 0, 0);
        localTextView.setLayoutParams(localLayoutParams);
        localObject = a(((NewDnaInfo.DnaDetail)localObject).a, ((NewDnaInfo.DnaDetail)localObject).b, ((NewDnaInfo.DnaDetail)localObject).c);
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
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramFriendDnaViewHolder.a.getLayoutParams();
    localLayoutParams.setMargins(ViewUtils.dpToPx(paramFloat1), ViewUtils.dpToPx(paramFloat2), ViewUtils.dpToPx(paramFloat3), ViewUtils.dpToPx(paramFloat4));
    paramFriendDnaViewHolder.itemView.setLayoutParams(localLayoutParams);
  }
  
  public void a(List<NewDnaInfo> paramList)
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
    paramViewHolder = (IntimateContentItemNewDnaView.FriendDnaViewHolder)paramViewHolder;
    Object localObject = (NewDnaInfo)this.b.get(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X800B568", "0X800B568", ((NewDnaInfo)localObject).a, 0, "", "", "", "");
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((NewDnaInfo)localObject).b)) {
      paramViewHolder.b.setText(((NewDnaInfo)localObject).b);
    }
    if ((((NewDnaInfo)localObject).d != null) && (((NewDnaInfo)localObject).d.size() > 0)) {
      a(paramViewHolder.c, ((NewDnaInfo)localObject).d);
    } else {
      paramViewHolder.c.removeAllViews();
    }
    paramViewHolder.d.setCornerRadiusAndMode(ViewUtils.dpToPx(15.0F), 1);
    if (IntimateContentItemNewDnaView.a(this.a))
    {
      paramViewHolder.d.setVisibility(8);
    }
    else if (!TextUtils.isEmpty(((NewDnaInfo)localObject).e))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramViewHolder.d.getWidth();
      localURLDrawableOptions.mRequestHeight = paramViewHolder.d.getHeight();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
      localObject = URLDrawable.getDrawable(((NewDnaInfo)localObject).e, localURLDrawableOptions);
      paramViewHolder.d.setImageDrawable((Drawable)localObject);
      paramViewHolder.d.setVisibility(0);
    }
    else
    {
      paramViewHolder.d.setVisibility(8);
    }
    a(paramInt, paramViewHolder);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a;
    return new IntimateContentItemNewDnaView.FriendDnaViewHolder(paramViewGroup, LayoutInflater.from(paramViewGroup.a).inflate(2131625183, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.FriendDnaRvAdapter
 * JD-Core Version:    0.7.0.1
 */