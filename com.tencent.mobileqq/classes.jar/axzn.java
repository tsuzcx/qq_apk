import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class axzn
  extends Observable
{
  private static axzn jdField_a_of_type_Axzn;
  public RichStatus a;
  public EIPCResultCallback a;
  private ConcurrentHashMap<Integer, bdpm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public RichStatus b;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new axzo(this);
  private ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private axzn()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new axzp(this);
  }
  
  public static axzn a()
  {
    try
    {
      if (jdField_a_of_type_Axzn == null) {
        jdField_a_of_type_Axzn = new axzn();
      }
      axzn localaxzn = jdField_a_of_type_Axzn;
      return localaxzn;
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
  
  public bdpm a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public bdpm a(int paramInt, boolean paramBoolean)
  {
    bdpm localbdpm2 = (bdpm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localbdpm2 != null) && (!localbdpm2.a.get()))
    {
      localObject = localbdpm2;
      if (!paramBoolean) {}
    }
    else
    {
      bdpm localbdpm1 = localbdpm2;
      if (localbdpm2 == null)
      {
        localbdpm1 = new bdpm(Integer.toString(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localbdpm1);
      }
      localObject = localbdpm1;
      if (paramInt != 0)
      {
        localbdpm1.a.set(true);
        if (QLog.isColorLevel()) {
          QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
        }
        ThreadManager.excute(new SignatureManagerForTool.1(this, paramInt), 128, null, true);
        localObject = localbdpm1;
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
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gh.g, localBundle, this.jdField_b_of_type_EipcEIPCResultCallback);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzn
 * JD-Core Version:    0.7.0.1
 */