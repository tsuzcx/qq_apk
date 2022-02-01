import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bfqy
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bfqw.a(this.jdField_a_of_type_Bfqw, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bfqu localbfqu = (bfqu)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bfqw.a(this.jdField_a_of_type_Bfqw) == null) || (isCancelled()) || (a() == null) || (bfqw.a(this.jdField_a_of_type_Bfqw))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bfqw.a(this.jdField_a_of_type_Bfqw)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbfqu.a();
        if ((bfqw.a(this.jdField_a_of_type_Bfqw) != null) && (paramVarArgs != null)) {
          bfqw.a(this.jdField_a_of_type_Bfqw).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bfqw.a(this.jdField_a_of_type_Bfqw) != null) {
          bfqw.a(this.jdField_a_of_type_Bfqw).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbfqu.a();
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
    bfqz localbfqz = (bfqz)bfqw.a(this.jdField_a_of_type_Bfqw).remove(localView);
    if ((isCancelled()) || (bfqw.a(this.jdField_a_of_type_Bfqw))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbfqz != null) && (localbfqz.a != null)) {
        localbfqz.a.a(localView, null);
      }
    }
    return;
    label72:
    bfqw.a(this.jdField_a_of_type_Bfqw, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbfqz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqy
 * JD-Core Version:    0.7.0.1
 */