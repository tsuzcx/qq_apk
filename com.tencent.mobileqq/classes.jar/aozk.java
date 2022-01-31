import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class aozk
  extends aoyt
{
  private TriangleView jdField_a_of_type_ComTencentBizWidgetsTriangleView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private wmf jdField_a_of_type_Wmf;
  private View c;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView h;
  private TextView i;
  
  public aozk(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131494935, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300649));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305313));
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312863));
      this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312877));
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313760);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313764);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131306219);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300722);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312597));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131306216);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131313762));
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView = ((TriangleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311869));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312317));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305370));
      this.jdField_a_of_type_Wmf = new wmf(null, this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void a(CharSequence paramCharSequence, MovementMethod paramMovementMethod)
  {
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    b(false);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(paramMovementMethod);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.h.setText(paramString1);
    this.i.setText(paramString2);
  }
  
  public void a(List<aoys> paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, short paramShort)
  {
    this.jdField_a_of_type_Wmf.a(paramList);
    this.jdField_a_of_type_Wmf.e = "/";
    this.jdField_a_of_type_Wmf.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Wmf.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Wmf.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Wmf.c = paramString3;
    this.jdField_a_of_type_Wmf.d = paramString4;
    this.jdField_a_of_type_Wmf.jdField_a_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Wmf.a(paramBoolean, paramString6, paramShort);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Wmf);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131305370);
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      localView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      localTextView.setVisibility(j);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Wmf != null) {
      this.jdField_a_of_type_Wmf.notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidViewView.setPadding(0, this.jdField_c_of_type_AndroidViewView.getPaddingTop(), 0, 0);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int j = 0;; j = 8)
    {
      localTextView.setVisibility(j);
      return;
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838503);
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131101491));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100634));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(Color.parseColor("#ffffffff"));
    this.jdField_g_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100633));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozk
 * JD-Core Version:    0.7.0.1
 */