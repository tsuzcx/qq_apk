package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;
import ndo;
import ndp;
import ndq;

public class VideoServerInfoManager
  extends BaseManger
{
  public long a;
  public VideoServerInfoManager.ServerInfo a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  public final Object b;
  public AtomicBoolean b;
  
  public VideoServerInfoManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo = new VideoServerInfoManager.ServerInfo();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new ndq(this, null);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.b()) {
      d();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    SLog.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo);
    RefreshVideoFileKeyRequest localRefreshVideoFileKeyRequest = new RefreshVideoFileKeyRequest();
    CmdTaskManger.a().a(localRefreshVideoFileKeyRequest, new ndp(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return HexUtil.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Bosses.get().postJob(new ndo(this));
  }
  
  public byte[] a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a;
    }
    d();
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(30000L);
        SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo;
        if (((VideoServerInfoManager.ServerInfo)???).a()) {
          return ((VideoServerInfoManager.ServerInfo)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          SLog.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((VideoServerInfoManager.ServerInfo)???).a;
  }
  
  public String b()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.b())
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a;
      if (arrayOfByte != null) {
        return HexUtil.a(arrayOfByte);
      }
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager
 * JD-Core Version:    0.7.0.1
 */