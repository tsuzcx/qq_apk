package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/ProcessUtil;", "", "()V", "isMainProcess", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ProcessUtil
{
  public static final ProcessUtil a = new ProcessUtil();
  
  @JvmStatic
  public static final boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */