package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser.ActionSheetItem;
import java.util.List;

public class PublicAccountImageCollectionMainActivityImpl$ActionSheetItemAdapter
  extends ArrayAdapter<IPublicAccountBrowser.ActionSheetItem>
{
  private List<IPublicAccountBrowser.ActionSheetItem> a;
  private LayoutInflater b;
  
  public PublicAccountImageCollectionMainActivityImpl$ActionSheetItemAdapter(Context paramContext, int paramInt, List<IPublicAccountBrowser.ActionSheetItem> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.a = paramList;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public IPublicAccountBrowser.ActionSheetItem a(int paramInt)
  {
    return (IPublicAccountBrowser.ActionSheetItem)this.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2131624760, null);
      paramViewGroup = new PublicAccountImageCollectionMainActivityImpl.ActionSheetItemViewHolder();
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131440807));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131440808));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (PublicAccountImageCollectionMainActivityImpl.ActionSheetItemViewHolder)paramView.getTag();
    }
    IPublicAccountBrowser.ActionSheetItem localActionSheetItem = a(paramInt);
    paramViewGroup.c = localActionSheetItem;
    paramViewGroup.a.setText(localActionSheetItem.c);
    paramViewGroup.b.setBackgroundResource(localActionSheetItem.a);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */