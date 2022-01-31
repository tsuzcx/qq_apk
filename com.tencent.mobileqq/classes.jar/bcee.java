import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bcee
{
  final int jdField_a_of_type_Int;
  private bceh jdField_a_of_type_Bceh = new bcef(this);
  final bcei jdField_a_of_type_Bcei;
  final bcej jdField_a_of_type_Bcej;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bcee(bcej parambcej, int paramInt, bcei parambcei)
  {
    this.jdField_a_of_type_Bcej = parambcej;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcei = parambcei;
    int i = 0;
    while (i < 32)
    {
      int k = j;
      if ((1 << i & paramInt) != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(j);
  }
  
  public <T> T a(int paramInt)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      Object localObject4;
      try
      {
        if ((this.jdField_a_of_type_Int & paramInt) == 0) {
          break label250;
        }
        localObject4 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localObject4;
        if (localObject4 != null) {
          break label136;
        }
        if (this.jdField_a_of_type_Bcei == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bcei.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bcfg();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bceg))
        {
          localObject4 = (bceg)localObject3;
          ((bceg)localObject4).jdField_a_of_type_Bceh = this.jdField_a_of_type_Bceh;
          ((bceg)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bcex(this.jdField_a_of_type_Bceh);
          break;
          localObject3 = new bcfx();
          break;
          localObject3 = new bcfh();
          break;
          localObject3 = new bcer(this.jdField_a_of_type_Bceh.a());
          break;
          localObject3 = new bcfo();
          break;
          localObject3 = new bcfs(this.jdField_a_of_type_Bceh.a());
          break;
          localObject3 = new bceu();
          break;
          localObject3 = new bcfc();
          break;
          localObject3 = null;
        }
        localObject3 = localObject4;
      } while (localObject4 != null);
      localObject3 = localObject4;
      switch (paramInt)
      {
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject = paramBundle.next();
      if ((localObject instanceof bceg)) {
        ((bceg)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcee
 * JD-Core Version:    0.7.0.1
 */