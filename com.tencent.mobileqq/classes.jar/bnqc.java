import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.play.AEPlayShowPart;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class bnqc
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bmvf jdField_a_of_type_Bmvf;
  private Map<Integer, bnqb> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public bnqc(Activity paramActivity, View paramView, bmvf parambmvf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bmvf = parambmvf;
    this.jdField_a_of_type_JavaUtilSet = a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt >> 16 == 2) {
      return 786432;
    }
    return 65536;
  }
  
  private Set<Integer> a()
  {
    return b();
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
      localObject = new bnln(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bndw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnda(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bncm(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnef(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnbp(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnps(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnhf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bnhr(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEPlayShowPart(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362283), this);
      continue;
      localObject = new bnev(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private int b(int paramInt)
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
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bmvf;
  }
  
  private Set<Integer> b()
  {
    HashSet localHashSet = new HashSet();
    int j = bnlb.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
      }
    }
    if ((bnlb.c.a(i)) || (bnlb.t.a(i)) || (bnlb.n.a(i)) || (bnlb.e.a(i)) || (bnlb.d(i)))
    {
      localHashSet.add(Integer.valueOf(458752));
      localHashSet.add(Integer.valueOf(131072));
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      localHashSet.add(Integer.valueOf(655360));
    }
    for (;;)
    {
      if (bnlb.a(this.jdField_a_of_type_Bmvf) == 204) {
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (bnlb.a(this.jdField_a_of_type_Bmvf) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      if (bnep.a())
      {
        boolean bool = bnqu.a().a("DEBUG_KEY_TEST_LAUNCH_SPEED_MODE", false, 4);
        if ((bnep.a()) && (!bool)) {
          localHashSet.add(Integer.valueOf(720896));
        }
      }
      return localHashSet;
      if (bnlb.e.a(i))
      {
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
      }
      else if ((bnlb.I.a(i)) || (bnlb.H.a(i)))
      {
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
      }
      else
      {
        if (!bnlb.w.a(i)) {
          break;
        }
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(393216));
      }
    }
    localHashSet.add(Integer.valueOf(458752));
    if (bnlb.h(i)) {
      localHashSet.add(Integer.valueOf(786432));
    }
    for (;;)
    {
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      break;
      localHashSet.add(Integer.valueOf(131072));
    }
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
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).initView();
    }
  }
  
  public bnkb a(int paramInt)
  {
    paramInt = b(paramInt);
    bnqb localbnqb = (bnqb)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localbnqb instanceof bnda)) {
      return ((bnda)localbnqb).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = b(paramInt);
    bnqb localbnqb = (bnqb)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbnqb != null) {
      return localbnqb.get(paramInt, paramVarArgs);
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
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = b(paramInt);
    int i = j;
    if (j == 65536) {
      i = a(paramInt);
    }
    bnqb localbnqb = (bnqb)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbnqb != null)
    {
      localbnqb.send(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    return (bnqb)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResume();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityPause();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStart();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStop();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bnqb)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqc
 * JD-Core Version:    0.7.0.1
 */