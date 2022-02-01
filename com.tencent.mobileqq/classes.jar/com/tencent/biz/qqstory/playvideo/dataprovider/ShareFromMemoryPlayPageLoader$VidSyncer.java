package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class ShareFromMemoryPlayPageLoader$VidSyncer
  implements IGroupPageLoader.IVidFullSyncer
{
  private int jdField_a_of_type_Int;
  IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ShareFromMemoryPlayPageLoader$VidSyncer(ShareFromMemoryPlayPageLoader paramShareFromMemoryPlayPageLoader, IDataProvider.GroupId paramGroupId)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
  }
  
  public void a(IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader), paramCallBack);
  }
  
  protected void a(String paramString, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.jdField_c_of_type_JavaLangString = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).uid;
    if (ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).collectionKey != null) {
      localGetCollectionVideoListRequest.jdField_d_of_type_Int = VideoCollectionEntry.getCollectionId(ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).collectionKey);
    }
    localGetCollectionVideoListRequest.jdField_d_of_type_JavaLangString = paramString;
    localGetCollectionVideoListRequest.jdField_c_of_type_Int = 20;
    localGetCollectionVideoListRequest.jdField_e_of_type_Int = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).shareTimeZone;
    localGetCollectionVideoListRequest.jdField_e_of_type_JavaLangString = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).feedId;
    localGetCollectionVideoListRequest.f = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).identify;
    localGetCollectionVideoListRequest.g = ShareFromMemoryPlayPageLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderShareFromMemoryPlayPageLoader).videoListOrder;
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new ShareFromMemoryPlayPageLoader.VidSyncer.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader.VidSyncer
 * JD-Core Version:    0.7.0.1
 */