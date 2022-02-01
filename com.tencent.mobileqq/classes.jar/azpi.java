import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class azpi
  extends AsyncTask<Void, Void, Void>
{
  final bfcb jdField_a_of_type_Bfcb = new azpj(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<azql> jdField_a_of_type_JavaUtilArrayList;
  List<azqf> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public azpi(QQAppInterface paramQQAppInterface, List<azqf> paramList)
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
    this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Azpg.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    bfau localbfau = new bfau();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      azqf localazqf = (azqf)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new azql();
        paramVarArgs.jdField_a_of_type_Azqk = this.jdField_a_of_type_Azpg.jdField_a_of_type_Azqk;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      bfbd localbfbd = new bfbd();
      localbfbd.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localbfbd.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localbfbd.jdField_f_of_type_Int = this.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localbfbd.e = this.jdField_a_of_type_Azpg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localbfbd.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localbfbd.jdField_c_of_type_Boolean = bool;
        localbfbd.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localazqf.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString);
        if (localazqf.jdField_a_of_type_Azqt.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localbfbd.b = bool;
        if (localazqf.jdField_a_of_type_Int == 2) {
          localbfbd.b = true;
        }
        if ((localazqf.jdField_a_of_type_Azqt.j == 0) || (localazqf.jdField_a_of_type_Azqt.k == 0) || (0L == localazqf.jdField_a_of_type_Azqt.c)) {
          break label514;
        }
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localbfbd.jdField_c_of_type_Int = localazqf.jdField_a_of_type_Azqt.j;
        localbfbd.jdField_d_of_type_Int = localazqf.jdField_a_of_type_Azqt.k;
        localbfbd.jdField_a_of_type_Long = localazqf.jdField_a_of_type_Azqt.c;
        label397:
        if ((localbfbd.jdField_f_of_type_Int != 1) && (localbfbd.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localbfau.jdField_a_of_type_JavaLangString = "grp_pic_up";; localbfau.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localbfbd.jdField_a_of_type_JavaLangString = localazqf.jdField_a_of_type_Azqt.jdField_f_of_type_JavaLangString;
        localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bhmi.b(localazqf.jdField_a_of_type_Azqt.g)) {
          paramVarArgs = localazqf.jdField_a_of_type_Azqt.g;
        }
        for (;;)
        {
          if (!bhmi.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localbfbd.jdField_c_of_type_Int = localOptions.outWidth;
          localbfbd.jdField_d_of_type_Int = localOptions.outHeight;
          localbfbd.jdField_a_of_type_Long = auog.a(paramVarArgs);
          break;
          if (localbfbd.b) {}
          for (paramVarArgs = beyq.a(localazqf, 131075, null);; paramVarArgs = beyq.a(localazqf, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = beqz.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localbfau.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localbfau.jdField_a_of_type_Bfcb = this.jdField_a_of_type_Bfcb;
      localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localbfau.toString());
      bfca.a(localbfau);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(bfbd parambfbd, bfbo parambfbo, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      azqf localazqf;
      try
      {
        localazqf = (azqf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambfbo != null)
        {
          localCustomFace.uint32_file_id.set((int)parambfbo.jdField_a_of_type_Long);
          if ((parambfbo.jdField_a_of_type_JavaUtilArrayList != null) && (parambfbo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            parambfbo = (bewy)parambfbo.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(betv.a(parambfbo.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(parambfbo.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (parambfbd == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(parambfbd.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(parambfbd.jdField_a_of_type_JavaLangString);
          parambfbo = localCustomFace.uint32_origin;
          if (parambfbd.b)
          {
            i = 1;
            parambfbo.set(i);
            localCustomFace.uint32_width.set(parambfbd.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(parambfbd.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)parambfbd.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localazqf.jdField_a_of_type_Azqt.e);
            localCustomFace.uint32_thumb_height.set(localazqf.jdField_a_of_type_Azqt.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localazqf.jdField_a_of_type_Azqt.m);
            azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception parambfbd)
      {
        azpw.b(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + parambfbd.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localazqf.jdField_a_of_type_Azqt.j);
      localCustomFace.uint32_height.set(localazqf.jdField_a_of_type_Azqt.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(bfbd parambfbd, bfbl parambfbl, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        azqf localazqf = (azqf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambfbd != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(parambfbd.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)parambfbd.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(parambfbd.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(parambfbd.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(parambfbd.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (parambfbd.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (parambfbl != null)
          {
            if (parambfbl.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(parambfbl.b));
            }
            if (parambfbl.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(parambfbl.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localazqf.jdField_a_of_type_Azqt.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localazqf.jdField_a_of_type_Azqt.e);
            localNotOnlineImage.uint32_thumb_height.set(localazqf.jdField_a_of_type_Azqt.jdField_f_of_type_Int);
            azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localazqf.jdField_a_of_type_Azqt.k);
          localNotOnlineImage.pic_width.set(localazqf.jdField_a_of_type_Azqt.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception parambfbd)
      {
        azpw.a(this.jdField_a_of_type_Azpg.b, this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + parambfbd.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpi
 * JD-Core Version:    0.7.0.1
 */