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
  private int jdField_a_of_type_Int;
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private IGroupPageLoader.CallBack jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  
  public DiscoverBannerPlayPageLoader(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = new IDataProvider.GroupId(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localGroupInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localGroupInfo.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localGroupInfo.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack.b(new ErrorMessage(), Collections.singletonList(localGroupInfo), true);
  }
  
  public IDataProvider.StartInfo a()
  {
    return new IDataProvider.StartInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, null, null);
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack = paramCallBack;
    paramCallBack = ((DiscoverManager)SuperManager.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramCallBack != null) && (paramCallBack.bannerInfoList.size() == paramCallBack.totalCount) && (paramCallBack.totalCount > 0))
    {
      SLog.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramCallBack.totalCount));
      a(paramCallBack);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(@NonNull GetDiscoverBannerVideoRequest paramGetDiscoverBannerVideoRequest, @Nullable GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramGetDiscoverBannerVideoResponse == null))
    {
      SLog.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramGetDiscoverBannerVideoRequest.b);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (DiscoverManager)SuperManager.a(22);
    paramErrorMessage.a(paramGetDiscoverBannerVideoRequest.b, paramGetDiscoverBannerVideoResponse);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramGetDiscoverBannerVideoRequest.b);
    }
    if ((paramGetDiscoverBannerVideoResponse.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramGetDiscoverBannerVideoRequest.b, paramGetDiscoverBannerVideoResponse.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    AssertUtils.a(paramString1);
    GetDiscoverBannerVideoRequest localGetDiscoverBannerVideoRequest = new GetDiscoverBannerVideoRequest();
    localGetDiscoverBannerVideoRequest.b = paramString1;
    localGetDiscoverBannerVideoRequest.c = paramString2;
    CmdTaskManger.a().a(localGetDiscoverBannerVideoRequest, this);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DiscoverBannerPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */