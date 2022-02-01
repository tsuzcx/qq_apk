import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhib
  implements View.OnClickListener
{
  protected Context a;
  protected View a;
  protected bhic a;
  protected final bkzi a;
  
  public bhib(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(paramContext, null));
  }
  
  protected View a()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560857, null);
    View localView2 = localView1.findViewById(2131365324);
    View localView3 = localView1.findViewById(2131365313);
    View localView4 = localView1.findViewById(2131365311);
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
    this.jdField_a_of_type_Bkzi.a(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!a()) {
        this.jdField_a_of_type_Bkzi.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TeamWorkCreateActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(bhic parambhic)
  {
    this.jdField_a_of_type_Bhic = parambhic;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bkzi.isShowing();
  }
  
  public void b()
  {
    if (a()) {}
    try
    {
      this.jdField_a_of_type_Bkzi.dismiss();
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
      if (this.jdField_a_of_type_Bhic != null) {
        this.jdField_a_of_type_Bhic.a(i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhib
 * JD-Core Version:    0.7.0.1
 */