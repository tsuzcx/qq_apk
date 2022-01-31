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

public class apxg
  extends apxf
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apxh(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcpq jdField_a_of_type_Bcpq;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public apxg(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpq != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bcpq.isShowing()) {
        this.jdField_a_of_type_Bcpq.show();
      }
      return;
      this.jdField_a_of_type_Bcpq = new bcpq(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcpq.setCancelable(false);
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131713816));
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131375830));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131370887));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      aptv.a(2131694543);
      return;
    }
    if ((apue.a()) && (apeh.c() > apee.a()))
    {
      apue.a(true, this.jdField_a_of_type_AndroidContentContext, new apxi(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bakj.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bajf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697853));
      c();
    }
    do
    {
      return;
      if (!apue.a()) {
        break;
      }
    } while (!bcvm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new apxj(this)));
    Object localObject = new apxk(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697652);
    localObject = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697850), str, 2131690596, 2131698041, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((amyo.c().b.jdField_a_of_type_Boolean) && (!bbwx.a().b())) {
      ((bbgg)localObject).setMessageWithoutAutoLink(amyo.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bbgg)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692468) + this.jdField_a_of_type_AndroidContentContext.getString(2131692643) + apeh.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692644);
    long l = apeh.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692466) + apvb.a(l);
    }
    Object localObject2 = localObject1;
    if (apeh.e() > 0L)
    {
      localObject2 = localObject1;
      if (!apue.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692467) + apvb.a(apeh.e());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (apeh.b() > 0L) {}
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
    a(2131695141);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */