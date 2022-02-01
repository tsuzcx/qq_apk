package com.tencent.mobileqq.activity.aio;

import NS_GROUP_COUNT.mobile_batch_get_profile_count_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.Map;

public class QzoneTroopReddotRequest
  extends QZoneCommonRequest
{
  private int a;
  public JceStruct a;
  
  public QzoneTroopReddotRequest(ArrayList<Long> paramArrayList, Map<String, String> paramMap)
  {
    mobile_batch_get_profile_count_req localmobile_batch_get_profile_count_req = new mobile_batch_get_profile_count_req();
    localmobile_batch_get_profile_count_req.vecUinList = paramArrayList;
    localmobile_batch_get_profile_count_req.extendinfo = paramMap;
    this.jdField_a_of_type_ComQqTafJceJceStruct = localmobile_batch_get_profile_count_req;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.Feeds.BatchGetProfileCount";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public int getType()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String uniKey()
  {
    return "BatchGetProfileCount";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.QzoneTroopReddotRequest
 * JD-Core Version:    0.7.0.1
 */