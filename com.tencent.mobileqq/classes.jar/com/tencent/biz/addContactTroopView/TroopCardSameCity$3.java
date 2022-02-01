package com.tencent.biz.addContactTroopView;

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
    if (this.a.a != null) {
      return this.a.a.size();
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
    TroopCardSameCity.ViewHolder localViewHolder;
    searchtab.Item2 localItem2;
    int j;
    int k;
    String str;
    int i;
    if (paramView == null)
    {
      localViewHolder = new TroopCardSameCity.ViewHolder();
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131559967, paramViewGroup, false);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368810));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379247));
      localViewHolder.b = ((TextView)paramView.findViewById(2131379120));
      paramView.setTag(localViewHolder);
      localItem2 = (searchtab.Item2)this.a.a.get(paramInt);
      j = AIOUtils.a(38.0F, this.a.getResources());
      k = AIOUtils.a(57.0F, this.a.getResources());
      str = localItem2.str_img_url.get();
      i = 1;
      if (HttpUtil.isValidUrl(str)) {
        break label381;
      }
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("//"))) {
        break label336;
      }
      str = "http:" + str;
      ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_no_head", "", 0, 0, "TroopCardSameCity", "" + str, "", "");
      i = 1;
      label231:
      if (i == 0) {
        break label447;
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(str, j, k);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
          localURLDrawable.restartDownload();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label336:
        label381:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q..urldrawable", 2, "URLDrawable.getDrawable() Exception.", localIllegalArgumentException);
        ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 1, "TroopCardSameCity", "" + str, "", "");
        continue;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localItem2.str_name.get());
      localViewHolder.b.setText(localItem2.str_desc.get());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewHolder = (TroopCardSameCity.ViewHolder)paramView.getTag();
      break;
      i = 0;
      ReportControllerImpl.b(null, "dc00899", "Q..urldrawable", "", "url_illegal", "", 0, 0, "TroopCardSameCity", "" + str, "", "");
      break label231;
      label447:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardSameCity.3
 * JD-Core Version:    0.7.0.1
 */