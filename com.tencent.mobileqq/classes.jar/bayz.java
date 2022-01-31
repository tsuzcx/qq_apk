import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bayz
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bayx.a(this.jdField_a_of_type_Bayx, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bayv localbayv = (bayv)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bayx.a(this.jdField_a_of_type_Bayx) == null) || (isCancelled()) || (a() == null) || (bayx.a(this.jdField_a_of_type_Bayx))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bayx.a(this.jdField_a_of_type_Bayx)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbayv.a();
        if ((bayx.a(this.jdField_a_of_type_Bayx) != null) && (paramVarArgs != null)) {
          bayx.a(this.jdField_a_of_type_Bayx).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bayx.a(this.jdField_a_of_type_Bayx) != null) {
          bayx.a(this.jdField_a_of_type_Bayx).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbayv.a();
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
    baza localbaza = (baza)bayx.a(this.jdField_a_of_type_Bayx).remove(localView);
    if ((isCancelled()) || (bayx.a(this.jdField_a_of_type_Bayx))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbaza != null) && (localbaza.a != null)) {
        localbaza.a.a(localView, null);
      }
    }
    return;
    label72:
    bayx.a(this.jdField_a_of_type_Bayx, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbaza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayz
 * JD-Core Version:    0.7.0.1
 */