package com.etrump.mixlayout;

import android.graphics.Typeface;
import badq;
import bajo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import f;
import fu;
import fv;
import g;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManager$5
  implements Runnable
{
  public FontManager$5(fv paramfv, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (fv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "asyncLoadFont font " + this.jdField_a_of_type_Int + " has loaded");
      }
    }
    label298:
    label444:
    label481:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = fv.a(this.jdField_a_of_type_Int, this.b);
            if (!new File((String)localObject).exists()) {
              break label602;
            }
            localObject = new fu(this.jdField_a_of_type_Int, (String)localObject);
            ((fu)localObject).b = this.b;
            if (this.b == 0) {
              ((fu)localObject).b = 1;
            }
            switch (this.b)
            {
            default: 
              return;
            case 1: 
              if (!ETEngine.getInstance().isEngineInited.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("VasFont", 2, "doGetUserFont and fontEngine not init");
                }
                this.this$0.d();
              }
              if (!ETEngine.getInstance().isEngineReady.get()) {
                break label481;
              }
              if (this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {
                break label298;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          return;
          try
          {
            ((fu)localObject).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((fu)localObject).jdField_a_of_type_JavaLangString);
            fv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
            bajo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            fv.a(this.this$0);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + localException.getMessage());
            ((fu)localObject).jdField_a_of_type_AndroidGraphicsTypeface = null;
            return;
          }
          if ((this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.jdField_a_of_type_Int)) && (this.this$0.b.native_isFontLoaded(this.jdField_a_of_type_Int))) {
            break label444;
          }
          if (this.this$0.a((fu)localObject, this.jdField_a_of_type_JavaLangString, this.c)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
        return;
        ETFont localETFont = new ETFont(((fu)localObject).jdField_a_of_type_Int, ((fu)localObject).jdField_a_of_type_JavaLangString, 1.0F);
        ((fu)localObject).c = this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getVariantStyleComboCount(localETFont);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "asyncLoadFont: id=" + ((fu)localObject).jdField_a_of_type_Int + " styleCount=" + ((fu)localObject).c);
        }
        fv.c = true;
        fv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
        bajo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        fv.a(this.this$0);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
      return;
      g.a().a(this.jdField_a_of_type_Int, ((fu)localObject).jdField_a_of_type_JavaLangString);
      ((fu)localObject).c = f.f(this.jdField_a_of_type_Int);
      ((fu)localObject).b = 4;
      fv.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
      bajo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      fv.a(this.this$0);
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (badq.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) || (badq.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    label602:
    QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
    }
    this.this$0.a(this.jdField_a_of_type_Int, null, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */