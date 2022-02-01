package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopTransferActivity$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private List<TroopTransferActivity.TroopMemberItem> b;
  
  public TroopTransferActivity$SearchResultAdapter(List<TroopTransferActivity.TroopMemberItem> paramList)
  {
    super(paramList, paramList.app, paramList.n, 1, true);
    Object localObject;
    this.b = localObject;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131629269, paramViewGroup, false);
      paramView = new TroopTransferActivity.ViewHolder(null);
      paramView.A = ((ImageView)localView.findViewById(2131436404));
      paramView.b = ((TextView)localView.findViewById(2131448598));
      ((TextView)localView.findViewById(2131448762)).setText("");
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TroopTransferActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (TroopTransferActivity.TroopMemberItem)this.b.get(paramInt);
    if ((!TextUtils.isEmpty(((TroopTransferActivity.TroopMemberItem)localObject).g)) && (!((TroopTransferActivity.TroopMemberItem)localObject).g.equals(((TroopTransferActivity.TroopMemberItem)localObject).d)))
    {
      TextView localTextView = paramView.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TroopTransferActivity.TroopMemberItem)localObject).d);
      localStringBuilder.append("(");
      localStringBuilder.append(((TroopTransferActivity.TroopMemberItem)localObject).g);
      localStringBuilder.append(")");
      localTextView.setText(localStringBuilder.toString());
    }
    else
    {
      paramView.b.setText(((TroopTransferActivity.TroopMemberItem)localObject).d);
    }
    paramView.y = ((TroopTransferActivity.TroopMemberItem)localObject).c;
    paramView.a = ((TroopTransferActivity.TroopMemberItem)localObject);
    paramView.A.setImageBitmap(a(1, ((TroopTransferActivity.TroopMemberItem)localObject).c));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */