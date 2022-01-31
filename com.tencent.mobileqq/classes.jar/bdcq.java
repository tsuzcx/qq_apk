import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bdcq
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bdco.a(this.jdField_a_of_type_Bdco, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bdcm localbdcm = (bdcm)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bdco.a(this.jdField_a_of_type_Bdco) == null) || (isCancelled()) || (a() == null) || (bdco.a(this.jdField_a_of_type_Bdco))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bdco.a(this.jdField_a_of_type_Bdco)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbdcm.a();
        if ((bdco.a(this.jdField_a_of_type_Bdco) != null) && (paramVarArgs != null)) {
          bdco.a(this.jdField_a_of_type_Bdco).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bdco.a(this.jdField_a_of_type_Bdco) != null) {
          bdco.a(this.jdField_a_of_type_Bdco).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbdcm.a();
        }
        catch (OutOfMemoryError paramVarArgs)
        {
          QLog.w("ImageWorker", 2, "OutOfMemoryError!!!!!");
        }
      }
      paramVarArgs = null;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    View localView = a();
    bdcr localbdcr = (bdcr)bdco.a(this.jdField_a_of_type_Bdco).remove(localView);
    if ((isCancelled()) || (bdco.a(this.jdField_a_of_type_Bdco))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbdcr != null) && (localbdcr.a != null)) {
        localbdcr.a.a(localView, null);
      }
    }
    return;
    label72:
    bdco.a(this.jdField_a_of_type_Bdco, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbdcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcq
 * JD-Core Version:    0.7.0.1
 */