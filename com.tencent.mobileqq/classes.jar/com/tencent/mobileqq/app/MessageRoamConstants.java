package com.tencent.mobileqq.app;

import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public abstract interface MessageRoamConstants
{
  public static final String a = EmosmUtils.a("VIP_roam_msg_search_cfg", "https://i.gtimg.cn/qqshow/admindata/comdata/searchStrategy/xydata.json");
  public static final String b = BaseApplication.getContext().getFilesDir() + File.separator + "searchInCloudConfig.json";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamConstants
 * JD-Core Version:    0.7.0.1
 */