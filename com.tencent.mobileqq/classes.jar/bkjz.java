import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bkjz
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bkjy> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bkjy> b = new ArrayList();
  
  public bkjz(@NonNull Groups paramGroups, @NonNull List<bkjy> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bkjy)paramGroups.next();
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
  public List<bkjy> a()
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
  
  public void a(bkjy parambkjy)
  {
    parambkjy.a();
    if ((parambkjy.jdField_a_of_type_Boolean) && (!this.b.contains(parambkjy)))
    {
      this.b.add(parambkjy);
      return;
    }
    if ((!parambkjy.jdField_a_of_type_Boolean) && (this.b.contains(parambkjy)))
    {
      this.b.remove(parambkjy);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambkjy.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambkjy));
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
  public List<bkjy> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bkjy localbkjy = (bkjy)localIterator.next();
      localbkjy.jdField_a_of_type_Boolean = true;
      this.b.add(localbkjy);
    }
  }
  
  public void b(bkjy parambkjy)
  {
    parambkjy.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambkjy)) {
      this.b.add(parambkjy);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bkjy)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkjz
 * JD-Core Version:    0.7.0.1
 */