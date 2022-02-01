package com.tencent.biz.qqcircle.datacenter.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.richframework.data.idata.IDataCenter;
import com.tencent.richframework.data.idata.IDataStore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QCircleBaseFeedStore
  implements IDataStore<FeedBlockData>
{
  private LinkedHashMap<String, FeedBlockData> a = new LinkedHashMap();
  private IDataCenter<FeedBlockData> b;
  private String c;
  
  public QCircleBaseFeedStore(IDataCenter<FeedBlockData> paramIDataCenter)
  {
    this.b = paramIDataCenter;
  }
  
  private void b(FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData == null) {
      return;
    }
    paramFeedBlockData = this.b.a(paramFeedBlockData);
    if (!TextUtils.isEmpty(paramFeedBlockData)) {
      this.a.remove(paramFeedBlockData);
    }
  }
  
  private void c(FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData == null) {
      return;
    }
    String str = this.b.a(paramFeedBlockData);
    if (!TextUtils.isEmpty(str)) {
      this.a.put(str, paramFeedBlockData);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    c(paramFeedBlockData);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(List<FeedBlockData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      c((FeedBlockData)paramList.next());
    }
  }
  
  public Map<String, FeedBlockData> b()
  {
    return this.a;
  }
  
  public void b(List<FeedBlockData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((FeedBlockData)paramList.next());
    }
  }
  
  public void c()
  {
    this.a.clear();
  }
  
  public boolean d()
  {
    return (b() != null) && (b().size() >= a());
  }
  
  public String e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.request.QCircleBaseFeedStore
 * JD-Core Version:    0.7.0.1
 */