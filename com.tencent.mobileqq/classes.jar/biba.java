import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter.2;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class biba
  implements biaj, biap
{
  private biak jdField_a_of_type_Biak;
  private bibc jdField_a_of_type_Bibc;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new bibb(this);
  private boolean jdField_a_of_type_Boolean;
  private RichStatus jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
  private boolean jdField_b_of_type_Boolean;
  
  public biba(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130846136);
  }
  
  public biba(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = paramVasResDrawable;
    this.jdField_a_of_type_Biak = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130847444;
    paramVasResDrawable.a().b = paramInt;
    paramVasResDrawable.a().jdField_a_of_type_JavaLangString = "sig_cover";
    paramVasResDrawable.a().e = 103;
    if (paramAppRuntime != null) {
      paramVasResDrawable.a("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
      {
        bool = true;
        QLog.d("SignatureAdapter", 2, bool);
      }
    }
    else
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("resType");
      }
      switch (i)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
    } while ((3 != paramInt) && (paramInt != 0));
    ThreadManager.excute(new SignatureAdapter.3(this, paramBundle), 128, null, true);
  }
  
  public void a(bibc parambibc)
  {
    this.jdField_a_of_type_Bibc = parambibc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Biak.a();
    bbux.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    bhzd localbhzd = bbux.a().a(i);
    if (!localbhzd.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((localbhzd.jdField_a_of_type_Bhzf == null) || (TextUtils.isEmpty(localbhzd.jdField_a_of_type_Bhzf.c))) {
        break label120;
      }
      this.jdField_a_of_type_JavaLangString = localbhzd.jdField_a_of_type_Bhzf.c;
    }
    for (;;)
    {
      bbux.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      if (this.jdField_a_of_type_Bibc != null) {
        this.jdField_a_of_type_Bibc.load(localbhzd);
      }
      if (!SignatureManager.a(localbhzd)) {
        break;
      }
      ThreadManager.excute(new SignatureAdapter.2(this, i, localbhzd), 128, null, true);
      return;
      label120:
      if (!TextUtils.isEmpty(localbhzd.s)) {
        this.jdField_a_of_type_JavaLangString = localbhzd.s;
      } else {
        this.jdField_a_of_type_JavaLangString = localbhzd.k;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Biak.a().sendEmptyMessage(10001);
  }
  
  public void c()
  {
    bbux.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biba
 * JD-Core Version:    0.7.0.1
 */