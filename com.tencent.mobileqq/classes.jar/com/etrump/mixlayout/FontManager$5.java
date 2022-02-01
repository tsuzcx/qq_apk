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
    Object localObject1 = FontManager.j();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(this.b);
    if (((ConcurrentHashMap)localObject1).get(((StringBuilder)localObject2).toString()) != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("asyncLoadFont font ");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(" has loaded");
        QLog.d("VasFont", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    localObject1 = FontManagerConstants.getTTFPath(this.b, this.c);
    if (new File((String)localObject1).exists())
    {
      localObject1 = new FontInfo(this.b, (String)localObject1);
      int i = this.c;
      ((FontInfo)localObject1).c = i;
      if (i == 0) {
        ((FontInfo)localObject1).c = 1;
      }
      i = this.c;
      StringBuilder localStringBuilder;
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return;
          }
          FastColorFontHelper.a().a(this.b, ((FontInfo)localObject1).b);
          ((FontInfo)localObject1).h = FastColorFontCache.f(this.b);
          ((FontInfo)localObject1).c = 4;
          FontManager.j().put(String.valueOf(this.b), localObject1);
          localObject2 = FontManager.j();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append("|");
          localStringBuilder.append(this.b);
          ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), localObject1);
          VasUtils.a(FontManager.a(this.this$0));
          FontManager.b(this.this$0);
          return;
        }
        try
        {
          ((FontInfo)localObject1).d = Typeface.createFromFile(((FontInfo)localObject1).b);
          FontManager.j().put(String.valueOf(this.b), localObject1);
          localObject2 = FontManager.j();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append("|");
          localStringBuilder.append(this.b);
          ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), localObject1);
          VasUtils.a(FontManager.a(this.this$0));
          FontManager.b(this.this$0);
          return;
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFontInfo createTypeface error: ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("VasFont", 1, localStringBuilder.toString());
          ((FontInfo)localObject1).d = null;
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
        if (this.this$0.c == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          }
          return;
        }
        if ((!this.this$0.c.native_isFontLoaded(this.b)) || (!this.this$0.d.native_isFontLoaded(this.b)))
        {
          if (!FontManager.a(this.this$0, (FontInfo)localObject1, this.a, this.d))
          {
            if (QLog.isColorLevel()) {
              QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
            }
            return;
          }
          localObject3 = new ETFont(((FontInfo)localObject1).a, ((FontInfo)localObject1).b, 1.0F);
          ((FontInfo)localObject1).h = this.this$0.c.native_getVariantStyleComboCount((ETFont)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("asyncLoadFont: id=");
            ((StringBuilder)localObject3).append(((FontInfo)localObject1).a);
            ((StringBuilder)localObject3).append(" styleCount=");
            ((StringBuilder)localObject3).append(((FontInfo)localObject1).h);
            QLog.i("VasFont", 2, ((StringBuilder)localObject3).toString());
          }
        }
        FontManagerConstants.sHasChatFont = true;
        FontManager.j().put(String.valueOf(this.b), localObject1);
        Object localObject3 = FontManager.j();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("|");
        localStringBuilder.append(this.b);
        ((ConcurrentHashMap)localObject3).put(localStringBuilder.toString(), localObject1);
        VasUtils.a(FontManager.a(this.this$0));
        FontManager.b(this.this$0);
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
    if ((!FontManager.a(this.this$0).getCurrentAccountUin().equals(this.a)) && (this.e) && (!NetworkUtil.isWifiConnected(FontManager.a(this.this$0).getApplication())) && (!NetworkUtil.is3Gor4G(FontManager.a(this.this$0).getApplication())))
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
      this.this$0.a(this.b, null, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */