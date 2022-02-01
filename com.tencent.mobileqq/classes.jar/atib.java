import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class atib
{
  void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof String))) {
      return;
    }
    Object localObject = (Object[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferObserver<FileAssistant>", 2, "onUpdate : type[" + paramInt + "], isSuccess[" + paramBoolean + "]");
    }
    switch (paramInt)
    {
    case 5008: 
    case 5009: 
    case 5010: 
    case 5011: 
    case 5012: 
    case 5017: 
    case 5018: 
    case 5019: 
    default: 
      QLog.e("FileTransferObserver<FileAssistant>", 1, "onUpdate : Can Not process type" + paramInt);
      return;
    case 5004: 
      a(paramBoolean, (athx)localObject[0], (anza)localObject[1], (List)localObject[2]);
      return;
    case 5005: 
      a(paramBoolean, (athx)localObject[0], (anza)localObject[1]);
      return;
    case 5006: 
      a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1], (String)localObject[2], (ByteStringMicro)localObject[3], ((Boolean)localObject[4]).booleanValue(), (String)localObject[5], ((Short)localObject[6]).shortValue(), (String)localObject[7], (List)localObject[8], ((Integer)localObject[9]).intValue(), (String)localObject[10], (String)localObject[11], (String)localObject[12], ((Long)localObject[13]).longValue(), (Bundle)localObject[14]);
      return;
    case 5007: 
      b(paramBoolean, (athx)localObject[0], (anza)localObject[1]);
      return;
    case 5013: 
      a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1], (String)localObject[2], (String)localObject[3], ((Integer)localObject[4]).intValue(), (String)localObject[5], (String)localObject[6], ((Integer)localObject[7]).intValue(), ((Long)localObject[8]).longValue(), (Bundle)localObject[9]);
      return;
    case 5014: 
      paramBoolean = ((Boolean)localObject[0]).booleanValue();
      long l = ((Long)localObject[1]).longValue();
      paramInt = ((Integer)localObject[2]).intValue();
      a(paramBoolean, l, ((Long)localObject[3]).longValue(), paramInt, ((Long)localObject[4]).longValue());
      return;
    case 5015: 
      paramObject = (Long)localObject[0];
      String str1 = (String)localObject[1];
      String str2 = (String)localObject[2];
      String str3 = (String)localObject[3];
      String str4 = (String)localObject[4];
      Integer localInteger = (Integer)localObject[5];
      String str5 = (String)localObject[6];
      String str6 = (String)localObject[7];
      localObject = (Bundle)localObject[8];
      a(paramBoolean, paramObject.longValue(), str1, str2, str3, str4, localInteger.intValue(), str5, str6, (Bundle)localObject);
      return;
    case 5016: 
      a(paramBoolean, (Long)localObject[0]);
      return;
    case 5020: 
      b(paramBoolean, (athx)localObject[0], (anza)localObject[1], (List)localObject[2]);
      return;
    case 5022: 
      b(paramBoolean, ((Boolean)localObject[0]).booleanValue(), (List)localObject[1]);
      return;
    }
    a(paramBoolean, ((Boolean)localObject[0]).booleanValue(), (List)localObject[1]);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, athx paramathx, anza paramanza) {}
  
  protected void a(boolean paramBoolean, athx paramathx, anza paramanza, List<String> paramList) {}
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList) {}
  
  public void aw_() {}
  
  protected void b(boolean paramBoolean, athx paramathx, anza paramanza) {}
  
  protected void b(boolean paramBoolean, athx paramathx, anza paramanza, List<String> paramList) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atib
 * JD-Core Version:    0.7.0.1
 */