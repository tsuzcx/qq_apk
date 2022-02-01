import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.EvilReportUtil;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageReqMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.Notice;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.NoticeWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;

public class benz
  implements bema, benh, beob, beoq, beoy
{
  private int jdField_a_of_type_Int;
  private bemc jdField_a_of_type_Bemc;
  private benm jdField_a_of_type_Benm;
  private beoa jdField_a_of_type_Beoa;
  private beow jdField_a_of_type_Beow;
  private beox jdField_a_of_type_Beox;
  private beqz jdField_a_of_type_Beqz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public benz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Benm = ((benm)paramQQAppInterface.getManager(QQManagerFactory.WRITE_TOGETHER_MANAGER));
    this.jdField_a_of_type_Benm.a(this);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    c(paramString1, paramBoolean, paramString2);
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString1 != null) {
      this.jdField_a_of_type_Beow.a(paramString1, benq.a(paramString2), true);
    }
  }
  
  private boolean d()
  {
    return benq.a(this.jdField_a_of_type_Int);
  }
  
  public List<bepb> a()
  {
    if (this.jdField_a_of_type_Beow == null) {
      return null;
    }
    return this.jdField_a_of_type_Beow.a();
  }
  
  public void a()
  {
    String str2 = null;
    String str4 = null;
    j = -1;
    for (;;)
    {
      try
      {
        String str3 = this.jdField_a_of_type_Beow.a().b;
        int k;
        QLog.e("EditorController", 1, "[sendCursorMessage] current data invalid: ", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = this.jdField_a_of_type_Beow.b();
          i = j;
          str4 = str2;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject;
            String str1 = null;
            int i = j;
          }
        }
        try
        {
          str2 = this.jdField_a_of_type_Beow.c();
          i = j;
          str4 = str2;
          j = ((Integer)this.jdField_a_of_type_Beow.a().first).intValue();
          i = j;
          str4 = str2;
          if (QLog.isColorLevel())
          {
            i = j;
            str4 = str2;
            QLog.d("EditorController", 2, "[sendCursorMessage] padId: " + str3 + ", uin: " + str1 + ", index: " + j);
          }
          k = 1;
          i = j;
          j = k;
          if (j != 0) {
            this.jdField_a_of_type_Benm.a(new CursorMessageReqMsg(str3, str1, str2, i));
          }
          return;
        }
        catch (Exception localException3)
        {
          break label180;
        }
        localException1 = localException1;
        str1 = null;
        str3 = null;
        i = j;
      }
      label180:
      j = 0;
      localObject = str4;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Beqz != null) {
      this.jdField_a_of_type_Beqz.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beow != null) {
      this.jdField_a_of_type_Beow.a(paramInt3, paramInt4);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onEditorSelectionChanged] lastStart: " + paramInt1 + ", lastEnd: " + paramInt2 + ", start: " + paramInt3 + ", end: " + paramInt4 + ", changedByUserTouch: " + paramBoolean + ", mInPushChangesetProgress: " + this.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert]start: " + paramInt1 + ", insCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = beog.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bemc);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert] cs: " + paramString1);
    }
    this.jdField_a_of_type_Bemc.a(paramString1);
    this.jdField_a_of_type_Beow.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Beoa != null) {
      this.jdField_a_of_type_Beoa.a(paramString3);
    }
    this.b = true;
  }
  
  public void a(belh parambelh)
  {
    if (parambelh != null)
    {
      this.jdField_a_of_type_Beow.a(parambelh);
      b(parambelh.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(bemc parambemc)
  {
    this.jdField_a_of_type_Bemc = parambemc;
  }
  
  public void a(beoa parambeoa)
  {
    this.jdField_a_of_type_Beoa = parambeoa;
  }
  
  public void a(beow parambeow)
  {
    this.jdField_a_of_type_Beow = parambeow;
  }
  
  public void a(beqz parambeqz)
  {
    this.jdField_a_of_type_Beqz = parambeqz;
    this.jdField_a_of_type_Beox = new beox();
    this.jdField_a_of_type_Beox.a(this);
    this.jdField_a_of_type_Beqz.a(this.jdField_a_of_type_Beox);
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == BaseWriteTogetherMsg.Type.CURSOR_MESSAGE) && ((paramObject instanceof CursorMessageRspMsg)))
    {
      paramType = (CursorMessageRspMsg)paramObject;
      if (paramType.body != null)
      {
        paramType = ((CursorMessageRspMsg.Body)paramType.body).notice;
        if (paramType != null)
        {
          paramObject = paramType.notice;
          if (paramObject != null)
          {
            int i = paramObject.gcp;
            paramType = paramObject.userId;
            paramObject = paramObject.uuId;
            if (QLog.isColorLevel()) {
              QLog.d("EditorController", 2, "[onUpdate] cursor index: " + i + ", uerId: " + paramType + ", uuId: " + paramObject);
            }
            this.jdField_a_of_type_Beow.a(paramType, i, i);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Beqz != null)
    {
      this.jdField_a_of_type_Beqz.b(this.jdField_a_of_type_Beox);
      Pair localPair = this.jdField_a_of_type_Beow.a();
      this.jdField_a_of_type_Beqz.a(paramString);
      this.jdField_a_of_type_Beow.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Beqz.a(this.jdField_a_of_type_Beox);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.jdField_a_of_type_Beow.a().b;
    String str2 = this.jdField_a_of_type_Beow.d();
    paramInt1 = this.jdField_a_of_type_Beow.b();
    EvilReportUtil.EvilReportParams localEvilReportParams = benq.a(paramString, str2, str1, paramInt1, this.jdField_a_of_type_Beow.a().jdField_a_of_type_JavaLangString);
    EvilReportUtil.doEvilReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localEvilReportParams);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onReportDocument] report text: " + paramString + ", report group: " + str2 + ", padId: " + str1 + ", curRev: " + paramInt1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new belh(paramString1, paramString2);
    paramString2 = beli.a(paramString3);
    this.jdField_a_of_type_Beow.a(paramString1);
    this.jdField_a_of_type_Beow.a(paramString2);
    this.jdField_a_of_type_Bemc.a(paramString1, paramString2.a());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramString1, paramBoolean, paramString2);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beqz != null) {
      this.jdField_a_of_type_Beqz.setEditorEnabled(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return !benq.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    ((benm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WRITE_TOGETHER_MANAGER)).b(this);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] start: " + paramInt1 + ", delCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = beog.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] cs: " + paramString1);
    }
    this.jdField_a_of_type_Bemc.a(paramString1);
    this.jdField_a_of_type_Beow.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Beoa != null) {
      this.jdField_a_of_type_Beoa.a(paramString3);
    }
    this.b = true;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Beqz != null)
    {
      this.jdField_a_of_type_Beqz.b(this.jdField_a_of_type_Beox);
      Pair localPair = this.jdField_a_of_type_Beow.a();
      this.jdField_a_of_type_Beqz.b(paramString);
      this.jdField_a_of_type_Beow.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Beqz.a(this.jdField_a_of_type_Beox);
    }
  }
  
  public boolean b()
  {
    belh localbelh = this.jdField_a_of_type_Beow.a();
    return (localbelh != null) && (!TextUtils.isEmpty(localbelh.jdField_a_of_type_JavaLangString)) && (d());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Beqz != null) {
      this.jdField_a_of_type_Beqz.a();
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benz
 * JD-Core Version:    0.7.0.1
 */