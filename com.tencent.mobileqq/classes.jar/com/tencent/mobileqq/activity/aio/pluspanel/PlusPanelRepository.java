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
  final SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new PlusPanelRepository.1(this);
  private final MutableLiveData<Integer> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  PlusPanelAppLoader jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader;
  private final Map<Class<? extends BaseChatPie>, Integer> jdField_a_of_type_JavaUtilMap = new PlusPanelRepository.3(this);
  private final int[] jdField_a_of_type_ArrayOfInt = { 1000, 1004, 1006, 1003, 1005, 1021, 1022, 1023, 1025, 10004, 10008, 10009, 10010 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_audio", "chat_tool_gaudio", "chat_tool_gaudio_new", "chat_tool_poke", "chat_tool_gift_clicked", "chat_tool_gift_stranger_clicked", "chat_tool_tencentdoc" };
  final SparseArray<String> b = new PlusPanelRepository.2(this);
  
  int a(Class<? extends BaseChatPie> paramClass)
  {
    paramClass = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (paramClass == null) {
      return 0;
    }
    return paramClass.intValue();
  }
  
  MutableLiveData<Integer> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  PlusPanelAppInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a(paramInt);
  }
  
  String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  ArrayList<PluginData> a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a(paramBaseChatPie);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (PlusPanelAppInfo)localList.get(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a(paramBaseChatPie, (PlusPanelAppInfo)localObject, i);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((!localArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a() >= 0)) {
      ThreadManagerV2.getUIHandlerV2().post(new PlusPanelRepository.4(this));
    }
    return localArrayList;
  }
  
  List<PlusPanelAppInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader.a();
  }
  
  void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader = new PlusPanelLoaderFactory().a(paramBaseChatPie, paramBoolean);
    QLog.d("PlusPanelRepository", 1, new Object[] { "init mLoader = ", this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader, ", oneWayFriend = ", Boolean.valueOf(paramBoolean) });
  }
  
  protected void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(paramString2, 0);
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
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
  
  int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  String b(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelRepository
 * JD-Core Version:    0.7.0.1
 */