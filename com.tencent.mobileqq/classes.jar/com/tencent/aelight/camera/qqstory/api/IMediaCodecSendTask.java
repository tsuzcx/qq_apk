package com.tencent.aelight.camera.qqstory.api;

import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMediaCodecSendTask
  extends QRouteApi
{
  public abstract void execute(VideoSendPublicParamBase paramVideoSendPublicParamBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask
 * JD-Core Version:    0.7.0.1
 */