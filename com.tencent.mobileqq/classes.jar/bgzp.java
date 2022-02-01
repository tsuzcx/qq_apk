import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bgzp
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bgzn.a(this.jdField_a_of_type_Bgzn, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bgzl localbgzl = (bgzl)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bgzn.a(this.jdField_a_of_type_Bgzn) == null) || (isCancelled()) || (a() == null) || (bgzn.a(this.jdField_a_of_type_Bgzn))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bgzn.a(this.jdField_a_of_type_Bgzn)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbgzl.a();
        if ((bgzn.a(this.jdField_a_of_type_Bgzn) != null) && (paramVarArgs != null)) {
          bgzn.a(this.jdField_a_of_type_Bgzn).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bgzn.a(this.jdField_a_of_type_Bgzn) != null) {
          bgzn.a(this.jdField_a_of_type_Bgzn).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbgzl.a();
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
    bgzq localbgzq = (bgzq)bgzn.a(this.jdField_a_of_type_Bgzn).remove(localView);
    if ((isCancelled()) || (bgzn.a(this.jdField_a_of_type_Bgzn))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbgzq != null) && (localbgzq.a != null)) {
        localbgzq.a.a(localView, null);
      }
    }
    return;
    label72:
    bgzn.a(this.jdField_a_of_type_Bgzn, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbgzq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzp
 * JD-Core Version:    0.7.0.1
 */