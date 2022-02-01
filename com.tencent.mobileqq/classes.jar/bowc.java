import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.editipc.PeakIpcModuleServer.1;
import dov.com.qq.im.editipc.PeakIpcModuleServer.2;
import dov.com.qq.im.editipc.PeakIpcModuleServer.3;
import eipc.EIPCResult;

public class bowc
  extends QIPCModule
{
  private static bowc a;
  
  private bowc(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public static bowc a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	bowc:a	Lbowc;
    //   6: ifnonnull +27 -> 33
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 14	bowc:a	Lbowc;
    //   15: ifnonnull +15 -> 30
    //   18: new 2	bowc
    //   21: dup
    //   22: ldc 16
    //   24: invokespecial 17	bowc:<init>	(Ljava/lang/String;)V
    //   27: putstatic 14	bowc:a	Lbowc;
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 14	bowc:a	Lbowc;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	5	0	localbowc	bowc
    //   42	5	0	localObject1	Object
    //   48	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	30	42	finally
    //   30	33	42	finally
    //   43	46	42	finally
    //   3	12	48	finally
    //   33	37	48	finally
    //   46	48	48	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleServer", 2, "[onCall]action= " + paramString);
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakIpcModuleServer", 2, "[onCall] get app failed.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    Object localObject2;
    boolean bool1;
    if ("action_start_send".equals(paramString))
    {
      paramBundle = (Intent)paramBundle.getParcelable("key_intent");
      if (paramBundle != null)
      {
        paramString = (QQAppInterface)localObject1;
        localObject1 = paramBundle.getStringExtra("thumbfile_send_path");
        localObject2 = paramBundle.getStringExtra("thumbfile_md5");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          ThreadManager.post(new PeakIpcModuleServer.1(this, (String)localObject2, (String)localObject1), 5, null, false);
        }
        localObject1 = bcec.a(3, 0);
        localObject2 = bcec.a(0, paramBundle, (bcev)localObject1);
        ((bceh)localObject2).c = true;
        ((bcev)localObject1).a((bceh)localObject2);
        bcec.a((bcev)localObject1, paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("sendVideo intent= ");
        if (paramBundle != null)
        {
          paramString = paramBundle.getExtras();
          QLog.d("PeakIpcModuleServer", 2, paramString);
        }
      }
      else
      {
        if (paramBundle == null) {
          break label266;
        }
      }
      label266:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("key_result", bool1);
        paramString = EIPCResult.createSuccessResult(localBundle);
        callbackResult(paramInt, paramString);
        return null;
        paramString = "";
        break;
      }
    }
    int i;
    long l2;
    long l1;
    if ("action_cancel_send".equals(paramString))
    {
      localObject2 = paramBundle.getString("uin");
      i = paramBundle.getInt("uintype");
      l2 = paramBundle.getLong("key_uinsequence");
      paramBundle = (QQAppInterface)localObject1;
      localObject1 = paramBundle.a().a((String)localObject2, i, l2);
      paramString = paramBundle.a().a((String)localObject2, l2);
      if (localObject1 != null)
      {
        l1 = ((MessageRecord)localObject1).uniseq;
        label350:
        if ((!(paramString instanceof bdyk)) || (((bdyk)paramString).h)) {
          break label570;
        }
        ((bdyk)paramString).c();
        bool1 = true;
        paramString = "forwardVideo";
      }
    }
    for (;;)
    {
      label380:
      boolean bool3;
      if (bool1)
      {
        bool3 = paramBundle.a().a((String)localObject2 + l2);
        bauy.a(paramBundle, (String)localObject2, l2);
        bool2 = bool3;
        if (localObject1 != null) {
          ThreadManager.post(new PeakIpcModuleServer.2(this, paramBundle, (MessageRecord)localObject1), 8, null, true);
        }
      }
      for (boolean bool2 = bool3;; bool2 = false)
      {
        for (;;)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PeakIpcModuleServer", 2, "cancelInfo, uinseq:" + (String)localObject2 + ", uinType:" + i + ", sequence:" + l2 + ", msgSequence" + l1 + ", cancel:" + bool1 + ", removeProcess:" + bool2 + ", tips:" + paramString);
            }
            localBundle.putBoolean("key_result", bool1);
            paramString = EIPCResult.createSuccessResult(localBundle);
            break;
            l1 = -1L;
            break label350;
            label570:
            if (((paramString instanceof bdth)) && (!((bdth)paramString).b))
            {
              ((bdth)paramString).c();
              bool1 = true;
              paramString = "C2CPic";
              break label380;
            }
            if ((!(paramString instanceof bdvb)) || (((bdvb)paramString).b)) {
              break label1832;
            }
            ((bdvb)paramString).c();
            bool1 = true;
            paramString = "GroupPic";
            break label380;
            Object localObject3;
            if ("action_pic_start_send".equals(paramString))
            {
              paramBundle.setClassLoader(getClass().getClassLoader());
              paramString = paramBundle.getString("key_file_path");
              localObject2 = (SessionInfo)paramBundle.getParcelable("key_session");
              localObject3 = paramBundle.getString("widgetinfo", "");
              paramBundle = paramBundle.getString("key_camera_material_name", "");
              if (!TextUtils.isEmpty(paramString))
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("key_story_photo_to_recent", true);
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localIntent.putExtra("widgetinfo", (String)localObject3);
                  localIntent.putExtra("key_camera_material_name", paramBundle);
                }
                ForwardUtils.a(localIntent, (SessionInfo)localObject2, paramString, (QQAppInterface)localObject1);
                localBundle.putBoolean("key_result", true);
              }
              for (bool1 = true;; bool1 = false)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PeakIpcModuleServer", 2, "sendPic success:" + bool1 + ", photoPath：" + paramString);
                }
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                localBundle.putBoolean("key_result", false);
              }
            }
            if ("action_re_send".equals(paramString))
            {
              localObject2 = paramBundle.getString("uin");
              i = paramBundle.getInt("uintype");
              l1 = paramBundle.getLong("key_uinsequence");
              paramString = (QQAppInterface)localObject1;
              paramBundle = paramString.a().a((String)localObject2, i, l1);
              bool2 = false;
              if ((paramBundle instanceof MessageForShortVideo))
              {
                localObject1 = (MessageForShortVideo)paramBundle;
                if ((bgmg.b(ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg"))) && (!TextUtils.isEmpty(((MessageForShortVideo)localObject1).videoFileName)) && (((MessageForShortVideo)localObject1).isStoryVideo))
                {
                  ((bauy)paramString.getManager(326)).a(((MessageForShortVideo)localObject1).frienduin, (MessageRecord)localObject1, ((MessageForShortVideo)localObject1).videoFileName);
                  localObject1 = bcec.a(4, 0);
                  localObject2 = bcec.a(0, paramBundle, (bcev)localObject1);
                  ((bceh)localObject2).c = true;
                  ((bcev)localObject1).a((bceh)localObject2);
                  bcec.a((bcev)localObject1, paramString);
                  bool1 = true;
                  label1014:
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder().append("reSend success:").append(bool1).append(", message：");
                    if (paramBundle == null) {
                      break label1445;
                    }
                  }
                }
              }
              label1445:
              for (paramString = paramBundle.toString();; paramString = "")
              {
                QLog.d("PeakIpcModuleServer", 2, paramString);
                localBundle.putBoolean("key_result", bool1);
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                ((MessageForShortVideo)localObject1).videoFileStatus = 1005;
                bool1 = false;
                break label1014;
                bool1 = bool2;
                if (!(paramBundle instanceof MessageForPic)) {
                  break label1014;
                }
                localObject1 = (MessageForPic)paramBundle;
                bool1 = bool2;
                if (!bgmg.b(((MessageForPic)localObject1).path)) {
                  break label1014;
                }
                bool1 = bool2;
                if (!((MessageForPic)localObject1).isStoryPhoto) {
                  break label1014;
                }
                ThreadManager.post(new PeakIpcModuleServer.3(this, paramString, (MessageForPic)localObject1), 5, null, false);
                if (((MessageForPic)localObject1).isSendFromLocal()) {
                  paramString.a().a(paramString.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq));
                }
                localObject2 = new ayyh();
                ((ayyh)localObject2).a(((MessageForPic)localObject1).path);
                ((ayyh)localObject2).d(5);
                ((ayyh)localObject2).d(((MessageForPic)localObject1).frienduin);
                if (((MessageForPic)localObject1).fileSizeFlag == 1) {
                  ((ayyh)localObject2).c(bdzh.e);
                }
                for (;;)
                {
                  ((ayyh)localObject2).e(((MessageForPic)localObject1).senderuin);
                  ((ayyh)localObject2).c(((MessageForPic)localObject1).selfuin);
                  ((ayyh)localObject2).e(((MessageForPic)localObject1).istroop);
                  ((ayyh)localObject2).l(((MessageForPic)localObject1).getConfessTopicId());
                  ((ayyh)localObject2).jdField_i_of_type_Int = ((MessageForPic)localObject1).extLong;
                  ((ayyh)localObject2).jdField_i_of_type_JavaLangString = ((MessageForPic)localObject1).extStr;
                  ((ayyh)localObject2).b(true);
                  localObject3 = new ayyi();
                  ((ayyi)localObject3).a = ((MessageForPic)localObject1).msgseq;
                  ((ayyi)localObject3).b = ((MessageForPic)localObject1).shmsgseq;
                  ((ayyi)localObject3).c = ((MessageForPic)localObject1).msgUid;
                  ((ayyh)localObject2).a((ayyi)localObject3);
                  ((ayyh)localObject2).b(((MessageForPic)localObject1).uniseq);
                  ((bauy)paramString.getManager(326)).a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq);
                  localObject3 = ayxn.a(4, 5);
                  ((ayxx)localObject3).a(((ayyh)localObject2).a());
                  ((ayxx)localObject3).a = ((MessageForPic)localObject1).picExtraData;
                  ayxn.a((ayxx)localObject3, paramString);
                  bool1 = true;
                  break;
                  ((ayyh)localObject2).c(bdzh.d);
                }
              }
            }
            if ("action_get_troop_member_name".equals(paramString))
            {
              paramString = paramBundle.getString("troop_uin");
              paramBundle = paramBundle.getString("uin");
              try
              {
                localObject1 = (TroopManager)((QQAppInterface)localObject1).getManager(52);
                paramString = ((TroopManager)localObject1).a(((TroopManager)localObject1).b(paramString), paramBundle);
                localBundle.putBoolean("key_result", true);
                localBundle.putString("uinname", paramString);
                paramString = EIPCResult.createSuccessResult(localBundle);
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PeakIpcModuleServer", 2, "getTroopMemberName exception = " + paramString.getMessage());
                  }
                  paramString.printStackTrace();
                  paramString = "";
                }
              }
            }
          }
          if ("action_get_troop_info".equals(paramString))
          {
            paramString = paramBundle.getString("troop_uin");
            try
            {
              paramBundle = (TroopManager)((QQAppInterface)localObject1).getManager(52);
              paramString = paramBundle.a(paramBundle.b(paramString), true);
              if (paramString != null)
              {
                localBundle.putBoolean("key_result", true);
                localBundle.putBoolean("troop_owner", paramString.isDisband());
                if ((paramString.isNewTroop()) && (!paramString.hasSetTroopHead())) {}
                for (bool1 = true;; bool1 = false)
                {
                  localBundle.putBoolean("troop_code", bool1);
                  paramString = EIPCResult.createSuccessResult(localBundle);
                  return paramString;
                }
              }
            }
            catch (Exception paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_TROOP_INFO exception = " + paramString.getMessage());
              }
              paramString.printStackTrace();
              paramString = null;
            }
          }
        }
        if ("action_get_name".equals(paramString))
        {
          paramString = paramBundle.getString("uin");
          try
          {
            paramString = bglf.b((QQAppInterface)localObject1, paramString);
            localBundle.putBoolean("key_result", true);
            localBundle.putString("uinname", paramString);
            paramString = EIPCResult.createSuccessResult(localBundle);
            return paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_NAME exception = " + paramString.getMessage());
            }
            paramString.printStackTrace();
          }
        }
        paramString = null;
        break;
      }
      label1832:
      paramString = "";
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowc
 * JD-Core Version:    0.7.0.1
 */