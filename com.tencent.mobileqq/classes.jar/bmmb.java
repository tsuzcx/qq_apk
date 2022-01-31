import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bmmb
  extends bmwn
{
  private final List<bmvv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bmvv> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bmvv a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bmvv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bmvv a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((blvi)blqr.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bmvv localbmvv = (bmvv)localIterator.next();
      if ((localbmvv != null) && (TextUtils.equals(paramString, localbmvv.jdField_a_of_type_JavaLangString))) {
        return localbmvv;
      }
    }
    return null;
  }
  
  public void a(bmvv parambmvv)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambmvv);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambmvv);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambmvv);
      a(i);
    }
  }
  
  public void a(Collection<bmvv> paramCollection)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bmvv localbmvv = (bmvv)paramCollection.next();
        if (localbmvv != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbmvv);
          if (localbmvv.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbmvv);
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
 * Qualified Name:     bmmb
 * JD-Core Version:    0.7.0.1
 */