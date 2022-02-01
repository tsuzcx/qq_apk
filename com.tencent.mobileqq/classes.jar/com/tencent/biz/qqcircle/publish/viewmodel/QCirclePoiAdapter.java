package com.tencent.biz.qqcircle.publish.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCirclePoiAdapter
  extends BaseAdapter
{
  private List<QCirclePoiAdapter.PoiItemInfo> a = new ArrayList();
  private QCirclePoiAdapter.PoiItemInfo b;
  private Context c;
  private int d = -1;
  
  public QCirclePoiAdapter(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private View a(int paramInt, View paramView, QCirclePoiAdapter.PoiItemInfo paramPoiItemInfo)
  {
    Object localObject = paramView;
    QCirclePoiAdapter.ViewHolder localViewHolder;
    if (paramView != null)
    {
      localViewHolder = (QCirclePoiAdapter.ViewHolder)paramView.getTag();
      if (localViewHolder.d == paramPoiItemInfo.b)
      {
        localObject = paramView;
        if (!localViewHolder.e) {}
      }
      else
      {
        localObject = null;
      }
    }
    if (localObject == null)
    {
      localObject = new QCirclePoiAdapter.ViewHolder(this, null);
      paramView = LayoutInflater.from(this.c).inflate(2131626935, null, true);
      ((QCirclePoiAdapter.ViewHolder)localObject).a = ((ViewGroup)paramView.findViewById(2131431280));
      ((QCirclePoiAdapter.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131448651));
      ((QCirclePoiAdapter.ViewHolder)localObject).c = ((ImageView)paramView.findViewById(2131436339));
      ((QCirclePoiAdapter.ViewHolder)localObject).d = true;
      ((QCirclePoiAdapter.ViewHolder)localObject).e = false;
      paramView.setTag(localObject);
    }
    else
    {
      localViewHolder = (QCirclePoiAdapter.ViewHolder)((View)localObject).getTag();
      paramView = (View)localObject;
      localObject = localViewHolder;
    }
    if (paramPoiItemInfo != null)
    {
      ((QCirclePoiAdapter.ViewHolder)localObject).b.setText(paramPoiItemInfo.a.poiName);
      paramPoiItemInfo = (FrameLayout.LayoutParams)((QCirclePoiAdapter.ViewHolder)localObject).a.getLayoutParams();
      paramPoiItemInfo.setMargins(0, 0, ViewUtils.a(5.0F), 0);
      ((QCirclePoiAdapter.ViewHolder)localObject).a.setLayoutParams(paramPoiItemInfo);
    }
    return paramView;
  }
  
  private View a(QCirclePoiAdapter.PoiItemInfo paramPoiItemInfo, View paramView)
  {
    paramPoiItemInfo = paramView;
    if (paramView != null)
    {
      paramPoiItemInfo = paramView;
      if (!((QCirclePoiAdapter.ViewHolder)paramView.getTag()).e) {
        paramPoiItemInfo = null;
      }
    }
    Object localObject;
    if (paramPoiItemInfo == null)
    {
      paramPoiItemInfo = new QCirclePoiAdapter.ViewHolder(this, null);
      paramView = new TextView(this.c);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localObject = (TextView)paramView;
      ((TextView)localObject).setGravity(16);
      paramView.setPadding(0, 0, ViewUtils.a(16.0F), 0);
      ((TextView)localObject).setTextSize(1, 12.0F);
      ((TextView)localObject).setTextColor(QCircleSkinHelper.getInstance().getColor(2131167081));
      Drawable localDrawable = this.c.getResources().getDrawable(2130845382);
      localDrawable.setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      ((TextView)localObject).setCompoundDrawables(localDrawable, null, null, null);
      ((TextView)localObject).setCompoundDrawablePadding(ViewUtils.a(3.0F));
      paramPoiItemInfo.b = ((TextView)localObject);
      paramPoiItemInfo.d = false;
      paramPoiItemInfo.e = true;
      paramView.setTag(paramPoiItemInfo);
    }
    else
    {
      localObject = (QCirclePoiAdapter.ViewHolder)paramPoiItemInfo.getTag();
      paramView = paramPoiItemInfo;
      paramPoiItemInfo = (QCirclePoiAdapter.PoiItemInfo)localObject;
    }
    paramPoiItemInfo.b.setText(2131895773);
    return paramView;
  }
  
  private View a(QCirclePoiAdapter.PoiItemInfo paramPoiItemInfo, View paramView, int paramInt)
  {
    paramView = new QCirclePoiAdapter.ViewHolder(this, null);
    TextView localTextView1 = new TextView(this.c);
    localTextView1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    TextView localTextView2 = (TextView)localTextView1;
    localTextView2.setGravity(16);
    if (paramInt == 0) {
      localTextView1.setPadding(ViewUtils.a(16.0F), 0, ViewUtils.a(16.0F), 0);
    } else {
      localTextView1.setPadding(0, 0, ViewUtils.a(16.0F), 0);
    }
    localTextView2.setTextSize(1, 12.0F);
    localTextView2.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167081));
    paramView.b = localTextView2;
    paramView.d = false;
    localTextView1.setTag(paramView);
    paramView.b.setText(paramPoiItemInfo.a.poiName);
    return localTextView1;
  }
  
  public QCirclePoiAdapter.PoiItemInfo a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (QCirclePoiAdapter.PoiItemInfo)this.a.get(paramInt);
  }
  
  public void a()
  {
    List localList = this.a;
    if (localList != null)
    {
      localList.clear();
      notifyDataSetChanged();
    }
  }
  
  public void a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    int i = QCircleConfigHelper.a("qqcircle", "qqcircle_publish_show_lbs_count", Integer.valueOf(5)).intValue();
    QCirclePoiAdapter.PoiItemInfo localPoiItemInfo;
    if (this.a.size() != i + 1)
    {
      localPoiItemInfo = this.b;
      if (localPoiItemInfo != null)
      {
        i = this.d;
        if (i != -1) {
          this.a.add(i, localPoiItemInfo);
        }
      }
    }
    i = 0;
    if ((paramPoiInfo != null) && (!"invalide_poi_id".equals(paramPoiInfo.poiId)))
    {
      int j = 0;
      while (i < this.a.size())
      {
        localPoiItemInfo = (QCirclePoiAdapter.PoiItemInfo)this.a.get(i);
        if (paramPoiInfo.poiName.equals(localPoiItemInfo.a.poiName))
        {
          localPoiItemInfo.b = true;
          this.b = localPoiItemInfo;
          this.d = i;
          j = 1;
        }
        i += 1;
      }
      if (j == 0)
      {
        this.b = new QCirclePoiAdapter.PoiItemInfo();
        localPoiItemInfo = this.b;
        localPoiItemInfo.b = true;
        localPoiItemInfo.a = paramPoiInfo;
      }
      else
      {
        this.a.remove(this.b);
      }
      notifyDataSetChanged();
      return;
    }
    paramPoiInfo = this.a.iterator();
    while (paramPoiInfo.hasNext()) {
      ((QCirclePoiAdapter.PoiItemInfo)paramPoiInfo.next()).b = false;
    }
    this.d = -1;
    this.b = null;
    notifyDataSetChanged();
  }
  
  public void a(List<LbsDataV2.PoiInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.a.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localPoiInfo = (LbsDataV2.PoiInfo)paramList.next();
        QCirclePoiAdapter.PoiItemInfo localPoiItemInfo = new QCirclePoiAdapter.PoiItemInfo();
        localPoiItemInfo.a = localPoiInfo;
        localPoiItemInfo.b = false;
        this.a.add(localPoiItemInfo);
      }
      paramList = new QCirclePoiAdapter.PoiItemInfo();
      LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
      localPoiInfo.poiId = "";
      localPoiInfo.poiName = "";
      paramList.a = localPoiInfo;
      paramList.b = false;
      paramList.c = true;
      this.a.add(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    List localList = this.a;
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
    Object localObject = a(paramInt);
    if (((QCirclePoiAdapter.PoiItemInfo)localObject).c) {
      localObject = a((QCirclePoiAdapter.PoiItemInfo)localObject, paramView);
    } else if (((QCirclePoiAdapter.PoiItemInfo)localObject).b) {
      localObject = a(paramInt, paramView, (QCirclePoiAdapter.PoiItemInfo)localObject);
    } else {
      localObject = a((QCirclePoiAdapter.PoiItemInfo)localObject, paramView, paramInt);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter
 * JD-Core Version:    0.7.0.1
 */