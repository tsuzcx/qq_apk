import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqct
  extends aqbe
{
  public aqct(Intent paramIntent)
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
      if ((localRecentUser != null) && (!bbbr.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(aqau.h))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      aywm.a((URLDrawable)paramDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setBounds(0, 0, (int)(264.0F * this.jdField_a_of_type_Float), (int)(138.0F * this.jdField_a_of_type_Float));
  }
  
  protected void a(bbgu parambbgu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwwardMapOption", 2, "updateImageView:setDefaultDialogPreviewImage");
    }
    a(aqdn.a(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839352), this.jdField_a_of_type_Float), false, 0);
  }
  
  protected void b()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_location_string");
    this.jdField_a_of_type_Bbgu.setMessage(str);
  }
  
  protected boolean c()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardMapOption realForwardTo isFromFavorite=" + bool1 + "isFromFav=" + bool2);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if ((bool1) || (bool2))
    {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      return true;
      if (this.f)
      {
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      else
      {
        super.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqct
 * JD-Core Version:    0.7.0.1
 */