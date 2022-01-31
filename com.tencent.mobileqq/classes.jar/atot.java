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

public class atot
  extends AsyncTask<Void, Void, Void>
{
  final axzn jdField_a_of_type_Axzn = new atou(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<atpw> jdField_a_of_type_JavaUtilArrayList;
  List<atpp> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public atot(QQAppInterface paramQQAppInterface, List<atpp> paramList)
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
    this.jdField_a_of_type_Ator.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ator.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    axyg localaxyg = new axyg();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      atpp localatpp = (atpp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new atpw();
        paramVarArgs.jdField_a_of_type_Atpv = this.jdField_a_of_type_Ator.jdField_a_of_type_Atpv;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      axyp localaxyp = new axyp();
      localaxyp.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localaxyp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localaxyp.jdField_f_of_type_Int = this.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localaxyp.e = this.jdField_a_of_type_Ator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localaxyp.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localaxyp.jdField_c_of_type_Boolean = bool;
        localaxyp.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localatpp.jdField_a_of_type_Atqd.jdField_f_of_type_JavaLangString);
        if (localatpp.jdField_a_of_type_Atqd.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localaxyp.b = bool;
        if (localatpp.jdField_a_of_type_Int == 2) {
          localaxyp.b = true;
        }
        if ((localatpp.jdField_a_of_type_Atqd.j == 0) || (localatpp.jdField_a_of_type_Atqd.k == 0) || (0L == localatpp.jdField_a_of_type_Atqd.c)) {
          break label514;
        }
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localaxyp.jdField_c_of_type_Int = localatpp.jdField_a_of_type_Atqd.j;
        localaxyp.jdField_d_of_type_Int = localatpp.jdField_a_of_type_Atqd.k;
        localaxyp.jdField_a_of_type_Long = localatpp.jdField_a_of_type_Atqd.c;
        label397:
        if ((localaxyp.jdField_f_of_type_Int != 1) && (localaxyp.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localaxyg.jdField_a_of_type_JavaLangString = "grp_pic_up";; localaxyg.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localaxyp.jdField_a_of_type_JavaLangString = localatpp.jdField_a_of_type_Atqd.jdField_f_of_type_JavaLangString;
        localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyp);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bace.b(localatpp.jdField_a_of_type_Atqd.g)) {
          paramVarArgs = localatpp.jdField_a_of_type_Atqd.g;
        }
        for (;;)
        {
          if (!bace.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localaxyp.jdField_c_of_type_Int = localOptions.outWidth;
          localaxyp.jdField_d_of_type_Int = localOptions.outHeight;
          localaxyp.jdField_a_of_type_Long = apdh.a(paramVarArgs);
          break;
          if (localaxyp.b) {}
          for (paramVarArgs = axwd.a(localatpp, 131075, null);; paramVarArgs = axwd.a(localatpp, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = axoa.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localaxyg.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localaxyg.jdField_a_of_type_Axzn = this.jdField_a_of_type_Axzn;
      localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localaxyg.toString());
      axzm.a(localaxyg);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(axyp paramaxyp, axza paramaxza, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      atpp localatpp;
      try
      {
        localatpp = (atpp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramaxza != null)
        {
          localCustomFace.uint32_file_id.set((int)paramaxza.jdField_a_of_type_Long);
          if ((paramaxza.jdField_a_of_type_JavaUtilArrayList != null) && (paramaxza.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramaxza = (axuh)paramaxza.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(axqw.a(paramaxza.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(paramaxza.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (paramaxyp == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramaxyp.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(paramaxyp.jdField_a_of_type_JavaLangString);
          paramaxza = localCustomFace.uint32_origin;
          if (paramaxyp.b)
          {
            i = 1;
            paramaxza.set(i);
            localCustomFace.uint32_width.set(paramaxyp.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(paramaxyp.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)paramaxyp.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localatpp.jdField_a_of_type_Atqd.e);
            localCustomFace.uint32_thumb_height.set(localatpp.jdField_a_of_type_Atqd.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localatpp.jdField_a_of_type_Atqd.m);
            atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception paramaxyp)
      {
        atpg.b(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramaxyp.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localatpp.jdField_a_of_type_Atqd.j);
      localCustomFace.uint32_height.set(localatpp.jdField_a_of_type_Atqd.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(axyp paramaxyp, axyx paramaxyx, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        atpp localatpp = (atpp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramaxyp != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramaxyp.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)paramaxyp.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramaxyp.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(paramaxyp.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(paramaxyp.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramaxyp.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramaxyx != null)
          {
            if (paramaxyx.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramaxyx.b));
            }
            if (paramaxyx.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramaxyx.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localatpp.jdField_a_of_type_Atqd.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localatpp.jdField_a_of_type_Atqd.e);
            localNotOnlineImage.uint32_thumb_height.set(localatpp.jdField_a_of_type_Atqd.jdField_f_of_type_Int);
            atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localatpp.jdField_a_of_type_Atqd.k);
          localNotOnlineImage.pic_width.set(localatpp.jdField_a_of_type_Atqd.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramaxyp)
      {
        atpg.a(this.jdField_a_of_type_Ator.b, this.jdField_a_of_type_Ator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramaxyp.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atot
 * JD-Core Version:    0.7.0.1
 */