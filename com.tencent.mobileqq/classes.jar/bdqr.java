import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class bdqr
  extends bdol
{
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public String ac;
  public String ad;
  public String ae;
  public long c;
  public long d;
  public long e;
  public int o;
  public int p;
  public int q;
  public int r;
  
  public bdqr()
  {
    this.jdField_a_of_type_Int = 14;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public bdqr(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      paramBundle = beyq.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(paramBundle))) {}
    }
    for (paramBundle = ahng.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (paramBundle == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
          }
          return new View(paramContext);
        }
        localObject = new MessageForPic();
        ((MessageForPic)localObject).path = this.ac;
        ((MessageForPic)localObject).uuid = this.ad;
        ((MessageForPic)localObject).md5 = this.ae;
        ((MessageForPic)localObject).istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
        ((MessageForPic)localObject).msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
        ((MessageForPic)localObject).versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
        ((MessageForPic)localObject).uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
        ((MessageForPic)localObject).issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
        ((MessageForPic)localObject).selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
        ((MessageForPic)localObject).frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        ((MessageForPic)localObject).groupFileID = this.c;
        ((MessageForPic)localObject).busiType = 1030;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend != 1) {
          break label469;
        }
      }
      label469:
      for (paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
      {
        ((MessageForPic)localObject).senderuin = paramBundle;
        ((MessageForPic)localObject).size = this.d;
        ((MessageForPic)localObject).time = this.e;
        ((MessageForPic)localObject).subVersion = 5;
        ((MessageForPic)localObject).fileSizeFlag = 0;
        ((MessageForPic)localObject).thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
        ((MessageForPic)localObject).thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
        ((MessageForPic)localObject).rawMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.rawUrl;
        ((MessageForPic)localObject).bigMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.bigUrl;
        ((MessageForPic)localObject).thumbMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbUrl;
        if (a()) {
          ((MessageForPic)localObject).thumbWidthHeightDP = new ThumbWidthHeightDP(this.o, this.p, this.q, this.r, true);
        }
        paramBundle = beqz.a(beyq.a((azqr)localObject, 1, null).toString());
        if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
          ((MessageForPic)localObject).imageType = 2000;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localObject = ahng.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject).getURL();
        if ((paramView == null) || (!(paramView instanceof BubbleImageView))) {
          break;
        }
        paramContext = (BubbleImageView)paramView;
        paramContext.d(false);
        paramContext.setShowEdge(true);
        paramContext.setImageDrawable((Drawable)localObject);
        avlv.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramContext);
        return paramContext;
      }
      paramView = new BubbleImageView(paramContext);
      paramView.setId(2131368523);
      paramView.setAdjustViewBounds(true);
      if (this.q != 0)
      {
        i = agej.a(this.q, paramContext.getResources());
        label522:
        paramView.setMaxWidth(i);
        if (this.r == 0) {
          break label634;
        }
      }
      label634:
      for (int i = agej.a(this.r, paramContext.getResources());; i = besm.a(false))
      {
        paramView.setMaxHeight(i);
        if (this.o != 0) {
          paramView.setMinimumWidth(agej.a(this.o, paramContext.getResources()));
        }
        if (this.p != 0) {
          paramView.setMinimumHeight(agej.a(this.p, paramContext.getResources()));
        }
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(12.0F);
        paramContext = paramView;
        break;
        i = besm.a(false);
        break label522;
      }
    }
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.ac;
    localMessageForPic.uuid = this.ad;
    localMessageForPic.md5 = this.ae;
    localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.c;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.d;
      localMessageForPic.time = this.e;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      localMessageForPic.thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
      localMessageForPic.thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
      return localMessageForPic;
    }
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
    this.ae = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    if (this.jdField_a_of_type_Int > 13)
    {
      this.o = paramObjectInput.readInt();
      this.p = paramObjectInput.readInt();
      this.q = paramObjectInput.readInt();
      this.r = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.ac == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.ad != null) {
        break label147;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.ae != null) {
        break label155;
      }
    }
    label147:
    label155:
    for (String str = "";; str = this.ae)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      if (this.jdField_a_of_type_Int > 13)
      {
        paramObjectOutput.writeInt(this.o);
        paramObjectOutput.writeInt(this.p);
        paramObjectOutput.writeInt(this.q);
        paramObjectOutput.writeInt(this.r);
      }
      return;
      str = this.ac;
      break;
      str = this.ad;
      break label34;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.ad == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.ae != null) {
        break label206;
      }
      str = "";
      label44:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
      if (this.ac != null) {
        break label214;
      }
    }
    label206:
    label214:
    for (String str = "";; str = this.ac)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.attribute(null, "minWidth", Integer.toString(this.o));
      paramXmlSerializer.attribute(null, "minHeight", Integer.toString(this.p));
      paramXmlSerializer.attribute(null, "maxWidth", Integer.toString(this.q));
      paramXmlSerializer.attribute(null, "maxHeight", Integer.toString(this.r));
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.ad;
      break;
      str = this.ae;
      break label44;
    }
  }
  
  public boolean a()
  {
    return (this.o != 0) && (this.p != 0) && (this.q != 0) && (this.r != 0);
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {}
    for (;;)
    {
      return true;
      String str4 = parambdqc.a("uuid");
      String str3 = parambdqc.a("md5");
      String str6 = parambdqc.a("md5");
      String str5 = parambdqc.a("filesize");
      String str2 = parambdqc.a("local_path");
      String str1 = str4;
      if (str4 == null) {
        str1 = "";
      }
      this.ad = str1;
      if (str3 == null)
      {
        str1 = "";
        label76:
        this.ae = str1;
        if (str2 != null) {
          break label193;
        }
        str1 = "";
        this.ac = str1;
        this.o = agej.a(parambdqc, "minWidth");
        this.p = agej.a(parambdqc, "minHeight");
        this.q = agej.a(parambdqc, "maxWidth");
        this.r = agej.a(parambdqc, "maxHeight");
        if (str6 == null) {}
      }
      try
      {
        this.c = Long.parseLong(str6);
        if (str5 == null) {
          continue;
        }
        try
        {
          this.d = Long.parseLong(str5);
          return true;
        }
        catch (NumberFormatException parambdqc) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, parambdqc.getMessage());
        return true;
        str1 = str3;
        break label76;
        label193:
        str1 = str2;
      }
      catch (NumberFormatException parambdqc)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, parambdqc.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqr
 * JD-Core Version:    0.7.0.1
 */