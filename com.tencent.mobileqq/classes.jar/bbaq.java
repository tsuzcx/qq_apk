import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bbaq
{
  final int jdField_a_of_type_Int;
  private bbat jdField_a_of_type_Bbat = new bbar(this);
  final bbau jdField_a_of_type_Bbau;
  final bbav jdField_a_of_type_Bbav;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bbaq(bbav parambbav, int paramInt, bbau parambbau)
  {
    this.jdField_a_of_type_Bbav = parambbav;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bbau = parambbau;
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
        if (this.jdField_a_of_type_Bbau == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bbau.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bbbs();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bbas))
        {
          localObject4 = (bbas)localObject3;
          ((bbas)localObject4).jdField_a_of_type_Bbat = this.jdField_a_of_type_Bbat;
          ((bbas)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bbbj(this.jdField_a_of_type_Bbat);
          break;
          localObject3 = new bbcj();
          break;
          localObject3 = new bbbt();
          break;
          localObject3 = new bbbd(this.jdField_a_of_type_Bbat.a());
          break;
          localObject3 = new bbca();
          break;
          localObject3 = new bbce(this.jdField_a_of_type_Bbat.a());
          break;
          localObject3 = new bbbg();
          break;
          localObject3 = new bbbo();
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
      if ((localObject instanceof bbas)) {
        ((bbas)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbaq
 * JD-Core Version:    0.7.0.1
 */