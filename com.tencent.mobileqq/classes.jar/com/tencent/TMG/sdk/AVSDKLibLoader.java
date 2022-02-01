package com.tencent.TMG.sdk;

import com.tencent.TMG.utils.SoUtil;

class AVSDKLibLoader
{
  private static int sExtractSoError = 0;
  private static boolean sLoadLibrary = false;
  
  public static int getSoExtractError()
  {
    return sExtractSoError;
  }
  
  public static boolean isLoadLibrary()
  {
    return sLoadLibrary;
  }
  
  public static boolean loadSdkLibrary()
  {
    if (!sLoadLibrary) {
      if ((!SoUtil.loadSo("stlport_shared")) || (!SoUtil.loadSo("tmg_xplatform")) || (!SoUtil.loadSo("UDT")) || (!SoUtil.loadSo("qavsdk"))) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      sLoadLibrary = bool;
      return sLoadLibrary;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVSDKLibLoader
 * JD-Core Version:    0.7.0.1
 */