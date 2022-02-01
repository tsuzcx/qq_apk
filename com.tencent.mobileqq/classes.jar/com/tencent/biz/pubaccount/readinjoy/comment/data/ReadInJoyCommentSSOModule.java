package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class ReadInJoyCommentSSOModule
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private ReadInJoyCommentObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = null;
  private String jdField_a_of_type_JavaLangString = "";
  
  private QQAppInterface a()
  {
    if (BaseActivity.sTopActivity != null) {
      return (QQAppInterface)BaseActivity.sTopActivity.getAppInterface();
    }
    return RIJQQAppInterfaceUtil.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = null;
  }
  
  public void a(ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = paramReadInJoyCommentObserver;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    QQAppInterface localQQAppInterface = a();
    if ((paramBaseCommentData == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver == null)) {
      return;
    }
    label405:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = new JSONObject();
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label359;
        }
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("article_id", paramString);
        ((JSONObject)localObject).put("like", paramInt2);
        ((JSONObject)localObject).put("oper_type", paramInt1);
        ((JSONObject)localObject).put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
        if (!paramBaseCommentData.isActivity()) {
          break label405;
        }
        i = 400;
        ((JSONObject)localObject).put("src", i);
        ((JSONObject)localObject).put("uuid", this.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject).put("to_uin", Long.parseLong(paramBaseCommentData.uin));
        ((JSONObject)localObject).put("content_src", ReadInJoyCommentHelper.a(paramInt3));
        localObject = ((JSONObject)localObject).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like info:" + (String)localObject);
        }
        paramString = new WebSsoBody.WebSsoRequestBody();
        paramString.data.set((String)localObject);
        localObject = new NewIntent(localQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
        ((NewIntent)localObject).setObserver(new ReadInJoyCommentSSOModule.2(this, paramBaseCommentData, paramInt1, paramInt2));
        localQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception paramString)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver.a(false, paramBaseCommentData, paramInt1, paramInt2);
        }
        paramString.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike error info:" + paramString.getLocalizedMessage());
      return;
      label359:
      if ((paramBaseCommentData instanceof SubCommentData))
      {
        ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
        ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("type", 2);
        continue;
        i = 20;
      }
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    try
    {
      localQQAppInterface = a();
      if (localQQAppInterface == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver == null) {
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramBaseCommentData.getCommentLevel());
      if (!(paramBaseCommentData instanceof CommentData)) {
        break label312;
      }
      ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver.a(false, paramBaseCommentData, "");
        }
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyCommentSSOModule", 2, "createComment error info:" + paramString.getLocalizedMessage());
        return;
        label312:
        if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        }
      }
    }
    ((JSONObject)localObject).put("article_id", paramString);
    ((JSONObject)localObject).put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
    ((JSONObject)localObject).put("src", 20);
    ((JSONObject)localObject).put("uuid", this.jdField_a_of_type_JavaLangString);
    ((JSONObject)localObject).put("content_src", ReadInJoyCommentHelper.a(paramInt));
    localObject = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentSSOModule", 2, "deleteComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete info:" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = new WebSsoBody.WebSsoRequestBody();
      paramString.data.set((String)localObject);
      localObject = new NewIntent(localQQAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new ReadInJoyCommentSSOModule.1(this, paramBaseCommentData));
      localQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentSSOModule
 * JD-Core Version:    0.7.0.1
 */