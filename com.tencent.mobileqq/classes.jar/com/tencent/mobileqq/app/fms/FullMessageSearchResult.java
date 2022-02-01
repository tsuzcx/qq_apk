package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Iterator;
import java.util.List;

public class FullMessageSearchResult
{
  public List<FullMessageSearchResult.SearchResultItem> a;
  public int b = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FullMessageSearchResult:");
    Object localObject = this.a;
    if (localObject == null)
    {
      localStringBuilder.append("null");
      return localStringBuilder.toString();
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FullMessageSearchResult.SearchResultItem localSearchResultItem = (FullMessageSearchResult.SearchResultItem)((Iterator)localObject).next();
      localStringBuilder.append("(");
      localStringBuilder.append(localSearchResultItem.user.uin);
      localStringBuilder.append(",");
      List localList = localSearchResultItem.secondPageList;
      int j = 0;
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localSearchResultItem.secondPageList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",");
      if (localSearchResultItem.secondPageMessageUniseq == null) {
        i = j;
      } else {
        i = localSearchResultItem.secondPageMessageUniseq.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(")");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" searchFinFlag=");
    ((StringBuilder)localObject).append(this.b);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchResult
 * JD-Core Version:    0.7.0.1
 */