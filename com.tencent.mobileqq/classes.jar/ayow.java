import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class ayow
  extends aype
  implements Handler.Callback, awap
{
  Handler a;
  protected aumn a;
  
  public ayow(ayox paramayox, aywa paramaywa)
  {
    super(paramayox, paramaywa);
    this.jdField_a_of_type_AndroidOsHandler = new bfnk(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aumn = aumm.a(paramaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramaywa);
  }
  
  private void r()
  {
    if (b())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "handleQuickSendFailed:" + a());
      }
      aywk.a(a(), 65537, null, null).downloadImediatly();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aumn != null) {
      r();
    }
    return super.a();
  }
  
  protected int a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (advu.a(paramMessageForPic)) {
      i = 5;
    }
    for (;;)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "getPicSourceReport:" + this.jdField_a_of_type_Aywa.e + " source:" + i);
      }
      return i;
      switch (this.jdField_a_of_type_Aywa.e)
      {
      default: 
        break;
      case 1009: 
      case 1031: 
      case 1048: 
        i = 4;
        break;
      case 1052: 
        i = 2;
        break;
      case 1050: 
        i = 1;
        break;
      case 1051: 
        i = 3;
        break;
      case 1053: 
        i = 7;
      }
    }
  }
  
  protected MessageForPic a()
  {
    Object localObject = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject instanceof MessageForPic)) {
      localObject = (MessageForPic)localObject;
    }
    MessageForPic localMessageForPic;
    do
    {
      return localObject;
      if (!(localObject instanceof MessageForStructing)) {
        break;
      }
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break;
      }
      localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
      if (localObject == null) {
        break;
      }
      localMessageForPic = ((axwt)localObject).a;
      localObject = localMessageForPic;
    } while (localMessageForPic != null);
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, aypb paramaypb)
  {
    super.a(paramInt, paramString1, paramString2, paramaypb);
    ayxb.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramInt, paramString1, paramString2);
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  protected void a(ayyw paramayyw)
  {
    if ((this.jdField_a_of_type_Aumn != null) && (!this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "changeRequest,file Size:" + paramayyw.jdField_a_of_type_Long + " md5:" + paramayyw.jdField_a_of_type_ArrayOfByte + " busiType:" + this.jdField_a_of_type_Aywa.e + " quickSendObject:" + this.jdField_a_of_type_Aumn);
      }
      paramayyw.jdField_a_of_type_Long = this.jdField_a_of_type_Aumn.jdField_a_of_type_Long;
      paramayyw.jdField_a_of_type_ArrayOfByte = bbdm.a(this.jdField_a_of_type_Aumn.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Aywa.e == 1042) {
        paramayyw.e = 1;
      }
    }
    anom.a(this.jdField_a_of_type_Aywa, paramayyw);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    d(1003);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {}
    while (ConfigManager.mUseHardCodeIp != 1) {
      return;
    }
    axrb.a("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    ConfigManager.mUseHardCodeIp = 0;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.d;
    if (this.f == null) {}
    for (String str1 = this.l;; str1 = this.f)
    {
      a("actRichMediaNetMonitor_picUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Aywa.h)
    {
      b(9333, "Server MD5 fast forward missed");
      d();
      return false;
    }
    if ((this.jdField_a_of_type_Aumn != null) && (!this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean = true;
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
      }
      f();
      return false;
    }
    if (this.jdField_a_of_type_Aywa.p)
    {
      this.jdField_a_of_type_Aywa.p = false;
      f();
      return false;
    }
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      b(9041, "No Local MD5");
      d();
      return false;
    }
    if ((paramBoolean) && ((this.jdField_q_of_type_Int == 0) || (this.p == 0)))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      bbdr.a(this.jdField_a_of_type_Aywa.i, localOptions);
      this.jdField_q_of_type_Int = localOptions.outHeight;
      this.p = localOptions.outWidth;
      Object localObject = this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject;
      if ((localObject != null) && ((localObject instanceof aywe)) && (((aywe)localObject).jdField_a_of_type_Boolean) && (ayui.a(this.jdField_a_of_type_Aywa.i)))
      {
        this.jdField_q_of_type_Int = localOptions.outWidth;
        this.p = localOptions.outHeight;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          b("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mWidth = " + this.p + ",mHeight = " + this.jdField_q_of_type_Int);
        }
      }
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Aywa.i, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (((this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && ((this.jdField_q_of_type_Int > 30000) || (this.p > 30000) || (this.p * this.jdField_q_of_type_Int > 200000000)))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "checkFileStandard fail，mHeight:" + this.jdField_q_of_type_Int + " mWidth:" + this.p);
      }
      b(90632, "PicOverStandard");
      d();
      return false;
    }
    return true;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)this.jdField_q_of_type_Long);
    arrayOfInt[1] = bgkh.a(this.jdField_a_of_type_Aywa.i);
    arrayOfInt[2] = this.p;
    arrayOfInt[3] = this.jdField_q_of_type_Int;
    arrayOfInt[4] = 0;
    int i = bbdr.a(this.jdField_a_of_type_Aywa.i);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.jdField_q_of_type_Int;
      arrayOfInt[3] = this.p;
    }
    com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 1, "rotateDegree : " + i + ", params[2] : " + arrayOfInt[2] + " params[3] : " + arrayOfInt[3]);
    return arrayOfInt;
  }
  
  public void aR_()
  {
    super.aR_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-255, 2000L);
  }
  
  protected void b(boolean paramBoolean)
  {
    HashMap localHashMap;
    if ((this.jdField_a_of_type_Aumn != null) && (!this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean))
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      if (this.jdField_a_of_type_Aywa.e == 1042) {
        axrl.a(BaseApplication.getContext()).a(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      axrl.a(BaseApplication.getContext()).a(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  protected boolean b()
  {
    MessageForPic localMessageForPic = a();
    return (localMessageForPic != null) && (localMessageForPic.imageType == 2000);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  void d()
  {
    super.d();
    if ((this.jdField_a_of_type_Aumn != null) && (this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean)) {
      r();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Aywa != null)
    {
      if (!askd.b(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label67;
      }
      askd.b(String.valueOf(this.j), 3);
    }
    label67:
    while (!askd.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      return;
    }
    askd.b(String.valueOf(this.j), 2);
  }
  
  void e()
  {
    Object localObject2 = null;
    super.e();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Aumn != null)
    {
      localObject1 = this.jdField_a_of_type_Aumn.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean) {
        break label236;
      }
      if (localObject1 != null)
      {
        localObject1 = aywk.a((String)localObject1, 65537);
        if (localObject1 == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject1 = ((URL)localObject1).toString();; localObject1 = null)
    {
      if (!ayog.b((String)localObject1))
      {
        String str = ayog.d((String)localObject1);
        if (!b()) {
          break label183;
        }
        localObject1 = this.jdField_a_of_type_Aywa.i;
        boolean bool = bbdj.d((String)localObject1, str);
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "quick send copy file:" + this.jdField_a_of_type_Aywa.i + " to:" + str + " ret:" + bool);
        }
      }
      label155:
      if (this.jdField_a_of_type_Aywa != null)
      {
        if (!askd.b(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          break label243;
        }
        askd.b("0", 3);
      }
      label183:
      label236:
      label243:
      while (!askd.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        return;
        URL localURL = aywk.a(this.jdField_a_of_type_Aumn.jdField_a_of_type_JavaLangString, 65537);
        localObject1 = localObject2;
        if (localURL != null) {
          localObject1 = localURL.toString();
        }
        if (ayog.b((String)localObject1))
        {
          localObject1 = ayog.d((String)localObject1);
          break;
        }
        localObject1 = this.jdField_a_of_type_Aywa.i;
        break;
        r();
        break label155;
      }
      askd.b("0", 2);
      return;
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_Aumn != null) {
      if (!this.jdField_a_of_type_Aumn.jdField_a_of_type_Boolean)
      {
        this.jdField_q_of_type_Long = this.jdField_a_of_type_Aumn.jdField_a_of_type_Long;
        this.c = this.jdField_a_of_type_Aumn.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfByte = bbdm.a(this.c);
        if (getClass().equals(ayrd.class)) {
          this.d = (this.c + "." + this.e);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Aywa.p);
      this.jdField_q_of_type_Long = this.jdField_a_of_type_Aywa.f;
      this.c = this.jdField_a_of_type_Aywa.n;
      this.jdField_a_of_type_ArrayOfByte = bbdm.a(this.jdField_a_of_type_Aywa.n);
    } while (!getClass().equals(ayrd.class));
    this.d = (this.c + "." + this.e);
  }
  
  protected void h()
  {
    try
    {
      if ((!aqwd.a().f()) && (!aqwd.a().h()) && (!aqwd.a().g()))
      {
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "a , s close !");
        }
      }
      else if ((this.jdField_a_of_type_Aywa != null) && (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = aqvs.a(this.jdField_a_of_type_Aywa.i);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgCtrl = localMsgCtrl;
          this.jdField_a_of_type_JavaUtilHashMap.put("param_amc", "1");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Ayqm.d < 1002) {
      d(1002);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayow
 * JD-Core Version:    0.7.0.1
 */