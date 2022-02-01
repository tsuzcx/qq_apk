package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/UgcPublishPermissionUtil;", "", "()V", "hasCreateColumnPermissions", "", "publishEntranceDisplayEnable", "publishLevelLimitEnable", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class UgcPublishPermissionUtil
{
  public static final UgcPublishPermissionUtil a = new UgcPublishPermissionUtil();
  
  public final boolean a()
  {
    boolean bool = false;
    if (Aladdin.getConfig(388).getIntegerFromString("publish_permission_binding_level", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean b()
  {
    return Aladdin.getConfig(388).getIntegerFromString("publish_entrance_display", 1) > 0;
  }
  
  public final boolean c()
  {
    return Aladdin.getConfig(388).getIntegerFromString("create_column_permissions", 1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.UgcPublishPermissionUtil
 * JD-Core Version:    0.7.0.1
 */