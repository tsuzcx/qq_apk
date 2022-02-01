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

public class badf
  extends bade
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bacy jdField_a_of_type_Bacy;
  private String jdField_a_of_type_JavaLangString;
  private Vector<Drawable> jdField_a_of_type_JavaUtilVector = new Vector();
  
  public badf(azxt paramazxt, azrb paramazrb)
  {
    super("VasProfileBackgroundComponent", paramazxt, paramazrb);
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
      if (bhrj.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        bhrj.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2, File paramFile)
  {
    Object localObject = (Boolean)azrc.b.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      localObject = "profilecard:" + paramString1;
      BaseApplicationImpl.sImageCache.remove(localObject);
      azrc.b.remove(Long.valueOf(paramLong));
    }
    localObject = new badh(this, paramLong, paramString2, null).a();
    if (((badh)localObject).a()) {}
    do
    {
      do
      {
        return true;
        paramFile = new badg(this, paramString2, paramFile, ((badh)localObject).a()).a();
      } while (paramFile.a());
      localObject = paramFile.a();
      paramFile = (File)localObject;
      if (localObject != null) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = null;
      paramString1 = bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramString2, paramString1);
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
  
  private boolean a(bacy parambacy)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, String.format("initProfileCardBackground styleId=%s bgId=%s url=%s strZipUrl=%s heroUrl=%s", new Object[] { Long.valueOf(parambacy.a()), Long.valueOf(parambacy.b()), parambacy.a(), parambacy.b(), parambacy.c() }));
    }
    if (!TextUtils.isEmpty(parambacy.a())) {
      try
      {
        Object localObject;
        if ((parambacy.b() == 160L) || (parambacy.b() == 1600L))
        {
          localObject = bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambacy.a());
          if (!TextUtils.isEmpty(parambacy.b())) {
            break label259;
          }
        }
        for (String str = "";; str = azrc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambacy.b()) + ".dynamic")
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
          return a(parambacy.b(), (String)localObject, str, localFile);
          localObject = azrc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambacy.a(), parambacy.b());
          break;
          label259:
          str = azrc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambacy.b()) + "dynamicBottom.jpg";
          if (new File(str).exists()) {
            localObject = str;
          }
        }
        return false;
      }
      catch (Throwable parambacy)
      {
        QLog.e(b(), 1, "initProfileCardBackground fail.", parambacy);
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
      } else if (bhrj.a(localDrawable)) {
        bhrj.a().a(localDrawable);
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
  
  public boolean a(badb parambadb)
  {
    if (parambadb.a() == null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(b());
    }
    while ((parambadb.a().equals(this.jdField_a_of_type_Bacy)) && (b())) {
      return true;
    }
    this.jdField_a_of_type_Bacy = parambadb.a();
    boolean bool = a(this.jdField_a_of_type_Bacy);
    if (QLog.isColorLevel()) {
      QLog.d(b(), 2, "onCardUpdate initConfigResult=" + bool);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (bhrj.b(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        a("card-video");
      }
      for (;;)
      {
        a(true);
        return true;
        if (bhrj.c(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
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
 * Qualified Name:     badf
 * JD-Core Version:    0.7.0.1
 */