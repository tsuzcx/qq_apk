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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    //   20: getstatic 57	alir:c	Ljava/lang/String;
    //   23: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 63
    //   32: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 74	java/io/File:exists	()Z
    //   46: ifeq +168 -> 214
    //   49: new 76	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: sipush 1024
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_1
    //   67: astore_0
    //   68: new 51	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   75: astore 5
    //   77: aload_1
    //   78: astore_0
    //   79: aload_1
    //   80: aload_3
    //   81: invokevirtual 83	java/io/FileInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: ifle +44 -> 130
    //   89: aload_1
    //   90: astore_0
    //   91: aload 5
    //   93: new 85	java/lang/String
    //   96: dup
    //   97: aload_3
    //   98: iconst_0
    //   99: iload_2
    //   100: invokespecial 88	java/lang/String:<init>	([BII)V
    //   103: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: goto -30 -> 77
    //   110: astore_3
    //   111: aload_1
    //   112: astore_0
    //   113: aload_3
    //   114: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   117: aload_1
    //   118: ifnull +96 -> 214
    //   121: aload_1
    //   122: invokevirtual 94	java/io/FileInputStream:close	()V
    //   125: aload 4
    //   127: astore_0
    //   128: aload_0
    //   129: areturn
    //   130: aload_1
    //   131: astore_0
    //   132: new 44	org/json/JSONObject
    //   135: dup
    //   136: new 85	java/lang/String
    //   139: dup
    //   140: aload 5
    //   142: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 100	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   149: invokespecial 103	java/lang/String:<init>	([B)V
    //   152: invokespecial 104	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   155: astore_3
    //   156: aload_3
    //   157: astore_0
    //   158: aload_1
    //   159: ifnull -31 -> 128
    //   162: aload_1
    //   163: invokevirtual 94	java/io/FileInputStream:close	()V
    //   166: aload_3
    //   167: areturn
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   173: aload_3
    //   174: areturn
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   180: aload 4
    //   182: areturn
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 94	java/io/FileInputStream:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   201: goto -7 -> 194
    //   204: astore_1
    //   205: goto -19 -> 186
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_1
    //   211: goto -100 -> 111
    //   214: aload 4
    //   216: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   0	217	1	paramString	String
    //   84	16	2	i	int
    //   65	33	3	arrayOfByte	byte[]
    //   110	4	3	localException1	Exception
    //   155	19	3	localJSONObject1	JSONObject
    //   208	1	3	localException2	Exception
    //   7	208	4	localJSONObject2	JSONObject
    //   75	66	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   60	66	110	java/lang/Exception
    //   68	77	110	java/lang/Exception
    //   79	85	110	java/lang/Exception
    //   91	107	110	java/lang/Exception
    //   132	156	110	java/lang/Exception
    //   162	166	168	java/io/IOException
    //   121	125	175	java/io/IOException
    //   49	58	183	finally
    //   190	194	196	java/io/IOException
    //   60	66	204	finally
    //   68	77	204	finally
    //   79	85	204	finally
    //   91	107	204	finally
    //   113	117	204	finally
    //   132	156	204	finally
    //   49	58	208	java/lang/Exception
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560556, this, true);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this);
    this.mWariningView = ((ImageView)findViewById(2131368307));
    this.mText = ((TextView)findViewById(2131368306));
    this.mArrowView = ((ImageView)findViewById(2131368304));
  }
  
  public void onClick(View paramView)
  {
    if (this.mUrl != null)
    {
      Intent localIntent = new Intent();
      Context localContext = paramView.getContext();
      localIntent.setClass(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.mUrl);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localContext.startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout
 * JD-Core Version:    0.7.0.1
 */