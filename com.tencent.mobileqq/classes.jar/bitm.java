import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bitm
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bitl> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bitl> b = new ArrayList();
  
  public bitm(@NonNull Groups paramGroups, @NonNull List<bitl> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bitl)paramGroups.next();
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
  public List<bitl> a()
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
  
  public void a(bitl parambitl)
  {
    parambitl.a();
    if ((parambitl.jdField_a_of_type_Boolean) && (!this.b.contains(parambitl)))
    {
      this.b.add(parambitl);
      return;
    }
    if ((!parambitl.jdField_a_of_type_Boolean) && (this.b.contains(parambitl)))
    {
      this.b.remove(parambitl);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambitl.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambitl));
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
  public List<bitl> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bitl localbitl = (bitl)localIterator.next();
      localbitl.jdField_a_of_type_Boolean = true;
      this.b.add(localbitl);
    }
  }
  
  public void b(bitl parambitl)
  {
    parambitl.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambitl)) {
      this.b.add(parambitl);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bitl)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitm
 * JD-Core Version:    0.7.0.1
 */