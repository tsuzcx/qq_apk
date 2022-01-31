package com.tencent.biz.qqstory.takevideo.publish;

import axir;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;
import ved;
import vsj;

public class GenerateVideoManifestSegment$1
  implements Runnable
{
  public GenerateVideoManifestSegment$1(vsj paramvsj, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      ved.a("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, before call AVideoCodec.recordSubmit()", this.a.jdField_a_of_type_JavaLangString);
      axir.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ved.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localUnsatisfiedLinkError });
      synchronized (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment.1
 * JD-Core Version:    0.7.0.1
 */