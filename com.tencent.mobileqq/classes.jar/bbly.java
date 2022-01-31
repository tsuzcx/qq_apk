import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.VoicePlayer.1;
import com.tencent.mobileqq.utils.VoicePlayer.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bbly
  implements avch
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private avcg jdField_a_of_type_Avcg;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VoicePlayer.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bblz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public bbly(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Avcg = new AmrPlayer(paramContext, paramInt);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
  }
  
  public bbly(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
  }
  
  public bbly(String paramString, Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramInt == 0) {
      this.jdField_a_of_type_Avcg = new AmrPlayer();
    }
    for (this.jdField_b_of_type_Int = 2;; this.jdField_b_of_type_Int = 3)
    {
      this.jdField_a_of_type_Int = 1;
      return;
      this.jdField_a_of_type_Avcg = new SilkPlayer();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (this.jdField_b_of_type_Boolean) {
      bbcf.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Int = 8;; this.jdField_a_of_type_Int = 4)
    {
      if (this.jdField_a_of_type_Avcg != null)
      {
        i = j;
        if (this.jdField_a_of_type_Int == 4) {
          i = this.jdField_a_of_type_Avcg.b();
        }
        this.jdField_a_of_type_Avcg.e();
        this.jdField_a_of_type_Avcg = null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bblz)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, i);
      }
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_Avcg != null) {
      return this.jdField_a_of_type_Avcg.a();
    }
    return 0;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_Avcg != null) {
      return this.jdField_a_of_type_Avcg.b();
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
  
  public void a(avcf paramavcf)
  {
    if (a()) {
      ((SilkPlayer)this.jdField_a_of_type_Avcg).a(paramavcf);
    }
  }
  
  public void a(avcg paramavcg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    a(true);
  }
  
  public void a(bblz parambblz)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambblz)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambblz);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Avcg != null) && ((this.jdField_a_of_type_Avcg instanceof SilkPlayer));
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
    this.jdField_a_of_type_Avcg.b(paramInt);
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
          this.jdField_a_of_type_Avcg.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Avcg.g();
        }
        this.jdField_a_of_type_Avcg.a(this);
        this.jdField_a_of_type_Avcg.a();
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
        bbcf.a(this.jdField_a_of_type_AndroidContentContext, true);
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
        this.jdField_a_of_type_Avcg.a();
        if (this.jdField_b_of_type_Boolean) {
          bbcf.a(this.jdField_a_of_type_AndroidContentContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Avcg instanceof AmrPlayer))
    {
      this.jdField_a_of_type_Int = 2;
      ((AmrPlayer)this.jdField_a_of_type_Avcg).b();
      if (this.jdField_b_of_type_Boolean) {
        bbcf.a(this.jdField_a_of_type_AndroidContentContext, true);
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
        bbcf.a(this.jdField_a_of_type_AndroidContentContext, false);
      }
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Avcg.f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bblz)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, c(), b());
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean) {
      bbcf.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.jdField_a_of_type_Int = 6;
    if (this.jdField_a_of_type_Avcg != null)
    {
      this.jdField_a_of_type_Avcg.c();
      this.jdField_a_of_type_Avcg.e();
      this.jdField_a_of_type_Avcg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbly
 * JD-Core Version:    0.7.0.1
 */