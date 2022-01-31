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

public class aumt
  extends AsyncTask<Void, Void, Void>
{
  final ayzw jdField_a_of_type_Ayzw = new aumu(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<aunw> jdField_a_of_type_JavaUtilArrayList;
  List<aunp> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public aumt(QQAppInterface paramQQAppInterface, List<aunp> paramList)
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
    this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aumr.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    ayyp localayyp = new ayyp();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aunp localaunp = (aunp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new aunw();
        paramVarArgs.jdField_a_of_type_Aunv = this.jdField_a_of_type_Aumr.jdField_a_of_type_Aunv;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      ayyy localayyy = new ayyy();
      localayyy.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localayyy.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localayyy.jdField_f_of_type_Int = this.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localayyy.e = this.jdField_a_of_type_Aumr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localayyy.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localayyy.jdField_c_of_type_Boolean = bool;
        localayyy.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localaunp.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString);
        if (localaunp.jdField_a_of_type_Auod.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localayyy.b = bool;
        if (localaunp.jdField_a_of_type_Int == 2) {
          localayyy.b = true;
        }
        if ((localaunp.jdField_a_of_type_Auod.j == 0) || (localaunp.jdField_a_of_type_Auod.k == 0) || (0L == localaunp.jdField_a_of_type_Auod.c)) {
          break label514;
        }
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localayyy.jdField_c_of_type_Int = localaunp.jdField_a_of_type_Auod.j;
        localayyy.jdField_d_of_type_Int = localaunp.jdField_a_of_type_Auod.k;
        localayyy.jdField_a_of_type_Long = localaunp.jdField_a_of_type_Auod.c;
        label397:
        if ((localayyy.jdField_f_of_type_Int != 1) && (localayyy.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localayyp.jdField_a_of_type_JavaLangString = "grp_pic_up";; localayyp.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localayyy.jdField_a_of_type_JavaLangString = localaunp.jdField_a_of_type_Auod.jdField_f_of_type_JavaLangString;
        localayyp.jdField_a_of_type_JavaUtilList.add(localayyy);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bbdx.b(localaunp.jdField_a_of_type_Auod.g)) {
          paramVarArgs = localaunp.jdField_a_of_type_Auod.g;
        }
        for (;;)
        {
          if (!bbdx.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localayyy.jdField_c_of_type_Int = localOptions.outWidth;
          localayyy.jdField_d_of_type_Int = localOptions.outHeight;
          localayyy.jdField_a_of_type_Long = apvd.a(paramVarArgs);
          break;
          if (localayyy.b) {}
          for (paramVarArgs = aywm.a(localaunp, 131075, null);; paramVarArgs = aywm.a(localaunp, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = ayoi.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localayyp.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localayyp.jdField_a_of_type_Ayzw = this.jdField_a_of_type_Ayzw;
      localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localayyp.toString());
      ayzv.a(localayyp);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(ayyy paramayyy, ayzj paramayzj, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      aunp localaunp;
      try
      {
        localaunp = (aunp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramayzj != null)
        {
          localCustomFace.uint32_file_id.set((int)paramayzj.jdField_a_of_type_Long);
          if ((paramayzj.jdField_a_of_type_JavaUtilArrayList != null) && (paramayzj.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramayzj = (ayuq)paramayzj.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(ayrf.a(paramayzj.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(paramayzj.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (paramayyy == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(paramayyy.jdField_a_of_type_JavaLangString);
          paramayzj = localCustomFace.uint32_origin;
          if (paramayyy.b)
          {
            i = 1;
            paramayzj.set(i);
            localCustomFace.uint32_width.set(paramayyy.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(paramayyy.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)paramayyy.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localaunp.jdField_a_of_type_Auod.e);
            localCustomFace.uint32_thumb_height.set(localaunp.jdField_a_of_type_Auod.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localaunp.jdField_a_of_type_Auod.m);
            aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception paramayyy)
      {
        aung.b(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramayyy.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localaunp.jdField_a_of_type_Auod.j);
      localCustomFace.uint32_height.set(localaunp.jdField_a_of_type_Auod.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(ayyy paramayyy, ayzg paramayzg, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        aunp localaunp = (aunp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramayyy != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramayyy.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)paramayyy.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(paramayyy.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(paramayyy.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramayyy.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramayzg != null)
          {
            if (paramayzg.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramayzg.b));
            }
            if (paramayzg.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramayzg.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localaunp.jdField_a_of_type_Auod.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localaunp.jdField_a_of_type_Auod.e);
            localNotOnlineImage.uint32_thumb_height.set(localaunp.jdField_a_of_type_Auod.jdField_f_of_type_Int);
            aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localaunp.jdField_a_of_type_Auod.k);
          localNotOnlineImage.pic_width.set(localaunp.jdField_a_of_type_Auod.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramayyy)
      {
        aung.a(this.jdField_a_of_type_Aumr.b, this.jdField_a_of_type_Aumr.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramayyy.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumt
 * JD-Core Version:    0.7.0.1
 */