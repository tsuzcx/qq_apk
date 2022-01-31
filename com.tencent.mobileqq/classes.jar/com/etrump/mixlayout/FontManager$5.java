package com.etrump.mixlayout;

import android.graphics.Typeface;
import bdee;
import bdkd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import f;
import fw;
import fx;
import g;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FontManager$5
  implements Runnable
{
  public FontManager$5(fx paramfx, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (fx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)) != null) {
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
            localObject = fx.a(this.jdField_a_of_type_Int, this.b);
            if (!new File((String)localObject).exists()) {
              break label602;
            }
            localObject = new fw(this.jdField_a_of_type_Int, (String)localObject);
            ((fw)localObject).b = this.b;
            if (this.b == 0) {
              ((fw)localObject).b = 1;
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
            ((fw)localObject).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((fw)localObject).jdField_a_of_type_JavaLangString);
            fx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
            bdkd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            fx.a(this.this$0);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + localException.getMessage());
            ((fw)localObject).jdField_a_of_type_AndroidGraphicsTypeface = null;
            return;
          }
          if ((this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.jdField_a_of_type_Int)) && (this.this$0.b.native_isFontLoaded(this.jdField_a_of_type_Int))) {
            break label444;
          }
          if (this.this$0.a((fw)localObject, this.jdField_a_of_type_JavaLangString, this.c)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
        return;
        ETFont localETFont = new ETFont(((fw)localObject).jdField_a_of_type_Int, ((fw)localObject).jdField_a_of_type_JavaLangString, 1.0F);
        ((fw)localObject).c = this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getVariantStyleComboCount(localETFont);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "asyncLoadFont: id=" + ((fw)localObject).jdField_a_of_type_Int + " styleCount=" + ((fw)localObject).c);
        }
        fx.c = true;
        fx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
        bdkd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        fx.a(this.this$0);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
      return;
      g.a().a(this.jdField_a_of_type_Int, ((fw)localObject).jdField_a_of_type_JavaLangString);
      ((fw)localObject).c = f.f(this.jdField_a_of_type_Int);
      ((fw)localObject).b = 4;
      fx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
      bdkd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      fx.a(this.this$0);
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (bdee.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) || (bdee.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */