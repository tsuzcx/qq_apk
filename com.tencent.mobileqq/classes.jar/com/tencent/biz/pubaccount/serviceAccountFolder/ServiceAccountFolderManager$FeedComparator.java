package com.tencent.biz.pubaccount.serviceAccountFolder;

import java.util.Comparator;

public class ServiceAccountFolderManager$FeedComparator
  implements Comparator<ServiceAccountFolderFeed>
{
  public ServiceAccountFolderManager$FeedComparator(ServiceAccountFolderManager paramServiceAccountFolderManager) {}
  
  public int a(ServiceAccountFolderFeed paramServiceAccountFolderFeed1, ServiceAccountFolderFeed paramServiceAccountFolderFeed2)
  {
    long l1 = paramServiceAccountFolderFeed1.f;
    long l2 = paramServiceAccountFolderFeed2.f;
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.FeedComparator
 * JD-Core Version:    0.7.0.1
 */