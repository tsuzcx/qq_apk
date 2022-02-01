package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.util.List;
import tencent.im.oidb.gallery.gallery.CommentIcon;

public class AtlasCommentData
{
  public CommentData a;
  public List<gallery.CommentIcon> a;
  public boolean a;
  
  public AtlasCommentData()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (AtlasCommentData)paramObject;
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData.commentId.equals(paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData.commentId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.AtlasCommentData
 * JD-Core Version:    0.7.0.1
 */