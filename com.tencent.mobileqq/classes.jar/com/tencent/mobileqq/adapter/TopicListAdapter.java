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
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if ((paramTopicInfo == null) || ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum <= 0))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTopicInfo.friendNum > 0)
    {
      if (paramTopicInfo.friendNum >= 10000)
      {
        localStringBuilder.append(a(paramTopicInfo.friendNum));
        localStringBuilder.append("万好友");
      }
    }
    else
    {
      if ((paramTopicInfo.friendNum > 0) && (paramTopicInfo.totalNum > 0)) {
        localStringBuilder.append("、");
      }
      if (paramTopicInfo.totalNum > 0)
      {
        if (paramTopicInfo.totalNum < 10000) {
          break label168;
        }
        localStringBuilder.append(a(paramTopicInfo.totalNum));
        localStringBuilder.append("万人添加该话题");
      }
    }
    for (;;)
    {
      if ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum > 0)) {
        localStringBuilder.append("添加该话题");
      }
      return localStringBuilder.toString();
      localStringBuilder.append(paramTopicInfo.friendNum);
      localStringBuilder.append("个好友");
      break;
      label168:
      localStringBuilder.append(paramTopicInfo.totalNum);
      localStringBuilder.append("人添加该话题");
    }
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramString.length() <= 2)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.charAt(0) == '#') {
        str = paramString.substring(1);
      }
      paramString = str;
    } while (str.charAt(str.length() - 1) != '#');
    return str.substring(0, str.length() - 1);
  }
  
  public SignatureManager.TopicInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (SignatureManager.TopicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<SignatureManager.TopicInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(List<SignatureManager.TopicInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.jdField_a_of_type_JavaUtilList) {
      this.jdField_a_of_type_JavaUtilList = ((ArrayList)paramList);
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramBoolean) && (paramList != this.b)) {
        this.b = ((ArrayList)paramList);
      }
      return bool;
    }
  }
  
  public List<SignatureManager.TopicInfo> b()
  {
    return this.b;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    String str;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562209, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView = new TopicListAdapter.ViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369560));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380664));
      paramView.b = ((TextView)localView.findViewById(2131380665));
      localView.setTag(paramView);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((SignatureManager.TopicInfo)localObject).topicStr);
        paramView.jdField_a_of_type_Int = ((SignatureManager.TopicInfo)localObject).topicId;
        str = a((SignatureManager.TopicInfo)localObject);
        if (!TextUtils.isEmpty(str)) {
          break label242;
        }
        paramView.b.setVisibility(8);
        label134:
        localView.setContentDescription(HardCodeUtil.a(2131714899) + a(((SignatureManager.TopicInfo)localObject).topicStr) + HardCodeUtil.a(2131714898));
      }
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label262;
      }
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839529));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TopicListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label242:
      paramView.b.setVisibility(0);
      paramView.b.setText(str);
      break label134;
      label262:
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839528));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */