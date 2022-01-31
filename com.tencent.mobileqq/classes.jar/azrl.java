import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;

public class azrl
{
  public static final String a;
  protected Handler a;
  protected SparseArray<azru> a;
  public LinearLayout a;
  public RelativeLayout a;
  public ScrollView a;
  protected bbwl a;
  public SpriteGLView a;
  private VasQuickUpdateManager.CallBacker a;
  public boolean a;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bbuv.a(ajsf.aW + ".troop/enter_effects/");
  }
  
  public azrl(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new azrt(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Bbwl = ((bbwi)paramQQAppInterface.getManager(47)).a(1);
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static int a(String paramString)
  {
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramString = paramString.substring("groupeffect_item_".length(), paramString.length() - ".zip".length());
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static Bitmap a(String paramString, azru paramazru)
  {
    Bitmap localBitmap = null;
    if (paramazru.c == 2) {
      paramString = paramString + "/yearsvip/yearsvip_s" + paramazru.b + ".png";
    }
    for (;;)
    {
      try
      {
        localBitmap = bbdr.a(paramString, null);
        return localBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          paramString = bbdr.a(paramString, null);
          return paramString;
        }
        catch (OutOfMemoryError paramString) {}
        paramString = paramString;
        return null;
      }
      if (paramazru.c == 1) {
        paramString = paramString + "/svip/svip_s" + paramazru.b + ".png";
      }
    }
    return null;
  }
  
  private azrj a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    azrw localazrw = (azrw)((QQAppInterface)localObject).getManager(231);
    boolean bool = localazrw.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      azrf localazrf = localazrw.a();
      if (localazrf.a.size() > 0)
      {
        int k = bbkv.a((QQAppInterface)localObject, ((QQAppInterface)localObject).c());
        int i;
        int j;
        if (localazrw.b(this.b))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localazrf.a.size()) {
            break label259;
          }
          localObject = (azrj)localazrf.a.get(j);
          bool = localazrw.a().getBoolean("gray_tips_no_longer_" + ((azrj)localObject).jdField_a_of_type_Int, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + ((azrj)localObject).jdField_a_of_type_Int + " nolongerShow = " + bool);
          }
          if ((!bool) && (((azrj)localObject).a(i, k)))
          {
            return localObject;
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    label259:
    return null;
  }
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + paramInt + File.separator + paramInt + ".zip";
  }
  
  public static String b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons").getAbsolutePath();
    }
    return null;
  }
  
  public static void b()
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
    }
    while (ThemeUtil.getFileNumInFile(new File(str)) != 0) {
      return;
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
  }
  
  public void a()
  {
    if (bbct.e()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    azrw localazrw;
    azru localazru;
    do
    {
      do
      {
        do
        {
          return;
          if (!axmt.b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
        return;
        localazrw = (azrw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(231);
      } while (localazrw == null);
      localazru = localazrw.a(this.b);
    } while ((localazru == null) || (!a(localazru)));
    if (System.currentTimeMillis() - localazru.jdField_a_of_type_Long < 60000L)
    {
      a(localazru);
      return;
    }
    localazrw.b(localazru);
  }
  
  public void a(azru paramazru)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + paramazru + " isAio = " + this.jdField_a_of_type_Boolean);
    }
    Object localObject1;
    String str;
    Object localObject2;
    View localView2;
    View localView3;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str = ((QQAppInterface)localObject1).c();
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramazru.jdField_a_of_type_JavaLangString))) {
        break label434;
      }
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramazru.jdField_a_of_type_Int), "");
      localObject2 = (azrw)((QQAppInterface)localObject1).getManager(231);
      if (localObject2 != null) {
        ((azrw)localObject2).b(paramazru);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      localObject2 = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377714);
      localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377870);
      localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372953);
      if ((localView1 == null) || (localView1.getVisibility() != 0)) {
        break label466;
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = localView1.getBottom();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      }
      if (this.jdField_a_of_type_AndroidWidgetScrollView == null)
      {
        this.jdField_a_of_type_AndroidWidgetScrollView = new azrm(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
        this.jdField_a_of_type_AndroidWidgetScrollView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, bawz.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new azrn(this, str, paramazru));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new TroopEnterEffectController.3(this, paramazru));
      paramazru = (azrw)((QQAppInterface)localObject1).getManager(231);
      localObject1 = a();
      if (localObject1 != null) {
        paramazru.a((azrj)localObject1, this.b);
      }
      azrw.a("Grp_AIO", "action_play", new String[0]);
      return;
      label434:
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramazru.jdField_a_of_type_Int), "");
      break;
      label466:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView3.getBottom();
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = bawz.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(azru paramazru)
  {
    int i = paramazru.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i);
    }
    String str = jdField_a_of_type_JavaLangString + i;
    if (balg.a(new File(str))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    bbdj.a(str);
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).downloadItem(25L, "groupeffect_item_" + i + ".zip", "TroopEnterEffectController");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramazru);
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetScrollView);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_AndroidWidgetScrollView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    azrw localazrw = (azrw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(231);
    if (localazrw != null) {
      localazrw.b(this.b);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azrl
 * JD-Core Version:    0.7.0.1
 */