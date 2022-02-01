package com.tencent.mobileqq.apollo.store.openbox;

import android.text.TextUtils;

public class ApolloBoxData$ApolloBoxDataItem
  implements Comparable<ApolloBoxDataItem>
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public short b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e = -1;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g = 0;
  public String g;
  public int h;
  
  public int a(ApolloBoxDataItem paramApolloBoxDataItem)
  {
    if (paramApolloBoxDataItem == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    if (bool == paramApolloBoxDataItem.jdField_a_of_type_Boolean) {
      return -(int)(this.c - paramApolloBoxDataItem.c);
    }
    if (bool) {
      return -1;
    }
    return 0;
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Long == this.b) || ((!TextUtils.isEmpty(paramString)) && (paramString.equals(String.valueOf(this.jdField_a_of_type_Long))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloBoxData.ApolloBoxDataItem
 * JD-Core Version:    0.7.0.1
 */