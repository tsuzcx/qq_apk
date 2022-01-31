import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class blbm
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bkle jdField_a_of_type_Bkle;
  private Map<Integer, blbl> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public blbm(Activity paramActivity, View paramView, bkle parambkle)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bkle = parambkle;
    this.jdField_a_of_type_JavaUtilSet = a();
  }
  
  private int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >> 16 == localInteger.intValue() >> 16) {
        return localInteger.intValue();
      }
    }
    return 65536;
  }
  
  private Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    int j = bkwm.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
      }
    }
    if ((bkwm.c.a(i)) || (bkwm.t.a(i)) || (bkwm.n.a(i)) || (bkwm.e.a(i)) || (bkwm.d(i)))
    {
      localHashSet.add(Integer.valueOf(131072));
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(458752));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      localHashSet.add(Integer.valueOf(655360));
      localHashSet.add(Integer.valueOf(786432));
    }
    for (;;)
    {
      if (bkwm.a(this.jdField_a_of_type_Bkle) == 204)
      {
        localHashSet.remove(Integer.valueOf(786432));
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (bkwm.a(this.jdField_a_of_type_Bkle) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      return localHashSet;
      if (bkwm.e.a(i))
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
        localHashSet.add(Integer.valueOf(786432));
      }
      else if ((bkwm.A.a(i)) || (bkwm.z.a(i)))
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
      }
      else if (bkwm.w.a(i))
      {
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(786432));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(393216));
      }
      else
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
        localHashSet.add(Integer.valueOf(786432));
      }
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
      return;
      localObject = new bkwx(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkqr(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkqa(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkrq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkpi(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blbc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkuc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkul(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blcc(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362193), this);
      continue;
      localObject = new bksk(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bkxe(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bkle;
  }
  
  private void b(int paramInt, Object... paramVarArgs) {}
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      a(((Integer)localIterator.next()).intValue());
    }
  }
  
  private void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a();
    }
  }
  
  public bkvr a(int paramInt)
  {
    paramInt = a(paramInt);
    blbl localblbl = (blbl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localblbl instanceof bkqr)) {
      return ((bkqr)localblbl).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    blbl localblbl = (blbl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localblbl != null) {
      return localblbl.a(paramInt, paramVarArgs);
    }
    return b(paramInt, paramVarArgs);
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        g();
        h();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    blbl localblbl = (blbl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localblbl != null)
    {
      localblbl.a(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (blbl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((blbl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbm
 * JD-Core Version:    0.7.0.1
 */