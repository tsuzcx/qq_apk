import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class baoy
  extends baop
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  baoy(baoo parambaoo)
  {
    super(parambaoo);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (baoo.c(this.jdField_b_of_type_Baoo).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((arzk.a()) && (baoo.b(this.jdField_b_of_type_Baoo) == 11))
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      baoo.c(this.jdField_b_of_type_Baoo).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(baoo.e(this.jdField_b_of_type_Baoo))) && (baoo.e(this.jdField_b_of_type_Baoo).length() > 150)) {
      baoo.a(this.jdField_b_of_type_Baoo).put("targetUrl", baoo.e(this.jdField_b_of_type_Baoo));
    }
    if (!TextUtils.isEmpty(baoo.a(this.jdField_b_of_type_Baoo).c)) {
      baoo.a(this.jdField_b_of_type_Baoo).put("sourceUrl", baoo.a(this.jdField_b_of_type_Baoo).c);
    }
    if (!TextUtils.isEmpty(baoo.a(this.jdField_b_of_type_Baoo).d)) {
      baoo.a(this.jdField_b_of_type_Baoo).put("sourceIcon", baoo.a(this.jdField_b_of_type_Baoo).d);
    }
    if ((baoo.e(this.jdField_b_of_type_Baoo) == 2) && (ndd.a(baoo.h(this.jdField_b_of_type_Baoo)))) {
      baoo.a(this.jdField_b_of_type_Baoo).put("audioUrl", baoo.h(this.jdField_b_of_type_Baoo));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(baoo.a(this.jdField_b_of_type_Baoo)))
    {
      baoo.c(this.jdField_b_of_type_Baoo, baoo.a(this.jdField_b_of_type_Baoo).e);
      baoo.b(this.jdField_b_of_type_Baoo).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + baoo.a(this.jdField_b_of_type_Baoo));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(baoo.a(this.jdField_b_of_type_Baoo))) {
        break label506;
      }
    }
    label506:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bfdq.a().a(localBundle, "" + baoo.a(this.jdField_b_of_type_Baoo), this.jdField_b_of_type_Baoo.a.c(), false);
      if ((!baoo.b(this.jdField_b_of_type_Baoo).get()) && (ndd.a(baoo.a(this.jdField_b_of_type_Baoo)))) {
        baoo.a(this.jdField_b_of_type_Baoo).put("imageUrl", baoo.a(this.jdField_b_of_type_Baoo));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + baoo.a(this.jdField_b_of_type_Baoo).toString());
      }
      if (!baoo.a(this.jdField_b_of_type_Baoo).isEmpty()) {
        break;
      }
      baoo.c(this.jdField_b_of_type_Baoo).set(true);
      b();
      return;
    }
    ThreadManager.post(new ForwardSdkShareProcessor.UrlExchangeStep.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoy
 * JD-Core Version:    0.7.0.1
 */