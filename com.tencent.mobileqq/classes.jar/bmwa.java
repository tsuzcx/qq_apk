import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bmwa
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bmvz> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bmvz> b = new ArrayList();
  
  public bmwa(@NonNull Groups paramGroups, @NonNull List<bmvz> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bmvz)paramGroups.next();
      if (paramList.jdField_a_of_type_Boolean) {
        this.b.add(paramList);
      }
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  @NonNull
  public List<bmvz> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(bmvz parambmvz)
  {
    parambmvz.a();
    if ((parambmvz.jdField_a_of_type_Boolean) && (!this.b.contains(parambmvz)))
    {
      this.b.add(parambmvz);
      return;
    }
    if ((!parambmvz.jdField_a_of_type_Boolean) && (this.b.contains(parambmvz)))
    {
      this.b.remove(parambmvz);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambmvz.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambmvz));
  }
  
  public boolean a()
  {
    return (!this.b.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.size() == this.b.size());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NonNull
  public List<bmvz> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bmvz localbmvz = (bmvz)localIterator.next();
      localbmvz.jdField_a_of_type_Boolean = true;
      this.b.add(localbmvz);
    }
  }
  
  public void b(bmvz parambmvz)
  {
    parambmvz.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambmvz)) {
      this.b.add(parambmvz);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmvz)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwa
 * JD-Core Version:    0.7.0.1
 */