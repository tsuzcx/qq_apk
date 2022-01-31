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
public class biwb
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private biim jdField_a_of_type_Biim;
  private Map<Integer, biwa> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public biwb(Activity paramActivity, View paramView, biim parambiim)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Biim = parambiim;
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
    int j = birc.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birc.a.a());
      }
    }
    if ((birc.c.a(i)) || (birc.t.a(i)) || (birc.n.a(i)) || (birc.e.a(i)) || (birc.d(i)))
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
      if (birc.a(this.jdField_a_of_type_Biim) == 204)
      {
        localHashSet.remove(Integer.valueOf(786432));
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (birc.a(this.jdField_a_of_type_Biim) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      return localHashSet;
      if (birc.e.a(i))
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
      else if ((birc.x.a(i)) || (birc.w.a(i)))
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
      localObject = new birn(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bilj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new biku(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bimj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bikc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bivq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bior(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bipa(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new biwr(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362177), this);
      continue;
      localObject = new bimz(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new biru(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Biim;
  }
  
  private void b(int paramInt, Object... paramVarArgs) {}
  
  public biqk a(int paramInt)
  {
    paramInt = a(paramInt);
    biwa localbiwa = (biwa)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localbiwa instanceof bilj)) {
      return ((bilj)localbiwa).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    biwa localbiwa = (biwa)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbiwa != null) {
      return localbiwa.a(paramInt, paramVarArgs);
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
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    biwa localbiwa = (biwa)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbiwa != null)
    {
      localbiwa.a(paramInt, paramVarArgs);
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
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (biwa)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
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
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).b();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).c();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((biwa)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwb
 * JD-Core Version:    0.7.0.1
 */