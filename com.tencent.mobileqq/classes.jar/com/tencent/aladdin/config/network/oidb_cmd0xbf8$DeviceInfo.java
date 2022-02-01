package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xbf8$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "os", "cpu", "memory", "storage", "screen", "camera", "brand" }, new Object[] { null, null, null, null, null, null, null }, DeviceInfo.class);
  public oidb_cmd0xbf8.BrandInfo brand = new oidb_cmd0xbf8.BrandInfo();
  public oidb_cmd0xbf8.Camera camera = new oidb_cmd0xbf8.Camera();
  public oidb_cmd0xbf8.CPU cpu = new oidb_cmd0xbf8.CPU();
  public oidb_cmd0xbf8.Memory memory = new oidb_cmd0xbf8.Memory();
  public oidb_cmd0xbf8.OS os = new oidb_cmd0xbf8.OS();
  public oidb_cmd0xbf8.Screen screen = new oidb_cmd0xbf8.Screen();
  public oidb_cmd0xbf8.Storage storage = new oidb_cmd0xbf8.Storage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */