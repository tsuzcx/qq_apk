import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

class ayfw
  extends FragmentPagerAdapter
{
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  
  ayfw(FragmentManager paramFragmentManager, List<Fragment> paramList)
  {
    super(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  Fragment a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfw
 * JD-Core Version:    0.7.0.1
 */