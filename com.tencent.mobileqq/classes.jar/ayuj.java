import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ayuj
  implements aytx, ayua, ayuh
{
  private int jdField_a_of_type_Int = 0;
  protected long a;
  private ayrp jdField_a_of_type_Ayrp;
  private aytw jdField_a_of_type_Aytw;
  private String jdField_a_of_type_JavaLangString;
  private List<ayui> jdField_a_of_type_JavaUtilList = new LinkedList();
  private UUID jdField_a_of_type_JavaUtilUUID;
  private wme jdField_a_of_type_Wme = new ayuk(this);
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 102;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  
  public ayuj(UUID paramUUID, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilUUID = paramUUID;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilUUID.toString();
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadSuc. bHit:" + paramBoolean);
    b(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayui)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, true, 0, this);
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile app=null");
      this.jdField_b_of_type_Boolean = true;
      c(azle.w);
      return;
    }
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile");
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, "", null, this.jdField_a_of_type_Wme);
    b(2);
  }
  
  private void c(int paramInt)
  {
    aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr ResultCode:" + paramInt);
    this.jdField_a_of_type_Boolean = true;
    b(6);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayui)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, false, paramInt, this);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_JavaUtilUUID;
  }
  
  public void a()
  {
    b(7);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int + " reason:" + paramInt);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_b_of_type_Long != 0L)
      {
        aytz.a().a(this.jdField_b_of_type_Long);
        this.jdField_b_of_type_Long = 0L;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ayrp != null)
      {
        wln.a(ayrz.a(), this.jdField_a_of_type_Ayrp);
        this.jdField_a_of_type_Ayrp = null;
      }
      b(0);
      return;
      if (this.jdField_a_of_type_Int == 3) {
        if (this.jdField_a_of_type_Aytw == null)
        {
          aysb.b("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop upload. uploader=null");
        }
        else
        {
          this.jdField_a_of_type_Aytw.a();
          this.jdField_a_of_type_Aytw = null;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (paramLong <= this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Long != paramLong1) {}
    while ((paramLong2 == 0L) || (this.jdField_d_of_type_Long != 0L)) {
      return;
    }
    this.jdField_d_of_type_Long = paramLong2;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      aysb.b("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. but had stop");
      return;
    }
    if (paramInt != 0)
    {
      this.jdField_b_of_type_Boolean = true;
      int i = azle.l;
      if (paramInt == -2) {
        i = azle.s;
      }
      for (;;)
      {
        aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
        c(i);
        return;
        if (paramInt == -1) {
          i = azle.g;
        } else if (paramInt == -4) {
          i = azle.jdField_e_of_type_Int;
        } else if (paramInt == -3) {
          i = azle.j;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. md5 or sha is null");
      this.jdField_b_of_type_Boolean = true;
      c(azle.l);
      return;
    }
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
    if ((paramLong2 != 0L) && (this.jdField_d_of_type_Long == 0L)) {
      this.jdField_d_of_type_Long = paramLong2;
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Int = paramBundle.getInt("_with_", 0);
      this.jdField_d_of_type_Int = paramBundle.getInt("_height_", 0);
      this.jdField_e_of_type_Int = paramBundle.getInt("_duration_", 0);
    }
    c();
  }
  
  public void a(ayui paramayui)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramayui);
  }
  
  public void a(String paramString)
  {
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload app=null");
      this.jdField_b_of_type_Boolean = true;
      c(azle.w);
      return;
    }
    if (this.jdField_a_of_type_Aytw != null)
    {
      this.jdField_a_of_type_Aytw.a();
      this.jdField_a_of_type_Aytw.a(null);
    }
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload firstIP=" + this.jdField_e_of_type_JavaLangString);
    String str1 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
    String str2 = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
    long l = ayrz.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_e_of_type_JavaLangString);
    if ((!paramBoolean) && (!TextUtils.isEmpty(this.f)))
    {
      localArrayList.add(this.f);
      if (!apdq.b(localQQAppInterface)) {
        break label307;
      }
      QLog.i("TroopFileUploadSimpleWorker<FileAssistant>", 1, "[Troop Upload] upload support IPv6. domain[" + this.f + "]");
      localArrayList.add(0, this.f);
    }
    for (;;)
    {
      paramBoolean = azjg.a(localQQAppInterface);
      this.jdField_a_of_type_Aytw = ayuo.a(localQQAppInterface, l, this.jdField_c_of_type_JavaLangString, str1, str2, localArrayList, "/ftn_handler", paramBoolean, this.f);
      if (this.jdField_a_of_type_Aytw != null) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      c(azle.w);
      return;
      label307:
      localArrayList.add(this.f);
    }
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " firstIP=" + this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Aytw.a(this);
    this.jdField_a_of_type_Aytw.a();
    b(3);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    this.jdField_b_of_type_Boolean = true;
    c(paramInt);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    c(azle.v);
  }
  
  public boolean a()
  {
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath:" + this.jdField_c_of_type_JavaLangString);
    if (!badq.g(BaseApplication.getContext()))
    {
      aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
      b(6);
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    b();
    return true;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Long = aytz.a().a(this.jdField_c_of_type_JavaLangString, this, null);
    if (this.jdField_b_of_type_Long == 0L)
    {
      this.jdField_b_of_type_Boolean = true;
      aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. startScan failed");
      c(azle.w);
      return;
    }
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. cookie:" + this.jdField_b_of_type_Long);
    b(1);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3) {}
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return aopg.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String d()
  {
    return aopg.a(this.jdField_b_of_type_ArrayOfByte);
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(false);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    aysb.a("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onOutDate. upload fail");
    c(206);
  }
  
  public void i()
  {
    aysb.c("TroopFileUploadSimpleWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetrySend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayuj
 * JD-Core Version:    0.7.0.1
 */