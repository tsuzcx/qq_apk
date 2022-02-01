package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetDiscoverBannerVideoRequest;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DiscoverBannerPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
  implements CmdTaskManger.CommandCallback<GetDiscoverBannerVideoRequest, GetDiscoverBannerVideoResponse>
{
  private String a = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private DiscoverBannerPlayInfo b;
  private IDataProvider.GroupId c;
  private IGroupPageLoader.CallBack d;
  private int e;
  
  public DiscoverBannerPlayPageLoader(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.b = paramDiscoverBannerPlayInfo;
    this.c = new IDataProvider.GroupId(this.b.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.c);
    localGroupInfo.c = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localGroupInfo.c.add(localBannerInfo.a);
        localGroupInfo.d.put(localBannerInfo.a, localBannerInfo.b);
      }
    }
    this.d.b(new ErrorMessage(), Collections.singletonList(localGroupInfo), true);
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    this.d = paramCallBack;
    paramCallBack = ((DiscoverManager)SuperManager.a(22)).a(this.b.bannerId);
    if ((paramCallBack != null) && (paramCallBack.bannerInfoList.size() == paramCallBack.totalCount) && (paramCallBack.totalCount > 0))
    {
      SLog.a(this.a, "get group data from cache, count:%d", Integer.valueOf(paramCallBack.totalCount));
      a(paramCallBack);
      return;
    }
    this.e = 0;
    a(this.b.bannerId, "");
  }
  
  public void a(@NonNull GetDiscoverBannerVideoRequest paramGetDiscoverBannerVideoRequest, @Nullable GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramGetDiscoverBannerVideoResponse != null))
    {
      paramErrorMessage = (DiscoverManager)SuperManager.a(22);
      paramErrorMessage.a(paramGetDiscoverBannerVideoRequest.f, paramGetDiscoverBannerVideoResponse);
      if (QLog.isColorLevel())
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saved banner info to db. bannerId = ");
        localStringBuilder.append(paramGetDiscoverBannerVideoRequest.f);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if ((!paramGetDiscoverBannerVideoResponse.e) && (this.e <= 10))
      {
        a(paramGetDiscoverBannerVideoRequest.f, paramGetDiscoverBannerVideoResponse.f);
        return;
      }
      a(paramErrorMessage.a(this.b.bannerId));
      return;
    }
    SLog.a(this.a, "get banner info back failed. bannerId =%s ", paramGetDiscoverBannerVideoRequest.f);
    this.d.a(paramErrorMessage, null, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e += 1;
    AssertUtils.checkNotEmpty(paramString1);
    GetDiscoverBannerVideoRequest localGetDiscoverBannerVideoRequest = new GetDiscoverBannerVideoRequest();
    localGetDiscoverBannerVideoRequest.f = paramString1;
    localGetDiscoverBannerVideoRequest.g = paramString2;
    CmdTaskManger.a().a(localGetDiscoverBannerVideoRequest, this);
  }
  
  public void b() {}
  
  public IDataProvider.StartInfo c()
  {
    return new IDataProvider.StartInfo(this.c, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DiscoverBannerPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */