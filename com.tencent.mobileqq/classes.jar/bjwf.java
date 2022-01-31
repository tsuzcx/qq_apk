import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bjwf
  extends bkgr
{
  private final List<bkfz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bkfz> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bkfz a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bkfz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bkfz a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((bjfl)bjav.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bkfz localbkfz = (bkfz)localIterator.next();
      if ((localbkfz != null) && (TextUtils.equals(paramString, localbkfz.jdField_a_of_type_JavaLangString))) {
        return localbkfz;
      }
    }
    return null;
  }
  
  public void a(bkfz parambkfz)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambkfz);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambkfz);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambkfz);
      a(i);
    }
  }
  
  public void a(Collection<bkfz> paramCollection)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bkfz localbkfz = (bkfz)paramCollection.next();
        if (localbkfz != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbkfz);
          if (localbkfz.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbkfz);
          }
        }
      }
    }
    finally {}
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwf
 * JD-Core Version:    0.7.0.1
 */