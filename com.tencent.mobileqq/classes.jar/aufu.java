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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aufu
  extends auft
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aufv(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bisl jdField_a_of_type_Bisl;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public aufu(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bisl.isShowing()) {
        this.jdField_a_of_type_Bisl.show();
      }
      return;
      this.jdField_a_of_type_Bisl = new bisl(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.setCancelable(false);
      this.jdField_a_of_type_Bisl.a(anvx.a(2131713271));
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377339));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131372043));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      audr.a(2131694226);
      return;
    }
    if ((auea.a()) && (atpm.c() > atpj.a()))
    {
      auea.a(true, this.jdField_a_of_type_AndroidContentContext, new aufw(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bgke.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bgjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697356));
      c();
    }
    do
    {
      return;
      if (!auea.a()) {
        break;
      }
    } while (!bixr.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new aufx(this)));
    Object localObject = new aufy(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697130);
    localObject = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697353), str, 2131690697, 2131697549, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((arjp.c().b.jdField_a_of_type_Boolean) && (!bhzh.a().b())) {
      ((QQCustomDialog)localObject).setMessageWithoutAutoLink(arjp.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((QQCustomDialog)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692275) + this.jdField_a_of_type_AndroidContentContext.getString(2131692446) + atpm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
    long l = atpm.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692273) + FileUtil.filesizeToString(l);
    }
    Object localObject2 = localObject1;
    if (atpm.e() > 0L)
    {
      localObject2 = localObject1;
      if (!auea.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692274) + FileUtil.filesizeToString(atpm.e());
      }
    }
    localObject1 = str;
    if (this.jdField_b_of_type_Int == 1101)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694399);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692273) + this.jdField_a_of_type_AndroidContentContext.getString(2131692446) + atpm.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (atpm.b() > 0L) {}
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
    if (paramBundle.getInt("file_choose_extension_handle_type", -1) == 1) {
      this.jdField_b_of_type_Int = 1101;
    }
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    a(2131694656);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufu
 * JD-Core Version:    0.7.0.1
 */