import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class avep
  extends Observable
{
  private static avep jdField_a_of_type_Avep;
  public RichStatus a;
  public EIPCResultCallback a;
  private ConcurrentHashMap<Integer, baoi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public RichStatus b;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new aveq(this);
  private ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private avep()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new aver(this);
  }
  
  public static avep a()
  {
    try
    {
      if (jdField_a_of_type_Avep == null) {
        jdField_a_of_type_Avep = new avep();
      }
      avep localavep = jdField_a_of_type_Avep;
      return localavep;
    }
    finally {}
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public baoi a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public baoi a(int paramInt, boolean paramBoolean)
  {
    baoi localbaoi2 = (baoi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localbaoi2 != null) && (!localbaoi2.a.get()))
    {
      localObject = localbaoi2;
      if (!paramBoolean) {}
    }
    else
    {
      baoi localbaoi1 = localbaoi2;
      if (localbaoi2 == null)
      {
        localbaoi1 = new baoi(Integer.toString(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localbaoi1);
      }
      localObject = localbaoi1;
      if (paramInt != 0)
      {
        localbaoi1.a.set(true);
        ThreadManagerV2.executeOnFileThread(new SignatureManagerForTool.1(this, paramInt));
        localObject = localbaoi1;
      }
    }
    return localObject;
  }
  
  public String a(int paramInt)
  {
    String str = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gf.g, localBundle, this.jdField_b_of_type_EipcEIPCResultCallback);
    }
    return str;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramRichStatus);
    QLog.d("Signature.TOOL", 2, "updateHandleStatus: tpdId=" + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId + " fontId=" + this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId);
  }
  
  public void b(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramRichStatus);
    QLog.d("Signature.TOOL", 2, "updateSaveStatus: tpdId=" + this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.tplId + " fontId=" + this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.fontId);
    a(paramRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avep
 * JD-Core Version:    0.7.0.1
 */