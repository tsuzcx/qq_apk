package com.tencent.mobileqq.activity;

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
  int[] jdField_a_of_type_ArrayOfInt = { 2130845521, 2130845522, 2130845523 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130845518, 2130845519, 2130845520 };
  
  public LikeRankingListActivity$LikeRankingListAdapter(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131719729);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131693636);
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
    while (i >= 0)
    {
      LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
      if (localLikeRankingInfo2.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo2;
        break;
      }
      i -= 1;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo, Integer.valueOf(paramList.size()) }));
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
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
    int i = getItemViewType(paramInt);
    View localView = paramView;
    if (paramView == null) {
      if (i != 0)
      {
        if (i != 1)
        {
          localView = paramView;
        }
        else
        {
          localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131559469, null);
          paramView = new LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder(this);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371517));
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376345));
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370354));
          localView.setTag(paramView);
        }
      }
      else
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2131561153, null);
        paramView = new LikeRankingListActivity.LikeRankingListAdapter.ViewHolder(this);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379834));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369461));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369287));
        paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369286));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379784));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379942));
        paramView.d = ((TextView)localView.findViewById(2131379753));
        paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365759);
        localView.setTag(paramView);
      }
    }
    int k = 8;
    int j = 0;
    Object localObject;
    if (i != 0)
    {
      if (i == 1)
      {
        paramView = (LikeRankingListActivity.LikeRankingListAdapter.MoreViewHolder)localView.getTag();
        localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
        if (this.jdField_a_of_type_Boolean) {
          i = 2131693802;
        } else {
          i = 2131694220;
        }
        ((TextView)localObject).setText(i);
        localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
        if (this.jdField_a_of_type_Boolean) {
          i = 0;
        } else {
          i = 8;
        }
        ((ProgressBar)localObject).setVisibility(i);
        paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
        if (this.jdField_a_of_type_Boolean) {
          i = k;
        } else {
          i = 0;
        }
        paramView.setVisibility(i);
        if (this.jdField_a_of_type_Boolean) {
          i = j;
        } else {
          i = 4;
        }
        localView.setVisibility(i);
      }
    }
    else
    {
      LikeRankingInfo localLikeRankingInfo = a(paramInt);
      if (localLikeRankingInfo != null)
      {
        LikeRankingListActivity.LikeRankingListAdapter.ViewHolder localViewHolder = (LikeRankingListActivity.LikeRankingListAdapter.ViewHolder)localView.getTag();
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
        if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1))) {
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        } else {
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        String str = String.valueOf(localLikeRankingInfo.uin);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(str);
        if (paramView != null)
        {
          localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.getFriendNick());
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, str);
          paramView = (View)localObject;
          if (localObject == null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, 1, true);
            }
            paramView = ImageUtil.f();
          }
          localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
        }
        else
        {
          localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
          localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.f());
        }
        i = localLikeRankingInfo.rankingNum;
        if ((i != 1) && (i != 2) && (i != 3))
        {
          if (localLikeRankingInfo.rankingNum < 1) {
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("-");
          } else {
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        paramView = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        paramView.setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localViewHolder.d.setText(paramView);
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.LikeRankingListAdapter
 * JD-Core Version:    0.7.0.1
 */