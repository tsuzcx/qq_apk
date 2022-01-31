import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class aupo
  extends FragmentPagerAdapter
{
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> b;
  
  private aupo(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public void a(@Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList1, @Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList2, @Nonnull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.b = paramArrayList2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Fragment getItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ReceiptMessageReadMemberListFragment.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ArrayOfJavaLangString[1]);
    case 0: 
      return ReceiptMessageReadMemberListFragment.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    }
    return ReceiptMessageReadMemberListFragment.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupo
 * JD-Core Version:    0.7.0.1
 */