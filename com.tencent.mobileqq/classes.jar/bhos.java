import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bhos
{
  final int jdField_a_of_type_Int;
  private bhov jdField_a_of_type_Bhov = new bhot(this);
  final bhow jdField_a_of_type_Bhow;
  final bhox jdField_a_of_type_Bhox;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bhos(bhox parambhox, int paramInt, bhow parambhow)
  {
    this.jdField_a_of_type_Bhox = parambhox;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bhow = parambhow;
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
        if (this.jdField_a_of_type_Bhow == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bhow.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bhpu();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bhou))
        {
          localObject4 = (bhou)localObject3;
          ((bhou)localObject4).jdField_a_of_type_Bhov = this.jdField_a_of_type_Bhov;
          ((bhou)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bhpl(this.jdField_a_of_type_Bhov);
          break;
          localObject3 = new bhql();
          break;
          localObject3 = new bhpv();
          break;
          localObject3 = new bhpf(this.jdField_a_of_type_Bhov.a());
          break;
          localObject3 = new bhqc();
          break;
          localObject3 = new bhqg(this.jdField_a_of_type_Bhov.a());
          break;
          localObject3 = new bhpi();
          break;
          localObject3 = new bhpq();
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
      if ((localObject instanceof bhou)) {
        ((bhou)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhos
 * JD-Core Version:    0.7.0.1
 */