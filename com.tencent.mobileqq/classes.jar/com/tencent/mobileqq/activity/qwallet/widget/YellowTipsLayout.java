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
    //   20: ldc 54
    //   22: invokestatic 60	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   25: checkcast 54	cooperation/qwallet/plugin/IQWalletHelper
    //   28: invokeinterface 64 1 0
    //   33: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 70
    //   42: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 80	java/io/File:exists	()Z
    //   56: ifeq +168 -> 224
    //   59: new 82	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: sipush 1024
    //   73: newarray byte
    //   75: astore_3
    //   76: aload_1
    //   77: astore_0
    //   78: new 51	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   85: astore 5
    //   87: aload_1
    //   88: astore_0
    //   89: aload_1
    //   90: aload_3
    //   91: invokevirtual 89	java/io/FileInputStream:read	([B)I
    //   94: istore_2
    //   95: iload_2
    //   96: ifle +44 -> 140
    //   99: aload_1
    //   100: astore_0
    //   101: aload 5
    //   103: new 91	java/lang/String
    //   106: dup
    //   107: aload_3
    //   108: iconst_0
    //   109: iload_2
    //   110: invokespecial 94	java/lang/String:<init>	([BII)V
    //   113: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: goto -30 -> 87
    //   120: astore_3
    //   121: aload_1
    //   122: astore_0
    //   123: aload_3
    //   124: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +96 -> 224
    //   131: aload_1
    //   132: invokevirtual 100	java/io/FileInputStream:close	()V
    //   135: aload 4
    //   137: astore_0
    //   138: aload_0
    //   139: areturn
    //   140: aload_1
    //   141: astore_0
    //   142: new 44	org/json/JSONObject
    //   145: dup
    //   146: new 91	java/lang/String
    //   149: dup
    //   150: aload 5
    //   152: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: iconst_0
    //   156: invokestatic 106	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   159: invokespecial 109	java/lang/String:<init>	([B)V
    //   162: invokespecial 110	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   165: astore_3
    //   166: aload_3
    //   167: astore_0
    //   168: aload_1
    //   169: ifnull -31 -> 138
    //   172: aload_1
    //   173: invokevirtual 100	java/io/FileInputStream:close	()V
    //   176: aload_3
    //   177: areturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   183: aload_3
    //   184: areturn
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   190: aload 4
    //   192: areturn
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 100	java/io/FileInputStream:close	()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   211: goto -7 -> 204
    //   214: astore_1
    //   215: goto -19 -> 196
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: goto -100 -> 121
    //   224: aload 4
    //   226: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramContext	Context
    //   0	227	1	paramString	String
    //   94	16	2	i	int
    //   75	33	3	arrayOfByte	byte[]
    //   120	4	3	localException1	Exception
    //   165	19	3	localJSONObject1	JSONObject
    //   218	1	3	localException2	Exception
    //   7	218	4	localJSONObject2	JSONObject
    //   85	66	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	76	120	java/lang/Exception
    //   78	87	120	java/lang/Exception
    //   89	95	120	java/lang/Exception
    //   101	117	120	java/lang/Exception
    //   142	166	120	java/lang/Exception
    //   172	176	178	java/io/IOException
    //   131	135	185	java/io/IOException
    //   59	68	193	finally
    //   200	204	206	java/io/IOException
    //   70	76	214	finally
    //   78	87	214	finally
    //   89	95	214	finally
    //   101	117	214	finally
    //   123	127	214	finally
    //   142	166	214	finally
    //   59	68	218	java/lang/Exception
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560708, this, true);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this);
    this.mWariningView = ((ImageView)findViewById(2131368710));
    this.mText = ((TextView)findViewById(2131368709));
    this.mArrowView = ((ImageView)findViewById(2131368707));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout
 * JD-Core Version:    0.7.0.1
 */