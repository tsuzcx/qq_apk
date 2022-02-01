package com.tencent.mobileqq.apollo.store.openbox;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ApolloBoxData
{
  public String a;
  public String b;
  public boolean c;
  public String d;
  public long e;
  public long f;
  public long g;
  public String h;
  public String i;
  public int j = -1;
  public int k;
  public final HashMap<Integer, ApolloBoxData.BoxCardListSummary> l = new HashMap();
  public final List<ApolloBoxData.BoxCardListSummary> m = new ArrayList();
  public List<ApolloBoxData.ApolloBoxDataItem> n;
  public List<ApolloBoxData.ApolloBoxDataItem> o;
  
  public static String a(int paramInt)
  {
    if (paramInt > 999999)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(999999));
      localStringBuilder.append("+");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt > 99999)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(99999));
      localStringBuilder.append("+");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt > 9999)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(9999));
      localStringBuilder.append("+");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      Object localObject = this.n;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = this.n.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = (ApolloBoxData.ApolloBoxDataItem)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(this.a)) && (this.a.equals(String.valueOf(localApolloBoxDataItem.a))))
          {
            ApolloBoxData.BoxCardListSummary localBoxCardListSummary;
            if (localApolloBoxDataItem.f <= 4)
            {
              localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.l.get(Integer.valueOf(3));
              if (localBoxCardListSummary != null)
              {
                localBoxCardListSummary.d += 1;
                this.k += 1;
              }
            }
            else
            {
              localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.l.get(Short.valueOf(localApolloBoxDataItem.f));
              if (localBoxCardListSummary != null)
              {
                localBoxCardListSummary.d += localApolloBoxDataItem.s;
                this.k += localApolloBoxDataItem.s;
              }
            }
            if (this.o == null) {
              this.o = new ArrayList();
            }
            this.o.add(localApolloBoxDataItem);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloBoxData
 * JD-Core Version:    0.7.0.1
 */