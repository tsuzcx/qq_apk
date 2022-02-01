package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stCardInfo;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class WSGridDataFilter
{
  private final HashSet<String> a = new HashSet();
  
  private String a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() > 1)
    {
      paramStringBuilder = paramStringBuilder.substring(0, paramStringBuilder.length() - 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getRepetitiveFeedIds] repetitive feedIds:");
      localStringBuilder.append(paramStringBuilder);
      WSLog.g("WSGridDataFilter", localStringBuilder.toString());
      return paramStringBuilder;
    }
    return "";
  }
  
  private String a(HashSet<String> paramHashSet)
  {
    if (paramHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        localStringBuilder.append((String)paramHashSet.next());
        localStringBuilder.append("_");
      }
      paramHashSet = localStringBuilder.substring(0, localStringBuilder.length() - 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getRepetitiveTraceIds] repetitive traceIds:");
      localStringBuilder.append(paramHashSet);
      WSLog.g("WSGridDataFilter", localStringBuilder.toString());
      return paramHashSet;
    }
    return "";
  }
  
  private boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool = false;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.video_type == 9))
    {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.cardInfo;
      if (paramstSimpleMetaFeed != null)
      {
        Object localObject = paramstSimpleMetaFeed.collectionCardInfo;
        if (localObject != null)
        {
          paramstSimpleMetaFeed = ((stCollectionCardInfo)localObject).collectionList;
          if (paramstSimpleMetaFeed == null) {
            return true;
          }
          localObject = ((stCollectionCardInfo)localObject).title;
          int i = paramstSimpleMetaFeed.size();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (i <= 0)) {
            bool = true;
          }
          return bool;
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<stSimpleMetaFeed> paramArrayList, String paramString)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      this.a.clear();
    }
    Object localObject = new ArrayList(paramArrayList);
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
      if (a(localstSimpleMetaFeed))
      {
        paramArrayList.remove(localstSimpleMetaFeed);
      }
      else
      {
        StringBuilder localStringBuilder2;
        if (this.a.contains(localstSimpleMetaFeed.id))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[filterRepetitiveFeedList] removeFromList feedId:");
          localStringBuilder2.append(localstSimpleMetaFeed.id);
          localStringBuilder2.append(", traceId:");
          localStringBuilder2.append(localstSimpleMetaFeed.traceId);
          localStringBuilder2.append(", title:");
          localStringBuilder2.append(localstSimpleMetaFeed.feed_desc);
          WSLog.d("WSGridDataFilter", localStringBuilder2.toString());
          localStringBuilder1.append(localstSimpleMetaFeed.id);
          localStringBuilder1.append("_");
          localHashSet.add(localstSimpleMetaFeed.traceId);
          paramArrayList.remove(localstSimpleMetaFeed);
        }
        else if (!TextUtils.isEmpty(localstSimpleMetaFeed.id))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[filterRepetitiveFeedList] addToHashSet feedId:");
          localStringBuilder2.append(localstSimpleMetaFeed.id);
          localStringBuilder2.append(", traceId:");
          localStringBuilder2.append(localstSimpleMetaFeed.traceId);
          localStringBuilder2.append(", title:");
          localStringBuilder2.append(localstSimpleMetaFeed.feed_desc);
          WSLog.e("WSGridDataFilter", localStringBuilder2.toString());
          this.a.add(localstSimpleMetaFeed.id);
        }
      }
    }
    WSGridBeaconReport.a(paramBoolean1, paramBoolean2, 0, a(localStringBuilder1), a(localHashSet), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataFilter
 * JD-Core Version:    0.7.0.1
 */