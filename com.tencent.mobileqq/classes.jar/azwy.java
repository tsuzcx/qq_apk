import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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

public class azwy
  extends azus
{
  public String S;
  public String T;
  public String U;
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public long c;
  public long d;
  public long e;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public azwy()
  {
    this.jdField_a_of_type_Int = 14;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public azwy(String paramString)
  {
    this();
    this.S = paramString;
  }
  
  private void a(View paramView)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.width;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.height;
    int i3 = aepi.a(this.k, paramView.getResources());
    int i4 = aepi.a(this.l, paramView.getResources());
    int i5 = aepi.a(this.m, paramView.getResources());
    int i6 = aepi.a(this.n, paramView.getResources());
    int i;
    if (i1 < i2)
    {
      if (i1 >= i3) {
        break label363;
      }
      i = (int)(i2 * i3 * 1.0F / i1);
    }
    for (int j = i3;; j = i1)
    {
      if (i2 > i6)
      {
        j = (int)(i1 * i6 * 1.0F / i2);
        i = i6;
      }
      label361:
      for (;;)
      {
        ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new ViewGroup.LayoutParams(j, i);
        }
        localLayoutParams1.width = j;
        localLayoutParams1.height = i;
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, new Object[] { "wClip=", Integer.valueOf(i1), ", hClip=", Integer.valueOf(i2), ", dstW=", Integer.valueOf(j), " dstH=", Integer.valueOf(i), ", thumbMaxHeightPx=", Integer.valueOf(i6), ", thumbMinHeightPx=", Integer.valueOf(i4), "，thumbMaxWidthPx=", Integer.valueOf(i5), ", thumbMinWidthPx=", Integer.valueOf(i3) });
        }
        paramView.setLayoutParams(localLayoutParams1);
        return;
        if (i2 < i4)
        {
          j = (int)(i1 * i4 * 1.0F / i2);
          i = i4;
        }
        for (;;)
        {
          if (i1 <= i5) {
            break label361;
          }
          i = (int)(i2 * i5 * 1.0F / i1);
          j = i5;
          break;
          i = i2;
          j = i1;
        }
      }
      label363:
      i = i2;
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      paramBundle = bayu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(paramBundle))) {}
    }
    for (paramBundle = afwu.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (paramBundle == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
          }
          paramView = new View(paramContext);
          return paramView;
        }
        localObject = new MessageForPic();
        ((MessageForPic)localObject).path = this.S;
        ((MessageForPic)localObject).uuid = this.T;
        ((MessageForPic)localObject).md5 = this.U;
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
          break label477;
        }
      }
      label477:
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
          ((MessageForPic)localObject).thumbWidthHeightDP = new ThumbWidthHeightDP(this.k, this.l, this.m, this.n, true);
        }
        paramBundle = baqn.a(bayu.a((awjs)localObject, 1, null).toString());
        if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
          ((MessageForPic)localObject).imageType = 2000;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        localObject = afwu.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject).getURL();
        if ((paramView == null) || (!(paramView instanceof BubbleImageView))) {
          break label488;
        }
        paramContext = (BubbleImageView)paramView;
        paramContext.d(false);
        paramContext.setShowEdge(true);
        paramContext.setImageDrawable((Drawable)localObject);
        paramView = paramContext;
        if (!a()) {
          break;
        }
        a(paramContext);
        return paramContext;
      }
      label488:
      paramView = new BubbleImageView(paramContext);
      paramView.setId(2131368124);
      paramView.setAdjustViewBounds(true);
      if (this.m != 0)
      {
        i = aepi.a(this.m, paramContext.getResources());
        label530:
        paramView.setMaxWidth(i);
        if (this.n == 0) {
          break label642;
        }
      }
      label642:
      for (int i = aepi.a(this.n, paramContext.getResources());; i = bayu.a(false))
      {
        paramView.setMaxHeight(i);
        if (this.k != 0) {
          paramView.setMinimumWidth(aepi.a(this.k, paramContext.getResources()));
        }
        if (this.l != 0) {
          paramView.setMinimumHeight(aepi.a(this.l, paramContext.getResources()));
        }
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(12.0F);
        paramContext = paramView;
        break;
        i = bayu.a(false);
        break label530;
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
    localMessageForPic.path = this.S;
    localMessageForPic.uuid = this.T;
    localMessageForPic.md5 = this.U;
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
    this.S = paramObjectInput.readUTF();
    this.T = paramObjectInput.readUTF();
    this.U = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    if (this.jdField_a_of_type_Int > 13)
    {
      this.k = paramObjectInput.readInt();
      this.l = paramObjectInput.readInt();
      this.m = paramObjectInput.readInt();
      this.n = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.T != null) {
        break label147;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.U != null) {
        break label155;
      }
    }
    label147:
    label155:
    for (String str = "";; str = this.U)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      if (this.jdField_a_of_type_Int > 13)
      {
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        paramObjectOutput.writeInt(this.m);
        paramObjectOutput.writeInt(this.n);
      }
      return;
      str = this.S;
      break;
      str = this.T;
      break label34;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.T == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.U != null) {
        break label206;
      }
      str = "";
      label44:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
      if (this.S != null) {
        break label214;
      }
    }
    label206:
    label214:
    for (String str = "";; str = this.S)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.attribute(null, "minWidth", Integer.toString(this.k));
      paramXmlSerializer.attribute(null, "minHeight", Integer.toString(this.l));
      paramXmlSerializer.attribute(null, "maxWidth", Integer.toString(this.m));
      paramXmlSerializer.attribute(null, "maxHeight", Integer.toString(this.n));
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.T;
      break;
      str = this.U;
      break label44;
    }
  }
  
  public boolean a()
  {
    return (this.k != 0) && (this.l != 0) && (this.m != 0) && (this.n != 0);
  }
  
  public boolean a(azwj paramazwj)
  {
    if (paramazwj == null) {}
    for (;;)
    {
      return true;
      String str4 = paramazwj.a("uuid");
      String str3 = paramazwj.a("md5");
      String str6 = paramazwj.a("md5");
      String str5 = paramazwj.a("filesize");
      String str2 = paramazwj.a("local_path");
      String str1 = str4;
      if (str4 == null) {
        str1 = "";
      }
      this.T = str1;
      if (str3 == null)
      {
        str1 = "";
        label76:
        this.U = str1;
        if (str2 != null) {
          break label193;
        }
        str1 = "";
        this.S = str1;
        this.k = aepi.a(paramazwj, "minWidth");
        this.l = aepi.a(paramazwj, "minHeight");
        this.m = aepi.a(paramazwj, "maxWidth");
        this.n = aepi.a(paramazwj, "maxHeight");
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
        catch (NumberFormatException paramazwj) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramazwj.getMessage());
        return true;
        str1 = str3;
        break label76;
        label193:
        str1 = str2;
      }
      catch (NumberFormatException paramazwj)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramazwj.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwy
 * JD-Core Version:    0.7.0.1
 */