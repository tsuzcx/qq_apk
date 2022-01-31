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
public class biws
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bijd jdField_a_of_type_Bijd;
  private Map<Integer, biwr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public biws(Activity paramActivity, View paramView, bijd parambijd)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bijd = parambijd;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = a();
    b();
    c();
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
    int j = birt.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a());
      }
    }
    if ((birt.c.a(i)) || (birt.t.a(i)) || (birt.n.a(i)) || (birt.e.a(i)) || (birt.d(i)))
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
      if (birt.a(this.jdField_a_of_type_Bijd) == 204)
      {
        localHashSet.remove(Integer.valueOf(786432));
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (birt.a(this.jdField_a_of_type_Bijd) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      return localHashSet;
      if (birt.e.a(i))
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
      else if ((birt.x.a(i)) || (birt.w.a(i)))
      {
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(458752));
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
      localObject = new bise(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bima(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bill(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bina(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bikt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new biwh(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bipi(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bipr(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bixi(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362176), this);
      continue;
      localObject = new binq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bisl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bijd;
  }
  
  private void b(int paramInt, Object... paramVarArgs) {}
  
  public birb a(int paramInt)
  {
    paramInt = a(paramInt);
    biwr localbiwr = (biwr)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localbiwr instanceof bima)) {
      return ((bima)localbiwr).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    biwr localbiwr = (biwr)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbiwr != null) {
      return localbiwr.a(paramInt, paramVarArgs);
    }
    return b(paramInt, paramVarArgs);
  }
  
  public void a()
  {
    a(393217, new Object[0]);
    a(262149, new Object[0]);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    biwr localbiwr = (biwr)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbiwr != null)
    {
      localbiwr.a(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (biwr)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  protected void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      a(((Integer)localIterator.next()).intValue());
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).b();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).c();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwr)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biws
 * JD-Core Version:    0.7.0.1
 */