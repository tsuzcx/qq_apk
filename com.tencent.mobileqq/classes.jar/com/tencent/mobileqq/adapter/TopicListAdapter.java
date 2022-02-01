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
  private QQAppInterface a;
  private Context b;
  private LayoutInflater c;
  private XListView d;
  private List<SignatureManager.TopicInfo> e;
  private List<SignatureManager.TopicInfo> f;
  private TopicListAdapter.IAddTopicListener g;
  
  public TopicListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, TopicListAdapter.IAddTopicListener paramIAddTopicListener)
  {
    this.b = paramContext;
    this.a = paramQQAppInterface;
    this.d = paramXListView;
    this.g = paramIAddTopicListener;
    this.c = LayoutInflater.from(paramContext);
  }
  
  private String a(SignatureManager.TopicInfo paramTopicInfo)
  {
    if ((paramTopicInfo != null) && ((paramTopicInfo.totalNum > 0) || (paramTopicInfo.friendNum > 0)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramTopicInfo.friendNum > 0) {
        if (paramTopicInfo.friendNum >= 10000)
        {
          localStringBuilder.append(b(paramTopicInfo.friendNum));
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
          localStringBuilder.append(b(paramTopicInfo.totalNum));
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
  
  private float b(int paramInt)
  {
    return Math.round(paramInt / 10000.0F * 100.0F) / 100.0F;
  }
  
  public SignatureManager.TopicInfo a(int paramInt)
  {
    List localList = this.e;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (SignatureManager.TopicInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  public List<SignatureManager.TopicInfo> a()
  {
    return this.e;
  }
  
  public boolean a(List<SignatureManager.TopicInfo> paramList, boolean paramBoolean)
  {
    boolean bool;
    if (paramList != this.e)
    {
      this.e = ((ArrayList)paramList);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((paramBoolean) && (paramList != this.f)) {
      this.f = ((ArrayList)paramList);
    }
    return bool;
  }
  
  public List<SignatureManager.TopicInfo> b()
  {
    return this.f;
  }
  
  public int getCount()
  {
    List localList = this.e;
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
      paramView = this.c.inflate(2131628472, this.d, false);
      localObject = new TopicListAdapter.ViewHolder();
      ((TopicListAdapter.ViewHolder)localObject).d = ((ImageView)paramView.findViewById(2131436252));
      ((TopicListAdapter.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131448825));
      ((TopicListAdapter.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131448826));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (TopicListAdapter.ViewHolder)paramView.getTag();
    }
    SignatureManager.TopicInfo localTopicInfo = a(paramInt);
    if (localTopicInfo != null)
    {
      ((TopicListAdapter.ViewHolder)localObject).b.setText(localTopicInfo.topicStr);
      ((TopicListAdapter.ViewHolder)localObject).a = localTopicInfo.topicId;
      String str = a(localTopicInfo);
      if (TextUtils.isEmpty(str))
      {
        ((TopicListAdapter.ViewHolder)localObject).c.setVisibility(8);
      }
      else
      {
        ((TopicListAdapter.ViewHolder)localObject).c.setVisibility(0);
        ((TopicListAdapter.ViewHolder)localObject).c.setText(str);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131912330));
      ((StringBuilder)localObject).append(a(localTopicInfo.topicStr));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131912329));
      paramView.setContentDescription(((StringBuilder)localObject).toString());
    }
    if (ThemeUtil.isNowThemeIsNight(this.a, false, null)) {
      paramView.setBackgroundDrawable(this.b.getResources().getDrawable(2130839569));
    } else {
      paramView.setBackgroundDrawable(this.b.getResources().getDrawable(2130839568));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TopicListAdapter
 * JD-Core Version:    0.7.0.1
 */