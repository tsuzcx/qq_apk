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

public class bbvh
  extends Observable
{
  private static bbvh jdField_a_of_type_Bbvh;
  public RichStatus a;
  public EIPCResultCallback a;
  private ConcurrentHashMap<Integer, bhoj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public RichStatus b;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new bbvi(this);
  private ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private bbvh()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new bbvj(this);
  }
  
  public static bbvh a()
  {
    try
    {
      if (jdField_a_of_type_Bbvh == null) {
        jdField_a_of_type_Bbvh = new bbvh();
      }
      bbvh localbbvh = jdField_a_of_type_Bbvh;
      return localbbvh;
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
  
  public bhoj a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public bhoj a(int paramInt, boolean paramBoolean)
  {
    bhoj localbhoj2 = (bhoj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localbhoj2 != null) && (!localbhoj2.a.get()))
    {
      localObject = localbhoj2;
      if (!paramBoolean) {}
    }
    else
    {
      bhoj localbhoj1 = localbhoj2;
      if (localbhoj2 == null)
      {
        localbhoj1 = new bhoj(Integer.toString(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localbhoj1);
      }
      localObject = localbhoj1;
      if (paramInt != 0)
      {
        localbhoj1.a.set(true);
        if (QLog.isColorLevel()) {
          QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
        }
        ThreadManager.excute(new SignatureManagerForTool.1(this, paramInt), 128, null, true);
        localObject = localbhoj1;
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
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gk.g, localBundle, this.jdField_b_of_type_EipcEIPCResultCallback);
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
 * Qualified Name:     bbvh
 * JD-Core Version:    0.7.0.1
 */