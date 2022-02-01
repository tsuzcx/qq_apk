import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class amzz
  extends anag
{
  private aitj jdField_a_of_type_Aitj;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  int a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    return 0;
  }
  
  public String a()
  {
    return "Dialog";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    if (this.jdField_a_of_type_Aitj != null)
    {
      this.jdField_a_of_type_Aitj.dismiss();
      this.jdField_a_of_type_Aitj = null;
    }
  }
  
  public void a(anah paramanah)
  {
    if (this.jdField_a_of_type_Aitj != null)
    {
      this.jdField_a_of_type_Aitj.hide();
      if (paramanah != null) {
        paramanah.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, anah paramanah)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = 1500;
      }
      j = i;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        j = i;
        if (localContext != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
        if (paramanah != null) {
          paramanah.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, anah paramanah)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Aitj == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Aitj = new aitj((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Aitj != null)
    {
      if (this.jdField_a_of_type_Aitj.isShowing()) {
        this.jdField_a_of_type_Aitj.hide();
      }
      localObject = this.jdField_a_of_type_Aitj.a(2131371603);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Aitj.setOnKeyListener(new anaa(this, paramanah));
      this.jdField_a_of_type_Aitj.show();
      if (paramanah != null) {
        paramanah.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, anah paramanah)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramanah, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramanah != null) {
        paramanah.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
    }
  }
  
  public void b(anah paramanah)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
      if (paramanah != null) {
        paramanah.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, anah paramanah)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(localContext, 230, paramString1, paramString2, new anab(this, paramanah), new anac(this, paramanah));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new anad(this, paramanah));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      if (paramanah != null) {
        paramanah.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzz
 * JD-Core Version:    0.7.0.1
 */