import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class azxv
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == azxt.a(this.jdField_a_of_type_Azxt, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    azxr localazxr = (azxr)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((azxt.a(this.jdField_a_of_type_Azxt) == null) || (isCancelled()) || (a() == null) || (azxt.a(this.jdField_a_of_type_Azxt))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!azxt.a(this.jdField_a_of_type_Azxt)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localazxr.a();
        if ((azxt.a(this.jdField_a_of_type_Azxt) != null) && (paramVarArgs != null)) {
          azxt.a(this.jdField_a_of_type_Azxt).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (azxt.a(this.jdField_a_of_type_Azxt) != null) {
          azxt.a(this.jdField_a_of_type_Azxt).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localazxr.a();
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
    azxw localazxw = (azxw)azxt.a(this.jdField_a_of_type_Azxt).remove(localView);
    if ((isCancelled()) || (azxt.a(this.jdField_a_of_type_Azxt))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localazxw != null) && (localazxw.a != null)) {
        localazxw.a.a(localView, null);
      }
    }
    return;
    label72:
    azxt.a(this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Boolean, localView, paramDrawable, localazxw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azxv
 * JD-Core Version:    0.7.0.1
 */