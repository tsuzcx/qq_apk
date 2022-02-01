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

public class atxk
  extends atxj
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atxl(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biau jdField_a_of_type_Biau;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public atxk(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biau != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Biau.isShowing()) {
        this.jdField_a_of_type_Biau.show();
      }
      return;
      this.jdField_a_of_type_Biau = new biau(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298998));
      this.jdField_a_of_type_Biau.setCancelable(false);
      this.jdField_a_of_type_Biau.a(anni.a(2131712583));
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377174));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371780));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      atvf.a(2131693919);
      return;
    }
    if ((atvo.a()) && (athc.c() > atgz.a()))
    {
      atvo.a(true, this.jdField_a_of_type_AndroidContentContext, new atxm(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bfsj.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bfrh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696888));
      c();
    }
    do
    {
      return;
      if (!atvo.a()) {
        break;
      }
    } while (!bigl.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new atxn(this)));
    Object localObject = new atxo(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131696672);
    localObject = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696885), str, 2131690582, 2131697081, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aqwx.c().b.jdField_a_of_type_Boolean) && (!bhhx.a().b())) {
      ((bgpa)localObject).setMessageWithoutAutoLink(aqwx.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bgpa)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_Biau.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692132) + this.jdField_a_of_type_AndroidContentContext.getString(2131692291) + athc.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692292);
    long l = athc.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692130) + atwl.a(l);
    }
    Object localObject2 = localObject1;
    if (athc.e() > 0L)
    {
      localObject2 = localObject1;
      if (!atvo.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692131) + atwl.a(athc.e());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (athc.b() > 0L) {}
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
    a(2131694299);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxk
 * JD-Core Version:    0.7.0.1
 */