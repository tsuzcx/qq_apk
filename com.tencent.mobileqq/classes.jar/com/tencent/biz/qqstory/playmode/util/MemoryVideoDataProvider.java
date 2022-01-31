package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.model.MemoryPlayingListSync;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;

public class MemoryVideoDataProvider
  extends MultiGroupVideoDataProvider
  implements IEventReceiver
{
  protected int a;
  protected DefaultPlayerVideoListSynchronizer a;
  protected MemoryVideoDataProvider.GetMemoryKeyListReceiver a;
  protected MemoryVideoDataProvider.PlayerVideoListReceiver a;
  protected MemoryDataPuller a;
  public final String a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  protected String b;
  protected ArrayList b;
  protected boolean b;
  protected int c;
  protected String c;
  protected int d;
  
  public MemoryVideoDataProvider(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$GetMemoryKeyListReceiver = new MemoryVideoDataProvider.GetMemoryKeyListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$PlayerVideoListReceiver = new MemoryVideoDataProvider.PlayerVideoListReceiver(this, this);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.d = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller = new MemoryDataPuller(paramString, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a();
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$GetMemoryKeyListReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$PlayerVideoListReceiver);
  }
  
  public void a()
  {
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$GetMemoryKeyListReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMemoryVideoDataProvider$PlayerVideoListReceiver);
    super.a();
  }
  
  public void a(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramPlayerVideoListEvent.jdField_a_of_type_JavaLangString)) {}
    while (!paramPlayerVideoListEvent.jdField_b_of_type_Boolean) {
      return;
    }
    VideoData localVideoData = new VideoData();
    if (paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemoryVideoDataProvider", 2, "handleVideoListEvent: event.errorInfo.isFail()");
      }
      localVideoData.jdField_b_of_type_Int = paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
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
      localVideoData.jdField_a_of_type_JavaLangString = ((String)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int));
      if (this.e == 0) {
        localVideoData.d = this.d;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean) {
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
        } while (this.jdField_a_of_type_JavaUtilArrayList == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_Int < 0);
      bool1 = bool2;
    } while (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new MemoryPlayingListSync(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.e = 1;
    if (d())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int -= 1;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int));
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new MemoryPlayingListSync(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.e = 2;
    if (this.jdField_b_of_type_Int + 1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Int += 1;
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int));
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new MemoryPlayingListSync(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
      return true;
    }
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    Object localObject = (MemoryManager)SuperManager.a(19);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (localObject = ((MemoryManager)localObject).a(this.jdField_b_of_type_JavaLangString);; localObject = null)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a((VideoCollectionItem)localObject);
      }
      for (;;)
      {
        return true;
        SLog.d("MemoryVideoDataProvider", "cannot find collection item , key = %s", new Object[] { this.jdField_b_of_type_JavaLangString });
      }
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int > 0;
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) || (!this.jdField_a_of_type_Boolean);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MemoryVideoDataProvider
 * JD-Core Version:    0.7.0.1
 */