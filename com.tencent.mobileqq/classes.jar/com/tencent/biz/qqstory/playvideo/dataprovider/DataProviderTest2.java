package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader;

public class DataProviderTest2
{
  private IDataProvider.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private IDataProvider.ICallBack jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$ICallBack = new DataProviderTest2.1(this);
  public SimpleDataProvider a;
  private PlayerDataPreLoader jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader;
  private IDataProvider.ICallBack b = new DataProviderTest2.2(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider = new SimpleDataProvider(new MsgTabPlayPageLoader(paramMsgTabPlayInfo));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader = new PlayerDataPreLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider = new SimpleDataProvider(new HomeFeedPlayPageLoader(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader = new PlayerDataPreLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.a(this.b);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$ICallBack);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.b(this.b);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$ICallBack);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DataProviderTest2
 * JD-Core Version:    0.7.0.1
 */