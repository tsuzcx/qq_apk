package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.videoupload.meta.LinkRichObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;

class StoryVideoUploadTask$5
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$5(StoryVideoUploadTask paramStoryVideoUploadTask, VideoLinkInfo paramVideoLinkInfo, LinkRichObject paramLinkRichObject) {}
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaLinkRichObject.a == 0) {}
    for (int i = 2;; i = 3)
    {
      paramUploadObject.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaLinkRichObject.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.c = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadMetaLinkRichObject.c;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.5
 * JD-Core Version:    0.7.0.1
 */