import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bkkq
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bkkp> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bkkp> b = new ArrayList();
  
  public bkkq(@NonNull Groups paramGroups, @NonNull List<bkkp> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bkkp)paramGroups.next();
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
  public List<bkkp> a()
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
  
  public void a(bkkp parambkkp)
  {
    parambkkp.a();
    if ((parambkkp.jdField_a_of_type_Boolean) && (!this.b.contains(parambkkp)))
    {
      this.b.add(parambkkp);
      return;
    }
    if ((!parambkkp.jdField_a_of_type_Boolean) && (this.b.contains(parambkkp)))
    {
      this.b.remove(parambkkp);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambkkp.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambkkp));
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
  public List<bkkp> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bkkp localbkkp = (bkkp)localIterator.next();
      localbkkp.jdField_a_of_type_Boolean = true;
      this.b.add(localbkkp);
    }
  }
  
  public void b(bkkp parambkkp)
  {
    parambkkp.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambkkp)) {
      this.b.add(parambkkp);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bkkp)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkq
 * JD-Core Version:    0.7.0.1
 */