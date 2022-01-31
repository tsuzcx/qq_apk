import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ayrb
  extends ayqs
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  ayrb(ayqr paramayqr)
  {
    super(paramayqr);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (ayqr.c(this.jdField_b_of_type_Ayqr).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((aqft.a()) && (ayqr.b(this.jdField_b_of_type_Ayqr) == 11))
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      ayqr.c(this.jdField_b_of_type_Ayqr).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(ayqr.e(this.jdField_b_of_type_Ayqr))) && (ayqr.e(this.jdField_b_of_type_Ayqr).length() > 150)) {
      ayqr.a(this.jdField_b_of_type_Ayqr).put("targetUrl", ayqr.e(this.jdField_b_of_type_Ayqr));
    }
    if (!TextUtils.isEmpty(ayqr.a(this.jdField_b_of_type_Ayqr).c)) {
      ayqr.a(this.jdField_b_of_type_Ayqr).put("sourceUrl", ayqr.a(this.jdField_b_of_type_Ayqr).c);
    }
    if (!TextUtils.isEmpty(ayqr.a(this.jdField_b_of_type_Ayqr).d)) {
      ayqr.a(this.jdField_b_of_type_Ayqr).put("sourceIcon", ayqr.a(this.jdField_b_of_type_Ayqr).d);
    }
    if ((ayqr.e(this.jdField_b_of_type_Ayqr) == 2) && (nam.a(ayqr.h(this.jdField_b_of_type_Ayqr)))) {
      ayqr.a(this.jdField_b_of_type_Ayqr).put("audioUrl", ayqr.h(this.jdField_b_of_type_Ayqr));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(ayqr.a(this.jdField_b_of_type_Ayqr)))
    {
      ayqr.c(this.jdField_b_of_type_Ayqr, ayqr.a(this.jdField_b_of_type_Ayqr).e);
      ayqr.b(this.jdField_b_of_type_Ayqr).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + ayqr.a(this.jdField_b_of_type_Ayqr));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(ayqr.a(this.jdField_b_of_type_Ayqr))) {
        break label506;
      }
    }
    label506:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bded.a().a(localBundle, "" + ayqr.a(this.jdField_b_of_type_Ayqr), this.jdField_b_of_type_Ayqr.a.c(), false);
      if ((!ayqr.b(this.jdField_b_of_type_Ayqr).get()) && (nam.a(ayqr.a(this.jdField_b_of_type_Ayqr)))) {
        ayqr.a(this.jdField_b_of_type_Ayqr).put("imageUrl", ayqr.a(this.jdField_b_of_type_Ayqr));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + ayqr.a(this.jdField_b_of_type_Ayqr).toString());
      }
      if (!ayqr.a(this.jdField_b_of_type_Ayqr).isEmpty()) {
        break;
      }
      ayqr.c(this.jdField_b_of_type_Ayqr).set(true);
      b();
      return;
    }
    ThreadManager.post(new ForwardSdkShareProcessor.UrlExchangeStep.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrb
 * JD-Core Version:    0.7.0.1
 */