import android.view.View;
import com.tencent.mobileqq.transfile.FileMsg;
import java.lang.ref.WeakReference;

class bahv
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<afbb> b;
  WeakReference<FileMsg> c;
  
  public bahv(bahu parambahu, View paramView, afbb paramafbb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramafbb);
  }
  
  public afbb a()
  {
    return (afbb)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public FileMsg a()
  {
    if (this.c == null) {
      return null;
    }
    return (FileMsg)this.c.get();
  }
  
  public void a(FileMsg paramFileMsg)
  {
    this.c = new WeakReference(paramFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahv
 * JD-Core Version:    0.7.0.1
 */