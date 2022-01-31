import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class arut
  extends arus
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aruu(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bety jdField_a_of_type_Bety;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public arut(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bety != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bety.isShowing()) {
        this.jdField_a_of_type_Bety.show();
      }
      return;
      this.jdField_a_of_type_Bety = new bety(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bety.setCancelable(false);
      this.jdField_a_of_type_Bety.a(alud.a(2131714211));
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131376385));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371216));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      arri.a(2131694702);
      return;
    }
    if ((arrr.a()) && (arbs.c() > arbp.a()))
    {
      arrr.a(true, this.jdField_a_of_type_AndroidContentContext, new aruv(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bcnt.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bcmp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698042));
      c();
    }
    do
    {
      return;
      if (!arrr.a()) {
        break;
      }
    } while (!bezm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new aruw(this)));
    Object localObject = new arux(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697830);
    localObject = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131698039), str, 2131690648, 2131698230, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aoul.c().b.jdField_a_of_type_Boolean) && (!beav.a().b())) {
      ((bdjz)localObject).setMessageWithoutAutoLink(aoul.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bdjz)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692546) + this.jdField_a_of_type_AndroidContentContext.getString(2131692725) + arbs.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692726);
    long l = arbs.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692544) + arso.a(l);
    }
    Object localObject2 = localObject1;
    if (arbs.e() > 0L)
    {
      localObject2 = localObject1;
      if (!arrr.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692545) + arso.a(arbs.e());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (arbs.b() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_busi_type");
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_ex_params_target_uin");
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_peer_type", -1);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_exparams_send_uin");
    }
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    a(2131695302);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arut
 * JD-Core Version:    0.7.0.1
 */