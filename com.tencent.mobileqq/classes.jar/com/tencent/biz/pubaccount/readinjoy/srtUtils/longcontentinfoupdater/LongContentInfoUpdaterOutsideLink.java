package com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.OutsideLinkInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterOutsideLink;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterOutsideLink
  extends LongContentInfoUpdater
{
  protected void a()
  {
    Object localObject = a();
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).a = 19191924;
    }
    localObject = a();
    if (localObject != null) {
      ((SocializeFeedsInfo.PGCFeedsInfo)localObject).a = true;
    }
    BaseArticleInfo localBaseArticleInfo = a();
    localObject = a();
    if (localObject != null)
    {
      localObject = ((SocializeFeedsInfo.LongContentInfo)localObject).a;
      if (localObject == null) {}
    }
    for (localObject = ((SocializeFeedsInfo.OutsideLinkInfo)localObject).a;; localObject = null)
    {
      localBaseArticleInfo.mTitle = ((String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater.LongContentInfoUpdaterOutsideLink
 * JD-Core Version:    0.7.0.1
 */