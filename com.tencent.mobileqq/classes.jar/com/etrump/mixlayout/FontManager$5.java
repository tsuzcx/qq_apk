package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.Vas.ColorFont.FastColorFontCache;
import com.Vas.ColorFont.FastColorFontHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class FontManager$5
  implements Runnable
{
  FontManager$5(FontManager paramFontManager, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString + "|" + this.jdField_a_of_type_Int) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "asyncLoadFont font " + this.jdField_a_of_type_Int + " has loaded");
      }
    }
    label359:
    label505:
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
            localObject = FontManager.a(this.jdField_a_of_type_Int, this.b);
            if (!new File((String)localObject).exists()) {
              break label737;
            }
            localObject = new FontInfo(this.jdField_a_of_type_Int, (String)localObject);
            ((FontInfo)localObject).b = this.b;
            if (this.b == 0) {
              ((FontInfo)localObject).b = 1;
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
                break label579;
              }
              if (this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {
                break label359;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          return;
          try
          {
            ((FontInfo)localObject).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((FontInfo)localObject).jdField_a_of_type_JavaLangString);
            FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Int), localObject);
            FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString + "|" + this.jdField_a_of_type_Int, localObject);
            VasUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            FontManager.a(this.this$0);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + localException.getMessage());
            ((FontInfo)localObject).jdField_a_of_type_AndroidGraphicsTypeface = null;
            return;
          }
          if ((this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(this.jdField_a_of_type_Int)) && (this.this$0.b.native_isFontLoaded(this.jdField_a_of_type_Int))) {
            break label505;
          }
          if (this.this$0.a((FontInfo)localObject, this.jdField_a_of_type_JavaLangString, this.c)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
        return;
        ETFont localETFont = new ETFont(((FontInfo)localObject).jdField_a_of_type_Int, ((FontInfo)localObject).jdField_a_of_type_JavaLangString, 1.0F);
        ((FontInfo)localObject).c = this.this$0.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getVariantStyleComboCount(localETFont);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "asyncLoadFont: id=" + ((FontInfo)localObject).jdField_a_of_type_Int + " styleCount=" + ((FontInfo)localObject).c);
        }
        FontManager.c = true;
        FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Int), localObject);
        FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString + "|" + this.jdField_a_of_type_Int, localObject);
        VasUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        FontManager.a(this.this$0);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
      return;
      FastColorFontHelper.a().a(this.jdField_a_of_type_Int, ((FontInfo)localObject).jdField_a_of_type_JavaLangString);
      ((FontInfo)localObject).c = FastColorFontCache.f(this.jdField_a_of_type_Int);
      ((FontInfo)localObject).b = 4;
      FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Int), localObject);
      FontManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString + "|" + this.jdField_a_of_type_Int, localObject);
      VasUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      FontManager.a(this.this$0);
      return;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (NetworkUtil.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) || (NetworkUtil.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    label579:
    label737:
    QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
    }
    this.this$0.a(this.jdField_a_of_type_Int, null, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */