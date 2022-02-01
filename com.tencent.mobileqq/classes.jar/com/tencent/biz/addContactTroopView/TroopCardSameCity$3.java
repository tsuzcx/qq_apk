package com.tencent.biz.addContactTroopView;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item2;

class TroopCardSameCity$3
  extends BaseAdapter
{
  public int getCount()
  {
    if (this.a.e != null) {
      return this.a.e.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    TroopCardSameCity.ViewHolder localViewHolder;
    View localView;
    if (paramView == null)
    {
      localViewHolder = new TroopCardSameCity.ViewHolder();
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131625881, paramViewGroup, false);
      localViewHolder.a = ((ImageView)localView.findViewById(2131435443));
      localViewHolder.b = ((TextView)localView.findViewById(2131447237));
      localViewHolder.c = ((TextView)localView.findViewById(2131447105));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (TroopCardSameCity.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    searchtab.Item2 localItem2 = (searchtab.Item2)this.a.e.get(paramInt);
    int j = AIOUtils.b(38.0F, this.a.getResources());
    int k = AIOUtils.b(57.0F, this.a.getResources());
    Object localObject = localItem2.str_img_url.get();
    paramView = (View)localObject;
    if (!HttpUtil.isValidUrl((String)localObject)) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("//")))
      {
        paramView = new StringBuilder();
        paramView.append("http:");
        paramView.append((String)localObject);
        paramView = paramView.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramView);
        ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_no_head", "", 0, 0, "TroopCardSameCity", ((StringBuilder)localObject).toString(), "", "");
      }
      else
      {
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append((String)localObject);
        ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 0, "TroopCardSameCity", paramView.toString(), "", "");
        paramView = (View)localObject;
        break label325;
      }
    }
    i = 1;
    label325:
    if (i != 0)
    {
      try
      {
        localObject = URLDrawable.getDrawable(paramView, j, k);
        localViewHolder.a.setImageDrawable((Drawable)localObject);
        if ((localObject == null) || (1 == ((URLDrawable)localObject).getStatus())) {
          break label453;
        }
        ((URLDrawable)localObject).restartDownload();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (!QLog.isColorLevel()) {
          break label453;
        }
      }
      QLog.e("Q..urldrawable", 2, "URLDrawable.getDrawable() Exception.", localIllegalArgumentException);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramView);
      ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 1, "TroopCardSameCity", localStringBuilder.toString(), "", "");
    }
    else
    {
      localViewHolder.a.setImageDrawable(null);
    }
    label453:
    localViewHolder.b.setText(localItem2.str_name.get());
    localViewHolder.c.setText(localItem2.str_desc.get());
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardSameCity.3
 * JD-Core Version:    0.7.0.1
 */