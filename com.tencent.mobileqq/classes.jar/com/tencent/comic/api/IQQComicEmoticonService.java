package com.tencent.comic.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"", "tool"})
public abstract interface IQQComicEmoticonService
  extends IRuntimeService
{
  public abstract void uploadComicEmoticon(Bundle paramBundle, IQQComicEmoticonService.IQQComicEmoUploadCallback paramIQQComicEmoUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicEmoticonService
 * JD-Core Version:    0.7.0.1
 */