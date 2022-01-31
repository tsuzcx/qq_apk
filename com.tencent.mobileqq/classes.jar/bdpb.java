import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.VoicePlayer.1;
import com.tencent.mobileqq.utils.VoicePlayer.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bdpb
  implements awyd
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private awyc jdField_a_of_type_Awyc;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VoicePlayer.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bdpc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public bdpb(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Awyc = new AmrPlayer(paramContext, paramInt);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
  }
  
  public bdpb(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
  }
  
  public bdpb(String paramString, Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramInt == 0) {
      this.jdField_a_of_type_Awyc = new AmrPlayer();
    }
    for (this.jdField_b_of_type_Int = 2;; this.jdField_b_of_type_Int = 3)
    {
      this.jdField_a_of_type_Int = 1;
      return;
      this.jdField_a_of_type_Awyc = new SilkPlayer();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (this.jdField_b_of_type_Boolean) {
      bdfi.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Int = 8;; this.jdField_a_of_type_Int = 4)
    {
      if (this.jdField_a_of_type_Awyc != null)
      {
        i = j;
        if (this.jdField_a_of_type_Int == 4) {
          i = this.jdField_a_of_type_Awyc.b();
        }
        this.jdField_a_of_type_Awyc.e();
        this.jdField_a_of_type_Awyc = null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bdpc)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, i);
      }
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Awyc != null) {
      return this.jdField_a_of_type_Awyc.a();
    }
    return 0;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_Awyc != null) {
      return this.jdField_a_of_type_Awyc.b();
    }
    return 0;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + c() + " current=" + b() + " enableEndBuffer=" + this.jdField_a_of_type_Boolean + " thread=" + Thread.currentThread().getName());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoicePlayer.2(this), 500L);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt) {}
  
  public void a(awyb paramawyb)
  {
    if (a()) {
      ((SilkPlayer)this.jdField_a_of_type_Awyc).a(paramawyb);
    }
  }
  
  public void a(awyc paramawyc, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    a(true);
  }
  
  public void a(bdpc parambdpc)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambdpc)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambdpc);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Awyc != null) && ((this.jdField_a_of_type_Awyc instanceof SilkPlayer));
  }
  
  public boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Awyc.b(paramInt);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      try
      {
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_b_of_type_Int != 1)
        {
          this.jdField_a_of_type_Awyc.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Awyc.g();
        }
        this.jdField_a_of_type_Awyc.a(this);
        this.jdField_a_of_type_Awyc.a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          a(true);
        }
      }
      if (this.jdField_b_of_type_Boolean) {
        bdfi.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Awyc.a();
        if (this.jdField_b_of_type_Boolean) {
          bdfi.a(this.jdField_a_of_type_AndroidContentContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Awyc instanceof AmrPlayer))
    {
      this.jdField_a_of_type_Int = 2;
      ((AmrPlayer)this.jdField_a_of_type_Awyc).b();
      if (this.jdField_b_of_type_Boolean) {
        bdfi.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 7) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Boolean) {
        bdfi.a(this.jdField_a_of_type_AndroidContentContext, false);
      }
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Awyc.f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bdpc)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, c(), b());
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean) {
      bdfi.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.jdField_a_of_type_Int = 6;
    if (this.jdField_a_of_type_Awyc != null)
    {
      this.jdField_a_of_type_Awyc.c();
      this.jdField_a_of_type_Awyc.e();
      this.jdField_a_of_type_Awyc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpb
 * JD-Core Version:    0.7.0.1
 */