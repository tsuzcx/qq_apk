import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bqfc
  extends bqpo
{
  private final List<bqow> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bqow> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bqow a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bqow)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bqow a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((bpqh)bplq.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bqow localbqow = (bqow)localIterator.next();
      if ((localbqow != null) && (TextUtils.equals(paramString, localbqow.jdField_a_of_type_JavaLangString))) {
        return localbqow;
      }
    }
    return null;
  }
  
  public void a(bqow parambqow)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambqow);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambqow);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambqow);
      a(i);
    }
  }
  
  public void a(Collection<bqow> paramCollection)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bqow localbqow = (bqow)paramCollection.next();
        if (localbqow != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbqow);
          if (localbqow.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbqow);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfc
 * JD-Core Version:    0.7.0.1
 */