import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bduz
  extends bduq
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  bduz(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected Runnable a()
  {
    return new ForwardSdkShareProcessor.UrlExchangeStep.1(this);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, paramString);
    }
  }
  
  protected boolean a()
  {
    return (bdup.c(this.jdField_b_of_type_Bdup).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (bdup.b(this.jdField_b_of_type_Bdup) == 11)
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      bdup.c(this.jdField_b_of_type_Bdup).set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(bdup.e(this.jdField_b_of_type_Bdup))) && (bdup.e(this.jdField_b_of_type_Bdup).length() > 150)) {
      bdup.a(this.jdField_b_of_type_Bdup).put("targetUrl", bdup.e(this.jdField_b_of_type_Bdup));
    }
    if (!TextUtils.isEmpty(bdup.a(this.jdField_b_of_type_Bdup).c)) {
      bdup.a(this.jdField_b_of_type_Bdup).put("sourceUrl", bdup.a(this.jdField_b_of_type_Bdup).c);
    }
    if (!TextUtils.isEmpty(bdup.a(this.jdField_b_of_type_Bdup).d)) {
      bdup.a(this.jdField_b_of_type_Bdup).put("sourceIcon", bdup.a(this.jdField_b_of_type_Bdup).d);
    }
    if ((bdup.e(this.jdField_b_of_type_Bdup) == 2) && (nlw.a(bdup.h(this.jdField_b_of_type_Bdup)))) {
      bdup.a(this.jdField_b_of_type_Bdup).put("audioUrl", bdup.h(this.jdField_b_of_type_Bdup));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(bdup.a(this.jdField_b_of_type_Bdup)))
    {
      bdup.c(this.jdField_b_of_type_Bdup, bdup.a(this.jdField_b_of_type_Bdup).e);
      bdup.a(this.jdField_b_of_type_Bdup).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + bdup.a(this.jdField_b_of_type_Bdup));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(bdup.a(this.jdField_b_of_type_Bdup))) {
        break label492;
      }
    }
    label492:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bipi.a().a(localBundle, "" + bdup.a(this.jdField_b_of_type_Bdup), this.jdField_b_of_type_Bdup.a.c(), false);
      if ((!bdup.a(this.jdField_b_of_type_Bdup).get()) && (nlw.a(bdup.a(this.jdField_b_of_type_Bdup)))) {
        bdup.a(this.jdField_b_of_type_Bdup).put("imageUrl", bdup.a(this.jdField_b_of_type_Bdup));
      }
      a("UrlExchangeStep|process|url=" + bdup.a(this.jdField_b_of_type_Bdup).toString());
      if (!bdup.a(this.jdField_b_of_type_Bdup).isEmpty()) {
        break;
      }
      bdup.c(this.jdField_b_of_type_Bdup).set(true);
      b();
      return;
    }
    ThreadManager.post(a(), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduz
 * JD-Core Version:    0.7.0.1
 */