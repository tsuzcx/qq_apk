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

public class awij
  extends AsyncTask<Void, Void, Void>
{
  final bbce jdField_a_of_type_Bbce = new awik(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<awjm> jdField_a_of_type_JavaUtilArrayList;
  List<awjf> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public awij(QQAppInterface paramQQAppInterface, List<awjf> paramList)
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
    this.jdField_a_of_type_Awih.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Awih.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    bbax localbbax = new bbax();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      awjf localawjf = (awjf)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new awjm();
        paramVarArgs.jdField_a_of_type_Awjl = this.jdField_a_of_type_Awih.jdField_a_of_type_Awjl;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      bbbg localbbbg = new bbbg();
      localbbbg.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localbbbg.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localbbbg.jdField_f_of_type_Int = this.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localbbbg.e = this.jdField_a_of_type_Awih.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localbbbg.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localbbbg.jdField_c_of_type_Boolean = bool;
        localbbbg.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localawjf.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString);
        if (localawjf.jdField_a_of_type_Awju.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localbbbg.b = bool;
        if (localawjf.jdField_a_of_type_Int == 2) {
          localbbbg.b = true;
        }
        if ((localawjf.jdField_a_of_type_Awju.j == 0) || (localawjf.jdField_a_of_type_Awju.k == 0) || (0L == localawjf.jdField_a_of_type_Awju.c)) {
          break label514;
        }
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localbbbg.jdField_c_of_type_Int = localawjf.jdField_a_of_type_Awju.j;
        localbbbg.jdField_d_of_type_Int = localawjf.jdField_a_of_type_Awju.k;
        localbbbg.jdField_a_of_type_Long = localawjf.jdField_a_of_type_Awju.c;
        label397:
        if ((localbbbg.jdField_f_of_type_Int != 1) && (localbbbg.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localbbax.jdField_a_of_type_JavaLangString = "grp_pic_up";; localbbax.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localbbbg.jdField_a_of_type_JavaLangString = localawjf.jdField_a_of_type_Awju.jdField_f_of_type_JavaLangString;
        localbbax.jdField_a_of_type_JavaUtilList.add(localbbbg);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bdhb.b(localawjf.jdField_a_of_type_Awju.g)) {
          paramVarArgs = localawjf.jdField_a_of_type_Awju.g;
        }
        for (;;)
        {
          if (!bdhb.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localbbbg.jdField_c_of_type_Int = localOptions.outWidth;
          localbbbg.jdField_d_of_type_Int = localOptions.outHeight;
          localbbbg.jdField_a_of_type_Long = arso.a(paramVarArgs);
          break;
          if (localbbbg.b) {}
          for (paramVarArgs = bayu.a(localawjf, 131075, null);; paramVarArgs = bayu.a(localawjf, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = baqn.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localbbax.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localbbax.jdField_a_of_type_Bbce = this.jdField_a_of_type_Bbce;
      localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localbbax.toString());
      bbcd.a(localbbax);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(bbbg parambbbg, bbbr parambbbr, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      awjf localawjf;
      try
      {
        localawjf = (awjf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambbbr != null)
        {
          localCustomFace.uint32_file_id.set((int)parambbbr.jdField_a_of_type_Long);
          if ((parambbbr.jdField_a_of_type_JavaUtilArrayList != null) && (parambbbr.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            parambbbr = (bawy)parambbbr.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(batj.a(parambbbr.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(parambbbr.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (parambbbg == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(parambbbg.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(parambbbg.jdField_a_of_type_JavaLangString);
          parambbbr = localCustomFace.uint32_origin;
          if (parambbbg.b)
          {
            i = 1;
            parambbbr.set(i);
            localCustomFace.uint32_width.set(parambbbg.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(parambbbg.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)parambbbg.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localawjf.jdField_a_of_type_Awju.e);
            localCustomFace.uint32_thumb_height.set(localawjf.jdField_a_of_type_Awju.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localawjf.jdField_a_of_type_Awju.m);
            awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception parambbbg)
      {
        awiw.b(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + parambbbg.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localawjf.jdField_a_of_type_Awju.j);
      localCustomFace.uint32_height.set(localawjf.jdField_a_of_type_Awju.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(bbbg parambbbg, bbbo parambbbo, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        awjf localawjf = (awjf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambbbg != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(parambbbg.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)parambbbg.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(parambbbg.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(parambbbg.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(parambbbg.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (parambbbg.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (parambbbo != null)
          {
            if (parambbbo.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(parambbbo.b));
            }
            if (parambbbo.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(parambbbo.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localawjf.jdField_a_of_type_Awju.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localawjf.jdField_a_of_type_Awju.e);
            localNotOnlineImage.uint32_thumb_height.set(localawjf.jdField_a_of_type_Awju.jdField_f_of_type_Int);
            awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localawjf.jdField_a_of_type_Awju.k);
          localNotOnlineImage.pic_width.set(localawjf.jdField_a_of_type_Awju.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception parambbbg)
      {
        awiw.a(this.jdField_a_of_type_Awih.b, this.jdField_a_of_type_Awih.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + parambbbg.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awij
 * JD-Core Version:    0.7.0.1
 */