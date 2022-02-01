package com.tencent.mobileqq.apollo.store.openbox;

import android.text.TextUtils;

public class ApolloBoxData$ApolloBoxDataItem
  implements Comparable<ApolloBoxDataItem>
{
  public long a;
  public long b;
  public boolean c;
  public boolean d;
  public long e;
  public short f;
  public int g;
  public String h;
  public String i;
  public String j;
  public short k;
  public String l;
  public int m;
  public int n;
  public int o;
  public int p = -1;
  public long q;
  public long r;
  public int s;
  public int t = 0;
  public String u;
  public String v;
  public String w;
  public int x;
  
  public int a(ApolloBoxDataItem paramApolloBoxDataItem)
  {
    if (paramApolloBoxDataItem == null) {
      return -1;
    }
    boolean bool = this.c;
    if (bool == paramApolloBoxDataItem.c) {
      return -(int)(this.e - paramApolloBoxDataItem.e);
    }
    if (bool) {
      return -1;
    }
    return 0;
  }
  
  public boolean a(String paramString)
  {
    return (this.a == this.b) || ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.a))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloBoxData.ApolloBoxDataItem
 * JD-Core Version:    0.7.0.1
 */