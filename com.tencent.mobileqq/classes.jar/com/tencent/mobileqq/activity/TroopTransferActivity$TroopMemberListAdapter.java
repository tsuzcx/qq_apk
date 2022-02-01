package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TroopTransferActivity$TroopMemberListAdapter
  extends FacePreloadBaseAdapter
{
  protected ArrayList<TroopTransferActivity.TroopMemberItem> a;
  protected LayoutInflater b;
  
  public TroopTransferActivity$TroopMemberListAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    super(paramArrayList, paramContext.app, paramContext.g, 1, true);
    this.b = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
    this.a = new ArrayList();
    TroopTransferActivity.TroopMemberItem localTroopMemberItem;
    int i;
    if (localTroopMemberItem == null) {
      i = 0;
    } else {
      i = localTroopMemberItem.size();
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = new ArrayList();
    int j = 0;
    while (j < i)
    {
      Object localObject = (String)localTroopMemberItem.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject)))
      {
        int k = ((String)localObject).indexOf('|');
        String str = ((String)localObject).substring(0, k);
        k = Integer.parseInt(((String)localObject).substring(k + 1));
        if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
        {
          localObject = new TroopTransferActivity.TroopMemberItem();
          ((TroopTransferActivity.TroopMemberItem)localObject).a = 1;
          ((TroopTransferActivity.TroopMemberItem)localObject).c = str;
          ((TroopTransferActivity.TroopMemberItem)localObject).b = k;
          localArrayList.add(localObject);
        }
        else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
        {
          localObject = new TroopTransferActivity.TroopMemberItem();
          ((TroopTransferActivity.TroopMemberItem)localObject).a = 1;
          ((TroopTransferActivity.TroopMemberItem)localObject).c = str;
          ((TroopTransferActivity.TroopMemberItem)localObject).b = k;
          paramArrayList.add(localObject);
        }
      }
      j += 1;
    }
    if (localArrayList.size() > 0)
    {
      localTroopMemberItem = new TroopTransferActivity.TroopMemberItem();
      localTroopMemberItem.a = 0;
      localTroopMemberItem.b = 1;
      this.a.add(0, localTroopMemberItem);
      this.a.addAll(localArrayList);
    }
    if (paramArrayList.size() > 0)
    {
      localTroopMemberItem = new TroopTransferActivity.TroopMemberItem();
      localTroopMemberItem.a = 0;
      localTroopMemberItem.b = 0;
      this.a.add(localTroopMemberItem);
      this.a.addAll(paramArrayList);
    }
    ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, paramContext), 8, null, false);
  }
  
  public TroopTransferActivity.TroopMemberItem a(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    while ((localObject1 == null) && (i < this.a.size()))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.a.get(i);
      Object localObject2 = localObject1;
      if (localTroopMemberItem != null)
      {
        localObject2 = localObject1;
        if (Utils.a(localTroopMemberItem.c, paramString)) {
          localObject2 = localTroopMemberItem;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public List<TroopTransferActivity.TroopMemberItem> a()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (TroopTransferActivity.TroopMemberItem)this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if ((localTroopMemberItem != null) && (localTroopMemberItem.a == 0)) {
      return 0;
    }
    if ((localTroopMemberItem != null) && (localTroopMemberItem.a == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    String str = "";
    TroopTransferActivity.ViewHolder localViewHolder = null;
    Object localObject2 = null;
    Object localObject1;
    if (i == 0)
    {
      if (paramView == null)
      {
        paramView = this.b.inflate(2131625258, paramViewGroup, false);
        localViewHolder = new TroopTransferActivity.ViewHolder(null);
        localViewHolder.A = null;
        localViewHolder.b = ((TextView)paramView);
        paramView.setTag(localViewHolder);
      }
      else
      {
        localViewHolder = (TroopTransferActivity.ViewHolder)paramView.getTag();
      }
      localViewHolder.a = localTroopMemberItem;
      if ((localTroopMemberItem != null) && (localTroopMemberItem.b == 1))
      {
        localViewHolder.b.setText(2131891487);
        localObject1 = paramView;
      }
      else if ((localTroopMemberItem != null) && (localTroopMemberItem.b == 0))
      {
        localViewHolder.b.setText(2131917431);
        localObject1 = paramView;
      }
      else
      {
        localViewHolder.b.setText("");
        localObject1 = paramView;
      }
    }
    else
    {
      localObject1 = paramView;
      if (i == 1)
      {
        if (paramView == null)
        {
          paramView = this.b.inflate(2131629586, paramViewGroup, false);
          paramView.findViewById(2131448256).setVisibility(8);
          paramView.findViewById(2131429919).setVisibility(8);
          localViewHolder = new TroopTransferActivity.ViewHolder(null);
          localViewHolder.A = ((ImageView)paramView.findViewById(2131436404));
          localViewHolder.b = ((TextView)paramView.findViewById(2131448598));
          paramView.setTag(localViewHolder);
        }
        else
        {
          localViewHolder = (TroopTransferActivity.ViewHolder)paramView.getTag();
        }
        localViewHolder.a = localTroopMemberItem;
        localObject1 = localObject2;
        if (localTroopMemberItem != null) {
          localObject1 = localTroopMemberItem.c;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
        {
          localViewHolder.y = ((String)localObject1);
          localViewHolder.A.setImageBitmap(a(1, localTroopMemberItem.c));
        }
        else
        {
          localViewHolder.A.setImageDrawable(ImageUtil.j());
        }
        localObject1 = str;
        if (localTroopMemberItem != null) {
          localObject1 = localTroopMemberItem.d;
        }
        localViewHolder.b.setText((CharSequence)localObject1);
        localObject1 = paramView;
      }
    }
    if ((localViewHolder != null) && (localViewHolder.b != null)) {
      ((View)localObject1).setContentDescription(localViewHolder.b.getText());
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */