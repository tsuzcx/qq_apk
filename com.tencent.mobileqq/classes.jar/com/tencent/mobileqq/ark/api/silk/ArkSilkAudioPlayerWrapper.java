package com.tencent.mobileqq.ark.api.silk;

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
  public static final Map<Integer, String> a = new HashMap();
  protected SilkAudioPlayer b;
  private volatile boolean c = false;
  private final String d;
  private ark.VariantWrapper e;
  
  static
  {
    a.put(Integer.valueOf(0), "开始");
    a.put(Integer.valueOf(1), "加载中");
    a.put(Integer.valueOf(2), "加载完成");
    a.put(Integer.valueOf(3), "播放状态");
    a.put(Integer.valueOf(4), "中断状态");
    a.put(Integer.valueOf(5), "停止状态");
    a.put(Integer.valueOf(6), "异常");
  }
  
  public ArkSilkAudioPlayerWrapper(String paramString)
  {
    this.d = paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "stop");
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((SilkAudioPlayer)localObject).a();
      this.c = false;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ark.VariantWrapper)localObject).Reset();
      this.e = null;
    }
  }
  
  public void a(int paramInt)
  {
    ArkDispatchTask.getInstance().post(this.d, new ArkSilkAudioPlayerWrapper.1(this, paramInt));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    a(5);
    ArkDispatchTask.getInstance().post(this.d, new ArkSilkAudioPlayerWrapper.2(this));
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper)
  {
    this.e = paramVariantWrapper;
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
    if (this.b == null) {
      this.b = new SilkAudioPlayer(this);
    }
    this.b.a(paramString);
    this.c = true;
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
  
  public void b(int paramInt)
  {
    ark.VariantWrapper localVariantWrapper = this.e;
    if (localVariantWrapper == null) {
      return;
    }
    try
    {
      localVariantWrapper = localVariantWrapper.Create();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", paramInt);
      ((JSONObject)localObject).put("info", a.get(Integer.valueOf(paramInt)));
      localVariantWrapper.SetTableAsJsonString(((JSONObject)localObject).toString());
      localObject = this.e.Create();
      this.e.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, (ark.VariantWrapper)localObject);
      localVariantWrapper.Reset();
      ((ark.VariantWrapper)localObject).Reset();
      if ((paramInt == 6) || (paramInt == 5))
      {
        this.e.Reset();
        this.e = null;
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncSilkAudioPlayerForArkStatus Error");
      ((StringBuilder)localObject).append(localException);
      QLog.e("ArkSilkAudioPlayerWrapper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onPlayStart");
    }
    a(0);
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
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onDownloadStart");
    }
    a(1);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkSilkAudioPlayerWrapper", 2, "onPlaying");
    }
    a(3);
  }
  
  public void f()
  {
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */