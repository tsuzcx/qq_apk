package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.manager.Manager;

public class ApolloRecentManager
  implements Manager
{
  public List<ApolloActionRecentData> a = Collections.synchronizedList(new ArrayList());
  public List<ApolloActionRecentData> b = Collections.synchronizedList(new ArrayList());
  private QQAppInterface c;
  
  public ApolloRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.a = ApolloDaoManagerServiceImpl.getRecentData(paramQQAppInterface, "recent_c2c");
    this.b = ApolloDaoManagerServiceImpl.getRecentData(paramQQAppInterface, "recent_troop");
    if (this.a == null) {
      this.a = Collections.synchronizedList(new ArrayList());
    }
    if (this.b == null) {
      this.b = Collections.synchronizedList(new ArrayList());
    }
    int i;
    if (this.a.size() > 8)
    {
      i = this.a.size();
      paramQQAppInterface = this.a;
      this.a = paramQQAppInterface.subList(i - 8, paramQQAppInterface.size());
    }
    if (this.b.size() > 8)
    {
      i = this.b.size();
      paramQQAppInterface = this.b;
      this.b = paramQQAppInterface.subList(i - 8, paramQQAppInterface.size());
    }
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecentManager
 * JD-Core Version:    0.7.0.1
 */