package com.tencent.biz.pubaccount;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import org.json.JSONArray;

public class PhotoWallViewForAccountDetail$PhotoAdapter
  extends BaseAdapter
{
  List<IPublicAccountConfigAttr.PaConfigInfo> a;
  private Context c = null;
  private LayoutInflater d = null;
  
  public PhotoWallViewForAccountDetail$PhotoAdapter(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail, Context paramContext)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
  }
  
  public void a(List<IPublicAccountConfigAttr.PaConfigInfo> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramViewGroup = new JSONArray(((IPublicAccountConfigAttr.PaConfigInfo)this.a.get(paramInt)).k);
      if (paramViewGroup.length() > 0) {
        paramViewGroup = paramViewGroup.optString(0);
      }
    }
    catch (Exception paramViewGroup)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetail.PhotoWallViewForAccountDetail", 2, "RICH_PIC_TEXT:pic json error!");
      }
      paramViewGroup.printStackTrace();
      paramViewGroup = null;
    }
    View localView;
    if (paramView == null)
    {
      paramView = new PhotoWallViewForAccountDetail.PhotoAdapter.ViewHolder(this);
      localView = this.d.inflate(2131625588, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.b.e, this.b.f));
      paramView.a = ((URLImageView)localView.findViewById(2131440218));
      localView.setTag(paramView);
    }
    else
    {
      PhotoWallViewForAccountDetail.PhotoAdapter.ViewHolder localViewHolder = (PhotoWallViewForAccountDetail.PhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    paramView.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
    if (TextUtils.isEmpty(paramViewGroup))
    {
      paramView.a.setImageResource(2130839760);
      return localView;
    }
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup);
    paramView.a.setImageDrawable(paramViewGroup);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */