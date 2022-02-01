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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Data{upErrorMessage=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuilder.append(", isUpEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mGroupInfoList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", isDownEnd=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", isFastData=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", downErrorMessage=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data
 * JD-Core Version:    0.7.0.1
 */