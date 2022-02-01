package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ShareFromMemoryPlayPageLoader$VidSyncer$1
  implements CmdTaskManger.CommandCallback<GetCollectionVideoListRequest, GetCollectionVideoListResponse>
{
  ShareFromMemoryPlayPageLoader$VidSyncer$1(ShareFromMemoryPlayPageLoader.VidSyncer paramVidSyncer, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack) {}
  
  public void a(@NonNull GetCollectionVideoListRequest paramGetCollectionVideoListRequest, @Nullable GetCollectionVideoListResponse paramGetCollectionVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetCollectionVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(paramErrorMessage, Collections.singletonList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
      return;
    }
    paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList);
    paramGetCollectionVideoListRequest = paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetCollectionVideoListRequest.hasNext()) {
      ((StoryVideoItem)paramGetCollectionVideoListRequest.next()).mOwnerUid = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).uid;
    }
    ((DownloadUrlManager)SuperManager.a(28)).a(paramGetCollectionVideoListResponse.b);
    paramGetCollectionVideoListRequest = paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetCollectionVideoListRequest.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramGetCollectionVideoListRequest.next();
      ShareFromMemoryPlayPageLoader.VidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer).add(paramErrorMessage.mVid);
    }
    if ((paramGetCollectionVideoListResponse.jdField_a_of_type_Boolean) || (paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramGetCollectionVideoListRequest = new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      paramGetCollectionVideoListRequest.jdField_a_of_type_JavaUtilList = ShareFromMemoryPlayPageLoader.VidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer);
      paramGetCollectionVideoListRequest.a(ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).feedId);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(Collections.singletonList(paramGetCollectionVideoListRequest), true);
      return;
    }
    ShareFromMemoryPlayPageLoader.VidSyncer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer);
    if (ShareFromMemoryPlayPageLoader.VidSyncer.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer) > 50)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader$VidSyncer.a(paramGetCollectionVideoListResponse.c, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$IVidFullSyncer$CallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader.VidSyncer.1
 * JD-Core Version:    0.7.0.1
 */