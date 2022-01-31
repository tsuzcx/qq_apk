import android.os.Bundle;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class beho
{
  final int jdField_a_of_type_Int;
  private behr jdField_a_of_type_Behr = new behp(this);
  final behs jdField_a_of_type_Behs;
  final beht jdField_a_of_type_Beht;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public beho(beht parambeht, int paramInt, behs parambehs)
  {
    this.jdField_a_of_type_Beht = parambeht;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Behs = parambehs;
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
        if (this.jdField_a_of_type_Behs == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Behs.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new beiq();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof behq))
        {
          localObject4 = (behq)localObject3;
          ((behq)localObject4).jdField_a_of_type_Behr = this.jdField_a_of_type_Behr;
          ((behq)localObject4).b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new beih(this.jdField_a_of_type_Behr);
          break;
          localObject3 = new bejh();
          break;
          localObject3 = new beir();
          break;
          localObject3 = new beib(this.jdField_a_of_type_Behr.a());
          break;
          localObject3 = new beiy();
          break;
          localObject3 = new bejc(this.jdField_a_of_type_Behr.a());
          break;
          localObject3 = new beie();
          break;
          localObject3 = new beim();
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
      if ((localObject instanceof behq)) {
        ((behq)localObject).a(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beho
 * JD-Core Version:    0.7.0.1
 */