import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.PluginInfo;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class bbzn
  implements bbzr
{
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1791;
      }
      localObject1 = bgkh.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().find(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().persist((Entity)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.app.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label296:
    label1779:
    label1788:
    label1791:
    for (int i = 1;; i = 0)
    {
      boolean bool1;
      Object localObject3;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject1 = BaseApplication.getContext().getString(2131717874);
        Iterator localIterator = ((List)localObject2).iterator();
        paramBoolean = false;
        localObject2 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject3 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject3).text.has();
          bool3 = ((im_msg_body.Elem)localObject3).not_online_image.has();
          if (!bool3) {
            break label1788;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          String str1;
          if (bool3)
          {
            localObject3 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject3).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject3).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject3).download_path.has()) {
              break label1779;
            }
            str1 = ((im_msg_body.NotOnlineImage)localObject3).download_path.get().toStringUtf8();
            localObject3 = str1;
            if (QLog.isColorLevel()) {
              QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + str1);
            }
          }
          for (localObject3 = str1;; localObject3 = null)
          {
            if (localObject3 != null)
            {
              localObject1 = new RichMsg.PicRec();
              ((RichMsg.PicRec)localObject1).localPath.set((String)localObject3);
              ((RichMsg.PicRec)localObject1).size.set(j);
              ((RichMsg.PicRec)localObject1).type.set(1);
              ((RichMsg.PicRec)localObject1).uuid.set((String)localObject3);
              localObject2 = bdzv.a((String)localObject3, j, 1, false, (String)localObject3);
              if (QLog.isColorLevel()) {
                QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
              }
            }
            for (;;)
            {
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              for (;;)
              {
                break label296;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().remove((Entity)localObject2);
                  paramMessageHandler.a().persist((Entity)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                if (bool2)
                {
                  localObject3 = (im_msg_body.Text)((im_msg_body.Elem)localObject3).text.get();
                  paramMsg = ((im_msg_body.Text)localObject3).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject3).link.has() + ",str:" + ((im_msg_body.Text)localObject3).str.has() + ",strC:" + ((im_msg_body.Text)localObject3).str.get().toStringUtf8());
                    QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject3).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject3).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject3).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject3).custom_face.has())
                {
                  Object localObject5 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject3).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject5).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject5).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject5).str_big_url.get();
                  str1 = ((im_msg_body.CustomFace)localObject5).str_orig_url.get();
                  String str2 = ((im_msg_body.CustomFace)localObject5).str_thumb_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject5).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject5).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject5).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject5).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject5).uint32_useful.get();
                  Object localObject6 = ((im_msg_body.CustomFace)localObject5).bytes_md5.get().toByteArray();
                  Object localObject4 = ((im_msg_body.CustomFace)localObject5).bytes_signature.get().toByteArray();
                  localObject5 = ((im_msg_body.CustomFace)localObject5).bytes_flag.get().toByteArray();
                  localObject6 = bgmj.a((byte[])localObject6);
                  localObject4 = bgmj.a((byte[])localObject4);
                  localObject5 = bgmj.a((byte[])localObject5);
                  if (QLog.isColorLevel()) {
                    QLog.d("AppShareInfoDecoder", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject6 + ",signature:" + (String)localObject4 + ",flag:" + (String)localObject5 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + str1 + ",downURLThum:" + str2);
                  }
                  localObject1 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.app.getCurrentAccountUin();
                  localObject2 = new RichMsg.PicRec();
                  ((RichMsg.PicRec)localObject2).localPath.set((String)localObject1);
                  ((RichMsg.PicRec)localObject2).size.set(0L);
                  ((RichMsg.PicRec)localObject2).type.set(1);
                  ((RichMsg.PicRec)localObject2).uuid.set((String)localObject1);
                  localObject1 = bdzv.a((String)localObject1, 0L, 1, false, (String)localObject1);
                  paramBoolean = true;
                  continue;
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)bbzh.a(-2000);
                    paramMsg.msgtype = -2000;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject2).toByteArray();
                    paramMsg.msg = ((String)localObject1);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    do
                    {
                      return;
                      if ((!paramBoolean) && (bool1))
                      {
                        paramMessageHandler = (MessageForText)bbzh.a(-1000);
                        paramMessageHandler.msgtype = -1000;
                        paramMessageHandler.msg = paramMsg;
                        paramList.add(paramMessageHandler);
                        return;
                      }
                    } while (paramMsg == null);
                    localObject2 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(bgkh.b(l1)));
                    paramMsg = bgjz.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject1 + ",opType:" + paramMsg.b);
                    }
                    localObject2 = bgjz.a((String)localObject1, (String)localObject2, l1, paramMsg.a);
                    if (QLog.isColorLevel()) {
                      QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject1 + ",encodeMsg:" + (String)localObject2);
                    }
                    localObject1 = bbzh.a(paramMsg.b);
                    ((MessageRecord)localObject1).msgtype = paramMsg.b;
                    ((MessageRecord)localObject1).msg = ((String)localObject2);
                    paramList.add(localObject1);
                  }
                }
              }
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
            }
          }
        }
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    if (!paramMsg.appshare_info.has()) {
      return;
    }
    a(paramMessageHandler, paramList, paramMsg, 0L, 0L, parambbyn.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzn
 * JD-Core Version:    0.7.0.1
 */