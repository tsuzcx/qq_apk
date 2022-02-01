package com.tencent.mobileqq.addfriend.ui;

import android.text.TextWatcher;
import android.widget.EditText;

public class AddFriendVerifyFragment$MaxBytesTextWatcher
  implements TextWatcher
{
  int a;
  EditText b;
  int c;
  int d;
  
  public AddFriendVerifyFragment$MaxBytesTextWatcher(int paramInt, EditText paramEditText)
  {
    this.a = paramInt;
    this.b = paramEditText;
  }
  
  /* Error */
  public void afterTextChanged(android.text.Editable paramEditable)
  {
    // Byte code:
    //   0: ldc 28
    //   2: astore_1
    //   3: aload_0
    //   4: getfield 21	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:b	Landroid/widget/EditText;
    //   7: invokevirtual 34	android/widget/EditText:getText	()Landroid/text/Editable;
    //   10: invokevirtual 38	java/lang/Object:toString	()Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 44	java/lang/String:getBytes	()[B
    //   20: arraylength
    //   21: aload_0
    //   22: getfield 19	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:a	I
    //   25: if_icmple +415 -> 440
    //   28: aload 4
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 46	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:c	I
    //   35: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   38: astore 6
    //   40: aload 4
    //   42: aload_0
    //   43: getfield 46	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:c	I
    //   46: aload_0
    //   47: getfield 52	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:d	I
    //   50: iadd
    //   51: aload 4
    //   53: invokevirtual 56	java/lang/String:length	()I
    //   56: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   59: astore 7
    //   61: aload 4
    //   63: aload_0
    //   64: getfield 46	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:c	I
    //   67: aload_0
    //   68: getfield 46	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:c	I
    //   71: aload_0
    //   72: getfield 52	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:d	I
    //   75: iadd
    //   76: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: astore_1
    //   82: aload 6
    //   84: invokevirtual 44	java/lang/String:getBytes	()[B
    //   87: arraylength
    //   88: aload 7
    //   90: invokevirtual 44	java/lang/String:getBytes	()[B
    //   93: arraylength
    //   94: iadd
    //   95: aload_0
    //   96: getfield 19	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:a	I
    //   99: if_icmpgt +341 -> 440
    //   102: aload_3
    //   103: astore_1
    //   104: aload 4
    //   106: invokevirtual 44	java/lang/String:getBytes	()[B
    //   109: arraylength
    //   110: aload_0
    //   111: getfield 19	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:a	I
    //   114: if_icmple +78 -> 192
    //   117: aload_3
    //   118: astore_1
    //   119: aload_3
    //   120: invokevirtual 56	java/lang/String:length	()I
    //   123: ifle +69 -> 192
    //   126: aload_3
    //   127: astore_1
    //   128: aload_3
    //   129: iconst_0
    //   130: aload_3
    //   131: invokevirtual 56	java/lang/String:length	()I
    //   134: iconst_1
    //   135: isub
    //   136: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   139: astore_3
    //   140: aload_3
    //   141: astore_1
    //   142: new 58	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   149: astore 4
    //   151: aload_3
    //   152: astore_1
    //   153: aload 4
    //   155: aload 6
    //   157: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: astore_1
    //   163: aload 4
    //   165: aload_3
    //   166: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: astore_1
    //   172: aload 4
    //   174: aload 7
    //   176: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: astore_1
    //   182: aload 4
    //   184: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 4
    //   189: goto -87 -> 102
    //   192: aload_3
    //   193: astore_1
    //   194: aload 4
    //   196: aload 4
    //   198: invokevirtual 56	java/lang/String:length	()I
    //   201: iconst_1
    //   202: isub
    //   203: invokevirtual 68	java/lang/String:charAt	(I)C
    //   206: invokestatic 72	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   209: ldc 74
    //   211: invokevirtual 77	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   214: astore 8
    //   216: aload 4
    //   218: astore 5
    //   220: aload_3
    //   221: astore_1
    //   222: aload 8
    //   224: arraylength
    //   225: iconst_2
    //   226: if_icmpne +81 -> 307
    //   229: aload 4
    //   231: astore 5
    //   233: aload_3
    //   234: astore_1
    //   235: aload 4
    //   237: invokevirtual 56	java/lang/String:length	()I
    //   240: iconst_1
    //   241: if_icmple +66 -> 307
    //   244: aload 8
    //   246: iconst_0
    //   247: baload
    //   248: sipush 255
    //   251: iand
    //   252: i2c
    //   253: istore_2
    //   254: aload 8
    //   256: iconst_1
    //   257: baload
    //   258: sipush 255
    //   261: iand
    //   262: i2c
    //   263: iload_2
    //   264: bipush 8
    //   266: ishl
    //   267: ior
    //   268: i2c
    //   269: istore_2
    //   270: aload 4
    //   272: astore 5
    //   274: iload_2
    //   275: ldc 78
    //   277: if_icmplt +30 -> 307
    //   280: aload 4
    //   282: astore 5
    //   284: iload_2
    //   285: ldc 79
    //   287: if_icmpgt +20 -> 307
    //   290: aload_3
    //   291: astore_1
    //   292: aload 4
    //   294: iconst_0
    //   295: aload 4
    //   297: invokevirtual 56	java/lang/String:length	()I
    //   300: iconst_1
    //   301: isub
    //   302: invokevirtual 50	java/lang/String:substring	(II)Ljava/lang/String;
    //   305: astore 5
    //   307: aload_3
    //   308: astore_1
    //   309: aload_0
    //   310: getfield 21	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:b	Landroid/widget/EditText;
    //   313: aload 5
    //   315: invokevirtual 83	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   318: aload_3
    //   319: astore_1
    //   320: aload_0
    //   321: getfield 21	com/tencent/mobileqq/addfriend/ui/AddFriendVerifyFragment$MaxBytesTextWatcher:b	Landroid/widget/EditText;
    //   324: aload 5
    //   326: invokevirtual 56	java/lang/String:length	()I
    //   329: invokevirtual 87	android/widget/EditText:setSelection	(I)V
    //   332: return
    //   333: astore_3
    //   334: aload 6
    //   336: astore 5
    //   338: aload 7
    //   340: astore 4
    //   342: goto +24 -> 366
    //   345: astore_3
    //   346: ldc 28
    //   348: astore 4
    //   350: aload 6
    //   352: astore 5
    //   354: goto +12 -> 366
    //   357: astore_3
    //   358: ldc 28
    //   360: astore 5
    //   362: aload 5
    //   364: astore 4
    //   366: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +71 -> 440
    //   372: new 58	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   379: astore 6
    //   381: aload 6
    //   383: ldc 95
    //   385: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 6
    //   391: aload 5
    //   393: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 6
    //   399: ldc 97
    //   401: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 6
    //   407: aload 4
    //   409: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 6
    //   415: ldc 99
    //   417: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 6
    //   423: aload_1
    //   424: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: ldc 101
    //   430: iconst_2
    //   431: aload 6
    //   433: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: aload_3
    //   437: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   440: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	MaxBytesTextWatcher
    //   0	441	1	paramEditable	android.text.Editable
    //   253	35	2	i	int
    //   79	240	3	str1	java.lang.String
    //   333	1	3	localThrowable1	java.lang.Throwable
    //   345	1	3	localThrowable2	java.lang.Throwable
    //   357	80	3	localThrowable3	java.lang.Throwable
    //   13	395	4	localObject1	Object
    //   218	174	5	localObject2	Object
    //   38	394	6	localObject3	Object
    //   59	280	7	str2	java.lang.String
    //   214	41	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	80	333	java/lang/Throwable
    //   82	102	333	java/lang/Throwable
    //   104	117	333	java/lang/Throwable
    //   119	126	333	java/lang/Throwable
    //   128	140	333	java/lang/Throwable
    //   142	151	333	java/lang/Throwable
    //   153	161	333	java/lang/Throwable
    //   163	170	333	java/lang/Throwable
    //   172	180	333	java/lang/Throwable
    //   182	189	333	java/lang/Throwable
    //   194	216	333	java/lang/Throwable
    //   222	229	333	java/lang/Throwable
    //   235	244	333	java/lang/Throwable
    //   292	307	333	java/lang/Throwable
    //   309	318	333	java/lang/Throwable
    //   320	332	333	java/lang/Throwable
    //   40	61	345	java/lang/Throwable
    //   28	40	357	java/lang/Throwable
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.MaxBytesTextWatcher
 * JD-Core Version:    0.7.0.1
 */