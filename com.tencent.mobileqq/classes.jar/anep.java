import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class anep
  extends anew
{
  private ajea jdField_a_of_type_Ajea;
  private bhpc jdField_a_of_type_Bhpc;
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
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    if (this.jdField_a_of_type_Ajea != null)
    {
      this.jdField_a_of_type_Ajea.dismiss();
      this.jdField_a_of_type_Ajea = null;
    }
  }
  
  public void a(anex paramanex)
  {
    if (this.jdField_a_of_type_Ajea != null)
    {
      this.jdField_a_of_type_Ajea.hide();
      if (paramanex != null) {
        paramanex.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, anex paramanex)
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
        if (paramanex != null) {
          paramanex.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, anex paramanex)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Ajea == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Ajea = new ajea((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Ajea != null)
    {
      if (this.jdField_a_of_type_Ajea.isShowing()) {
        this.jdField_a_of_type_Ajea.hide();
      }
      localObject = this.jdField_a_of_type_Ajea.a(2131371450);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Ajea.setOnKeyListener(new aneq(this, paramanex));
      this.jdField_a_of_type_Ajea.show();
      if (paramanex != null) {
        paramanex.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, anex paramanex)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramanex, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramanex != null) {
        paramanex.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      this.jdField_a_of_type_Bhpc.hide();
    }
  }
  
  public void b(anex paramanex)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
      if (paramanex != null) {
        paramanex.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, anex paramanex)
  {
    if ((this.jdField_a_of_type_Bhpc == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bhpc = bhlq.a(localContext, 230, paramString1, paramString2, new aner(this, paramanex), new anes(this, paramanex));
      }
    }
    if (this.jdField_a_of_type_Bhpc != null)
    {
      if (this.jdField_a_of_type_Bhpc.isShowing()) {
        this.jdField_a_of_type_Bhpc.hide();
      }
      this.jdField_a_of_type_Bhpc.setOnKeyListener(new anet(this, paramanex));
      this.jdField_a_of_type_Bhpc.setTitle(paramString1);
      this.jdField_a_of_type_Bhpc.setMessage(paramString2);
      this.jdField_a_of_type_Bhpc.show();
      if (paramanex != null) {
        paramanex.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anep
 * JD-Core Version:    0.7.0.1
 */