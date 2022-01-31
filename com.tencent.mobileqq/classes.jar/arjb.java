import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class arjb
  extends aqtp
{
  arjb(arja paramarja, aqxm paramaqxm) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    QLog.i("VideoForDisc<QFile>", 2, "[" + this.jdField_a_of_type_Arja.a.nSessionId + "],[getOnlinePlay Url]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    if (paramLong1 == -100001L) {}
    while ((paramString3 == null) || (paramString3.length() == 0))
    {
      paramLong2 = 9360L;
      if (paramLong1 == 0L) {
        paramLong2 = 9048L;
      }
      this.jdField_a_of_type_Aqxm.a((int)paramLong2, BaseApplication.getContext().getResources().getString(2131690976));
      return;
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        this.jdField_a_of_type_Arja.a(true);
        this.jdField_a_of_type_Aqxm.a((int)paramLong1, BaseApplication.getContext().getResources().getString(2131692973));
        return;
      }
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Arja.a(false);
        this.jdField_a_of_type_Aqxm.a((int)0L, BaseApplication.getContext().getResources().getString(2131690976));
        return;
      }
    }
    paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
    if (QLog.isColorLevel()) {
      QLog.d("VideoForDisc<QFile>", 1, paramString1);
    }
    this.jdField_a_of_type_Aqxm.a(paramString1, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjb
 * JD-Core Version:    0.7.0.1
 */