package com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater;

import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterVideoBigPic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterVideoBigPic
  extends LongContentInfoUpdater
{
  protected void a()
  {
    Object localObject = a();
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).a = 6;
    }
    localObject = a();
    if (localObject != null) {
      ((SocializeFeedsInfo.PGCFeedsInfo)localObject).a = true;
    }
    localObject = a();
    if (localObject != null)
    {
      localObject = ((SocializeFeedsInfo.LongContentInfo)localObject).a;
      if (localObject != null)
      {
        a().mTitle = ((SocializeFeedsInfo.PGCVideoInfo)localObject).g;
        a().mVideoVid = ((SocializeFeedsInfo.PGCVideoInfo)localObject).e;
      }
    }
    try
    {
      localObject = a();
      if (localObject != null)
      {
        localObject = ((SocializeFeedsInfo.LongContentInfo)localObject).a;
        if (localObject != null)
        {
          localObject = ((SocializeFeedsInfo.PGCVideoInfo)localObject).d;
          if (localObject != null) {
            a().mVideoCoverUrl = new URL((String)localObject);
          }
        }
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater.LongContentInfoUpdaterVideoBigPic
 * JD-Core Version:    0.7.0.1
 */