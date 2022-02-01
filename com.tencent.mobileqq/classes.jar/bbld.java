import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

class bbld
{
  private long jdField_a_of_type_Long;
  private bdyi jdField_a_of_type_Bdyi;
  private MessageForText.AtTroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<MessageForText.AtTroopMemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private im_msg_body.Elem jdField_a_of_type_TencentImMsgIm_msg_body$Elem;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private MessageForText.AtTroopMemberInfo jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder;
  
  public bbld(StringBuilder paramStringBuilder1, long paramLong, bdyi parambdyi, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo1, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = paramLong;
    this.jdField_a_of_type_Long = ???;
    this.jdField_a_of_type_Bdyi = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramAtTroopMemberInfo1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramAtTroopMemberInfo2;
    this.jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramArrayOfByte;
    this.jdField_a_of_type_ArrayOfByte = paramStringBuilder2;
    this.jdField_b_of_type_JavaLangStringBuilder = paramBoolean;
    this.jdField_a_of_type_Boolean = paramElem;
    Object localObject;
    this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem = localObject;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:NewSysFaceMsg;\n");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Bblb.a((im_msg_body.CommonElem)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.get()));
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    int j = 0;
    int n = PkgTools.getShortData(paramArrayOfByte, 0);
    int i = 2;
    for (;;)
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
      if ((j < n) && (i < 2048))
      {
        localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        if ((j == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = localAtTroopMemberInfo;
        }
        if (localAtTroopMemberInfo.readFrom(paramArrayOfByte, i)) {}
      }
      else
      {
        return;
      }
      int k = i + localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + paramInt));
      int m = (short)(j + 1);
      if (localAtTroopMemberInfo.isIncludingAll()) {
        this.jdField_a_of_type_Bdyi.jdField_a_of_type_Bdyj.b(13, this.jdField_a_of_type_Long);
      }
      j = m;
      i = k;
      if (localAtTroopMemberInfo.isIncludingMe(bblb.a(this.jdField_a_of_type_Bblb).app.getLongAccountUin()))
      {
        this.jdField_a_of_type_Bdyi.jdField_a_of_type_Bdyj.b(24, this.jdField_a_of_type_Long);
        j = m;
        i = k;
        if (localAtTroopMemberInfo != this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo)
        {
          j = m;
          i = k;
          if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)
          {
            j = m;
            i = k;
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo.isIncludingMe(bblb.a(this.jdField_a_of_type_Bblb).app.getLongAccountUin()))
            {
              this.jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = localAtTroopMemberInfo;
              j = m;
              i = k;
            }
          }
        }
      }
    }
  }
  
  @Nullable
  private bbld b()
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:Text;\n");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = this;
    }
    int i;
    do
    {
      return localObject1;
      localObject2 = (im_msg_body.Text)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.text.get();
      i = this.jdField_b_of_type_JavaLangStringBuilder.length();
      if (((im_msg_body.Text)localObject2).str.has())
      {
        localObject1 = bblk.a(((im_msg_body.Text)localObject2).str.get().toStringUtf8(), false);
        this.jdField_b_of_type_JavaLangStringBuilder.append((String)localObject1);
      }
      localObject1 = localObject3;
    } while (!((im_msg_body.Text)localObject2).attr_6_buf.has());
    Object localObject1 = ((im_msg_body.Text)localObject2).attr_6_buf.get();
    if (localObject1 != null) {}
    for (Object localObject2 = ((ByteStringMicro)localObject1).toByteArray();; localObject2 = null)
    {
      if ((this.jdField_a_of_type_Bdyi != null) && ((this.jdField_a_of_type_Bdyi.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Bdyi.jdField_a_of_type_Int == 1)) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (localObject2 != null) && (localObject2.length != 0)) {
        b(i, (byte[])localObject2);
      }
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Bdyi == null) {
        break;
      }
      if ((!this.jdField_a_of_type_Bdyi.jdField_a_of_type_Bdyj.a(24, this.jdField_a_of_type_Long)) && (!this.jdField_a_of_type_Bdyi.jdField_a_of_type_Bdyj.a(13, this.jdField_a_of_type_Long)))
      {
        localObject1 = localObject3;
        if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo != null) {
          break;
        }
      }
      localObject1 = localObject3;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject3;
      if (localObject2.length == 0) {
        break;
      }
      a(i, (byte[])localObject2);
      return null;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:OnlineImage;\n");
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append(BaseApplication.getContext().getString(2131694223));
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = PkgTools.getShortData(paramArrayOfByte, 0);
    int j = 2;
    for (;;)
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
      if ((i < k) && (j < 2048))
      {
        localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        if (localAtTroopMemberInfo.readFrom(paramArrayOfByte, j)) {}
      }
      else
      {
        return;
      }
      j += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + paramInt));
      i = (short)(i + 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localAtTroopMemberInfo);
    }
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType: bankcode_ctrlinfo;\n");
    }
    byte[] arrayOfByte = this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.bankcode_ctrl_info.get().toByteArray();
    int i = arrayOfByte[0];
    int j = arrayOfByte[(arrayOfByte.length - 1)];
    if ((i != 40) || (j != 41)) {
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_JavaLangStringBuilder.append("elemType: bankcode_ctrlinfo buffer error;\n");
      }
    }
    do
    {
      do
      {
        return true;
      } while (ByteBuffer.wrap(arrayOfByte, 2, 2).getShort() != 29786);
      i = ByteBuffer.wrap(arrayOfByte, 4, 2).getShort();
    } while (i <= 0);
    this.jdField_a_of_type_ArrayOfByte = new byte[i];
    System.arraycopy(arrayOfByte, 6, this.jdField_a_of_type_ArrayOfByte, 0, i);
    return false;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:small_emoji;\n");
    }
    if (!((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.has()) {
      return;
    }
    int i = (((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
    int j = ((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.get() & 0xFFFF;
    char[] arrayOfChar = aqyy.a(i, j);
    if ((((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).imageType.get() & 0xFFFF) == 2))
    {
      arrayOfChar[3] = 'ǿ';
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + j);
      }
    }
    this.jdField_b_of_type_JavaLangStringBuilder.append('\024');
    this.jdField_b_of_type_JavaLangStringBuilder.append(arrayOfChar[3]);
    this.jdField_b_of_type_JavaLangStringBuilder.append(arrayOfChar[2]);
    this.jdField_b_of_type_JavaLangStringBuilder.append(arrayOfChar[1]);
    this.jdField_b_of_type_JavaLangStringBuilder.append(arrayOfChar[0]);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:Face;\n");
    }
    if (!((im_msg_body.Face)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.get()).index.has()) {}
    int i;
    do
    {
      return;
      i = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.get()).index.get());
    } while (i < 0);
    this.jdField_b_of_type_JavaLangStringBuilder.append('\024');
    this.jdField_b_of_type_JavaLangStringBuilder.append((char)i);
  }
  
  public bbld a()
  {
    bbld localbbld1;
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.text.has())
    {
      bbld localbbld2 = b();
      localbbld1 = this;
      if (localbbld2 != null) {
        localbbld1 = localbbld2;
      }
    }
    do
    {
      do
      {
        do
        {
          return localbbld1;
          if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.has())
          {
            d();
            return this;
          }
          if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.has())
          {
            c();
            return this;
          }
          if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.online_image.has())
          {
            b();
            return this;
          }
          if (!this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.bankcode_ctrl_info.has()) {
            break;
          }
          localbbld1 = this;
        } while (!b());
        return this;
        localbbld1 = this;
      } while (!this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.has());
      localbbld1 = this;
    } while (33 != this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.uint32_service_type.get());
    a();
    return this;
  }
  
  public MessageForText.AtTroopMemberInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public MessageForText.AtTroopMemberInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbld
 * JD-Core Version:    0.7.0.1
 */