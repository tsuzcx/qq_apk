package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.AppRuntime;

public class SubscribeGlobalInfo
{
  private static volatile CertifiedAccountMeta.StUser a;
  private static CertifiedAccountRead.StGetMainPageRsp b;
  
  public static CertifiedAccountMeta.StUser a()
  {
    try
    {
      if (a == null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        COMM.Entry localEntry = new COMM.Entry();
        localEntry.key.set("user_info");
        localEntry.value.set("1");
        localStCommonExt.mapInfo.add(localEntry);
        if (VSNetworkHelper.getInstance() != null) {
          VSNetworkHelper.getInstance().sendRequest(new SubscribePersonalDetailRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localStCommonExt), new SubscribeGlobalInfo.1());
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return a;
  }
  
  public static void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (b == null) {
      b = new CertifiedAccountRead.StGetMainPageRsp();
    }
    if (a == null) {
      a = new CertifiedAccountMeta.StUser();
    }
    CertifiedAccountMeta.StUser localStUser = paramStGetMainPageRsp.user;
    if (localStUser == null) {
      return;
    }
    b.feedCount.set(paramStGetMainPageRsp.feedCount.get());
    b.followCount.set(paramStGetMainPageRsp.followCount.get());
    b.fansCount.set(paramStGetMainPageRsp.fansCount.get());
    b.user.set(paramStGetMainPageRsp.user.get());
    b.share.set(paramStGetMainPageRsp.share);
    if (SubscribeUtils.a(localStUser.attr.get()))
    {
      a.id.set(localStUser.id.get());
      a.nick.set(localStUser.nick.get());
      a.icon.set(localStUser.icon.get());
      a.followState.set(localStUser.followState.get());
      a.attr.set(localStUser.attr.get());
      a.youZhan.set(localStUser.youZhan.get());
      a.type.set(localStUser.type.get());
    }
  }
  
  public static CertifiedAccountRead.StGetMainPageRsp b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeGlobalInfo
 * JD-Core Version:    0.7.0.1
 */