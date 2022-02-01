package com.tencent.biz.qqstory.takevideo.publish;

import bdby;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;
import yuk;
import ziq;

public class GenerateVideoManifestSegment$1
  implements Runnable
{
  public GenerateVideoManifestSegment$1(ziq paramziq, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      yuk.a("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, before call AVideoCodec.recordSubmit()", this.a.jdField_a_of_type_JavaLangString);
      bdby.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      yuk.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localUnsatisfiedLinkError });
      synchronized (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment.1
 * JD-Core Version:    0.7.0.1
 */