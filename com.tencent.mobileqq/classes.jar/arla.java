import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class arla
  extends yub
{
  arla(arkz paramarkz) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.a.e = arrr.a(paramByteStringMicro1);
    short s;
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.e)))
    {
      QLog.d("TroopFileModel<FileAssistant>", 2, "downURL:" + this.a.e);
      this.a.jdField_a_of_type_JavaLangString = paramString3;
      this.a.b = ("" + paramInt3);
      this.a.c = arrr.a(paramByteStringMicro1);
      this.a.d = paramString4;
      this.a.c = arrr.a(paramByteStringMicro1);
      if ((!bcnt.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!bcnt.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (paramBundle == null)) {
        break label418;
      }
      paramString1 = paramBundle.getString("strHttpsDomain");
      if (TextUtils.isEmpty(paramString1)) {
        break label418;
      }
      s = (short)paramBundle.getInt("httpsPort", 0);
      if (s != 0) {
        break label413;
      }
      paramBoolean = true;
      s = 443;
    }
    for (;;)
    {
      ytu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, "" + paramInt3, this.a.c, arrr.c(this.a.jdField_a_of_type_Arhz.a()), "/", paramString4, this.a.jdField_a_of_type_Arhz.a(), new arlb(this, paramBoolean, paramString1, s));
      do
      {
        return;
        QLog.e("TroopFileModel<FileAssistant>", 1, "get preview url failed for troop, retCode[" + paramInt1 + "], retMeg[" + paramString1 + "]");
        azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + this.a.jdField_a_of_type_Arhz.a().TroopUin, "-1", arrr.f(this.a.c()), "1");
      } while (this.a.jdField_a_of_type_Arkp == null);
      this.a.jdField_a_of_type_Arkp.a(paramInt1);
      return;
      label413:
      paramBoolean = true;
      continue;
      label418:
      s = 0;
      paramString1 = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arla
 * JD-Core Version:    0.7.0.1
 */