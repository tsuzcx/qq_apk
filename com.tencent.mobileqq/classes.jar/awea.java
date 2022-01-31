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

public class awea
  extends AsyncTask<Void, Void, Void>
{
  final baxv jdField_a_of_type_Baxv = new aweb(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<awfd> jdField_a_of_type_JavaUtilArrayList;
  List<awew> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public awea(QQAppInterface paramQQAppInterface, List<awew> paramList)
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
    this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Awdy.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    bawo localbawo = new bawo();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      awew localawew = (awew)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new awfd();
        paramVarArgs.jdField_a_of_type_Awfc = this.jdField_a_of_type_Awdy.jdField_a_of_type_Awfc;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      bawx localbawx = new bawx();
      localbawx.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localbawx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localbawx.jdField_f_of_type_Int = this.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localbawx.e = this.jdField_a_of_type_Awdy.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localbawx.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localbawx.jdField_c_of_type_Boolean = bool;
        localbawx.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localawew.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString);
        if (localawew.jdField_a_of_type_Awfl.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localbawx.b = bool;
        if (localawew.jdField_a_of_type_Int == 2) {
          localbawx.b = true;
        }
        if ((localawew.jdField_a_of_type_Awfl.j == 0) || (localawew.jdField_a_of_type_Awfl.k == 0) || (0L == localawew.jdField_a_of_type_Awfl.c)) {
          break label514;
        }
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localbawx.jdField_c_of_type_Int = localawew.jdField_a_of_type_Awfl.j;
        localbawx.jdField_d_of_type_Int = localawew.jdField_a_of_type_Awfl.k;
        localbawx.jdField_a_of_type_Long = localawew.jdField_a_of_type_Awfl.c;
        label397:
        if ((localbawx.jdField_f_of_type_Int != 1) && (localbawx.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localbawo.jdField_a_of_type_JavaLangString = "grp_pic_up";; localbawo.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localbawx.jdField_a_of_type_JavaLangString = localawew.jdField_a_of_type_Awfl.jdField_f_of_type_JavaLangString;
        localbawo.jdField_a_of_type_JavaUtilList.add(localbawx);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bdcs.b(localawew.jdField_a_of_type_Awfl.g)) {
          paramVarArgs = localawew.jdField_a_of_type_Awfl.g;
        }
        for (;;)
        {
          if (!bdcs.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localbawx.jdField_c_of_type_Int = localOptions.outWidth;
          localbawx.jdField_d_of_type_Int = localOptions.outHeight;
          localbawx.jdField_a_of_type_Long = arof.a(paramVarArgs);
          break;
          if (localbawx.b) {}
          for (paramVarArgs = baul.a(localawew, 131075, null);; paramVarArgs = baul.a(localawew, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = bame.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localbawo.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localbawo.jdField_a_of_type_Baxv = this.jdField_a_of_type_Baxv;
      localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localbawo.toString());
      baxu.a(localbawo);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(bawx parambawx, baxi parambaxi, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      awew localawew;
      try
      {
        localawew = (awew)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambaxi != null)
        {
          localCustomFace.uint32_file_id.set((int)parambaxi.jdField_a_of_type_Long);
          if ((parambaxi.jdField_a_of_type_JavaUtilArrayList != null) && (parambaxi.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            parambaxi = (basp)parambaxi.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(bapa.a(parambaxi.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(parambaxi.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (parambawx == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(parambawx.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(parambawx.jdField_a_of_type_JavaLangString);
          parambaxi = localCustomFace.uint32_origin;
          if (parambawx.b)
          {
            i = 1;
            parambaxi.set(i);
            localCustomFace.uint32_width.set(parambawx.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(parambawx.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)parambawx.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localawew.jdField_a_of_type_Awfl.e);
            localCustomFace.uint32_thumb_height.set(localawew.jdField_a_of_type_Awfl.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localawew.jdField_a_of_type_Awfl.m);
            awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception parambawx)
      {
        awen.b(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + parambawx.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localawew.jdField_a_of_type_Awfl.j);
      localCustomFace.uint32_height.set(localawew.jdField_a_of_type_Awfl.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(bawx parambawx, baxf parambaxf, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        awew localawew = (awew)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambawx != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(parambawx.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)parambawx.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(parambawx.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(parambawx.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(parambawx.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (parambawx.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (parambaxf != null)
          {
            if (parambaxf.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(parambaxf.b));
            }
            if (parambaxf.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(parambaxf.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localawew.jdField_a_of_type_Awfl.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localawew.jdField_a_of_type_Awfl.e);
            localNotOnlineImage.uint32_thumb_height.set(localawew.jdField_a_of_type_Awfl.jdField_f_of_type_Int);
            awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localawew.jdField_a_of_type_Awfl.k);
          localNotOnlineImage.pic_width.set(localawew.jdField_a_of_type_Awfl.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception parambawx)
      {
        awen.a(this.jdField_a_of_type_Awdy.b, this.jdField_a_of_type_Awdy.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + parambawx.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awea
 * JD-Core Version:    0.7.0.1
 */