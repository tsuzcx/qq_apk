import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class botp
  extends bpbn
{
  private final List<bpaw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bpaw> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bpaw a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bpaw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bpaw a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((bojs)bogd.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bpaw localbpaw = (bpaw)localIterator.next();
      if ((localbpaw != null) && (TextUtils.equals(paramString, localbpaw.jdField_a_of_type_JavaLangString))) {
        return localbpaw;
      }
    }
    return null;
  }
  
  public void a(bpaw parambpaw)
  {
    ykq.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambpaw);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambpaw);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambpaw);
      a(i);
    }
  }
  
  public void a(Collection<bpaw> paramCollection)
  {
    ykq.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bpaw localbpaw = (bpaw)paramCollection.next();
        if (localbpaw != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbpaw);
          if (localbpaw.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbpaw);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botp
 * JD-Core Version:    0.7.0.1
 */