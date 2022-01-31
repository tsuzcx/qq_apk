import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qflutter.qflutter_skin_engine.NativeColorInfo;
import com.qflutter.qflutter_skin_engine.NativeImageInfo;
import com.qflutter.qflutter_skin_engine.NinePatchInfo;
import com.qflutter.qflutter_skin_engine.QFlutterSkinEngineNativeInterface;
import com.qflutter.qflutter_skin_engine.QFlutterSkinEngineUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flutter.engine.FlutterSkinEngineNativeImp.1;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqad
  implements QFlutterSkinEngineNativeInterface
{
  public static HashMap<String, Integer> a;
  public static HashMap<String, String> b;
  public static HashMap<String, Integer> c;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<ColorStateList> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skinConversationPageBg", Integer.valueOf(2130848953));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBlueNormal", Integer.valueOf(2130848980));
    jdField_a_of_type_JavaUtilHashMap.put("skinSmallBtnBluePressed", Integer.valueOf(2130848979));
    jdField_a_of_type_JavaUtilHashMap.put("skinAIOBubbleNormal", Integer.valueOf(2130848752));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBg", Integer.valueOf(2130849026));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackNormal", Integer.valueOf(2130849040));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageTitleBarBackPressed", Integer.valueOf(2130849044));
    jdField_a_of_type_JavaUtilHashMap.put("skinPageBg", Integer.valueOf(2130848951));
    jdField_a_of_type_JavaUtilHashMap.put("skinFromItemRightArrow", Integer.valueOf(2130849076));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgNormal", Integer.valueOf(2130849239));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBgPressed", Integer.valueOf(2130849236));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgNormal", Integer.valueOf(2130849259));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemTopBgPressed", Integer.valueOf(2130849257));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgNormal", Integer.valueOf(2130849253));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemMiddleBgPressed", Integer.valueOf(2130849251));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgNormal", Integer.valueOf(2130849244));
    jdField_a_of_type_JavaUtilHashMap.put("skinListItemBottomBgPressed", Integer.valueOf(2130849242));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOff", Integer.valueOf(2130849271));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchBgOn", Integer.valueOf(2130849272));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOff", Integer.valueOf(2130849269));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOn", Integer.valueOf(2130849267));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130849268));
    jdField_a_of_type_JavaUtilHashMap.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130849270));
    jdField_a_of_type_JavaUtilHashMap.put("skinTipsNew", Integer.valueOf(2130849291));
    b = new HashMap();
    c = new HashMap();
    c.put("skinConversationNickBlack", Integer.valueOf(2131166861));
    c.put("skinConversationMsgGray", Integer.valueOf(2131166931));
    c.put("skinBtnBlueTextColor", Integer.valueOf(2131166885));
    c.put("skinBtnWhiteTextColor", Integer.valueOf(2131166893));
    c.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131166848));
    c.put("skinPageTitleBarTextColor", Integer.valueOf(2131166851));
    c.put("skinFormItemBlack", Integer.valueOf(2131166854));
    c.put("skinFormItemGray", Integer.valueOf(2131166929));
  }
  
  public aqad(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlutterSkinEngineNativeImp", 0, "preCacheColors");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      ThreadManagerV2.executeOnSubThread(new FlutterSkinEngineNativeImp.1(this, this.jdField_a_of_type_JavaUtilArrayList, localResources), true);
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
      if (b.containsKey(paramString)) {
        localNativeImageInfo.assetsPath = ((String)b.get(paramString));
      } else if ((paramString.startsWith("https:")) || (paramString.startsWith("http:")) || (paramString.startsWith("HTTPS:")) || (!paramString.startsWith("HTTP:"))) {}
    }
  }
  
  public List<NativeColorInfo> getNativeSkinColors()
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
        localObject1 = QFlutterSkinEngineUtils.getNinePatchInfoFromChunk(paramDrawable.getNinePatchChunk());
      }
    }
    return localObject1;
  }
  
  public Handler getSubThreadHandler()
  {
    return null;
  }
  
  public Handler getUiThreadHandler()
  {
    return null;
  }
  
  public boolean isNinePatchDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof SkinnableNinePatchDrawable)) || ((paramDrawable instanceof NinePatchDrawable));
  }
  
  public void loadJniSo()
  {
    System.load(aqaa.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqad
 * JD-Core Version:    0.7.0.1
 */