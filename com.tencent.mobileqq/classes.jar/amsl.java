import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class amsl
  extends AsyncTask
{
  public amsl(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, DiscussionManager paramDiscussionManager, String paramString, long paramLong, QQAppInterface paramQQAppInterface) {}
  
  protected ArrayList a(Void... paramVarArgs)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.b(this.jdField_a_of_type_JavaLangString);
    paramVarArgs = new HashSet();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramVarArgs.add((String)((Iterator)localObject).next());
      }
    }
    localObject = new ArrayList();
    int i = DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler).size() - 1;
    if (i >= 0)
    {
      if (paramVarArgs.contains(((ResultRecord)DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler).get(i)).jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        i -= 1;
        break;
        ResultRecord localResultRecord = (ResultRecord)DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler).get(i);
        AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
        if (localResultRecord.jdField_a_of_type_Int == 4) {
          localAddDiscussMemberInfo.RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        }
        for (;;)
        {
          localAddDiscussMemberInfo.Type = localResultRecord.jdField_a_of_type_Int;
          ((ArrayList)localObject).add(localAddDiscussMemberInfo);
          break;
          try
          {
            localAddDiscussMemberInfo.Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
            localAddDiscussMemberInfo.RefUin = Long.valueOf(localResultRecord.c).longValue();
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.d("DingdongPluginRemoteCmdHandler", 2, "doModifyDiscussForDingdong, NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
    }
    return localObject;
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      paramArrayList = new Intent();
      paramArrayList.putExtra("reqCode", 7);
      paramArrayList.putExtra("isSuccess", true);
      paramArrayList.putExtra("roomId", this.jdField_a_of_type_Long);
      DingdongPluginHelper.a(11, paramArrayList);
    }
    DiscussionHandler localDiscussionHandler;
    do
    {
      return;
      if (!DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler));
        DingdongPluginRemoteCmdHandler.a(this.jdField_a_of_type_CooperationDingdongDingdongPluginRemoteCmdHandler, true);
      }
      localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    } while (localDiscussionHandler == null);
    localDiscussionHandler.b(this.jdField_a_of_type_Long, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsl
 * JD-Core Version:    0.7.0.1
 */