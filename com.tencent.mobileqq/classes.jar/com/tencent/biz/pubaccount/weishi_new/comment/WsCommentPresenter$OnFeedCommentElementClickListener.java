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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.net.URLDecoder;

class WsCommentPresenter$OnFeedCommentElementClickListener
  implements OnCommentElementClickListener
{
  WsCommentPresenter$OnFeedCommentElementClickListener(WsCommentPresenter paramWsCommentPresenter) {}
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema, int paramInt)
  {
    if (paramstSchema != null)
    {
      int i = paramstSchema.type;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramstSimpleMetaPerson = paramstSchema.H5Url;
          paramstSchema = new StringBuilder();
          paramstSchema.append("h5Url is :");
          paramstSchema.append(paramstSimpleMetaPerson);
          WSLog.c("weishi", paramstSchema.toString());
          if (WsCommentPresenter.a(this.a) != null)
          {
            paramstSchema = new Bundle();
            paramstSchema.putBoolean("injectrecommend", false);
            paramstSimpleMetaPerson = URLDecoder.decode(paramstSimpleMetaPerson);
            ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).forwardToBrowser(WsCommentPresenter.a(this.a), paramstSimpleMetaPerson, 0, paramstSchema, null);
            paramstSchema = new StringBuilder();
            paramstSchema.append("评论头像点击:");
            paramstSchema.append(paramstSimpleMetaPerson);
            WSLog.b("comment", paramstSchema.toString());
          }
          else
          {
            WSLog.c("comment", "context 不是Activity");
          }
          WsCommentPresenter.a(this.a, 1000001, paramInt);
          return;
        }
        a(paramstSchema.schema, paramInt);
        return;
      }
      paramstSimpleMetaPerson = paramstSchema.miniAppSchema;
      WSMiniAppHelper.a().a(WsCommentPresenter.a(this.a), paramstSimpleMetaPerson);
      paramstSchema = new StringBuilder();
      paramstSchema.append("miniShema is :");
      paramstSchema.append(paramstSimpleMetaPerson);
      WSLog.c("weishi", paramstSchema.toString());
      WsCommentPresenter.a(this.a, 1000007, paramInt);
      return;
    }
    if (paramstSimpleMetaPerson != null) {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema_url;
    } else {
      paramstSimpleMetaPerson = "";
    }
    a(paramstSimpleMetaPerson, paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("weishi://profile?person_id=");
      paramString.append(WeishiUtils.d());
      str = paramString.toString();
    }
    paramString = WsCommentPresenter.a(this.a, str, 13);
    if (WeishiGuideUtils.a(WsCommentPresenter.a(this.a)))
    {
      WeishiScehmeUtil.a(WsCommentPresenter.a(this.a), "biz_src_jc_gzh_weishi", str, paramString.mScene, paramString.mLinkStrategyType, paramString.mEventId);
      WsCommentPresenter.a(this.a, 1000003, paramInt);
      return;
    }
    WeishiDownloadUtil.a(WsCommentPresenter.a(this.a), paramString, true);
    WsCommentPresenter.a(this.a, 1000002, paramInt);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 77)
          {
            if (paramInt1 != 6)
            {
              if (paramInt1 != 7)
              {
                switch (paramInt1)
                {
                default: 
                  return;
                case 12: 
                  paramView = (String)paramObject;
                  paramObject = new StringBuilder();
                  paramObject.append("weishi://feed?feed_id=");
                  paramObject.append(paramView);
                  String str = paramObject.toString();
                  WSDownloadParams localWSDownloadParams = WsCommentPresenter.a(this.a, str, 14);
                  paramObject = WSCommentBeaconReport.c(this.a.a());
                  paramView = paramObject;
                  if (TextUtils.equals(this.a.a(), "focus"))
                  {
                    paramView = new StringBuilder();
                    paramView.append(paramObject);
                    paramView.append(WsCommentPresenter.a(this.a));
                    paramView = paramView.toString();
                  }
                  if (WeishiGuideUtils.a(WsCommentPresenter.a(this.a)))
                  {
                    WeishiScehmeUtil.a(WsCommentPresenter.a(this.a), "biz_src_jc_gzh_weishi", str, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
                    WSCommentBeaconReport.a(this.a.a(), this.a.b(), paramView, 1000003, WsCommentPresenter.a(this.a));
                    return;
                  }
                  WeishiDownloadUtil.a(WsCommentPresenter.a(this.a), localWSDownloadParams);
                  WSCommentBeaconReport.a(this.a.a(), this.a.b(), paramView, 1000002, WsCommentPresenter.a(this.a));
                  return;
                case 11: 
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
                  this.a.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt2, paramInt1 * -1 * i);
                  return;
                case 10: 
                  if (!(paramObject instanceof stSimpleMetaComment)) {
                    break;
                  }
                  paramView = (stSimpleMetaComment)paramObject;
                  WsCommentPresenter.a(this.a).a(paramView);
                  WsCommentPresenter.a(this.a, 1000001, 5);
                  return;
                case 9: 
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
                  paramView = new StringBuilder();
                  paramView.append("4 mCommentListChanged:");
                  paramView.append(this.a.jdField_a_of_type_Boolean);
                  paramView.append(", hashCode");
                  paramView.append(this.a.hashCode());
                  WSLog.c("comment", paramView.toString());
                  WsCommentPresenter.a(this.a, 1000001, 3);
                  return;
                }
              }
              else if ((paramObject instanceof Object[]))
              {
                paramObject = (Object[])paramObject;
                if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof stSimpleMetaComment)) && ((paramObject[1] instanceof stSimpleMetaReply)))
                {
                  paramView = (stSimpleMetaComment)paramObject[0];
                  paramObject = (stSimpleMetaReply)paramObject[1];
                  WsCommentPresenter.a(this.a, paramView, paramObject, 0);
                  WsCommentPresenter.a(this.a, 1000001, 1);
                }
              }
            }
            else if ((paramObject instanceof stSimpleMetaComment))
            {
              paramView = (stSimpleMetaComment)paramObject;
              this.a.a().a(WsCommentPresenter.a(this.a), paramView);
              this.a.jdField_a_of_type_Boolean = true;
              paramObject = new StringBuilder();
              paramObject.append("3 mCommentListChanged:");
              paramObject.append(this.a.jdField_a_of_type_Boolean);
              paramObject.append(",clickPosition:");
              paramObject.append(paramInt2);
              paramObject.append(", hashCode");
              paramObject.append(this.a.hashCode());
              WSLog.c("comment", paramObject.toString());
              paramObject = this.a;
              if (paramView.isDing == 0) {
                paramInt1 = 1001002;
              } else {
                paramInt1 = 1001001;
              }
              WsCommentPresenter.a(paramObject, paramInt1, 3);
              if ((WsCommentPresenter.a(this.a) instanceof WSFollowFragment))
              {
                paramInt1 = paramInt2 - 1;
                paramView = ((WSFollowFragment)WsCommentPresenter.a(this.a)).a().getRecyclerView().findViewHolderForAdapterPosition(WsCommentPresenter.b(this.a));
                if ((paramView instanceof WSFollowFeedHolder))
                {
                  paramView = (WSFollowFeedHolder)paramView;
                  paramObject = new StringBuilder();
                  paramObject.append("***getPosition():");
                  paramObject.append(WsCommentPresenter.b(this.a));
                  paramObject.append(",realPosition:");
                  paramObject.append(paramInt1);
                  WSLog.c("comment", paramObject.toString());
                  paramView.a(paramInt1);
                }
              }
            }
          }
          else if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof stSimpleMetaComment)) && ((paramObject[1] instanceof stSimpleMetaReply)))
            {
              paramView = (stSimpleMetaReply)paramObject[1];
              paramObject = (stSimpleMetaComment)paramObject[0];
              if (paramView.poster != null)
              {
                paramObject = paramView.poster.avatarSchema;
                a(paramView.poster, paramObject, 2);
                return;
              }
              a(null, null, 2);
            }
          }
        }
        else if ((paramObject instanceof stSimpleMetaComment))
        {
          paramView = (stSimpleMetaComment)paramObject;
          WsCommentPresenter.a(this.a, paramView, null, 0);
          WsCommentPresenter.a(this.a, 1000001, 1);
        }
      }
      else
      {
        WsCommentPresenter.a(this.a, 1000001, 6);
        if ((paramObject instanceof stSimpleMetaPerson))
        {
          paramView = (stSimpleMetaPerson)paramObject;
          a(paramView, paramView.avatarSchema, 6);
        }
      }
    }
    else
    {
      paramView = (stSimpleMetaPerson)paramObject;
      a(paramView, paramView.avatarSchema, 2);
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.OnFeedCommentElementClickListener
 * JD-Core Version:    0.7.0.1
 */