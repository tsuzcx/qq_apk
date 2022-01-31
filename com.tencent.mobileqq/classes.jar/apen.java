import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.dating.SayHelloMsgListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class apen
  extends ause
{
  public apen(SayHelloMsgListActivity paramSayHelloMsgListActivity) {}
  
  public void a(boolean paramBoolean, List<FansEntity> paramList)
  {
    int i = 0;
    if (paramBoolean)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FansEntity localFansEntity = (FansEntity)localIterator.next();
        RecentBaseData localRecentBaseData = (RecentBaseData)this.a.jdField_a_of_type_JavaUtilMap.get(String.valueOf(localFansEntity.uin));
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentSayHelloListItem))) {
          ((RecentSayHelloListItem)localRecentBaseData).a(localFansEntity);
        }
      }
      azmj.b(this.a.app, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_hi_list", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
    if (QLog.isDevelopLevel()) {
      if (paramList != null) {
        break label187;
      }
    }
    for (;;)
    {
      QLog.d("Q.msg_box", 4, "get tags, size is " + i);
      return;
      label187:
      i = paramList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apen
 * JD-Core Version:    0.7.0.1
 */