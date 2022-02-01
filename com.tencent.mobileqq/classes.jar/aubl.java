import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class aubl
  extends auav
{
  private int jdField_a_of_type_Int;
  private aagx jdField_a_of_type_Aagx;
  private TriangleView jdField_a_of_type_ComTencentBizWidgetsTriangleView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private View c;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public aubl(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560877, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366781));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372155));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380539));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380553));
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381679);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381684);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373138);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366880);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379891));
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380272));
      this.j.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView = ((TriangleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379371));
      this.jdField_a_of_type_Aagx = new aagx(null, this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373135);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131381682));
      this.i = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131381680));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372237));
      this.k = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361940));
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    super.a(paramOnClickListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379354));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131379320));
    this.l = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379330));
    this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379318);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.l.setText(paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    super.a(paramString, paramOnClickListener);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  public void a(List<auao> paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, short paramShort)
  {
    this.jdField_a_of_type_Aagx.a(paramList);
    this.jdField_a_of_type_Aagx.e = "/";
    this.jdField_a_of_type_Aagx.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Aagx.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Aagx.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Aagx.c = paramString3;
    this.jdField_a_of_type_Aagx.d = paramString4;
    this.jdField_a_of_type_Aagx.jdField_a_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Aagx.a(paramBoolean, paramString6, paramShort);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aagx);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localView.setVisibility(m);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      if (this.jdField_a_of_type_Int != 2) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.k != null)
    {
      this.k.setText(paramString);
      this.k.setOnClickListener(paramOnClickListener);
      e(true);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aagx != null) {
      this.jdField_a_of_type_Aagx.notifyDataSetChanged();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (this.jdField_a_of_type_Int == 2) {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    for (;;)
    {
      if (localRelativeLayout != null) {
        if (!paramBoolean) {
          break label43;
        }
      }
      label43:
      for (int m = 0;; m = 8)
      {
        localRelativeLayout.setVisibility(m);
        if (paramBoolean) {
          e(false);
        }
        return;
      }
    }
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidViewView.setPadding(0, this.jdField_c_of_type_AndroidViewView.getPaddingTop(), 0, 0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c(String paramString)
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localView.setVisibility(m);
      return;
    }
  }
  
  public void d(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.i.setVisibility(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void e(String paramString)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    int m = 0;
    if (this.k != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label49;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
        this.k.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.k.setVisibility(8);
    return;
    label49:
    TextView localTextView = this.k;
    if (paramBoolean) {}
    for (;;)
    {
      localTextView.setVisibility(m);
      return;
      m = 8;
    }
  }
  
  public void f(String paramString)
  {
    this.j.setText(paramString);
    g(true);
  }
  
  public void f(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      localView = this.jdField_d_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int m = 0;; m = 8)
    {
      localView.setVisibility(m);
      if (paramBoolean) {
        this.jdField_a_of_type_Int = 1;
      }
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.j;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localTextView.setVisibility(m);
      return;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838911);
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167296));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166376));
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167112));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(Color.parseColor("#ffffffff"));
    this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166375));
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165357));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubl
 * JD-Core Version:    0.7.0.1
 */