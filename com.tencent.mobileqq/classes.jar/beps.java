import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class beps
{
  public int a;
  public long a;
  public long b;
  
  public beps()
  {
    a();
  }
  
  public beps(beps parambeps)
  {
    a(parambeps);
  }
  
  public static boolean a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return (paramLong2 != -1L) && ((paramLong1 == -1L) || ((paramInt1 == paramInt2) && (paramLong1 > paramLong2)) || ((paramInt1 != paramInt2) && (bepr.a(paramInt2, paramInt1))));
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("biz_type", this.jdField_a_of_type_Int);
      localJSONObject.put("shmsgseq", this.jdField_a_of_type_Long);
      localJSONObject.put("uniseq", this.b);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_Long != -1L))
    {
      this.b = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.MessageNavInfo", 2, "updateMsgSeq, preBizType = " + this.jdField_a_of_type_Int + ", newBizType = " + paramInt + ", msgSeq = " + paramLong);
      }
    }
  }
  
  public void a(beps parambeps)
  {
    if (parambeps != null)
    {
      this.jdField_a_of_type_Int = parambeps.jdField_a_of_type_Int;
      this.jdField_a_of_type_Long = parambeps.jdField_a_of_type_Long;
      this.b = parambeps.b;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("biz_type");
      this.jdField_a_of_type_Long = paramString.getLong("shmsgseq");
      this.b = paramString.getLong("uniseq");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != -1L;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, paramInt, paramLong);
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool = a(paramInt, paramLong1);
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.MessageNavInfo", 2, "update, preBizType = " + this.jdField_a_of_type_Int + ", newBizType = " + paramInt + ", needUpdate = " + bool + ", shmsgseq = " + paramLong1 + ", uniseq = " + paramLong2);
    }
    if (bool)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = paramLong1;
      this.b = paramLong2;
      return true;
    }
    return false;
  }
  
  public boolean a(beps parambeps)
  {
    if (parambeps == null) {
      return false;
    }
    return a(parambeps.jdField_a_of_type_Int, parambeps.jdField_a_of_type_Long, parambeps.b);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int j = 27;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
        i = j;
        if (paramQQAppInterface != null)
        {
          i = j;
          if (paramQQAppInterface.hasOrgs()) {
            i = 14;
          }
        }
      }
    }
    return a(i, paramLong1, paramLong2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Navigate.MessageNavInfo", 2, "updateShMsgSeq, preBizType = " + this.jdField_a_of_type_Int + ", newBizType = " + paramInt + ", newShMsgSeq = " + paramLong);
    }
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != paramInt)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beps
 * JD-Core Version:    0.7.0.1
 */