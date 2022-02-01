package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class RelativeFeedsAdapter$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedListRsp>
{
  RelativeFeedsAdapter$1(RelativeFeedsAdapter paramRelativeFeedsAdapter, LoadInfo paramLoadInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.b.D().b(paramStGetFeedListRsp.livePageInfo.get());
      COMM.StCommonExt localStCommonExt;
      if ((!this.a.c()) && (!this.a.d()))
      {
        if (this.a.e())
        {
          paramBaseRequest = this.b;
          paramString = paramStGetFeedListRsp.hotLive.get();
          localStCommonExt = paramStGetFeedListRsp.extInfo;
          paramBoolean = bool1;
          if (paramStGetFeedListRsp.isFinish.get() == 1) {
            paramBoolean = true;
          }
          paramBaseRequest.b(paramString, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
        }
      }
      else
      {
        if ((paramStGetFeedListRsp.hotLive.get() != null) && (paramStGetFeedListRsp.hotLive.get().size() != 0))
        {
          if (RelativeFeedsAdapter.a(this.b) != null) {
            RelativeFeedsAdapter.a(this.b).b(false);
          }
        }
        else if (RelativeFeedsAdapter.a(this.b) != null)
        {
          this.b.b();
          RelativeFeedsAdapter.a(this.b).b(true);
        }
        paramBaseRequest = this.b;
        paramString = paramStGetFeedListRsp.hotLive.get();
        localStCommonExt = paramStGetFeedListRsp.extInfo;
        paramBoolean = bool2;
        if (paramStGetFeedListRsp.isFinish.get() == 1) {
          paramBoolean = true;
        }
        paramBaseRequest.a(paramString, localStCommonExt, paramBoolean, paramStGetFeedListRsp.adAttchInfo.get());
        this.b.b("share_key_continue_feeds", new BlockMerger.ShareData(paramStGetFeedListRsp.hotLive.get()));
      }
    }
    else
    {
      this.b.d(false);
      if (((this.a.c()) || (this.a.d())) && (RelativeFeedsAdapter.a(this.b) != null)) {
        RelativeFeedsAdapter.a(this.b).b(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */