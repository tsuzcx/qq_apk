import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.15;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

public class arlh
  extends yub
{
  public arlh(TroopFileModel.15 param15) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramByteStringMicro1 = arrr.a(paramByteStringMicro1);
    paramString2 = null;
    paramString1 = paramString2;
    if (paramBoolean)
    {
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramInt1 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipType;
        paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramByteStringMicro1 + "&filetype=" + paramInt1 + "&path=" + bhsz.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath) + "&";
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.a.jdField_a_of_type_Arkm != null) {
        this.a.jdField_a_of_type_Arkm.a(paramString1, paramString4);
      }
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "url = " + paramString1 + ", cookies = " + paramString4);
      }
      if (this.a.this$0.a.a() != null)
      {
        paramString1 = String.valueOf(this.a.this$0.a.a().TroopUin);
        if (this.a.this$0.a.a() == null) {
          break label299;
        }
        paramString2 = arrr.b(this.a.this$0.a.a().nFileType);
        label269:
        azqs.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramString1, "", paramString2, "1");
      }
    }
    label299:
    do
    {
      return;
      paramString1 = "";
      break;
      paramString2 = "unknow";
      break label269;
      if (this.a.jdField_a_of_type_Arkm != null) {
        this.a.jdField_a_of_type_Arkm.c();
      }
    } while (!QLog.isColorLevel());
    QLog.e("zivonchen", 2, "url = " + paramString1 + ", cookies = " + paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlh
 * JD-Core Version:    0.7.0.1
 */