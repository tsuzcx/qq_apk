import android.util.SparseArray;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import java.util.ArrayList;
import java.util.List;

public class augh
{
  private SparseArray<HotPicTagInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ArrayList<HotPicTagInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public HotPicTagInfo a(int paramInt)
  {
    return (HotPicTagInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public List<HotPicTagInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramHotPicTagInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramHotPicTagInfo.tagId, paramHotPicTagInfo);
  }
  
  public HotPicTagInfo b(int paramInt)
  {
    return (HotPicTagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augh
 * JD-Core Version:    0.7.0.1
 */