package com.tencent.mobileqq.arcard;

import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.StoryVideoExtRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.UploadPicExtInfo;

public abstract interface ARRelationShipFileUpload$ARRelationShipFileUploadCallBack
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, ARRelationShipUploadRusult.StoryVideoExtRsp paramStoryVideoExtRsp);
  
  public abstract void a(String paramString, ARRelationShipUploadRusult.UploadPicExtInfo paramUploadPicExtInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipFileUploadCallBack
 * JD-Core Version:    0.7.0.1
 */