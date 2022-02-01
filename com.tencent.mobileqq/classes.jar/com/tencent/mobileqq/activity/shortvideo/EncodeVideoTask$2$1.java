package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.database.PublishVideoEntry;

class EncodeVideoTask$2$1
  implements Runnable
{
  EncodeVideoTask$2$1(EncodeVideoTask.2 param2, String paramString, PublishVideoEntry paramPublishVideoEntry) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_1
    //   7: bipush 249
    //   9: istore_2
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$videoPath	Ljava/lang/String;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokestatic 37	bjme:a	(Ljava/lang/String;ZZ)V
    //   19: aload_0
    //   20: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   23: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   26: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   29: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +21 -> 53
    //   35: aload_0
    //   36: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   39: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   42: aload_0
    //   43: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   46: getfield 60	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   49: invokestatic 64	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$402	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   52: pop
    //   53: aload_0
    //   54: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   57: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   60: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   63: ifnull +327 -> 390
    //   66: aload_0
    //   67: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   70: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   73: aload_0
    //   74: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   77: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   80: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   83: getfield 73	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:thumbMd5String	Ljava/lang/String;
    //   86: invokestatic 76	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$602	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: aload_0
    //   91: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   94: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   97: astore 7
    //   99: aload_0
    //   100: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   103: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   106: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   109: getfield 80	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:thumbMd5	[B
    //   112: ifnonnull +260 -> 372
    //   115: aload_0
    //   116: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   119: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   122: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   125: invokestatic 89	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   128: astore 6
    //   130: aload 7
    //   132: aload 6
    //   134: invokestatic 93	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$702	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   137: pop
    //   138: aload_0
    //   139: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   142: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   145: aload_0
    //   146: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   149: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   152: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   155: getfield 97	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:width	I
    //   158: invokestatic 101	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$802	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   161: pop
    //   162: aload_0
    //   163: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   166: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   169: aload_0
    //   170: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   173: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   176: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   179: getfield 104	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:hight	I
    //   182: invokestatic 107	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$902	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   185: pop
    //   186: aload_0
    //   187: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   190: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   193: aload_0
    //   194: getfield 18	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$videoPath	Ljava/lang/String;
    //   197: invokestatic 110	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1002	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   200: pop
    //   201: aload_0
    //   202: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   205: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   208: invokestatic 113	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1000	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   211: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +981 -> 1195
    //   217: new 115	java/io/File
    //   220: dup
    //   221: aload_0
    //   222: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   225: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   228: invokestatic 113	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1000	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   231: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: astore 6
    //   236: iload_1
    //   237: istore_2
    //   238: aload 6
    //   240: invokevirtual 122	java/io/File:exists	()Z
    //   243: ifeq +85 -> 328
    //   246: new 124	java/io/FileInputStream
    //   249: dup
    //   250: aload_0
    //   251: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   254: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   257: invokestatic 113	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1000	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   260: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   263: astore 7
    //   265: aload 6
    //   267: invokevirtual 129	java/io/File:length	()J
    //   270: lstore 4
    //   272: aload_0
    //   273: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   276: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   279: aload 7
    //   281: lload 4
    //   283: invokestatic 135	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   286: invokestatic 138	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1102	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   289: pop
    //   290: aload_0
    //   291: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   294: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   297: aload_0
    //   298: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   301: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   304: invokestatic 142	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1100	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   307: invokestatic 146	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   310: invokestatic 149	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1202	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   313: pop
    //   314: iload_1
    //   315: istore_2
    //   316: aload 7
    //   318: ifnull +10 -> 328
    //   321: aload 7
    //   323: invokevirtual 152	java/io/FileInputStream:close	()V
    //   326: iload_1
    //   327: istore_2
    //   328: iload_2
    //   329: ifeq +872 -> 1201
    //   332: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +28 -> 363
    //   338: ldc 159
    //   340: iconst_2
    //   341: new 161	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   348: ldc 164
    //   350: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_2
    //   354: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   367: iload_2
    //   368: invokevirtual 183	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:onError	(I)V
    //   371: return
    //   372: aload_0
    //   373: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   376: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   379: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$500	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   382: getfield 80	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:thumbMd5	[B
    //   385: astore 6
    //   387: goto -257 -> 130
    //   390: aload_0
    //   391: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   394: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   397: aload_0
    //   398: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   401: getfield 186	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   404: invokestatic 101	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$802	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   407: pop
    //   408: aload_0
    //   409: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   412: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   415: aload_0
    //   416: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   419: getfield 189	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   422: invokestatic 107	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$902	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   425: pop
    //   426: new 115	java/io/File
    //   429: dup
    //   430: aload_0
    //   431: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   434: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   437: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   440: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   443: astore 8
    //   445: aload 8
    //   447: invokevirtual 122	java/io/File:exists	()Z
    //   450: ifeq +616 -> 1066
    //   453: new 124	java/io/FileInputStream
    //   456: dup
    //   457: aload_0
    //   458: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   461: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   464: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   467: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   470: astore 7
    //   472: aload 7
    //   474: astore 6
    //   476: aload 8
    //   478: invokevirtual 129	java/io/File:length	()J
    //   481: lstore 4
    //   483: aload 7
    //   485: astore 6
    //   487: aload_0
    //   488: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   491: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   494: aload 7
    //   496: lload 4
    //   498: invokestatic 135	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   501: invokestatic 93	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$702	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   513: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   516: aload_0
    //   517: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   520: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   523: invokestatic 192	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$700	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   526: invokestatic 146	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   529: invokestatic 76	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$602	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   532: pop
    //   533: aload 7
    //   535: ifnull +8 -> 543
    //   538: aload 7
    //   540: invokevirtual 152	java/io/FileInputStream:close	()V
    //   543: aload_0
    //   544: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   547: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   550: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   553: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   556: ifeq +33 -> 589
    //   559: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +11 -> 573
    //   565: ldc 159
    //   567: iconst_2
    //   568: ldc 194
    //   570: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: bipush 250
    //   575: istore_1
    //   576: goto -390 -> 186
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   586: goto -43 -> 543
    //   589: aload_0
    //   590: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   593: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   596: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   599: ldc 202
    //   601: invokestatic 208	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   604: astore 6
    //   606: aload_0
    //   607: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   610: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   613: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   616: aload 6
    //   618: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   621: ifeq +21 -> 642
    //   624: aload_0
    //   625: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   628: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   631: aload 6
    //   633: invokestatic 64	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$402	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   636: pop
    //   637: iconst_0
    //   638: istore_1
    //   639: goto -63 -> 576
    //   642: aload 6
    //   644: invokestatic 218	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   647: ifne +958 -> 1605
    //   650: iload_2
    //   651: istore_1
    //   652: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq -79 -> 576
    //   658: ldc 159
    //   660: iconst_2
    //   661: new 161	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   668: ldc 220
    //   670: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   677: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   680: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   683: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc 222
    //   688: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 6
    //   693: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload_2
    //   703: istore_1
    //   704: goto -128 -> 576
    //   707: astore 8
    //   709: aconst_null
    //   710: astore 7
    //   712: aload 7
    //   714: astore 6
    //   716: aload 8
    //   718: invokevirtual 223	java/io/FileNotFoundException:printStackTrace	()V
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 152	java/io/FileInputStream:close	()V
    //   731: aload_0
    //   732: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   735: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   738: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   741: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   744: ifeq +33 -> 777
    //   747: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +11 -> 761
    //   753: ldc 159
    //   755: iconst_2
    //   756: ldc 194
    //   758: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: bipush 250
    //   763: istore_1
    //   764: goto -188 -> 576
    //   767: astore 6
    //   769: aload 6
    //   771: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   774: goto -43 -> 731
    //   777: aload_0
    //   778: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   781: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   784: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   787: ldc 202
    //   789: invokestatic 208	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore 6
    //   794: aload_0
    //   795: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   798: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   801: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   804: aload 6
    //   806: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   809: ifeq +21 -> 830
    //   812: aload_0
    //   813: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   816: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   819: aload 6
    //   821: invokestatic 64	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$402	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   824: pop
    //   825: iload_3
    //   826: istore_1
    //   827: goto -251 -> 576
    //   830: iload_3
    //   831: istore_1
    //   832: aload 6
    //   834: invokestatic 218	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   837: ifne -10 -> 827
    //   840: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +47 -> 890
    //   846: ldc 159
    //   848: iconst_2
    //   849: new 161	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   856: ldc 220
    //   858: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_0
    //   862: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   865: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   868: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   871: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc 222
    //   876: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 6
    //   881: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: bipush 249
    //   892: istore_1
    //   893: goto -66 -> 827
    //   896: astore 7
    //   898: aconst_null
    //   899: astore 6
    //   901: aload 6
    //   903: ifnull +8 -> 911
    //   906: aload 6
    //   908: invokevirtual 152	java/io/FileInputStream:close	()V
    //   911: aload_0
    //   912: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   915: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   918: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   921: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   924: ifeq +30 -> 954
    //   927: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +11 -> 941
    //   933: ldc 159
    //   935: iconst_2
    //   936: ldc 194
    //   938: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   941: aload 7
    //   943: athrow
    //   944: astore 6
    //   946: aload 6
    //   948: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   951: goto -40 -> 911
    //   954: aload_0
    //   955: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   958: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   961: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   964: ldc 202
    //   966: invokestatic 208	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   969: astore 6
    //   971: aload_0
    //   972: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   975: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   978: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   981: aload 6
    //   983: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   986: ifeq +19 -> 1005
    //   989: aload_0
    //   990: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   993: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   996: aload 6
    //   998: invokestatic 64	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$402	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   1001: pop
    //   1002: goto -61 -> 941
    //   1005: aload 6
    //   1007: invokestatic 218	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   1010: ifne -69 -> 941
    //   1013: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq -75 -> 941
    //   1019: ldc 159
    //   1021: iconst_2
    //   1022: new 161	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1029: ldc 220
    //   1031: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_0
    //   1035: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1038: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1041: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1044: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc 222
    //   1049: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 6
    //   1054: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1063: goto -122 -> 941
    //   1066: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1069: ifeq +37 -> 1106
    //   1072: ldc 159
    //   1074: iconst_2
    //   1075: new 161	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1082: ldc 225
    //   1084: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1091: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1094: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1097: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: bipush 248
    //   1108: istore_1
    //   1109: goto -923 -> 186
    //   1112: astore 6
    //   1114: aload 6
    //   1116: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   1119: iload_1
    //   1120: istore_2
    //   1121: goto -793 -> 328
    //   1124: astore 7
    //   1126: aload 9
    //   1128: astore 6
    //   1130: aload 7
    //   1132: invokevirtual 223	java/io/FileNotFoundException:printStackTrace	()V
    //   1135: bipush 246
    //   1137: istore_1
    //   1138: iload_1
    //   1139: istore_2
    //   1140: aload 6
    //   1142: ifnull -814 -> 328
    //   1145: aload 6
    //   1147: invokevirtual 152	java/io/FileInputStream:close	()V
    //   1150: iload_1
    //   1151: istore_2
    //   1152: goto -824 -> 328
    //   1155: astore 6
    //   1157: aload 6
    //   1159: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   1162: iload_1
    //   1163: istore_2
    //   1164: goto -836 -> 328
    //   1167: astore 6
    //   1169: aconst_null
    //   1170: astore 7
    //   1172: aload 7
    //   1174: ifnull +8 -> 1182
    //   1177: aload 7
    //   1179: invokevirtual 152	java/io/FileInputStream:close	()V
    //   1182: aload 6
    //   1184: athrow
    //   1185: astore 7
    //   1187: aload 7
    //   1189: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   1192: goto -10 -> 1182
    //   1195: bipush 247
    //   1197: istore_2
    //   1198: goto -870 -> 328
    //   1201: aload_0
    //   1202: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1205: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1208: invokestatic 229	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1300	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1211: ifeq +57 -> 1268
    //   1214: aload_0
    //   1215: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1218: getfield 232	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1221: astore 6
    //   1223: aload_0
    //   1224: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1227: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1230: invokestatic 235	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$200	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1233: ifeq +25 -> 1258
    //   1236: new 115	java/io/File
    //   1239: dup
    //   1240: aload_0
    //   1241: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1244: getfield 232	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1247: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   1250: invokevirtual 239	java/io/File:getParentFile	()Ljava/io/File;
    //   1253: invokevirtual 242	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1256: astore 6
    //   1258: aload 6
    //   1260: invokestatic 247	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:c	(Ljava/lang/String;)V
    //   1263: aload 6
    //   1265: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   1268: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +186 -> 1457
    //   1274: ldc 159
    //   1276: iconst_2
    //   1277: new 161	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1284: ldc 252
    //   1286: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_0
    //   1290: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1293: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1296: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1299: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: ldc 254
    //   1304: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload_0
    //   1308: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1311: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1314: invokestatic 192	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$700	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1317: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1320: ldc_w 259
    //   1323: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: aload_0
    //   1327: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1330: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1333: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$600	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1336: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: ldc_w 261
    //   1342: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: aload_0
    //   1346: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1349: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1352: invokestatic 265	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$800	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1355: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: ldc_w 267
    //   1361: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload_0
    //   1365: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1368: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1371: invokestatic 270	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$900	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1374: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: ldc_w 272
    //   1380: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload_0
    //   1384: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1387: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1390: invokestatic 113	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1000	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1393: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: ldc_w 274
    //   1399: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: aload_0
    //   1403: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1406: getfield 278	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1409: d2i
    //   1410: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1413: ldc_w 280
    //   1416: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload_0
    //   1420: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1423: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1426: invokestatic 142	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1100	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1429: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1432: ldc_w 282
    //   1435: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload_0
    //   1439: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1442: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1445: invokestatic 285	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1200	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1448: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1457: aload_0
    //   1458: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1461: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1464: invokestatic 289	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ResultListener;
    //   1467: ifnull -1096 -> 371
    //   1470: aload_0
    //   1471: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1474: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1477: invokestatic 289	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ResultListener;
    //   1480: aload_0
    //   1481: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1484: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1487: invokestatic 113	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1000	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1490: aload_0
    //   1491: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1494: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1497: invokestatic 142	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$1100	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1500: aload_0
    //   1501: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1504: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1507: invokestatic 49	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$400	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1510: aload_0
    //   1511: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1514: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1517: invokestatic 265	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$800	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1520: aload_0
    //   1521: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1524: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1527: invokestatic 270	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$900	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1530: aload_0
    //   1531: getfield 16	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:this$1	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2;
    //   1534: getfield 43	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2:this$0	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1537: invokestatic 192	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:access$700	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1540: aload_0
    //   1541: getfield 20	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$2$1:val$publishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1544: getfield 278	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1547: d2i
    //   1548: invokeinterface 295 8 0
    //   1553: return
    //   1554: astore 6
    //   1556: aload 6
    //   1558: invokevirtual 296	java/lang/Exception:printStackTrace	()V
    //   1561: goto -293 -> 1268
    //   1564: astore 6
    //   1566: goto -394 -> 1172
    //   1569: astore 8
    //   1571: aload 6
    //   1573: astore 7
    //   1575: aload 8
    //   1577: astore 6
    //   1579: goto -407 -> 1172
    //   1582: astore 8
    //   1584: aload 7
    //   1586: astore 6
    //   1588: aload 8
    //   1590: astore 7
    //   1592: goto -462 -> 1130
    //   1595: astore 7
    //   1597: goto -696 -> 901
    //   1600: astore 8
    //   1602: goto -890 -> 712
    //   1605: iconst_0
    //   1606: istore_1
    //   1607: goto -1031 -> 576
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1610	0	this	1
    //   6	1601	1	i	int
    //   9	1189	2	j	int
    //   4	827	3	k	int
    //   270	227	4	l	long
    //   128	380	6	localObject1	Object
    //   579	3	6	localIOException1	java.io.IOException
    //   604	111	6	localObject2	Object
    //   767	3	6	localIOException2	java.io.IOException
    //   792	115	6	str1	String
    //   944	3	6	localIOException3	java.io.IOException
    //   969	84	6	str2	String
    //   1112	3	6	localIOException4	java.io.IOException
    //   1128	18	6	localObject3	Object
    //   1155	3	6	localIOException5	java.io.IOException
    //   1167	16	6	localObject4	Object
    //   1221	43	6	str3	String
    //   1554	3	6	localException	java.lang.Exception
    //   1564	8	6	localObject5	Object
    //   1577	10	6	localObject6	Object
    //   97	630	7	localObject7	Object
    //   896	46	7	localObject8	Object
    //   1124	7	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   1170	8	7	localObject9	Object
    //   1185	3	7	localIOException6	java.io.IOException
    //   1573	18	7	localObject10	Object
    //   1595	1	7	localObject11	Object
    //   443	34	8	localFile	java.io.File
    //   707	10	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   1569	7	8	localObject12	Object
    //   1582	7	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1600	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	1126	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   538	543	579	java/io/IOException
    //   453	472	707	java/io/FileNotFoundException
    //   726	731	767	java/io/IOException
    //   453	472	896	finally
    //   906	911	944	java/io/IOException
    //   321	326	1112	java/io/IOException
    //   246	265	1124	java/io/FileNotFoundException
    //   1145	1150	1155	java/io/IOException
    //   246	265	1167	finally
    //   1177	1182	1185	java/io/IOException
    //   1201	1223	1554	java/lang/Exception
    //   1223	1258	1554	java/lang/Exception
    //   1258	1268	1554	java/lang/Exception
    //   265	314	1564	finally
    //   1130	1135	1569	finally
    //   265	314	1582	java/io/FileNotFoundException
    //   476	483	1595	finally
    //   487	505	1595	finally
    //   509	533	1595	finally
    //   716	721	1595	finally
    //   476	483	1600	java/io/FileNotFoundException
    //   487	505	1600	java/io/FileNotFoundException
    //   509	533	1600	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1
 * JD-Core Version:    0.7.0.1
 */