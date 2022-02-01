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
public class bmas
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private blio jdField_a_of_type_Blio;
  private Map<Integer, bmar> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public bmas(Activity paramActivity, View paramView, blio paramblio)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Blio = paramblio;
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
      localObject = new blwd(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blqn(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blpr(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blpb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blqw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bloe(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bmai(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new bltd(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new blto(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEPlayShowPart(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362278), this);
      continue;
      localObject = new blrm(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
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
    return this.jdField_a_of_type_Blio;
  }
  
  private Set<Integer> b()
  {
    HashSet localHashSet = new HashSet();
    int j = blvr.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.a.a());
      }
    }
    if ((blvr.c.a(i)) || (blvr.t.a(i)) || (blvr.n.a(i)) || (blvr.e.a(i)) || (blvr.d(i)))
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
      if (blvr.a(this.jdField_a_of_type_Blio) == 204) {
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (blvr.a(this.jdField_a_of_type_Blio) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      if (blrg.a())
      {
        boolean bool = bmbk.a().a("DEBUG_KEY_TEST_LAUNCH_SPEED_MODE", false, 4);
        if ((blrg.a()) && (!bool)) {
          localHashSet.add(Integer.valueOf(720896));
        }
      }
      return localHashSet;
      if (blvr.e.a(i))
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
      else if ((blvr.I.a(i)) || (blvr.H.a(i)))
      {
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
      }
      else
      {
        if (!blvr.w.a(i)) {
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
    if (blvr.h(i)) {
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
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).initView();
    }
  }
  
  public bluy a(int paramInt)
  {
    paramInt = b(paramInt);
    bmar localbmar = (bmar)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localbmar instanceof blpr)) {
      return ((blpr)localbmar).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = b(paramInt);
    bmar localbmar = (bmar)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbmar != null) {
      return localbmar.get(paramInt, paramVarArgs);
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
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = b(paramInt);
    int i = j;
    if (j == 65536) {
      i = a(paramInt);
    }
    bmar localbmar = (bmar)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localbmar != null)
    {
      localbmar.send(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    return (bmar)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResume();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityPause();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStart();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStop();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((bmar)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmas
 * JD-Core Version:    0.7.0.1
 */