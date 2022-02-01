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
    String str = "";
    if (paramStringBuilder.length() > 1)
    {
      str = paramStringBuilder.substring(0, paramStringBuilder.length() - 1);
      WSLog.g("WSGridDataFilter", "[getRepetitiveFeedIds] repetitive feedIds:" + str);
    }
    return str;
  }
  
  private String a(HashSet<String> paramHashSet)
  {
    Object localObject = "";
    if (paramHashSet.size() > 0)
    {
      localObject = new StringBuilder();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        ((StringBuilder)localObject).append((String)paramHashSet.next()).append("_");
      }
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
      WSLog.g("WSGridDataFilter", "[getRepetitiveTraceIds] repetitive traceIds:" + (String)localObject);
    }
    return localObject;
  }
  
  private boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramstSimpleMetaFeed != null)
    {
      bool1 = bool2;
      if (paramstSimpleMetaFeed.video_type == 9)
      {
        paramstSimpleMetaFeed = paramstSimpleMetaFeed.cardInfo;
        if (paramstSimpleMetaFeed != null)
        {
          localObject = paramstSimpleMetaFeed.collectionCardInfo;
          if (localObject != null)
          {
            paramstSimpleMetaFeed = ((stCollectionCardInfo)localObject).collectionList;
            if (paramstSimpleMetaFeed != null) {
              break label56;
            }
          }
        }
        bool1 = true;
      }
    }
    label56:
    int i;
    do
    {
      return bool1;
      localObject = ((stCollectionCardInfo)localObject).title;
      i = paramstSimpleMetaFeed.size();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      bool1 = bool2;
    } while (i > 0);
    return true;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<stSimpleMetaFeed> paramArrayList, String paramString)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      this.a.clear();
    }
    Object localObject = new ArrayList(paramArrayList);
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
      if (a(localstSimpleMetaFeed))
      {
        paramArrayList.remove(localstSimpleMetaFeed);
      }
      else if (this.a.contains(localstSimpleMetaFeed.id))
      {
        WSLog.d("WSGridDataFilter", "[filterRepetitiveFeedList] removeFromList feedId:" + localstSimpleMetaFeed.id + ", traceId:" + localstSimpleMetaFeed.traceId + ", title:" + localstSimpleMetaFeed.feed_desc);
        localStringBuilder.append(localstSimpleMetaFeed.id).append("_");
        localHashSet.add(localstSimpleMetaFeed.traceId);
        paramArrayList.remove(localstSimpleMetaFeed);
      }
      else if (!TextUtils.isEmpty(localstSimpleMetaFeed.id))
      {
        WSLog.e("WSGridDataFilter", "[filterRepetitiveFeedList] addToHashSet feedId:" + localstSimpleMetaFeed.id + ", traceId:" + localstSimpleMetaFeed.traceId + ", title:" + localstSimpleMetaFeed.feed_desc);
        this.a.add(localstSimpleMetaFeed.id);
      }
    }
    WSGridBeaconReport.a(paramBoolean1, paramBoolean2, 0, a(localStringBuilder), a(localHashSet), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataFilter
 * JD-Core Version:    0.7.0.1
 */