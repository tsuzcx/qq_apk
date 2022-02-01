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

public class aupf
  extends aupe
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aupg(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjbs jdField_a_of_type_Bjbs;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public aupf(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bjbs.isShowing()) {
        this.jdField_a_of_type_Bjbs.show();
      }
      return;
      this.jdField_a_of_type_Bjbs = new bjbs(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299011));
      this.jdField_a_of_type_Bjbs.setCancelable(false);
      this.jdField_a_of_type_Bjbs.a(anzj.a(2131712692));
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377314));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371887));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      auna.a(2131693936);
      return;
    }
    if ((aunj.a()) && (atyw.c() > atyt.a()))
    {
      aunj.a(true, this.jdField_a_of_type_AndroidContentContext, new auph(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bgsk.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bgri.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131696937));
      c();
    }
    do
    {
      return;
      if (!aunj.a()) {
        break;
      }
    } while (!bjhk.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new aupi(this)));
    Object localObject = new aupj(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131696721);
    localObject = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131696934), str, 2131690580, 2131697130, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((arml.c().b.jdField_a_of_type_Boolean) && (!biim.a().b())) {
      ((bhpc)localObject).setMessageWithoutAutoLink(arml.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bhpc)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692137) + this.jdField_a_of_type_AndroidContentContext.getString(2131692296) + atyw.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692297);
    long l = atyw.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692135) + auog.a(l);
    }
    Object localObject2 = localObject1;
    if (atyw.e() > 0L)
    {
      localObject2 = localObject1;
      if (!aunj.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692136) + auog.a(atyw.e());
      }
    }
    localObject1 = str;
    if (this.jdField_b_of_type_Int == 1101)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694098);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692135) + this.jdField_a_of_type_AndroidContentContext.getString(2131692296) + atyw.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692297);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (atyw.b() > 0L) {}
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
    a(2131694341);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupf
 * JD-Core Version:    0.7.0.1
 */