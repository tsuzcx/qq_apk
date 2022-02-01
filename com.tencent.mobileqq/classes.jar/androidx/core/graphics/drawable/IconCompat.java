package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat
  extends CustomVersionedParcelable
{
  private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25F;
  private static final int AMBIENT_SHADOW_ALPHA = 30;
  private static final float BLUR_FACTOR = 0.01041667F;
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667F;
  private static final String EXTRA_INT1 = "int1";
  private static final String EXTRA_INT2 = "int2";
  private static final String EXTRA_OBJ = "obj";
  private static final String EXTRA_TINT_LIST = "tint_list";
  private static final String EXTRA_TINT_MODE = "tint_mode";
  private static final String EXTRA_TYPE = "type";
  private static final float ICON_DIAMETER_FACTOR = 0.9166667F;
  private static final int KEY_SHADOW_ALPHA = 61;
  private static final float KEY_SHADOW_OFFSET_FACTOR = 0.02083333F;
  private static final String TAG = "IconCompat";
  public static final int TYPE_UNKNOWN = -1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public byte[] mData = null;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mInt1 = 0;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mInt2 = 0;
  Object mObj1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Parcelable mParcelable = null;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public ColorStateList mTintList = null;
  PorterDuff.Mode mTintMode = DEFAULT_TINT_MODE;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public String mTintModeStr = null;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int mType = -1;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public IconCompat() {}
  
  private IconCompat(int paramInt)
  {
    this.mType = paramInt;
  }
  
  @Nullable
  public static IconCompat createFromBundle(@NonNull Bundle paramBundle)
  {
    int i = paramBundle.getInt("type");
    IconCompat localIconCompat = new IconCompat(i);
    localIconCompat.mInt1 = paramBundle.getInt("int1");
    localIconCompat.mInt2 = paramBundle.getInt("int2");
    if (paramBundle.containsKey("tint_list")) {
      localIconCompat.mTintList = ((ColorStateList)paramBundle.getParcelable("tint_list"));
    }
    if (paramBundle.containsKey("tint_mode")) {
      localIconCompat.mTintMode = PorterDuff.Mode.valueOf(paramBundle.getString("tint_mode"));
    }
    switch (i)
    {
    case 0: 
    default: 
      Log.w("IconCompat", "Unknown type " + i);
      return null;
    case -1: 
    case 1: 
    case 5: 
      localIconCompat.mObj1 = paramBundle.getParcelable("obj");
    }
    for (;;)
    {
      return localIconCompat;
      localIconCompat.mObj1 = paramBundle.getString("obj");
      continue;
      localIconCompat.mObj1 = paramBundle.getByteArray("obj");
    }
  }
  
  @Nullable
  @RequiresApi(23)
  public static IconCompat createFromIcon(@NonNull Context paramContext, @NonNull Icon paramIcon)
  {
    Preconditions.checkNotNull(paramIcon);
    switch (getType(paramIcon))
    {
    case 3: 
    default: 
      paramContext = new IconCompat(-1);
      paramContext.mObj1 = paramIcon;
      return paramContext;
    case 2: 
      String str = getResPackage(paramIcon);
      try
      {
        paramContext = createWithResource(getResources(paramContext, str), str, getResId(paramIcon));
        return paramContext;
      }
      catch (Resources.NotFoundException paramContext)
      {
        throw new IllegalArgumentException("Icon resource cannot be found");
      }
    }
    return createWithContentUri(getUri(paramIcon));
  }
  
  @Nullable
  @RequiresApi(23)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static IconCompat createFromIcon(@NonNull Icon paramIcon)
  {
    Preconditions.checkNotNull(paramIcon);
    switch (getType(paramIcon))
    {
    case 3: 
    default: 
      IconCompat localIconCompat = new IconCompat(-1);
      localIconCompat.mObj1 = paramIcon;
      return localIconCompat;
    case 2: 
      return createWithResource(null, getResPackage(paramIcon), getResId(paramIcon));
    }
    return createWithContentUri(getUri(paramIcon));
  }
  
  @Nullable
  @RequiresApi(23)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon paramIcon)
  {
    if ((getType(paramIcon) == 2) && (getResId(paramIcon) == 0)) {
      return null;
    }
    return createFromIcon(paramIcon);
  }
  
  @VisibleForTesting
  static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = (int)(0.6666667F * Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()));
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f1 = i * 0.5F;
    float f2 = 0.9166667F * f1;
    if (paramBoolean)
    {
      float f3 = 0.01041667F * i;
      localPaint.setColor(0);
      localPaint.setShadowLayer(f3, 0.0F, 0.02083333F * i, 1023410176);
      localCanvas.drawCircle(f1, f1, f2, localPaint);
      localPaint.setShadowLayer(f3, 0.0F, 0.0F, 503316480);
      localCanvas.drawCircle(f1, f1, f2, localPaint);
      localPaint.clearShadowLayer();
    }
    localPaint.setColor(-16777216);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - i) / 2, -(paramBitmap.getHeight() - i) / 2);
    localBitmapShader.setLocalMatrix(localMatrix);
    localPaint.setShader(localBitmapShader);
    localCanvas.drawCircle(f1, f1, f2, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  public static IconCompat createWithAdaptiveBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("Bitmap must not be null.");
    }
    IconCompat localIconCompat = new IconCompat(5);
    localIconCompat.mObj1 = paramBitmap;
    return localIconCompat;
  }
  
  public static IconCompat createWithBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("Bitmap must not be null.");
    }
    IconCompat localIconCompat = new IconCompat(1);
    localIconCompat.mObj1 = paramBitmap;
    return localIconCompat;
  }
  
  public static IconCompat createWithContentUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Uri must not be null.");
    }
    return createWithContentUri(paramUri.toString());
  }
  
  public static IconCompat createWithContentUri(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Uri must not be null.");
    }
    IconCompat localIconCompat = new IconCompat(4);
    localIconCompat.mObj1 = paramString;
    return localIconCompat;
  }
  
  public static IconCompat createWithData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Data must not be null.");
    }
    IconCompat localIconCompat = new IconCompat(3);
    localIconCompat.mObj1 = paramArrayOfByte;
    localIconCompat.mInt1 = paramInt1;
    localIconCompat.mInt2 = paramInt2;
    return localIconCompat;
  }
  
  public static IconCompat createWithResource(Context paramContext, @DrawableRes int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null.");
    }
    return createWithResource(paramContext.getResources(), paramContext.getPackageName(), paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static IconCompat createWithResource(Resources paramResources, String paramString, @DrawableRes int paramInt)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Package must not be null.");
    }
    if (paramInt == 0) {
      throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }
    IconCompat localIconCompat = new IconCompat(2);
    localIconCompat.mInt1 = paramInt;
    if (paramResources != null) {
      try
      {
        localIconCompat.mObj1 = paramResources.getResourceName(paramInt);
        return localIconCompat;
      }
      catch (Resources.NotFoundException paramResources)
      {
        throw new IllegalArgumentException("Icon resource cannot be found");
      }
    }
    localIconCompat.mObj1 = paramString;
    return localIconCompat;
  }
  
  @DrawableRes
  @IdRes
  @RequiresApi(23)
  private static int getResId(@NonNull Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResId();
    }
    try
    {
      int i = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
      return 0;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon resource", paramIcon);
    }
    return 0;
  }
  
  @Nullable
  @RequiresApi(23)
  private static String getResPackage(@NonNull Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResPackage();
    }
    try
    {
      paramIcon = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon package", paramIcon);
    }
    return null;
  }
  
  private static Resources getResources(Context paramContext, String paramString)
  {
    Object localObject = null;
    if ("android".equals(paramString)) {
      paramContext = Resources.getSystem();
    }
    for (;;)
    {
      return paramContext;
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramString, 8192);
        paramContext = localObject;
        if (localApplicationInfo != null)
        {
          paramContext = localPackageManager.getResourcesForApplication(localApplicationInfo);
          return paramContext;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[] { paramString }), paramContext);
      }
    }
    return null;
  }
  
  @RequiresApi(23)
  private static int getType(@NonNull Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getType();
    }
    try
    {
      int i = ((Integer)paramIcon.getClass().getMethod("getType", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localIllegalAccessException);
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localInvocationTargetException);
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("IconCompat", "Unable to get icon type " + paramIcon, localNoSuchMethodException);
    }
    return -1;
  }
  
  @Nullable
  @RequiresApi(23)
  private static Uri getUri(@NonNull Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getUri();
    }
    try
    {
      paramIcon = (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      Log.e("IconCompat", "Unable to get icon uri", paramIcon);
    }
    return null;
  }
  
  private Drawable loadDrawableInner(Context paramContext)
  {
    switch (this.mType)
    {
    default: 
    case 1: 
    case 5: 
    case 2: 
      for (;;)
      {
        return null;
        return new BitmapDrawable(paramContext.getResources(), (Bitmap)this.mObj1);
        return new BitmapDrawable(paramContext.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
        localObject3 = getResPackage();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = paramContext.getPackageName();
        }
        localObject1 = getResources(paramContext, (String)localObject1);
        try
        {
          paramContext = ResourcesCompat.getDrawable((Resources)localObject1, this.mInt1, paramContext.getTheme());
          return paramContext;
        }
        catch (RuntimeException paramContext)
        {
          Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", new Object[] { Integer.valueOf(this.mInt1), this.mObj1 }), paramContext);
        }
      }
    case 3: 
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeByteArray((byte[])this.mObj1, this.mInt1, this.mInt2));
    }
    Object localObject3 = Uri.parse((String)this.mObj1);
    Object localObject1 = ((Uri)localObject3).getScheme();
    if (("content".equals(localObject1)) || ("file".equals(localObject1))) {}
    for (;;)
    {
      FileInputStream localFileInputStream;
      try
      {
        localObject1 = paramContext.getContentResolver().openInputStream((Uri)localObject3);
        if (localObject1 == null) {
          break;
        }
        return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)localObject1));
      }
      catch (Exception localException)
      {
        Log.w("IconCompat", "Unable to load image from URI: " + localObject3, localException);
        localFileInputStream = null;
        continue;
      }
      try
      {
        localFileInputStream = new FileInputStream(new File((String)this.mObj1));
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Log.w("IconCompat", "Unable to load image from path: " + localObject3, localFileNotFoundException);
        Object localObject2 = null;
      }
    }
  }
  
  private static String typeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 1: 
      return "BITMAP";
    case 5: 
      return "BITMAP_MASKABLE";
    case 3: 
      return "DATA";
    case 2: 
      return "RESOURCE";
    }
    return "URI";
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void addToShortcutIntent(@NonNull Intent paramIntent, @Nullable Drawable paramDrawable, @NonNull Context paramContext)
  {
    checkResource(paramContext);
    int i;
    switch (this.mType)
    {
    case 3: 
    case 4: 
    default: 
      throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    case 1: 
      localObject = (Bitmap)this.mObj1;
      paramContext = (Context)localObject;
      if (paramDrawable == null) {
        break;
      }
    case 5: 
      for (paramContext = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);; paramContext = createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, true))
      {
        if (paramDrawable != null)
        {
          i = paramContext.getWidth();
          int j = paramContext.getHeight();
          paramDrawable.setBounds(i / 2, j / 2, i, j);
          paramDrawable.draw(new Canvas(paramContext));
        }
        paramIntent.putExtra("android.intent.extra.shortcut.ICON", paramContext);
        return;
      }
    }
    try
    {
      paramContext = paramContext.createPackageContext(getResPackage(), 0);
      if (paramDrawable == null)
      {
        paramIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, this.mInt1));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramIntent)
    {
      throw new IllegalArgumentException("Can't find package " + this.mObj1, paramIntent);
    }
    Object localObject = ContextCompat.getDrawable(paramContext, this.mInt1);
    if ((((Drawable)localObject).getIntrinsicWidth() <= 0) || (((Drawable)localObject).getIntrinsicHeight() <= 0)) {
      i = ((ActivityManager)paramContext.getSystemService("activity")).getLauncherLargeIconSize();
    }
    for (paramContext = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);; paramContext = Bitmap.createBitmap(((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      ((Drawable)localObject).setBounds(0, 0, paramContext.getWidth(), paramContext.getHeight());
      ((Drawable)localObject).draw(new Canvas(paramContext));
      break;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void checkResource(Context paramContext)
  {
    String str2;
    if (this.mType == 2)
    {
      str2 = (String)this.mObj1;
      if (str2.contains(":")) {
        break label29;
      }
    }
    label29:
    String str3;
    int i;
    do
    {
      return;
      str3 = str2.split(":", -1)[1];
      String str1 = str3.split("/", -1)[0];
      str3 = str3.split("/", -1)[1];
      str2 = str2.split(":", -1)[0];
      i = getResources(paramContext, str2).getIdentifier(str3, str1, str2);
    } while (this.mInt1 == i);
    Log.i("IconCompat", "Id has changed for " + str2 + "/" + str3);
    this.mInt1 = i;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Bitmap getBitmap()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      if ((this.mObj1 instanceof Bitmap)) {
        return (Bitmap)this.mObj1;
      }
      return null;
    }
    if (this.mType == 1) {
      return (Bitmap)this.mObj1;
    }
    if (this.mType == 5) {
      return createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, true);
    }
    throw new IllegalStateException("called getBitmap() on " + this);
  }
  
  @IdRes
  public int getResId()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return getResId((Icon)this.mObj1);
    }
    if (this.mType != 2) {
      throw new IllegalStateException("called getResId() on " + this);
    }
    return this.mInt1;
  }
  
  @NonNull
  public String getResPackage()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return getResPackage((Icon)this.mObj1);
    }
    if (this.mType != 2) {
      throw new IllegalStateException("called getResPackage() on " + this);
    }
    return ((String)this.mObj1).split(":", -1)[0];
  }
  
  public int getType()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return getType((Icon)this.mObj1);
    }
    return this.mType;
  }
  
  @NonNull
  public Uri getUri()
  {
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return getUri((Icon)this.mObj1);
    }
    return Uri.parse((String)this.mObj1);
  }
  
  public Drawable loadDrawable(Context paramContext)
  {
    checkResource(paramContext);
    if (Build.VERSION.SDK_INT >= 23) {
      paramContext = toIcon().loadDrawable(paramContext);
    }
    Drawable localDrawable;
    do
    {
      do
      {
        return paramContext;
        localDrawable = loadDrawableInner(paramContext);
        paramContext = localDrawable;
      } while (localDrawable == null);
      if (this.mTintList != null) {
        break;
      }
      paramContext = localDrawable;
    } while (this.mTintMode == DEFAULT_TINT_MODE);
    localDrawable.mutate();
    DrawableCompat.setTintList(localDrawable, this.mTintList);
    DrawableCompat.setTintMode(localDrawable, this.mTintMode);
    return localDrawable;
  }
  
  public void onPostParceling()
  {
    this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
    switch (this.mType)
    {
    case 0: 
    default: 
      return;
    case -1: 
      if (this.mParcelable != null)
      {
        this.mObj1 = this.mParcelable;
        return;
      }
      throw new IllegalArgumentException("Invalid icon");
    case 1: 
    case 5: 
      if (this.mParcelable != null)
      {
        this.mObj1 = this.mParcelable;
        return;
      }
      this.mObj1 = this.mData;
      this.mType = 3;
      this.mInt1 = 0;
      this.mInt2 = this.mData.length;
      return;
    case 2: 
    case 4: 
      this.mObj1 = new String(this.mData, Charset.forName("UTF-16"));
      return;
    }
    this.mObj1 = this.mData;
  }
  
  public void onPreParceling(boolean paramBoolean)
  {
    this.mTintModeStr = this.mTintMode.name();
    switch (this.mType)
    {
    case 0: 
    default: 
      return;
    case -1: 
      if (paramBoolean) {
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
      }
      this.mParcelable = ((Parcelable)this.mObj1);
      return;
    case 1: 
    case 5: 
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)this.mObj1;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        this.mData = localByteArrayOutputStream.toByteArray();
        return;
      }
      this.mParcelable = ((Parcelable)this.mObj1);
      return;
    case 4: 
      this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
      return;
    case 2: 
      this.mData = ((String)this.mObj1).getBytes(Charset.forName("UTF-16"));
      return;
    }
    this.mData = ((byte[])this.mObj1);
  }
  
  public IconCompat setTint(@ColorInt int paramInt)
  {
    return setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public IconCompat setTintList(ColorStateList paramColorStateList)
  {
    this.mTintList = paramColorStateList;
    return this;
  }
  
  public IconCompat setTintMode(PorterDuff.Mode paramMode)
  {
    this.mTintMode = paramMode;
    return this;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    switch (this.mType)
    {
    case 0: 
    default: 
      throw new IllegalArgumentException("Invalid icon");
    case 1: 
    case 5: 
      localBundle.putParcelable("obj", (Bitmap)this.mObj1);
    }
    for (;;)
    {
      localBundle.putInt("type", this.mType);
      localBundle.putInt("int1", this.mInt1);
      localBundle.putInt("int2", this.mInt2);
      if (this.mTintList != null) {
        localBundle.putParcelable("tint_list", this.mTintList);
      }
      if (this.mTintMode != DEFAULT_TINT_MODE) {
        localBundle.putString("tint_mode", this.mTintMode.name());
      }
      return localBundle;
      localBundle.putParcelable("obj", (Parcelable)this.mObj1);
      continue;
      localBundle.putString("obj", (String)this.mObj1);
      continue;
      localBundle.putByteArray("obj", (byte[])this.mObj1);
    }
  }
  
  @RequiresApi(23)
  public Icon toIcon()
  {
    Object localObject;
    Icon localIcon;
    switch (this.mType)
    {
    case 0: 
    default: 
      throw new IllegalArgumentException("Unknown type");
    case -1: 
      localObject = (Icon)this.mObj1;
      return localObject;
    case 1: 
      localIcon = Icon.createWithBitmap((Bitmap)this.mObj1);
    }
    for (;;)
    {
      if (this.mTintList != null) {
        localIcon.setTintList(this.mTintList);
      }
      localObject = localIcon;
      if (this.mTintMode == DEFAULT_TINT_MODE) {
        break;
      }
      localIcon.setTintMode(this.mTintMode);
      return localIcon;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localIcon = Icon.createWithAdaptiveBitmap((Bitmap)this.mObj1);
      }
      else
      {
        localIcon = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
        continue;
        localIcon = Icon.createWithResource(getResPackage(), this.mInt1);
        continue;
        localIcon = Icon.createWithData((byte[])this.mObj1, this.mInt1, this.mInt2);
        continue;
        localIcon = Icon.createWithContentUri((String)this.mObj1);
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    if (this.mType == -1) {
      return String.valueOf(this.mObj1);
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=").append(typeToString(this.mType));
    switch (this.mType)
    {
    }
    for (;;)
    {
      if (this.mTintList != null)
      {
        localStringBuilder.append(" tint=");
        localStringBuilder.append(this.mTintList);
      }
      if (this.mTintMode != DEFAULT_TINT_MODE) {
        localStringBuilder.append(" mode=").append(this.mTintMode);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(" size=").append(((Bitmap)this.mObj1).getWidth()).append("x").append(((Bitmap)this.mObj1).getHeight());
      continue;
      localStringBuilder.append(" pkg=").append(getResPackage()).append(" id=").append(String.format("0x%08x", new Object[] { Integer.valueOf(getResId()) }));
      continue;
      localStringBuilder.append(" len=").append(this.mInt1);
      if (this.mInt2 != 0)
      {
        localStringBuilder.append(" off=").append(this.mInt2);
        continue;
        localStringBuilder.append(" uri=").append(this.mObj1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompat
 * JD-Core Version:    0.7.0.1
 */