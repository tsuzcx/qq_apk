package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VidListPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
{
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private VidListPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo;
  
  public VidListPlayPageLoader(VidListPlayInfo paramVidListPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo = paramVidListPlayInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = new IDataProvider.GroupId("vidList");
  }
  
  public IDataProvider.StartInfo a()
  {
    return new IDataProvider.StartInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mStartVideoFeedId);
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localArrayList.add(localGroupInfo);
    localGroupInfo.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(paramInt);; str = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVideoFeedIdList.get(i - 1))
      {
        localGroupInfo.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceVidListPlayInfo.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramCallBack.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.VidListPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */