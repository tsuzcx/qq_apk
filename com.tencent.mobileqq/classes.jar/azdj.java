import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.audio.AudioNewController.2;
import com.tencent.mobileqq.qassistant.audio.AudioNewController.3;
import com.tencent.mobileqq.qassistant.audio.AudioNewController.4;
import com.tencent.mobileqq.qassistant.audio.AudioNewController.5;
import com.tencent.mobileqq.qassistant.audio.AudioUploadThread;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class azdj
  implements azgc
{
  public volatile int a;
  private azdl jdField_a_of_type_Azdl;
  private volatile azdq jdField_a_of_type_Azdq;
  private volatile azds jdField_a_of_type_Azds = new azds();
  private azgd jdField_a_of_type_Azgd;
  private volatile AudioUploadThread jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread;
  private volatile QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(16000, 16000, 1);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  public volatile boolean a;
  private AtomicLong b = new AtomicLong(0L);
  
  public azdj()
  {
    this.jdField_a_of_type_Int = -1;
    azdw.a().a(this.jdField_a_of_type_Azds);
    this.jdField_a_of_type_Boolean = azhh.a().b;
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    azdo localazdo = new azdo(azeu.a());
    azdw.a().a(localazdo);
    boolean bool = this.jdField_a_of_type_Azdq.a(paramArrayOfByte);
    azdw.a().b(localazdo);
    if (this.jdField_a_of_type_Azgd != null) {
      this.jdField_a_of_type_Azgd.a(bool);
    }
    azdt localazdt = this.jdField_a_of_type_Azdq.a(paramArrayOfByte);
    localazdo.a(localazdt.jdField_a_of_type_ArrayOfByte, bool, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get(), paramArrayOfByte.length);
    azdw.a().c(localazdo);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() + paramArrayOfByte.length);
    this.jdField_a_of_type_Azds.a(paramArrayOfByte, localazdo);
    return localazdt.jdField_a_of_type_Int;
  }
  
  private azfz a()
  {
    return new azdk(this);
  }
  
  private void a(QQRecorder.RecorderParam paramRecorderParam, int paramInt)
  {
    if ((paramRecorderParam != null) && (paramRecorderParam.a != null))
    {
      paramRecorderParam.a[paramRecorderParam.f] = paramInt;
      if (paramRecorderParam.f < paramRecorderParam.a.length - 1) {
        paramRecorderParam.f += 1;
      }
    }
  }
  
  private void b(QQRecorder.RecorderParam paramRecorderParam, int paramInt)
  {
    if (paramRecorderParam != null)
    {
      paramRecorderParam.a = new int[paramInt / 1000 * 10];
      paramRecorderParam.f = 0;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_Azdl != null)
      {
        azeu.a("AudioNewController", "force release recorder...");
        this.jdField_a_of_type_Azdl.a(null);
        this.jdField_a_of_type_Azdl.a.set(false);
        this.jdField_a_of_type_Azdl.a();
        this.jdField_a_of_type_Azdl.b();
        this.jdField_a_of_type_Azdl = null;
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public azdu a()
  {
    long l2 = this.jdField_a_of_type_Azds.a();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.b.get();
    }
    return new azdu(this.jdField_a_of_type_Azds.a(), l1, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
  }
  
  public void a()
  {
    try
    {
      if ((a()) || (this.jdField_a_of_type_Azdl != null)) {
        f();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread != null)
      {
        azeu.a("AudioNewController", "quit voice transfer thread");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = null;
      }
      if (this.jdField_a_of_type_Azds != null)
      {
        azeu.a("AudioNewController", "force clear voice cache");
        this.jdField_a_of_type_Azds.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Azdq);
      }
      if (this.jdField_a_of_type_Azdq != null)
      {
        azeu.a("AudioNewController", "exit release silk encoder");
        this.jdField_a_of_type_Azdq.a();
        this.jdField_a_of_type_Azdq = null;
      }
      this.jdField_a_of_type_Int = -1;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((a()) || (this.jdField_a_of_type_Azdl != null)) {
        f();
      }
      azeu.a("AudioNewController", "invoked assistant recorder, type:" + paramInt);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.b.set(0L);
      this.jdField_a_of_type_Azds.a();
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = new AudioUploadThread(this.jdField_a_of_type_Int, this.jdField_a_of_type_Azds);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.start();
      }
      if (this.jdField_a_of_type_Azdq == null) {
        this.jdField_a_of_type_Azdq = new azdq(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      }
      this.jdField_a_of_type_Azdl = new azdl(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_Azdl.a(a());
      this.jdField_a_of_type_Azdl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      return;
    }
    finally {}
  }
  
  public void a(azgd paramazgd)
  {
    this.jdField_a_of_type_Azgd = paramazgd;
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof azfr))
    {
      paramObject = (azfr)paramObject;
      this.jdField_a_of_type_Azds.a(paramObject);
    }
    azeu.a("AudioNewController", "message on finish, invoke session");
    a();
    ThreadManager.getUIHandler().post(new AudioNewController.5(this));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Azdl != null) {
      return this.jdField_a_of_type_Azdl.a.get();
    }
    return false;
  }
  
  public boolean a(azga paramazga)
  {
    if ((a()) || (this.jdField_a_of_type_Azdl != null)) {
      f();
    }
    azeu.a("AudioNewController", "invoke wake recorder");
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Azdl = new azdl();
    return this.jdField_a_of_type_Azdl.a(paramazga);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      azeu.a("AudioNewController", "finishWakeRecorder..");
      f();
    }
  }
  
  public void c()
  {
    azeu.a("AudioNewController", "session on finish, invoke message");
    a();
    ThreadManager.getUIHandler().post(new AudioNewController.2(this));
  }
  
  public void d()
  {
    azeu.a("AudioNewController", "message on finish, invoke session");
    a();
    ThreadManager.getUIHandler().post(new AudioNewController.3(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Azds.a(null);
    azeu.a("AudioNewController", "message on finish, invoke session");
    a();
    ThreadManager.getUIHandler().post(new AudioNewController.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdj
 * JD-Core Version:    0.7.0.1
 */