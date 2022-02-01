package com.tencent.falco.base.imageloader;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;

class FailReasonUtil
{
  static String getFailReasonStr(FailReason paramFailReason)
  {
    String str;
    if (paramFailReason == null) {
      str = "";
    }
    do
    {
      return str;
      str = "unknown";
      if (paramFailReason.getType() == FailReason.FailType.IO_ERROR) {
        return "IO_ERROR";
      }
      if (paramFailReason.getType() == FailReason.FailType.NETWORK_DENIED) {
        return "NETWORK_DENIED";
      }
      if (paramFailReason.getType() == FailReason.FailType.DECODING_ERROR) {
        return "DECODING_ERROR";
      }
    } while (paramFailReason.getType() != FailReason.FailType.OUT_OF_MEMORY);
    return "OUT_OF_MEMORY";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.FailReasonUtil
 * JD-Core Version:    0.7.0.1
 */