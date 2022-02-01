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
  private List<IntimateInfo.MutualMarkInfo> b;
  private int c = 0;
  
  private IntimateContentItemMutualMarkView$FriendMaskAdapter(IntimateContentItemMutualMarkView paramIntimateContentItemMutualMarkView) {}
  
  public IntimateInfo.MutualMarkInfo a(int paramInt)
  {
    List localList = this.b;
    if (localList == null) {
      return null;
    }
    return (IntimateInfo.MutualMarkInfo)localList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.MutualMarkInfo> paramList)
  {
    this.b = paramList;
    if (this.c == 0)
    {
      this.c = ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(40.0F) - 80) / ViewUtils.dip2px(60.0F));
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("friend mark max count: ");
        paramList.append(this.c);
        QLog.d("intimate_relationship", 2, paramList.toString());
      }
      if (this.c <= 0) {
        this.c = 5;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    int i = localList.size();
    int j = this.c;
    if (i > j) {
      return j;
    }
    return this.b.size();
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
      paramView = LayoutInflater.from(this.a.a).inflate(2131625191, null);
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131433795);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    IntimateInfo.MutualMarkInfo localMutualMarkInfo = a(paramInt);
    if ((localMutualMarkInfo instanceof IntimateInfo.PrefetchMutualMarkInfo))
    {
      localObject = (IntimateInfo.PrefetchMutualMarkInfo)localMutualMarkInfo;
      IntimateContentItemMutualMarkView.a(this.a, (IntimateInfo.PrefetchMutualMarkInfo)localObject);
    }
    else
    {
      int i = 0;
      if ((localMutualMarkInfo != null) && (!TextUtils.isEmpty(localMutualMarkInfo.iconStaticUrl)))
      {
        localObject = new ColorDrawable(0);
        String str = MutualMarkAlienationHelper.a(this.a.h.n(), this.a.h.k(), localMutualMarkInfo.type, localMutualMarkInfo.level, localMutualMarkInfo.subLevel, localMutualMarkInfo.iconStaticUrl);
        IntimateContentItemMutualMarkView.a(this.a, localImageView, str, (Drawable)localObject, localMutualMarkInfo.type);
      }
      else
      {
        if (localMutualMarkInfo != null) {
          i = MutualMarkConfigHelper.b(this.a.h.n(), this.a.h.k(), localMutualMarkInfo.type, localMutualMarkInfo.level);
        }
        if (i != 0) {
          localObject = new MutualMarkIconProxyDrawable(this.a.a, i);
        }
        localImageView.setImageDrawable((Drawable)localObject);
      }
      localRelativeLayout.setBackgroundDrawable(this.a.h.l().getResources().getDrawable(2130841284));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView.FriendMaskAdapter
 * JD-Core Version:    0.7.0.1
 */