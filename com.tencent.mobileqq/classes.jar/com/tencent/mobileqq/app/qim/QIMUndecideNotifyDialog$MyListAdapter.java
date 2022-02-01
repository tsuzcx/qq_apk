package com.tencent.mobileqq.app.qim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

class QIMUndecideNotifyDialog$MyListAdapter
  extends XBaseAdapter
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<QIMNotifyAddFriend> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b = 0;
  
  public QIMUndecideNotifyDialog$MyListAdapter(QIMUndecideNotifyDialog paramQIMUndecideNotifyDialog, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131298158);
    this.b = paramContext.getResources().getDimensionPixelOffset(2131298157);
  }
  
  public void a(List<QIMNotifyAddFriend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QIMUndecideNotifyDialog.ViewHolder localViewHolder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561007, null);
      localViewHolder = new QIMUndecideNotifyDialog.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369650));
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364501));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380481));
      localViewHolder.b = ((TextView)paramView.findViewById(2131380613));
      localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370587));
      paramView.setTag(localViewHolder);
      localQIMNotifyAddFriend = (QIMNotifyAddFriend)getItem(paramInt);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localQIMNotifyAddFriend);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.b.contains(localQIMNotifyAddFriend));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localQIMNotifyAddFriend.uin), (byte)3));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localQIMNotifyAddFriend.nickName);
      localViewHolder.b.setText(localQIMNotifyAddFriend.wording);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.a.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label486;
      }
      localViewHolder.b.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      if (localQIMNotifyAddFriend.videoInfos.size() <= 0) {
        break label499;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = new ArrayList();
      int i = 0;
      while (i < localQIMNotifyAddFriend.videoInfos.size())
      {
        Object localObject2 = (QIMNotifyAddFriend.VideoInfo)localQIMNotifyAddFriend.videoInfos.get(i);
        URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ArrayList)localObject1).add(((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid);
        localURLImageView.setOnClickListener(new QIMUndecideNotifyDialog.MyListAdapter.1(this, (ArrayList)localObject1, ((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid));
        UIUtils.a(localURLImageView, ((QIMNotifyAddFriend.VideoInfo)localObject2).coverUrl, this.jdField_a_of_type_Int, this.b, 8, new ColorDrawable(-1), "Qim_First_Login_Recommend");
        localObject2 = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int, this.b);
        if (localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
      localViewHolder = (QIMUndecideNotifyDialog.ViewHolder)paramView.getTag();
      break;
      label486:
      localViewHolder.b.setVisibility(8);
    }
    label499:
    localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    localViewHolder.jdField_a_of_type_Long = localQIMNotifyAddFriend.uin;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog.MyListAdapter
 * JD-Core Version:    0.7.0.1
 */