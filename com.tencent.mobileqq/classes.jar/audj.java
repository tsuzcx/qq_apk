import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.4;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsReaderView;
import java.io.File;
import java.util.HashMap;

public class audj
{
  private static audj jdField_a_of_type_Audj;
  private int jdField_a_of_type_Int = -1;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private TbsReaderView jdField_b_of_type_ComTencentTbsReaderTbsReaderView;
  private boolean jdField_b_of_type_Boolean;
  
  public static audj a()
  {
    if (jdField_a_of_type_Audj == null) {
      jdField_a_of_type_Audj = new audj();
    }
    return jdField_a_of_type_Audj;
  }
  
  private void a()
  {
    audm localaudm = new audm(this);
    ThreadManagerV2.getUIHandlerV2().post(new LocalTbsViewManager.4(this, localaudm));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      bdll.b(null, "dc00898", "", "", "0X800B00B", "0X800B00B", 0, 0, "", "", "", "");
      return;
    }
    if (paramBoolean2) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800B00C", "0X800B00C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", paramString);
    paramString = aumo.a().b();
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localBundle.putString("tempPath", paramString);
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("file_reader_tool_bar_hide", bool);
      localBundle.putInt("file_reader_download_type", 1);
      localBundle.putString("reader_tokenid", "Y29tLnRlbmNlbnQubW9iaWxlcXE=");
      localBundle.putString("reader_pkgname", "com.tencent.mobileqq");
      localBundle.putBoolean("file_reader_click_action_disable", true);
      localBundle.putInt("style", 2);
      localBundle.putInt("file_reader_bg_content_color", -1);
      localBundle.putBoolean("file_reader_add_view_to_toolbar", this.jdField_b_of_type_Boolean);
      localBundle.putString("big_brother_source_key", "biz_src_jc_file");
      return localBundle;
    }
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, audo paramaudo)
  {
    if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (paramActivity.hashCode() == this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    }
    if (!auog.b(paramString)) {
      return null;
    }
    if (this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView != null)
    {
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView.onStop();
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null)
    {
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = new TbsReaderView(paramActivity, new audp(this, paramaudo, paramActivity, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.setBackgroundColor(-1);
    String str = auog.a(paramString);
    paramaudo = str;
    if (str.startsWith(".")) {
      paramaudo = str.replaceFirst(".", "");
    }
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.preOpen(paramaudo, false))
    {
      paramString = a(paramString);
      if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.openFile(paramString) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(true, bool);
        this.jdField_a_of_type_Int = paramActivity.hashCode();
        return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
      }
    }
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    return null;
  }
  
  public void a(int paramInt, audo paramaudo)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LocalTbsViewManager.6(this, paramInt, paramaudo));
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
      if (this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView != null)
      {
        this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView.onStop();
        this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
      }
    } while (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView == null);
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      bdll.b(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
      paramBundle = (Intent)paramBundle.getParcelable("file_open_intent");
    } while (paramBundle == null);
    paramBundle.putExtra("big_brother_source_key", "biz_src_jc_file");
    paramContext.startActivity(paramBundle);
  }
  
  public void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      QLog.e("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser params null!");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_start", paramBundle.getString("stat_download_start", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_downloading", paramBundle.getString("stat_download_downloading", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_success", paramBundle.getString("stat_download_success", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_failed", paramBundle.getString("stat_download_failed", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_installed_success", paramBundle.getString("stat_download_installed_success", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_open_qb_success", paramBundle.getString("stat_open_qb_success", ""));
    paramBundle = paramBundle.getString("download_url", "");
    if (aure.a().a(paramBundle))
    {
      QLog.w("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser isExistedDownloadOfUrl show toast!");
      QQToast.a(paramContext, 0, 2131697538, 0).a();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_open_with_qq_browser_", paramString);
    localBundle.putBoolean("tbs_new_report", true);
    aunj.a(paramContext, paramBundle, localBundle);
    a("stat_download_start");
  }
  
  public void a(Context paramContext, Object paramObject1, Object paramObject2, String paramString, audo paramaudo)
  {
    if ((paramObject1 == null) || (!(paramObject1 instanceof Bundle))) {
      return;
    }
    paramObject1 = (Bundle)paramObject1;
    int i = paramObject1.getInt("typeId", -1);
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "handleTbsReaderEvent: actionType[" + i + "]");
    switch (i)
    {
    case 3: 
    default: 
      return;
    case 1: 
      bdll.b(null, "dc00898", "", "", "0X800AF71", "0X800AF71", 0, 0, "", "", "", "");
      return;
    case 2: 
      bdll.b(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 1, 0, "", "", "", "");
      return;
    case 4: 
      bdll.b(null, "dc00898", "", "", "0X800AF74", "0X800AF74", 0, 0, "", "", "", "");
      return;
    case 5: 
      bdll.b(null, "dc00898", "", "", "0X800AF75", "0X800AF75", 0, 0, "", "", "", "");
      a(paramContext, paramObject1, paramString);
      return;
    case 6: 
      a(paramContext, paramObject1);
      return;
    }
    a(paramObject2, paramaudo);
  }
  
  public void a(Object paramObject, Activity paramActivity, audo paramaudo)
  {
    if (paramObject == null) {
      return;
    }
    int i = ((Bundle)paramObject).getInt("function_id");
    paramaudo.a(TbsReaderView.getResString(paramActivity, i), TbsReaderView.getResDrawable(paramActivity, i + 1), TbsReaderView.getResDrawable(paramActivity, i + 2), new audn(this, i, paramActivity));
  }
  
  public void a(Object paramObject, audo paramaudo)
  {
    paramaudo = paramaudo.a();
    if (((paramObject instanceof ViewGroup)) && ((paramaudo instanceof View))) {
      ((ViewGroup)paramObject).addView(paramaudo);
    }
  }
  
  public void a(Object paramObject, String paramString)
  {
    if (!(paramObject instanceof Integer)) {}
    while (((Integer)paramObject).intValue() != 0) {
      return;
    }
    paramObject = a(paramString);
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.openFile(paramObject) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(true, bool);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "reportQQBrowserDownloadEvent: reportType[" + paramString + "]");
      if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (!TextUtils.isEmpty(str))) {
        this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.userStatistics(str);
      }
      if (paramString.equals("stat_download_success"))
      {
        bdll.b(null, "dc00898", "", "", "0X800AF76", "0X800AF76", 0, 0, "", "", "", "");
        return;
      }
    } while (!paramString.equals("stat_open_qb_success"));
    bdll.b(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return ReaderEngine.getInstance().getVersionCode() >= 5060010;
  }
  
  public boolean a(Activity paramActivity, String paramString, audo paramaudo, boolean paramBoolean)
  {
    if (!a(true)) {}
    do
    {
      return false;
      if (this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "canOpenFile return 2-------");
        }
        this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView.onStop();
        this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (paramaudo == null);
    paramaudo.b(false);
    return false;
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new audk(this, paramaudo));
    paramActivity = auog.a(paramString);
    if (paramActivity.startsWith(".")) {
      paramActivity = paramActivity.replaceFirst(".", "");
    }
    for (;;)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        if (localTbsReaderView.preOpen(paramActivity, bool)) {
          break label165;
        }
        localTbsReaderView.onStop();
        if (paramaudo != null) {
          paramaudo.b(false);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
        return false;
      }
      label165:
      if ((paramBoolean) && (paramaudo != null)) {
        paramaudo.b(true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
      }
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = localTbsReaderView;
      return true;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine init. isForeground[" + paramBoolean + "]");
    audl localaudl = new audl(this);
    paramBoolean = ReaderEngine.getInstance().fileEnginePreLoad(BaseApplicationImpl.getApplication(), localaudl, paramBoolean);
    if (paramBoolean)
    {
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine had downloaded.");
      a();
      return paramBoolean;
    }
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine not download.");
    bdll.b(null, "dc00898", "", "", "0X800B009", "0X800B009", 0, 0, "", "", "", "");
    return paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audj
 * JD-Core Version:    0.7.0.1
 */