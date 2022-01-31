import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqfn
  extends aqbc
{
  public aqfn(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!bbbd.a(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.getType() == 1) && (!a(localRecentUser.uin)) && (a(c))) || ((localRecentUser.getType() == 1006) && (a(aqas.h))) || ((localRecentUser.getType() == 3000) && (a(d))))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.jdField_b_of_type_Boolean)))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("acceptType", 13);
    if (((i & 0x1) != 0) && (m())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (((i & 0x4) != 0) && (l())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (((i & 0x8) != 0) && (k())) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("openAIOForPtt", 0) != 1)
    {
      a(2131694930);
      long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("appid", -1L);
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("uintype");
      UiApiPlugin.a((Activity)localObject, localQQAppInterface, l, new String[] { str }, new int[] { paramInt });
      return;
    }
    Object localObject = actn.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", paramBundle.getString("uinname"));
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    ((Intent)localObject).putExtra("open_chat_from_voice_changer_guide", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfn
 * JD-Core Version:    0.7.0.1
 */