import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class aywm
  implements aywe
{
  public static final String a;
  public final int a;
  public Context a;
  public View a;
  
  static
  {
    jdField_a_of_type_JavaLangString = aywm.class.getSimpleName();
  }
  
  public aywm(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(jdField_a_of_type_JavaLangString + "type is illegal, type = " + paramInt);
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 2) {}
    }
    else
    {
      i = 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "type is illegal, type = " + 0);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = i;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (bool) {
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166832));
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = localRelativeLayout;
      return localRelativeLayout;
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
      View localView = new View(this.jdField_a_of_type_AndroidContentContext);
      if (bool) {
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166843));
      }
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams.addRule(15);
        localLayoutParams.leftMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
        localLayoutParams.rightMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
        localRelativeLayout.addView(localView, localLayoutParams);
        break;
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166842));
      }
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 18.0F)));
      break;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */