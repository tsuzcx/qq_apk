import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atuh
  extends atpa
{
  atuh(atug paramatug) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle)
  {
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo, bSuccess[" + paramBoolean + " retCode:" + paramInt1 + " downloadIp:" + paramString4 + " downloadDomain:" + paramString5 + " port:" + paramInt2 + " url:" + paramString6 + " cookie:" + paramString2);
    atui localatui = atug.a(this.a, paramLong, false);
    if (localatui == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo no this session");
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if (!paramBoolean)
    {
      this.a.a.a().a(false, 50, new Object[] { localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo url=null");
      this.a.a.a().a(false, 50, new Object[] { localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    paramString6 = null;
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      paramString1 = paramString4;
    }
    while ((paramString1 == null) || (paramString1.length() < 0))
    {
      this.a.a.a().a(false, 50, new Object[] { localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
      paramString1 = paramString6;
      if (paramString5 != null)
      {
        paramString1 = paramString6;
        if (paramString5.length() > 0) {
          paramString1 = paramString5;
        }
      }
    }
    if ((paramString3 == null) || (paramString3.length() < 0)) {
      QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
    }
    paramString5 = "/ftn_video_pic/rkey=" + paramString3 + "&filetype=" + localatui.b + "&size=" + this.a.a(localatui.jdField_a_of_type_Int) + "&";
    paramBoolean = false;
    short s1 = 0;
    if ((atyt.h(this.a.a)) && (paramBundle != null))
    {
      paramString4 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramString4))
      {
        boolean bool = true;
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        paramBoolean = bool;
        paramString3 = paramString4;
        s1 = s2;
        if (s2 == 0)
        {
          s1 = 443;
          paramString3 = paramString4;
          paramBoolean = bool;
        }
      }
    }
    for (;;)
    {
      paramString4 = "";
      if (paramBundle != null) {
        paramString4 = paramBundle.getString("IPv6Dns");
      }
      this.a.a(paramLong, true, paramString1, paramInt2, paramString5, null, paramString2, paramBoolean, paramString3, s1, paramString4);
      return;
      paramString3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atuh
 * JD-Core Version:    0.7.0.1
 */