package com.tencent.avcore.engine.dav;

public abstract interface DavRejectReason
{
  public static final int VOIP_REJECT_REASON_CONFLICT = 100;
  public static final int VOIP_REJECT_REASON_DEFAULT = 1;
  public static final int VOIP_REJECT_REASON_ISCALLING = 3;
  public static final int VOIP_REJECT_REASON_IS_AV_CALLING = 65536;
  public static final int VOIP_REJECT_REASON_IS_PHONE_CALLING = 65535;
  public static final int VOIP_REJECT_REASON_SELF_REJECT = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.dav.DavRejectReason
 * JD-Core Version:    0.7.0.1
 */