import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.io.ByteArrayOutputStream;

public class bhal
  extends QIPCModule
{
  public bhal()
  {
    super("AECameraGetInfoServer");
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static bhal a()
  {
    return bham.a();
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  private String a(@NonNull String paramString)
  {
    if (paramString.contains("183.61.46.145")) {
      return "IPv4";
    }
    if (paramString.contains("240e:e1:a900:50::18")) {
      return "IPv6";
    }
    return "Unknown";
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2;
    if ("WATER_MARK_GET_PROFILE_PHOTO".equals(paramString))
    {
      paramBundle = (ajjj)((QQAppInterface)localObject1).getManager(51);
      if (paramBundle != null)
      {
        paramString = ((QQAppInterface)localObject1).c();
        paramBundle = paramBundle.c(paramString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("QQ_NUMBER", paramString);
        ((Bundle)localObject2).putInt("QQ_LEVEL", paramBundle.iQQLevel);
        ((Bundle)localObject2).putInt("QQ_VIP_LEVEL", paramBundle.iSuperVipLevel);
        ((Bundle)localObject2).putShort("QQ_SEX", paramBundle.shGender);
        ((Bundle)localObject2).putString("QQ_NICKNAME", paramBundle.strNick);
        ((Bundle)localObject2).putByteArray("PROFILE_PHOTO", a(a(azwp.a((AppInterface)localObject1, paramString, (byte)3))));
        return EIPCResult.createResult(0, (Bundle)localObject2);
      }
    }
    else if ("WATER_MARK_GET_QQCARD_FRIENDINFO".equals(paramString))
    {
      localObject2 = (ajjj)((QQAppInterface)localObject1).getManager(51);
      if (localObject2 != null)
      {
        paramString = paramBundle.getString("friend");
        paramBundle = ((ajjj)localObject2).c(paramString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("QQ_NUMBER", paramString);
        ((Bundle)localObject2).putInt("QQ_LEVEL", paramBundle.iQQLevel);
        ((Bundle)localObject2).putInt("QQ_VIP_LEVEL", paramBundle.iSuperVipLevel);
        ((Bundle)localObject2).putShort("QQ_SEX", paramBundle.shGender);
        ((Bundle)localObject2).putString("QQ_NICKNAME", paramBundle.strNick);
        ((Bundle)localObject2).putByteArray("PROFILE_PHOTO", a(a(azwp.a((AppInterface)localObject1, paramString, (byte)3))));
        return EIPCResult.createResult(0, (Bundle)localObject2);
      }
    }
    else if ("ACTION_GET_ENV_INFO".equals(paramString))
    {
      paramBundle = new Bundle();
      if (EnvSwitchActivity.isTestEnvironment())
      {
        localObject1 = EnvSwitchActivity.loadTestEnvironment()[0];
        paramString = "Unknown";
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = a((String)localObject1);
        }
        paramBundle.putString("KEY_ENV_INFO", "Test Env: " + paramString);
      }
      for (;;)
      {
        paramString = EIPCResult.createSuccessResult(paramBundle);
        callbackResult(paramInt, paramString);
        return paramString;
        paramBundle.putString("KEY_ENV_INFO", "Prod Env");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhal
 * JD-Core Version:    0.7.0.1
 */