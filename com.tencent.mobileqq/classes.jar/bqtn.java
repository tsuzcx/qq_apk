import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bqtn
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<bqtm> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<bqtm> b = new ArrayList();
  
  public bqtn(@NonNull Groups paramGroups, @NonNull List<bqtm> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (bqtm)paramGroups.next();
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
  public List<bqtm> a()
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
  
  public void a(bqtm parambqtm)
  {
    parambqtm.a();
    if ((parambqtm.jdField_a_of_type_Boolean) && (!this.b.contains(parambqtm)))
    {
      this.b.add(parambqtm);
      return;
    }
    if ((!parambqtm.jdField_a_of_type_Boolean) && (this.b.contains(parambqtm)))
    {
      this.b.remove(parambqtm);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + parambqtm.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(parambqtm));
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
  public List<bqtm> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bqtm localbqtm = (bqtm)localIterator.next();
      localbqtm.jdField_a_of_type_Boolean = true;
      this.b.add(localbqtm);
    }
  }
  
  public void b(bqtm parambqtm)
  {
    parambqtm.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(parambqtm)) {
      this.b.add(parambqtm);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bqtm)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqtn
 * JD-Core Version:    0.7.0.1
 */