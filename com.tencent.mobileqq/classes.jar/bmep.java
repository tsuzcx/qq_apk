import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class bmep
  extends bmdj
{
  private int jdField_a_of_type_Int;
  private bmdl jdField_a_of_type_Bmdl;
  private bmeb<bmdm, bmeq> jdField_a_of_type_Bmeb = new bmeb();
  private final WeakReference<bmdn> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<bmdl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bmep(@NonNull bmdn parambmdn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmdn);
    this.jdField_a_of_type_Bmdl = bmdl.b;
  }
  
  private static bmdk a(bmdl parambmdl)
  {
    switch (parambmdl.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambmdl);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return bmdk.f;
    case 3: 
      return bmdk.e;
    case 4: 
      return bmdk.d;
    }
    throw new IllegalArgumentException();
  }
  
  static bmdl a(bmdk parambmdk)
  {
    switch (parambmdk.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + parambmdk);
    case 0: 
    case 4: 
      return bmdl.c;
    case 1: 
    case 3: 
      return bmdl.d;
    case 2: 
      return bmdl.e;
    }
    return bmdl.jdField_a_of_type_Bmdl;
  }
  
  static bmdl a(@NonNull bmdl parambmdl1, @Nullable bmdl parambmdl2)
  {
    if ((parambmdl2 != null) && (parambmdl2.a(parambmdl1) < 0)) {
      return parambmdl2;
    }
    return parambmdl1;
  }
  
  private bmdl a(bmdm parambmdm)
  {
    parambmdm = this.jdField_a_of_type_Bmeb.a(parambmdm);
    if (parambmdm != null)
    {
      parambmdm = ((bmeq)parambmdm.getValue()).jdField_a_of_type_Bmdl;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (bmdl localbmdl = (bmdl)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);; localbmdl = null)
    {
      return a(a(this.jdField_a_of_type_Bmdl, parambmdm), localbmdl);
      parambmdm = null;
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void a(bmdl parambmdl)
  {
    if (this.jdField_a_of_type_Bmdl == parambmdl) {
      return;
    }
    this.jdField_a_of_type_Bmdl = parambmdl;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0))
    {
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(bmdn parambmdn)
  {
    bmeg localbmeg = this.jdField_a_of_type_Bmeb.a();
    while ((localbmeg.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localbmeg.next();
      bmeq localbmeq = (bmeq)localEntry.getValue();
      while ((localbmeq.jdField_a_of_type_Bmdl.a(this.jdField_a_of_type_Bmdl) < 0) && (!this.b) && (this.jdField_a_of_type_Bmeb.a(localEntry.getKey())))
      {
        b(localbmeq.jdField_a_of_type_Bmdl);
        localbmeq.a(parambmdn, b(localbmeq.jdField_a_of_type_Bmdl));
        a();
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bmeb.a() == 0) {
      return true;
    }
    bmdl localbmdl1 = ((bmeq)this.jdField_a_of_type_Bmeb.a().getValue()).jdField_a_of_type_Bmdl;
    bmdl localbmdl2 = ((bmeq)this.jdField_a_of_type_Bmeb.b().getValue()).jdField_a_of_type_Bmdl;
    if ((localbmdl1 == localbmdl2) && (this.jdField_a_of_type_Bmdl == localbmdl2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static bmdk b(bmdl parambmdl)
  {
    switch (parambmdl.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambmdl);
    case 0: 
    case 1: 
      return bmdk.jdField_a_of_type_Bmdk;
    case 2: 
      return bmdk.b;
    case 3: 
      return bmdk.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b()
  {
    bmdn localbmdn = (bmdn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbmdn == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!a())
    {
      this.b = false;
      if (this.jdField_a_of_type_Bmdl.a(((bmeq)this.jdField_a_of_type_Bmeb.a().getValue()).jdField_a_of_type_Bmdl) < 0) {
        b(localbmdn);
      }
      Map.Entry localEntry = this.jdField_a_of_type_Bmeb.b();
      if ((!this.b) && (localEntry != null) && (this.jdField_a_of_type_Bmdl.a(((bmeq)localEntry.getValue()).jdField_a_of_type_Bmdl) > 0)) {
        a(localbmdn);
      }
    }
    this.b = false;
  }
  
  private void b(bmdl parambmdl)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambmdl);
  }
  
  private void b(bmdn parambmdn)
  {
    Iterator localIterator = this.jdField_a_of_type_Bmeb.a();
    while ((localIterator.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bmeq localbmeq = (bmeq)localEntry.getValue();
      while ((localbmeq.jdField_a_of_type_Bmdl.a(this.jdField_a_of_type_Bmdl) > 0) && (!this.b) && (this.jdField_a_of_type_Bmeb.a(localEntry.getKey())))
      {
        bmdk localbmdk = a(localbmeq.jdField_a_of_type_Bmdl);
        b(a(localbmdk));
        localbmeq.a(parambmdn, localbmdk);
        a();
      }
    }
  }
  
  @NonNull
  public bmdl a()
  {
    return this.jdField_a_of_type_Bmdl;
  }
  
  public void a(@NonNull bmdk parambmdk)
  {
    a(a(parambmdk));
  }
  
  public void a(@NonNull bmdm parambmdm)
  {
    bmdl localbmdl;
    bmeq localbmeq;
    if (this.jdField_a_of_type_Bmdl == bmdl.jdField_a_of_type_Bmdl)
    {
      localbmdl = bmdl.jdField_a_of_type_Bmdl;
      localbmeq = new bmeq(parambmdm, localbmdl);
      if ((bmeq)this.jdField_a_of_type_Bmeb.a(parambmdm, localbmeq) == null) {
        break label49;
      }
    }
    label49:
    bmdn localbmdn;
    do
    {
      return;
      localbmdl = bmdl.b;
      break;
      localbmdn = (bmdn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbmdn == null);
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      localbmdl = a(parambmdm);
      this.jdField_a_of_type_Int += 1;
      while ((localbmeq.jdField_a_of_type_Bmdl.a(localbmdl) < 0) && (this.jdField_a_of_type_Bmeb.a(parambmdm)))
      {
        b(localbmeq.jdField_a_of_type_Bmdl);
        localbmeq.a(localbmdn, b(localbmeq.jdField_a_of_type_Bmdl));
        a();
        localbmdl = a(parambmdm);
      }
    }
    if (i == 0) {
      b();
    }
    this.jdField_a_of_type_Int -= 1;
  }
  
  public void b(@NonNull bmdm parambmdm)
  {
    this.jdField_a_of_type_Bmeb.a(parambmdm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmep
 * JD-Core Version:    0.7.0.1
 */