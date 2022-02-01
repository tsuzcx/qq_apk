import android.view.View;
import java.lang.ref.SoftReference;
import java.util.concurrent.Future;

public final class aymv<Params, Result>
{
  public final int a;
  public final Integer a;
  public Long a;
  public final Params a;
  public final String a;
  public SoftReference<View> a;
  public Future<?> a;
  public SoftReference<View> b;
  public SoftReference<Result> c;
  
  public aymv(String paramString, View paramView1, View paramView2, Params paramParams, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramView1);
    if (paramView2 != null) {}
    for (paramString = new SoftReference(paramView2);; paramString = null)
    {
      this.b = paramString;
      this.jdField_a_of_type_JavaLangObject = paramParams;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
      this.c = null;
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      this.jdField_a_of_type_JavaUtilConcurrentFuture = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymv
 * JD-Core Version:    0.7.0.1
 */