import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.maxvideo.mediadevice.AVCodec;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class aomd
  implements Runnable
{
  public aomd(GenerateVideoManifestSegment paramGenerateVideoManifestSegment, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      SLog.a("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoCacheDir:%s, before call AVideoCodec.recordSubmit()", this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      SLog.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoCacheDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, localUnsatisfiedLinkError });
      synchronized (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomd
 * JD-Core Version:    0.7.0.1
 */