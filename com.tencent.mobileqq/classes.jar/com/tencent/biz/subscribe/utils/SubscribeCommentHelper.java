package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class SubscribeCommentHelper
{
  private static SubscribeCommentHelper jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeCommentHelper;
  public static final String a = "SubscribeCommentHelper";
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static SubscribeCommentHelper a()
  {
    if (jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeCommentHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeCommentHelper == null) {
          jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeCommentHelper = new SubscribeCommentHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeCommentHelper;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    } else {
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString2);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString3);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("storeComment storeKey: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" comment: ");
    localStringBuilder.append(paramString2);
    QLog.d(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  private String b(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    String str = "";
    if (paramStFeed != null) {
      paramStFeed = paramStFeed.id.get();
    } else {
      paramStFeed = "";
    }
    if (paramStComment != null) {
      paramStComment = paramStComment.id.get();
    } else {
      paramStComment = "";
    }
    if (paramStReply != null) {
      str = paramStReply.id.get();
    }
    return a(paramStFeed, paramStComment, str);
  }
  
  public String a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    paramStFeed = b(paramStFeed, paramStComment, paramStReply);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramStFeed))
    {
      paramStComment = jdField_a_of_type_JavaLangString;
      paramStReply = new StringBuilder();
      paramStReply.append("getComment storeKey: ");
      paramStReply.append(paramStFeed);
      paramStReply.append(" preCommentText: ");
      paramStReply.append((String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed));
      QLog.d(paramStComment, 1, paramStReply.toString());
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramStFeed);
    }
    paramStComment = jdField_a_of_type_JavaLangString;
    paramStReply = new StringBuilder();
    paramStReply.append("getComment storeKey: ");
    paramStReply.append(paramStFeed);
    paramStReply.append(" preCommentText doesn't exit");
    QLog.d(paramStComment, 1, paramStReply.toString());
    return "";
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    a(b(paramStFeed, paramStComment, paramStReply), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeCommentHelper
 * JD-Core Version:    0.7.0.1
 */