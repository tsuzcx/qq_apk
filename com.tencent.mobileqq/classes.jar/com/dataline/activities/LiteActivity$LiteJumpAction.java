package com.dataline.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import bw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteActivity$LiteJumpAction
{
  int jdField_a_of_type_Int;
  LiteActivity jdField_a_of_type_ComDatalineActivitiesLiteActivity;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public LiteActivity$LiteJumpAction(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity2;
  }
  
  /* Error */
  String a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 28	android/net/Uri:getScheme	()Ljava/lang/String;
    //   6: astore 4
    //   8: ldc 30
    //   10: aload 4
    //   12: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +20 -> 35
    //   18: new 38	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokevirtual 41	android/net/Uri:getPath	()Ljava/lang/String;
    //   26: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 47	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: areturn
    //   35: ldc 49
    //   37: aload 4
    //   39: invokevirtual 36	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +110 -> 152
    //   45: aload_0
    //   46: getfield 18	com/dataline/activities/LiteActivity$LiteJumpAction:jdField_a_of_type_ComDatalineActivitiesLiteActivity	Lcom/dataline/activities/LiteActivity;
    //   49: invokevirtual 55	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   52: aload_1
    //   53: iconst_1
    //   54: anewarray 32	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: ldc 57
    //   61: aastore
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 63	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_3
    //   71: aload_1
    //   72: ldc 57
    //   74: invokeinterface 69 2 0
    //   79: istore_2
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: invokeinterface 73 1 0
    //   88: pop
    //   89: aload_1
    //   90: astore_3
    //   91: aload_1
    //   92: iload_2
    //   93: invokeinterface 77 2 0
    //   98: astore 4
    //   100: aload 4
    //   102: astore_3
    //   103: aload_1
    //   104: ifnull -71 -> 33
    //   107: aload_1
    //   108: invokeinterface 80 1 0
    //   113: aload 4
    //   115: areturn
    //   116: astore 4
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: astore_3
    //   122: aload 4
    //   124: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +35 -> 163
    //   131: aload_1
    //   132: invokeinterface 80 1 0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull +9 -> 150
    //   144: aload_3
    //   145: invokeinterface 80 1 0
    //   150: aload_1
    //   151: athrow
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: goto -15 -> 140
    //   158: astore 4
    //   160: goto -40 -> 120
    //   163: aconst_null
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	LiteJumpAction
    //   0	165	1	paramUri	Uri
    //   79	14	2	i	int
    //   1	144	3	localObject	Object
    //   6	108	4	str	String
    //   116	7	4	localException1	Exception
    //   158	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   45	69	116	java/lang/Exception
    //   45	69	139	finally
    //   71	80	154	finally
    //   82	89	154	finally
    //   91	100	154	finally
    //   122	127	154	finally
    //   71	80	158	java/lang/Exception
    //   82	89	158	java/lang/Exception
    //   91	100	158	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (this.jdField_a_of_type_Int == -1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.i(LiteActivity.a, 1, "sendMultipleFileWithFileProvider. [fileType] = " + this.jdField_a_of_type_Int);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i(LiteActivity.a, 1, "[filePath] = " + str);
      }
    }
    this.b.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(Intent paramIntent)
  {
    Bundle localBundle;
    Object localObject;
    try
    {
      localBundle = paramIntent.getExtras();
      if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {
        return;
      }
      paramIntent.putExtra("dataline_share_finish", true);
      localObject = paramIntent.getType();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      if (localBundle == null)
      {
        QLog.e(LiteActivity.a, 1, "LiteJumpAction:doShare type is [" + (String)localObject + "], action is [" + paramIntent.getAction() + "]");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    if ((((String)localObject).startsWith("text")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
    {
      paramIntent = localBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramIntent);
      return;
    }
    if (((String)localObject).startsWith("message"))
    {
      paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramIntent.toString());
      return;
    }
    if (((String)localObject).startsWith("image"))
    {
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.b);
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        a((ArrayList)localObject, true);
        return;
      }
      a((ArrayList)localBundle.get("android.intent.extra.STREAM"), true);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SEND"))
    {
      paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
      if (paramIntent == null)
      {
        LiteActivity.a(this.b);
        return;
      }
      if (((paramIntent instanceof Uri)) && ("text/x-vcard".equals(localObject)) && ("content".equals(paramIntent.getScheme())))
      {
        new bw(this.b).execute(new Object[] { this.b.getApplicationContext(), paramIntent });
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((ArrayList)localObject, false);
      return;
    }
    a((ArrayList)localBundle.get("android.intent.extra.STREAM"), false);
  }
  
  void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    int i = 1;
    if (paramArrayList == null)
    {
      LiteActivity.a(this.b);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str;
    if (paramArrayList.size() == 1)
    {
      str = a((Uri)paramArrayList.get(0));
      if ((TextUtils.isEmpty(str)) || (!new File(str).canRead()))
      {
        localArrayList.add(LiteActivity.a(this.b, (Uri)paramArrayList.get(0)));
        this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_Int = i;
          return;
        }
      }
      localArrayList.add(str);
      if (!paramBoolean) {
        break label183;
      }
    }
    for (;;)
    {
      this.b.a(localArrayList, i);
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = a((Uri)paramArrayList.next());
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
      break;
      label183:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.LiteJumpAction
 * JD-Core Version:    0.7.0.1
 */