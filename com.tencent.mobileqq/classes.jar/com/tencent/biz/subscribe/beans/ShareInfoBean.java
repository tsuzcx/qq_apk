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
    CertifiedAccountMeta.StShare localStShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if (localStShare != null) {
      return localStShare.author.id.get();
    }
    return "";
  }
  
  public String b()
  {
    Object localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject1 != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject1).url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.url.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.url.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if (localObject1 != null)
      {
        int i = ((ExtraTypeInfo)localObject1).pageType;
        if (i != 8001) {
          switch (i)
          {
          default: 
            localObject2 = this.jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = "";
            break;
          case 7002: 
            localObject1 = SubscribeShareHelper.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
            break;
          case 7001: 
            localObject1 = SubscribeShareHelper.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
            break;
          case 7000: 
            localObject1 = SubscribeShareHelper.e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
            break;
          }
        } else {
          localObject1 = SubscribeShareHelper.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("share url is:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ShareInfoBean", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    return localObject1;
  }
  
  public String c()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject).title.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.title.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.title.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get();
    }
    return "";
  }
  
  public String d()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject).desc.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.desc.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.desc.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.desc.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.subtitle.get();
    }
    return "";
  }
  
  public String e()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject).cover.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.cover.url.get());
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.cover.url.get();
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get();
      }
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get();
    }
    return "";
  }
  
  public String f()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject).author.nick.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.nick.get();
    }
    localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localObject != null) {
      return ((CertifiedAccountMeta.StFeed)localObject).poster.nick.get();
    }
    return "";
  }
  
  public String g()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StShare)localObject).author.desc.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.desc.get();
    }
    localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localObject != null) {
      return ((CertifiedAccountMeta.StFeed)localObject).poster.desc.get();
    }
    return "";
  }
  
  public String h()
  {
    CertifiedAccountMeta.StShare localStShare = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    if ((localStShare != null) && (!StringUtil.a(localStShare.shorturl.get()))) {
      return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shorturl.get();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.ShareInfoBean
 * JD-Core Version:    0.7.0.1
 */