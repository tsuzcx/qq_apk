package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class EmojiFragment$TemplateListAdapter
  extends RecyclerView.Adapter<EmojiFragment.TemplateListAdapter.TemplateItemVH>
{
  private Context context;
  private List<EmojiFragment.TemplateInfo> mTemplateBundleInfoList = new ArrayList();
  
  public EmojiFragment$TemplateListAdapter(EmojiFragment paramEmojiFragment, Context paramContext)
  {
    this.context = paramContext;
  }
  
  void addTempList(List<EmojiFragment.TemplateInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.mTemplateBundleInfoList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.mTemplateBundleInfoList == null) || (this.mTemplateBundleInfoList.isEmpty())) {
      return 0;
    }
    return this.mTemplateBundleInfoList.size();
  }
  
  public void onBindViewHolder(EmojiFragment.TemplateListAdapter.TemplateItemVH paramTemplateItemVH, int paramInt)
  {
    EmojiFragment.TemplateInfo localTemplateInfo = (EmojiFragment.TemplateInfo)this.mTemplateBundleInfoList.get(paramInt);
    if (localTemplateInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramTemplateItemVH, paramInt, getItemId(paramInt));
      return;
      EmojiFragment.TempListItem localTempListItem = paramTemplateItemVH.tempListItem;
      if (localTempListItem != null)
      {
        EmojiFragment.access$500(this.this$0).put(localTemplateInfo.rId, EmojiFragment.TempListItem.access$200(localTempListItem));
        localTempListItem.setData(localTemplateInfo);
      }
    }
  }
  
  public EmojiFragment.TemplateListAdapter.TemplateItemVH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new EmojiFragment.TemplateListAdapter.TemplateItemVH(this, new EmojiFragment.TempListItem(this.this$0, this.context));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TemplateListAdapter
 * JD-Core Version:    0.7.0.1
 */