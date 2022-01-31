package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync;
import java.util.List;

public class TroopStoryGroupInfoListSynchronizer
  extends BaseVidListPlayingListSync
{
  VidToGroupInfoPuller a;
  public List a;
  String b;
  public boolean b;
  
  protected int a()
  {
    return 0;
  }
  
  protected VidToVideoInfoPuller a()
  {
    return null;
  }
  
  public void a(String paramString, IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a()) && (TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) && (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.c();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller = new VidToGroupInfoPuller(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.b()) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a(this.jdField_a_of_type_JavaUtilList, new ErrorMessage(), false, false)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopModelVidToGroupInfoPuller.a();
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryGroupInfoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */