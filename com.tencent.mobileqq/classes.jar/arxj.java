import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class arxj
  extends arxd
{
  public static int a;
  public static int b = 1;
  private amab jdField_a_of_type_Amab = new arxk(this);
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new arxm(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private arxn jdField_a_of_type_Arxn;
  private bcws jdField_a_of_type_Bcws;
  private bcwt jdField_a_of_type_Bcwt = new arxl(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  
  public arxj(bdfq parambdfq)
  {
    super(parambdfq);
  }
  
  private void b(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardPreviewTroopMemberController.1(this, paramString));
  }
  
  protected int a()
  {
    return 380;
  }
  
  protected View a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 5);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i = aekt.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "bindData title: " + paramString1 + " uin: " + paramString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramQQAppInterface = "";
    }
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface;
    a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_Bcwt);
    this.jdField_a_of_type_Arxn = new arxn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcws);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Arxn);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    d();
    if (paramInt == 1) {
      ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).o(this.jdField_a_of_type_JavaLangString);
    }
    while (paramInt != 3000) {
      return;
    }
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void c()
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDestroy.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxj
 * JD-Core Version:    0.7.0.1
 */