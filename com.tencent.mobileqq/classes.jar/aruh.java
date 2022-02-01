import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class aruh
  implements aruk
{
  public aruh(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.a.d) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_Aslp != null) {
        this.a.jdField_a_of_type_Aslp.jdField_f_of_type_Long = System.currentTimeMillis();
      }
      this.a.d = true;
      if (!paramBoolean)
      {
        if ((paramString3 != null) && (paramString3.length() > 0)) {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
        }
        for (;;)
        {
          this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.a.jdField_g_of_type_Boolean = true;
          this.a.stopTitleProgress();
          if (this.a.jdField_a_of_type_Aslp != null)
          {
            this.a.jdField_a_of_type_Aslp.jdField_a_of_type_Boolean = false;
            this.a.jdField_a_of_type_Aslp.jdField_c_of_type_Long = (this.a.jdField_a_of_type_Aslp.jdField_f_of_type_Long - this.a.jdField_a_of_type_Aslp.jdField_e_of_type_Long);
            this.a.jdField_a_of_type_Aslp.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
            this.a.jdField_a_of_type_Aslp.h = paramString3;
            this.a.jdField_a_of_type_Aslp.jdField_c_of_type_JavaLangString = paramString6;
            this.a.jdField_a_of_type_Aslp.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_Aslp.jdField_a_of_type_Long);
            this.a.jdField_a_of_type_Aslp.a();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + paramString3 + "]");
          return;
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131703693));
        }
      }
      paramBoolean = false;
      paramString3 = paramString1;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("ishttps", false);
        paramBoolean = bool;
        paramString3 = paramString1;
        if (bool)
        {
          paramString3 = paramBundle.getString("httpsdomain", null);
          this.a.h = (paramBundle.getShort("httpsport", (short)0) + "");
          paramBoolean = bool;
        }
      }
      this.a.jdField_g_of_type_JavaLangString = paramString3;
      this.a.h = paramString2;
      this.a.jdField_b_of_type_Boolean = paramBoolean;
      this.a.jdField_e_of_type_JavaLangString = paramString4;
      this.a.jdField_f_of_type_JavaLangString = paramString5;
      if (paramBoolean) {}
      for (this.a.jdField_a_of_type_JavaLangString = ("https://" + paramString3 + ":" + paramString2 + "/ftn_doc_previewer/" + this.a.i);; this.a.jdField_a_of_type_JavaLangString = ("http://" + paramString3 + ":" + paramString2 + "/ftn_doc_previewer/" + this.a.i))
      {
        this.a.j = paramString6;
        if (this.a.jdField_a_of_type_Aslp != null)
        {
          this.a.jdField_a_of_type_Aslp.jdField_a_of_type_Boolean = true;
          this.a.jdField_a_of_type_Aslp.jdField_f_of_type_JavaLangString = paramString4;
          this.a.jdField_a_of_type_Aslp.h = "";
          this.a.jdField_a_of_type_Aslp.jdField_f_of_type_Long = System.currentTimeMillis();
          this.a.jdField_a_of_type_Aslp.jdField_c_of_type_Long = (this.a.jdField_a_of_type_Aslp.jdField_f_of_type_Long - this.a.jdField_a_of_type_Aslp.jdField_e_of_type_Long);
          this.a.jdField_a_of_type_Aslp.b = paramString3;
          this.a.jdField_a_of_type_Aslp.jdField_e_of_type_JavaLangString = this.a.jdField_a_of_type_JavaLangString;
          this.a.jdField_a_of_type_Aslp.jdField_c_of_type_JavaLangString = paramString6;
          this.a.jdField_a_of_type_Aslp.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_Aslp.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_Aslp.a();
        }
        if (this.a.jdField_a_of_type_JavaLangString != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
        }
        this.a.finish();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.a.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.a.jdField_a_of_type_JavaLangString + ")");
      }
    } while (this.a.jdField_a_of_type_Aslp == null);
    this.a.jdField_a_of_type_Aslp.jdField_e_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_Aslp.k = "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruh
 * JD-Core Version:    0.7.0.1
 */