import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bghn
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bghl.a(this.jdField_a_of_type_Bghl, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bghj localbghj = (bghj)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bghl.a(this.jdField_a_of_type_Bghl) == null) || (isCancelled()) || (a() == null) || (bghl.a(this.jdField_a_of_type_Bghl))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bghl.a(this.jdField_a_of_type_Bghl)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbghj.a();
        if ((bghl.a(this.jdField_a_of_type_Bghl) != null) && (paramVarArgs != null)) {
          bghl.a(this.jdField_a_of_type_Bghl).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bghl.a(this.jdField_a_of_type_Bghl) != null) {
          bghl.a(this.jdField_a_of_type_Bghl).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbghj.a();
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
    bgho localbgho = (bgho)bghl.a(this.jdField_a_of_type_Bghl).remove(localView);
    if ((isCancelled()) || (bghl.a(this.jdField_a_of_type_Bghl))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbgho != null) && (localbgho.a != null)) {
        localbgho.a.a(localView, null);
      }
    }
    return;
    label72:
    bghl.a(this.jdField_a_of_type_Bghl, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbgho);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghn
 * JD-Core Version:    0.7.0.1
 */