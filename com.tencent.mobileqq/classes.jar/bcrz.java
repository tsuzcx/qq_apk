import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

class bcrz
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<MessageForText.AtTroopMemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private im_msg_body.RichText jdField_a_of_type_TencentImMsgIm_msg_body$RichText;
  private int b;
  private int c;
  
  public bcrz(im_msg_body.RichText paramRichText, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = paramRichText;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder;
    this.c = paramInt3;
  }
  
  @Nullable
  private MessageForText.AtTroopMemberInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      while (this.b < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.b);
        if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid())) {
          return localAtTroopMemberInfo;
        }
        this.b += 1;
      }
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
    {
      localObject1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      bcrx.a(this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject1);
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
      this.jdField_a_of_type_Int += 1;
    }
    int j = this.jdField_a_of_type_JavaLangString.charAt(this.c + 1);
    int i = j;
    if (j == 250) {
      i = 10;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + i);
    }
    Object localObject3;
    if (QQSysFaceUtil.isValidFaceId(i))
    {
      j = QQSysFaceUtil.convertToServer(i);
      if (j >= 260)
      {
        localObject1 = new hummer_commelem.MsgElemInfo_servtype33();
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).uint32_index.set(j);
        localObject3 = QQSysFaceUtil.getFaceDescription(i);
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).bytes_text.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).bytes_compat.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        localObject3 = new im_msg_body.CommonElem();
        ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(33);
        ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(1);
        ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype33)localObject1).toByteArray()));
        localObject1 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject3);
        this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject1);
        this.jdField_a_of_type_Int += 1;
        this.c += 1;
      }
    }
    while (this.c + 4 >= this.jdField_a_of_type_JavaLangString.length()) {
      for (;;)
      {
        return;
        localObject1 = new im_msg_body.Face();
        ((im_msg_body.Face)localObject1).index.set(j);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).face.set((MessageMicro)localObject1);
        this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject3);
      }
    }
    Object localObject4 = new char[4];
    localObject4[3] = this.jdField_a_of_type_JavaLangString.charAt(this.c + 1);
    localObject4[2] = this.jdField_a_of_type_JavaLangString.charAt(this.c + 2);
    localObject4[1] = this.jdField_a_of_type_JavaLangString.charAt(this.c + 3);
    localObject4[0] = this.jdField_a_of_type_JavaLangString.charAt(this.c + 4);
    i = 0;
    if (i < 4)
    {
      if (localObject4[i] == 'ú') {
        localObject4[i] = 10;
      }
      for (;;)
      {
        i += 1;
        break;
        if (localObject4[i] == 'þ') {
          localObject4[i] = 13;
        }
      }
    }
    int[] arrayOfInt = asdi.a((char[])localObject4);
    Object localObject1 = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject1);
        localObject3 = QQText.SMALL_EMOJI_SYMBOL;
        if (localObject1 != null)
        {
          localObject1 = (awyr)((AppInterface)localObject1).getManager(QQManagerFactory.EMOTICON_MANAGER);
          if (localObject1 == null) {
            break label840;
          }
          localObject1 = ((awyr)localObject1).a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
          if (localObject1 != null)
          {
            localObject1 = ((Emoticon)localObject1).character;
            i = arrayOfInt[0];
            j = arrayOfInt[1];
            localObject3 = new im_msg_body.SmallEmoji();
            ((im_msg_body.SmallEmoji)localObject3).packIdSum.set((i << 16) + j);
            if (localObject4[3] == 'ÿ')
            {
              ((im_msg_body.SmallEmoji)localObject3).imageType.set(1);
              localObject4 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject4).small_emoji.set((MessageMicro)localObject3);
              this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject4);
              this.jdField_a_of_type_Int += 1;
              localObject3 = new im_msg_body.Text();
              ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
              localObject1 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
              this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject1);
              this.jdField_a_of_type_Int += 1;
              this.c += 4;
              return;
              i = 0;
            }
          }
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "[AccountNotMatchException]," + localAccountNotMatchException.getMessage());
          }
          Object localObject2 = null;
          continue;
          if (localObject4[3] == 'ǿ')
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "send apng epid = " + arrayOfInt[0] + " eid = " + arrayOfInt[1]);
            }
            ((im_msg_body.SmallEmoji)localObject3).imageType.set(2);
            continue;
            localObject2 = localObject3;
            continue;
            label840:
            localObject2 = null;
          }
        }
      }
    }
  }
  
  private void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo)
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
    {
      localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      bcrx.a(this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject);
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
      this.jdField_a_of_type_Int += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString.substring(paramAtTroopMemberInfo.startPos, paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen);
    localObject = bcrx.a(this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject);
    this.b += 1;
    short s = paramAtTroopMemberInfo.startPos;
    paramAtTroopMemberInfo.startPos = 0;
    a(paramAtTroopMemberInfo, (im_msg_body.Elem)localObject);
    paramAtTroopMemberInfo.startPos = s;
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_Int += 1;
    this.c += paramAtTroopMemberInfo.textLen - 1;
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.Word2Byte(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bcrz a()
  {
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = a();
    if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.startPos <= this.c))
    {
      a(localAtTroopMemberInfo);
      return this;
    }
    if ((this.jdField_a_of_type_JavaLangString.charAt(this.c) == '\024') && (this.c + 1 < this.jdField_a_of_type_JavaLangString.length()))
    {
      a();
      return this;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString.charAt(this.c));
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrz
 * JD-Core Version:    0.7.0.1
 */