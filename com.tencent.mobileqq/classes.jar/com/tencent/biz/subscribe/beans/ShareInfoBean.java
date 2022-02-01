package com.tencent.biz.subscribe.beans;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class ShareInfoBean
{
  public int a;
  public CertifiedAccountMeta.StFeed a;
  public CertifiedAccountMeta.StShare a;
  public ExtraTypeInfo a;
  public String a;
  public boolean a;
  public boolean b;
  public boolean c = true;
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.id.get();
    }
    return "";
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.url.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.url.get();
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null))
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return "";
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    String str;
    switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      if (this.jdField_a_of_type_JavaLangString == null) {
        str = "";
      }
      break;
    }
    for (;;)
    {
      QLog.d("ShareInfoBean", 1, "share url is:" + str);
      return str;
      str = SubscribeShareHelper.e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str = SubscribeShareHelper.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str = SubscribeShareHelper.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str = SubscribeShareHelper.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.title.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.title.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.title.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get();
    }
    return "";
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.desc.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.desc.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.desc.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.subtitle.get();
    }
    return "";
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.cover.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.cover.url.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.cover.url.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get();
    }
    return "";
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.nick.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.nick.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get();
    }
    return "";
  }
  
  public String g()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.desc.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.desc.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.get();
    }
    return "";
  }
  
  public String h()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!StringUtil.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shorturl.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shorturl.get();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.ShareInfoBean
 * JD-Core Version:    0.7.0.1
 */