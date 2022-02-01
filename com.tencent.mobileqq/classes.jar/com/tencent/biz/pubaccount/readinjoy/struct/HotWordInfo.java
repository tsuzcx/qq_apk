package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class HotWordInfo
{
  public List<HotWordItem> a;
  
  public static HotWordInfo a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    HotWordInfo localHotWordInfo = new HotWordInfo();
    if ((paramHotWordInfo != null) && (paramHotWordInfo.rpt_hot_word_item.has()))
    {
      localHotWordInfo.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        HotWordItem localHotWordItem = HotWordItem.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localHotWordInfo.a.add(localHotWordItem);
      }
    }
    return localHotWordInfo;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    if ((this.a != null) && (this.a.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((HotWordItem)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set(localArrayList);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo
 * JD-Core Version:    0.7.0.1
 */