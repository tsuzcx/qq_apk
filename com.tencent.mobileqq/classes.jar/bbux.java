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

public class bbux
  extends Observable
{
  private static bbux jdField_a_of_type_Bbux;
  public RichStatus a;
  public EIPCResultCallback a;
  private ConcurrentHashMap<Integer, bhzd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public RichStatus b;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new bbuy(this);
  private ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private bbux()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new bbuz(this);
  }
  
  public static bbux a()
  {
    try
    {
      if (jdField_a_of_type_Bbux == null) {
        jdField_a_of_type_Bbux = new bbux();
      }
      bbux localbbux = jdField_a_of_type_Bbux;
      return localbbux;
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
  
  public bhzd a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public bhzd a(int paramInt, boolean paramBoolean)
  {
    bhzd localbhzd2 = (bhzd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localbhzd2 != null) && (!localbhzd2.a.get()))
    {
      localObject = localbhzd2;
      if (!paramBoolean) {}
    }
    else
    {
      bhzd localbhzd1 = localbhzd2;
      if (localbhzd2 == null)
      {
        localbhzd1 = new bhzd(Integer.toString(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localbhzd1);
      }
      localObject = localbhzd1;
      if (paramInt != 0)
      {
        localbhzd1.a.set(true);
        if (QLog.isColorLevel()) {
          QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
        }
        ThreadManager.excute(new SignatureManagerForTool.1(this, paramInt), 128, null, true);
        localObject = localbhzd1;
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
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gm.g, localBundle, this.jdField_b_of_type_EipcEIPCResultCallback);
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
 * Qualified Name:     bbux
 * JD-Core Version:    0.7.0.1
 */