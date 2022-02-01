import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class amsv
  extends amtc
{
  private aisr jdField_a_of_type_Aisr;
  private bgpa jdField_a_of_type_Bgpa;
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
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    if (this.jdField_a_of_type_Aisr != null)
    {
      this.jdField_a_of_type_Aisr.dismiss();
      this.jdField_a_of_type_Aisr = null;
    }
  }
  
  public void a(amtd paramamtd)
  {
    if (this.jdField_a_of_type_Aisr != null)
    {
      this.jdField_a_of_type_Aisr.hide();
      if (paramamtd != null) {
        paramamtd.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, amtd paramamtd)
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
        if (paramamtd != null) {
          paramamtd.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, amtd paramamtd)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Aisr == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Aisr = new aisr((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Aisr != null)
    {
      if (this.jdField_a_of_type_Aisr.isShowing()) {
        this.jdField_a_of_type_Aisr.hide();
      }
      localObject = this.jdField_a_of_type_Aisr.a(2131371343);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Aisr.setOnKeyListener(new amsw(this, paramamtd));
      this.jdField_a_of_type_Aisr.show();
      if (paramamtd != null) {
        paramamtd.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, amtd paramamtd)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramamtd, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramamtd != null) {
        paramamtd.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      this.jdField_a_of_type_Bgpa.hide();
    }
  }
  
  public void b(amtd paramamtd)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
      if (paramamtd != null) {
        paramamtd.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, amtd paramamtd)
  {
    if ((this.jdField_a_of_type_Bgpa == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bgpa = bglp.a(localContext, 230, paramString1, paramString2, new amsx(this, paramamtd), new amsy(this, paramamtd));
      }
    }
    if (this.jdField_a_of_type_Bgpa != null)
    {
      if (this.jdField_a_of_type_Bgpa.isShowing()) {
        this.jdField_a_of_type_Bgpa.hide();
      }
      this.jdField_a_of_type_Bgpa.setOnKeyListener(new amsz(this, paramamtd));
      this.jdField_a_of_type_Bgpa.setTitle(paramString1);
      this.jdField_a_of_type_Bgpa.setMessage(paramString2);
      this.jdField_a_of_type_Bgpa.show();
      if (paramamtd != null) {
        paramamtd.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsv
 * JD-Core Version:    0.7.0.1
 */