package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class IDataProvider$Data
{
  public ErrorMessage a;
  public List<IDataProvider.GroupInfo> a;
  public boolean a;
  public ErrorMessage b;
  public boolean b;
  public boolean c;
  
  public IDataProvider$Data()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    return "Data{upErrorMessage=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", isUpEnd=" + this.jdField_a_of_type_Boolean + ", mGroupInfoList=" + this.jdField_a_of_type_JavaUtilList + ", isDownEnd=" + this.jdField_b_of_type_Boolean + ", isFastData=" + this.c + ", downErrorMessage=" + this.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data
 * JD-Core Version:    0.7.0.1
 */