package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;

public class AccountDetailWindowViewWrapper$PhotoAdapter
  extends BaseAdapter
{
  public AccountDetailWindowViewWrapper$PhotoAdapter(AccountDetailWindowViewWrapper paramAccountDetailWindowViewWrapper) {}
  
  public IPublicAccountConfigAttr.PaConfigInfo a(int paramInt)
  {
    return (IPublicAccountConfigAttr.PaConfigInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.a.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.b(200.0F, paramViewGroup);
    int j = AIOUtils.b(140.0F, paramViewGroup);
    int k = AIOUtils.b(12.0F, paramViewGroup);
    if (paramView == null)
    {
      paramViewGroup = new AccountDetailWindowViewWrapper.PhotoAdapter.ViewHolder(this);
      paramView = new BubbleViewLayout(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.setRadius(6.0F);
      paramView.a(false);
      paramView.setLayoutParams(new AbsListView.LayoutParams(j, i));
      Object localObject2 = new URLImageView(this.a.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((URLImageView)localObject2).setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
      ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject1 = (ViewGroup)paramView;
      ((ViewGroup)localObject1).addView((View)localObject2);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject2);
      localObject2 = new TextView(this.a.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.setMargins(k, 0, k, k);
      ((TextView)localObject2).setLayoutParams(localLayoutParams);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((ViewGroup)localObject1).addView((View)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (AccountDetailWindowViewWrapper.PhotoAdapter.ViewHolder)paramView.getTag();
    }
    Object localObject1 = a(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(((IPublicAccountConfigAttr.PaConfigInfo)localObject1).e, null, null, true));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IPublicAccountConfigAttr.PaConfigInfo)localObject1).a);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailWindowViewWrapper.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */