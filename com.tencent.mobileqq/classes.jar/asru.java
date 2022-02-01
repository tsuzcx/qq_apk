import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class asru
  implements asrx
{
  public asru(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.a.d) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_Athl != null) {
        this.a.jdField_a_of_type_Athl.jdField_f_of_type_Long = System.currentTimeMillis();
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
          if (this.a.jdField_a_of_type_Athl != null)
          {
            this.a.jdField_a_of_type_Athl.jdField_a_of_type_Boolean = false;
            this.a.jdField_a_of_type_Athl.jdField_c_of_type_Long = (this.a.jdField_a_of_type_Athl.jdField_f_of_type_Long - this.a.jdField_a_of_type_Athl.jdField_e_of_type_Long);
            this.a.jdField_a_of_type_Athl.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
            this.a.jdField_a_of_type_Athl.i = paramString3;
            this.a.jdField_a_of_type_Athl.jdField_d_of_type_JavaLangString = paramString6;
            this.a.jdField_a_of_type_Athl.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_Athl.jdField_a_of_type_Long);
            this.a.jdField_a_of_type_Athl.a();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + paramString3 + "]");
          return;
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131703356));
        }
      }
      paramBoolean = false;
      String str = paramString1;
      paramString3 = paramString2;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("ishttps", false);
        paramBoolean = bool;
        str = paramString1;
        paramString3 = paramString2;
        if (bool)
        {
          str = paramBundle.getString("httpsdomain", null);
          paramString3 = paramBundle.getShort("httpsport", (short)0) + "";
          paramBoolean = bool;
        }
      }
      this.a.h = str;
      this.a.i = paramString3;
      this.a.jdField_b_of_type_Boolean = paramBoolean;
      this.a.jdField_f_of_type_JavaLangString = paramString4;
      this.a.jdField_g_of_type_JavaLangString = paramString5;
      if (paramBoolean) {}
      for (this.a.jdField_b_of_type_JavaLangString = ("https://" + str + ":" + paramString3 + "/ftn_doc_previewer/" + this.a.j);; this.a.jdField_b_of_type_JavaLangString = ("http://" + str + ":" + paramString3 + "/ftn_doc_previewer/" + this.a.j))
      {
        this.a.k = paramString6;
        if (this.a.jdField_a_of_type_Athl != null)
        {
          this.a.jdField_a_of_type_Athl.jdField_a_of_type_Boolean = true;
          this.a.jdField_a_of_type_Athl.jdField_g_of_type_JavaLangString = paramString4;
          this.a.jdField_a_of_type_Athl.i = "";
          this.a.jdField_a_of_type_Athl.jdField_f_of_type_Long = System.currentTimeMillis();
          this.a.jdField_a_of_type_Athl.jdField_c_of_type_Long = (this.a.jdField_a_of_type_Athl.jdField_f_of_type_Long - this.a.jdField_a_of_type_Athl.jdField_e_of_type_Long);
          this.a.jdField_a_of_type_Athl.jdField_c_of_type_JavaLangString = str;
          this.a.jdField_a_of_type_Athl.jdField_f_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
          this.a.jdField_a_of_type_Athl.jdField_d_of_type_JavaLangString = paramString6;
          this.a.jdField_a_of_type_Athl.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_Athl.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_Athl.a();
        }
        if (this.a.jdField_b_of_type_JavaLangString != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
        }
        this.a.finish();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.a.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.a.jdField_b_of_type_JavaLangString + ")");
      }
    } while (this.a.jdField_a_of_type_Athl == null);
    this.a.jdField_a_of_type_Athl.jdField_e_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_Athl.l = "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asru
 * JD-Core Version:    0.7.0.1
 */