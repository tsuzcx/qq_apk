import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class bhwh
  extends bhvc
{
  private int jdField_a_of_type_Int;
  private bhve jdField_a_of_type_Bhve;
  private bhvu<bhvf, bhwi> jdField_a_of_type_Bhvu = new bhvu();
  private final WeakReference<bhvg> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<bhve> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bhwh(@NonNull bhvg parambhvg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhvg);
    this.jdField_a_of_type_Bhve = bhve.b;
  }
  
  private static bhvd a(bhve parambhve)
  {
    switch (parambhve.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambhve);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return bhvd.f;
    case 3: 
      return bhvd.e;
    case 4: 
      return bhvd.d;
    }
    throw new IllegalArgumentException();
  }
  
  static bhve a(bhvd parambhvd)
  {
    switch (parambhvd.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + parambhvd);
    case 0: 
    case 4: 
      return bhve.c;
    case 1: 
    case 3: 
      return bhve.d;
    case 2: 
      return bhve.e;
    }
    return bhve.jdField_a_of_type_Bhve;
  }
  
  static bhve a(@NonNull bhve parambhve1, @Nullable bhve parambhve2)
  {
    if ((parambhve2 != null) && (parambhve2.a(parambhve1) < 0)) {
      return parambhve2;
    }
    return parambhve1;
  }
  
  private bhve a(bhvf parambhvf)
  {
    parambhvf = this.jdField_a_of_type_Bhvu.a(parambhvf);
    if (parambhvf != null)
    {
      parambhvf = ((bhwi)parambhvf.getValue()).jdField_a_of_type_Bhve;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (bhve localbhve = (bhve)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);; localbhve = null)
    {
      return a(a(this.jdField_a_of_type_Bhve, parambhvf), localbhve);
      parambhvf = null;
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void a(bhve parambhve)
  {
    if (this.jdField_a_of_type_Bhve == parambhve) {
      return;
    }
    this.jdField_a_of_type_Bhve = parambhve;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0))
    {
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(bhvg parambhvg)
  {
    bhvz localbhvz = this.jdField_a_of_type_Bhvu.a();
    while ((localbhvz.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localbhvz.next();
      bhwi localbhwi = (bhwi)localEntry.getValue();
      while ((localbhwi.jdField_a_of_type_Bhve.a(this.jdField_a_of_type_Bhve) < 0) && (!this.b) && (this.jdField_a_of_type_Bhvu.a(localEntry.getKey())))
      {
        b(localbhwi.jdField_a_of_type_Bhve);
        localbhwi.a(parambhvg, b(localbhwi.jdField_a_of_type_Bhve));
        a();
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bhvu.a() == 0) {
      return true;
    }
    bhve localbhve1 = ((bhwi)this.jdField_a_of_type_Bhvu.a().getValue()).jdField_a_of_type_Bhve;
    bhve localbhve2 = ((bhwi)this.jdField_a_of_type_Bhvu.b().getValue()).jdField_a_of_type_Bhve;
    if ((localbhve1 == localbhve2) && (this.jdField_a_of_type_Bhve == localbhve2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static bhvd b(bhve parambhve)
  {
    switch (parambhve.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + parambhve);
    case 0: 
    case 1: 
      return bhvd.jdField_a_of_type_Bhvd;
    case 2: 
      return bhvd.b;
    case 3: 
      return bhvd.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b()
  {
    bhvg localbhvg = (bhvg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbhvg == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!a())
    {
      this.b = false;
      if (this.jdField_a_of_type_Bhve.a(((bhwi)this.jdField_a_of_type_Bhvu.a().getValue()).jdField_a_of_type_Bhve) < 0) {
        b(localbhvg);
      }
      Map.Entry localEntry = this.jdField_a_of_type_Bhvu.b();
      if ((!this.b) && (localEntry != null) && (this.jdField_a_of_type_Bhve.a(((bhwi)localEntry.getValue()).jdField_a_of_type_Bhve) > 0)) {
        a(localbhvg);
      }
    }
    this.b = false;
  }
  
  private void b(bhve parambhve)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhve);
  }
  
  private void b(bhvg parambhvg)
  {
    Iterator localIterator = this.jdField_a_of_type_Bhvu.a();
    while ((localIterator.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bhwi localbhwi = (bhwi)localEntry.getValue();
      while ((localbhwi.jdField_a_of_type_Bhve.a(this.jdField_a_of_type_Bhve) > 0) && (!this.b) && (this.jdField_a_of_type_Bhvu.a(localEntry.getKey())))
      {
        bhvd localbhvd = a(localbhwi.jdField_a_of_type_Bhve);
        b(a(localbhvd));
        localbhwi.a(parambhvg, localbhvd);
        a();
      }
    }
  }
  
  @NonNull
  public bhve a()
  {
    return this.jdField_a_of_type_Bhve;
  }
  
  public void a(@NonNull bhvd parambhvd)
  {
    a(a(parambhvd));
  }
  
  public void a(@NonNull bhvf parambhvf)
  {
    bhve localbhve;
    bhwi localbhwi;
    if (this.jdField_a_of_type_Bhve == bhve.jdField_a_of_type_Bhve)
    {
      localbhve = bhve.jdField_a_of_type_Bhve;
      localbhwi = new bhwi(parambhvf, localbhve);
      if ((bhwi)this.jdField_a_of_type_Bhvu.a(parambhvf, localbhwi) == null) {
        break label49;
      }
    }
    label49:
    bhvg localbhvg;
    do
    {
      return;
      localbhve = bhve.b;
      break;
      localbhvg = (bhvg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbhvg == null);
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      localbhve = a(parambhvf);
      this.jdField_a_of_type_Int += 1;
      while ((localbhwi.jdField_a_of_type_Bhve.a(localbhve) < 0) && (this.jdField_a_of_type_Bhvu.a(parambhvf)))
      {
        b(localbhwi.jdField_a_of_type_Bhve);
        localbhwi.a(localbhvg, b(localbhwi.jdField_a_of_type_Bhve));
        a();
        localbhve = a(parambhvf);
      }
    }
    if (i == 0) {
      b();
    }
    this.jdField_a_of_type_Int -= 1;
  }
  
  public void b(@NonNull bhvf parambhvf)
  {
    this.jdField_a_of_type_Bhvu.a(parambhvf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwh
 * JD-Core Version:    0.7.0.1
 */