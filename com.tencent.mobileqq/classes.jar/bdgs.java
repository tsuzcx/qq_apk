import com.tencent.mobileqq.together.writetogether.data.GetChangesetsResp;
import com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg.Data;
import com.tencent.qphone.base.util.QLog;
import java.util.TreeSet;

class bdgs
  extends bdgm
{
  bdgs(bdgr parambdgr) {}
  
  public void a(boolean paramBoolean, GetChangesetsResp paramGetChangesetsResp)
  {
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "onPullPad");
    }
    NewChangesMsg.Data localData;
    if (paramBoolean)
    {
      if ((paramGetChangesetsResp.changes.length > 0) && (paramGetChangesetsResp.changes[0].a.newRev > this.a.jdField_a_of_type_Int + 1))
      {
        QLog.w("ChangesetClient", 1, "get newer cs, store it");
        paramGetChangesetsResp = paramGetChangesetsResp.changes;
        j = paramGetChangesetsResp.length;
      }
      for (;;)
      {
        if (i < j)
        {
          localData = paramGetChangesetsResp[i];
          this.a.jdField_a_of_type_JavaUtilTreeSet.add(localData.a);
          i += 1;
          continue;
          paramGetChangesetsResp = paramGetChangesetsResp.changes;
          int k = paramGetChangesetsResp.length;
          i = j;
          if (i < k)
          {
            localData = paramGetChangesetsResp[i].a;
            if (localData.newRev <= this.a.jdField_a_of_type_Int) {
              QLog.w("ChangesetClient", 1, "get duplicate cs");
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (localData.newRev > this.a.jdField_a_of_type_Int + 1)
      {
        QLog.e("ChangesetClient", 1, "get broken cs");
        this.a.b();
        return;
      }
      bdgr.a(this.a, localData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgs
 * JD-Core Version:    0.7.0.1
 */