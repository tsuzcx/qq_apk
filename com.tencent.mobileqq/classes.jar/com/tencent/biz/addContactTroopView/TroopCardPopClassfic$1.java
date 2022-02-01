package com.tencent.biz.addContactTroopView;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;

class TroopCardPopClassfic$1
  extends RecyclerView.Adapter<TroopCardPopClassfic.ViewHolder>
{
  private void a(TroopCardPopClassfic.ViewHolder paramViewHolder, popclassifc.PopItem paramPopItem)
  {
    paramViewHolder.a.setText(paramPopItem.str_desc.get());
    int i = DisplayUtil.a(this.a.a.b(), 48.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    paramViewHolder.b.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewHolder.b.setLayoutParams(localLayoutParams);
    paramPopItem = URLDrawable.getDrawable(paramPopItem.str_icon_url.get(), null);
    paramViewHolder.b.setImageDrawable(paramPopItem);
    if ((paramPopItem != null) && (1 != paramPopItem.getStatus())) {
      paramPopItem.restartDownload();
    }
  }
  
  public TroopCardPopClassfic.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131625884, null);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(this.a.e, -2));
    return new TroopCardPopClassfic.ViewHolder(paramViewGroup);
  }
  
  public void a(TroopCardPopClassfic.ViewHolder paramViewHolder, int paramInt)
  {
    a(paramViewHolder, (popclassifc.PopItem)((popclassifc.PopCard)this.a.d.get()).rpt_pop_items.get(paramInt));
    paramViewHolder.itemView.setOnClickListener(new TroopCardPopClassfic.1.1(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.a.d != null) {
      return ((popclassifc.PopCard)this.a.d.get()).rpt_pop_items.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic.1
 * JD-Core Version:    0.7.0.1
 */