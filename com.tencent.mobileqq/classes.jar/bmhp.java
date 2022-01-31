import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bmhp
  extends bmsb
{
  private final List<bmrj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bmrj> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bmrj a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bmrj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bmrj a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((blqw)blmf.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bmrj localbmrj = (bmrj)localIterator.next();
      if ((localbmrj != null) && (TextUtils.equals(paramString, localbmrj.jdField_a_of_type_JavaLangString))) {
        return localbmrj;
      }
    }
    return null;
  }
  
  public void a(bmrj parambmrj)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambmrj);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambmrj);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambmrj);
      a(i);
    }
  }
  
  public void a(Collection<bmrj> paramCollection)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bmrj localbmrj = (bmrj)paramCollection.next();
        if (localbmrj != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbmrj);
          if (localbmrj.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbmrj);
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
 * Qualified Name:     bmhp
 * JD-Core Version:    0.7.0.1
 */