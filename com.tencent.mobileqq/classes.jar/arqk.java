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

public class arqk
  extends arqj
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arql(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bepp jdField_a_of_type_Bepp;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public arqk(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepp != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bepp.isShowing()) {
        this.jdField_a_of_type_Bepp.show();
      }
      return;
      this.jdField_a_of_type_Bepp = new bepp(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bepp.setCancelable(false);
      this.jdField_a_of_type_Bepp.a(alpo.a(2131714199));
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131376331));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371197));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      armz.a(2131694700);
      return;
    }
    if ((arni.a()) && (aqxj.c() > aqxg.a()))
    {
      arni.a(true, this.jdField_a_of_type_AndroidContentContext, new arqm(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bcjk.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bcig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131698040));
      c();
    }
    do
    {
      return;
      if (!arni.a()) {
        break;
      }
    } while (!bevd.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new arqn(this)));
    Object localObject = new arqo(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697828);
    localObject = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131698037), str, 2131690648, 2131698228, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aoqc.c().b.jdField_a_of_type_Boolean) && (!bdwm.a().b())) {
      ((bdfq)localObject).setMessageWithoutAutoLink(aoqc.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bdfq)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692545) + this.jdField_a_of_type_AndroidContentContext.getString(2131692723) + aqxj.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692724);
    long l = aqxj.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692543) + arof.a(l);
    }
    Object localObject2 = localObject1;
    if (aqxj.e() > 0L)
    {
      localObject2 = localObject1;
      if (!arni.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692544) + arof.a(aqxj.e());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (aqxj.b() > 0L) {}
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
    a(2131695300);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */