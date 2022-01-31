import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class axqu
  extends axql
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  axqu(axqk paramaxqk)
  {
    super(paramaxqk);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (axqk.c(this.jdField_b_of_type_Axqk).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((apmf.a()) && (axqk.b(this.jdField_b_of_type_Axqk) == 11))
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      axqk.c(this.jdField_b_of_type_Axqk).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(axqk.e(this.jdField_b_of_type_Axqk))) && (axqk.e(this.jdField_b_of_type_Axqk).length() > 150)) {
      axqk.a(this.jdField_b_of_type_Axqk).put("targetUrl", axqk.e(this.jdField_b_of_type_Axqk));
    }
    if (!TextUtils.isEmpty(axqk.a(this.jdField_b_of_type_Axqk).c)) {
      axqk.a(this.jdField_b_of_type_Axqk).put("sourceUrl", axqk.a(this.jdField_b_of_type_Axqk).c);
    }
    if (!TextUtils.isEmpty(axqk.a(this.jdField_b_of_type_Axqk).d)) {
      axqk.a(this.jdField_b_of_type_Axqk).put("sourceIcon", axqk.a(this.jdField_b_of_type_Axqk).d);
    }
    if ((axqk.e(this.jdField_b_of_type_Axqk) == 2) && (mpl.a(axqk.h(this.jdField_b_of_type_Axqk)))) {
      axqk.a(this.jdField_b_of_type_Axqk).put("audioUrl", axqk.h(this.jdField_b_of_type_Axqk));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(axqk.a(this.jdField_b_of_type_Axqk)))
    {
      axqk.c(this.jdField_b_of_type_Axqk, axqk.a(this.jdField_b_of_type_Axqk).e);
      axqk.b(this.jdField_b_of_type_Axqk).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + axqk.a(this.jdField_b_of_type_Axqk));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(axqk.a(this.jdField_b_of_type_Axqk))) {
        break label506;
      }
    }
    label506:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bcad.a().a(localBundle, "" + axqk.a(this.jdField_b_of_type_Axqk), this.jdField_b_of_type_Axqk.a.c(), false);
      if ((!axqk.b(this.jdField_b_of_type_Axqk).get()) && (mpl.a(axqk.a(this.jdField_b_of_type_Axqk)))) {
        axqk.a(this.jdField_b_of_type_Axqk).put("imageUrl", axqk.a(this.jdField_b_of_type_Axqk));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + axqk.a(this.jdField_b_of_type_Axqk).toString());
      }
      if (!axqk.a(this.jdField_b_of_type_Axqk).isEmpty()) {
        break;
      }
      axqk.c(this.jdField_b_of_type_Axqk).set(true);
      b();
      return;
    }
    ThreadManager.post(new ForwardSdkShareProcessor.UrlExchangeStep.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqu
 * JD-Core Version:    0.7.0.1
 */