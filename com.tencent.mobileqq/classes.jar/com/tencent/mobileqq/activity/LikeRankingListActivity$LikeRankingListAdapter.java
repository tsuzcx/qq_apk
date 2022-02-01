package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class LikeRankingListActivity$LikeRankingListAdapter
  extends BaseAdapter
{
  RelativeSizeSpan jdField_a_of_type_AndroidTextStyleRelativeSizeSpan = new RelativeSizeSpan(0.62F);
  String jdField_a_of_type_JavaLangString;
  List<LikeRankingInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = { 2130845648, 2130845649, 2130845650 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130845645, 2130845646, 2130845647 };
  
  public LikeRankingListActivity$LikeRankingListAdapter(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131719997);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131693683);
  }
  
  public LikeRankingInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (LikeRankingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<LikeRankingInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    LikeRankingInfo localLikeRankingInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
        if (localLikeRankingInfo2.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo2;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo, Integer.valueOf(paramList.size()) }));
        }
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_Boolean = false;
        notifyDataSetChanged();
        return;
      }
      i -= 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 8;
    int j = 0;
    int i = getItemViewType(paramInt);
    if (paramView == null) {}
    switch (i)
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    LikeRankingInfo localLikeRankingInfo;
    do
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131561310, null);
      localObject1 = new LikeRankingListActivity.LikeRankingListAdapter.ViewHolder(this);
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380540));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369771));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369577));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369576));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380481));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380668));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131380441));
      ((LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365922);
      paramView.setTag(localObject1);
      break;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131559592, null);
      localObject1 = new LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder(this);
      ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371896));
      ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376854));
      ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370717));
      paramView.setTag(localObject1);
      break;
      localLikeRankingInfo = a(paramInt);
    } while (localLikeRankingInfo == null);
    LikeRankingListActivity.LikeRankingListAdapter.ViewHolder localViewHolder = (LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)paramView.getTag();
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    label384:
    String str;
    if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
    {
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      str = String.valueOf(localLikeRankingInfo.uin);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(str);
      if (localObject1 == null) {
        break label678;
      }
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).getFriendNick());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, 1, true);
        }
        localObject1 = ImageUtil.c();
      }
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      label499:
      switch (localLikeRankingInfo.rankingNum)
      {
      default: 
        if (localLikeRankingInfo.rankingNum < 1) {
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("-");
        }
        break;
      }
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      for (;;)
      {
        localObject1 = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        ((SpannableString)localObject1).setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localViewHolder.d.setText((CharSequence)localObject1);
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
        break;
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label384;
        label678:
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.c());
        break label499;
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
    }
    Object localObject1 = (LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)paramView.getTag();
    Object localObject2 = ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131693848;
      label807:
      ((TextView)localObject2).setText(i);
      localObject2 = ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label891;
      }
      i = 0;
      label831:
      ((ProgressBar)localObject2).setVisibility(i);
      localObject1 = ((LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label898;
      }
      i = k;
      label856:
      ((ImageView)localObject1).setVisibility(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label904;
      }
    }
    label898:
    label904:
    for (i = j;; i = 4)
    {
      paramView.setVisibility(i);
      break;
      i = 2131694255;
      break label807;
      label891:
      i = 8;
      break label831;
      i = 0;
      break label856;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.LikeRankingListAdapter
 * JD-Core Version:    0.7.0.1
 */