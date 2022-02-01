package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

class FakeModule
  implements IModule
{
  private static String TAG = "FakeModule";
  private final HashMap<Long, String> mFakeFocusBusiness = new HashMap();
  private final HashSet<String> mFakeInQueueBusiness = new HashSet();
  private final String mName;
  
  FakeModule(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    TAG = localStringBuilder.toString();
    this.mName = paramString;
  }
  
  public void abandonAVFocus()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module abandonAVFocus, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
  }
  
  public String checkAVFocus()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module checkAVFocus, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return "";
  }
  
  public HashMap<Long, String> getFocusBusiness()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module getFocusBusiness, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return this.mFakeFocusBusiness;
  }
  
  public HashSet<String> getInQueueBusiness()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module getInQueueBusiness, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return this.mFakeInQueueBusiness;
  }
  
  public String requestAVFocus()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module requestAVFocus, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return "";
  }
  
  public void setListener(IModule.FocusChangeListener paramFocusChangeListener)
  {
    paramFocusChangeListener = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module setListener, name[");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("]");
    QLog.e(paramFocusChangeListener, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.FakeModule
 * JD-Core Version:    0.7.0.1
 */