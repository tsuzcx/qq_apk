import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bpdh
  extends bpnt
{
  private final List<bpnb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<bpnb> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bpnb a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bpnb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bpnb a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((boom)bojv.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bpnb localbpnb = (bpnb)localIterator.next();
      if ((localbpnb != null) && (TextUtils.equals(paramString, localbpnb.jdField_a_of_type_JavaLangString))) {
        return localbpnb;
      }
    }
    return null;
  }
  
  public void a(bpnb parambpnb)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + parambpnb);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambpnb);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, parambpnb);
      a(i);
    }
  }
  
  public void a(Collection<bpnb> paramCollection)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        bpnb localbpnb = (bpnb)paramCollection.next();
        if (localbpnb != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localbpnb);
          if (localbpnb.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localbpnb);
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
 * Qualified Name:     bpdh
 * JD-Core Version:    0.7.0.1
 */