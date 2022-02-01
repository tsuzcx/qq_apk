package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.GetRecommendListListener;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.ac.ArticleComment.GetRecommendPubAccountResponse;
import tencent.im.oidb.ac.ArticleComment.Record;
import tencent.im.oidb.ac.ArticleComment.RetInfo;

class PublicAccountSearchRecommendManagerImpl$3
  implements BusinessObserver
{
  PublicAccountSearchRecommendManagerImpl$3(PublicAccountSearchRecommendManagerImpl paramPublicAccountSearchRecommendManagerImpl, NewIntent paramNewIntent, AppInterface paramAppInterface, IPublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountSearchRecommendManagerImpl.access$500(this.d), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      PublicAccountSearchRecommendManagerImpl.access$700(this.d, this.b, this.c);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new ArticleComment.GetRecommendPubAccountResponse();
        ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        if (QLog.isColorLevel())
        {
          paramBundle = PublicAccountSearchRecommendManagerImpl.access$500(this.d);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnReceiveGetRecommendPubAccountResponse->retCode:");
          localStringBuilder.append(((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get());
          localStringBuilder.append(", title:");
          localStringBuilder.append(((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get());
          localStringBuilder.append(", listSize:");
          localStringBuilder.append(((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
          QLog.d(paramBundle, 2, localStringBuilder.toString());
        }
        if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d(PublicAccountSearchRecommendManagerImpl.access$500(this.d), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
          }
          PublicAccountSearchRecommendManagerImpl.access$700(this.d, this.b, this.c);
          return;
        }
        paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
        if (paramInt == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(PublicAccountSearchRecommendManagerImpl.access$500(this.d), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
          }
          PublicAccountSearchRecommendManagerImpl.access$402(this.d, true);
          this.c.a(new ArrayList(), null, true);
          return;
        }
        PublicAccountSearchRecommendManagerImpl.access$402(this.d, false);
        if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has())
        {
          paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();
          if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(PublicAccountSearchRecommendManagerImpl.access$500(this.d), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
            }
            PublicAccountSearchRecommendManagerImpl.access$102(this.d, paramBundle);
            PublicAccountSearchRecommendManagerImpl.access$000(this.d).clear();
            paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
            if (paramBundle.hasNext())
            {
              localObject = (ArticleComment.Record)paramBundle.next();
              PublicAccountSearchRecommendManagerImpl.access$000(this.d).add(new IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem(((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
              continue;
            }
            PublicAccountSearchRecommendManagerImpl.access$202(this.d, NetConnInfoCenter.getServerTimeMillis());
            PublicAccountSearchRecommendManagerImpl.access$800(this.d, this.b);
          }
          PublicAccountSearchRecommendManagerImpl.access$700(this.d, this.b, this.c);
          if (QLog.isColorLevel())
          {
            paramBundle = PublicAccountSearchRecommendManagerImpl.access$500(this.d);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("OnReceiveGetRecommendPubAccountResponse update UI->title:");
            ((StringBuilder)localObject).append(PublicAccountSearchRecommendManagerImpl.access$100(this.d));
            ((StringBuilder)localObject).append(", cacheTime:");
            ((StringBuilder)localObject).append(PublicAccountSearchRecommendManagerImpl.access$200(this.d));
            ((StringBuilder)localObject).append(", isFobidden:");
            ((StringBuilder)localObject).append(PublicAccountSearchRecommendManagerImpl.access$400(this.d));
            ((StringBuilder)localObject).append(", recommendSize:");
            ((StringBuilder)localObject).append(PublicAccountSearchRecommendManagerImpl.access$000(this.d).size());
            QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
            paramBundle = PublicAccountSearchRecommendManagerImpl.access$000(this.d).iterator();
            if (paramBundle.hasNext())
            {
              localObject = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramBundle.next();
              QLog.d(PublicAccountSearchRecommendManagerImpl.access$500(this.d), 2, ((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localObject).toString());
              continue;
            }
          }
          return;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = PublicAccountSearchRecommendManagerImpl.access$500(this.d);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnReceiveGetRecommendPubAccountResponse exception:");
          localStringBuilder.append(paramBundle);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        PublicAccountSearchRecommendManagerImpl.access$700(this.d, this.b, this.c);
        return;
      }
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountSearchRecommendManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */