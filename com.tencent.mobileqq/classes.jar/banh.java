import OnlinePushPack.MsgInfo;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogHandler.1;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;

public class banh
{
  private static volatile banh jdField_a_of_type_Banh;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static banh a()
  {
    if (jdField_a_of_type_Banh == null) {}
    try
    {
      if (jdField_a_of_type_Banh == null) {
        jdField_a_of_type_Banh = new banh();
      }
      return jdField_a_of_type_Banh;
    }
    finally {}
  }
  
  private void a(long paramLong1, long paramLong2, submsgtype0x122.MsgBody paramMsgBody)
  {
    paramMsgBody = paramMsgBody.bytes_content.get().toByteArray();
    if (paramMsgBody != null) {}
    Object localObject9;
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject8;
    Object localObject5;
    Object localObject7;
    Object localObject4;
    try
    {
      paramMsgBody = new String(paramMsgBody, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogHandler", 2, new Object[] { "configContent : ", paramMsgBody });
      }
      paramMsgBody = avpe.a(paramMsgBody);
    }
    catch (UnsupportedEncodingException paramMsgBody)
    {
      do
      {
        for (;;)
        {
          QLog.e("PushDialogHandler", 1, "e:", paramMsgBody);
          paramMsgBody = null;
        }
        str = "";
        paramMsgBody = "";
        localObject2 = "";
        localObject1 = "";
        localObject8 = "";
        localObject5 = "";
        localObject7 = "";
        localObject4 = "";
        localObject6 = "";
        localObject3 = "";
        localObject9 = ((avow)localObject9).a();
      } while (localObject9 == null);
      localIterator = ((List)localObject9).iterator();
    }
    if (paramMsgBody != null)
    {
      localObject9 = paramMsgBody.a();
      if (((avow)localObject9).a() != 6) {
        QLog.e("PushDialogHandler", 1, new Object[] { "error note type:", Integer.valueOf(((avow)localObject9).a()) });
      }
    }
    else
    {
      return;
    }
    Object localObject6;
    Object localObject3;
    avow localavow;
    Object localObject15;
    Object localObject10;
    Object localObject12;
    Object localObject11;
    for (;;)
    {
      Iterator localIterator;
      if (localIterator.hasNext())
      {
        localavow = (avow)localIterator.next();
        localObject9 = localavow.a();
        localObject15 = localavow.a();
        if (localavow.a() == 7)
        {
          str = (String)((HashMap)localObject9).get(Integer.valueOf(2));
          localObject9 = localObject6;
          localObject10 = localObject7;
          localObject12 = localObject8;
          localObject7 = localObject2;
          localObject11 = localObject3;
          localObject2 = localObject4;
          localObject4 = localObject5;
          localObject8 = paramMsgBody;
          localObject6 = localObject1;
          localObject5 = localObject12;
          localObject3 = localObject10;
          localObject1 = localObject9;
          paramMsgBody = (submsgtype0x122.MsgBody)localObject11;
          localObject9 = localObject8;
          localObject10 = localObject6;
          localObject11 = localObject7;
          localObject8 = localObject4;
          localObject12 = localObject5;
          localObject7 = localObject3;
          localObject3 = paramMsgBody;
          localObject6 = localObject1;
          localObject4 = localObject2;
          localObject5 = localObject8;
          localObject8 = localObject12;
          localObject1 = localObject10;
          localObject2 = localObject11;
          paramMsgBody = (submsgtype0x122.MsgBody)localObject9;
        }
        else if (localavow.a() == 8)
        {
          localObject9 = (String)((HashMap)localObject9).get(Integer.valueOf(1));
          localObject9 = localObject1;
          localObject10 = localObject2;
          localObject11 = paramMsgBody;
          if (localObject15 != null)
          {
            localObject9 = localObject1;
            localObject10 = localObject2;
            localObject11 = paramMsgBody;
            if (((List)localObject15).size() != 0) {
              localObject12 = ((List)localObject15).iterator();
            }
          }
        }
      }
    }
    label794:
    label1072:
    label1073:
    for (;;)
    {
      label435:
      localObject9 = localObject1;
      localObject10 = localObject2;
      localObject11 = paramMsgBody;
      if (((Iterator)localObject12).hasNext())
      {
        localObject10 = (avow)((Iterator)localObject12).next();
        localObject9 = ((avow)localObject10).a();
        if (((avow)localObject10).a() == 2)
        {
          if (localObject9 == null) {
            continue;
          }
          localObject9 = (String)((HashMap)localObject9).get(Integer.valueOf(2));
          if (TextUtils.isEmpty((CharSequence)localObject9)) {
            break label1072;
          }
          paramMsgBody = (submsgtype0x122.MsgBody)localObject9;
        }
      }
      for (;;)
      {
        break label435;
        if ((((avow)localObject10).a() != 3) || (localObject9 == null)) {
          break label1073;
        }
        localObject2 = (String)((HashMap)localObject9).get(Integer.valueOf(2));
        localObject1 = (String)((HashMap)localObject9).get(Integer.valueOf(4));
        break label435;
        localObject12 = localObject7;
        localObject7 = localObject10;
        localObject1 = localObject6;
        localObject6 = localObject9;
        paramMsgBody = (submsgtype0x122.MsgBody)localObject3;
        localObject2 = localObject4;
        localObject3 = localObject12;
        localObject4 = localObject5;
        localObject5 = localObject8;
        localObject8 = localObject11;
        break;
        Object localObject14 = localObject3;
        Object localObject13 = localObject6;
        localObject12 = localObject4;
        localObject11 = localObject7;
        localObject10 = localObject5;
        localObject9 = localObject8;
        if (localavow.a() == 9)
        {
          localObject14 = localObject3;
          localObject13 = localObject6;
          localObject12 = localObject4;
          localObject11 = localObject7;
          localObject10 = localObject5;
          localObject9 = localObject8;
          if (localObject15 != null)
          {
            localObject15 = ((List)localObject15).iterator();
            int i = 0;
            localObject14 = localObject3;
            localObject13 = localObject6;
            localObject12 = localObject4;
            localObject11 = localObject7;
            localObject10 = localObject5;
            localObject9 = localObject8;
            if (((Iterator)localObject15).hasNext())
            {
              localObject9 = (avow)((Iterator)localObject15).next();
              if (((avow)localObject9).a() == 10)
              {
                localObject9 = ((avow)localObject9).a();
                localObject11 = (String)((HashMap)localObject9).get(Integer.valueOf(2));
                localObject14 = (String)((HashMap)localObject9).get(Integer.valueOf(4));
                if (i == 0)
                {
                  localObject10 = localObject14;
                  localObject13 = localObject11;
                  localObject12 = localObject5;
                  localObject9 = localObject6;
                  i += 1;
                  localObject8 = localObject13;
                  localObject5 = localObject12;
                  localObject4 = localObject10;
                  localObject6 = localObject9;
                }
              }
              for (;;)
              {
                break;
                if (i == 1)
                {
                  localObject9 = localObject14;
                  localObject10 = localObject4;
                  localObject12 = localObject11;
                  localObject13 = localObject8;
                  break label794;
                }
                localObject9 = localObject6;
                localObject10 = localObject4;
                localObject12 = localObject5;
                localObject13 = localObject8;
                if (i != 2) {
                  break label794;
                }
                localObject3 = localObject14;
                localObject7 = localObject11;
                localObject9 = localObject6;
                localObject10 = localObject4;
                localObject12 = localObject5;
                localObject13 = localObject8;
                break label794;
                localObject9 = new Intent();
                ((Intent)localObject9).putExtra("public_fragment_window_feature", 1);
                ((Intent)localObject9).putExtra("BusiType", paramLong2);
                ((Intent)localObject9).putExtra("Title", str);
                ((Intent)localObject9).putExtra("Message", paramMsgBody);
                ((Intent)localObject9).putExtra("contentUrlText", (String)localObject2);
                ((Intent)localObject9).putExtra("contentUrlValue", (String)localObject1);
                ((Intent)localObject9).putExtra("btnText1", (String)localObject8);
                ((Intent)localObject9).putExtra("btnText2", (String)localObject5);
                ((Intent)localObject9).putExtra("btnText3", (String)localObject7);
                ((Intent)localObject9).putExtra("btnAction1", (String)localObject4);
                ((Intent)localObject9).putExtra("btnAction2", (String)localObject6);
                ((Intent)localObject9).putExtra("btnAction3", (String)localObject3);
                afez.a((Intent)localObject9, PublicTransFragmentActivity.class, RiskHintDlgFragment.class);
                return;
              }
            }
          }
        }
        localObject3 = localObject11;
        localObject4 = localObject10;
        localObject5 = localObject9;
        localObject6 = localObject1;
        localObject7 = localObject2;
        localObject8 = paramMsgBody;
        paramMsgBody = (submsgtype0x122.MsgBody)localObject14;
        localObject1 = localObject13;
        localObject2 = localObject12;
        break;
      }
    }
  }
  
