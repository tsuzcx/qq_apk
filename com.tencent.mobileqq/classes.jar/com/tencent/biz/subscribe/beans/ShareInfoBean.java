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
  public CertifiedAccountMeta.StFeed b;
  public String c;
  public CertifiedAccountMeta.StShare d;
  public ExtraTypeInfo e;
  public boolean f;
  public boolean g;
  public boolean h = true;
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.b;
  }
  
  public String b()
  {
    CertifiedAccountMeta.StShare localStShare = this.d;
    if (localStShare != null) {
      return localStShare.author.id.get();
    }
    return "";
  }
  
  public String c()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject1).url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.d.url.get());
      return this.d.url.get();
    }
    if (this.b != null)
    {
      localObject1 = this.e;
      if (localObject1 != null)
      {
        int i = ((ExtraTypeInfo)localObject1).pageType;
        if (i != 8001) {
          switch (i)
          {
          default: 
            localObject2 = this.c;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = "";
            break;
          case 7002: 
            localObject1 = SubscribeShareHelper.b(this.b);
            break;
          case 7001: 
            localObject1 = SubscribeShareHelper.d(this.b);
            break;
          case 7000: 
            localObject1 = SubscribeShareHelper.e(this.b);
            break;
          }
        } else {
          localObject1 = SubscribeShareHelper.c(this.b);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("share url is:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ShareInfoBean", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
    }
    Object localObject2 = this.c;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    return localObject1;
  }
  
  public String d()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject).title.get())))
    {
      QLog.e("ShareInfoBean", 1, this.d.title.get());
      return this.d.title.get();
    }
    if (this.b != null)
    {
      localObject = this.e;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.b.poster.nick.get();
      }
      return this.b.title.get();
    }
    return "";
  }
  
  public String e()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject).desc.get())))
    {
      QLog.e("ShareInfoBean", 1, this.d.desc.get());
      return this.d.desc.get();
    }
    if (this.b != null)
    {
      localObject = this.e;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.b.poster.desc.get();
      }
      return this.b.subtitle.get();
    }
    return "";
  }
  
  public String f()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject).cover.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.d.cover.url.get());
      return this.d.cover.url.get();
    }
    if (this.b != null)
    {
      localObject = this.e;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).pageType == 7002)) {
        return this.b.poster.icon.get();
      }
      return this.b.cover.url.get();
    }
    return "";
  }
  
  public String g()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject).author.nick.get()))) {
      return this.d.author.nick.get();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((CertifiedAccountMeta.StFeed)localObject).poster.nick.get();
    }
    return "";
  }
  
  public String h()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StShare)localObject).author.desc.get()))) {
      return this.d.author.desc.get();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((CertifiedAccountMeta.StFeed)localObject).poster.desc.get();
    }
    return "";
  }
  
  public String i()
  {
    CertifiedAccountMeta.StShare localStShare = this.d;
    if ((localStShare != null) && (!StringUtil.isEmpty(localStShare.shorturl.get()))) {
      return this.d.shorturl.get();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.ShareInfoBean
 * JD-Core Version:    0.7.0.1
 */