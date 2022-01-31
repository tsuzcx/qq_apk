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

public class bbsp
  implements bbrz, bbsf
{
  private bbsa jdField_a_of_type_Bbsa;
  private bbsr jdField_a_of_type_Bbsr;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new bbsq(this);
  private boolean jdField_a_of_type_Boolean;
  private RichStatus jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
  private boolean jdField_b_of_type_Boolean;
  
  public bbsp(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130845272);
  }
  
  public bbsp(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = paramVasResDrawable;
    this.jdField_a_of_type_Bbsa = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130846516;
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
    ThreadManager.executeOnFileThread(new SignatureAdapter.3(this, paramBundle));
  }
  
  public void a(bbsr parambbsr)
  {
    this.jdField_a_of_type_Bbsr = parambbsr;
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
    int i = this.jdField_a_of_type_Bbsa.a();
    awek.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    bbqs localbbqs = awek.a().a(i);
    if (!localbbqs.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((localbbqs.jdField_a_of_type_Bbqu == null) || (TextUtils.isEmpty(localbbqs.jdField_a_of_type_Bbqu.c))) {
        break label115;
      }
      this.jdField_a_of_type_JavaLangString = localbbqs.jdField_a_of_type_Bbqu.c;
    }
    for (;;)
    {
      awek.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      if (this.jdField_a_of_type_Bbsr != null) {
        this.jdField_a_of_type_Bbsr.load(localbbqs);
      }
      if (!SignatureManager.a(localbbqs)) {
        break;
      }
      ThreadManager.executeOnFileThread(new SignatureAdapter.2(this, i, localbbqs));
      return;
      label115:
      if (!TextUtils.isEmpty(localbbqs.s)) {
        this.jdField_a_of_type_JavaLangString = localbbqs.s;
      } else {
        this.jdField_a_of_type_JavaLangString = localbbqs.k;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bbsa.a().sendEmptyMessage(10001);
  }
  
  public void c()
  {
    awek.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsp
 * JD-Core Version:    0.7.0.1
 */