import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bazn
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bazl.a(this.jdField_a_of_type_Bazl, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bazj localbazj = (bazj)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bazl.a(this.jdField_a_of_type_Bazl) == null) || (isCancelled()) || (a() == null) || (bazl.a(this.jdField_a_of_type_Bazl))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bazl.a(this.jdField_a_of_type_Bazl)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbazj.a();
        if ((bazl.a(this.jdField_a_of_type_Bazl) != null) && (paramVarArgs != null)) {
          bazl.a(this.jdField_a_of_type_Bazl).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bazl.a(this.jdField_a_of_type_Bazl) != null) {
          bazl.a(this.jdField_a_of_type_Bazl).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbazj.a();
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
    bazo localbazo = (bazo)bazl.a(this.jdField_a_of_type_Bazl).remove(localView);
    if ((isCancelled()) || (bazl.a(this.jdField_a_of_type_Bazl))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbazo != null) && (localbazo.a != null)) {
        localbazo.a.a(localView, null);
      }
    }
    return;
    label72:
    bazl.a(this.jdField_a_of_type_Bazl, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbazo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bazn
 * JD-Core Version:    0.7.0.1
 */