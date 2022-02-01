import android.text.TextUtils;
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

public class bene
  implements belg, bemm, beng, benv, beod
{
  private int jdField_a_of_type_Int;
  private beli jdField_a_of_type_Beli;
  private bemr jdField_a_of_type_Bemr;
  private benf jdField_a_of_type_Benf;
  private beob jdField_a_of_type_Beob;
  private beoc jdField_a_of_type_Beoc;
  private bepp jdField_a_of_type_Bepp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bene(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Bemr = ((bemr)paramQQAppInterface.getManager(377));
    this.jdField_a_of_type_Bemr.a(this);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    c(paramString1, paramBoolean, paramString2);
  }
  
  private void c(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramString1 != null) {
      this.jdField_a_of_type_Beob.a(paramString1, bemv.a(paramString2), true);
    }
  }
  
  private boolean d()
  {
    return bemv.a(this.jdField_a_of_type_Int);
  }
  
  public List<beog> a()
  {
    if (this.jdField_a_of_type_Beob == null) {
      return null;
    }
    return this.jdField_a_of_type_Beob.a();
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
        String str3 = this.jdField_a_of_type_Beob.a().b;
        int k;
        QLog.e("EditorController", 1, "[sendCursorMessage] current data invalid: ", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = this.jdField_a_of_type_Beob.b();
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
          str2 = this.jdField_a_of_type_Beob.c();
          i = j;
          str4 = str2;
          j = ((Integer)this.jdField_a_of_type_Beob.a().first).intValue();
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
            this.jdField_a_of_type_Bemr.a(new CursorMessageReqMsg(str3, str1, str2, i));
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
    if (this.jdField_a_of_type_Bepp != null) {
      this.jdField_a_of_type_Bepp.setMySelection(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beob != null) {
      this.jdField_a_of_type_Beob.a(paramInt3, paramInt4);
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
    paramString1 = benl.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beli);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextInsert] cs: " + paramString1);
    }
    this.jdField_a_of_type_Beli.a(paramString1);
    this.jdField_a_of_type_Beob.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Benf != null) {
      this.jdField_a_of_type_Benf.a(paramString3);
    }
    this.b = true;
  }
  
  public void a(bekn parambekn)
  {
    if (parambekn != null)
    {
      this.jdField_a_of_type_Beob.a(parambekn);
      b(parambekn.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(beli parambeli)
  {
    this.jdField_a_of_type_Beli = parambeli;
  }
  
  public void a(benf parambenf)
  {
    this.jdField_a_of_type_Benf = parambenf;
  }
  
  public void a(beob parambeob)
  {
    this.jdField_a_of_type_Beob = parambeob;
  }
  
  public void a(bepp parambepp)
  {
    this.jdField_a_of_type_Bepp = parambepp;
    this.jdField_a_of_type_Beoc = new beoc();
    this.jdField_a_of_type_Beoc.a(this);
    this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_Beoc);
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
            this.jdField_a_of_type_Beob.a(paramType, i, i);
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bepp != null)
    {
      this.jdField_a_of_type_Bepp.b(this.jdField_a_of_type_Beoc);
      Pair localPair = this.jdField_a_of_type_Beob.a();
      this.jdField_a_of_type_Bepp.a(paramString);
      this.jdField_a_of_type_Beob.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_Beoc);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString.substring(paramInt1, paramInt2);
    String str1 = this.jdField_a_of_type_Beob.a().b;
    String str2 = this.jdField_a_of_type_Beob.d();
    paramInt1 = this.jdField_a_of_type_Beob.b();
    aamq localaamq = bemv.a(paramString, str2, str1, paramInt1, this.jdField_a_of_type_Beob.a().jdField_a_of_type_JavaLangString);
    aamo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localaamq);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onReportDocument] report text: " + paramString + ", report group: " + str2 + ", padId: " + str1 + ", curRev: " + paramInt1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new bekn(paramString1, paramString2);
    paramString2 = beko.a(paramString3);
    this.jdField_a_of_type_Beob.a(paramString1);
    this.jdField_a_of_type_Beob.a(paramString2);
    this.jdField_a_of_type_Beli.a(paramString1, paramString2.a());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramString1, paramBoolean, paramString2);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bepp != null) {
      this.jdField_a_of_type_Bepp.setEditorEnabled(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return !bemv.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    ((bemr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377)).b(this);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] start: " + paramInt1 + ", delCnt: " + paramInt2 + ", text: " + paramString1);
    }
    paramString1 = benl.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("EditorController", 2, "[onTextDelete] cs: " + paramString1);
    }
    this.jdField_a_of_type_Beli.a(paramString1);
    this.jdField_a_of_type_Beob.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_a_of_type_Benf != null) {
      this.jdField_a_of_type_Benf.a(paramString3);
    }
    this.b = true;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bepp != null)
    {
      this.jdField_a_of_type_Bepp.b(this.jdField_a_of_type_Beoc);
      Pair localPair = this.jdField_a_of_type_Beob.a();
      this.jdField_a_of_type_Bepp.b(paramString);
      this.jdField_a_of_type_Beob.a(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_Beoc);
    }
  }
  
  public boolean b()
  {
    bekn localbekn = this.jdField_a_of_type_Beob.a();
    return (localbekn != null) && (!TextUtils.isEmpty(localbekn.jdField_a_of_type_JavaLangString)) && (d());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bepp != null) {
      this.jdField_a_of_type_Bepp.a();
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bene
 * JD-Core Version:    0.7.0.1
 */