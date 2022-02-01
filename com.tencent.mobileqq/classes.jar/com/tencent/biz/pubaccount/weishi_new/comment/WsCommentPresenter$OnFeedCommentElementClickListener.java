package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import java.net.URLDecoder;

class WsCommentPresenter$OnFeedCommentElementClickListener
  implements OnCommentElementClickListener
{
  WsCommentPresenter$OnFeedCommentElementClickListener(WsCommentPresenter paramWsCommentPresenter) {}
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema, int paramInt)
  {
    if (paramstSchema != null)
    {
      switch (paramstSchema.type)
      {
      default: 
        return;
      case 1: 
        paramstSimpleMetaPerson = paramstSchema.miniAppSchema;
        WSMiniAppHelper.a().a(WsCommentPresenter.a(this.a), paramstSimpleMetaPerson);
        WSLog.c("weishi", "miniShema is :" + paramstSimpleMetaPerson);
        WsCommentPresenter.a(this.a, 1000007, paramInt);
        return;
      case 2: 
        a(paramstSchema.schema, paramInt);
        return;
      }
      paramstSchema = paramstSchema.H5Url;
      WSLog.c("weishi", "h5Url is :" + paramstSchema);
      if (WsCommentPresenter.a(this.a) != null)
      {
        paramstSimpleMetaPerson = new Bundle();
        paramstSimpleMetaPerson.putBoolean("injectrecommend", false);
        paramstSchema = URLDecoder.decode(paramstSchema);
        QzoneLiveVideoInterface.forwardToBrowser(WsCommentPresenter.a(this.a), paramstSchema, 0, paramstSimpleMetaPerson, null);
        WSLog.b("comment", "评论头像点击:" + paramstSchema);
      }
      for (;;)
      {
        WsCommentPresenter.a(this.a, 1000001, paramInt);
        return;
        WSLog.c("comment", "context 不是Activity");
      }
    }
    paramstSchema = "";
    if (paramstSimpleMetaPerson != null) {
      paramstSchema = paramstSimpleMetaPerson.schema_url;
    }
    a(paramstSchema, paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "weishi://profile?person_id=" + WeishiUtils.d();
    }
    for (;;)
    {
      WSDownloadParams localWSDownloadParams = WsCommentPresenter.a(this.a, paramString, 13);
      if (WeishiGuideUtils.a(WsCommentPresenter.a(this.a)))
      {
        WeishiScehmeUtil.a(WsCommentPresenter.a(this.a), "biz_src_jc_gzh_weishi", paramString, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
        WsCommentPresenter.a(this.a, 1000003, paramInt);
        return;
      }
      WeishiDownloadUtil.a(WsCommentPresenter.a(this.a), localWSDownloadParams, true);
      WsCommentPresenter.a(this.a, 1000002, paramInt);
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    WSDownloadParams localWSDownloadParams;
    switch (paramInt1)
    {
    default: 
      return;
    case 12: 
      paramView = (String)paramObject;
      paramObject = "weishi://feed?feed_id=" + paramView;
      localWSDownloadParams = WsCommentPresenter.a(this.a, paramObject, 14);
      paramView = WSCommentBeaconReport.c(this.a.a());
      if (TextUtils.equals(this.a.a(), "focus")) {
        paramView = paramView + WsCommentPresenter.a(this.a);
      }
      break;
    }
    for (;;)
    {
      if (WeishiGuideUtils.a(WsCommentPresenter.a(this.a)))
      {
        WeishiScehmeUtil.a(WsCommentPresenter.a(this.a), "biz_src_jc_gzh_weishi", paramObject, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
        WSCommentBeaconReport.a(this.a.a(), this.a.b(), paramView, 1000003, WsCommentPresenter.a(this.a));
        return;
      }
      WeishiDownloadUtil.a(WsCommentPresenter.a(this.a), localWSDownloadParams);
      WSCommentBeaconReport.a(this.a.a(), this.a.b(), paramView, 1000002, WsCommentPresenter.a(this.a));
      return;
      WsCommentPresenter.a(this.a, 1000001, 6);
      if (!(paramObject instanceof stSimpleMetaPerson)) {
        break;
      }
      a((stSimpleMetaPerson)paramObject, ((stSimpleMetaPerson)paramObject).avatarSchema, 6);
      return;
      paramView = ((stSimpleMetaPerson)paramObject).avatarSchema;
      a((stSimpleMetaPerson)paramObject, paramView, 2);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramObject = (Object[])paramObject;
      if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
        break;
      }
      paramView = (stSimpleMetaReply)paramObject[1];
      paramObject = (stSimpleMetaComment)paramObject[0];
      if (paramView.poster != null)
      {
        paramObject = paramView.poster.avatarSchema;
        a(paramView.poster, paramObject, 2);
        return;
      }
      a(null, null, 2);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      WsCommentPresenter.a(this.a, paramView, null, 0);
      WsCommentPresenter.a(this.a, 1000001, 1);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramObject = (Object[])paramObject;
      if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject[0];
      paramObject = (stSimpleMetaReply)paramObject[1];
      WsCommentPresenter.a(this.a, paramView, paramObject, 0);
      WsCommentPresenter.a(this.a, 1000001, 1);
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      WsCommentPresenter.a(this.a).a(paramView);
      WsCommentPresenter.a(this.a, 1000001, 5);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramView = (Object[])paramObject;
      if ((paramView.length <= 1) || (paramView[0] == null)) {
        break;
      }
      paramObject = (stSimpleMetaComment)paramView[0];
      paramInt1 = WsCommentPresenter.a(this.a).a(paramObject);
      if ((paramInt1 < 0) || (paramView[1] == null)) {
        break;
      }
      int i = ((Integer)paramView[1]).intValue();
      this.a.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
      return;
      if (!(paramObject instanceof stSimpleMetaComment)) {
        break;
      }
      paramView = (stSimpleMetaComment)paramObject;
      this.a.a().a(WsCommentPresenter.a(this.a), paramView);
      this.a.jdField_a_of_type_Boolean = true;
      WSLog.c("comment", "3 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ",clickPosition:" + paramInt2 + ", hashCode" + this.a.hashCode());
      paramObject = this.a;
      if (paramView.isDing == 0) {}
      for (paramInt1 = 1001002;; paramInt1 = 1001001)
      {
        WsCommentPresenter.a(paramObject, paramInt1, 3);
        if (!(WsCommentPresenter.a(this.a) instanceof WSFollowFragment)) {
          break;
        }
        paramInt1 = paramInt2 - 1;
        paramView = ((WSFollowFragment)WsCommentPresenter.a(this.a)).a().a().findViewHolderForAdapterPosition(WsCommentPresenter.b(this.a));
        if (!(paramView instanceof WSFollowFeedHolder)) {
          break;
        }
        paramView = (WSFollowFeedHolder)paramView;
        WSLog.c("comment", "***getPosition():" + WsCommentPresenter.b(this.a) + ",realPosition:" + paramInt1);
        paramView.a(paramInt1);
        return;
      }
      if (!(paramObject instanceof Object[])) {
        break;
      }
      paramView = (Object[])paramObject;
      if ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null)) {
        break;
      }
      paramObject = (stSimpleMetaComment)paramView[0];
      this.a.a().a(WsCommentPresenter.a(this.a), paramObject, (stSimpleMetaReply)paramView[1]);
      this.a.jdField_a_of_type_Boolean = true;
      WSLog.c("comment", "4 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ", hashCode" + this.a.hashCode());
      WsCommentPresenter.a(this.a, 1000001, 3);
      return;
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.OnFeedCommentElementClickListener
 * JD-Core Version:    0.7.0.1
 */