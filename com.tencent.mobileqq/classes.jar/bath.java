import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bath
  extends basy
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  bath(basx parambasx)
  {
    super(parambasx);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (basx.c(this.jdField_b_of_type_Basx).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((asdt.a()) && (basx.b(this.jdField_b_of_type_Basx) == 11))
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      basx.c(this.jdField_b_of_type_Basx).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(basx.e(this.jdField_b_of_type_Basx))) && (basx.e(this.jdField_b_of_type_Basx).length() > 150)) {
      basx.a(this.jdField_b_of_type_Basx).put("targetUrl", basx.e(this.jdField_b_of_type_Basx));
    }
    if (!TextUtils.isEmpty(basx.a(this.jdField_b_of_type_Basx).c)) {
      basx.a(this.jdField_b_of_type_Basx).put("sourceUrl", basx.a(this.jdField_b_of_type_Basx).c);
    }
    if (!TextUtils.isEmpty(basx.a(this.jdField_b_of_type_Basx).d)) {
      basx.a(this.jdField_b_of_type_Basx).put("sourceIcon", basx.a(this.jdField_b_of_type_Basx).d);
    }
    if ((basx.e(this.jdField_b_of_type_Basx) == 2) && (ndd.a(basx.h(this.jdField_b_of_type_Basx)))) {
      basx.a(this.jdField_b_of_type_Basx).put("audioUrl", basx.h(this.jdField_b_of_type_Basx));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(basx.a(this.jdField_b_of_type_Basx)))
    {
      basx.c(this.jdField_b_of_type_Basx, basx.a(this.jdField_b_of_type_Basx).e);
      basx.b(this.jdField_b_of_type_Basx).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + basx.a(this.jdField_b_of_type_Basx));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(basx.a(this.jdField_b_of_type_Basx))) {
        break label506;
      }
    }
    label506:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bfhz.a().a(localBundle, "" + basx.a(this.jdField_b_of_type_Basx), this.jdField_b_of_type_Basx.a.c(), false);
      if ((!basx.b(this.jdField_b_of_type_Basx).get()) && (ndd.a(basx.a(this.jdField_b_of_type_Basx)))) {
        basx.a(this.jdField_b_of_type_Basx).put("imageUrl", basx.a(this.jdField_b_of_type_Basx));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + basx.a(this.jdField_b_of_type_Basx).toString());
      }
      if (!basx.a(this.jdField_b_of_type_Basx).isEmpty()) {
        break;
      }
      basx.c(this.jdField_b_of_type_Basx).set(true);
      b();
      return;
    }
    ThreadManager.post(new ForwardSdkShareProcessor.UrlExchangeStep.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bath
 * JD-Core Version:    0.7.0.1
 */