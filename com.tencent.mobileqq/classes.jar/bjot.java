import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class bjot
  extends bjno
{
  private int jdField_a_of_type_Int;
  private bjnq jdField_a_of_type_Bjnq;
  private bjog<bjnr, bjou> jdField_a_of_type_Bjog = new bjog();
  private final WeakReference<bjns> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<bjnq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bjot(@NonNull bjns parambjns)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjns);
    this.jdField_a_of_type_Bjnq = bjnq.b;
  }
  
  private static bjnp a(bjnq parambjnq)
  {
    switch (parambjnq.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambjnq);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return bjnp.f;
    case 3: 
      return bjnp.e;
    case 4: 
      return bjnp.d;
    }
    throw new IllegalArgumentException();
  }
  
  static bjnq a(bjnp parambjnp)
  {
    switch (parambjnp.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + parambjnp);
    case 0: 
    case 4: 
      return bjnq.c;
    case 1: 
    case 3: 
      return bjnq.d;
    case 2: 
      return bjnq.e;
    }
    return bjnq.jdField_a_of_type_Bjnq;
  }
  
  static bjnq a(@NonNull bjnq parambjnq1, @Nullable bjnq parambjnq2)
  {
    if ((parambjnq2 != null) && (parambjnq2.a(parambjnq1) < 0)) {
      return parambjnq2;
    }
    return parambjnq1;
  }
  
  private bjnq a(bjnr parambjnr)
  {
    parambjnr = this.jdField_a_of_type_Bjog.a(parambjnr);
    if (parambjnr != null)
    {
      parambjnr = ((bjou)parambjnr.getValue()).jdField_a_of_type_Bjnq;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (bjnq localbjnq = (bjnq)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);; localbjnq = null)
    {
      return a(a(this.jdField_a_of_type_Bjnq, parambjnr), localbjnq);
      parambjnr = null;
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void a(bjnq parambjnq)
  {
    if (this.jdField_a_of_type_Bjnq == parambjnq) {
      return;
    }
    this.jdField_a_of_type_Bjnq = parambjnq;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0))
    {
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(bjns parambjns)
  {
    bjol localbjol = this.jdField_a_of_type_Bjog.a();
    while ((localbjol.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localbjol.next();
      bjou localbjou = (bjou)localEntry.getValue();
      while ((localbjou.jdField_a_of_type_Bjnq.a(this.jdField_a_of_type_Bjnq) < 0) && (!this.b) && (this.jdField_a_of_type_Bjog.a(localEntry.getKey())))
      {
        b(localbjou.jdField_a_of_type_Bjnq);
        localbjou.a(parambjns, b(localbjou.jdField_a_of_type_Bjnq));
        a();
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bjog.a() == 0) {
      return true;
    }
    bjnq localbjnq1 = ((bjou)this.jdField_a_of_type_Bjog.a().getValue()).jdField_a_of_type_Bjnq;
    bjnq localbjnq2 = ((bjou)this.jdField_a_of_type_Bjog.b().getValue()).jdField_a_of_type_Bjnq;
    if ((localbjnq1 == localbjnq2) && (this.jdField_a_of_type_Bjnq == localbjnq2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static bjnp b(bjnq parambjnq)
  {
    switch (parambjnq.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambjnq);
    case 0: 
    case 1: 
      return bjnp.jdField_a_of_type_Bjnp;
    case 2: 
      return bjnp.b;
    case 3: 
      return bjnp.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b()
  {
    bjns localbjns = (bjns)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbjns == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!a())
    {
      this.b = false;
      if (this.jdField_a_of_type_Bjnq.a(((bjou)this.jdField_a_of_type_Bjog.a().getValue()).jdField_a_of_type_Bjnq) < 0) {
        b(localbjns);
      }
      Map.Entry localEntry = this.jdField_a_of_type_Bjog.b();
      if ((!this.b) && (localEntry != null) && (this.jdField_a_of_type_Bjnq.a(((bjou)localEntry.getValue()).jdField_a_of_type_Bjnq) > 0)) {
        a(localbjns);
      }
    }
    this.b = false;
  }
  
  private void b(bjnq parambjnq)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambjnq);
  }
  
  private void b(bjns parambjns)
  {
    Iterator localIterator = this.jdField_a_of_type_Bjog.a();
    while ((localIterator.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bjou localbjou = (bjou)localEntry.getValue();
      while ((localbjou.jdField_a_of_type_Bjnq.a(this.jdField_a_of_type_Bjnq) > 0) && (!this.b) && (this.jdField_a_of_type_Bjog.a(localEntry.getKey())))
      {
        bjnp localbjnp = a(localbjou.jdField_a_of_type_Bjnq);
        b(a(localbjnp));
        localbjou.a(parambjns, localbjnp);
        a();
      }
    }
  }
  
  @NonNull
  public bjnq a()
  {
    return this.jdField_a_of_type_Bjnq;
  }
  
  public void a(@NonNull bjnp parambjnp)
  {
    a(a(parambjnp));
  }
  
  public void a(@NonNull bjnr parambjnr)
  {
    bjnq localbjnq;
    bjou localbjou;
    if (this.jdField_a_of_type_Bjnq == bjnq.jdField_a_of_type_Bjnq)
    {
      localbjnq = bjnq.jdField_a_of_type_Bjnq;
      localbjou = new bjou(parambjnr, localbjnq);
      if ((bjou)this.jdField_a_of_type_Bjog.a(parambjnr, localbjou) == null) {
        break label49;
      }
    }
    label49:
    bjns localbjns;
    do
    {
      return;
      localbjnq = bjnq.b;
      break;
      localbjns = (bjns)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbjns == null);
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      localbjnq = a(parambjnr);
      this.jdField_a_of_type_Int += 1;
      while ((localbjou.jdField_a_of_type_Bjnq.a(localbjnq) < 0) && (this.jdField_a_of_type_Bjog.a(parambjnr)))
      {
        b(localbjou.jdField_a_of_type_Bjnq);
        localbjou.a(localbjns, b(localbjou.jdField_a_of_type_Bjnq));
        a();
        localbjnq = a(parambjnr);
      }
    }
    if (i == 0) {
      b();
    }
    this.jdField_a_of_type_Int -= 1;
  }
  
  public void b(@NonNull bjnr parambjnr)
  {
    this.jdField_a_of_type_Bjog.a(parambjnr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjot
 * JD-Core Version:    0.7.0.1
 */