  public void a(submsgtype0x122.MsgBody paramMsgBody, MsgInfo paramMsgInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramMsgBody.uint64_busi_type.has()) {
      paramMsgBody.uint64_busi_type.get();
    }
    long l2;
    byte[] arrayOfByte;
    if (paramMsgBody.uint64_busi_id.has())
    {
      l1 = paramMsgBody.uint64_busi_id.get();
      if (paramMsgBody.uint32_ctrl_flag.has()) {
        l2 = paramMsgBody.uint32_ctrl_flag.get();
      }
      if (paramMsgBody.uint32_c2c_type.has()) {
        l2 = paramMsgBody.uint32_c2c_type.get();
      }
      if (paramMsgBody.uint32_service_type.has()) {
        l2 = paramMsgBody.uint32_service_type.get();
      }
      if (!paramMsgBody.bytes_content.has()) {
        break label186;
      }
      arrayOfByte = paramMsgBody.bytes_content.get().toByteArray();
      label119:
      if (!paramMsgBody.uint64_templ_id.has()) {
        break label192;
      }
      l2 = paramMsgBody.uint64_templ_id.get();
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
        break label208;
      }
    }
    for (;;)
    {
      try
      {
        new String(arrayOfByte, "utf-8");
        if (l1 != 1001L) {
          break label225;
        }
        a(l1, l2, paramMsgBody);
        return;
        l1 = 0L;
        break;
        label186:
        arrayOfByte = null;
        break label119;
        label192:
        l2 = 0L;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      label208:
      if (QLog.isColorLevel()) {
        QLog.e("PushDialogHandler", 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
      }
    }
    label225:
    long l1 = paramMsgInfo.getURealMsgTime();
    paramMsgBody = new PushDialogTemplate(paramMsgBody, paramMsgInfo.lFromUin, l1 * 1000L);
    if (a(paramQQAppInterface, paramMsgInfo))
    {
      paramMsgInfo = agdu.a();
      if (paramMsgInfo != null)
      {
        a().post(new PushDialogHandler.1(this, paramMsgInfo, paramMsgBody));
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    banf.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramMsgBody);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a(0).f(String.valueOf(paramMsgInfo.lFromUin), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!paramQQAppInterface.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banh
 * JD-Core Version:    0.7.0.1
 */