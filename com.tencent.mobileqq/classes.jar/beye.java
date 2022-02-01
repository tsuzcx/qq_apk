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

public class beye
  implements bexs, bexv, beyc
{
  private int jdField_a_of_type_Int = 0;
  protected long a;
  private aaro jdField_a_of_type_Aaro = new beyf(this);
  private bevk jdField_a_of_type_Bevk;
  private bexr jdField_a_of_type_Bexr;
  private String jdField_a_of_type_JavaLangString;
  private List<beyd> jdField_a_of_type_JavaUtilList = new LinkedList();
  private UUID jdField_a_of_type_JavaUtilUUID;
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
  
  public beye(UUID paramUUID, long paramLong, String paramString1, String paramString2)
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
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadSuc. bHit:" + paramBoolean);
    b(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((beyd)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, true, 0, this);
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile app=null");
      this.jdField_b_of_type_Boolean = true;
      c(bfuj.w);
      return;
    }
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile");
    this.jdField_a_of_type_Bevk = aaqt.a(localQQAppInterface, this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, "", null, this.jdField_a_of_type_Aaro);
    b(2);
  }
  
  private void c(int paramInt)
  {
    bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr ResultCode:" + paramInt);
    this.jdField_a_of_type_Boolean = true;
    b(6);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((beyd)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, false, paramInt, this);
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
      bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int + " reason:" + paramInt);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_b_of_type_Long != 0L)
      {
        bexu.a().a(this.jdField_b_of_type_Long);
        this.jdField_b_of_type_Long = 0L;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bevk != null)
      {
        aaqt.a(bevv.a(), this.jdField_a_of_type_Bevk);
        this.jdField_a_of_type_Bevk = null;
      }
      b(0);
      return;
      if (this.jdField_a_of_type_Int == 3) {
        if (this.jdField_a_of_type_Bexr == null)
        {
          bevx.b("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop upload. uploader=null");
        }
        else
        {
          this.jdField_a_of_type_Bexr.a();
          this.jdField_a_of_type_Bexr = null;
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
      bevx.b("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. but had stop");
      return;
    }
    if (paramInt != 0)
    {
      this.jdField_b_of_type_Boolean = true;
      int i = bfuj.l;
      if (paramInt == -2) {
        i = bfuj.s;
      }
      for (;;)
      {
        bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
        c(i);
        return;
        if (paramInt == -1) {
          i = bfuj.g;
        } else if (paramInt == -4) {
          i = bfuj.jdField_e_of_type_Int;
        } else if (paramInt == -3) {
          i = bfuj.j;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. md5 or sha is null");
      this.jdField_b_of_type_Boolean = true;
      c(bfuj.l);
      return;
    }
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
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
  
  public void a(beyd parambeyd)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambeyd);
  }
  
  public void a(String paramString)
  {
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload app=null");
      this.jdField_b_of_type_Boolean = true;
      c(bfuj.w);
      return;
    }
    if (this.jdField_a_of_type_Bexr != null)
    {
      this.jdField_a_of_type_Bexr.a();
      this.jdField_a_of_type_Bexr.a(null);
    }
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload firstIP=" + this.jdField_e_of_type_JavaLangString);
    String str1 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
    String str2 = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
    long l = bevv.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_e_of_type_JavaLangString);
    if ((!paramBoolean) && (!TextUtils.isEmpty(this.f)))
    {
      if (!atcq.a().a(localQQAppInterface, 3)) {
        break label488;
      }
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. is config enable IPv6. domain[" + this.f + "]");
      Object localObject = new atcr(this.f, 0);
      localObject = atcq.a().a(localQQAppInterface, (atcr)localObject, 3);
      if ((localObject == null) || (((atct)localObject).a())) {
        break label439;
      }
      if (atcq.a())
      {
        QLog.d("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. debugIsDisableIPv4OnDoubleStack");
        localArrayList.clear();
      }
      atcq.a(((atct)localObject).jdField_a_of_type_JavaUtilList, localArrayList, true, false);
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv6. iplist:" + localArrayList.toString());
    }
    for (;;)
    {
      paramBoolean = bfsj.a(localQQAppInterface);
      this.jdField_a_of_type_Bexr = beyj.a(localQQAppInterface, l, this.jdField_c_of_type_JavaLangString, str1, str2, localArrayList, "/ftn_handler", paramBoolean, this.f);
      if (this.jdField_a_of_type_Bexr != null) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      c(bfuj.w);
      return;
      label439:
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv4:");
      localArrayList.add(this.f);
      continue;
      label488:
      localArrayList.add(this.f);
    }
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " firstIP=" + this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Bexr.a(this);
    this.jdField_a_of_type_Bexr.a();
    b(3);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
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
    c(bfuj.v);
  }
  
  public boolean a()
  {
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath:" + this.jdField_c_of_type_JavaLangString);
    if (!bgnt.g(BaseApplication.getContext()))
    {
      bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
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
    this.jdField_b_of_type_Long = bexu.a().a(this.jdField_c_of_type_JavaLangString, this, null);
    if (this.jdField_b_of_type_Long == 0L)
    {
      this.jdField_b_of_type_Boolean = true;
      bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. startScan failed");
      c(bfuj.w);
      return;
    }
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. cookie:" + this.jdField_b_of_type_Long);
    b(1);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3) {}
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return atjh.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String d()
  {
    return atjh.a(this.jdField_b_of_type_ArrayOfByte);
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
    bevx.a("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onOutDate. upload fail");
    c(206);
  }
  
  public void i()
  {
    bevx.c("TroopFileUploadSimpleWorker", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetrySend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beye
 * JD-Core Version:    0.7.0.1
 */