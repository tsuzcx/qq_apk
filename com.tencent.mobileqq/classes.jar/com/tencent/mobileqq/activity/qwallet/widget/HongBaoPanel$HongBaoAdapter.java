package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class HongBaoPanel$HongBaoAdapter
  extends RecyclerView.Adapter<HongBaoPanel.MyViewHolder>
{
  private List<PanelData> mDatas = new ArrayList();
  private HongBaoPanel.OnHolderItemClickListener mHolderItemClickListener;
  
  HongBaoPanel$HongBaoAdapter(HongBaoPanel paramHongBaoPanel) {}
  
  public void clearDatas()
  {
    this.mDatas.clear();
    notifyDataSetChanged();
  }
  
  public List<PanelData> getDatas()
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
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject1 = (PanelData)this.mDatas.get(paramInt);
      Object localObject2 = this.this$0;
      Object localObject3 = paramMyViewHolder.hongbaoText;
      String str = ((PanelData)this.mDatas.get(paramInt)).b;
      if (HongBaoPanel.access$300(this.this$0).equals("#5B6175"))
      {
        i = this.this$0.mContext.getResources().getColor(2131167033);
        label122:
        HongBaoPanel.access$400((HongBaoPanel)localObject2, (TextView)localObject3, str, i, 0);
        paramMyViewHolder.hongbaoPic.setImageResource(2130843643);
        if (!StringUtil.a(((PanelData)localObject1).c))
        {
          paramMyViewHolder.hongbaoPic.setTag(((PanelData)localObject1).c);
          localObject2 = HongBaoPanel.access$500(this.this$0, paramInt, ((PanelData)localObject1).c, paramMyViewHolder.hongbaoPic);
          if ((localObject2 != null) && (((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon != null)) {
            paramMyViewHolder.hongbaoPic.setImageBitmap(((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon);
          }
        }
        if (this.this$0.redManager == null) {
          continue;
        }
        localObject1 = this.this$0.redManager.a(((PanelData)localObject1).jdField_a_of_type_JavaLangString);
        if (localObject1 == null) {
          continue;
        }
        localObject2 = paramMyViewHolder.hbRedPointContainer;
        if (!((QWalletRedManager.ShowInfo)localObject1).jdField_a_of_type_Boolean) {
          break label362;
        }
      }
      label362:
      for (int i = 0;; i = 8)
      {
        for (;;)
        {
          ((RelativeLayout)localObject2).setVisibility(i);
          if (!((QWalletRedManager.ShowInfo)localObject1).b) {
            break label368;
          }
          paramMyViewHolder.imgFlag.setVisibility(0);
          try
          {
            localObject2 = new ColorDrawable(0);
            ((Drawable)localObject2).setAlpha(0);
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
            localObject1 = URLDrawable.getDrawable(((QWalletRedManager.ShowInfo)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
            paramMyViewHolder.imgFlag.setImageDrawable((Drawable)localObject1);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        break;
        i = Color.parseColor(HongBaoPanel.access$300(this.this$0));
        break label122;
      }
      label368:
      paramMyViewHolder.imgFlag.setVisibility(8);
    }
  }
  
  public HongBaoPanel.MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new HongBaoPanel.MyViewHolder(this.this$0, LayoutInflater.from(this.this$0.mContext).inflate(2131560639, paramViewGroup, false), this.mHolderItemClickListener);
  }
  
  public void setDatas(List<PanelData> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.HongBaoAdapter
 * JD-Core Version:    0.7.0.1
 */