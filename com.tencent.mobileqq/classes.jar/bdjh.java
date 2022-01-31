import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class bdjh
  implements View.OnClickListener
{
  protected Context a;
  protected View a;
  protected bdji a;
  protected final bhpy a;
  
  public bdjh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(paramContext, null));
  }
  
  protected View a()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560664, null);
    View localView2 = localView1.findViewById(2131364927);
    View localView3 = localView1.findViewById(2131364916);
    View localView4 = localView1.findViewById(2131364914);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    return localView1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!a()) {
        this.jdField_a_of_type_Bhpy.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TeamWorkCreateActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(bdji parambdji)
  {
    this.jdField_a_of_type_Bdji = parambdji;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bhpy.isShowing();
  }
  
  public void b()
  {
    if (a()) {}
    try
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("TeamWorkCreateActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bdji != null) {
        this.jdField_a_of_type_Bdji.a(i);
      }
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjh
 * JD-Core Version:    0.7.0.1
 */