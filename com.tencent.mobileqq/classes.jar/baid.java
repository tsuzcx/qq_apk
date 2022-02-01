import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class baid
  extends baic
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bahw jdField_a_of_type_Bahw;
  private String jdField_a_of_type_JavaLangString;
  private Vector<Drawable> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public baid(baei parambaei, azxr paramazxr)
  {
    super("VasProfileBackgroundComponent", parambaei, paramazxr);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "releaseBackground");
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
      }
      if (bicd.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        bicd.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2, File paramFile)
  {
    Object localObject = (Boolean)azxs.b.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      localObject = "profilecard:" + paramString1;
      BaseApplicationImpl.sImageCache.remove(localObject);
      azxs.b.remove(Long.valueOf(paramLong));
    }
    localObject = new baif(this, paramLong, paramString2, null).a();
    if (((baif)localObject).a()) {}
    do
    {
      do
      {
        return true;
        paramFile = new baie(this, paramString2, paramFile, ((baif)localObject).a()).a();
      } while (paramFile.a());
      localObject = paramFile.a();
      paramFile = (File)localObject;
      if (localObject != null) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = null;
      paramString1 = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramString2, paramString1);
      paramFile = paramString1;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break;
      }
      paramFile = paramString1;
      if (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable)) {
        break;
      }
      paramString2 = ((FriendProfileCardBgDrawable)paramString1).a();
      localObject = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
      paramFile = paramString1;
      if (localObject == null) {
        break;
      }
      paramFile = paramString1;
      if (localObject != paramString2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(b(), 2, "initProfileCardBackground newBitmap == currentBitmap");
    return true;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_JavaUtilVector.add(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, String.format("initProfileCardBackground bgDrawable=%s", new Object[] { paramFile }));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramFile;
    return true;
  }
  
  private boolean a(bahw parambahw)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, String.format("initProfileCardBackground styleId=%s bgId=%s url=%s strZipUrl=%s heroUrl=%s", new Object[] { Long.valueOf(parambahw.a()), Long.valueOf(parambahw.b()), parambahw.a(), parambahw.b(), parambahw.c() }));
    }
    if (!TextUtils.isEmpty(parambahw.a())) {
      try
      {
        Object localObject;
        if ((parambahw.b() == 160L) || (parambahw.b() == 1600L))
        {
          localObject = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambahw.a());
          if (!TextUtils.isEmpty(parambahw.b())) {
            break label259;
          }
        }
        for (String str = "";; str = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambahw.b()) + ".dynamic")
        {
          if (QLog.isColorLevel()) {
            QLog.d(b(), 2, String.format("initProfileCardBackground fileName=%s dynamicFileDirectory=%s", new Object[] { localObject, str }));
          }
          File localFile = new File((String)localObject);
          boolean bool1 = localFile.isFile();
          boolean bool2 = localFile.exists();
          if (QLog.isColorLevel()) {
            QLog.d(b(), 2, String.format("initProfileCardBackground isFile=%s exists=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if ((!bool1) || (!bool2)) {
            break label355;
          }
          return a(parambahw.b(), (String)localObject, str, localFile);
          localObject = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambahw.a(), parambahw.b());
          break;
          label259:
          str = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambahw.b()) + "dynamicBottom.jpg";
          if (new File(str).exists()) {
            localObject = str;
          }
        }
        return false;
      }
      catch (Throwable parambahw)
      {
        QLog.e(b(), 1, "initProfileCardBackground fail.", parambahw);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, String.format("clearBGCache size=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      if ((localDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)localDrawable).a();
      } else if (bicd.a(localDrawable)) {
        bicd.a().a(localDrawable);
      }
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramBaseActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("qqvip_bg");
    ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public boolean a(bahz parambahz)
  {
    if (parambahz.a() == null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(b());
    }
    while ((parambahz.a().equals(this.jdField_a_of_type_Bahw)) && (b())) {
      return true;
    }
    this.jdField_a_of_type_Bahw = parambahz.a();
    boolean bool = a(this.jdField_a_of_type_Bahw);
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "onCardUpdate initConfigResult=" + bool);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (bicd.b(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        a("card-video");
      }
      for (;;)
      {
        a(true);
        return true;
        if (bicd.c(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
          a("card-etc");
        } else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable)) {
          if (((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).d) {
            a("card-dynamic");
          } else {
            a("card-static");
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(b());
    a("card-default");
    a(false);
    return true;
  }
  
  public void f()
  {
    super.f();
    i();
    a();
    ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baid
 * JD-Core Version:    0.7.0.1
 */