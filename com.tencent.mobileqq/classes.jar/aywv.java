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

public class aywv
  extends AsyncTask<Void, Void, Void>
{
  final bedc jdField_a_of_type_Bedc = new ayww(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<ayxy> jdField_a_of_type_JavaUtilArrayList;
  List<ayxr> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public aywv(QQAppInterface paramQQAppInterface, List<ayxr> paramList)
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
    this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aywt.a();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    bebv localbebv = new bebv();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ayxr localayxr = (ayxr)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!this.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new ayxy();
        paramVarArgs.jdField_a_of_type_Ayxx = this.jdField_a_of_type_Aywt.jdField_a_of_type_Ayxx;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      bece localbece = new bece();
      localbece.jdField_c_of_type_JavaLangString = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
      localbece.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localbece.jdField_f_of_type_Int = this.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localbece.e = this.jdField_a_of_type_Aywt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localbece.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localbece.jdField_c_of_type_Boolean = bool;
        localbece.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localayxr.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString);
        if (localayxr.jdField_a_of_type_Ayyg.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localbece.b = bool;
        if (localayxr.jdField_a_of_type_Int == 2) {
          localbece.b = true;
        }
        if ((localayxr.jdField_a_of_type_Ayyg.j == 0) || (localayxr.jdField_a_of_type_Ayyg.k == 0) || (0L == localayxr.jdField_a_of_type_Ayyg.c)) {
          break label514;
        }
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localbece.jdField_c_of_type_Int = localayxr.jdField_a_of_type_Ayyg.j;
        localbece.jdField_d_of_type_Int = localayxr.jdField_a_of_type_Ayyg.k;
        localbece.jdField_a_of_type_Long = localayxr.jdField_a_of_type_Ayyg.c;
        label397:
        if ((localbece.jdField_f_of_type_Int != 1) && (localbece.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localbebv.jdField_a_of_type_JavaLangString = "grp_pic_up";; localbebv.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localbece.jdField_a_of_type_JavaLangString = localayxr.jdField_a_of_type_Ayyg.jdField_f_of_type_JavaLangString;
        localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (bgmg.b(localayxr.jdField_a_of_type_Ayyg.g)) {
          paramVarArgs = localayxr.jdField_a_of_type_Ayyg.g;
        }
        for (;;)
        {
          if (!bgmg.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localbece.jdField_c_of_type_Int = localOptions.outWidth;
          localbece.jdField_d_of_type_Int = localOptions.outHeight;
          localbece.jdField_a_of_type_Long = atwl.a(paramVarArgs);
          break;
          if (localbece.b) {}
          for (paramVarArgs = bdzx.a(localayxr, 131075, null);; paramVarArgs = bdzx.a(localayxr, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = bdsh.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localbebv.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localbebv.jdField_a_of_type_Bedc = this.jdField_a_of_type_Bedc;
      localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getProtoReqManager();
      ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localbebv.toString());
      bedb.a(localbebv);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(bece parambece, becp parambecp, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      ayxr localayxr;
      try
      {
        localayxr = (ayxr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambecp != null)
        {
          localCustomFace.uint32_file_id.set((int)parambecp.jdField_a_of_type_Long);
          if ((parambecp.jdField_a_of_type_JavaUtilArrayList != null) && (parambecp.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            parambecp = (bdyf)parambecp.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(bdvb.a(parambecp.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(parambecp.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a()));
          }
          if (parambece == null) {
            break label451;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(parambece.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(parambece.jdField_a_of_type_JavaLangString);
          parambecp = localCustomFace.uint32_origin;
          if (parambece.b)
          {
            i = 1;
            parambecp.set(i);
            localCustomFace.uint32_width.set(parambece.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(parambece.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)parambece.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localayxr.jdField_a_of_type_Ayyg.e);
            localCustomFace.uint32_thumb_height.set(localayxr.jdField_a_of_type_Ayyg.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localayxr.jdField_a_of_type_Ayyg.m);
            ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
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
      catch (Exception parambece)
      {
        ayxi.b(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + parambece.toString());
        return null;
      }
      continue;
      label451:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localayxr.jdField_a_of_type_Ayyg.j);
      localCustomFace.uint32_height.set(localayxr.jdField_a_of_type_Ayyg.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(bece parambece, becm parambecm, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        ayxr localayxr = (ayxr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (parambece != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(parambece.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)parambece.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(parambece.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(parambece.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(parambece.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (parambece.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (parambecm != null)
          {
            if (parambecm.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(parambecm.b));
            }
            if (parambecm.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(parambecm.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localayxr.jdField_a_of_type_Ayyg.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localayxr.jdField_a_of_type_Ayyg.e);
            localNotOnlineImage.uint32_thumb_height.set(localayxr.jdField_a_of_type_Ayyg.jdField_f_of_type_Int);
            ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localayxr.jdField_a_of_type_Ayyg.k);
          localNotOnlineImage.pic_width.set(localayxr.jdField_a_of_type_Ayyg.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception parambece)
      {
        ayxi.a(this.jdField_a_of_type_Aywt.b, this.jdField_a_of_type_Aywt.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + parambece.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywv
 * JD-Core Version:    0.7.0.1
 */