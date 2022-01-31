import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class bmad
  extends blyx
{
  private int jdField_a_of_type_Int;
  private blyz jdField_a_of_type_Blyz;
  private blzp<blza, bmae> jdField_a_of_type_Blzp = new blzp();
  private final WeakReference<blzb> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<blyz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bmad(@NonNull blzb paramblzb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramblzb);
    this.jdField_a_of_type_Blyz = blyz.b;
  }
  
  private static blyy a(blyz paramblyz)
  {
    switch (paramblyz.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramblyz);
    case 1: 
      throw new IllegalArgumentException();
    case 2: 
      return blyy.f;
    case 3: 
      return blyy.e;
    case 4: 
      return blyy.d;
    }
    throw new IllegalArgumentException();
  }
  
  static blyz a(blyy paramblyy)
  {
    switch (paramblyy.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + paramblyy);
    case 0: 
    case 4: 
      return blyz.c;
    case 1: 
    case 3: 
      return blyz.d;
    case 2: 
      return blyz.e;
    }
    return blyz.jdField_a_of_type_Blyz;
  }
  
  static blyz a(@NonNull blyz paramblyz1, @Nullable blyz paramblyz2)
  {
    if ((paramblyz2 != null) && (paramblyz2.a(paramblyz1) < 0)) {
      return paramblyz2;
    }
    return paramblyz1;
  }
  
  private blyz a(blza paramblza)
  {
    paramblza = this.jdField_a_of_type_Blzp.a(paramblza);
    if (paramblza != null)
    {
      paramblza = ((bmae)paramblza.getValue()).jdField_a_of_type_Blyz;
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label74;
      }
    }
    label74:
    for (blyz localblyz = (blyz)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);; localblyz = null)
    {
      return a(a(this.jdField_a_of_type_Blyz, paramblza), localblyz);
      paramblza = null;
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
  }
  
  private void a(blyz paramblyz)
  {
    if (this.jdField_a_of_type_Blyz == paramblyz) {
      return;
    }
    this.jdField_a_of_type_Blyz = paramblyz;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0))
    {
      this.b = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(blzb paramblzb)
  {
    blzu localblzu = this.jdField_a_of_type_Blzp.a();
    while ((localblzu.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localblzu.next();
      bmae localbmae = (bmae)localEntry.getValue();
      while ((localbmae.jdField_a_of_type_Blyz.a(this.jdField_a_of_type_Blyz) < 0) && (!this.b) && (this.jdField_a_of_type_Blzp.a(localEntry.getKey())))
      {
        b(localbmae.jdField_a_of_type_Blyz);
        localbmae.a(paramblzb, b(localbmae.jdField_a_of_type_Blyz));
        a();
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Blzp.a() == 0) {
      return true;
    }
    blyz localblyz1 = ((bmae)this.jdField_a_of_type_Blzp.a().getValue()).jdField_a_of_type_Blyz;
    blyz localblyz2 = ((bmae)this.jdField_a_of_type_Blzp.b().getValue()).jdField_a_of_type_Blyz;
    if ((localblyz1 == localblyz2) && (this.jdField_a_of_type_Blyz == localblyz2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static blyy b(blyz paramblyz)
  {
    switch (paramblyz.jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramblyz);
    case 0: 
    case 1: 
      return blyy.jdField_a_of_type_Blyy;
    case 2: 
      return blyy.b;
    case 3: 
      return blyy.c;
    }
    throw new IllegalArgumentException();
  }
  
  private void b()
  {
    blzb localblzb = (blzb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localblzb == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!a())
    {
      this.b = false;
      if (this.jdField_a_of_type_Blyz.a(((bmae)this.jdField_a_of_type_Blzp.a().getValue()).jdField_a_of_type_Blyz) < 0) {
        b(localblzb);
      }
      Map.Entry localEntry = this.jdField_a_of_type_Blzp.b();
      if ((!this.b) && (localEntry != null) && (this.jdField_a_of_type_Blyz.a(((bmae)localEntry.getValue()).jdField_a_of_type_Blyz) > 0)) {
        a(localblzb);
      }
    }
    this.b = false;
  }
  
  private void b(blyz paramblyz)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramblyz);
  }
  
  private void b(blzb paramblzb)
  {
    Iterator localIterator = this.jdField_a_of_type_Blzp.a();
    while ((localIterator.hasNext()) && (!this.b))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bmae localbmae = (bmae)localEntry.getValue();
      while ((localbmae.jdField_a_of_type_Blyz.a(this.jdField_a_of_type_Blyz) > 0) && (!this.b) && (this.jdField_a_of_type_Blzp.a(localEntry.getKey())))
      {
        blyy localblyy = a(localbmae.jdField_a_of_type_Blyz);
        b(a(localblyy));
        localbmae.a(paramblzb, localblyy);
        a();
      }
    }
  }
  
  @NonNull
  public blyz a()
  {
    return this.jdField_a_of_type_Blyz;
  }
  
  public void a(@NonNull blyy paramblyy)
  {
    a(a(paramblyy));
  }
  
  public void a(@NonNull blza paramblza)
  {
    blyz localblyz;
    bmae localbmae;
    if (this.jdField_a_of_type_Blyz == blyz.jdField_a_of_type_Blyz)
    {
      localblyz = blyz.jdField_a_of_type_Blyz;
      localbmae = new bmae(paramblza, localblyz);
      if ((bmae)this.jdField_a_of_type_Blzp.a(paramblza, localbmae) == null) {
        break label49;
      }
    }
    label49:
    blzb localblzb;
    do
    {
      return;
      localblyz = blyz.b;
      break;
      localblzb = (blzb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localblzb == null);
    if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      localblyz = a(paramblza);
      this.jdField_a_of_type_Int += 1;
      while ((localbmae.jdField_a_of_type_Blyz.a(localblyz) < 0) && (this.jdField_a_of_type_Blzp.a(paramblza)))
      {
        b(localbmae.jdField_a_of_type_Blyz);
        localbmae.a(localblzb, b(localbmae.jdField_a_of_type_Blyz));
        a();
        localblyz = a(paramblza);
      }
    }
    if (i == 0) {
      b();
    }
    this.jdField_a_of_type_Int -= 1;
  }
  
  public void b(@NonNull blza paramblza)
  {
    this.jdField_a_of_type_Blzp.a(paramblza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmad
 * JD-Core Version:    0.7.0.1
 */