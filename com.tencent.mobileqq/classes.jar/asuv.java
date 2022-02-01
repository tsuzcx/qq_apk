import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class asuv
{
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private Map<String, Integer> b = new HashMap();
  private Map<String, List<StructMsg.ButtonInfo>> c = new HashMap();
  
  public int a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.b.containsKey(paramString)))
      {
        int i = ((Integer)this.b.get(paramString)).intValue();
        return i;
      }
      return -1;
    }
  }
  
  public long a(String paramString)
  {
    long l2 = -1L;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l1 = l2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        l1 = l2;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
        }
      }
      return l1;
    }
    finally {}
  }
  
  public List<StructMsg.ButtonInfo> a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.c.containsKey(paramString))
      {
        paramString = (List)this.c.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public void a(String paramString, List<StructMsg.ButtonInfo> paramList, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.c.containsKey(paramString)) {
          this.c.remove(paramString);
        }
        this.c.put(paramString, paramList);
        this.b.put(paramString, Integer.valueOf(paramInt));
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuv
 * JD-Core Version:    0.7.0.1
 */