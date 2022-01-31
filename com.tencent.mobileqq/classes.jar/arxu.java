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

public class arxu
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
    jdField_a_of_type_JavaUtilHashMap.put("skinConversationPageBg", Integer.valueOf(2130849463));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBlueNormal", Integer.valueOf(2130849490));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBluePressed", Integer.valueOf(2130849489));
    jdField_a_of_type_JavaUtilHashMap.put("skinAIOBubbleNormal", Integer.valueOf(2130849262));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBg", Integer.valueOf(2130849536));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackNormal", Integer.valueOf(2130849550));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackPressed", Integer.valueOf(2130849554));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageBg", Integer.valueOf(2130849461));
    jdField_a_of_type_JavaUtilHashMap.put("skinFromItemRightArrow", Integer.valueOf(2130849586));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgNormal", Integer.valueOf(2130849752));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgPressed", Integer.valueOf(2130849749));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgNormal", Integer.valueOf(2130849772));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgPressed", Integer.valueOf(2130849770));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgNormal", Integer.valueOf(2130849766));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgPressed", Integer.valueOf(2130849764));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgNormal", Integer.valueOf(2130849757));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgPressed", Integer.valueOf(2130849755));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOff", Integer.valueOf(2130849784));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOn", Integer.valueOf(2130849785));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOff", Integer.valueOf(2130849782));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOn", Integer.valueOf(2130849780));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130849781));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130849783));
    jdField_a_of_type_JavaUtilHashMap.put("skinTipsNew", Integer.valueOf(2130849804));
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
    c.put("skinConversationNickBlack", Integer.valueOf(2131166910));
    c.put("skinConversationMsgGray", Integer.valueOf(2131166981));
    c.put("skinBtnBlueTextColor", Integer.valueOf(2131166934));
    c.put("skinBtnWhiteTextColor", Integer.valueOf(2131166942));
    c.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131166897));
    c.put("skinPageTitleBarTextColor", Integer.valueOf(2131166900));
    c.put("skinFormItemBlack", Integer.valueOf(2131166903));
    c.put("skinFormItemGray", Integer.valueOf(2131166978));
  }
  
  public arxu(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxu
 * JD-Core Version:    0.7.0.1
 */