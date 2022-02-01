import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class bmca
  extends ReportDialog
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhhi jdField_a_of_type_Bhhi;
  
  public bmca(@NonNull Context paramContext)
  {
    super(paramContext, 2131755826);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131558512);
    ((TextView)findViewById(2131379563)).setText(2131694452);
    paramContext = (ImageView)findViewById(2131369334);
    this.jdField_a_of_type_Bhhi = a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Bhhi);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363773));
  }
  
  private bhhi a()
  {
    bhhi localbhhi = new bhhi(getContext());
    localbhhi.a(UIUtils.dip2px(getContext(), 94.0F));
    localbhhi.a(true);
    localbhhi.g(-1711276033);
    localbhhi.h(18);
    localbhhi.b(true);
    localbhhi.d(false);
    localbhhi.f(0);
    localbhhi.c(false);
    localbhhi.d(-16722948);
    localbhhi.e(872415231);
    localbhhi.i(6);
    localbhhi.e(true);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    return localbhhi;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhi == null) {
      return;
    }
    this.jdField_a_of_type_Bhhi.a();
    this.jdField_a_of_type_Bhhi.c(paramInt);
    this.jdField_a_of_type_Bhhi.a(paramInt + "%");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmca
 * JD-Core Version:    0.7.0.1
 */