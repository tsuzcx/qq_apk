import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qflutter.resource_loader.NativeAppInterface;
import com.qflutter.resource_loader.NativeColorInfo;
import com.qflutter.resource_loader.NativeImageInfo;
import com.qflutter.resource_loader.NinePatchInfo;
import com.qflutter.resource_loader.Utils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flutter.engine.QFlutterResourceLoaderNativeImp.1;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class auxa
  implements NativeAppInterface
{
  private static String jdField_a_of_type_JavaLangString = "";
  public static HashMap<String, Integer> a;
  public static HashMap<String, String> b;
  public static HashMap<String, Integer> c;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<ColorStateList> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Handler b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skinConversationPageBg", Integer.valueOf(2130850026));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBlueNormal", Integer.valueOf(2130850053));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBluePressed", Integer.valueOf(2130850052));
    jdField_a_of_type_JavaUtilHashMap.put("skinAIOBubbleNormal", Integer.valueOf(2130849824));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBg", Integer.valueOf(2130850099));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackNormal", Integer.valueOf(2130850113));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackPressed", Integer.valueOf(2130850117));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageBg", Integer.valueOf(2130850024));
    jdField_a_of_type_JavaUtilHashMap.put("skinFromItemRightArrow", Integer.valueOf(2130850149));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgNormal", Integer.valueOf(2130850350));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgPressed", Integer.valueOf(2130850347));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgNormal", Integer.valueOf(2130850370));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgPressed", Integer.valueOf(2130850368));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgNormal", Integer.valueOf(2130850364));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgPressed", Integer.valueOf(2130850362));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgNormal", Integer.valueOf(2130850355));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgPressed", Integer.valueOf(2130850353));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOff", Integer.valueOf(2130850382));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOn", Integer.valueOf(2130850383));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOff", Integer.valueOf(2130850380));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOn", Integer.valueOf(2130850378));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130850379));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130850381));
    jdField_a_of_type_JavaUtilHashMap.put("skinTipsNew", Integer.valueOf(2130850403));
    jdField_a_of_type_JavaUtilHashMap.put("qzoneAlbumCategoryLockIcon", Integer.valueOf(2130848577));
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
    c.put("skinConversationNickBlack", Integer.valueOf(2131166997));
    c.put("skinConversationMsgGray", Integer.valueOf(2131167074));
    c.put("skinBtnBlueTextColor", Integer.valueOf(2131167023));
    c.put("skinBtnWhiteTextColor", Integer.valueOf(2131167031));
    c.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131166984));
    c.put("skinPageTitleBarTextColor", Integer.valueOf(2131166987));
    c.put("skinFormItemBlack", Integer.valueOf(2131166990));
    c.put("skinFormItemGray", Integer.valueOf(2131167071));
  }
  
  public auxa(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = ThreadManagerV2.getUIHandlerV2();
    a();
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = new File(paramString, "libqflutter-resource-loader.so").getAbsolutePath();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "preCacheColors");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      ThreadManagerV2.executeOnSubThread(new QFlutterResourceLoaderNativeImp.1(this, this.jdField_a_of_type_JavaUtilArrayList, localResources), true);
    }
  }
  
  public Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableNinePatchDrawable));
    return ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
  }
  
  public NativeImageInfo getNativeAppImage(String paramString)
  {
    NativeImageInfo localNativeImageInfo = new NativeImageInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localNativeImageInfo;
    }
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localNativeImageInfo.drawableId = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
      localNativeImageInfo.scale = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    }
    for (;;)
    {
      return localNativeImageInfo;
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) {
        localNativeImageInfo.assetsPath = ((String)jdField_b_of_type_JavaUtilHashMap.get(paramString));
      } else if ((paramString.startsWith("https:")) || (paramString.startsWith("http:")) || (paramString.startsWith("HTTPS:")) || (!paramString.startsWith("HTTP:"))) {}
    }
  }
  
  public List<NativeColorInfo> getNativeThemeColors()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      NativeColorInfo localNativeColorInfo = new NativeColorInfo(str);
      localNativeColorInfo.resId = ((Integer)c.get(str));
      localArrayList.add(localNativeColorInfo);
    }
    return localArrayList;
  }
  
  public NinePatchInfo getNinePatchInfo(Drawable paramDrawable)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramDrawable instanceof SkinnableNinePatchDrawable))
    {
      paramDrawable = ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
      localObject1 = localObject2;
      if (paramDrawable != null) {
        localObject1 = Utils.getNinePatchInfoFromChunk(paramDrawable.getNinePatchChunk());
      }
    }
    return localObject1;
  }
  
  public Handler getSubThreadHandler()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String getThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public Handler getUiThreadHandler()
  {
    return this.jdField_b_of_type_AndroidOsHandler;
  }
  
  public boolean isNinePatchDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof SkinnableNinePatchDrawable)) || ((paramDrawable instanceof NinePatchDrawable));
  }
  
  public void loadJniSo()
  {
    System.load(jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxa
 * JD-Core Version:    0.7.0.1
 */