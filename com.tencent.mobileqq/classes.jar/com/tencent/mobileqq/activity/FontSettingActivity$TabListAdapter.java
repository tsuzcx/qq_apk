package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;

class FontSettingActivity$TabListAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private LayoutInflater b;
  private RecentFaceDecoder c;
  
  public FontSettingActivity$TabListAdapter(FontSettingActivity paramFontSettingActivity, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    this.b = paramFontSettingActivity.getLayoutInflater();
    this.c = new RecentFaceDecoder(paramQQAppInterface, this);
  }
  
  public void a()
  {
    this.c.b();
  }
  
  public int getCount()
  {
    return this.a.q.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.q.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.b.inflate(2131629159, paramViewGroup, false);
    Object localObject = (FontSettingActivity.RecentData)this.a.q.get(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131435219);
    localImageView.setImageDrawable(this.c.a(((FontSettingActivity.RecentData)localObject).f, ((FontSettingActivity.RecentData)localObject).e));
    ((TextView)paramView.findViewById(16908308)).setText(((FontSettingActivity.RecentData)localObject).b);
    ((TextView)paramView.findViewById(16908309)).setText(((FontSettingActivity.RecentData)localObject).c);
    ((TextView)paramView.findViewById(2131436844)).setText(((FontSettingActivity.RecentData)localObject).d);
    FontSettingActivity.TabListAdapter.ViewHolder localViewHolder = new FontSettingActivity.TabListAdapter.ViewHolder(this);
    localViewHolder.a = ((FontSettingActivity.RecentData)localObject).e;
    localViewHolder.b = localImageView;
    localViewHolder.c = ((FontSettingActivity.RecentData)localObject);
    paramView.setTag(localViewHolder);
    if ((FontSettingActivity.a(this.a)) && (paramInt == this.a.q.size() - 1))
    {
      localObject = this.a;
      ((FontSettingActivity)localObject).s = true;
      ((FontSettingActivity)localObject).a();
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.a.f.getChildCount();
    if (paramBitmap != null)
    {
      paramInt1 = 0;
      Object localObject2;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (paramInt1 >= paramInt2) {
          break;
        }
        Object localObject3 = this.a.f.getChildAt(paramInt1).getTag();
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if ((localObject3 instanceof FontSettingActivity.TabListAdapter.ViewHolder))
          {
            localObject1 = (FontSettingActivity.TabListAdapter.ViewHolder)localObject3;
            localObject2 = localObject1;
            if (((FontSettingActivity.TabListAdapter.ViewHolder)localObject1).a.equals(paramString))
            {
              localObject2 = localObject1;
              break;
            }
          }
        }
        paramInt1 += 1;
      }
      if (localObject2 != null)
      {
        localObject2.b.setImageBitmap(paramBitmap);
        notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.TabListAdapter
 * JD-Core Version:    0.7.0.1
 */