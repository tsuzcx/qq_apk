import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atku
  extends atib
{
  atku(atkt paramatkt) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    atkt.a(this.a, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramString6, paramLong2, paramBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    this.a.a(paramBoolean, paramLong1, paramString1, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atku
 * JD-Core Version:    0.7.0.1
 */