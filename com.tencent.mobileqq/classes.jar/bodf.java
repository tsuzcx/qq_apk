import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.1;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.2;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.4;

public class bodf
{
  public static void a(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bodi parambodi)
  {
    bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] - BEGIN -");
    if (parambodi != null) {
      parambodi.a(paramAEEditorTextBean, 0);
    }
    if (boaf.a().a(paramAEEditorTextBean.id))
    {
      bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file exists");
      ThreadManager.excute(new AEEditorPagStickerUtil.1(paramAEEditorTextBean, parambodi), 64, null, false);
    }
    for (;;)
    {
      bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
      return;
      bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] pag zip file not exists");
      AEEditorPagStickerInfo localAEEditorPagStickerInfo = boaf.a().a(paramAEEditorTextBean.id);
      if (localAEEditorPagStickerInfo == null)
      {
        if (parambodi != null) {
          parambodi.a(paramAEEditorTextBean, false, "ERROR_PAG_ZIP_INFO_NOT_FOUND");
        }
        bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] invalid sticker info");
        bnrh.a("AEEditorPagStickerUtil", "[preparePagSticker] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.2(AEEditorPagStickerInfo.convert2DownloadBean(localAEEditorPagStickerInfo), paramAEEditorTextBean, parambodi), 128, null, false);
    }
  }
  
  private static void b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bodi parambodi)
  {
    bnrh.a("AEEditorPagStickerUtil", "[downloadPagZip] - BEGIN -");
    boaf.a().a(paramAEEditorDownloadResBean, new bodg(paramAEEditorTextBean, parambodi));
    bnrh.a("AEEditorPagStickerUtil", "[downloadPagZip] - END -");
  }
  
  private static void b(AEEditorTextBean paramAEEditorTextBean, @NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, @Nullable bodi parambodi)
  {
    bnrh.a("AEEditorPagStickerUtil", "[downloadPagFont] - BEGIN -");
    boaf.a().a(paramAEEditorDownloadResBean, new bodh(parambodi, paramAEEditorTextBean));
    bnrh.a("AEEditorPagStickerUtil", "[downloadPagFont] - END -");
  }
  
  private static void d(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bodi parambodi)
  {
    boolean bool = false;
    bnrh.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - BEGIN -");
    Object localObject = boaf.a().d(paramAEEditorTextBean.id);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (parambodi != null) {
        parambodi.a(paramAEEditorTextBean, false, null);
      }
      bnrh.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] invalid config json path");
      bnrh.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
      return;
    }
    localObject = boaf.a().a((String)localObject);
    if (parambodi != null)
    {
      if (localObject != null) {
        bool = true;
      }
      parambodi.a(paramAEEditorTextBean, bool, (AEEditorPagStickerConfig)localObject);
    }
    bnrh.a("AEEditorPagStickerUtil", "[parsePagStickerConfig] - END -");
  }
  
  private static void e(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bodi parambodi)
  {
    bnrh.a("AEEditorPagStickerUtil", "[preparePagFont] - BEGIN -");
    if (parambodi != null) {
      parambodi.a(paramAEEditorTextBean, 66);
    }
    if (!TextUtils.isEmpty(paramAEEditorTextBean.fontId))
    {
      bnrh.a("AEEditorPagStickerUtil", "[preparePagFont] font info configured");
      f(paramAEEditorTextBean, parambodi);
    }
    for (;;)
    {
      bnrh.a("AEEditorPagStickerUtil", "[preparePagFont] - END -");
      return;
      bnrh.a("AEEditorPagStickerUtil", "[preparePagFont] font info not configured");
      if (parambodi != null)
      {
        parambodi.a(paramAEEditorTextBean, 100);
        parambodi.a(paramAEEditorTextBean, true, "SUCCESS_FONT_NOT_CONFIGURED");
      }
    }
  }
  
  private static void f(@NonNull AEEditorTextBean paramAEEditorTextBean, @Nullable bodi parambodi)
  {
    bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - BEGIN -");
    AEEditorDownloadResBean localAEEditorDownloadResBean = boaf.a().a(paramAEEditorTextBean.fontId);
    if (localAEEditorDownloadResBean == null)
    {
      if (parambodi != null) {
        parambodi.a(paramAEEditorTextBean, false, "ERROR_FONT_INFO_NOT_FOUND");
      }
      bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] invalid font info");
      bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
    }
    if (boaf.a().a(localAEEditorDownloadResBean))
    {
      bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file exists");
      if (parambodi != null)
      {
        parambodi.a(paramAEEditorTextBean, 100);
        parambodi.a(paramAEEditorTextBean, true, "SUCCESS_FONT_EXISTED");
      }
    }
    for (;;)
    {
      bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
      return;
      bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] font file not exists");
      if (boaf.a().b(localAEEditorDownloadResBean.getId()))
      {
        if (parambodi != null) {
          parambodi.a(paramAEEditorTextBean, true, "SUCCESS_FONT_LIMIT_EXCEEDED");
        }
        bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] used fonts exceeded limit");
        bnrh.a("AEEditorPagStickerUtil", "[preProcessPagFontInfo] - END -");
        return;
      }
      ThreadManager.excute(new AEEditorPagStickerUtil.4(paramAEEditorTextBean, localAEEditorDownloadResBean, parambodi), 128, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodf
 * JD-Core Version:    0.7.0.1
 */