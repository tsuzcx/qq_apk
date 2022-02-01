package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Iterator;
import java.util.List;

public class FullMessageSearchResult
{
  public int a;
  public List<FullMessageSearchResult.SearchResultItem> a;
  
  public FullMessageSearchResult()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FullMessageSearchResult:");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localStringBuilder.append("null");
      return localStringBuilder.toString();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      FullMessageSearchResult.SearchResultItem localSearchResultItem = (FullMessageSearchResult.SearchResultItem)localIterator.next();
      localStringBuilder.append("(");
      localStringBuilder.append(localSearchResultItem.user.uin);
      localStringBuilder.append(",");
      if (localSearchResultItem.secondPageList == null)
      {
        i = 0;
        label96:
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        if (localSearchResultItem.secondPageMessageUniseq != null) {
          break label149;
        }
      }
      label149:
      for (int i = 0;; i = localSearchResultItem.secondPageMessageUniseq.size())
      {
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        break;
        i = localSearchResultItem.secondPageList.size();
        break label96;
      }
    }
    localStringBuilder.append(" searchFinFlag=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchResult
 * JD-Core Version:    0.7.0.1
 */