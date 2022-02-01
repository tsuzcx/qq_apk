import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bigl
{
  final int jdField_a_of_type_Int;
  private bigo jdField_a_of_type_Bigo = new bigm(this);
  final bigp jdField_a_of_type_Bigp;
  final bigq jdField_a_of_type_Bigq;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bigl(bigq parambigq, int paramInt, bigp parambigp)
  {
    this.jdField_a_of_type_Bigq = parambigq;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bigp = parambigp;
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
        if (this.jdField_a_of_type_Bigp == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bigp.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bihn();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bign))
        {
          localObject4 = (bign)localObject3;
          ((bign)localObject4).mComponentContext = this.jdField_a_of_type_Bigo;
          ((bign)localObject4).didBindContext();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bihe(this.jdField_a_of_type_Bigo);
          break;
          localObject3 = new SwiftBrowserUIStyleHandler();
          break;
          localObject3 = new biho();
          break;
          localObject3 = new bigy(this.jdField_a_of_type_Bigo.a());
          break;
          localObject3 = new bihv();
          break;
          localObject3 = new bihz(this.jdField_a_of_type_Bigo.a());
          break;
          localObject3 = new bihb();
          break;
          localObject3 = new bihj();
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
      if ((localObject instanceof bign)) {
        ((bign)localObject).onLifeCycleStateChanged(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigl
 * JD-Core Version:    0.7.0.1
 */