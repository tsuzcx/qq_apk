package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VidListDataProvider
  implements IDataProvider
{
  private IDataProvider.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
  private IDataProvider.GroupInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo;
  private IDataProvider.StartInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
  public final String a;
  public final List<String> a;
  
  public VidListDataProvider(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data = new IDataProvider.Data();
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
    paramString.b = true;
    paramString.jdField_a_of_type_Boolean = true;
    paramString.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo = new IDataProvider.GroupInfo(new IDataProvider.GroupId("TROOP_GROUD_ID"));
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo;
    paramString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramString.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    paramString.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, "TROOP_FEED_ID");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo = new IDataProvider.StartInfo(new IDataProvider.GroupId("TROOP_GROUD_ID"), this.jdField_a_of_type_JavaLangString, "TROOP_FEED_ID");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo;
  }
  
  public IDataProvider.Data a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
  }
  
  public IDataProvider.StartInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
  }
  
  public void a() {}
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, String paramString) {}
  
  public void a(IDataProvider.ICallBack paramICallBack) {}
  
  public void b() {}
  
  public void b(IDataProvider.ICallBack paramICallBack) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.VidListDataProvider
 * JD-Core Version:    0.7.0.1
 */