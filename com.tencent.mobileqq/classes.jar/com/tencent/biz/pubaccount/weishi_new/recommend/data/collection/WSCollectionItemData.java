package com.tencent.biz.pubaccount.weishi_new.recommend.data.collection;

import UserGrowth.stCollection;

public class WSCollectionItemData
  implements IWSCollectionData<stCollection>
{
  private final stCollection a;
  private final int b;
  
  public WSCollectionItemData(stCollection paramstCollection, int paramInt)
  {
    this.a = paramstCollection;
    this.b = paramInt;
  }
  
  public String a()
  {
    stCollection localstCollection = this.a;
    if (localstCollection != null) {
      return localstCollection.cover;
    }
    return "";
  }
  
  public String b()
  {
    stCollection localstCollection = this.a;
    if (localstCollection != null) {
      return localstCollection.name;
    }
    return "";
  }
  
  public String c()
  {
    stCollection localstCollection = this.a;
    if (localstCollection != null) {
      return localstCollection.subTitle;
    }
    return "";
  }
  
  public stCollection d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData
 * JD-Core Version:    0.7.0.1
 */