package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class VidToVideoInfoPuller$1
  extends SimpleJob<Object>
{
  VidToVideoInfoPuller$1(VidToVideoInfoPuller paramVidToVideoInfoPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((MemoryManager)SuperManager.a(19)).b(this.a.i);
    this.a.a(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */