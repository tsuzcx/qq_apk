import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bett
  extends betk
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  bett(betj parambetj)
  {
    super(parambetj);
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
    return (this.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (this.jdField_b_of_type_Betj.jdField_a_of_type_Int == 11)
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      this.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      b();
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString.length() > 150)) {
      this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.put("targetUrl", this.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.c)) {
      this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.put("sourceUrl", this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.c);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.d)) {
      this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.put("sourceIcon", this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.d);
    }
    if ((this.jdField_b_of_type_Betj.jdField_b_of_type_Int == 2) && (nnr.a(this.jdField_b_of_type_Betj.f))) {
      this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.put("audioUrl", this.jdField_b_of_type_Betj.f);
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(this.jdField_b_of_type_Betj.e))
    {
      this.jdField_b_of_type_Betj.e = this.jdField_b_of_type_Betj.jdField_a_of_type_Beyh.e;
      betj.a(this.jdField_b_of_type_Betj).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + this.jdField_b_of_type_Betj.e);
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Betj.e)) {
        break label491;
      }
    }
    label491:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bjqh.a().a(localBundle, "" + betj.a(this.jdField_b_of_type_Betj), this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      if ((!betj.a(this.jdField_b_of_type_Betj).get()) && (nnr.a(this.jdField_b_of_type_Betj.e))) {
        this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.put("imageUrl", this.jdField_b_of_type_Betj.e);
      }
      a("UrlExchangeStep|process|url=" + this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.toString());
      if (!this.jdField_b_of_type_Betj.jdField_b_of_type_JavaUtilHashMap.isEmpty()) {
        break;
      }
      this.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      b();
      return;
    }
    ThreadManager.post(a(), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bett
 * JD-Core Version:    0.7.0.1
 */