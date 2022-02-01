import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.together.writetogether.websocket.msg.AcceptCommitAndNewChangesHeader;
import com.tencent.mobileqq.together.writetogether.websocket.msg.AcceptCommitMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CommitErrorMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CommitErrorMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CommitErrorMsg.Data;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CommitErrorMsg.Header;
import com.tencent.mobileqq.together.writetogether.websocket.msg.LastReversionMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.LastReversionMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.LastReversionMsg.Notice;
import com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.NewChangesMsg.Data;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesHeader;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesReqMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesReqMsg.UserChangesReqBody;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesRespMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class bemz
  implements bels, bemm, benk
{
  int jdField_a_of_type_Int;
  private beli jdField_a_of_type_Beli;
  private beml jdField_a_of_type_Beml;
  private bemu jdField_a_of_type_Bemu;
  private benh jdField_a_of_type_Benh;
  benj jdField_a_of_type_Benj;
  private beoe jdField_a_of_type_Beoe;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  UserChangesReqMsg jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg;
  private String jdField_a_of_type_JavaLangString;
  TreeSet<NewChangesMsg.Data> jdField_a_of_type_JavaUtilTreeSet = new TreeSet();
  int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public bemz(QQAppInterface paramQQAppInterface, @NonNull beli parambeli, @NonNull String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Beml = ((beml)paramQQAppInterface.getManager(377));
    this.jdField_a_of_type_Beli = parambeli;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.d = paramString2;
    e();
  }
  
  private belt a(boolean paramBoolean)
  {
    if ((paramBoolean) || (!this.jdField_a_of_type_Beli.b())) {
      return this.jdField_a_of_type_Beli.a(this.jdField_b_of_type_JavaLangString);
    }
    return null;
  }
  
  private void a(NewChangesMsg.Data paramData)
  {
    this.jdField_a_of_type_Beli.a(paramData.changeset, paramData.author, paramData.apool);
    a(this.jdField_a_of_type_Int + 1);
  }
  
  private void d()
  {
    a(this.jdField_a_of_type_Int + 1);
    this.jdField_a_of_type_Beli.a();
    if (this.jdField_a_of_type_Beli.a()) {
      a(false);
    }
    if (this.jdField_a_of_type_Benh != null) {
      this.jdField_a_of_type_Benh.a(this.jdField_a_of_type_Int);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new benc(this, null);
    a(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Beml.a(this);
    this.jdField_a_of_type_Bemu = new bena(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bemu);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Benj != null) && ((this.jdField_a_of_type_Beoe == null) || (!bemv.a(this.jdField_a_of_type_Beoe.a())))) {
      this.jdField_a_of_type_Benj.a(1, 500);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Beml.a(paramInt);
  }
  
  public void a(benh parambenh)
  {
    this.jdField_a_of_type_Benh = parambenh;
  }
  
  public void a(benj parambenj)
  {
    this.jdField_a_of_type_Benj = parambenj;
    parambenj.a(this);
  }
  
  void a(INetInfoHandler paramINetInfoHandler)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramINetInfoHandler);
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    switch (benb.a[paramType.ordinal()])
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (UserChangesRespMsg)paramObject);
      return;
    case 2: 
      a(paramBoolean, (AcceptCommitMsg)paramObject);
      return;
    case 3: 
      a(paramBoolean, (NewChangesMsg)paramObject);
      return;
    case 4: 
      a((LastReversionMsg)paramObject);
      return;
    }
    a((CommitErrorMsg)paramObject);
  }
  
  void a(CommitErrorMsg paramCommitErrorMsg)
  {
    if ((((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason == 40401) && (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg != null) && (((CommitErrorMsg.Header)paramCommitErrorMsg.header).taskId == ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId))
    {
      QLog.w("ChangesetClient", 1, "characters reach the limit");
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg = null;
    }
    this.jdField_a_of_type_Benh.a(((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.reason, ((CommitErrorMsg.Body)paramCommitErrorMsg.body).data.msg);
  }
  
  void a(LastReversionMsg paramLastReversionMsg)
  {
    if (((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev > this.jdField_a_of_type_Int)
    {
      b(((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev);
      this.jdField_b_of_type_Int = ((LastReversionMsg.Body)paramLastReversionMsg.body).notice.lastRev;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChangesetClient", 2, "handleUserChange");
    }
    if ((this.jdField_c_of_type_JavaLangString != null) || ((!this.jdField_a_of_type_Beli.a()) && (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg == null))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg != null)
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: waiting commit to be accepted");
        this.jdField_a_of_type_Beml.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg);
        return;
      }
      if (!a())
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: no network");
        return;
      }
      Object localObject = a(true);
      if ((localObject == null) || (((belt)localObject).jdField_a_of_type_JavaLangString == null))
      {
        QLog.d("ChangesetClient", 1, "handleUserChange: user change data is null");
        return;
      }
      localObject = new UserChangesReqMsg(new UserChangesHeader(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int), new UserChangesReqMsg.UserChangesReqBody(this.jdField_a_of_type_Int, ((belt)localObject).jdField_a_of_type_JavaLangString, ((belt)localObject).jdField_a_of_type_Beko, this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg = ((UserChangesReqMsg)localObject);
      this.jdField_a_of_type_Beml.a((BaseToWriteTogetherMsg)localObject);
    } while (this.jdField_a_of_type_Benh == null);
    this.jdField_a_of_type_Benh.a();
  }
  
  void a(boolean paramBoolean, AcceptCommitMsg paramAcceptCommitMsg)
  {
    if (!paramBoolean) {
      return;
    }
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramAcceptCommitMsg.header;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg != null) && (localAcceptCommitAndNewChangesHeader.taskId == ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId))
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg = null;
      if (localAcceptCommitAndNewChangesHeader.newRev != this.jdField_a_of_type_Int + 1)
      {
        this.jdField_c_of_type_Int = localAcceptCommitAndNewChangesHeader.baseRev;
        b(localAcceptCommitAndNewChangesHeader.newRev - 1);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("accept commit with mismatch task id: ");
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg == null) {}
      for (paramAcceptCommitMsg = "null";; paramAcceptCommitMsg = localAcceptCommitAndNewChangesHeader.taskId + " <-> " + ((UserChangesHeader)this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgUserChangesReqMsg.header).taskId)
      {
        QLog.e("ChangesetClient", 1, paramAcceptCommitMsg);
        break;
      }
    }
    d();
  }
  
  void a(boolean paramBoolean, NewChangesMsg paramNewChangesMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handleNewChanges");
    }
    if (!paramBoolean) {}
    AcceptCommitAndNewChangesHeader localAcceptCommitAndNewChangesHeader;
    do
    {
      return;
      localAcceptCommitAndNewChangesHeader = (AcceptCommitAndNewChangesHeader)paramNewChangesMsg.header;
      paramNewChangesMsg = ((NewChangesMsg.Body)paramNewChangesMsg.body).data;
      if (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_a_of_type_Int + 1) {
        break;
      }
      QLog.w("ChangesetClient", 1, "get broken cs, cur rev: " + this.jdField_a_of_type_Int + ", new rev: " + localAcceptCommitAndNewChangesHeader.newRev + ", newest pending merge rev: " + this.jdField_b_of_type_Int);
    } while (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_b_of_type_Int);
    paramNewChangesMsg.newRev = localAcceptCommitAndNewChangesHeader.newRev;
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramNewChangesMsg);
    b(localAcceptCommitAndNewChangesHeader.newRev - 1);
    this.jdField_b_of_type_Int = localAcceptCommitAndNewChangesHeader.newRev;
    return;
    if (localAcceptCommitAndNewChangesHeader.newRev <= this.jdField_a_of_type_Int)
    {
      QLog.w("ChangesetClient", 1, "get duplicate cs");
      return;
    }
    a(paramNewChangesMsg);
    b();
  }
  
  void a(boolean paramBoolean, UserChangesRespMsg paramUserChangesRespMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChangesetClient", 2, "isSuccess: " + paramBoolean + ", result" + ((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result);
    }
    if (((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result != 0) {
      this.jdField_a_of_type_Benh.a(((OnPostWrapper)paramUserChangesRespMsg.body).onpost.result, ((OnPostWrapper)paramUserChangesRespMsg.body).onpost.errMsg);
    }
  }
  
  boolean a()
  {
    return bhnv.a();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      return true;
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "handlePendingMerges");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    while (localIterator.hasNext())
    {
      NewChangesMsg.Data localData = (NewChangesMsg.Data)localIterator.next();
      if (localData.newRev == this.jdField_a_of_type_Int + 1)
      {
        a(localData);
        localArrayList.add(localData);
      }
      else if (localData.newRev <= this.jdField_a_of_type_Int)
      {
        QLog.w("ChangesetClient", 1, "get duplicate pending merge cs");
        localArrayList.add(localData);
      }
      else
      {
        if (this.jdField_c_of_type_Int == this.jdField_a_of_type_Int + 1) {
          d();
        }
        if (localData.newRev != this.jdField_a_of_type_Int + 1) {
          break;
        }
        a(localData);
        localArrayList.add(localData);
      }
    }
    this.jdField_a_of_type_JavaUtilTreeSet.removeAll(localArrayList);
  }
  
  void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "pullDoc");
    }
    bemn localbemn = (bemn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184);
    int i = Math.max(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int) + 1;
    while (paramInt - i >= 0)
    {
      int j = Math.min(paramInt - i + 1, 50);
      localbemn.a(this.d, this.jdField_a_of_type_JavaLangString, i, j + i - 1);
      i += 50;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Beml.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bemu);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemz
 * JD-Core Version:    0.7.0.1
 */