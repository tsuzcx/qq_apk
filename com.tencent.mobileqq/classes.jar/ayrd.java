import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ayrd
  extends ayqu
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  ayrd(ayqt paramayqt)
  {
    super(paramayqt);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (ayqt.c(this.jdField_b_of_type_Ayqt).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((aqfv.a()) && (ayqt.b(this.jdField_b_of_type_Ayqt) == 11))
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      ayqt.c(this.jdField_b_of_type_Ayqt).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(ayqt.e(this.jdField_b_of_type_Ayqt))) && (ayqt.e(this.jdField_b_of_type_Ayqt).length() > 150)) {
      ayqt.a(this.jdField_b_of_type_Ayqt).put("targetUrl", ayqt.e(this.jdField_b_of_type_Ayqt));
    }
    if (!TextUtils.isEmpty(ayqt.a(this.jdField_b_of_type_Ayqt).c)) {
      ayqt.a(this.jdField_b_of_type_Ayqt).put("sourceUrl", ayqt.a(this.jdField_b_of_type_Ayqt).c);
    }
    if (!TextUtils.isEmpty(ayqt.a(this.jdField_b_of_type_Ayqt).d)) {
      ayqt.a(this.jdField_b_of_type_Ayqt).put("sourceIcon", ayqt.a(this.jdField_b_of_type_Ayqt).d);
    }
    if ((ayqt.e(this.jdField_b_of_type_Ayqt) == 2) && (naj.a(ayqt.h(this.jdField_b_of_type_Ayqt)))) {
      ayqt.a(this.jdField_b_of_type_Ayqt).put("audioUrl", ayqt.h(this.jdField_b_of_type_Ayqt));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(ayqt.a(this.jdField_b_of_type_Ayqt)))
    {
      ayqt.c(this.jdField_b_of_type_Ayqt, ayqt.a(this.jdField_b_of_type_Ayqt).e);
      ayqt.b(this.jdField_b_of_type_Ayqt).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + ayqt.a(this.jdField_b_of_type_Ayqt));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(ayqt.a(this.jdField_b_of_type_Ayqt))) {
        break label506;
      }
    }
    label506:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bdes.a().a(localBundle, "" + ayqt.a(this.jdField_b_of_type_Ayqt), this.jdField_b_of_type_Ayqt.a.c(), false);
      if ((!ayqt.b(this.jdField_b_of_type_Ayqt).get()) && (naj.a(ayqt.a(this.jdField_b_of_type_Ayqt)))) {
        ayqt.a(this.jdField_b_of_type_Ayqt).put("imageUrl", ayqt.a(this.jdField_b_of_type_Ayqt));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + ayqt.a(this.jdField_b_of_type_Ayqt).toString());
      }
      if (!ayqt.a(this.jdField_b_of_type_Ayqt).isEmpty()) {
        break;
      }
      ayqt.c(this.jdField_b_of_type_Ayqt).set(true);
      b();
      return;
    }
    ThreadManager.post(new ForwardSdkShareProcessor.UrlExchangeStep.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrd
 * JD-Core Version:    0.7.0.1
 */