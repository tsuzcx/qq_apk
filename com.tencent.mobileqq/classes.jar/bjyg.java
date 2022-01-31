import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.2;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bjyg
  extends bjxz
{
  public static Set<String> a;
  private byte jdField_a_of_type_Byte = 115;
  public int a;
  JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private boolean b;
  int c = 0;
  int d = 3;
  int e = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public bjyg()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static double a(Context paramContext, int paramInt, bjxx parambjxx)
  {
    if (parambjxx != null)
    {
      int i = parambjxx.jdField_a_of_type_Int;
      int j = parambjxx.jdField_b_of_type_Int;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        paramContext = bjdt.a(paramContext, k, j, paramInt, false);
        double d3;
        if ((paramContext == null) || ((k <= paramContext.width) && (j <= paramContext.height)))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / paramContext.width;
        }
        for (double d2 = j / paramContext.height;; d2 = k / paramContext.height)
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / paramContext.width;
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  private int a()
  {
    if (this.d > 1) {
      return 1;
    }
    return 2;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    switch (paramJSONObject.optInt("compressType", 0))
    {
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static String a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return paramString;
      localObject = new File(paramString);
    } while ((!((File)localObject).exists()) || (!((File)localObject).canRead()) || (!SharpPUtil.isSharpPFile((File)localObject)));
    try
    {
      if (!bhqa.a(paramContext))
      {
        QLog.w("QzonePhotoWallPlugin", 1, "------ sharpp is not avaliable.");
        return paramString;
      }
    }
    catch (Throwable paramContext) {}
    for (;;)
    {
      QLog.e("QzonePhotoWallPlugin", 1, "decodeSharpP catch an exception: ", paramContext);
      return paramString;
      localObject = SharpPUtil.decodeSharpPByFilePath(((File)localObject).getAbsolutePath());
      if (localObject == null) {
        break;
      }
      String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
      paramContext = bdzf.a(alof.bd + str);
      boolean bool = bjup.a((Bitmap)localObject, paramContext, Bitmap.CompressFormat.JPEG, 90, true);
      if (!bool) {
        break;
      }
      try
      {
        QLog.i("QzonePhotoWallPlugin", 1, "------ sharpp file save success:" + str);
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramContext;
        paramContext = localThrowable;
      }
    }
  }
  
  private static void a(Activity paramActivity, WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = AbsBaseWebViewActivity.a(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    paramActivity.startActivity(paramIntent);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.getInt("pickerType");
      this.d = paramString.getInt("maxPickCount");
      this.e = a(paramString);
      this.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("userInfo");
      this.jdField_a_of_type_Boolean = paramString.optBoolean("clipByH5");
      this.jdField_b_of_type_Boolean = paramString.optBoolean("noNeedImageData", false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    ThreadManager.post(new QzonePhotoWallPlugin.2(this, paramArrayList), 8, null, false);
  }
  
  private void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          Object localObject = (String)paramArrayList.get(i);
          long l1 = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            String str2 = a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getApplicationContext());
            jdField_a_of_type_JavaUtilSet.add(str2);
            localObject = bjxu.a(str2);
            if (localObject != null)
            {
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize with =" + ((bjxx)localObject).jdField_a_of_type_Int + " height=" + ((bjxx)localObject).jdField_b_of_type_Int + " compressType=" + this.e);
              if (this.e != 3)
              {
                double d1 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), this.e, (bjxx)localObject);
                if (d1 > 0.0D)
                {
                  ((bjxx)localObject).jdField_a_of_type_Int = ((int)(((bjxx)localObject).jdField_a_of_type_Int / d1));
                  ((bjxx)localObject).jdField_b_of_type_Int = ((int)(((bjxx)localObject).jdField_b_of_type_Int / d1));
                }
              }
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize change width =" + ((bjxx)localObject).jdField_a_of_type_Int + " height=" + ((bjxx)localObject).jdField_b_of_type_Int + " compressType=" + this.e);
              String str1 = bjxu.a(str2, ((bjxx)localObject).jdField_a_of_type_Int, ((bjxx)localObject).jdField_b_of_type_Int);
              boolean bool = TextUtils.isEmpty(str1);
              if (!bool) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("currentIndex", i);
                  String str3;
                  if ((a() == 2) || (!paramBoolean))
                  {
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize before path =" + str2);
                    str3 = Base64.encodeToString(str2.getBytes(), 2);
                    localJSONObject.put("identifier", str3);
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize toH5 identifier =" + str3);
                  }
                  int j = 0;
                  if (!this.jdField_b_of_type_Boolean)
                  {
                    str3 = "" + "data:image/jpg;base64," + str1;
                    j = str1.length();
                    localJSONObject.put("imageSize", j);
                    localJSONObject.put("data", str3);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZImagePickerJSInterface.onReceive(" + localJSONObject.toString() + ")");
                  long l2 = System.currentTimeMillis();
                  QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize  path=" + str2 + " timediff=" + (l2 - l1) + " length=" + j + " compressType =" + this.e + " with =" + ((bjxx)localObject).jdField_a_of_type_Int + " height=" + ((bjxx)localObject).jdField_b_of_type_Int);
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  QLog.e("QzonePhotoWallPlugin", 2, "imageBase64 size=" + str1.length() + ",compressType=" + this.e + ",width=" + ((bjxx)localObject).jdField_a_of_type_Int + ",height=" + ((bjxx)localObject).jdField_b_of_type_Int + "," + localOutOfMemoryError);
                  bflz.a().a(alud.a(2131712535), 1);
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.e("QzonePhotoWallPlugin", 1, "toBase64: " + paramArrayList);
      }
      i += 1;
    }
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), NewPhotoListActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", this.d);
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if (this.d > 1) {}
    for (boolean bool = false;; bool = true)
    {
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      localIntent.putExtras((Bundle)localObject);
      bjdt.c(localIntent);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (localObject == null) {
        break;
      }
      a((Activity)localObject, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, localIntent, this.jdField_a_of_type_Byte);
      return;
    }
    QLog.e("QzonePhotoWallPlugin", 1, "launchCustom MobileAlbum activity is null");
  }
  
  private void b(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if (bjvb.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), new bjyh(this), 1)) {}
    }
    while (!"QzoneAlbum".equals(paramString))
    {
      return;
      b();
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", a());
    paramString.putInt("_input_max", this.d);
    paramString.putBoolean("key_multiple_model_need_download_img", true);
    bjea localbjea = bjea.a();
    localbjea.a = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), localbjea, paramString, this.jdField_a_of_type_Byte);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
        }
        localJSONObject.put("userInfo", this.jdField_a_of_type_OrgJsonJSONObject);
        if (paramArrayList != null) {
          continue;
        }
        i = 0;
        localJSONObject.put("totalPickCount", i);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZImagePickerJSInterface.doSelectPhoto(" + localJSONObject.toString() + ")");
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      if ((a() == 2) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        jdField_a_of_type_JavaUtilSet.add(paramArrayList.get(0));
      }
      ThreadManager.post(new QzonePhotoWallPlugin.3(this, paramArrayList), 8, null, false);
      return;
      i = paramArrayList.size();
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if ((paramByte == this.jdField_a_of_type_Byte) && (paramInt == -1))
    {
      ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      ArrayList localArrayList1;
      if (localArrayList2 != null)
      {
        localArrayList1 = localArrayList2;
        if (!localArrayList2.isEmpty()) {}
      }
      else
      {
        localArrayList2 = new ArrayList(1);
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localArrayList1 = localArrayList2;
        if (!TextUtils.isEmpty(paramIntent))
        {
          localArrayList2.add(paramIntent);
          localArrayList1 = localArrayList2;
        }
      }
      b(localArrayList1);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("QZImagePicker")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString3.equals("choosePhoto")) {
          break;
        }
        bool1 = bool2;
      } while (paramVarArgs == null);
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    a(paramVarArgs[0]);
    this.e = 0;
    if (this.c == 0)
    {
      b("MobileAlbum");
      return true;
    }
    b("QzoneAlbum");
    return true;
    if (paramString3.equals("getLocalImage")) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.e = a(paramJsBridgeListener);
        paramJsBridgeListener = paramJsBridgeListener.optString("identifier", "");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
          return false;
        }
        paramJsBridgeListener = new String(Base64.decode(paramJsBridgeListener, 2));
        paramString1 = new ArrayList();
        paramString1.add(paramJsBridgeListener);
        QLog.i("QzonePhotoWallPlugin", 1, "@coverOptimize  identifier =" + paramJsBridgeListener);
        if (!jdField_a_of_type_JavaUtilSet.contains(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is wrong identifier = " + paramJsBridgeListener);
          return false;
        }
        this.jdField_b_of_type_Boolean = false;
        a(paramString1);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.jdField_a_of_type_Byte) && (j == -1))
      {
        if (a() != 1) {
          break label128;
        }
        paramString = localIntent.getStringArrayListExtra("key_cover_selected_img_path");
      }
      for (;;)
      {
        b(paramString);
        return true;
        label128:
        paramString = new ArrayList();
        paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramMap)) {
          paramString.add(paramMap);
        }
      }
    }
    return super.a(paramString, paramLong, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjyg
 * JD-Core Version:    0.7.0.1
 */