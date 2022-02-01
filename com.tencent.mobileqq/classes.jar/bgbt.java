import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera.Parameters;
import android.view.Window;
import java.util.List;

public class bgbt
{
  private bgbs a = bgbs.a();
  
  public static bgbt a()
  {
    return bgbv.a;
  }
  
  public int a()
  {
    return 1;
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public android.app.Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload 7
    //   2: invokevirtual 39	com/tencent/mobileqq/app/QQAppInterface:isOpenNoClearNotification	()Z
    //   5: istore 10
    //   7: ldc 40
    //   9: istore 9
    //   11: aload_1
    //   12: ldc 42
    //   14: iconst_m1
    //   15: invokevirtual 48	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   18: sipush 1008
    //   21: if_icmpne +199 -> 220
    //   24: getstatic 54	com/tencent/mobileqq/app/AppConstants:REMINDER_UIN	Ljava/lang/String;
    //   27: aload_1
    //   28: ldc 56
    //   30: invokevirtual 60	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +177 -> 213
    //   39: iload 9
    //   41: istore 8
    //   43: aload_1
    //   44: ldc 68
    //   46: iconst_0
    //   47: invokevirtual 72	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   50: ifeq +7 -> 57
    //   53: ldc 73
    //   55: istore 8
    //   57: aload_1
    //   58: ldc 75
    //   60: iload 8
    //   62: invokevirtual 79	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   65: pop
    //   66: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   69: iconst_0
    //   70: aload_1
    //   71: ldc 86
    //   73: invokestatic 92	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   76: astore_1
    //   77: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +28 -> 108
    //   83: ldc 99
    //   85: iconst_2
    //   86: new 101	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   93: ldc 104
    //   95: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   111: bipush 11
    //   113: if_icmpge +204 -> 317
    //   116: new 127	android/app/Notification
    //   119: dup
    //   120: iload 8
    //   122: aload_3
    //   123: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   126: invokespecial 136	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   129: astore_2
    //   130: aload_2
    //   131: aload_1
    //   132: putfield 140	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   135: iload 10
    //   137: ifeq +24 -> 161
    //   140: aload_2
    //   141: aload_2
    //   142: getfield 143	android/app/Notification:flags	I
    //   145: bipush 32
    //   147: ior
    //   148: putfield 143	android/app/Notification:flags	I
    //   151: aload_2
    //   152: aload_2
    //   153: getfield 143	android/app/Notification:flags	I
    //   156: iconst_2
    //   157: ior
    //   158: putfield 143	android/app/Notification:flags	I
    //   161: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   164: aload 7
    //   166: invokestatic 148	bfrg:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   169: ifeq +42 -> 211
    //   172: invokestatic 154	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   175: bipush 11
    //   177: invokevirtual 158	java/util/Calendar:get	(I)I
    //   180: pop
    //   181: aload_2
    //   182: aload_2
    //   183: getfield 143	android/app/Notification:flags	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 143	android/app/Notification:flags	I
    //   191: aload_2
    //   192: ldc 159
    //   194: putfield 162	android/app/Notification:ledARGB	I
    //   197: aload_2
    //   198: sipush 2000
    //   201: putfield 165	android/app/Notification:ledOffMS	I
    //   204: aload_2
    //   205: sipush 2000
    //   208: putfield 168	android/app/Notification:ledOnMS	I
    //   211: aload_2
    //   212: areturn
    //   213: ldc 169
    //   215: istore 8
    //   217: goto -174 -> 43
    //   220: aload_1
    //   221: ldc 42
    //   223: iconst_m1
    //   224: invokevirtual 48	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   227: sipush 1010
    //   230: if_icmpne +28 -> 258
    //   233: getstatic 172	com/tencent/mobileqq/app/AppConstants:DATE_UIN	Ljava/lang/String;
    //   236: invokestatic 176	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   239: aload_1
    //   240: ldc 56
    //   242: invokevirtual 60	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +10 -> 258
    //   251: ldc 177
    //   253: istore 8
    //   255: goto -212 -> 43
    //   258: aload_1
    //   259: ldc 42
    //   261: iconst_m1
    //   262: invokevirtual 48	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   265: sipush 1001
    //   268: if_icmpeq +20 -> 288
    //   271: iload 9
    //   273: istore 8
    //   275: aload_1
    //   276: ldc 42
    //   278: iconst_m1
    //   279: invokevirtual 48	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   282: sipush 10002
    //   285: if_icmpne -242 -> 43
    //   288: iload 9
    //   290: istore 8
    //   292: getstatic 180	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   295: invokestatic 176	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   298: aload_1
    //   299: ldc 56
    //   301: invokevirtual 60	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   304: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq -264 -> 43
    //   310: ldc 181
    //   312: istore 8
    //   314: goto -271 -> 43
    //   317: new 183	android/app/Notification$Builder
    //   320: dup
    //   321: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   324: invokespecial 186	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   327: iload 8
    //   329: invokevirtual 190	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   332: iconst_1
    //   333: invokevirtual 194	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   336: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   339: invokevirtual 198	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   342: aload_3
    //   343: invokevirtual 202	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   346: astore 11
    //   348: iload 10
    //   350: ifeq +10 -> 360
    //   353: aload 11
    //   355: iconst_1
    //   356: invokevirtual 205	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   359: pop
    //   360: ldc 207
    //   362: invokestatic 213	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   365: ldc 215
    //   367: iconst_1
    //   368: anewarray 209	java/lang/Class
    //   371: dup
    //   372: iconst_0
    //   373: getstatic 221	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   376: aastore
    //   377: invokevirtual 225	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   380: astore 12
    //   382: aload 12
    //   384: ifnull +22 -> 406
    //   387: aload 12
    //   389: aload 11
    //   391: iconst_1
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: iconst_1
    //   398: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: aastore
    //   402: invokevirtual 234	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   409: aload 7
    //   411: invokestatic 148	bfrg:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   414: ifeq +26 -> 440
    //   417: invokestatic 154	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   420: bipush 11
    //   422: invokevirtual 158	java/util/Calendar:get	(I)I
    //   425: pop
    //   426: aload 11
    //   428: ldc 159
    //   430: sipush 2000
    //   433: sipush 2000
    //   436: invokevirtual 238	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   439: pop
    //   440: iload 6
    //   442: ifeq +57 -> 499
    //   445: aload_2
    //   446: ifnull +10 -> 456
    //   449: aload 11
    //   451: aload_2
    //   452: invokevirtual 242	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   455: pop
    //   456: aload 11
    //   458: aload 4
    //   460: invokevirtual 245	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   463: aload 5
    //   465: invokevirtual 248	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   468: aload_1
    //   469: invokevirtual 252	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   472: pop
    //   473: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   476: bipush 16
    //   478: if_icmplt +52 -> 530
    //   481: aload 11
    //   483: invokevirtual 256	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   486: astore_1
    //   487: aload_1
    //   488: areturn
    //   489: astore 12
    //   491: aload 12
    //   493: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   496: goto -90 -> 406
    //   499: aload 11
    //   501: aload 4
    //   503: invokevirtual 245	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   506: aload 5
    //   508: invokevirtual 248	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   511: aload_1
    //   512: invokevirtual 252	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   515: pop
    //   516: aload_2
    //   517: ifnull -44 -> 473
    //   520: aload 11
    //   522: aload_2
    //   523: invokevirtual 242	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   526: pop
    //   527: goto -54 -> 473
    //   530: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   533: bipush 16
    //   535: if_icmpge +17 -> 552
    //   538: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   541: bipush 11
    //   543: if_icmplt +9 -> 552
    //   546: aload 11
    //   548: invokevirtual 262	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   551: areturn
    //   552: new 127	android/app/Notification
    //   555: dup
    //   556: iload 8
    //   558: aload_3
    //   559: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   562: invokespecial 136	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   565: astore_1
    //   566: aload_1
    //   567: areturn
    //   568: astore_1
    //   569: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +14 -> 586
    //   575: ldc_w 264
    //   578: iconst_2
    //   579: aload_1
    //   580: invokevirtual 267	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   583: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: new 127	android/app/Notification
    //   589: dup
    //   590: iload 8
    //   592: aload_3
    //   593: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   596: invokespecial 136	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   599: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	bgbt
    //   0	600	1	paramIntent	Intent
    //   0	600	2	paramBitmap	Bitmap
    //   0	600	3	paramString1	String
    //   0	600	4	paramString2	String
    //   0	600	5	paramString3	String
    //   0	600	6	paramBoolean	boolean
    //   0	600	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   41	550	8	i	int
    //   9	280	9	j	int
    //   5	344	10	bool	boolean
    //   346	201	11	localBuilder	android.app.Notification.Builder
    //   380	8	12	localMethod	java.lang.reflect.Method
    //   489	3	12	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   360	382	489	java/lang/Exception
    //   387	406	489	java/lang/Exception
    //   473	487	568	java/lang/Exception
    //   530	552	568	java/lang/Exception
    //   552	566	568	java/lang/Exception
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(b()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public String a()
  {
    return bgbs.a;
  }
  
  public String a(Camera.Parameters paramParameters)
  {
    String str = "off";
    List localList = paramParameters.getSupportedFlashModes();
    if (localList.contains("torch")) {
      paramParameters = "torch";
    }
    do
    {
      return paramParameters;
      if (localList.contains("on")) {
        return "on";
      }
      paramParameters = str;
    } while (!localList.contains("auto"));
    return "auto";
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public boolean a()
  {
    return (!this.a.a(0)) && (this.a.a(1));
  }
  
  public String b()
  {
    return bgbs.c;
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbt
 * JD-Core Version:    0.7.0.1
 */