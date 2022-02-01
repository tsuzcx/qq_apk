package com.tencent.biz.qqstory.msgTabNode.util;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import java.util.Iterator;
import java.util.List;

public class MsgTabStoryUtil
{
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static MsgTabNodeInfo a(@NonNull List<MsgTabNodeInfo> paramList1, @NonNull List<MsgTabNodeInfo> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    Iterator localIterator = paramList1.iterator();
    label16:
    MsgTabNodeInfo localMsgTabNodeInfo;
    for (paramList1 = null; localIterator.hasNext(); paramList1 = localMsgTabNodeInfo)
    {
      localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      if (a(localMsgTabNodeInfo)) {
        paramList2.add(localMsgTabNodeInfo);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
        break label16;
      }
    }
    return paramList1;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    return (paramMsgTabNodeInfo.jdField_a_of_type_Int == 5) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 6) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 7) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 8) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 9) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 12) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil
 * JD-Core Version:    0.7.0.1
 */