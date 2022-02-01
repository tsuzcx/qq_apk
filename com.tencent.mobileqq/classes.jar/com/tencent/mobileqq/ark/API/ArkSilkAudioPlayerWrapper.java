package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ArkSilkAudioPlayerWrapper
  implements SilkAudioPlayer.SilkAudioPlayerListener
{
  public static final Map<Integer, String> a;
  private ark.VariantWrapper jdField_a_of_type_ComTencentArkArk$VariantWrapper;
  protected SilkAudioPlayer a;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), "开始");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), "加载中");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), "加载完成");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), "播放状态");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), "中断状态");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), "停止状态");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(6), "异常");
  }
  
  public ArkSilkAudioPlayerWrapper(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "stop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPISilkAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkAPISilkAudioPlayer.a();
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentArkArk$VariantWrapper != null)
    {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Reset();
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = null;
    }
  }
  
  public void a(int paramInt)
  {
    ArkDispatchTask.getInstance().post(this.jdField_a_of_type_JavaLangString, new ArkSilkAudioPlayerWrapper.1(this, paramInt));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    a(5);
    ArkDispatchTask.getInstance().post(this.jdField_a_of_type_JavaLangString, new ArkSilkAudioPlayerWrapper.2(this));
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper)
  {
    this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = paramVariantWrapper;
  }
  
  public void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
    a(2);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "play");
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ArkSilkAudioPlayerWrapper", 1, "play but url is empty");
      a(6);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPISilkAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPISilkAudioPlayer = new SilkAudioPlayer(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqArkAPISilkAudioPlayer.a(paramString);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean)
    {
      a(5);
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onPlayStart");
    }
    a(0);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentArkArk$VariantWrapper == null) {}
    for (;;)
    {
      return;
      try
      {
        ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Create();
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("state", paramInt);
        ((JSONObject)localObject).put("info", jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)));
        localVariantWrapper.SetTableAsJsonString(((JSONObject)localObject).toString());
        localObject = this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Create();
        this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, (ark.VariantWrapper)localObject);
        localVariantWrapper.Reset();
        ((ark.VariantWrapper)localObject).Reset();
        if ((paramInt == 6) || (paramInt == 5))
        {
          this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Reset();
          this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = null;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ArkSilkAudioPlayerWrapper", 1, "syncSilkAudioPlayerForArkStatus Error" + localException);
      }
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onDownloadStart");
    }
    a(1);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    a(6);
    a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onPlaying");
    }
    a(3);
  }
  
  public void e()
  {
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkSilkAudioPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */