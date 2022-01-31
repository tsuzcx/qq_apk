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

public class apxi
  extends apxh
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apxj(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcqf jdField_a_of_type_Bcqf;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public apxi(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    d();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf != null) {
      g();
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bcqf.isShowing()) {
        this.jdField_a_of_type_Bcqf.show();
      }
      return;
      this.jdField_a_of_type_Bcqf = new bcqf(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcqf.setCancelable(false);
      this.jdField_a_of_type_Bcqf.a(ajya.a(2131713827));
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131375832));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131370887));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      aptx.a(2131694544);
      return;
    }
    if ((apug.a()) && (apel.c() > apei.a()))
    {
      apug.a(true, this.jdField_a_of_type_AndroidContentContext, new apxk(this), this.jdField_b_of_type_Int);
      return;
    }
    c();
  }
  
  private void f()
  {
    if (bakx.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      bajt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697863));
      c();
    }
    do
    {
      return;
      if (!apug.a()) {
        break;
      }
    } while (!bcwb.a((Activity)this.jdField_a_of_type_AndroidContentContext, 2, new apxl(this)));
    Object localObject = new apxm(this);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131697653);
    localObject = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697860), str, 2131690596, 2131698051, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((amyv.c().b.jdField_a_of_type_Boolean) && (!bbxl.a().b())) {
      ((bbgu)localObject).setMessageWithoutAutoLink(amyv.c().b.a(this.jdField_a_of_type_AndroidContentContext, str));
    }
    ((bbgu)localObject).show();
    return;
    c();
  }
  
  private void g()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.cancel();
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
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131692469) + this.jdField_a_of_type_AndroidContentContext.getString(2131692644) + apel.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692645);
    long l = apel.d();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692467) + apvd.a(l);
    }
    Object localObject2 = localObject1;
    if (apel.e() > 0L)
    {
      localObject2 = localObject1;
      if (!apug.a(this.jdField_a_of_type_AndroidContentContext)) {
        localObject2 = (String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692468) + apvd.a(apel.e());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (apel.b() > 0L) {}
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
    a(2131695142);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxi
 * JD-Core Version:    0.7.0.1
 */