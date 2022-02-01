package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.Vas.ColorFont.FastColorFontCache;
import com.Vas.ColorFont.FastColorFontHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
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
    Object localObject1 = FontManager.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    if (((ConcurrentHashMap)localObject1).get(((StringBuilder)localObject2).toString()) != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("asyncLoadFont font ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" has loaded");
        QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject1 = FontManagerConstants.getTTFPath(this.jdField_a_of_type_Int, this.b);
    if (new File((String)localObject1).exists())
    {
      localObject1 = new FontInfo(this.jdField_a_of_type_Int, (String)localObject1);
      int i = this.b;
      ((FontInfo)localObject1).b = i;
      if (i == 0) {
        ((FontInfo)localObject1).b = 1;
      }
      i = this.b;
      StringBuilder localStringBuilder;
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return;
          }
          FastColorFontHelper.a().a(this.jdField_a_of_type_Int, ((FontInfo)localObject1).jdField_a_of_type_JavaLangString);
          ((FontInfo)localObject1).c = FastColorFontCache.f(this.jdField_a_of_type_Int);
          ((FontInfo)localObject1).b = 4;
          FontManager.a().put(String.valueOf(this.jdField_a_of_type_Int), localObject1);
          localObject2 = FontManager.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("|");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), localObject1);
          VasUtils.a(FontManager.a(this.this$0));
          FontManager.a(this.this$0);
          return;
        }
        try
        {
          ((FontInfo)localObject1).jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(((FontInfo)localObject1).jdField_a_of_type_JavaLangString);
          FontManager.a().put(String.valueOf(this.jdField_a_of_type_Int), localObject1);
          localObject2 = FontManager.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("|");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), localObject1);
          VasUtils.a(FontManager.a(this.this$0));
          FontManager.a(this.this$0);
          return;
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFontInfo createTypeface error: ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("VasFont", 1, localStringBuilder.toString());
          ((FontInfo)localObject1).jdField_a_of_type_AndroidGraphicsTypeface = null;
          return;
        }
      }
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasFont", 2, "doGetUserFont and fontEngine not init");
        }
        this.this$0.c();
      }
      if (ETEngine.getInstance().isEngineReady.get())
      {
        if (this.this$0.a == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          }
          return;
        }
        if ((!this.this$0.a.native_isFontLoaded(this.jdField_a_of_type_Int)) || (!this.this$0.b.native_isFontLoaded(this.jdField_a_of_type_Int)))
        {
          if (!FontManager.a(this.this$0, (FontInfo)localObject1, this.jdField_a_of_type_JavaLangString, this.c))
          {
            if (QLog.isColorLevel()) {
              QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
            }
            return;
          }
          localObject3 = new ETFont(((FontInfo)localObject1).jdField_a_of_type_Int, ((FontInfo)localObject1).jdField_a_of_type_JavaLangString, 1.0F);
          ((FontInfo)localObject1).c = this.this$0.a.native_getVariantStyleComboCount((ETFont)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("asyncLoadFont: id=");
            ((StringBuilder)localObject3).append(((FontInfo)localObject1).jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(" styleCount=");
            ((StringBuilder)localObject3).append(((FontInfo)localObject1).c);
            QLog.i("VasFont", 2, ((StringBuilder)localObject3).toString());
          }
        }
        FontManagerConstants.sHasChatFont = true;
        FontManager.a().put(String.valueOf(this.jdField_a_of_type_Int), localObject1);
        Object localObject3 = FontManager.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("|");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        ((ConcurrentHashMap)localObject3).put(localStringBuilder.toString(), localObject1);
        VasUtils.a(FontManager.a(this.this$0));
        FontManager.a(this.this$0);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doGetUserFont fontEngine not init mIsFontEngineReady = ");
        ((StringBuilder)localObject1).append(ETEngine.getInstance().isEngineReady.get());
        ((StringBuilder)localObject1).append(" mIsFontEngineInited = ");
        ((StringBuilder)localObject1).append(ETEngine.getInstance().isEngineInited.get());
        QLog.e("VasFont", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if ((!FontManager.a(this.this$0).getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean) && (!NetworkUtil.isWifiConnected(FontManager.a(this.this$0).getApplication())) && (!NetworkUtil.is3Gor4G(FontManager.a(this.this$0).getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
      }
      this.this$0.a(this.jdField_a_of_type_Int, null, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */