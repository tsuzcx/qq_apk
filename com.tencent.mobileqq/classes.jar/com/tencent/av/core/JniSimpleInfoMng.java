package com.tencent.av.core;

import android.text.TextUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class JniSimpleInfoMng
{
  private final VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
  private final HashMap<Long, HashMap<String, Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  JniSimpleInfoMng(VcControllerImpl paramVcControllerImpl)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = paramVcControllerImpl;
  }
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject;
    if (a(paramBoolean1, paramBoolean2, false))
    {
      localObject = a(paramLong, paramString);
      if ((localObject instanceof Integer))
      {
        j = ((Integer)localObject).intValue();
        i = j;
        if (j == paramInt) {
          break label63;
        }
        bool1 = true;
        i = j;
        break label66;
      }
    }
    i = paramInt;
    label63:
    bool1 = false;
    label66:
    j = i;
    bool2 = bool1;
    if (b(paramBoolean1, paramBoolean2, bool1))
    {
      localObject = null;
      try
      {
        String str = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getAVSDKInfo(paramLong, paramString);
        localObject = str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        a("getAVSDKInfo", localUnsatisfiedLinkError);
      }
      j = i;
      bool2 = bool1;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      j = Integer.parseInt((String)localObject);
      i = j;
      a(paramLong, paramString, Integer.valueOf(j));
      if (j != paramInt) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j = i;
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getIntegerValue, [peerUin: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", onlyFromCache: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", onlyFromAVSDK: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", ret: ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", key: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", default: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("JniSimpleInfoMng", 2, ((StringBuilder)localObject).toString());
    }
    return j;
  }
  
  public static long a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return l;
    }
    catch (Throwable paramString)
    {
      QLog.i("JniSimpleInfoMng", 1, "parseUin", paramString);
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("JniSimpleInfoMng", 1, "parseUin", paramString);
    }
    return -1L;
  }
  
  private HashMap<String, Object> a(long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localObject == null) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        HashMap localHashMap1 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        localObject = localHashMap1;
        if (localHashMap1 == null)
        {
          localObject = new HashMap();
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localObject);
        }
        return localObject;
      }
    }
    return localHashMap;
  }
  
  private void a(String paramString, UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSoFail, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("JniSimpleInfoMng", 1, localStringBuilder.toString(), paramUnsatisfiedLinkError);
    AVSoUtils.a(BaseApplication.getContext(), "VideoCtrl");
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean1) || ((!paramBoolean2) && (!paramBoolean3));
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean2) || ((!paramBoolean1) && (!paramBoolean3));
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramLong, "WatchTogetherFlag", paramBoolean1, paramBoolean2, -1);
  }
  
  public int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(a(paramString), "PeerTerminalType", paramBoolean1, paramBoolean2, 0);
  }
  
  public Object a(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramLong).get(paramString);
  }
  
  void a(long paramLong)
  {
    Object localObject = a(paramLong);
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearInfoForClose, peerUin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("JniSimpleInfoMng", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramLong).put(paramString, paramObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l = a(paramString);
    a(l, "WatchTogetherFlag", Integer.valueOf(paramInt));
    if (paramBoolean) {
      try
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAVSDKInfo(l, "WatchTogetherFlag", String.valueOf(paramInt));
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        a("setAVSDKInfo", localUnsatisfiedLinkError);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWatchTogetherFlag, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], flag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], toAVSDK[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("JniSimpleInfoMng", 2, localStringBuilder.toString());
    }
  }
  
  public int b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(a(paramString), "PeerSdkVersion", paramBoolean1, paramBoolean2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.JniSimpleInfoMng
 * JD-Core Version:    0.7.0.1
 */