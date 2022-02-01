package com.tencent.mobileqq.activity.aio.pluspanel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelLoaderFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PlusPanelRepository
  extends BaseRepository
{
  PlusPanelAppLoader a;
  final SparseArray<String> b = new PlusPanelRepository.1(this);
  final SparseArray<String> c = new PlusPanelRepository.2(this);
  private final MutableLiveData<Integer> d = new MutableLiveData();
  private final Map<Class<? extends BaseChatPie>, Integer> e = new PlusPanelRepository.3(this);
  private final int[] f = { 1000, 1004, 1006, 1003, 1005, 1021, 1022, 1023, 1025, 10004, 10008, 10010, 10013 };
  private final String[] g = { "chat_tool_audio", "chat_tool_gaudio", "chat_tool_gaudio_new", "chat_tool_poke", "chat_tool_gift_clicked", "chat_tool_gift_stranger_clicked", "chat_tool_tencentdoc" };
  
  int a(Class<? extends BaseChatPie> paramClass)
  {
    paramClass = (Integer)this.e.get(paramClass);
    if (paramClass == null) {
      return 0;
    }
    return paramClass.intValue();
  }
  
  MutableLiveData<Integer> a()
  {
    return this.d;
  }
  
  String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  ArrayList<PluginData> a(BaseChatPie paramBaseChatPie)
  {
    this.a.a(paramBaseChatPie);
    ArrayList localArrayList = new ArrayList();
    List localList = c();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (PlusPanelAppInfo)localList.get(i);
      localObject = this.a.a(paramBaseChatPie, (PlusPanelAppInfo)localObject, i);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((!localArrayList.isEmpty()) && (this.a.c() >= 0)) {
      ThreadManagerV2.getUIHandlerV2().post(new PlusPanelRepository.4(this));
    }
    return localArrayList;
  }
  
  void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    this.a = new PlusPanelLoaderFactory().a(paramBaseChatPie, paramBoolean);
    QLog.d("PlusPanelRepository", 1, new Object[] { "init mLoader = ", this.a, ", oneWayFriend = ", Boolean.valueOf(paramBoolean) });
  }
  
  protected void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(paramString2, 0);
    String[] arrayOfString = this.g;
    int j = arrayOfString.length;
    Object localObject1 = "";
    int i = 0;
    while (i < j)
    {
      localObject2 = arrayOfString[i];
      if (TextUtils.equals(paramString1, (CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      i += 1;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString2);
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    localSharedPreferences.edit().putBoolean((String)localObject2, false).apply();
  }
  
  String b(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }
  
  int[] b()
  {
    return this.f;
  }
  
  PlusPanelAppInfo c(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  List<PlusPanelAppInfo> c()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelRepository
 * JD-Core Version:    0.7.0.1
 */