package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDataManager;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class OnWeChatVideoWatchLaterClickListener
  implements ViewBase.OnClickListener
{
  BaseArticleInfo a;
  
  public OnWeChatVideoWatchLaterClickListener(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a = paramBaseArticleInfo;
  }
  
  public static List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> a(BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = new RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem();
    localWeChatVideoArticleItem.jdField_a_of_type_Long = paramBaseArticleInfo.mFeedId;
    localWeChatVideoArticleItem.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
    localWeChatVideoArticleItem.jdField_a_of_type_Int = paramInt1;
    localWeChatVideoArticleItem.b = paramInt2;
    localArrayList.add(localWeChatVideoArticleItem);
    return localArrayList;
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo != null)
    {
      if (paramBaseArticleInfo.mPartnerAccountInfo != null)
      {
        paramBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.set(1);
        paramBaseArticleInfo.invalidateProteusTemplateBean();
      }
    }
    else {
      return;
    }
    paramBaseArticleInfo.isWatchLater = true;
    paramBaseArticleInfo.invalidateProteusTemplateBean();
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2)
  {
    if (a(paramBaseArticleInfo))
    {
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "requestWechatVideoSeelaterProgress: " + paramBaseArticleInfo.innerUniqueID + " currentPlayTime: " + paramInt1 + " duration: " + paramInt2);
      ReadInJoyLogicEngine.a().a().a(a(paramBaseArticleInfo, paramInt1, paramInt2));
      return;
    }
    QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "requestWechatVideoSeelaterProgress: null");
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while (((paramBaseArticleInfo.mPartnerAccountInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() != 1)) && (!paramBaseArticleInfo.isWatchLater)) {
      return false;
    }
    return true;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a == null)
    {
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "articleInfo is null");
      return;
    }
    if (a(this.a))
    {
      QLog.d("OnWeChatVideoSeeLaterClickListener", 1, "Watch see later already clicked!");
      return;
    }
    a(this.a);
    ReadInJoyLogicEngine.a().c((ArticleInfo)this.a);
    ReadInJoyLogicEngineEventDispatcher.a().c();
    long l1 = VideoDataManager.a.a(this.a.innerUniqueID);
    long l2 = VideoDataManager.a.b(this.a.innerUniqueID);
    a(this.a, (int)(l1 / 1000L), (int)(l2 / 1000L));
    QQToast.a(BaseApplicationImpl.getApplication(), 0, HardCodeUtil.a(2131718616), 0).a();
    VideoReportUtil.a.a((ArticleInfo)this.a, l1, null);
    RIJFeedsDynamicInsertController.a.a(this.a, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SEE_LATER, 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnWeChatVideoWatchLaterClickListener
 * JD-Core Version:    0.7.0.1
 */