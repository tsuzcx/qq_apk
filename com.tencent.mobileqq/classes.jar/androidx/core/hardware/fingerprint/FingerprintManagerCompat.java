package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

@Deprecated
public class FingerprintManagerCompat
{
  private final Context mContext;
  
  private FingerprintManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static FingerprintManagerCompat from(@NonNull Context paramContext)
  {
    return new FingerprintManagerCompat(paramContext);
  }
  
  @Nullable
  @RequiresApi(23)
  private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT == 23) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    if ((Build.VERSION.SDK_INT > 23) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint"))) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  @RequiresApi(23)
  static FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    FingerprintManagerCompat.CryptoObject localCryptoObject = null;
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      localCryptoObject = new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getMac());
    }
    return localCryptoObject;
  }
  
  @RequiresApi(23)
  private static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    return new FingerprintManagerCompat.1(paramAuthenticationCallback);
  }
  
  @RequiresApi(23)
  private static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerCompat.CryptoObject paramCryptoObject)
  {
    FingerprintManager.CryptoObject localCryptoObject = null;
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      localCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
    }
    return localCryptoObject;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public void authenticate(@Nullable FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, @Nullable androidx.core.os.CancellationSignal paramCancellationSignal, @NonNull FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      if (localFingerprintManager != null)
      {
        if (paramCancellationSignal != null) {
          paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal.getCancellationSignalObject();
        } else {
          paramCancellationSignal = null;
        }
        localFingerprintManager.authenticate(wrapCryptoObject(paramCryptoObject), paramCancellationSignal, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
      }
    }
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean hasEnrolledFingerprints()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.hasEnrolledFingerprints()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean isHardwareDetected()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.isHardwareDetected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.hardware.fingerprint.FingerprintManagerCompat
 * JD-Core Version:    0.7.0.1
 */