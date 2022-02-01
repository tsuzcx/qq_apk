import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bnrr
  extends ReportDialog
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private bisa jdField_a_of_type_Bisa;
  
  public bnrr(@NonNull Context paramContext)
  {
    super(paramContext, 2131755829);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131558523);
    ((TextView)findViewById(2131379875)).setText(2131694653);
    paramContext = (ImageView)findViewById(2131369501);
    this.jdField_a_of_type_Bisa = a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Bisa);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363844));
  }
  
  private bisa a()
  {
    bisa localbisa = new bisa(getContext());
    localbisa.a(UIUtils.dip2px(getContext(), 94.0F));
    localbisa.a(true);
    localbisa.g(-1711276033);
    localbisa.h(18);
    localbisa.b(true);
    localbisa.d(false);
    localbisa.f(0);
    localbisa.c(false);
    localbisa.d(-16722948);
    localbisa.e(872415231);
    localbisa.i(6);
    localbisa.e(true);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    return localbisa;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisa == null) {
      return;
    }
    this.jdField_a_of_type_Bisa.a();
    this.jdField_a_of_type_Bisa.c(paramInt);
    this.jdField_a_of_type_Bisa.a(paramInt + "%");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrr
 * JD-Core Version:    0.7.0.1
 */