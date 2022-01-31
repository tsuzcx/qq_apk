import com.tencent.mobileqq.comment.DanmuItemBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aobu
{
  int jdField_a_of_type_Int = 0;
  aobs jdField_a_of_type_Aobs;
  aoby jdField_a_of_type_Aoby;
  List<Long> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 30;
  List<Long> jdField_b_of_type_JavaUtilList = new ArrayList();
  int jdField_c_of_type_Int = 0;
  List<DanmuItemBean> jdField_c_of_type_JavaUtilList;
  int jdField_d_of_type_Int = 0;
  List<DanmuItemBean> jdField_d_of_type_JavaUtilList = new ArrayList();
  int e = 0;
  int f = 60;
  
  public aobu(aobt paramaobt) {}
  
  public aobu a()
  {
    aobt.a().a(aobt.a().a(this.jdField_a_of_type_Aobs.b, this.jdField_a_of_type_Aobs.jdField_a_of_type_Long), this);
    return this;
  }
  
  public aobu a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aobu a(aobs paramaobs)
  {
    this.jdField_a_of_type_Aobs = paramaobs;
    return this;
  }
  
  public aobu a(aoby paramaoby)
  {
    this.jdField_a_of_type_Aoby = paramaoby;
    return this;
  }
  
  public aobu a(List<DanmuItemBean> paramList)
  {
    this.jdField_c_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public aobu a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return String.format("CacheHolder - topicUin:%s, groupUin:%s, msgType:%s, peakCached:%s, videoStartTime:%s, videoEndTime:%s, nextStartIdx:%s, count:%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Aobs.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_Aobs.b), Integer.valueOf(this.jdField_a_of_type_Aobs.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Aobs.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.e), Integer.valueOf(this.f) });
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    DanmuItemBean localDanmuItemBean;
    while (localIterator.hasNext())
    {
      localDanmuItemBean = (DanmuItemBean)localIterator.next();
      if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(localDanmuItemBean.b))) {
        localIterator.remove();
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        if (!this.jdField_b_of_type_JavaUtilList.contains(Long.valueOf(l))) {
          this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(l));
        }
      }
    }
    if ((this.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localDanmuItemBean = (DanmuItemBean)localIterator.next();
        if (!a(localDanmuItemBean.jdField_a_of_type_Long, localDanmuItemBean.b)) {
          this.jdField_d_of_type_JavaUtilList.add(localDanmuItemBean);
        }
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)localIterator.next();
      if ((localDanmuItemBean.jdField_a_of_type_Long == paramLong1) && (localDanmuItemBean.b == paramLong2)) {
        return true;
      }
    }
    return false;
  }
  
  public aobu b(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_b_of_type_Int = paramInt;
    }
    return this;
  }
  
  public aobu b(List<Long> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public aobu c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public aobu d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public aobu e(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobu
 * JD-Core Version:    0.7.0.1
 */