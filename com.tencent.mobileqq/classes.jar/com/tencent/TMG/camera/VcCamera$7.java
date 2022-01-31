package com.tencent.TMG.camera;

import android.hardware.Camera.PreviewCallback;

class VcCamera$7
  implements Camera.PreviewCallback
{
  VcCamera$7(VcCamera paramVcCamera) {}
  
  /* Error */
  @android.annotation.TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, android.hardware.Camera paramCamera)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: getstatic 29	com/tencent/TMG/camera/VcCamera:nInFPS	I
    //   9: ifle +228 -> 237
    //   12: aload_0
    //   13: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   16: invokestatic 33	com/tencent/TMG/camera/VcCamera:access$800	(Lcom/tencent/TMG/camera/VcCamera;)Z
    //   19: ifeq +451 -> 470
    //   22: aload_0
    //   23: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   26: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   29: ifne +209 -> 238
    //   32: aload_0
    //   33: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   36: getfield 39	com/tencent/TMG/camera/VcCamera:screenOrientation	I
    //   39: iconst_2
    //   40: if_icmpeq +1292 -> 1332
    //   43: aload_0
    //   44: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   47: getfield 39	com/tencent/TMG/camera/VcCamera:screenOrientation	I
    //   50: iconst_1
    //   51: if_icmpeq +1281 -> 1332
    //   54: aload_0
    //   55: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   58: getfield 43	com/tencent/TMG/camera/VcCamera:devDisplay	Landroid/view/Display;
    //   61: invokevirtual 49	android/view/Display:getRotation	()I
    //   64: bipush 90
    //   66: imul
    //   67: istore_3
    //   68: sipush 360
    //   71: iload_3
    //   72: aload_0
    //   73: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   76: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   79: iadd
    //   80: sipush 360
    //   83: irem
    //   84: isub
    //   85: sipush 360
    //   88: irem
    //   89: istore_3
    //   90: iload_3
    //   91: aload_0
    //   92: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   95: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   98: iadd
    //   99: istore 4
    //   101: aload_0
    //   102: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   105: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   108: sipush 270
    //   111: if_icmpeq +15 -> 126
    //   114: aload_0
    //   115: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   118: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   121: bipush 90
    //   123: if_icmpne +161 -> 284
    //   126: iload 4
    //   128: istore_3
    //   129: aload_0
    //   130: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   133: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   136: sipush 180
    //   139: irem
    //   140: ifne +41 -> 181
    //   143: iload 4
    //   145: istore_3
    //   146: aload_0
    //   147: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   150: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   153: ifne +28 -> 181
    //   156: iload 4
    //   158: istore_3
    //   159: aload_0
    //   160: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   163: invokestatic 57	com/tencent/TMG/camera/VcCamera:access$900	(Lcom/tencent/TMG/camera/VcCamera;)Ljava/lang/String;
    //   166: ldc 59
    //   168: invokevirtual 65	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   171: ifne +10 -> 181
    //   174: iload 4
    //   176: sipush 180
    //   179: iadd
    //   180: istore_3
    //   181: aload_0
    //   182: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   185: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   188: ifne +239 -> 427
    //   191: aload_0
    //   192: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   195: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
    //   198: ifle +209 -> 407
    //   201: iload_3
    //   202: sipush 360
    //   205: aload_0
    //   206: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   209: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
    //   212: isub
    //   213: iadd
    //   214: istore_3
    //   215: iload_3
    //   216: sipush 360
    //   219: irem
    //   220: bipush 90
    //   222: idiv
    //   223: istore 7
    //   225: aload_1
    //   226: ifnonnull +471 -> 697
    //   229: ldc 70
    //   231: iconst_0
    //   232: ldc 72
    //   234: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: return
    //   238: aload_0
    //   239: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   242: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   245: iconst_1
    //   246: if_icmpne +1081 -> 1327
    //   249: aload_0
    //   250: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   253: getfield 43	com/tencent/TMG/camera/VcCamera:devDisplay	Landroid/view/Display;
    //   256: invokevirtual 49	android/view/Display:getRotation	()I
    //   259: istore_3
    //   260: aload_0
    //   261: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   264: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   267: iload_3
    //   268: bipush 90
    //   270: imul
    //   271: isub
    //   272: sipush 360
    //   275: iadd
    //   276: sipush 360
    //   279: irem
    //   280: istore_3
    //   281: goto -191 -> 90
    //   284: aload_0
    //   285: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   288: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   291: ifeq +19 -> 310
    //   294: iload 4
    //   296: istore_3
    //   297: aload_0
    //   298: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   301: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   304: sipush 180
    //   307: if_icmpne -126 -> 181
    //   310: aload_0
    //   311: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   314: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   317: bipush 90
    //   319: if_icmpeq +16 -> 335
    //   322: aload_0
    //   323: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   326: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   329: sipush 270
    //   332: if_icmpne +39 -> 371
    //   335: iload 4
    //   337: istore_3
    //   338: aload_0
    //   339: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   342: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   345: ifne -164 -> 181
    //   348: iload 4
    //   350: istore_3
    //   351: aload_0
    //   352: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   355: getfield 82	com/tencent/TMG/camera/VcCamera:mbIsTablet	Z
    //   358: ifne -177 -> 181
    //   361: iload 4
    //   363: sipush 180
    //   366: iadd
    //   367: istore_3
    //   368: goto -187 -> 181
    //   371: iload 4
    //   373: istore_3
    //   374: aload_0
    //   375: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   378: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   381: ifne -200 -> 181
    //   384: iload 4
    //   386: istore_3
    //   387: aload_0
    //   388: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   391: getfield 82	com/tencent/TMG/camera/VcCamera:mbIsTablet	Z
    //   394: ifeq -213 -> 181
    //   397: iload 4
    //   399: sipush 180
    //   402: iadd
    //   403: istore_3
    //   404: goto -223 -> 181
    //   407: iload_3
    //   408: aload_0
    //   409: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   412: aload_0
    //   413: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   416: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   419: invokevirtual 86	com/tencent/TMG/camera/VcCamera:getRemoteAngleForFrontCamera	(I)I
    //   422: iadd
    //   423: istore_3
    //   424: goto -209 -> 215
    //   427: aload_0
    //   428: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   431: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
    //   434: ifle +16 -> 450
    //   437: iload_3
    //   438: aload_0
    //   439: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   442: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
    //   445: iadd
    //   446: istore_3
    //   447: goto -232 -> 215
    //   450: iload_3
    //   451: aload_0
    //   452: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   455: aload_0
    //   456: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   459: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   462: invokevirtual 92	com/tencent/TMG/camera/VcCamera:getRemoteAngleForBackCamera	(I)I
    //   465: iadd
    //   466: istore_3
    //   467: goto -252 -> 215
    //   470: aload_0
    //   471: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   474: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   477: aload_0
    //   478: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   481: getfield 95	com/tencent/TMG/camera/VcCamera:CompenSateRecvAngle	I
    //   484: iadd
    //   485: bipush 90
    //   487: iadd
    //   488: sipush 360
    //   491: irem
    //   492: istore 4
    //   494: aload_0
    //   495: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   498: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   501: sipush 270
    //   504: if_icmpeq +18 -> 522
    //   507: iload 4
    //   509: istore_3
    //   510: aload_0
    //   511: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   514: invokevirtual 52	com/tencent/TMG/camera/VcCamera:getOrientation	()I
    //   517: bipush 90
    //   519: if_icmpne +19 -> 538
    //   522: aload_0
    //   523: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   526: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   529: ifne +82 -> 611
    //   532: iload 4
    //   534: bipush 90
    //   536: iadd
    //   537: istore_3
    //   538: aload_0
    //   539: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   542: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   545: ifne +76 -> 621
    //   548: iload_3
    //   549: istore 4
    //   551: aload_0
    //   552: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   555: invokestatic 57	com/tencent/TMG/camera/VcCamera:access$900	(Lcom/tencent/TMG/camera/VcCamera;)Ljava/lang/String;
    //   558: ldc 59
    //   560: invokevirtual 65	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   563: ifne +10 -> 573
    //   566: iload_3
    //   567: sipush 180
    //   570: iadd
    //   571: istore 4
    //   573: aload_0
    //   574: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   577: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   580: ifne +72 -> 652
    //   583: aload_0
    //   584: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   587: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
    //   590: ifle +41 -> 631
    //   593: iload 4
    //   595: sipush 360
    //   598: aload_0
    //   599: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   602: getfield 68	com/tencent/TMG/camera/VcCamera:mFrontCameraAngle	I
    //   605: isub
    //   606: iadd
    //   607: istore_3
    //   608: goto -393 -> 215
    //   611: iload 4
    //   613: sipush 180
    //   616: iadd
    //   617: istore_3
    //   618: goto -80 -> 538
    //   621: iload_3
    //   622: sipush 180
    //   625: iadd
    //   626: istore 4
    //   628: goto -55 -> 573
    //   631: iload 4
    //   633: aload_0
    //   634: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   637: aload_0
    //   638: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   641: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   644: invokevirtual 86	com/tencent/TMG/camera/VcCamera:getRemoteAngleForFrontCamera	(I)I
    //   647: iadd
    //   648: istore_3
    //   649: goto -434 -> 215
    //   652: aload_0
    //   653: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   656: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
    //   659: ifle +17 -> 676
    //   662: iload 4
    //   664: aload_0
    //   665: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   668: getfield 89	com/tencent/TMG/camera/VcCamera:mBackCameraAngle	I
    //   671: iadd
    //   672: istore_3
    //   673: goto -458 -> 215
    //   676: iload 4
    //   678: aload_0
    //   679: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   682: aload_0
    //   683: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   686: invokevirtual 53	com/tencent/TMG/camera/VcCamera:getRotation	()I
    //   689: invokevirtual 92	com/tencent/TMG/camera/VcCamera:getRemoteAngleForBackCamera	(I)I
    //   692: iadd
    //   693: istore_3
    //   694: goto -479 -> 215
    //   697: aload_0
    //   698: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   701: getfield 98	com/tencent/TMG/camera/VcCamera:LAST_CAMERA	I
    //   704: aload_0
    //   705: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   708: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   711: if_icmpeq +38 -> 749
    //   714: new 100	com/tencent/TMG/camera/VcCamera$CameraPreviewChangeRunnable
    //   717: dup
    //   718: aload_0
    //   719: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   722: aload_0
    //   723: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   726: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   729: invokespecial 103	com/tencent/TMG/camera/VcCamera$CameraPreviewChangeRunnable:<init>	(Lcom/tencent/TMG/camera/VcCamera;I)V
    //   732: invokestatic 109	com/tencent/TMG/sdk/AVUILoopProxy:postTaskToMainLooper	(Ljava/lang/Runnable;)V
    //   735: aload_0
    //   736: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   739: aload_0
    //   740: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   743: getfield 36	com/tencent/TMG/camera/VcCamera:CUR_CAMERA	I
    //   746: putfield 98	com/tencent/TMG/camera/VcCamera:LAST_CAMERA	I
    //   749: aload_1
    //   750: arraylength
    //   751: istore 8
    //   753: iload 8
    //   755: aload_0
    //   756: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   759: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   762: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
    //   765: aload_0
    //   766: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   769: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   772: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
    //   775: imul
    //   776: aload_0
    //   777: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   780: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   783: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   786: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
    //   789: imul
    //   790: bipush 8
    //   792: idiv
    //   793: if_icmpeq +476 -> 1269
    //   796: ldc 70
    //   798: iconst_0
    //   799: new 131	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   806: ldc 134
    //   808: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload_0
    //   812: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   815: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   818: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
    //   821: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: ldc 143
    //   826: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_0
    //   830: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   833: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   836: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
    //   839: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: ldc 145
    //   844: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_0
    //   848: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   851: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   854: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   857: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: ldc 147
    //   862: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: iload 8
    //   867: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload_0
    //   877: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   880: getfield 155	com/tencent/TMG/camera/VcCamera:mFrameSizes	Ljava/util/List;
    //   883: ifnull +439 -> 1322
    //   886: aload_0
    //   887: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   890: getfield 155	com/tencent/TMG/camera/VcCamera:mFrameSizes	Ljava/util/List;
    //   893: invokeinterface 161 1 0
    //   898: astore 13
    //   900: aload 13
    //   902: invokeinterface 167 1 0
    //   907: ifeq +415 -> 1322
    //   910: aload 13
    //   912: invokeinterface 171 1 0
    //   917: checkcast 173	android/hardware/Camera$Size
    //   920: astore 14
    //   922: aload 14
    //   924: getfield 174	android/hardware/Camera$Size:height	I
    //   927: aload 14
    //   929: getfield 175	android/hardware/Camera$Size:width	I
    //   932: imul
    //   933: aload_0
    //   934: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   937: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   940: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   943: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
    //   946: imul
    //   947: bipush 8
    //   949: idiv
    //   950: iload 8
    //   952: if_icmpne -52 -> 900
    //   955: ldc 70
    //   957: iconst_0
    //   958: new 131	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   965: ldc 177
    //   967: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload 14
    //   972: getfield 175	android/hardware/Camera$Size:width	I
    //   975: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: ldc 143
    //   980: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 14
    //   985: getfield 174	android/hardware/Camera$Size:height	I
    //   988: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   991: ldc 145
    //   993: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload_0
    //   997: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1000: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   1003: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   1006: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: ldc 147
    //   1011: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: iload 8
    //   1016: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload 14
    //   1027: getfield 175	android/hardware/Camera$Size:width	I
    //   1030: aload 14
    //   1032: getfield 174	android/hardware/Camera$Size:height	I
    //   1035: if_icmplt -135 -> 900
    //   1038: aload_0
    //   1039: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1042: aload_1
    //   1043: iload 8
    //   1045: aload 14
    //   1047: getfield 175	android/hardware/Camera$Size:width	I
    //   1050: aload 14
    //   1052: getfield 174	android/hardware/Camera$Size:height	I
    //   1055: iload 7
    //   1057: aload_0
    //   1058: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1061: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   1064: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   1067: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
    //   1070: iconst_1
    //   1071: istore_3
    //   1072: iload_3
    //   1073: istore 4
    //   1075: iload_3
    //   1076: ifne +157 -> 1233
    //   1079: iload_3
    //   1080: istore 4
    //   1082: aload_2
    //   1083: ifnull +150 -> 1233
    //   1086: aload_2
    //   1087: invokevirtual 187	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1090: astore 13
    //   1092: iload_3
    //   1093: istore 4
    //   1095: aload 13
    //   1097: ifnull +136 -> 1233
    //   1100: aload 13
    //   1102: invokevirtual 193	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1105: getfield 175	android/hardware/Camera$Size:width	I
    //   1108: istore 9
    //   1110: aload 13
    //   1112: invokevirtual 193	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1115: getfield 174	android/hardware/Camera$Size:height	I
    //   1118: istore 10
    //   1120: aload 13
    //   1122: invokevirtual 196	android/hardware/Camera$Parameters:getPreviewFormat	()I
    //   1125: istore 11
    //   1127: ldc 70
    //   1129: iconst_0
    //   1130: new 131	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   1137: ldc 198
    //   1139: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: iload 9
    //   1144: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1147: ldc 200
    //   1149: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: iload 10
    //   1154: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1157: ldc 202
    //   1159: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: iload 11
    //   1164: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: ldc 147
    //   1169: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: iload 8
    //   1174: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1183: iload 9
    //   1185: iload 10
    //   1187: imul
    //   1188: iload 11
    //   1190: invokestatic 129	android/graphics/ImageFormat:getBitsPerPixel	(I)I
    //   1193: imul
    //   1194: bipush 8
    //   1196: idiv
    //   1197: istore 12
    //   1199: iload_3
    //   1200: istore 4
    //   1202: iload 12
    //   1204: iload 8
    //   1206: if_icmpne +27 -> 1233
    //   1209: aload_0
    //   1210: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1213: aload_1
    //   1214: iload 8
    //   1216: iload 9
    //   1218: iload 10
    //   1220: iload 7
    //   1222: iload 11
    //   1224: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
    //   1227: iload 5
    //   1229: istore_3
    //   1230: iload_3
    //   1231: istore 4
    //   1233: iload 4
    //   1235: ifne +11 -> 1246
    //   1238: ldc 70
    //   1240: iconst_0
    //   1241: ldc 204
    //   1243: invokestatic 78	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1246: aload_0
    //   1247: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1250: getfield 208	com/tencent/TMG/camera/VcCamera:mCallbackBufferAddStrategy	Lcom/tencent/TMG/camera/CallbackBufferAddStrategy;
    //   1253: aload_2
    //   1254: aload_1
    //   1255: invokevirtual 214	com/tencent/TMG/camera/CallbackBufferAddStrategy:supplement	(Landroid/hardware/Camera;[B)V
    //   1258: return
    //   1259: astore 13
    //   1261: aload 13
    //   1263: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   1266: goto -36 -> 1230
    //   1269: aload_0
    //   1270: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1273: aload_1
    //   1274: iload 8
    //   1276: aload_0
    //   1277: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1280: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   1283: getfield 118	com/tencent/TMG/camera/CameraCaptureSettings:width	I
    //   1286: aload_0
    //   1287: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1290: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   1293: getfield 121	com/tencent/TMG/camera/CameraCaptureSettings:height	I
    //   1296: iload 7
    //   1298: aload_0
    //   1299: getfield 12	com/tencent/TMG/camera/VcCamera$7:this$0	Lcom/tencent/TMG/camera/VcCamera;
    //   1302: getfield 113	com/tencent/TMG/camera/VcCamera:VideoChatSettings	Lcom/tencent/TMG/camera/CameraCaptureSettings;
    //   1305: getfield 124	com/tencent/TMG/camera/CameraCaptureSettings:format	I
    //   1308: invokestatic 181	com/tencent/TMG/camera/VcCamera:access$1000	(Lcom/tencent/TMG/camera/VcCamera;[BIIIII)V
    //   1311: goto -65 -> 1246
    //   1314: astore 13
    //   1316: iload 6
    //   1318: istore_3
    //   1319: goto -58 -> 1261
    //   1322: iconst_0
    //   1323: istore_3
    //   1324: goto -252 -> 1072
    //   1327: iconst_0
    //   1328: istore_3
    //   1329: goto -1239 -> 90
    //   1332: iconst_0
    //   1333: istore_3
    //   1334: goto -1266 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1337	0	this	7
    //   0	1337	1	paramArrayOfByte	byte[]
    //   0	1337	2	paramCamera	android.hardware.Camera
    //   67	1267	3	i	int
    //   99	1135	4	j	int
    //   4	1224	5	k	int
    //   1	1316	6	m	int
    //   223	1074	7	n	int
    //   751	524	8	i1	int
    //   1108	109	9	i2	int
    //   1118	101	10	i3	int
    //   1125	98	11	i4	int
    //   1197	10	12	i5	int
    //   898	223	13	localObject	Object
    //   1259	3	13	localException1	java.lang.Exception
    //   1314	1	13	localException2	java.lang.Exception
    //   920	131	14	localSize	android.hardware.Camera.Size
    // Exception table:
    //   from	to	target	type
    //   1086	1092	1259	java/lang/Exception
    //   1100	1199	1259	java/lang/Exception
    //   1209	1227	1314	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.7
 * JD-Core Version:    0.7.0.1
 */