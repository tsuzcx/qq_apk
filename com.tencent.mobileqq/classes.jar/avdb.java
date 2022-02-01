import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class avdb
{
  public static int a;
  public static int b = 1;
  private float jdField_a_of_type_Float = 1.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new avde(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aojs jdField_a_of_type_Aojs = new avdc(this);
  private aoof jdField_a_of_type_Aoof;
  private aoog jdField_a_of_type_Aoog = new avdd(this);
  private avdf jdField_a_of_type_Avdf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  
  public avdb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardTroopMemberControllerForMiniPie.1(this, paramString));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private void d()
  {
    int i = 5;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131703747));
      int j = (int)(16.0D / this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, j);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167086));
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 5);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      if (this.jdField_a_of_type_Float != 0.0F) {
        i = (int)(5 / this.jdField_a_of_type_Float);
      }
      i = agej.a(i, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "destroy.");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    }
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, float paramFloat)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "setTroopInfo  uin: " + paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    }
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this.jdField_a_of_type_Aoog);
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Avdf = new avdf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aoof, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Avdf);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    b();
    if (paramInt == 1) {
      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).o(this.jdField_a_of_type_JavaLangString);
    }
    while (paramInt != 3000) {
      return;
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdb
 * JD-Core Version:    0.7.0.1
 */