import OnlinePushPack.MsgInfo;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.TemplParam;

public class azur
{
  private static volatile azur jdField_a_of_type_Azur;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static azur a()
  {
    if (jdField_a_of_type_Azur == null) {}
    try
    {
      if (jdField_a_of_type_Azur == null) {
        jdField_a_of_type_Azur = new azur();
      }
      return jdField_a_of_type_Azur;
    }
    finally {}
  }
  
  private void a(long paramLong1, long paramLong2, submsgtype0x122.MsgBody paramMsgBody)
  {
    Object localObject1 = paramMsgBody.bytes_content.get().toByteArray();
    paramMsgBody = paramMsgBody.rpt_msg_templ_param.get();
    if ((paramMsgBody != null) && (paramMsgBody.size() != 0))
    {
      paramMsgBody = ((submsgtype0x122.TemplParam)paramMsgBody.get(0)).bytes_value;
      if (paramMsgBody != null)
      {
        paramMsgBody = paramMsgBody.get().toStringUtf8();
        QLog.d("PushDialogHandler", 1, "get scheme success");
      }
    }
    Object localObject7;
    for (Object localObject12 = paramMsgBody;; localObject12 = "")
    {
      if (localObject1 != null) {}
      try
      {
        paramMsgBody = new String((byte[])localObject1, "utf-8");
        if (QLog.isColorLevel())
        {
          QLog.d("PushDialogHandler", 2, new Object[] { "configContent : ", paramMsgBody });
          QLog.d("PushDialogHandler", 2, new Object[] { "miniAppAction : ", localObject12 });
        }
        paramMsgBody = auxd.a(paramMsgBody);
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
          str1 = "";
          paramMsgBody = "";
          localObject1 = "";
          localObject3 = "";
          localObject5 = "";
          localObject6 = "";
          localObject2 = "";
          localObject4 = "";
          localObject7 = ((auwv)localObject7).a();
        } while (localObject7 == null);
        localIterator1 = ((List)localObject7).iterator();
      }
      if (paramMsgBody != null)
      {
        localObject7 = paramMsgBody.a();
        if (((auwv)localObject7).a() == 6) {
          break label249;
        }
        QLog.e("PushDialogHandler", 1, new Object[] { "error note type:", Integer.valueOf(((auwv)localObject7).a()) });
      }
      return;
      QLog.d("PushDialogHandler", 1, "value is null");
      paramMsgBody = "";
      break;
      QLog.d("PushDialogHandler", 1, "templParams is null or empty");
    }
    label249:
    String str1;
    Object localObject3;
    Object localObject5;
    Object localObject6;
    Object localObject2;
    Object localObject4;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    for (;;)
    {
      Iterator localIterator1;
      if (localIterator1.hasNext())
      {
        localObject8 = (auwv)localIterator1.next();
        localObject9 = ((auwv)localObject8).a();
        localObject7 = ((auwv)localObject8).a();
        if (((auwv)localObject8).a() == 7)
        {
          str1 = (String)((HashMap)localObject9).get(Integer.valueOf(2));
          localObject7 = localObject4;
          localObject8 = localObject2;
          localObject2 = localObject6;
          localObject9 = localObject5;
          localObject6 = paramMsgBody;
          localObject5 = localObject1;
          localObject4 = localObject3;
          localObject3 = localObject9;
          localObject1 = localObject8;
          paramMsgBody = (submsgtype0x122.MsgBody)localObject7;
          localObject7 = localObject6;
          localObject8 = localObject5;
          localObject9 = localObject4;
          localObject6 = localObject2;
          localObject4 = paramMsgBody;
          localObject2 = localObject1;
          localObject5 = localObject3;
          localObject3 = localObject9;
          localObject1 = localObject8;
          paramMsgBody = (submsgtype0x122.MsgBody)localObject7;
        }
        else if (((auwv)localObject8).a() == 8)
        {
          localObject8 = (String)((HashMap)localObject9).get(Integer.valueOf(1));
          if ((localObject7 == null) || (((List)localObject7).size() == 0)) {
            break label1083;
          }
          localObject8 = new SpannableStringBuilder();
          localObject9 = ((List)localObject7).iterator();
          while (((Iterator)localObject9).hasNext())
          {
            localObject7 = (auwv)((Iterator)localObject9).next();
            localObject10 = ((auwv)localObject7).a();
            if ((((auwv)localObject7).a() == 2) && (localObject10 != null))
            {
              localObject7 = (String)((HashMap)localObject10).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject7))
              {
                ((SpannableStringBuilder)localObject8).append(new SpannableString((CharSequence)localObject7));
                paramMsgBody = (submsgtype0x122.MsgBody)localObject7;
              }
            }
          }
        }
      }
    }
    label772:
    label1083:
    for (;;)
    {
      localObject7 = localObject3;
      localObject8 = localObject1;
      localObject9 = paramMsgBody;
      paramMsgBody = (submsgtype0x122.MsgBody)localObject4;
      localObject1 = localObject2;
      localObject2 = localObject6;
      localObject3 = localObject5;
      localObject4 = localObject7;
      localObject5 = localObject8;
      localObject6 = localObject9;
      break;
      if ((((auwv)localObject8).a() == 9) && (localObject7 != null))
      {
        Iterator localIterator2 = ((List)localObject7).iterator();
        int i = 0;
        localObject7 = localObject2;
        localObject8 = localObject4;
        localObject2 = localObject3;
        localObject3 = localObject5;
        localObject4 = localObject6;
        localObject5 = localObject7;
        localObject6 = localObject8;
        if (localIterator2.hasNext())
        {
          localObject7 = (auwv)localIterator2.next();
          String str2;
          Object localObject11;
          if (((auwv)localObject7).a() == 10)
          {
            localObject7 = ((auwv)localObject7).a();
            localObject9 = (String)((HashMap)localObject7).get(Integer.valueOf(2));
            str2 = (String)((HashMap)localObject7).get(Integer.valueOf(4));
            if (i == 0)
            {
              localObject8 = str2;
              localObject11 = localObject9;
              localObject10 = localObject2;
              localObject7 = localObject5;
              i += 1;
              localObject1 = localObject11;
              localObject2 = localObject10;
              localObject4 = localObject8;
              localObject5 = localObject7;
            }
          }
          for (;;)
          {
            break;
            if (i == 1)
            {
              localObject7 = str2;
              localObject8 = localObject4;
              localObject10 = localObject9;
              localObject11 = localObject1;
              break label772;
            }
            localObject7 = localObject5;
            localObject8 = localObject4;
            localObject10 = localObject2;
            localObject11 = localObject1;
            if (i != 2) {
              break label772;
            }
            localObject6 = str2;
            localObject3 = localObject9;
            localObject7 = localObject5;
            localObject8 = localObject4;
            localObject10 = localObject2;
            localObject11 = localObject1;
            break label772;
            localObject7 = new Intent();
            ((Intent)localObject7).putExtra("public_fragment_window_feature", 1);
            ((Intent)localObject7).putExtra("BusiType", paramLong2);
            ((Intent)localObject7).putExtra("Title", str1);
            ((Intent)localObject7).putExtra("Message", paramMsgBody);
            ((Intent)localObject7).putExtra("btnText1", (String)localObject1);
            ((Intent)localObject7).putExtra("btnText2", (String)localObject3);
            ((Intent)localObject7).putExtra("btnText3", (String)localObject5);
            ((Intent)localObject7).putExtra("btnAction1", (String)localObject6);
            ((Intent)localObject7).putExtra("btnAction2", (String)localObject2);
            ((Intent)localObject7).putExtra("btnAction3", (String)localObject4);
            ((Intent)localObject7).putExtra("miniAction", (String)localObject12);
            aevv.a((Intent)localObject7, PublicTransFragmentActivity.class, RiskHintDlgFragment.class);
            return;
          }
        }
        localObject7 = localObject2;
        localObject8 = localObject1;
        localObject9 = paramMsgBody;
        paramMsgBody = (submsgtype0x122.MsgBody)localObject6;
        localObject1 = localObject5;
        localObject2 = localObject4;
        localObject4 = localObject7;
        localObject5 = localObject8;
        localObject6 = localObject9;
        break;
      }
      localObject7 = localObject3;
      localObject8 = localObject1;
      localObject9 = paramMsgBody;
      paramMsgBody = (submsgtype0x122.MsgBody)localObject4;
      localObject1 = localObject2;
      localObject2 = localObject6;
      localObject3 = localObject5;
      localObject4 = localObject7;
      localObject5 = localObject8;
      localObject6 = localObject9;
      break;
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
          break label226;
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
    label226:
    long l1 = paramMsgInfo.getURealMsgTime();
    paramMsgBody = new PushDialogTemplate(paramMsgBody, paramMsgInfo.lFromUin, l1 * 1000L);
    if (a(paramQQAppInterface, paramMsgInfo))
    {
      paramMsgInfo = afuc.a();
      if (paramMsgInfo != null)
      {
        a().post(new PushDialogHandler.1(this, paramMsgInfo, paramMsgBody));
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    azup.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramMsgBody);
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
 * Qualified Name:     azur
 * JD-Core Version:    0.7.0.1
 */