import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bipn
{
  final int jdField_a_of_type_Int;
  private bipq jdField_a_of_type_Bipq = new bipo(this);
  final bipr jdField_a_of_type_Bipr;
  final bips jdField_a_of_type_Bips;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bipn(bips parambips, int paramInt, bipr parambipr)
  {
    this.jdField_a_of_type_Bips = parambips;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bipr = parambipr;
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
        if (this.jdField_a_of_type_Bipr == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bipr.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new biqp();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bipp))
        {
          localObject4 = (bipp)localObject3;
          ((bipp)localObject4).jdField_a_of_type_Bipq = this.jdField_a_of_type_Bipq;
          ((bipp)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new biqg(this.jdField_a_of_type_Bipq);
          break;
          localObject3 = new birg();
          break;
          localObject3 = new biqq();
          break;
          localObject3 = new biqa(this.jdField_a_of_type_Bipq.a());
          break;
          localObject3 = new biqx();
          break;
          localObject3 = new birb(this.jdField_a_of_type_Bipq.a());
          break;
          localObject3 = new biqd();
          break;
          localObject3 = new biql();
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
      if ((localObject instanceof bipp)) {
        ((bipp)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipn
 * JD-Core Version:    0.7.0.1
 */