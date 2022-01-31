package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetDiscoverBannerVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nmr;

public class NewDiscoverBannerDataProvider
  extends MultiGroupVideoDataProvider
  implements IEventReceiver
{
  public int a;
  public GetDiscoverBannerVideoHandler a;
  public NewDiscoverBannerDataProvider.GetBannerInfoReceiver a;
  public VideoData a;
  public String a;
  public List a;
  public boolean a;
  public String b;
  public List b;
  public boolean b;
  public boolean c;
  public boolean d = true;
  
  public NewDiscoverBannerDataProvider(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider$GetBannerInfoReceiver = new NewDiscoverBannerDataProvider.GetBannerInfoReceiver(this);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData = new VideoData();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.jdField_a_of_type_JavaUtilList = new ArrayList();
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider$GetBannerInfoReceiver);
  }
  
  public void a()
  {
    super.a();
    this.d = false;
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilNewDiscoverBannerDataProvider$GetBannerInfoReceiver);
  }
  
  public void a(List paramList)
  {
    if (this.c) {
      return;
    }
    paramList = new BatchGetVideoInfo(paramList);
    paramList.a(new nmr(this, paramList));
    if (QLog.isColorLevel()) {
      QLog.d("NewDiscoverBannerDataProvider", 2, "start get video info");
    }
    this.c = true;
    paramList.b();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewDiscoverBannerDataProvider", 2, "load banner info from db");
      }
      DiscoverBannerVideoEntry localDiscoverBannerVideoEntry = ((DiscoverManager)SuperManager.a(22)).a(this.jdField_a_of_type_JavaLangString);
      if ((localDiscoverBannerVideoEntry != null) && (localDiscoverBannerVideoEntry.bannerInfoList != null))
      {
        this.jdField_a_of_type_Int = localDiscoverBannerVideoEntry.totalCount;
        Iterator localIterator = localDiscoverBannerVideoEntry.bannerInfoList.iterator();
        while (localIterator.hasNext())
        {
          DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)localIterator.next();
          this.jdField_b_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_b_of_type_JavaLangString);
        }
        if (localDiscoverBannerVideoEntry.bannerInfoList.size() == this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("NewDiscoverBannerDataProvider", 2, "banner info was completely hit. totalCount=" + this.jdField_a_of_type_Int);
          }
          a(this.jdField_b_of_type_JavaUtilList);
          b(this.jdField_a_of_type_JavaUtilList);
          return;
        }
        this.jdField_b_of_type_JavaLangString = localDiscoverBannerVideoEntry.nextCookie;
        if (QLog.isColorLevel()) {
          QLog.d("NewDiscoverBannerDataProvider", 2, "banner info was not completely hit. totalCount=" + this.jdField_a_of_type_Int + ", local count=" + localDiscoverBannerVideoEntry.bannerInfoList.size());
        }
        a(this.jdField_b_of_type_JavaUtilList);
        b(this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler = new GetDiscoverBannerVideoHandler();
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("NewDiscoverBannerDataProvider", 2, "load banner info from net. cookie=" + this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler.jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetDiscoverBannerVideoHandler.a();
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.b = -1;
      this.c = false;
      a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.b = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData.c = this.jdField_a_of_type_Int;
    this.c = false;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilVideoData);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewDiscoverBannerDataProvider", 2, "start get feed info");
    }
    GetFeedFeatureHandler.a(paramList);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean isValidate()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.NewDiscoverBannerDataProvider
 * JD-Core Version:    0.7.0.1
 */