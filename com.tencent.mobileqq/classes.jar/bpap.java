import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bpap
  extends ReportDialog
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjbh jdField_a_of_type_Bjbh;
  
  public bpap(@NonNull Context paramContext)
  {
    super(paramContext, 2131755824);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131558513);
    ((TextView)findViewById(2131379781)).setText(2131694338);
    paramContext = (ImageView)findViewById(2131369324);
    this.jdField_a_of_type_Bjbh = a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Bjbh);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363744));
  }
  
  private bjbh a()
  {
    bjbh localbjbh = new bjbh(getContext());
    localbjbh.a(zps.a(getContext(), 94.0F));
    localbjbh.a(true);
    localbjbh.g(-1711276033);
    localbjbh.h(18);
    localbjbh.b(true);
    localbjbh.d(false);
    localbjbh.f(0);
    localbjbh.c(false);
    localbjbh.d(-16722948);
    localbjbh.e(872415231);
    localbjbh.i(6);
    localbjbh.e(true);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    return localbjbh;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbh == null) {
      return;
    }
    this.jdField_a_of_type_Bjbh.a();
    this.jdField_a_of_type_Bjbh.c(paramInt);
    this.jdField_a_of_type_Bjbh.a(paramInt + "%");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpap
 * JD-Core Version:    0.7.0.1
 */