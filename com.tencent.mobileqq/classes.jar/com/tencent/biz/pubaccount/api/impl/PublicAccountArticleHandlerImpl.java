package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoFirstItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.ac.ArticleComment.ArticleLikeRequest;
import tencent.im.oidb.ac.ArticleComment.ArticleLikeRespond;
import tencent.im.oidb.ac.ArticleComment.CheckArticleLikeRequest;
import tencent.im.oidb.ac.ArticleComment.CheckArticleLikeRespond;
import tencent.im.oidb.ac.ArticleComment.CreateArticleCommentRequest;
import tencent.im.oidb.ac.ArticleComment.CreateArticleCommentRespond;
import tencent.im.oidb.ac.ArticleComment.GetArticleCommentCountRequest;
import tencent.im.oidb.ac.ArticleComment.GetArticleCommentCountRespond;
import tencent.im.oidb.ac.ArticleComment.GetArticleLikeCountRequest;
import tencent.im.oidb.ac.ArticleComment.GetArticleLikeCountRespond;
import tencent.im.oidb.ac.ArticleComment.GetPhotoCollectionInfoRequest;
import tencent.im.oidb.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import tencent.im.oidb.ac.ArticleComment.GetRecommendInfoRequest;
import tencent.im.oidb.ac.ArticleComment.GetRecommendInfoResponse;
import tencent.im.oidb.ac.ArticleComment.LikeRet;
import tencent.im.oidb.ac.ArticleComment.PhotoFirstItemInfo;
import tencent.im.oidb.ac.ArticleComment.PhotoItemInfo;
import tencent.im.oidb.ac.ArticleComment.RecommendInfo;
import tencent.im.oidb.ac.ArticleComment.RecommendItemInfo;
import tencent.im.oidb.ac.ArticleComment.ReportGalleryInfoRequest;
import tencent.im.oidb.ac.ArticleComment.ReportGalleryInfoResponse;
import tencent.im.oidb.ac.ArticleComment.RetInfo;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.ReqBody;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PublicAccountArticleHandlerImpl
  extends BusinessHandler
  implements IPublicAccountArticleHandler
{
  public static final String TAG = "Q.pubaccount.video.PublicAccountArticleHandler";
  public String IMAGE_COLLECTION_ARTICLE_ID = "image_collection_article_id";
  protected Set<String> allowCmdSet;
  private final long mTimeOut = 30000L;
  IPublicAccountArticleObserver publicAccountArticleObserver;
  
  public PublicAccountArticleHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public PublicAccountArticleHandlerImpl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void handleArticleReadCount(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = 0;
    if ((bool) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleArticleReadCount:");
      paramToServiceMsg.append(bool);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramToServiceMsg.toString());
    }
    int i;
    if (bool)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0x6a6.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if ((paramFromServiceMsg.uint32_ret_code.has()) && (paramFromServiceMsg.uint32_ret_code.get() == 0))
        {
          if (paramFromServiceMsg.uint32_read_count.has())
          {
            i = paramFromServiceMsg.uint32_read_count.get();
          }
          else if (paramFromServiceMsg.uint64_read_count.has())
          {
            i = (int)paramFromServiceMsg.uint64_read_count.get();
          }
          else
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount 获取失败, read_count 为空");
              i = j;
            }
          }
        }
        else
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount 获取失败, ret_code 为空或 ret_code == 1");
            i = j;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          break label304;
        }
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleArticleReadCount, ERROR e=");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
      i = j;
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount, 返回直接出错了");
        i = j;
      }
    }
    label304:
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleArticleReadCount playCount :");
      paramToServiceMsg.append(i);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = this.publicAccountArticleObserver;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onGetArticleReadCount(bool, i);
    }
  }
  
  private void handleCheckIsArticleLiked(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    paramFromServiceMsg = "";
    if (bool1)
    {
      ArticleComment.CheckArticleLikeRequest localCheckArticleLikeRequest = new ArticleComment.CheckArticleLikeRequest();
      ArticleComment.CheckArticleLikeRespond localCheckArticleLikeRespond = new ArticleComment.CheckArticleLikeRespond();
      try
      {
        localCheckArticleLikeRequest.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localCheckArticleLikeRespond.mergeFrom((byte[])paramObject);
        paramObject = paramFromServiceMsg;
        if (localCheckArticleLikeRespond.ret.has())
        {
          if ((!localCheckArticleLikeRespond.ret.ret_code.has()) || (localCheckArticleLikeRespond.ret.ret_code.get() != 0)) {
            break label302;
          }
          paramToServiceMsg = paramFromServiceMsg;
          if (localCheckArticleLikeRequest.article_id.has())
          {
            paramToServiceMsg = localCheckArticleLikeRequest.article_id.get().toStringUtf8();
            localBundle.putString("VALUE_ARTICLE_ID", paramToServiceMsg);
          }
          paramObject = paramToServiceMsg;
          if (localCheckArticleLikeRespond.data.has())
          {
            paramObject = paramToServiceMsg;
            if (localCheckArticleLikeRespond.data.size() > 0)
            {
              paramObject = paramToServiceMsg;
              if (((ArticleComment.LikeRet)localCheckArticleLikeRespond.data.get(0)).like.has()) {
                if (((ArticleComment.LikeRet)localCheckArticleLikeRespond.data.get(0)).like.get() == 0)
                {
                  localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", false);
                  paramObject = paramToServiceMsg;
                }
                else
                {
                  localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", true);
                  bool1 = true;
                  break label254;
                }
              }
            }
          }
        }
        bool1 = false;
        paramToServiceMsg = paramObject;
        label254:
        bool2 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleCheckIsArticleLiked() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      label302:
      bool1 = false;
      paramToServiceMsg = paramFromServiceMsg;
    }
    paramFromServiceMsg = this.publicAccountArticleObserver;
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.onCheckIsArticleLiked(bool2, paramToServiceMsg, bool1);
      return;
    }
    super.notifyUI(1, bool2, localBundle);
  }
  
  private void handleCreateArticleCommentReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    int i;
    if (bool2)
    {
      paramToServiceMsg = new ArticleComment.CreateArticleCommentRespond();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret.has()) && (paramToServiceMsg.ret.ret_code.has()))
        {
          int j = paramToServiceMsg.ret.ret_code.get();
          i = j;
          if (j != 0) {
            break label133;
          }
          bool1 = true;
          i = j;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleCreateArticleCommentReq() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      i = -1;
    }
    label133:
    paramToServiceMsg = this.publicAccountArticleObserver;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onCreateArticleCommentRespond(bool1, i);
    }
  }
  
  private void handleGetArticleCommentCountReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int i = 0;
    boolean bool2;
    if (bool1)
    {
      paramToServiceMsg = new ArticleComment.GetArticleCommentCountRespond();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.ret.has())
        {
          if ((paramToServiceMsg.ret.ret_code.has()) && (paramToServiceMsg.ret.ret_code.get() != 0)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          bool2 = bool1;
          if (!paramToServiceMsg.count.has()) {
            break label157;
          }
          i = paramToServiceMsg.count.get();
          bool2 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetArticleCommentCountReq() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      bool2 = false;
    }
    label157:
    paramToServiceMsg = this.publicAccountArticleObserver;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onGetArticleCommentCountRespond(bool2, i);
    }
  }
  
  private void handleGetPhotoCollectionInfoReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    IPublicAccountImageCollectionUtils.PhotoCollectionInfo localPhotoCollectionInfo = new IPublicAccountImageCollectionUtils.PhotoCollectionInfo();
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    int i = 0;
    if (bool2)
    {
      ArticleComment.GetPhotoCollectionInfoResponse localGetPhotoCollectionInfoResponse = new ArticleComment.GetPhotoCollectionInfoResponse();
      try
      {
        localGetPhotoCollectionInfoResponse.mergeFrom((byte[])paramObject);
        localPhotoCollectionInfo.a = ((String)paramToServiceMsg.extraData.get(this.IMAGE_COLLECTION_ARTICLE_ID));
        paramFromServiceMsg = localPhotoCollectionInfo.a;
        paramToServiceMsg = paramFromServiceMsg;
        if (!localGetPhotoCollectionInfoResponse.ret.has()) {
          break label679;
        }
        if ((localGetPhotoCollectionInfoResponse.ret.ret_code.has()) && (localGetPhotoCollectionInfoResponse.ret.ret_code.get() != 0)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (localGetPhotoCollectionInfoResponse.article_share_url.has()) {
          localPhotoCollectionInfo.b = localGetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
        }
        if (localGetPhotoCollectionInfoResponse.puin.has())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append(localGetPhotoCollectionInfoResponse.puin.get());
          paramToServiceMsg.append("");
          localPhotoCollectionInfo.c = paramToServiceMsg.toString();
        }
        if (localGetPhotoCollectionInfoResponse.article_img_url.has()) {
          localPhotoCollectionInfo.d = localGetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
        }
        if (localGetPhotoCollectionInfoResponse.article_title.has()) {
          localPhotoCollectionInfo.e = localGetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
        }
        if (localGetPhotoCollectionInfoResponse.enable_comment.has()) {
          localPhotoCollectionInfo.f = localGetPhotoCollectionInfoResponse.enable_comment.get();
        }
        if (localGetPhotoCollectionInfoResponse.comment_url.has()) {
          localPhotoCollectionInfo.g = localGetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
        }
        if (localGetPhotoCollectionInfoResponse.firstItem.has())
        {
          localPhotoCollectionInfo.h = new IPublicAccountImageCollectionUtils.PhotoFirstItemInfo();
          localPhotoCollectionInfo.h.a = localGetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
          localPhotoCollectionInfo.h.d = localGetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
          localPhotoCollectionInfo.h.c = localGetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
          localPhotoCollectionInfo.h.b = localGetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
        }
        if ((localGetPhotoCollectionInfoResponse.item.has()) && (localGetPhotoCollectionInfoResponse.item.get().size() > 0))
        {
          localPhotoCollectionInfo.i = new ArrayList();
          int j = localGetPhotoCollectionInfoResponse.item.get().size();
          while (i < j)
          {
            paramToServiceMsg = new IPublicAccountImageCollectionUtils.PhotoItemInfo();
            paramToServiceMsg.a = ((ArticleComment.PhotoItemInfo)localGetPhotoCollectionInfoResponse.item.get(i)).url.get().toStringUtf8();
            paramToServiceMsg.b = ((ArticleComment.PhotoItemInfo)localGetPhotoCollectionInfoResponse.item.get(i)).content.get().toStringUtf8();
            paramToServiceMsg.c = ((ArticleComment.PhotoItemInfo)localGetPhotoCollectionInfoResponse.item.get(i)).static_url.get().toStringUtf8();
            paramToServiceMsg.d = ((ArticleComment.PhotoItemInfo)localGetPhotoCollectionInfoResponse.item.get(i)).width.get();
            paramToServiceMsg.e = ((ArticleComment.PhotoItemInfo)localGetPhotoCollectionInfoResponse.item.get(i)).height.get();
            localPhotoCollectionInfo.i.add(paramToServiceMsg);
            i += 1;
          }
        }
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetPhotoCollectionInfoReq() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      paramToServiceMsg = null;
    }
    label679:
    paramFromServiceMsg = this.publicAccountArticleObserver;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.onGetPhotoCollectionInfoRespond(bool1, localPhotoCollectionInfo, (byte[])paramObject, paramToServiceMsg);
    }
  }
  
  private void handleGetRecommendInfoReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new ArrayList();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int i = 0;
    boolean bool2 = true;
    if (bool1)
    {
      paramFromServiceMsg = new ArticleComment.GetRecommendInfoResponse();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramFromServiceMsg.ret.has())
        {
          if (paramFromServiceMsg.ret.ret_code.has()) {
            paramFromServiceMsg.ret.ret_code.get();
          }
          bool1 = bool2;
          if (paramFromServiceMsg.item.has())
          {
            bool1 = bool2;
            if (paramFromServiceMsg.item.get().size() > 0)
            {
              int j = paramFromServiceMsg.item.get().size();
              for (;;)
              {
                bool1 = bool2;
                if (i >= j) {
                  break;
                }
                paramObject = new IPublicAccountImageCollectionUtils.RecommendItemInfo();
                paramObject.d = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).article_id.get().toStringUtf8();
                paramObject.c = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).recommend_source.get().toStringUtf8();
                paramObject.b = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).title.get().toStringUtf8();
                paramObject.a = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).url.get().toStringUtf8();
                paramToServiceMsg.add(paramObject);
                i += 1;
              }
              bool1 = false;
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetRecommendInfoReq ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetRecommendInfoReq success, size ");
      paramFromServiceMsg.append(paramToServiceMsg.size());
      QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = this.publicAccountArticleObserver;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.onGetRecommendInfoRespond(bool1, paramToServiceMsg);
    }
  }
  
  private void handleQueryArticleLikeCount(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int j = 0;
    paramFromServiceMsg = "";
    int i;
    if (bool1)
    {
      boolean bool2 = true;
      ArticleComment.GetArticleLikeCountRequest localGetArticleLikeCountRequest = new ArticleComment.GetArticleLikeCountRequest();
      ArticleComment.GetArticleLikeCountRespond localGetArticleLikeCountRespond = new ArticleComment.GetArticleLikeCountRespond();
      try
      {
        localGetArticleLikeCountRequest.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localGetArticleLikeCountRespond.mergeFrom((byte[])paramObject);
        i = j;
        paramObject = paramFromServiceMsg;
        bool1 = bool2;
        if (!localGetArticleLikeCountRespond.ret.has()) {
          break label265;
        }
        if ((localGetArticleLikeCountRespond.ret.ret_code.has()) && (localGetArticleLikeCountRespond.ret.ret_code.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (localGetArticleLikeCountRequest.article_id.has())
          {
            paramToServiceMsg = localGetArticleLikeCountRequest.article_id.get().toStringUtf8();
            localBundle.putString("VALUE_ARTICLE_ID", paramToServiceMsg);
          }
          i = j;
          paramObject = paramToServiceMsg;
          bool1 = bool2;
          if (!localGetArticleLikeCountRespond.count.has()) {
            break label265;
          }
          i = localGetArticleLikeCountRespond.count.get();
          localBundle.putInt("VALUE_ARTICLE_LIKE_COUNT", i);
          paramObject = paramToServiceMsg;
          bool1 = bool2;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleQueryArticleLikeCount() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      bool1 = false;
      paramObject = paramFromServiceMsg;
      i = j;
    }
    label265:
    paramToServiceMsg = this.publicAccountArticleObserver;
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.onQueryArticleLikeCount(bool1, paramObject, i);
      return;
    }
    super.notifyUI(2, bool1, localBundle);
  }
  
  private void handleReportReadPhotoCollectionReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new ArticleComment.ReportGalleryInfoResponse();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret.has()) && ((!paramToServiceMsg.ret.ret_code.has()) || (paramToServiceMsg.ret.ret_code.get() == 0))) {
          bool = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleReportReadPhotoCollectionReq() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      bool = false;
    }
    paramToServiceMsg = this.publicAccountArticleObserver;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onReportReadPhotoCollectionRespond(bool);
    }
  }
  
  private void handleSendArticleLikeReq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool1 = true;
    boolean bool2 = true;
    paramFromServiceMsg = "";
    if (bool3)
    {
      ArticleComment.ArticleLikeRequest localArticleLikeRequest = new ArticleComment.ArticleLikeRequest();
      ArticleComment.ArticleLikeRespond localArticleLikeRespond = new ArticleComment.ArticleLikeRespond();
      try
      {
        localArticleLikeRequest.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localArticleLikeRespond.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        if (!localArticleLikeRespond.ret.has()) {
          break label238;
        }
        if ((localArticleLikeRespond.ret.ret_code.has()) && (localArticleLikeRespond.ret.ret_code.get() != 0))
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", false);
          bool2 = false;
        }
        else
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", true);
        }
        bool1 = bool2;
        paramToServiceMsg = paramFromServiceMsg;
        if (!localArticleLikeRequest.article_id.has()) {
          break label238;
        }
        paramToServiceMsg = localArticleLikeRequest.article_id.get().toStringUtf8();
        localBundle.putString("VALUE_ARTICLE_ID", paramToServiceMsg);
        bool1 = bool2;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleSendArticleLikeReq() ERROR e=");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    else
    {
      bool1 = false;
      paramToServiceMsg = paramFromServiceMsg;
    }
    label238:
    paramFromServiceMsg = this.publicAccountArticleObserver;
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.onSendArticleLikeReq(bool1, paramToServiceMsg);
      return;
    }
    super.notifyUI(0, bool1, localBundle);
  }
  
  public void checkIsArticleLiked(String paramString)
  {
    ArticleComment.CheckArticleLikeRequest localCheckArticleLikeRequest = new ArticleComment.CheckArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localCheckArticleLikeRequest.article_id.set(paramString);
    localCheckArticleLikeRequest.uins.add(Long.valueOf(getCurrentAccountUin()));
    paramString = createToServiceMsg("PubAccountArticleCenter.CheckArticleLike");
    paramString.putWupBuffer(localCheckArticleLikeRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  public void createArticleComment(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createArticleComment() articleId = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    paramString1 = new ArticleComment.CreateArticleCommentRequest();
    localObject = ByteStringMicro.copyFromUtf8((String)localObject);
    paramString1.article_id.set((ByteStringMicro)localObject);
    paramString2 = ByteStringMicro.copyFromUtf8(paramString2);
    paramString1.comment.set(paramString2);
    paramString1.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    paramString1.hide_name.set(paramInt);
    paramString2 = createToServiceMsg("PubAccountArticleCenter.CreateArticleComment");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.setTimeout(30000L);
    super.sendPbReq(paramString2);
  }
  
  public void getArticleCommentCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getArticleCommentCount() articleId = ");
      paramString.append((String)localObject);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramString.toString());
    }
    paramString = new ArticleComment.GetArticleCommentCountRequest();
    localObject = ByteStringMicro.copyFromUtf8((String)localObject);
    paramString.article_id.set((ByteStringMicro)localObject);
    localObject = createToServiceMsg("PubAccountArticleCenter.GetArticleCommentCount");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PubAccountArticleCenter.ArticleLike");
      this.allowCmdSet.add("PubAccountArticleCenter.CheckArticleLike");
      this.allowCmdSet.add("PubAccountArticleCenter.GetArticleLikeCount");
      this.allowCmdSet.add("PubAccountArticleCenter.CreateArticleComment");
      this.allowCmdSet.add("PubAccountArticleCenter.GetArticleCommentCount");
      this.allowCmdSet.add("PubAccountArticleCenter.PictureInfo");
      this.allowCmdSet.add("PubAccountArticleCenter.GetRecommendInfo");
      this.allowCmdSet.add("PubAccountArticleCenter.GalleryReport");
      this.allowCmdSet.add("OidbSvc.0x6a6");
    }
    return this.allowCmdSet;
  }
  
  public void getPhotoCollectionInfo(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPhotoCollectionInfo() articleId = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArticleComment.GetPhotoCollectionInfoRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString1);
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).article_id.set(localByteStringMicro);
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).versionInfo.set("8.8.17,3,5770");
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).click_source.set(paramInt2);
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).recommend_position.set(paramInt1);
    ((ArticleComment.GetPhotoCollectionInfoRequest)localObject).recommend_source.set(paramString2);
    paramString2 = createToServiceMsg("PubAccountArticleCenter.PictureInfo");
    paramString2.putWupBuffer(((ArticleComment.GetPhotoCollectionInfoRequest)localObject).toByteArray());
    paramString2.setTimeout(30000L);
    paramString2.extraData.putString(this.IMAGE_COLLECTION_ARTICLE_ID, paramString1);
    super.sendPbReq(paramString2);
  }
  
  public void getRecommendInfo(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecommendInfo() articleId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArticleComment.GetRecommendInfoRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    ((ArticleComment.GetRecommendInfoRequest)localObject).article_id.set(paramString);
    ((ArticleComment.GetRecommendInfoRequest)localObject).cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    ((ArticleComment.GetRecommendInfoRequest)localObject).versionInfo.set("8.8.17,3,5770");
    paramString = createToServiceMsg("PubAccountArticleCenter.GetRecommendInfo");
    paramString.putWupBuffer(((ArticleComment.GetRecommendInfoRequest)localObject).toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountArticleObserver.class);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive() getServiceCmd=");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    try
    {
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleLikeCount"))
      {
        handleQueryArticleLikeCount(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CheckArticleLike"))
      {
        handleCheckIsArticleLiked(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike"))
      {
        handleSendArticleLikeReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GalleryReport"))
      {
        handleReportReadPhotoCollectionReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CreateArticleComment"))
      {
        handleCreateArticleCommentReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleCommentCount"))
      {
        handleGetArticleCommentCountReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.PictureInfo"))
      {
        handleGetPhotoCollectionInfoReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetRecommendInfo"))
      {
        handleGetRecommendInfoReq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6a6"))
      {
        handleArticleReadCount(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onReceive ERROR e=");
        paramObject.append(paramToServiceMsg.getMessage());
        paramObject.append(paramFromServiceMsg.getServiceCmd());
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, paramObject.toString());
      }
    }
  }
  
  public void queryArticleLikeCount(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryArticleLikeCount() articleId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArticleComment.GetArticleLikeCountRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    ((ArticleComment.GetArticleLikeCountRequest)localObject).article_id.set(paramString);
    paramString = createToServiceMsg("PubAccountArticleCenter.GetArticleLikeCount");
    paramString.putWupBuffer(((ArticleComment.GetArticleLikeCountRequest)localObject).toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  public void queryArticleReadCount(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryArticleReadCount()  articleId");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6a6.ReqBody();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    ((oidb_0x6a6.ReqBody)localObject).bytes_article_id.set(paramString);
    ((oidb_0x6a6.ReqBody)localObject).uint32_req_type.set(0);
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x6a6", 1702, 0, ((oidb_0x6a6.ReqBody)localObject).toByteArray()));
  }
  
  public void removePublicAccountArticleObserver()
  {
    this.publicAccountArticleObserver = null;
  }
  
  public void reportReadPhotoCollection(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportReadPhotoCollection() articleId = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArticleComment.ReportGalleryInfoRequest();
    String str = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramString3);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).article_id.set(Integer.valueOf(str).intValue());
    ((ArticleComment.ReportGalleryInfoRequest)localObject).uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    ((ArticleComment.ReportGalleryInfoRequest)localObject).puin.set(Long.valueOf(paramString2).longValue());
    paramString2 = ByteStringMicro.copyFromUtf8(paramString3);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).article_url.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8("Android");
    ((ArticleComment.ReportGalleryInfoRequest)localObject).os.set(paramString2);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).is_qq.set(1);
    paramString2 = ByteStringMicro.copyFromUtf8("8.8.17");
    ((ArticleComment.ReportGalleryInfoRequest)localObject).mv.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8("5770");
    ((ArticleComment.ReportGalleryInfoRequest)localObject).subv.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8(com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[com.tencent.mobileqq.utils.NetworkUtil.getSystemNetwork(this.appRuntime.getApplicationContext())]);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).network.set(paramString2);
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).rowkey.set(paramString1);
    ((ArticleComment.ReportGalleryInfoRequest)localObject).ts.set((int)(System.currentTimeMillis() / 1000L));
    ((ArticleComment.ReportGalleryInfoRequest)localObject).site_id.set(paramInt1);
    if (paramInt1 == 2)
    {
      ((ArticleComment.ReportGalleryInfoRequest)localObject).recommend_index.set(paramInt2);
      paramString1 = ByteStringMicro.copyFromUtf8(paramString4);
      ((ArticleComment.ReportGalleryInfoRequest)localObject).echo_info.set(paramString1);
    }
    ((ArticleComment.ReportGalleryInfoRequest)localObject).browse_time.set(paramInt3);
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramInt1 == 2))
    {
      paramString1 = new ArticleComment.RecommendInfo();
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (IPublicAccountImageCollectionUtils.RecommendItemInfo)paramString2.next();
        paramString4 = ByteStringMicro.copyFromUtf8(paramString3.d);
        paramString1.rowkey.set(paramString4);
        paramString3 = ByteStringMicro.copyFromUtf8(paramString3.c);
        paramString1.echo_info.set(paramString3);
        ((ArticleComment.ReportGalleryInfoRequest)localObject).recommend_info.add(paramString1);
      }
    }
    paramString1 = createToServiceMsg("PubAccountArticleCenter.GalleryReport");
    paramString1.putWupBuffer(((ArticleComment.ReportGalleryInfoRequest)localObject).toByteArray());
    paramString1.setTimeout(30000L);
    super.sendPbReq(paramString1);
  }
  
  public void sendArticleLikeReq(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArticleComment.ArticleLikeRequest localArticleLikeRequest = new ArticleComment.ArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localArticleLikeRequest.article_id.set(paramString);
    localArticleLikeRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    if (paramBoolean1) {
      localArticleLikeRequest.like.set(1);
    } else {
      localArticleLikeRequest.like.set(0);
    }
    if (paramBoolean2) {
      localArticleLikeRequest.pin.set(1);
    } else {
      localArticleLikeRequest.pin.set(0);
    }
    paramString = createToServiceMsg("PubAccountArticleCenter.ArticleLike");
    paramString.putWupBuffer(localArticleLikeRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  public void setPublicAccountArticleObserver(IPublicAccountArticleObserver paramIPublicAccountArticleObserver)
  {
    this.publicAccountArticleObserver = paramIPublicAccountArticleObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountArticleHandlerImpl
 * JD-Core Version:    0.7.0.1
 */