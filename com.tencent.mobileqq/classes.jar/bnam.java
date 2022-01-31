import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bnam
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bnal> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bnal> b = new ArrayList();
  
  public bnam(@NonNull Groups paramGroups, @NonNull List<bnal> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bnal)paramGroups.next();
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
  public List<bnal> a()
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
  
  public void a(bnal parambnal)
  {
    parambnal.a();
    if ((parambnal.jdField_a_of_type_Boolean) && (!this.b.contains(parambnal)))
    {
      this.b.add(parambnal);
      return;
    }
    if ((!parambnal.jdField_a_of_type_Boolean) && (this.b.contains(parambnal)))
    {
      this.b.remove(parambnal);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambnal.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambnal));
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
  public List<bnal> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bnal localbnal = (bnal)localIterator.next();
      localbnal.jdField_a_of_type_Boolean = true;
      this.b.add(localbnal);
    }
  }
  
  public void b(bnal parambnal)
  {
    parambnal.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambnal)) {
      this.b.add(parambnal);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bnal)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnam
 * JD-Core Version:    0.7.0.1
 */