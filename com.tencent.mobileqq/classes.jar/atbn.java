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

public class atbn
  extends atbm
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atbo(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhht jdField_a_of_type_Bhht;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public atbn(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhht != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bhht.isShowing()) {
        this.jdField_a_of_type_Bhht.show();
      }
      return;
      this.jdField_a_of_type_Bhht = new bhht(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299076));
      this.jdField_a_of_type_Bhht.setCancelable(false);
      this.jdField_a_of_type_Bhht.a(amtj.a(2131712924));
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377065));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371853));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      aszk.a(2131694035);
      return;
    }
    if ((aszt.a()) && (aslg.c() > asld.a()))
    {
      aszt.a(true, this.jdField_a_of_type_AndroidContentContext, new atbp(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bfby.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bfaw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697079));
      c();
    }
    do
    {
      return;
      if (!aszt.a()) {
        break;
      }
    } while (!bhnb.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new atbq(this)));
    Object localObject = new atbr(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131696862);
    localObject = bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697076), str, 2131690620, 2131697272, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aqgi.c().b.jdField_a_of_type_Boolean) && (!bgox.a().b())) {
      ((QQCustomDialog)localObject).setMessageWithoutAutoLink(aqgi.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((QQCustomDialog)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692185) + this.jdField_a_of_type_AndroidContentContext.getString(2131692344) + aslg.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692345);
    long l = aslg.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692183) + FileUtil.filesizeToString(l);
    }
    Object localObject2 = localObject1;
    if (aslg.e() > 0L)
    {
      localObject2 = localObject1;
      if (!aszt.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692184) + FileUtil.filesizeToString(aslg.e());
      }
    }
    localObject1 = str;
    if (this.jdField_b_of_type_Int == 1101)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694201);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692183) + this.jdField_a_of_type_AndroidContentContext.getString(2131692344) + aslg.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692345);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (aslg.b() > 0L) {}
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
    a(2131694455);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbn
 * JD-Core Version:    0.7.0.1
 */