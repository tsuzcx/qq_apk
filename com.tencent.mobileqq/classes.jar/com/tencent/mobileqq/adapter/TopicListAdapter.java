package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class TopicListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TopicListAdapter.IAddTopicListener jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter$IAddTopicListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<SignatureManager.TopicInfo> jdField_a_of_type_JavaUtilList;
  private List<SignatureManager.TopicInfo> b;
  
  public TopicListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, TopicListAdapter.IAddTopicListener paramIAddTopicListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTopicListAdapter$IAddTopicListener = paramIAddTopicListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private float a(int paramInt)
  {
    return Math.round(paramInt / 10000.0F * 100.0F) / 100.0F;
  }
  
  private String a(SignatureManager.TopicInfo paramTopicInfo)
  {
    if ((paramTopicInfo != null) && ((paramTopicInfo.totalNum > 0) || (paramTopicInfo.friendNum > 0)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramTopicInfo.friendNum > 0) {
        if (paramTopicInfo.friendNum >= 10000)
        {
          localStringBuilder.append(a(paramTopicInfo.friendNum));
          localStringBuilder.append("万好友");
        }
        else
        {
          localStringBuilder.append(paramTopicInfo.friendNum);
          localStringBuilder.append("个好友");
        }
      }
      if ((paramTopicInfo.friendNum > 0) && (paramTopicInfo.totalNum > 0)) {
        localStringBuilder.append("、");
      }
      if (paramTopicInfo.totalNum > 0) {
        if (paramTopicInfo.totalNum >= 10000)
        {
          localStringBuilder.append(a(paramTopicInfo.totalNum));
          localStringBuilder.append("万人添加该话题");
        }
        else
        {
          localStringBuilder.append(paramTopicInfo.totalNum);
          localStringBuilder.append("人添加该话题");
        }
      }
      if ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum > 0)) {
        localStringBuilder.append("添加该话题");
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramString.length() <= 2)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.charAt(0) == '#') {
      str = paramString.substring(1);
    }
    paramString = str;
    if (str.charAt(str.length() - 1) == '#') {
      paramString = str.substring(0, str.length() - 1);
    }
    return paramString;
  }
  
  public SignatureManager.TopicInfo a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (SignatureManager.TopicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List<SignatureManager.TopicInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(List<SignatureManager.TopicInfo> paramList, boolean paramBoolean)
  {
    boolean bool;
    if (paramList != this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList = ((ArrayList)paramList);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((paramBoolean) && (paramList != this.b)) {
      this.b = ((ArrayList)paramList);
    }
    return bool;
  }
  
  public List<SignatureManager.TopicInfo> b()
  {
    return this.b;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562046, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localObject = new TopicListAdapter.ViewHolder();
      ((TopicListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369273));
      ((TopicListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379939));
      ((TopicListAdapter.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131379940));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (TopicListAdapter.ViewHolder)paramView.getTag();
    }
    SignatureManager.TopicInfo localTopicInfo = a(paramInt);
    if (localTopicInfo != null)
    {
      ((TopicListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localTopicInfo.topicStr);
      ((TopicListAdapter.ViewHolder)localObject).jdField_a_of_type_Int = localTopicInfo.topicId;
      String str = a(localTopicInfo);
      if (TextUtils.isEmpty(str))
      {
        ((TopicListAdapter.ViewHolder)localObject).b.setVisibility(8);
      }
      else
      {
        ((TopicListAdapter.ViewHolder)localObject).b.setVisibility(0);
        ((TopicListAdapter.ViewHolder)localObject).b.setText(str);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714829));
      ((StringBuilder)localObject).append(a(localTopicInfo.topicStr));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714828));
      paramView.setContentDescription(((StringBuilder)localObject).toString());
    }
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839385));
    } else {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839384));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */