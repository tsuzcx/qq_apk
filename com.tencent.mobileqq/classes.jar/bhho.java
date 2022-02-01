import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class bhho
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {}
    while (this == bhhm.a(this.jdField_a_of_type_Bhhm, localView)) {
      return localView;
    }
    return null;
  }
  
  public Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    bhhk localbhhk = (bhhk)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if (((bhhm.a(this.jdField_a_of_type_Bhhm) == null) || (isCancelled()) || (a() == null) || (bhhm.a(this.jdField_a_of_type_Bhhm))) || ((0 == 0) && (!isCancelled()) && (a() != null) && (!bhhm.a(this.jdField_a_of_type_Bhhm)))) {}
    for (;;)
    {
      try
      {
        paramVarArgs = localbhhk.a();
        if ((bhhm.a(this.jdField_a_of_type_Bhhm) != null) && (paramVarArgs != null)) {
          bhhm.a(this.jdField_a_of_type_Bhhm).a(str, paramVarArgs);
        }
        return paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (bhhm.a(this.jdField_a_of_type_Bhhm) != null) {
          bhhm.a(this.jdField_a_of_type_Bhhm).a();
        }
        System.gc();
        Thread.yield();
        try
        {
          paramVarArgs = localbhhk.a();
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
    bhhp localbhhp = (bhhp)bhhm.a(this.jdField_a_of_type_Bhhm).remove(localView);
    if ((isCancelled()) || (bhhm.a(this.jdField_a_of_type_Bhhm))) {
      paramDrawable = null;
    }
    if (localView != null)
    {
      if (paramDrawable != null) {
        break label72;
      }
      if ((localbhhp != null) && (localbhhp.a != null)) {
        localbhhp.a.a(localView, null);
      }
    }
    return;
    label72:
    bhhm.a(this.jdField_a_of_type_Bhhm, this.jdField_a_of_type_Boolean, localView, paramDrawable, localbhhp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhho
 * JD-Core Version:    0.7.0.1
 */