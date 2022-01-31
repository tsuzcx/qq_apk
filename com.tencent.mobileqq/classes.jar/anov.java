import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkPlayer;
import com.tencent.ark.ark.PlayerStubFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMediaPlayer.2;
import com.tencent.mobileqq.ark.ArkMediaPlayer.3;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class anov
  extends ArkPlayer
{
  public static final ark.PlayerStubFactory a;
  private static final Set<WeakReference<anov>> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = this.jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComTencentArkArk$PlayerStubFactory = new anow();
  }
  
  protected anov()
  {
    jdField_a_of_type_JavaUtilSet.add(new WeakReference(this));
    ENV.logI("Ark.ArkMediaPlayer", String.format("ArkMediaPlayer.create.%h", new Object[] { this }));
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (anov)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((anov)localObject2).c();
          }
        }
      }
    }
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (anov)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((anov)localObject2).d();
          }
        }
      }
    }
  }
  
  public boolean Pause()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = this.d;
    }
    return super.Pause();
  }
  
  public boolean Play()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = this.b;
    }
    return super.Play();
  }
  
  public boolean Resume()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = this.e;
    }
    return super.Resume();
  }
  
  public boolean Stop()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = this.c;
    }
    return super.Stop();
  }
  
  public void c()
  {
    ArkAppCenter.a().post(this.mQueueKey, new ArkMediaPlayer.2(this));
  }
  
  public void d()
  {
    ArkAppCenter.a().post(this.mQueueKey, new ArkMediaPlayer.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anov
 * JD-Core Version:    0.7.0.1
 */