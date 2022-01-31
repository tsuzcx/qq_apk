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
import java.util.ArrayList;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class axor
  extends axox
  implements Handler.Callback, avaw
{
  Handler a;
  protected atop a;
  private ArrayList<String> b = new ArrayList();
  
  public axor(axos paramaxos, axvt paramaxvt)
  {
    super(paramaxos, paramaxvt);
    this.jdField_a_of_type_AndroidOsHandler = new befq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Atop = atoo.a(paramaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramaxvt);
  }
  
  private void r()
  {
    if (b())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "handleQuickSendFailed:" + a());
      }
      axwd.a(a(), 65537, null, null).downloadImediatly();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atop != null) {
      r();
    }
    return super.a();
  }
  
  protected int a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (adkt.a(paramMessageForPic)) {
      i = 5;
    }
    for (;;)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "getPicSourceReport:" + this.jdField_a_of_type_Axvt.e + " source:" + i);
      }
      return i;
      switch (this.jdField_a_of_type_Axvt.e)
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
    Object localObject = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
      localMessageForPic = ((awwr)localObject).a;
      localObject = localMessageForPic;
    } while (localMessageForPic != null);
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, axow paramaxow)
  {
    super.a(paramInt, paramString1, paramString2, paramaxow);
    axwu.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramInt, paramString1);
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
  }
  
  protected void a(axyp paramaxyp)
  {
    if ((this.jdField_a_of_type_Atop != null) && (!this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "changeRequest,file Size:" + paramaxyp.jdField_a_of_type_Long + " md5:" + paramaxyp.jdField_a_of_type_ArrayOfByte + " busiType:" + this.jdField_a_of_type_Axvt.e + " quickSendObject:" + this.jdField_a_of_type_Atop);
      }
      paramaxyp.jdField_a_of_type_Long = this.jdField_a_of_type_Atop.jdField_a_of_type_Long;
      paramaxyp.jdField_a_of_type_ArrayOfByte = bach.a(this.jdField_a_of_type_Atop.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Axvt.e == 1042) {
        paramaxyp.e = 1;
      }
    }
    amye.a(this.jdField_a_of_type_Axvt, paramaxyp);
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
    awrc.a("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    ConfigManager.mUseHardCodeIp = 0;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "reportForServerMonitor , isSuccess = " + paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.b.contains(paramString1)) {
        return;
      }
      this.b.add(paramString1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_type", "1");
    localHashMap.put("business_type", "1");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.i);
    localHashMap.put("server_ip", paramString1);
    localHashMap.put("server_port", paramString2);
    localHashMap.put("md5", this.d);
    if (this.f == null) {}
    for (paramString1 = this.k;; paramString1 = this.f)
    {
      localHashMap.put("uuid", paramString1);
      localHashMap.put("chatType", this.jdField_a_of_type_Axvt.jdField_a_of_type_Int + "");
      localHashMap.put("chatUin", this.jdField_a_of_type_Axvt.c + "");
      awrn.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_picUp", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong) {}
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Axvt.h)
    {
      b(9333, "Server MD5 fast forward missed");
      d();
      return false;
    }
    if ((this.jdField_a_of_type_Atop != null) && (!this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean = true;
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
      }
      f();
      return false;
    }
    if (this.jdField_a_of_type_Axvt.p)
    {
      this.jdField_a_of_type_Axvt.p = false;
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
      bacm.a(this.jdField_a_of_type_Axvt.i, localOptions);
      this.jdField_q_of_type_Int = localOptions.outHeight;
      this.p = localOptions.outWidth;
      Object localObject = this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
      if ((localObject != null) && ((localObject instanceof axvx)) && (((axvx)localObject).jdField_a_of_type_Boolean) && (axub.a(this.jdField_a_of_type_Axvt.i)))
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
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Axvt.i, "r");
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
    if (((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && ((this.jdField_q_of_type_Int > 30000) || (this.p > 30000) || (this.p * this.jdField_q_of_type_Int > 200000000)))
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
    arrayOfInt[1] = bfcq.a(this.jdField_a_of_type_Axvt.i);
    arrayOfInt[2] = this.p;
    arrayOfInt[3] = this.jdField_q_of_type_Int;
    arrayOfInt[4] = 0;
    int i = bacm.a(this.jdField_a_of_type_Axvt.i);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.jdField_q_of_type_Int;
      arrayOfInt[3] = this.p;
    }
    com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 1, "rotateDegree : " + i + ", params[2] : " + arrayOfInt[2] + " params[3] : " + arrayOfInt[3]);
    return arrayOfInt;
  }
  
  public void aU_()
  {
    super.aU_();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-255, 2000L);
  }
  
  protected void b(boolean paramBoolean)
  {
    HashMap localHashMap;
    if ((this.jdField_a_of_type_Atop != null) && (!this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean))
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label95;
      }
    }
    label95:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      if (this.jdField_a_of_type_Axvt.e == 1042) {
        awrn.a(BaseApplication.getContext()).a(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      awrn.a(BaseApplication.getContext()).a(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
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
    if ((this.jdField_a_of_type_Atop != null) && (this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean)) {
      r();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Axvt != null)
    {
      if (!arnz.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label67;
      }
      arnz.b(String.valueOf(this.j), 3);
    }
    label67:
    while (!arnz.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      return;
    }
    arnz.b(String.valueOf(this.j), 2);
  }
  
  void e()
  {
    Object localObject2 = null;
    super.e();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-255);
    if (this.jdField_a_of_type_Atop != null)
    {
      localObject1 = this.jdField_a_of_type_Atop.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean) {
        break label236;
      }
      if (localObject1 != null)
      {
        localObject1 = axwd.a((String)localObject1, 65537);
        if (localObject1 == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject1 = ((URL)localObject1).toString();; localObject1 = null)
    {
      if (!axoa.b((String)localObject1))
      {
        String str = axoa.d((String)localObject1);
        if (!b()) {
          break label183;
        }
        localObject1 = this.jdField_a_of_type_Axvt.i;
        boolean bool = bace.d((String)localObject1, str);
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "quick send copy file:" + this.jdField_a_of_type_Axvt.i + " to:" + str + " ret:" + bool);
        }
      }
      label155:
      if (this.jdField_a_of_type_Axvt != null)
      {
        if (!arnz.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          break label243;
        }
        arnz.b("0", 3);
      }
      label183:
      label236:
      label243:
      while (!arnz.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        return;
        URL localURL = axwd.a(this.jdField_a_of_type_Atop.jdField_a_of_type_JavaLangString, 65537);
        localObject1 = localObject2;
        if (localURL != null) {
          localObject1 = localURL.toString();
        }
        if (axoa.b((String)localObject1))
        {
          localObject1 = axoa.d((String)localObject1);
          break;
        }
        localObject1 = this.jdField_a_of_type_Axvt.i;
        break;
        r();
        break label155;
      }
      arnz.b("0", 2);
      return;
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_Atop != null) {
      if (!this.jdField_a_of_type_Atop.jdField_a_of_type_Boolean)
      {
        this.jdField_q_of_type_Long = this.jdField_a_of_type_Atop.jdField_a_of_type_Long;
        this.c = this.jdField_a_of_type_Atop.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfByte = bach.a(this.c);
        if (getClass().equals(axqw.class)) {
          this.d = (this.c + "." + this.e);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Axvt.p);
      this.jdField_q_of_type_Long = this.jdField_a_of_type_Axvt.f;
      this.c = this.jdField_a_of_type_Axvt.n;
      this.jdField_a_of_type_ArrayOfByte = bach.a(this.jdField_a_of_type_Axvt.n);
    } while (!getClass().equals(axqw.class));
    this.d = (this.c + "." + this.e);
  }
  
  protected void h()
  {
    try
    {
      if ((!aqcb.a().f()) && (!aqcb.a().h()) && (!aqcb.a().g()))
      {
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "a , s close !");
        }
      }
      else if ((this.jdField_a_of_type_Axvt != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = aqbq.a(this.jdField_a_of_type_Axvt.i);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgCtrl = localMsgCtrl;
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
    if (this.jdField_a_of_type_Axqf.d < 1002) {
      d(1002);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axor
 * JD-Core Version:    0.7.0.1
 */