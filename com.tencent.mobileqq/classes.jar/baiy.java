import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.audio.AudioNewController.1;
import com.tencent.mobileqq.qassistant.audio.AudioUploadThread;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class baiy
  implements balt
{
  public volatile int a;
  protected baja a;
  protected volatile bajf a;
  protected volatile bajh a;
  protected balu a;
  protected volatile AudioUploadThread a;
  protected volatile QQRecorder.RecorderParam a;
  protected AtomicLong a;
  public volatile boolean a;
  protected AtomicLong b = new AtomicLong(0L);
  
  public baiy()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(16000, 16000, 1);
    this.jdField_a_of_type_Bajh = new bajh();
    bajl.a().a(this.jdField_a_of_type_Bajh);
    this.jdField_a_of_type_Boolean = banp.a().b;
  }
  
  protected int a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_Bajh == null) || (this.jdField_a_of_type_Bajf == null)) {
      return 2000;
    }
    bajd localbajd = new bajd(bakl.a());
    bajl.a().a(localbajd);
    boolean bool = this.jdField_a_of_type_Bajf.a(paramArrayOfByte);
    bajl.a().b(localbajd);
    if (this.jdField_a_of_type_Balu != null) {
      this.jdField_a_of_type_Balu.a(bool);
    }
    baji localbaji = this.jdField_a_of_type_Bajf.a(paramArrayOfByte);
    localbajd.a(localbaji.jdField_a_of_type_ArrayOfByte, bool, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get(), paramArrayOfByte.length);
    bajl.a().c(localbajd);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() + paramArrayOfByte.length);
    this.jdField_a_of_type_Bajh.a(paramArrayOfByte, localbajd);
    return localbaji.jdField_a_of_type_Int;
  }
  
  public bajj a()
  {
    long l2 = this.jdField_a_of_type_Bajh.a();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.b.get();
    }
    return new bajj(this.jdField_a_of_type_Bajh.a(), l1, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
  }
  
  protected balq a()
  {
    return new baiz(this);
  }
  
  public void a()
  {
    try
    {
      if ((a()) || (this.jdField_a_of_type_Baja != null)) {
        c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread != null)
      {
        bakl.a("AudioNewController", "quit voice transfer thread");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = null;
      }
      if (this.jdField_a_of_type_Bajh != null)
      {
        bakl.a("AudioNewController", "force clear voice cache");
        this.jdField_a_of_type_Bajh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bajf);
      }
      if (this.jdField_a_of_type_Bajf != null)
      {
        bakl.a("AudioNewController", "exit release silk encoder");
        this.jdField_a_of_type_Bajf.a();
        this.jdField_a_of_type_Bajf = null;
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
      if ((a()) || (this.jdField_a_of_type_Baja != null)) {
        c();
      }
      bakl.a("AudioNewController", "invoked assistant recorder, type:" + paramInt);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.b.set(0L);
      this.jdField_a_of_type_Bajh.a();
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = new AudioUploadThread(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bajh);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.start();
      }
      if (this.jdField_a_of_type_Bajf == null) {
        this.jdField_a_of_type_Bajf = new bajf(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      }
      this.jdField_a_of_type_Baja = new baja(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_Baja.a(a());
      this.jdField_a_of_type_Baja.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      return;
    }
    finally {}
  }
  
  public void a(balu parambalu)
  {
    this.jdField_a_of_type_Balu = parambalu;
  }
  
  protected void a(QQRecorder.RecorderParam paramRecorderParam, int paramInt)
  {
    if ((paramRecorderParam != null) && (paramRecorderParam.a != null))
    {
      paramRecorderParam.a[paramRecorderParam.f] = paramInt;
      if (paramRecorderParam.f < paramRecorderParam.a.length - 1) {
        paramRecorderParam.f += 1;
      }
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof bali))
    {
      paramObject = (bali)paramObject;
      this.jdField_a_of_type_Bajh.a(paramObject);
    }
    bakl.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Baja != null) {
      return this.jdField_a_of_type_Baja.a.get();
    }
    return false;
  }
  
  public boolean a(balr parambalr)
  {
    if ((a()) || (this.jdField_a_of_type_Baja != null)) {
      c();
    }
    bakl.a("AudioNewController", "invoke wake recorder");
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Baja = new baja();
    return this.jdField_a_of_type_Baja.a(parambalr);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bakl.a("AudioNewController", "finishWakeRecorder..");
      c();
    }
  }
  
  public void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AudioNewController.1(this, paramInt));
  }
  
  protected void b(QQRecorder.RecorderParam paramRecorderParam, int paramInt)
  {
    if (paramRecorderParam != null)
    {
      paramRecorderParam.a = new int[paramInt / 1000 * 10];
      paramRecorderParam.f = 0;
    }
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_Baja != null)
      {
        bakl.a("AudioNewController", "force release recorder...");
        this.jdField_a_of_type_Baja.a(null);
        this.jdField_a_of_type_Baja.a.set(false);
        this.jdField_a_of_type_Baja.a();
        this.jdField_a_of_type_Baja.b();
        this.jdField_a_of_type_Baja = null;
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
  
  public void d()
  {
    bakl.a("AudioNewController", "session on finish, invoke message");
    a();
    b(2);
  }
  
  public void e()
  {
    bakl.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Bajh.a(null);
    bakl.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiy
 * JD-Core Version:    0.7.0.1
 */