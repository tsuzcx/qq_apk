package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import nml;
import nmm;
import nmn;

public class DiscoverVideoDataProvider
  extends MultiGroupVideoDataProvider
{
  protected int a;
  protected CardItem.CardVideoInfo a;
  protected List a;
  protected boolean a;
  protected int b;
  protected int c;
  
  public DiscoverVideoDataProvider(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramInt;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Int > 0) {
      i = paramInt - 1;
    }
    paramInt = this.jdField_a_of_type_Int;
    while (paramInt <= this.b)
    {
      if (i - ((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a().size() < 0) {
        return paramInt;
      }
      i -= ((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a().size();
      paramInt += 1;
    }
    return 0;
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    VideoData localVideoData = new VideoData();
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiscoverVideoDataProvider", 2, "handleVideoListEvent: event.errorInfo.isFail()");
      }
      localVideoData.b = -1;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      a(localVideoData);
      return;
      localVideoData.b = 0;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
      localVideoData.jdField_a_of_type_JavaUtilList = paramArrayList;
      localVideoData.c = paramArrayList.size();
      localVideoData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo.c();
      if (this.e == 0) {
        localVideoData.d = 0;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Boolean) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          this.e = 0;
          bool1 = bool2;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_Int < 0);
      bool1 = bool2;
    } while (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_Boolean = true;
    this.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = ((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.c));
    BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo.a());
    localBatchGetVideoInfo.a(new nml(this, localBatchGetVideoInfo));
    localBatchGetVideoInfo.b();
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.e = 1;
    if (d())
    {
      this.jdField_a_of_type_Boolean = true;
      this.b += 1;
      this.c = this.b;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = ((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.c));
      BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo.a());
      localBatchGetVideoInfo.a(new nmm(this, localBatchGetVideoInfo));
      localBatchGetVideoInfo.b();
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.e = 2;
    if (e())
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int -= 1;
      this.c = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = ((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.c));
      BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo.a());
      localBatchGetVideoInfo.a(new nmn(this, localBatchGetVideoInfo));
      localBatchGetVideoInfo.b();
      return true;
    }
    return false;
  }
  
  public boolean d()
  {
    return this.b < this.jdField_a_of_type_JavaUtilList.size() - 1;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Int > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.DiscoverVideoDataProvider
 * JD-Core Version:    0.7.0.1
 */