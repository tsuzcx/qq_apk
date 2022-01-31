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

public class aumr
  extends AsyncTask<Void, Void, Void>
{
  final ayzu jdField_a_of_type_Ayzu = new aums(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<aunu> jdField_a_of_type_JavaUtilArrayList;
  List<aunn> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public aumr(QQAppInterface paramQQAppInterface, List<aunn> paramList)
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
    this.jdField_a_of_type_Aump.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aump.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    ayyn localayyn = new ayyn();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aunn localaunn = (aunn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new aunu();
        paramVarArgs.jdField_a_of_type_Aunt = this.jdField_a_of_type_Aump.jdField_a_of_type_Aunt;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      ayyw localayyw = new ayyw();
      localayyw.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localayyw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localayyw.jdField_f_of_type_Int = this.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localayyw.e = this.jdField_a_of_type_Aump.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localayyw.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localayyw.jdField_c_of_type_Boolean = bool;
        localayyw.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localaunn.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString);
        if (localaunn.jdField_a_of_type_Auob.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localayyw.b = bool;
        if (localaunn.jdField_a_of_type_Int == 2) {
          localayyw.b = true;
        }
        if ((localaunn.jdField_a_of_type_Auob.j == 0) || (localaunn.jdField_a_of_type_Auob.k == 0) || (0L == localaunn.jdField_a_of_type_Auob.c)) {
          break label514;
        }
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localayyw.jdField_c_of_type_Int = localaunn.jdField_a_of_type_Auob.j;
        localayyw.jdField_d_of_type_Int = localaunn.jdField_a_of_type_Auob.k;
        localayyw.jdField_a_of_type_Long = localaunn.jdField_a_of_type_Auob.c;
        label397:
        if ((localayyw.jdField_f_of_type_Int != 1) && (localayyw.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localayyn.jdField_a_of_type_JavaLangString = "grp_pic_up";; localayyn.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localayyw.jdField_a_of_type_JavaLangString = localaunn.jdField_a_of_type_Auob.jdField_f_of_type_JavaLangString;
        localayyn.jdField_a_of_type_JavaUtilList.add(localayyw);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bbdj.b(localaunn.jdField_a_of_type_Auob.g)) {
          paramVarArgs = localaunn.jdField_a_of_type_Auob.g;
        }
        for (;;)
        {
          if (!bbdj.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localayyw.jdField_c_of_type_Int = localOptions.outWidth;
          localayyw.jdField_d_of_type_Int = localOptions.outHeight;
          localayyw.jdField_a_of_type_Long = apvb.a(paramVarArgs);
          break;
          if (localayyw.b) {}
          for (paramVarArgs = aywk.a(localaunn, 131075, null);; paramVarArgs = aywk.a(localaunn, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = ayog.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localayyn.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localayyn.jdField_a_of_type_Ayzu = this.jdField_a_of_type_Ayzu;
      localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localayyn.toString());
      ayzt.a(localayyn);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(ayyw paramayyw, ayzh paramayzh, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      aunn localaunn;
      try
      {
        localaunn = (aunn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramayzh != null)
        {
          localCustomFace.uint32_file_id.set((int)paramayzh.jdField_a_of_type_Long);
          if ((paramayzh.jdField_a_of_type_JavaUtilArrayList != null) && (paramayzh.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramayzh = (ayuo)paramayzh.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(ayrd.a(paramayzh.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(paramayzh.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (paramayyw == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramayyw.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(paramayyw.jdField_a_of_type_JavaLangString);
          paramayzh = localCustomFace.uint32_origin;
          if (paramayyw.b)
          {
            i = 1;
            paramayzh.set(i);
            localCustomFace.uint32_width.set(paramayyw.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(paramayyw.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)paramayyw.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localaunn.jdField_a_of_type_Auob.e);
            localCustomFace.uint32_thumb_height.set(localaunn.jdField_a_of_type_Auob.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localaunn.jdField_a_of_type_Auob.m);
            aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception paramayyw)
      {
        aune.b(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramayyw.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localaunn.jdField_a_of_type_Auob.j);
      localCustomFace.uint32_height.set(localaunn.jdField_a_of_type_Auob.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(ayyw paramayyw, ayze paramayze, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        aunn localaunn = (aunn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramayyw != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramayyw.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)paramayyw.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramayyw.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(paramayyw.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(paramayyw.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramayyw.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramayze != null)
          {
            if (paramayze.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramayze.b));
            }
            if (paramayze.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramayze.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localaunn.jdField_a_of_type_Auob.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localaunn.jdField_a_of_type_Auob.e);
            localNotOnlineImage.uint32_thumb_height.set(localaunn.jdField_a_of_type_Auob.jdField_f_of_type_Int);
            aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localaunn.jdField_a_of_type_Auob.k);
          localNotOnlineImage.pic_width.set(localaunn.jdField_a_of_type_Auob.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramayyw)
      {
        aune.a(this.jdField_a_of_type_Aump.b, this.jdField_a_of_type_Aump.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramayyw.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumr
 * JD-Core Version:    0.7.0.1
 */