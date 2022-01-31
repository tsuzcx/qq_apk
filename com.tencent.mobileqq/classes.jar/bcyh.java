import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bcyh
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bcyf.a(this.jdField_a_of_type_Bcyf, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bcyd localbcyd = (bcyd)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bcyf.a(this.jdField_a_of_type_Bcyf) == null) || (isCancelled()) || (a() == null) || (bcyf.a(this.jdField_a_of_type_Bcyf))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bcyf.a(this.jdField_a_of_type_Bcyf)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbcyd.a();
        if ((bcyf.a(this.jdField_a_of_type_Bcyf) != null) && (paramVarArgs != null)) {
          bcyf.a(this.jdField_a_of_type_Bcyf).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bcyf.a(this.jdField_a_of_type_Bcyf) != null) {
          bcyf.a(this.jdField_a_of_type_Bcyf).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbcyd.a();
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
    bcyi localbcyi = (bcyi)bcyf.a(this.jdField_a_of_type_Bcyf).remove(localView);
    if ((isCancelled()) || (bcyf.a(this.jdField_a_of_type_Bcyf))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbcyi != null) && (localbcyi.a != null)) {
        localbcyi.a.a(localView, null);
      }
    }
    return;
    label72:
    bcyf.a(this.jdField_a_of_type_Bcyf, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbcyi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyh
 * JD-Core Version:    0.7.0.1
 */