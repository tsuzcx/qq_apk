import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class atya
  extends aahg
{
  atya(atxr paramatxr) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramByteStringMicro2 = this.a.a.a();
    paramByteStringMicro1 = auea.a(paramByteStringMicro1);
    paramString2 = null;
    paramString1 = paramString2;
    if (paramBoolean)
    {
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramInt1 = paramByteStringMicro2.zipType;
        paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramByteStringMicro1 + "&filetype=" + paramInt1 + "&path=" + bkyp.a(paramByteStringMicro2.zipInnerPath) + "&";
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopFileModel<FileAssistant>", 1, "url = " + paramString1 + ", cookies = " + paramString4);
      }
      if (atxr.a(this.a) != null) {
        atxr.a(this.a).a(paramString1, paramString4);
      }
      if (this.a.a.a() != null)
      {
        paramString1 = String.valueOf(this.a.a.a().TroopUin);
        if (this.a.a.a() == null) {
          break label291;
        }
        paramString2 = auea.b(this.a.a.a().nFileType);
        label261:
        bdla.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramString1, "", paramString2, "1");
      }
    }
    label291:
    do
    {
      return;
      paramString1 = "";
      break;
      paramString2 = "unknow";
      break label261;
      QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl_onGetFilePreviewResult error, url is null.");
    } while (atxr.a(this.a) == null);
    atxr.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atya
 * JD-Core Version:    0.7.0.1
 */