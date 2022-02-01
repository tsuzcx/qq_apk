import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1.1;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1.2;
import mqq.os.MqqHandler;

public class atfu
  extends bcuf
{
  atfu(atft paramatft) {}
  
  public void a(int paramInt)
  {
    if ((atft.d(this.a) != null) && (paramInt <= 100)) {
      atft.a(this.a).post(new DocsExportFileModel.1.2(this, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    atft.a(this.a, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    atft.a(this.a, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a.b;
    long l3 = this.a.b;
    long l4 = this.a.a;
    if (paramBoolean)
    {
      if ((atft.a(this.a) != null) && (atft.b(this.a).getBoolean("isMiniProgram", false))) {
        bcxh.a(atft.a(this.a), "0X800A4B3");
      }
      if (atft.a(this.a) != null)
      {
        atft.a(this.a).setFilePath(paramString1);
        atft.a(this.a).fileSize = aszt.a(paramString1);
        paramString1 = bcug.a(atft.a(this.a).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null)) {
          bcef.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, l3 - l4 + "", l1 - l2 + "", paramString1, paramString2);
        }
      }
      if (atft.a(this.a) != null)
      {
        atft.a(this.a).removeMessages(8001);
        atft.a(this.a).removeMessages(8002);
        atft.a(this.a).post(new DocsExportFileModel.1.1(this));
      }
      return;
    }
    paramString1 = amtj.a(2131702529);
    atft.a(this.a, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfu
 * JD-Core Version:    0.7.0.1
 */