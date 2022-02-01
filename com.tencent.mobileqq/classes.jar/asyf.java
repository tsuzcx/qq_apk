import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class asyf
  implements aufp
{
  public asyf(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void loadFinish(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label56;
      }
      this.a.a(bool, paramInt2, paramString);
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
      this.a.jdField_g_of_type_Boolean = true;
      this.a.a(1000);
      return;
      bool = false;
      break;
      label56:
      if (paramInt1 == 1) {
        this.a.b(bool, paramInt2, paramString);
      }
    }
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt2 == 0)
    {
      bool1 = true;
      this.a.runOnUiThread(new FilePreviewActivity.16.2(this, paramInt1, bool1, paramInt2, paramString));
      paramString = this.a;
      if (paramBoolean) {
        break label67;
      }
    }
    label67:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramString.jdField_g_of_type_Boolean = paramBoolean;
      this.a.a(1000);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void openFile(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = new Intent(this.a, FilePreviewActivity.class);
      ((Intent)localObject1).putExtra("offline_file_type", 1);
      ((Intent)localObject1).putExtra("offline_file_name", this.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_url", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_bZip", this.a.jdField_a_of_type_Boolean);
      ((Intent)localObject1).putExtra("offline_file_domain", this.a.jdField_g_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_port", this.a.h);
      ((Intent)localObject1).putExtra("offline_file_domain_key", this.a.e);
      ((Intent)localObject1).putExtra("offline_file_type_key", this.a.jdField_b_of_type_Int);
      ((Intent)localObject1).putExtra("OfflinePreZipPath", paramString2);
      ((Intent)localObject1).putExtra("OfflinePreZipDirName", paramString1);
      ((Intent)localObject1).putExtra("OfflinePreZipUUID", this.a.j);
      if (!TextUtils.isEmpty(this.a.f)) {
        ((Intent)localObject1).putExtra("COOKIE", this.a.f);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
      this.a.startActivityForResult((Intent)localObject1, 0);
      return;
    }
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.a.j)) {}
    Object localObject3;
    do
    {
      Object localObject2;
      do
      {
        localObject2 = auht.a();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("_filename_from_dlg", paramString1);
        ((Bundle)localObject3).putLong("_filesize_from_dlg", paramLong);
        ((Bundle)localObject3).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_file_preview");
        ((Bundle)localObject3).putString("big_brother_source_key", "biz_src_file_preview");
        Bundle localBundle = new Bundle();
        localBundle.putString("FILE_TMP_SERVER_PATH", (String)localObject1);
        localBundle.putInt("FILE_FROM", 190);
        if (!TextUtils.isEmpty(this.a.f)) {
          localBundle.putString("COOKIE", this.a.f);
        }
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>FilePreviewActivity", 1, "set cookies:" + this.a.f);
        }
        ((Bundle)localObject3).putBundle("_user_data", localBundle);
        bhdj.a(this.a, 233, this.a.getString(2131718183), "是否下载文件:\n" + paramString1 + "(" + FileUtil.filesizeToString(paramLong) + ")", new asyg(this, paramString2, (auht)localObject2, (Bundle)localObject3), new asyh(this)).show();
        return;
        localObject2 = MD5.toMD5(this.a.j + paramString2 + paramString1);
        localObject3 = this.a.app.getFileManagerDataCenter().b((String)localObject2);
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (!FileUtil.fileExistsAndNotEmpty(((FileManagerEntity)localObject3).getFilePath()));
    paramString1 = new audz();
    paramString1.jdField_b_of_type_JavaLangString = "file_viewer_in";
    paramString1.jdField_a_of_type_Int = 73;
    paramString1.c = FileUtil.getExtension(((FileManagerEntity)localObject3).fileName);
    paramString1.jdField_a_of_type_Long = ((FileManagerEntity)localObject3).fileSize;
    audy.a(this.a.app.getCurrentAccountUin(), paramString1);
    audy.a("0X8004AE4");
    paramString1 = new ForwardFileInfo();
    paramString1.d(((FileManagerEntity)localObject3).getCloudType());
    paramString1.b(10000);
    paramString1.b(((FileManagerEntity)localObject3).nSessionId);
    paramString1.c(((FileManagerEntity)localObject3).uniseq);
    paramString1.d(((FileManagerEntity)localObject3).fileName);
    paramString1.d(((FileManagerEntity)localObject3).fileSize);
    paramString1.b(((FileManagerEntity)localObject3).Uuid);
    paramString1.a(((FileManagerEntity)localObject3).getFilePath());
    paramString2 = new ArrayList();
    try
    {
      paramString2.add(new FileInfo(((FileManagerEntity)localObject3).getFilePath()));
      if ((((FileManagerEntity)localObject3).nFileType == 0) || (((FileManagerEntity)localObject3).nFileType == 1)) {
        atpm.a(paramString2);
      }
      paramString2 = new Intent(this.a.getActivity(), FileBrowserActivity.class);
      paramString2.putExtra("fileinfo", paramString1);
      this.a.getActivity().startActivityForResult(paramString2, 102);
      audy.a("0X80052CD");
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void updatePage(int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new FilePreviewActivity.16.1(this, paramInt1, paramInt2));
  }
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyf
 * JD-Core Version:    0.7.0.1
 */