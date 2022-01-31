import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bier
  extends bipf
{
  private final List<bion> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bion> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bion a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bion)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bion a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((bhkc)bhfm.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bion localbion = (bion)localIterator.next();
      if ((localbion != null) && (TextUtils.equals(paramString, localbion.jdField_a_of_type_JavaLangString))) {
        return localbion;
      }
    }
    return null;
  }
  
  public void a(bion parambion)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambion);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambion);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambion);
      a(i);
    }
  }
  
  public void a(Collection<bion> paramCollection)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bion localbion = (bion)paramCollection.next();
        if (localbion != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbion);
          if (localbion.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbion);
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
 * Qualified Name:     bier
 * JD-Core Version:    0.7.0.1
 */