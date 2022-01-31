import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bjvo
  extends bkga
{
  private final List<bkfi> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bkfi> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bkfi a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bkfi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bkfi a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((bjeu)bjae.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bkfi localbkfi = (bkfi)localIterator.next();
      if ((localbkfi != null) && (TextUtils.equals(paramString, localbkfi.jdField_a_of_type_JavaLangString))) {
        return localbkfi;
      }
    }
    return null;
  }
  
  public void a(bkfi parambkfi)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambkfi);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambkfi);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambkfi);
      a(i);
    }
  }
  
  public void a(Collection<bkfi> paramCollection)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bkfi localbkfi = (bkfi)paramCollection.next();
        if (localbkfi != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbkfi);
          if (localbkfi.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbkfi);
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
 * Qualified Name:     bjvo
 * JD-Core Version:    0.7.0.1
 */