package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import nro;

public class ShareGroupVideoDataProvider
  extends MultiGroupVideoDataProvider
  implements IEventReceiver
{
  protected int a;
  protected ShareGroupVideoDataProvider.GetFeedIdVidListReceiver a;
  protected ShareGroupVideoDataProvider.GetShareGroupDateListReceiver a;
  protected ShareGroupVideoDataProvider.PlayerVideoListReceiver a;
  protected ShareGroupDateListPageLoader a;
  public final String a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected int c;
  protected String c;
  protected int d;
  protected int f;
  
  public ShareGroupVideoDataProvider(String paramString, int paramInt1, ArrayList paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = ("ShareGroupVideoDataProvider" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetShareGroupDateListReceiver = new ShareGroupVideoDataProvider.GetShareGroupDateListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$PlayerVideoListReceiver = new ShareGroupVideoDataProvider.PlayerVideoListReceiver(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetFeedIdVidListReceiver = new ShareGroupVideoDataProvider.GetFeedIdVidListReceiver(this);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.f = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader = new ShareGroupDateListPageLoader(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetShareGroupDateListReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$PlayerVideoListReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetFeedIdVidListReceiver);
  }
  
  public void a()
  {
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetShareGroupDateListReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$PlayerVideoListReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilShareGroupVideoDataProvider$GetFeedIdVidListReceiver);
    super.a();
  }
  
  public void a(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramPlayerVideoListEvent.jdField_a_of_type_JavaLangString)) {}
    while (!paramPlayerVideoListEvent.jdField_b_of_type_Boolean) {
      return;
    }
    VideoData localVideoData = new VideoData();
    if (paramPlayerVideoListEvent.errorInfo.isFail())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShareGroupVideoDataProvider", 2, "handleVideoListEvent: event.errorInfo.isFail()");
      }
      localVideoData.jdField_b_of_type_Int = paramPlayerVideoListEvent.errorInfo.errorCode;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      a(localVideoData);
      return;
      localVideoData.jdField_b_of_type_Int = 0;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
      localVideoData.jdField_a_of_type_JavaUtilList = paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList;
      localVideoData.jdField_c_of_type_Int = paramPlayerVideoListEvent.jdField_a_of_type_Int;
      localVideoData.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.d));
      if (this.e == 0) {
        localVideoData.d = this.f;
      }
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    paramArrayList = new BatchGetVideoInfo(paramArrayList);
    paramArrayList.a(new nro(this, paramArrayList, paramString));
    paramArrayList.b();
  }
  
  public void a(String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    VideoData localVideoData = new VideoData();
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShareGroupVideoDataProvider", 2, "handleVideoListEvent: event.errorInfo.isFail()");
      }
      localVideoData.jdField_b_of_type_Int = -1;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      a(localVideoData);
      return;
      localVideoData.jdField_b_of_type_Int = 0;
      localVideoData.jdField_a_of_type_Boolean = true;
      localVideoData.jdField_a_of_type_Int = this.e;
      localVideoData.jdField_a_of_type_JavaUtilList = paramArrayList;
      localVideoData.jdField_c_of_type_Int = paramArrayList.size();
      localVideoData.jdField_a_of_type_JavaLangString = paramString;
      if (this.e == 0) {
        localVideoData.d = this.f;
      }
    }
  }
  
  public boolean a()
  {
    int i = 2;
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.e = 0;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.d = this.jdField_b_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.d));
      ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
      String str = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        localShareGroupManager.a(str, i);
        return true;
        i = 1;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    int i = 2;
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.e = 1;
    if (d())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Int -= 1;
      this.d = this.jdField_b_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.d));
      ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
      String str = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        localShareGroupManager.a(str, i);
        return true;
        i = 1;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    int i = 2;
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.e = 2;
    if (this.jdField_c_of_type_Int + 1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Int += 1;
      this.d = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.d));
      ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
      String str = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        localShareGroupManager.a(str, i);
        return true;
        i = 1;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDateListPageLoader.c();
    return true;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Int > 0;
  }
  
  public boolean e()
  {
    return (this.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) || (!this.jdField_a_of_type_Boolean);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.ShareGroupVideoDataProvider
 * JD-Core Version:    0.7.0.1
 */