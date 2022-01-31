import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bcdq
{
  final int jdField_a_of_type_Int;
  private bcdt jdField_a_of_type_Bcdt = new bcdr(this);
  final bcdu jdField_a_of_type_Bcdu;
  final bcdv jdField_a_of_type_Bcdv;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bcdq(bcdv parambcdv, int paramInt, bcdu parambcdu)
  {
    this.jdField_a_of_type_Bcdv = parambcdv;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcdu = parambcdu;
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
        if (this.jdField_a_of_type_Bcdu == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bcdu.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bces();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bcds))
        {
          localObject4 = (bcds)localObject3;
          ((bcds)localObject4).jdField_a_of_type_Bcdt = this.jdField_a_of_type_Bcdt;
          ((bcds)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bcej(this.jdField_a_of_type_Bcdt);
          break;
          localObject3 = new bcfj();
          break;
          localObject3 = new bcet();
          break;
          localObject3 = new bced(this.jdField_a_of_type_Bcdt.a());
          break;
          localObject3 = new bcfa();
          break;
          localObject3 = new bcfe(this.jdField_a_of_type_Bcdt.a());
          break;
          localObject3 = new bceg();
          break;
          localObject3 = new bceo();
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
      if ((localObject instanceof bcds)) {
        ((bcds)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdq
 * JD-Core Version:    0.7.0.1
 */