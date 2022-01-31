import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqav
  extends aqbe
{
  public aqav(Intent paramIntent)
  {
    super(paramIntent);
    this.b = true;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bbbr.a(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(aqau.h))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
    {
      this.jdField_a_of_type_JavaUtilSet.add(f);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    ArrayList localArrayList4 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localArrayList4 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList4;
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("sendMultiple", true);
      if (localArrayList1 == null) {
        paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList3);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable localURLDrawable;
    if (paramBoolean)
    {
      localURLDrawable = (URLDrawable)paramDrawable;
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label33;
      }
      aywm.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    while (paramDrawable == null)
    {
      return;
      label33:
      aywm.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    paramDrawable.setBounds(0, 0, jdField_a_of_type_Int, jdField_a_of_type_Int);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bbgu.setMessage(null);
    this.jdField_a_of_type_Bbgu.setMessageCount(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqav
 * JD-Core Version:    0.7.0.1
 */