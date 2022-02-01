package com.tencent.hippy.qq.module.vas;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.vas.hippy.VasFunCallHippyHelper;
import com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.qphone.base.util.BaseApplication;

@HippyNativeModule(name="VasPersonalizedModule")
public class VasPersonalizedModule
  extends QQBaseModule
{
  static final String TAG = "VasPersonalizedModule";
  private final int BUBBLE = 2;
  private final int CARD = 15;
  private final int COLOR_SCREEN = 22;
  private final int E_MOJI = 1;
  private final int FACE = 23;
  private final int FACE_ADDON = 4;
  private final int FONT = 5;
  private final int FUN_CALL = 17;
  private final int LIKE = 20;
  private final int LISTEN_TOGETHER = 39;
  private final int MAGIC_FONTFont = 300;
  private final String METHOD_SET = "set";
  private final int RED_PACKET = 16;
  private final int THEME = 3;
  private final int THEME_BG = 8;
  private final int TROOP = 26;
  private final VasFunCallHippyHelper mFunCallHippyHelper;
  private final VasPersonalizedModule.ThemeChangedBroadcastReceiver mThemeChangedBroadcastReceiver = new VasPersonalizedModule.ThemeChangedBroadcastReceiver();
  private final VasThemeHippyHelper mThemeHippyHelper;
  
  public VasPersonalizedModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    BaseApplicationImpl.getContext().registerReceiver(this.mThemeChangedBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
    this.mThemeHippyHelper = new VasThemeHippyHelper(ContextHolder.getAppContext(), getAppInterface(), getActivity());
    this.mFunCallHippyHelper = new VasFunCallHippyHelper(ContextHolder.getAppContext(), getActivity());
  }
  
  private void setTheme(long paramLong, Promise paramPromise)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    if ("1000".equals(localStringBuilder.toString())) {
      this.mThemeHippyHelper.a(false, "200", "1000", "0", 0, null, null, 0L, paramPromise);
    }
  }
  
  public void destroy()
  {
    BaseApplicationImpl.getContext().unregisterReceiver(this.mThemeChangedBroadcastReceiver);
    super.destroy();
  }
  
  @HippyMethod(name="set")
  public void set(HippyMap paramHippyMap, Promise paramPromise)
  {
    long l1 = paramHippyMap.getLong("bid");
    long l2 = paramHippyMap.getLong("itemId");
    int i = (int)l1;
    if (i != 3)
    {
      if (i != 17) {
        return;
      }
      this.mFunCallHippyHelper.a(paramHippyMap, paramPromise);
      return;
    }
    setTheme(l2, paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.vas.VasPersonalizedModule
 * JD-Core Version:    0.7.0.1
 */