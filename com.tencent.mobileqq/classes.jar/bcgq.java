import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.3;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.5;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bcgq
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunShowPictureIntentLimit", 200);
  public static String b = "pic_up";
  public static String c = "pic";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected String a;
  
  public bcgq()
  {
    this.mPluginNameSpace = "troopNotice";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = 5381;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return Integer.toString(0x7FFFFFFF & j);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: aload_2
    //   1: sipush 640
    //   4: invokestatic 85	ndi:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +15 -> 26
    //   14: aload 9
    //   16: ifnull +8 -> 24
    //   19: aload 9
    //   21: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 9
    //   28: astore_2
    //   29: new 92	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 98	alof:bp	Ljava/lang/String;
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 104
    //   44: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 111	bdzf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 10
    //   55: aload 9
    //   57: astore_2
    //   58: aload 9
    //   60: new 113	java/io/File
    //   63: dup
    //   64: aload 10
    //   66: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokestatic 121	bdhj:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   72: aload 9
    //   74: ifnull +8 -> 82
    //   77: aload 9
    //   79: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   82: new 123	java/util/HashMap
    //   85: dup
    //   86: invokespecial 124	java/util/HashMap:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 126
    //   93: aload 5
    //   95: invokestatic 127	bcgq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokeinterface 133 3 0
    //   103: pop
    //   104: aload_3
    //   105: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +62 -> 170
    //   111: new 135	org/json/JSONObject
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   119: astore_3
    //   120: aload_3
    //   121: invokevirtual 140	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   124: astore 9
    //   126: aload 9
    //   128: invokeinterface 146 1 0
    //   133: ifeq +37 -> 170
    //   136: aload 9
    //   138: invokeinterface 150 1 0
    //   143: checkcast 57	java/lang/String
    //   146: astore 11
    //   148: aload_2
    //   149: aload 11
    //   151: aload_3
    //   152: aload 11
    //   154: invokevirtual 154	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   157: invokevirtual 157	java/lang/Object:toString	()Ljava/lang/String;
    //   160: invokeinterface 133 3 0
    //   165: pop
    //   166: goto -40 -> 126
    //   169: astore_3
    //   170: new 123	java/util/HashMap
    //   173: dup
    //   174: invokespecial 124	java/util/HashMap:<init>	()V
    //   177: astore_3
    //   178: aload_3
    //   179: aload 6
    //   181: aload 10
    //   183: invokeinterface 133 3 0
    //   188: pop
    //   189: aload_0
    //   190: invokevirtual 60	java/lang/String:length	()I
    //   193: istore 8
    //   195: new 159	java/lang/StringBuffer
    //   198: dup
    //   199: ldc 161
    //   201: invokespecial 162	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   204: astore 6
    //   206: iconst_0
    //   207: istore 7
    //   209: iload 7
    //   211: bipush 10
    //   213: iload 8
    //   215: isub
    //   216: if_icmpge +79 -> 295
    //   219: aload 6
    //   221: ldc 164
    //   223: invokevirtual 167	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   226: pop
    //   227: iload 7
    //   229: iconst_1
    //   230: iadd
    //   231: istore 7
    //   233: goto -24 -> 209
    //   236: astore_0
    //   237: aconst_null
    //   238: astore 9
    //   240: aload 9
    //   242: astore_2
    //   243: aload_0
    //   244: invokevirtual 170	java/lang/OutOfMemoryError:printStackTrace	()V
    //   247: aload 9
    //   249: ifnull +8 -> 257
    //   252: aload 9
    //   254: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 9
    //   263: aload 9
    //   265: astore_2
    //   266: aload_0
    //   267: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   270: aload 9
    //   272: ifnull +8 -> 280
    //   275: aload 9
    //   277: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   280: aconst_null
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +7 -> 293
    //   289: aload_2
    //   290: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   293: aload_0
    //   294: athrow
    //   295: aload 6
    //   297: aload_0
    //   298: invokevirtual 167	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   301: pop
    //   302: new 123	java/util/HashMap
    //   305: dup
    //   306: invokespecial 124	java/util/HashMap:<init>	()V
    //   309: astore_0
    //   310: aload_0
    //   311: ldc 173
    //   313: new 175	java/net/URL
    //   316: dup
    //   317: aload_1
    //   318: invokespecial 176	java/net/URL:<init>	(Ljava/lang/String;)V
    //   321: invokevirtual 179	java/net/URL:getRef	()Ljava/lang/String;
    //   324: invokeinterface 133 3 0
    //   329: pop
    //   330: aload 4
    //   332: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: ifne +67 -> 402
    //   338: new 135	org/json/JSONObject
    //   341: dup
    //   342: aload 4
    //   344: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   347: astore 4
    //   349: aload 4
    //   351: invokevirtual 140	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   354: astore 9
    //   356: aload 9
    //   358: invokeinterface 146 1 0
    //   363: ifeq +39 -> 402
    //   366: aload 9
    //   368: invokeinterface 150 1 0
    //   373: checkcast 57	java/lang/String
    //   376: astore 10
    //   378: aload_0
    //   379: aload 10
    //   381: aload 4
    //   383: aload 10
    //   385: invokevirtual 154	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   388: invokevirtual 157	java/lang/Object:toString	()Ljava/lang/String;
    //   391: invokeinterface 133 3 0
    //   396: pop
    //   397: goto -41 -> 356
    //   400: astore 4
    //   402: aload_1
    //   403: aload 6
    //   405: invokevirtual 180	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   408: aload 5
    //   410: aload_2
    //   411: aload_3
    //   412: aload_0
    //   413: invokestatic 185	ndd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   416: areturn
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 186	java/net/MalformedURLException:printStackTrace	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: goto -140 -> 285
    //   428: astore_0
    //   429: goto -166 -> 263
    //   432: astore_0
    //   433: goto -193 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramString1	String
    //   0	436	1	paramString2	String
    //   0	436	2	paramString3	String
    //   0	436	3	paramString4	String
    //   0	436	4	paramString5	String
    //   0	436	5	paramString6	String
    //   0	436	6	paramString7	String
    //   207	25	7	i	int
    //   193	23	8	j	int
    //   7	360	9	localObject	Object
    //   53	331	10	str1	String
    //   146	7	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   111	126	169	org/json/JSONException
    //   126	166	169	org/json/JSONException
    //   0	9	236	java/lang/OutOfMemoryError
    //   0	9	259	java/io/IOException
    //   0	9	282	finally
    //   338	356	400	org/json/JSONException
    //   356	397	400	org/json/JSONException
    //   310	330	417	java/net/MalformedURLException
    //   29	55	424	finally
    //   58	72	424	finally
    //   243	247	424	finally
    //   266	270	424	finally
    //   29	55	428	java/io/IOException
    //   58	72	428	java/io/IOException
    //   29	55	432	java/lang/OutOfMemoryError
    //   58	72	432	java/lang/OutOfMemoryError
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<MediaPreviewInfo> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MediaPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putParcelableArrayList("mediaInfoList", paramArrayList);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList, null, null, false, paramBoolean, paramString, paramInt2, null, null, "");
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo, String paramString2)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString1, paramInt2, paramPublicAccountShowPictureReport, paramArticleInfo, null, null, paramString2, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4, String paramString2, boolean paramBoolean3)
  {
    ThreadManager.post(new TroopNoticeJsHandler.2(paramActivity, paramInt1, paramArrayList1, paramArrayList2, paramArrayOfBoolean, paramPublicAccountShowPictureReport, paramArrayList3, paramArrayList4, paramBoolean1, paramBoolean2, paramBoolean3, paramArticleInfo, paramString1, paramString2, paramInt2), 8, null, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, String paramString2, String paramString3, ArticleInfo paramArticleInfo, String paramString4)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putStringArrayList("seqNum", paramArrayList1);
    if (paramArrayList2 != null) {
      localBundle.putStringArrayList("descs", paramArrayList2);
    }
    if (paramArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", paramArrayOfBoolean);
    }
    if ((paramPublicAccountShowPictureReport != null) && (paramPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", paramPublicAccountShowPictureReport.toString());
    }
    localBundle.putBoolean("needBottomBar", paramBoolean1);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean2);
    localBundle.putBoolean("is_show_content_url", true);
    localBundle.putString("article_url", paramString2);
    localBundle.putString("article_title", paramString3);
    if (paramArticleInfo != null)
    {
      localBundle.putInt("channel_id", (int)paramArticleInfo.mChannelID);
      localBundle.putLong("articleSeq", paramArticleInfo.mRecommendSeq);
      localBundle.putBoolean("is_grid_image_report", true);
      rqj.a(paramArticleInfo, "", paramInt1, localBundle);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("src_id", paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localBundle.putString("str_data_extra", paramString4);
    }
    if ((ors.l(paramArticleInfo)) && (!TextUtils.isEmpty(paramString2))) {
      localBundle.putString("btntext", paramActivity.getString(2131718928));
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramActivity, 0, localArrayList, true, "", 1000);
  }
  
  protected void a(String paramString)
  {
    try
    {
      Object localObject6 = new JSONObject(paramString);
      Object localObject8 = ((JSONObject)localObject6).optString("bigurl");
      Object localObject1;
      int i;
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject9;
      if (!TextUtils.isEmpty((CharSequence)localObject8))
      {
        paramString = ((JSONObject)localObject6).optString("videoID");
        localObject1 = ((JSONObject)localObject6).optString("videoURL");
        ((JSONObject)localObject6).optString("originalVideoURL");
        i = ((JSONObject)localObject6).optInt("videoWidth");
        j = ((JSONObject)localObject6).optInt("videoHeight");
        ((JSONObject)localObject6).optBoolean("isLike");
        localObject2 = this.mRuntime.a();
        if (localObject2 == null) {
          return;
        }
        localObject3 = bjea.a();
        localObject4 = new Bundle();
        localObject5 = new ArrayList();
        localObject7 = new PhotoInfo();
        ((PhotoInfo)localObject7).d = ((String)localObject8);
        ((PhotoInfo)localObject7).q = 1;
        ((PhotoInfo)localObject7).a = new VideoInfo();
        ((PhotoInfo)localObject7).a.jdField_a_of_type_JavaLangString = paramString;
        localObject9 = new PictureUrl();
        ((PictureUrl)localObject9).jdField_a_of_type_JavaLangString = ((String)localObject8);
        ((PhotoInfo)localObject7).a.d = ((PictureUrl)localObject9);
        localObject8 = new VideoUrl();
        ((VideoUrl)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((PhotoInfo)localObject7).a.jdField_a_of_type_JavaLangString = paramString;
        ((PhotoInfo)localObject7).a.b = ((String)localObject1);
        ((PhotoInfo)localObject7).a.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)localObject8);
        ((PhotoInfo)localObject7).a.g = i;
        ((PhotoInfo)localObject7).a.h = j;
        ((PhotoInfo)localObject7).a.f = 5;
        ((ArrayList)localObject5).add(localObject7);
        ((Bundle)localObject4).putSerializable("picturelist", (Serializable)localObject5);
        ((Bundle)localObject4).putInt("curindex", 0);
        ((Bundle)localObject4).putInt("mode", 3);
        ((Bundle)localObject4).putBoolean("need_clear_cache", true);
        bjdt.c((Activity)localObject2, (bjea)localObject3, (Bundle)localObject4, 6);
      }
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("callback");
      Object localObject5 = ((JSONObject)localObject6).optJSONArray("imageIDs");
      localObject8 = ((JSONObject)localObject6).optJSONArray("likes");
      Object localObject7 = ((JSONObject)localObject6).optJSONArray("descs");
      Object localObject4 = ((JSONObject)localObject6).optJSONArray("sourceIDs");
      Object localObject10 = ((JSONObject)localObject6).optJSONArray("sourceSize");
      boolean bool1 = ((JSONObject)localObject6).optBoolean("needBottomBar");
      paramString = ((JSONObject)localObject6).optJSONObject("extra");
      if (paramString == null) {}
      boolean bool2;
      ArrayList localArrayList;
      int k;
      for (paramString = "";; paramString = paramString.toString())
      {
        j = ((JSONObject)localObject6).optInt("index");
        localObject9 = ((JSONObject)localObject6).optString("srcID");
        bool2 = ((JSONObject)localObject6).optBoolean("isReport");
        localObject1 = null;
        if (Boolean.valueOf(bool2).booleanValue())
        {
          localObject1 = new PublicAccountShowPictureReport();
          ((PublicAccountShowPictureReport)localObject1).parse((JSONObject)localObject6);
        }
        bool2 = ((JSONObject)localObject6).optBoolean("isNotShowIndex", true);
        if ((localObject5 == null) || (((JSONArray)localObject5).length() == 0) || (this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
          break label1108;
        }
        localObject3 = this.mRuntime.a();
        if (localObject3 == null) {
          break label1108;
        }
        localObject2 = localObject3;
        if ((localObject3 instanceof BasePluginActivity)) {
          localObject2 = ((BasePluginActivity)localObject3).getOutActivity();
        }
        localArrayList = new ArrayList();
        i = 0;
        k = ((JSONArray)localObject5).length();
        while (i < k)
        {
          localArrayList.add(((JSONArray)localObject5).get(i).toString());
          i += 1;
        }
      }
      if (localObject4 != null)
      {
        localObject3 = new ArrayList();
        i = 0;
        k = ((JSONArray)localObject4).length();
        while (i < k)
        {
          ((ArrayList)localObject3).add(((JSONArray)localObject4).get(i).toString());
          i += 1;
        }
      }
      for (;;)
      {
        localObject4 = null;
        if (localObject10 != null)
        {
          localObject5 = new ArrayList();
          i = 0;
          k = ((JSONArray)localObject10).length();
          for (;;)
          {
            localObject4 = localObject5;
            if (i >= k) {
              break;
            }
            ((ArrayList)localObject5).add(((JSONArray)localObject10).get(i).toString());
            i += 1;
          }
        }
        boolean bool3 = ((JSONObject)localObject6).optBoolean("showTitle", false);
        localObject5 = bdfr.encodeToString(((JSONObject)localObject6).optString("title", "").getBytes(), 0);
        localObject6 = ((JSONObject)localObject6).optString("articleUrl", "");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "KANDIAN Grid Image title: ", localObject5, ", articleUrl: ", localObject6, ", showTitle: ", Boolean.valueOf(bool3) });
        }
        if (bool1)
        {
          if (localObject8 != null)
          {
            localObject10 = new boolean[((JSONArray)localObject8).length()];
            i = 0;
            while (i < ((JSONArray)localObject8).length())
            {
              localObject10[i] = ((JSONArray)localObject8).getBoolean(i);
              i += 1;
            }
            localObject8 = new ArrayList();
            if ((localObject7 != null) && (((JSONArray)localObject7).length() != 0))
            {
              i = 0;
              k = ((JSONArray)localObject7).length();
              while (i < k)
              {
                ((ArrayList)localObject8).add(((JSONArray)localObject7).get(i).toString());
                i += 1;
              }
            }
            if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
            {
              this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bcgr(this);
              localObject7 = new IntentFilter("android.intent.action.WEBJSCALL");
              ((Activity)localObject2).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject7);
            }
            if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
            {
              a((Activity)localObject2, j, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
              return;
            }
            a((Activity)localObject2, j, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, (ArrayList)localObject3, (ArrayList)localObject4, paramString, true);
          }
        }
        else
        {
          if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
          {
            a((Activity)localObject2, j, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
            return;
          }
          a((Activity)localObject2, j, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, paramString);
          return;
          localObject3 = null;
          continue;
        }
        label1108:
        return;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected void b(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.3(this, paramString), 5, null, true);
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null)
        {
          String str1 = ((JSONObject)localObject).optString("callback");
          String str2 = ((JSONObject)localObject).optString("cgiURL");
          String str3 = ((JSONObject)localObject).optString("imageID");
          String str4 = ((JSONObject)localObject).optString("headFields");
          localObject = ((JSONObject)localObject).optString("postParams");
          String str5 = bglm.a(localAppInterface);
          localActivity.runOnUiThread(new TroopNoticeJsHandler.4(this, paramString, str1, a(localAppInterface.getCurrentAccountUin(), str2, str3, (String)localObject, str4, str5, b)));
          return;
        }
      }
    }
    catch (InterruptedException paramString) {}catch (Exception paramString) {}catch (OutOfMemoryError paramString) {}catch (JSONException paramString) {}
  }
  
  protected void d(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.5(this, paramString), 5, null, false);
  }
  
  public void e(String paramString)
  {
    if ((this.mRuntime == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + paramString + ")");
  }
  
  protected void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 4, "TroopNoticeJsHandler showMedia(): jsonData = " + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      localJSONArray = paramString.optJSONArray("imageIDs");
      j = paramString.optInt("index");
      bool = paramString.optBoolean("isNotShowIndex", true);
      if (localJSONArray == null) {
        return;
      }
      if (localJSONArray.length() == 0) {
        return;
      }
      if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
        return;
      }
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof BasePluginActivity)) {
        break label210;
      }
      paramString = ((BasePluginActivity)paramString).getOutActivity();
    }
    catch (JSONException paramString)
    {
      JSONArray localJSONArray;
      int j;
      boolean bool;
      ArrayList localArrayList;
      int i;
      int k;
      while (QLog.isColorLevel())
      {
        QLog.d("zivonchen", 4, QLog.getStackTraceString(paramString));
        return;
      }
    }
    localArrayList = new ArrayList();
    i = 0;
    k = localJSONArray.length();
    while (i < k)
    {
      localArrayList.add(new MediaPreviewInfo(localJSONArray.optJSONObject(i)));
      i += 1;
    }
    a(paramString, j, localArrayList, bool, 101);
    return;
    label210:
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if ((!"showPicture".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label37;
      }
      a(paramVarArgs[0]);
    }
    label37:
    do
    {
      return false;
      if (("sendPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        b(paramVarArgs[0]);
        return false;
      }
      if (("sendBatchPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        d(paramVarArgs[0]);
        return false;
      }
    } while ((!"showMedia".equals(paramString3)) || (paramVarArgs.length != 1));
    f(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    CustomWebView localCustomWebView;
    if (paramByte == 100)
    {
      localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra("DeletedList")));
      paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    localCustomWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "([])");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Activity localActivity2;
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null))
    {
      localActivity2 = this.mRuntime.a();
      if (localActivity2 != null) {}
    }
    else
    {
      return;
    }
    Activity localActivity1 = localActivity2;
    if ((localActivity2 instanceof BasePluginActivity)) {
      localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
    }
    localActivity1.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgq
 * JD-Core Version:    0.7.0.1
 */