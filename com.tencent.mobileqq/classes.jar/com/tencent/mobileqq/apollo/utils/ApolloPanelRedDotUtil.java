package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/ApolloPanelRedDotUtil;", "", "()V", "TAG", "", "getAppInfoPath", "packageId", "", "needShowRedDot", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloPanelRedDotUtil
{
  public static final ApolloPanelRedDotUtil a = new ApolloPanelRedDotUtil();
  
  @JvmStatic
  @Nullable
  public static final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "1000200.1000202";
    case 1: 
      return "1000200.1000203";
    case 8: 
      return "1000200.1000201";
    }
    return "1000200.1000204";
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    Object localObject1 = a(paramInt);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    localObject2 = ((BaseApplicationImpl)localObject2).getRuntime().getRuntimeService(IRedTouchManager.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getA…va, ProcessConstant.MAIN)");
    localObject1 = ((IRedTouchManager)localObject2).getAppInfoByPath((String)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "iRedTouchManager.getAppInfoByPath(path)");
    QLog.d("ApolloPanelRedDotUtil", 1, "packageId: " + paramInt + ", iNewFlag:" + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() + ' ');
    return (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 1) && (CmShowWnsUtils.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil
 * JD-Core Version:    0.7.0.1
 */