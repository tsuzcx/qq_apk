import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class bjoc
  extends bjmx
{
  private int jdField_a_of_type_Int;
  private bjmz jdField_a_of_type_Bjmz;
  private bjnp<bjna, bjod> jdField_a_of_type_Bjnp = new bjnp();
  private final WeakReference<bjnb> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<bjmz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bjoc(@NonNull bjnb parambjnb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjnb);
    this.jdField_a_of_type_Bjmz = bjmz.b;
  }
  
  private static bjmy a(bjmz parambjmz)
  {
    switch (parambjmz.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambjmz);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return bjmy.f;
    case 3: 
      return bjmy.e;
    case 4: 
      return bjmy.d;
    }
    throw new IllegalArgumentException();
  }
  
  static bjmz a(bjmy parambjmy)
  {
    switch (parambjmy.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + parambjmy);
    case 0: 
    case 4: 
      return bjmz.c;
    case 1: 
    case 3: 
      return bjmz.d;
    case 2: 
      return bjmz.e;
    }
    return bjmz.jdField_a_of_type_Bjmz;
  }
  
  static bjmz a(@NonNull bjmz parambjmz1, @Nullable bjmz parambjmz2)
  {
    if ((parambjmz2 != null) && (parambjmz2.a(parambjmz1) < 0)) {
      return parambjmz2;
    }
    return parambjmz1;
  }
  
  private bjmz a(bjna parambjna)
  {
    parambjna = this.jdField_a_of_type_Bjnp.a(parambjna);
    if (parambjna != null)
    {
      parambjna = ((bjod)parambjna.getValue()).jdField_a_of_type_Bjmz;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (bjmz localbjmz = (bjmz)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);; localbjmz = null)
    {
      return a(a(this.jdField_a_of_type_Bjmz, parambjna), localbjmz);
      parambjna = null;
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void a(bjmz parambjmz)
  {
    if (this.jdField_a_of_type_Bjmz == parambjmz) {
      return;
    }
    this.jdField_a_of_type_Bjmz = parambjmz;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0))
    {
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(bjnb parambjnb)
  {
    bjnu localbjnu = this.jdField_a_of_type_Bjnp.a();
    while ((localbjnu.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localbjnu.next();
      bjod localbjod = (bjod)localEntry.getValue();
      while ((localbjod.jdField_a_of_type_Bjmz.a(this.jdField_a_of_type_Bjmz) < 0) && (!this.b) && (this.jdField_a_of_type_Bjnp.a(localEntry.getKey())))
      {
        b(localbjod.jdField_a_of_type_Bjmz);
        localbjod.a(parambjnb, b(localbjod.jdField_a_of_type_Bjmz));
        a();
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bjnp.a() == 0) {
      return true;
    }
    bjmz localbjmz1 = ((bjod)this.jdField_a_of_type_Bjnp.a().getValue()).jdField_a_of_type_Bjmz;
    bjmz localbjmz2 = ((bjod)this.jdField_a_of_type_Bjnp.b().getValue()).jdField_a_of_type_Bjmz;
    if ((localbjmz1 == localbjmz2) && (this.jdField_a_of_type_Bjmz == localbjmz2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static bjmy b(bjmz parambjmz)
  {
    switch (parambjmz.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambjmz);
    case 0: 
    case 1: 
      return bjmy.jdField_a_of_type_Bjmy;
    case 2: 
      return bjmy.b;
    case 3: 
      return bjmy.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b()
  {
    bjnb localbjnb = (bjnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbjnb == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!a())
    {
      this.b = false;
      if (this.jdField_a_of_type_Bjmz.a(((bjod)this.jdField_a_of_type_Bjnp.a().getValue()).jdField_a_of_type_Bjmz) < 0) {
        b(localbjnb);
      }
      Map.Entry localEntry = this.jdField_a_of_type_Bjnp.b();
      if ((!this.b) && (localEntry != null) && (this.jdField_a_of_type_Bjmz.a(((bjod)localEntry.getValue()).jdField_a_of_type_Bjmz) > 0)) {
        a(localbjnb);
      }
    }
    this.b = false;
  }
  
  private void b(bjmz parambjmz)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambjmz);
  }
  
  private void b(bjnb parambjnb)
  {
    Iterator localIterator = this.jdField_a_of_type_Bjnp.a();
    while ((localIterator.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bjod localbjod = (bjod)localEntry.getValue();
      while ((localbjod.jdField_a_of_type_Bjmz.a(this.jdField_a_of_type_Bjmz) > 0) && (!this.b) && (this.jdField_a_of_type_Bjnp.a(localEntry.getKey())))
      {
        bjmy localbjmy = a(localbjod.jdField_a_of_type_Bjmz);
        b(a(localbjmy));
        localbjod.a(parambjnb, localbjmy);
        a();
      }
    }
  }
  
  @NonNull
  public bjmz a()
  {
    return this.jdField_a_of_type_Bjmz;
  }
  
  public void a(@NonNull bjmy parambjmy)
  {
    a(a(parambjmy));
  }
  
  public void a(@NonNull bjna parambjna)
  {
    bjmz localbjmz;
    bjod localbjod;
    if (this.jdField_a_of_type_Bjmz == bjmz.jdField_a_of_type_Bjmz)
    {
      localbjmz = bjmz.jdField_a_of_type_Bjmz;
      localbjod = new bjod(parambjna, localbjmz);
      if ((bjod)this.jdField_a_of_type_Bjnp.a(parambjna, localbjod) == null) {
        break label49;
      }
    }
    label49:
    bjnb localbjnb;
    do
    {
      return;
      localbjmz = bjmz.b;
      break;
      localbjnb = (bjnb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbjnb == null);
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      localbjmz = a(parambjna);
      this.jdField_a_of_type_Int += 1;
      while ((localbjod.jdField_a_of_type_Bjmz.a(localbjmz) < 0) && (this.jdField_a_of_type_Bjnp.a(parambjna)))
      {
        b(localbjod.jdField_a_of_type_Bjmz);
        localbjod.a(localbjnb, b(localbjod.jdField_a_of_type_Bjmz));
        a();
        localbjmz = a(parambjna);
      }
    }
    if (i == 0) {
      b();
    }
    this.jdField_a_of_type_Int -= 1;
  }
  
  public void b(@NonNull bjna parambjna)
  {
    this.jdField_a_of_type_Bjnp.a(parambjna);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoc
 * JD-Core Version:    0.7.0.1
 */