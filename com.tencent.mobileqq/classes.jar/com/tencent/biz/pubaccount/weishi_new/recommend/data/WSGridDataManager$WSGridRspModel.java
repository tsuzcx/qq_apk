package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;

class WSGridDataManager$WSGridRspModel
{
  private ArrayList<stSimpleMetaFeed> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public ArrayList<stSimpleMetaFeed> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager.WSGridRspModel
 * JD-Core Version:    0.7.0.1
 */