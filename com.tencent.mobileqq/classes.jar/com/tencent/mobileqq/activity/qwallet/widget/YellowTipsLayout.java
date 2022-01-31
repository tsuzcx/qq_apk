package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class YellowTipsLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String AD_LEVEL_INFO = "info";
  public static final String AD_LEVEL_WARNING = "warning";
  public static final String KEY_HB_AD = "mk_hb_ad";
  public static final String KEY_TRANS_AD = "transfer_ad";
  private ImageView mArrowView;
  private TextView mText;
  private String mUrl;
  private ImageView mWariningView;
  
  public YellowTipsLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public YellowTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  /* Error */
  public static JSONObject getYellowTipsConfig(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 44	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 47	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: new 49	java/io/File
    //   12: dup
    //   13: new 51	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 58	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 62	java/io/File:getPath	()Ljava/lang/String;
    //   27: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 68
    //   32: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 70
    //   41: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 80	java/io/File:exists	()Z
    //   55: ifeq +168 -> 223
    //   58: new 82	java/io/FileInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: sipush 1024
    //   72: newarray byte
    //   74: astore_3
    //   75: aload_1
    //   76: astore_0
    //   77: new 51	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   84: astore 5
    //   86: aload_1
    //   87: astore_0
    //   88: aload_1
    //   89: aload_3
    //   90: invokevirtual 89	java/io/FileInputStream:read	([B)I
    //   93: istore_2
    //   94: iload_2
    //   95: ifle +44 -> 139
    //   98: aload_1
    //   99: astore_0
    //   100: aload 5
    //   102: new 91	java/lang/String
    //   105: dup
    //   106: aload_3
    //   107: iconst_0
    //   108: iload_2
    //   109: invokespecial 94	java/lang/String:<init>	([BII)V
    //   112: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: goto -30 -> 86
    //   119: astore_3
    //   120: aload_1
    //   121: astore_0
    //   122: aload_3
    //   123: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   126: aload_1
    //   127: ifnull +96 -> 223
    //   130: aload_1
    //   131: invokevirtual 100	java/io/FileInputStream:close	()V
    //   134: aload 4
    //   136: astore_0
    //   137: aload_0
    //   138: areturn
    //   139: aload_1
    //   140: astore_0
    //   141: new 44	org/json/JSONObject
    //   144: dup
    //   145: new 91	java/lang/String
    //   148: dup
    //   149: aload 5
    //   151: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokestatic 106	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   158: invokespecial 109	java/lang/String:<init>	([B)V
    //   161: invokespecial 110	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   164: astore_3
    //   165: aload_3
    //   166: astore_0
    //   167: aload_1
    //   168: ifnull -31 -> 137
    //   171: aload_1
    //   172: invokevirtual 100	java/io/FileInputStream:close	()V
    //   175: aload_3
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   182: aload_3
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   189: aload 4
    //   191: areturn
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 100	java/io/FileInputStream:close	()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   210: goto -7 -> 203
    //   213: astore_1
    //   214: goto -19 -> 195
    //   217: astore_3
    //   218: aconst_null
    //   219: astore_1
    //   220: goto -100 -> 120
    //   223: aload 4
    //   225: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramContext	Context
    //   0	226	1	paramString	String
    //   93	16	2	i	int
    //   74	33	3	arrayOfByte	byte[]
    //   119	4	3	localException1	Exception
    //   164	19	3	localJSONObject1	JSONObject
    //   217	1	3	localException2	Exception
    //   7	217	4	localJSONObject2	JSONObject
    //   84	66	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	75	119	java/lang/Exception
    //   77	86	119	java/lang/Exception
    //   88	94	119	java/lang/Exception
    //   100	116	119	java/lang/Exception
    //   141	165	119	java/lang/Exception
    //   171	175	177	java/io/IOException
    //   130	134	184	java/io/IOException
    //   58	67	192	finally
    //   199	203	205	java/io/IOException
    //   69	75	213	finally
    //   77	86	213	finally
    //   88	94	213	finally
    //   100	116	213	finally
    //   122	126	213	finally
    //   141	165	213	finally
    //   58	67	217	java/lang/Exception
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130969847, this, true);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this);
    this.mWariningView = ((ImageView)findViewById(2131368274));
    this.mText = ((TextView)findViewById(2131368275));
    this.mArrowView = ((ImageView)findViewById(2131368276));
  }
  
  public void onClick(View paramView)
  {
    if (this.mUrl != null)
    {
      Intent localIntent = new Intent();
      paramView = paramView.getContext();
      localIntent.setClass(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", this.mUrl);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.startActivity(localIntent);
    }
  }
  
  public void setArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mArrowView.getVisibility() != 0) {
        this.mArrowView.setVisibility(0);
      }
    }
    while (this.mArrowView.getVisibility() != 0) {
      return;
    }
    this.mArrowView.setVisibility(4);
  }
  
  public void setMessage(String paramString)
  {
    this.mText.setText(paramString);
  }
  
  public void setUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setArrowVisible(false);
      this.mUrl = null;
      return;
    }
    setArrowVisible(true);
    this.mUrl = paramString;
  }
  
  public void setWarningVisible(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mWariningView.getVisibility() != 0) {
        this.mWariningView.setVisibility(0);
      }
    }
    while (this.mWariningView.getVisibility() != 0) {
      return;
    }
    this.mWariningView.setVisibility(4);
  }
  
  public boolean setYellowTipsJsonConfig(JSONObject paramJSONObject, String paramString)
  {
    setVisibility(8);
    if (paramJSONObject == null) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          Object localObject = paramJSONObject.optJSONObject(paramString);
          if (localObject != null)
          {
            paramJSONObject = ((JSONObject)localObject).optString("ad_text");
            paramString = ((JSONObject)localObject).optString("ad_url");
            String str1 = ((JSONObject)localObject).optString("ad_level");
            String str2 = ((JSONObject)localObject).optString("ad_begin_time");
            localObject = ((JSONObject)localObject).optString("ad_end_time");
            if ((!TextUtils.isEmpty(paramJSONObject)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str2)))
            {
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              long l1 = localSimpleDateFormat.parse(str2).getTime();
              long l2 = localSimpleDateFormat.parse((String)localObject).getTime();
              long l3 = System.currentTimeMillis();
              if ((l3 >= l1) && (l3 <= l2))
              {
                setVisibility(0);
                this.mText.setText(paramJSONObject);
                setUrl(paramString);
                set_ad_level(str1);
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
          }
        }
      }
    } while (getVisibility() != 0);
    return true;
  }
  
  public void set_ad_level(String paramString)
  {
    if ((paramString != null) && ("info".equals(paramString)))
    {
      setWarningVisible(false);
      return;
    }
    setWarningVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout
 * JD-Core Version:    0.7.0.1
 */