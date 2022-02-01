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

public class bhqf
  implements bhpn, bhpt
{
  private bhpo jdField_a_of_type_Bhpo;
  private bhqh jdField_a_of_type_Bhqh;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new bhqg(this);
  private boolean jdField_a_of_type_Boolean;
  private RichStatus jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
  private boolean jdField_b_of_type_Boolean;
  
  public bhqf(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130846115);
  }
  
  public bhqf(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = paramVasResDrawable;
    this.jdField_a_of_type_Bhpo = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130847441;
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
  
  public void a(bhqh parambhqh)
  {
    this.jdField_a_of_type_Bhqh = parambhqh;
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
    int i = this.jdField_a_of_type_Bhpo.a();
    bbvh.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    bhoj localbhoj = bbvh.a().a(i);
    if (!localbhoj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((localbhoj.jdField_a_of_type_Bhol == null) || (TextUtils.isEmpty(localbhoj.jdField_a_of_type_Bhol.c))) {
        break label120;
      }
      this.jdField_a_of_type_JavaLangString = localbhoj.jdField_a_of_type_Bhol.c;
    }
    for (;;)
    {
      bbvh.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      if (this.jdField_a_of_type_Bhqh != null) {
        this.jdField_a_of_type_Bhqh.load(localbhoj);
      }
      if (!SignatureManager.a(localbhoj)) {
        break;
      }
      ThreadManager.excute(new SignatureAdapter.2(this, i, localbhoj), 128, null, true);
      return;
      label120:
      if (!TextUtils.isEmpty(localbhoj.s)) {
        this.jdField_a_of_type_JavaLangString = localbhoj.s;
      } else {
        this.jdField_a_of_type_JavaLangString = localbhoj.k;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bhpo.a().sendEmptyMessage(10001);
  }
  
  public void c()
  {
    bbvh.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqf
 * JD-Core Version:    0.7.0.1
 */