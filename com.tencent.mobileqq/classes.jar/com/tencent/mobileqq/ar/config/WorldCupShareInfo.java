package com.tencent.mobileqq.ar.config;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorldCupShareInfo
{
  public static final boolean DEBUG = false;
  public static final String RES_ROOT = AppConstants.aI + File.separator + "WorldCupShareResource" + File.separator;
  private static final String TAG = "WorldCupShareInfo";
  public String AIOMsgImageUrl;
  public String AIOMsgJumpUrl;
  public String AIOMsgSrcIconUrl;
  public String AIOMsgSrcJumpUrl;
  public String AIOMsgSrcName;
  public String AIOMsgSummary;
  public String AIOMsgTitle;
  public String AIOQRCodeDetailTitle;
  public String AIOQRCodeMainTitle;
  public String background;
  public String banner1;
  public String banner2;
  public String banner3;
  public String clothes;
  public String default_background;
  public String font_name;
  public String loading;
  private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @JSONUtils.GenericType(a=WorldCupShareInfo.Template.class)
  public ArrayList share = new ArrayList();
  public String share_br_icon;
  
  public static Bitmap getResBitmap(String paramString)
  {
    return getResBitmap(paramString, true);
  }
  
  public static Bitmap getResBitmap(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          Object localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inPurgeable = true;
          ((BitmapFactory.Options)localObject1).inInputShareable = true;
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
          ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
          ((BitmapFactory.Options)localObject1).inDither = paramBoolean;
          localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          return localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WorldCupShareInfo", 2, "getResBitmap sample1 OOM|url:" + paramString);
          }
          try
          {
            Object localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inSampleSize = 4;
            ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
            localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
            return localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}
          if (QLog.isColorLevel())
          {
            QLog.w("WorldCupShareInfo", 2, "getResBitmap sample4 OOM|url:" + paramString);
            return null;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("WorldCupShareInfo", 2, "getResBitmap Exception:" + localException.toString() + ",filePath:" + paramString);
    return null;
  }
  
  /* Error */
  private String load(String paramString)
  {
    // Byte code:
    //   0: new 41	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: new 55	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 158	java/io/File:exists	()Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifne +24 -> 46
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 160	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: aconst_null
    //   38: areturn
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 166	java/io/BufferedReader
    //   49: dup
    //   50: new 168	java/io/InputStreamReader
    //   53: dup
    //   54: new 170	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: invokespecial 174	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   65: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   68: astore_3
    //   69: aload_3
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +39 -> 118
    //   82: aload_3
    //   83: astore_1
    //   84: aload 5
    //   86: aload 4
    //   88: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto -23 -> 69
    //   95: astore 4
    //   97: aload_3
    //   98: astore_1
    //   99: aload 4
    //   101: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 183	java/io/BufferedReader:close	()V
    //   112: aload 5
    //   114: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: areturn
    //   118: aload_3
    //   119: ifnull -7 -> 112
    //   122: aload_3
    //   123: invokevirtual 183	java/io/BufferedReader:close	()V
    //   126: goto -14 -> 112
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   134: goto -22 -> 112
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   142: goto -30 -> 112
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 183	java/io/BufferedReader:close	()V
    //   156: aload_3
    //   157: athrow
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   163: goto -7 -> 156
    //   166: astore_3
    //   167: goto -19 -> 148
    //   170: astore 4
    //   172: aconst_null
    //   173: astore_3
    //   174: goto -77 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	WorldCupShareInfo
    //   0	177	1	paramString	String
    //   20	2	2	bool	boolean
    //   68	55	3	localBufferedReader	java.io.BufferedReader
    //   145	12	3	localObject1	Object
    //   166	1	3	localObject2	Object
    //   173	1	3	localObject3	Object
    //   75	12	4	str	String
    //   95	5	4	localIOException1	java.io.IOException
    //   170	1	4	localIOException2	java.io.IOException
    //   7	106	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	37	39	java/io/IOException
    //   71	77	95	java/io/IOException
    //   84	92	95	java/io/IOException
    //   122	126	129	java/io/IOException
    //   108	112	137	java/io/IOException
    //   9	21	145	finally
    //   46	69	145	finally
    //   152	156	158	java/io/IOException
    //   71	77	166	finally
    //   84	92	166	finally
    //   99	104	166	finally
    //   9	21	170	java/io/IOException
    //   46	69	170	java/io/IOException
  }
  
  public Date getDate(String paramString)
  {
    try
    {
      paramString = this.mFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String getTimeString(long paramLong)
  {
    return this.mFormat.format(new Date(paramLong));
  }
  
  public void parse(String paramString)
  {
    paramString = load(paramString);
    QLog.d("WorldCupShareInfo", 1, "WL_DEBUG parse configText = " + paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject = (WorldCupShareInfo)JSONUtils.b(paramString, WorldCupShareInfo.class);
        this.font_name = ((WorldCupShareInfo)localObject).font_name;
        this.clothes = ((WorldCupShareInfo)localObject).clothes;
        this.background = ((WorldCupShareInfo)localObject).background;
        this.default_background = ((WorldCupShareInfo)localObject).default_background;
        this.loading = ((WorldCupShareInfo)localObject).loading;
        this.banner1 = ((WorldCupShareInfo)localObject).banner1;
        this.banner2 = ((WorldCupShareInfo)localObject).banner2;
        this.banner3 = ((WorldCupShareInfo)localObject).banner3;
        this.share_br_icon = ((WorldCupShareInfo)localObject).share_br_icon;
        this.share = ((WorldCupShareInfo)localObject).share;
        paramString = paramString.getJSONArray("share");
        if (this.share.size() >= paramString.length())
        {
          int i = 0;
          while (i < paramString.length())
          {
            localObject = (WorldCupShareInfo.Template)this.share.get(i);
            Collections.sort(((WorldCupShareInfo.Template)localObject).matches, new WorldCupShareInfo.1(this));
            JSONObject localJSONObject = paramString.getJSONObject(i);
            ((WorldCupShareInfo.Template)localObject).column1 = ((WorldCupShareInfo.Column)JSONUtils.b(localJSONObject.getJSONObject("column1"), WorldCupShareInfo.Column.class));
            ((WorldCupShareInfo.Template)localObject).column2 = ((WorldCupShareInfo.Column)JSONUtils.b(localJSONObject.getJSONObject("column2"), WorldCupShareInfo.Column.class));
            i += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("WorldCupShareInfo", 1, "WL_DEBUG parse e = " + paramString);
        paramString.printStackTrace();
      }
    }
  }
  
  public void parseShare(JSONObject paramJSONObject)
  {
    paramJSONObject = (WorldCupShareInfo)JSONUtils.b(paramJSONObject.getJSONObject("shareInfo"), WorldCupShareInfo.class);
    this.AIOMsgImageUrl = paramJSONObject.AIOMsgImageUrl;
    this.AIOMsgJumpUrl = paramJSONObject.AIOMsgJumpUrl;
    this.AIOMsgSummary = paramJSONObject.AIOMsgSummary;
    this.AIOMsgTitle = paramJSONObject.AIOMsgTitle;
    this.AIOMsgSrcName = paramJSONObject.AIOMsgSrcName;
    this.AIOMsgSrcJumpUrl = paramJSONObject.AIOMsgSrcJumpUrl;
    this.AIOMsgSrcIconUrl = paramJSONObject.AIOMsgSrcIconUrl;
    this.AIOQRCodeMainTitle = paramJSONObject.AIOQRCodeMainTitle;
    this.AIOQRCodeDetailTitle = paramJSONObject.AIOQRCodeDetailTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupShareInfo
 * JD-Core Version:    0.7.0.1
 */