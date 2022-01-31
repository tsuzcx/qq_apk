import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public final class bilx
{
  public static final SparseBooleanArray a;
  public static asot a;
  public static String a;
  public static final int[] a;
  public static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "extra.IS_MIXED_MSG";
    b = "extra.IS_REPLY_SRC_MSG_EXIST";
    jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 7, 9 };
    int i = 0;
    if (i < 10)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int k = arrayOfInt.length;
      j = 0;
      label57:
      if (j >= k) {
        break label108;
      }
      if (i == arrayOfInt[j] - 1) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, true);
      }
    }
    label108:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
      }
      i += 1;
      break;
      j += 1;
      break label57;
      return;
    }
  }
  
  public static int a(String paramString)
  {
    paramString = bdcs.b(paramString);
    int i = 0;
    if ("jpg".equals(paramString)) {
      i = 1000;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ImgType", 2, "sender imgType is " + i);
      }
      return i;
      if ("png".equals(paramString)) {
        i = 1001;
      } else if ("bmp".equals(paramString)) {
        i = 1005;
      } else if ("gif".equals(paramString)) {
        i = 2000;
      } else if ("apng".equals(paramString)) {
        i = 2001;
      } else if ("sharpp".equals(paramString)) {
        i = 1004;
      } else if ("webp".equals(paramString)) {
        i = 1002;
      }
    }
  }
  
  /* Error */
  public static java.util.ArrayList<java.lang.Integer> a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 93	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 99	java/io/File:exists	()Z
    //   22: ifeq -15 -> 7
    //   25: invokestatic 103	bddw:a	()V
    //   28: new 105	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 109	java/io/File:length	()J
    //   36: l2i
    //   37: invokespecial 112	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 7
    //   42: new 114	java/io/BufferedInputStream
    //   45: dup
    //   46: new 116	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: astore_0
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore 5
    //   69: aload 4
    //   71: astore_0
    //   72: aload 4
    //   74: aload 5
    //   76: iconst_0
    //   77: sipush 1024
    //   80: invokevirtual 126	java/io/BufferedInputStream:read	([BII)I
    //   83: istore_1
    //   84: iconst_m1
    //   85: iload_1
    //   86: if_icmpeq +117 -> 203
    //   89: aload 4
    //   91: astore_0
    //   92: aload 7
    //   94: aload 5
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 130	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -32 -> 69
    //   104: astore 5
    //   106: aload 4
    //   108: astore_0
    //   109: aload 5
    //   111: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   114: aload 4
    //   116: ifnull +205 -> 321
    //   119: aload 4
    //   121: invokevirtual 136	java/io/BufferedInputStream:close	()V
    //   124: iconst_0
    //   125: istore_1
    //   126: aload 6
    //   128: astore_0
    //   129: iload_1
    //   130: ifeq +59 -> 189
    //   133: new 138	java/util/ArrayList
    //   136: dup
    //   137: bipush 10
    //   139: invokespecial 139	java/util/ArrayList:<init>	(I)V
    //   142: astore 4
    //   144: aload 7
    //   146: invokevirtual 143	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: astore 5
    //   151: aload 5
    //   153: arraylength
    //   154: istore_3
    //   155: iconst_0
    //   156: istore_1
    //   157: aload 4
    //   159: astore_0
    //   160: iload_1
    //   161: iload_3
    //   162: if_icmpge +27 -> 189
    //   165: iload_1
    //   166: iconst_1
    //   167: iadd
    //   168: istore_2
    //   169: aload 5
    //   171: iload_1
    //   172: baload
    //   173: iconst_m1
    //   174: if_icmpne +142 -> 316
    //   177: aload 5
    //   179: iload_2
    //   180: baload
    //   181: bipush 217
    //   183: if_icmpne +82 -> 265
    //   186: aload 4
    //   188: astore_0
    //   189: aload 7
    //   191: invokevirtual 144	java/io/ByteArrayOutputStream:close	()V
    //   194: ldc 146
    //   196: ldc 148
    //   198: invokestatic 151	bddw:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: areturn
    //   203: iconst_1
    //   204: istore_2
    //   205: iload_2
    //   206: istore_1
    //   207: aload 4
    //   209: ifnull -83 -> 126
    //   212: aload 4
    //   214: invokevirtual 136	java/io/BufferedInputStream:close	()V
    //   217: iload_2
    //   218: istore_1
    //   219: goto -93 -> 126
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   227: iload_2
    //   228: istore_1
    //   229: goto -103 -> 126
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   237: iconst_0
    //   238: istore_1
    //   239: goto -113 -> 126
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_0
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 136	java/io/BufferedInputStream:close	()V
    //   254: aload 4
    //   256: athrow
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   262: goto -8 -> 254
    //   265: aload 5
    //   267: iload_2
    //   268: baload
    //   269: bipush 218
    //   271: if_icmpne +45 -> 316
    //   274: aload 4
    //   276: iload_2
    //   277: iconst_1
    //   278: isub
    //   279: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: invokevirtual 160	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: iload_2
    //   287: iconst_1
    //   288: iadd
    //   289: istore_1
    //   290: goto -133 -> 157
    //   293: astore 4
    //   295: aload 4
    //   297: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   300: goto -106 -> 194
    //   303: astore 4
    //   305: goto -59 -> 246
    //   308: astore 5
    //   310: aconst_null
    //   311: astore 4
    //   313: goto -207 -> 106
    //   316: iload_2
    //   317: istore_1
    //   318: goto -161 -> 157
    //   321: iconst_0
    //   322: istore_1
    //   323: goto -197 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString	String
    //   83	240	1	i	int
    //   168	149	2	j	int
    //   154	9	3	k	int
    //   57	156	4	localObject1	Object
    //   242	33	4	localObject2	Object
    //   293	3	4	localIOException1	java.io.IOException
    //   303	1	4	localObject3	Object
    //   311	1	4	localObject4	Object
    //   67	28	5	arrayOfByte1	byte[]
    //   104	6	5	localIOException2	java.io.IOException
    //   149	117	5	arrayOfByte2	byte[]
    //   308	1	5	localIOException3	java.io.IOException
    //   1	126	6	localObject5	Object
    //   40	150	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	69	104	java/io/IOException
    //   72	84	104	java/io/IOException
    //   92	101	104	java/io/IOException
    //   212	217	222	java/io/IOException
    //   119	124	232	java/io/IOException
    //   42	59	242	finally
    //   250	254	257	java/io/IOException
    //   189	194	293	java/io/IOException
    //   62	69	303	finally
    //   72	84	303	finally
    //   92	101	303	finally
    //   109	114	303	finally
    //   42	59	308	java/io/IOException
  }
  
  public static void a(Context paramContext, Bundle paramBundle, agft paramagft, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (localBundle.getBoolean("extra.ENTER_NEW_GALLERY"))
    {
      paramBundle = new Intent(paramContext, com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.class);
      if ((!(paramContext instanceof PublicFragmentActivity)) || (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment))) {
        break label578;
      }
    }
    label312:
    label321:
    label578:
    for (int i = 1;; i = 0)
    {
      if ((!localBundle.getBoolean("extra.EXTRA_NOT_CLEAR_TOP", false)) && (paramInt2 != 3) && (paramInt2 != 2) && (i == 0))
      {
        paramBundle.addFlags(603979776);
        label95:
        localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramagft.asBinder()));
        localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
        localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
        if (paramAIORichMediaData != null) {
          localBundle.putBoolean(jdField_a_of_type_JavaLangString, paramAIORichMediaData.l);
        }
        if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {
          break label418;
        }
        if (!(paramContext instanceof MultiForwardActivity)) {
          break label390;
        }
        paramagft = ((BaseActivity)paramContext).getAppInterface();
        if ((paramagft instanceof QQAppInterface))
        {
          localBundle.putBoolean("extra.FROM_AIO", true);
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localBundle.putString("uin", ((MultiForwardActivity)paramContext).getChatFragment().a().a().jdField_a_of_type_JavaLangString);
          String str = localBundle.getString("extra.GROUP_UIN");
          if ((str != null) && (((QQAppInterface)paramagft).b(str) == 2)) {
            localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          }
          if ((paramAIORichMediaData != null) && (paramAIORichMediaData.k))
          {
            localBundle.putLong("key_multi_forward_seq", ((MultiForwardActivity)paramContext).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
            ((MultiForwardActivity)paramContext).a.a = true;
          }
        }
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
        if (ChatHistoryActivity.a(paramContext, localBundle)) {
          paramInt1 = 38;
        }
        paramBundle.putExtras(localBundle);
        if (paramInt1 >= 0) {
          break label558;
        }
        paramContext.startActivity(paramBundle);
      }
      for (;;)
      {
        if (jdField_a_of_type_Asot != null) {
          jdField_a_of_type_Asot.b();
        }
        return;
        paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
        break;
        paramBundle.addFlags(536870912);
        break label95;
        localBundle.putBoolean("extra.FROM_AIO", true);
        localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
        break label312;
        if ((paramContext instanceof ChatHistoryActivity))
        {
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label321;
        }
        if ((paramContext instanceof ChatHistory))
        {
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label321;
        }
        if ((paramContext instanceof PublicFragmentActivity))
        {
          if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
            break label321;
          }
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
          break label321;
        }
        if (!(paramContext instanceof ChatHistoryFileActivity)) {
          break label321;
        }
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
        break label321;
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 2000) || (paramInt == 3);
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_0
    //   19: ifnonnull +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: new 93	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 99	java/io/File:exists	()Z
    //   39: ifeq -17 -> 22
    //   42: aload_0
    //   43: invokestatic 358	bdda:b	(Ljava/lang/String;)Z
    //   46: ifeq -24 -> 22
    //   49: invokestatic 103	bddw:a	()V
    //   52: new 116	java/io/FileInputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 5
    //   63: aload 11
    //   65: astore 6
    //   67: aload 10
    //   69: astore 7
    //   71: aload 9
    //   73: astore 8
    //   75: aload 5
    //   77: invokevirtual 362	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   80: astore_0
    //   81: aload_0
    //   82: astore 6
    //   84: aload_0
    //   85: astore 7
    //   87: aload_0
    //   88: astore 8
    //   90: aload_0
    //   91: getstatic 368	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   94: lconst_0
    //   95: aload_0
    //   96: invokevirtual 373	java/nio/channels/FileChannel:size	()J
    //   99: invokevirtual 377	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   102: astore 9
    //   104: aload_0
    //   105: astore 6
    //   107: aload_0
    //   108: astore 7
    //   110: aload_0
    //   111: astore 8
    //   113: aload_0
    //   114: invokevirtual 373	java/nio/channels/FileChannel:size	()J
    //   117: l2i
    //   118: istore_3
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: iload_3
    //   123: if_icmpge +365 -> 488
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: aload_0
    //   131: astore 6
    //   133: aload_0
    //   134: astore 7
    //   136: aload_0
    //   137: astore 8
    //   139: aload 9
    //   141: iload_1
    //   142: invokevirtual 383	java/nio/MappedByteBuffer:get	(I)B
    //   145: iconst_m1
    //   146: if_icmpne +337 -> 483
    //   149: iload_2
    //   150: iload_3
    //   151: if_icmpge +332 -> 483
    //   154: iload_2
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: aload_0
    //   159: astore 6
    //   161: aload_0
    //   162: astore 7
    //   164: aload_0
    //   165: astore 8
    //   167: aload 9
    //   169: iload_2
    //   170: invokevirtual 383	java/nio/MappedByteBuffer:get	(I)B
    //   173: istore_2
    //   174: iload_2
    //   175: bipush 194
    //   177: if_icmpeq +21 -> 198
    //   180: iload_2
    //   181: bipush 198
    //   183: if_icmpeq +15 -> 198
    //   186: iload_2
    //   187: bipush 202
    //   189: if_icmpeq +9 -> 198
    //   192: iload_2
    //   193: bipush 206
    //   195: if_icmpne -74 -> 121
    //   198: iconst_1
    //   199: istore 4
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 384	java/nio/channels/FileChannel:close	()V
    //   209: aload 5
    //   211: ifnull +269 -> 480
    //   214: aload 5
    //   216: invokevirtual 385	java/io/FileInputStream:close	()V
    //   219: ldc 146
    //   221: ldc_w 387
    //   224: invokestatic 151	bddw:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: iload 4
    //   229: ireturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   235: goto -26 -> 209
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   243: goto -24 -> 219
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_0
    //   249: aload 8
    //   251: ifnull +8 -> 259
    //   254: aload 8
    //   256: invokevirtual 384	java/nio/channels/FileChannel:close	()V
    //   259: aload_0
    //   260: ifnull +214 -> 474
    //   263: aload_0
    //   264: invokevirtual 385	java/io/FileInputStream:close	()V
    //   267: iconst_0
    //   268: istore 4
    //   270: goto -51 -> 219
    //   273: astore 5
    //   275: aload 5
    //   277: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   280: goto -21 -> 259
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   288: iconst_0
    //   289: istore 4
    //   291: goto -72 -> 219
    //   294: astore_0
    //   295: aconst_null
    //   296: astore 5
    //   298: aload 7
    //   300: ifnull +8 -> 308
    //   303: aload 7
    //   305: invokevirtual 384	java/nio/channels/FileChannel:close	()V
    //   308: aload 5
    //   310: ifnull +164 -> 474
    //   313: aload 5
    //   315: invokevirtual 385	java/io/FileInputStream:close	()V
    //   318: iconst_0
    //   319: istore 4
    //   321: goto -102 -> 219
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   329: goto -21 -> 308
    //   332: astore_0
    //   333: aload_0
    //   334: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   337: iconst_0
    //   338: istore 4
    //   340: goto -121 -> 219
    //   343: astore_0
    //   344: aconst_null
    //   345: astore 5
    //   347: aload 6
    //   349: ifnull +8 -> 357
    //   352: aload 6
    //   354: invokevirtual 384	java/nio/channels/FileChannel:close	()V
    //   357: aload 5
    //   359: ifnull +115 -> 474
    //   362: aload 5
    //   364: invokevirtual 385	java/io/FileInputStream:close	()V
    //   367: iconst_0
    //   368: istore 4
    //   370: goto -151 -> 219
    //   373: astore_0
    //   374: aload_0
    //   375: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   378: goto -21 -> 357
    //   381: astore_0
    //   382: aload_0
    //   383: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   386: iconst_0
    //   387: istore 4
    //   389: goto -170 -> 219
    //   392: astore_0
    //   393: aconst_null
    //   394: astore 5
    //   396: aconst_null
    //   397: astore 6
    //   399: aload 6
    //   401: ifnull +8 -> 409
    //   404: aload 6
    //   406: invokevirtual 384	java/nio/channels/FileChannel:close	()V
    //   409: aload 5
    //   411: ifnull +8 -> 419
    //   414: aload 5
    //   416: invokevirtual 385	java/io/FileInputStream:close	()V
    //   419: aload_0
    //   420: athrow
    //   421: astore 6
    //   423: aload 6
    //   425: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   428: goto -19 -> 409
    //   431: astore 5
    //   433: aload 5
    //   435: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   438: goto -19 -> 419
    //   441: astore_0
    //   442: aconst_null
    //   443: astore 6
    //   445: goto -46 -> 399
    //   448: astore 7
    //   450: aload_0
    //   451: astore 6
    //   453: aload 7
    //   455: astore_0
    //   456: goto -57 -> 399
    //   459: astore_0
    //   460: goto -113 -> 347
    //   463: astore_0
    //   464: goto -166 -> 298
    //   467: astore_0
    //   468: aload 5
    //   470: astore_0
    //   471: goto -222 -> 249
    //   474: iconst_0
    //   475: istore 4
    //   477: goto -258 -> 219
    //   480: goto -261 -> 219
    //   483: iload_2
    //   484: istore_1
    //   485: goto -364 -> 121
    //   488: iconst_0
    //   489: istore 4
    //   491: goto -290 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	paramString	String
    //   120	365	1	i	int
    //   129	355	2	j	int
    //   118	34	3	k	int
    //   199	291	4	bool	boolean
    //   32	183	5	localObject1	Object
    //   273	3	5	localIOException1	java.io.IOException
    //   296	119	5	localObject2	Object
    //   431	38	5	localIOException2	java.io.IOException
    //   4	401	6	localObject3	Object
    //   421	3	6	localIOException3	java.io.IOException
    //   443	9	6	str	String
    //   1	303	7	localObject4	Object
    //   448	6	7	localObject5	Object
    //   16	239	8	localObject6	Object
    //   13	155	9	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   10	58	10	localObject7	Object
    //   7	57	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   205	209	230	java/io/IOException
    //   214	219	238	java/io/IOException
    //   52	63	246	java/io/FileNotFoundException
    //   254	259	273	java/io/IOException
    //   263	267	283	java/io/IOException
    //   52	63	294	java/io/IOException
    //   303	308	324	java/io/IOException
    //   313	318	332	java/io/IOException
    //   52	63	343	java/lang/IndexOutOfBoundsException
    //   352	357	373	java/io/IOException
    //   362	367	381	java/io/IOException
    //   52	63	392	finally
    //   404	409	421	java/io/IOException
    //   414	419	431	java/io/IOException
    //   75	81	441	finally
    //   90	104	448	finally
    //   113	119	448	finally
    //   139	149	448	finally
    //   167	174	448	finally
    //   75	81	459	java/lang/IndexOutOfBoundsException
    //   90	104	459	java/lang/IndexOutOfBoundsException
    //   113	119	459	java/lang/IndexOutOfBoundsException
    //   139	149	459	java/lang/IndexOutOfBoundsException
    //   167	174	459	java/lang/IndexOutOfBoundsException
    //   75	81	463	java/io/IOException
    //   90	104	463	java/io/IOException
    //   113	119	463	java/io/IOException
    //   139	149	463	java/io/IOException
    //   167	174	463	java/io/IOException
    //   75	81	467	java/io/FileNotFoundException
    //   90	104	467	java/io/FileNotFoundException
    //   113	119	467	java/io/FileNotFoundException
    //   139	149	467	java/io/FileNotFoundException
    //   167	174	467	java/io/FileNotFoundException
  }
  
  public static void b(Context paramContext, Bundle paramBundle, agft paramagft, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramagft.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
    localBundle.putBoolean("extra.IS_GOTO_IMAGELIST", true);
    localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
    paramBundle.putExtras(localBundle);
    boolean bool = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    if (paramInt1 < 0)
    {
      paramContext.startActivity(paramBundle);
      if ((bool) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).overridePendingTransition(2130772045, 2130772050);
      }
    }
    for (;;)
    {
      if (jdField_a_of_type_Asot != null) {
        jdField_a_of_type_Asot.b();
      }
      return;
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilx
 * JD-Core Version:    0.7.0.1
 */