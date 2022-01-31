import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arxs
  extends arxa
{
  public arxs(Intent paramIntent)
  {
    super(paramIntent);
    this.e = true;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bdal.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(aruc.h))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 0) || (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void d()
  {
    e();
    super.d();
  }
  
  public void e()
  {
    Object localObject1 = azqu.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject1 == null) || (TextUtils.isEmpty(((AbsStructMsg)localObject1).mMsg_A_ActionData))) {}
    for (;;)
    {
      return;
      Object localObject2 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((AbsStructMsg)localObject1).mMsg_A_ActionData);
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((bddb)localObject2).b("usertype");
      localObject2 = ((bddb)localObject2).b("unionid");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        continue;
      }
      try
      {
        i = Integer.parseInt((String)localObject1);
        wta.a("share_uin", "qq_suc", bclo.b(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")), i, new String[] { localObject2 });
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.shareAccount", 2, "shareToQQ success userType:" + i + ",userUnionId:" + (String)localObject2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxs
 * JD-Core Version:    0.7.0.1
 */