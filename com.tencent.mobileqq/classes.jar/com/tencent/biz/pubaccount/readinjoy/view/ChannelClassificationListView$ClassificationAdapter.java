package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter
  extends BaseAdapter
{
  private ChannelClassificationListView$ClassificationAdapter(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public T a(int paramInt)
  {
    return (ChannelClassificationListView.IClassData)ChannelClassificationListView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ChannelClassificationListView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562880, paramViewGroup, false);
      paramView.setOnClickListener(new ChannelClassificationListView.ClassificationAdapter.1(this, paramViewGroup));
    }
    for (;;)
    {
      Object localObject = (ChannelClassificationListView.IClassData)ChannelClassificationListView.a(this.a).get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(((ChannelClassificationListView.IClassData)localObject).a());
      if (!((ChannelClassificationListView.IClassData)localObject).a())
      {
        ((ChannelClassificationListView.IClassData)localObject).a(true);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("subchannelid", a(paramInt).b());
        ((JSONObject)localObject).put("subchannelname", a(paramInt).a());
        ((JSONObject)localObject).put("channelid", ChannelClassificationListView.a(this.a));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8009932", "0X8009932", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.ClassificationAdapter
 * JD-Core Version:    0.7.0.1
 */