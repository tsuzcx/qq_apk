package com.tencent.mobileqq.activity.qwallet.widget;

import ahcw;
import ahcy;
import ahcz;
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
import bbkk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import java.util.ArrayList;
import java.util.List;

class HongBaoPanel$HongBaoAdapter
  extends RecyclerView.Adapter<HongBaoPanel.MyViewHolder>
{
  private List<ahcz> mDatas = new ArrayList();
  private HongBaoPanel.OnHolderItemClickListener mHolderItemClickListener;
  
  HongBaoPanel$HongBaoAdapter(HongBaoPanel paramHongBaoPanel) {}
  
  public void clearDatas()
  {
    this.mDatas.clear();
    notifyDataSetChanged();
  }
  
  public List<ahcz> getDatas()
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
  
  public ahcz getPanelDataAtPos(int paramInt)
  {
    if ((this.mDatas == null) || (this.mDatas.size() <= 0) || (this.mDatas.size() <= paramInt)) {
      return null;
    }
    return (ahcz)this.mDatas.get(paramInt);
  }
  
  public void onBindViewHolder(HongBaoPanel.MyViewHolder paramMyViewHolder, int paramInt)
  {
    if ((this.mDatas == null) || (this.mDatas.size() <= 0) || (this.mDatas.size() <= paramInt)) {}
    Object localObject1;
    Object localObject3;
    int i;
    do
    {
      do
      {
        return;
        localObject1 = (ahcz)this.mDatas.get(paramInt);
        localObject2 = this.this$0;
        localObject3 = paramMyViewHolder.hongbaoText;
        String str = ((ahcz)this.mDatas.get(paramInt)).b;
        if (!HongBaoPanel.access$300(this.this$0).equals("#5B6175")) {
          break;
        }
        i = this.this$0.mContext.getResources().getColor(2131166854);
        HongBaoPanel.access$400((HongBaoPanel)localObject2, (TextView)localObject3, str, i, 0);
        paramMyViewHolder.hongbaoPic.setImageResource(2130842810);
        if (!bbkk.a(((ahcz)localObject1).c))
        {
          paramMyViewHolder.hongbaoPic.setTag(((ahcz)localObject1).c);
          localObject2 = HongBaoPanel.access$500(this.this$0, paramInt, ((ahcz)localObject1).c, paramMyViewHolder.hongbaoPic);
          if ((localObject2 != null) && (((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon != null)) {
            paramMyViewHolder.hongbaoPic.setImageBitmap(((CustomizeStrategyFactory.RedPacketInfo)localObject2).icon);
          }
        }
      } while (this.this$0.redManager == null);
      localObject1 = this.this$0.redManager.a(((ahcz)localObject1).jdField_a_of_type_JavaLangString);
    } while (localObject1 == null);
    Object localObject2 = paramMyViewHolder.hbRedPointContainer;
    if (((ahcy)localObject1).jdField_a_of_type_Boolean) {}
    for (paramInt = 0;; paramInt = 8)
    {
      ((RelativeLayout)localObject2).setVisibility(paramInt);
      if (!((ahcy)localObject1).b) {
        break label349;
      }
      paramMyViewHolder.imgFlag.setVisibility(0);
      try
      {
        localObject2 = new ColorDrawable(0);
        ((Drawable)localObject2).setAlpha(0);
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(((ahcy)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
        paramMyViewHolder.imgFlag.setImageDrawable((Drawable)localObject1);
        return;
      }
      catch (Throwable paramMyViewHolder)
      {
        paramMyViewHolder.printStackTrace();
        return;
      }
      i = Color.parseColor(HongBaoPanel.access$300(this.this$0));
      break;
    }
    label349:
    paramMyViewHolder.imgFlag.setVisibility(8);
  }
  
  public HongBaoPanel.MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new HongBaoPanel.MyViewHolder(this.this$0, LayoutInflater.from(this.this$0.mContext).inflate(2131560211, paramViewGroup, false), this.mHolderItemClickListener);
  }
  
  public void setDatas(List<ahcz> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.HongBaoAdapter
 * JD-Core Version:    0.7.0.1
 */