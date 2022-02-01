package com.tencent.biz.qqstory.troop.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync;
import java.util.List;

public class TroopStoryGroupInfoListSynchronizer
  extends BaseVidListPlayingListSync
{
  VidToGroupInfoPuller a;
  public List<String> a;
  String b;
  public boolean b;
  
  protected VidToVideoInfoPuller a()
  {
    return null;
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller = new VidToGroupInfoPuller(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a()) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a(this.jdField_a_of_type_JavaUtilList, new ErrorMessage(), false, false)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a();
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryGroupInfoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */