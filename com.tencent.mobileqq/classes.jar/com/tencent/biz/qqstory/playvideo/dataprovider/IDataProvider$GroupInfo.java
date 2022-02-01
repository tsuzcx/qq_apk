package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IDataProvider$GroupInfo
  implements Cloneable
{
  public int a;
  public IDataProvider.GroupId a;
  @Nullable
  public String a;
  public List<String> a;
  public Map<String, String> a;
  private boolean a;
  
  public IDataProvider$GroupInfo(IDataProvider.GroupId paramGroupId)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    AssertUtils.a(paramGroupId);
    if ((paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      paramGroupId = ((MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId).a;
      if ((paramGroupId != null) && (paramGroupId.jdField_a_of_type_Int == 12)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public GroupInfo a()
  {
    GroupInfo localGroupInfo = new GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localGroupInfo.jdField_a_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localGroupInfo.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    localGroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localGroupInfo;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = (GroupInfo)paramObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId != null) {
        return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      }
    } while (paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    if ("gi{g=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId + ", fv=" + this.jdField_a_of_type_JavaLangString + ", vlist=" + this.jdField_a_of_type_JavaUtilList != null) {
      return String.valueOf(this.jdField_a_of_type_JavaUtilList.size());
    }
    return "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo
 * JD-Core Version:    0.7.0.1
 */