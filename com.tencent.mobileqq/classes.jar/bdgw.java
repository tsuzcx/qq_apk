import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.EvilReportUtil;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageReqMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.Notice;
import com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.NoticeWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;

public class bdgw
  implements bdex, bdge, bdgy, bdhn, bdhv
{
  private int jdField_a_of_type_Int;
  private bdez jdField_a_of_type_Bdez;
  private bdgj jdField_a_of_type_Bdgj;
  private bdgx jdField_a_of_type_Bdgx;
  private bdht jdField_a_of_type_Bdht;
  private bdhu jdField_a_of_type_Bdhu;
  private bdjw jdField_a_of_type_Bdjw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bdgw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Bdgj = ((bdgj)paramQQAppInterface.getManager(377));
    this.jdField_a_of_type_Bdgj.a(this);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    c(paramString1, paramBoolean, paramString2);
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString1 != null) {
      this.jdField_a_of_type_Bdht.a(paramString1, bdgn.a(paramString2), true);
    }
  }
  
  private boolean d()
  {
    return bdgn.a(this.jdField_a_of_type_Int);
  }
  
  public List<bdhy> a()
  {
    if (this.jdField_a_of_type_Bdht == null) {
      return null;
    }
    return this.jdField_a_of_type_Bdht.a();
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
        String str3 = this.jdField_a_of_type_Bdht.a().b;
        int k;
        QLog.e("EditorController", 1, "[sendCursorMessage] current data invalid: ", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = this.jdField_a_of_type_Bdht.b();
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
          str2 = this.jdField_a_of_type_Bdht.c();
          i = j;
          str4 = str2;
          j = ((Integer)this.jdField_a_of_type_Bdht.a().first).intValue();
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
            this.jdField_a_of_type_Bdgj.a(new CursorMessageReqMsg(str3, str1, str2, i));
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
    if (this.jdField_a_of_type_Bdjw != null) {
      this.jdField_a_of_type_Bdjw.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdht != null) {
      this.jdField_a_of_type_Bdht.a(paramInt3, paramInt4);
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
    paramString1 = bdhd.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdez);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert] cs: " + paramString1);
    }
    this.jdField_a_of_type_Bdez.a(paramString1);
    this.jdField_a_of_type_Bdht.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Bdgx != null) {
      this.jdField_a_of_type_Bdgx.a(paramString3);
    }
    this.b = true;
  }
  
  public void a(bdee parambdee)
  {
    if (parambdee != null)
    {
      this.jdField_a_of_type_Bdht.a(parambdee);
      b(parambdee.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(bdez parambdez)
  {
    this.jdField_a_of_type_Bdez = parambdez;
  }
  
  public void a(bdgx parambdgx)
  {
    this.jdField_a_of_type_Bdgx = parambdgx;
  }
  
  public void a(bdht parambdht)
  {
    this.jdField_a_of_type_Bdht = parambdht;
  }
  
  public void a(bdjw parambdjw)
  {
    this.jdField_a_of_type_Bdjw = parambdjw;
    this.jdField_a_of_type_Bdhu = new bdhu();
    this.jdField_a_of_type_Bdhu.a(this);
    this.jdField_a_of_type_Bdjw.a(this.jdField_a_of_type_Bdhu);
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
            this.jdField_a_of_type_Bdht.a(paramType, i, i);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bdjw != null)
    {
      this.jdField_a_of_type_Bdjw.b(this.jdField_a_of_type_Bdhu);
      Pair localPair = this.jdField_a_of_type_Bdht.a();
      this.jdField_a_of_type_Bdjw.a(paramString);
      this.jdField_a_of_type_Bdht.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Bdjw.a(this.jdField_a_of_type_Bdhu);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.jdField_a_of_type_Bdht.a().b;
    String str2 = this.jdField_a_of_type_Bdht.d();
    paramInt1 = this.jdField_a_of_type_Bdht.b();
    EvilReportUtil.EvilReportParams localEvilReportParams = bdgn.a(paramString, str2, str1, paramInt1, this.jdField_a_of_type_Bdht.a().jdField_a_of_type_JavaLangString);
    EvilReportUtil.doEvilReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localEvilReportParams);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onReportDocument] report text: " + paramString + ", report group: " + str2 + ", padId: " + str1 + ", curRev: " + paramInt1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new bdee(paramString1, paramString2);
    paramString2 = bdef.a(paramString3);
    this.jdField_a_of_type_Bdht.a(paramString1);
    this.jdField_a_of_type_Bdht.a(paramString2);
    this.jdField_a_of_type_Bdez.a(paramString1, paramString2.a());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramString1, paramBoolean, paramString2);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdjw != null) {
      this.jdField_a_of_type_Bdjw.setEditorEnabled(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return !bdgn.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    ((bdgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377)).b(this);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] start: " + paramInt1 + ", delCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = bdhd.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] cs: " + paramString1);
    }
    this.jdField_a_of_type_Bdez.a(paramString1);
    this.jdField_a_of_type_Bdht.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Bdgx != null) {
      this.jdField_a_of_type_Bdgx.a(paramString3);
    }
    this.b = true;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bdjw != null)
    {
      this.jdField_a_of_type_Bdjw.b(this.jdField_a_of_type_Bdhu);
      Pair localPair = this.jdField_a_of_type_Bdht.a();
      this.jdField_a_of_type_Bdjw.b(paramString);
      this.jdField_a_of_type_Bdht.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Bdjw.a(this.jdField_a_of_type_Bdhu);
    }
  }
  
  public boolean b()
  {
    bdee localbdee = this.jdField_a_of_type_Bdht.a();
    return (localbdee != null) && (!TextUtils.isEmpty(localbdee.jdField_a_of_type_JavaLangString)) && (d());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bdjw != null) {
      this.jdField_a_of_type_Bdjw.a();
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgw
 * JD-Core Version:    0.7.0.1
 */