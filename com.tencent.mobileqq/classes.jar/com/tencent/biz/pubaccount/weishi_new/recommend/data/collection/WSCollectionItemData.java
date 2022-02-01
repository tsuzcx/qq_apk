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
    if (this.jdField_a_of_type_UserGrowthStCollection != null) {
      return this.jdField_a_of_type_UserGrowthStCollection.cover;
    }
    return "";
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_UserGrowthStCollection != null) {
      return this.jdField_a_of_type_UserGrowthStCollection.name;
    }
    return "";
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_UserGrowthStCollection != null) {
      return this.jdField_a_of_type_UserGrowthStCollection.subTitle;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData
 * JD-Core Version:    0.7.0.1
 */