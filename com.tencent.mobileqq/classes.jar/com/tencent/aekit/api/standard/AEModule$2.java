package com.tencent.aekit.api.standard;

final class AEModule$2
  implements Runnable
{
  AEModule$2(boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   3: astore_1
    //   4: invokestatic 31	com/tencent/ttpic/baseutils/device/DeviceAttrs:getInstance	()Lcom/tencent/ttpic/baseutils/device/DeviceAttrs;
    //   7: aload_1
    //   8: invokevirtual 36	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   11: aload_1
    //   12: invokestatic 42	com/tencent/ttpic/util/SecurityUtils:getSignMD5	(Landroid/content/Context;)Ljava/lang/String;
    //   15: invokevirtual 46	com/tencent/ttpic/baseutils/device/DeviceAttrs:init	(Landroid/content/Context;Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 12	com/tencent/aekit/api/standard/AEModule$2:val$forceUpdate	Z
    //   22: ifeq +49 -> 71
    //   25: invokestatic 31	com/tencent/ttpic/baseutils/device/DeviceAttrs:getInstance	()Lcom/tencent/ttpic/baseutils/device/DeviceAttrs;
    //   28: astore_2
    //   29: new 48	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic 55	com/tencent/ttpic/openapi/manager/FeatureManager:getSoDir	()Ljava/lang/String;
    //   41: invokestatic 61	com/tencent/ttpic/baseutils/io/FileUtils:genSeperateFileDir	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc 67
    //   51: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: new 72	com/tencent/aekit/api/standard/AEModule$2$1
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 75	com/tencent/aekit/api/standard/AEModule$2$1:<init>	(Lcom/tencent/aekit/api/standard/AEModule$2;)V
    //   68: invokevirtual 79	com/tencent/ttpic/baseutils/device/DeviceAttrs:update	(Ljava/lang/String;Lcom/tencent/ttpic/baseutils/device/DeviceAttrs$UpdateListener;)V
    //   71: invokestatic 84	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:getInstance	()Lcom/tencent/ttpic/baseutils/device/GpuScopeAttrs;
    //   74: aload_1
    //   75: invokestatic 89	com/tencent/ttpic/baseutils/device/DeviceInstance:getInstance	()Lcom/tencent/ttpic/baseutils/device/DeviceInstance;
    //   78: invokevirtual 92	com/tencent/ttpic/baseutils/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   81: invokestatic 97	com/tencent/aekit/api/standard/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   84: invokestatic 100	com/tencent/ttpic/openapi/manager/FeatureManager:getResourceDir	()Ljava/lang/String;
    //   87: invokevirtual 103	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   93: invokestatic 109	com/tencent/ttpic/device/DeviceUtils:hasDeviceHigh	(Landroid/content/Context;)Z
    //   96: ifeq +9 -> 105
    //   99: ldc 110
    //   101: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   104: return
    //   105: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   108: invokestatic 119	com/tencent/ttpic/device/DeviceUtils:hasDeviceNormal	(Landroid/content/Context;)Z
    //   111: ifeq +9 -> 120
    //   114: ldc 120
    //   116: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   119: return
    //   120: ldc 121
    //   122: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   125: return
    //   126: astore_2
    //   127: goto +84 -> 211
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 124	java/lang/Error:printStackTrace	()V
    //   135: new 48	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   142: astore_3
    //   143: aload_3
    //   144: ldc 126
    //   146: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_3
    //   151: aload_2
    //   152: invokevirtual 129	java/lang/Error:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 131
    //   161: aload_3
    //   162: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 137	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: invokestatic 84	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:getInstance	()Lcom/tencent/ttpic/baseutils/device/GpuScopeAttrs;
    //   171: aload_1
    //   172: invokestatic 89	com/tencent/ttpic/baseutils/device/DeviceInstance:getInstance	()Lcom/tencent/ttpic/baseutils/device/DeviceInstance;
    //   175: invokevirtual 92	com/tencent/ttpic/baseutils/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   178: invokestatic 97	com/tencent/aekit/api/standard/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   181: invokestatic 100	com/tencent/ttpic/openapi/manager/FeatureManager:getResourceDir	()Ljava/lang/String;
    //   184: invokevirtual 103	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   187: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   190: invokestatic 109	com/tencent/ttpic/device/DeviceUtils:hasDeviceHigh	(Landroid/content/Context;)Z
    //   193: ifeq +6 -> 199
    //   196: goto -97 -> 99
    //   199: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   202: invokestatic 119	com/tencent/ttpic/device/DeviceUtils:hasDeviceNormal	(Landroid/content/Context;)Z
    //   205: ifeq -85 -> 120
    //   208: goto -94 -> 114
    //   211: invokestatic 84	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:getInstance	()Lcom/tencent/ttpic/baseutils/device/GpuScopeAttrs;
    //   214: aload_1
    //   215: invokestatic 89	com/tencent/ttpic/baseutils/device/DeviceInstance:getInstance	()Lcom/tencent/ttpic/baseutils/device/DeviceInstance;
    //   218: invokevirtual 92	com/tencent/ttpic/baseutils/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   221: invokestatic 97	com/tencent/aekit/api/standard/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   224: invokestatic 100	com/tencent/ttpic/openapi/manager/FeatureManager:getResourceDir	()Ljava/lang/String;
    //   227: invokevirtual 103	com/tencent/ttpic/baseutils/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   230: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   233: invokestatic 109	com/tencent/ttpic/device/DeviceUtils:hasDeviceHigh	(Landroid/content/Context;)Z
    //   236: ifne +28 -> 264
    //   239: invokestatic 25	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   242: invokestatic 119	com/tencent/ttpic/device/DeviceUtils:hasDeviceNormal	(Landroid/content/Context;)Z
    //   245: ifeq +11 -> 256
    //   248: ldc 120
    //   250: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   253: goto +16 -> 269
    //   256: ldc 121
    //   258: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   261: goto +8 -> 269
    //   264: ldc 110
    //   266: putstatic 116	com/tencent/ttpic/openapi/facedetect/FaceDetector:FACE_DETECT_WIDTH	F
    //   269: goto +5 -> 274
    //   272: aload_2
    //   273: athrow
    //   274: goto -2 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	2
    //   3	212	1	localContext	android.content.Context
    //   28	28	2	localDeviceAttrs	com.tencent.ttpic.baseutils.device.DeviceAttrs
    //   126	1	2	localObject	Object
    //   130	143	2	localError	java.lang.Error
    //   36	126	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	71	126	finally
    //   131	168	126	finally
    //   4	71	130	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule.2
 * JD-Core Version:    0.7.0.1
 */