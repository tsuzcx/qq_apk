package com.tencent.biz.pubaccount.weishi_new.recommend.data.collection;

import UserGrowth.stCollection;

public class WSCollectionItemData
  implements IWSCollectionData<stCollection>
{
  private final int jdField_a_of_type_Int;
  private final stCollection jdField_a_of_type_UserGrowthStCollection;
  
  public WSCollectionItemData(stCollection paramstCollection, int paramInt)
  {
    this.jdField_a_of_type_UserGrowthStCollection = paramstCollection;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public stCollection a()
  {
    return this.jdField_a_of_type_UserGrowthStCollection;
  }
  
  public String a()
  {
    stCollection localstCollection = this.jdField_a_of_type_UserGrowthStCollection;
    if (localstCollection != null) {
      return localstCollection.cover;
    }
    return "";
  }
  
  public String b()
  {
    stCollection localstCollection = this.jdField_a_of_type_UserGrowthStCollection;
    if (localstCollection != null) {
      return localstCollection.name;
    }
    return "";
  }
  
  public String c()
  {
    stCollection localstCollection = this.jdField_a_of_type_UserGrowthStCollection;
    if (localstCollection != null) {
      return localstCollection.subTitle;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData
 * JD-Core Version:    0.7.0.1
 */