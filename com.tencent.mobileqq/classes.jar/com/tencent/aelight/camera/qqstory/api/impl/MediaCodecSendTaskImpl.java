package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.MediaCodecSendTask;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;

public class MediaCodecSendTaskImpl
  implements IMediaCodecSendTask
{
  VideoSendPublicParam createParam(VideoSendPublicParamBase paramVideoSendPublicParamBase)
  {
    VideoSendPublicParam localVideoSendPublicParam = new VideoSendPublicParam();
    if (paramVideoSendPublicParamBase == null) {
      return localVideoSendPublicParam;
    }
    localVideoSendPublicParam.mContext = paramVideoSendPublicParamBase.mContext;
    localVideoSendPublicParam.mVideoCacheDir = paramVideoSendPublicParamBase.mVideoCacheDir;
    localVideoSendPublicParam.mEncodeMode = paramVideoSendPublicParamBase.mEncodeMode;
    localVideoSendPublicParam.mVideoFilePath = paramVideoSendPublicParamBase.mVideoFilePath;
    localVideoSendPublicParam.mThumbFilePath = paramVideoSendPublicParamBase.mThumbFilePath;
    localVideoSendPublicParam.mThumbWidth = paramVideoSendPublicParamBase.mThumbWidth;
    localVideoSendPublicParam.mThumbHeight = paramVideoSendPublicParamBase.mThumbHeight;
    localVideoSendPublicParam.fakeVid = paramVideoSendPublicParamBase.fakeVid;
    localVideoSendPublicParam.recordTime = paramVideoSendPublicParamBase.recordTime;
    localVideoSendPublicParam.mUserCallBack = paramVideoSendPublicParamBase.mUserCallBack;
    localVideoSendPublicParam.mContent = paramVideoSendPublicParamBase.mContent;
    localVideoSendPublicParam.mPriv = paramVideoSendPublicParamBase.mPriv;
    localVideoSendPublicParam.mPrivUinList = paramVideoSendPublicParamBase.mPrivUinList;
    localVideoSendPublicParam.mEnableEditVideo = paramVideoSendPublicParamBase.mEnableEditVideo;
    localVideoSendPublicParam.topicSyncQzone = paramVideoSendPublicParamBase.topicSyncQzone;
    localVideoSendPublicParam.fontId = paramVideoSendPublicParamBase.fontId;
    localVideoSendPublicParam.fontFormatType = paramVideoSendPublicParamBase.fontFormatType;
    localVideoSendPublicParam.fontUrl = paramVideoSendPublicParamBase.fontUrl;
    localVideoSendPublicParam.superFontId = paramVideoSendPublicParamBase.superFontId;
    localVideoSendPublicParam.superFontInfo = paramVideoSendPublicParamBase.superFontInfo;
    localVideoSendPublicParam.generateGif = paramVideoSendPublicParamBase.generateGif;
    localVideoSendPublicParam.timerDelete = paramVideoSendPublicParamBase.timerDelete;
    localVideoSendPublicParam.isUploadOrigin = paramVideoSendPublicParamBase.isUploadOrigin;
    localVideoSendPublicParam.entrySource = paramVideoSendPublicParamBase.entrySource;
    localVideoSendPublicParam.mUin = paramVideoSendPublicParamBase.mUin;
    localVideoSendPublicParam.mUinType = paramVideoSendPublicParamBase.mUinType;
    localVideoSendPublicParam.mTroopUin = paramVideoSendPublicParamBase.mTroopUin;
    return localVideoSendPublicParam;
  }
  
  public void execute(VideoSendPublicParamBase paramVideoSendPublicParamBase)
  {
    new MediaCodecSendTask(createParam(paramVideoSendPublicParamBase)).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.MediaCodecSendTaskImpl
 * JD-Core Version:    0.7.0.1
 */