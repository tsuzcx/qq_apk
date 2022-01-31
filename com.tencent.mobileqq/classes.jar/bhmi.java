import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.share.WXShareFromQZHelper.1;
import cooperation.qzone.share.WXShareFromQZHelper.2;
import cooperation.qzone.share.WXShareFromQZHelper.3;
import cooperation.qzone.share.WXShareFromQZHelper.4;
import cooperation.qzone.share.WXShareFromQZHelper.5;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bhmi
  implements IWXAPIEventHandler
{
  private static bhmi jdField_a_of_type_Bhmi;
  public static String a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b;
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx34b037fdb0f655ee", true);
  private CopyOnWriteArrayList<bhmj> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhmi.class.getSimpleName();
    b = bbvj.a(ajsd.aW + "photo/");
  }
  
  private bhmi()
  {
    a();
  }
  
  public static bhmi a()
  {
    if (jdField_a_of_type_Bhmi == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bhmi == null) {
        jdField_a_of_type_Bhmi = new bhmi();
      }
      return jdField_a_of_type_Bhmi;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", QzoneConfig.getInstance().getConfig("H5Url", "WeiXinDownload", "http://app.qq.com/#id=detail&appid=100733732"));
      localIntent.putExtra("fromQZone", true);
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(Activity paramActivity, BaseReq paramBaseReq)
  {
    if ((paramActivity != null) && (paramBaseReq != null)) {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        try
        {
          localObject2 = ((ShowMessageFromWX.Req)paramBaseReq).message.messageExt;
          paramBaseReq = axbl.b((String)localObject2);
          if ((paramBaseReq.get("actiontype") != null) && (((String)paramBaseReq.get("actiontype")).equals("schema")) && (paramBaseReq.get("schema") != null))
          {
            localObject1 = Uri.decode((String)paramBaseReq.get("schema"));
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((!((String)localObject1).startsWith("mqzone")) && (!((String)localObject1).startsWith("mqqzone")) && (!((String)localObject1).startsWith("mqqapi://qzoneschema")))) {
              break;
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("cmd", "Schema");
            ((Intent)localObject2).putExtra("schema", (String)localObject1);
            bgyp.a(paramActivity, bgyw.a(), (Intent)localObject2);
            paramActivity = (String)paramBaseReq.get("appid");
            if (paramActivity == null)
            {
              i = 0;
              new LpReportInfo_pf00064(2000, 3000, i).reportImediately();
              return;
            }
            int i = Integer.parseInt(paramActivity);
            continue;
          }
          if ((paramBaseReq.get("appid") == null) || (!((String)paramBaseReq.get("appid")).equals("1000398")) || ((!paramBaseReq.containsKey("albumId")) && (!paramBaseReq.containsKey("aid")))) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("cmd", "Schema");
          if ("1".equals(paramBaseReq.get("pagetype")))
          {
            paramBaseReq = ((String)localObject2).replace("aid", "albumid");
            ((Intent)localObject1).putExtra("schema", "mqzone://arouse/album?" + paramBaseReq + "&source=doNotJumpQzone");
            bgyp.a(paramActivity, bgyw.a(), (Intent)localObject1);
            return;
          }
        }
        catch (Throwable paramActivity)
        {
          paramActivity.printStackTrace();
          return;
        }
        if ("0".equals(paramBaseReq.get("pagetype"))) {
          ((Intent)localObject1).putExtra("schema", "mqzone://arouse/photofromwxapp?" + (String)localObject2 + "&source=doNotJumpQzone");
        }
      }
    }
  }
  
  public static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wx34b037fdb0f655ee");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
    }
  }
  
  public void a(Context paramContext, ArrayList<File> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    localIntent.setAction("android.intent.action.SEND_MULTIPLE");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(Uri.fromFile((File)paramArrayList.next()));
    }
    localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getApplication(), localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public void a(bhmj parambhmj)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambhmj)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambhmj);
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new WXTextObject(paramString);
    paramString = new WXMediaMessage();
    paramString.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    localObject = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject).transaction = a("text");
    ((SendMessageToWX.Req)localObject).message = paramString;
    ((SendMessageToWX.Req)localObject).scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq((BaseReq)localObject)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.3(this));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = new WXMediaMessage(new WXWebpageObject(paramString3));
    paramString3.description = paramString2;
    paramString3.title = paramString1;
    paramString3.thumbData = WXShareHelper.a(paramBitmap, false, true);
    paramString1 = new SendMessageToWX.Req();
    paramString1.transaction = a("webpage");
    paramString1.message = paramString3;
    paramString1.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString1)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.1(this));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString3;
    localWXMiniProgramObject.userName = paramString5;
    if (!TextUtils.isEmpty(paramString6))
    {
      localWXMiniProgramObject.path = (paramString4 + "&sk=" + paramString6);
      paramString3 = new WXMediaMessage(localWXMiniProgramObject);
      paramString3.title = paramString1;
      paramString3.description = paramString2;
      if (paramBitmap == null) {
        break label431;
      }
      try
      {
        float f = Math.min(400.0F / paramBitmap.getWidth(), 400.0F / paramBitmap.getHeight());
        paramString1 = new Matrix();
        paramString1.postScale(f, f);
        paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString1, true);
        paramString3.thumbData = a(paramString1, 100);
        QZLog.e(jdField_a_of_type_JavaLangString, "wxshare thumbData:" + paramString3.thumbData.length);
        int j = 4;
        int i = 100;
        while ((paramString3.thumbData != null) && (paramString3.thumbData.length >= 131072))
        {
          j -= 1;
          if (j > 0)
          {
            i -= 10;
            paramString3.thumbData = a(paramString1, i);
            QZLog.e(jdField_a_of_type_JavaLangString, "wxshare thumbData -- :" + paramString3.thumbData.length);
            continue;
            paramString1 = new SendMessageToWX.Req();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, "excetion:" + paramString1.getMessage());
        ThreadManager.getUIHandler().post(new WXShareFromQZHelper.4(this));
      }
    }
    for (;;)
    {
      paramString1.transaction = a("webpage");
      paramString1.message = paramString3;
      paramString1.scene = paramInt;
      boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramString1);
      if (!bool)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, "wxshare failed ,ret:" + bool);
        ThreadManager.getUIHandler().post(new WXShareFromQZHelper.5(this));
      }
      return;
      localWXMiniProgramObject.path = paramString4;
      break;
      paramString1.recycle();
      continue;
      label431:
      QZLog.e(jdField_a_of_type_JavaLangString, "wxshare bmp null");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.imagePath = paramString;
    paramString = new WXMediaMessage();
    paramString.mediaObject = localWXImageObject;
    if (paramInt == 0)
    {
      paramString.thumbData = paramArrayOfByte;
      if ((paramString.thumbData == null) || ((paramString.thumbData != null) && (paramString.thumbData.length > 32768))) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "wxmsg.thumbData is invalid");
      }
    }
    paramArrayOfByte = new SendMessageToWX.Req();
    paramArrayOfByte.transaction = a("img");
    paramArrayOfByte.message = paramString;
    paramArrayOfByte.scene = paramInt;
    if (!this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(paramArrayOfByte)) {
      ThreadManager.getUIHandler().post(new WXShareFromQZHelper.2(this));
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "isWXinstalled error ", localThrowable);
    }
    return false;
  }
  
  public void b(bhmj parambhmj)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambhmj)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(parambhmj);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 620756993;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
    for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
    {
      a(localActivity, paramBaseReq);
      return;
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((bhmj)localIterator.next()).a(paramBaseResp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhmi
 * JD-Core Version:    0.7.0.1
 */