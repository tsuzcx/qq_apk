import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class azjc
  extends AsyncTask<Void, Void, Void>
{
  final RichProtoProc.RichProtoCallback jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = new azjd(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<azkf> jdField_a_of_type_JavaUtilArrayList;
  List<azjz> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public azjc(QQAppInterface paramQQAppInterface, List<azjz> paramList)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  private String a(im_msg_body.CustomFace paramCustomFace)
  {
    if ((!QLog.isColorLevel()) || (paramCustomFace == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CustomFace]uint32_server_ip:" + paramCustomFace.uint32_server_ip.get());
    localStringBuilder.append(",uint32_server_port:" + paramCustomFace.uint32_server_port.get());
    localStringBuilder.append(",uint32_file_id:" + paramCustomFace.uint32_file_id.get());
    localStringBuilder.append(",bytes_md5:" + HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
    localStringBuilder.append(",str_file_path:" + paramCustomFace.str_file_path.get());
    localStringBuilder.append(",uint32_origin:" + paramCustomFace.uint32_origin.get());
    localStringBuilder.append(",uint32_width:" + paramCustomFace.uint32_width.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",image_type:" + paramCustomFace.image_type.get());
    return localStringBuilder.toString();
  }
  
  private String a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    if ((!QLog.isColorLevel()) || (paramNotOnlineImage == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NotOnlineImage]file_path:" + paramNotOnlineImage.file_path.get().toStringUtf8());
    localStringBuilder.append(",file_len:" + paramNotOnlineImage.file_len.get());
    localStringBuilder.append(",download_path:" + paramNotOnlineImage.download_path.get().toStringUtf8());
    localStringBuilder.append(",res_id:" + paramNotOnlineImage.res_id.get().toStringUtf8());
    localStringBuilder.append(",pic_md5:" + HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
    localStringBuilder.append(",pic_height:" + paramNotOnlineImage.pic_height.get());
    localStringBuilder.append(",pic_width:" + paramNotOnlineImage.pic_width.get());
    localStringBuilder.append(",original:" + paramNotOnlineImage.original.get());
    localStringBuilder.append(",img_type:" + paramNotOnlineImage.img_type.get());
    localStringBuilder.append(",uint32_file_id:" + paramNotOnlineImage.uint32_file_id.get());
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Azja.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Azja.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      azjz localazjz = (azjz)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new azkf();
        paramVarArgs.jdField_a_of_type_Azke = this.jdField_a_of_type_Azja.jdField_a_of_type_Azke;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localPicUpReq.peerUin = this.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localPicUpReq.uinType = this.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localPicUpReq.secondUin = this.jdField_a_of_type_Azja.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localPicUpReq.uinType == 1006)
      {
        bool = true;
        label220:
        localPicUpReq.isContact = bool;
        localPicUpReq.md5 = HexUtil.hexStr2Bytes(localazjz.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString);
        if (localazjz.jdField_a_of_type_Azkn.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localPicUpReq.isRaw = bool;
        if (localazjz.jdField_a_of_type_Int == 2) {
          localPicUpReq.isRaw = true;
        }
        if ((localazjz.jdField_a_of_type_Azkn.j == 0) || (localazjz.jdField_a_of_type_Azkn.k == 0) || (0L == localazjz.jdField_a_of_type_Azkn.c)) {
          break label514;
        }
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localPicUpReq.width = localazjz.jdField_a_of_type_Azkn.j;
        localPicUpReq.height = localazjz.jdField_a_of_type_Azkn.k;
        localPicUpReq.fileSize = localazjz.jdField_a_of_type_Azkn.c;
        label397:
        if ((localPicUpReq.uinType != 1) && (localPicUpReq.uinType != 3000)) {
          break label746;
        }
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localRichProtoReq.protoKey = "grp_pic_up";; localRichProtoReq.protoKey = "c2c_pic_up")
      {
        localPicUpReq.fileName = localazjz.jdField_a_of_type_Azkn.jdField_f_of_type_JavaLangString;
        localRichProtoReq.reqs.add(localPicUpReq);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (FileUtils.fileExistsAndNotEmpty(localazjz.jdField_a_of_type_Azkn.g)) {
          paramVarArgs = localazjz.jdField_a_of_type_Azkn.g;
        }
        for (;;)
        {
          if (!FileUtils.fileExistsAndNotEmpty(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localPicUpReq.width = localOptions.outWidth;
          localPicUpReq.height = localOptions.outHeight;
          localPicUpReq.fileSize = FileUtil.getFileSize(paramVarArgs);
          break;
          if (localPicUpReq.isRaw) {}
          for (paramVarArgs = URLDrawableHelper.getURL(localazjz, 131075, null);; paramVarArgs = URLDrawableHelper.getURL(localazjz, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = AbsDownloader.getFilePath(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localRichProtoReq.reqs.isEmpty())
    {
      localRichProtoReq.callback = this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
      localRichProtoReq.protoReqMgr = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localRichProtoReq.toString());
      RichProtoProc.procRichProtoReq(localRichProtoReq);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      azjz localazjz;
      try
      {
        localazjz = (azjz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramGroupPicUpResp != null)
        {
          localCustomFace.uint32_file_id.set((int)paramGroupPicUpResp.groupFileID);
          if ((paramGroupPicUpResp.mIpList != null) && (paramGroupPicUpResp.mIpList.size() > 0))
          {
            paramGroupPicUpResp = (ServerAddr)paramGroupPicUpResp.mIpList.get(0);
            localCustomFace.uint32_server_ip.set(GroupPicUploadProcessor.ipToLong(paramGroupPicUpResp.mIp));
            localCustomFace.uint32_server_port.set(paramGroupPicUpResp.port);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionKey()));
          }
          if (paramPicUpReq == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
          localCustomFace.str_file_path.set(paramPicUpReq.fileName);
          paramGroupPicUpResp = localCustomFace.uint32_origin;
          if (paramPicUpReq.isRaw)
          {
            i = 1;
            paramGroupPicUpResp.set(i);
            localCustomFace.uint32_width.set(paramPicUpReq.width);
            localCustomFace.uint32_height.set(paramPicUpReq.height);
            localCustomFace.uint32_size.set((int)paramPicUpReq.fileSize);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localazjz.jdField_a_of_type_Azkn.e);
            localCustomFace.uint32_thumb_height.set(localazjz.jdField_a_of_type_Azkn.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localazjz.jdField_a_of_type_Azkn.m);
            azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
            return localCustomFace;
          }
        }
        else
        {
          localCustomFace.uint32_file_id.set(0);
          continue;
        }
        int i = 0;
      }
      catch (Exception paramPicUpReq)
      {
        azjq.b(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramPicUpReq.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localazjz.jdField_a_of_type_Azkn.j);
      localCustomFace.uint32_height.set(localazjz.jdField_a_of_type_Azkn.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        azjz localazjz = (azjz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramPicUpReq != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramPicUpReq.fileName));
          localNotOnlineImage.file_len.set((int)paramPicUpReq.fileSize);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.md5));
          localNotOnlineImage.pic_height.set(paramPicUpReq.height);
          localNotOnlineImage.pic_width.set(paramPicUpReq.width);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramPicUpReq.isRaw) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramC2CPicUpResp != null)
          {
            if (paramC2CPicUpResp.mUuid != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mUuid));
            }
            if (paramC2CPicUpResp.mResid != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.mResid));
            }
            localNotOnlineImage.img_type.set(localazjz.jdField_a_of_type_Azkn.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localazjz.jdField_a_of_type_Azkn.e);
            localNotOnlineImage.uint32_thumb_height.set(localazjz.jdField_a_of_type_Azkn.jdField_f_of_type_Int);
            azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localazjz.jdField_a_of_type_Azkn.k);
          localNotOnlineImage.pic_width.set(localazjz.jdField_a_of_type_Azkn.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramPicUpReq)
      {
        azjq.a(this.jdField_a_of_type_Azja.b, this.jdField_a_of_type_Azja.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramPicUpReq.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjc
 * JD-Core Version:    0.7.0.1
 */