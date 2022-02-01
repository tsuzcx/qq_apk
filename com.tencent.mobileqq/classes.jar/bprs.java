import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bprs
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bprr> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bprr> b = new ArrayList();
  
  public bprs(@NonNull Groups paramGroups, @NonNull List<bprr> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bprr)paramGroups.next();
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
  public List<bprr> a()
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
  
  public void a(bprr parambprr)
  {
    parambprr.a();
    if ((parambprr.jdField_a_of_type_Boolean) && (!this.b.contains(parambprr)))
    {
      this.b.add(parambprr);
      return;
    }
    if ((!parambprr.jdField_a_of_type_Boolean) && (this.b.contains(parambprr)))
    {
      this.b.remove(parambprr);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambprr.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambprr));
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
  public List<bprr> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bprr localbprr = (bprr)localIterator.next();
      localbprr.jdField_a_of_type_Boolean = true;
      this.b.add(localbprr);
    }
  }
  
  public void b(bprr parambprr)
  {
    parambprr.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambprr)) {
      this.b.add(parambprr);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bprr)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprs
 * JD-Core Version:    0.7.0.1
 */