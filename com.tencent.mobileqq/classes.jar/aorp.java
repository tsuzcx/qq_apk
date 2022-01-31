import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;

public class aorp
{
  private static aorp jdField_a_of_type_Aorp;
  private int jdField_a_of_type_Int = -1;
  private TbsReaderView jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
  private TbsReaderView b;
  
  public static aorp a()
  {
    if (jdField_a_of_type_Aorp == null) {
      jdField_a_of_type_Aorp = new aorp();
    }
    return jdField_a_of_type_Aorp;
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, aorv paramaorv)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null) && (paramActivity.hashCode() == this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
    }
    if (!apdh.b(paramString)) {
      return null;
    }
    if (this.b != null)
    {
      this.b.onStop();
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
    }
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = new TbsReaderView(paramActivity, new aorq(this, paramActivity, paramaorv, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.setBackgroundColor(-1);
    Object localObject = apdh.a(paramString);
    paramaorv = (aorv)localObject;
    if (((String)localObject).startsWith(".")) {
      paramaorv = ((String)localObject).replaceFirst(".", "");
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.preOpen(paramaorv, false))
    {
      paramaorv = new Bundle();
      paramaorv.putString("filePath", paramString);
      paramString = apbo.a().b();
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramaorv.putString("tempPath", paramString);
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.openFile(paramaorv);
      this.jdField_a_of_type_Int = paramActivity.hashCode();
      return this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
    }
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalTbsViewManager<FileAssistant>", 4, "LocalTbsViewManager destroy hashCode[" + this.jdField_a_of_type_Int + "],activity[" + i + "]");
    }
    if (this.jdField_a_of_type_Int != i) {}
    do
    {
      return;
      if (this.b != null)
      {
        this.b.onStop();
        this.b = null;
      }
    } while (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView == null);
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = null;
  }
  
  public boolean a(Activity paramActivity, String paramString, aorv paramaorv, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return 2-------");
      }
      this.b.onStop();
      this.b = null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (paramaorv != null) {
        paramaorv.b(false);
      }
      return false;
    }
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new aoru(this, paramaorv));
    paramActivity = apdh.a(paramString);
    if (paramActivity.startsWith(".")) {
      paramActivity = paramActivity.replaceFirst(".", "");
    }
    for (;;)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        if (localTbsReaderView.preOpen(paramActivity, bool)) {
          break label152;
        }
        localTbsReaderView.onStop();
        if (paramaorv != null) {
          paramaorv.b(false);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
        return false;
      }
      label152:
      if ((paramBoolean) && (paramaorv != null)) {
        paramaorv.b(true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
      }
      this.b = localTbsReaderView;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorp
 * JD-Core Version:    0.7.0.1
 */