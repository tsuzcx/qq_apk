package com.tencent.mobileqq.activity.qwallet.widget;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

class HongBaoPanel$HongBaoAdapter
  extends RecyclerView.Adapter
{
  private List mDatas = new ArrayList();
  private HongBaoPanel.OnHolderItemClickListener mHolderItemClickListener;
  
  HongBaoPanel$HongBaoAdapter(HongBaoPanel paramHongBaoPanel) {}
  
  public void clearDatas()
  {
    this.mDatas.clear();
    notifyDataSetChanged();
  }
  
  public List getDatas()
  {
    return this.mDatas;
  }
  
  public int getItemCount()
  {
    if (this.mDatas != null) {
      return this.mDatas.size();
    }
    return 0;
  }
  
  public PanelData getPanelDataAtPos(int paramInt)
  {
    if ((this.mDatas == null) || (this.mDatas.size() <= 0) || (this.mDatas.size() <= paramInt)) {
      return null;
    }
    return (PanelData)this.mDatas.get(paramInt);
  }
  
  public void onBindViewHolder(HongBaoPanel.MyViewHolder paramMyViewHolder, int paramInt)
  {
    if ((this.mDatas == null) || (this.mDatas.size() <= 0) || (this.mDatas.size() <= paramInt)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = (PanelData)this.mDatas.get(paramInt);
        HongBaoPanel.access$300(this.this$0, paramMyViewHolder.hongbaoText, ((PanelData)this.mDatas.get(paramInt)).b, HongBaoPanel.access$200(this.this$0));
        paramMyViewHolder.hongbaoPic.setImageResource(2130841082);
        if (!StringUtil.a(((PanelData)localObject1).c))
        {
          paramMyViewHolder.hongbaoPic.setTag(((PanelData)localObject1).c);
          localObject2 = HongBaoPanel.access$400(this.this$0, paramInt, ((PanelData)localObject1).c, paramMyViewHolder.hongbaoPic);
          if ((localObject2 != null) && (((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon != null)) {
            paramMyViewHolder.hongbaoPic.setImageBitmap(((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon);
          }
        }
      } while (this.this$0.redManager == null);
      localObject1 = this.this$0.redManager.a(((PanelData)localObject1).jdField_a_of_type_JavaLangString);
    } while (localObject1 == null);
    Object localObject2 = paramMyViewHolder.hbRedPointContainer;
    if (((QWalletRedManager.ShowInfo)localObject1).jdField_a_of_type_Boolean) {}
    for (paramInt = 0;; paramInt = 8)
    {
      ((RelativeLayout)localObject2).setVisibility(paramInt);
      if (!((QWalletRedManager.ShowInfo)localObject1).b) {
        break;
      }
      paramMyViewHolder.imgFlag.setVisibility(0);
      try
      {
        localObject2 = new ColorDrawable(0);
        ((Drawable)localObject2).setAlpha(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(((QWalletRedManager.ShowInfo)localObject1).jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        paramMyViewHolder.imgFlag.setImageDrawable((Drawable)localObject1);
        return;
      }
      catch (Throwable paramMyViewHolder)
      {
        paramMyViewHolder.printStackTrace();
        return;
      }
    }
    paramMyViewHolder.imgFlag.setVisibility(8);
  }
  
  public HongBaoPanel.MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new HongBaoPanel.MyViewHolder(this.this$0, LayoutInflater.from(this.this$0.mContext).inflate(2130969790, paramViewGroup, false), this.mHolderItemClickListener);
  }
  
  public void setDatas(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    this.mDatas.clear();
    this.mDatas.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void setOnItemClickListener(HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.mHolderItemClickListener = paramOnHolderItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.HongBaoAdapter
 * JD-Core Version:    0.7.0.1
 */