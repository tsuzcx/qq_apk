package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class EditInfoActivity$14
  implements TextWatcher
{
  EditInfoActivity$14(EditInfoActivity paramEditInfoActivity, EditText paramEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  /* Error */
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 30	com/tencent/mobileqq/text/QQText
    //   3: dup
    //   4: aload_1
    //   5: iconst_3
    //   6: invokespecial 33	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;I)V
    //   9: astore 7
    //   11: aload 7
    //   13: invokevirtual 37	com/tencent/mobileqq/text/QQText:trim	()Ljava/lang/String;
    //   16: pop
    //   17: aload_1
    //   18: ifnull +11 -> 29
    //   21: aload 7
    //   23: invokevirtual 41	com/tencent/mobileqq/text/QQText:length	()I
    //   26: ifne +92 -> 118
    //   29: aload_0
    //   30: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   33: new 43	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   40: ldc 46
    //   42: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   49: getfield 56	com/tencent/mobileqq/activity/EditInfoActivity:d	I
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: putfield 66	com/tencent/mobileqq/activity/EditInfoActivity:c	Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   65: getfield 67	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   68: instanceof 69
    //   71: ifeq +27 -> 98
    //   74: aload_0
    //   75: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   78: getfield 67	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   81: checkcast 69	com/tencent/mobileqq/widget/ColorClearableEditText
    //   84: astore_1
    //   85: aload_1
    //   86: iconst_0
    //   87: aconst_null
    //   88: aconst_null
    //   89: iconst_0
    //   90: aconst_null
    //   91: invokevirtual 73	com/tencent/mobileqq/widget/ColorClearableEditText:setSpecialColor	(I[I[FILandroid/graphics/Bitmap;)V
    //   94: aload_1
    //   95: invokevirtual 76	com/tencent/mobileqq/widget/ColorClearableEditText:b	()V
    //   98: aload_0
    //   99: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   102: getfield 79	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   105: new 81	com/tencent/mobileqq/activity/EditInfoActivity$14$1
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 84	com/tencent/mobileqq/activity/EditInfoActivity$14$1:<init>	(Lcom/tencent/mobileqq/activity/EditInfoActivity$14;)V
    //   113: invokevirtual 90	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   116: pop
    //   117: return
    //   118: aload_0
    //   119: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   122: getfield 93	com/tencent/mobileqq/activity/EditInfoActivity:jdField_g_of_type_Int	I
    //   125: ifne +310 -> 435
    //   128: aload_0
    //   129: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   132: getfield 96	com/tencent/mobileqq/activity/EditInfoActivity:jdField_g_of_type_Boolean	Z
    //   135: ifeq +285 -> 420
    //   138: aload_0
    //   139: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   142: invokestatic 99	com/tencent/mobileqq/activity/EditInfoActivity:a	(Lcom/tencent/mobileqq/activity/EditInfoActivity;)I
    //   145: istore_2
    //   146: iload_2
    //   147: istore_3
    //   148: aload_0
    //   149: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   152: getfield 102	com/tencent/mobileqq/activity/EditInfoActivity:i	I
    //   155: iconst_1
    //   156: if_icmpne +96 -> 252
    //   159: iload_2
    //   160: istore_3
    //   161: iload_2
    //   162: aload_0
    //   163: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   166: getfield 56	com/tencent/mobileqq/activity/EditInfoActivity:d	I
    //   169: if_icmple +83 -> 252
    //   172: aload_1
    //   173: instanceof 104
    //   176: istore 6
    //   178: iload_2
    //   179: istore_3
    //   180: iload 6
    //   182: ifeq +70 -> 252
    //   185: iload_2
    //   186: istore_3
    //   187: iload_3
    //   188: istore 4
    //   190: aload_0
    //   191: getfield 15	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   194: invokestatic 110	com/tencent/mobileqq/text/TextUtils:backspace	(Landroid/widget/EditText;)V
    //   197: aload_0
    //   198: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   201: getfield 93	com/tencent/mobileqq/activity/EditInfoActivity:jdField_g_of_type_Int	I
    //   204: ifne +255 -> 459
    //   207: aload_0
    //   208: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   211: getfield 96	com/tencent/mobileqq/activity/EditInfoActivity:jdField_g_of_type_Boolean	Z
    //   214: ifeq +230 -> 444
    //   217: aload_0
    //   218: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   221: invokestatic 99	com/tencent/mobileqq/activity/EditInfoActivity:a	(Lcom/tencent/mobileqq/activity/EditInfoActivity;)I
    //   224: istore_2
    //   225: aload_0
    //   226: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   229: getfield 56	com/tencent/mobileqq/activity/EditInfoActivity:d	I
    //   232: istore 5
    //   234: iload_2
    //   235: istore_3
    //   236: iload_2
    //   237: iload 5
    //   239: if_icmple +13 -> 252
    //   242: iload_2
    //   243: istore_3
    //   244: iload 4
    //   246: iload_2
    //   247: if_icmpgt -60 -> 187
    //   250: iload_2
    //   251: istore_3
    //   252: aload_0
    //   253: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   256: new 43	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   263: ldc 46
    //   265: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   272: getfield 56	com/tencent/mobileqq/activity/EditInfoActivity:d	I
    //   275: iload_3
    //   276: isub
    //   277: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: putfield 66	com/tencent/mobileqq/activity/EditInfoActivity:c	Ljava/lang/String;
    //   286: aload_0
    //   287: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   290: getfield 66	com/tencent/mobileqq/activity/EditInfoActivity:c	Ljava/lang/String;
    //   293: invokevirtual 113	java/lang/String:length	()I
    //   296: iconst_4
    //   297: if_icmple +40 -> 337
    //   300: aload_0
    //   301: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   304: new 43	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   311: aload_0
    //   312: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   315: getfield 66	com/tencent/mobileqq/activity/EditInfoActivity:c	Ljava/lang/String;
    //   318: iconst_0
    //   319: iconst_2
    //   320: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   323: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 119
    //   328: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: putfield 66	com/tencent/mobileqq/activity/EditInfoActivity:c	Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   341: getfield 79	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   344: new 121	com/tencent/mobileqq/activity/EditInfoActivity$14$2
    //   347: dup
    //   348: aload_0
    //   349: iload_3
    //   350: invokespecial 124	com/tencent/mobileqq/activity/EditInfoActivity$14$2:<init>	(Lcom/tencent/mobileqq/activity/EditInfoActivity$14;I)V
    //   353: invokevirtual 90	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   356: pop
    //   357: aload_0
    //   358: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   361: getfield 67	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   364: instanceof 69
    //   367: ifeq -250 -> 117
    //   370: aload_0
    //   371: getfield 13	com/tencent/mobileqq/activity/EditInfoActivity$14:jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   374: getfield 67	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   377: checkcast 69	com/tencent/mobileqq/widget/ColorClearableEditText
    //   380: invokevirtual 76	com/tencent/mobileqq/widget/ColorClearableEditText:b	()V
    //   383: return
    //   384: astore_1
    //   385: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq -271 -> 117
    //   391: ldc 132
    //   393: iconst_2
    //   394: new 43	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   401: ldc 134
    //   403: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 137	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   410: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: return
    //   420: aload 7
    //   422: invokevirtual 141	com/tencent/mobileqq/text/QQText:toString	()Ljava/lang/String;
    //   425: ldc 143
    //   427: invokevirtual 147	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   430: arraylength
    //   431: istore_2
    //   432: goto -286 -> 146
    //   435: aload 7
    //   437: invokevirtual 41	com/tencent/mobileqq/text/QQText:length	()I
    //   440: istore_2
    //   441: goto -295 -> 146
    //   444: aload 7
    //   446: invokevirtual 141	com/tencent/mobileqq/text/QQText:toString	()Ljava/lang/String;
    //   449: ldc 143
    //   451: invokevirtual 147	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   454: arraylength
    //   455: istore_2
    //   456: goto -231 -> 225
    //   459: aload 7
    //   461: invokevirtual 41	com/tencent/mobileqq/text/QQText:length	()I
    //   464: istore_2
    //   465: goto -240 -> 225
    //   468: astore_1
    //   469: iload 4
    //   471: istore_2
    //   472: ldc 132
    //   474: iconst_1
    //   475: aload_1
    //   476: invokevirtual 148	java/lang/Throwable:toString	()Ljava/lang/String;
    //   479: invokestatic 150	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: iload_2
    //   483: istore_3
    //   484: goto -232 -> 252
    //   487: astore_1
    //   488: goto -16 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	14
    //   0	491	1	paramCharSequence	CharSequence
    //   0	491	2	paramInt1	int
    //   0	491	3	paramInt2	int
    //   0	491	4	paramInt3	int
    //   232	8	5	i	int
    //   176	5	6	bool	boolean
    //   9	451	7	localQQText	com.tencent.mobileqq.text.QQText
    // Exception table:
    //   from	to	target	type
    //   118	146	384	java/io/UnsupportedEncodingException
    //   148	159	384	java/io/UnsupportedEncodingException
    //   161	178	384	java/io/UnsupportedEncodingException
    //   190	225	384	java/io/UnsupportedEncodingException
    //   225	234	384	java/io/UnsupportedEncodingException
    //   252	337	384	java/io/UnsupportedEncodingException
    //   337	383	384	java/io/UnsupportedEncodingException
    //   420	432	384	java/io/UnsupportedEncodingException
    //   435	441	384	java/io/UnsupportedEncodingException
    //   444	456	384	java/io/UnsupportedEncodingException
    //   459	465	384	java/io/UnsupportedEncodingException
    //   472	482	384	java/io/UnsupportedEncodingException
    //   190	225	468	java/lang/Throwable
    //   444	456	468	java/lang/Throwable
    //   459	465	468	java/lang/Throwable
    //   225	234	487	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.14
 * JD-Core Version:    0.7.0.1
 */