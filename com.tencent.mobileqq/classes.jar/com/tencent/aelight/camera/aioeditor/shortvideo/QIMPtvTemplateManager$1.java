package com.tencent.aelight.camera.aioeditor.shortvideo;

class QIMPtvTemplateManager$1
  implements Runnable
{
  QIMPtvTemplateManager$1(QIMPtvTemplateManager paramQIMPtvTemplateManager, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   4: getfield 31	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:f	Ljava/util/List;
    //   7: invokeinterface 37 1 0
    //   12: ifne +11 -> 23
    //   15: aload_0
    //   16: getfield 16	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:a	Z
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aconst_null
    //   24: astore_3
    //   25: invokestatic 43	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: invokevirtual 47	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   31: ldc 49
    //   33: invokevirtual 55	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokestatic 60	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_2
    //   47: ifnull +80 -> 127
    //   50: aload_2
    //   51: invokevirtual 65	java/io/InputStream:close	()V
    //   54: aload_3
    //   55: astore_1
    //   56: goto +71 -> 127
    //   59: astore_2
    //   60: aload_3
    //   61: astore_1
    //   62: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +62 -> 127
    //   68: aload_2
    //   69: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   72: aload_3
    //   73: astore_1
    //   74: goto +53 -> 127
    //   77: astore_3
    //   78: goto +10 -> 88
    //   81: astore_1
    //   82: goto +294 -> 376
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +9 -> 102
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull +21 -> 124
    //   106: aload_2
    //   107: invokevirtual 65	java/io/InputStream:close	()V
    //   110: goto +14 -> 124
    //   113: astore_1
    //   114: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   124: ldc 76
    //   126: astore_1
    //   127: aload_0
    //   128: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   131: aload_1
    //   132: invokestatic 79	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:a	(Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;Ljava/lang/String;)Ljava/util/List;
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +233 -> 370
    //   140: aload_1
    //   141: invokeinterface 37 1 0
    //   146: ifeq +4 -> 150
    //   149: return
    //   150: aload_1
    //   151: invokeinterface 83 1 0
    //   156: astore_2
    //   157: aload_2
    //   158: invokeinterface 88 1 0
    //   163: ifeq +135 -> 298
    //   166: aload_2
    //   167: invokeinterface 92 1 0
    //   172: checkcast 94	com/tencent/aelight/camera/aioeditor/capture/data/TemplateGroupItem
    //   175: getfield 96	com/tencent/aelight/camera/aioeditor/capture/data/TemplateGroupItem:a	Ljava/util/List;
    //   178: invokeinterface 83 1 0
    //   183: astore_3
    //   184: aload_3
    //   185: invokeinterface 88 1 0
    //   190: ifeq -33 -> 157
    //   193: aload_3
    //   194: invokeinterface 92 1 0
    //   199: checkcast 98	com/tencent/aelight/camera/struct/editor/PtvTemplateInfo
    //   202: astore 4
    //   204: aload 4
    //   206: ifnull -22 -> 184
    //   209: aload 4
    //   211: aload_0
    //   212: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   215: aload 4
    //   217: invokevirtual 101	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:a	(Lcom/tencent/aelight/camera/struct/editor/PtvTemplateInfo;)Z
    //   220: putfield 104	com/tencent/aelight/camera/struct/editor/PtvTemplateInfo:g	Z
    //   223: aload 4
    //   225: getfield 104	com/tencent/aelight/camera/struct/editor/PtvTemplateInfo:g	Z
    //   228: ifne -44 -> 184
    //   231: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -50 -> 184
    //   237: new 106	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   244: astore 5
    //   246: aload 5
    //   248: ldc 109
    //   250: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 5
    //   256: aload 4
    //   258: getfield 116	com/tencent/aelight/camera/struct/editor/PtvTemplateInfo:a	Ljava/lang/String;
    //   261: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 5
    //   267: ldc 118
    //   269: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 5
    //   275: aload 4
    //   277: getfield 121	com/tencent/aelight/camera/struct/editor/PtvTemplateInfo:d	Ljava/lang/String;
    //   280: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: ldc 123
    //   286: iconst_2
    //   287: aload 5
    //   289: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 131	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: goto -111 -> 184
    //   298: aload_0
    //   299: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   302: getfield 134	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:g	Ljava/lang/Object;
    //   305: astore_2
    //   306: aload_2
    //   307: monitorenter
    //   308: aload_0
    //   309: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   312: getfield 31	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:f	Ljava/util/List;
    //   315: invokeinterface 37 1 0
    //   320: ifeq +17 -> 337
    //   323: aload_0
    //   324: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   327: getfield 31	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:f	Ljava/util/List;
    //   330: aload_1
    //   331: invokeinterface 138 2 0
    //   336: pop
    //   337: aload_0
    //   338: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   341: invokevirtual 141	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:g	()Lcom/tencent/common/app/AppInterface;
    //   344: ifnull +18 -> 362
    //   347: aload_0
    //   348: getfield 14	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager$1:this$0	Lcom/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager;
    //   351: invokevirtual 141	com/tencent/aelight/camera/aioeditor/shortvideo/QIMPtvTemplateManager:g	()Lcom/tencent/common/app/AppInterface;
    //   354: ldc 143
    //   356: iconst_3
    //   357: iconst_1
    //   358: aconst_null
    //   359: invokevirtual 149	com/tencent/common/app/AppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   362: aload_2
    //   363: monitorexit
    //   364: return
    //   365: astore_1
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    //   370: return
    //   371: astore_2
    //   372: aload_1
    //   373: astore_3
    //   374: aload_2
    //   375: astore_1
    //   376: aload_3
    //   377: ifnull +21 -> 398
    //   380: aload_3
    //   381: invokevirtual 65	java/io/InputStream:close	()V
    //   384: goto +14 -> 398
    //   387: astore_2
    //   388: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   398: goto +5 -> 403
    //   401: aload_1
    //   402: athrow
    //   403: goto -2 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	1
    //   38	36	1	localObject1	Object
    //   81	1	1	localObject2	Object
    //   89	9	1	localObject3	Object
    //   113	8	1	localException1	java.lang.Exception
    //   126	205	1	localObject4	Object
    //   365	8	1	localObject5	Object
    //   375	27	1	localObject6	Object
    //   36	15	2	localInputStream	java.io.InputStream
    //   59	10	2	localException2	java.lang.Exception
    //   371	4	2	localObject8	Object
    //   387	8	2	localException3	java.lang.Exception
    //   24	49	3	str	java.lang.String
    //   77	1	3	localIOException1	java.io.IOException
    //   85	14	3	localIOException2	java.io.IOException
    //   183	198	3	localObject9	Object
    //   202	74	4	localPtvTemplateInfo	com.tencent.aelight.camera.struct.editor.PtvTemplateInfo
    //   244	44	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	54	59	java/lang/Exception
    //   39	44	77	java/io/IOException
    //   25	37	81	finally
    //   25	37	85	java/io/IOException
    //   106	110	113	java/lang/Exception
    //   308	337	365	finally
    //   337	362	365	finally
    //   362	364	365	finally
    //   366	368	365	finally
    //   39	44	371	finally
    //   90	96	371	finally
    //   98	102	371	finally
    //   380	384	387	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.1
 * JD-Core Version:    0.7.0.1
 */