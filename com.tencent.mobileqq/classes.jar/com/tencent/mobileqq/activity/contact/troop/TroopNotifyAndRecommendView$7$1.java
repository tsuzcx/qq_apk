package com.tencent.mobileqq.activity.contact.troop;

import ajpe;
import ajqt;
import ajqw;
import ajqx;
import bdzi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopNotifyAndRecommendView$7$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$7$1(ajqt paramajqt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "Get MessageRecords From DB Real Size =", Integer.valueOf(this.a.a.jdField_a_of_type_JavaUtilList.size()) });
    }
    Object localObject1 = ajqw.a(this.a.a.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "Get MessageRecords From DB No Seq Size =", Integer.valueOf(((List)localObject1).size()) });
    }
    TroopNotifyAndRecommendView.setAndCheckNotifyFollowSeq((List)localObject1, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (ajqx.b())
    {
      this.a.a.setType(1);
      ajqx.b(false);
    }
    Object localObject2 = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      ((List)localObject2).add(((List)localObject1).get(((List)localObject1).size() - i - 1));
      i += 1;
    }
    ajqw.a((List)localObject2, bdzi.a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localObject2 = ajqw.c();
    List localList2 = ajqw.a();
    List localList1 = ajqw.b();
    if (this.a.a.c == 1) {
      this.a.a.a(true);
    }
    for (localObject1 = localList1;; localObject1 = localObject2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "withoutExitDatas Size =", Integer.valueOf(((List)localObject2).size()), "exitDataList Size =", Integer.valueOf(localList2.size()), "undealDataList Size=", Integer.valueOf(localList1.size()) });
      }
      if ((localObject2 == null) || (((List)localObject2).size() <= 0) || ((((List)localObject2).get(0) instanceof MessageForSystemMsg))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initNotificationListData error");
      }
      this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.y();
      if (this.a.a.jdField_a_of_type_Ajpe != null)
      {
        this.a.a.jdField_a_of_type_Ajpe.a(null);
        this.a.a.jdField_a_of_type_Ajpe.notifyDataSetChanged();
      }
      return;
    }
    if (this.a.a.jdField_a_of_type_Ajpe != null)
    {
      this.a.a.jdField_a_of_type_Ajpe.a((List)localObject1);
      this.a.a.jdField_a_of_type_Ajpe.notifyDataSetChanged();
      this.a.a.jdField_a_of_type_Ajpe.a(this.a.a.jdField_a_of_type_Aoga);
    }
    this.a.a.c(localList2);
    this.a.a.b(localList1);
    if (!ajqw.b()) {
      this.a.a.a(false, 2);
    }
    if (ajqw.a()) {
      this.a.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.a(this.a.a);
      TroopNotifyAndRecommendView.b(this.a.a);
      return;
      this.a.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.7.1
 * JD-Core Version:    0.7.0.1
 */