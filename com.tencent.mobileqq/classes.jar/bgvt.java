import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class bgvt
{
  final int jdField_a_of_type_Int;
  private bgvw jdField_a_of_type_Bgvw = new bgvu(this);
  final bgvx jdField_a_of_type_Bgvx;
  final bgvy jdField_a_of_type_Bgvy;
  final ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bgvt(bgvy parambgvy, int paramInt, bgvx parambgvx)
  {
    this.jdField_a_of_type_Bgvy = parambgvy;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bgvx = parambgvx;
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
        if (this.jdField_a_of_type_Bgvx == null) {
          break label255;
        }
        localObject4 = this.jdField_a_of_type_Bgvx.a(paramInt);
      }
      finally {}
      throw new InvalidParameterException("componentFlag:" + paramInt + " cannot create, please check!");
      Object localObject3 = new bgwv();
      label136:
      label250:
      label255:
      do
      {
        if ((localObject3 instanceof bgvv))
        {
          localObject4 = (bgvv)localObject3;
          ((bgvv)localObject4).mComponentContext = this.jdField_a_of_type_Bgvw;
          ((bgvv)localObject4).didBindContext();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
        for (;;)
        {
          return localObject3;
          localObject3 = new bgwm(this.jdField_a_of_type_Bgvw);
          break;
          localObject3 = new SwiftBrowserUIStyleHandler();
          break;
          localObject3 = new bgww();
          break;
          localObject3 = new bgwg(this.jdField_a_of_type_Bgvw.a());
          break;
          localObject3 = new bgxd();
          break;
          localObject3 = new bgxh(this.jdField_a_of_type_Bgvw.a());
          break;
          localObject3 = new bgwj();
          break;
          localObject3 = new bgwr();
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
      if ((localObject instanceof bgvv)) {
        ((bgvv)localObject).onLifeCycleStateChanged(paramInt, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvt
 * JD-Core Version:    0.7.0.1
 */