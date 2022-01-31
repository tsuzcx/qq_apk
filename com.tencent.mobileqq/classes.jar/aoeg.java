import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.util.Pair;
import java.util.concurrent.ConcurrentHashMap;

public class aoeg
{
  public static final Object a;
  Pair<String, Boolean> jdField_a_of_type_ComTencentUtilPair = new Pair("", Boolean.valueOf(false));
  ConcurrentHashMap<String, ConfessInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ConfessInfo a(String arg1, int paramInt1, int paramInt2)
  {
    Object localObject1 = aoep.a(???, paramInt1, paramInt2);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject1 = (ConfessInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      return localObject1;
    }
  }
  
  public ConfessInfo a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4, long paramLong)
  {
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.reset();
    localConfessInfo.topicId = paramInt2;
    localConfessInfo.confessorSex = paramInt3;
    localConfessInfo.confessorNick = paramString3;
    try
    {
      localConfessInfo.confessorUin = Long.parseLong(paramString2);
      label44:
      localConfessInfo.confessorUinStr = paramString2;
      localConfessInfo.confessTime = paramLong;
      if (paramString4 != null) {
        localConfessInfo.topic = paramString4;
      }
      a(paramString1, paramInt1, localConfessInfo);
      return localConfessInfo;
    }
    catch (Exception paramString3)
    {
      break label44;
    }
  }
  
  public void a(String arg1, int paramInt, ConfessInfo paramConfessInfo)
  {
    String str = aoep.a(???, paramInt, paramConfessInfo.topicId);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ConfessInfo localConfessInfo = (ConfessInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localConfessInfo == null) || (!localConfessInfo.equals(paramConfessInfo))) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramConfessInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoeg
 * JD-Core Version:    0.7.0.1
 */