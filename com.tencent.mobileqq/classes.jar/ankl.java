import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ankl
  extends anhq
  implements ankr
{
  static long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  public String a;
  
  public ankl()
  {
    this.i = "show_fav_menu";
  }
  
  public static String a(Map<String, VipComicFavorEmoStructMsgInfo> paramMap, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
    if (paramMap != null) {
      return paramMap.actionData;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.d);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", ajjy.a(2131638593));
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", this.jdField_a_of_type_JavaLangString);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)awuw.a(localBundle), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, 0);
    paramSessionInfo = adww.a(this.jdField_a_of_type_JavaLangString);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      bezp.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], adww.a(this.jdField_a_of_type_JavaLangString) });
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  /* Error */
  public Drawable a(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: new 16	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 17	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: astore_1
    //   12: aload 4
    //   14: astore_3
    //   15: invokestatic 151	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: invokevirtual 155	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   21: astore 5
    //   23: aload 4
    //   25: astore_1
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ldc 156
    //   33: invokevirtual 162	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: ldc 163
    //   48: invokevirtual 162	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   51: astore 5
    //   53: aload 5
    //   55: astore_3
    //   56: aload 4
    //   58: astore_1
    //   59: aload_3
    //   60: astore 4
    //   62: new 165	java/net/URL
    //   65: dup
    //   66: ldc 167
    //   68: ldc 169
    //   70: aload_0
    //   71: getfield 64	ankl:d	Ljava/lang/String;
    //   74: invokespecial 172	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: astore 5
    //   79: new 174	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   82: dup
    //   83: invokespecial 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 64	ankl:d	Ljava/lang/String;
    //   92: putfield 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   95: aload_3
    //   96: bipush 100
    //   98: putfield 181	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   101: aload_3
    //   102: bipush 100
    //   104: putfield 184	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   107: invokestatic 190	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   110: astore 6
    //   112: aload 6
    //   114: aload_1
    //   115: putfield 194	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   118: aload 6
    //   120: aload 4
    //   122: putfield 197	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   125: aload 6
    //   127: aload_0
    //   128: putfield 201	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   131: aload_0
    //   132: getfield 64	ankl:d	Ljava/lang/String;
    //   135: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +66 -> 204
    //   141: aload 5
    //   143: aload 6
    //   145: invokestatic 206	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   148: astore_1
    //   149: aload_1
    //   150: aload_3
    //   151: invokevirtual 210	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   154: aload_1
    //   155: areturn
    //   156: astore_3
    //   157: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +13 -> 173
    //   163: ldc 218
    //   165: iconst_2
    //   166: aload_3
    //   167: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: astore 4
    //   176: goto -114 -> 62
    //   179: astore_1
    //   180: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +13 -> 196
    //   186: ldc 218
    //   188: iconst_2
    //   189: aload_1
    //   190: invokevirtual 226	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   193: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aconst_null
    //   197: astore 4
    //   199: aload_3
    //   200: astore_1
    //   201: goto -139 -> 62
    //   204: ldc 218
    //   206: iconst_1
    //   207: new 228	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   214: ldc 231
    //   216: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 238	ankl:toString	()Ljava/lang/String;
    //   223: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 242	java/net/MalformedURLException:printStackTrace	()V
    //   239: ldc 218
    //   241: iconst_1
    //   242: ldc 244
    //   244: aload_1
    //   245: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -16 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	ankl
    //   0	251	1	paramContext	Context
    //   0	251	2	paramFloat	float
    //   14	137	3	localObject1	Object
    //   156	44	3	localException	java.lang.Exception
    //   7	191	4	localObject2	Object
    //   21	121	5	localObject3	Object
    //   110	34	6	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   15	23	156	java/lang/Exception
    //   29	38	156	java/lang/Exception
    //   44	53	156	java/lang/Exception
    //   15	23	179	java/lang/OutOfMemoryError
    //   29	38	179	java/lang/OutOfMemoryError
    //   44	53	179	java/lang/OutOfMemoryError
    //   62	154	234	java/net/MalformedURLException
    //   204	232	234	java/net/MalformedURLException
  }
  
  /* Error */
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 16	android/graphics/drawable/ColorDrawable
    //   3: dup
    //   4: invokespecial 17	android/graphics/drawable/ColorDrawable:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: astore_1
    //   12: aload 6
    //   14: astore 5
    //   16: invokestatic 151	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: invokevirtual 155	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   22: astore 7
    //   24: aload 6
    //   26: astore_1
    //   27: aload 6
    //   29: astore 5
    //   31: aload 7
    //   33: ldc 156
    //   35: invokevirtual 162	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore 6
    //   40: aload 6
    //   42: astore_1
    //   43: aload 6
    //   45: astore 5
    //   47: aload 7
    //   49: ldc 163
    //   51: invokevirtual 162	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   54: astore 7
    //   56: aload 7
    //   58: astore 5
    //   60: aload 6
    //   62: astore_1
    //   63: aload 5
    //   65: astore 6
    //   67: new 165	java/net/URL
    //   70: dup
    //   71: ldc 167
    //   73: ldc 250
    //   75: aload_0
    //   76: getfield 64	ankl:d	Ljava/lang/String;
    //   79: invokespecial 172	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore 7
    //   84: new 174	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   87: dup
    //   88: invokespecial 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 64	ankl:d	Ljava/lang/String;
    //   99: putfield 178	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   102: aload 5
    //   104: iload_3
    //   105: putfield 181	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   108: aload 5
    //   110: iload 4
    //   112: putfield 184	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   115: invokestatic 190	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   118: astore 8
    //   120: aload 8
    //   122: aload_1
    //   123: putfield 194	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   126: aload 8
    //   128: aload 6
    //   130: putfield 197	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   133: aload 8
    //   135: aload_0
    //   136: putfield 201	com/tencent/image/URLDrawable$URLDrawableOptions:mExtraInfo	Ljava/lang/Object;
    //   139: aload_0
    //   140: getfield 64	ankl:d	Ljava/lang/String;
    //   143: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +70 -> 216
    //   149: aload 7
    //   151: aload 8
    //   153: invokestatic 206	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   156: astore_1
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 210	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   163: aload_1
    //   164: areturn
    //   165: astore 5
    //   167: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +14 -> 184
    //   173: ldc 218
    //   175: iconst_2
    //   176: aload 5
    //   178: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: astore 6
    //   187: goto -120 -> 67
    //   190: astore_1
    //   191: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +13 -> 207
    //   197: ldc 218
    //   199: iconst_2
    //   200: aload_1
    //   201: invokevirtual 226	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   204: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: astore 6
    //   210: aload 5
    //   212: astore_1
    //   213: goto -146 -> 67
    //   216: ldc 218
    //   218: iconst_1
    //   219: new 228	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   226: ldc 252
    //   228: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: invokevirtual 238	ankl:toString	()Ljava/lang/String;
    //   235: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 242	java/net/MalformedURLException:printStackTrace	()V
    //   251: ldc 218
    //   253: iconst_1
    //   254: ldc 254
    //   256: aload_1
    //   257: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -16 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ankl
    //   0	263	1	paramContext	Context
    //   0	263	2	paramFloat	float
    //   0	263	3	paramInt1	int
    //   0	263	4	paramInt2	int
    //   14	145	5	localObject1	Object
    //   165	46	5	localException	java.lang.Exception
    //   7	202	6	localObject2	Object
    //   22	128	7	localObject3	Object
    //   118	34	8	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   16	24	165	java/lang/Exception
    //   31	40	165	java/lang/Exception
    //   47	56	165	java/lang/Exception
    //   16	24	190	java/lang/OutOfMemoryError
    //   31	40	190	java/lang/OutOfMemoryError
    //   47	56	190	java/lang/OutOfMemoryError
    //   67	163	246	java/net/MalformedURLException
    //   216	244	246	java/net/MalformedURLException
  }
  
  public String a()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    if (adww.a(this.jdField_a_of_type_JavaLangString))
    {
      a(paramQQAppInterface, paramSessionInfo);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (ascr.a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramContext = (BaseActivity)paramContext;
      bbmy.a(paramQQAppInterface.getApp(), ajjy.a(2131638595), 0).b(paramContext.getTitleBarHeight());
      return;
    }
    paramEditText = this.d;
    if (!TextUtils.isEmpty(this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      aael.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEditText, true, bool, this.c, null);
      if ((TextUtils.isEmpty(this.d)) || (!this.d.contains("qto_"))) {
        break;
      }
      awqx.b(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(ajjm.a(this.c)), "", ajjm.a(this.d), "");
      return;
    }
    awqx.b(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.d);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843059);
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable b(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.d);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130843059);
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String toString()
  {
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.d, this.e });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankl
 * JD-Core Version:    0.7.0.1
 */