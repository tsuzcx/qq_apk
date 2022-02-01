package com.tencent.mobileqq.apollo.utils;

import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.model.ApolloDressInfo;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKGetResPathUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloAEUtil
{
  public static CmShowAssetsData a(ApolloDressInfo paramApolloDressInfo)
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    Iterator localIterator = paramApolloDressInfo.getDressMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localIterator.next()).getValue();
      String str = new File(BKGetResPathUtil.b(localDress.id)).getAbsolutePath();
      localCmShowAssetsData.b.put(localDress.attachPart.get(0), str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("part: ");
      localStringBuilder.append((String)localDress.attachPart.get(0));
      localStringBuilder.append("; dir : ");
      localStringBuilder.append(str);
      QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    }
    localCmShowAssetsData.a = paramApolloDressInfo.getRoleDir();
    localCmShowAssetsData.c = paramApolloDressInfo.getFaceJson();
    paramApolloDressInfo = new StringBuilder();
    paramApolloDressInfo.append("roleResDir: ");
    paramApolloDressInfo.append(localCmShowAssetsData.a);
    QLog.d("[cmshow]cm_res", 1, paramApolloDressInfo.toString());
    return localCmShowAssetsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloAEUtil
 * JD-Core Version:    0.7.0.1
 */