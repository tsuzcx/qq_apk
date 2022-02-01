package com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterVideoSmallPic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterVideoSmallPic
  extends LongContentInfoUpdater
{
  protected void a()
  {
    SocializeFeedsInfo.LongContentInfo localLongContentInfo1 = null;
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).a = 1;
    }
    Object localObject2 = a();
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((SocializeFeedsInfo.LongContentInfo)localObject1).a;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((SocializeFeedsInfo.PGCVideoInfo)localObject1).g;; localObject1 = null)
    {
      ((BaseArticleInfo)localObject2).mTitle = ((String)localObject1);
      localObject2 = a();
      if (localObject2 != null)
      {
        ((SocializeFeedsInfo.PGCFeedsInfo)localObject2).a = true;
        SocializeFeedsInfo.LongContentInfo localLongContentInfo2 = a();
        localObject1 = localLongContentInfo1;
        if (localLongContentInfo2 != null) {
          localObject1 = localLongContentInfo2.a;
        }
        ((SocializeFeedsInfo.PGCFeedsInfo)localObject2).b = new ArrayList();
        ((SocializeFeedsInfo.PGCFeedsInfo)localObject2).b.add(localObject1);
      }
      try
      {
        localObject1 = a();
        localLongContentInfo1 = a();
        if (localLongContentInfo1 == null) {
          Intrinsics.throwNpe();
        }
        ((BaseArticleInfo)localObject1).mSinglePicture = new URL(localLongContentInfo1.a.d);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater.LongContentInfoUpdaterVideoSmallPic
 * JD-Core Version:    0.7.0.1
 */