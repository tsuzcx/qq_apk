package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateContentItemMutualMarkView$FriendMaskAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private List<IntimateInfo.MutualMarkInfo> jdField_a_of_type_JavaUtilList;
  
  private IntimateContentItemMutualMarkView$FriendMaskAdapter(IntimateContentItemMutualMarkView paramIntimateContentItemMutualMarkView) {}
  
  public IntimateInfo.MutualMarkInfo a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return (IntimateInfo.MutualMarkInfo)localList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.MutualMarkInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((ViewUtils.a() - ViewUtils.a(40.0F) - 80) / ViewUtils.a(60.0F));
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("friend mark max count: ");
        paramList.append(this.jdField_a_of_type_Int);
        QLog.d("intimate_relationship", 2, paramList.toString());
      }
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = 5;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    int i = localList.size();
    int j = this.jdField_a_of_type_Int;
    if (i > j) {
      return j;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @RequiresApi(api=16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_AndroidContentContext).inflate(2131559270, null);
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131367338);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    IntimateInfo.MutualMarkInfo localMutualMarkInfo = a(paramInt);
    if ((localMutualMarkInfo instanceof IntimateInfo.PrefetchMutualMarkInfo))
    {
      localObject = (IntimateInfo.PrefetchMutualMarkInfo)localMutualMarkInfo;
      IntimateContentItemMutualMarkView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView, (IntimateInfo.PrefetchMutualMarkInfo)localObject);
    }
    else
    {
      int i = 0;
      if ((localMutualMarkInfo != null) && (!TextUtils.isEmpty(localMutualMarkInfo.iconStaticUrl)))
      {
        localObject = new ColorDrawable(0);
        String str = MutualMarkAlienationHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), localMutualMarkInfo.type, localMutualMarkInfo.level, localMutualMarkInfo.subLevel, localMutualMarkInfo.iconStaticUrl);
        IntimateContentItemMutualMarkView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView, localImageView, str, (Drawable)localObject, localMutualMarkInfo.type);
      }
      else
      {
        if (localMutualMarkInfo != null) {
          i = MutualMarkConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), localMutualMarkInfo.type, localMutualMarkInfo.level);
        }
        if (i != 0) {
          localObject = new MutualMarkIconProxyDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_AndroidContentContext, i);
        }
        localImageView.setImageDrawable((Drawable)localObject);
      }
      localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getResources().getDrawable(2130840518));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView.FriendMaskAdapter
 * JD-Core Version:    0.7.0.1
 */