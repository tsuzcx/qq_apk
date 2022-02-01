import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class anhl
{
  public static long a;
  public static Object a;
  public static int[] a;
  public static boolean b;
  public int a;
  public Drawable a;
  public apbm a;
  public URLDrawable a;
  public String a;
  public WeakReference<DynamicAvatarView> a;
  public boolean a;
  public int b;
  public String b;
  public WeakReference<anhl> b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public boolean e;
  public boolean f;
  public boolean g;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 3, 5, 0, 4, 6, 1 };
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public anhl()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public anhl(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new anhx(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4))
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
      a(paramBoolean4, null);
      return;
    }
  }
  
  public anhl(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 0, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
    a(paramBoolean3, paramDynamicAvatar);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_b_of_type_Boolean = true;
      AbstractVideoImage.pauseAll();
      paramAppInterface = (apbm)paramAppInterface.getManager(180);
      if (paramAppInterface != null)
      {
        paramAppInterface.d();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramAppInterface.a);
      }
      return;
    }
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    int i;
    if (jdField_a_of_type_Long <= 0L)
    {
      i = DeviceInfoUtil.getCpuNumber();
      if (i < 8) {
        break label50;
      }
      jdField_a_of_type_Long = 100L;
    }
    for (;;)
    {
      paramAppInterface = (apbm)paramAppInterface.getManager(180);
      ThreadManager.getSubThreadHandler().postDelayed(paramAppInterface.a, jdField_a_of_type_Long);
      return;
      label50:
      if (i >= 4) {
        jdField_a_of_type_Long = 200L;
      } else if (i >= 3) {
        jdField_a_of_type_Long = 400L;
      } else if (i >= 2) {
        jdField_a_of_type_Long = 800L;
      } else {
        jdField_a_of_type_Long = 1000L;
      }
    }
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    if (!b()) {}
    while (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
  }
  
  public void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DynamicAvatar paramDynamicAvatar, boolean paramBoolean5)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_c_of_type_Boolean = paramBoolean4;
    this.g = paramBoolean2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramInt2 == 200)
    {
      this.jdField_c_of_type_Int = 17;
      if (paramInt1 != 32) {
        break label144;
      }
    }
    label144:
    for (this.jdField_b_of_type_Int = 18;; this.jdField_b_of_type_Int = 17)
    {
      this.jdField_d_of_type_Int = paramInt3;
      this.f = paramBoolean1;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_JavaLangString = apbm.b(paramInt1, paramInt2, paramString, paramInt3);
      if (!paramBoolean5) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      }
      this.jdField_a_of_type_Apbm = ((apbm)paramAppInterface.getManager(180));
      return;
      this.jdField_c_of_type_Int = 18;
      break;
    }
  }
  
  public void a(boolean paramBoolean, DynamicAvatar paramDynamicAvatar)
  {
    this.jdField_a_of_type_Apbm.a(this);
    if ((paramBoolean) && (this.jdField_a_of_type_Apbm.a(this.jdField_e_of_type_Int)))
    {
      paramBoolean = true;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean) {
        break label46;
      }
    }
    label46:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
      } while ((!this.g) && (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (this.jdField_d_of_type_Boolean));
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "getDynamicAvatar uin: " + this.jdField_a_of_type_JavaLangString + " source: " + this.jdField_e_of_type_Int);
      }
      if ((this.g) || (paramDynamicAvatar == null))
      {
        this.jdField_a_of_type_Apbm.b(this);
        return;
      }
      if (paramDynamicAvatar != null)
      {
        this.jdField_b_of_type_JavaLangString = apbm.a(this.jdField_b_of_type_Int, this.jdField_d_of_type_Int, paramDynamicAvatar);
        this.jdField_c_of_type_JavaLangString = apbm.a(this.jdField_b_of_type_Int, 640, paramDynamicAvatar);
        if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = apbm.a(17, this.jdField_d_of_type_Int, paramDynamicAvatar);
          this.jdField_c_of_type_JavaLangString = apbm.a(17, 640, paramDynamicAvatar);
        }
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_e_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "initValue url: " + this.jdField_b_of_type_JavaLangString);
        }
      }
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Apbm.b(this);
  }
  
  public boolean a()
  {
    return a() == this.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public boolean a(URLDrawable paramURLDrawable)
  {
    if (!b()) {
      return false;
    }
    if (this.jdField_b_of_type_JavaLangString.equals(((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url equals currentUrl");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "truly setVideoDrawable");
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    if (!jdField_b_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return false;
    }
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localDynamicAvatarView.jdField_a_of_type_Anhl != this)
    {
      QLog.e("Q.dynamicAvatar", 1, "mDynamicFaceDrawable is changed : " + this + " " + localDynamicAvatarView.jdField_a_of_type_Anhl);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhl
 * JD-Core Version:    0.7.0.1
 */