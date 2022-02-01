package com.tencent.biz.addContactTroopView;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class AddContactTroopManage
  implements Manager
{
  protected AppInterface a;
  protected final String a;
  protected troopviewInfo.RspBody a;
  
  public AddContactTroopManage(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "AddContactTroopManage";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(troopviewInfo.RspBody paramRspBody)
  {
    ThreadManager.post(new AddContactTroopManage.1(this, paramRspBody), 8, null, false);
  }
  
  private boolean a(troopviewInfo.RspBody paramRspBody)
  {
    if (paramRspBody != null)
    {
      if (!paramRspBody.has()) {
        return false;
      }
      File localFile = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AddContactTroopManage");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      return FileUtils.pushData2File(new File(localFile, localStringBuilder.toString()).getAbsolutePath(), paramRspBody.toByteArray(), false);
    }
    return false;
  }
  
  private troopviewInfo.RspBody b()
  {
    Object localObject1;
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AddContactTroopManage");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      byte[] arrayOfByte = FileUtils.fileToBytes(new File((File)localObject1, ((StringBuilder)localObject2).toString()));
      localObject1 = new troopviewInfo.RspBody();
      localObject2 = localObject1;
      if (arrayOfByte == null) {
        return ???;
      }
      try
      {
        ((troopviewInfo.RspBody)localObject1).mergeFrom(arrayOfByte);
        return localObject1;
      }
      catch (NullPointerException localNullPointerException1) {}catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
      localInvalidProtocolBufferMicroException2.printStackTrace();
    }
    catch (NullPointerException localNullPointerException2)
    {
      localObject1 = null;
      localNullPointerException2.printStackTrace();
      return localObject1;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      localObject1 = null;
    }
    Object localObject3 = localObject1;
    return localObject3;
  }
  
  public popclassifc.PopHotWordCard a()
  {
    troopviewInfo.RspBody localRspBody = a();
    if (localRspBody != null) {
      return (popclassifc.PopHotWordCard)((popclassifc.RspBody)((popclassifc.RspBody)localRspBody.popRsb.get()).get()).pop_hotword.get();
    }
    return null;
  }
  
  public troopviewInfo.RspBody a()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody == null) {
        this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody = b();
      }
      if (this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody == null) {
        this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody = new troopviewInfo.RspBody();
      }
      troopviewInfo.RspBody localRspBody = this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody;
      return localRspBody;
    }
    finally {}
  }
  
  public void a(popclassifc.RspBody paramRspBody)
  {
    try
    {
      troopviewInfo.RspBody localRspBody = a();
      localRspBody.popRsb = new popclassifc.RspBody();
      localRspBody.popRsb.set(paramRspBody);
      a(localRspBody);
      return;
    }
    finally
    {
      paramRspBody = finally;
      throw paramRspBody;
    }
  }
  
  public void a(searchtab.RspBody paramRspBody)
  {
    try
    {
      troopviewInfo.RspBody localRspBody = a();
      localRspBody.searchRsb = new searchtab.RspBody();
      localRspBody.searchRsb.set(paramRspBody);
      a(localRspBody);
      return;
    }
    finally
    {
      paramRspBody = finally;
      throw paramRspBody;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopManage
 * JD-Core Version:    0.7.0.1
 */